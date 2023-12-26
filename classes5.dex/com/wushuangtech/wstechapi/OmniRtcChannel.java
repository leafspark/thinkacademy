package com.wushuangtech.wstechapi;

import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;
import com.wushuangtech.wstechapi.bean.ChannelMediaOptions;

public interface OmniRtcChannel {
    int addPublishStreamUrl(String str, boolean z);

    int adjustUserPlaybackSignalVolume(long j, int i);

    String channelId();

    int createDataStream(boolean z, boolean z2);

    int destroy();

    String getChannelSessionId();

    int getConnectionState();

    OmniRtcChannelEventHandler getEventHandler();

    int getRole();

    long getUid();

    boolean isJoinedChannel();

    int joinChannel(String str, long j, ChannelMediaOptions channelMediaOptions);

    int leaveChannel();

    int muteAllRemoteAudioStreams(boolean z);

    int muteAllRemoteVideoStreams(boolean z);

    int muteLocalAudioStream(boolean z);

    int muteLocalVideoStream(boolean z);

    int muteRemoteAudioStream(long j, boolean z);

    int muteRemoteVideoStream(long j, boolean z);

    int publish();

    int removeInjectStreamUrl(String str);

    int removePublishStreamUrl(String str);

    int renewToken(String str);

    int sendStreamMessage(int i, byte[] bArr);

    int setClientRole(int i);

    int setDefaultMuteAllRemoteAudioStreams(boolean z);

    int setDefaultMuteAllRemoteVideoStreams(boolean z);

    int setRemoteDefaultVideoStreamType(int i);

    int setRemoteRenderMode(int i, int i2);

    int setRemoteRenderMode(long j, int i, int i2);

    int setRemoteUserPriority(int i, int i2);

    int setRemoteVideoStreamType(long j, int i);

    int setRemoteVoicePosition(int i, double d, double d2);

    int setRemoteVolumeAll(int i);

    void setRtcChannelEventHandler(OmniRtcChannelEventHandler omniRtcChannelEventHandler);

    int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    int stopChannelMediaRelay();

    int takeRemoteViewSnapshot(long j);

    int unpublish();

    int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);
}
