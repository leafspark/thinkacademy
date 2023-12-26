package com.wushuangtech.api;

import android.util.Log;
import com.wushuangtech.api.ExternalRtmpPublishModuleCallback;
import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.log.RtmpPullReportLogger;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.SntpClient;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class ExternalRtmpPublishModule implements VideoSender, AudioSender {
    /* access modifiers changed from: private */
    public static final String TAG = "ExternalRtmpPublishModule";
    private static ExternalRtmpPublishModule mExternalRtmpPublishModule;
    private WeakReference<ExternalAudioModuleCallback> mAudioCallback;
    private WeakReference<ExternalRtmpPublishModuleCallback> mCallback;
    private volatile boolean mIsPause;
    private long mLastRtmpStatisticsTime;
    private volatile boolean mNeedIFrame;
    private final FastLogCacheBean mPushAudioWatcher;
    private final FastLogCacheBean mPushVideoWatcher;
    /* access modifiers changed from: private */
    public RtmpPullReportLogger mRtmpPullReportLogger;
    private RtmpPushStatistics mRtmpPushStatistics;
    private WeakReference<ExternalVideoModuleCallback> mVideoCallback;

    public static class RtmpPushStatistics {
        public int mAudioRealBitrate;
        public int mFps;
        public int mVideoRealBitrate;
    }

    private native int GetAudioRealBitrate();

    private native int GetRealFps();

    private native int GetVideoRealBitrate();

    private native boolean Initialize(ExternalRtmpPublishModule externalRtmpPublishModule);

    private native void PushEncodedAudioData(byte[] bArr, int i);

    private native void PushEncodedVideoData(byte[] bArr, int i, int i2, int i3, int i4);

    private native void SendEncodedVideoFrame();

    private native void SetRetryTimes(int i);

    private native boolean StartPublish(String str, int i);

    private native boolean StopPublish();

    private native void SyncNtpTime(long j);

    private native void Uninitialize();

    public void SetAudioFractionLoss(int i) {
    }

    public void pushDualEncodedVideoData(ArrayList<byte[]> arrayList, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j) {
    }

    public void pushDualEncodedVideoData(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j) {
    }

    public void sendNACKData(byte[] bArr, int i, long j) {
    }

    public void sendRTCPData(byte[] bArr, int i, long j) {
    }

    public ExternalRtmpPublishModule() {
        String str = TAG;
        this.mPushAudioWatcher = new FastLogCacheBean(OmniLog.RTMP_WATCH, str, 4);
        this.mPushVideoWatcher = new FastLogCacheBean(OmniLog.RTMP_WATCH, str, 4);
    }

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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.wushuangtech.api.ExternalRtmpPublishModule getInstance() {
        /*
            java.lang.Class<com.wushuangtech.api.ExternalRtmpPublishModule> r0 = com.wushuangtech.api.ExternalRtmpPublishModule.class
            monitor-enter(r0)
            com.wushuangtech.api.ExternalRtmpPublishModule r1 = mExternalRtmpPublishModule     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x001b
            monitor-enter(r0)     // Catch:{ all -> 0x001f }
            com.wushuangtech.api.ExternalRtmpPublishModule r1 = mExternalRtmpPublishModule     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x0016
            com.wushuangtech.api.ExternalRtmpPublishModule r1 = new com.wushuangtech.api.ExternalRtmpPublishModule     // Catch:{ all -> 0x0018 }
            r1.<init>()     // Catch:{ all -> 0x0018 }
            mExternalRtmpPublishModule = r1     // Catch:{ all -> 0x0018 }
            r1.Initialize(r1)     // Catch:{ all -> 0x0018 }
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            goto L_0x001b
        L_0x0018:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1     // Catch:{ all -> 0x001f }
        L_0x001b:
            com.wushuangtech.api.ExternalRtmpPublishModule r1 = mExternalRtmpPublishModule     // Catch:{ all -> 0x001f }
            monitor-exit(r0)
            return r1
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.ExternalRtmpPublishModule.getInstance():com.wushuangtech.api.ExternalRtmpPublishModule");
    }

    public void setExternalVideoModuleCallback(ExternalVideoModuleCallback externalVideoModuleCallback) {
        this.mVideoCallback = new WeakReference<>(externalVideoModuleCallback);
    }

    public void setExternalAudioModuleCallback(ExternalAudioModuleCallback externalAudioModuleCallback) {
        this.mAudioCallback = new WeakReference<>(externalAudioModuleCallback);
    }

    public void setExternalRtmpPublishModuleCallback(ExternalRtmpPublishModuleCallback externalRtmpPublishModuleCallback) {
        this.mCallback = new WeakReference<>(externalRtmpPublishModuleCallback);
    }

    public RtmpPushStatistics getRtmpPushStatus() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLastRtmpStatisticsTime;
        boolean z = true;
        if (j == 0) {
            this.mLastRtmpStatisticsTime = currentTimeMillis;
        } else if (currentTimeMillis - j < 1000) {
            z = false;
        }
        if (z) {
            RtmpPushStatistics rtmpPushStatistics = new RtmpPushStatistics();
            this.mRtmpPushStatistics = rtmpPushStatistics;
            rtmpPushStatistics.mFps = GetRealFps();
            this.mRtmpPushStatistics.mAudioRealBitrate = GetAudioRealBitrate() / 1000;
            this.mRtmpPushStatistics.mVideoRealBitrate = GetVideoRealBitrate() / 1000;
            this.mLastRtmpStatisticsTime = currentTimeMillis;
        }
        RtmpPushStatistics rtmpPushStatistics2 = new RtmpPushStatistics();
        rtmpPushStatistics2.mFps = this.mRtmpPushStatistics.mFps;
        rtmpPushStatistics2.mAudioRealBitrate = this.mRtmpPushStatistics.mAudioRealBitrate;
        rtmpPushStatistics2.mVideoRealBitrate = this.mRtmpPushStatistics.mVideoRealBitrate;
        return rtmpPushStatistics2;
    }

    public boolean startPublish(String str) {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mVideoCallback;
        if (weakReference == null || this.mAudioCallback == null) {
            OmniLog.rtmp_e(TAG, "startPublish -> WeakReference ExternalVideoModuleCallback or ExternalAudioModuleCallback is null");
            return false;
        }
        ExternalVideoModuleCallback externalVideoModuleCallback = (ExternalVideoModuleCallback) weakReference.get();
        ExternalAudioModuleCallback externalAudioModuleCallback = (ExternalAudioModuleCallback) this.mAudioCallback.get();
        if (externalVideoModuleCallback == null || externalAudioModuleCallback == null) {
            OmniLog.rtmp_e(TAG, "startPublish -> ExternalVideoModuleCallback or ExternalAudioModuleCallback is null");
            return false;
        }
        boolean StartPublish = StartPublish(str, 3);
        String str2 = TAG;
        OmniLog.rtmp_d(str2, "startPublish -> Start result : " + StartPublish);
        if (StartPublish) {
            RtmpPullReportLogger rtmpPullReportLogger = this.mRtmpPullReportLogger;
            if (rtmpPullReportLogger != null) {
                rtmpPullReportLogger.Release();
            }
            RtmpPullReportLogger rtmpPullReportLogger2 = new RtmpPullReportLogger(GlobalConfig.mAppId, str, UUID.randomUUID().toString());
            this.mRtmpPullReportLogger = rtmpPullReportLogger2;
            rtmpPullReportLogger2.reportStartRtmpPush();
            externalVideoModuleCallback.startCapture();
            externalAudioModuleCallback.startCapture();
            SntpClient.asyncRequestTime("time4.apple.com", 1000, new SntpClient.CallBack() {
                public void onRequestComplete(boolean z, long j, long j2, long j3) {
                    if (!z) {
                        OmniLog.rtmp_e(ExternalRtmpPublishModule.TAG, "SntpClient -> Ntp sync failed!");
                    } else {
                        ExternalRtmpPublishModule.getInstance().syncNtpTime(j);
                        String access$000 = ExternalRtmpPublishModule.TAG;
                        OmniLog.rtmp_d(access$000, "SntpClient -> Ntp sync success! " + j);
                    }
                    if (ExternalRtmpPublishModule.this.mRtmpPullReportLogger != null) {
                        ExternalRtmpPublishModule.this.mRtmpPullReportLogger.reportNtpSync(z);
                    }
                }
            });
        }
        return StartPublish;
    }

    public boolean stopPublish() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mVideoCallback;
        if (weakReference == null || this.mAudioCallback == null) {
            OmniLog.rtmp_e(TAG, "stopPublish -> WeakReference ExternalVideoModuleCallback or ExternalAudioModuleCallback is null");
            return false;
        }
        ExternalVideoModuleCallback externalVideoModuleCallback = (ExternalVideoModuleCallback) weakReference.get();
        ExternalAudioModuleCallback externalAudioModuleCallback = (ExternalAudioModuleCallback) this.mAudioCallback.get();
        if (externalVideoModuleCallback == null || externalAudioModuleCallback == null) {
            OmniLog.rtmp_e(TAG, "stopPublish -> ExternalVideoModuleCallback or ExternalAudioModuleCallback is null");
            return false;
        }
        boolean StopPublish = StopPublish();
        String str = TAG;
        OmniLog.rtmp_d(str, "stopPublish -> Stop result : " + StopPublish);
        RtmpPullReportLogger rtmpPullReportLogger = this.mRtmpPullReportLogger;
        if (rtmpPullReportLogger != null) {
            rtmpPullReportLogger.reportStopRtmpPush(StopPublish);
        }
        if (StopPublish) {
            externalVideoModuleCallback.stopCapture();
            externalAudioModuleCallback.stopCapture();
            RtmpPullReportLogger rtmpPullReportLogger2 = this.mRtmpPullReportLogger;
            if (rtmpPullReportLogger2 != null) {
                rtmpPullReportLogger2.Release();
                this.mRtmpPullReportLogger = null;
            }
        }
        return StopPublish;
    }

    public void pushEncodedAudioData(byte[] bArr) {
        if (bArr != null && !this.mIsPause) {
            PushEncodedAudioData(bArr, bArr.length);
        }
    }

    public void pushEncodedVideoData(ArrayList<byte[]> arrayList, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j) {
        Iterator<byte[]> it = arrayList.iterator();
        while (it.hasNext()) {
            pushEncodedVideoData(it.next(), videoFrameType, i, i2, j);
        }
    }

    public void pushEncodedVideoData(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, long j) {
        int i3 = 0;
        if (this.mNeedIFrame) {
            if (videoFrameType == ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I) {
                this.mNeedIFrame = false;
            } else {
                return;
            }
        }
        if (!this.mIsPause) {
            if (videoFrameType == ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I) {
                i3 = 1;
            }
            byte[] bArr2 = bArr;
            PushEncodedVideoData(bArr2, bArr.length, i3, i, i2);
            SendEncodedVideoFrame();
        }
    }

    /* access modifiers changed from: private */
    public void syncNtpTime(long j) {
        SyncNtpTime(j);
    }

    private boolean StartCapture() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mVideoCallback;
        if (!(weakReference == null || this.mAudioCallback == null)) {
            ExternalVideoModuleCallback externalVideoModuleCallback = (ExternalVideoModuleCallback) weakReference.get();
            ExternalAudioModuleCallback externalAudioModuleCallback = (ExternalAudioModuleCallback) this.mAudioCallback.get();
            if (!(externalVideoModuleCallback == null || externalAudioModuleCallback == null)) {
                externalVideoModuleCallback.startCapture();
                externalAudioModuleCallback.startCapture();
                return true;
            }
        }
        return false;
    }

    private boolean StopCapture() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mVideoCallback;
        if (!(weakReference == null || this.mAudioCallback == null)) {
            ExternalVideoModuleCallback externalVideoModuleCallback = (ExternalVideoModuleCallback) weakReference.get();
            ExternalAudioModuleCallback externalAudioModuleCallback = (ExternalAudioModuleCallback) this.mAudioCallback.get();
            if (!(externalVideoModuleCallback == null || externalAudioModuleCallback == null)) {
                externalVideoModuleCallback.stopCapture();
                externalAudioModuleCallback.stopCapture();
                return true;
            }
        }
        return false;
    }

    private void ReceiveRtmpStatus(int i) {
        RtmpPullReportLogger.RtmpPushStatus rtmpPushStatus;
        ExternalRtmpPublishModuleCallback.RtmpErrorType rtmpErrorType;
        ExternalRtmpPublishModuleCallback externalRtmpPublishModuleCallback;
        ExternalRtmpPublishModuleCallback.RtmpErrorType rtmpErrorType2;
        String str = TAG;
        OmniLog.rtmp_d(str, "ReceiveRtmpStatus -> type : " + i);
        RtmpPullReportLogger.RtmpPushStatus rtmpPushStatus2 = RtmpPullReportLogger.RtmpPushStatus.RTMP_PUSH_UNKNOW;
        if (i == 0) {
            rtmpErrorType = ExternalRtmpPublishModuleCallback.RtmpErrorType.RtmpErrorType_InitError;
            rtmpPushStatus = RtmpPullReportLogger.RtmpPushStatus.RTMP_PUSH_FAILED;
        } else if (i == 1) {
            rtmpErrorType = ExternalRtmpPublishModuleCallback.RtmpErrorType.RtmpErrorType_OpenError;
            rtmpPushStatus = RtmpPullReportLogger.RtmpPushStatus.RTMP_PUSH_FAILED;
        } else {
            if (i == 2) {
                rtmpErrorType2 = ExternalRtmpPublishModuleCallback.RtmpErrorType.RtmpErrorType_AudioNoBuf;
            } else if (i == 3) {
                rtmpErrorType2 = ExternalRtmpPublishModuleCallback.RtmpErrorType.RtmpErrorType_VideoNoBuf;
            } else if (i == 4) {
                rtmpErrorType = ExternalRtmpPublishModuleCallback.RtmpErrorType.RtmpErrorType_LinkFailed;
                rtmpPushStatus = RtmpPullReportLogger.RtmpPushStatus.RTMP_PUSH_DISCONNECTED;
            } else {
                rtmpErrorType = ExternalRtmpPublishModuleCallback.RtmpErrorType.RtmpErrorType_LinkSuccessed;
                rtmpPushStatus = RtmpPullReportLogger.RtmpPushStatus.RTMP_PUSH_SUCCESS;
            }
            ExternalRtmpPublishModuleCallback.RtmpErrorType rtmpErrorType3 = rtmpErrorType2;
            rtmpPushStatus = rtmpPushStatus2;
            rtmpErrorType = rtmpErrorType3;
        }
        WeakReference<ExternalRtmpPublishModuleCallback> weakReference = this.mCallback;
        if (!(weakReference == null || (externalRtmpPublishModuleCallback = (ExternalRtmpPublishModuleCallback) weakReference.get()) == null)) {
            externalRtmpPublishModuleCallback.receiveRtmpStatus(rtmpErrorType);
        }
        if (this.mRtmpPullReportLogger != null) {
            if (rtmpPushStatus != RtmpPullReportLogger.RtmpPushStatus.RTMP_PUSH_UNKNOW) {
                this.mRtmpPullReportLogger.reportRtmpPushStatus(rtmpPushStatus.getValue());
            } else if (!(i == ExternalRtmpPublishModuleCallback.RtmpErrorType.RtmpErrorType_AudioNoBuf.ordinal() || i == ExternalRtmpPublishModuleCallback.RtmpErrorType.RtmpErrorType_VideoNoBuf.ordinal())) {
                this.mRtmpPullReportLogger.reportRtmpPushStatus(i);
            }
        }
        if (i != ExternalRtmpPublishModuleCallback.RtmpErrorType.RtmpErrorType_AudioNoBuf.ordinal() && i != ExternalRtmpPublishModuleCallback.RtmpErrorType.RtmpErrorType_VideoNoBuf.ordinal()) {
            GlobalHolder.getInstance().notifyCHRTMPStatus(i);
        }
    }

    private int MaxFps() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mVideoCallback;
        if (weakReference == null || weakReference.get() == null) {
            return 15;
        }
        return ((ExternalVideoModuleCallback) this.mVideoCallback.get()).maxFps();
    }

    private int MaxBitrate() {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mVideoCallback;
        if (weakReference == null || weakReference.get() == null) {
            return 400000;
        }
        return ((ExternalVideoModuleCallback) this.mVideoCallback.get()).maxBitrate();
    }

    private void ChangeEncParam(int i, int i2) {
        WeakReference<ExternalVideoModuleCallback> weakReference = this.mVideoCallback;
        if (weakReference != null && weakReference.get() != null) {
            String str = TAG;
            Log.d(str, "Change params : " + i + " | " + i2);
            if (!this.mIsPause) {
                ((ExternalVideoModuleCallback) this.mVideoCallback.get()).changeEncParam(i, i2);
            }
        }
    }

    public void setIsPause(boolean z) {
        if (!z) {
            this.mNeedIFrame = true;
        }
        this.mIsPause = z;
    }

    static {
        System.loadLibrary("rtmp");
        OmniLog.d("LOADLIBRARY", "rtmp");
    }
}
