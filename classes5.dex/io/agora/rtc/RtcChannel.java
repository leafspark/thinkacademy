package io.agora.rtc;

import io.agora.rtc.internal.EncryptionConfig;
import io.agora.rtc.live.LiveInjectStreamConfig;
import io.agora.rtc.live.LiveTranscoding;
import io.agora.rtc.mediaio.IVideoSink;
import io.agora.rtc.models.ChannelMediaOptions;
import io.agora.rtc.models.ClientRoleOptions;
import io.agora.rtc.models.DataStreamConfig;
import io.agora.rtc.video.ChannelMediaRelayConfiguration;

public abstract class RtcChannel {
    private IRtcChannelEventHandler mEventHandler = null;

    public abstract int addInjectStreamUrl(String str, LiveInjectStreamConfig liveInjectStreamConfig);

    public abstract int addPublishStreamUrl(String str, boolean z);

    public abstract int adjustUserPlaybackSignalVolume(int i, int i2);

    public abstract int applyRemoteStreamSubscribeAdvice(int i, int i2);

    public abstract String channelId();

    public abstract int createDataStream(DataStreamConfig dataStreamConfig);

    public abstract int createDataStream(boolean z, boolean z2);

    public abstract int destroy();

    public abstract int enableEncryption(boolean z, EncryptionConfig encryptionConfig);

    public abstract int enableRemoteSuperResolution(int i, boolean z);

    public abstract String getCallId();

    public abstract String getChannelCallId();

    public abstract int getConnectionState();

    public abstract int joinChannel(String str, String str2, int i, ChannelMediaOptions channelMediaOptions);

    public abstract int joinChannelWithUserAccount(String str, String str2, ChannelMediaOptions channelMediaOptions);

    public abstract int leaveChannel();

    public abstract int muteAllRemoteAudioStreams(boolean z);

    public abstract int muteAllRemoteVideoStreams(boolean z);

    public abstract int muteLocalAudioStream(boolean z);

    public abstract int muteLocalVideoStream(boolean z);

    public abstract int muteRemoteAudioStream(int i, boolean z);

    public abstract int muteRemoteVideoStream(int i, boolean z);

    public abstract int publish();

    public abstract int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i);

    public abstract int removeInjectStreamUrl(String str);

    public abstract int removePublishStreamUrl(String str);

    public abstract int renewToken(String str);

    public abstract int sendStreamMessage(int i, byte[] bArr);

    public abstract int setAVSyncSource(String str, int i);

    public abstract int setClientRole(int i);

    public abstract int setClientRole(int i, ClientRoleOptions clientRoleOptions);

    public abstract int setDefaultMuteAllRemoteAudioStreams(boolean z);

    public abstract int setDefaultMuteAllRemoteVideoStreams(boolean z);

    @Deprecated
    public abstract int setEncryptionMode(String str);

    @Deprecated
    public abstract int setEncryptionSecret(String str);

    public abstract int setLiveTranscoding(LiveTranscoding liveTranscoding);

    public abstract int setRemoteDefaultVideoStreamType(int i);

    public abstract int setRemoteRenderMode(int i, int i2, int i3);

    public abstract int setRemoteUserPriority(int i, int i2);

    public abstract int setRemoteVideoRenderer(int i, IVideoSink iVideoSink);

    public abstract int setRemoteVideoStreamType(int i, int i2);

    public abstract int setRemoteVoicePosition(int i, double d, double d2);

    public abstract int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    public abstract int stopChannelMediaRelay();

    public abstract int unpublish();

    public abstract int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    public void setRtcChannelEventHandler(IRtcChannelEventHandler iRtcChannelEventHandler) {
        this.mEventHandler = iRtcChannelEventHandler;
    }

    public IRtcChannelEventHandler getEventHandler() {
        return this.mEventHandler;
    }
}
