package com.eaydu.omni;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.eaydu.omni.AgoraEngine;
import com.eaydu.omni.BaseRtcEngine;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.eaydu.omni.listener.RtcConnectReason;
import com.eaydu.omni.log.LOGErrorCode;
import com.eaydu.omni.log.LOGMediaType;
import com.eaydu.omni.log.LogCommonInfo;
import com.eaydu.omni.log.LogReport;
import com.eaydu.omni.log.bean.LogAudioRemoteStatistics;
import com.eaydu.omni.log.bean.LogVideoRemoteStatistics;
import com.eaydu.omni.logger.Logger;
import com.eaydu.omni.utils.CommonUtils;
import com.eaydu.omni.utils.DataUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.igexin.assist.sdk.AssistPushConsts;
import io.agora.rtc.IRtcChannelEventHandler;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.RtcChannel;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.live.LiveTranscoding;
import io.agora.rtc.models.ChannelMediaOptions;
import io.agora.rtc.video.AgoraImage;
import io.agora.rtc.video.ChannelMediaRelayConfiguration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AgoraChannel extends BaseRTCChannel {
    private static final boolean DEBUG = false;
    private static final String TAG = "AgoraChannel";
    /* access modifiers changed from: private */
    public static final Object gLock = new Object();
    private AgoraEngine.EngineAndChannelEachOtherListener engineAndChannelEachOtherListener;
    private long leaveChannelStartTime = 0;
    private BaseRtcEngine.IActivityStateCallback mActivityStateCallback = new BaseRtcEngine.IActivityStateCallback() {
        public void onState(int i) {
            if (AgoraChannel.this.mLogReport != null) {
                AgoraChannel.this.mLogReport.appStateChanged(i);
            }
        }
    };
    /* access modifiers changed from: private */
    public String mChannelId;
    /* access modifiers changed from: private */
    public volatile int mDataStreamId = 0;
    /* access modifiers changed from: private */
    public AgoraEngine mEngine;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public RTCChannel.IRTCChannelEventListener mListener;
    /* access modifiers changed from: private */
    public LogReport mLogReport;
    public HashMap<Integer, Long> mMetadataRecTimestampMap = new HashMap<>();
    public HashMap<Integer, Long> mRecTimestampMap = new HashMap<>();
    private Object mTimestampLock = new Object();
    /* access modifiers changed from: private */
    public final Object mTimestampRecLock = new Object();
    /* access modifiers changed from: private */
    public long mUserId;
    private RtcChannel rtcChannel;

    /* access modifiers changed from: protected */
    public void setRtcChannel(RtcChannel rtcChannel2) {
        synchronized (gLock) {
            this.rtcChannel = rtcChannel2;
            if (rtcChannel2 != null) {
                this.mChannelId = rtcChannel2.channelId();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setEngine(AgoraEngine agoraEngine) {
        synchronized (gLock) {
            this.mEngine = agoraEngine;
        }
    }

    /* access modifiers changed from: protected */
    public void setEngineListener(AgoraEngine.EngineAndChannelEachOtherListener engineAndChannelEachOtherListener2) {
        Logger.i("AgoraChannel setEngineListener  success", new Object[0]);
        this.engineAndChannelEachOtherListener = engineAndChannelEachOtherListener2;
    }

    /* access modifiers changed from: protected */
    public void setLogReport(LogReport logReport) {
        super.setLogReport(logReport);
        this.mLogReport = logReport;
    }

    public void joinChannel(String str, long j) {
        synchronized (gLock) {
            Logger.i("AgoraChannel joinChannel mChannelId: " + this.mChannelId + ", uid: " + j + ", token: " + str, new Object[0]);
            if (this.rtcChannel != null) {
                ChannelMediaOptions channelMediaOptions = new ChannelMediaOptions();
                channelMediaOptions.publishLocalAudio = false;
                channelMediaOptions.publishLocalVideo = false;
                channelMediaOptions.autoSubscribeAudio = true;
                channelMediaOptions.autoSubscribeVideo = true;
                int joinChannel = this.rtcChannel.joinChannel(str, "", (int) j, channelMediaOptions);
                Logger.i("AgoraChannel joinChannel result = " + joinChannel, new Object[0]);
            }
            AgoraEngine agoraEngine = this.mEngine;
            if (agoraEngine != null) {
                agoraEngine.addActivityStateCallback(this.mActivityStateCallback);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void muteRemoteVideo(long j, boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraChannel muteRemoteVideo mChannelId: " + this.mChannelId + ", uid: " + j + ", mute: " + z, new Object[0]);
            RtcChannel rtcChannel2 = this.rtcChannel;
            if (rtcChannel2 != null) {
                rtcChannel2.muteRemoteVideoStream((int) j, z);
            }
            LogReport logReport = this.mLogReport;
            if (logReport != null) {
                if (z) {
                    logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "9", (String) null, j);
                } else {
                    logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "11", (String) null, j);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void muteRemoteAudio(long j, boolean z) {
        synchronized (gLock) {
            Logger.i("AgoraChannel muteRemoteAudio mChannelId: " + this.mChannelId + ", uid: " + j + ", mute: " + z, new Object[0]);
            RtcChannel rtcChannel2 = this.rtcChannel;
            if (rtcChannel2 != null) {
                rtcChannel2.muteRemoteAudioStream((int) j, z);
            }
            LogReport logReport = this.mLogReport;
            if (logReport != null) {
                if (z) {
                    logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "10", (String) null, j);
                } else {
                    logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "12", (String) null, j);
                }
            }
        }
    }

    public int takeRemoteViewSnapshot(long j) {
        Logger.i("AgoraChannel takeRemoteViewSnapshot channelId: " + this.mChannelId + ", uid: " + j, new Object[0]);
        AgoraEngine agoraEngine = this.mEngine;
        if (agoraEngine != null) {
            return agoraEngine.takeRemoteViewSnapshot(this.mChannelId, j);
        }
        return -2;
    }

    public void leaveChannel() {
        synchronized (gLock) {
            Logger.i("AgoraChannel leaveChannel " + this.mChannelId, new Object[0]);
            this.leaveChannelStartTime = System.currentTimeMillis();
            this.mDataStreamId = -1;
            Iterator<Map.Entry<Integer, AgoraEngine.DelayObject>> it = this.mEngine.delayMap.entrySet().iterator();
            while (it.hasNext()) {
                AgoraEngine.DelayObject delayObject = (AgoraEngine.DelayObject) it.next().getValue();
                if (delayObject.isDelay == 1 && TextUtils.equals(delayObject.roomId, this.mChannelId)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    LogReport logReport = this.mLogReport;
                    if (logReport != null) {
                        logReport.jitterRenderDelayEnd(currentTimeMillis, delayObject.uid, delayObject.roomId, currentTimeMillis - delayObject.startTime);
                    }
                }
                if (TextUtils.equals(delayObject.roomId, this.mChannelId)) {
                    it.remove();
                }
            }
            RtcChannel rtcChannel2 = this.rtcChannel;
            if (rtcChannel2 != null) {
                rtcChannel2.leaveChannel();
            }
            AgoraEngine agoraEngine = this.mEngine;
            if (agoraEngine != null) {
                agoraEngine.removeActivityStateCallback(this.mActivityStateCallback);
            }
            LogReport logReport2 = this.mLogReport;
            if (logReport2 != null) {
                logReport2.leaveRoom(this.mChannelId, logReport2.getmUserid(), LOGErrorCode.LOG_Success.value, "LeaveRoom bye bye", System.currentTimeMillis() - this.leaveChannelStartTime);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        synchronized (gLock) {
            Logger.i("AgoraChannel destroy " + this.mChannelId, new Object[0]);
            RtcChannel rtcChannel2 = this.rtcChannel;
            if (rtcChannel2 != null) {
                rtcChannel2.destroy();
                this.rtcChannel = null;
            }
        }
    }

    public void setEventListener(RTCChannel.IRTCChannelEventListener iRTCChannelEventListener) {
        Logger.i("AgoraChannel setEventListener", new Object[0]);
        if (this.rtcChannel != null) {
            Logger.i("AgoraChannel setEventListener success", new Object[0]);
            this.mListener = iRTCChannelEventListener;
            this.rtcChannel.setRtcChannelEventHandler(new IRtcChannelEventHandler() {
                public void onFirstRemoteVideoDecoded(RtcChannel rtcChannel, int i, int i2, int i3, int i4) {
                    AgoraChannel.super.onFirstRemoteVideoDecoded(rtcChannel, i, i2, i3, i4);
                    final long j = ((long) i) & 4294967295L;
                    Logger.i("AgoraChannel onFirstRemoteVideoDecoded mChannelId" + AgoraChannel.this.mChannelId + " uid: " + j + ", width: " + i2 + ", height: " + i3 + ", elapsed: " + i4, new Object[0]);
                    if (AgoraChannel.this.mLogReport != null) {
                        AgoraChannel.this.mLogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, "1", (String) null, j);
                    }
                    if (!(AgoraChannel.this.mEngine == null || AgoraChannel.this.mEngine.mediaDataObserverPlugin == null || AgoraChannel.this.mEngine.mediaDataObserverPlugin == null)) {
                        AgoraChannel.this.mEngine.mediaDataObserverPlugin.allocateBuffer(i, i2, i3);
                    }
                    if (AgoraChannel.this.mListener != null) {
                        Handler access$400 = AgoraChannel.this.mHandler;
                        AnonymousClass1 r12 = new Runnable() {
                            public void run() {
                                if (AgoraChannel.this.mListener != null) {
                                    AgoraChannel.this.mListener.remotefirstVideoRecvWithUid(AgoraChannel.this.mChannelId, j);
                                }
                            }
                        };
                        if (!(access$400 instanceof Handler)) {
                            access$400.post(r12);
                        } else {
                            AsynchronousInstrumentation.handlerPost(access$400, r12);
                        }
                    }
                }

                public void onChannelWarning(RtcChannel rtcChannel, int i) {
                    Logger.w("AgoraChannel onWarning mChannelId: " + AgoraChannel.this.mChannelId + ", warn: " + i, new Object[0]);
                }

                public void onChannelError(RtcChannel rtcChannel, int i) {
                    Logger.i("AgoraChannel onChannelError mChannelId: " + AgoraChannel.this.mChannelId + ", error: " + i, new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        if (i == 110 || i == 101) {
                            Logger.i("AgoraChannel IRtcChannelEventHandler RTCEngineErrorCodeInvalidToken", new Object[0]);
                            AgoraChannel.this.mListener.didOccurError(AgoraChannel.this.mChannelId, RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeInvalidToken);
                        } else if (i == 109) {
                            Logger.i("AgoraChannel IRtcChannelEventHandler RTCEngineErrorCodeTokenExpired", new Object[0]);
                            AgoraChannel.this.mListener.didOccurError(AgoraChannel.this.mChannelId, RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeTokenExpired);
                        } else if (i == 1003) {
                            Logger.i("AgoraChannel IRtcChannelEventHandler RTCEngineErrorCodeStartCamera", new Object[0]);
                            AgoraChannel.this.mListener.didOccurError(AgoraChannel.this.mChannelId, RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeStartCamera);
                        } else if (i == 1004) {
                            Logger.i("AgoraChannel IRtcChannelEventHandler RTCEngineErrorCodeStartVideoRender", new Object[0]);
                            AgoraChannel.this.mListener.didOccurError(AgoraChannel.this.mChannelId, RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeStartVideoRender);
                        } else if (i == 1109) {
                            Logger.i("AgoraChannel IRtcChannelEventHandler RTC_ERR_AUDIOTRACKOVERFLOW", new Object[0]);
                            AgoraChannel.this.mListener.didOccurError(AgoraChannel.this.mChannelId, RTCEngine.RTCEngineErrorCode.RTC_ERR_AUDIOTRACKOVERFLOW);
                        } else if (i < 1005 || i > 1360) {
                            Logger.e("onError " + i + " " + RtcEngine.getErrorDescription(i), new Object[0]);
                        } else {
                            Logger.i("AgoraChannel IRtcChannelEventHandler RTCEngineErrorCodesAudioError", new Object[0]);
                            AgoraChannel.this.mListener.didOccurError(AgoraChannel.this.mChannelId, RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodesAudioError);
                        }
                    }
                }

                public void onJoinChannelSuccess(final RtcChannel rtcChannel, int i, int i2) {
                    long j = (long) i;
                    long j2 = j & 4294967295L;
                    Logger.i("AgoraChannel onJoinChannelSuccess mChannelId = " + AgoraChannel.this.mChannelId + " uid: " + j2 + ", elapsed: " + i2 + "，callId:", new Object[0]);
                    Handler access$400 = AgoraChannel.this.mHandler;
                    AnonymousClass2 r0 = new Runnable() {
                        public void run() {
                            synchronized (AgoraChannel.gLock) {
                                if (rtcChannel != null) {
                                    int unused = AgoraChannel.this.mDataStreamId = rtcChannel.createDataStream(false, false);
                                }
                            }
                        }
                    };
                    if (!(access$400 instanceof Handler)) {
                        access$400.post(r0);
                    } else {
                        AsynchronousInstrumentation.handlerPost(access$400, r0);
                    }
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.localUserJoinedWithUid(AgoraChannel.this.mChannelId, j);
                    }
                    if (AgoraChannel.this.mLogReport != null) {
                        String channelCallId = rtcChannel.getChannelCallId();
                        if (channelCallId != null) {
                            AgoraChannel.this.mLogReport.setSessionId(channelCallId);
                        } else {
                            AgoraChannel.this.mLogReport.setSessionId("");
                        }
                        AgoraChannel.this.mLogReport.setStreamId(rtcChannel.getCallId());
                        AgoraChannel.this.mLogReport.joinRoom(i2, j, LOGErrorCode.LOG_Success.value, "joined room successfully", 0);
                    }
                    long unused = AgoraChannel.this.mUserId = j2;
                }

                public void onRejoinChannelSuccess(RtcChannel rtcChannel, int i, int i2) {
                    long j = (long) i;
                    long j2 = j & 4294967295L;
                    Logger.i("AgoraChannel onRejoinChannelSuccess mChannelId: " + AgoraChannel.this.mChannelId + ", uid: " + j2 + ", elapsed: " + i2, new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.localUserJoinedWithUid(AgoraChannel.this.mChannelId, j);
                    }
                    if (AgoraChannel.this.mLogReport != null) {
                        AgoraChannel.this.mLogReport.setStreamId(rtcChannel.getCallId());
                        AgoraChannel.this.mLogReport.joinRoom(i2, j, LOGErrorCode.LOG_Success.value, "ReJoined room successfully", 1);
                    }
                    long unused = AgoraChannel.this.mUserId = j2;
                }

                public void onLeaveChannel(RtcChannel rtcChannel, IRtcEngineEventHandler.RtcStats rtcStats) {
                    Logger.i("AgoraChannel onLeaveChannel", new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onLeaveChannel(AgoraChannel.this.mChannelId);
                    }
                }

                public void onClientRoleChanged(RtcChannel rtcChannel, int i, int i2) {
                    AgoraChannel.super.onClientRoleChanged(rtcChannel, i, i2);
                }

                public void onUserJoined(RtcChannel rtcChannel, int i, int i2) {
                    long j = (long) i;
                    Logger.i("AgoraChannel onUserJoined mChannelId: " + AgoraChannel.this.mChannelId + ", uid: " + (4294967295L & j) + ", elapsed: " + i2, new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.remoteUserJoinWithUid(AgoraChannel.this.mChannelId, j);
                    }
                }

                public void onUserOffline(RtcChannel rtcChannel, int i, int i2) {
                    long j = (long) i;
                    long j2 = 4294967295L & j;
                    Logger.i("AgoraChannel onUserOffline mChannelId: " + AgoraChannel.this.mChannelId + ", uid: " + j2 + ", reason: " + i2, new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.didOfflineOfUid(AgoraChannel.this.mChannelId, j);
                        AgoraChannel.this.mListener.didOfflineOfUid(AgoraChannel.this.mChannelId, j, i2);
                    }
                    if (AgoraChannel.this.mLogReport != null) {
                        AgoraChannel.this.mLogReport.deleteUser(j2);
                    }
                    LogCommonInfo.getInstance().removeVolume(String.valueOf(j2));
                    if (AgoraChannel.this.mEngine != null && AgoraChannel.this.mEngine.mediaDataObserverPlugin != null && AgoraChannel.this.mEngine.mediaDataObserverPlugin != null) {
                        AgoraChannel.this.mEngine.mediaDataObserverPlugin.removeBuffer(i);
                    }
                }

                public void onConnectionStateChanged(RtcChannel rtcChannel, int i, int i2) {
                    String str;
                    int i3 = i;
                    final int i4 = i2;
                    AgoraChannel.super.onConnectionStateChanged(rtcChannel, i, i2);
                    if (AgoraChannel.this.mListener != null) {
                        Logger.i("AgoraChannel onConnectionStateChanged mChannelId: " + AgoraChannel.this.mChannelId + ", state: " + i3 + " ,reason:" + i4, new Object[0]);
                        if (i4 == 3) {
                            Logger.i("AgoraChannel CONNECTION_CHANGED_BANNED_BY_SERVER", new Object[0]);
                            if (AgoraChannel.this.mEngine != null) {
                                AgoraChannel.this.mEngine.doEngineChangeNotify();
                                return;
                            }
                            return;
                        }
                        String str2 = "setting_proxy_server";
                        String str3 = "banned_by_server";
                        if (i3 == 1) {
                            if (AgoraChannel.this.mLogReport != null) {
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
                                AgoraChannel.this.mLogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ, str2, -1);
                            }
                            Handler access$400 = AgoraChannel.this.mHandler;
                            AnonymousClass3 r6 = new Runnable() {
                                public void run() {
                                    if (AgoraChannel.this.mListener != null) {
                                        AgoraChannel.this.mListener.connectionChangedToState(AgoraChannel.this.mChannelId, RTCConnectionStateType.RTCConnectionStateTypeDisconnected, RtcConnectReason.getReason(i4));
                                    }
                                }
                            };
                            if (!(access$400 instanceof Handler)) {
                                access$400.post(r6);
                            } else {
                                AsynchronousInstrumentation.handlerPost(access$400, r6);
                            }
                        } else if (i3 == 2) {
                            if (AgoraChannel.this.mLogReport != null) {
                                AgoraChannel.this.mLogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedConnecting, -1);
                            }
                            AgoraChannel.this.mListener.connectionChangedToState(AgoraChannel.this.mChannelId, RTCConnectionStateType.RTCConnectionStateTypeConnecting, RtcConnectReason.getReason(i2));
                        } else if (i3 == 3) {
                            if (AgoraChannel.this.mLogReport != null) {
                                AgoraChannel.this.mLogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, FirebaseAnalytics.Param.SUCCESS, -1);
                            }
                            Handler access$4002 = AgoraChannel.this.mHandler;
                            AnonymousClass4 r62 = new Runnable() {
                                public void run() {
                                    if (AgoraChannel.this.mListener != null) {
                                        AgoraChannel.this.mListener.connectionChangedToState(AgoraChannel.this.mChannelId, RTCConnectionStateType.RTCConnectionStateTypeConnected, RtcConnectReason.getReason(i4));
                                    }
                                }
                            };
                            if (!(access$4002 instanceof Handler)) {
                                access$4002.post(r62);
                            } else {
                                AsynchronousInstrumentation.handlerPost(access$4002, r62);
                            }
                        } else if (i3 == 4) {
                            AgoraChannel.this.mListener.connectionChangedToState(AgoraChannel.this.mChannelId, RTCConnectionStateType.RTCConnectionStateTypeReconnecting, RtcConnectReason.getReason(i2));
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
                                str = str3;
                            }
                            if (AgoraChannel.this.mLogReport != null) {
                                AgoraChannel.this.mLogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_OPPO, str, -1);
                            }
                            AgoraChannel.this.mListener.connectionChangedToState(AgoraChannel.this.mChannelId, RTCConnectionStateType.RTCConnectionStateTypeFailed, RtcConnectReason.getReason(i2));
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
                        if (AgoraChannel.this.mLogReport != null) {
                            AgoraChannel.this.mLogReport.sendCommonError("channelError", AgoraChannel.this.mLogReport.getmRoomid(), i3 + " " + i4 + "", i4 + "");
                            AgoraChannel.this.mLogReport.joinRoom(0, AgoraChannel.this.mLogReport.getmUserid(), LOGErrorCode.LOG_Fail.value, "joined room fail", 0);
                        }
                    }
                }

                public void onConnectionLost(RtcChannel rtcChannel) {
                    Logger.i("AgoraChannel onConnectionLost mChannelId: " + AgoraChannel.this.mChannelId, new Object[0]);
                    if (AgoraChannel.this.mLogReport != null) {
                        AgoraChannel.this.mLogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ, RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedInterrupted, -1);
                    }
                    if (AgoraChannel.this.mListener != null) {
                        Handler access$400 = AgoraChannel.this.mHandler;
                        AnonymousClass5 r0 = new Runnable() {
                            public void run() {
                                if (AgoraChannel.this.mListener != null) {
                                    AgoraChannel.this.mListener.connectionChangedToState(AgoraChannel.this.mChannelId, RTCConnectionStateType.RTCConnectionStateTypeDisconnected, "");
                                }
                            }
                        };
                        if (!(access$400 instanceof Handler)) {
                            access$400.post(r0);
                        } else {
                            AsynchronousInstrumentation.handlerPost(access$400, r0);
                        }
                    }
                }

                public void onTokenPrivilegeWillExpire(RtcChannel rtcChannel, String str) {
                    AgoraChannel.super.onTokenPrivilegeWillExpire(rtcChannel, str);
                    Logger.w("AgoraChannel onTokenPrivilegeWillExpire mChannelId: " + AgoraChannel.this.mChannelId, new Object[0]);
                }

                public void onRequestToken(RtcChannel rtcChannel) {
                    AgoraChannel.super.onRequestToken(rtcChannel);
                    Logger.w("AgoraChannel onRequestToken mChannelId: " + AgoraChannel.this.mChannelId, new Object[0]);
                }

                public void onRtcStats(RtcChannel rtcChannel, final IRtcEngineEventHandler.RtcStats rtcStats) {
                    AgoraChannel.super.onRtcStats(rtcChannel, rtcStats);
                    if (AgoraChannel.this.mLogReport != null) {
                        AgoraChannel.this.mLogReport.setGateWayRttAndAppCpu(rtcStats.gatewayRtt, (int) (rtcStats.cpuAppUsage * 100.0d));
                    }
                    if (AgoraChannel.this.mListener != null) {
                        Handler access$400 = AgoraChannel.this.mHandler;
                        AnonymousClass6 r0 = new Runnable() {
                            public void run() {
                                RTCEngine.ReportRtcStats reportRtcStats = new RTCEngine.ReportRtcStats();
                                reportRtcStats.txAudioBytes = rtcStats.txAudioBytes;
                                reportRtcStats.txVideoBytes = rtcStats.txVideoBytes;
                                reportRtcStats.rxAudioBytes = rtcStats.rxAudioBytes;
                                reportRtcStats.rxVideoBytes = rtcStats.rxVideoBytes;
                                reportRtcStats.txAudioKBitRate = rtcStats.txAudioKBitRate;
                                reportRtcStats.txVideoKBitRate = rtcStats.txVideoKBitRate;
                                reportRtcStats.rxAudioKBitRate = rtcStats.rxAudioKBitRate;
                                reportRtcStats.rxVideoKBitRate = rtcStats.rxVideoKBitRate;
                                reportRtcStats.cpuAppUsage = rtcStats.cpuAppUsage;
                                reportRtcStats.cpuTotalUsage = rtcStats.cpuTotalUsage;
                                reportRtcStats.txPacketsLostRate = (double) rtcStats.txPacketLossRate;
                                reportRtcStats.rxPacketsLostRate = (double) rtcStats.rxPacketLossRate;
                                reportRtcStats.gateWayRtt = rtcStats.gatewayRtt;
                                reportRtcStats.lastmileDelay = rtcStats.lastmileDelay;
                                if (AgoraChannel.this.mListener != null) {
                                    AgoraChannel.this.mListener.reportRtcStats(AgoraChannel.this.mChannelId, reportRtcStats);
                                }
                            }
                        };
                        if (!(access$400 instanceof Handler)) {
                            access$400.post(r0);
                        } else {
                            AsynchronousInstrumentation.handlerPost(access$400, r0);
                        }
                    }
                }

                public void onNetworkQuality(RtcChannel rtcChannel, int i, int i2, int i3) {
                    AgoraChannel.super.onNetworkQuality(rtcChannel, i, i2, i3);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onNetworkQuality(rtcChannel.channelId(), (long) i, i2, i3);
                    }
                }

                public void onRemoteVideoStats(RtcChannel rtcChannel, IRtcEngineEventHandler.RemoteVideoStats remoteVideoStats) {
                    if (AgoraChannel.this.mListener != null) {
                        RTCEngine.RemoteVideoStats remoteVideoStats2 = new RTCEngine.RemoteVideoStats();
                        remoteVideoStats2.uid = (long) remoteVideoStats.uid;
                        remoteVideoStats2.decoderOutputFrameRate = remoteVideoStats.decoderOutputFrameRate;
                        remoteVideoStats2.height = remoteVideoStats.height;
                        remoteVideoStats2.width = remoteVideoStats.width;
                        remoteVideoStats2.rendererOutputFrameRate = remoteVideoStats.rendererOutputFrameRate;
                        remoteVideoStats2.packetLossRate = remoteVideoStats.packetLossRate;
                        remoteVideoStats2.receivedBitrate = remoteVideoStats.receivedBitrate;
                        AgoraChannel.this.mListener.onRemoteVideoStats(rtcChannel.channelId(), remoteVideoStats2);
                    }
                    if (AgoraChannel.this.mLogReport != null) {
                        LogVideoRemoteStatistics logVideoRemoteStatistics = new LogVideoRemoteStatistics();
                        logVideoRemoteStatistics.uid = (long) remoteVideoStats.uid;
                        logVideoRemoteStatistics.width = remoteVideoStats.width;
                        logVideoRemoteStatistics.height = remoteVideoStats.height;
                        logVideoRemoteStatistics.receivedBitrate = remoteVideoStats.receivedBitrate;
                        logVideoRemoteStatistics.decoderOutputFrameRate = remoteVideoStats.decoderOutputFrameRate;
                        logVideoRemoteStatistics.latency = remoteVideoStats.endToEndDelayMs;
                        logVideoRemoteStatistics.avDiff = remoteVideoStats.avSyncTimeMs;
                        logVideoRemoteStatistics.packetLossRate = remoteVideoStats.packetLossRate;
                        AgoraChannel.this.mLogReport.LogStaticRemoteVideoStats(logVideoRemoteStatistics);
                    }
                }

                public void onRemoteAudioStats(RtcChannel rtcChannel, IRtcEngineEventHandler.RemoteAudioStats remoteAudioStats) {
                    AgoraChannel.super.onRemoteAudioStats(rtcChannel, remoteAudioStats);
                    if (AgoraChannel.this.mListener != null) {
                        RTCEngine.RemoteAudioStats remoteAudioStats2 = new RTCEngine.RemoteAudioStats();
                        remoteAudioStats2.uid = (long) remoteAudioStats.uid;
                        remoteAudioStats2.quality = remoteAudioStats.uid;
                        remoteAudioStats2.audioLossRate = remoteAudioStats.audioLossRate;
                        remoteAudioStats2.numChannels = remoteAudioStats.numChannels;
                        remoteAudioStats2.receivedSampleRate = remoteAudioStats.receivedSampleRate;
                        remoteAudioStats2.receivedBitrate = remoteAudioStats.receivedBitrate;
                        AgoraChannel.this.mListener.onRemoteAudioStats(rtcChannel.channelId(), remoteAudioStats2);
                    }
                    if (AgoraChannel.this.mLogReport != null) {
                        LogAudioRemoteStatistics logAudioRemoteStatistics = new LogAudioRemoteStatistics();
                        logAudioRemoteStatistics.uid = (long) remoteAudioStats.uid;
                        logAudioRemoteStatistics.jitterBufferDelay = remoteAudioStats.jitterBufferDelay;
                        logAudioRemoteStatistics.audioLossRate = remoteAudioStats.audioLossRate;
                        logAudioRemoteStatistics.receivedBitrate = remoteAudioStats.receivedBitrate;
                        logAudioRemoteStatistics.audioVolume = 0;
                        logAudioRemoteStatistics.audioDecFps = 0;
                        AgoraChannel.this.mLogReport.LogStaticRemoteAudioStats(logAudioRemoteStatistics);
                    }
                }

                public void onRemoteAudioStateChanged(RtcChannel rtcChannel, int i, int i2, int i3, int i4) {
                    AgoraChannel.super.onRemoteAudioStateChanged(rtcChannel, i, i2, i3, i4);
                    Logger.i("AgoraChannel onRemoteAudioStateChanged mChannelId = " + AgoraChannel.this.mChannelId + " uid: " + i + ", state: " + i2 + ", reason: " + i3 + ", elapsed: " + i4, new Object[0]);
                    if (AgoraChannel.this.mListener == null) {
                        return;
                    }
                    if (i3 == 5) {
                        AgoraChannel.this.mListener.didAudioMuted(rtcChannel.channelId(), (long) i, true);
                    } else if (i3 == 6) {
                        AgoraChannel.this.mListener.didAudioMuted(rtcChannel.channelId(), (long) i, false);
                    }
                }

                public void onActiveSpeaker(RtcChannel rtcChannel, int i) {
                    AgoraChannel.super.onActiveSpeaker(rtcChannel, i);
                }

                public void onFirstRemoteAudioFrame(RtcChannel rtcChannel, int i, int i2) {
                    final long j = ((long) i) & 4294967295L;
                    Logger.i("AgoraChannel onFirstRemoteAudioFrame mChannelId: " + AgoraChannel.this.mChannelId + " uid: " + j + ", elapsed: " + i2, new Object[0]);
                    if (AgoraChannel.this.mLogReport != null) {
                        AgoraChannel.this.mLogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, (String) null, j);
                    }
                    if (AgoraChannel.this.mListener != null) {
                        Handler access$400 = AgoraChannel.this.mHandler;
                        AnonymousClass7 r0 = new Runnable() {
                            public void run() {
                                if (AgoraChannel.this.mListener != null) {
                                    AgoraChannel.this.mListener.remotefirstAudioRecvWithUid(AgoraChannel.this.mChannelId, j);
                                }
                            }
                        };
                        if (!(access$400 instanceof Handler)) {
                            access$400.post(r0);
                        } else {
                            AsynchronousInstrumentation.handlerPost(access$400, r0);
                        }
                    }
                }

                public void onAudioSubscribeStateChanged(RtcChannel rtcChannel, int i, int i2, int i3, int i4) {
                    long j = ((long) i) & 4294967295L;
                    Logger.i("AgoraChannel onSubscribeAudioStateChanged mChannelId: " + AgoraChannel.this.mChannelId + ", uid: " + j + ", oldState: " + i2 + ", newState: " + i3 + ", elapsed: " + i4, new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onSubscribeAudioStateChanged(rtcChannel.channelId(), i, i2, i3);
                    }
                    if (i2 == 2 && i3 == 3 && AgoraChannel.this.mLogReport != null) {
                        AgoraChannel.this.mLogReport.LogStaticRemoteAudioIn(j, i4);
                    }
                }

                public void onFirstRemoteVideoFrame(RtcChannel rtcChannel, int i, int i2, int i3, int i4) {
                    AgoraChannel.super.onFirstRemoteVideoFrame(rtcChannel, i, i2, i3, i4);
                }

                public void onVideoSubscribeStateChanged(RtcChannel rtcChannel, int i, int i2, int i3, int i4) {
                    long j = ((long) i) & 4294967295L;
                    Logger.i("AgoraChannel onSubscribeVideoStateChanged mChannelId: " + AgoraChannel.this.mChannelId + ", uid: " + j + ", oldState: " + i2 + ", newState: " + i3 + ", elapsed: " + i4, new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onSubscribeVideoStateChanged(rtcChannel.channelId(), i, i2, i3);
                    }
                    if (i2 == 2 && i3 == 3 && AgoraChannel.this.mLogReport != null) {
                        AgoraChannel.this.mLogReport.LogStaticRemoteVideoIn(j, i4);
                    }
                }

                public void onVideoBufferingStateChanged(RtcChannel rtcChannel, int i, int i2, long j) {
                    long j2;
                    int i3 = i2;
                    long j3 = j;
                    long j4 = (long) i;
                    long j5 = j4 & 4294967295L;
                    Logger.i("AgoraChannel onVideoBufferingStateChanged mChannelId: " + rtcChannel.channelId() + ", CALL_ID: " + rtcChannel.channelId() + ", CONN_STATE " + rtcChannel.getConnectionState() + ", uid: " + j5 + ", state: " + i3 + " " + j3 + " " + System.currentTimeMillis(), new Object[0]);
                    if (i3 == 0) {
                        AgoraEngine.DelayObject delayObject = AgoraChannel.this.mEngine.delayMap.get(Integer.valueOf(i));
                        if (delayObject == null) {
                            AgoraEngine.DelayObject delayObject2 = new AgoraEngine.DelayObject();
                            delayObject2.uid = j4;
                            delayObject2.isDelay = 1;
                            delayObject2.roomId = rtcChannel.channelId();
                            delayObject2.startTime = j3;
                            AgoraChannel.this.mEngine.delayMap.put(Integer.valueOf(i), delayObject2);
                        } else {
                            delayObject.startTime = j3;
                        }
                        if (AgoraChannel.this.mLogReport != null) {
                            AgoraChannel.this.mLogReport.jitterRenderDelayStart(j, j5, rtcChannel.channelId());
                        }
                    } else if (i3 == 1) {
                        Iterator<Map.Entry<Integer, AgoraEngine.DelayObject>> it = AgoraChannel.this.mEngine.delayMap.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry next = it.next();
                            AgoraEngine.DelayObject delayObject3 = (AgoraEngine.DelayObject) next.getValue();
                            if (delayObject3.isDelay != 1 || !TextUtils.equals(delayObject3.roomId, rtcChannel.channelId()) || AgoraChannel.this.mLogReport == null) {
                                j2 = j4;
                            } else {
                                j2 = j4;
                                AgoraChannel.this.mLogReport.jitterRenderDelayEnd(j, ((AgoraEngine.DelayObject) next.getValue()).uid, delayObject3.roomId, j3 - delayObject3.startTime);
                            }
                            if (TextUtils.equals(delayObject3.roomId, rtcChannel.channelId())) {
                                it.remove();
                            }
                            j3 = j;
                            j4 = j2;
                        }
                    }
                    long j6 = j4;
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onVideoBufferingStateChanged(j6, i2, j);
                        AgoraChannel.this.mListener.onVideoBufferingStateChanged(rtcChannel.channelId(), j6, i2, j);
                    }
                }

                public void onVideoSizeChanged(RtcChannel rtcChannel, int i, int i2, int i3, int i4) {
                    AgoraChannel.super.onVideoSizeChanged(rtcChannel, i, i2, i3, i4);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onVideoSizeChanged(rtcChannel.channelId(), (long) i, i2, i3, i4);
                    }
                }

                public void onRemoteVideoStateChanged(RtcChannel rtcChannel, int i, int i2, int i3, int i4) {
                    long j = (long) i;
                    Logger.i("AgoraChannel onRemoteVideoStateChanged mChannelId = " + AgoraChannel.this.mChannelId + " uid: " + (4294967295L & j) + ", state: " + i2 + ", reason: " + i3 + ", elapsed: " + i4, new Object[0]);
                    if (i3 == 6 && AgoraChannel.this.mLogReport != null) {
                        AgoraChannel.this.mLogReport.LogStaticRemoteVideoIn(j, i4);
                    }
                    if (AgoraChannel.this.mListener != null) {
                        if (i3 == 5) {
                            AgoraChannel.this.mListener.didVideoMuted(rtcChannel.channelId(), j, true);
                        } else if (i3 == 6) {
                            AgoraChannel.this.mListener.didVideoMuted(rtcChannel.channelId(), j, false);
                        }
                    }
                    if (AgoraChannel.this.mListener != null && i2 != 3) {
                        AgoraChannel.this.mListener.onRemoteVideoStateChanged(AgoraChannel.this.mChannelId, j, i2);
                    }
                }

                public void onStreamMessage(RtcChannel rtcChannel, int i, int i2, byte[] bArr) {
                    AgoraChannel.super.onStreamMessage(rtcChannel, i, i2, bArr);
                    if (bArr != null) {
                        if (bArr.length == 24 && CommonUtils.isTSMsg(bArr)) {
                            synchronized (AgoraChannel.this.mTimestampRecLock) {
                                AgoraChannel.this.mMetadataRecTimestampMap.put(Integer.valueOf(i), Long.valueOf(AgoraChannel.longFrom8Bytes(bArr, 16, false)));
                                AgoraChannel.this.mRecTimestampMap.put(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis()));
                            }
                        } else if (bArr.length > 24 && CommonUtils.isIRCMsg(bArr)) {
                            int length = bArr.length - 24;
                            byte[] bArr2 = new byte[length];
                            System.arraycopy(bArr, 24, bArr2, 0, length);
                            if (AgoraChannel.this.mListener != null) {
                                long j = (long) i;
                                AgoraChannel.this.mListener.onStreamMessage(j, bArr2);
                                AgoraChannel.this.mListener.onStreamMessage(rtcChannel.channelId(), j, bArr2);
                            }
                        }
                    }
                }

                public void onStreamMessageError(RtcChannel rtcChannel, int i, int i2, int i3, int i4, int i5) {
                    AgoraChannel.super.onStreamMessageError(rtcChannel, i, i2, i3, i4, i5);
                }

                public void onChannelMediaRelayStateChanged(RtcChannel rtcChannel, int i, int i2) {
                    AgoraChannel.super.onChannelMediaRelayStateChanged(rtcChannel, i, i2);
                    Logger.i("AgoraChannel onChannelMediaRelayStateChanged mChannelId = " + AgoraChannel.this.mChannelId + ", state: " + i + ", code: " + i2, new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onChannelMediaRelayStateChanged(rtcChannel.channelId(), i, i2);
                    }
                }

                public void onChannelMediaRelayEvent(RtcChannel rtcChannel, int i) {
                    AgoraChannel.super.onChannelMediaRelayEvent(rtcChannel, i);
                    Logger.i("AgoraChannel onChannelMediaRelayEvent mChannelId = " + AgoraChannel.this.mChannelId + ", code: " + i, new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onChannelMediaRelayEvent(rtcChannel.channelId(), i);
                    }
                }

                public void onRtmpStreamingStateChanged(RtcChannel rtcChannel, String str, int i, int i2) {
                    AgoraChannel.super.onRtmpStreamingStateChanged(rtcChannel, str, i, i2);
                }

                public void onTranscodingUpdated(RtcChannel rtcChannel) {
                    AgoraChannel.super.onTranscodingUpdated(rtcChannel);
                }

                public void onStreamInjectedStatus(RtcChannel rtcChannel, String str, int i, int i2) {
                    AgoraChannel.super.onStreamInjectedStatus(rtcChannel, str, i, i2);
                }

                public void onRemoteSubscribeFallbackToAudioOnly(RtcChannel rtcChannel, int i, boolean z) {
                    AgoraChannel.super.onRemoteSubscribeFallbackToAudioOnly(rtcChannel, i, z);
                }

                public void onAudioPublishStateChanged(RtcChannel rtcChannel, int i, int i2, int i3) {
                    Logger.i("AgoraChannel onAudioPublishStateChanged mChannelId: " + AgoraChannel.this.mChannelId + ", oldState: " + i + ", newState: " + i2 + ", elapsed: " + i3 + ", " + rtcChannel, new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onPublishAudioStateChanged(rtcChannel.channelId(), i, i2);
                    }
                    if (i == 2 && i2 == 3) {
                        AgoraChannel.this.mLogReport.LogStaticLocalAudioIn(i3);
                        AgoraChannel.this.mLogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_AUDIO.value);
                        AgoraChannel.this.mLogReport.setAudioPublished(true);
                        return;
                    }
                    AgoraChannel.this.mLogReport.setAudioPublished(false);
                }

                public void onVideoPublishStateChanged(RtcChannel rtcChannel, int i, int i2, int i3) {
                    Logger.i("AgoraChannel onVideoPublishStateChanged mChannelId: " + AgoraChannel.this.mChannelId + ", oldState: " + i + ", newState: " + i2 + ", width: " + 0 + ", height: " + 0 + ", elapsed: " + i3 + ", " + rtcChannel, new Object[0]);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onPublishVideoStateChanged(rtcChannel.channelId(), i, i2);
                    }
                    if (i == 2 && i2 == 3) {
                        if (AgoraChannel.this.mLogReport != null) {
                            AgoraChannel.this.mLogReport.LogStaticLocalVideoIn(i3, 0, 0);
                            AgoraChannel.this.mLogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_VIDEO.value);
                            AgoraChannel.this.mLogReport.setVideoPublished(true);
                        }
                        AgoraChannel.this.mEngine.cachePublishChannelInfo(rtcChannel.channelId());
                    } else {
                        AgoraChannel.this.mLogReport.setVideoPublished(false);
                    }
                    if (i2 == 0 || i2 == 1) {
                        AgoraChannel.this.mEngine.cachePublishChannelInfo((String) null);
                    }
                }

                public void onRemoteStreamSubscribeAdvice(RtcChannel rtcChannel, int i, int i2, int i3) {
                    AgoraChannel.super.onRemoteStreamSubscribeAdvice(rtcChannel, i, i2, i3);
                    if (AgoraChannel.this.mListener != null) {
                        AgoraChannel.this.mListener.onRemoteStreamSubscribeAdvice(rtcChannel.channelId(), (long) i, i2, i3);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void setRemoteRenderMode(long j, RTCEngine.RTCVideoRenderMode rTCVideoRenderMode) {
        synchronized (gLock) {
            Logger.i("AgoraChannel setRemoteRenderMode mChannelId = " + this.mChannelId + " uid = " + j + " mode = " + rTCVideoRenderMode, new Object[0]);
            RtcChannel rtcChannel2 = this.rtcChannel;
            if (!(rtcChannel2 == null || this.mEngine == null)) {
                rtcChannel2.setRemoteRenderMode((int) j, rTCVideoRenderMode.getValue(), this.mEngine.mRemoteMirrorMode);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getChannelId() {
        String str;
        synchronized (gLock) {
            str = this.mChannelId;
        }
        return str;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getTimestamp(int r7) {
        /*
            r6 = this;
            io.agora.rtc.RtcChannel r0 = r6.rtcChannel
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
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.AgoraChannel.getTimestamp(int):long");
    }

    public int setRemoteVideoStreamType(long j, int i) {
        synchronized (gLock) {
            Logger.i("AgoraChannel setRemoteVideoStreamType uid: " + j + ", streamType: " + i, new Object[0]);
            RtcChannel rtcChannel2 = this.rtcChannel;
            if (rtcChannel2 == null) {
                return -1;
            }
            int remoteVideoStreamType = rtcChannel2.setRemoteVideoStreamType((int) j, i);
            return remoteVideoStreamType;
        }
    }

    public int setupRemoteVideo(long j, TextureView textureView) {
        AgoraEngine agoraEngine;
        synchronized (gLock) {
            if (!(this.rtcChannel == null || (agoraEngine = this.mEngine) == null)) {
                agoraEngine.setupRemoteVideo(textureView, j, this.mChannelId);
            }
        }
        return 0;
    }

    public String getChannelCallId() {
        RtcChannel rtcChannel2 = this.rtcChannel;
        return rtcChannel2 != null ? rtcChannel2.getChannelCallId() : "";
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

    public int publish() {
        synchronized (gLock) {
            Logger.i("AgoraChannel publish", new Object[0]);
            RtcChannel rtcChannel2 = this.rtcChannel;
            if (rtcChannel2 == null) {
                return -2;
            }
            int publish = rtcChannel2.publish();
            return publish;
        }
    }

    public int unPublish() {
        synchronized (gLock) {
            Logger.i("AgoraChannel unPublish", new Object[0]);
            RtcChannel rtcChannel2 = this.rtcChannel;
            if (rtcChannel2 == null) {
                return -2;
            }
            int unpublish = rtcChannel2.unpublish();
            return unpublish;
        }
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
            java.lang.String r2 = "AgoraChannel setRole role = "
            r1.append(r2)     // Catch:{ all -> 0x0038 }
            r1.append(r5)     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0038 }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0038 }
            com.eaydu.omni.logger.Logger.i(r1, r3)     // Catch:{ all -> 0x0038 }
            io.agora.rtc.RtcChannel r1 = r4.rtcChannel     // Catch:{ all -> 0x0038 }
            if (r1 != 0) goto L_0x0021
            r5 = -1
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            return r5
        L_0x0021:
            com.eaydu.omni.RTCEngine$RTCRole r1 = com.eaydu.omni.RTCEngine.RTCRole.RTCRoleBroadcaster     // Catch:{ all -> 0x0038 }
            if (r5 != r1) goto L_0x002c
            io.agora.rtc.RtcChannel r5 = r4.rtcChannel     // Catch:{ all -> 0x0038 }
            r1 = 1
            r5.setClientRole(r1)     // Catch:{ all -> 0x0038 }
            goto L_0x0036
        L_0x002c:
            com.eaydu.omni.RTCEngine$RTCRole r1 = com.eaydu.omni.RTCEngine.RTCRole.RTCRoleAudience     // Catch:{ all -> 0x0038 }
            if (r5 != r1) goto L_0x0036
            io.agora.rtc.RtcChannel r5 = r4.rtcChannel     // Catch:{ all -> 0x0038 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.AgoraChannel.setRole(com.eaydu.omni.RTCEngine$RTCRole):int");
    }

    public int muteLocalAudio(boolean z) {
        int i;
        synchronized (gLock) {
            Logger.i("AgoraChannel muteLocalAudio muted = " + z, new Object[0]);
            RtcChannel rtcChannel2 = this.rtcChannel;
            if (rtcChannel2 != null) {
                i = rtcChannel2.muteLocalAudioStream(z);
                if (i == 0) {
                    LogReport logReport = this.mLogReport;
                    if (logReport != null) {
                        if (z) {
                            logReport.LogStopPublish(logReport.getmUserid(), LOGMediaType.LOG_MEDIA_AUDIO.value);
                        } else {
                            logReport.LogStartPublish(LOGMediaType.LOG_MEDIA_AUDIO.value);
                        }
                    }
                } else {
                    Logger.i("AgoraChannel muteLocalAudio failed code = " + i, new Object[0]);
                }
            } else {
                i = -1;
            }
            LogReport logReport2 = this.mLogReport;
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

    public int muteLocalVideo(boolean z) {
        int i;
        synchronized (gLock) {
            Logger.i("AgoraChannel muteLocalVideo muted = " + z, new Object[0]);
            RtcChannel rtcChannel2 = this.rtcChannel;
            if (rtcChannel2 != null) {
                i = rtcChannel2.muteLocalVideoStream(z);
                if (i == 0) {
                    LogReport logReport = this.mLogReport;
                    if (logReport != null) {
                        if (z) {
                            logReport.LogStopPublish(logReport.getmUserid(), LOGMediaType.LOG_MEDIA_VIDEO.value);
                        } else {
                            logReport.LogStartPublish(LOGMediaType.LOG_MEDIA_VIDEO.value);
                        }
                    }
                } else {
                    Logger.i("AgoraChannel muteLocalVideo failed code = " + i, new Object[0]);
                }
            } else {
                i = -1;
            }
            LogReport logReport2 = this.mLogReport;
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

    public int startChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        if (this.rtcChannel == null) {
            return -2;
        }
        ChannelMediaRelayConfiguration agoraChannelMediaRelayConfigurationFromRTC = AgoraEngine.ClassConverter.getAgoraChannelMediaRelayConfigurationFromRTC(rTCChannelMediaRelayConfiguration);
        if (agoraChannelMediaRelayConfigurationFromRTC == null) {
            return -3;
        }
        return this.rtcChannel.startChannelMediaRelay(agoraChannelMediaRelayConfigurationFromRTC);
    }

    public int stopChannelMediaRelay() {
        RtcChannel rtcChannel2 = this.rtcChannel;
        if (rtcChannel2 == null) {
            return -2;
        }
        return rtcChannel2.stopChannelMediaRelay();
    }

    public int updateChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        if (this.rtcChannel == null) {
            return -2;
        }
        return this.rtcChannel.updateChannelMediaRelay(AgoraEngine.ClassConverter.getAgoraChannelMediaRelayConfigurationFromRTC(rTCChannelMediaRelayConfiguration));
    }

    public void muteAllRemoteVideo(boolean z) {
        Logger.i("AgoraChannel muteAllRemoteVideo mChannelId: " + this.mChannelId + ", mute: " + z, new Object[0]);
        RtcChannel rtcChannel2 = this.rtcChannel;
        if (rtcChannel2 != null) {
            rtcChannel2.muteAllRemoteVideoStreams(z);
        }
    }

    public void muteAllRemoteAudio(boolean z) {
        Logger.i("AgoraChannel muteAllRemoteAudio mChannelId: " + this.mChannelId + ", mute: " + z, new Object[0]);
        RtcChannel rtcChannel2 = this.rtcChannel;
        if (rtcChannel2 != null) {
            rtcChannel2.muteAllRemoteAudioStreams(z);
        }
    }

    public int applyRemoteStreamSubscribeAdvice(long j, int i) {
        Logger.i("AgoraChannel applyRemoteStreamSubscribeAdvice uid = " + j + " streamType = " + i, new Object[0]);
        RtcChannel rtcChannel2 = this.rtcChannel;
        if (rtcChannel2 == null) {
            return -2;
        }
        return rtcChannel2.applyRemoteStreamSubscribeAdvice((int) j, i);
    }

    public int sendStreamMessage(long j, byte[] bArr) {
        if (this.rtcChannel == null) {
            return -2;
        }
        if (bArr.length > 1000) {
            return -114;
        }
        byte[] bArr2 = new byte[(bArr.length + 24)];
        byte[] LongToBytes = DataUtils.LongToBytes(j);
        System.arraycopy(EngineConfig.SEI_IRC_UUID, 0, bArr2, 0, 16);
        System.arraycopy(LongToBytes, 0, bArr2, 16, 8);
        System.arraycopy(bArr, 0, bArr2, 24, bArr.length);
        return this.rtcChannel.sendStreamMessage(this.mDataStreamId, bArr2);
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        Logger.i("AgoraChannel setDefaultMuteAllRemoteAudioStreams muted = " + z, new Object[0]);
        RtcChannel rtcChannel2 = this.rtcChannel;
        if (rtcChannel2 != null) {
            return rtcChannel2.setDefaultMuteAllRemoteAudioStreams(z);
        }
        return -2;
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        Logger.i("AgoraChannel setDefaultMuteAllRemoteVideoStreams muted = " + z, new Object[0]);
        RtcChannel rtcChannel2 = this.rtcChannel;
        if (rtcChannel2 != null) {
            return rtcChannel2.setDefaultMuteAllRemoteAudioStreams(z);
        }
        return -2;
    }

    public int addPublishStreamUrl(String str, boolean z) {
        int i;
        RtcChannel rtcChannel2 = this.rtcChannel;
        if (rtcChannel2 == null) {
            i = -1;
        } else {
            i = rtcChannel2.addPublishStreamUrl(str, z);
        }
        LogReport logReport = this.mLogReport;
        if (logReport != null) {
            logReport.pushRtmpState(str, "1000", i + "");
        }
        Logger.i("AgoraChannel addPublishStreamUrl url = " + str + "needTranscode" + z + "errCode = " + i, new Object[0]);
        return i;
    }

    public int removePublishStreamUrl(String str) {
        int i;
        RtcChannel rtcChannel2 = this.rtcChannel;
        if (rtcChannel2 == null) {
            i = -1;
        } else {
            i = rtcChannel2.removePublishStreamUrl(str);
        }
        LogReport logReport = this.mLogReport;
        if (logReport != null) {
            logReport.pushRtmpState(str, "1001", i + "");
        }
        Logger.i("AgoraChannel removePublishStreamUrl url = " + str + "errCode = " + i, new Object[0]);
        return i;
    }

    public int setRtmpConfig(RTCEngine.RTCRtmpConfig rTCRtmpConfig) {
        Logger.i("AgoraEngine setRtmpConfig " + rTCRtmpConfig.toString(), new Object[0]);
        if (this.rtcChannel == null || rTCRtmpConfig == null) {
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
        this.rtcChannel.setLiveTranscoding(liveTranscoding);
        return 0;
    }
}
