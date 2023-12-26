package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessPopupwindowSmallPadControllerBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ImageButton swLiveBusinessStudentCamera;
    public final TextView tvLiveBusinessFeedback;
    public final TextView tvLiveBusinessStudentCamera;
    public final View vLiveBusinessStudentTeacherOnlyDivider;

    private LiveBusinessPopupwindowSmallPadControllerBinding(ConstraintLayout constraintLayout, ImageButton imageButton, TextView textView, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.swLiveBusinessStudentCamera = imageButton;
        this.tvLiveBusinessFeedback = textView;
        this.tvLiveBusinessStudentCamera = textView2;
        this.vLiveBusinessStudentTeacherOnlyDivider = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPopupwindowSmallPadControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPopupwindowSmallPadControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_popupwindow_small_pad_controller;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_student_teacher_only_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowSmallPadControllerBinding bind(android.view.View r8) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.sw_live_business_student_camera
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
            if (r4 == 0) goto L_0x0033
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_feedback
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0033
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_student_camera
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0033
            int r0 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_student_teacher_only_divider
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r7 == 0) goto L_0x0033
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowSmallPadControllerBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowSmallPadControllerBinding
            r3 = r8
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0033:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowSmallPadControllerBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowSmallPadControllerBinding");
    }
}
