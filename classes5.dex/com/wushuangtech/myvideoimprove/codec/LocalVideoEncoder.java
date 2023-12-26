package com.wushuangtech.myvideoimprove.codec;

import android.os.Build;
import android.os.Process;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.video.bean.VideoFrame;
import com.wushuangtech.myvideoimprove.codec.BaseCodecImpl;
import com.wushuangtech.myvideoimprove.codec.encoder.BaseEncoderImpl;
import com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LocalVideoEncoder {
    public String TAG = "LVE";
    private volatile boolean mDestroyed;
    private ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> mEncoderMP;
    private final String mLogWatcher;

    public interface OnLocalVideoEncoderCallBack {
        void onEncodedDataReport(boolean z, byte[] bArr, int i, int i2, int i3, long j);

        void onEncoderStartFailed();

        void onEncoderStartSuccess();

        void onEncoderTypeChanged(boolean z);
    }

    public enum VideoEncoderType {
        MAIN,
        DUAL
    }

    public LocalVideoEncoder(String str) {
        this.TAG += "<" + str + ">";
        this.mLogWatcher = "LPW][VEW";
        this.mEncoderMP = new ConcurrentHashMap<>();
    }

    public void init(VideoEncoderType[] videoEncoderTypeArr) {
        int length = videoEncoderTypeArr.length;
        int i = 0;
        while (i < length) {
            VideoEncoderType videoEncoderType = videoEncoderTypeArr[i];
            if (this.mEncoderMP.get(videoEncoderType) == null) {
                this.mEncoderMP.put(videoEncoderType, new VideoEncoderHolder(videoEncoderType, this.mLogWatcher));
                i++;
            } else {
                return;
            }
        }
    }

    public void init(VideoEncoderType videoEncoderType) {
        if (this.mEncoderMP.get(videoEncoderType) == null) {
            this.mEncoderMP.put(videoEncoderType, new VideoEncoderHolder(videoEncoderType, this.mLogWatcher));
        }
    }

    public void setOnHardwareSurfaceLifeListener(HardwareEncoder.OnHardwareSurfaceLifeListener onHardwareSurfaceLifeListener) {
        VideoEncoderHolder videoEncoderHolder;
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap != null) {
            Iterator<Map.Entry<VideoEncoderType, VideoEncoderHolder>> it = encoderMap.entrySet().iterator();
            while (it.hasNext() && (videoEncoderHolder = (VideoEncoderHolder) it.next().getValue()) != null) {
                videoEncoderHolder.setOnHardwareSurfaceLifeListener(onHardwareSurfaceLifeListener);
            }
        }
    }

    public void setOnLocalVideoEncoderTypeChangedListener(OnLocalVideoEncoderCallBack onLocalVideoEncoderCallBack) {
        VideoEncoderHolder videoEncoderHolder;
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap != null) {
            Iterator<Map.Entry<VideoEncoderType, VideoEncoderHolder>> it = encoderMap.entrySet().iterator();
            while (it.hasNext() && (videoEncoderHolder = (VideoEncoderHolder) it.next().getValue()) != null) {
                videoEncoderHolder.setOnLocalVideoEncoderTypeChangedListener(onLocalVideoEncoderCallBack);
            }
        }
    }

    public void setHardwareEncoderSurfaceEnabled(VideoEncoderType videoEncoderType, boolean z) {
        VideoEncoderHolder videoEncoderHolder;
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap != null) {
            Iterator<Map.Entry<VideoEncoderType, VideoEncoderHolder>> it = encoderMap.entrySet().iterator();
            while (it.hasNext() && (videoEncoderHolder = (VideoEncoderHolder) it.next().getValue()) != null) {
                videoEncoderHolder.setHardwareSurfaceEnabled(z);
            }
        }
    }

    public boolean startEncoder(VideoEncoderType videoEncoderType) {
        VideoEncoderHolder videoEncoderHolder;
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap == null || (videoEncoderHolder = encoderMap.get(videoEncoderType)) == null) {
            return false;
        }
        return videoEncoderHolder.createEncoder();
    }

    public boolean stopEncoder(VideoEncoderType videoEncoderType) {
        VideoEncoderHolder videoEncoderHolder;
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap == null || (videoEncoderHolder = encoderMap.get(videoEncoderType)) == null) {
            return false;
        }
        return videoEncoderHolder.destroyEncoder();
    }

    public void setExternalVideoColorFormat(int i) {
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap != null) {
            for (Map.Entry<VideoEncoderType, VideoEncoderHolder> value : encoderMap.entrySet()) {
                VideoEncoderHolder videoEncoderHolder = (VideoEncoderHolder) value.getValue();
                if (videoEncoderHolder != null) {
                    videoEncoderHolder.setExternalVideoColorFormat(i);
                }
            }
        }
    }

    public void setVideoEncoderParams(VideoEncoderType videoEncoderType, int i) {
        VideoEncoderHolder videoEncoderHolder;
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap != null && (videoEncoderHolder = encoderMap.get(videoEncoderType)) != null) {
            videoEncoderHolder.setEncoderParams(i);
        }
    }

    public void setVideoEncoderParams(VideoEncoderType videoEncoderType, int i, int i2, int i3, int i4, int i5) {
        VideoEncoderHolder videoEncoderHolder;
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap != null && (videoEncoderHolder = encoderMap.get(videoEncoderType)) != null) {
            videoEncoderHolder.setEncoderParams(i, i2, i3, i4, i5);
        }
    }

    public void setSoftEncodrType(VideoEncoderType videoEncoderType, boolean z) {
        VideoEncoderHolder videoEncoderHolder;
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap != null && (videoEncoderHolder = encoderMap.get(videoEncoderType)) != null) {
            videoEncoderHolder.setSoftEncoderType(z);
        }
    }

    public void setVideoBitrateMode(VideoEncoderType videoEncoderType, int i) {
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap != null) {
            if (videoEncoderType == null) {
                for (Map.Entry<VideoEncoderType, VideoEncoderHolder> value : encoderMap.entrySet()) {
                    ((VideoEncoderHolder) value.getValue()).setVideoBitrateMode(i);
                }
                return;
            }
            VideoEncoderHolder videoEncoderHolder = encoderMap.get(videoEncoderType);
            if (videoEncoderHolder != null) {
                videoEncoderHolder.setVideoBitrateMode(i);
            }
        }
    }

    public void requestKeyFrame(VideoEncoderType videoEncoderType) {
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap != null) {
            if (videoEncoderType == null) {
                for (Map.Entry<VideoEncoderType, VideoEncoderHolder> value : encoderMap.entrySet()) {
                    ((VideoEncoderHolder) value.getValue()).requestKeyFrame();
                }
                return;
            }
            VideoEncoderHolder videoEncoderHolder = encoderMap.get(videoEncoderType);
            if (videoEncoderHolder != null) {
                videoEncoderHolder.requestKeyFrame();
            }
        }
    }

    public void clearResource() {
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap = getEncoderMap();
        if (encoderMap != null) {
            this.mEncoderMP = null;
            this.mDestroyed = true;
            OmniLog.i(this.mLogWatcher, this.TAG, "clearResource invoked!");
            for (Map.Entry<VideoEncoderType, VideoEncoderHolder> value : encoderMap.entrySet()) {
                ((VideoEncoderHolder) value.getValue()).clearResource();
            }
            encoderMap.clear();
        }
    }

    public void receiveVideoData(VideoEncoderType videoEncoderType, VideoFrame videoFrame) {
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap;
        VideoEncoderHolder videoEncoderHolder;
        if (videoFrame != null && videoFrame.data != null && (encoderMap = getEncoderMap()) != null && (videoEncoderHolder = encoderMap.get(videoEncoderType)) != null) {
            videoEncoderHolder.receiveVideoData(videoFrame);
        }
    }

    public void receiveVideoData(VideoFrame videoFrame) {
        ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> encoderMap;
        if (videoFrame != null && videoFrame.data != null && (encoderMap = getEncoderMap()) != null) {
            for (Map.Entry<VideoEncoderType, VideoEncoderHolder> value : encoderMap.entrySet()) {
                ((VideoEncoderHolder) value.getValue()).receiveVideoData(videoFrame);
            }
        }
    }

    private ConcurrentHashMap<VideoEncoderType, VideoEncoderHolder> getEncoderMap() {
        if (this.mDestroyed) {
            return null;
        }
        return this.mEncoderMP;
    }

    private static class VideoEncoderHolder implements BaseCodecImpl.OnCodecEventCallBack {
        private static boolean OPEN_CHECK = true;
        private final String TAG;
        private int mBitrate;
        /* access modifiers changed from: private */
        public BaseEncoderImpl mCurrentVideoEncoder;
        /* access modifiers changed from: private */
        public final Object mDestroyLock = new Object();
        private boolean mEncoderDestroyed = true;
        /* access modifiers changed from: private */
        public boolean mEncoderStarted;
        private boolean mExitControlThread;
        private int mExternalVideoColorFormat;
        private int mFps;
        /* access modifiers changed from: private */
        public ConcurrentLinkedQueue<VideoFrame> mGLIntBufferCache;
        private boolean mHardwareSurfaceEnabled = true;
        private int mHeight;
        private int mLastDynamicBitrate;
        private final String mLogWatcher;
        private OnLocalVideoEncoderCallBack mOnLocalVideoEncoderCallBack;
        private final Object mThreadControlLock = new Object();
        private int mTryOpenCount;
        private boolean mUseSoftEncoder;
        private int mVideoBitrateMode = 1;
        private HardwareEncoder.OnHardwareSurfaceLifeListener mVideoEncoderCallBack;
        private Thread mVideoEncoderThread;
        private final VideoEncoderType mVideoEncoderType;
        private int mVideoIFrameInterval;
        private int mWidth;

        public void onRestartCodec() {
        }

        VideoEncoderHolder(VideoEncoderType videoEncoderType, String str) {
            this.mVideoEncoderType = videoEncoderType;
            this.mLogWatcher = str;
            this.TAG = "VideoEncoderHolder";
            Thread thread = new Thread(new LocalRunnable(this));
            thread.setName("ENCODER-SOFT-DATA");
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnHardwareSurfaceLifeListener(HardwareEncoder.OnHardwareSurfaceLifeListener onHardwareSurfaceLifeListener) {
            this.mVideoEncoderCallBack = onHardwareSurfaceLifeListener;
        }

        public void setOnLocalVideoEncoderTypeChangedListener(OnLocalVideoEncoderCallBack onLocalVideoEncoderCallBack) {
            this.mOnLocalVideoEncoderCallBack = onLocalVideoEncoderCallBack;
        }

        /* access modifiers changed from: package-private */
        public void setEncoderParams(int i) {
            BaseEncoderImpl baseEncoderImpl;
            if (smoothBitrate(i) > 0 && (baseEncoderImpl = this.mCurrentVideoEncoder) != null) {
                log("Change Set video encoder bitrate... " + i);
                if (!baseEncoderImpl.isHardwareEncoder()) {
                    baseEncoderImpl.setDynamicBitrate(i);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    baseEncoderImpl.setDynamicBitrate(i);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setEncoderParams(int i, int i2, int i3, int i4, int i5) {
            if (i != this.mWidth || i2 != this.mHeight || i3 != this.mFps || i4 != this.mBitrate || i5 != this.mVideoIFrameInterval) {
                log("SCREEN_ROTATE Set video encoder params..." + i + " | " + i2 + " | " + i3 + " | " + i4 + " | " + i5);
                this.mWidth = i;
                this.mHeight = i2;
                this.mFps = i3;
                this.mBitrate = i4;
                this.mVideoIFrameInterval = i5;
                recordParams();
                synchronized (this.mDestroyLock) {
                    if (!this.mEncoderDestroyed) {
                        synchronized (this.mThreadControlLock) {
                            this.mThreadControlLock.notify();
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setSoftEncoderType(boolean z) {
            if (this.mUseSoftEncoder != z) {
                log("Set video encoder work type, soft? : " + z);
                this.mUseSoftEncoder = z;
            }
        }

        public void setVideoBitrateMode(int i) {
            if (this.mVideoBitrateMode != i) {
                log("Set video encoder bitrate mode, mode : " + i);
                this.mVideoBitrateMode = i;
                synchronized (this.mDestroyLock) {
                    if (!this.mEncoderDestroyed) {
                        synchronized (this.mThreadControlLock) {
                            this.mThreadControlLock.notify();
                        }
                    }
                }
            }
        }

        public void setHardwareSurfaceEnabled(boolean z) {
            this.mHardwareSurfaceEnabled = z;
            log("Set hardware surface enabled : " + z);
        }

        public void setExternalVideoColorFormat(int i) {
            this.mExternalVideoColorFormat = i;
            log("Set the external video color format : " + i);
            BaseEncoderImpl baseEncoderImpl = this.mCurrentVideoEncoder;
            if (baseEncoderImpl != null) {
                ((HardwareEncoder) baseEncoderImpl).setExternalVideoFormat(i);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
            if (OPEN_CHECK == false) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
            r0 = r4.mThreadControlLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r4.mThreadControlLock.notify();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
            return startEncoder();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean createEncoder() {
            /*
                r4 = this;
                java.lang.Object r0 = r4.mDestroyLock
                monitor-enter(r0)
                boolean r1 = r4.mEncoderDestroyed     // Catch:{ all -> 0x003a }
                r2 = 1
                if (r1 != 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x003a }
                return r2
            L_0x000a:
                r1 = 0
                r4.mEncoderDestroyed = r1     // Catch:{ all -> 0x003a }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
                r1.<init>()     // Catch:{ all -> 0x003a }
                java.lang.String r3 = "Create video encoder, recheck : "
                r1.append(r3)     // Catch:{ all -> 0x003a }
                boolean r3 = OPEN_CHECK     // Catch:{ all -> 0x003a }
                r1.append(r3)     // Catch:{ all -> 0x003a }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x003a }
                r4.log(r1)     // Catch:{ all -> 0x003a }
                monitor-exit(r0)     // Catch:{ all -> 0x003a }
                boolean r0 = OPEN_CHECK
                if (r0 == 0) goto L_0x0035
                java.lang.Object r0 = r4.mThreadControlLock
                monitor-enter(r0)
                java.lang.Object r1 = r4.mThreadControlLock     // Catch:{ all -> 0x0032 }
                r1.notify()     // Catch:{ all -> 0x0032 }
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                return r2
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                throw r1
            L_0x0035:
                boolean r0 = r4.startEncoder()
                return r0
            L_0x003a:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003a }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.createEncoder():boolean");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
            if (OPEN_CHECK == false) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            r0 = r4.mThreadControlLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
            monitor-enter(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r4.mThreadControlLock.notify();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
            monitor-exit(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
            return stopEncoder();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean destroyEncoder() {
            /*
                r4 = this;
                java.lang.Object r0 = r4.mDestroyLock
                monitor-enter(r0)
                boolean r1 = r4.mEncoderDestroyed     // Catch:{ all -> 0x0039 }
                r2 = 1
                if (r1 == 0) goto L_0x000a
                monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                return r2
            L_0x000a:
                r4.mEncoderDestroyed = r2     // Catch:{ all -> 0x0039 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0039 }
                r1.<init>()     // Catch:{ all -> 0x0039 }
                java.lang.String r3 = "Destroy video encoder, recheck : "
                r1.append(r3)     // Catch:{ all -> 0x0039 }
                boolean r3 = OPEN_CHECK     // Catch:{ all -> 0x0039 }
                r1.append(r3)     // Catch:{ all -> 0x0039 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0039 }
                r4.log(r1)     // Catch:{ all -> 0x0039 }
                monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                boolean r0 = OPEN_CHECK
                if (r0 == 0) goto L_0x0034
                java.lang.Object r0 = r4.mThreadControlLock
                monitor-enter(r0)
                java.lang.Object r1 = r4.mThreadControlLock     // Catch:{ all -> 0x0031 }
                r1.notify()     // Catch:{ all -> 0x0031 }
                monitor-exit(r0)     // Catch:{ all -> 0x0031 }
                return r2
            L_0x0031:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0031 }
                throw r1
            L_0x0034:
                boolean r0 = r4.stopEncoder()
                return r0
            L_0x0039:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.destroyEncoder():boolean");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
            if (r2 == false) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
            r1 = new com.wushuangtech.myvideoimprove.codec.encoder.SoftwareEncoder(r7.mLogWatcher);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
            r1 = new com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder(r7.mLogWatcher);
            ((com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder) r1).setExternalVideoFormat(r7.mExternalVideoColorFormat);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
            r2 = java.lang.Integer.toHexString(r1.hashCode());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0065, code lost:
            if (r1.initEncoder(r2) != false) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
            logE(r0 + "Init video encoder failed! type : " + r7.mVideoEncoderType);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0080, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0081, code lost:
            log(r0 + "Create a new video encoder = " + r1.getClass().getSimpleName() + r2 + " | type : " + r7.mVideoEncoderType + " - bug1000");
            r1.setOnCodecRestartCallBack(r7);
            r1.setVideoBitrateMode(r7.mVideoBitrateMode);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00be, code lost:
            if (r7.mVideoEncoderType != com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.MAIN) goto L_0x00c4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c0, code lost:
            r1.setDualEncoder(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c8, code lost:
            if (r7.mVideoEncoderType != com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.DUAL) goto L_0x00cd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ca, code lost:
            r1.setDualEncoder(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cd, code lost:
            r2 = tryOpenEncoder(r1);
            r4 = r7.mDestroyLock;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d3, code lost:
            monitor-enter(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d4, code lost:
            if (r2 == false) goto L_0x00f7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            r7.mCurrentVideoEncoder = r1;
            r7.mEncoderStarted = true;
            r1 = r7.mOnLocalVideoEncoderCallBack;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00dc, code lost:
            if (r1 == null) goto L_0x00e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00de, code lost:
            r1.onEncoderStartSuccess();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e1, code lost:
            log(r0 + "Start encoder holder over!");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f5, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f6, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f7, code lost:
            monitor-exit(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f8, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean startEncoder() {
            /*
                r7 = this;
                java.lang.String r0 = com.wushuangtech.utils.OmniLog.getInvokedMethodNameWithFormat()
                java.lang.Object r1 = r7.mDestroyLock
                monitor-enter(r1)
                boolean r2 = r7.mEncoderDestroyed     // Catch:{ all -> 0x00fc }
                r3 = 1
                if (r2 == 0) goto L_0x0022
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
                r2.<init>()     // Catch:{ all -> 0x00fc }
                r2.append(r0)     // Catch:{ all -> 0x00fc }
                java.lang.String r0 = "encoder holder already destroyed!"
                r2.append(r0)     // Catch:{ all -> 0x00fc }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00fc }
                r7.logW(r0)     // Catch:{ all -> 0x00fc }
                monitor-exit(r1)     // Catch:{ all -> 0x00fc }
                return r3
            L_0x0022:
                boolean r2 = r7.mEncoderStarted     // Catch:{ all -> 0x00fc }
                if (r2 == 0) goto L_0x003c
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
                r2.<init>()     // Catch:{ all -> 0x00fc }
                r2.append(r0)     // Catch:{ all -> 0x00fc }
                java.lang.String r0 = "encoder holder already started!"
                r2.append(r0)     // Catch:{ all -> 0x00fc }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00fc }
                r7.logW(r0)     // Catch:{ all -> 0x00fc }
                monitor-exit(r1)     // Catch:{ all -> 0x00fc }
                return r3
            L_0x003c:
                boolean r2 = r7.mUseSoftEncoder     // Catch:{ all -> 0x00fc }
                monitor-exit(r1)     // Catch:{ all -> 0x00fc }
                if (r2 == 0) goto L_0x0049
                com.wushuangtech.myvideoimprove.codec.encoder.SoftwareEncoder r1 = new com.wushuangtech.myvideoimprove.codec.encoder.SoftwareEncoder
                java.lang.String r2 = r7.mLogWatcher
                r1.<init>(r2)
                goto L_0x0058
            L_0x0049:
                com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder r1 = new com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder
                java.lang.String r2 = r7.mLogWatcher
                r1.<init>(r2)
                r2 = r1
                com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder r2 = (com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder) r2
                int r4 = r7.mExternalVideoColorFormat
                r2.setExternalVideoFormat(r4)
            L_0x0058:
                int r2 = r1.hashCode()
                java.lang.String r2 = java.lang.Integer.toHexString(r2)
                boolean r4 = r1.initEncoder(r2)
                r5 = 0
                if (r4 != 0) goto L_0x0081
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "Init video encoder failed! type : "
                r1.append(r0)
                com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r0 = r7.mVideoEncoderType
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                r7.logE(r0)
                return r5
            L_0x0081:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r0)
                java.lang.String r6 = "Create a new video encoder = "
                r4.append(r6)
                java.lang.Class r6 = r1.getClass()
                java.lang.String r6 = r6.getSimpleName()
                r4.append(r6)
                r4.append(r2)
                java.lang.String r2 = " | type : "
                r4.append(r2)
                com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r2 = r7.mVideoEncoderType
                r4.append(r2)
                java.lang.String r2 = " - bug1000"
                r4.append(r2)
                java.lang.String r2 = r4.toString()
                r7.log(r2)
                r1.setOnCodecRestartCallBack(r7)
                int r2 = r7.mVideoBitrateMode
                r1.setVideoBitrateMode(r2)
                com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r2 = r7.mVideoEncoderType
                com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r4 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.MAIN
                if (r2 != r4) goto L_0x00c4
                r1.setDualEncoder(r5)
                goto L_0x00cd
            L_0x00c4:
                com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r2 = r7.mVideoEncoderType
                com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r4 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderType.DUAL
                if (r2 != r4) goto L_0x00cd
                r1.setDualEncoder(r3)
            L_0x00cd:
                boolean r2 = r7.tryOpenEncoder(r1)
                java.lang.Object r4 = r7.mDestroyLock
                monitor-enter(r4)
                if (r2 == 0) goto L_0x00f7
                r7.mCurrentVideoEncoder = r1     // Catch:{ all -> 0x00f9 }
                r7.mEncoderStarted = r3     // Catch:{ all -> 0x00f9 }
                com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$OnLocalVideoEncoderCallBack r1 = r7.mOnLocalVideoEncoderCallBack     // Catch:{ all -> 0x00f9 }
                if (r1 == 0) goto L_0x00e1
                r1.onEncoderStartSuccess()     // Catch:{ all -> 0x00f9 }
            L_0x00e1:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f9 }
                r1.<init>()     // Catch:{ all -> 0x00f9 }
                r1.append(r0)     // Catch:{ all -> 0x00f9 }
                java.lang.String r0 = "Start encoder holder over!"
                r1.append(r0)     // Catch:{ all -> 0x00f9 }
                java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00f9 }
                r7.log(r0)     // Catch:{ all -> 0x00f9 }
                monitor-exit(r4)     // Catch:{ all -> 0x00f9 }
                return r3
            L_0x00f7:
                monitor-exit(r4)     // Catch:{ all -> 0x00f9 }
                return r5
            L_0x00f9:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x00f9 }
                throw r0
            L_0x00fc:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00fc }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.startEncoder():boolean");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x009b, code lost:
            if (r4 == null) goto L_0x00b3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a1, code lost:
            if (r4.isHardwareEncoder() == false) goto L_0x00aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a3, code lost:
            ((com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder) r4).release();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00aa, code lost:
            ((com.wushuangtech.myvideoimprove.codec.encoder.SoftwareEncoder) r4).release();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b0, code lost:
            r4.destroyEncoder();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b3, code lost:
            log(r0 + "Stop video encoder has bean done!");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c7, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean stopEncoder() {
            /*
                r7 = this;
                java.lang.String r0 = com.wushuangtech.utils.OmniLog.getInvokedMethodNameWithFormat()
                java.lang.Object r1 = r7.mDestroyLock
                monitor-enter(r1)
                boolean r2 = r7.mEncoderStarted     // Catch:{ all -> 0x00c8 }
                r3 = 1
                if (r2 != 0) goto L_0x0022
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
                r2.<init>()     // Catch:{ all -> 0x00c8 }
                r2.append(r0)     // Catch:{ all -> 0x00c8 }
                java.lang.String r0 = "already stopped!"
                r2.append(r0)     // Catch:{ all -> 0x00c8 }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00c8 }
                r7.logW(r0)     // Catch:{ all -> 0x00c8 }
                monitor-exit(r1)     // Catch:{ all -> 0x00c8 }
                return r3
            L_0x0022:
                java.lang.String r2 = "null"
                com.wushuangtech.myvideoimprove.codec.encoder.BaseEncoderImpl r4 = r7.mCurrentVideoEncoder     // Catch:{ all -> 0x00c8 }
                if (r4 == 0) goto L_0x0063
                boolean r2 = r7.mUseSoftEncoder     // Catch:{ all -> 0x00c8 }
                if (r2 == 0) goto L_0x0048
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
                r2.<init>()     // Catch:{ all -> 0x00c8 }
                java.lang.String r4 = "SoftwareEncoder"
                r2.append(r4)     // Catch:{ all -> 0x00c8 }
                com.wushuangtech.myvideoimprove.codec.encoder.BaseEncoderImpl r4 = r7.mCurrentVideoEncoder     // Catch:{ all -> 0x00c8 }
                int r4 = r4.hashCode()     // Catch:{ all -> 0x00c8 }
                java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch:{ all -> 0x00c8 }
                r2.append(r4)     // Catch:{ all -> 0x00c8 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c8 }
                goto L_0x0063
            L_0x0048:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
                r2.<init>()     // Catch:{ all -> 0x00c8 }
                java.lang.String r4 = "HardwareEncoder"
                r2.append(r4)     // Catch:{ all -> 0x00c8 }
                com.wushuangtech.myvideoimprove.codec.encoder.BaseEncoderImpl r4 = r7.mCurrentVideoEncoder     // Catch:{ all -> 0x00c8 }
                int r4 = r4.hashCode()     // Catch:{ all -> 0x00c8 }
                java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch:{ all -> 0x00c8 }
                r2.append(r4)     // Catch:{ all -> 0x00c8 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c8 }
            L_0x0063:
                com.wushuangtech.myvideoimprove.codec.encoder.BaseEncoderImpl r4 = r7.mCurrentVideoEncoder     // Catch:{ all -> 0x00c8 }
                r5 = 0
                r7.mCurrentVideoEncoder = r5     // Catch:{ all -> 0x00c8 }
                r6 = 0
                r7.mEncoderStarted = r6     // Catch:{ all -> 0x00c8 }
                r7.mLastDynamicBitrate = r6     // Catch:{ all -> 0x00c8 }
                r7.unInitThread()     // Catch:{ all -> 0x00c8 }
                java.util.concurrent.ConcurrentLinkedQueue<com.wushuangtech.library.video.bean.VideoFrame> r6 = r7.mGLIntBufferCache     // Catch:{ all -> 0x00c8 }
                if (r6 == 0) goto L_0x0079
                r6.clear()     // Catch:{ all -> 0x00c8 }
                r7.mGLIntBufferCache = r5     // Catch:{ all -> 0x00c8 }
            L_0x0079:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
                r5.<init>()     // Catch:{ all -> 0x00c8 }
                r5.append(r0)     // Catch:{ all -> 0x00c8 }
                java.lang.String r6 = "Clear variables over! encoder = "
                r5.append(r6)     // Catch:{ all -> 0x00c8 }
                r5.append(r2)     // Catch:{ all -> 0x00c8 }
                java.lang.String r2 = ", type = "
                r5.append(r2)     // Catch:{ all -> 0x00c8 }
                com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderType r2 = r7.mVideoEncoderType     // Catch:{ all -> 0x00c8 }
                r5.append(r2)     // Catch:{ all -> 0x00c8 }
                java.lang.String r2 = r5.toString()     // Catch:{ all -> 0x00c8 }
                r7.log(r2)     // Catch:{ all -> 0x00c8 }
                monitor-exit(r1)     // Catch:{ all -> 0x00c8 }
                if (r4 == 0) goto L_0x00b3
                boolean r1 = r4.isHardwareEncoder()
                if (r1 == 0) goto L_0x00aa
                r1 = r4
                com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder r1 = (com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder) r1
                r1.release()
                goto L_0x00b0
            L_0x00aa:
                r1 = r4
                com.wushuangtech.myvideoimprove.codec.encoder.SoftwareEncoder r1 = (com.wushuangtech.myvideoimprove.codec.encoder.SoftwareEncoder) r1
                r1.release()
            L_0x00b0:
                r4.destroyEncoder()
            L_0x00b3:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r0)
                java.lang.String r0 = "Stop video encoder has bean done!"
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                r7.log(r0)
                return r3
            L_0x00c8:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00c8 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.stopEncoder():boolean");
        }

        public void clearResource() {
            this.mExitControlThread = true;
            destroyEncoder();
        }

        /* access modifiers changed from: package-private */
        public void receiveVideoData(VideoFrame videoFrame) {
            ConcurrentLinkedQueue<VideoFrame> concurrentLinkedQueue = this.mGLIntBufferCache;
            if (concurrentLinkedQueue != null) {
                if (concurrentLinkedQueue.size() >= 30) {
                    concurrentLinkedQueue.poll();
                }
                concurrentLinkedQueue.add(videoFrame);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
            if (r1 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            if (r1.isHardwareEncoder() == false) goto L_0x0024;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
            if (android.os.Build.VERSION.SDK_INT >= 19) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
            r1.requestIFrame();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
            r1.requestIFrame();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
            log("Request video encoder key frame...");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestKeyFrame() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.mDestroyLock
                monitor-enter(r0)
                boolean r1 = r3.mEncoderStarted     // Catch:{ all -> 0x0028 }
                if (r1 != 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return
            L_0x0009:
                com.wushuangtech.myvideoimprove.codec.encoder.BaseEncoderImpl r1 = r3.mCurrentVideoEncoder     // Catch:{ all -> 0x0028 }
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                java.lang.String r0 = "Request video encoder key frame..."
                r3.log(r0)
                if (r1 == 0) goto L_0x0027
                boolean r0 = r1.isHardwareEncoder()
                if (r0 == 0) goto L_0x0024
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 19
                if (r0 >= r2) goto L_0x0020
                goto L_0x0027
            L_0x0020:
                r1.requestIFrame()
                goto L_0x0027
            L_0x0024:
                r1.requestIFrame()
            L_0x0027:
                return
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.requestKeyFrame():void");
        }

        private void initThread() {
            if (this.mVideoEncoderThread == null) {
                Thread thread = new Thread(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
                        com.wushuangtech.library.video.VideoStatus.mVideoEncodeRecvFrameTimes++;
                        r1.receiveVideoData(r2.data, r2.width, r2.height, r2.mRotate, r2.timeStamp, r2.format);
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r10 = this;
                            r0 = 10
                            android.os.Process.setThreadPriority(r0)
                        L_0x0005:
                            boolean r0 = java.lang.Thread.interrupted()
                            if (r0 != 0) goto L_0x0068
                            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderHolder r0 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.this
                            java.util.concurrent.ConcurrentLinkedQueue r0 = r0.mGLIntBufferCache
                            if (r0 != 0) goto L_0x0014
                            goto L_0x0005
                        L_0x0014:
                            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderHolder r1 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.this
                            com.wushuangtech.myvideoimprove.codec.encoder.BaseEncoderImpl r1 = r1.mCurrentVideoEncoder
                            if (r1 != 0) goto L_0x001d
                            goto L_0x0005
                        L_0x001d:
                            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderHolder r2 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.this
                            boolean r2 = r2.mEncoderStarted
                            if (r2 != 0) goto L_0x0026
                            return
                        L_0x0026:
                            boolean r2 = r0.isEmpty()
                            if (r2 != 0) goto L_0x0062
                            java.lang.Object r2 = r0.poll()
                            com.wushuangtech.library.video.bean.VideoFrame r2 = (com.wushuangtech.library.video.bean.VideoFrame) r2
                            if (r2 != 0) goto L_0x0035
                            goto L_0x0026
                        L_0x0035:
                            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderHolder r3 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.this
                            java.lang.Object r3 = r3.mDestroyLock
                            monitor-enter(r3)
                            com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$VideoEncoderHolder r4 = com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.this     // Catch:{ all -> 0x005f }
                            boolean r4 = r4.mEncoderStarted     // Catch:{ all -> 0x005f }
                            if (r4 != 0) goto L_0x0046
                            monitor-exit(r3)     // Catch:{ all -> 0x005f }
                            return
                        L_0x0046:
                            monitor-exit(r3)     // Catch:{ all -> 0x005f }
                            long r3 = com.wushuangtech.library.video.VideoStatus.mVideoEncodeRecvFrameTimes
                            r5 = 1
                            long r3 = r3 + r5
                            com.wushuangtech.library.video.VideoStatus.mVideoEncodeRecvFrameTimes = r3
                            byte[] r3 = r2.data
                            int r4 = r2.width
                            int r5 = r2.height
                            int r6 = r2.mRotate
                            long r7 = r2.timeStamp
                            int r9 = r2.format
                            r2 = r1
                            r2.receiveVideoData(r3, r4, r5, r6, r7, r9)
                            goto L_0x0026
                        L_0x005f:
                            r0 = move-exception
                            monitor-exit(r3)     // Catch:{ all -> 0x005f }
                            throw r0
                        L_0x0062:
                            r0 = 15
                            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0068 }
                            goto L_0x0005
                        L_0x0068:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.AnonymousClass1.run():void");
                    }
                });
                this.mVideoEncoderThread = thread;
                if (!(thread instanceof Thread)) {
                    thread.start();
                } else {
                    AsynchronousInstrumentation.threadStart(thread);
                }
            }
        }

        private void handleThread(boolean z) {
            if (z) {
                initThread();
                this.mGLIntBufferCache = new ConcurrentLinkedQueue<>();
                return;
            }
            unInitThread();
            ConcurrentLinkedQueue<VideoFrame> concurrentLinkedQueue = this.mGLIntBufferCache;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.clear();
                this.mGLIntBufferCache = null;
            }
        }

        private void unInitThread() {
            Thread thread = this.mVideoEncoderThread;
            if (thread != null) {
                thread.interrupt();
                try {
                    this.mVideoEncoderThread.join(2000);
                } catch (InterruptedException unused) {
                    this.mVideoEncoderThread.interrupt();
                }
                this.mVideoEncoderThread = null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0024, code lost:
            r8.setEncoderParams(r5, r3, r6);
            r2 = new com.wushuangtech.myvideoimprove.bean.CodecConfigureBean();
            r2.width = r7.mWidth;
            r2.height = r7.mHeight;
            r3 = r8.isHardwareEncoder();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
            if (r3 == false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
            r5 = (com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder) r8;
            r5.setOnHardwareSurfaceLifeListener(r7.mVideoEncoderCallBack);
            r5.setEncoderSurfaceMode(r7.mHardwareSurfaceEnabled);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
            r8 = r8.open(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
            if (r8 == false) goto L_0x0070;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004d, code lost:
            log(r1 + "Encoder open success! hardware = " + r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
            if (r3 == false) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0068, code lost:
            if (r7.mHardwareSurfaceEnabled != false) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006b, code lost:
            r0 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
            handleThread(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
            logE(r1 + "Encoder open failed!");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
            return r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean tryOpenEncoder(com.wushuangtech.myvideoimprove.codec.encoder.BaseEncoderImpl r8) {
            /*
                r7 = this;
                r0 = 1
                if (r8 != 0) goto L_0x0004
                return r0
            L_0x0004:
                java.lang.String r1 = com.wushuangtech.utils.OmniLog.getInvokedMethodNameWithFormat()
                java.lang.Object r2 = r7.mDestroyLock
                monitor-enter(r2)
                int r3 = r7.mWidth     // Catch:{ all -> 0x00b1 }
                r4 = 0
                if (r3 == 0) goto L_0x009b
                int r3 = r7.mHeight     // Catch:{ all -> 0x00b1 }
                if (r3 != 0) goto L_0x0016
                goto L_0x009b
            L_0x0016:
                int r3 = r7.mBitrate     // Catch:{ all -> 0x00b1 }
                if (r3 == 0) goto L_0x0085
                int r5 = r7.mFps     // Catch:{ all -> 0x00b1 }
                if (r5 == 0) goto L_0x0085
                int r6 = r7.mVideoIFrameInterval     // Catch:{ all -> 0x00b1 }
                if (r6 != 0) goto L_0x0023
                goto L_0x0085
            L_0x0023:
                monitor-exit(r2)     // Catch:{ all -> 0x00b1 }
                r8.setEncoderParams(r5, r3, r6)
                com.wushuangtech.myvideoimprove.bean.CodecConfigureBean r2 = new com.wushuangtech.myvideoimprove.bean.CodecConfigureBean
                r2.<init>()
                int r3 = r7.mWidth
                r2.width = r3
                int r3 = r7.mHeight
                r2.height = r3
                boolean r3 = r8.isHardwareEncoder()
                if (r3 == 0) goto L_0x0047
                r5 = r8
                com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder r5 = (com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder) r5
                com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder$OnHardwareSurfaceLifeListener r6 = r7.mVideoEncoderCallBack
                r5.setOnHardwareSurfaceLifeListener(r6)
                boolean r6 = r7.mHardwareSurfaceEnabled
                r5.setEncoderSurfaceMode(r6)
            L_0x0047:
                boolean r8 = r8.open(r2)
                if (r8 == 0) goto L_0x0070
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                r2.append(r1)
                java.lang.String r1 = "Encoder open success! hardware = "
                r2.append(r1)
                r2.append(r3)
                java.lang.String r1 = r2.toString()
                r7.log(r1)
                if (r3 == 0) goto L_0x006c
                boolean r1 = r7.mHardwareSurfaceEnabled
                if (r1 != 0) goto L_0x006b
                goto L_0x006c
            L_0x006b:
                r0 = r4
            L_0x006c:
                r7.handleThread(r0)
                goto L_0x0084
            L_0x0070:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r1)
                java.lang.String r1 = "Encoder open failed!"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r7.logE(r0)
            L_0x0084:
                return r8
            L_0x0085:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
                r8.<init>()     // Catch:{ all -> 0x00b1 }
                r8.append(r1)     // Catch:{ all -> 0x00b1 }
                java.lang.String r0 = "Encoder params is zero!"
                r8.append(r0)     // Catch:{ all -> 0x00b1 }
                java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00b1 }
                r7.logE(r8)     // Catch:{ all -> 0x00b1 }
                monitor-exit(r2)     // Catch:{ all -> 0x00b1 }
                return r4
            L_0x009b:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
                r8.<init>()     // Catch:{ all -> 0x00b1 }
                r8.append(r1)     // Catch:{ all -> 0x00b1 }
                java.lang.String r0 = "Encoder size is zero!"
                r8.append(r0)     // Catch:{ all -> 0x00b1 }
                java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00b1 }
                r7.logE(r8)     // Catch:{ all -> 0x00b1 }
                monitor-exit(r2)     // Catch:{ all -> 0x00b1 }
                return r4
            L_0x00b1:
                r8 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00b1 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.tryOpenEncoder(com.wushuangtech.myvideoimprove.codec.encoder.BaseEncoderImpl):boolean");
        }

        public void onEncodedDataReport(boolean z, byte[] bArr, int i, int i2, int i3, long j) {
            OnLocalVideoEncoderCallBack onLocalVideoEncoderCallBack = this.mOnLocalVideoEncoderCallBack;
            if (onLocalVideoEncoderCallBack != null) {
                onLocalVideoEncoderCallBack.onEncodedDataReport(z, bArr, i, i2, i3, j);
            }
        }

        private void recordParams() {
            GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
            if (globalVideoConfig != null) {
                if (this.mVideoEncoderType == VideoEncoderType.MAIN) {
                    globalVideoConfig.setVideoEncoderParams(this.mWidth, this.mHeight, this.mFps, this.mBitrate);
                } else {
                    globalVideoConfig.setVideoEncoderMinorParams(this.mWidth, this.mHeight, this.mFps, this.mBitrate);
                }
            }
        }

        /* access modifiers changed from: private */
        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
            	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public void executingRestartCodec() {
            /*
                r4 = this;
                java.lang.String r0 = "--------------------- Need to restart video encoder! ----------------------------"
                r4.log(r0)
            L_0x0005:
                r4.stopEncoder()     // Catch:{ Exception -> 0x0099 }
                boolean r0 = r4.startEncoder()     // Catch:{ Exception -> 0x0099 }
                if (r0 == 0) goto L_0x0066
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0099 }
                r0.<init>()     // Catch:{ Exception -> 0x0099 }
                java.lang.String r1 = "Restart video encoder success! "
                r0.append(r1)     // Catch:{ Exception -> 0x0099 }
                boolean r1 = r4.mEncoderDestroyed     // Catch:{ Exception -> 0x0099 }
                r0.append(r1)     // Catch:{ Exception -> 0x0099 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0099 }
                r4.log(r0)     // Catch:{ Exception -> 0x0099 }
                java.lang.Object r0 = r4.mDestroyLock     // Catch:{ Exception -> 0x0099 }
                monitor-enter(r0)     // Catch:{ Exception -> 0x0099 }
                boolean r1 = r4.mEncoderDestroyed     // Catch:{ all -> 0x0063 }
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                if (r1 == 0) goto L_0x002f
                r4.stopEncoder()     // Catch:{ Exception -> 0x0099 }
            L_0x002f:
                java.lang.Object r0 = r4.mThreadControlLock     // Catch:{ Exception -> 0x0099 }
                monitor-enter(r0)     // Catch:{ Exception -> 0x0099 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
                r2.<init>()     // Catch:{ all -> 0x0060 }
                java.lang.String r3 = "Local video encoder control thread wait! last state: "
                r2.append(r3)     // Catch:{ all -> 0x0060 }
                r2.append(r1)     // Catch:{ all -> 0x0060 }
                java.lang.String r3 = ", current state: "
                r2.append(r3)     // Catch:{ all -> 0x0060 }
                boolean r3 = r4.mEncoderDestroyed     // Catch:{ all -> 0x0060 }
                r2.append(r3)     // Catch:{ all -> 0x0060 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0060 }
                r4.log(r2)     // Catch:{ all -> 0x0060 }
                boolean r2 = r4.mEncoderDestroyed     // Catch:{ all -> 0x0060 }
                if (r1 != r2) goto L_0x0059
                java.lang.Object r1 = r4.mThreadControlLock     // Catch:{ all -> 0x0060 }
                r1.wait()     // Catch:{ all -> 0x0060 }
            L_0x0059:
                java.lang.String r1 = "Local video encoder control thread notify!"
                r4.log(r1)     // Catch:{ all -> 0x0060 }
                monitor-exit(r0)     // Catch:{ all -> 0x0060 }
                goto L_0x008c
            L_0x0060:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0060 }
                throw r1     // Catch:{ Exception -> 0x0099 }
            L_0x0063:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0063 }
                throw r1     // Catch:{ Exception -> 0x0099 }
            L_0x0066:
                r0 = 2000(0x7d0, double:9.88E-321)
                java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x0099 }
                java.lang.String r0 = "Restart video encoder failed... wait and try next!!!"
                r4.logE(r0)     // Catch:{ Exception -> 0x0099 }
                com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder$OnLocalVideoEncoderCallBack r0 = r4.mOnLocalVideoEncoderCallBack     // Catch:{ Exception -> 0x0099 }
                if (r0 == 0) goto L_0x008c
                int r0 = r4.mTryOpenCount     // Catch:{ Exception -> 0x0099 }
                int r0 = r0 + 1
                r4.mTryOpenCount = r0     // Catch:{ Exception -> 0x0099 }
                r1 = 100000(0x186a0, float:1.4013E-40)
                if (r0 <= r1) goto L_0x008c
                boolean r0 = r4.mUseSoftEncoder     // Catch:{ Exception -> 0x0099 }
                if (r0 != 0) goto L_0x008c
                r4.tryOpenSoftEncoder()     // Catch:{ Exception -> 0x0099 }
                java.lang.String r0 = "Break try looper..."
                r4.logE(r0)     // Catch:{ Exception -> 0x0099 }
                goto L_0x0098
            L_0x008c:
                boolean r0 = r4.mExitControlThread     // Catch:{ Exception -> 0x0099 }
                if (r0 == 0) goto L_0x0005
                java.lang.String r0 = "Local video encoder control thread exit!"
                r4.log(r0)     // Catch:{ Exception -> 0x0099 }
                r4.stopEncoder()     // Catch:{ Exception -> 0x0099 }
            L_0x0098:
                return
            L_0x0099:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x0005
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder.VideoEncoderHolder.executingRestartCodec():void");
        }

        private void tryOpenSoftEncoder() {
            OPEN_CHECK = false;
            this.mUseSoftEncoder = true;
            OnLocalVideoEncoderCallBack onLocalVideoEncoderCallBack = this.mOnLocalVideoEncoderCallBack;
            if (onLocalVideoEncoderCallBack != null) {
                onLocalVideoEncoderCallBack.onEncoderTypeChanged(true);
                if (startEncoder()) {
                    log("Restart video soft encoder success...");
                    if (this.mEncoderDestroyed) {
                        stopEncoder();
                    }
                }
            }
        }

        private int smoothBitrate(int i) {
            int i2 = this.mLastDynamicBitrate;
            if (i2 == i) {
                return 0;
            }
            if (i2 == 0) {
                this.mLastDynamicBitrate = i;
                return i;
            } else if (Math.abs(i - i2) < 10000) {
                return 0;
            } else {
                this.mLastDynamicBitrate = i;
                return i;
            }
        }

        private void log(String str) {
            OmniLog.i(this.mLogWatcher, this.TAG, str);
        }

        private void logW(String str) {
            OmniLog.w(this.mLogWatcher, this.TAG, str);
        }

        private void logE(String str) {
            OmniLog.e(OmniLog.VIDEO_ENCODER_WATCH, this.TAG, str);
        }
    }

    private static class LocalRunnable implements Runnable {
        private final WeakReference<VideoEncoderHolder> mOutReference;

        public LocalRunnable(VideoEncoderHolder videoEncoderHolder) {
            this.mOutReference = new WeakReference<>(videoEncoderHolder);
        }

        public void run() {
            Process.setThreadPriority(10);
            VideoEncoderHolder videoEncoderHolder = (VideoEncoderHolder) this.mOutReference.get();
            if (videoEncoderHolder != null) {
                videoEncoderHolder.executingRestartCodec();
            }
        }
    }
}
