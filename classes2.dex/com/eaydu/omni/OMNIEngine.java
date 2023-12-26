package com.eaydu.omni;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.jwt.Claim;
import com.eaydu.omni.jwt.JWT;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.eaydu.omni.listener.RtcConnectReason;
import com.eaydu.omni.log.CoreRtcLogWrite;
import com.eaydu.omni.log.LOGErrorCode;
import com.eaydu.omni.log.LOGMediaType;
import com.eaydu.omni.log.LogCommonInfo;
import com.eaydu.omni.log.LogReport;
import com.eaydu.omni.log.bean.LogAudioLocalStatistics;
import com.eaydu.omni.log.bean.LogAudioRemoteStatistics;
import com.eaydu.omni.log.bean.LogMemoryStatistics;
import com.eaydu.omni.log.bean.LogVideoLocalStatistics;
import com.eaydu.omni.log.bean.LogVideoRemoteStatistics;
import com.eaydu.omni.logger.Logger;
import com.eaydu.omni.utils.CommonUtils;
import com.eaydu.omni.utils.DataUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.igexin.assist.sdk.AssistPushConsts;
import com.wushuangtech.expansion.api.Constants;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.ChannelMediaInfo;
import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.OmniVideoFrame;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.jni.NativeInitializer;
import com.wushuangtech.wstechapi.OmniRtcChannel;
import com.wushuangtech.wstechapi.OmniRtcEngine;
import com.wushuangtech.wstechapi.OmniRtcEngineEventHandler;
import com.wushuangtech.wstechapi.bean.VideoCanvas;
import com.wushuangtech.wstechapi.bean.VideoEncoderConfiguration;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OMNIEngine extends BaseRtcEngine {
    protected static final int AUDIO_STATE_CHOPPERING_START = 1;
    protected static final int AUDIO_STATE_CHOPPERING_STOP = 2;
    private static final int ERROR_ENGINE_EMPTY = -10;
    private static final String TAG = "OMNIEngine";
    protected static final int VIDEO_STATE_CHOPPERING_START = 1;
    protected static final int VIDEO_STATE_CHOPPERING_STOP = 2;
    private static final boolean enableDataStream = true;
    /* access modifiers changed from: private */
    public static final Object gLock = new Object();
    private static final boolean useDataSteam = true;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Long, DelayObject> audioDelayMap = new ConcurrentHashMap<>();
    private CoreRtcLogWrite coreRtcLogWrite;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Long, DelayObject> delayMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public long joinRoomDelay = 0;
    /* access modifiers changed from: private */
    public long joinRoomEndTime = 0;
    /* access modifiers changed from: private */
    public long joinRoomStartTime = 0;
    /* access modifiers changed from: private */
    public long lastEngineChangeNotifyTime = 0;
    private long leaveRoomStartTime = 0;
    private String mAppid;
    /* access modifiers changed from: private */
    public RTCEngine.ContentInspectListener mContentInspectListener;
    private Context mContext;
    /* access modifiers changed from: private */
    public int mDataStreamId = 0;
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mHasEnableExternalAudio;
    private boolean mHasEnableExternalVideo;
    /* access modifiers changed from: private */
    public RTCEngine.IRTCAudioObserver mIRTCMediaAudioObserver = null;
    /* access modifiers changed from: private */
    public RTCEngine.IRTCMediaAudioProcess mIRTCMediaAudioProcess = null;
    /* access modifiers changed from: private */
    public RTCEngine.IRTCMediaVideoProcess mIRTCMediaVideoProcess = null;
    /* access modifiers changed from: private */
    public RTCEngine.IRtcEngineEventListener mListener;
    private byte[] mLocalVideoRawDataCopyArray;
    public HashMap<Integer, Long> mMetadataRecTimestampMap = new HashMap<>();
    /* access modifiers changed from: private */
    public boolean mNeedJavaLocalVideoData = true;
    /* access modifiers changed from: private */
    public boolean mNeedJavaRemoteVideoData = true;
    protected OmniRtcEngine mOMNIEngine = null;
    protected RTCEngine.RtcEngineEventObserver mObserver;
    private String mOtherRoomId = "";
    private String mPlanId;
    private boolean mRTCLocalVideoRenderMirror = true;
    private RTCEngine.RTCVideoRenderMode mRTCLocalVideoRenderMode = RTCEngine.RTCVideoRenderMode.RTCVideoRenderModeHidden;
    private boolean mRTCRemoteVideoRenderMirror = false;
    private RTCEngine.RTCVideoRenderMode mRTCRemoteVideoRenderMode = RTCEngine.RTCVideoRenderMode.RTCVideoRenderModeHidden;
    /* access modifiers changed from: private */
    public Object mRawAudioDataLock = new Object();
    /* access modifiers changed from: private */
    public Object mRawVideoDataLock = new Object();
    public HashMap<Integer, Long> mRecTimestampMap = new HashMap<>();
    /* access modifiers changed from: private */
    public String mRoomid = "";
    public long mSetTimestamp = 0;
    /* access modifiers changed from: private */
    public RTCEngine.ReportRtcStats mStatsReport = new RTCEngine.ReportRtcStats();
    final OmniRtcEngineEventHandler mTTTRtcEventHandler;
    private Object mTimestampLock = new Object();
    /* access modifiers changed from: private */
    public Object mTimestampRecLock = new Object();
    private String mToken;
    public long mUserSetTimestamp = 0;
    /* access modifiers changed from: private */
    public long mUserid;
    protected LogReport mlogReport;
    /* access modifiers changed from: private */
    public String mlostReasion = "disconnect by client";
    /* access modifiers changed from: private */
    public int mreCountNum = 0;
    /* access modifiers changed from: private */
    public long startConnectime = 0;

    public interface EngineAndChannelEachOtherListener {
        void channelUserLeaveRoom(long j, String str);
    }

    private void releaseRawData() {
    }

    private native void releaseVideoRawDataBuffer();

    private native boolean setVideoLocalRawDataBuffer(ByteBuffer byteBuffer);

    private native boolean setVideoRemoteRawDataBuffer(ByteBuffer byteBuffer);

    private native void transLocalVideoRawData(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    private native void transRemoteVideoRawData(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2);

    public int setHowlingMode(int i) {
        return 0;
    }

    static /* synthetic */ int access$708(OMNIEngine oMNIEngine) {
        int i = oMNIEngine.mreCountNum;
        oMNIEngine.mreCountNum = i + 1;
        return i;
    }

    static {
        try {
            System.loadLibrary("apm-plugin-raw-data");
        } catch (Throwable unused) {
        }
    }

    static class DelayObject {
        public long delayTime;
        public int isDelay = 0;
        public boolean isMuted;
        public String roomId;
        public long startTime;
        public long uid;

        DelayObject() {
        }
    }

    public OMNIEngine(Context context, String str, RTCEngine.IRtcEngineEventListener iRtcEngineEventListener, String str2, String str3, long j, LogReport logReport, String str4) {
        AnonymousClass2 r1 = new OmniRtcEngineEventHandler() {
            public void onStreamMessageError(int i, int i2, int i3, int i4, int i5) {
            }

            public void onFirstRemoteVideoDecoded(long j, int i, int i2, int i3) {
                Logger.i("OMNIEngine onFirstRemoteVideoDecoded " + j + " ,width = " + i + " ,height = " + i2 + " elapsed = " + i3 + " mListener:" + OMNIEngine.this.mListener + " Engine:" + OMNIEngine.this, new Object[0]);
                final long j2 = j & 4294967295L;
                if (OMNIEngine.this.mListener != null) {
                    Handler handler = OMNIEngine.this.mHandler;
                    AnonymousClass1 r10 = new Runnable() {
                        public void run() {
                            if (OMNIEngine.this.mListener != null) {
                                OMNIEngine.this.mListener.remotefirstVideoRecvWithUid(j2);
                            }
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r10);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r10);
                    }
                }
                if (OMNIEngine.this.mlogReport != null) {
                    OMNIEngine.this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, "1", (String) null, j2);
                    OMNIEngine.this.mlogReport.LogStaticRemoteVideoIn(j2, i3);
                }
            }

            public void onFirstRemoteAudioFrame(long j, int i) {
                Logger.i("OMNIEngine onFirstRemoteAudioFrame uid = " + j + " elapsed = " + i + " mListener:" + OMNIEngine.this.mListener + " Engine:" + OMNIEngine.this, new Object[0]);
                final long j2 = j & 4294967295L;
                if (OMNIEngine.this.mlogReport != null) {
                    OMNIEngine.this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, (String) null, j2);
                    OMNIEngine.this.mlogReport.LogStaticRemoteAudioIn(j2, i);
                }
                if (OMNIEngine.this.mListener != null) {
                    Handler handler = OMNIEngine.this.mHandler;
                    AnonymousClass2 r0 = new Runnable() {
                        public void run() {
                            if (OMNIEngine.this.mListener != null) {
                                OMNIEngine.this.mListener.remotefirstAudioRecvWithUid(j2);
                            }
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r0);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r0);
                    }
                }
            }

            public void onFirstLocalVideoFrame(int i, int i2, int i3) {
                Logger.i("OMNIEngine onFirstLocalVideoFrame width = " + i + " height = " + i2, new Object[0]);
                if (OMNIEngine.this.mlogReport != null) {
                    OMNIEngine.this.mlogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_VIDEO.value);
                    OMNIEngine.this.mlogReport.LogStaticLocalVideoIn(i3, i, i2);
                }
            }

            public void onFirstLocalAudioFrame(int i) {
                Logger.i("OMNIEngine onFirstLocalAudioFrame elapsed = " + i, new Object[0]);
                if (OMNIEngine.this.mlogReport != null) {
                    OMNIEngine.this.mlogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_AUDIO.value);
                    OMNIEngine.this.mlogReport.LogStaticLocalAudioIn(i);
                }
            }

            public void onUserJoined(long j, int i, int i2) {
                Logger.i("OMNIEngine onUserJoined uid = " + j + " mListener:" + OMNIEngine.this.mListener + " Engine:" + OMNIEngine.this, new Object[0]);
                long j2 = j & 4294967295L;
                if (OMNIEngine.this.mListener != null) {
                    OMNIEngine.this.mListener.remoteUserJoinWitnUid(j2);
                }
            }

            public void onClientRoleChanged(long j, int i) {
                OMNIEngine.super.onClientRoleChanged(j, i);
            }

            public void onUserOffline(long j, int i) {
                Logger.i("OMNIEngine onUserOffline uid = " + j + "reason = " + i + " mListener:" + OMNIEngine.this.mListener + " Engine:" + OMNIEngine.this, new Object[0]);
                long j2 = j & 4294967295L;
                if (OMNIEngine.this.mListener != null) {
                    OMNIEngine.this.mListener.didOfflineOfUid(j2);
                }
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.didOfflineOfUid(j2, i);
                }
                if (OMNIEngine.this.mlogReport != null) {
                    OMNIEngine.this.mlogReport.deleteUser(j2);
                }
                LogCommonInfo.getInstance().removeVolume(String.valueOf(j2));
            }

            public void onUserKicked(long j, int i, int i2) {
                Logger.i("OMNIEngine onUserKicked uid:" + j + " reason:" + i + " kickTime:" + i2, new Object[0]);
                OMNIEngine.super.onUserKicked(j, i, i2);
                if (i2 == 7200 && i == 111) {
                    Logger.i("OMNIEngine CONNECTION_CHANGED_BANNED_BY_SERVER", new Object[0]);
                    OMNIEngine.this.doEngineChangeNotify();
                }
                if (i == 105) {
                    Logger.i("OMNIEngine ERROR_KICK_BY_RELOGIN", new Object[0]);
                    if (OMNIEngine.this.mObserver != null) {
                        OMNIEngine.this.mObserver.onKick(i);
                    }
                }
            }

            public void onUserMuteVideo(long j, boolean z) {
                Logger.i("OMNIEngine onUserMuteVideo uid = " + j + "mute = " + z + " mListener:" + OMNIEngine.this.mListener + " Engine:" + OMNIEngine.this, new Object[0]);
                long j2 = j & 4294967295L;
                if (OMNIEngine.this.mListener != null) {
                    OMNIEngine.this.mListener.didVideoMuted(j2, z);
                }
            }

            public void onUserMuteAudio(long j, boolean z) {
                Logger.i("OMNIEngine onUserMuteAudio uid = " + j + "muted = " + z + " mListener:" + OMNIEngine.this.mListener + " Engine:" + OMNIEngine.this, new Object[0]);
                if (OMNIEngine.this.mListener != null) {
                    OMNIEngine.this.mListener.didAudioMuted(j, z);
                }
            }

            public void onRemoteVideoStateChanged(long j, int i, int i2, int i3) {
                Logger.i("OMNIEngine onRemoteVideoStateChanged uid = " + j + "state = " + i + " reason = " + i2 + " mListener:" + OMNIEngine.this.mListener + " Engine:" + OMNIEngine.this, new Object[0]);
                if (i != 3 && OMNIEngine.this.mListener != null) {
                    OMNIEngine.this.mListener.onRemoteVideoStateChanged(j, i);
                }
            }

            public void onRtcStats(RtcStats rtcStats) {
                if (OMNIEngine.this.mlogReport != null) {
                    OMNIEngine.this.mlogReport.LogLocalAudioSentBps(rtcStats.txAudioKBitRate);
                    OMNIEngine.this.mlogReport.LogStatistics(rtcStats.lastmileDelay);
                    OMNIEngine.this.mlogReport.setGateWayRttAndAppCpu(rtcStats.gatewayRtt, (int) (rtcStats.cpuAppUsage * 100.0d));
                    LogMemoryStatistics logMemoryStatistics = new LogMemoryStatistics();
                    logMemoryStatistics.memoryAppUsageInKbytes = rtcStats.memoryAppUsageInKbytes;
                    logMemoryStatistics.memoryAppUsageRatio = rtcStats.memoryAppUsageRatio;
                    logMemoryStatistics.memoryTotalUsageRatio = rtcStats.memoryTotalUsageRatio;
                    OMNIEngine.this.mlogReport.LogStatisticsMemoryStats(logMemoryStatistics);
                }
                if (OMNIEngine.this.mListener != null) {
                    OMNIEngine.this.mStatsReport.txAudioBytes = rtcStats.txAudioBytes;
                    OMNIEngine.this.mStatsReport.txVideoBytes = rtcStats.txVideoBytes;
                    OMNIEngine.this.mStatsReport.rxAudioBytes = rtcStats.rxAudioBytes;
                    OMNIEngine.this.mStatsReport.rxVideoBytes = rtcStats.rxVideoBytes;
                    OMNIEngine.this.mStatsReport.txAudioKBitRate = rtcStats.txAudioKBitRate;
                    OMNIEngine.this.mStatsReport.txVideoKBitRate = rtcStats.txVideoKBitRate;
                    OMNIEngine.this.mStatsReport.rxAudioKBitRate = rtcStats.rxAudioKBitRate;
                    OMNIEngine.this.mStatsReport.rxVideoKBitRate = rtcStats.rxVideoKBitRate;
                    OMNIEngine.this.mStatsReport.cpuAppUsage = rtcStats.cpuAppUsage;
                    OMNIEngine.this.mStatsReport.cpuTotalUsage = rtcStats.cpuTotalUsage;
                    OMNIEngine.this.mStatsReport.txPacketsLostRate = (double) rtcStats.txPacketLossRate;
                    OMNIEngine.this.mStatsReport.rxPacketsLostRate = (double) rtcStats.rxPacketLossRate;
                    OMNIEngine.this.mStatsReport.lastmileDelay = rtcStats.lastmileDelay;
                    OMNIEngine.this.mStatsReport.gateWayRtt = rtcStats.gatewayRtt;
                    OMNIEngine.this.mListener.reportRtcStats(OMNIEngine.this.mStatsReport);
                }
            }

            public void onRemoteVideoStats(RemoteVideoStats remoteVideoStats) {
                if (OMNIEngine.this.mObserver != null) {
                    RTCEngine.RemoteVideoStats remoteVideoStats2 = new RTCEngine.RemoteVideoStats();
                    remoteVideoStats2.uid = remoteVideoStats.uid;
                    remoteVideoStats2.decoderOutputFrameRate = remoteVideoStats.decoderOutputFrameRate;
                    remoteVideoStats2.height = remoteVideoStats.height;
                    remoteVideoStats2.width = remoteVideoStats.width;
                    remoteVideoStats2.rendererOutputFrameRate = remoteVideoStats.rendererOutputFrameRate;
                    remoteVideoStats2.packetLossRate = remoteVideoStats.packetLossRate;
                    remoteVideoStats2.receivedBitrate = remoteVideoStats.receivedBitrate;
                    remoteVideoStats2.avDiff = remoteVideoStats.avDiff;
                    remoteVideoStats2.rtt = remoteVideoStats.rtt;
                    OMNIEngine.this.mObserver.onRemoteVideoStats(remoteVideoStats2);
                }
                if (OMNIEngine.this.mlogReport != null) {
                    LogVideoRemoteStatistics logVideoRemoteStatistics = new LogVideoRemoteStatistics();
                    logVideoRemoteStatistics.uid = remoteVideoStats.uid;
                    logVideoRemoteStatistics.width = remoteVideoStats.width;
                    logVideoRemoteStatistics.height = remoteVideoStats.height;
                    logVideoRemoteStatistics.receivedBitrate = remoteVideoStats.receivedBitrate;
                    logVideoRemoteStatistics.decoderOutputFrameRate = remoteVideoStats.decoderOutputFrameRate;
                    logVideoRemoteStatistics.latency = remoteVideoStats.latency;
                    logVideoRemoteStatistics.avDiff = remoteVideoStats.avDiff;
                    logVideoRemoteStatistics.delay = remoteVideoStats.delay;
                    logVideoRemoteStatistics.packetLossRate = remoteVideoStats.packetLossRate;
                    logVideoRemoteStatistics.vJitter = remoteVideoStats.jitter;
                    logVideoRemoteStatistics.vDecodeDur = remoteVideoStats.decodeDur;
                    logVideoRemoteStatistics.vRtt = remoteVideoStats.rtt;
                    OMNIEngine.this.mlogReport.LogStaticRemoteVideoStats(logVideoRemoteStatistics);
                    OMNIEngine.this.mlogReport.LogStaticRemoteVideoTransportStats(logVideoRemoteStatistics);
                }
            }

            public void onLocalVideoStats(LocalVideoStats localVideoStats) {
                if (OMNIEngine.this.mObserver != null) {
                    RTCEngine.LocalVideoStats localVideoStats2 = new RTCEngine.LocalVideoStats();
                    localVideoStats2.captureFrameRate = localVideoStats.sentFrameRate;
                    localVideoStats2.sentBitrate = localVideoStats.sentBitrate;
                    localVideoStats2.sentFrameRate = localVideoStats.sentFrameRate;
                    localVideoStats2.targetBitrate = localVideoStats.videoTargetBps;
                    localVideoStats2.targetFrameRate = localVideoStats.videoTargetFps;
                    localVideoStats2.encodedBitrate = localVideoStats.sentBitrate;
                    localVideoStats2.encodedFrameWidth = localVideoStats.encodedFrameWidth;
                    localVideoStats2.encodedFrameHeight = localVideoStats.encodedFrameHeight;
                    localVideoStats2.packetLossRate = localVideoStats.txPacketLossRate;
                    localVideoStats2.rtt = localVideoStats.rtt;
                    OMNIEngine.this.mObserver.onLocalVideoStats(localVideoStats2);
                }
                if (OMNIEngine.this.mlogReport != null) {
                    LogVideoLocalStatistics logVideoLocalStatistics = new LogVideoLocalStatistics();
                    logVideoLocalStatistics.sentBitrate = localVideoStats.sentBitrate;
                    logVideoLocalStatistics.videoTargetBps = localVideoStats.videoTargetBps;
                    logVideoLocalStatistics.sentFrameRate = localVideoStats.sentFrameRate;
                    logVideoLocalStatistics.videoTargetFps = localVideoStats.videoTargetFps;
                    logVideoLocalStatistics.videoEncoded = localVideoStats.sentFrameRate;
                    logVideoLocalStatistics.mVideoLossRate = localVideoStats.txPacketLossRate;
                    logVideoLocalStatistics.vRtt = localVideoStats.rtt;
                    logVideoLocalStatistics.encodedFrameWidth = localVideoStats.encodedFrameWidth;
                    logVideoLocalStatistics.encodedFrameHeight = localVideoStats.encodedFrameHeight;
                    logVideoLocalStatistics.uid = OMNIEngine.this.mUserid;
                    LogCommonInfo.getInstance().LogStaticLocalVideoStats(String.valueOf(OMNIEngine.this.mUserid), logVideoLocalStatistics);
                }
            }

            public void onLocalAudioStats(LocalAudioStats localAudioStats) {
                OMNIEngine.super.onLocalAudioStats(localAudioStats);
                if (OMNIEngine.this.mObserver != null) {
                    RTCEngine.LocalAudioStats localAudioStats2 = new RTCEngine.LocalAudioStats();
                    localAudioStats2.numChannels = localAudioStats.numChannels;
                    localAudioStats2.sentSampleRate = localAudioStats.sentSampleRate;
                    localAudioStats2.sentBitrate = localAudioStats.sentBitrate;
                    localAudioStats2.txPacketLossRate = localAudioStats.txPacketLossRate;
                    localAudioStats2.audioFps = localAudioStats.audioEncodeFps;
                    localAudioStats2.rtt = localAudioStats.rtt;
                    OMNIEngine.this.mObserver.onLocalAudioStats(localAudioStats2);
                }
                if (OMNIEngine.this.mlogReport != null) {
                    LogAudioLocalStatistics logAudioLocalStatistics = new LogAudioLocalStatistics();
                    logAudioLocalStatistics.audioLossRate = localAudioStats.txPacketLossRate;
                    logAudioLocalStatistics.sentBitrate = localAudioStats.sentBitrate;
                    logAudioLocalStatistics.aRtt = localAudioStats.rtt;
                    logAudioLocalStatistics.uid = OMNIEngine.this.mUserid;
                    LogCommonInfo.getInstance().LogStaticLocalAudioStats(String.valueOf(OMNIEngine.this.mUserid), logAudioLocalStatistics);
                }
            }

            public void onRemoteAudioStats(RemoteAudioStats remoteAudioStats) {
                OMNIEngine.super.onRemoteAudioStats(remoteAudioStats);
                if (OMNIEngine.this.mlogReport != null) {
                    LogAudioRemoteStatistics logAudioRemoteStatistics = new LogAudioRemoteStatistics();
                    logAudioRemoteStatistics.uid = remoteAudioStats.uid;
                    logAudioRemoteStatistics.jitterBufferDelay = remoteAudioStats.jitterBufferDelay;
                    logAudioRemoteStatistics.audioLossRate = remoteAudioStats.audioLossRate;
                    logAudioRemoteStatistics.receivedBitrate = remoteAudioStats.receivedBitrate;
                    logAudioRemoteStatistics.audioVolume = remoteAudioStats.audioVolume;
                    logAudioRemoteStatistics.audioDecFps = remoteAudioStats.audioDecFps;
                    logAudioRemoteStatistics.aJitter = remoteAudioStats.jitter;
                    logAudioRemoteStatistics.aDecodeDur = remoteAudioStats.decodeDur;
                    logAudioRemoteStatistics.aRtt = remoteAudioStats.rtt;
                    OMNIEngine.this.mlogReport.LogStaticRemoteAudioStats(logAudioRemoteStatistics);
                }
                if (OMNIEngine.this.mObserver != null) {
                    RTCEngine.RemoteAudioStats remoteAudioStats2 = new RTCEngine.RemoteAudioStats();
                    remoteAudioStats2.uid = remoteAudioStats.uid;
                    remoteAudioStats2.audioLossRate = remoteAudioStats.audioLossRate;
                    remoteAudioStats2.numChannels = remoteAudioStats.numChannels;
                    remoteAudioStats2.receivedSampleRate = remoteAudioStats.sampleRate;
                    remoteAudioStats2.receivedBitrate = remoteAudioStats.receivedBitrate;
                    remoteAudioStats2.audioFps = remoteAudioStats.audioDecFps;
                    remoteAudioStats2.avDiff = remoteAudioStats.avDiff;
                    remoteAudioStats2.rtt = remoteAudioStats.rtt;
                    OMNIEngine.this.mObserver.onRemoteAudioStats(remoteAudioStats2);
                }
                if (OMNIEngine.this.mObserver != null) {
                    RTCEngine.RTCAudioStats rTCAudioStats = new RTCEngine.RTCAudioStats();
                    rTCAudioStats.uid = (int) remoteAudioStats.uid;
                    rTCAudioStats.audioLossRate = remoteAudioStats.audioLossRate;
                    rTCAudioStats.jitterBufferDelay = remoteAudioStats.jitterBufferDelay;
                    OMNIEngine.this.mObserver.onAudioStats(rTCAudioStats);
                }
            }

            public void onAudioVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i) {
                if (audioVolumeInfoArr != null) {
                    for (AudioVolumeInfo audioVolumeInfo : audioVolumeInfoArr) {
                        if (OMNIEngine.this.mObserver != null) {
                            OMNIEngine.this.mObserver.reportAudioVolumeOfSpeaker(audioVolumeInfo.mChannelId, audioVolumeInfo.mUid & 4294967295L, audioVolumeInfo.mVolume);
                        }
                        if (OMNIEngine.this.mListener != null) {
                            OMNIEngine.this.mListener.reportAudioVolumeOfSpeaker(audioVolumeInfo.mUid & 4294967295L, audioVolumeInfo.mVolume);
                        }
                        if (OMNIEngine.this.mlogReport != null) {
                            OMNIEngine.this.mlogReport.LogStaticUserAudioVolume(audioVolumeInfo.mUid & 4294967295L, audioVolumeInfo.mVolume);
                        }
                        LogCommonInfo.getInstance().updateVolume(String.valueOf(4294967295L & audioVolumeInfo.mUid), audioVolumeInfo.mVolume);
                    }
                }
            }

            public void onLeaveChannel(RtcStats rtcStats) {
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onLeaveChannel();
                }
            }

            public void onLastmileQuality(int i) {
                if (OMNIEngine.this.mListener != null) {
                    OMNIEngine.this.mListener.onOnceLastMileQuality(RTCEngine.RTC_LASTMILE_QUALITY.values()[i]);
                }
            }

            public void onError(int i) {
                Logger.i("OMNIEngine onError " + i, new Object[0]);
                if (OMNIEngine.this.mListener != null) {
                    if (i == 110) {
                        OMNIEngine.this.mListener.didOccurError(RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeInvalidToken);
                    } else if (i == 170001) {
                        OMNIEngine.this.mListener.didOccurError(RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeTokenExpired);
                    }
                }
            }

            public void onRtcLogReport(int i, String str) {
                OMNIEngine.this.handleSdkLog(i, str);
            }

            public void onCameraConnectError(int i) {
                OMNIEngine.super.onCameraConnectError(i);
                Logger.i("OMNIEngine onCameraConnectError errorType = " + i, new Object[0]);
                if (OMNIEngine.this.mListener != null) {
                    OMNIEngine.this.mListener.didOccurError(RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeStartCamera);
                }
            }

            public void onStreamMessage(long j, int i, byte[] bArr) {
                if (bArr != null) {
                    if (bArr.length == 24 && CommonUtils.isTSMsg(bArr)) {
                        synchronized (OMNIEngine.this.mTimestampRecLock) {
                            int i2 = (int) j;
                            OMNIEngine.this.mMetadataRecTimestampMap.put(Integer.valueOf(i2), Long.valueOf(DataUtils.longFrom8Bytes(bArr, 16, false)));
                            OMNIEngine.this.mRecTimestampMap.put(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
                        }
                    } else if (bArr.length > 24 && CommonUtils.isIRCMsg(bArr)) {
                        int length = bArr.length - 24;
                        byte[] bArr2 = new byte[length];
                        System.arraycopy(bArr, 24, bArr2, 0, length);
                        if (OMNIEngine.this.mObserver != null) {
                            OMNIEngine.this.mObserver.onStreamMessage(j, bArr2);
                        }
                    }
                }
            }

            public void onConnectionStateChanged(int i, int i2) {
                String str;
                int i3 = i;
                final int i4 = i2;
                Logger.i("OMNIEngine onConnectionStateChanged state = " + i3 + "reason = " + i4, new Object[0]);
                if (OMNIEngine.this.mListener != null) {
                    String str2 = "rejected_by_server";
                    if (i3 == 1) {
                        Handler handler = OMNIEngine.this.mHandler;
                        String str3 = "keep_alive_timeout";
                        AnonymousClass3 r5 = new Runnable() {
                            public void run() {
                                if (OMNIEngine.this.mListener != null) {
                                    OMNIEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeDisconnected, RtcConnectReason.getReason(i4));
                                }
                            }
                        };
                        String str4 = "client_ip_address_changed";
                        if (!(handler instanceof Handler)) {
                            handler.post(r5);
                        } else {
                            AsynchronousInstrumentation.handlerPost(handler, r5);
                        }
                        if (OMNIEngine.this.mlogReport != null) {
                            switch (i4) {
                                case 3:
                                    str2 = "banned_by_server";
                                    break;
                                case 4:
                                    str2 = "join_failed";
                                    break;
                                case 5:
                                    str2 = "leave_channel";
                                    break;
                                case 6:
                                    str2 = "invalid_app_id";
                                    break;
                                case 7:
                                    str2 = "invalid_channel_name";
                                    break;
                                case 8:
                                    str2 = "invalid_token";
                                    break;
                                case 9:
                                    str2 = "token_expired";
                                    break;
                                case 10:
                                    break;
                                case 11:
                                    str2 = "setting_proxy_server";
                                    break;
                                case 12:
                                    str2 = "renew_token";
                                    break;
                                case 13:
                                    str2 = str4;
                                    break;
                                case 14:
                                    str2 = str3;
                                    break;
                                default:
                                    str2 = RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedInterrupted;
                                    break;
                            }
                            OMNIEngine.this.mlogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ, str2, -1);
                            OMNIEngine.this.mlogReport.roomDisconnect(OMNIEngine.this.mRoomid, OMNIEngine.this.mUserid, LOGErrorCode.LOG_Disconnected.value, OMNIEngine.this.mlostReasion);
                        }
                    } else if (i3 == 2) {
                        long unused = OMNIEngine.this.startConnectime = System.currentTimeMillis();
                        if (OMNIEngine.this.mlogReport != null) {
                            OMNIEngine.this.mlogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedConnecting, -1);
                        }
                        OMNIEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeConnecting, RtcConnectReason.getReason(i2));
                    } else if (i3 == 3) {
                        if (OMNIEngine.this.mlogReport != null) {
                            OMNIEngine.this.mlogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, i4 != 15 ? i4 != 16 ? FirebaseAnalytics.Param.SUCCESS : "video_switch_server" : "audio_switch_server", -1);
                        }
                        Handler handler2 = OMNIEngine.this.mHandler;
                        AnonymousClass4 r52 = new Runnable() {
                            public void run() {
                                if (OMNIEngine.this.mListener != null) {
                                    OMNIEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeConnected, RtcConnectReason.getReason(i4));
                                }
                            }
                        };
                        if (!(handler2 instanceof Handler)) {
                            handler2.post(r52);
                        } else {
                            AsynchronousInstrumentation.handlerPost(handler2, r52);
                        }
                        if (OMNIEngine.this.mlogReport != null) {
                            OMNIEngine.this.mlogReport.roomReconnect(OMNIEngine.this.mRoomid, OMNIEngine.this.mUserid, LOGErrorCode.LOG_Success.value, OMNIEngine.this.startConnectime, System.currentTimeMillis(), OMNIEngine.this.mreCountNum);
                        }
                        int unused2 = OMNIEngine.this.mreCountNum = 0;
                    } else if (i3 == 4) {
                        OMNIEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeReconnecting, RtcConnectReason.getReason(i2));
                        OMNIEngine.access$708(OMNIEngine.this);
                    } else if (i3 == 5) {
                        switch (i4) {
                            case 3:
                                str = "banned_by_server";
                                break;
                            case 4:
                                str = "join_failed";
                                break;
                            case 5:
                                str = "leave_channel";
                                break;
                            case 6:
                                str = "invalid_app_id";
                                break;
                            case 7:
                                str = "invalid_channel_name";
                                break;
                            case 8:
                                str = "invalid_token";
                                break;
                            case 9:
                                str = "token_expired";
                                break;
                            case 10:
                                str = str2;
                                break;
                            case 11:
                                str = "setting_proxy_server";
                                break;
                            case 12:
                                str = "renew_token";
                                break;
                            case 13:
                                str = "client_ip_address_changed";
                                break;
                            case 14:
                                str = "keep_alive_timeout";
                                break;
                            default:
                                str = "";
                                break;
                        }
                        if (OMNIEngine.this.mlogReport != null) {
                            OMNIEngine.this.mlogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_OPPO, str, -1);
                        }
                        OMNIEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeFailed, RtcConnectReason.getReason(i2));
                    }
                    switch (i4) {
                        case 4:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            if (OMNIEngine.this.mlogReport != null) {
                                OMNIEngine.this.mlogReport.sendCommonError("engineError", OMNIEngine.this.mRoomid, i3 + " " + i4 + "", i4 + "");
                                OMNIEngine.this.mlogReport.joinRoom(0, OMNIEngine.this.mlogReport.getmUserid(), LOGErrorCode.LOG_Fail.value, "joined room fail", 0);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }

            public void onConnectionLost() {
                Logger.i("OMNIEngine onConnectionLost ", new Object[0]);
                if (OMNIEngine.this.mListener != null) {
                    Handler handler = OMNIEngine.this.mHandler;
                    AnonymousClass5 r1 = new Runnable() {
                        public void run() {
                            if (OMNIEngine.this.mListener != null) {
                                OMNIEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeDisconnected, "");
                            }
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r1);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r1);
                    }
                }
                if (OMNIEngine.this.mlogReport != null) {
                    OMNIEngine.this.mlogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ, RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedInterrupted, -1);
                    OMNIEngine.this.mlogReport.roomDisconnect(OMNIEngine.this.mRoomid, OMNIEngine.this.mUserid, LOGErrorCode.LOG_Disconnected.value, OMNIEngine.this.mlostReasion);
                }
            }

            public void onJoinChannelSuccess(String str, long j, int i) {
                String channelSessionId = OMNIEngine.this.mOMNIEngine.getChannelSessionId();
                Logger.i("OMNIEngine onJoinChannelSuccess channel=" + str + ", uid=" + j + ", sessionId=" + channelSessionId + ", elapsed=" + i, new Object[0]);
                Handler handler = OMNIEngine.this.mHandler;
                AnonymousClass6 r1 = new Runnable() {
                    public void run() {
                        synchronized (OMNIEngine.gLock) {
                            if (OMNIEngine.this.mOMNIEngine != null) {
                                int unused = OMNIEngine.this.mDataStreamId = OMNIEngine.this.mOMNIEngine.createDataStream(false, false);
                            }
                        }
                    }
                };
                if (!(handler instanceof Handler)) {
                    handler.post(r1);
                } else {
                    AsynchronousInstrumentation.handlerPost(handler, r1);
                }
                final long j2 = j & 4294967295L;
                if (OMNIEngine.this.mListener != null) {
                    Handler handler2 = OMNIEngine.this.mHandler;
                    AnonymousClass7 r12 = new Runnable() {
                        public void run() {
                            if (OMNIEngine.this.mListener != null) {
                                OMNIEngine.this.mListener.localUserJoindWithUid(j2);
                            }
                        }
                    };
                    if (!(handler2 instanceof Handler)) {
                        handler2.post(r12);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler2, r12);
                    }
                }
                long unused = OMNIEngine.this.joinRoomEndTime = System.currentTimeMillis();
                OMNIEngine oMNIEngine = OMNIEngine.this;
                long unused2 = oMNIEngine.joinRoomDelay = oMNIEngine.joinRoomEndTime - OMNIEngine.this.joinRoomStartTime;
                if (OMNIEngine.this.mlogReport != null) {
                    OMNIEngine.this.mlogReport.setSessionId(channelSessionId);
                    OMNIEngine.this.mlogReport.joinRoom(i, j2, LOGErrorCode.LOG_Success.value, "joined room successfully", 0);
                }
            }

            public void onRejoinChannelSuccess(String str, long j, int i) {
                String channelSessionId = OMNIEngine.this.mOMNIEngine.getChannelSessionId();
                Logger.i("OMNIEngine onRejoinChannelSuccess channel=" + str + ", uid=" + j + ", sessionId=" + channelSessionId + ", elapsed=" + i, new Object[0]);
                final long j2 = j & 4294967295L;
                if (OMNIEngine.this.mListener != null) {
                    Handler handler = OMNIEngine.this.mHandler;
                    AnonymousClass8 r12 = new Runnable() {
                        public void run() {
                            if (OMNIEngine.this.mListener != null) {
                                OMNIEngine.this.mListener.localUserJoindWithUid(j2);
                            }
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r12);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r12);
                    }
                }
                if (OMNIEngine.this.mlogReport != null) {
                    OMNIEngine.this.mlogReport.setSessionId(channelSessionId);
                    OMNIEngine.this.mlogReport.joinRoom(i, j2, LOGErrorCode.LOG_Success.value, "ReJoined room successfully", 1);
                }
            }

            public void onVideoPublishStateChanged(int i, int i2, int i3) {
                Logger.i("OMNIEngine onPublishVideoStateChanged room: " + OMNIEngine.this.mRoomid + ", oldState: " + i + ", newState: " + i2 + ", elapsed: " + i3, new Object[0]);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onPublishVideoStateChanged(i, i2);
                }
                if (i != 2 || i2 != 3) {
                    OMNIEngine.this.mlogReport.setVideoPublished(false);
                } else if (OMNIEngine.this.mlogReport != null) {
                    OMNIEngine.this.mlogReport.LogStaticLocalVideoIn(i3, 0, 0);
                    OMNIEngine.this.mlogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_VIDEO.value);
                    OMNIEngine.this.mlogReport.setVideoPublished(true);
                }
            }

            public void onAudioPublishStateChanged(int i, int i2, int i3) {
                Logger.i("OMNIEngine onPublishAudioStateChanged room: " + OMNIEngine.this.mRoomid + ", oldState: " + i + ", newState: " + i2 + ", elapsed: " + i3, new Object[0]);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onPublishAudioStateChanged(i, i2);
                }
                if (i == 2 && i2 == 3) {
                    OMNIEngine.this.mlogReport.LogStaticLocalAudioIn(i3);
                    OMNIEngine.this.mlogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_AUDIO.value);
                    OMNIEngine.this.mlogReport.setAudioPublished(true);
                    return;
                }
                OMNIEngine.this.mlogReport.setAudioPublished(false);
            }

            public void onVideoSubscribeStateChanged(long j, int i, int i2, int i3) {
                long j2 = 4294967295L & j;
                Logger.i("OMNIEngine onSubscribeVideoStateChanged room: " + OMNIEngine.this.mRoomid + ", uid: " + j2 + ", oldState: " + i + ", newState: " + i2 + ", elapsed: " + i3, new Object[0]);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onSubscribeVideoStateChanged((int) j, i, i2);
                }
                if (i == 2 && i2 == 3) {
                    OMNIEngine.this.mlogReport.LogStaticRemoteVideoIn(j2, i3);
                }
            }

            public void onAudioSubscribeStateChanged(long j, int i, int i2, int i3) {
                long j2 = 4294967295L & j;
                Logger.i("OMNIEngine onSubscribeAudioStateChanged room: " + OMNIEngine.this.mRoomid + ", uid: " + j2 + ", oldState: " + i + ", newState: " + i2 + ", elapsed: " + i3, new Object[0]);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onSubscribeAudioStateChanged((int) j, i, i2);
                }
                if (i == 2 && i2 == 3) {
                    OMNIEngine.this.mlogReport.LogStaticRemoteAudioIn(j2, i3);
                }
            }

            public void onWarning(int i) {
                Logger.w("OMNIEngine onWarning " + i, new Object[0]);
            }

            public byte[] onLocalAudioDataReport(byte[] bArr, int i, int i2, int i3) {
                if (OMNIEngine.this.mIRTCMediaAudioProcess == null) {
                    return null;
                }
                RTCEngine.RTCAudioData rTCAudioData = new RTCEngine.RTCAudioData();
                rTCAudioData.buffer = bArr;
                rTCAudioData.bufferLength = i;
                rTCAudioData.bytesPerSample = 2;
                rTCAudioData.channels = i3;
                rTCAudioData.renderTimeMs = 0;
                rTCAudioData.samplesPerSec = i2;
                rTCAudioData.samples = (i / i3) / 2;
                synchronized (OMNIEngine.this.mRawAudioDataLock) {
                    if (OMNIEngine.this.mIRTCMediaAudioProcess != null) {
                        OMNIEngine.this.mIRTCMediaAudioProcess.didCapturedAuidoData(rTCAudioData);
                    }
                }
                return null;
            }

            public byte[] onRemoteAudioDataReport(byte[] bArr, int i, int i2, int i3) {
                RTCEngine.IRTCAudioObserver access$1500 = OMNIEngine.this.mIRTCMediaAudioObserver;
                if (access$1500 == null) {
                    return OMNIEngine.super.onRemoteAudioDataReport(bArr, i, i2, i3);
                }
                RTCEngine.RTCPlayBackAudioFrame rTCPlayBackAudioFrame = new RTCEngine.RTCPlayBackAudioFrame();
                rTCPlayBackAudioFrame.buffer = bArr;
                rTCPlayBackAudioFrame.bufferLength = i;
                rTCPlayBackAudioFrame.bytesPerSample = 2;
                rTCPlayBackAudioFrame.channels = i3;
                rTCPlayBackAudioFrame.renderTimeMs = 0;
                rTCPlayBackAudioFrame.samplesPerSec = -1;
                rTCPlayBackAudioFrame.samples = i2;
                access$1500.onPlaybackAudioData(rTCPlayBackAudioFrame);
                return bArr;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
                r0 = new com.eaydu.omni.RTCEngine.RTCVideoData();
                r0.data = r15;
                r0.width = r17;
                r0.height = r18;
                r0.yStride = r20;
                r0.uStride = r21;
                r0.vStride = r22;
                r0.rotation = r23;
                r0.renderTimeMs = r24;
                r4 = com.eaydu.omni.OMNIEngine.access$1800(r1.this$0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
                monitor-enter(r4);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
                if (com.eaydu.omni.OMNIEngine.access$1700(r1.this$0) == null) goto L_0x005e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
                com.eaydu.omni.OMNIEngine.access$1700(r1.this$0).didCapturedVideoData(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x005e, code lost:
                monitor-exit(r4);
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onCaptureVideoFrame(byte[] r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24) {
                /*
                    r14 = this;
                    r1 = r14
                    com.eaydu.omni.OMNIEngine.super.onCaptureVideoFrame(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                    com.eaydu.omni.OMNIEngine r0 = com.eaydu.omni.OMNIEngine.this
                    boolean r0 = r0.mNeedJavaLocalVideoData
                    if (r0 == 0) goto L_0x0066
                    com.eaydu.omni.OMNIEngine r0 = com.eaydu.omni.OMNIEngine.this
                    com.eaydu.omni.RTCEngine$IRTCMediaVideoProcess r0 = r0.mIRTCMediaVideoProcess
                    if (r0 == 0) goto L_0x0066
                    java.lang.Object r2 = com.eaydu.omni.OMNIEngine.gLock
                    monitor-enter(r2)
                    com.eaydu.omni.OMNIEngine r0 = com.eaydu.omni.OMNIEngine.this     // Catch:{ all -> 0x0063 }
                    com.wushuangtech.wstechapi.OmniRtcEngine r0 = r0.mOMNIEngine     // Catch:{ all -> 0x0063 }
                    if (r0 != 0) goto L_0x0021
                    monitor-exit(r2)     // Catch:{ all -> 0x0063 }
                    return
                L_0x0021:
                    monitor-exit(r2)     // Catch:{ all -> 0x0063 }
                    com.eaydu.omni.RTCEngine$RTCVideoData r0 = new com.eaydu.omni.RTCEngine$RTCVideoData
                    r0.<init>()
                    r3 = r15
                    r0.data = r3
                    r5 = r17
                    r0.width = r5
                    r6 = r18
                    r0.height = r6
                    r8 = r20
                    r0.yStride = r8
                    r9 = r21
                    r0.uStride = r9
                    r10 = r22
                    r0.vStride = r10
                    r11 = r23
                    r0.rotation = r11
                    r12 = r24
                    r0.renderTimeMs = r12
                    com.eaydu.omni.OMNIEngine r2 = com.eaydu.omni.OMNIEngine.this
                    java.lang.Object r4 = r2.mRawVideoDataLock
                    monitor-enter(r4)
                    com.eaydu.omni.OMNIEngine r2 = com.eaydu.omni.OMNIEngine.this     // Catch:{ all -> 0x0060 }
                    com.eaydu.omni.RTCEngine$IRTCMediaVideoProcess r2 = r2.mIRTCMediaVideoProcess     // Catch:{ all -> 0x0060 }
                    if (r2 == 0) goto L_0x005e
                    com.eaydu.omni.OMNIEngine r2 = com.eaydu.omni.OMNIEngine.this     // Catch:{ all -> 0x0060 }
                    com.eaydu.omni.RTCEngine$IRTCMediaVideoProcess r2 = r2.mIRTCMediaVideoProcess     // Catch:{ all -> 0x0060 }
                    r2.didCapturedVideoData(r0)     // Catch:{ all -> 0x0060 }
                L_0x005e:
                    monitor-exit(r4)     // Catch:{ all -> 0x0060 }
                    goto L_0x0075
                L_0x0060:
                    r0 = move-exception
                    monitor-exit(r4)     // Catch:{ all -> 0x0060 }
                    throw r0
                L_0x0063:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x0063 }
                    throw r0
                L_0x0066:
                    r3 = r15
                    r5 = r17
                    r6 = r18
                    r8 = r20
                    r9 = r21
                    r10 = r22
                    r11 = r23
                    r12 = r24
                L_0x0075:
                    com.eaydu.omni.OMNIEngine r2 = com.eaydu.omni.OMNIEngine.this
                    r3 = r15
                    r4 = r16
                    r5 = r17
                    r6 = r18
                    r7 = r19
                    r8 = r20
                    r9 = r21
                    r10 = r22
                    r11 = r23
                    r12 = r24
                    r2.pushVideoLocalRawData(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.OMNIEngine.AnonymousClass2.onCaptureVideoFrame(byte[], int, int, int, int, int, int, int, int, long):void");
            }

            public void onRenderVideoFrame(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2) {
                if (OMNIEngine.this.mNeedJavaRemoteVideoData) {
                    long j3 = j & 4294967295L;
                    if (OMNIEngine.this.mIRTCMediaVideoProcess != null) {
                        RTCEngine.RTCVideoData rTCVideoData = new RTCEngine.RTCVideoData();
                        rTCVideoData.data = bArr;
                        rTCVideoData.width = i2;
                        rTCVideoData.height = i3;
                        rTCVideoData.yStride = i5;
                        rTCVideoData.uStride = i6;
                        rTCVideoData.vStride = i7;
                        rTCVideoData.rotation = i8;
                        rTCVideoData.renderTimeMs = j2;
                        synchronized (OMNIEngine.this.mRawVideoDataLock) {
                            if (OMNIEngine.this.mIRTCMediaVideoProcess != null) {
                                OMNIEngine.this.mIRTCMediaVideoProcess.didRenderVideoData(j3, rTCVideoData);
                            }
                        }
                        OMNIEngine.this.pushVideoRemoteRawData(j, bArr, i, i2, i3, i4, i5, i6, i7, i8, j2);
                    }
                }
                byte[] bArr2 = bArr;
                int i9 = i2;
                int i10 = i3;
                int i11 = i5;
                int i12 = i6;
                int i13 = i7;
                int i14 = i8;
                long j4 = j2;
                OMNIEngine.this.pushVideoRemoteRawData(j, bArr, i, i2, i3, i4, i5, i6, i7, i8, j2);
            }

            public void onVideoBufferingStateChanged(long j, int i, long j2) {
                Logger.i("OMNIEngine onVideoBufferingStateChanged " + j + " " + i + " " + j2 + " " + System.currentTimeMillis(), new Object[0]);
                if (i == 0) {
                    DelayObject delayObject = (DelayObject) OMNIEngine.this.delayMap.get(Long.valueOf(j));
                    if (delayObject == null) {
                        DelayObject delayObject2 = new DelayObject();
                        delayObject2.isDelay = 1;
                        delayObject2.uid = j;
                        delayObject2.roomId = OMNIEngine.this.mRoomid;
                        delayObject2.startTime = j2;
                        OMNIEngine.this.delayMap.put(Long.valueOf(j), delayObject2);
                    } else {
                        delayObject.startTime = j2;
                    }
                    OMNIEngine oMNIEngine = OMNIEngine.this;
                    oMNIEngine.renderDelayStart(j, ((DelayObject) oMNIEngine.delayMap.get(Long.valueOf(j))).startTime, OMNIEngine.this.mRoomid);
                } else if (i == 1) {
                    OMNIEngine.this.doRenderEnd(j, j2);
                }
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onVideoBufferingStateChanged(j, i, j2);
                }
            }

            public void onAudioBufferingStateChanged(long j, int i, long j2) {
                Logger.i("OMNIEngine onAudioBufferingStateChanged " + j + " " + i + " " + j2 + " " + System.currentTimeMillis(), new Object[0]);
                if (i == 0) {
                    DelayObject delayObject = (DelayObject) OMNIEngine.this.audioDelayMap.get(Long.valueOf(j));
                    if (delayObject == null) {
                        DelayObject delayObject2 = new DelayObject();
                        delayObject2.isDelay = 1;
                        delayObject2.uid = j;
                        delayObject2.roomId = OMNIEngine.this.mRoomid;
                        delayObject2.startTime = j2;
                        OMNIEngine.this.audioDelayMap.put(Long.valueOf(j), delayObject2);
                    } else {
                        delayObject.startTime = j2;
                    }
                    OMNIEngine oMNIEngine = OMNIEngine.this;
                    oMNIEngine.audioRenderDelayStart(j, ((DelayObject) oMNIEngine.audioDelayMap.get(Long.valueOf(j))).startTime, OMNIEngine.this.mRoomid);
                } else if (i == 1) {
                    OMNIEngine.this.doAudioRenderEnd(j, j2);
                }
            }

            public void onLocalAudioStateChanged(int i, int i2) {
                OMNIEngine.super.onLocalAudioStateChanged(i, i2);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onLocalAudioStateChanged(i, i2);
                }
                if (OMNIEngine.this.mlogReport != null) {
                    if (i == 0) {
                        OMNIEngine.this.mlogReport.addDeviceInfo(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, (String) null);
                    } else if (i == 1) {
                        OMNIEngine.this.mlogReport.addDeviceInfo(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, "1", (String) null);
                    }
                    if (i2 == 1) {
                        OMNIEngine.this.mlogReport.addDeviceInfo(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "unknown");
                    } else if (i2 == 2) {
                        OMNIEngine.this.mlogReport.addDeviceInfo(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "no_permission");
                    } else if (i2 == 3) {
                        OMNIEngine.this.mlogReport.addDeviceInfo(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "busy");
                    }
                }
            }

            public void onLocalVideoStateChanged(int i, int i2) {
                OMNIEngine.super.onLocalVideoStateChanged(i, i2);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onLocalVideoStateChanged(i, i2);
                }
                if (OMNIEngine.this.mlogReport != null) {
                    if (i == 0) {
                        OMNIEngine.this.mlogReport.addDeviceInfo("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, (String) null);
                    } else if (i == 1) {
                        OMNIEngine.this.mlogReport.addDeviceInfo("1", "1", (String) null);
                    }
                    if (i2 == 1) {
                        OMNIEngine.this.mlogReport.addDeviceInfo("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "unknown");
                    } else if (i2 == 2) {
                        OMNIEngine.this.mlogReport.addDeviceInfo("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "no_permission");
                    } else if (i2 == 3) {
                        OMNIEngine.this.mlogReport.addDeviceInfo("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "busy");
                    }
                }
            }

            public void onRemoteStreamSubscribeAdvice(long j, int i, int i2) {
                Logger.i("OMNIEngine onRemoteStreamSubscribeAdvice uid = " + j + " currentStreamType = " + i + ", suitableStreamType = " + i2 + ", mObserver = " + OMNIEngine.this.mObserver, new Object[0]);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onRemoteStreamSubscribeAdvice(j, i, i2);
                }
            }

            public void onTakeLocalViewSnapshot(Bitmap bitmap) {
                Logger.i("OMNIEngine onTakeLocalViewSnapshot bitmap = " + bitmap + ", mObserver = " + OMNIEngine.this.mObserver, new Object[0]);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onTakeLocalViewSnapshot(bitmap);
                }
            }

            public void onTakeRemoteViewSnapshot(long j, Bitmap bitmap) {
                Logger.i("OMNIEngine onTakeRemoteViewSnapshot bitmap = " + bitmap + ", mObserver = " + OMNIEngine.this.mObserver, new Object[0]);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onTakeRemoteViewSnapshot(j, bitmap);
                }
            }

            public void onCaptureVideoSize(int i, int i2) {
                Logger.i("OMNIEngine onCaptureVideoSize width = " + i + ", height = " + i2, new Object[0]);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onCaptureVideoSize(i, i2);
                }
            }

            public void onTakePreEncodeSnapshot(byte[] bArr) {
                if (OMNIEngine.this.mContentInspectListener != null) {
                    OMNIEngine.this.mContentInspectListener.onTakePreEncodeSnapshot(bArr);
                }
            }

            public void onChannelMediaRelayStateChanged(int i, int i2) {
                OMNIEngine.super.onChannelMediaRelayStateChanged(i, i2);
                Logger.i("OMNIEngine onChannelMediaRelayStateChanged state = " + i + " code = " + i2, new Object[0]);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onChannelMediaRelayStateChanged(i, i2);
                }
            }

            public void onChannelMediaRelayEvent(int i) {
                OMNIEngine.super.onChannelMediaRelayEvent(i);
                Logger.i("OMNIEngine onChannelMediaRelayEvent code = " + i, new Object[0]);
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onChannelMediaRelayEvent(i);
                }
            }

            public void onNetworkQuality(long j, int i, int i2) {
                if (OMNIEngine.this.mObserver != null) {
                    OMNIEngine.this.mObserver.onNetworkQuality(j, i, i2);
                }
            }
        };
        this.mTTTRtcEventHandler = r1;
        synchronized (gLock) {
            this.mContext = context;
            this.mListener = iRtcEngineEventListener;
            this.mToken = str2;
            this.mRoomid = str3;
            this.mUserid = j;
            this.mlogReport = logReport;
            this.mAppid = str;
            this.mPlanId = str4;
            Logger.i("OMNIEngine room = " + this.mRoomid + ", uid = " + this.mUserid + ", appId = " + this.mAppid + ", planId = " + str4 + ", token = " + str2 + ", listener = " + this.mListener + ", this = " + this + ", context = " + context, new Object[0]);
            try {
                this.mOMNIEngine = OmniRtcEngine.create(context, str, r1);
                Logger.i("OMNIEngine create, version = " + OmniRtcEngine.getSdkVersion() + "(2023_03_23)" + ", sdkTestVersion = " + "rc-xes-9.75-3.6.140.3" + ", clientCoreVersion = " + NativeInitializer.getIntance().getVersion() + ", engineConfigLogLevel = " + EngineConfig.LogLevelConfig + ", threadId=" + Thread.currentThread().getId(), new Object[0]);
                if (this.mOMNIEngine != null) {
                    try {
                        setURLForEngineFromToken();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.mOMNIEngine.setChannelProfile(1);
                    this.mOMNIEngine.setClientRole(1);
                    LogReport logReport2 = this.mlogReport;
                    if (logReport2 != null) {
                        logReport2.setVideoPublished(true);
                        this.mlogReport.setAudioPublished(true);
                    }
                    this.mOMNIEngine.setBeautyFaceStatus(false, 0.0f, 0.0f);
                    this.mOMNIEngine.enableAudioVolumeIndication(300, 3);
                    this.mOMNIEngine.enableAudioDataReport(true, true);
                    this.mOMNIEngine.setAudioProfile(0, Constants.AudioScenario.getValue(Constants.AudioScenario.EDUCATION));
                    this.mOMNIEngine.setPreferAudioCodec(4, 18, 1);
                    this.mOMNIEngine.enableVideo();
                    if (TextUtils.isEmpty(str2)) {
                        EngineConfig.LogLevelConfig = 0;
                    }
                    OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
                    omniRtcEngine.setAppExtensionInfo("{\"livemode\":0,\"planid\":\"" + this.mPlanId + "\"}");
                } else {
                    Logger.i("OMNIEngine create Failed!", new Object[0]);
                }
            } catch (Exception e2) {
                Log.e(TAG, Log.getStackTraceString(e2));
                Logger.i("OMNIEngine " + Log.getStackTraceString(e2), new Object[0]);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040 A[Catch:{ Exception -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050 A[Catch:{ Exception -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int setURLForEngineFromToken() {
        /*
            r6 = this;
            com.eaydu.omni.urls.UrlManager r0 = com.eaydu.omni.urls.UrlManager.getInstance()
            java.lang.String r0 = r0.getUrlCoreSlbOMNI()
            com.eaydu.omni.urls.UrlManager r1 = com.eaydu.omni.urls.UrlManager.getInstance()
            java.lang.String r1 = r1.getUrlCoreSlbBackupOMNI()
            com.eaydu.omni.urls.UrlManager r2 = com.eaydu.omni.urls.UrlManager.getInstance()
            java.lang.String r2 = r2.getUrlCoreServerLogOMNI()
            com.eaydu.omni.urls.UrlManager r3 = com.eaydu.omni.urls.UrlManager.getInstance()
            java.lang.String r3 = r3.getUrlInspect()
            r4 = 1
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0035 }
            if (r5 == 0) goto L_0x0030
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0035 }
            if (r5 != 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r0 = 0
            goto L_0x003a
        L_0x0030:
            int r0 = r6.setSlbAddress(r0, r1)     // Catch:{ Exception -> 0x0035 }
            goto L_0x003a
        L_0x0035:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r4
        L_0x003a:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0045 }
            if (r1 != 0) goto L_0x004a
            int r0 = r6.setServerLogAddress(r2)     // Catch:{ Exception -> 0x0045 }
            goto L_0x004a
        L_0x0045:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r4
        L_0x004a:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0056 }
            if (r1 != 0) goto L_0x0054
            int r0 = r6.setImageReportUrl(r3)     // Catch:{ Exception -> 0x0056 }
        L_0x0054:
            r4 = r0
            goto L_0x005a
        L_0x0056:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.OMNIEngine.setURLForEngineFromToken():int");
    }

    private int setSlbAddress(String str, String str2) {
        try {
            OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
            if (omniRtcEngine != null) {
                return omniRtcEngine.setSlbAddress(str, str2);
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    private int setImageReportUrl(String str) {
        int i = ERROR_ENGINE_EMPTY;
        try {
            OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
            if (omniRtcEngine != null) {
                i = omniRtcEngine.setImageReportUrl(str);
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
            return i;
        } finally {
            Logger.i("OMNIEngine setImageReportUrl url = " + str + ", result = " + i, new Object[0]);
        }
    }

    private int setServerLogAddress(String str) {
        try {
            OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
            if (omniRtcEngine != null) {
                return omniRtcEngine.setServerLogAddress(str);
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* access modifiers changed from: protected */
    public void setRoomId(String str) {
        super.setRoomId(str);
        this.mRoomid = str;
    }

    /* access modifiers changed from: protected */
    public void setToken(String str) {
        super.setToken(str);
        this.mToken = str;
    }

    public int setRole(RTCEngine.RTCRole rTCRole) {
        int i;
        LogReport logReport;
        LogReport logReport2;
        if (this.mOMNIEngine != null) {
            if (rTCRole == RTCEngine.RTCRole.RTCRoleBroadcaster) {
                i = this.mOMNIEngine.setClientRole(1);
                if (i == 0 && (logReport2 = this.mlogReport) != null) {
                    logReport2.setVideoPublished(true);
                    this.mlogReport.setAudioPublished(true);
                }
            } else if (rTCRole == RTCEngine.RTCRole.RTCRoleAudience) {
                i = this.mOMNIEngine.setClientRole(2);
                if (i == 0 && (logReport = this.mlogReport) != null) {
                    logReport.setVideoPublished(false);
                    this.mlogReport.setAudioPublished(false);
                }
            }
            Logger.i("OMNIEngine setRole role = " + rTCRole + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
            return i;
        }
        i = ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine setRole role = " + rTCRole + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        return i;
    }

    public int setBusinessUserRole(RTCEngine.RTCUserBusinessType rTCUserBusinessType) {
        int businessUserRole = this.mOMNIEngine.setBusinessUserRole(rTCUserBusinessType.getValue());
        Logger.i("OMNIEngine setBusinessRole = " + rTCUserBusinessType + " ret = " + businessUserRole + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        return businessUserRole;
    }

    public void setObserver(RTCEngine.RtcEngineEventObserver rtcEngineEventObserver) {
        super.setObserver(rtcEngineEventObserver);
        this.mObserver = rtcEngineEventObserver;
        Logger.i("OMNIEngine setObserver", new Object[0]);
    }

    public void setMediaVideoProcessListener(RTCEngine.IRTCMediaVideoProcess iRTCMediaVideoProcess) {
        synchronized (this.mRawVideoDataLock) {
            this.mIRTCMediaVideoProcess = iRTCMediaVideoProcess;
        }
        Logger.i("OMNIEngine setMediaVideoProcessListener", new Object[0]);
    }

    public void setMediaAudioProcessListener(RTCEngine.IRTCMediaAudioProcess iRTCMediaAudioProcess) {
        synchronized (this.mRawAudioDataLock) {
            this.mIRTCMediaAudioProcess = iRTCMediaAudioProcess;
        }
        Logger.i("OMNIEngine setMediaAudioProcessListener", new Object[0]);
    }

    public void setPlayBackAudioObserver(RTCEngine.IRTCAudioObserver iRTCAudioObserver) {
        Logger.i("OMNIEngine setPlayBackAudioObserver", new Object[0]);
        this.mIRTCMediaAudioObserver = iRTCAudioObserver;
    }

    public int setRtcEngineLog(String str, RTCEngine.RTCEngineLogLevel rTCEngineLogLevel) {
        int i;
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return ERROR_ENGINE_EMPTY;
        }
        try {
            i = omniRtcEngine.setLogFilter(rTCEngineLogLevel.getValue());
            if (i != 0) {
                Logger.i("OMNIEngine setRtcEngineLog srcPath = " + str + ", level = " + rTCEngineLogLevel + ", setLogFilter = " + i + ", setLogFileResult = " + -1, new Object[0]);
                return i;
            }
            try {
                int logFile = this.mOMNIEngine.setLogFile(str);
                Logger.i("OMNIEngine setRtcEngineLog srcPath = " + str + ", level = " + rTCEngineLogLevel + ", setLogFilter = " + i + ", setLogFileResult = " + logFile, new Object[0]);
                return logFile;
            } catch (Throwable th) {
                th = th;
                Logger.i("OMNIEngine setRtcEngineLog srcPath = " + str + ", level = " + rTCEngineLogLevel + ", setLogFilter = " + i + ", setLogFileResult = " + -1, new Object[0]);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i = -1;
            Logger.i("OMNIEngine setRtcEngineLog srcPath = " + str + ", level = " + rTCEngineLogLevel + ", setLogFilter = " + i + ", setLogFileResult = " + -1, new Object[0]);
            throw th;
        }
    }

    public int setRecordingAudioParameters(int i, int i2) {
        Logger.i("OMNIEngine setRecordingAudioParameters sample = " + i + " channel = " + i2, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return -1;
        }
        int i3 = (i / 100) * i2;
        if (i3 < 160) {
            i3 = 160;
        }
        return omniRtcEngine.setRecordingAudioFrameParameters(i, i2, 0, i3);
    }

    public int setPlaybackAudioFrameParameters(int i, int i2, RTCEngine.RawAudioFrameOpMode rawAudioFrameOpMode, int i3) {
        synchronized (gLock) {
            Logger.i("OMNIEngine setPlaybackAudioFrameParameters sampleRate = " + i + " channel = " + i2 + " mode = " + rawAudioFrameOpMode.getValue() + " samplesPerCall = " + i3, new Object[0]);
            OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
            if (omniRtcEngine == null) {
                return -1;
            }
            int playbackAudioFrameParameters = omniRtcEngine.setPlaybackAudioFrameParameters(i, i2, i3);
            return playbackAudioFrameParameters;
        }
    }

    public void enableLastmileProbeTest() {
        Logger.i("OMNIEngine enableLastmileProbeTest", new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.enableLastmileTest();
        }
    }

    public void disableLastmileProbeTest() {
        Logger.i("OMNIEngine disableLastmileProbeTest", new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.disableLastmileTest();
        }
    }

    public int joinRoom() {
        this.joinRoomStartTime = System.currentTimeMillis();
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int joinChannel = omniRtcEngine != null ? omniRtcEngine.joinChannel(this.mToken, this.mRoomid, this.mUserid) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine joinRoom token =  " + this.mToken + " room id = " + this.mRoomid + " uid = " + this.mUserid + " ret = " + joinChannel + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        return joinChannel;
    }

    public void leaveRoom() {
        Logger.i("OMNIEngine leaveRoom " + this.mRoomid, new Object[0]);
        this.leaveRoomStartTime = System.currentTimeMillis();
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.leaveChannel();
        }
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.leaveRoom(this.mRoomid, this.mUserid, LOGErrorCode.LOG_Success.value, "LeaveRoom bye bye", System.currentTimeMillis() - this.leaveRoomStartTime);
        }
    }

    public void destory() {
        synchronized (gLock) {
            Logger.i("OMNIEngine destory", new Object[0]);
            if (this.mOMNIEngine != null) {
                OmniRtcEngine.destroy();
            }
            this.mOMNIEngine = null;
            this.mLocalVideoRawDataCopyArray = null;
            this.lastEngineChangeNotifyTime = 0;
            releaseRawData();
            CoreRtcLogWrite coreRtcLogWrite2 = this.coreRtcLogWrite;
            if (coreRtcLogWrite2 != null) {
                coreRtcLogWrite2.stop();
            }
        }
    }

    public String getSdkVersion() {
        return OmniRtcEngine.getSdkVersion();
    }

    public void enableLocalVideo(boolean z) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int enableLocalVideo = omniRtcEngine != null ? omniRtcEngine.enableLocalVideo(z) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine enableLocalVideo enable = " + z + " ret = " + enableLocalVideo, new Object[0]);
    }

    public void enableLocalAudio(boolean z) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int enableLocalAudio = omniRtcEngine != null ? omniRtcEngine.enableLocalAudio(z) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine enableLocalAudio enable = " + z + " ret = " + enableLocalAudio, new Object[0]);
    }

    public int muteLocalVideo(boolean z) {
        int i;
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            i = omniRtcEngine.muteLocalVideoStream(z);
            if (i == 0) {
                LogReport logReport = this.mlogReport;
                if (logReport != null) {
                    if (z) {
                        logReport.LogStopPublish(this.mUserid, LOGMediaType.LOG_MEDIA_VIDEO.value);
                    } else {
                        logReport.LogStartPublish(LOGMediaType.LOG_MEDIA_VIDEO.value);
                    }
                }
            } else {
                Logger.i("OMNIEngine muteLocalVideo failed code = " + i, new Object[0]);
            }
        } else {
            i = ERROR_ENGINE_EMPTY;
        }
        Logger.i("OMNIEngine muteLocalVideo mute = " + z + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        LogReport logReport2 = this.mlogReport;
        if (logReport2 != null) {
            if (z) {
                logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_OPPO, (String) null, -1);
            } else {
                logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_ST, (String) null, -1);
            }
        }
        return i;
    }

    public int muteLocalAudio(boolean z) {
        int i;
        Logger.i("OMNIEngine muteLocalAudio mute = " + z, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            i = omniRtcEngine.muteLocalAudioStream(z);
            if (i == 0) {
                LogReport logReport = this.mlogReport;
                if (logReport != null) {
                    if (z) {
                        logReport.LogStopPublish(this.mUserid, LOGMediaType.LOG_MEDIA_AUDIO.value);
                    } else {
                        logReport.LogStartPublish(LOGMediaType.LOG_MEDIA_AUDIO.value);
                    }
                }
            } else {
                Logger.i("OMNIEngine muteLocalAudio failed code = " + i, new Object[0]);
            }
        } else {
            i = ERROR_ENGINE_EMPTY;
        }
        Logger.i("OMNIEngine muteLocalAudio mute = " + z + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        LogReport logReport2 = this.mlogReport;
        if (logReport2 != null) {
            if (z) {
                logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_VIVO, (String) null, -1);
            } else {
                logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "8", (String) null, -1);
            }
        }
        return i;
    }

    public void muteRemoteVideo(long j, boolean z) {
        Logger.i("OMNIEngine muteRemoteVideo uid = " + j + " muted = " + z, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.muteRemoteVideoStream(j, z);
        }
        LogReport logReport = this.mlogReport;
        if (logReport == null) {
            return;
        }
        if (z) {
            logReport.LogStopPlay(j, LOGMediaType.LOG_MEDIA_VIDEO.value);
            this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "9", (String) null, j);
            return;
        }
        logReport.LogStaticRemoteVideoIn(j, 0);
        this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "11", (String) null, j);
    }

    public void muteRemoteAudio(long j, boolean z) {
        Logger.i("OMNIEngine muteRemoteAudio uid = " + j + " muted = " + z, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.muteRemoteAudioStream(j, z);
        }
        LogReport logReport = this.mlogReport;
        if (logReport == null) {
            return;
        }
        if (z) {
            logReport.LogStopPlay(j, LOGMediaType.LOG_MEDIA_AUDIO.value);
            this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "10", (String) null, j);
            return;
        }
        logReport.LogStaticRemoteAudioIn(j, 0);
        this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "12", (String) null, j);
    }

    public void muteAllRemoteVideo(boolean z) {
        Logger.i("OMNIEngine muteAllRemoteVideo mute = " + z, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.muteAllRemoteVideoStreams(z);
        }
        LogReport logReport = this.mlogReport;
        if (logReport == null) {
            return;
        }
        if (z) {
            logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "1", (String) null, -1);
        } else {
            logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, (String) null, -1);
        }
    }

    public void muteAllRemoteAudio(boolean z) {
        Logger.i("OMNIEngine muteAllRemoteAudio mute = " + z, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.muteAllRemoteAudioStreams(z);
        }
        LogReport logReport = this.mlogReport;
        if (logReport == null) {
            return;
        }
        if (z) {
            logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, (String) null, -1);
        } else {
            logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ, (String) null, -1);
        }
    }

    public int setupLocalVideo(View view) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int i = omniRtcEngine != null ? omniRtcEngine.setupLocalVideo(new VideoCanvas(this.mUserid, this.mRTCLocalVideoRenderMode.getValue(), (SurfaceView) view)) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine setupLocalVideo view = " + view + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        return i;
    }

    public int setupLocalVideo(TextureView textureView) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int i = omniRtcEngine != null ? omniRtcEngine.setupLocalVideo(new VideoCanvas(this.mUserid, this.mRTCLocalVideoRenderMode.getValue(), textureView)) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine setupLocalVideo view = " + textureView + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        return i;
    }

    public void setLocalRenderMode(RTCEngine.RTCVideoRenderMode rTCVideoRenderMode) {
        Logger.i("OMNIEngine setLocalRenderMode", new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            this.mRTCLocalVideoRenderMode = rTCVideoRenderMode;
            omniRtcEngine.setLocalRenderMode(rTCVideoRenderMode.getValue(), this.mRTCLocalVideoRenderMirror ? 160201 : 160202);
        }
    }

    public void setupRemoteVideo(View view, long j) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int i = omniRtcEngine != null ? omniRtcEngine.setupRemoteVideo(new VideoCanvas(j, 1, (SurfaceView) view)) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine setupRemoteVideo uid = " + j + " view = " + view + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
    }

    public void setupRemoteVideo(View view, long j, String str) {
        int i;
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            i = ERROR_ENGINE_EMPTY;
        } else if (view instanceof SurfaceView) {
            i = omniRtcEngine.setupRemoteVideo(new VideoCanvas(str, j, 1, (SurfaceView) view));
        } else {
            i = omniRtcEngine.setupRemoteVideo(new VideoCanvas(str, j, 1, (TextureView) view));
        }
        Logger.i("OMNIChannel setupRemoteVideo channelId = " + str + " uid = " + j + " view = " + view + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
    }

    public int setupRemoteVideo(long j, TextureView textureView) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int i = omniRtcEngine != null ? omniRtcEngine.setupRemoteVideo(new VideoCanvas(j, 1, textureView)) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine setupRemoteVideo uid = " + j + " view = " + textureView + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        return i;
    }

    public void setRemoteRenderMode(long j, RTCEngine.RTCVideoRenderMode rTCVideoRenderMode) {
        Logger.i("OMNIEngine setRemoteRenderMode uid = " + j + "  mode = " + rTCVideoRenderMode.getValue(), new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            this.mRTCRemoteVideoRenderMode = rTCVideoRenderMode;
            omniRtcEngine.setRemoteRenderMode(j, rTCVideoRenderMode.getValue(), this.mRTCRemoteVideoRenderMirror ? 160201 : 160202);
        }
    }

    public void setRemoteRenderMode(long j, RTCEngine.RTCVideoRenderMode rTCVideoRenderMode, int i) {
        Logger.i("OMNIEngine setRemoteRenderMode uid = " + j + "  mode = " + rTCVideoRenderMode.getValue() + "  mirrorMode = " + i, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            this.mRTCRemoteVideoRenderMode = rTCVideoRenderMode;
            int i2 = 160200;
            if (i == 1) {
                i2 = 160201;
            } else if (i == 2) {
                i2 = 160202;
            }
            omniRtcEngine.setRemoteRenderMode(j, rTCVideoRenderMode.getValue(), i2);
        }
    }

    public View createRendererView() {
        if (this.mOMNIEngine != null) {
            SurfaceView CreateRendererSurfaceView = OmniRtcEngine.CreateRendererSurfaceView(this.mContext);
            CreateRendererSurfaceView.setZOrderMediaOverlay(true);
            Logger.i("OMNIEngine createRendererView " + CreateRendererSurfaceView, new Object[0]);
            return CreateRendererSurfaceView;
        }
        Logger.i("OMNIEngine createRendererView " + null, new Object[0]);
        return null;
    }

    public void startPreview() {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int startPreview = omniRtcEngine != null ? omniRtcEngine.startPreview() : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine startPreview ret = " + startPreview, new Object[0]);
    }

    public void stopPreview() {
        Logger.i("OMNIEngine stopPreview", new Object[0]);
    }

    public void switchCamera() {
        Logger.i("OMNIEngine switchCamera", new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.switchCamera();
        }
    }

    public void setMirror(boolean z) {
        Logger.i("OMNIEngine setMirror " + z, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            this.mRTCLocalVideoRenderMirror = z;
            if (z) {
                omniRtcEngine.setLocalRenderMode(this.mRTCLocalVideoRenderMode.getValue(), 160201);
            } else {
                omniRtcEngine.setLocalRenderMode(this.mRTCLocalVideoRenderMode.getValue(), 160202);
            }
        }
    }

    public void setRemoteMirror(boolean z) {
        Logger.i("OMNIEngine setRemoteMirror " + z, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            this.mRTCRemoteVideoRenderMirror = z;
            omniRtcEngine.setRemoteRenderMirror(z ? 160201 : 160202);
        }
    }

    public void setVideoEncoderConfiguration(int i, int i2, RTCEngine.RTCEngineVideoBitrate rTCEngineVideoBitrate, RTCEngine.RTC_ORIENTATION_MODE rtc_orientation_mode) {
        Logger.i("OMNIEngine setVideoEncoderConfiguration width = %d height = %d bitrate = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(rTCEngineVideoBitrate.getValue()));
        if (this.mOMNIEngine != null) {
            this.mOMNIEngine.setVideoEncoderConfiguration(new VideoEncoderConfiguration(new VideoEncoderConfiguration.VideoDimensions(i, i2), VideoEncoderConfiguration.FRAME_RATE.FRAME_RATE_FPS_15, rTCEngineVideoBitrate.getValue(), VideoEncoderConfiguration.ORIENTATION_MODE.values()[rtc_orientation_mode.getValue()]));
        }
    }

    public void setVideoEncoderConfiguration(int i, int i2, int i3, int i4, RTCEngine.RTC_ORIENTATION_MODE rtc_orientation_mode) {
        Logger.i("OMNIEngine setVideoEncoderConfiguration width = %d height = %d fps = %d bitrate = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 < 5) {
            i3 = 5;
        } else if (i3 > 30) {
            i3 = 30;
        }
        if (i4 < 100) {
            i4 = 100;
        }
        if (this.mOMNIEngine != null) {
            VideoEncoderConfiguration videoEncoderConfiguration = new VideoEncoderConfiguration(new VideoEncoderConfiguration.VideoDimensions(i, i2), VideoEncoderConfiguration.FRAME_RATE.FRAME_RATE_FPS_15, i4, VideoEncoderConfiguration.ORIENTATION_MODE.values()[rtc_orientation_mode.getValue()]);
            videoEncoderConfiguration.frameRate = i3;
            this.mOMNIEngine.setVideoEncoderConfiguration(videoEncoderConfiguration);
        }
    }

    public int setAudioEncoderConfiguration(int i, int i2) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return -2;
        }
        return omniRtcEngine.setAudioEncoderConfiguration(i, i2);
    }

    public void muteVideo(boolean z) {
        Logger.i("OMNIEngine muteVideo mute = " + z, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.muteLocalVideoStream(z);
        }
    }

    public void muteAudio(boolean z) {
        Logger.i("OMNIEngine muteAudio mute = " + z, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.muteLocalAudioStream(z);
        }
    }

    public void enableExternalVideo(boolean z) {
        Logger.i("OMNIEngine enableExternalVideo enable = " + z, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.setExternalVideoSource(z, false, true);
            this.mHasEnableExternalVideo = z;
        }
    }

    public boolean sendCustomVideoData(byte[] bArr, int i, int i2, int i3, int i4) {
        if (!this.mHasEnableExternalVideo || bArr == null || bArr.length == 0 || this.mOMNIEngine == null) {
            return false;
        }
        OmniVideoFrame omniVideoFrame = new OmniVideoFrame();
        omniVideoFrame.format = i;
        omniVideoFrame.timeStamp = System.currentTimeMillis();
        omniVideoFrame.stride = i2;
        omniVideoFrame.height = i3;
        omniVideoFrame.buf = bArr;
        omniVideoFrame.rotation = i4;
        return this.mOMNIEngine.pushExternalVideoFrame(omniVideoFrame);
    }

    public void enableExternalAudio(boolean z, int i, int i2) {
        Logger.i("OMNIEngine enableExternalAudio enable = " + z + " sampleRate = " + i + " channels = " + i2, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.setExternalAudioSource(z, i, i2);
            this.mHasEnableExternalAudio = z;
        }
    }

    public void sendCustomPCMData(byte[] bArr) {
        OmniRtcEngine omniRtcEngine;
        if (this.mHasEnableExternalAudio && bArr != null && bArr.length != 0 && (omniRtcEngine = this.mOMNIEngine) != null) {
            omniRtcEngine.pushExternalAudioFrame(bArr, System.currentTimeMillis());
        }
    }

    public int pushExternalAudioFrame(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return -2;
        }
        return omniRtcEngine.pushExternalAudioFrame(bArr, j, i, i2, i3, i4);
    }

    public void setVolume(long j, int i) {
        Logger.i("OMNIEngine setVolume type1 uid = " + j + " volumeNum = " + i, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.adjustUserPlaybackSignalVolume(j, i);
        }
    }

    public void setVolume(long j, int i, String str) {
        Logger.i("OMNIEngine setVolume type2 uid = " + j + " volumeNum = " + i + " roomId = " + str, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.adjustUserPlaybackSignalVolume(j, i);
        }
    }

    public BaseRTCChannel createChannel(String str) {
        Logger.i("OMNIEngine createChannel channelId = " + str, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return null;
        }
        OmniRtcChannel createRtcChannel = omniRtcEngine.createRtcChannel(str);
        if (createRtcChannel == null) {
            Logger.i("OMNIEngine createChannel rtcChannel = " + createRtcChannel, new Object[0]);
            return null;
        }
        OMNIChannel oMNIChannel = new OMNIChannel();
        oMNIChannel.setRtcChannel(createRtcChannel);
        oMNIChannel.setEngine(this);
        oMNIChannel.setEngineListener(new EngineAndChannelEachOtherListener() {
            public void channelUserLeaveRoom(long j, String str) {
                Logger.i("OMNIEngine channelUserLeaveRoom  uid = " + j + " roomId " + str, new Object[0]);
            }
        });
        return oMNIChannel;
    }

    /* access modifiers changed from: protected */
    public void renderDelayStart(long j, long j2, String str) {
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.jitterRenderDelayStart(j2, j, str);
        }
    }

    /* access modifiers changed from: protected */
    public void renderDelayEnd(long j, long j2, String str, long j3) {
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.jitterRenderDelayEnd(j2, j, str, j3);
        }
    }

    /* access modifiers changed from: protected */
    public void audioRenderDelayStart(long j, long j2, String str) {
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.audioJitterRenderDelayStart(j2, j, str);
        }
    }

    /* access modifiers changed from: protected */
    public void audioRenderDelayEnd(long j, long j2, String str, long j3) {
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.audioJitterRenderDelayEnd(j2, j, str, j3);
        }
    }

    public int setTimestamp(long j) {
        if (this.mOMNIEngine == null) {
            return -1;
        }
        byte[] bArr = {-88, 95, -28, -23, 27, 105, 17, -24, -123, -126, 0, 80, -62, 73, 0, 72, 0, 0, 0, 0, 0, 0, 0, 0};
        System.arraycopy(LongToBytes(j), 0, bArr, 16, 8);
        return this.mOMNIEngine.sendStreamMessage(this.mDataStreamId, bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getTimestamp(int r7) {
        /*
            r6 = this;
            com.wushuangtech.wstechapi.OmniRtcEngine r0 = r6.mOMNIEngine
            if (r0 != 0) goto L_0x0007
            r0 = -1
            return r0
        L_0x0007:
            java.lang.Object r0 = r6.mTimestampRecLock
            monitor-enter(r0)
            java.util.HashMap<java.lang.Integer, java.lang.Long> r1 = r6.mMetadataRecTimestampMap     // Catch:{ all -> 0x0077 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0077 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0077 }
            r2 = 0
            if (r1 == 0) goto L_0x0075
            java.util.HashMap<java.lang.Integer, java.lang.Long> r1 = r6.mMetadataRecTimestampMap     // Catch:{ all -> 0x0077 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0077 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0077 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0077 }
            long r4 = r1.longValue()     // Catch:{ all -> 0x0077 }
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0075
            java.util.HashMap<java.lang.Integer, java.lang.Long> r1 = r6.mRecTimestampMap     // Catch:{ all -> 0x0077 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0077 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x0075
            java.util.HashMap<java.lang.Integer, java.lang.Long> r1 = r6.mRecTimestampMap     // Catch:{ all -> 0x0077 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0077 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0077 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0077 }
            long r4 = r1.longValue()     // Catch:{ all -> 0x0077 }
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x004d
            goto L_0x0075
        L_0x004d:
            java.util.HashMap<java.lang.Integer, java.lang.Long> r1 = r6.mMetadataRecTimestampMap     // Catch:{ all -> 0x0077 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0077 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0077 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ all -> 0x0077 }
            long r1 = r1.longValue()     // Catch:{ all -> 0x0077 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0077 }
            long r1 = r1 + r3
            java.util.HashMap<java.lang.Integer, java.lang.Long> r3 = r6.mRecTimestampMap     // Catch:{ all -> 0x0077 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0077 }
            java.lang.Object r7 = r3.get(r7)     // Catch:{ all -> 0x0077 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0077 }
            long r3 = r7.longValue()     // Catch:{ all -> 0x0077 }
            long r1 = r1 - r3
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            return r1
        L_0x0075:
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            return r2
        L_0x0077:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0077 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.OMNIEngine.getTimestamp(int):long");
    }

    private static byte[] LongToBytes(long j) {
        byte[] bArr = new byte[8];
        int i = 0;
        while (i < 8) {
            int i2 = i + 1;
            bArr[i] = (byte) ((int) ((j >> (64 - (i2 * 8))) & 255));
            i = i2;
        }
        return bArr;
    }

    private static long BytesToLong(byte[] bArr) {
        long j = 0;
        for (int i = 0; i < 8; i++) {
            j = (j << 8) | ((long) (bArr[i] & 255));
        }
        return j;
    }

    public int addPublishStreamUrl(String str, boolean z) {
        int i;
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            i = -1;
        } else {
            i = omniRtcEngine.addPublishStreamUrl(str, z);
        }
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.pushRtmpState(str, "1000", i + "");
        }
        Logger.i("OMNIEngine addPublishStreamUrl url = " + str + "needTranscode" + z + "errCode = " + i, new Object[0]);
        return i;
    }

    public int removePublishStreamUrl(String str) {
        int i;
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            i = -1;
        } else {
            i = omniRtcEngine.removePublishStreamUrl(str);
        }
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.pushRtmpState(str, "1001", i + "");
        }
        Logger.i("OMNIEngine removePublishStreamUrl url = " + str + "errCode = " + i, new Object[0]);
        return i;
    }

    public int setRtmpConfig(RTCEngine.RTCRtmpConfig rTCRtmpConfig) {
        Logger.i("OMNIEngine setRtmpConfig:" + rTCRtmpConfig, new Object[0]);
        if (this.mOMNIEngine == null || rTCRtmpConfig == null) {
            return -1;
        }
        return 0;
    }

    public int startPlayMusic(String str) {
        Logger.i("OMNIEngine startPlayMusic" + str, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return -1;
        }
        return omniRtcEngine.startAudioMixing(str, false, false, 1);
    }

    public int startPlayMusic(String str, boolean z, boolean z2, int i) {
        Logger.i("OMNIEngine startPlayMusic" + str + " loopback = " + z + " replace = " + z2 + " cycle = " + i, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return -1;
        }
        return omniRtcEngine.startAudioMixing(str, z, z2, i);
    }

    public int stopPlayMusic() {
        Logger.i("OMNIEngine stopPlayMusic", new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return -1;
        }
        return omniRtcEngine.stopAudioMixing();
    }

    public int playMusicVolume(int i) {
        Logger.i("OMNIEngine playMusicVolume " + i, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return -1;
        }
        return omniRtcEngine.adjustAudioMixingVolume(i);
    }

    public int setParams(String str) {
        Logger.i("OMNIEngine setParams config = " + str, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            return omniRtcEngine.setParameters(str);
        }
        return 0;
    }

    public int setRemoteVideoStreamType(long j, int i) {
        try {
            OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
            if (omniRtcEngine == null) {
                return ERROR_ENGINE_EMPTY;
            }
            int remoteVideoStreamType = omniRtcEngine.setRemoteVideoStreamType(j, i);
            Logger.i("OMNIEngine setRemoteVideoStreamType uid=" + j + " streamType=" + i + " result=" + remoteVideoStreamType, new Object[0]);
            return remoteVideoStreamType;
        } finally {
            Logger.i("OMNIEngine setRemoteVideoStreamType uid=" + j + " streamType=" + i + " result=" + ERROR_ENGINE_EMPTY, new Object[0]);
        }
    }

    public int setRemoteSubscribeFallbackOption(int i) {
        try {
            OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
            if (omniRtcEngine == null) {
                return ERROR_ENGINE_EMPTY;
            }
            int remoteSubscribeFallbackOption = omniRtcEngine.setRemoteSubscribeFallbackOption(i);
            Logger.i("OMNIEngine setRemoteSubscribeFallbackOption option=" + i + " result=" + remoteSubscribeFallbackOption, new Object[0]);
            return remoteSubscribeFallbackOption;
        } finally {
            Logger.i("OMNIEngine setRemoteSubscribeFallbackOption option=" + i + " result=" + ERROR_ENGINE_EMPTY, new Object[0]);
        }
    }

    public int applyRemoteStreamSubscribeAdvice(long j, int i) {
        try {
            OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
            if (omniRtcEngine == null) {
                return ERROR_ENGINE_EMPTY;
            }
            int remoteVideoStreamType = omniRtcEngine.setRemoteVideoStreamType(j, i);
            Logger.i("OMNIEngine applyRemoteStreamSubscribeAdvice uid=" + j + " streamType=" + i + " result=" + remoteVideoStreamType, new Object[0]);
            return remoteVideoStreamType;
        } finally {
            Logger.i("OMNIEngine applyRemoteStreamSubscribeAdvice uid=" + j + " streamType=" + i + " result=" + ERROR_ENGINE_EMPTY, new Object[0]);
        }
    }

    public int setAudioMode(RTCEngine.RTCAudioMode rTCAudioMode) {
        Logger.i("OMNIEngine setAudioMode mode = " + rTCAudioMode.getValue(), new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            return omniRtcEngine.setAudioMode(rTCAudioMode.getValue());
        }
        return -1;
    }

    public int setRemoteMixedVolume(int i) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int remoteVolumeAll = omniRtcEngine != null ? omniRtcEngine.setRemoteVolumeAll(i) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine setRemoteVolumeAll volume = " + i + ", ret = " + remoteVolumeAll, new Object[0]);
        return remoteVolumeAll;
    }

    public int takeLocalViewSnapshot() {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int takeLocalViewSnapshot = omniRtcEngine != null ? omniRtcEngine.takeLocalViewSnapshot() : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine takeLocalViewSnapshot ret = " + takeLocalViewSnapshot, new Object[0]);
        return takeLocalViewSnapshot;
    }

    public int takeRemoteViewSnapshot(long j) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int takeRemoteViewSnapshot = omniRtcEngine != null ? omniRtcEngine.takeRemoteViewSnapshot(j) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine takeRemoteViewSnapshot uid = " + j + ", ret = " + takeRemoteViewSnapshot, new Object[0]);
        return takeRemoteViewSnapshot;
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int defaultMuteAllRemoteAudioStreams = omniRtcEngine != null ? omniRtcEngine.setDefaultMuteAllRemoteAudioStreams(z) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine setDefaultMuteAllRemoteAudioStreams muted = " + z + ", ret = " + defaultMuteAllRemoteAudioStreams, new Object[0]);
        return defaultMuteAllRemoteAudioStreams;
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int defaultMuteAllRemoteVideoStreams = omniRtcEngine != null ? omniRtcEngine.setDefaultMuteAllRemoteVideoStreams(z) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine setDefaultMuteAllRemoteVideoStreams muted = " + z + ", ret = " + defaultMuteAllRemoteVideoStreams, new Object[0]);
        return defaultMuteAllRemoteVideoStreams;
    }

    public int enableContentInspect(boolean z, int i) {
        Logger.i("OMNIEngine enableContentInspect enable = " + z + " timeInterval = " + i, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            return omniRtcEngine.enableContentInspect(z, i);
        }
        return -1;
    }

    public int contentInspectExtra(String str, RTCEngine.InspectMode[] inspectModeArr) {
        Logger.i("OMNIEngine contentInspectExtra arguments = " + str + " modes = " + Arrays.toString(inspectModeArr), new Object[0]);
        if (this.mOMNIEngine == null) {
            return -1;
        }
        if (inspectModeArr == null) {
            return -3;
        }
        int[] iArr = new int[2];
        for (RTCEngine.InspectMode inspectMode : inspectModeArr) {
            int i = inspectMode.mode;
            if (i == 1) {
                iArr[0] = inspectMode.rate;
            } else if (i == 2) {
                iArr[1] = inspectMode.rate;
            }
        }
        return this.mOMNIEngine.contentInspectExtra(str, iArr);
    }

    public void setContentInspectListener(RTCEngine.ContentInspectListener contentInspectListener) {
        this.mContentInspectListener = contentInspectListener;
    }

    public int takePreEncodeSnapshot() {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return -1;
        }
        return omniRtcEngine.takePreEncodeSnapshot();
    }

    /* JADX INFO: finally extract failed */
    public int startChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        String str = "null";
        ChannelMediaRelayConfiguration channelMediaRelayConfiguration = null;
        try {
            if (this.mOMNIEngine == null) {
                Logger.i("OMNIEngine startChannelMediaRelay config=" + str + " result=" + ERROR_ENGINE_EMPTY, new Object[0]);
                return ERROR_ENGINE_EMPTY;
            }
            channelMediaRelayConfiguration = ClassConverter.getCoreChannelMediaRelayConfigurationFromRTC(rTCChannelMediaRelayConfiguration);
            if (channelMediaRelayConfiguration == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("OMNIEngine startChannelMediaRelay config=");
                if (channelMediaRelayConfiguration != null) {
                    str = channelMediaRelayConfiguration.toString();
                }
                sb.append(str);
                sb.append(" result=");
                sb.append(-3);
                Logger.i(sb.toString(), new Object[0]);
                return -3;
            }
            int startChannelMediaRelay = this.mOMNIEngine.startChannelMediaRelay(channelMediaRelayConfiguration);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("OMNIEngine startChannelMediaRelay config=");
            if (channelMediaRelayConfiguration != null) {
                str = channelMediaRelayConfiguration.toString();
            }
            sb2.append(str);
            sb2.append(" result=");
            sb2.append(startChannelMediaRelay);
            Logger.i(sb2.toString(), new Object[0]);
            return startChannelMediaRelay;
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("OMNIEngine startChannelMediaRelay config=");
            if (channelMediaRelayConfiguration != null) {
                str = channelMediaRelayConfiguration.toString();
            }
            sb3.append(str);
            sb3.append(" result=");
            sb3.append(ERROR_ENGINE_EMPTY);
            Logger.i(sb3.toString(), new Object[0]);
            throw th;
        }
    }

    public int stopChannelMediaRelay() {
        Logger.i("OMNIEngine stopChannelMediaRelay", new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return ERROR_ENGINE_EMPTY;
        }
        return omniRtcEngine.stopChannelMediaRelay();
    }

    /* JADX INFO: finally extract failed */
    public int updateChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        String str = "null";
        ChannelMediaRelayConfiguration channelMediaRelayConfiguration = null;
        try {
            if (this.mOMNIEngine == null) {
                Logger.i("OMNIEngine updateChannelMediaRelay config=" + str + " result=" + ERROR_ENGINE_EMPTY, new Object[0]);
                return ERROR_ENGINE_EMPTY;
            }
            channelMediaRelayConfiguration = ClassConverter.getCoreChannelMediaRelayConfigurationFromRTC(rTCChannelMediaRelayConfiguration);
            if (channelMediaRelayConfiguration == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("OMNIEngine updateChannelMediaRelay config=");
                if (channelMediaRelayConfiguration != null) {
                    str = channelMediaRelayConfiguration.toString();
                }
                sb.append(str);
                sb.append(" result=");
                sb.append(-3);
                Logger.i(sb.toString(), new Object[0]);
                return -3;
            }
            for (String checkRoomID : channelMediaRelayConfiguration.getDestChannelMediaInfos().keySet()) {
                if (!CommonUtils.checkRoomID(checkRoomID)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("OMNIEngine updateChannelMediaRelay config=");
                    if (channelMediaRelayConfiguration != null) {
                        str = channelMediaRelayConfiguration.toString();
                    }
                    sb2.append(str);
                    sb2.append(" result=");
                    sb2.append(-64);
                    Logger.i(sb2.toString(), new Object[0]);
                    return -64;
                }
            }
            int updateChannelMediaRelay = this.mOMNIEngine.updateChannelMediaRelay(channelMediaRelayConfiguration);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("OMNIEngine updateChannelMediaRelay config=");
            if (channelMediaRelayConfiguration != null) {
                str = channelMediaRelayConfiguration.toString();
            }
            sb3.append(str);
            sb3.append(" result=");
            sb3.append(updateChannelMediaRelay);
            Logger.i(sb3.toString(), new Object[0]);
            return updateChannelMediaRelay;
        } catch (Throwable th) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("OMNIEngine updateChannelMediaRelay config=");
            if (channelMediaRelayConfiguration != null) {
                str = channelMediaRelayConfiguration.toString();
            }
            sb4.append(str);
            sb4.append(" result=");
            sb4.append(ERROR_ENGINE_EMPTY);
            Logger.i(sb4.toString(), new Object[0]);
            throw th;
        }
    }

    public int setPreviewResolution(int i, int i2) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        int cameraPreviewResolution = omniRtcEngine != null ? omniRtcEngine.setCameraPreviewResolution(i, i2) : ERROR_ENGINE_EMPTY;
        Logger.i("OMNIEngine setPreviewResolution width = " + i + ", height=" + i2 + ", ret = " + cameraPreviewResolution, new Object[0]);
        return cameraPreviewResolution;
    }

    private void doRenderEnd() {
        try {
            Iterator<Map.Entry<Long, DelayObject>> it = this.delayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                DelayObject delayObject = (DelayObject) next.getValue();
                if (delayObject.isDelay == 1 && TextUtils.equals(delayObject.roomId, this.mRoomid)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    renderDelayEnd(((DelayObject) next.getValue()).uid, currentTimeMillis, delayObject.roomId, currentTimeMillis - delayObject.startTime);
                }
                if (TextUtils.equals(delayObject.roomId, this.mRoomid)) {
                    it.remove();
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void doRenderEnd(long j, long j2) {
        try {
            Iterator<Map.Entry<Long, DelayObject>> it = this.delayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                DelayObject delayObject = (DelayObject) next.getValue();
                if (delayObject.isDelay == 1 && TextUtils.equals(delayObject.roomId, this.mRoomid) && delayObject.uid == j) {
                    renderDelayEnd(((DelayObject) next.getValue()).uid, j2, delayObject.roomId, j2 - delayObject.startTime);
                    if (TextUtils.equals(delayObject.roomId, this.mRoomid)) {
                        it.remove();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void doAudioRenderEnd() {
        try {
            Iterator<Map.Entry<Long, DelayObject>> it = this.audioDelayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                DelayObject delayObject = (DelayObject) next.getValue();
                if (delayObject.isDelay == 1 && TextUtils.equals(delayObject.roomId, this.mRoomid)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    audioRenderDelayEnd(((DelayObject) next.getValue()).uid, currentTimeMillis, delayObject.roomId, currentTimeMillis - delayObject.startTime);
                }
                if (TextUtils.equals(delayObject.roomId, this.mRoomid)) {
                    it.remove();
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void doAudioRenderEnd(long j, long j2) {
        try {
            Iterator<Map.Entry<Long, DelayObject>> it = this.audioDelayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                DelayObject delayObject = (DelayObject) next.getValue();
                if (delayObject.isDelay == 1 && TextUtils.equals(delayObject.roomId, this.mRoomid) && delayObject.uid == j) {
                    audioRenderDelayEnd(((DelayObject) next.getValue()).uid, j2, delayObject.roomId, j2 - delayObject.startTime);
                    if (TextUtils.equals(delayObject.roomId, this.mRoomid)) {
                        it.remove();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void doEngineChangeNotify() {
        if (this.mObserver != null) {
            Handler handler = this.mHandler;
            AnonymousClass3 r1 = new Runnable() {
                public void run() {
                    if (OMNIEngine.this.mObserver != null && SystemClock.uptimeMillis() - OMNIEngine.this.lastEngineChangeNotifyTime >= 60000) {
                        Logger.i("OMNIEngine CONNECTION_CHANGED_BANNED_BY_SERVER Success", new Object[0]);
                        OMNIEngine.this.mObserver.onEngineChangeNotify();
                        long unused = OMNIEngine.this.lastEngineChangeNotifyTime = SystemClock.uptimeMillis();
                    }
                }
            };
            if (!(handler instanceof Handler)) {
                handler.post(r1);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, r1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void pushVideoLocalRawData(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
        synchronized (gLock) {
            if (this.mOMNIEngine != null) {
                transLocalVideoRawData(bArr, i, i2, i3, i4, i5, i6, i7, i8, j);
            }
        }
    }

    /* access modifiers changed from: private */
    public void pushVideoRemoteRawData(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2) {
        synchronized (gLock) {
            if (this.mOMNIEngine != null) {
                transRemoteVideoRawData(bArr, j, i, i2, i3, i4, i5, i6, i7, i8, j2);
            }
        }
    }

    public void handleSdkLog(int i, String str) {
        if (i >= EngineConfig.LogLevelConfig) {
            Logger.log(4, Logger.LoggerTags.SdkTag, str, (Throwable) null);
        }
    }

    public int setAVSyncSource(String str, long j) {
        Logger.i("OMNIEngine setAVSyncSource channelId = " + str + " uid = " + j, new Object[0]);
        try {
            OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
            if (omniRtcEngine != null) {
                return omniRtcEngine.setAVSyncSource(this.mRoomid, j);
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public int setAVSyncSource(long j) {
        Logger.i("OMNIEngine setAVSyncSource 2 channelId = " + this.mRoomid + " uid = " + j, new Object[0]);
        try {
            OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
            if (omniRtcEngine != null) {
                return omniRtcEngine.setAVSyncSource(this.mRoomid, j);
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public int setServerAddress(String str, int i) {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return 0;
        }
        omniRtcEngine.setServerIp(str, i);
        return 0;
    }

    public int setActivityState(int i) {
        super.setActivityState(i);
        if (this.mOMNIEngine == null) {
            return -2;
        }
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.appStateChanged(i);
        }
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        omniRtcEngine.setParameters("ComLatSdkAppBackgroundState:" + i);
        return 0;
    }

    public int sendStreamMessage(long j, byte[] bArr) {
        if (this.mOMNIEngine == null) {
            return -2;
        }
        if (bArr.length > 1000) {
            return -114;
        }
        byte[] bArr2 = new byte[(bArr.length + 24)];
        byte[] LongToBytes = LongToBytes(j);
        System.arraycopy(EngineConfig.SEI_IRC_UUID, 0, bArr2, 0, 16);
        System.arraycopy(LongToBytes, 0, bArr2, 16, 8);
        System.arraycopy(bArr, 0, bArr2, 24, bArr.length);
        return this.mOMNIEngine.sendStreamMessage(this.mDataStreamId, bArr2);
    }

    public int setMediaVideoProcessOptions(boolean z, boolean z2) {
        Logger.i("OMNIEngine setMediaVideoProcessOptions needJavaLocalVideoData = " + z + " needJavaRemoteVideoData = " + z2, new Object[0]);
        this.mNeedJavaLocalVideoData = z;
        this.mNeedJavaRemoteVideoData = z2;
        return 0;
    }

    public int checkFeatureSupport(RTCEngine.RTCFeature rTCFeature) {
        return rTCFeature == RTCEngine.RTCFeature.FeatureAudioBeauty ? 0 : -3;
    }

    public int getEngineType() {
        return RTCEngine.EngineType.OMNI.getValue();
    }

    public static class ClassConverter {
        public static ChannelMediaRelayConfiguration getCoreChannelMediaRelayConfigurationFromRTC(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
            ChannelMediaRelayConfiguration channelMediaRelayConfiguration = new ChannelMediaRelayConfiguration();
            channelMediaRelayConfiguration.setSrcChannelInfo(getCoreChannelMediaInfoFromRTC(rTCChannelMediaRelayConfiguration.getSrcChannelMediaInfo()));
            for (RTCEngine.RTCChannelMediaInfo coreChannelMediaInfoFromRTC : rTCChannelMediaRelayConfiguration.getDestChannelMediaInfos()) {
                ChannelMediaInfo coreChannelMediaInfoFromRTC2 = getCoreChannelMediaInfoFromRTC(coreChannelMediaInfoFromRTC);
                if (coreChannelMediaInfoFromRTC2 == null) {
                    return null;
                }
                channelMediaRelayConfiguration.setDestChannelInfo(coreChannelMediaInfoFromRTC2.mChannelId, coreChannelMediaInfoFromRTC2);
            }
            return channelMediaRelayConfiguration;
        }

        public static ChannelMediaInfo getCoreChannelMediaInfoFromRTC(RTCEngine.RTCChannelMediaInfo rTCChannelMediaInfo) {
            try {
                Map<String, Claim> claims = new JWT(rTCChannelMediaInfo.token).getClaims();
                Claim claim = claims.get("roomStr");
                String str = "";
                String asString = claim != null ? claim.asString() : str;
                Claim claim2 = claims.get("user");
                long longValue = claim2 != null ? claim2.asInt().longValue() : 0;
                Claim claim3 = claims.get("attachToken");
                if (claim3 != null) {
                    str = claim3.asString();
                } else {
                    Claim claim4 = claims.get(AssistPushConsts.MSG_TYPE_TOKEN);
                    if (claim4 != null) {
                        str = claim4.asString();
                    }
                }
                return new ChannelMediaInfo(asString, str, longValue);
            } catch (Exception e) {
                Logger.i("ClassConverter getCoreChannelMediaInfoFromRTC parseTokenFailed " + e.getMessage(), new Object[0]);
                return null;
            }
        }
    }

    public int getConnectionState() {
        Logger.i("OMNIEngine getConnectionState ", new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            return omniRtcEngine.getConnectionState();
        }
        return -2;
    }

    public int setAudioProfile(int i, int i2) {
        Logger.i("OMNIEngine setAudioProfile profile = " + i2 + " scenario = " + i2, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            return omniRtcEngine.setAudioProfile(i, i2);
        }
        return -2;
    }

    public void enableVideo() {
        Logger.i("OMNIEngine enableVideo ", new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            omniRtcEngine.enableVideo();
        }
    }

    public int disableVideo() {
        Logger.i("OMNIEngine disableVideo ", new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            return omniRtcEngine.disableVideo();
        }
        return -2;
    }

    public TextureView createTextureView() {
        Context context;
        if (this.mOMNIEngine == null || (context = this.mContext) == null) {
            Logger.i("OMNIEngine createTextureView " + null, new Object[0]);
            return null;
        }
        TextureView CreateRendererTextureView = OmniRtcEngine.CreateRendererTextureView(context);
        Logger.i("OMNIEngine createTextureView " + CreateRendererTextureView, new Object[0]);
        return CreateRendererTextureView;
    }

    public int switchChannel(String str, String str2) {
        Logger.i("OMNIEngine switchChannel token = " + str + " channelName = " + str2, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine != null) {
            return omniRtcEngine.switchChannel(str, str2);
        }
        return -2;
    }

    public String getChannelCallId() {
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        return omniRtcEngine != null ? omniRtcEngine.getChannelSessionId() : "";
    }

    public int setLiveMode(int i) {
        Logger.i("OMNIEngine setLiveMode liveMode = " + i + ", planId = " + this.mPlanId + ", this = " + this, new Object[0]);
        OmniRtcEngine omniRtcEngine = this.mOMNIEngine;
        if (omniRtcEngine == null) {
            return -2;
        }
        return omniRtcEngine.setAppExtensionInfo("{\"livemode\":" + i + ",\"planid\":\"" + this.mPlanId + "\"}");
    }
}
