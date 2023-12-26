package com.tal.app.thinkacademy.lib.player.rtcplayer;

import com.eaydu.omni.listener.RTCConnectionStateType;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0013H&¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayerEngineEventListener;", "", "didAudioMuted", "", "uid", "", "muted", "", "type", "", "didOfflineOfUid", "didVideoMuted", "dispatchConnectionState", "state", "Lcom/eaydu/omni/listener/RTCConnectionStateType;", "reason", "localUserJoindWithUid", "onOnceLastMileQuality", "quality", "", "onRemoteVideoStateChanged", "remoteUserJoinWitnUid", "remotefirstAudioRecvWithUid", "remotefirstVideoRecvWithUid", "reportAudioVolumeOfSpeaker", "volume", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcPlayerEngineEventListener.kt */
public interface RtcPlayerEngineEventListener {
    void didAudioMuted(long j, boolean z, String str);

    void didOfflineOfUid(long j, String str);

    void didVideoMuted(long j, boolean z, String str);

    void dispatchConnectionState(RTCConnectionStateType rTCConnectionStateType, String str, String str2);

    void localUserJoindWithUid(long j, String str);

    void onOnceLastMileQuality(int i, String str);

    void onRemoteVideoStateChanged(long j, int i, String str);

    void remoteUserJoinWitnUid(long j, String str);

    void remotefirstAudioRecvWithUid(long j, String str);

    void remotefirstVideoRecvWithUid(long j, String str);

    void reportAudioVolumeOfSpeaker(long j, int i);
}
