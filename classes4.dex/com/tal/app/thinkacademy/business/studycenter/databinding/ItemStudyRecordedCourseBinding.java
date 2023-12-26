package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.widget.TagTextView;

public final class ItemStudyRecordedCourseBinding implements ViewBinding {
    public final ImageView ivItemStudyTeacherOne;
    public final ImageView ivItemStudyTeacherPhotoFive;
    public final ImageView ivItemStudyTeacherPhotoFour;
    public final ImageView ivItemStudyTeacherPhotoOne;
    public final ImageView ivItemStudyTeacherPhotoThree;
    public final ImageView ivItemStudyTeacherPhotoTwo;
    public final ImageView ivItemStudyTeacherTwo;
    public final ImageView ivStudyItemTagExpired;
    public final LinearLayout layoutItemManyTeachers;
    public final ConstraintLayout layoutItemStudyTeacherTwo;
    public final LinearLayout layoutItemTwoTeachers;
    public final RoundLinearLayout llItemStudyStatus;
    private final LinearLayout rootView;
    public final TextView tvItemStudyCourseDuration;
    public final TagTextView tvItemStudyCourseName;
    public final TextView tvItemStudyTeacherNameOne;
    public final TextView tvItemStudyTeacherNameTwo;
    public final RoundTextView tvItemStudyTeacherTitleOne;
    public final RoundTextView tvItemStudyTeacherTitleTwo;
    public final TextView tvTimeOne;
    public final TextView tvTimeTwo;

    private ItemStudyRecordedCourseBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, LinearLayout linearLayout2, ConstraintLayout constraintLayout, LinearLayout linearLayout3, RoundLinearLayout roundLinearLayout, TextView textView, TagTextView tagTextView, TextView textView2, TextView textView3, RoundTextView roundTextView, RoundTextView roundTextView2, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.ivItemStudyTeacherOne = imageView;
        this.ivItemStudyTeacherPhotoFive = imageView2;
        this.ivItemStudyTeacherPhotoFour = imageView3;
        this.ivItemStudyTeacherPhotoOne = imageView4;
        this.ivItemStudyTeacherPhotoThree = imageView5;
        this.ivItemStudyTeacherPhotoTwo = imageView6;
        this.ivItemStudyTeacherTwo = imageView7;
        this.ivStudyItemTagExpired = imageView8;
        this.layoutItemManyTeachers = linearLayout2;
        this.layoutItemStudyTeacherTwo = constraintLayout;
        this.layoutItemTwoTeachers = linearLayout3;
        this.llItemStudyStatus = roundLinearLayout;
        this.tvItemStudyCourseDuration = textView;
        this.tvItemStudyCourseName = tagTextView;
        this.tvItemStudyTeacherNameOne = textView2;
        this.tvItemStudyTeacherNameTwo = textView3;
        this.tvItemStudyTeacherTitleOne = roundTextView;
        this.tvItemStudyTeacherTitleTwo = roundTextView2;
        this.tvTimeOne = textView4;
        this.tvTimeTwo = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemStudyRecordedCourseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemStudyRecordedCourseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_study_recorded_course;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_item_study_teacher_two;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ll_item_study_status;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_title_one;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_title_two;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyRecordedCourseBinding bind(android.view.View r25) {
        /*
            r0 = r25
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_one
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_five
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_four
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_one
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_three
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_two
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_two
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_study_item_tag_expired
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_item_many_teachers
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_item_study_teacher_two
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_item_two_teachers
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            if (r15 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ll_item_study_status
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.flyco.roundview.RoundLinearLayout r16 = (com.flyco.roundview.RoundLinearLayout) r16
            if (r16 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_course_duration
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_course_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.tal.app.thinkacademy.lib.commui.widget.TagTextView r18 = (com.tal.app.thinkacademy.lib.commui.widget.TagTextView) r18
            if (r18 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_name_one
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_name_two
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_title_one
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            com.flyco.roundview.RoundTextView r21 = (com.flyco.roundview.RoundTextView) r21
            if (r21 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_title_two
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            com.flyco.roundview.RoundTextView r22 = (com.flyco.roundview.RoundTextView) r22
            if (r22 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTimeOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTimeTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x00f1
            com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyRecordedCourseBinding r1 = new com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyRecordedCourseBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r1
        L_0x00f1:
            android.content.res.Resources r0 = r25.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyRecordedCourseBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyRecordedCourseBinding");
    }
}
