package com.wushuangtech.videocore;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.Surface;
import com.wushuangtech.api.RtcDeviceManager;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.constants.RtcEngineEvent;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.inter.OnRtcGlobalMessageCallBack;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.ThreadFactoryWithNamePrefix;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.library.video.bean.VideoRemoteRawDataBean;
import com.wushuangtech.utils.MyMathUtils;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.YuvToBitmap;
import com.wushuangtech.videocore.decoder.VideoDecoderHardware;
import com.wushuangtech.videocore.inter.OnVideoDecoderHardwareListener;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VideoDecoder {
    private static final int EFFICIENCY_SOFT_AVC = 1;
    private static final int HARDWARE_RESTART_MAX_NUM = 2;
    public static String PATH = "/mnt/sdcard/GGLog/";
    private static final int SOFT_DECODE_FRAME_NUM = 2;
    public static boolean mEnableDynamicSwitchVideoType = false;
    private static final ExecutorService mSingleExecutorService = Executors.newSingleThreadExecutor(new ThreadFactoryWithNamePrefix("DECODER-CALLBACK"));
    private static final boolean mUseDecodedData = true;
    private String TAG = "VideoDecoder";
    private final String mChannelName;
    private ConcurrentHashMap<String, ConcurrentHashMap<Long, Boolean>> mChannelTakeRemote = new ConcurrentHashMap<>();
    private byte[] mDecodedYuvBuffer = null;
    private boolean mDecoderWorking;
    private final String mDeviceId;
    private final Object mFlagLock = new Object();
    private final String[] mHardwareBlackList = {"MI 8"};
    private int mHardwareRestartNum;
    private int mHeight;
    private boolean mIFrameCome;
    private long mLastDecoderSpentTime;
    private long mLastSoftDecodedFrameNum;
    private long mLastVideoRemoteDecodeStartTimestamp;
    private final Object mLock = new Object();
    private ByteBuffer mRawBuffer;
    private final FastLogCacheBean mRecvDataWatcher;
    private boolean mReportFirstDecoded;
    private boolean mReportFirstDran;
    private RtcGlobalMessageCallBackImpl mRtcGlobalMessageCallBackImpl;
    private boolean mSoftDecoding;
    private boolean mStarted;
    private Surface mSurface;
    private WeakReference<SurfaceTexture> mSurfaceTexture;
    private boolean mSurfaceTextureUpdated;
    private final long mUid;
    private final VideoDecoderHardware mVideoDecoderHardware;
    private long mVideoRemoteDecodeEndTimestamp;
    private long mVideoRemoteDecodeStartTimestamp;
    private int mWidth;
    private long mpdecoder;
    private OnVideoDecoderHardwareListener onVideoDecoderHardwareListener;

    private native void CloseDecoder(long j);

    private native long Initialize(VideoDecoder videoDecoder);

    private void OnFirstFrameDecodedNew() {
    }

    private native int OpenDecoder(long j, String str, boolean z, boolean z2, Surface surface, int i, int i2);

    private native void Uninitialize(long j);

    private native void decodeYuvFrame(long j, byte[] bArr, long j2, int i, String str);

    private native void nativeEnableDirectBufferForRawData(long j, boolean z);

    private native boolean setSurface(long j, Surface surface);

    private native boolean useDecodedData(long j, boolean z);

    public native boolean RenderYuvDecodedFrame(byte[] bArr, int i, int i2, Surface surface);

    public native void nativeEnableDebugMode(long j, boolean z);

    public native void nativeEnableDynamicSwitchDecodeType(long j, boolean z);

    public native long nativeGetDecoderSpentTimeInfo(long j, int i);

    public native void nativeSetByteBuffer(long j, ByteBuffer byteBuffer, int i);

    VideoDecoder(String str, long j, String str2) {
        this.mChannelName = str;
        this.mUid = j;
        this.mDeviceId = str2;
        this.TAG += "<" + str2 + ">";
        long Initialize = Initialize(this);
        if (Initialize != 0) {
            this.mpdecoder = Initialize;
            this.mVideoDecoderHardware = new VideoDecoderHardware(this.TAG);
            FastLogCacheBean fastLogCacheBean = new FastLogCacheBean("onGetH264Frame-" + str2, this.TAG, 4);
            this.mRecvDataWatcher = fastLogCacheBean;
            fastLogCacheBean.mInterval = RtcEngineEvent.AudioEvent.EVENT_AUDIO_START_POINT;
            nativeEnableDebugMode(Initialize, false);
            nativeEnableDirectBufferForRawData(Initialize, GlobalConfig.mRemoteVideoTransByBuffer);
            this.mRtcGlobalMessageCallBackImpl = new RtcGlobalMessageCallBackImpl(this);
            GlobalHolder.getInstance().addRtcGlobalMessageCallBack(this.mRtcGlobalMessageCallBackImpl);
            return;
        }
        throw new RuntimeException("init decoder failed!");
    }

    /* access modifiers changed from: private */
    public void takeRemoteViewSnapshot(String str, long j) {
        ConcurrentHashMap concurrentHashMap = this.mChannelTakeRemote.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap();
        }
        concurrentHashMap.put(Long.valueOf(j), true);
        this.mChannelTakeRemote.put(str, concurrentHashMap);
    }

    private class RtcGlobalMessageCallBackImpl implements OnRtcGlobalMessageCallBack {
        private final WeakReference<VideoDecoder> mOutReference;

        public RtcGlobalMessageCallBackImpl(VideoDecoder videoDecoder) {
            this.mOutReference = new WeakReference<>(videoDecoder);
        }

        public void onGlobalMessage(int i, Object... objArr) {
            if (((VideoDecoder) this.mOutReference.get()) != null && i == 1013) {
                VideoDecoder.this.takeRemoteViewSnapshot(objArr[0], objArr[1].longValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isDecoding() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mStarted;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public int getWidth() {
        return this.mWidth;
    }

    /* access modifiers changed from: package-private */
    public int getHeight() {
        return this.mHeight;
    }

    /* access modifiers changed from: package-private */
    public boolean checkSurfaceEmpty() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mSurface == null;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public void setOnVideoDecoderHardwareListener(OnVideoDecoderHardwareListener onVideoDecoderHardwareListener2) {
        this.onVideoDecoderHardwareListener = onVideoDecoderHardwareListener2;
    }

    /* access modifiers changed from: package-private */
    public void setDecoderType(boolean z) {
        synchronized (this.mLock) {
            boolean z2 = this.mSoftDecoding;
            if (!z) {
                String[] strArr = this.mHardwareBlackList;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (Build.MODEL.equals(strArr[i])) {
                        this.mSoftDecoding = true;
                        break;
                    }
                    i++;
                }
                this.mSoftDecoding = false;
            } else {
                this.mSoftDecoding = true;
            }
            if (z2 != this.mSoftDecoding && this.mDecoderWorking) {
                resetDecoder();
            }
            logI("Setting decoder type, soft? " + this.mSoftDecoding + " | thread id : " + Thread.currentThread().getId());
        }
        if (GlobalHolder.getInstance().getTestCallBack() != null) {
            GlobalHolder.getInstance().getTestCallBack().onVideoDecoderTypeChanged(this.mDeviceId, !this.mSoftDecoding);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0098, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSurfaceTexture(android.graphics.SurfaceTexture r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            boolean r0 = com.wushuangtech.library.GlobalConfig.mVideoRemoteRenderTexture
            if (r0 != 0) goto L_0x0008
            return
        L_0x0008:
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            long r1 = r5.mpdecoder     // Catch:{ all -> 0x009b }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            return
        L_0x0015:
            int r1 = r5.mWidth     // Catch:{ all -> 0x009b }
            if (r1 == 0) goto L_0x0099
            int r1 = r5.mHeight     // Catch:{ all -> 0x009b }
            if (r1 != 0) goto L_0x001e
            goto L_0x0099
        L_0x001e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r1.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r2 = "Setting surface texture... surfaceTexture : "
            r1.append(r2)     // Catch:{ all -> 0x009b }
            r1.append(r6)     // Catch:{ all -> 0x009b }
            java.lang.String r2 = " ｜ size : "
            r1.append(r2)     // Catch:{ all -> 0x009b }
            int r2 = r5.mWidth     // Catch:{ all -> 0x009b }
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r2 = " * "
            r1.append(r2)     // Catch:{ all -> 0x009b }
            int r2 = r5.mHeight     // Catch:{ all -> 0x009b }
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r2 = " | mDecoderWorking : "
            r1.append(r2)     // Catch:{ all -> 0x009b }
            boolean r2 = r5.mDecoderWorking     // Catch:{ all -> 0x009b }
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r2 = " | thread id : "
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x009b }
            long r2 = r2.getId()     // Catch:{ all -> 0x009b }
            r1.append(r2)     // Catch:{ all -> 0x009b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x009b }
            r5.logI(r1)     // Catch:{ all -> 0x009b }
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x009b }
            r1.<init>(r6)     // Catch:{ all -> 0x009b }
            r5.mSurfaceTexture = r1     // Catch:{ all -> 0x009b }
            boolean r6 = r5.mDecoderWorking     // Catch:{ all -> 0x009b }
            if (r6 == 0) goto L_0x0097
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r6.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r1 = "TEXTURE_UPDATE - Texture updated... start wait! "
            r6.append(r1)     // Catch:{ all -> 0x009b }
            java.lang.String r1 = r5.mDeviceId     // Catch:{ all -> 0x009b }
            r6.append(r1)     // Catch:{ all -> 0x009b }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x009b }
            r5.logI(r6)     // Catch:{ all -> 0x009b }
            r6 = 1
            r5.mSurfaceTextureUpdated = r6     // Catch:{ all -> 0x009b }
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()     // Catch:{ all -> 0x009b }
            r2 = 1011(0x3f3, float:1.417E-42)
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x009b }
            r3 = 0
            java.lang.String r4 = r5.mDeviceId     // Catch:{ all -> 0x009b }
            r6[r3] = r4     // Catch:{ all -> 0x009b }
            r1.sendSyncGlobalMessage(r2, r6)     // Catch:{ all -> 0x009b }
            r5.resetDecoder()     // Catch:{ all -> 0x009b }
        L_0x0097:
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            return
        L_0x0099:
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            return
        L_0x009b:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009b }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoder.setSurfaceTexture(android.graphics.SurfaceTexture):void");
    }

    /* access modifiers changed from: package-private */
    public void setVideoSize(int i, int i2) {
        synchronized (this.mLock) {
            logI("Setting decoder size : " + i + " * " + i2 + " | thread id : " + Thread.currentThread().getId());
            this.mWidth = i;
            this.mHeight = i2;
            if (this.mDecoderWorking) {
                resetDecoder();
            }
        }
    }

    public void resetReportFirstDecoded(String str) {
        synchronized (this.mFlagLock) {
            logI("Recv reset first flag... deviceId : " + this.mDeviceId + " | working : " + this.mDecoderWorking + " | coming : " + str + " | old : " + this.mChannelName);
            if (this.mChannelName.equals(str)) {
                this.mReportFirstDecoded = false;
                this.mReportFirstDran = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean start(int r6, int r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            boolean r1 = r5.mDecoderWorking     // Catch:{ all -> 0x0049 }
            r2 = 1
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return r2
        L_0x000a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r1.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "Video decoder start working... thread id : "
            r1.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0049 }
            long r3 = r3.getId()     // Catch:{ all -> 0x0049 }
            r1.append(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = " width:"
            r1.append(r3)     // Catch:{ all -> 0x0049 }
            r1.append(r6)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = " height:"
            r1.append(r3)     // Catch:{ all -> 0x0049 }
            r1.append(r7)     // Catch:{ all -> 0x0049 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0049 }
            r5.logI(r1)     // Catch:{ all -> 0x0049 }
            r5.mDecoderWorking = r2     // Catch:{ all -> 0x0049 }
            if (r6 == 0) goto L_0x0047
            if (r7 != 0) goto L_0x003d
            goto L_0x0047
        L_0x003d:
            r5.mWidth = r6     // Catch:{ all -> 0x0049 }
            r5.mHeight = r7     // Catch:{ all -> 0x0049 }
            boolean r6 = r5.executingStart()     // Catch:{ all -> 0x0049 }
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return r6
        L_0x0047:
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            return r2
        L_0x0049:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0049 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoder.start(int, int):boolean");
    }

    public void stop() {
        synchronized (this.mLock) {
            if (this.mDecoderWorking) {
                this.mDecoderWorking = false;
                if (this.mStarted) {
                    logI("Video decoder stop working... thread id : " + Thread.currentThread().getId());
                    executingStop();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onGetH264Frame(com.wushuangtech.library.video.bean.VideoFrame r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.mLock
            monitor-enter(r0)
            com.wushuangtech.bean.FastLogCacheBean r1 = r12.mRecvDataWatcher     // Catch:{ all -> 0x00d6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d6 }
            r2.<init>()     // Catch:{ all -> 0x00d6 }
            java.lang.String r3 = "channel="
            r2.append(r3)     // Catch:{ all -> 0x00d6 }
            java.lang.String r3 = r12.mChannelName     // Catch:{ all -> 0x00d6 }
            r2.append(r3)     // Catch:{ all -> 0x00d6 }
            java.lang.String r3 = ", soft="
            r2.append(r3)     // Catch:{ all -> 0x00d6 }
            boolean r3 = r12.mSoftDecoding     // Catch:{ all -> 0x00d6 }
            r2.append(r3)     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00d6 }
            r1.mMessage = r2     // Catch:{ all -> 0x00d6 }
            com.wushuangtech.bean.FastLogCacheBean r1 = r12.mRecvDataWatcher     // Catch:{ all -> 0x00d6 }
            com.wushuangtech.utils.OmniLog.fd(r1)     // Catch:{ all -> 0x00d6 }
            long r1 = r12.mpdecoder     // Catch:{ all -> 0x00d6 }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x00d4
            boolean r1 = r12.mStarted     // Catch:{ all -> 0x00d6 }
            if (r1 != 0) goto L_0x0037
            goto L_0x00d4
        L_0x0037:
            int r1 = r13.width     // Catch:{ all -> 0x00d6 }
            int r2 = r12.mWidth     // Catch:{ all -> 0x00d6 }
            if (r1 != r2) goto L_0x0043
            int r1 = r13.height     // Catch:{ all -> 0x00d6 }
            int r2 = r12.mHeight     // Catch:{ all -> 0x00d6 }
            if (r1 == r2) goto L_0x006e
        L_0x0043:
            int r1 = r13.width     // Catch:{ all -> 0x00d6 }
            r12.mWidth = r1     // Catch:{ all -> 0x00d6 }
            int r1 = r13.height     // Catch:{ all -> 0x00d6 }
            r12.mHeight = r1     // Catch:{ all -> 0x00d6 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d6 }
            r1.<init>()     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = "Video size changed... "
            r1.append(r2)     // Catch:{ all -> 0x00d6 }
            int r2 = r12.mWidth     // Catch:{ all -> 0x00d6 }
            r1.append(r2)     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = " | "
            r1.append(r2)     // Catch:{ all -> 0x00d6 }
            int r2 = r12.mHeight     // Catch:{ all -> 0x00d6 }
            r1.append(r2)     // Catch:{ all -> 0x00d6 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d6 }
            r12.logI(r1)     // Catch:{ all -> 0x00d6 }
            r12.resetDecoder()     // Catch:{ all -> 0x00d6 }
        L_0x006e:
            boolean r1 = com.wushuangtech.library.GlobalConfig.mVideoRemoteRenderTexture     // Catch:{ all -> 0x00d6 }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0083
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()     // Catch:{ all -> 0x00d6 }
            r4 = 1005(0x3ed, float:1.408E-42)
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ all -> 0x00d6 }
            java.lang.String r6 = r12.mDeviceId     // Catch:{ all -> 0x00d6 }
            r5[r2] = r6     // Catch:{ all -> 0x00d6 }
            r1.sendSyncGlobalMessage(r4, r5)     // Catch:{ all -> 0x00d6 }
        L_0x0083:
            r12.updateVideoRemoteDecodeStart()     // Catch:{ all -> 0x00d6 }
            boolean r1 = r12.mSoftDecoding     // Catch:{ all -> 0x00d6 }
            if (r1 == 0) goto L_0x0099
            long r5 = r12.mpdecoder     // Catch:{ all -> 0x00d6 }
            byte[] r7 = r13.data     // Catch:{ all -> 0x00d6 }
            long r8 = r13.timeStamp     // Catch:{ all -> 0x00d6 }
            int r10 = r13.recvFrameRate     // Catch:{ all -> 0x00d6 }
            java.lang.String r11 = r12.mDeviceId     // Catch:{ all -> 0x00d6 }
            r4 = r12
            r4.decodeYuvFrame(r5, r7, r8, r10, r11)     // Catch:{ all -> 0x00d6 }
            goto L_0x00d2
        L_0x0099:
            boolean r1 = r12.mIFrameCome     // Catch:{ all -> 0x00d6 }
            if (r1 != 0) goto L_0x00ac
            com.wushuangtech.api.ExternalVideoModuleCallback$VideoFrameType r1 = r13.frameType     // Catch:{ all -> 0x00d6 }
            com.wushuangtech.api.ExternalVideoModuleCallback$VideoFrameType r4 = com.wushuangtech.api.ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_SPS_PPS     // Catch:{ all -> 0x00d6 }
            if (r1 == r4) goto L_0x00aa
            java.lang.String r13 = "recv data, but need drop it"
            r12.logD(r13)     // Catch:{ all -> 0x00d6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00d6 }
            return
        L_0x00aa:
            r12.mIFrameCome = r3     // Catch:{ all -> 0x00d6 }
        L_0x00ac:
            com.wushuangtech.videocore.decoder.VideoDecoderHardware r1 = r12.mVideoDecoderHardware     // Catch:{ all -> 0x00d6 }
            boolean r13 = r1.decodingFrame(r13, r12)     // Catch:{ all -> 0x00d6 }
            if (r13 != 0) goto L_0x00d2
            int r13 = r12.mHardwareRestartNum     // Catch:{ all -> 0x00d6 }
            r1 = 2
            if (r13 >= r1) goto L_0x00c7
            java.lang.String r13 = "Hardware decode exception, restart!"
            r12.logI(r13)     // Catch:{ all -> 0x00d6 }
            int r13 = r12.mHardwareRestartNum     // Catch:{ all -> 0x00d6 }
            int r13 = r13 + r3
            r12.mHardwareRestartNum = r13     // Catch:{ all -> 0x00d6 }
            r12.resetDecoder()     // Catch:{ all -> 0x00d6 }
            goto L_0x00cd
        L_0x00c7:
            java.lang.String r13 = "Hardware decode error, change to soft!"
            r12.logI(r13)     // Catch:{ all -> 0x00d6 }
            r2 = r3
        L_0x00cd:
            if (r2 == 0) goto L_0x00d2
            r12.setDecoderType(r3)     // Catch:{ all -> 0x00d6 }
        L_0x00d2:
            monitor-exit(r0)     // Catch:{ all -> 0x00d6 }
            return
        L_0x00d4:
            monitor-exit(r0)     // Catch:{ all -> 0x00d6 }
            return
        L_0x00d6:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d6 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoder.onGetH264Frame(com.wushuangtech.library.video.bean.VideoFrame):void");
    }

    /* access modifiers changed from: package-private */
    public void uninitialize() {
        synchronized (this.mLock) {
            executingStop();
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            Uninitialize(this.mpdecoder);
            this.mpdecoder = 0;
            logI("Uninitialize video decoder over... thread id : " + Thread.currentThread().getId());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r7 == 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r9 = r11.mLastSoftDecodedFrameNum;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r9 != 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        r0 = (int) (r1 - r7);
        r3 = (int) (r5 - r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r3 != 0) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        r0 = java.lang.Math.max(r0 / r3, 0);
        r3 = com.wushuangtech.library.GlobalHolder.getInstance().getGlobalVideoConfig();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r3 == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        r3.setVideoDecodedElapsed(r11.mChannelName, r11.mUid, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
        r11.mLastDecoderSpentTime = r1;
        r11.mLastSoftDecodedFrameNum = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        r11.mLastDecoderSpentTime = r1;
        r11.mLastSoftDecodedFrameNum = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r7 = r11.mLastDecoderSpentTime;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateDecoderSpentTime() {
        /*
            r11 = this;
            java.lang.Object r0 = r11.mLock
            monitor-enter(r0)
            long r1 = r11.mpdecoder     // Catch:{ all -> 0x0051 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x000d:
            r5 = 1
            long r1 = r11.nativeGetDecoderSpentTimeInfo(r1, r5)     // Catch:{ all -> 0x0051 }
            long r5 = r11.mpdecoder     // Catch:{ all -> 0x0051 }
            r7 = 2
            long r5 = r11.nativeGetDecoderSpentTimeInfo(r5, r7)     // Catch:{ all -> 0x0051 }
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            long r7 = r11.mLastDecoderSpentTime
            int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x004c
            long r9 = r11.mLastSoftDecodedFrameNum
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0027
            goto L_0x004c
        L_0x0027:
            long r3 = r1 - r7
            int r0 = (int) r3
            long r3 = r5 - r9
            int r3 = (int) r3
            if (r3 != 0) goto L_0x0030
            return
        L_0x0030:
            int r0 = r0 / r3
            r3 = 0
            int r0 = java.lang.Math.max(r0, r3)
            com.wushuangtech.library.GlobalHolder r3 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.library.GlobalVideoConfig r3 = r3.getGlobalVideoConfig()
            if (r3 == 0) goto L_0x0047
            java.lang.String r4 = r11.mChannelName
            long r7 = r11.mUid
            r3.setVideoDecodedElapsed(r4, r7, r0)
        L_0x0047:
            r11.mLastDecoderSpentTime = r1
            r11.mLastSoftDecodedFrameNum = r5
            return
        L_0x004c:
            r11.mLastDecoderSpentTime = r1
            r11.mLastSoftDecodedFrameNum = r5
            return
        L_0x0051:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoder.updateDecoderSpentTime():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        if (r2.mSurface == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        tryReportVideoFirstDran();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void renderYuvDecodedFrame(byte[] r3, int r4, int r5) {
        /*
            r2 = this;
            boolean r0 = com.wushuangtech.library.GlobalConfig.mVideoRemoteRenderTexture
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            if (r3 != 0) goto L_0x0008
            return
        L_0x0008:
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            android.view.Surface r1 = r2.mSurface     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            return
        L_0x0011:
            boolean r3 = r2.RenderYuvDecodedFrame(r3, r4, r5, r1)     // Catch:{ all -> 0x0028 }
            if (r3 != 0) goto L_0x001f
            java.lang.String r3 = r2.TAG     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = "HW render yuv frame failed..."
            r5 = 0
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r3, (java.lang.String) r4, (boolean) r5)     // Catch:{ all -> 0x0028 }
        L_0x001f:
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            android.view.Surface r3 = r2.mSurface
            if (r3 == 0) goto L_0x0027
            r2.tryReportVideoFirstDran()
        L_0x0027:
            return
        L_0x0028:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0028 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoder.renderYuvDecodedFrame(byte[], int, int):void");
    }

    private Bitmap getBitmap(VideoRemoteRawDataBean videoRemoteRawDataBean) {
        try {
            int i = videoRemoteRawDataBean.mLineSizeY * videoRemoteRawDataBean.mHeight;
            int i2 = i / 4;
            byte[] bArr = new byte[i];
            byte[] bArr2 = new byte[i2];
            byte[] bArr3 = new byte[i2];
            if (videoRemoteRawDataBean.mBuffer != null) {
                System.arraycopy(videoRemoteRawDataBean.mBuffer.array(), videoRemoteRawDataBean.mBuffer.arrayOffset(), bArr, 0, i);
                System.arraycopy(videoRemoteRawDataBean.mBuffer.array(), videoRemoteRawDataBean.mBuffer.arrayOffset() + i, bArr2, 0, i2);
                System.arraycopy(videoRemoteRawDataBean.mBuffer.array(), i + i2 + videoRemoteRawDataBean.mBuffer.arrayOffset(), bArr3, 0, i2);
            } else if (videoRemoteRawDataBean.mData == null) {
                return null;
            } else {
                System.arraycopy(videoRemoteRawDataBean.mData, 0, bArr, 0, i);
                System.arraycopy(videoRemoteRawDataBean.mData, i, bArr2, 0, i2);
                System.arraycopy(videoRemoteRawDataBean.mData, i + i2, bArr3, 0, i2);
            }
            return YuvToBitmap.Yuv420ToBitmap(new YuvToBitmap.VideoFrame(videoRemoteRawDataBean.mWidth, videoRemoteRawDataBean.mHeight, bArr, bArr2, bArr3, videoRemoteRawDataBean.mLineSizeY, videoRemoteRawDataBean.mLineSizeU, videoRemoteRawDataBean.mLineSizeV));
        } catch (Exception unused) {
            String str = this.TAG;
            OmniLog.e(str, "getBitmap uid:" + this.mUid);
            return null;
        }
    }

    private void reportTakeShot(VideoRemoteRawDataBean videoRemoteRawDataBean) {
        Bitmap bitmap;
        ConcurrentHashMap concurrentHashMap = this.mChannelTakeRemote.get(this.mChannelName);
        if (concurrentHashMap != null && ((Boolean) concurrentHashMap.get(Long.valueOf(this.mUid))).booleanValue() && (bitmap = getBitmap(videoRemoteRawDataBean)) != null) {
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.VIDEO_REMOTE_TAKE_SNAPSHOT, this.mChannelName, Long.valueOf(this.mUid), bitmap);
            concurrentHashMap.put(Long.valueOf(this.mUid), false);
        }
    }

    public void reportYuvDecodedFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, boolean z, long j) {
        VideoRemoteRawDataBean videoRemoteRawDataBean;
        byte[] bArr2 = bArr;
        if (GlobalConfig.mRemoteVideoTransByBuffer && this.mSoftDecoding) {
            ByteBuffer byteBuffer = this.mRawBuffer;
            byte[] array = byteBuffer != null ? byteBuffer.array() : null;
            videoRemoteRawDataBean = new VideoRemoteRawDataBean(this.mDeviceId, this.mRawBuffer, i, i2, i3, i4, i5, z, j);
            bArr2 = array;
        } else if (bArr2 != null && bArr2.length > 0) {
            videoRemoteRawDataBean = new VideoRemoteRawDataBean(this.mDeviceId, bArr, i, i2, i3, i4, i5, z, j);
        } else {
            return;
        }
        if (!GlobalConfig.mVideoRemoteRenderTexture) {
            GlobalHolder.getInstance().sendSyncGlobalMessage(1005, videoRemoteRawDataBean);
        }
        if (bArr2 != null) {
            int i6 = ((i3 * i2) * 3) / 2;
            byte[] bArr3 = this.mDecodedYuvBuffer;
            if (bArr3 == null || bArr3.length != i6) {
                this.mDecodedYuvBuffer = new byte[i6];
            }
            Object obj = this.mDecodedYuvBuffer;
            if (obj != null) {
                System.arraycopy(this.mRawBuffer.array(), this.mRawBuffer.arrayOffset(), obj, 0, i6);
                GlobalHolder.getInstance().sendRtcEngineEvent(96, this.mChannelName, Long.valueOf(this.mUid), obj, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j));
            }
            reportTakeShot(videoRemoteRawDataBean);
        }
    }

    public void onVideoFrameDecoded() {
        if (this.mSurfaceTextureUpdated) {
            this.mSurfaceTextureUpdated = false;
            logI("TEXTURE_UPDATE - Start decoding, notify stop wiat... " + this.mDeviceId);
            GlobalHolder.getInstance().sendSyncGlobalMessage(1012, this.mDeviceId);
        }
        VideoStatistical globalVideoStatistical = GlobalHolder.getInstance().getGlobalVideoStatistical();
        if (globalVideoStatistical != null) {
            globalVideoStatistical.updateVideoRemoteDecodeCount(this.mUid);
        }
        tryReportVideoFirstDecoded();
    }

    public void receiveVideoRenderFinish() {
        tryReportVideoFirstDran();
    }

    private void tryReportVideoFirstDecoded() {
        boolean z;
        if (!this.mReportFirstDecoded) {
            synchronized (this.mFlagLock) {
                z = !this.mReportFirstDecoded;
            }
            if (z && reportVideoFirstFrameEvent(true)) {
                synchronized (this.mFlagLock) {
                    this.mReportFirstDecoded = true;
                }
            }
        }
    }

    private void tryReportVideoFirstDran() {
        boolean z;
        if (!this.mReportFirstDran) {
            synchronized (this.mFlagLock) {
                z = !this.mReportFirstDran;
            }
            if (z && reportVideoFirstFrameEvent(false)) {
                synchronized (this.mFlagLock) {
                    this.mReportFirstDran = true;
                }
            }
        }
    }

    private boolean executingStart() {
        boolean z;
        WeakReference<SurfaceTexture> weakReference;
        if (this.mStarted) {
            return true;
        }
        this.mStarted = true;
        logI("Starting decoder, soft type? " + this.mSoftDecoding + " | suface : " + this.mSurface + " | " + this.mWidth + " | " + this.mHeight);
        if (GlobalConfig.mVideoRemoteRenderTexture && (weakReference = this.mSurfaceTexture) != null) {
            SurfaceTexture surfaceTexture = (SurfaceTexture) weakReference.get();
            if (surfaceTexture == null) {
                logE("SurfaceTexture is null... old : " + this.mSurface);
                return false;
            }
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
            }
            this.mSurface = new Surface(surfaceTexture);
        }
        if (GlobalConfig.mRemoteVideoTransByBuffer) {
            int alignIntMultipleOf32 = MyMathUtils.alignIntMultipleOf32(this.mWidth);
            int alignIntMultipleOf322 = MyMathUtils.alignIntMultipleOf32(this.mHeight);
            int i = ((alignIntMultipleOf32 * alignIntMultipleOf322) * 3) / 2;
            int i2 = -1;
            ByteBuffer byteBuffer = this.mRawBuffer;
            if (byteBuffer != null) {
                i2 = byteBuffer.capacity();
            }
            if (i > i2) {
                logI("Video size changed! reallocate bytebuffer, current capacity = " + i2 + ", des capacity = " + i + ", src size = " + this.mWidth + " * " + this.mHeight + ", des size = " + alignIntMultipleOf32 + " *" + alignIntMultipleOf322);
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
                this.mRawBuffer = allocateDirect;
                nativeSetByteBuffer(this.mpdecoder, allocateDirect, i);
            }
        }
        if (this.mSoftDecoding) {
            z = openSoftwareDecoder(this.mSurface, this.mWidth, this.mHeight);
        } else {
            z = this.mVideoDecoderHardware.openHardwareDecoder(this.mSurface, this.mWidth, this.mHeight);
        }
        if (!z) {
            logE("Start decoder failed!");
            executingStop();
            mSingleExecutorService.submit(new LocalVideoDecoderTypeRunnable(this, true));
            return false;
        }
        if (this.onVideoDecoderHardwareListener != null && !this.mSoftDecoding) {
            this.onVideoDecoderHardwareListener.hardwareDecoderCreated(this.mVideoDecoderHardware.buildHardwareDecoderInfo(this.mDeviceId));
        }
        logI("Start video decoder over... thread id : " + Thread.currentThread().getId());
        return true;
    }

    private boolean executingStop() {
        if (!this.mStarted) {
            return false;
        }
        CloseDecoder(this.mpdecoder);
        VideoDecoderHardware videoDecoderHardware = this.mVideoDecoderHardware;
        if (videoDecoderHardware != null) {
            if (this.onVideoDecoderHardwareListener != null) {
                this.onVideoDecoderHardwareListener.hardwareDecoderDestory(videoDecoderHardware.buildHardwareDecoderInfo(this.mDeviceId));
            }
            this.mVideoDecoderHardware.closeHardwareDecoder();
        }
        this.mRawBuffer = null;
        this.mDecodedYuvBuffer = null;
        this.mStarted = false;
        logI("Stop video decoder over... | thread id : " + Thread.currentThread().getId());
        return true;
    }

    private void resetDecoder() {
        executingStop();
        executingStart();
    }

    private boolean openSoftwareDecoder(Surface surface, int i, int i2) {
        if (!useDecodedData(this.mpdecoder, true)) {
            logE("Setting native decoder faield!");
            return false;
        }
        logI("open native decoder! " + surface + " | dynamic switch=" + mEnableDynamicSwitchVideoType);
        nativeEnableDynamicSwitchDecodeType(this.mpdecoder, mEnableDynamicSwitchVideoType);
        int OpenDecoder = OpenDecoder(this.mpdecoder, this.mDeviceId, true, false, surface, i, i2);
        if (OpenDecoder == 0) {
            return true;
        }
        logE("Open native decoder failed! " + OpenDecoder);
        return false;
    }

    public void updateVideoRemoteDecodeStart() {
        long currentTimeMillis = System.currentTimeMillis();
        this.mVideoRemoteDecodeStartTimestamp = currentTimeMillis;
        long j = this.mLastVideoRemoteDecodeStartTimestamp;
        int i = (int) (currentTimeMillis - j);
        if ((j == 0 || i < 500) && this.mVideoRemoteDecodeEndTimestamp != 0) {
            checkVideoRemoteDecodeCaton();
        }
        this.mLastVideoRemoteDecodeStartTimestamp = this.mVideoRemoteDecodeStartTimestamp;
    }

    public void updateVideoRemoteDecodeEnd() {
        if (this.mVideoRemoteDecodeStartTimestamp != 0) {
            this.mVideoRemoteDecodeEndTimestamp = System.currentTimeMillis();
            checkVideoRemoteDecodeCaton();
        }
    }

    private void checkVideoRemoteDecodeCaton() {
        int abs = (int) Math.abs(this.mVideoRemoteDecodeEndTimestamp - this.mVideoRemoteDecodeStartTimestamp);
        if (abs > 500) {
            GlobalHolder.getInstance().handleRtcEventReport(this.mChannelName, LogEvent.VIDEO_LOCAL_UPSTREAM_STUCK, this.mDeviceId, 3, Integer.valueOf(abs));
        }
    }

    private void OnFrameDecoded(byte[] bArr, int i, int i2, int i3, int i4, int i5, boolean z, long j) {
        updateVideoRemoteDecodeEnd();
        if (this.mSurfaceTextureUpdated) {
            this.mSurfaceTextureUpdated = false;
            logI("TEXTURE_UPDATE - Start decoding, notify stop wait...");
            GlobalHolder.getInstance().sendSyncGlobalMessage(1012, this.mDeviceId);
        }
        VideoStatistical globalVideoStatistical = GlobalHolder.getInstance().getGlobalVideoStatistical();
        if (globalVideoStatistical != null) {
            globalVideoStatistical.updateVideoRemoteDecodeCount(this.mUid);
        }
        tryReportVideoFirstDecoded();
        if (GlobalConfig.mVideoRemoteRenderTexture && this.mSurface != null) {
            tryReportVideoFirstDran();
        } else if (!GlobalConfig.mVideoRemoteRenderTexture) {
            tryReportVideoFirstDran();
        }
        reportYuvDecodedFrame(bArr, i, i2, i3, i4, i5, z, j);
    }

    private void OnFirstFrameDecoded(int i, int i2) {
        logI("Recv first frame decoded... " + this.mReportFirstDecoded);
    }

    private void OnFirstFrameDrawed(int i, int i2) {
        logI("Recv first frame draw... " + this.mReportFirstDran);
    }

    private void OnFrameSizeChanged(int i, int i2) {
        logI("Recv frame size changed... " + i + " | " + i2);
    }

    private void OnSoftDecoderClosed() {
        mSingleExecutorService.submit(new LocalVideoDecoderTypeRunnable(this, false));
        logI("Change to hardware decoding!");
    }

    private boolean reportVideoFirstFrameEvent(boolean z) {
        int i;
        String str = this.mChannelName;
        String str2 = this.mDeviceId;
        OmniLog.i(this.TAG, "channelName:" + str + " deviceId:" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            logE("Report first frame event" + ", Channel name is empty! " + str + " | " + this.mDeviceId);
            return false;
        }
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(str);
        if (deviceManager == null) {
            logE("Report first frame event" + ", RtcDeviceManager is null! " + str + " | " + this.mDeviceId);
            return false;
        }
        if (str2.equals(Long.toString(this.mUid))) {
            UserDeviceConfig videoDeviceForDefault = deviceManager.getVideoDeviceForDefault(this.mUid);
            if (videoDeviceForDefault == null) {
                logE("Report first frame event" + ", DefaultVideoDevice is null! " + str + " | " + this.mUid);
                return false;
            }
            str2 = videoDeviceForDefault.getDeviceId();
        }
        if (deviceManager.getUserByDeviceId(str2) <= 0) {
            logE("Report first frame event" + ", uid is zero!");
        }
        UserDeviceConfig videoDeviceByDeviceId = deviceManager.getVideoDeviceByDeviceId(str2);
        if (videoDeviceByDeviceId == null) {
            logE("Report first frame event" + ", UserDeviceConfig is null! " + str + " | " + this.mDeviceId);
        }
        if (videoDeviceByDeviceId != null) {
            i = (int) (System.currentTimeMillis() - videoDeviceByDeviceId.getDeviceOpenTimestamp());
        } else {
            i = 0;
        }
        RtcGlobalServerMessage rtcGlobalServerMessage = RtcGlobalServerMessage.VIDEO_REMOTE_FIRST_FRAME_DECODED;
        if (!z) {
            rtcGlobalServerMessage = RtcGlobalServerMessage.VIDEO_REMOTE_FIRST_FRAME_DRAN;
        }
        OmniLog.i(this.TAG, "message:" + rtcGlobalServerMessage + " channelName:" + str + " mUid:" + this.mUid + " deviceId:" + str2 + " mWidth:" + this.mWidth + " mHeight:" + this.mHeight + " elapsed:" + i);
        GlobalHolder.getInstance().sendSyncGlobalServerMessage(rtcGlobalServerMessage, str, Long.valueOf(this.mUid), str2, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(i));
        return true;
    }

    private void logI(String str) {
        OmniLog.i("RVW", this.TAG, str);
    }

    private void logD(String str) {
        OmniLog.d("RVW", this.TAG, str);
    }

    private void logE(String str) {
        OmniLog.e("RVW", this.TAG, str);
    }

    private static class LocalVideoDecoderTypeRunnable implements Runnable {
        private final WeakReference<VideoDecoder> mOutReference;
        private final boolean mSoftDecoding;

        public LocalVideoDecoderTypeRunnable(VideoDecoder videoDecoder, boolean z) {
            this.mOutReference = new WeakReference<>(videoDecoder);
            this.mSoftDecoding = z;
        }

        public void run() {
            Process.setThreadPriority(10);
            VideoDecoder videoDecoder = (VideoDecoder) this.mOutReference.get();
            if (videoDecoder != null) {
                videoDecoder.setDecoderType(this.mSoftDecoding);
            }
        }
    }

    public static void writeFile(String str, byte[] bArr, boolean z) {
        try {
            File file = new File(PATH + str);
            if (!z && file.exists()) {
                file.delete();
            }
            if (!file.exists()) {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
