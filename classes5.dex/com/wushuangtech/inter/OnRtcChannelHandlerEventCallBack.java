package com.wushuangtech.inter;

import android.graphics.Bitmap;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;

public interface OnRtcChannelHandlerEventCallBack {
    void OnVideoBufferingStateChanged(long j, int i, long j2);

    void onAudioBufferingStateChanged(long j, int i, long j2);

    void onAudioPublishStateChanged(int i, int i2, int i3);

    void onAudioSubscribeStateChanged(long j, int i, int i2, int i3);

    void onCaptureVideoSize(int i, int i2);

    void onChannelError(int i);

    void onChannelMediaRelayEvent(int i);

    void onChannelMediaRelayStateChanged(int i, int i2);

    void onClientRoleChanged(int i, int i2);

    void onConnectionLost();

    void onConnectionStateChanged(int i, int i2);

    void onFirstRemoteAudioDecoded(long j, int i);

    void onFirstRemoteVideoFrame(long j, int i, int i2, int i3);

    void onJoinChannelSuccess(long j, int i);

    void onLeaveChannel(RtcStats rtcStats);

    void onNetworkQuality(long j, int i, int i2);

    void onRejoinChannelSuccess(long j, int i);

    void onRemoteAudioStateChanged(long j, int i, int i2, int i3);

    void onRemoteAudioStats(RemoteAudioStats remoteAudioStats);

    void onRemoteStreamSubscribeAdvice(long j, int i, int i2);

    void onRemoteVideoStateChanged(long j, int i, int i2, int i3);

    void onRemoteVideoStats(RemoteVideoStats remoteVideoStats);

    void onRequestToken();

    void onRtcStats(RtcStats rtcStats);

    void onStreamMessage(long j, int i, byte[] bArr);

    void onTakeRemoteViewSnapshot(long j, Bitmap bitmap);

    void onTokenPrivilegeWillExpire(String str);

    void onUserJoined(long j, int i);

    void onUserKicked(long j, int i, int i2);

    void onUserOffline(long j, int i);

    void onVideoPublishStateChanged(int i, int i2, int i3);

    void onVideoSubscribeStateChanged(long j, int i, int i2, int i3);
}
