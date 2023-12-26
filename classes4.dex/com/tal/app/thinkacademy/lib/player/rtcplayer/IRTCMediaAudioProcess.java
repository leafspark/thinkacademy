package com.tal.app.thinkacademy.lib.player.rtcplayer;

import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcAudioData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCMediaAudioProcess;", "", "didCapturedAuidoData", "", "data", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcAudioData;", "didRenderAudioData", "uid", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IRTCMediaAudioProcess.kt */
public interface IRTCMediaAudioProcess {
    void didCapturedAuidoData(RtcAudioData rtcAudioData);

    void didRenderAudioData(long j, RtcAudioData rtcAudioData);
}
