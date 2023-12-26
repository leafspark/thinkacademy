package com.tal.app.thinkacademy.live.business.collectivespeech.driver;

import com.tal.app.thinkacademy.lib.network.javacallback.OmyCallback;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.live.business.interactivegames.bean.RandomSpeechStudent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/tal/app/thinkacademy/live/business/collectivespeech/driver/BaseSpeechPluginDriver$whoCanSpeak$1$1", "Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "Lcom/tal/app/thinkacademy/lib/restful/HiResponse;", "Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/RandomSpeechStudent;", "onSuccess", "", "response", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSpeechPluginDriver.kt */
public final class BaseSpeechPluginDriver$whoCanSpeak$1$1 extends OmyCallback<HiResponse<RandomSpeechStudent>> {
    final /* synthetic */ BaseSpeechPluginDriver this$0;

    BaseSpeechPluginDriver$whoCanSpeak$1$1(BaseSpeechPluginDriver baseSpeechPluginDriver) {
        this.this$0 = baseSpeechPluginDriver;
    }

    public void onSuccess(HiResponse<RandomSpeechStudent> hiResponse) {
        Intrinsics.checkNotNullParameter(hiResponse, "response");
        this.this$0.updateGroupAudio(true);
        BaseSpeechPluginDriver baseSpeechPluginDriver = this.this$0;
        RandomSpeechStudent data = hiResponse.getData();
        baseSpeechPluginDriver.mOtherStudents = data == null ? null : data.getList();
        ArrayList access$getMOtherStudents$p = this.this$0.mOtherStudents;
        if (access$getMOtherStudents$p != null) {
            BaseSpeechPluginDriver baseSpeechPluginDriver2 = this.this$0;
            int i = 0;
            for (Object next : access$getMOtherStudents$p) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                baseSpeechPluginDriver2.playingAudioStart(((Number) next).longValue());
                i = i2;
            }
        }
    }
}
