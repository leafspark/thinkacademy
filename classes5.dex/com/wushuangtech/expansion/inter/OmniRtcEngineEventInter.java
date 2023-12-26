package com.wushuangtech.expansion.inter;

import android.graphics.Bitmap;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;

public interface OmniRtcEngineEventInter {
    void onAkamaiServerID(String str, String str2);

    void onAudioBufferingStateChanged(long j, int i, long j2);

    void onAudioEffectFinished(int i);

    void onAudioMixingPlayFinish();

    void onAudioPublishStateChanged(int i, int i2, int i3);

    void onAudioRecordFinish();

    void onAudioRouteChanged(int i);

    void onAudioSubscribeStateChanged(long j, int i, int i2, int i3);

    void onAudioVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i);

    void onCameraConnectError(int i);

    void onCameraReady();

    void onCaptureVideoFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

    void onCaptureVideoSize(int i, int i2);

    void onChannelMediaRelayEvent(int i);

    void onChannelMediaRelayStateChanged(int i, int i2);

    void onClientRoleChanged(long j, int i);

    void onConnectionLost();

    void onConnectionStateChanged(int i, int i2);

    void onDualSteamModeEnabled(long j, boolean z);

    void onError(int i);

    void onFirstLocalAudioFrame(int i);

    void onFirstLocalVideoFrame(int i, int i2, int i3);

    void onFirstLocalVideoFramePublished(int i);

    void onFirstRemoteAudioDecoded(long j, int i);

    void onFirstRemoteAudioFrame(long j, int i);

    void onFirstRemoteVideoDecoded(long j, int i, int i2, int i3);

    void onFirstRemoteVideoDecoded(long j, String str, int i, int i2, int i3);

    void onFirstRemoteVideoFrame(long j, int i, int i2, int i3);

    void onFirstRemoteVideoFrame(long j, String str, int i, int i2, int i3);

    void onJoinChannelSuccess(String str, long j, int i);

    void onLastmileQuality(int i);

    void onLeaveChannel(RtcStats rtcStats);

    byte[] onLocalAudioDataReport(byte[] bArr, int i, int i2, int i3);

    void onLocalAudioStateChanged(int i, int i2);

    void onLocalAudioStats(LocalAudioStats localAudioStats);

    void onLocalVideoStateChanged(int i, int i2);

    void onLocalVideoStats(LocalVideoStats localVideoStats);

    byte[] onMixedAudioFrame(byte[] bArr, int i, int i2, int i3);

    void onNetworkQuality(long j, int i, int i2);

    void onReceiveAudioLyric(long j, String str);

    void onReconnectServerFailed();

    void onReconnectServerSucceed();

    void onRejoinChannelSuccess(String str, long j, int i);

    byte[] onRemoteAudioDataReport(byte[] bArr, int i, int i2, int i3);

    void onRemoteAudioStateChanged(long j, int i, int i2, int i3);

    void onRemoteAudioStats(RemoteAudioStats remoteAudioStats);

    void onRemoteStreamSubscribeAdvice(long j, int i, int i2);

    void onRemoteVideoStateChanged(long j, int i, int i2, int i3);

    void onRemoteVideoStats(RemoteVideoStats remoteVideoStats);

    void onRenderVideoFrame(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2);

    void onRequestToken();

    void onRtcLogReport(int i, String str);

    void onRtcPushStatus(String str, boolean z);

    void onRtcStats(RtcStats rtcStats);

    void onSetSEI(String str);

    void onSpeakingMuted(long j, boolean z);

    void onStatusOfRtmpPublish(int i);

    void onStreamMessage(long j, int i, byte[] bArr);

    void onTakeLocalViewSnapshot(Bitmap bitmap);

    void onTakePreEncodeSnapshot(byte[] bArr);

    void onTakeRemoteViewSnapshot(long j, Bitmap bitmap);

    void onTokenPrivilegeWillExpire();

    void onUserEnableVideo(long j, String str, int i, boolean z);

    void onUserEnableVideo(long j, String str, boolean z);

    void onUserEnableVideo(long j, boolean z);

    void onUserJoined(long j, int i, int i2);

    void onUserKicked(long j, int i, int i2);

    @Deprecated
    void onUserMuteAudio(long j, boolean z);

    void onUserMuteVideo(long j, boolean z);

    void onUserOffline(long j, int i);

    void onVideoBufferingStateChanged(long j, int i, long j2);

    void onVideoMixerCreated(String str, String str2);

    void onVideoPublishStateChanged(int i, int i2, int i3);

    void onVideoSubscribeStateChanged(long j, int i, int i2, int i3);

    void reportH264SeiContent(String str, long j);
}
