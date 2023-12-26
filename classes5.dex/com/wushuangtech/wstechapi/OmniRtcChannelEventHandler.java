package com.wushuangtech.wstechapi;

import android.graphics.Bitmap;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;

public abstract class OmniRtcChannelEventHandler {
    /* access modifiers changed from: package-private */
    public void OnAudioPublishStateChanged(int i, int i2, int i3) {
    }

    /* access modifiers changed from: package-private */
    public void OnAudioSubscribeStateChanged(long j, int i, int i2, int i3) {
    }

    /* access modifiers changed from: package-private */
    public void OnVideoPublishStateChanged(int i, int i2, int i3) {
    }

    /* access modifiers changed from: package-private */
    public void OnVideoSubscribeStateChanged(long j, int i, int i2, int i3) {
    }

    public void onActiveSpeaker(OmniRtcChannel omniRtcChannel, long j) {
    }

    public void onAudioBufferingStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, long j2) {
    }

    public void onAudioPublishStateChanged(OmniRtcChannel omniRtcChannel, int i, int i2, int i3) {
    }

    public void onAudioSubscribeStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
    }

    public void onCaptureVideoSize(OmniRtcChannel omniRtcChannel, int i, int i2) {
    }

    public void onChannelError(OmniRtcChannel omniRtcChannel, int i) {
    }

    public void onChannelMediaRelayEvent(OmniRtcChannel omniRtcChannel, int i) {
    }

    public void onChannelMediaRelayStateChanged(OmniRtcChannel omniRtcChannel, int i, int i2) {
    }

    public void onChannelWarning(OmniRtcChannel omniRtcChannel, int i) {
    }

    public void onClientRoleChanged(OmniRtcChannel omniRtcChannel, int i, int i2) {
    }

    public void onConnectionLost(OmniRtcChannel omniRtcChannel) {
    }

    public void onConnectionStateChanged(OmniRtcChannel omniRtcChannel, int i, int i2) {
    }

    public void onFirstRemoteAudioDecoded(OmniRtcChannel omniRtcChannel, long j, int i) {
    }

    public void onFirstRemoteVideoFrame(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
    }

    public void onJoinChannelSuccess(OmniRtcChannel omniRtcChannel, long j, int i) {
    }

    public void onLeaveChannel(OmniRtcChannel omniRtcChannel, RtcStats rtcStats) {
    }

    public void onLocalPublishFallbackToAudioOnly(OmniRtcChannel omniRtcChannel, boolean z) {
    }

    public void onNetworkQuality(OmniRtcChannel omniRtcChannel, long j, int i, int i2) {
    }

    public void onRejoinChannelSuccess(OmniRtcChannel omniRtcChannel, long j, int i) {
    }

    public void onRemoteAudioStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
    }

    public void onRemoteAudioStats(OmniRtcChannel omniRtcChannel, RemoteAudioStats remoteAudioStats) {
    }

    public void onRemoteStreamSubscribeAdvice(OmniRtcChannel omniRtcChannel, long j, int i, int i2) {
    }

    public void onRemoteSubscribeFallbackToAudioOnly(OmniRtcChannel omniRtcChannel, long j, boolean z) {
    }

    public void onRemoteVideoStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
    }

    public void onRemoteVideoStats(OmniRtcChannel omniRtcChannel, RemoteVideoStats remoteVideoStats) {
    }

    public void onRequestToken(OmniRtcChannel omniRtcChannel) {
    }

    public void onRtcStats(OmniRtcChannel omniRtcChannel, RtcStats rtcStats) {
    }

    public void onRtmpStreamingEvent(OmniRtcChannel omniRtcChannel, String str, int i) {
    }

    public void onRtmpStreamingStateChanged(OmniRtcChannel omniRtcChannel, String str, int i, int i2) {
    }

    public void onStreamInjectedStatus(OmniRtcChannel omniRtcChannel, String str, long j, int i) {
    }

    public void onStreamMessage(OmniRtcChannel omniRtcChannel, long j, int i, byte[] bArr) {
    }

    public void onStreamMessageError(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3, int i4) {
    }

    public void onTakeLocalViewSnapshot(OmniRtcChannel omniRtcChannel, Bitmap bitmap) {
    }

    public void onTakeRemoteViewSnapshot(OmniRtcChannel omniRtcChannel, long j, Bitmap bitmap) {
    }

    public void onTokenPrivilegeWillExpire(OmniRtcChannel omniRtcChannel, String str) {
    }

    public void onTranscodingUpdated(OmniRtcChannel omniRtcChannel) {
    }

    public void onUserJoined(OmniRtcChannel omniRtcChannel, long j, int i) {
    }

    public void onUserKicked(OmniRtcChannel omniRtcChannel, long j, int i, int i2) {
    }

    public void onUserOffline(OmniRtcChannel omniRtcChannel, long j, int i) {
    }

    public void onVideoBufferingStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, long j2) {
    }

    public void onVideoPublishStateChanged(OmniRtcChannel omniRtcChannel, int i, int i2, int i3) {
    }

    public void onVideoSizeChanged(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
    }

    public void onVideoSubscribeStateChanged(OmniRtcChannel omniRtcChannel, long j, int i, int i2, int i3) {
    }
}
