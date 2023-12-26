package com.wushuangtech.wstechapi.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.wstechapi.OmniRtcChannel;
import com.wushuangtech.wstechapi.OmniRtcChannelEventHandler;
import java.lang.ref.WeakReference;

public class OmniRtcChannelEventDispatcher {
    private final String TAG;
    private final String mChannelName;
    private final WeakReference<OmniRtcChannel> mChannelReference;
    private LocalHandler mLocalHandler;
    private HandlerThread mLocalHandlerThread;
    private WeakReference<OmniRtcChannelEventHandler> mReference;

    /* access modifiers changed from: private */
    public static String getString(int i) {
        if (i == 18) {
            return "EVENT_ON_NETWORK_QUALITY";
        }
        switch (i) {
            case 1:
                return "EVENT_ON_JOIN_CHANNEL_SUCCESS";
            case 2:
                return "EVENT_ON_JOIN_CHANNEL_FAILED";
            case 3:
                return "EVENT_ON_JOIN_CHANNEL_LEAVE";
            case 4:
                return "EVENT_ON_USER_JOINED";
            case 5:
                return "EVENT_ON_USER_OFFLINE";
            case 6:
                return "EVENT_ON_ROLE_CHANGED";
            case 7:
                return "EVENT_ON_RTC_STATUS";
            case 8:
                return "EVENT_ON_CONNECT_LOST";
            case 9:
                return "EVENT_ON_CONNECT_STATE_CHANGED";
            case 10:
                return "EVENT_ON_TOKEN_WILL_EXPIRE";
            case 11:
                return "EVENT_ON_TOKEN_REQUEST_REFRESH";
            case 12:
                return "EVENT_ON_STREAM_MESSAGE_RECV";
            case 13:
                return "EVENT_ON_USER_KICKED";
            case 14:
                return "EVENT_ON_REJOIN_CHANNEL_SUCCESS";
            default:
                switch (i) {
                    case 200:
                        return "EVENT_ON_AUDIO_REMOTE_STATUS";
                    case 201:
                        return "EVENT_ON_AUDIO_REMOTE_FIRST_FRAME";
                    case 202:
                        return "EVENT_ON_AUDIO_REMOTE_STATE_CHANGED";
                    default:
                        switch (i) {
                            case 300:
                                return "EVENT_ON_VIDEO_REMOTE_STATUS";
                            case 301:
                                return "EVENT_ON_VIDEO_REMOTE_STREAM_STATUS";
                            case 302:
                                return "EVENT_ON_VIDEO_REMOTE_FIRST_FRAME";
                            case 303:
                                return "EVENT_ON_VIDEO_BUFFERING_STATE_CHANGED";
                            default:
                                return "UNKNOW";
                        }
                }
        }
    }

    public OmniRtcChannelEventDispatcher(OmniRtcChannel omniRtcChannel) {
        this.mChannelReference = new WeakReference<>(omniRtcChannel);
        String channelId = omniRtcChannel.channelId();
        this.mChannelName = channelId;
        String str = "OmniRtcChannelEventDispatcher" + "-" + channelId;
        this.TAG = str;
        OmniLog.i(str, "Create channel event dispatcher! " + this);
    }

    public void setRtcChannelEventHandler(OmniRtcChannelEventHandler omniRtcChannelEventHandler) {
        this.mReference = new WeakReference<>(omniRtcChannelEventHandler);
    }

    public void createCallBackThread() {
        HandlerThread handlerThread = new HandlerThread("CB-CHANNEL-" + this.mChannelName);
        this.mLocalHandlerThread = handlerThread;
        handlerThread.start();
        this.mLocalHandler = new LocalHandler(this.mLocalHandlerThread.getLooper(), this, this.TAG);
        String str = this.TAG;
        OmniLog.i(str, "Create call back thread! " + this.mLocalHandlerThread);
    }

    public void sendMessage(Message message) {
        LocalHandler localHandler = this.mLocalHandler;
        if (localHandler != null && !localHandler.sendMessage(message)) {
            String str = this.TAG;
            OmniLog.i(str, "Send call back message failed, try again! " + message.toString());
            LocalHandler localHandler2 = this.mLocalHandler;
            if (localHandler2 != null) {
                localHandler2.sendMessage(message);
            }
        }
    }

    public void clearResource() {
        String str = this.TAG;
        OmniLog.i(str, "Start clear resource... stop thread! " + this.mLocalHandlerThread);
        LocalHandler localHandler = this.mLocalHandler;
        if (localHandler != null) {
            localHandler.removeCallbacksAndMessages((Object) null);
            this.mLocalHandler = null;
        }
        HandlerThread handlerThread = this.mLocalHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            try {
                this.mLocalHandlerThread.join(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mLocalHandlerThread = null;
        }
    }

    public void handleMessage(Message message) {
        WeakReference<OmniRtcChannelEventHandler> weakReference = this.mReference;
        if (weakReference != null) {
            OmniRtcChannelEventHandler omniRtcChannelEventHandler = (OmniRtcChannelEventHandler) weakReference.get();
            String string = getString(message.what);
            if (omniRtcChannelEventHandler == null) {
                String str = this.TAG;
                OmniLog.w(str, "Send call message failed... OmniRtcChannelEventHandler is null! " + string);
                return;
            }
            OmniRtcChannel omniRtcChannel = (OmniRtcChannel) this.mChannelReference.get();
            if (omniRtcChannel == null) {
                String str2 = this.TAG;
                OmniLog.w(str2, "Send call message failed... OmniRtcChannel is null! " + string);
                return;
            }
            Object[] objArr = (Object[]) message.obj;
            int i = message.what;
            switch (i) {
                case 1:
                    omniRtcChannelEventHandler.onJoinChannelSuccess(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue());
                    return;
                case 2:
                    omniRtcChannelEventHandler.onChannelError(omniRtcChannel, ((Integer) objArr[0]).intValue());
                    return;
                case 3:
                    omniRtcChannelEventHandler.onLeaveChannel(omniRtcChannel, (RtcStats) objArr[0]);
                    return;
                case 4:
                    omniRtcChannelEventHandler.onUserJoined(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue());
                    return;
                case 5:
                    omniRtcChannelEventHandler.onUserOffline(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue());
                    return;
                case 6:
                    omniRtcChannelEventHandler.onClientRoleChanged(omniRtcChannel, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    return;
                case 7:
                    omniRtcChannelEventHandler.onRtcStats(omniRtcChannel, (RtcStats) objArr[0]);
                    return;
                case 8:
                    omniRtcChannelEventHandler.onConnectionLost(omniRtcChannel);
                    return;
                case 9:
                    GlobalConfig.mConnectState = ((Integer) objArr[0]).intValue();
                    omniRtcChannelEventHandler.onConnectionStateChanged(omniRtcChannel, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    return;
                case 10:
                    omniRtcChannelEventHandler.onTokenPrivilegeWillExpire(omniRtcChannel, (String) objArr[0]);
                    return;
                case 11:
                    omniRtcChannelEventHandler.onRequestToken(omniRtcChannel);
                    return;
                case 12:
                    omniRtcChannelEventHandler.onStreamMessage(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), (byte[]) objArr[2]);
                    return;
                case 13:
                    omniRtcChannelEventHandler.onUserKicked(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                    return;
                case 14:
                    omniRtcChannelEventHandler.onRejoinChannelSuccess(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue());
                    return;
                case 15:
                    omniRtcChannelEventHandler.onChannelMediaRelayStateChanged(omniRtcChannel, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    return;
                case 16:
                    omniRtcChannelEventHandler.onChannelMediaRelayEvent(omniRtcChannel, ((Integer) objArr[0]).intValue());
                    return;
                case 17:
                    omniRtcChannelEventHandler.onRemoteStreamSubscribeAdvice(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                    return;
                case 18:
                    omniRtcChannelEventHandler.onNetworkQuality(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                    return;
                default:
                    switch (i) {
                        case 200:
                            omniRtcChannelEventHandler.onRemoteAudioStats(omniRtcChannel, (RemoteAudioStats) objArr[0]);
                            return;
                        case 201:
                            omniRtcChannelEventHandler.onFirstRemoteAudioDecoded(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue());
                            return;
                        case 202:
                            omniRtcChannelEventHandler.onRemoteAudioStateChanged(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                            return;
                        case 203:
                            omniRtcChannelEventHandler.onAudioBufferingStateChanged(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue());
                            return;
                        default:
                            switch (i) {
                                case 300:
                                    omniRtcChannelEventHandler.onRemoteVideoStats(omniRtcChannel, (RemoteVideoStats) objArr[0]);
                                    return;
                                case 301:
                                    omniRtcChannelEventHandler.onRemoteVideoStateChanged(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                                    return;
                                case 302:
                                    omniRtcChannelEventHandler.onFirstRemoteVideoFrame(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                                    return;
                                case 303:
                                    omniRtcChannelEventHandler.onVideoBufferingStateChanged(omniRtcChannel, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Long) objArr[2]).longValue());
                                    return;
                                case 304:
                                    omniRtcChannelEventHandler.onCaptureVideoSize(omniRtcChannel, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                                    return;
                                case 305:
                                    omniRtcChannelEventHandler.onTakeRemoteViewSnapshot(omniRtcChannel, ((Long) objArr[0]).longValue(), (Bitmap) objArr[1]);
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
    }

    private static class LocalHandler extends Handler {
        private final WeakReference<OmniRtcChannelEventDispatcher> mOutReference;
        private final String mTAG;

        LocalHandler(Looper looper, OmniRtcChannelEventDispatcher omniRtcChannelEventDispatcher, String str) {
            super(looper);
            this.mTAG = str;
            this.mOutReference = new WeakReference<>(omniRtcChannelEventDispatcher);
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            String access$000 = OmniRtcChannelEventDispatcher.getString(message.what);
            OmniRtcChannelEventDispatcher omniRtcChannelEventDispatcher = (OmniRtcChannelEventDispatcher) this.mOutReference.get();
            if (omniRtcChannelEventDispatcher == null) {
                String str = this.mTAG;
                OmniLog.w(str, "Send call message failed... OmniRtcChannelEventDispatcher is null! " + access$000);
                AsynchronousInstrumentation.handlerMessageEnd();
                return;
            }
            omniRtcChannelEventDispatcher.handleMessage(message);
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }
}
