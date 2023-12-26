package com.wushuangtech.api;

import com.wushuangtech.bean.AVStreamPublishBean;
import com.wushuangtech.bean.RtcChannelConfigBean;
import com.wushuangtech.bean.RtcChannelMediaOptions;
import com.wushuangtech.bean.RtcGlobalConfigBean;
import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;
import com.wushuangtech.handler.AVStreamPublishHandler;
import com.wushuangtech.handler.ChannelMediaRelayHandler;
import com.wushuangtech.inter.OnRtcChannelHandlerEventCallBack;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;

public class RtcChannelHandlerImpl implements RtcChannelHandler, RtcChannelExtendHandler {
    private final String TAG;
    private ChannelMediaRelayHandler mChannelMediaRelayHandler;
    private final String mChannelName;
    private RtcChannelAVManager mRtcChannelAVManager;
    private RtcChannelEventManager mRtcChannelEventManager;
    private RtcChannelManager mRtcChannelManager;

    public RtcChannelHandlerImpl(String str, String str2, OnRtcChannelHandlerEventCallBack onRtcChannelHandlerEventCallBack) {
        this(str, str2, (RtcChannelAVManager) null, onRtcChannelHandlerEventCallBack);
    }

    public RtcChannelHandlerImpl(String str, String str2, RtcChannelAVManager rtcChannelAVManager, OnRtcChannelHandlerEventCallBack onRtcChannelHandlerEventCallBack) {
        String str3 = str + " - RtcChannelHandler";
        this.TAG = str3;
        this.mChannelName = str2;
        this.mRtcChannelManager = new RtcChannelManager(str2);
        if (rtcChannelAVManager == null) {
            this.mRtcChannelAVManager = new RtcChannelAVManager(str2);
        } else {
            this.mRtcChannelAVManager = rtcChannelAVManager;
        }
        RtcChannelEventManager rtcChannelEventManager = new RtcChannelEventManager(str3, str2, this.mRtcChannelManager, this.mRtcChannelAVManager);
        this.mRtcChannelEventManager = rtcChannelEventManager;
        rtcChannelEventManager.setCallBack(onRtcChannelHandlerEventCallBack);
        this.mRtcChannelManager.setRtcChannelEventManager(this.mRtcChannelEventManager);
        this.mRtcChannelManager.setRtcChannelAVManager(this.mRtcChannelAVManager);
        this.mRtcChannelAVManager.setRtcChannelManager(this.mRtcChannelManager);
        RoomJni.getInstance().addCallback(this.mRtcChannelEventManager.getLocalRtcChannelNativeCallBack());
        GlobalHolder.getInstance().addRtcGlobalServerMessageCallback(this.mRtcChannelEventManager);
        GlobalHolder.getInstance().getAVStreamPublishHandler().addAVStreamPublishBean(new AVStreamPublishBean(str2));
        OmniLog.i(str3, "RtcChannelHandlerImpl created " + str2 + " | " + this.mRtcChannelEventManager.getLocalRtcChannelNativeCallBack());
    }

    public int destroy() {
        boolean z;
        RtcChannelEventManager rtcChannelEventManager = this.mRtcChannelEventManager;
        String str = "";
        if (!(rtcChannelEventManager == null || rtcChannelEventManager.getLocalRtcChannelNativeCallBack() == null)) {
            str = str + this.mRtcChannelEventManager.getLocalRtcChannelNativeCallBack();
        }
        ChannelMediaRelayHandler channelMediaRelayHandler = this.mChannelMediaRelayHandler;
        if (channelMediaRelayHandler != null) {
            channelMediaRelayHandler.stopChannelMediaRelay();
            this.mChannelMediaRelayHandler = null;
        }
        GlobalHolder.getInstance().getAVStreamPublishHandler().removeAVStreamPublishBean(this.mChannelName);
        OmniLog.i(this.TAG, "Executing destory... " + this.mChannelName + " | " + this.mRtcChannelManager + " | " + this.mRtcChannelAVManager + " | " + str);
        if (this.mRtcChannelEventManager != null) {
            GlobalHolder.getInstance().removeRtcGlobalServerMessageCallback(this.mRtcChannelEventManager);
            RoomJni.getInstance().removeCallback(this.mRtcChannelEventManager.getLocalRtcChannelNativeCallBack());
            this.mRtcChannelEventManager = null;
        }
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            z = rtcChannelManager.isDefaultChannel();
            this.mRtcChannelManager.destroy();
        } else {
            z = false;
        }
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            rtcChannelAVManager.destroy(z);
        }
        GlobalHolder.getInstance().clearChannelDatas(this.mChannelName);
        this.mRtcChannelManager = null;
        this.mRtcChannelAVManager = null;
        return 0;
    }

    public String channelName() {
        return this.mChannelName;
    }

    public long getUserId() {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            return rtcChannelManager.getChannelUid();
        }
        return 0;
    }

    public int getRole() {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            return rtcChannelManager.getRole();
        }
        return 0;
    }

    public String getChannelSessionId() {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            return rtcChannelManager.getChannelSessionId();
        }
        return null;
    }

    public boolean isJoinedChannel() {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            return rtcChannelManager.isJoinedChannel();
        }
        return false;
    }

    public int setClientRole(int i) {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            return rtcChannelManager.setRole(i);
        }
        return -1;
    }

    public int joinChannel(String str, long j, RtcChannelMediaOptions rtcChannelMediaOptions, boolean z) {
        if (this.mRtcChannelManager == null) {
            return -1;
        }
        RtcChannelConfigBean rtcChannelConfigBean = new RtcChannelConfigBean();
        rtcChannelConfigBean.mChannelToken = str;
        rtcChannelConfigBean.mChannelName = this.mChannelName;
        rtcChannelConfigBean.mChannelUid = j;
        rtcChannelConfigBean.mIsDefaultChannel = z;
        if (rtcChannelMediaOptions != null) {
            rtcChannelConfigBean.mAutoSubscribeAudio = rtcChannelMediaOptions.autoSubscribeAudio;
            rtcChannelConfigBean.mAutoSubscribeVideo = rtcChannelMediaOptions.autoSubscribeVideo;
        }
        RtcGlobalConfigBean rtcGlobalConfigBean = new RtcGlobalConfigBean();
        rtcGlobalConfigBean.mAppId = GlobalConfig.mAppId;
        rtcGlobalConfigBean.mChannelMode = GlobalConfig.mCurrentChannelMode;
        rtcGlobalConfigBean.mVideoModuleEnabled = GlobalConfig.mVideoEnabled;
        int joinChannel = this.mRtcChannelManager.joinChannel(rtcChannelConfigBean, rtcGlobalConfigBean);
        if (joinChannel != 0) {
            return joinChannel;
        }
        this.mRtcChannelEventManager.setJoinChannelTimestamp(System.currentTimeMillis());
        return 0;
    }

    public int leaveChannel() {
        ChannelMediaRelayHandler channelMediaRelayHandler = this.mChannelMediaRelayHandler;
        if (channelMediaRelayHandler != null) {
            channelMediaRelayHandler.stopChannelMediaRelay();
            this.mChannelMediaRelayHandler = null;
        }
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            rtcChannelAVManager.leaveChannel();
        }
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            rtcChannelManager.leaveChannel();
        }
        RtcChannelEventManager rtcChannelEventManager = this.mRtcChannelEventManager;
        if (rtcChannelEventManager != null) {
            rtcChannelEventManager.onLeaveChannel(this.mChannelName);
        }
        GlobalHolder.getInstance().clearChannelDatas(this.mChannelName);
        return 0;
    }

    public int renewToken(String str) {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            return rtcChannelManager.renewToken(str);
        }
        return -1;
    }

    public int setRemoteRenderMode(long j, int i, int i2) {
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            return rtcChannelAVManager.setRemoteRenderMode(j, i, i2);
        }
        String str = this.TAG;
        OmniLog.e("REMOTE_MODE", str, "Set render mode failed! RtcChannelAVManager is null! " + j);
        return -1;
    }

    public int muteRemoteAudioStream(long j, boolean z) {
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            return rtcChannelAVManager.muteRemoteAudioStream(j, z);
        }
        return -1;
    }

    public int muteAllRemoteVideoStreams(boolean z) {
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            return rtcChannelAVManager.muteAllRemoteVideoStreams(z);
        }
        return -1;
    }

    public int muteRemoteVideoStream(long j, boolean z) {
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            return rtcChannelAVManager.muteRemoteVideoStream(j, z);
        }
        return -1;
    }

    public int muteAllRemoteAudioStreams(boolean z) {
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            return rtcChannelAVManager.muteAllRemoteAudioStreams(z);
        }
        return -1;
    }

    public int adjustUserPlaybackSignalVolume(long j, int i) {
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            return rtcChannelAVManager.adjustUserPlaybackSignalVolume(j, i);
        }
        return -1;
    }

    public int setRemoteVideoStreamType(long j, int i) {
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            return rtcChannelAVManager.setRemoteVideoStreamType(j, i);
        }
        return -1;
    }

    public int muteLocalAudioStream(boolean z) {
        return muteLocalAVStream(true, z);
    }

    public int muteLocalVideoStream(boolean z) {
        return muteLocalAVStream(false, z);
    }

    public int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager == null) {
            return -3;
        }
        long channelUid = rtcChannelManager.getChannelUid();
        if (channelUid == 0) {
            return -3;
        }
        if (this.mChannelMediaRelayHandler == null) {
            this.mChannelMediaRelayHandler = new ChannelMediaRelayHandler(this.mChannelName, channelUid);
        }
        return this.mChannelMediaRelayHandler.startChannelMediaRelay(channelMediaRelayConfiguration);
    }

    public int stopChannelMediaRelay() {
        ChannelMediaRelayHandler channelMediaRelayHandler = this.mChannelMediaRelayHandler;
        if (channelMediaRelayHandler == null) {
            return -3;
        }
        channelMediaRelayHandler.stopChannelMediaRelay();
        this.mChannelMediaRelayHandler = null;
        return -3;
    }

    public int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        ChannelMediaRelayHandler channelMediaRelayHandler = this.mChannelMediaRelayHandler;
        if (channelMediaRelayHandler != null) {
            return channelMediaRelayHandler.updateChannelMediaRelay(channelMediaRelayConfiguration);
        }
        return -3;
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            return rtcChannelAVManager.setDefaultMuteAllRemoteAudioStreams(z);
        }
        return -3;
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager != null) {
            return rtcChannelAVManager.setDefaultMuteAllRemoteVideoStreams(z);
        }
        return -3;
    }

    public int addPublishStreamUrl(String str, boolean z) {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            return rtcChannelManager.addPublishStreamUrl(str, z);
        }
        return -3;
    }

    public int removePublishStreamUrl(String str) {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            return rtcChannelManager.removePublishStreamUrl(str);
        }
        return -3;
    }

    public void setisMediaRelay(boolean z) {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            rtcChannelManager.setisMediaRelay(z);
        }
    }

    public void setSrcChannelName(String str) {
        RtcChannelManager rtcChannelManager = this.mRtcChannelManager;
        if (rtcChannelManager != null) {
            rtcChannelManager.setSrcChannelName(str);
        }
    }

    private int muteLocalAVStream(boolean z, boolean z2) {
        boolean z3;
        if (this.mRtcChannelAVManager == null) {
            return 0;
        }
        AVStreamPublishHandler aVStreamPublishHandler = GlobalHolder.getInstance().getAVStreamPublishHandler();
        if (!z2) {
            if (z) {
                z3 = aVStreamPublishHandler.updateAudioMuted(this.mChannelName, false);
            } else {
                z3 = aVStreamPublishHandler.updateVideoMuted(this.mChannelName, false);
            }
            if (!z3) {
                return -5;
            }
        } else if (z) {
            aVStreamPublishHandler.updateAudioMuted(this.mChannelName, true);
        } else {
            aVStreamPublishHandler.updateVideoMuted(this.mChannelName, true);
        }
        RtcChannelAVManager rtcChannelAVManager = this.mRtcChannelAVManager;
        if (rtcChannelAVManager == null) {
            return -1;
        }
        if (z) {
            return rtcChannelAVManager.muteLocalAudioStream(z2);
        }
        return rtcChannelAVManager.muteLocalVideoStream(z2);
    }
}
