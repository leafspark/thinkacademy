package com.wushuangtech.api;

import android.graphics.Bitmap;
import com.wushuangtech.bean.RtcChannelMediaOptions;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.handler.AVStreamPublishHandler;
import com.wushuangtech.inter.OnRtcChannelHandlerEventCallBack;
import com.wushuangtech.inter.OnRtcGlobalServerMessageCallBack;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.log.ReportLoggerImpl;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

public class RtcRelayRtcChannel {
    private final String TAG;
    private boolean mDestroy;
    private LocalRtcChannelCbImpl mLocalRtcChannelCbImpl;
    private RtcChannelHandler mRtcChannelHandler;
    private final String mSrcChannelName;

    public RtcRelayRtcChannel(String str, String str2) {
        String str3 = "TALRelayRtcChannel-" + str2 + "-" + str;
        this.TAG = str3;
        this.mSrcChannelName = str;
        LocalRtcChannelCbImpl localRtcChannelCbImpl = new LocalRtcChannelCbImpl(this);
        this.mLocalRtcChannelCbImpl = localRtcChannelCbImpl;
        RtcChannelHandlerImpl rtcChannelHandlerImpl = new RtcChannelHandlerImpl(str3, str2, localRtcChannelCbImpl);
        this.mRtcChannelHandler = rtcChannelHandlerImpl;
        rtcChannelHandlerImpl.setisMediaRelay(true);
        this.mRtcChannelHandler.setSrcChannelName(str);
        GlobalHolder.getInstance().addRtcGlobalServerMessageCallback(this.mLocalRtcChannelCbImpl);
        GlobalHolder.getInstance().initChannelInterInvokeReporter(str2);
    }

    public int joinChannel(String str, long j) {
        String invokedMethodName = getInvokedMethodName();
        int i = -6;
        try {
            RtcChannelHandler rtcChannelHandler = this.mRtcChannelHandler;
            if (rtcChannelHandler != null && (i = rtcChannelHandler.joinChannel(str, j, (RtcChannelMediaOptions) null, false)) == 0) {
                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mSrcChannelName, 2);
                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_STATE_CHANGED, this.mSrcChannelName, 1, 0);
            }
            return i;
        } finally {
            sendInvokeEventLog(invokedMethodName, str, Long.valueOf(j), Integer.valueOf(i));
        }
    }

    public int leaveChannel() {
        sendInvokeEventLog(getInvokedMethodName(), new Object[0]);
        RtcChannelHandler rtcChannelHandler = this.mRtcChannelHandler;
        if (rtcChannelHandler != null) {
            return rtcChannelHandler.leaveChannel();
        }
        return 0;
    }

    public void destroy() {
        this.mDestroy = true;
        GlobalHolder.getInstance().removeRtcGlobalServerMessageCallback(this.mLocalRtcChannelCbImpl);
        RtcChannelHandler rtcChannelHandler = this.mRtcChannelHandler;
        if (rtcChannelHandler != null) {
            rtcChannelHandler.destroy();
            this.mRtcChannelHandler = null;
        }
        this.mLocalRtcChannelCbImpl = null;
    }

    public String channelName() {
        RtcChannelHandler rtcChannelHandler = this.mRtcChannelHandler;
        if (rtcChannelHandler != null) {
            return rtcChannelHandler.channelName();
        }
        return null;
    }

    public long getUserId() {
        RtcChannelHandler rtcChannelHandler = this.mRtcChannelHandler;
        if (rtcChannelHandler != null) {
            return rtcChannelHandler.getUserId();
        }
        return 0;
    }

    public String getInvokedMethodName() {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }

    private void sendInvokeEventLog(String str, Object... objArr) {
        uploadEventLog(5, str, objArr);
    }

    private void sendCallBackEventLog(String str, Object... objArr) {
        uploadEventLog(6, str, objArr);
    }

    private void uploadEventLog(int i, String str, Object... objArr) {
        RtcChannelHandler rtcChannelHandler = this.mRtcChannelHandler;
        if (rtcChannelHandler != null) {
            String channelName = rtcChannelHandler.channelName();
            ReportLoggerImpl.EventBean eventBean = new ReportLoggerImpl.EventBean();
            eventBean.timestamp = System.currentTimeMillis();
            eventBean.funName = str;
            eventBean.objs = objArr;
            if (this.mRtcChannelHandler != null) {
                GlobalHolder.getInstance().handleUserActionReport(LocalSDKConstants.USER_ACTION_PREFIX_RELAY, channelName, i, eventBean);
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleCallBackForJoinChannelError(int i) {
        RtcChannelHandler rtcChannelHandler;
        String str = this.TAG;
        OmniLog.i(OmniLog.RELAY_WATCH, str, "onChannelError err = " + i);
        if (!this.mDestroy && (rtcChannelHandler = this.mRtcChannelHandler) != null) {
            GlobalHolder.getInstance().handleUserActionReport(LocalSDKConstants.USER_ACTION_PREFIX_RELAY, rtcChannelHandler.channelName(), 4, new Object[0]);
            sendCallBackEventLog("onChannelError", Integer.valueOf(i));
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mSrcChannelName, 0);
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_STATE_CHANGED, this.mSrcChannelName, 3, 5);
        }
    }

    /* access modifiers changed from: private */
    public void handleCallBackForJoinChannelSuccess(long j) {
        RtcChannelHandler rtcChannelHandler;
        String str = this.TAG;
        OmniLog.i(OmniLog.RELAY_WATCH, str, "onJoinChannelSuccess uid = " + j);
        if (!this.mDestroy && (rtcChannelHandler = this.mRtcChannelHandler) != null) {
            GlobalHolder.getInstance().handleUserActionReport(LocalSDKConstants.USER_ACTION_PREFIX_RELAY, rtcChannelHandler.channelName(), 4, new Object[0]);
            sendCallBackEventLog("onJoinChannelSuccess", Long.valueOf(j));
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mSrcChannelName, 3);
            AVStreamPublishHandler aVStreamPublishHandler = GlobalHolder.getInstance().getAVStreamPublishHandler();
            if (aVStreamPublishHandler.isPublishStats(this.mSrcChannelName)) {
                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mSrcChannelName, 4);
            }
            if (!aVStreamPublishHandler.isAudioMuted(this.mSrcChannelName)) {
                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mSrcChannelName, 6);
            }
            if (!aVStreamPublishHandler.isVideoMuted(this.mSrcChannelName)) {
                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mSrcChannelName, 5);
            }
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_STATE_CHANGED, this.mSrcChannelName, 2, 0);
        }
    }

    /* access modifiers changed from: private */
    public void handleCallBackForLeaveChannel() {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onLeaveChannel ");
        RtcChannelHandler rtcChannelHandler = this.mRtcChannelHandler;
        sb.append(rtcChannelHandler == null ? "null" : rtcChannelHandler.channelName());
        OmniLog.i(OmniLog.RELAY_WATCH, str, sb.toString());
        if (!this.mDestroy) {
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_STATE_CHANGED, this.mSrcChannelName, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public void handleCallBackForConnectLost() {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onConnectionLost ");
        RtcChannelHandler rtcChannelHandler = this.mRtcChannelHandler;
        sb.append(rtcChannelHandler == null ? "null" : rtcChannelHandler.channelName());
        OmniLog.i(OmniLog.RELAY_WATCH, str, sb.toString());
        if (!this.mDestroy) {
            sendCallBackEventLog("onConnectionLost", new Object[0]);
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mSrcChannelName, 0);
        }
    }

    /* access modifiers changed from: private */
    public void handleCallBackForRejoin() {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onRejoinChannelSuccess ");
        RtcChannelHandler rtcChannelHandler = this.mRtcChannelHandler;
        sb.append(rtcChannelHandler == null ? "null" : rtcChannelHandler.channelName());
        OmniLog.i(OmniLog.RELAY_WATCH, str, sb.toString());
        if (!this.mDestroy) {
            sendCallBackEventLog("onRejoinChannelSuccess", new Object[0]);
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_MEDIA_RELAY_EVENT, this.mSrcChannelName, 1);
        }
    }

    private static class LocalRtcChannelCbImpl implements OnRtcChannelHandlerEventCallBack, OnRtcGlobalServerMessageCallBack {
        private final WeakReference<RtcRelayRtcChannel> mReference;

        public void OnGlobalChannelSessionId(String str, String str2) {
        }

        public void OnGlobalConnectIdReport(String str) {
        }

        public void OnGlobalRecvAudioMsg(String str, long j, int i, byte[] bArr) {
        }

        public void OnVideoBufferingStateChanged(long j, int i, long j2) {
        }

        public void onAudioBufferingStateChanged(long j, int i, long j2) {
        }

        public void onAudioPublishStateChanged(int i, int i2, int i3) {
        }

        public void onAudioSubscribeStateChanged(long j, int i, int i2, int i3) {
        }

        public void onCaptureVideoSize(int i, int i2) {
        }

        public void onChannelMediaRelayEvent(int i) {
        }

        public void onChannelMediaRelayStateChanged(int i, int i2) {
        }

        public void onClientRoleChanged(int i, int i2) {
        }

        public void onConnectionStateChanged(int i, int i2) {
        }

        public void onFirstRemoteAudioDecoded(long j, int i) {
        }

        public void onFirstRemoteVideoFrame(long j, int i, int i2, int i3) {
        }

        public void onGlobalAudioBufferingStateChanged(String str, long j, int i, long j2) {
        }

        public void onGlobalAudioVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i) {
        }

        public void onGlobalCaptureVideoSize(int i, int i2) {
        }

        public void onGlobalChannelMediaRelayEvent(String str, int i) {
        }

        public void onGlobalChannelMediaRelayStateChanged(String str, int i, int i2) {
        }

        public void onGlobalChannelOnError(int i) {
        }

        public void onGlobalChannelRefreshToken(String str, String str2, int i, int i2, int i3) {
        }

        public void onGlobalConnectionStateChanged(String str, int i, int i2) {
        }

        public void onGlobalFirstRemoteAudioDecoded(String str, long j, int i) {
        }

        public void onGlobalFirstRemoteAudioFrame(String str, long j, int i) {
        }

        public void onGlobalFirstRemoteVideoDecoded(String str, long j, String str2, int i, int i2, int i3) {
        }

        public void onGlobalFirstRemoteVideoFrame(String str, long j, String str2, int i, int i2, int i3) {
        }

        public void onGlobalLocalAudioStats(LocalAudioStats localAudioStats) {
        }

        public void onGlobalLocalVideoStats(LocalVideoStats localVideoStats) {
        }

        public void onGlobalNetworkQualityEvent(String str, long j, int i, int i2) {
        }

        public void onGlobalRejoin(String str, int i) {
        }

        public void onGlobalRemoteAudioStateChanged(String str, long j, int i, int i2, int i3) {
        }

        public void onGlobalRemoteAudioStats(String str, long j, RemoteAudioStats remoteAudioStats) {
        }

        public void onGlobalRemoteStreamSubscribeAdvice(String str, long j, int i, int i2) {
        }

        public void onGlobalRemoteTakeSnapshot(String str, long j, Bitmap bitmap) {
        }

        public void onGlobalRemoteVideoStateChanged(String str, long j, int i, int i2, int i3) {
        }

        public void onGlobalRemoteVideoStats(String str, long j, RemoteVideoStats remoteVideoStats) {
        }

        public void onGlobalRtcStats(RtcStats rtcStats) {
        }

        public void onGlobalUserRoleChanged(String str, long j, int i) {
        }

        public void onGlobalVideoSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
        }

        public void onNetworkQuality(long j, int i, int i2) {
        }

        public void onRemoteAudioStateChanged(long j, int i, int i2, int i3) {
        }

        public void onRemoteAudioStats(RemoteAudioStats remoteAudioStats) {
        }

        public void onRemoteStreamSubscribeAdvice(long j, int i, int i2) {
        }

        public void onRemoteVideoStateChanged(long j, int i, int i2, int i3) {
        }

        public void onRemoteVideoStats(RemoteVideoStats remoteVideoStats) {
        }

        public void onRequestToken() {
        }

        public void onRtcStats(RtcStats rtcStats) {
        }

        public void onStreamMessage(long j, int i, byte[] bArr) {
        }

        public void onTakeRemoteViewSnapshot(long j, Bitmap bitmap) {
        }

        public void onTokenPrivilegeWillExpire(String str) {
        }

        public void onUserJoined(long j, int i) {
        }

        public void onUserKicked(long j, int i, int i2) {
        }

        public void onUserOffline(long j, int i) {
        }

        public void onVideoPublishStateChanged(int i, int i2, int i3) {
        }

        public void onVideoSubscribeStateChanged(long j, int i, int i2, int i3) {
        }

        public LocalRtcChannelCbImpl(RtcRelayRtcChannel rtcRelayRtcChannel) {
            this.mReference = new WeakReference<>(rtcRelayRtcChannel);
        }

        public void onChannelError(int i) {
            RtcRelayRtcChannel rtcRelayRtcChannel = (RtcRelayRtcChannel) this.mReference.get();
            if (rtcRelayRtcChannel != null) {
                rtcRelayRtcChannel.handleCallBackForJoinChannelError(i);
            }
        }

        public void onJoinChannelSuccess(long j, int i) {
            RtcRelayRtcChannel rtcRelayRtcChannel = (RtcRelayRtcChannel) this.mReference.get();
            if (rtcRelayRtcChannel != null) {
                rtcRelayRtcChannel.handleCallBackForJoinChannelSuccess(j);
            }
        }

        public void onRejoinChannelSuccess(long j, int i) {
            RtcRelayRtcChannel rtcRelayRtcChannel = (RtcRelayRtcChannel) this.mReference.get();
            if (rtcRelayRtcChannel != null) {
                rtcRelayRtcChannel.handleCallBackForRejoin();
            }
        }

        public void onLeaveChannel(RtcStats rtcStats) {
            RtcRelayRtcChannel rtcRelayRtcChannel = (RtcRelayRtcChannel) this.mReference.get();
            if (rtcRelayRtcChannel != null) {
                rtcRelayRtcChannel.handleCallBackForLeaveChannel();
            }
        }

        public void onConnectionLost() {
            RtcRelayRtcChannel rtcRelayRtcChannel = (RtcRelayRtcChannel) this.mReference.get();
            if (rtcRelayRtcChannel != null) {
                rtcRelayRtcChannel.handleCallBackForConnectLost();
            }
        }
    }
}
