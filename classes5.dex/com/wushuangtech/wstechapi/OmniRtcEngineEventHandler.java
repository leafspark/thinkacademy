package com.wushuangtech.wstechapi;

import android.graphics.Bitmap;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.expansion.inter.OmniRtcEngineEventInter;

public abstract class OmniRtcEngineEventHandler implements OmniRtcEngineEventInter {
    public void onAkamaiServerID(String str, String str2) {
    }

    public void onAudioBufferingStateChanged(long j, int i, long j2) {
    }

    public void onAudioEffectFinished(int i) {
    }

    public void onAudioMixingPlayFinish() {
    }

    public void onAudioPublishStateChanged(int i, int i2, int i3) {
    }

    public void onAudioRecordFinish() {
    }

    public void onAudioRouteChanged(int i) {
    }

    public void onAudioSubscribeStateChanged(long j, int i, int i2, int i3) {
    }

    public void onAudioVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i) {
    }

    public void onCameraConnectError(int i) {
    }

    public void onCameraReady() {
    }

    public void onCaptureVideoFrame(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j) {
    }

    public void onCaptureVideoSize(int i, int i2) {
    }

    public void onChannelMediaRelayEvent(int i) {
    }

    public void onChannelMediaRelayStateChanged(int i, int i2) {
    }

    public void onClientRoleChanged(long j, int i) {
    }

    public void onConnectionLost() {
    }

    public void onConnectionStateChanged(int i, int i2) {
    }

    public void onDualSteamModeEnabled(long j, boolean z) {
    }

    public void onError(int i) {
    }

    public void onFirstLocalAudioFrame(int i) {
    }

    public void onFirstLocalVideoFrame(int i, int i2, int i3) {
    }

    public void onFirstLocalVideoFramePublished(int i) {
    }

    public void onFirstRemoteAudioDecoded(long j, int i) {
    }

    public void onFirstRemoteAudioFrame(long j, int i) {
    }

    public void onFirstRemoteVideoDecoded(long j, int i, int i2, int i3) {
    }

    public void onFirstRemoteVideoDecoded(long j, String str, int i, int i2, int i3) {
    }

    public void onFirstRemoteVideoFrame(long j, int i, int i2, int i3) {
    }

    public void onFirstRemoteVideoFrame(long j, String str, int i, int i2, int i3) {
    }

    public void onJoinChannelSuccess(String str, long j, int i) {
    }

    public void onLastmileQuality(int i) {
    }

    public void onLeaveChannel(RtcStats rtcStats) {
    }

    public byte[] onLocalAudioDataReport(byte[] bArr, int i, int i2, int i3) {
        return new byte[0];
    }

    public void onLocalAudioStateChanged(int i, int i2) {
    }

    public void onLocalAudioStats(LocalAudioStats localAudioStats) {
    }

    public void onLocalVideoStateChanged(int i, int i2) {
    }

    public void onLocalVideoStats(LocalVideoStats localVideoStats) {
    }

    public byte[] onMixedAudioFrame(byte[] bArr, int i, int i2, int i3) {
        return new byte[0];
    }

    public void onNetworkQuality(long j, int i, int i2) {
    }

    public void onReceiveAudioLyric(long j, String str) {
    }

    public void onReconnectServerFailed() {
    }

    public void onReconnectServerSucceed() {
    }

    public void onRejoinChannelSuccess(String str, long j, int i) {
    }

    public byte[] onRemoteAudioDataReport(byte[] bArr, int i, int i2, int i3) {
        return new byte[0];
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

    public void onRenderVideoFrame(long j, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2) {
    }

    public void onRequestToken() {
    }

    public void onRtcLogReport(int i, String str) {
    }

    public void onRtcPushStatus(String str, boolean z) {
    }

    public void onRtcStats(RtcStats rtcStats) {
    }

    public void onSetSEI(String str) {
    }

    public void onSpeakingMuted(long j, boolean z) {
    }

    public void onStatusOfRtmpPublish(int i) {
    }

    public void onStreamMessage(long j, int i, byte[] bArr) {
    }

    public void onTakeLocalViewSnapshot(Bitmap bitmap) {
    }

    public void onTakePreEncodeSnapshot(byte[] bArr) {
    }

    public void onTakeRemoteViewSnapshot(long j, Bitmap bitmap) {
    }

    public void onTokenPrivilegeWillExpire() {
    }

    public void onUserEnableVideo(long j, String str, int i, boolean z) {
    }

    public void onUserEnableVideo(long j, String str, boolean z) {
    }

    public void onUserEnableVideo(long j, boolean z) {
    }

    public void onUserJoined(long j, int i, int i2) {
    }

    public void onUserKicked(long j, int i, int i2) {
    }

    public void onUserMuteAudio(long j, boolean z) {
    }

    public void onUserMuteVideo(long j, boolean z) {
    }

    public void onUserOffline(long j, int i) {
    }

    public void onVideoBufferingStateChanged(long j, int i, long j2) {
    }

    public void onVideoMixerCreated(String str, String str2) {
    }

    public void onVideoPublishStateChanged(int i, int i2, int i3) {
    }

    public void onVideoSubscribeStateChanged(long j, int i, int i2, int i3) {
    }

    public void reportH264SeiContent(String str, long j) {
    }
}
