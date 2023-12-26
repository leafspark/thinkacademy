package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;

public final class LayoutClassItemTeacherBinding implements ViewBinding {
    public final ImageView ivTeacherAvatar1;
    public final ImageView ivTeacherAvatar2;
    public final ImageView ivTeacherAvatarGroup1;
    public final ImageView ivTeacherAvatarGroup2;
    public final ImageView ivTeacherAvatarGroup3;
    public final ImageView ivTeacherAvatarGroup4;
    public final ImageView ivTeacherAvatarGroup5;
    public final ImageView ivTeacherAvatarGroup6;
    public final ConstraintLayout layoutMoreTeacher;
    public final LinearLayout layoutTeacher;
    private final ConstraintLayout rootView;
    public final ConstraintLayout teacherRoot1;
    public final ConstraintLayout teacherRoot2;
    public final TextView tvTeacherName1;
    public final TextView tvTeacherName2;
    public final TextView tvTeacherRole1;
    public final TextView tvTeacherRole2;

    private LayoutClassItemTeacherBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.ivTeacherAvatar1 = imageView;
        this.ivTeacherAvatar2 = imageView2;
        this.ivTeacherAvatarGroup1 = imageView3;
        this.ivTeacherAvatarGroup2 = imageView4;
        this.ivTeacherAvatarGroup3 = imageView5;
        this.ivTeacherAvatarGroup4 = imageView6;
        this.ivTeacherAvatarGroup5 = imageView7;
        this.ivTeacherAvatarGroup6 = imageView8;
        this.layoutMoreTeacher = constraintLayout2;
        this.layoutTeacher = linearLayout;
        this.teacherRoot1 = constraintLayout3;
        this.teacherRoot2 = constraintLayout4;
        this.tvTeacherName1 = textView;
        this.tvTeacherName2 = textView2;
        this.tvTeacherRole1 = textView3;
        this.tvTeacherRole2 = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutClassItemTeacherBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutClassItemTeacherBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_class_item_teacher;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.layout_more_teacher;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.teacher_root_1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.teacher_root_2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.LayoutClassItemTeacherBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.iv_teacher_avatar_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.iv_teacher_avatar_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.iv_teacher_avatar_group_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.iv_teacher_avatar_group_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.iv_teacher_avatar_group_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.iv_teacher_avatar_group_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.iv_teacher_avatar_group_5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.iv_teacher_avatar_group_6
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.layout_more_teacher
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            if (r13 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.layout_teacher
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.teacher_root_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.teacher_root_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.ConstraintLayout r16 = (androidx.constraintlayout.widget.ConstraintLayout) r16
            if (r16 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_teacher_name_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_teacher_name_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_teacher_role_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00c1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tv_teacher_role_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00c1
            com.tal.app.thinkacademy.business.shop.databinding.LayoutClassItemTeacherBinding r1 = new com.tal.app.thinkacademy.business.shop.databinding.LayoutClassItemTeacherBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.LayoutClassItemTeacherBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.LayoutClassItemTeacherBinding");
    }
}
