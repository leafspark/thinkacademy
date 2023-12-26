package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class StudyItemRecordedCalendarBinding implements ViewBinding {
    public final ImageView ivFinalExam;
    public final ImageView ivRecordedCourse;
    public final ImageView ivSpeakerUnfold;
    public final LinearLayout lyFinalExam;
    public final LinearLayout lyRecordedCourse;
    public final RoundLinearLayout rlSpeakerState;
    private final LinearLayout rootView;
    public final RoundTextView tvFinalExamStateName;
    public final TextView tvFinalExamStateNameGray;
    public final TextView tvFinalExamStateTime;
    public final TextView tvFinalExamTitle;
    public final TextView tvRecordedCourseDuration;
    public final TextView tvRecordedCourseNameGray;
    public final RoundTextView tvRecordedCourseStateName;
    public final TextView tvRecordedCourseTitle;
    public final TextView tvSpeakerOrder;
    public final TextView tvSpeakerTitle;

    private StudyItemRecordedCalendarBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout2, LinearLayout linearLayout3, RoundLinearLayout roundLinearLayout, RoundTextView roundTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RoundTextView roundTextView2, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = linearLayout;
        this.ivFinalExam = imageView;
        this.ivRecordedCourse = imageView2;
        this.ivSpeakerUnfold = imageView3;
        this.lyFinalExam = linearLayout2;
        this.lyRecordedCourse = linearLayout3;
        this.rlSpeakerState = roundLinearLayout;
        this.tvFinalExamStateName = roundTextView;
        this.tvFinalExamStateNameGray = textView;
        this.tvFinalExamStateTime = textView2;
        this.tvFinalExamTitle = textView3;
        this.tvRecordedCourseDuration = textView4;
        this.tvRecordedCourseNameGray = textView5;
        this.tvRecordedCourseStateName = roundTextView2;
        this.tvRecordedCourseTitle = textView6;
        this.tvSpeakerOrder = textView7;
        this.tvSpeakerTitle = textView8;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StudyItemRecordedCalendarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StudyItemRecordedCalendarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.study_item_recorded_calendar;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.rlSpeakerState;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvFinalExamStateName;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvRecordedCourseStateName;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.StudyItemRecordedCalendarBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivFinalExam
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivRecordedCourse
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivSpeakerUnfold
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.lyFinalExam
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.lyRecordedCourse
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.rlSpeakerState
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.flyco.roundview.RoundLinearLayout r10 = (com.flyco.roundview.RoundLinearLayout) r10
            if (r10 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvFinalExamStateName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.flyco.roundview.RoundTextView r11 = (com.flyco.roundview.RoundTextView) r11
            if (r11 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvFinalExamStateNameGray
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvFinalExamStateTime
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvFinalExamTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvRecordedCourseDuration
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvRecordedCourseNameGray
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvRecordedCourseStateName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.flyco.roundview.RoundTextView r17 = (com.flyco.roundview.RoundTextView) r17
            if (r17 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvRecordedCourseTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerOrder
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00c1
            com.tal.app.thinkacademy.business.studycenter.databinding.StudyItemRecordedCalendarBinding r1 = new com.tal.app.thinkacademy.business.studycenter.databinding.StudyItemRecordedCalendarBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x00c1:
            android.content.res.Resources r0 = r21.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.StudyItemRecordedCalendarBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.StudyItemRecordedCalendarBinding");
    }
}
