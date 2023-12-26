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
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.widget.TagTextView;

public final class ItemStudyCourseBinding implements ViewBinding {
    public final ImageView ivItemStudyRefund;
    public final ImageView ivItemStudyTeacherOne;
    public final ImageView ivItemStudyTeacherPhotoFive;
    public final ImageView ivItemStudyTeacherPhotoFour;
    public final ImageView ivItemStudyTeacherPhotoOne;
    public final ImageView ivItemStudyTeacherPhotoThree;
    public final ImageView ivItemStudyTeacherPhotoTwo;
    public final ImageView ivItemStudyTeacherTwo;
    public final ImageView ivStudyItemTagNew;
    public final LinearLayout layoutItemManyTeachers;
    public final ConstraintLayout layoutItemStudyTeacherTwo;
    public final LinearLayout layoutItemTwoTeachers;
    public final RoundRelativeLayout llItemStudyStatus;
    private final LinearLayout rootView;
    public final TextView tvItemStudyCourseDuration;
    public final TagTextView tvItemStudyCourseName;
    public final TextView tvItemStudyCourseTime;
    public final TextView tvItemStudyCourseType;
    public final TextView tvItemStudyNextClass;
    public final TextView tvItemStudyStartClassOrder;
    public final TextView tvItemStudyTeacherNameOne;
    public final TextView tvItemStudyTeacherNameTwo;
    public final RoundTextView tvItemStudyTeacherTitleOne;
    public final RoundTextView tvItemStudyTeacherTitleTwo;

    private ItemStudyCourseBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, LinearLayout linearLayout2, ConstraintLayout constraintLayout, LinearLayout linearLayout3, RoundRelativeLayout roundRelativeLayout, TextView textView, TagTextView tagTextView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, RoundTextView roundTextView, RoundTextView roundTextView2) {
        this.rootView = linearLayout;
        this.ivItemStudyRefund = imageView;
        this.ivItemStudyTeacherOne = imageView2;
        this.ivItemStudyTeacherPhotoFive = imageView3;
        this.ivItemStudyTeacherPhotoFour = imageView4;
        this.ivItemStudyTeacherPhotoOne = imageView5;
        this.ivItemStudyTeacherPhotoThree = imageView6;
        this.ivItemStudyTeacherPhotoTwo = imageView7;
        this.ivItemStudyTeacherTwo = imageView8;
        this.ivStudyItemTagNew = imageView9;
        this.layoutItemManyTeachers = linearLayout2;
        this.layoutItemStudyTeacherTwo = constraintLayout;
        this.layoutItemTwoTeachers = linearLayout3;
        this.llItemStudyStatus = roundRelativeLayout;
        this.tvItemStudyCourseDuration = textView;
        this.tvItemStudyCourseName = tagTextView;
        this.tvItemStudyCourseTime = textView2;
        this.tvItemStudyCourseType = textView3;
        this.tvItemStudyNextClass = textView4;
        this.tvItemStudyStartClassOrder = textView5;
        this.tvItemStudyTeacherNameOne = textView6;
        this.tvItemStudyTeacherNameTwo = textView7;
        this.tvItemStudyTeacherTitleOne = roundTextView;
        this.tvItemStudyTeacherTitleTwo = roundTextView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemStudyCourseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemStudyCourseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_study_course;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_item_study_teacher_two;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ll_item_study_status;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f3, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_title_one;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ff, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_title_two;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyCourseBinding bind(android.view.View r28) {
        /*
            r0 = r28
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_refund
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_one
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_five
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_four
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_one
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_three
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_two
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_two
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_study_item_tag_new
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_item_many_teachers
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_item_study_teacher_two
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_item_two_teachers
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ll_item_study_status
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.flyco.roundview.RoundRelativeLayout r17 = (com.flyco.roundview.RoundRelativeLayout) r17
            if (r17 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_course_duration
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_course_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            com.tal.app.thinkacademy.lib.commui.widget.TagTextView r19 = (com.tal.app.thinkacademy.lib.commui.widget.TagTextView) r19
            if (r19 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_course_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_course_type
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_next_class
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_start_class_order
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_name_one
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_name_two
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_title_one
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            com.flyco.roundview.RoundTextView r26 = (com.flyco.roundview.RoundTextView) r26
            if (r26 == 0) goto L_0x0115
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_item_study_teacher_title_two
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            com.flyco.roundview.RoundTextView r27 = (com.flyco.roundview.RoundTextView) r27
            if (r27 == 0) goto L_0x0115
            com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyCourseBinding r1 = new com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyCourseBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x0115:
            android.content.res.Resources r0 = r28.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyCourseBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ItemStudyCourseBinding");
    }
}
