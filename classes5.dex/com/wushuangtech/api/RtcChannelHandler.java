package com.wushuangtech.api;

import com.wushuangtech.bean.RtcChannelMediaOptions;
import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;

public interface RtcChannelHandler {
    int addPublishStreamUrl(String str, boolean z);

    int adjustUserPlaybackSignalVolume(long j, int i);

    String channelName();

    int destroy();

    String getChannelSessionId();

    int getRole();

    long getUserId();

    boolean isJoinedChannel();

    int joinChannel(String str, long j, RtcChannelMediaOptions rtcChannelMediaOptions, boolean z);

    int leaveChannel();

    int muteAllRemoteAudioStreams(boolean z);

    int muteAllRemoteVideoStreams(boolean z);

    int muteLocalAudioStream(boolean z);

    int muteLocalVideoStream(boolean z);

    int muteRemoteAudioStream(long j, boolean z);

    int muteRemoteVideoStream(long j, boolean z);

    int removePublishStreamUrl(String str);

    int renewToken(String str);

    int setClientRole(int i);

    int setDefaultMuteAllRemoteAudioStreams(boolean z);

    int setDefaultMuteAllRemoteVideoStreams(boolean z);

    int setRemoteRenderMode(long j, int i, int i2);

    int setRemoteVideoStreamType(long j, int i);

    void setSrcChannelName(String str);

    void setisMediaRelay(boolean z);

    int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    int stopChannelMediaRelay();

    int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);
}
