package com.tal.app.thinkacademy.lib.player.rtcplayer;

import com.eaydu.omni.RTCEngine;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayEventListener;", "", "onAudioTeacherJointRoom", "", "onConnectionFaild", "onNeterror", "onPadTeacherleaveRoom", "onPlayFaild", "onRemotefirstVideoRecvWithUid", "onRtcConnected", "onRtcStats", "stats", "Lcom/eaydu/omni/RTCEngine$ReportRtcStats;", "onVideoPlaySuceess", "onVideoTeacherLeaveRoom", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcPlayEventListener.kt */
public interface RtcPlayEventListener {
    void onAudioTeacherJointRoom();

    void onConnectionFaild();

    void onNeterror();

    void onPadTeacherleaveRoom();

    void onPlayFaild();

    void onRemotefirstVideoRecvWithUid();

    void onRtcConnected();

    void onRtcStats(RTCEngine.ReportRtcStats reportRtcStats);

    void onVideoPlaySuceess();

    void onVideoTeacherLeaveRoom();
}
