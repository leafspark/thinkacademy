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

public final class ItemPlanListLessonBinding implements ViewBinding {
    public final ImageView ivAssignment;
    public final ImageView ivAssignmentStateNameFinished;
    public final ImageView ivExam;
    public final ImageView ivMaterials;
    public final ImageView ivPreQuestionFinished;
    public final ImageView ivPreTest;
    public final ImageView ivSpeakerState;
    public final ImageView ivSpeakerUnfold;
    public final LinearLayout llPreQuestion;
    public final LinearLayout llSpeaker;
    public final LinearLayout lyAssignment;
    public final LinearLayout lyExam;
    public final LinearLayout lyMaterials;
    public final RoundLinearLayout rlSpeakerState;
    private final LinearLayout rootView;
    public final RoundTextView tvAssignmentStateName;
    public final TextView tvAssignmentStateNameGray;
    public final TextView tvAssignmentStateTime;
    public final TextView tvAssignmentTitle;
    public final RoundTextView tvDoPretest;
    public final RoundTextView tvExamButton;
    public final TextView tvExamReportTime;
    public final TextView tvExamTitle;
    public final TextView tvLessonReport;
    public final TextView tvLessonType;
    public final RoundTextView tvMaterialsButton;
    public final TextView tvMaterialsTitle;
    public final TextView tvPreQuestionEndTime;
    public final TextView tvPreQuestionGray;
    public final TextView tvPreQuestionName;
    public final TextView tvSpeakerOrder;
    public final RoundTextView tvSpeakerParentEnter;
    public final RoundTextView tvSpeakerStateName;
    public final TextView tvSpeakerStateNameEnter;
    public final TextView tvSpeakerStateNameGray;
    public final TextView tvSpeakerStateTime;
    public final TextView tvSpeakerStateTitle;
    public final TextView tvSpeakerTitle;

    private ItemPlanListLessonBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, RoundLinearLayout roundLinearLayout, RoundTextView roundTextView, TextView textView, TextView textView2, TextView textView3, RoundTextView roundTextView2, RoundTextView roundTextView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RoundTextView roundTextView4, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, RoundTextView roundTextView5, RoundTextView roundTextView6, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17) {
        this.rootView = linearLayout;
        this.ivAssignment = imageView;
        this.ivAssignmentStateNameFinished = imageView2;
        this.ivExam = imageView3;
        this.ivMaterials = imageView4;
        this.ivPreQuestionFinished = imageView5;
        this.ivPreTest = imageView6;
        this.ivSpeakerState = imageView7;
        this.ivSpeakerUnfold = imageView8;
        this.llPreQuestion = linearLayout2;
        this.llSpeaker = linearLayout3;
        this.lyAssignment = linearLayout4;
        this.lyExam = linearLayout5;
        this.lyMaterials = linearLayout6;
        this.rlSpeakerState = roundLinearLayout;
        this.tvAssignmentStateName = roundTextView;
        this.tvAssignmentStateNameGray = textView;
        this.tvAssignmentStateTime = textView2;
        this.tvAssignmentTitle = textView3;
        this.tvDoPretest = roundTextView2;
        this.tvExamButton = roundTextView3;
        this.tvExamReportTime = textView4;
        this.tvExamTitle = textView5;
        this.tvLessonReport = textView6;
        this.tvLessonType = textView7;
        this.tvMaterialsButton = roundTextView4;
        this.tvMaterialsTitle = textView8;
        this.tvPreQuestionEndTime = textView9;
        this.tvPreQuestionGray = textView10;
        this.tvPreQuestionName = textView11;
        this.tvSpeakerOrder = textView12;
        this.tvSpeakerParentEnter = roundTextView5;
        this.tvSpeakerStateName = roundTextView6;
        this.tvSpeakerStateNameEnter = textView13;
        this.tvSpeakerStateNameGray = textView14;
        this.tvSpeakerStateTime = textView15;
        this.tvSpeakerStateTitle = textView16;
        this.tvSpeakerTitle = textView17;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemPlanListLessonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemPlanListLessonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_plan_list_lesson;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.rlSpeakerState;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvAssignmentStateName;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cf, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDoPretest;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00db, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamButton;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0117, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvMaterialsButton;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x015f, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerParentEnter;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x016b, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerStateName;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ItemPlanListLessonBinding bind(android.view.View r42) {
        /*
            r0 = r42
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivAssignment
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivAssignmentStateNameFinished
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivExam
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivMaterials
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivPreQuestionFinished
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivPreTest
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivSpeakerState
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivSpeakerUnfold
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.llPreQuestion
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.llSpeaker
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.lyAssignment
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            if (r15 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.lyExam
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.lyMaterials
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.LinearLayout r17 = (android.widget.LinearLayout) r17
            if (r17 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.rlSpeakerState
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.flyco.roundview.RoundLinearLayout r18 = (com.flyco.roundview.RoundLinearLayout) r18
            if (r18 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvAssignmentStateName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            com.flyco.roundview.RoundTextView r19 = (com.flyco.roundview.RoundTextView) r19
            if (r19 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvAssignmentStateNameGray
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvAssignmentStateTime
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvAssignmentTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDoPretest
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            com.flyco.roundview.RoundTextView r23 = (com.flyco.roundview.RoundTextView) r23
            if (r23 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            com.flyco.roundview.RoundTextView r24 = (com.flyco.roundview.RoundTextView) r24
            if (r24 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamReportTime
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonReport
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvMaterialsButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            com.flyco.roundview.RoundTextView r29 = (com.flyco.roundview.RoundTextView) r29
            if (r29 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvMaterialsTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.TextView r30 = (android.widget.TextView) r30
            if (r30 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvPreQuestionEndTime
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            android.widget.TextView r31 = (android.widget.TextView) r31
            if (r31 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvPreQuestionGray
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            android.widget.TextView r32 = (android.widget.TextView) r32
            if (r32 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvPreQuestionName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r33 = r2
            android.widget.TextView r33 = (android.widget.TextView) r33
            if (r33 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerOrder
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r34 = r2
            android.widget.TextView r34 = (android.widget.TextView) r34
            if (r34 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerParentEnter
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r35 = r2
            com.flyco.roundview.RoundTextView r35 = (com.flyco.roundview.RoundTextView) r35
            if (r35 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerStateName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r36 = r2
            com.flyco.roundview.RoundTextView r36 = (com.flyco.roundview.RoundTextView) r36
            if (r36 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerStateNameEnter
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r37 = r2
            android.widget.TextView r37 = (android.widget.TextView) r37
            if (r37 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerStateNameGray
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r38 = r2
            android.widget.TextView r38 = (android.widget.TextView) r38
            if (r38 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerStateTime
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r39 = r2
            android.widget.TextView r39 = (android.widget.TextView) r39
            if (r39 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerStateTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r40 = r2
            android.widget.TextView r40 = (android.widget.TextView) r40
            if (r40 == 0) goto L_0x01bd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r41 = r2
            android.widget.TextView r41 = (android.widget.TextView) r41
            if (r41 == 0) goto L_0x01bd
            com.tal.app.thinkacademy.business.studycenter.databinding.ItemPlanListLessonBinding r1 = new com.tal.app.thinkacademy.business.studycenter.databinding.ItemPlanListLessonBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            return r1
        L_0x01bd:
            android.content.res.Resources r0 = r42.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ItemPlanListLessonBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ItemPlanListLessonBinding");
    }
}
