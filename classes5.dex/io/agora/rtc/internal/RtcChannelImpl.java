package io.agora.rtc.internal;

import io.agora.rtc.IMetadataObserver;
import io.agora.rtc.RtcChannel;
import io.agora.rtc.internal.RtcEngineMessage;
import io.agora.rtc.live.LiveInjectStreamConfig;
import io.agora.rtc.mediaio.AgoraDefaultRender;
import io.agora.rtc.mediaio.IVideoSink;
import io.agora.rtc.models.ChannelMediaOptions;
import io.agora.rtc.models.ClientRoleOptions;
import io.agora.rtc.models.DataStreamConfig;

public class RtcChannelImpl extends RtcChannel {
    private boolean mInitialized = false;
    private boolean mJoined = false;
    private long mNativeHandle = 0;
    private RtcEngineImpl mRtcEngineImpl = null;

    private native int nativeRtcChannelAddInjectStreamUrl(long j, String str, byte[] bArr);

    private native int nativeRtcChannelAddPublishStreamUrl(long j, String str, boolean z);

    private native int nativeRtcChannelAddRemoteVideoRender(long j, int i, IVideoSink iVideoSink, int i2);

    private native int nativeRtcChannelAdjustUserPlaybackSignalVolume(long j, int i, int i2);

    private native int nativeRtcChannelApplyRemoteStreamSubscribeAdvice(long j, int i, int i2);

    private native String nativeRtcChannelChannelId(long j);

    private native int nativeRtcChannelCreateDataStream(long j, boolean z, boolean z2);

    private native int nativeRtcChannelCreateDataStream2(long j, boolean z, boolean z2);

    private native int nativeRtcChannelEnableEncryption(long j, boolean z, int i, String str, byte[] bArr);

    private native int nativeRtcChannelEnableRemoteSuperResolution(long j, int i, boolean z);

    private native String nativeRtcChannelGetCallId(long j);

    private native String nativeRtcChannelGetChannelCallId(long j);

    private native int nativeRtcChannelGetConncetionState(long j);

    private native int nativeRtcChannelJoinChannel(long j, String str, String str2, int i, Object obj);

    private native int nativeRtcChannelJoinChannelWithUserAccount(long j, String str, String str2, Object obj);

    private native int nativeRtcChannelLeaveChannel(long j);

    private native int nativeRtcChannelMuteAllRemoteAudioStreams(long j, boolean z);

    private native int nativeRtcChannelMuteAllRemoteVideoStreams(long j, boolean z);

    private native int nativeRtcChannelMuteLocalAudioStream(long j, boolean z);

    private native int nativeRtcChannelMuteLocalVideoStream(long j, boolean z);

    private native int nativeRtcChannelMuteRemoteAudioStream(long j, int i, boolean z);

    private native int nativeRtcChannelMuteRemoteVideoStream(long j, int i, boolean z);

    private native int nativeRtcChannelPublish(long j);

    private native int nativeRtcChannelRegisterMediaMetadataObserver(long j, Object obj, int i);

    private native int nativeRtcChannelRemoveInjectStreamUrl(long j, String str);

    private native int nativeRtcChannelRemovePublishStreamUrl(long j, String str);

    private native int nativeRtcChannelRenewToken(long j, String str);

    private native int nativeRtcChannelSendStreamMessage(long j, int i, byte[] bArr);

    private native int nativeRtcChannelSetAVSyncSource(long j, String str, int i);

    private native int nativeRtcChannelSetClientRole(long j, int i);

    private native int nativeRtcChannelSetClientRoleOptions(long j, int i, Object obj);

    private native int nativeRtcChannelSetDefaultMuteAllRemoteAudioStreams(long j, boolean z);

    private native int nativeRtcChannelSetDefaultMuteAllRemoteVideoStreams(long j, boolean z);

    private native int nativeRtcChannelSetEncryptionMode(long j, String str);

    private native int nativeRtcChannelSetEncryptionSecret(long j, String str);

    private native int nativeRtcChannelSetLiveTranscoding(long j, byte[] bArr);

    private native int nativeRtcChannelSetRemoteDefaultVideoStreamType(long j, int i);

    private native int nativeRtcChannelSetRemoteRenderMode(long j, int i, int i2);

    private native int nativeRtcChannelSetRemoteRenderModeWithMirrorMode(long j, int i, int i2, int i3);

    private native int nativeRtcChannelSetRemoteUserPriority(long j, int i, int i2);

    private native int nativeRtcChannelSetRemoteVideoStreamType(long j, int i, int i2);

    private native int nativeRtcChannelSetRemoteVoicePosition(long j, int i, double d, double d2);

    private native int nativeRtcChannelStartChannelMediaRelay(long j, byte[] bArr);

    private native int nativeRtcChannelStopChannelMediaRelay(long j);

    private native int nativeRtcChannelUnpublish(long j);

    private native int nativeRtcChannelUpdateChannelMediaRelay(long j, byte[] bArr);

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public boolean hasJoined() {
        return this.mJoined;
    }

    public long getNativeHandle() {
        return this.mNativeHandle;
    }

    public void onEngineDestroy() {
        this.mNativeHandle = 0;
        this.mInitialized = false;
    }

    public int initialize(RtcEngineImpl rtcEngineImpl, long j) {
        this.mRtcEngineImpl = rtcEngineImpl;
        this.mNativeHandle = j;
        this.mInitialized = true;
        return 0;
    }

    public String channelId() {
        if (!this.mInitialized) {
            return "";
        }
        return nativeRtcChannelChannelId(this.mNativeHandle);
    }

    public String getCallId() {
        if (!this.mInitialized) {
            return "";
        }
        return nativeRtcChannelGetCallId(this.mNativeHandle);
    }

    public String getChannelCallId() {
        if (!this.mInitialized) {
            return "";
        }
        return nativeRtcChannelGetChannelCallId(this.mNativeHandle);
    }

    public int destroy() {
        if (!this.mInitialized) {
            return -7;
        }
        int destroyRtcChannel = this.mRtcEngineImpl.destroyRtcChannel(channelId());
        this.mInitialized = false;
        return destroyRtcChannel;
    }

    public int getConnectionState() {
        if (!this.mInitialized) {
            return 1;
        }
        return nativeRtcChannelGetConncetionState(this.mNativeHandle);
    }

    public int enableRemoteSuperResolution(int i, boolean z) {
        if (!this.mInitialized) {
            return 1;
        }
        return nativeRtcChannelEnableRemoteSuperResolution(this.mNativeHandle, i, z);
    }

    public int joinChannel(String str, String str2, int i, ChannelMediaOptions channelMediaOptions) {
        if (!this.mInitialized || this.mRtcEngineImpl.getContext() == null) {
            return -7;
        }
        if (channelMediaOptions == null) {
            return -2;
        }
        this.mRtcEngineImpl.onRtcChannelJoinChannel();
        this.mJoined = true;
        return nativeRtcChannelJoinChannel(this.mNativeHandle, str, str2, i, channelMediaOptions);
    }

    public int joinChannelWithUserAccount(String str, String str2, ChannelMediaOptions channelMediaOptions) {
        if (!this.mInitialized || this.mRtcEngineImpl.getContext() == null) {
            return -7;
        }
        if (channelMediaOptions == null) {
            return -2;
        }
        this.mRtcEngineImpl.onRtcChannelJoinChannel();
        this.mJoined = true;
        return nativeRtcChannelJoinChannelWithUserAccount(this.mNativeHandle, str, str2, channelMediaOptions);
    }

    public int leaveChannel() {
        if (!this.mInitialized) {
            return -7;
        }
        this.mJoined = false;
        this.mRtcEngineImpl.onRtcChannelLeaveChannel();
        return nativeRtcChannelLeaveChannel(this.mNativeHandle);
    }

    public int setAVSyncSource(String str, int i) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetAVSyncSource(this.mNativeHandle, str, i);
    }

    public int muteLocalAudioStream(boolean z) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteLocalAudioStream(this.mNativeHandle, z);
    }

    public int muteLocalVideoStream(boolean z) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteLocalVideoStream(this.mNativeHandle, z);
    }

    public int publish() {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelPublish(this.mNativeHandle);
    }

    public int unpublish() {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelUnpublish(this.mNativeHandle);
    }

    public int renewToken(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelRenewToken(this.mNativeHandle, str);
    }

    public int setEncryptionSecret(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetEncryptionSecret(this.mNativeHandle, str);
    }

    public int setEncryptionMode(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetEncryptionMode(this.mNativeHandle, str);
    }

    public int enableEncryption(boolean z, EncryptionConfig encryptionConfig) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelEnableEncryption(this.mNativeHandle, z, encryptionConfig.encryptionMode.getValue(), encryptionConfig.encryptionKey, encryptionConfig.encryptionKdfSalt);
    }

    public int registerMediaMetadataObserver(IMetadataObserver iMetadataObserver, int i) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelRegisterMediaMetadataObserver(this.mNativeHandle, iMetadataObserver, i);
    }

    public int setClientRole(int i) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetClientRole(this.mNativeHandle, i);
    }

    public int setClientRole(int i, ClientRoleOptions clientRoleOptions) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetClientRoleOptions(this.mNativeHandle, i, clientRoleOptions);
    }

    public int setRemoteUserPriority(int i, int i2) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetRemoteUserPriority(this.mNativeHandle, i, i2);
    }

    public int setRemoteVoicePosition(int i, double d, double d2) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetRemoteVoicePosition(this.mNativeHandle, i, d, d2);
    }

    public int setRemoteRenderMode(int i, int i2, int i3) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetRemoteRenderModeWithMirrorMode(this.mNativeHandle, i, i2, i3);
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetDefaultMuteAllRemoteAudioStreams(this.mNativeHandle, z);
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetDefaultMuteAllRemoteVideoStreams(this.mNativeHandle, z);
    }

    public int muteAllRemoteAudioStreams(boolean z) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteAllRemoteAudioStreams(this.mNativeHandle, z);
    }

    public int muteRemoteAudioStream(int i, boolean z) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteRemoteAudioStream(this.mNativeHandle, i, z);
    }

    public int adjustUserPlaybackSignalVolume(int i, int i2) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelAdjustUserPlaybackSignalVolume(this.mNativeHandle, i, i2);
    }

    public int muteAllRemoteVideoStreams(boolean z) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteAllRemoteVideoStreams(this.mNativeHandle, z);
    }

    public int muteRemoteVideoStream(int i, boolean z) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelMuteRemoteVideoStream(this.mNativeHandle, i, z);
    }

    public int applyRemoteStreamSubscribeAdvice(int i, int i2) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelApplyRemoteStreamSubscribeAdvice(this.mNativeHandle, i, i2);
    }

    public int setRemoteVideoStreamType(int i, int i2) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetRemoteVideoStreamType(this.mNativeHandle, i, i2);
    }

    public int setRemoteDefaultVideoStreamType(int i) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSetRemoteDefaultVideoStreamType(this.mNativeHandle, i);
    }

    public int createDataStream(boolean z, boolean z2) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelCreateDataStream(this.mNativeHandle, z, z2);
    }

    public int createDataStream(DataStreamConfig dataStreamConfig) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelCreateDataStream2(this.mNativeHandle, dataStreamConfig.ordered, dataStreamConfig.syncWithAudio);
    }

    public int sendStreamMessage(int i, byte[] bArr) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelSendStreamMessage(this.mNativeHandle, i, bArr);
    }

    public int addPublishStreamUrl(String str, boolean z) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelAddPublishStreamUrl(this.mNativeHandle, str, z);
    }

    public int removePublishStreamUrl(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelRemovePublishStreamUrl(this.mNativeHandle, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setLiveTranscoding(io.agora.rtc.live.LiveTranscoding r4) {
        /*
            r3 = this;
            boolean r0 = r3.mInitialized
            if (r0 != 0) goto L_0x0006
            r4 = -7
            return r4
        L_0x0006:
            if (r4 != 0) goto L_0x000a
            r4 = -2
            return r4
        L_0x000a:
            java.util.ArrayList r0 = r4.getUsers()
            if (r0 == 0) goto L_0x0035
            java.util.ArrayList r0 = r4.getUsers()
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0035
            java.lang.Object r1 = r0.next()
            io.agora.rtc.live.LiveTranscoding$TranscodingUser r1 = (io.agora.rtc.live.LiveTranscoding.TranscodingUser) r1
            int r2 = r1.width
            if (r2 <= 0) goto L_0x002d
            int r1 = r1.height
            if (r1 <= 0) goto L_0x002d
            goto L_0x0018
        L_0x002d:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "transcoding user's width and height must be >0"
            r4.<init>(r0)
            throw r4
        L_0x0035:
            io.agora.rtc.internal.RtcEngineMessage$PLiveTranscoding r0 = new io.agora.rtc.internal.RtcEngineMessage$PLiveTranscoding
            r0.<init>()
            byte[] r4 = r0.marshall((io.agora.rtc.live.LiveTranscoding) r4)
            long r0 = r3.mNativeHandle
            int r4 = r3.nativeRtcChannelSetLiveTranscoding(r0, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.internal.RtcChannelImpl.setLiveTranscoding(io.agora.rtc.live.LiveTranscoding):int");
    }

    public int addInjectStreamUrl(String str, LiveInjectStreamConfig liveInjectStreamConfig) {
        if (!this.mInitialized) {
            return -7;
        }
        if (str == null || liveInjectStreamConfig == null) {
            return -2;
        }
        return nativeRtcChannelAddInjectStreamUrl(this.mNativeHandle, str, new RtcEngineMessage.PInjectStreamConfig().marshall(liveInjectStreamConfig));
    }

    public int removeInjectStreamUrl(String str) {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelRemoveInjectStreamUrl(this.mNativeHandle, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int startChannelMediaRelay(io.agora.rtc.video.ChannelMediaRelayConfiguration r5) {
        /*
            r4 = this;
            boolean r0 = r4.mInitialized
            if (r0 != 0) goto L_0x0006
            r5 = -7
            return r5
        L_0x0006:
            r0 = -2
            if (r5 == 0) goto L_0x005b
            java.util.Map r1 = r5.getDestChannelMediaInfos()
            int r1 = r1.size()
            if (r1 == 0) goto L_0x005b
            io.agora.rtc.video.ChannelMediaInfo r1 = r5.getSrcChannelMediaInfo()
            if (r1 != 0) goto L_0x001a
            goto L_0x005b
        L_0x001a:
            java.util.Map r1 = r5.getDestChannelMediaInfos()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0026:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            io.agora.rtc.video.ChannelMediaInfo r3 = (io.agora.rtc.video.ChannelMediaInfo) r3
            java.lang.String r3 = r3.channelName
            if (r3 == 0) goto L_0x004a
            java.lang.Object r2 = r2.getValue()
            io.agora.rtc.video.ChannelMediaInfo r2 = (io.agora.rtc.video.ChannelMediaInfo) r2
            java.lang.String r2 = r2.channelName
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0026
        L_0x004a:
            return r0
        L_0x004b:
            io.agora.rtc.internal.RtcEngineMessage$PChannelMediaRelayConfiguration r0 = new io.agora.rtc.internal.RtcEngineMessage$PChannelMediaRelayConfiguration
            r0.<init>()
            byte[] r5 = r0.marshall((io.agora.rtc.video.ChannelMediaRelayConfiguration) r5)
            long r0 = r4.mNativeHandle
            int r5 = r4.nativeRtcChannelStartChannelMediaRelay(r0, r5)
            return r5
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.internal.RtcChannelImpl.startChannelMediaRelay(io.agora.rtc.video.ChannelMediaRelayConfiguration):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int updateChannelMediaRelay(io.agora.rtc.video.ChannelMediaRelayConfiguration r5) {
        /*
            r4 = this;
            boolean r0 = r4.mInitialized
            if (r0 != 0) goto L_0x0006
            r5 = -7
            return r5
        L_0x0006:
            r0 = -2
            if (r5 == 0) goto L_0x005b
            java.util.Map r1 = r5.getDestChannelMediaInfos()
            int r1 = r1.size()
            if (r1 == 0) goto L_0x005b
            io.agora.rtc.video.ChannelMediaInfo r1 = r5.getSrcChannelMediaInfo()
            if (r1 != 0) goto L_0x001a
            goto L_0x005b
        L_0x001a:
            java.util.Map r1 = r5.getDestChannelMediaInfos()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0026:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            io.agora.rtc.video.ChannelMediaInfo r3 = (io.agora.rtc.video.ChannelMediaInfo) r3
            java.lang.String r3 = r3.channelName
            if (r3 == 0) goto L_0x004a
            java.lang.Object r2 = r2.getValue()
            io.agora.rtc.video.ChannelMediaInfo r2 = (io.agora.rtc.video.ChannelMediaInfo) r2
            java.lang.String r2 = r2.channelName
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0026
        L_0x004a:
            return r0
        L_0x004b:
            io.agora.rtc.internal.RtcEngineMessage$PChannelMediaRelayConfiguration r0 = new io.agora.rtc.internal.RtcEngineMessage$PChannelMediaRelayConfiguration
            r0.<init>()
            byte[] r5 = r0.marshall((io.agora.rtc.video.ChannelMediaRelayConfiguration) r5)
            long r0 = r4.mNativeHandle
            int r5 = r4.nativeRtcChannelUpdateChannelMediaRelay(r0, r5)
            return r5
        L_0x005b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.internal.RtcChannelImpl.updateChannelMediaRelay(io.agora.rtc.video.ChannelMediaRelayConfiguration):int");
    }

    public int stopChannelMediaRelay() {
        if (!this.mInitialized) {
            return -7;
        }
        return nativeRtcChannelStopChannelMediaRelay(this.mNativeHandle);
    }

    public int setRemoteVideoRenderer(int i, IVideoSink iVideoSink) {
        int i2;
        if (!this.mInitialized) {
            return -7;
        }
        if (iVideoSink == null) {
            i2 = 0;
        } else {
            i2 = iVideoSink instanceof AgoraDefaultRender ? 1 : 2;
        }
        return nativeRtcChannelAddRemoteVideoRender(this.mNativeHandle, i, iVideoSink, i2);
    }
}
