package com.eaydu.omni;

import android.view.TextureView;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.log.LogReport;

public abstract class BaseRTCChannel {
    private static final int ERROR_CODE_NOT_IMPLEMENT = -2;

    public int addPublishStreamUrl(String str, boolean z) {
        return -2;
    }

    public int applyRemoteStreamSubscribeAdvice(long j, int i) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public void destroy() {
    }

    public String getChannelCallId() {
        return "";
    }

    /* access modifiers changed from: protected */
    public abstract String getChannelId();

    /* access modifiers changed from: protected */
    public long getTimestamp(int i) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public abstract void joinChannel(String str, long j);

    /* access modifiers changed from: protected */
    public abstract void leaveChannel();

    public void muteAllRemoteAudio(boolean z) {
    }

    public void muteAllRemoteVideo(boolean z) {
    }

    /* access modifiers changed from: protected */
    public int muteLocalAudio(boolean z) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public int muteLocalVideo(boolean z) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public void muteRemoteAudio(long j, boolean z) {
    }

    /* access modifiers changed from: protected */
    public void muteRemoteVideo(long j, boolean z) {
    }

    /* access modifiers changed from: protected */
    public int publish() {
        return -2;
    }

    public int removePublishStreamUrl(String str) {
        return -2;
    }

    public int sendStreamMessage(long j, byte[] bArr) {
        return -2;
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        return -2;
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public abstract void setEventListener(RTCChannel.IRTCChannelEventListener iRTCChannelEventListener);

    /* access modifiers changed from: protected */
    public void setLogReport(LogReport logReport) {
    }

    /* access modifiers changed from: protected */
    public abstract void setRemoteRenderMode(long j, RTCEngine.RTCVideoRenderMode rTCVideoRenderMode);

    public int setRemoteVideoStreamType(long j, int i) {
        return -2;
    }

    public int setRemoteVolumeAll(int i) {
        return -2;
    }

    public int setRole(RTCEngine.RTCRole rTCRole) {
        return -2;
    }

    public int setRtmpConfig(RTCEngine.RTCRtmpConfig rTCRtmpConfig) {
        return -2;
    }

    public int setupRemoteVideo(long j, TextureView textureView) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public int startChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public int stopChannelMediaRelay() {
        return -2;
    }

    public int takeRemoteViewSnapshot(long j) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public int unPublish() {
        return -2;
    }

    /* access modifiers changed from: protected */
    public int updateChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        return -2;
    }
}
