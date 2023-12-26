package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import android.os.Bundle;
import com.tal.app.thinkacademy.business.study.study.StudyTrack;
import com.tal.app.thinkacademy.business.study.study.entity.LessonDetails;
import com.tal.app.thinkacademy.business.study.study.entity.Performance;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CalendarAdapter.kt */
final class CalendarAdapter$showLessonItem$1$11 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LessonDetails $this_run;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CalendarAdapter$showLessonItem$1$11(LessonDetails lessonDetails) {
        super(0);
        this.$this_run = lessonDetails;
    }

    public final void invoke() {
        HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
        String planId = this.$this_run.getPlanId();
        if (planId == null) {
            planId = "";
        }
        hWEventTracking.ostaClassReport(planId);
        StudyTrack.INSTANCE.classReportClick(this.$this_run.getPlanId());
        Bundle bundle = new Bundle();
        Performance performance = this.$this_run.getPerformance();
        bundle.putString("jump_key", performance == null ? null : performance.getUrl());
        bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).build());
        XesRoute.getInstance().navigation("/commui/browser_activity", bundle);
    }
}
