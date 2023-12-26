package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import android.view.View;
import android.widget.ImageView;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.study.study.entity.RecordLesson;

public final /* synthetic */ class RecordedCalendarAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ RecordLesson f$0;
    public final /* synthetic */ RecordedCalendarAdapter f$1;
    public final /* synthetic */ RoundLinearLayout f$2;
    public final /* synthetic */ ImageView f$3;

    public /* synthetic */ RecordedCalendarAdapter$$ExternalSyntheticLambda0(RecordLesson recordLesson, RecordedCalendarAdapter recordedCalendarAdapter, RoundLinearLayout roundLinearLayout, ImageView imageView) {
        this.f$0 = recordLesson;
        this.f$1 = recordedCalendarAdapter;
        this.f$2 = roundLinearLayout;
        this.f$3 = imageView;
    }

    public final void onClick(View view) {
        RecordedCalendarAdapter.m491convert$lambda1$lambda0(this.f$0, this.f$1, this.f$2, this.f$3, view);
    }
}
