package com.tal.app.thinkacademy.live.business.teachercameup.driver;

import com.tal.app.thinkacademy.lib.player.rtcplayer.SimpleRtcPlayerEngineEventListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/live/business/teachercameup/driver/TeacherCameUpPluginDriver$initEngine$1", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/SimpleRtcPlayerEngineEventListener;", "reportAudioVolumeOfSpeaker", "", "uid", "", "volume", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherCameUpPluginDriver.kt */
public final class TeacherCameUpPluginDriver$initEngine$1 extends SimpleRtcPlayerEngineEventListener {
    final /* synthetic */ TeacherCameUpPluginDriver this$0;

    TeacherCameUpPluginDriver$initEngine$1(TeacherCameUpPluginDriver teacherCameUpPluginDriver) {
        this.this$0 = teacherCameUpPluginDriver;
    }

    public void reportAudioVolumeOfSpeaker(long j, int i) {
        super.reportAudioVolumeOfSpeaker(j, i);
        if (j == this.this$0.mAudioId) {
            this.this$0.mAudioVolume = i;
            if (this.this$0.mIsOpenMic) {
                this.this$0.updateMic();
            }
        }
    }
}
