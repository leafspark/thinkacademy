package com.tal.app.thinkacademy.live.business.collectivespeech.driver;

import com.tal.app.thinkacademy.lib.player.rtcplayer.SimpleRtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.live.business.collectivespeech.view.CollectiveSpeechView;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/live/business/collectivespeech/driver/BaseSpeechPluginDriver$initEngine$2", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/SimpleRtcPlayerEngineEventListener;", "reportAudioVolumeOfSpeaker", "", "uid", "", "volume", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSpeechPluginDriver.kt */
public final class BaseSpeechPluginDriver$initEngine$2 extends SimpleRtcPlayerEngineEventListener {
    final /* synthetic */ BaseSpeechPluginDriver this$0;

    BaseSpeechPluginDriver$initEngine$2(BaseSpeechPluginDriver baseSpeechPluginDriver) {
        this.this$0 = baseSpeechPluginDriver;
    }

    public void reportAudioVolumeOfSpeaker(long j, int i) {
        super.reportAudioVolumeOfSpeaker(j, i);
        if (Intrinsics.areEqual(String.valueOf(j), EnterRoomMuteData.STATUS_UN_MUTE)) {
            if (!this.this$0.isTimeOut && this.this$0.mMaxVolume < i) {
                this.this$0.mMaxVolume = i;
            }
            if (!this.this$0.isHadSentIt && i > 0) {
                this.this$0.isHadSentIt = true;
                this.this$0.submitStartSpeech();
            }
            CollectiveSpeechView access$getMCollectiveSpeechView$p = this.this$0.mCollectiveSpeechView;
            if (access$getMCollectiveSpeechView$p != null) {
                access$getMCollectiveSpeechView$p.updateVolume(i);
            }
        }
    }
}
