package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import android.view.View;
import android.widget.ImageView;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.study.study.entity.LessonDetails;

public final /* synthetic */ class CalendarAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ LessonDetails f$0;
    public final /* synthetic */ CalendarAdapter f$1;
    public final /* synthetic */ RoundLinearLayout f$2;
    public final /* synthetic */ ImageView f$3;

    public /* synthetic */ CalendarAdapter$$ExternalSyntheticLambda0(LessonDetails lessonDetails, CalendarAdapter calendarAdapter, RoundLinearLayout roundLinearLayout, ImageView imageView) {
        this.f$0 = lessonDetails;
        this.f$1 = calendarAdapter;
        this.f$2 = roundLinearLayout;
        this.f$3 = imageView;
    }

    public final void onClick(View view) {
        CalendarAdapter.m490showLessonItem$lambda4$lambda2(this.f$0, this.f$1, this.f$2, this.f$3, view);
    }
}
