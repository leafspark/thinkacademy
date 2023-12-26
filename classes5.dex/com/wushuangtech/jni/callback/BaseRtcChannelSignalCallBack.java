package com.wushuangtech.jni.callback;

import com.wushuangtech.jni.RoomJni;

public abstract class BaseRtcChannelSignalCallBack implements RoomJni.RoomJniCallback {
    public void OnAudioLevelReport(String str, long j, int i, int i2) {
    }

    public void OnAudioMsgLog(int i, long j) {
    }

    public void OnAudioPublishStateChanged(String str, int i, int i2, int i3) {
    }

    public void OnAudioRemoteFirstFrame(String str, long j) {
    }

    public void OnAudioSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
    }

    public void OnAudioTryReconnect() {
    }

    public void OnAudioUpstreamStatus(String str, long j, int i) {
    }

    public void OnCheckNetQuality(int i, int i2, int i3) {
    }

    public void OnConfRefreshToken(String str, String str2, int i, int i2, int i3) {
    }

    public void OnConnect(String str, String str2, int i) {
    }

    public void OnConnectFailed(String str, String str2, int i) {
    }

    public void OnConnectIdReport(String str) {
    }

    public void OnConnectServerResult(String str, int i, String str2) {
    }

    public void OnEnterAuthed() {
    }

    public void OnEnterTimeout(String str, String str2, long j, int i, int i2, long j2, long j3, long j4, long j5, long j6, String str3) {
    }

    public void OnFirstAudioSent() {
    }

    public void OnFirstVideoSent() {
    }

    public void OnGlobalSessionId(String str, String str2) {
    }

    public void OnMediaReconnect(int i, String str) {
    }

    public void OnMediaRelayEvent(String str, String str2, int i) {
    }

    public void OnMediaRelayModeUpdate(int i) {
    }

    public void OnMediaRelayStateChanged(String str, String str2, int i, int i2) {
    }

    public void OnMixAudioLevelReport(String str, long j, int i, int i2) {
    }

    public void OnNetTestQuality(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
    }

    public void OnReceiveLyric(String str, long j, String str2) {
    }

    public void OnReconnectTimeout() {
    }

    public void OnRecvAudioMsg(String str, long j, int i, byte[] bArr) {
    }

    public void OnRecvCmdMsg(String str, long j, String str2) {
    }

    public void OnRecvVideoMsg(String str, String str2) {
    }

    public void OnRejoin(String str, int i) {
    }

    public void OnRemoteAudioMuted(String str, long j, boolean z) {
    }

    public void OnRemoteStreamSubscribeAdvice(String str, long j, int i, int i2) {
    }

    public void OnRemoteVideoMuted(String str, long j, boolean z) {
    }

    public void OnReportFirstIFrameSent() {
    }

    public void OnReportImageFireEvent() {
    }

    public void OnReportMediaAddr(String str, int i, String str2, String str3, int i2, String str4) {
    }

    public void OnRoomChairChanged(String str, long j) {
    }

    public void OnRoomConnectSuccess() {
    }

    public void OnRoomDisconnected(String str) {
    }

    public void OnRoomEnter(String str, int i, int i2, long j, int i3, int i4, long j2, long j3, long j4, long j5, long j6, long j7, String str2) {
    }

    public void OnRoomKicked(String str, long j, long j2, int i, String str2, int i2) {
    }

    public void OnRoomMemberEnter(String str, long j, String str2, int i, int i2, boolean z, boolean z2) {
    }

    public void OnRoomMemberExit(String str, long j, int i) {
    }

    public void OnRoomPermissionGranted(long j, int i, int i2) {
    }

    public void OnRtpRtcp(boolean z, boolean z2) {
    }

    public void OnSendDataFail(String str, int i, int i2) {
    }

    public void OnSetAudioCodecParams(int i, int i2) {
    }

    public void OnStartSendAudio() {
    }

    public void OnStartSendVideo(boolean z, boolean z2) {
    }

    public void OnStopSendAudio() {
    }

    public void OnStopSendVideo(int i) {
    }

    public void OnUpdateAudioStatus(String str, long j, boolean z, boolean z2) {
    }

    public void OnUpdateDevParam(String str) {
    }

    public void OnUpdateMediaChannelState(int i, int i2, String str, int i3, int i4) {
    }

    public void OnUpdateRtmpError(String str, String str2) {
    }

    public void OnUpdateRtmpStatus(String str, String str2, int i) {
    }

    public void OnUpdateVideoDev(String str, long j, String str2) {
    }

    public void OnUserRoleChanged(String str, long j, int i) {
    }

    public void OnVideoBufferingStateChanged(String str, long j, boolean z, int i, long j2) {
    }

    public void OnVideoMixerCreate(String str, String str2, String str3) {
    }

    public void OnVideoPublishStateChanged(String str, int i, int i2, int i3) {
    }

    public void OnVideoSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
    }

    public void OnVideoTryReconnect() {
    }
}
