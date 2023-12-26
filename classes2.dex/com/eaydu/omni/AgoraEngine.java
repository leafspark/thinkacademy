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
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.jwt.Claim;
import com.eaydu.omni.jwt.JWT;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.eaydu.omni.listener.RtcConnectReason;
import com.eaydu.omni.log.LOGErrorCode;
import com.eaydu.omni.log.LOGMediaType;
import com.eaydu.omni.log.LogCommonInfo;
import com.eaydu.omni.log.LogReport;
import com.eaydu.omni.log.bean.LogAudioLocalStatistics;
import com.eaydu.omni.log.bean.LogAudioRemoteStatistics;
import com.eaydu.omni.log.bean.LogVideoLocalStatistics;
import com.eaydu.omni.log.bean.LogVideoRemoteStatistics;
import com.eaydu.omni.logger.Logger;
import com.eaydu.omni.utils.CommonUtils;
import com.eaydu.omni.utils.FilePathUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.igexin.assist.sdk.AssistPushConsts;
import com.luck.picture.lib.tools.PictureFileUtils;
import io.agora.rtc.IMetadataObserver;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.RtcChannel;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.live.LiveTranscoding;
import io.agora.rtc.models.ContentInspectConfig;
import io.agora.rtc.plugin.rawdata.MediaDataAudioObserver;
import io.agora.rtc.plugin.rawdata.MediaDataObserverPlugin;
import io.agora.rtc.plugin.rawdata.MediaDataVideoObserver;
import io.agora.rtc.plugin.rawdata.MediaPreProcessing;
import io.agora.rtc.video.AgoraImage;
import io.agora.rtc.video.CameraCapturerConfiguration;
import io.agora.rtc.video.ChannelMediaInfo;
import io.agora.rtc.video.ChannelMediaRelayConfiguration;
import io.agora.rtc.video.VideoCanvas;
import io.agora.rtc.video.VideoEncoderConfiguration;
import java.io.File;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AgoraEngine extends BaseRtcEngine implements IMetadataObserver {
    private static final boolean DEBUG = false;
    private static final String TAG = "AgoraEngine";
    static final int VIDEO_STATE_CHOPPERING_START = 1;
    protected static final int VIDEO_STATE_CHOPPERING_STOP = 2;
    protected static final int VIDEO_STATE_STREAMING = 0;
    private static final boolean enableDataStream = true;
    /* access modifiers changed from: private */
    public static final Object gLock = new Object();
    private static final boolean useDataSteam = true;
    /* access modifiers changed from: private */
    public String agoraInspectFileName = "";
    protected final ConcurrentHashMap<Integer, DelayObject> delayMap = new ConcurrentHashMap<>();
    private boolean enableInspect;
    private ContentInspectConfig enspectConfig;
    /* access modifiers changed from: private */
    public long joinRoomDelay = 0;
    /* access modifiers changed from: private */
    public long joinRoomEndTime = 0;
    /* access modifiers changed from: private */
    public long joinRoomStartTime = 0;
    /* access modifiers changed from: private */
    public long lastEngineChangeNotifyTime = 0;
    private long leaveRoomStartTime = 0;
    protected RtcEngine mAgoraEngine = null;
    final IRtcEngineEventHandler mAgoraRtcEventHandler;
    private CameraCapturerConfiguration.CAMERA_DIRECTION mCamPosition = CameraCapturerConfiguration.CAMERA_DIRECTION.CAMERA_FRONT;
    /* access modifiers changed from: private */
    public RTCEngine.ContentInspectListener mContentInspectListener;
    private Context mContext;
    /* access modifiers changed from: private */
    public volatile int mDataStreamId = 0;
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
    int mLocalMirrorMode = 0;
    int mLocalRenderMode = 1;
    final MediaDataAudioObserver mMediaDataAudioObserver = new MediaDataAudioObserver() {
        public void onMixedAudioFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, long j, int i6) {
        }

        public void onRecordAudioFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, long j, int i6) {
            if (AgoraEngine.this.mIRTCMediaAudioProcess != null) {
                RTCEngine.RTCAudioData rTCAudioData = new RTCEngine.RTCAudioData();
                rTCAudioData.buffer = bArr;
                rTCAudioData.bufferLength = i6;
                rTCAudioData.bytesPerSample = i3;
                rTCAudioData.channels = i4;
                rTCAudioData.renderTimeMs = j;
                rTCAudioData.samplesPerSec = i5;
                rTCAudioData.samples = i2;
                AgoraEngine.this.mIRTCMediaAudioProcess.didCapturedAuidoData(rTCAudioData);
            }
        }

        public void onPlaybackAudioFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, long j, int i6) {
            if (AgoraEngine.this.mIRTCMediaAudioObserver != null) {
                RTCEngine.RTCPlayBackAudioFrame rTCPlayBackAudioFrame = new RTCEngine.RTCPlayBackAudioFrame();
                rTCPlayBackAudioFrame.buffer = bArr;
                rTCPlayBackAudioFrame.bufferLength = i6;
                rTCPlayBackAudioFrame.bytesPerSample = i3;
                rTCPlayBackAudioFrame.channels = i4;
                rTCPlayBackAudioFrame.renderTimeMs = j;
                rTCPlayBackAudioFrame.samplesPerSec = -1;
                rTCPlayBackAudioFrame.samples = i2;
                AgoraEngine.this.mIRTCMediaAudioObserver.onPlaybackAudioData(rTCPlayBackAudioFrame);
            }
        }

        public void onPlaybackAudioFrameBeforeMixing(int i, byte[] bArr, int i2, int i3, int i4, int i5, int i6, long j, int i7) {
            long j2 = ((long) i) & 4294967295L;
            if (AgoraEngine.this.mIRTCMediaAudioProcess != null) {
                RTCEngine.RTCAudioData rTCAudioData = new RTCEngine.RTCAudioData();
                rTCAudioData.buffer = bArr;
                rTCAudioData.bufferLength = i7;
                rTCAudioData.bytesPerSample = i4;
                rTCAudioData.channels = i5;
                rTCAudioData.renderTimeMs = j;
                rTCAudioData.samplesPerSec = i6;
                rTCAudioData.samples = i3;
                AgoraEngine.this.mIRTCMediaAudioProcess.didRenderAudioData(j2, rTCAudioData);
            }
        }
    };
    final MediaDataVideoObserver mMediaDataVideoObserver = new MediaDataVideoObserver() {
        public void onCaptureVideoFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
            if (AgoraEngine.this.mIRTCMediaVideoProcess != null) {
                RTCEngine.RTCVideoData rTCVideoData = new RTCEngine.RTCVideoData();
                rTCVideoData.data = bArr;
                rTCVideoData.width = i2;
                rTCVideoData.height = i3;
                rTCVideoData.yStride = i5;
                rTCVideoData.uStride = i6;
                rTCVideoData.vStride = i7;
                rTCVideoData.rotation = i8;
                rTCVideoData.renderTimeMs = j;
                AgoraEngine.this.mIRTCMediaVideoProcess.didCapturedVideoData(rTCVideoData);
            }
        }

        public void onRenderVideoFrame(int i, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j) {
            long j2 = ((long) i) & 4294967295L;
            if (AgoraEngine.this.mIRTCMediaVideoProcess != null) {
                RTCEngine.RTCVideoData rTCVideoData = new RTCEngine.RTCVideoData();
                rTCVideoData.data = bArr;
                rTCVideoData.width = i3;
                rTCVideoData.height = i4;
                rTCVideoData.yStride = i6;
                rTCVideoData.uStride = i7;
                rTCVideoData.vStride = i8;
                rTCVideoData.rotation = i9;
                rTCVideoData.renderTimeMs = j;
                AgoraEngine.this.mIRTCMediaVideoProcess.didRenderVideoData(j2, rTCVideoData);
            }
        }
    };
    public HashMap<Integer, Long> mMetadataRecTimestampMap = new HashMap<>();
    protected RTCEngine.RtcEngineEventObserver mObserver;
    private String mOtherRoomId = "";
    private String mPublishChannelId;
    public HashMap<Integer, Long> mRecTimestampMap = new HashMap<>();
    int mRemoteMirrorMode = 0;
    /* access modifiers changed from: private */
    public long mRenderExternalCachedTimeMs = 0;
    /* access modifiers changed from: private */
    public String mRoomid = "";
    public long mSetTimestamp = 0;
    /* access modifiers changed from: private */
    public RTCEngine.ReportRtcStats mStatsReport = new RTCEngine.ReportRtcStats();
    private Object mTimestampLock = new Object();
    /* access modifiers changed from: private */
    public Object mTimestampRecLock = new Object();
    private String mToken;
    public long mUserSetTimestamp = 0;
    /* access modifiers changed from: private */
    public long mUserid;
    protected MediaDataObserverPlugin mediaDataObserverPlugin = null;
    protected LogReport mlogReport;
    /* access modifiers changed from: private */
    public String mlostReasion = "disconnect by client";
    /* access modifiers changed from: private */
    public int mreCountNum = 0;
    /* access modifiers changed from: private */
    public long startConnectime = 0;
    private boolean startInspect;
    int tag;

    public interface EngineAndChannelEachOtherListener {
        void channelUserLeaveRoom(long j, String str);
    }

    public int getMaxMetadataSize() {
        return PictureFileUtils.KB;
    }

    static /* synthetic */ int access$1208(AgoraEngine agoraEngine) {
        int i = agoraEngine.mreCountNum;
        agoraEngine.mreCountNum = i + 1;
        return i;
    }

    static class DelayObject {
        public int isDelay = 0;
        public boolean isMuted;
        public String roomId;
        public long startTime;
        public long uid;

        DelayObject() {
        }
    }

    public AgoraEngine(Context context, String str, RTCEngine.IRtcEngineEventListener iRtcEngineEventListener, String str2, String str3, long j, LogReport logReport) {
        AnonymousClass4 r2 = new IRtcEngineEventHandler() {
            public void onRemoteVideoTransportStats(int i, int i2, int i3, int i4) {
            }

            public void onStreamMessageError(int i, int i2, int i3, int i4, int i5) {
            }

            public void onRenderExternalAudioStats(IRtcEngineEventHandler.ExternalAudioStats externalAudioStats) {
                AgoraEngine.super.onRenderExternalAudioStats(externalAudioStats);
                long unused = AgoraEngine.this.mRenderExternalCachedTimeMs = (long) externalAudioStats.cachedTimeMs;
            }

            public void onFirstRemoteVideoDecoded(int i, int i2, int i3, int i4) {
                AgoraEngine.super.onFirstRemoteVideoDecoded(i, i2, i3, i4);
                final long j = ((long) i) & 4294967295L;
                Logger.i("AgoraEngine onFirstRemoteVideoFrame uid: " + j + ", width: " + i2 + ", height: " + i3 + ", elapsed: " + i4, new Object[0]);
                if (AgoraEngine.this.mediaDataObserverPlugin != null) {
                    AgoraEngine.this.mediaDataObserverPlugin.allocateBuffer(i, i2, i3);
                }
                if (AgoraEngine.this.mListener != null) {
                    Handler handler = AgoraEngine.this.mHandler;
                    AnonymousClass1 r6 = new Runnable() {
                        public void run() {
                            if (AgoraEngine.this.mListener != null) {
                                AgoraEngine.this.mListener.remotefirstVideoRecvWithUid(j);
                            }
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r6);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r6);
                    }
                }
            }

            public void onVideoSubscribeStateChanged(String str, int i, int i2, int i3, int i4) {
                long j = ((long) i) & 4294967295L;
                Logger.i("AgoraEngine onSubscribeVideoStateChanged room: " + AgoraEngine.this.mRoomid + ", uid: " + j + ", oldState: " + i2 + ", newState: " + i3 + ", elapsed: " + i4, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onSubscribeVideoStateChanged(i, i2, i3);
                }
                if (i2 == 2 && i3 == 3) {
                    AgoraEngine.this.mlogReport.LogStaticRemoteVideoIn(j, i4);
                }
            }

            public void onFirstRemoteAudioFrame(int i, int i2) {
                final long j = ((long) i) & 4294967295L;
                Logger.i("AgoraEngine onFirstRemoteAudioFrame room: " + AgoraEngine.this.mRoomid + ", uid: " + j + ", elapsed: " + i2, new Object[0]);
                if (AgoraEngine.this.mlogReport != null) {
                    AgoraEngine.this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, (String) null, j);
                }
                if (AgoraEngine.this.mListener != null) {
                    Handler handler = AgoraEngine.this.mHandler;
                    AnonymousClass2 r12 = new Runnable() {
                        public void run() {
                            if (AgoraEngine.this.mListener != null) {
                                AgoraEngine.this.mListener.remotefirstAudioRecvWithUid(j);
                            }
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r12);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r12);
                    }
                }
            }

            public void onCaptureVideoSizeChanged(int i, int i2) {
                Logger.i("AgoraEngine onCaptureVideoSizeChanged width = " + i + ", height = " + i2, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onCaptureVideoSize(i, i2);
                }
            }

            public void onFirstRemoteVideoFrame(int i, int i2, int i3, int i4) {
                long j = ((long) i) & 4294967295L;
                if (AgoraEngine.this.mlogReport != null) {
                    AgoraEngine.this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, "1", (String) null, j);
                }
            }

            public void onAudioSubscribeStateChanged(String str, int i, int i2, int i3, int i4) {
                long j = ((long) i) & 4294967295L;
                Logger.i("AgoraEngine onSubscribeAudioStateChanged room: " + str + ", uid: " + j + ", oldState: " + i2 + ", newState: " + i3 + ", elapsed: " + i4, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onSubscribeAudioStateChanged(i, i2, i3);
                }
                if (i2 == 2 && i3 == 3) {
                    AgoraEngine.this.mlogReport.LogStaticRemoteAudioIn(j, i4);
                }
            }

            public void onFirstLocalVideoFrame(int i, int i2, int i3) {
                Logger.i("AgoraEngine onFirstLocalVideoFrame room: " + AgoraEngine.this.mRoomid + ", width: " + i + ", height: " + i2 + ", elapsed: " + i3, new Object[0]);
                if (AgoraEngine.this.mlogReport != null) {
                    AgoraEngine.this.mlogReport.LogStaticLocalVideoIn(i3, i, i2);
                    AgoraEngine.this.mlogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_VIDEO.value);
                }
            }

            public void onAudioPublishStateChanged(String str, int i, int i2, int i3) {
                Logger.i("AgoraEngine onAudioPublishStateChanged room: " + str + ", oldState: " + i + ", newState: " + i2 + ", elapsed: " + i3, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onPublishAudioStateChanged(i, i2);
                }
                if (i == 2 && i2 == 3) {
                    AgoraEngine.this.mlogReport.LogStaticLocalAudioIn(i3);
                    AgoraEngine.this.mlogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_AUDIO.value);
                    AgoraEngine.this.mlogReport.setAudioPublished(true);
                    return;
                }
                AgoraEngine.this.mlogReport.setAudioPublished(false);
            }

            public void onVideoPublishStateChanged(String str, int i, int i2, int i3) {
                Logger.i("AgoraEngine onVideoPublishStateChanged room: " + str + ", oldState: " + i + ", newState: " + i2 + ", elapsed: " + i3, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onPublishVideoStateChanged(i, i2);
                }
                if (i == 2 && i2 == 3) {
                    if (AgoraEngine.this.mlogReport != null) {
                        AgoraEngine.this.mlogReport.LogStaticLocalVideoIn(i3, 0, 0);
                        AgoraEngine.this.mlogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_VIDEO.value);
                        AgoraEngine.this.mlogReport.setVideoPublished(true);
                    }
                    AgoraEngine.this.cachePublishChannelInfo(str);
                } else {
                    AgoraEngine.this.mlogReport.setVideoPublished(false);
                }
                if (i2 == 0 || i2 == 1) {
                    AgoraEngine.this.cachePublishChannelInfo((String) null);
                }
            }

            public void onUserJoined(int i, int i2) {
                long j = ((long) i) & 4294967295L;
                Log.i(AgoraEngine.TAG, "onUserJoined room: " + AgoraEngine.this.mRoomid + ", uid: " + j + ", elapsed: " + i2);
                Logger.i("AgoraEngine onUserJoined room: " + AgoraEngine.this.mRoomid + ", uid: " + j + ", elapsed: " + i2, new Object[0]);
                if (AgoraEngine.this.mListener != null) {
                    AgoraEngine.this.mListener.remoteUserJoinWitnUid(j);
                }
            }

            public void onUserOffline(int i, int i2) {
                long j = ((long) i) & 4294967295L;
                Logger.i("AgoraEngine onUserOffline " + AgoraEngine.this.mRoomid + " uid: " + j + ", reason: " + i2, new Object[0]);
                if (AgoraEngine.this.mListener != null) {
                    AgoraEngine.this.mListener.didOfflineOfUid(j);
                }
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.didOfflineOfUid(j, i2);
                }
                if (AgoraEngine.this.mlogReport != null) {
                    AgoraEngine.this.mlogReport.deleteUser(j);
                }
                LogCommonInfo.getInstance().removeVolume(String.valueOf(j));
                if (AgoraEngine.this.mediaDataObserverPlugin != null) {
                    AgoraEngine.this.mediaDataObserverPlugin.removeBuffer(i);
                }
            }

            public void onUserMuteVideo(int i, boolean z) {
                long j = ((long) i) & 4294967295L;
                Logger.i("AgoraEngine onUserMuteVideo uid: " + j + ", muted: " + z, new Object[0]);
                if (AgoraEngine.this.mListener != null) {
                    AgoraEngine.this.mListener.didVideoMuted(j, z);
                }
            }

            public void onVideoBufferingStateChanged(int i, int i2, long j) {
                DelayObject delayObject;
                int i3 = i2;
                long j2 = j;
                long j3 = (long) i;
                long j4 = j3 & 4294967295L;
                Logger.i("AgoraEngine onVideoBufferingStateChanged " + j4 + " " + i3 + " " + j2 + " " + System.currentTimeMillis(), new Object[0]);
                if (i3 == 0) {
                    DelayObject delayObject2 = AgoraEngine.this.delayMap.get(Integer.valueOf(i));
                    if (delayObject2 == null) {
                        DelayObject delayObject3 = new DelayObject();
                        delayObject3.isDelay = 1;
                        delayObject3.uid = j3;
                        delayObject3.roomId = AgoraEngine.this.mRoomid;
                        delayObject3.startTime = j2;
                        AgoraEngine.this.delayMap.put(Integer.valueOf(i), delayObject3);
                    } else {
                        delayObject2.startTime = j2;
                    }
                    AgoraEngine agoraEngine = AgoraEngine.this;
                    agoraEngine.renderDelayStart(j4, j, agoraEngine.mRoomid);
                } else if (i3 == 1) {
                    Iterator<Map.Entry<Integer, DelayObject>> it = AgoraEngine.this.delayMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        DelayObject delayObject4 = (DelayObject) next.getValue();
                        if (delayObject4.isDelay != 1 || !TextUtils.equals(delayObject4.roomId, AgoraEngine.this.mRoomid)) {
                            delayObject = delayObject4;
                        } else {
                            delayObject = delayObject4;
                            AgoraEngine.this.renderDelayEnd(((DelayObject) next.getValue()).uid, j, delayObject4.roomId, j2 - delayObject4.startTime);
                        }
                        if (TextUtils.equals(delayObject.roomId, AgoraEngine.this.mRoomid)) {
                            it.remove();
                        }
                        int i4 = i2;
                    }
                }
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onVideoBufferingStateChanged(j3, i2, j);
                }
            }

            public void onUserMuteAudio(int i, boolean z) {
                long j = ((long) i) & 4294967295L;
                Logger.i("AgoraEngine onUserMuteAudio uid: " + j + ", muted: " + z, new Object[0]);
                if (AgoraEngine.this.mListener != null) {
                    AgoraEngine.this.mListener.didAudioMuted(j, z);
                }
            }

            public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
                AgoraEngine.super.onVideoSizeChanged(i, i2, i3, i4);
                Log.i(AgoraEngine.TAG, "AgoraEngine onVideoSizeChanged room: " + AgoraEngine.this.mRoomid + ", uid: " + (((long) i) & 4294967295L) + ", width: " + i2 + ", height: " + i3 + ", rotation: " + i4);
            }

            public void onRemoteVideoStateChanged(int i, int i2, int i3, int i4) {
                long j = (long) i;
                long j2 = 4294967295L & j;
                Log.i(AgoraEngine.TAG, "onRemoteVideoStateChanged room: " + AgoraEngine.this.mRoomid + ", uid: " + j2 + ", state: " + i2 + ", reason: " + i3 + ", elapsed: " + i4);
                Logger.i("AgoraEngine onRemoteVideoStateChanged room: " + AgoraEngine.this.mRoomid + ", uid: " + j2 + ", state: " + i2 + ", reason: " + i3 + ", elapsed: " + i4, new Object[0]);
                if (i2 != 3 && AgoraEngine.this.mListener != null) {
                    AgoraEngine.this.mListener.onRemoteVideoStateChanged(j, i2);
                }
            }

            public void onRtcStats(IRtcEngineEventHandler.RtcStats rtcStats) {
                if (AgoraEngine.this.mlogReport != null) {
                    AgoraEngine.this.mlogReport.LogLocalAudioSentBps(rtcStats.txAudioKBitRate);
                    AgoraEngine.this.mlogReport.LogStatistics(rtcStats.lastmileDelay);
                    AgoraEngine.this.mlogReport.setGateWayRttAndAppCpu(rtcStats.gatewayRtt, (int) (rtcStats.cpuAppUsage * 100.0d));
                }
                if (AgoraEngine.this.mListener != null) {
                    AgoraEngine.this.mStatsReport.txAudioBytes = rtcStats.txAudioBytes;
                    AgoraEngine.this.mStatsReport.txVideoBytes = rtcStats.txVideoBytes;
                    AgoraEngine.this.mStatsReport.rxAudioBytes = rtcStats.rxAudioBytes;
                    AgoraEngine.this.mStatsReport.rxVideoBytes = rtcStats.rxVideoBytes;
                    AgoraEngine.this.mStatsReport.txAudioKBitRate = rtcStats.txAudioKBitRate;
                    AgoraEngine.this.mStatsReport.txVideoKBitRate = rtcStats.txVideoKBitRate;
                    AgoraEngine.this.mStatsReport.rxAudioKBitRate = rtcStats.rxAudioKBitRate;
                    AgoraEngine.this.mStatsReport.rxVideoKBitRate = rtcStats.rxVideoKBitRate;
                    AgoraEngine.this.mStatsReport.cpuAppUsage = rtcStats.cpuAppUsage;
                    AgoraEngine.this.mStatsReport.cpuTotalUsage = rtcStats.cpuTotalUsage;
                    AgoraEngine.this.mStatsReport.txPacketsLostRate = (double) rtcStats.txPacketLossRate;
                    AgoraEngine.this.mStatsReport.rxPacketsLostRate = (double) rtcStats.rxPacketLossRate;
                    AgoraEngine.this.mStatsReport.gateWayRtt = rtcStats.gatewayRtt;
                    AgoraEngine.this.mStatsReport.lastmileDelay = rtcStats.lastmileDelay;
                    AgoraEngine.this.mListener.reportRtcStats(AgoraEngine.this.mStatsReport);
                }
            }

            public void onNetworkQuality(int i, int i2, int i3) {
                long j = ((long) i) & 4294967295L;
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onNetworkQuality(j, i2, i3);
                }
                if (AgoraEngine.this.mlogReport != null) {
                    AgoraEngine.this.mlogReport.LogStaticNetworkQuality(j, i2, i3);
                }
            }

            public void onRemoteVideoStats(IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats) {
                if (AgoraEngine.this.mObserver != null) {
                    RTCEngine.RemoteVideoStats remoteVideoStats2 = new RTCEngine.RemoteVideoStats();
                    remoteVideoStats2.uid = (long) remoteVideoStats.uid;
                    remoteVideoStats2.decoderOutputFrameRate = remoteVideoStats.decoderOutputFrameRate;
                    remoteVideoStats2.height = remoteVideoStats.height;
                    remoteVideoStats2.width = remoteVideoStats.width;
                    remoteVideoStats2.rendererOutputFrameRate = remoteVideoStats.rendererOutputFrameRate;
                    remoteVideoStats2.packetLossRate = remoteVideoStats.packetLossRate;
                    remoteVideoStats2.receivedBitrate = remoteVideoStats.receivedBitrate;
                    AgoraEngine.this.mObserver.onRemoteVideoStats(remoteVideoStats2);
                }
                if (AgoraEngine.this.mlogReport != null) {
                    LogVideoRemoteStatistics logVideoRemoteStatistics = new LogVideoRemoteStatistics();
                    logVideoRemoteStatistics.uid = (long) remoteVideoStats.uid;
                    logVideoRemoteStatistics.width = remoteVideoStats.width;
                    logVideoRemoteStatistics.height = remoteVideoStats.height;
                    logVideoRemoteStatistics.receivedBitrate = remoteVideoStats.receivedBitrate;
                    logVideoRemoteStatistics.decoderOutputFrameRate = remoteVideoStats.decoderOutputFrameRate;
                    logVideoRemoteStatistics.latency = remoteVideoStats.endToEndDelayMs;
                    logVideoRemoteStatistics.avDiff = remoteVideoStats.avSyncTimeMs;
                    logVideoRemoteStatistics.delay = remoteVideoStats.delay;
                    logVideoRemoteStatistics.packetLossRate = remoteVideoStats.packetLossRate;
                    AgoraEngine.this.mlogReport.LogStaticRemoteVideoStats(logVideoRemoteStatistics);
                }
            }

            public void onRemoteAudioTransportStats(int i, int i2, int i3, int i4) {
                long j = ((long) i) & 4294967295L;
                if (AgoraEngine.this.mlogReport != null) {
                    LogAudioRemoteStatistics logAudioRemoteStatistics = new LogAudioRemoteStatistics();
                    logAudioRemoteStatistics.uid = j;
                    logAudioRemoteStatistics.jitterBufferDelay = i2;
                    logAudioRemoteStatistics.audioLossRate = i3;
                    logAudioRemoteStatistics.receivedBitrate = i4;
                    logAudioRemoteStatistics.audioVolume = 0;
                    logAudioRemoteStatistics.audioDecFps = 0;
                    AgoraEngine.this.mlogReport.LogStaticRemoteAudioTransportStats(logAudioRemoteStatistics);
                }
            }

            public void onAudioVolumeIndication(IRtcEngineEventHandler.AudioVolumeInfo[] audioVolumeInfoArr, int i) {
                if (audioVolumeInfoArr != null) {
                    for (IRtcEngineEventHandler.AudioVolumeInfo audioVolumeInfo : audioVolumeInfoArr) {
                        long j = ((long) audioVolumeInfo.uid) & 4294967295L;
                        if (AgoraEngine.this.mObserver != null) {
                            AgoraEngine.this.mObserver.reportAudioVolumeOfSpeaker(audioVolumeInfo.channelId, j, audioVolumeInfo.volume);
                        }
                        if (AgoraEngine.this.mListener != null) {
                            AgoraEngine.this.mListener.reportAudioVolumeOfSpeaker(j, audioVolumeInfo.volume);
                        }
                        if (AgoraEngine.this.mlogReport != null) {
                            AgoraEngine.this.mlogReport.LogStaticUserAudioVolume(j, audioVolumeInfo.volume);
                        }
                        LogCommonInfo.getInstance().updateVolume(String.valueOf(j), audioVolumeInfo.volume);
                    }
                }
            }

            public void onLocalVideoStats(IRtcEngineEventHandler.LocalVideoStats localVideoStats) {
                if (AgoraEngine.this.mObserver != null) {
                    RTCEngine.LocalVideoStats localVideoStats2 = new RTCEngine.LocalVideoStats();
                    localVideoStats2.captureFrameRate = localVideoStats.sentFrameRate;
                    localVideoStats2.sentBitrate = localVideoStats.sentBitrate;
                    localVideoStats2.sentFrameRate = localVideoStats.sentFrameRate;
                    localVideoStats2.targetBitrate = localVideoStats.targetBitrate;
                    localVideoStats2.targetFrameRate = localVideoStats.targetFrameRate;
                    localVideoStats2.encodedBitrate = localVideoStats.sentBitrate;
                    localVideoStats2.encodedFrameWidth = localVideoStats.encodedFrameWidth;
                    localVideoStats2.encodedFrameHeight = localVideoStats.encodedFrameHeight;
                    AgoraEngine.this.mObserver.onLocalVideoStats(localVideoStats2);
                }
                if (AgoraEngine.this.mlogReport != null) {
                    LogVideoLocalStatistics logVideoLocalStatistics = new LogVideoLocalStatistics();
                    logVideoLocalStatistics.sentBitrate = localVideoStats.sentBitrate;
                    logVideoLocalStatistics.videoTargetBps = localVideoStats.targetBitrate;
                    logVideoLocalStatistics.sentFrameRate = localVideoStats.sentFrameRate;
                    logVideoLocalStatistics.videoTargetFps = localVideoStats.targetFrameRate;
                    logVideoLocalStatistics.videoEncoded = localVideoStats.encoderOutputFrameRate;
                    logVideoLocalStatistics.mVideoLossRate = localVideoStats.txPacketLossRate;
                    logVideoLocalStatistics.encodedFrameWidth = localVideoStats.encodedFrameWidth;
                    logVideoLocalStatistics.encodedFrameHeight = localVideoStats.encodedFrameHeight;
                    logVideoLocalStatistics.uid = AgoraEngine.this.mUserid;
                    LogCommonInfo.getInstance().LogStaticLocalVideoStats(String.valueOf(AgoraEngine.this.mUserid), logVideoLocalStatistics);
                }
            }

            public void onLocalAudioStats(IRtcEngineEventHandler.LocalAudioStats localAudioStats) {
                AgoraEngine.super.onLocalAudioStats(localAudioStats);
                if (AgoraEngine.this.mObserver != null) {
                    RTCEngine.LocalAudioStats localAudioStats2 = new RTCEngine.LocalAudioStats();
                    localAudioStats2.numChannels = localAudioStats.numChannels;
                    localAudioStats2.sentSampleRate = localAudioStats.sentSampleRate;
                    localAudioStats2.sentBitrate = localAudioStats.sentBitrate;
                    localAudioStats2.txPacketLossRate = localAudioStats.txPacketLossRate;
                    AgoraEngine.this.mObserver.onLocalAudioStats(localAudioStats2);
                }
                if (AgoraEngine.this.mlogReport != null) {
                    LogAudioLocalStatistics logAudioLocalStatistics = new LogAudioLocalStatistics();
                    logAudioLocalStatistics.audioLossRate = localAudioStats.txPacketLossRate;
                    logAudioLocalStatistics.sentBitrate = localAudioStats.sentBitrate;
                    logAudioLocalStatistics.uid = AgoraEngine.this.mUserid;
                    LogCommonInfo.getInstance().LogStaticLocalAudioStats(String.valueOf(AgoraEngine.this.mUserid), logAudioLocalStatistics);
                }
            }

            public void onLocalVideoStateChanged(int i, int i2) {
                Logger.i("Agora onLocalVideoStateChanged localVideoState = " + i + ", error = " + i2, new Object[0]);
                if (i == 2 && AgoraEngine.this.mediaDataObserverPlugin != null) {
                    AgoraEngine.this.mediaDataObserverPlugin.allocateBuffer(0, 0, 0);
                }
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onLocalVideoStateChanged(i, i2);
                }
                if (AgoraEngine.this.mlogReport != null) {
                    if (i == 0) {
                        AgoraEngine.this.mlogReport.addDeviceInfo("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, (String) null);
                    } else if (i == 1) {
                        AgoraEngine.this.mlogReport.addDeviceInfo("1", "1", (String) null);
                    }
                    if (i2 == 1) {
                        AgoraEngine.this.mlogReport.addDeviceInfo("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "unknown");
                    } else if (i2 == 2) {
                        AgoraEngine.this.mlogReport.addDeviceInfo("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "no_permission");
                    } else if (i2 == 3) {
                        AgoraEngine.this.mlogReport.addDeviceInfo("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "busy");
                    }
                }
            }

            public void onLocalAudioStateChanged(int i, int i2) {
                Logger.i("Agora onLocalAudioStateChanged state = " + i + ", error = " + i2, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onLocalAudioStateChanged(i, i2);
                }
                if (AgoraEngine.this.mlogReport != null) {
                    if (i == 0) {
                        AgoraEngine.this.mlogReport.addDeviceInfo(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, (String) null);
                    } else if (i == 1) {
                        AgoraEngine.this.mlogReport.addDeviceInfo(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, "1", (String) null);
                    }
                    if (i2 == 1) {
                        AgoraEngine.this.mlogReport.addDeviceInfo(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "unknown");
                    } else if (i2 == 2) {
                        AgoraEngine.this.mlogReport.addDeviceInfo(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "no_permission");
                    } else if (i2 == 3) {
                        AgoraEngine.this.mlogReport.addDeviceInfo(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "busy");
                    }
                }
            }

            public void onLeaveChannel(IRtcEngineEventHandler.RtcStats rtcStats) {
                Logger.i("AgoraEngine onLeaveChannel", new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onLeaveChannel();
                }
            }

            public void onLastmileQuality(int i) {
                if (AgoraEngine.this.mListener != null) {
                    AgoraEngine.this.mListener.onOnceLastMileQuality(RTCEngine.RTC_LASTMILE_QUALITY.values()[i]);
                }
            }

            public void onClientRoleChanged(int i, int i2) {
                AgoraEngine.super.onClientRoleChanged(i, i2);
            }

            public void onError(int i) {
                Log.e(AgoraEngine.TAG, "onError " + i);
                Logger.e("AgoraEngine onError " + i, new Object[0]);
                if (AgoraEngine.this.mListener != null) {
                    if (i == 110 || i == 101) {
                        AgoraEngine.this.mListener.didOccurError(RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeInvalidToken);
                    } else if (i == 109) {
                        AgoraEngine.this.mListener.didOccurError(RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeTokenExpired);
                    } else if (i == 1003) {
                        AgoraEngine.this.mListener.didOccurError(RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeStartCamera);
                    } else if (i == 1004) {
                        AgoraEngine.this.mListener.didOccurError(RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeStartVideoRender);
                    } else if (i == 1109) {
                        AgoraEngine.this.mListener.didOccurError(RTCEngine.RTCEngineErrorCode.RTC_ERR_AUDIOTRACKOVERFLOW);
                    } else if (i < 1005 || i > 1360) {
                        Log.e(AgoraEngine.TAG, "onError " + i + " " + RtcEngine.getErrorDescription(i));
                    } else {
                        AgoraEngine.this.mListener.didOccurError(RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodesAudioError);
                    }
                }
            }

            public void onStreamMessage(int i, int i2, byte[] bArr) {
                long j = (long) i;
                if (bArr != null) {
                    if (bArr.length == 24 && CommonUtils.isTSMsg(bArr)) {
                        synchronized (AgoraEngine.this.mTimestampRecLock) {
                            AgoraEngine.this.mMetadataRecTimestampMap.put(Integer.valueOf(i), Long.valueOf(AgoraEngine.longFrom8Bytes(bArr, 16, false)));
                            AgoraEngine.this.mRecTimestampMap.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
                        }
                    } else if (bArr.length > 24 && CommonUtils.isIRCMsg(bArr)) {
                        int length = bArr.length - 24;
                        byte[] bArr2 = new byte[length];
                        System.arraycopy(bArr, 24, bArr2, 0, length);
                        if (AgoraEngine.this.mObserver != null) {
                            AgoraEngine.this.mObserver.onStreamMessage(j, bArr2);
                        }
                    }
                }
            }

            public void onConnectionStateChanged(int i, int i2) {
                String str;
                int i3 = i;
                final int i4 = i2;
                Logger.i("AgoraEngine onConnectionStateChanged state = " + i3 + "reason = " + i4, new Object[0]);
                if (AgoraEngine.this.mListener != null) {
                    if (i4 == 3) {
                        Logger.i("AgoraEngine CONNECTION_CHANGED_BANNED_BY_SERVER", new Object[0]);
                        AgoraEngine.this.doEngineChangeNotify();
                        return;
                    }
                    String str2 = "setting_proxy_server";
                    if (i3 == 1) {
                        Handler handler = AgoraEngine.this.mHandler;
                        AnonymousClass3 r3 = new Runnable() {
                            public void run() {
                                if (AgoraEngine.this.mListener != null) {
                                    AgoraEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeDisconnected, RtcConnectReason.getReason(i4));
                                }
                            }
                        };
                        String str3 = "banned_by_server";
                        if (!(handler instanceof Handler)) {
                            handler.post(r3);
                        } else {
                            AsynchronousInstrumentation.handlerPost(handler, r3);
                        }
                        if (AgoraEngine.this.mlogReport != null) {
                            if (i4 != 123) {
                                switch (i4) {
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
                                        str2 = "rejected_by_server";
                                        break;
                                    case 11:
                                        break;
                                    case 12:
                                        str2 = "renew_token";
                                        break;
                                    case 13:
                                        str2 = "client_ip_address_changed";
                                        break;
                                    case 14:
                                        str2 = "keep_alive_timeout";
                                        break;
                                    default:
                                        str2 = RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedInterrupted;
                                        break;
                                }
                            } else {
                                str2 = str3;
                            }
                            AgoraEngine.this.mlogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ, str2, -1);
                            AgoraEngine.this.mlogReport.roomDisconnect(AgoraEngine.this.mRoomid, AgoraEngine.this.mUserid, LOGErrorCode.LOG_Disconnected.value, AgoraEngine.this.mlostReasion);
                        }
                    } else if (i3 == 2) {
                        long unused = AgoraEngine.this.startConnectime = System.currentTimeMillis();
                        if (AgoraEngine.this.mlogReport != null) {
                            AgoraEngine.this.mlogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedConnecting, -1);
                        }
                        AgoraEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeConnecting, RtcConnectReason.getReason(i2));
                    } else if (i3 == 3) {
                        if (AgoraEngine.this.mlogReport != null) {
                            AgoraEngine.this.mlogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, FirebaseAnalytics.Param.SUCCESS, -1);
                        }
                        Handler handler2 = AgoraEngine.this.mHandler;
                        AnonymousClass4 r6 = new Runnable() {
                            public void run() {
                                if (AgoraEngine.this.mListener != null) {
                                    AgoraEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeConnected, RtcConnectReason.getReason(i4));
                                }
                            }
                        };
                        if (!(handler2 instanceof Handler)) {
                            handler2.post(r6);
                        } else {
                            AsynchronousInstrumentation.handlerPost(handler2, r6);
                        }
                        if (AgoraEngine.this.mlogReport != null) {
                            AgoraEngine.this.mlogReport.roomReconnect(AgoraEngine.this.mRoomid, AgoraEngine.this.mUserid, LOGErrorCode.LOG_Success.value, AgoraEngine.this.startConnectime, System.currentTimeMillis(), AgoraEngine.this.mreCountNum);
                        }
                        int unused2 = AgoraEngine.this.mreCountNum = 0;
                    } else if (i3 == 4) {
                        AgoraEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeReconnecting, RtcConnectReason.getReason(i2));
                        AgoraEngine.access$1208(AgoraEngine.this);
                    } else if (i3 == 5) {
                        if (i4 != 123) {
                            switch (i4) {
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
                                    str = "rejected_by_server";
                                    break;
                                case 11:
                                    str = str2;
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
                        } else {
                            str = "banned_by_server";
                        }
                        if (AgoraEngine.this.mlogReport != null) {
                            AgoraEngine.this.mlogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_OPPO, str, -1);
                        }
                        AgoraEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeFailed, RtcConnectReason.getReason(i2));
                    }
                    if (!(i4 == 4 || i4 == 123)) {
                        switch (i4) {
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                                break;
                            default:
                                return;
                        }
                    }
                    if (AgoraEngine.this.mlogReport != null) {
                        AgoraEngine.this.mlogReport.sendCommonError("engineError", AgoraEngine.this.mRoomid, i3 + " " + i4 + "", i4 + "");
                        AgoraEngine.this.mlogReport.joinRoom(0, AgoraEngine.this.mlogReport.getmUserid(), LOGErrorCode.LOG_Fail.value, "joined room fail", 0);
                    }
                }
            }

            public void onConnectionLost() {
                Logger.e("AgoraEngine onConnectionLost", new Object[0]);
                Log.e(AgoraEngine.TAG, "onConnectionLost");
                if (AgoraEngine.this.mListener != null) {
                    Handler handler = AgoraEngine.this.mHandler;
                    AnonymousClass5 r1 = new Runnable() {
                        public void run() {
                            if (AgoraEngine.this.mListener != null) {
                                AgoraEngine.this.mListener.connectionChangedToState(RTCConnectionStateType.RTCConnectionStateTypeDisconnected, "");
                            }
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r1);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r1);
                    }
                }
                if (AgoraEngine.this.mlogReport != null) {
                    AgoraEngine.this.mlogReport.roomDisconnect(AgoraEngine.this.mRoomid, AgoraEngine.this.mUserid, LOGErrorCode.LOG_Disconnected.value, AgoraEngine.this.mlostReasion);
                }
            }

            public void onJoinChannelSuccess(String str, int i, int i2) {
                final long j = ((long) i) & 4294967295L;
                Logger.i("AgoraEngine onJoinChannelSuccess " + str + " uid: " + j + " " + i2, new Object[0]);
                Handler handler = AgoraEngine.this.mHandler;
                AnonymousClass6 r13 = new Runnable() {
                    public void run() {
                        synchronized (AgoraEngine.gLock) {
                            if (AgoraEngine.this.mAgoraEngine != null) {
                                int unused = AgoraEngine.this.mDataStreamId = AgoraEngine.this.mAgoraEngine.createDataStream(false, false);
                            }
                        }
                    }
                };
                if (!(handler instanceof Handler)) {
                    handler.post(r13);
                } else {
                    AsynchronousInstrumentation.handlerPost(handler, r13);
                }
                if (AgoraEngine.this.mListener != null) {
                    Handler handler2 = AgoraEngine.this.mHandler;
                    AnonymousClass7 r132 = new Runnable() {
                        public void run() {
                            if (AgoraEngine.this.mListener != null) {
                                AgoraEngine.this.mListener.localUserJoindWithUid(j);
                            }
                        }
                    };
                    if (!(handler2 instanceof Handler)) {
                        handler2.post(r132);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler2, r132);
                    }
                }
                long unused = AgoraEngine.this.joinRoomEndTime = System.currentTimeMillis();
                AgoraEngine agoraEngine = AgoraEngine.this;
                long unused2 = agoraEngine.joinRoomDelay = agoraEngine.joinRoomEndTime - AgoraEngine.this.joinRoomStartTime;
                if (AgoraEngine.this.mlogReport != null) {
                    String channelCallId = AgoraEngine.this.mAgoraEngine.getChannelCallId();
                    if (channelCallId != null) {
                        AgoraEngine.this.mlogReport.setSessionId(channelCallId);
                    } else {
                        AgoraEngine.this.mlogReport.setSessionId("");
                    }
                    AgoraEngine.this.mlogReport.setStreamId(AgoraEngine.this.mAgoraEngine.getCallId());
                    AgoraEngine.this.mlogReport.joinRoom(i2, j, LOGErrorCode.LOG_Success.value, "joined room successfully", 0);
                }
            }

            public void onRejoinChannelSuccess(String str, int i, int i2) {
                Logger.i("AgoraEngine onRejoinChannelSuccess channel = " + str + " ,uid = " + i + " ,elapsed = " + i2, new Object[0]);
                final long j = ((long) i) & 4294967295L;
                if (AgoraEngine.this.mListener != null) {
                    Handler handler = AgoraEngine.this.mHandler;
                    AnonymousClass8 r11 = new Runnable() {
                        public void run() {
                            if (AgoraEngine.this.mListener != null) {
                                AgoraEngine.this.mListener.localUserJoindWithUid(j);
                            }
                        }
                    };
                    if (!(handler instanceof Handler)) {
                        handler.post(r11);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, r11);
                    }
                }
                if (AgoraEngine.this.mlogReport != null) {
                    AgoraEngine.this.mlogReport.setStreamId(AgoraEngine.this.mAgoraEngine.getCallId());
                    AgoraEngine.this.mlogReport.joinRoom(i2, j, LOGErrorCode.LOG_Success.value, "ReJoined room successfully", 1);
                }
            }

            public void onWarning(int i) {
                Log.w(AgoraEngine.TAG, "onWarning " + i);
                Logger.w("AgoraEngine onWarning " + i, new Object[0]);
                if (AgoraEngine.this.mListener != null && i == 1051) {
                    AgoraEngine.this.mListener.didOccurError(RTCEngine.RTCEngineErrorCode.RTC_ERR_HOWLING);
                }
            }

            public void onRtmpStreamingStateChanged(String str, int i, int i2) {
                AgoraEngine.super.onRtmpStreamingStateChanged(str, i, i2);
                Logger.i("AgoraEngine onRtmpStreamingStateChanged url = " + str + " state = " + i + " errCode = " + i2, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onRtmpStreamingStateChanged(str, i, i2);
                }
                if (AgoraEngine.this.mlogReport != null) {
                    AgoraEngine.this.mlogReport.pushRtmpState(str, i + "", i2 + "");
                }
            }

            public void onRemoteAudioStats(IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats) {
                AgoraEngine.super.onRemoteAudioStats(remoteAudioStats);
                int i = remoteAudioStats.uid;
                if (AgoraEngine.this.mObserver != null) {
                    RTCEngine.RemoteAudioStats remoteAudioStats2 = new RTCEngine.RemoteAudioStats();
                    remoteAudioStats2.uid = (long) remoteAudioStats.uid;
                    remoteAudioStats2.audioLossRate = remoteAudioStats.audioLossRate;
                    remoteAudioStats2.numChannels = remoteAudioStats.numChannels;
                    remoteAudioStats2.receivedSampleRate = remoteAudioStats.receivedSampleRate;
                    remoteAudioStats2.receivedBitrate = remoteAudioStats.receivedBitrate;
                    AgoraEngine.this.mObserver.onRemoteAudioStats(remoteAudioStats2);
                }
                if (AgoraEngine.this.mObserver != null) {
                    RTCEngine.RTCAudioStats rTCAudioStats = new RTCEngine.RTCAudioStats();
                    rTCAudioStats.uid = remoteAudioStats.uid;
                    rTCAudioStats.audioLossRate = remoteAudioStats.audioLossRate;
                    rTCAudioStats.jitterBufferDelay = remoteAudioStats.jitterBufferDelay;
                    rTCAudioStats.networkTransportDelay = remoteAudioStats.networkTransportDelay;
                    AgoraEngine.this.mObserver.onAudioStats(rTCAudioStats);
                }
            }

            public void onStreamPublished(String str, int i) {
                AgoraEngine.super.onStreamPublished(str, i);
                Logger.i("AgoraEngine onStreamPublished url = " + str + " error = " + i, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onStreamPublished(str, i);
                }
            }

            public void onStreamUnpublished(String str) {
                AgoraEngine.super.onStreamUnpublished(str);
                Logger.i("AgoraEngine onStreamUnpublished url = " + str, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onStreamUnpublished(str);
                }
            }

            public void onTranscodingUpdated() {
                AgoraEngine.super.onTranscodingUpdated();
            }

            public void onAudioMixingStateChanged(int i, int i2) {
                AgoraEngine.super.onAudioMixingStateChanged(i, i2);
                int i3 = 0;
                Logger.i("AgoraEngine onAudioMixingStateChanged state = " + i + " errorCode = " + i2, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    if (i != 710) {
                        if (i == 711) {
                            i3 = 1;
                        } else if (i == 713) {
                            i3 = 2;
                        } else if (i == 714) {
                            i3 = 3;
                            if (AgoraEngine.this.mlogReport != null) {
                                AgoraEngine.this.mlogReport.sendCommonError("musicError", AgoraEngine.this.mRoomid, i + "", i2 + "");
                            }
                        } else {
                            i3 = -1;
                        }
                    }
                    AgoraEngine.this.mObserver.onPlayMusicSateChanged(i3, i2);
                }
            }

            public void onChannelMediaRelayStateChanged(int i, int i2) {
                AgoraEngine.super.onChannelMediaRelayStateChanged(i, i2);
                Logger.i("AgoraEngine onChannelMediaRelayStateChanged state = " + i + " code = " + i2, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onChannelMediaRelayStateChanged(i, i2);
                }
            }

            public void onChannelMediaRelayEvent(int i) {
                AgoraEngine.super.onChannelMediaRelayEvent(i);
                Logger.i("AgoraEngine onChannelMediaRelayEvent code = " + i, new Object[0]);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onChannelMediaRelayEvent(i);
                }
            }

            public void onRemoteStreamSubscribeAdvice(String str, int i, int i2, int i3) {
                AgoraEngine.super.onRemoteStreamSubscribeAdvice(str, i, i2, i3);
                if (AgoraEngine.this.mObserver != null) {
                    AgoraEngine.this.mObserver.onRemoteStreamSubscribeAdvice((long) i, i2, i3);
                }
            }

            public void onSnapshotTaken(String str, int i, String str2, int i2, int i3, int i4) {
                String str3;
                String str4;
                String str5;
                String str6;
                String str7 = str;
                int i5 = i2;
                int i6 = i3;
                int i7 = i4;
                AgoraEngine.super.onSnapshotTaken(str, i, str2, i2, i3, i4);
                long j = ((long) i) & 4294967295L;
                if (i7 != 0) {
                    Logger.e("AgoraEngine takeSnapshot failed channel: " + str7 + ", uid: " + j + ", width: " + i5 + ", height: " + i6 + ", errCode: " + i7, new Object[0]);
                    return;
                }
                if (!str2.equals(AgoraEngine.this.agoraInspectFileName)) {
                    str5 = ", uid: ";
                    str6 = ", width: ";
                    str3 = ", errCode: ";
                    str4 = ", height: ";
                    Bitmap decodeFile = BitmapFactoryInstrumentation.decodeFile(str2);
                    if (AgoraEngine.this.mObserver != null && j == 0) {
                        AgoraEngine.this.mObserver.onTakeLocalViewSnapshot(decodeFile);
                    }
                    if (AgoraEngine.this.mObserver != null && j > 0) {
                        AgoraEngine.this.mObserver.onTakeRemoteViewSnapshot(j, decodeFile);
                    }
                } else if (AgoraEngine.this.mContentInspectListener != null) {
                    str5 = ", uid: ";
                    str6 = ", width: ";
                    str3 = ", errCode: ";
                    str4 = ", height: ";
                    AgoraEngine.this.mContentInspectListener.onTakePreEncodeSnapshot(str, i, str2, i2, i3, i4);
                } else {
                    str5 = ", uid: ";
                    str6 = ", width: ";
                    str3 = ", errCode: ";
                    str4 = ", height: ";
                }
                Logger.i("AgoraEngine onSnapshotTaken channel: " + str7 + str5 + j + str6 + i5 + str4 + i6 + str3 + i4, new Object[0]);
            }
        };
        this.mAgoraRtcEventHandler = r2;
        synchronized (gLock) {
            this.mContext = context;
            this.mListener = iRtcEngineEventListener;
            this.mToken = str2;
            this.mRoomid = str3;
            this.mUserid = j;
            this.mlogReport = logReport;
            try {
                this.mAgoraEngine = RtcEngine.create(context, str, r2);
                Logger.i("AgoraEngine create  ======================", new Object[0]);
                RtcEngine rtcEngine = this.mAgoraEngine;
                if (rtcEngine != null) {
                    rtcEngine.setParameters("{ \"rtc.min_playout_delay\": 200 }");
                    this.mAgoraEngine.setParameters("{ \"rtc.remote_subscribe_fallback_option\": 0 }");
                    this.mAgoraEngine.setParameters("{ \"rtc.video.downMaxRetryTimes\": 10 }");
                    this.mAgoraEngine.setParameters("{ \"che.audio.external_render_stats_interval\": 100 }");
                    this.mAgoraEngine.enableWebSdkInteroperability(true);
                    this.mAgoraEngine.setChannelProfile(1);
                    this.mAgoraEngine.setClientRole(1);
                    this.mAgoraEngine.enableAudioVolumeIndication(300, 3, true);
                    this.mAgoraEngine.setAudioProfile(0, 2);
                    this.mAgoraEngine.enableVideo();
                } else {
                    Logger.e("AgoraEngine create Failed!", new Object[0]);
                }
            } catch (Exception e) {
                Log.e(TAG, Log.getStackTraceString(e));
                Logger.e("AgoraEngine " + Log.getStackTraceString(e), new Object[0]);
            }
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

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setRole(com.eaydu.omni.RTCEngine.RTCRole r5) {
        /*
            r4 = this;
            java.lang.Object r0 = gLock
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            r1.<init>()     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = "AgoraEngine setRole role = "
            r1.append(r2)     // Catch:{ all -> 0x0038 }
            r1.append(r5)     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0038 }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0038 }
            com.eaydu.omni.logger.Logger.i(r1, r3)     // Catch:{ all -> 0x0038 }
            io.agora.rtc.RtcEngine r1 = r4.mAgoraEngine     // Catch:{ all -> 0x0038 }
            if (r1 != 0) goto L_0x0021
            r5 = -1
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            return r5
        L_0x0021:
            com.eaydu.omni.RTCEngine$RTCRole r1 = com.eaydu.omni.RTCEngine.RTCRole.RTCRoleBroadcaster     // Catch:{ all -> 0x0038 }
            if (r5 != r1) goto L_0x002c
            io.agora.rtc.RtcEngine r5 = r4.mAgoraEngine     // Catch:{ all -> 0x0038 }
            r1 = 1
            r5.setClientRole(r1)     // Catch:{ all -> 0x0038 }
            goto L_0x0036
        L_0x002c:
            com.eaydu.omni.RTCEngine$RTCRole r1 = com.eaydu.omni.RTCEngine.RTCRole.RTCRoleAudience     // Catch:{ all -> 0x0038 }
            if (r5 != r1) goto L_0x0036
            io.agora.rtc.RtcEngine r5 = r4.mAgoraEngine     // Catch:{ all -> 0x0038 }
            r1 = 2
            r5.setClientRole(r1)     // Catch:{ all -> 0x0038 }
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            return r2
        L_0x0038:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.AgoraEngine.setRole(com.eaydu.omni.RTCEngine$RTCRole):int");
    }

    public void setObserver(RTCEngine.RtcEngineEventObserver rtcEngineEventObserver) {
        super.setObserver(rtcEngineEventObserver);
        this.mObserver = rtcEngineEventObserver;
        Logger.i("AgoraEngine setObserver", new Object[0]);
    }

    public void setMediaVideoProcessListener(RTCEngine.IRTCMediaVideoProcess iRTCMediaVideoProcess) {
        MediaDataObserverPlugin mediaDataObserverPlugin2;
        synchronized (gLock) {
            Logger.i("AgoraEngine setMediaVideoProcessListener", new Object[0]);
            this.mIRTCMediaVideoProcess = iRTCMediaVideoProcess;
            if (this.mediaDataObserverPlugin == null) {
                MediaDataObserverPlugin the = MediaDataObserverPlugin.the();
                this.mediaDataObserverPlugin = the;
                MediaPreProcessing.setDataCallback(the);
                MediaPreProcessing.setAudioCapturingBuffer(this.mediaDataObserverPlugin.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_CAPTURING);
                MediaPreProcessing.setAudioPlayingBuffer(this.mediaDataObserverPlugin.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_PLAYING);
                MediaPreProcessing.setAudioMixedBuffer(this.mediaDataObserverPlugin.PRE_ALLOC_BYTE_BUFFER_FOR_AFTER_AUDIO_MIXING);
            }
            this.mediaDataObserverPlugin.removeVideoObserver(this.mMediaDataVideoObserver);
            if (!(iRTCMediaVideoProcess == null || (mediaDataObserverPlugin2 = this.mediaDataObserverPlugin) == null)) {
                mediaDataObserverPlugin2.addVideoObserver(this.mMediaDataVideoObserver);
            }
        }
    }

    public void setMediaAudioProcessListener(RTCEngine.IRTCMediaAudioProcess iRTCMediaAudioProcess) {
        MediaDataObserverPlugin mediaDataObserverPlugin2;
        synchronized (gLock) {
            Logger.i("AgoraEngine setMediaAudioProcessListener", new Object[0]);
            this.mIRTCMediaAudioProcess = iRTCMediaAudioProcess;
            if (this.mediaDataObserverPlugin == null) {
                MediaDataObserverPlugin the = MediaDataObserverPlugin.the();
                this.mediaDataObserverPlugin = the;
                MediaPreProcessing.setDataCallback(the);
                MediaPreProcessing.setAudioCapturingBuffer(this.mediaDataObserverPlugin.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_CAPTURING);
                MediaPreProcessing.setAudioPlayingBuffer(this.mediaDataObserverPlugin.PRE_ALLOC_BYTE_BUFFER_FOR_AUDIO_PLAYING);
                MediaPreProcessing.setAudioMixedBuffer(this.mediaDataObserverPlugin.PRE_ALLOC_BYTE_BUFFER_FOR_AFTER_AUDIO_MIXING);
            }
            this.mediaDataObserverPlugin.removeAudioObserver(this.mMediaDataAudioObserver);
            if (!(iRTCMediaAudioProcess == null || (mediaDataObserverPlugin2 = this.mediaDataObserverPlugin) == null)) {
                mediaDataObserverPlugin2.addAudioObserver(this.mMediaDataAudioObserver);
            }
        }
    }

    public void setPlayBackAudioObserver(RTCEngine.IRTCAudioObserver iRTCAudioObserver) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setPlayBackAudioObserver", new Object[0]);
            this.mIRTCMediaAudioObserver = iRTCAudioObserver;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setRtcEngineLog(java.lang.String r5, com.eaydu.omni.RTCEngine.RTCEngineLogLevel r6) {
        /*
            r4 = this;
            java.lang.Object r0 = gLock
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r1.<init>()     // Catch:{ all -> 0x0072 }
            java.lang.String r2 = "AgoraEngine setRtcEngineLog --- fileFullPath ="
            r1.append(r2)     // Catch:{ all -> 0x0072 }
            r1.append(r5)     // Catch:{ all -> 0x0072 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0072 }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0072 }
            com.eaydu.omni.logger.Logger.i(r1, r3)     // Catch:{ all -> 0x0072 }
            io.agora.rtc.RtcEngine r1 = r4.mAgoraEngine     // Catch:{ all -> 0x0072 }
            r3 = -1
            if (r1 != 0) goto L_0x0021
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            return r3
        L_0x0021:
            if (r5 == 0) goto L_0x006f
            java.lang.String r1 = ""
            boolean r1 = r5.equals(r1)     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x002c
            goto L_0x006f
        L_0x002c:
            java.lang.String r1 = "/"
            boolean r1 = r5.endsWith(r1)     // Catch:{ all -> 0x0072 }
            if (r1 == 0) goto L_0x0046
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r1.<init>()     // Catch:{ all -> 0x0072 }
            r1.append(r5)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = "agoraLog.txt"
            r1.append(r5)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0072 }
            goto L_0x0057
        L_0x0046:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            r1.<init>()     // Catch:{ all -> 0x0072 }
            r1.append(r5)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = "/agoraLog.txt"
            r1.append(r5)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x0072 }
        L_0x0057:
            io.agora.rtc.RtcEngine r1 = r4.mAgoraEngine     // Catch:{ all -> 0x0072 }
            int r5 = r1.setLogFile(r5)     // Catch:{ all -> 0x0072 }
            if (r5 != 0) goto L_0x006d
            io.agora.rtc.RtcEngine r5 = r4.mAgoraEngine     // Catch:{ all -> 0x0072 }
            int r6 = r6.getValue()     // Catch:{ all -> 0x0072 }
            int r5 = r5.setLogFilter(r6)     // Catch:{ all -> 0x0072 }
            if (r5 != 0) goto L_0x006d
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            return r2
        L_0x006d:
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            return r3
        L_0x006f:
            r5 = -2
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            return r5
        L_0x0072:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.AgoraEngine.setRtcEngineLog(java.lang.String, com.eaydu.omni.RTCEngine$RTCEngineLogLevel):int");
    }

    public int setRecordingAudioParameters(int i, int i2) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setRecordingAudioParameters sample = " + i + " channel = " + i2, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine == null) {
                return -1;
            }
            int i3 = (i / 100) * i2;
            if (i3 < 160) {
                i3 = 160;
            }
            int recordingAudioFrameParameters = rtcEngine.setRecordingAudioFrameParameters(i, i2, 0, i3);
            return recordingAudioFrameParameters;
        }
    }

    public void enableLastmileProbeTest() {
        synchronized (gLock) {
            Logger.i("AgoraEngine enableLastmileProbeTest", new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.enableLastmileTest();
            }
        }
    }

    public void disableLastmileProbeTest() {
        synchronized (gLock) {
            Logger.i("AgoraEngine disableLastmileProbeTest", new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.disableLastmileTest();
            }
        }
    }

    public int joinRoom() {
        int i;
        synchronized (gLock) {
            i = 0;
            Logger.i("AgoraEngine joinRoom " + this.mRoomid + " " + this.mUserid + " with version: " + RtcEngine.getSdkVersion(), new Object[0]);
            LogReport logReport = this.mlogReport;
            if (logReport != null) {
                logReport.setRoomid(this.mRoomid);
            }
            this.joinRoomStartTime = System.currentTimeMillis();
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                int joinChannel = rtcEngine.joinChannel(this.mToken, this.mRoomid, "", (int) this.mUserid);
                Logger.i("AgoraEngine joinRoom result = " + joinChannel, new Object[0]);
                i = joinChannel;
            }
        }
        return i;
    }

    public void leaveRoom() {
        synchronized (gLock) {
            Logger.i("AgoraEngine leaveRoom " + this.mRoomid, new Object[0]);
            this.mDataStreamId = -1;
            this.leaveRoomStartTime = System.currentTimeMillis();
            this.mLocalMirrorMode = 0;
            Iterator<Map.Entry<Integer, DelayObject>> it = this.delayMap.entrySet().iterator();
            while (it.hasNext()) {
                DelayObject delayObject = (DelayObject) it.next().getValue();
                if (delayObject.isDelay == 1 && TextUtils.equals(delayObject.roomId, this.mRoomid)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    renderDelayEnd(delayObject.uid, currentTimeMillis, delayObject.roomId, currentTimeMillis - delayObject.startTime);
                }
                if (TextUtils.equals(delayObject.roomId, this.mRoomid)) {
                    it.remove();
                }
            }
            cachePublishChannelInfo((String) null);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.leaveChannel();
            }
            LogReport logReport = this.mlogReport;
            if (logReport != null) {
                logReport.leaveRoom(this.mRoomid, this.mUserid, LOGErrorCode.LOG_Success.value, "LeaveRoom bye bye", System.currentTimeMillis() - this.leaveRoomStartTime);
            }
        }
    }

    public void destory() {
        synchronized (gLock) {
            Logger.i("AgoraEngine destory ======================", new Object[0]);
            doStopObserveMediaDataFromRtcEngine();
            cachePublishChannelInfo((String) null);
            if (this.mAgoraEngine != null) {
                RtcEngine.destroy();
                MediaPreProcessing.release();
                MediaDataObserverPlugin.VideoDataCallbackOptions.NEED_JAVA_LOCAL_VIDEO_DATA = true;
                MediaDataObserverPlugin.VideoDataCallbackOptions.NEED_JAVA_REMOTE_VIDEO_DATA = true;
                this.mAgoraEngine = null;
            }
            this.lastEngineChangeNotifyTime = 0;
        }
    }

    private void doStopObserveMediaDataFromRtcEngine() {
        MediaDataObserverPlugin mediaDataObserverPlugin2 = this.mediaDataObserverPlugin;
        if (mediaDataObserverPlugin2 != null) {
            mediaDataObserverPlugin2.removeAudioObserver(this.mMediaDataAudioObserver);
            this.mediaDataObserverPlugin.removeVideoObserver(this.mMediaDataVideoObserver);
            this.mediaDataObserverPlugin.removeAllBuffers();
        }
    }

    public String getSdkVersion() {
        return RtcEngine.getSdkVersion();
    }

    public void enableLocalVideo(boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine enableLocalVideo enable = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.enableLocalVideo(z);
            }
        }
    }

    public void enableLocalAudio(boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine enableLocalAudio enable = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                if (z) {
                    rtcEngine.enableLocalAudio(true);
                } else {
                    rtcEngine.enableLocalAudio(false);
                }
            }
        }
    }

    public int muteLocalVideo(boolean z) {
        int i;
        synchronized (gLock) {
            Logger.i("AgoraEngine muteLocalVideo muted = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                i = rtcEngine.muteLocalVideoStream(z);
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
                    Logger.i("AgoraEngine muteLocalVideo failed code  = " + i, new Object[0]);
                }
            } else {
                i = -1;
            }
            LogReport logReport2 = this.mlogReport;
            if (logReport2 != null) {
                if (z) {
                    logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_OPPO, (String) null, -1);
                } else {
                    logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_ST, (String) null, -1);
                }
            }
        }
        return i;
    }

    public int muteLocalAudio(boolean z) {
        int i;
        synchronized (gLock) {
            Logger.i("AgoraEngine muteLocalAudio muted = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                i = rtcEngine.muteLocalAudioStream(z);
                if (i == 0) {
                    LogReport logReport = this.mlogReport;
                    if (logReport != null && z) {
                        logReport.LogStopPublish(this.mUserid, LOGMediaType.LOG_MEDIA_AUDIO.value);
                    }
                } else {
                    Logger.i("AgoraEngine muteLocalAudio failed code = " + i, new Object[0]);
                }
            } else {
                i = -1;
            }
            LogReport logReport2 = this.mlogReport;
            if (logReport2 != null) {
                if (z) {
                    logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_VIVO, (String) null, -1);
                } else {
                    logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "8", (String) null, -1);
                }
            }
        }
        return i;
    }

    public void muteRemoteVideo(long j, boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine muteRemoteVideo uid = " + j + " enable = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.muteRemoteVideoStream((int) j, z);
            }
            LogReport logReport = this.mlogReport;
            if (logReport != null) {
                if (z) {
                    logReport.LogStopPlay(j, LOGMediaType.LOG_MEDIA_VIDEO.value);
                    this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "9", (String) null, j);
                } else {
                    logReport.LogStaticRemoteVideoIn(j, 0);
                    this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "11", (String) null, j);
                }
            }
        }
    }

    public void muteRemoteAudio(long j, boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine muteRemoteAudio uid = " + j + " enable = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.muteRemoteAudioStream((int) j, z);
            }
            LogReport logReport = this.mlogReport;
            if (logReport != null) {
                if (z) {
                    logReport.LogStopPlay(j, LOGMediaType.LOG_MEDIA_AUDIO.value);
                    this.mlogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "10", (String) null, j);
                } else {
                    logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "12", (String) null, j);
                }
            }
        }
    }

    public void muteAllRemoteVideo(boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine muteAllRemoteVideo mute = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.muteAllRemoteVideoStreams(z);
            }
            LogReport logReport = this.mlogReport;
            if (logReport != null) {
                if (z) {
                    logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "1", (String) null, -1);
                } else {
                    logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, (String) null, -1);
                }
            }
        }
    }

    public void muteAllRemoteAudio(boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine muteAllRemoteAudio mute = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.muteAllRemoteAudioStreams(z);
            }
            LogReport logReport = this.mlogReport;
            if (logReport != null) {
                if (z) {
                    logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, (String) null, -1);
                } else {
                    logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ, (String) null, -1);
                }
            }
        }
    }

    public void cachePublishChannelInfo(String str) {
        this.mPublishChannelId = str;
    }

    public int takeLocalViewSnapshot() {
        synchronized (gLock) {
            int i = -1;
            if (TextUtils.isEmpty(this.mPublishChannelId)) {
                Logger.e("AgoraEngine takeLocalViewSnapshot error no publishing streaming " + this.mPublishChannelId, new Object[0]);
                return -1;
            }
            String str = this.mContext.getCacheDir().getAbsolutePath() + File.separatorChar + this.mPublishChannelId + "_" + 0 + ".jpeg";
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                i = rtcEngine.takeSnapshot(this.mPublishChannelId, 0, str);
            }
            Logger.i("AgoraEngine takeLocalViewSnapshot channelId: " + this.mPublishChannelId + ", target: " + str + ", ret = " + i, new Object[0]);
            return i;
        }
    }

    /* access modifiers changed from: package-private */
    public int takeRemoteViewSnapshot(String str, long j) {
        int i = -1;
        if (TextUtils.isEmpty(str) || j == 0) {
            Logger.e("AgoraEngine takeRemoteViewSnapshot error channelId error " + str + " " + j, new Object[0]);
            return -1;
        }
        String str2 = this.mContext.getCacheDir().getAbsolutePath() + File.separatorChar + this.mPublishChannelId + "_" + j + ".jpeg";
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine != null) {
            i = rtcEngine.takeSnapshot(str, (int) j, str2);
        }
        Logger.i("AgoraEngine takeRemoteViewSnapshot channelId: " + str + ", uid: " + j + ", ret = " + i, new Object[0]);
        return i;
    }

    public int setupLocalVideo(View view) {
        int i;
        synchronized (gLock) {
            i = -1;
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                i = rtcEngine.setupLocalVideo(new VideoCanvas(view, 1, (int) this.mUserid));
            }
            Logger.i("AgoraEngine setupLocalVideo View: " + view + ", uid: " + this.mUserid + ", ret = " + i, new Object[0]);
        }
        return i;
    }

    public int setupLocalVideo(TextureView textureView) {
        int i;
        synchronized (gLock) {
            i = -1;
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                i = rtcEngine.setupLocalVideo(new VideoCanvas(textureView, 1, (int) this.mUserid));
            }
            Logger.i("AgoraEngine setupLocalVideo TextureView: " + textureView + ", uid: " + this.mUserid + ", ret = " + i, new Object[0]);
        }
        return i;
    }

    public void setLocalRenderMode(RTCEngine.RTCVideoRenderMode rTCVideoRenderMode) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setLocalRenderMode", new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.setLocalRenderMode(rTCVideoRenderMode.getValue(), this.mLocalMirrorMode);
            }
            this.mLocalRenderMode = rTCVideoRenderMode.getValue();
        }
    }

    public void setupRemoteVideo(View view, long j) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setupRemoteVideo uid = " + j + ", view = " + view, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.setupRemoteVideo(new VideoCanvas((SurfaceView) view, 1, (int) j));
            }
        }
    }

    public void setupRemoteVideo(View view, long j, String str) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setupRemoteVideo channelId = " + str + " , uid = " + j + ", view = " + view, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.setupRemoteVideo(new VideoCanvas(view, 1, str, (int) j));
            }
        }
    }

    public int setupRemoteVideo(long j, TextureView textureView) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setupRemoteVideo uid = " + j + " , view = " + textureView, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.setupRemoteVideo(new VideoCanvas(textureView, 1, (int) j));
            }
        }
        return 0;
    }

    public void setRemoteRenderMode(long j, RTCEngine.RTCVideoRenderMode rTCVideoRenderMode) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setRemoteRenderMode uid = " + j + "  mode = " + rTCVideoRenderMode.getValue(), new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.setRemoteRenderMode((int) j, rTCVideoRenderMode.getValue(), this.mRemoteMirrorMode);
            }
        }
    }

    public void setRemoteRenderMode(long j, RTCEngine.RTCVideoRenderMode rTCVideoRenderMode, int i) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setRemoteRenderMode uid = " + j + "  mode = " + rTCVideoRenderMode.getValue() + "  mirrorMode = " + i, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.setRemoteRenderMode((int) j, rTCVideoRenderMode.getValue(), i);
            }
        }
    }

    public View createRendererView() {
        synchronized (gLock) {
            Logger.i("AgoraEngine createRendererView", new Object[0]);
            if (this.mAgoraEngine == null) {
                return null;
            }
            SurfaceView CreateRendererView = RtcEngine.CreateRendererView(this.mContext);
            CreateRendererView.setZOrderMediaOverlay(true);
            return CreateRendererView;
        }
    }

    public void startPreview() {
        synchronized (gLock) {
            Logger.i("AgoraEngine startPreview", new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                this.tag = rtcEngine.startPreview();
            }
        }
    }

    public void stopPreview() {
        synchronized (gLock) {
            Logger.i("AgoraEngine stopPreview", new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                this.tag = rtcEngine.stopPreview();
            }
        }
    }

    public void switchCamera() {
        synchronized (gLock) {
            Logger.i("AgoraEngine switchCamera", new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.switchCamera();
            }
        }
    }

    public void setMirror(boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setMirror " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                if (z) {
                    rtcEngine.setLocalRenderMode(this.mLocalRenderMode, 1);
                    this.mLocalMirrorMode = 1;
                } else {
                    rtcEngine.setLocalRenderMode(this.mLocalRenderMode, 2);
                    this.mLocalMirrorMode = 2;
                }
            }
        }
    }

    public void setRemoteMirror(boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setRemoteMirror " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                if (z) {
                    rtcEngine.setParameters("{\"che.video.enableRemoteViewMirror\":true}");
                    this.mRemoteMirrorMode = 1;
                } else {
                    rtcEngine.setParameters("{\"che.video.enableRemoteViewMirror\":false}");
                    this.mRemoteMirrorMode = 2;
                }
            }
        }
    }

    public void setVideoEncoderConfiguration(int i, int i2, RTCEngine.RTCEngineVideoBitrate rTCEngineVideoBitrate, RTCEngine.RTC_ORIENTATION_MODE rtc_orientation_mode) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setVideoEncoderConfiguration width = %d height = %d bitrate = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(rTCEngineVideoBitrate.getValue()));
            if (this.mAgoraEngine != null) {
                this.mAgoraEngine.setVideoEncoderConfiguration(new VideoEncoderConfiguration(new VideoEncoderConfiguration.VideoDimensions(i, i2), VideoEncoderConfiguration.FRAME_RATE.FRAME_RATE_FPS_15, rTCEngineVideoBitrate.getValue(), VideoEncoderConfiguration.ORIENTATION_MODE.values()[rtc_orientation_mode.getValue()]));
            }
        }
    }

    public int setCameraPosition(int i) {
        if (i == 0) {
            this.mCamPosition = CameraCapturerConfiguration.CAMERA_DIRECTION.CAMERA_FRONT;
            return 0;
        } else if (i != 1) {
            return 0;
        } else {
            this.mCamPosition = CameraCapturerConfiguration.CAMERA_DIRECTION.CAMERA_REAR;
            return 0;
        }
    }

    public int getCameraPosition() {
        if (this.mCamPosition != CameraCapturerConfiguration.CAMERA_DIRECTION.CAMERA_FRONT && this.mCamPosition == CameraCapturerConfiguration.CAMERA_DIRECTION.CAMERA_REAR) {
            return 1;
        }
        return 0;
    }

    public int setPreviewResolution(int i, int i2) {
        int i3;
        synchronized (gLock) {
            i3 = -1;
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                i3 = rtcEngine.enableLocalVideo(false) + this.mAgoraEngine.setCameraCapturerConfiguration(new CameraCapturerConfiguration(i, i2, this.mCamPosition)) + this.mAgoraEngine.enableLocalVideo(true);
            }
            Logger.i("AgoraEngine setPreviewResolution width = " + i + ", height=" + i2 + ", ret = " + i3, new Object[0]);
        }
        return i3;
    }

    public void setVideoEncoderConfiguration(int i, int i2, int i3, int i4, RTCEngine.RTC_ORIENTATION_MODE rtc_orientation_mode) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setVideoEncoderConfiguration width = %d height = %d fps = %d bitrate = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            if (this.mAgoraEngine != null) {
                VideoEncoderConfiguration videoEncoderConfiguration = new VideoEncoderConfiguration(new VideoEncoderConfiguration.VideoDimensions(i, i2), VideoEncoderConfiguration.FRAME_RATE.FRAME_RATE_FPS_15, i4, VideoEncoderConfiguration.ORIENTATION_MODE.values()[rtc_orientation_mode.getValue()]);
                videoEncoderConfiguration.frameRate = i3;
                this.mAgoraEngine.setVideoEncoderConfiguration(videoEncoderConfiguration);
            }
        }
    }

    public int setAudioEncoderConfiguration(int i, int i2) {
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -2;
        }
        return rtcEngine.setParameters("{\"che.audio.codec.bitrate\":" + (i * ResultCode.KARAOKE_SUCCESS) + "}");
    }

    public void muteVideo(boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine muteVideo muting = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.muteLocalVideoStream(z);
            }
        }
    }

    public void muteAudio(boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine muteAudio muting = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.muteLocalAudioStream(z);
            }
        }
    }

    public void enableExternalVideo(boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraEngine enableExternalVideo enable = " + z, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.setExternalVideoSource(z, false, true);
                this.mHasEnableExternalVideo = z;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendCustomVideoData(byte[] r4, int r5, int r6, int r7, int r8) {
        /*
            r3 = this;
            java.lang.Object r8 = gLock
            monitor-enter(r8)
            boolean r0 = r3.mHasEnableExternalVideo     // Catch:{ all -> 0x0033 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r8)     // Catch:{ all -> 0x0033 }
            return r1
        L_0x000a:
            if (r4 == 0) goto L_0x0031
            int r0 = r4.length     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0010
            goto L_0x0031
        L_0x0010:
            io.agora.rtc.RtcEngine r0 = r3.mAgoraEngine     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x002f
            io.agora.rtc.video.AgoraVideoFrame r0 = new io.agora.rtc.video.AgoraVideoFrame     // Catch:{ all -> 0x0033 }
            r0.<init>()     // Catch:{ all -> 0x0033 }
            r0.format = r5     // Catch:{ all -> 0x0033 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0033 }
            r0.timeStamp = r1     // Catch:{ all -> 0x0033 }
            r0.stride = r6     // Catch:{ all -> 0x0033 }
            r0.height = r7     // Catch:{ all -> 0x0033 }
            r0.buf = r4     // Catch:{ all -> 0x0033 }
            io.agora.rtc.RtcEngine r4 = r3.mAgoraEngine     // Catch:{ all -> 0x0033 }
            boolean r4 = r4.pushExternalVideoFrame(r0)     // Catch:{ all -> 0x0033 }
            monitor-exit(r8)     // Catch:{ all -> 0x0033 }
            return r4
        L_0x002f:
            monitor-exit(r8)     // Catch:{ all -> 0x0033 }
            return r1
        L_0x0031:
            monitor-exit(r8)     // Catch:{ all -> 0x0033 }
            return r1
        L_0x0033:
            r4 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0033 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.AgoraEngine.sendCustomVideoData(byte[], int, int, int, int):boolean");
    }

    public void enableExternalAudio(boolean z, int i, int i2) {
        synchronized (gLock) {
            Logger.i("AgoraEngine enableExternalAudio enable = " + z + " sampleRate = " + i + " channels = " + i2, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.setExternalAudioSource(z, i, i2);
                this.mHasEnableExternalAudio = z;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendCustomPCMData(byte[] r5) {
        /*
            r4 = this;
            java.lang.Object r0 = gLock
            monitor-enter(r0)
            boolean r1 = r4.mHasEnableExternalAudio     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x0009:
            if (r5 == 0) goto L_0x001c
            int r1 = r5.length     // Catch:{ all -> 0x001e }
            if (r1 != 0) goto L_0x000f
            goto L_0x001c
        L_0x000f:
            io.agora.rtc.RtcEngine r1 = r4.mAgoraEngine     // Catch:{ all -> 0x001e }
            if (r1 == 0) goto L_0x001a
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x001e }
            r1.pushExternalAudioFrame(r5, r2)     // Catch:{ all -> 0x001e }
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            return
        L_0x001e:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.AgoraEngine.sendCustomPCMData(byte[]):void");
    }

    public void setVolume(long j, int i) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setVolume type1 uid = " + j + " volumeNum = " + i, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.setParameters("{\"che.audio.playout.uid.volume\": {\"channel\":\"" + this.mRoomid + "\",\"uid\":" + j + ",\"volume\":" + i + "}}");
            }
        }
    }

    public void setVolume(long j, int i, String str) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setVolume type2 uid = " + j + " volumeNum = " + i + " roomId = " + str, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine != null) {
                rtcEngine.setParameters("{\"che.audio.playout.uid.volume\": {\"channel\":\"" + str + "\",\"uid\":" + j + ",\"volume\":" + i + "}}");
            }
        }
    }

    public BaseRTCChannel createChannel(String str) {
        synchronized (gLock) {
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine == null) {
                return null;
            }
            RtcChannel createRtcChannel = rtcEngine.createRtcChannel(str);
            if (createRtcChannel == null) {
                return null;
            }
            Logger.i("AgoraEngine createChannel ===============  channelId = " + str, new Object[0]);
            AgoraChannel agoraChannel = new AgoraChannel();
            agoraChannel.setRtcChannel(createRtcChannel);
            agoraChannel.setEngine(this);
            agoraChannel.setEngineListener(new EngineAndChannelEachOtherListener() {
                public void channelUserLeaveRoom(long j, String str) {
                    Logger.i("AgoraEngine channelUserLeaveRoom ===============  uid = " + j + " roomId " + str, new Object[0]);
                }
            });
            return agoraChannel;
        }
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

    public byte[] onReadyToSendMetadata(long j) {
        synchronized (this.mTimestampLock) {
            long j2 = this.mUserSetTimestamp;
            if (j2 == 0) {
                byte[] bArr = new byte[0];
                return bArr;
            }
            byte[] LongToBytes = LongToBytes((j2 + System.currentTimeMillis()) - this.mSetTimestamp);
            this.mUserSetTimestamp = 0;
            this.mSetTimestamp = 0;
            return LongToBytes;
        }
    }

    public void onMetadataReceived(byte[] bArr, int i, long j) {
        synchronized (this.mTimestampRecLock) {
            if (bArr != null) {
                if (bArr.length >= 24) {
                    this.mMetadataRecTimestampMap.put(Integer.valueOf(i), Long.valueOf(longFrom8Bytes(bArr, 16, false)));
                    this.mRecTimestampMap.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    public int setTimestamp(long j) {
        if (this.mAgoraEngine == null) {
            return -1;
        }
        if (this.mDataStreamId < 0) {
            return this.mDataStreamId;
        }
        byte[] bArr = {-88, 95, -28, -23, 27, 105, 17, -24, -123, -126, 0, 80, -62, 73, 0, 72, 0, 0, 0, 0, 0, 0, 0, 0};
        System.arraycopy(LongToBytes(j), 0, bArr, 16, 8);
        return this.mAgoraEngine.sendStreamMessage(this.mDataStreamId, bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getTimestamp(int r7) {
        /*
            r6 = this;
            io.agora.rtc.RtcEngine r0 = r6.mAgoraEngine
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
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.AgoraEngine.getTimestamp(int):long");
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

    /* access modifiers changed from: private */
    public static long longFrom8Bytes(byte[] bArr, int i, boolean z) {
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = (z ? i2 : 7 - i2) << 3;
            j |= (255 << i3) & (((long) bArr[i + i2]) << i3);
        }
        return j;
    }

    public int addPublishStreamUrl(String str, boolean z) {
        int i;
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            i = -1;
        } else {
            i = rtcEngine.addPublishStreamUrl(str, z);
        }
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.pushRtmpState(str, "1000", i + "");
        }
        Logger.i("AgoraEngine addPublishStreamUrl url = " + str + "needTranscode" + z + "errCode = " + i, new Object[0]);
        return i;
    }

    public int removePublishStreamUrl(String str) {
        int i;
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            i = -1;
        } else {
            i = rtcEngine.removePublishStreamUrl(str);
        }
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.pushRtmpState(str, "1001", i + "");
        }
        Logger.i("AgoraEngine removePublishStreamUrl url = " + str + "errCode = " + i, new Object[0]);
        return i;
    }

    public int setRtmpConfig(RTCEngine.RTCRtmpConfig rTCRtmpConfig) {
        Logger.i("AgoraEngine setRtmpConfig " + rTCRtmpConfig.toString(), new Object[0]);
        if (this.mAgoraEngine == null || rTCRtmpConfig == null) {
            return -1;
        }
        LiveTranscoding liveTranscoding = new LiveTranscoding();
        if (rTCRtmpConfig.audioChannel != 0) {
            liveTranscoding.audioChannels = rTCRtmpConfig.audioChannel;
        }
        if (rTCRtmpConfig.audioSampleRate != 0) {
            if (rTCRtmpConfig.audioSampleRate == 44100) {
                liveTranscoding.audioSampleRate = LiveTranscoding.AudioSampleRateType.TYPE_44100;
            }
            if (rTCRtmpConfig.audioSampleRate == 48000) {
                liveTranscoding.audioSampleRate = LiveTranscoding.AudioSampleRateType.TYPE_48000;
            }
            if (rTCRtmpConfig.audioSampleRate == 32000) {
                liveTranscoding.audioSampleRate = LiveTranscoding.AudioSampleRateType.TYPE_32000;
            }
        }
        if (rTCRtmpConfig.backgroundColor != -1) {
            liveTranscoding.setBackgroundColor(rTCRtmpConfig.backgroundColor);
        }
        if (rTCRtmpConfig.backgroundImage != null) {
            AgoraImage agoraImage = new AgoraImage();
            agoraImage.url = rTCRtmpConfig.backgroundImage.url;
            agoraImage.x = rTCRtmpConfig.backgroundImage.x;
            agoraImage.y = rTCRtmpConfig.backgroundImage.y;
            agoraImage.width = rTCRtmpConfig.backgroundImage.width;
            agoraImage.height = rTCRtmpConfig.backgroundImage.height;
            liveTranscoding.backgroundImage = agoraImage;
        }
        if (rTCRtmpConfig.fps != 0) {
            liveTranscoding.videoFramerate = rTCRtmpConfig.fps;
        }
        if (rTCRtmpConfig.gop != 0) {
            liveTranscoding.videoGop = rTCRtmpConfig.gop;
        }
        if (!(rTCRtmpConfig.width == 0 || rTCRtmpConfig.height == 0)) {
            liveTranscoding.width = rTCRtmpConfig.width;
            liveTranscoding.height = rTCRtmpConfig.height;
        }
        for (RTCEngine.RTCRtmpUser next : rTCRtmpConfig.users) {
            LiveTranscoding.TranscodingUser transcodingUser = new LiveTranscoding.TranscodingUser();
            transcodingUser.uid = next.uid;
            transcodingUser.x = next.x;
            transcodingUser.y = next.y;
            transcodingUser.height = next.height;
            transcodingUser.width = next.width;
            transcodingUser.zOrder = next.zorder;
            liveTranscoding.addUser(transcodingUser);
        }
        this.mAgoraEngine.setLiveTranscoding(liveTranscoding);
        return 0;
    }

    public int startPlayMusic(String str) {
        Logger.i("AgoraEngine startPlayMusic :" + str, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.startAudioMixing(str, false, false, 1);
    }

    public int startPlayMusic(String str, boolean z, boolean z2, int i) {
        Logger.i("AgoraEngine startPlayMusic" + str + " loopback = " + z + " replace = " + z2 + " cycle = " + i, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.startAudioMixing(str, z, z2, i);
    }

    public int stopPlayMusic() {
        Logger.i("AgoraEngine stopPlayMusic", new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.stopAudioMixing();
    }

    public int pauseAudioMusic() {
        Logger.i("AgoraEngine pauseAudioMusic", new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.pauseAudioMixing();
    }

    public int resumeAudioMusic() {
        Logger.i("AgoraEngine resumeAudioMusic", new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.resumeAudioMixing();
    }

    public int getAudioMusicDuration() {
        Logger.i("AgoraEngine getAudioMusicDuration", new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.getAudioMixingDuration();
    }

    public int getAudioMusicCurrentPosition() {
        Logger.i("AgoraEngine getAudioMusicCurrentPosition", new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.getAudioMixingCurrentPosition();
    }

    public int setAudioMusicPosition(int i) {
        Logger.i("AgoraEngine setAudioMusicPosition  pos = " + i, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.setAudioMixingPosition(i);
    }

    public int playMusicVolume(int i) {
        Logger.i("AgoraEngine playMusicVolume " + i, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.adjustAudioMixingVolume(i);
    }

    public int setParams(String str) {
        Logger.i("AgoraEngine setParams " + str, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine != null) {
            return rtcEngine.setParameters(str);
        }
        return 0;
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        Logger.i("AgoraEngine setDefaultMuteAllRemoteAudioStreams muted = " + z, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine != null) {
            return rtcEngine.setDefaultMuteAllRemoteAudioStreams(z);
        }
        return -1;
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        Logger.i("AgoraEngine setDefaultMuteAllRemoteVideoStreams muted = " + z, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine != null) {
            return rtcEngine.setDefaultMuteAllRemoteVideoStreams(z);
        }
        return -1;
    }

    public int switchRoomWithToken(String str) {
        leaveRoom();
        try {
            Map<String, Claim> claims = new JWT(str).getClaims();
            Claim claim = claims.get("roomStr");
            if (claim != null) {
                this.mRoomid = claim.asString();
            }
            Claim claim2 = claims.get("attachToken");
            if (claim2 != null) {
                this.mToken = claim2.asString();
            } else {
                Claim claim3 = claims.get(AssistPushConsts.MSG_TYPE_TOKEN);
                if (claim3 != null) {
                    this.mToken = claim3.asString();
                }
            }
            joinRoom();
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public int enableContentInspect(boolean z) {
        Logger.i("AgoraEngine enableContentInspect enable = " + z, new Object[0]);
        this.startInspect = true;
        this.enableInspect = z;
        return startEnableInspect();
    }

    public int enableContentInspect(boolean z, int i) {
        Logger.i("AgoraEngine enableContentInspect enable = " + z + " timeInterval = " + i, new Object[0]);
        this.startInspect = true;
        this.enableInspect = z;
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        rtcEngine.setParameters("{\"rtc.video.content_inspect_interval_sec\":" + i + "}");
        return startEnableInspect();
    }

    public int contentInspectExtra(String str, RTCEngine.InspectMode[] inspectModeArr) {
        Logger.i("AgoraEngine contentInspectExtra arguments = " + str + " modes = " + Arrays.toString(inspectModeArr), new Object[0]);
        if (this.mAgoraEngine == null) {
            return -1;
        }
        if (inspectModeArr == null) {
            return -3;
        }
        ContentInspectConfig contentInspectConfig = new ContentInspectConfig();
        for (RTCEngine.InspectMode inspectMode : inspectModeArr) {
            int i = inspectMode.mode;
            if (i == 1) {
                contentInspectConfig.modules[0].type = 2;
                contentInspectConfig.modules[0].frequency = inspectMode.rate;
            } else if (i == 2) {
                contentInspectConfig.modules[1].type = 1;
                contentInspectConfig.modules[1].frequency = inspectMode.rate;
            }
        }
        contentInspectConfig.extraInfo = str;
        this.enspectConfig = contentInspectConfig;
        return 0;
    }

    private int startEnableInspect() {
        RtcEngine rtcEngine;
        ContentInspectConfig contentInspectConfig = this.enspectConfig;
        if (contentInspectConfig == null || !this.startInspect || (rtcEngine = this.mAgoraEngine) == null) {
            return 0;
        }
        return rtcEngine.enableContentInspect(this.enableInspect, contentInspectConfig);
    }

    public void setContentInspectListener(RTCEngine.ContentInspectListener contentInspectListener) {
        this.mContentInspectListener = contentInspectListener;
    }

    public int takePreEncodeSnapshot() {
        Context context;
        if (this.mAgoraEngine == null) {
            return -1;
        }
        try {
            if (TextUtils.isEmpty(this.agoraInspectFileName) && (context = this.mContext) != null) {
                this.agoraInspectFileName = FilePathUtils.getAgoraInspectFileName(context.getApplicationContext());
            }
            if (!TextUtils.isEmpty(this.agoraInspectFileName)) {
                return this.mAgoraEngine.takeSnapshot(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE, 0, this.agoraInspectFileName);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
    }

    public int setAVSyncSource(long j, long j2) {
        Logger.i("AgoraEngine setAVSyncSource 1 channelId = " + j + " uid = " + j2, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.setAVSyncSource(j + "", (int) j2);
    }

    public int setAVSyncSource(long j) {
        Logger.i("AgoraEngine setAVSyncSource 2 channelId = " + this.mRoomid + " uid = " + j, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine != null) {
            return rtcEngine.setAVSyncSource(this.mRoomid, (int) j);
        }
        return -1;
    }

    public int setRemoteVideoStreamType(long j, int i) {
        Logger.i("AgoraEngine setRemoteVideoStreamType uid = " + j + " ,streamType = " + i, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -1;
        }
        return rtcEngine.setRemoteVideoStreamType((int) j, i);
    }

    public int setAudioMode(RTCEngine.RTCAudioMode rTCAudioMode) {
        int i = 0;
        Logger.i("AgoraEngine setAudioMode mode = " + rTCAudioMode.getValue(), new Object[0]);
        if (this.mAgoraEngine == null) {
            return -1;
        }
        if (rTCAudioMode == RTCEngine.RTCAudioMode.Mode_Call) {
            i = 2;
        } else if (rTCAudioMode == RTCEngine.RTCAudioMode.Mode_Music) {
            i = 3;
        }
        RtcEngine rtcEngine = this.mAgoraEngine;
        return rtcEngine.setParameters("{\"che.audio.switch.scenario\":" + i + "}");
    }

    public int setPlaybackAudioFrameParameters(int i, int i2, RTCEngine.RawAudioFrameOpMode rawAudioFrameOpMode, int i3) {
        synchronized (gLock) {
            Logger.i("AgoraEngine setPlaybackAudioFrameParameters sampleRate = " + i + " channel = " + i2 + " mode = " + rawAudioFrameOpMode.getValue() + " samplesPerCall = " + i3, new Object[0]);
            RtcEngine rtcEngine = this.mAgoraEngine;
            if (rtcEngine == null) {
                return -1;
            }
            int playbackAudioFrameParameters = rtcEngine.setPlaybackAudioFrameParameters(i, i2, rawAudioFrameOpMode.getValue(), i3);
            return playbackAudioFrameParameters;
        }
    }

    /* access modifiers changed from: protected */
    public void doEngineChangeNotify() {
        if (this.mObserver != null) {
            Handler handler = this.mHandler;
            AnonymousClass5 r1 = new Runnable() {
                public void run() {
                    if (AgoraEngine.this.mObserver != null && SystemClock.uptimeMillis() - AgoraEngine.this.lastEngineChangeNotifyTime >= 60000) {
                        Logger.i("AgoraEngine CONNECTION_CHANGED_BANNED_BY_SERVER Success", new Object[0]);
                        AgoraEngine.this.mObserver.onEngineChangeNotify();
                        long unused = AgoraEngine.this.lastEngineChangeNotifyTime = SystemClock.uptimeMillis();
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

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int publish() {
        /*
            r5 = this;
            java.lang.Object r0 = gLock
            monitor-enter(r0)
            java.lang.String r1 = "AgoraEngine publish"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x002d }
            com.eaydu.omni.logger.Logger.i(r1, r3)     // Catch:{ all -> 0x002d }
            io.agora.rtc.RtcEngine r1 = r5.mAgoraEngine     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x002a
            int r1 = r1.muteLocalAudioStream(r2)     // Catch:{ all -> 0x002d }
            r3 = 1
            if (r1 != 0) goto L_0x0018
            r1 = r3
            goto L_0x0019
        L_0x0018:
            r1 = r2
        L_0x0019:
            io.agora.rtc.RtcEngine r4 = r5.mAgoraEngine     // Catch:{ all -> 0x002d }
            int r4 = r4.muteLocalVideoStream(r2)     // Catch:{ all -> 0x002d }
            if (r4 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r3 = r2
        L_0x0023:
            r1 = r1 | r3
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r2 = -1
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r2
        L_0x002a:
            r1 = -2
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r1
        L_0x002d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.AgoraEngine.publish():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0029, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int unPublish() {
        /*
            r5 = this;
            java.lang.Object r0 = gLock
            monitor-enter(r0)
            java.lang.String r1 = "AgoraEngine unPublish"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x002d }
            com.eaydu.omni.logger.Logger.i(r1, r3)     // Catch:{ all -> 0x002d }
            io.agora.rtc.RtcEngine r1 = r5.mAgoraEngine     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x002a
            r3 = 1
            int r1 = r1.muteLocalAudioStream(r3)     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x0018
            r1 = r3
            goto L_0x0019
        L_0x0018:
            r1 = r2
        L_0x0019:
            io.agora.rtc.RtcEngine r4 = r5.mAgoraEngine     // Catch:{ all -> 0x002d }
            int r4 = r4.muteLocalVideoStream(r3)     // Catch:{ all -> 0x002d }
            if (r4 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r3 = r2
        L_0x0023:
            r1 = r1 | r3
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r2 = -1
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r2
        L_0x002a:
            r1 = -2
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r1
        L_0x002d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.AgoraEngine.unPublish():int");
    }

    public int setActivityState(int i) {
        super.setActivityState(i);
        if (this.mAgoraEngine == null) {
            return -2;
        }
        LogReport logReport = this.mlogReport;
        if (logReport == null) {
            return 0;
        }
        logReport.appStateChanged(i);
        return 0;
    }

    public int sendStreamMessage(long j, byte[] bArr) {
        if (this.mAgoraEngine == null) {
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
        return this.mAgoraEngine.sendStreamMessage(this.mDataStreamId, bArr2);
    }

    public int startChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        Logger.i("AgoraEngine startChannelMediaRelay channelMediaRelayConfiguration = " + rTCChannelMediaRelayConfiguration, new Object[0]);
        if (this.mAgoraEngine == null) {
            return -2;
        }
        ChannelMediaRelayConfiguration agoraChannelMediaRelayConfigurationFromRTC = ClassConverter.getAgoraChannelMediaRelayConfigurationFromRTC(rTCChannelMediaRelayConfiguration);
        if (agoraChannelMediaRelayConfigurationFromRTC == null) {
            return -3;
        }
        return this.mAgoraEngine.startChannelMediaRelay(agoraChannelMediaRelayConfigurationFromRTC);
    }

    public int stopChannelMediaRelay() {
        Logger.i("AgoraEngine stopChannelMediaRelay", new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -2;
        }
        return rtcEngine.stopChannelMediaRelay();
    }

    public int updateChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        if (this.mAgoraEngine == null) {
            return -2;
        }
        return this.mAgoraEngine.updateChannelMediaRelay(ClassConverter.getAgoraChannelMediaRelayConfigurationFromRTC(rTCChannelMediaRelayConfiguration));
    }

    public int checkFeatureSupport(RTCEngine.RTCFeature rTCFeature) {
        return rTCFeature == RTCEngine.RTCFeature.FeatureAudioBeauty ? 1 : -3;
    }

    public int getEngineType() {
        return RTCEngine.EngineType.Agora.getValue();
    }

    public int pushExternalAudioFrame(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -2;
        }
        int pushExternalAudioFrame = rtcEngine.pushExternalAudioFrame(bArr, j, i, i2, i3, i4);
        return (pushExternalAudioFrame == 0 && i4 == 0) ? (int) ((((((long) i) * this.mRenderExternalCachedTimeMs) * ((long) i2)) * ((long) i3)) / 1000) : pushExternalAudioFrame;
    }

    public int setExternalAudioSourceVolume(int i, int i2) {
        Logger.i("AgoraEngine setExternalAudioSourceVolume sourceId = " + i + " volume = " + i2, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -2;
        }
        return rtcEngine.setExternalAudioSourceVolume(i, i2);
    }

    public int setRemoteSubscribeFallbackOption(int i) {
        Logger.i("AgoraEngine setRemoteSubscribeFallbackOption option = " + i, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -2;
        }
        return rtcEngine.setRemoteSubscribeFallbackOption(i);
    }

    public int applyRemoteStreamSubscribeAdvice(long j, int i) {
        Logger.i("AgoraEngine applyRemoteStreamSubscribeAdvice uid = " + j + " streamType = " + i, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -2;
        }
        return rtcEngine.applyRemoteStreamSubscribeAdvice((int) j, i);
    }

    public int setRemoteMixedVolume(int i) {
        Logger.i("AgoraEngine setRemoteMixedVolume volume = " + i, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -2;
        }
        return rtcEngine.adjustPlaybackSignalVolume(i);
    }

    public int setMediaVideoProcessOptions(boolean z, boolean z2) {
        Logger.i("AgoraEngine setMediaVideoProcessOptions needJavaLocalVideoData: " + z + ", needJavaRemoteVideoData: " + z2, new Object[0]);
        MediaDataObserverPlugin.VideoDataCallbackOptions.NEED_JAVA_LOCAL_VIDEO_DATA = z;
        MediaDataObserverPlugin.VideoDataCallbackOptions.NEED_JAVA_REMOTE_VIDEO_DATA = z2;
        return 0;
    }

    public static class ClassConverter {
        public static ChannelMediaRelayConfiguration getAgoraChannelMediaRelayConfigurationFromRTC(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
            ChannelMediaRelayConfiguration channelMediaRelayConfiguration = new ChannelMediaRelayConfiguration();
            channelMediaRelayConfiguration.setSrcChannelInfo(getAgoraChannelMediaInfoFromRTC(rTCChannelMediaRelayConfiguration.getSrcChannelMediaInfo()));
            for (RTCEngine.RTCChannelMediaInfo agoraChannelMediaInfoFromRTC : rTCChannelMediaRelayConfiguration.getDestChannelMediaInfos()) {
                ChannelMediaInfo agoraChannelMediaInfoFromRTC2 = getAgoraChannelMediaInfoFromRTC(agoraChannelMediaInfoFromRTC);
                if (agoraChannelMediaInfoFromRTC2 == null) {
                    return null;
                }
                channelMediaRelayConfiguration.setDestChannelInfo(agoraChannelMediaInfoFromRTC2.channelName, agoraChannelMediaInfoFromRTC2);
            }
            return channelMediaRelayConfiguration;
        }

        public static ChannelMediaInfo getAgoraChannelMediaInfoFromRTC(RTCEngine.RTCChannelMediaInfo rTCChannelMediaInfo) {
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
                return new ChannelMediaInfo(asString, str, (int) longValue);
            } catch (Exception e) {
                Logger.i("ClassConverter getAgoraChannelMediaInfoFromRTC parseTokenFailed " + e.getMessage(), new Object[0]);
                return null;
            }
        }
    }

    public static class AgoraUtils {
        private static final String TAG = "AgoraUtils";
        private static boolean mLoaded;
        private static final String[] mSoArray = {"libagora-rtc-sdk-jni.so"};

        public static boolean hasLoadSo() {
            return mLoaded;
        }

        public static int loadExportSo(String str) {
            try {
                RtcEngine.setLibraryPath(str);
                return 0;
            } catch (InvalidParameterException unused) {
                return -1002;
            } catch (Exception unused2) {
                return -1001;
            }
        }

        public static boolean isLoaded() {
            return mLoaded;
        }

        private static boolean checkFileExist(String str) {
            return new File(str).exists();
        }
    }

    public int getConnectionState() {
        Logger.i("AgoraEngine getConnectionState ", new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine != null) {
            return rtcEngine.getConnectionState();
        }
        return -2;
    }

    public int setAudioProfile(int i, int i2) {
        Logger.i("AgoraEngine setAudioProfile profile = " + i + " scenario = " + i2, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine != null) {
            return rtcEngine.setAudioProfile(i, i2);
        }
        return -2;
    }

    public void enableVideo() {
        Logger.i("AgoraEngine enableVideo ", new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine != null) {
            rtcEngine.enableVideo();
        }
    }

    public int disableVideo() {
        Logger.i("AgoraEngine disableVideo ", new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine != null) {
            return rtcEngine.disableVideo();
        }
        return -2;
    }

    public TextureView createTextureView() {
        synchronized (gLock) {
            Logger.i("AgoraEngine createTextureView", new Object[0]);
            if (this.mAgoraEngine == null) {
                return null;
            }
            TextureView CreateTextureView = RtcEngine.CreateTextureView(this.mContext);
            return CreateTextureView;
        }
    }

    public int switchChannel(String str, String str2) {
        Logger.i("AgoraEngine switchChannel token = " + str + " channelName = " + str2, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine != null) {
            return rtcEngine.switchChannel(str, str2);
        }
        return -2;
    }

    public String getChannelCallId() {
        RtcEngine rtcEngine = this.mAgoraEngine;
        return rtcEngine != null ? rtcEngine.getChannelCallId() : "";
    }

    public int setHowlingMode(int i) {
        Logger.i("AgoraEngine setHowlingMode mode = " + i, new Object[0]);
        RtcEngine rtcEngine = this.mAgoraEngine;
        if (rtcEngine == null) {
            return -2;
        }
        if (i == 0) {
            rtcEngine.setParameters("{\"che.audio.enable.livehc\":false}");
            this.mAgoraEngine.setParameters("{\"che.audio.howling.activity\":1}");
            this.mAgoraEngine.setParameters("{\"che.audio.howling.suppression\":false}");
            this.mAgoraEngine.setParameters("{\"che.audio.enable.howling_control\":false}");
        } else if (i == 1) {
            rtcEngine.setParameters("{\"che.audio.enable.livehc\":true}");
            this.mAgoraEngine.setParameters("{\"che.audio.howling.activity\":1}");
            this.mAgoraEngine.setParameters("{\"che.audio.howling.suppression\":false}");
            this.mAgoraEngine.setParameters("{\"che.audio.enable.howling_control\":true}");
        } else if (i != 2) {
            return -1;
        } else {
            rtcEngine.setParameters("{\"che.audio.enable.livehc\":true}");
            this.mAgoraEngine.setParameters("{\"che.audio.howling.activity\":1}");
            this.mAgoraEngine.setParameters("{\"che.audio.howling.suppression\":true}");
            this.mAgoraEngine.setParameters("{\"che.audio.enable.howling_control\":true}");
        }
        return 0;
    }
}
