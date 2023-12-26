package com.wushuangtech.inter;

import android.graphics.Bitmap;
import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;

public interface OnRtcGlobalServerMessageCallBack {
    void OnGlobalChannelSessionId(String str, String str2);

    void OnGlobalConnectIdReport(String str);

    void OnGlobalRecvAudioMsg(String str, long j, int i, byte[] bArr);

    void onGlobalAudioBufferingStateChanged(String str, long j, int i, long j2);

    void onGlobalAudioVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i);

    void onGlobalCaptureVideoSize(int i, int i2);

    void onGlobalChannelMediaRelayEvent(String str, int i);

    void onGlobalChannelMediaRelayStateChanged(String str, int i, int i2);

    void onGlobalChannelOnError(int i);

    void onGlobalChannelRefreshToken(String str, String str2, int i, int i2, int i3);

    void onGlobalConnectionStateChanged(String str, int i, int i2);

    void onGlobalFirstRemoteAudioDecoded(String str, long j, int i);

    void onGlobalFirstRemoteAudioFrame(String str, long j, int i);

    void onGlobalFirstRemoteVideoDecoded(String str, long j, String str2, int i, int i2, int i3);

    void onGlobalFirstRemoteVideoFrame(String str, long j, String str2, int i, int i2, int i3);

    void onGlobalLocalAudioStats(LocalAudioStats localAudioStats);

    void onGlobalLocalVideoStats(LocalVideoStats localVideoStats);

    void onGlobalNetworkQualityEvent(String str, long j, int i, int i2);

    void onGlobalRejoin(String str, int i);

    void onGlobalRemoteAudioStateChanged(String str, long j, int i, int i2, int i3);

    void onGlobalRemoteAudioStats(String str, long j, RemoteAudioStats remoteAudioStats);

    void onGlobalRemoteStreamSubscribeAdvice(String str, long j, int i, int i2);

    void onGlobalRemoteTakeSnapshot(String str, long j, Bitmap bitmap);

    void onGlobalRemoteVideoStateChanged(String str, long j, int i, int i2, int i3);

    void onGlobalRemoteVideoStats(String str, long j, RemoteVideoStats remoteVideoStats);

    void onGlobalRtcStats(RtcStats rtcStats);

    void onGlobalUserRoleChanged(String str, long j, int i);

    void onGlobalVideoSubscribeStateChanged(String str, long j, int i, int i2, int i3);
}
