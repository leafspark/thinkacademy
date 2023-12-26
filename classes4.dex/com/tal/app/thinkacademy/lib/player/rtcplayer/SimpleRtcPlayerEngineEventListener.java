package com.tal.app.thinkacademy.lib.player.rtcplayer;

import com.eaydu.omni.listener.RTCConnectionStateType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0014H\u0016¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/rtcplayer/SimpleRtcPlayerEngineEventListener;", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayerEngineEventListener;", "()V", "didAudioMuted", "", "uid", "", "muted", "", "type", "", "didOfflineOfUid", "didVideoMuted", "dispatchConnectionState", "state", "Lcom/eaydu/omni/listener/RTCConnectionStateType;", "reason", "localUserJoindWithUid", "onOnceLastMileQuality", "quality", "", "onRemoteVideoStateChanged", "remoteUserJoinWitnUid", "remotefirstAudioRecvWithUid", "remotefirstVideoRecvWithUid", "reportAudioVolumeOfSpeaker", "volume", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleRtcPlayerEngineEventListener.kt */
public class SimpleRtcPlayerEngineEventListener implements RtcPlayerEngineEventListener {
    public void didAudioMuted(long j, boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void didOfflineOfUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void didVideoMuted(long j, boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void dispatchConnectionState(RTCConnectionStateType rTCConnectionStateType, String str, String str2) {
        Intrinsics.checkNotNullParameter(rTCConnectionStateType, "state");
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "type");
    }

    public void localUserJoindWithUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void onOnceLastMileQuality(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void onRemoteVideoStateChanged(long j, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void remoteUserJoinWitnUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void remotefirstAudioRecvWithUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void remotefirstVideoRecvWithUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void reportAudioVolumeOfSpeaker(long j, int i) {
    }
}
