package com.eaydu.omni;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.eaydu.omni.BaseRtcEngine;
import com.eaydu.omni.OMNIEngine;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.eaydu.omni.log.LOGErrorCode;
import com.eaydu.omni.log.LOGMediaType;
import com.eaydu.omni.log.LogCommonInfo;
import com.eaydu.omni.log.LogReport;
import com.eaydu.omni.log.bean.LogAudioRemoteStatistics;
import com.eaydu.omni.log.bean.LogMemoryStatistics;
import com.eaydu.omni.log.bean.LogVideoRemoteStatistics;
import com.eaydu.omni.logger.Logger;
import com.eaydu.omni.utils.CommonUtils;
import com.eaydu.omni.utils.DataUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.wstechapi.OmniRtcChannel;
import com.wushuangtech.wstechapi.OmniRtcChannelEventHandler;
import com.wushuangtech.wstechapi.bean.ChannelMediaOptions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OMNIChannel extends BaseRTCChannel {
    private static final int ERROR_CHANNEL_EMPTY = -10;
    /* access modifiers changed from: private */
    public static final Object gLock = new Object();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Long, OMNIEngine.DelayObject> audioDelayMap = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<Long, OMNIEngine.DelayObject> delayMap = new ConcurrentHashMap<>();
    private OMNIEngine.EngineAndChannelEachOtherListener engineAndChannelEachOtherListener;
    private long leaveChannelStartTime;
    private BaseRtcEngine.IActivityStateCallback mActivityStateCallback = new BaseRtcEngine.IActivityStateCallback() {
        public void onState(int i) {
            if (OMNIChannel.this.mLogReport != null) {
                OMNIChannel.this.mLogReport.appStateChanged(i);
            }
        }
    };
    /* access modifiers changed from: private */
    public String mChannelId;
    /* access modifiers changed from: private */
    public int mDataStreamId = 0;
    /* access modifiers changed from: private */
    public OMNIEngine mEngine;
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
    public Object mTimestampRecLock = new Object();
    private OmniRtcChannel rtcChannel;

    /* access modifiers changed from: protected */
    public void setRtcChannel(OmniRtcChannel omniRtcChannel) {
        this.rtcChannel = omniRtcChannel;
        if (omniRtcChannel != null) {
            this.mChannelId = omniRtcChannel.channelId();
        }
    }

    /* access modifiers changed from: protected */
    public void setEngine(OMNIEngine oMNIEngine) {
        this.mEngine = oMNIEngine;
    }

    /* access modifiers changed from: protected */
    public void setEngineListener(OMNIEngine.EngineAndChannelEachOtherListener engineAndChannelEachOtherListener2) {
        this.engineAndChannelEachOtherListener = engineAndChannelEachOtherListener2;
        Logger.i("OMNIChannel setEngineListener ", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void setLogReport(LogReport logReport) {
        super.setLogReport(logReport);
        this.mLogReport = logReport;
    }

    public void joinChannel(String str, long j) {
        int i;
        if (this.rtcChannel != null) {
            ChannelMediaOptions channelMediaOptions = new ChannelMediaOptions();
            channelMediaOptions.autoSubscribeAudio = true;
            channelMediaOptions.autoSubscribeVideo = true;
            i = this.rtcChannel.joinChannel(str, j, channelMediaOptions);
        } else {
            i = ERROR_CHANNEL_EMPTY;
        }
        Logger.i("OMNIChannel joinChannel uid = " + j + " token = " + str + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        OMNIEngine oMNIEngine = this.mEngine;
        if (oMNIEngine != null) {
            oMNIEngine.addActivityStateCallback(this.mActivityStateCallback);
        }
    }

    public void leaveChannel() {
        Logger.i("OMNIChannel leaveChannel " + this.mChannelId, new Object[0]);
        this.leaveChannelStartTime = System.currentTimeMillis();
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel != null) {
            omniRtcChannel.leaveChannel();
        }
        OMNIEngine oMNIEngine = this.mEngine;
        if (oMNIEngine != null) {
            oMNIEngine.removeActivityStateCallback(this.mActivityStateCallback);
        }
        LogReport logReport = this.mLogReport;
        if (logReport != null) {
            logReport.leaveRoom(this.mChannelId, logReport.getmUserid(), LOGErrorCode.LOG_Success.value, "LeaveRoom bye bye", System.currentTimeMillis() - this.leaveChannelStartTime);
        }
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        Logger.i("OMNIChannel destroy " + this.mChannelId, new Object[0]);
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel != null) {
            omniRtcChannel.destroy();
            this.rtcChannel = null;
        }
    }

    public void setEventListener(RTCChannel.IRTCChannelEventListener iRTCChannelEventListener) {
        Logger.i("OMNIChannel setEventListener", new Object[0]);
        if (this.rtcChannel != null) {
            Logger.i("OMNIChannel setEventListener success", new Object[0]);
            this.mListener = iRTCChannelEventListener;
            this.rtcChannel.setRtcChannelEventHandler(new OmniRtcChannelEventHandler() {
                public void onChannelWarning(OmniRtcChannel omniRtcChannel, int i) {
                    OMNIChannel.super.onChannelWarning(omniRtcChannel, i);
                }

                public void onChannelError(OmniRtcChannel omniRtcChannel, int i) {
                    OMNIChannel.super.onChannelError(omniRtcChannel, i);
                    Logger.i("OMNIChannel onChannelError channelId = " + OMNIChannel.this.mChannelId + " error = " + i, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        if (i == 110) {
                            OMNIChannel.this.mListener.didOccurError(omniRtcChannel.channelId(), RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeInvalidToken);
                        } else if (i == 170001) {
                            OMNIChannel.this.mListener.didOccurError(omniRtcChannel.channelId(), RTCEngine.RTCEngineErrorCode.RTCEngineErrorCodeTokenExpired);
                        }
                    }
                }

                public void onJoinChannelSuccess(final OmniRtcChannel omniRtcChannel, long j, int i) {
                    String channelSessionId = omniRtcChannel.getChannelSessionId();
                    Logger.i("OMNIChannel onJoinChannelSuccess channel=" + OMNIChannel.this.mChannelId + ", uid=" + j + ", sessionId=" + channelSessionId + ", elapsed=" + i, new Object[0]);
                    Handler access$500 = OMNIChannel.this.mHandler;
                    AnonymousClass1 r2 = new Runnable() {
                        public void run() {
                            synchronized (OMNIChannel.gLock) {
                                if (omniRtcChannel != null) {
                                    int unused = OMNIChannel.this.mDataStreamId = omniRtcChannel.createDataStream(false, false);
                                }
                            }
                        }
                    };
                    if (!(access$500 instanceof Handler)) {
                        access$500.post(r2);
                    } else {
                        AsynchronousInstrumentation.handlerPost(access$500, r2);
                    }
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.localUserJoinedWithUid(OMNIChannel.this.mChannelId, j);
                    }
                    if (OMNIChannel.this.mLogReport != null) {
                        OMNIChannel.this.mLogReport.setSessionId(channelSessionId);
                        OMNIChannel.this.mLogReport.joinRoom(i, j, LOGErrorCode.LOG_Success.value, "joined room successfully", 0);
                    }
                }

                public void onRejoinChannelSuccess(OmniRtcChannel omniRtcChannel, long j, int i) {
                    String channelSessionId = omniRtcChannel.getChannelSessionId();
                    Logger.i("OMNIChannel onRejoinChannelSuccess channel=" + OMNIChannel.this.mChannelId + ", uid=" + j + ", sessionId=" + channelSessionId + ", elapsed=" + i, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.localUserJoinedWithUid(OMNIChannel.this.mChannelId, j);
                    }
                    if (OMNIChannel.this.mLogReport != null) {
                        OMNIChannel.this.mLogReport.setSessionId(channelSessionId);
                        OMNIChannel.this.mLogReport.joinRoom(i, j, LOGErrorCode.LOG_Success.value, "ReJoined room successfully", 1);
                    }
                }

                public void onLeaveChannel(OmniRtcChannel omniRtcChannel, RtcStats rtcStats) {
                    OMNIChannel.super.onLeaveChannel(omniRtcChannel, rtcStats);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onLeaveChannel(OMNIChannel.this.mChannelId);
                    }
                }

                public void onClientRoleChanged(OmniRtcChannel omniRtcChannel, int i, int i2) {
                    OMNIChannel.super.onClientRoleChanged(omniRtcChannel, i, i2);
                }

                public void onUserJoined(OmniRtcChannel omniRtcChannel, long j, int i) {
                    OMNIChannel.super.onUserJoined(omniRtcChannel, j, i);
                    Logger.i("OMNIChannel onUserJoined mChannelId = " + OMNIChannel.this.mChannelId + " uid = " + j, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.remoteUserJoinWithUid(OMNIChannel.this.mChannelId, j);
                    }
                }

                public void onUserOffline(OmniRtcChannel omniRtcChannel, long j, int i) {
                    OMNIChannel.super.onUserOffline(omniRtcChannel, j, i);
                    Logger.i("OMNIChannel onUserOffline mChannelId = " + OMNIChannel.this.mChannelId + " ,uid = " + j + " ,reason= " + i, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.didOfflineOfUid(OMNIChannel.this.mChannelId, j);
                        OMNIChannel.this.mListener.didOfflineOfUid(OMNIChannel.this.mChannelId, j, i);
                    }
                    if (OMNIChannel.this.mLogReport != null) {
                        OMNIChannel.this.mLogReport.deleteUser(j);
                    }
                    LogCommonInfo.getInstance().removeVolume(String.valueOf(j));
                }

                public void onUserKicked(OmniRtcChannel omniRtcChannel, long j, int i, int i2) {
                    Logger.i("OMNIChannel onUserKicked uid = " + j + " reason = " + i + "kickTime = " + i2, new Object[0]);
                    if (i2 == 7200 && i == 111) {
                        Logger.i("OMNIChannel CONNECTION_CHANGED_BANNED_BY_SERVER", new Object[0]);
                        if (OMNIChannel.this.mEngine != null) {
                            OMNIChannel.this.mEngine.doEngineChangeNotify();
                        }
                    }
                    if (i == 105) {
                        Logger.i("OMNIChannel ERROR_KICK_BY_RELOGIN " + OMNIChannel.this.mChannelId, new Object[0]);
                        if (OMNIChannel.this.mListener != null) {
                            OMNIChannel.this.mListener.onKick(OMNIChannel.this.mChannelId, i);
                        }
                    }
                }

                /* JADX WARNING: Code restructure failed: missing block: B:55:0x0146, code lost:
                    r10 = r6;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:66:0x015d, code lost:
                    com.eaydu.omni.OMNIChannel.access$000(r0.this$0).addImportantEvents("1", com.igexin.assist.sdk.AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, r10, -1);
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onConnectionStateChanged(com.wushuangtech.wstechapi.OmniRtcChannel r25, int r26, int r27) {
                    /*
                        r24 = this;
                        r0 = r24
                        r1 = r26
                        r2 = r27
                        com.eaydu.omni.OMNIChannel.super.onConnectionStateChanged(r25, r26, r27)
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        r3.<init>()
                        java.lang.String r4 = "OMNIChannel onConnectionStateChanged channelId = "
                        r3.append(r4)
                        com.eaydu.omni.OMNIChannel r4 = com.eaydu.omni.OMNIChannel.this
                        java.lang.String r4 = r4.mChannelId
                        r3.append(r4)
                        java.lang.String r4 = ", state="
                        r3.append(r4)
                        r3.append(r1)
                        java.lang.String r4 = ", reason = "
                        r3.append(r4)
                        r3.append(r2)
                        java.lang.String r3 = r3.toString()
                        r4 = 0
                        java.lang.Object[] r5 = new java.lang.Object[r4]
                        com.eaydu.omni.logger.Logger.i(r3, r5)
                        com.eaydu.omni.OMNIChannel r3 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.RTCChannel$IRTCChannelEventListener r3 = r3.mListener
                        if (r3 != 0) goto L_0x003f
                        return
                    L_0x003f:
                        r5 = 1
                        java.lang.String r6 = "keep_alive_timeout"
                        java.lang.String r7 = "client_ip_address_changed"
                        java.lang.String r8 = "renew_token"
                        java.lang.String r9 = "setting_proxy_server"
                        java.lang.String r10 = "rejected_by_server"
                        java.lang.String r11 = "token_expired"
                        java.lang.String r12 = "invalid_token"
                        java.lang.String r13 = "invalid_channel_name"
                        java.lang.String r14 = "invalid_app_id"
                        java.lang.String r15 = "leave_channel"
                        java.lang.String r16 = "join_failed"
                        java.lang.String r17 = "banned_by_server"
                        java.lang.String r4 = ""
                        if (r1 == r5) goto L_0x0139
                        r5 = 2
                        if (r1 == r5) goto L_0x0110
                        r5 = 3
                        if (r1 == r5) goto L_0x00cc
                        r5 = 4
                        if (r1 == r5) goto L_0x00bb
                        r5 = 5
                        if (r1 == r5) goto L_0x006a
                        goto L_0x0184
                    L_0x006a:
                        switch(r2) {
                            case 3: goto L_0x0091;
                            case 4: goto L_0x008e;
                            case 5: goto L_0x008b;
                            case 6: goto L_0x0088;
                            case 7: goto L_0x0085;
                            case 8: goto L_0x0082;
                            case 9: goto L_0x007f;
                            case 10: goto L_0x007c;
                            case 11: goto L_0x0079;
                            case 12: goto L_0x0076;
                            case 13: goto L_0x0073;
                            case 14: goto L_0x0070;
                            default: goto L_0x006d;
                        }
                    L_0x006d:
                        r21 = r4
                        goto L_0x0093
                    L_0x0070:
                        r21 = r6
                        goto L_0x0093
                    L_0x0073:
                        r21 = r7
                        goto L_0x0093
                    L_0x0076:
                        r21 = r8
                        goto L_0x0093
                    L_0x0079:
                        r21 = r9
                        goto L_0x0093
                    L_0x007c:
                        r21 = r10
                        goto L_0x0093
                    L_0x007f:
                        r21 = r11
                        goto L_0x0093
                    L_0x0082:
                        r21 = r12
                        goto L_0x0093
                    L_0x0085:
                        r21 = r13
                        goto L_0x0093
                    L_0x0088:
                        r21 = r14
                        goto L_0x0093
                    L_0x008b:
                        r21 = r15
                        goto L_0x0093
                    L_0x008e:
                        r21 = r16
                        goto L_0x0093
                    L_0x0091:
                        r21 = r17
                    L_0x0093:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r5 = r5.mLogReport
                        if (r5 == 0) goto L_0x00aa
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r18 = r5.mLogReport
                        r22 = -1
                        java.lang.String r19 = "1"
                        java.lang.String r20 = "5"
                        r18.addImportantEvents(r19, r20, r21, r22)
                    L_0x00aa:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        java.lang.String r5 = r5.mChannelId
                        com.eaydu.omni.listener.RTCConnectionStateType r6 = com.eaydu.omni.listener.RTCConnectionStateType.RTCConnectionStateTypeFailed
                        java.lang.String r7 = com.eaydu.omni.listener.RtcConnectReason.getReason(r27)
                        r3.connectionChangedToState(r5, r6, r7)
                        goto L_0x0184
                    L_0x00bb:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        java.lang.String r5 = r5.mChannelId
                        com.eaydu.omni.listener.RTCConnectionStateType r6 = com.eaydu.omni.listener.RTCConnectionStateType.RTCConnectionStateTypeReconnecting
                        java.lang.String r7 = com.eaydu.omni.listener.RtcConnectReason.getReason(r27)
                        r3.connectionChangedToState(r5, r6, r7)
                        goto L_0x0184
                    L_0x00cc:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r5 = r5.mLogReport
                        if (r5 == 0) goto L_0x00f5
                        r5 = 15
                        if (r2 == r5) goto L_0x00e3
                        r5 = 16
                        if (r2 == r5) goto L_0x00e0
                        java.lang.String r5 = "success"
                    L_0x00de:
                        r9 = r5
                        goto L_0x00e6
                    L_0x00e0:
                        java.lang.String r5 = "video_switch_server"
                        goto L_0x00de
                    L_0x00e3:
                        java.lang.String r5 = "audio_switch_server"
                        goto L_0x00de
                    L_0x00e6:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r6 = r5.mLogReport
                        r10 = -1
                        java.lang.String r7 = "1"
                        java.lang.String r8 = "3"
                        r6.addImportantEvents(r7, r8, r9, r10)
                    L_0x00f5:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        android.os.Handler r5 = r5.mHandler
                        com.eaydu.omni.OMNIChannel$2$3 r6 = new com.eaydu.omni.OMNIChannel$2$3
                        r6.<init>(r3, r2)
                        boolean r3 = r5 instanceof android.os.Handler
                        if (r3 != 0) goto L_0x0109
                        r5.post(r6)
                        goto L_0x0184
                    L_0x0109:
                        android.os.Handler r5 = (android.os.Handler) r5
                        com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation.handlerPost(r5, r6)
                        goto L_0x0184
                    L_0x0110:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r5 = r5.mLogReport
                        if (r5 == 0) goto L_0x0129
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r6 = r5.mLogReport
                        r10 = -1
                        java.lang.String r7 = "1"
                        java.lang.String r8 = "4"
                        java.lang.String r9 = "connecting"
                        r6.addImportantEvents(r7, r8, r9, r10)
                    L_0x0129:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        java.lang.String r5 = r5.mChannelId
                        com.eaydu.omni.listener.RTCConnectionStateType r6 = com.eaydu.omni.listener.RTCConnectionStateType.RTCConnectionStateTypeConnecting
                        java.lang.String r7 = com.eaydu.omni.listener.RtcConnectReason.getReason(r27)
                        r3.connectionChangedToState(r5, r6, r7)
                        goto L_0x0184
                    L_0x0139:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r5 = r5.mLogReport
                        if (r5 == 0) goto L_0x016c
                        switch(r2) {
                            case 3: goto L_0x015b;
                            case 4: goto L_0x0158;
                            case 5: goto L_0x0156;
                            case 6: goto L_0x0154;
                            case 7: goto L_0x0152;
                            case 8: goto L_0x0150;
                            case 9: goto L_0x014e;
                            case 10: goto L_0x015d;
                            case 11: goto L_0x014c;
                            case 12: goto L_0x014a;
                            case 13: goto L_0x0148;
                            case 14: goto L_0x0146;
                            default: goto L_0x0144;
                        }
                    L_0x0144:
                        java.lang.String r6 = "interrupted"
                    L_0x0146:
                        r10 = r6
                        goto L_0x015d
                    L_0x0148:
                        r10 = r7
                        goto L_0x015d
                    L_0x014a:
                        r10 = r8
                        goto L_0x015d
                    L_0x014c:
                        r10 = r9
                        goto L_0x015d
                    L_0x014e:
                        r10 = r11
                        goto L_0x015d
                    L_0x0150:
                        r10 = r12
                        goto L_0x015d
                    L_0x0152:
                        r10 = r13
                        goto L_0x015d
                    L_0x0154:
                        r10 = r14
                        goto L_0x015d
                    L_0x0156:
                        r10 = r15
                        goto L_0x015d
                    L_0x0158:
                        r10 = r16
                        goto L_0x015d
                    L_0x015b:
                        r10 = r17
                    L_0x015d:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r7 = r5.mLogReport
                        r11 = -1
                        java.lang.String r8 = "1"
                        java.lang.String r9 = "2"
                        r7.addImportantEvents(r8, r9, r10, r11)
                    L_0x016c:
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        android.os.Handler r5 = r5.mHandler
                        com.eaydu.omni.OMNIChannel$2$2 r6 = new com.eaydu.omni.OMNIChannel$2$2
                        r6.<init>(r3, r2)
                        boolean r3 = r5 instanceof android.os.Handler
                        if (r3 != 0) goto L_0x017f
                        r5.post(r6)
                        goto L_0x0184
                    L_0x017f:
                        android.os.Handler r5 = (android.os.Handler) r5
                        com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation.handlerPost(r5, r6)
                    L_0x0184:
                        switch(r2) {
                            case 4: goto L_0x0189;
                            case 5: goto L_0x0187;
                            case 6: goto L_0x0189;
                            case 7: goto L_0x0189;
                            case 8: goto L_0x0189;
                            case 9: goto L_0x0189;
                            case 10: goto L_0x0189;
                            default: goto L_0x0187;
                        }
                    L_0x0187:
                        r1 = 3
                        goto L_0x01e8
                    L_0x0189:
                        com.eaydu.omni.OMNIChannel r3 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r3 = r3.mLogReport
                        if (r3 == 0) goto L_0x0187
                        com.eaydu.omni.OMNIChannel r3 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r3 = r3.mLogReport
                        com.eaydu.omni.OMNIChannel r5 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r5 = r5.mLogReport
                        java.lang.String r5 = r5.getmRoomid()
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                        r6.<init>()
                        r6.append(r1)
                        java.lang.String r1 = " "
                        r6.append(r1)
                        r6.append(r2)
                        r6.append(r4)
                        java.lang.String r1 = r6.toString()
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                        r6.<init>()
                        r6.append(r2)
                        r6.append(r4)
                        java.lang.String r4 = r6.toString()
                        java.lang.String r6 = "channelError"
                        r3.sendCommonError(r6, r5, r1, r4)
                        com.eaydu.omni.OMNIChannel r1 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r3 = r1.mLogReport
                        r4 = 0
                        com.eaydu.omni.OMNIChannel r1 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.log.LogReport r1 = r1.mLogReport
                        long r5 = r1.getmUserid()
                        com.eaydu.omni.log.LOGErrorCode r1 = com.eaydu.omni.log.LOGErrorCode.LOG_Fail
                        int r7 = r1.value
                        r9 = 0
                        java.lang.String r8 = "joined room fail"
                        r3.joinRoom(r4, r5, r7, r8, r9)
                        goto L_0x0187
                    L_0x01e8:
                        if (r2 != r1) goto L_0x021c
                        r1 = 0
                        java.lang.Object[] r1 = new java.lang.Object[r1]
                        java.lang.String r2 = "OMNIChannel CONNECTION_CHANGED_BANNED_BY_SERVER"
                        com.eaydu.omni.logger.Logger.i(r2, r1)
                        com.eaydu.omni.OMNIChannel r1 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.OMNIEngine r1 = r1.mEngine
                        if (r1 == 0) goto L_0x021c
                        com.eaydu.omni.OMNIChannel r1 = com.eaydu.omni.OMNIChannel.this
                        com.eaydu.omni.OMNIEngine r1 = r1.mEngine
                        com.eaydu.omni.RTCEngine$RtcEngineEventObserver r1 = r1.mObserver
                        if (r1 == 0) goto L_0x021c
                        com.eaydu.omni.OMNIChannel r1 = com.eaydu.omni.OMNIChannel.this
                        android.os.Handler r1 = r1.mHandler
                        com.eaydu.omni.OMNIChannel$2$4 r2 = new com.eaydu.omni.OMNIChannel$2$4
                        r2.<init>()
                        boolean r3 = r1 instanceof android.os.Handler
                        if (r3 != 0) goto L_0x0217
                        r1.post(r2)
                        goto L_0x021c
                    L_0x0217:
                        android.os.Handler r1 = (android.os.Handler) r1
                        com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation.handlerPost(r1, r2)
                    L_0x021c:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.OMNIChannel.AnonymousClass2.onConnectionStateChanged(com.wushuangtech.wstechapi.OmniRtcChannel, int, int):void");
                }

                public void onConnectionLost(OmniRtcChannel omniRtcChannel) {
                    OMNIChannel.super.onConnectionLost(omniRtcChannel);
                    Logger.i("OMNIChannel onConnectionLost mChannelId = " + OMNIChannel.this.mChannelId, new Object[0]);
                    if (OMNIChannel.this.mLogReport != null) {
                        OMNIChannel.this.mLogReport.addImportantEvents("1", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_MZ, RTCEngine.RTCConnectionChangedReason.RTCConnectionChangedInterrupted, -1);
                    }
                    if (OMNIChannel.this.mListener != null) {
                        Handler access$500 = OMNIChannel.this.mHandler;
                        AnonymousClass5 r0 = new Runnable() {
                            public void run() {
                                if (OMNIChannel.this.mListener != null) {
                                    OMNIChannel.this.mListener.connectionChangedToState(OMNIChannel.this.mChannelId, RTCConnectionStateType.RTCConnectionStateTypeDisconnected, "");
                                }
                            }
                        };
                        if (!(access$500 instanceof Handler)) {
                            access$500.post(r0);
                        } else {
                            AsynchronousInstrumentation.handlerPost(access$500, r0);
                        }
                    }
                }

                public void onTokenPrivilegeWillExpire(OmniRtcChannel omniRtcChannel, String str) {
                    OMNIChannel.super.onTokenPrivilegeWillExpire(omniRtcChannel, str);
                }

                public void onRequestToken(OmniRtcChannel omniRtcChannel) {
                    OMNIChannel.super.onRequestToken(omniRtcChannel);
                }

                public void onRtcStats(OmniRtcChannel omniRtcChannel, final RtcStats rtcStats) {
                    OMNIChannel.super.onRtcStats(omniRtcChannel, rtcStats);
                    if (OMNIChannel.this.mLogReport != null) {
                        OMNIChannel.this.mLogReport.setGateWayRttAndAppCpu(rtcStats.gatewayRtt, (int) (rtcStats.cpuAppUsage * 100.0d));
                        LogMemoryStatistics logMemoryStatistics = new LogMemoryStatistics();
                        logMemoryStatistics.memoryAppUsageInKbytes = rtcStats.memoryAppUsageInKbytes;
                        logMemoryStatistics.memoryAppUsageRatio = rtcStats.memoryAppUsageRatio;
                        logMemoryStatistics.memoryTotalUsageRatio = rtcStats.memoryTotalUsageRatio;
                        OMNIChannel.this.mLogReport.LogStatisticsMemoryStats(logMemoryStatistics);
                    }
                    if (OMNIChannel.this.mListener != null) {
                        Handler access$500 = OMNIChannel.this.mHandler;
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
                                reportRtcStats.lastmileDelay = rtcStats.lastmileDelay;
                                reportRtcStats.gateWayRtt = rtcStats.gatewayRtt;
                                if (OMNIChannel.this.mListener != null) {
                                    OMNIChannel.this.mListener.reportRtcStats(OMNIChannel.this.mChannelId, reportRtcStats);
                                }
                            }
                        };
                        if (!(access$500 instanceof Handler)) {
                            access$500.post(r0);
                        } else {
                            AsynchronousInstrumentation.handlerPost(access$500, r0);
                        }
                    }
                }

                public void onNetworkQuality(OmniRtcChannel omniRtcChannel, long j, int i, int i2) {
                    OMNIChannel.super.onNetworkQuality(omniRtcChannel, j, i, i2);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onNetworkQuality(omniRtcChannel.channelId(), j, i, i2);
                    }
                }

                public void onRemoteVideoStats(OmniRtcChannel omniRtcChannel, RemoteVideoStats remoteVideoStats) {
                    OMNIChannel.super.onRemoteVideoStats(omniRtcChannel, remoteVideoStats);
                    if (OMNIChannel.this.mListener != null) {
                        RTCEngine.RemoteVideoStats remoteVideoStats2 = new RTCEngine.RemoteVideoStats();
                        remoteVideoStats2.uid = remoteVideoStats.uid;
                        remoteVideoStats2.decoderOutputFrameRate = remoteVideoStats.decoderOutputFrameRate;
                        remoteVideoStats2.height = remoteVideoStats.height;
                        remoteVideoStats2.width = remoteVideoStats.width;
                        remoteVideoStats2.rendererOutputFrameRate = remoteVideoStats.rendererOutputFrameRate;
                        remoteVideoStats2.packetLossRate = remoteVideoStats.packetLossRate;
                        remoteVideoStats2.receivedBitrate = remoteVideoStats.receivedBitrate;
                        OMNIChannel.this.mListener.onRemoteVideoStats(omniRtcChannel.channelId(), remoteVideoStats2);
                    }
                    if (OMNIChannel.this.mLogReport != null) {
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
                        OMNIChannel.this.mLogReport.LogStaticRemoteVideoStats(logVideoRemoteStatistics);
                        OMNIChannel.this.mLogReport.LogStaticRemoteVideoTransportStats(logVideoRemoteStatistics);
                    }
                }

                public void onRemoteAudioStats(OmniRtcChannel omniRtcChannel, RemoteAudioStats remoteAudioStats) {
                    OMNIChannel.super.onRemoteAudioStats(omniRtcChannel, remoteAudioStats);
                    if (OMNIChannel.this.mListener != null) {
                        RTCEngine.RemoteAudioStats remoteAudioStats2 = new RTCEngine.RemoteAudioStats();
                        remoteAudioStats2.uid = remoteAudioStats.uid;
                        remoteAudioStats2.audioLossRate = remoteAudioStats.audioLossRate;
                        remoteAudioStats2.numChannels = remoteAudioStats.numChannels;
                        remoteAudioStats2.receivedSampleRate = remoteAudioStats.sampleRate;
                        remoteAudioStats2.receivedBitrate = remoteAudioStats.receivedBitrate;
                        OMNIChannel.this.mListener.onRemoteAudioStats(omniRtcChannel.channelId(), remoteAudioStats2);
                    }
                    if (OMNIChannel.this.mLogReport != null) {
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
                        OMNIChannel.this.mLogReport.LogStaticRemoteAudioStats(logAudioRemoteStatistics);
                    }
                }

                public void onRemoteAudioStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
                    OMNIChannel.super.onRemoteAudioStateChanged(omniRtcChannel, j, i, i2, i3);
                    Logger.i("OMNIChannel onRemoteAudioStateChanged mChannelId = " + OMNIChannel.this.mChannelId + " uid = " + j + " state = " + i + ", reason = " + i2, new Object[0]);
                    if (OMNIChannel.this.mListener == null) {
                        return;
                    }
                    if (i2 == 5) {
                        OMNIChannel.this.mListener.didAudioMuted(omniRtcChannel.channelId(), j, true);
                    } else if (i2 == 6) {
                        OMNIChannel.this.mListener.didAudioMuted(omniRtcChannel.channelId(), j, false);
                    }
                }

                public void onActiveSpeaker(OmniRtcChannel omniRtcChannel, long j) {
                    OMNIChannel.super.onActiveSpeaker(omniRtcChannel, j);
                }

                public void onFirstRemoteVideoFrame(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
                    OMNIChannel.super.onFirstRemoteVideoFrame(omniRtcChannel, j, i, i2, i3);
                    Logger.i("OMNIChannel onFirstRemoteVideoFrame mChannelId = " + OMNIChannel.this.mChannelId + " uid = " + j, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.remotefirstVideoRecvWithUid(OMNIChannel.this.mChannelId, j);
                    }
                    if (OMNIChannel.this.mLogReport != null) {
                        OMNIChannel.this.mLogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, "1", (String) null, j);
                        OMNIChannel.this.mLogReport.LogStaticRemoteVideoIn(j, i3);
                    }
                }

                public void onFirstRemoteAudioDecoded(OmniRtcChannel omniRtcChannel, long j, int i) {
                    OMNIChannel.super.onFirstRemoteAudioDecoded(omniRtcChannel, j, i);
                    Logger.i("OMNIChannel onFirstRemoteAudioDecoded mChannelId = " + OMNIChannel.this.mChannelId + " uid = " + j, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.remotefirstAudioRecvWithUid(OMNIChannel.this.mChannelId, j);
                    }
                    if (OMNIChannel.this.mLogReport != null) {
                        OMNIChannel.this.mLogReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_HW, (String) null, j);
                        OMNIChannel.this.mLogReport.LogStaticRemoteAudioIn(j, i);
                    }
                }

                public void onVideoSizeChanged(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
                    OMNIChannel.super.onVideoSizeChanged(omniRtcChannel, j, i, i2, i3);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onVideoSizeChanged(omniRtcChannel.channelId(), j, i, i2, i3);
                    }
                }

                public void onRemoteVideoStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
                    OMNIChannel.super.onRemoteVideoStateChanged(omniRtcChannel, j, i, i2, i3);
                    Logger.i("OMNIChannel onRemoteVideoStateChanged mChannelId = " + OMNIChannel.this.mChannelId + " uid = " + j + " state = " + i + ", reason = " + i2, new Object[0]);
                    if (i != 3) {
                        if (OMNIChannel.this.mListener != null) {
                            if (i2 == 5) {
                                OMNIChannel.this.mListener.didVideoMuted(omniRtcChannel.channelId(), j, true);
                            } else if (i2 == 6) {
                                OMNIChannel.this.mListener.didVideoMuted(omniRtcChannel.channelId(), j, false);
                            }
                        }
                        if (OMNIChannel.this.mListener != null) {
                            OMNIChannel.this.mListener.onRemoteVideoStateChanged(OMNIChannel.this.mChannelId, j, i);
                        }
                    }
                }

                public void onStreamMessage(OmniRtcChannel omniRtcChannel, long j, int i, byte[] bArr) {
                    OMNIChannel.super.onStreamMessage(omniRtcChannel, j, i, bArr);
                    if (bArr != null) {
                        if (bArr.length == 24 && CommonUtils.isTSMsg(bArr)) {
                            synchronized (OMNIChannel.this.mTimestampRecLock) {
                                int i2 = (int) j;
                                OMNIChannel.this.mMetadataRecTimestampMap.put(Integer.valueOf(i2), Long.valueOf(DataUtils.longFrom8Bytes(bArr, 16, false)));
                                OMNIChannel.this.mRecTimestampMap.put(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
                            }
                        } else if (bArr.length > 24 && CommonUtils.isIRCMsg(bArr)) {
                            int length = bArr.length - 24;
                            byte[] bArr2 = new byte[length];
                            System.arraycopy(bArr, 24, bArr2, 0, length);
                            if (OMNIChannel.this.mListener != null) {
                                OMNIChannel.this.mListener.onStreamMessage(j, bArr2);
                                OMNIChannel.this.mListener.onStreamMessage(omniRtcChannel.channelId(), j, bArr2);
                            }
                        }
                    }
                }

                public void onVideoBufferingStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, long j2) {
                    Logger.i("OMNIChannel onVideoBufferingStateChanged mChannelId: " + omniRtcChannel.channelId() + ", SESSION_ID: " + omniRtcChannel.getChannelSessionId() + ", CONN_STATE " + omniRtcChannel.getConnectionState() + ", uid: " + j + ", state: " + i + " " + j2 + " " + System.currentTimeMillis(), new Object[0]);
                    if (i == 0) {
                        OMNIEngine.DelayObject delayObject = (OMNIEngine.DelayObject) OMNIChannel.this.delayMap.get(Long.valueOf(j));
                        if (delayObject == null) {
                            OMNIEngine.DelayObject delayObject2 = new OMNIEngine.DelayObject();
                            delayObject2.uid = j;
                            delayObject2.isDelay = 1;
                            delayObject2.roomId = omniRtcChannel.channelId();
                            delayObject2.startTime = j2;
                            OMNIChannel.this.delayMap.put(Long.valueOf(j), delayObject2);
                        } else {
                            delayObject.startTime = j2;
                        }
                        if (OMNIChannel.this.mLogReport != null) {
                            OMNIChannel.this.mLogReport.jitterRenderDelayStart(((OMNIEngine.DelayObject) OMNIChannel.this.delayMap.get(Long.valueOf(j))).startTime, j, omniRtcChannel.channelId());
                        }
                    } else if (i == 1) {
                        OMNIChannel.this.doRenderEnd(j, j2);
                    }
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onVideoBufferingStateChanged(j, i, j2);
                        OMNIChannel.this.mListener.onVideoBufferingStateChanged(omniRtcChannel.channelId(), j, i, j2);
                    }
                }

                public void onAudioBufferingStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, long j2) {
                    Logger.i("OMNIChannel onAudioBufferingStateChanged mChannelId: " + omniRtcChannel.channelId() + ", SESSION_ID: " + omniRtcChannel.getChannelSessionId() + ", CONN_STATE " + omniRtcChannel.getConnectionState() + ", uid: " + j + ", state: " + i + " " + j2 + " " + System.currentTimeMillis(), new Object[0]);
                    if (i == 0) {
                        OMNIEngine.DelayObject delayObject = (OMNIEngine.DelayObject) OMNIChannel.this.audioDelayMap.get(Long.valueOf(j));
                        if (delayObject == null) {
                            OMNIEngine.DelayObject delayObject2 = new OMNIEngine.DelayObject();
                            delayObject2.uid = j;
                            delayObject2.isDelay = 1;
                            delayObject2.roomId = omniRtcChannel.channelId();
                            delayObject2.startTime = j2;
                            OMNIChannel.this.audioDelayMap.put(Long.valueOf(j), delayObject2);
                        } else {
                            delayObject.startTime = j2;
                        }
                        if (OMNIChannel.this.mLogReport != null) {
                            OMNIChannel.this.mLogReport.audioJitterRenderDelayStart(((OMNIEngine.DelayObject) OMNIChannel.this.audioDelayMap.get(Long.valueOf(j))).startTime, j, omniRtcChannel.channelId());
                        }
                    } else if (i == 1) {
                        OMNIChannel.this.doAudioRenderEnd(j, j2);
                    }
                }

                public void onStreamMessageError(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3, int i4) {
                    OMNIChannel.super.onStreamMessageError(omniRtcChannel, j, i, i2, i3, i4);
                }

                public void onChannelMediaRelayStateChanged(OmniRtcChannel omniRtcChannel, int i, int i2) {
                    OMNIChannel.super.onChannelMediaRelayStateChanged(omniRtcChannel, i, i2);
                    Logger.i("OMNIChannel onChannelMediaRelayStateChanged mChannelId = " + OMNIChannel.this.mChannelId + ", state: " + i + ", code: " + i2, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onChannelMediaRelayStateChanged(omniRtcChannel.channelId(), i, i2);
                    }
                }

                public void onChannelMediaRelayEvent(OmniRtcChannel omniRtcChannel, int i) {
                    OMNIChannel.super.onChannelMediaRelayEvent(omniRtcChannel, i);
                    Logger.i("OMNIChannel onChannelMediaRelayEvent mChannelId = " + OMNIChannel.this.mChannelId + ", code: " + i, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onChannelMediaRelayEvent(omniRtcChannel.channelId(), i);
                    }
                }

                public void onRtmpStreamingStateChanged(OmniRtcChannel omniRtcChannel, String str, int i, int i2) {
                    OMNIChannel.super.onRtmpStreamingStateChanged(omniRtcChannel, str, i, i2);
                }

                public void onTranscodingUpdated(OmniRtcChannel omniRtcChannel) {
                    OMNIChannel.super.onTranscodingUpdated(omniRtcChannel);
                }

                public void onStreamInjectedStatus(OmniRtcChannel omniRtcChannel, String str, long j, int i) {
                    OMNIChannel.super.onStreamInjectedStatus(omniRtcChannel, str, j, i);
                }

                public void onRemoteSubscribeFallbackToAudioOnly(OmniRtcChannel omniRtcChannel, long j, boolean z) {
                    OMNIChannel.super.onRemoteSubscribeFallbackToAudioOnly(omniRtcChannel, j, z);
                }

                public void onRemoteStreamSubscribeAdvice(OmniRtcChannel omniRtcChannel, long j, int i, int i2) {
                    Logger.i("OMNIChannel onRemoteStreamSubscribeAdvice mChannelId = " + OMNIChannel.this.mChannelId + " uid = " + j + " currentStreamType = " + i + ", suitableStreamType = " + i2 + ", mListener = " + OMNIChannel.this.mListener, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onRemoteStreamSubscribeAdvice(omniRtcChannel.channelId(), j, i, i2);
                    }
                }

                public void onAudioSubscribeStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
                    long j2 = 4294967295L & j;
                    Logger.i("OMNIChannel onSubscribeAudioStateChanged mChannelId: " + OMNIChannel.this.mChannelId + ", uid: " + j2 + ", oldState: " + i + ", newState: " + i2 + ", elapsed: " + i3, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onSubscribeAudioStateChanged(omniRtcChannel.channelId(), (int) j, i, i2);
                    }
                    if (i == 2 && i2 == 3 && OMNIChannel.this.mLogReport != null) {
                        OMNIChannel.this.mLogReport.LogStaticRemoteAudioIn(j2, i3);
                    }
                }

                public void onVideoSubscribeStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
                    long j2 = 4294967295L & j;
                    Logger.i("OMNIChannel onSubscribeVideoStateChanged mChannelId: " + OMNIChannel.this.mChannelId + ", uid: " + j2 + ", oldState: " + i + ", newState: " + i2 + ", elapsed: " + i3, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onSubscribeVideoStateChanged(omniRtcChannel.channelId(), (int) j, i, i2);
                    }
                    if (i == 2 && i2 == 3) {
                        OMNIChannel.this.mLogReport.LogStaticRemoteVideoIn(j2, i3);
                    }
                }

                public void onAudioPublishStateChanged(OmniRtcChannel omniRtcChannel, int i, int i2, int i3) {
                    Logger.i("OMNIChannel onPublishAudioStateChanged mChannelId: " + OMNIChannel.this.mChannelId + ", oldState: " + i + ", newState: " + i2 + ", elapsed: " + i3 + ", " + omniRtcChannel, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onPublishAudioStateChanged(omniRtcChannel.channelId(), i, i2);
                    }
                    if (i == 2 && i2 == 3) {
                        OMNIChannel.this.mLogReport.LogStaticLocalAudioIn(i3);
                        OMNIChannel.this.mLogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_AUDIO.value);
                        OMNIChannel.this.mLogReport.setAudioPublished(true);
                        return;
                    }
                    OMNIChannel.this.mLogReport.setAudioPublished(false);
                }

                public void onVideoPublishStateChanged(OmniRtcChannel omniRtcChannel, int i, int i2, int i3) {
                    Logger.i("OMNIChannel onPublishVideoStateChanged mChannelId: " + OMNIChannel.this.mChannelId + ", width: " + 0 + ", height: " + 0 + ", elapsed: " + i3 + ", " + omniRtcChannel, new Object[0]);
                    if (OMNIChannel.this.mListener != null) {
                        OMNIChannel.this.mListener.onPublishVideoStateChanged(omniRtcChannel.channelId(), i, i2);
                    }
                    if (i != 2 || i2 != 3) {
                        OMNIChannel.this.mLogReport.setVideoPublished(false);
                    } else if (OMNIChannel.this.mLogReport != null) {
                        OMNIChannel.this.mLogReport.LogStaticLocalVideoIn(i3, 0, 0);
                        OMNIChannel.this.mLogReport.LogStartPublish(LOGMediaType.LOG_MEDIA_VIDEO.value);
                        OMNIChannel.this.mLogReport.setVideoPublished(true);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void setRemoteRenderMode(long j, RTCEngine.RTCVideoRenderMode rTCVideoRenderMode) {
        Logger.i("OMNIChannel setRemoteRenderMode mChannelId = " + this.mChannelId + " uid = " + j + " mode = " + rTCVideoRenderMode, new Object[0]);
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel != null) {
            omniRtcChannel.setRemoteRenderMode(j, rTCVideoRenderMode.getValue(), 160202);
        }
    }

    public int setRemoteVideoStreamType(long j, int i) {
        try {
            OmniRtcChannel omniRtcChannel = this.rtcChannel;
            if (omniRtcChannel == null) {
                return ERROR_CHANNEL_EMPTY;
            }
            int remoteVideoStreamType = omniRtcChannel.setRemoteVideoStreamType(j, i);
            Logger.i("OMNIChannel setRemoteVideoStreamType uid=" + j + " streamType=" + i + " result=" + remoteVideoStreamType, new Object[0]);
            return remoteVideoStreamType;
        } finally {
            Logger.i("OMNIChannel setRemoteVideoStreamType uid=" + j + " streamType=" + i + " result=" + ERROR_CHANNEL_EMPTY, new Object[0]);
        }
    }

    public int applyRemoteStreamSubscribeAdvice(long j, int i) {
        try {
            OmniRtcChannel omniRtcChannel = this.rtcChannel;
            if (omniRtcChannel == null) {
                return ERROR_CHANNEL_EMPTY;
            }
            int remoteVideoStreamType = omniRtcChannel.setRemoteVideoStreamType(j, i);
            Logger.i("OMNIChannel applyRemoteStreamSubscribeAdvice uid=" + j + " streamType=" + i + " result=" + remoteVideoStreamType, new Object[0]);
            return remoteVideoStreamType;
        } finally {
            Logger.i("OMNIChannel applyRemoteStreamSubscribeAdvice uid=" + j + " streamType=" + i + " result=" + ERROR_CHANNEL_EMPTY, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public String getChannelId() {
        return this.mChannelId;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getTimestamp(int r7) {
        /*
            r6 = this;
            com.wushuangtech.wstechapi.OmniRtcChannel r0 = r6.rtcChannel
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
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.OMNIChannel.getTimestamp(int):long");
    }

    public int setRole(RTCEngine.RTCRole rTCRole) {
        int i;
        LogReport logReport;
        LogReport logReport2;
        if (rTCRole == RTCEngine.RTCRole.RTCRoleBroadcaster) {
            i = this.rtcChannel.setClientRole(1);
            if (i == 0 && (logReport2 = this.mLogReport) != null) {
                logReport2.setVideoPublished(true);
                this.mLogReport.setAudioPublished(true);
            }
        } else if (rTCRole == RTCEngine.RTCRole.RTCRoleAudience) {
            i = this.rtcChannel.setClientRole(2);
            if (i == 0 && (logReport = this.mLogReport) != null) {
                logReport.setVideoPublished(false);
                this.mLogReport.setAudioPublished(false);
            }
        } else {
            i = ERROR_CHANNEL_EMPTY;
        }
        Logger.i("OMNIChannel setRole role = " + rTCRole + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        return i;
    }

    public int muteLocalAudio(boolean z) {
        int i;
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel != null) {
            i = omniRtcChannel.muteLocalAudioStream(z);
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
                Logger.i("OMNIChannel muteLocalAudio failed code = " + i, new Object[0]);
            }
        } else {
            i = ERROR_CHANNEL_EMPTY;
        }
        Logger.i("OMNIChannel muteLocalAudio mute = " + z + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        LogReport logReport2 = this.mLogReport;
        if (logReport2 != null) {
            if (z) {
                logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_VIVO, (String) null, -1);
            } else {
                logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "8", (String) null, -1);
            }
        }
        return i;
    }

    public int muteLocalVideo(boolean z) {
        int i;
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel != null) {
            i = omniRtcChannel.muteLocalVideoStream(z);
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
                Logger.i("OMNIChannel muteLocalVideo failed code = " + i, new Object[0]);
            }
        } else {
            i = ERROR_CHANNEL_EMPTY;
        }
        Logger.i("OMNIChannel muteLocalVideo mute = " + z + " ret = " + i + " thread id = " + Thread.currentThread().getId(), new Object[0]);
        LogReport logReport2 = this.mLogReport;
        if (logReport2 != null) {
            if (z) {
                logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_OPPO, (String) null, -1);
            } else {
                logReport2.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_ST, (String) null, -1);
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public void muteRemoteVideo(long j, boolean z) {
        Logger.i("OMNIChannel muteRemoteVideo mChannelId: " + this.mChannelId + ", uid: " + j + ", mute: " + z, new Object[0]);
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel != null) {
            omniRtcChannel.muteRemoteVideoStream(j, z);
        }
        LogReport logReport = this.mLogReport;
        if (logReport == null) {
            return;
        }
        if (z) {
            logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "9", (String) null, j);
        } else {
            logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "11", (String) null, j);
        }
    }

    /* access modifiers changed from: protected */
    public void muteRemoteAudio(long j, boolean z) {
        Logger.i("OMNIChannel muteRemoteAudio mChannelId: " + this.mChannelId + ", uid: " + j + ", mute: " + z, new Object[0]);
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel != null) {
            omniRtcChannel.muteRemoteAudioStream(j, z);
        }
        LogReport logReport = this.mLogReport;
        if (logReport == null) {
            return;
        }
        if (z) {
            logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "10", (String) null, j);
        } else {
            logReport.addImportantEvents(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_XM, "12", (String) null, j);
        }
    }

    public void muteAllRemoteVideo(boolean z) {
        Logger.i("OMNIChannel muteAllRemoteVideo mChannelId: " + this.mChannelId + ", mute: " + z, new Object[0]);
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel != null) {
            omniRtcChannel.muteAllRemoteVideoStreams(z);
        }
    }

    public void muteAllRemoteAudio(boolean z) {
        Logger.i("OMNIChannel muteAllRemoteAudio mChannelId: " + this.mChannelId + ", mute: " + z, new Object[0]);
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel != null) {
            omniRtcChannel.muteAllRemoteAudioStreams(z);
        }
    }

    /* JADX INFO: finally extract failed */
    public int startChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        String str = "null";
        ChannelMediaRelayConfiguration channelMediaRelayConfiguration = null;
        try {
            if (this.rtcChannel == null) {
                Logger.i("OMNIChannel startChannelMediaRelay config=" + str + " result=" + ERROR_CHANNEL_EMPTY, new Object[0]);
                return ERROR_CHANNEL_EMPTY;
            }
            channelMediaRelayConfiguration = OMNIEngine.ClassConverter.getCoreChannelMediaRelayConfigurationFromRTC(rTCChannelMediaRelayConfiguration);
            if (channelMediaRelayConfiguration == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("OMNIChannel startChannelMediaRelay config=");
                if (channelMediaRelayConfiguration != null) {
                    str = channelMediaRelayConfiguration.toString();
                }
                sb.append(str);
                sb.append(" result=");
                sb.append(ERROR_CHANNEL_EMPTY);
                Logger.i(sb.toString(), new Object[0]);
                return -3;
            }
            int startChannelMediaRelay = this.rtcChannel.startChannelMediaRelay(channelMediaRelayConfiguration);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("OMNIChannel startChannelMediaRelay config=");
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
            sb3.append("OMNIChannel startChannelMediaRelay config=");
            if (channelMediaRelayConfiguration != null) {
                str = channelMediaRelayConfiguration.toString();
            }
            sb3.append(str);
            sb3.append(" result=");
            sb3.append(ERROR_CHANNEL_EMPTY);
            Logger.i(sb3.toString(), new Object[0]);
            throw th;
        }
    }

    public int stopChannelMediaRelay() {
        Logger.i("OMNIChannel stopChannelMediaRelay", new Object[0]);
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel == null) {
            return ERROR_CHANNEL_EMPTY;
        }
        return omniRtcChannel.stopChannelMediaRelay();
    }

    /* JADX INFO: finally extract failed */
    public int updateChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        String str = "null";
        ChannelMediaRelayConfiguration channelMediaRelayConfiguration = null;
        try {
            if (this.rtcChannel == null) {
                Logger.i("OMNIChannel updateChannelMediaRelay config=" + str + " result=" + ERROR_CHANNEL_EMPTY, new Object[0]);
                return ERROR_CHANNEL_EMPTY;
            }
            channelMediaRelayConfiguration = OMNIEngine.ClassConverter.getCoreChannelMediaRelayConfigurationFromRTC(rTCChannelMediaRelayConfiguration);
            if (channelMediaRelayConfiguration == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("OMNIChannel updateChannelMediaRelay config=");
                if (channelMediaRelayConfiguration != null) {
                    str = channelMediaRelayConfiguration.toString();
                }
                sb.append(str);
                sb.append(" result=");
                sb.append(-3);
                Logger.i(sb.toString(), new Object[0]);
                return -3;
            }
            int updateChannelMediaRelay = this.rtcChannel.updateChannelMediaRelay(channelMediaRelayConfiguration);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("OMNIChannel updateChannelMediaRelay config=");
            if (channelMediaRelayConfiguration != null) {
                str = channelMediaRelayConfiguration.toString();
            }
            sb2.append(str);
            sb2.append(" result=");
            sb2.append(updateChannelMediaRelay);
            Logger.i(sb2.toString(), new Object[0]);
            return updateChannelMediaRelay;
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("OMNIChannel updateChannelMediaRelay config=");
            if (channelMediaRelayConfiguration != null) {
                str = channelMediaRelayConfiguration.toString();
            }
            sb3.append(str);
            sb3.append(" result=");
            sb3.append(ERROR_CHANNEL_EMPTY);
            Logger.i(sb3.toString(), new Object[0]);
            throw th;
        }
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

    public int setRemoteVolumeAll(int i) {
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        int remoteVolumeAll = omniRtcChannel != null ? omniRtcChannel.setRemoteVolumeAll(i) : ERROR_CHANNEL_EMPTY;
        Logger.i("OMNIChannel setRemoteVolumeAll volume = " + i + ", ret = " + remoteVolumeAll, new Object[0]);
        return remoteVolumeAll;
    }

    public int takeRemoteViewSnapshot(long j) {
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        int takeRemoteViewSnapshot = omniRtcChannel != null ? omniRtcChannel.takeRemoteViewSnapshot(j) : ERROR_CHANNEL_EMPTY;
        Logger.i("OMNIChannel takeRemoteViewSnapshot uid = " + j + ", ret = " + takeRemoteViewSnapshot, new Object[0]);
        return takeRemoteViewSnapshot;
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        int defaultMuteAllRemoteAudioStreams = omniRtcChannel != null ? omniRtcChannel.setDefaultMuteAllRemoteAudioStreams(z) : ERROR_CHANNEL_EMPTY;
        Logger.i("OMNIChannel setDefaultMuteAllRemoteAudioStreams muted = " + z + ", ret =" + defaultMuteAllRemoteAudioStreams, new Object[0]);
        return defaultMuteAllRemoteAudioStreams;
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel != null) {
            return omniRtcChannel.setDefaultMuteAllRemoteVideoStreams(z);
        }
        Logger.i("OMNIChannel setDefaultMuteAllRemoteVideoStreams muted = " + z + ", ret = " + ERROR_CHANNEL_EMPTY, new Object[0]);
        return ERROR_CHANNEL_EMPTY;
    }

    public int setupRemoteVideo(long j, TextureView textureView) {
        OMNIEngine oMNIEngine;
        if (this.rtcChannel == null || (oMNIEngine = this.mEngine) == null) {
            return ERROR_CHANNEL_EMPTY;
        }
        oMNIEngine.setupRemoteVideo(textureView, j, this.mChannelId);
        return 0;
    }

    public String getChannelCallId() {
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        return omniRtcChannel != null ? omniRtcChannel.getChannelSessionId() : "";
    }

    public int addPublishStreamUrl(String str, boolean z) {
        int i;
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel == null) {
            i = -1;
        } else {
            i = omniRtcChannel.addPublishStreamUrl(str, z);
        }
        LogReport logReport = this.mLogReport;
        if (logReport != null) {
            logReport.pushRtmpState(str, "1000", i + "");
        }
        Logger.i("OMNIChannel addPublishStreamUrl url = " + str + "needTranscode" + z + "errCode = " + i, new Object[0]);
        return i;
    }

    public int removePublishStreamUrl(String str) {
        int i;
        OmniRtcChannel omniRtcChannel = this.rtcChannel;
        if (omniRtcChannel == null) {
            i = -1;
        } else {
            i = omniRtcChannel.removePublishStreamUrl(str);
        }
        LogReport logReport = this.mLogReport;
        if (logReport != null) {
            logReport.pushRtmpState(str, "1001", i + "");
        }
        Logger.i("OMNIChannel removePublishStreamUrl url = " + str + "errCode = " + i, new Object[0]);
        return i;
    }

    public int setRtmpConfig(RTCEngine.RTCRtmpConfig rTCRtmpConfig) {
        Logger.i("OMNIChannel setRtmpConfig " + rTCRtmpConfig.toString(), new Object[0]);
        if (this.rtcChannel == null || rTCRtmpConfig == null) {
            return -1;
        }
        return 0;
    }

    private void doRenderEnd() {
        try {
            Iterator<Map.Entry<Long, OMNIEngine.DelayObject>> it = this.delayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                OMNIEngine.DelayObject delayObject = (OMNIEngine.DelayObject) next.getValue();
                if (delayObject.isDelay == 1 && TextUtils.equals(delayObject.roomId, this.rtcChannel.channelId())) {
                    long currentTimeMillis = System.currentTimeMillis();
                    LogReport logReport = this.mLogReport;
                    if (logReport != null) {
                        logReport.jitterRenderDelayEnd(currentTimeMillis, ((OMNIEngine.DelayObject) next.getValue()).uid, delayObject.roomId, currentTimeMillis - delayObject.startTime);
                    }
                }
                if (TextUtils.equals(delayObject.roomId, this.rtcChannel.channelId())) {
                    it.remove();
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void doRenderEnd(long j, long j2) {
        try {
            Iterator<Map.Entry<Long, OMNIEngine.DelayObject>> it = this.delayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                OMNIEngine.DelayObject delayObject = (OMNIEngine.DelayObject) next.getValue();
                if (delayObject.isDelay == 1 && TextUtils.equals(delayObject.roomId, this.rtcChannel.channelId()) && delayObject.uid == j) {
                    LogReport logReport = this.mLogReport;
                    if (logReport != null) {
                        logReport.jitterRenderDelayEnd(j2, ((OMNIEngine.DelayObject) next.getValue()).uid, delayObject.roomId, j2 - delayObject.startTime);
                    }
                    if (TextUtils.equals(delayObject.roomId, this.rtcChannel.channelId())) {
                        it.remove();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void doAudioRenderEnd() {
        try {
            Iterator<Map.Entry<Long, OMNIEngine.DelayObject>> it = this.audioDelayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                OMNIEngine.DelayObject delayObject = (OMNIEngine.DelayObject) next.getValue();
                if (delayObject.isDelay == 1 && TextUtils.equals(delayObject.roomId, this.rtcChannel.channelId())) {
                    long currentTimeMillis = System.currentTimeMillis();
                    LogReport logReport = this.mLogReport;
                    if (logReport != null) {
                        logReport.audioJitterRenderDelayEnd(currentTimeMillis, ((OMNIEngine.DelayObject) next.getValue()).uid, delayObject.roomId, currentTimeMillis - delayObject.startTime);
                    }
                }
                if (TextUtils.equals(delayObject.roomId, this.rtcChannel.channelId())) {
                    it.remove();
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void doAudioRenderEnd(long j, long j2) {
        try {
            Iterator<Map.Entry<Long, OMNIEngine.DelayObject>> it = this.audioDelayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                OMNIEngine.DelayObject delayObject = (OMNIEngine.DelayObject) next.getValue();
                if (delayObject.isDelay == 1 && TextUtils.equals(delayObject.roomId, this.rtcChannel.channelId()) && delayObject.uid == j) {
                    LogReport logReport = this.mLogReport;
                    if (logReport != null) {
                        logReport.audioJitterRenderDelayEnd(j2, ((OMNIEngine.DelayObject) next.getValue()).uid, delayObject.roomId, j2 - delayObject.startTime);
                    }
                    if (TextUtils.equals(delayObject.roomId, this.rtcChannel.channelId())) {
                        it.remove();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
