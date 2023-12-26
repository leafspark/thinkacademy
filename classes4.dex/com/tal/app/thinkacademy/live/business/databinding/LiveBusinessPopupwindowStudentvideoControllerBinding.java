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

public final class LiveBusinessPopupwindowStudentvideoControllerBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ImageButton swLiveBusinessStudentvideoController;
    public final ImageButton swLiveBusinessTeacheronlyController;
    public final TextView tvLiveBusinessStudentTeacherOnly;
    public final TextView tvLiveBusinessStudentWindow;
    public final View vLiveBusinessStudentTeacherOnlyDivider;

    private LiveBusinessPopupwindowStudentvideoControllerBinding(ConstraintLayout constraintLayout, ImageButton imageButton, ImageButton imageButton2, TextView textView, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.swLiveBusinessStudentvideoController = imageButton;
        this.swLiveBusinessTeacheronlyController = imageButton2;
        this.tvLiveBusinessStudentTeacherOnly = textView;
        this.tvLiveBusinessStudentWindow = textView2;
        this.vLiveBusinessStudentTeacherOnlyDivider = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPopupwindowStudentvideoControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPopupwindowStudentvideoControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_popupwindow_studentvideo_controller;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_student_teacher_only_divider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowStudentvideoControllerBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.sw_live_business_studentvideo_controller
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
            if (r4 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.live.business.R.id.sw_live_business_teacheronly_controller
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
            if (r5 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_student_teacher_only
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_student_window
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_student_teacher_only_divider
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r8 == 0) goto L_0x003e
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowStudentvideoControllerBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowStudentvideoControllerBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003e:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowStudentvideoControllerBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowStudentvideoControllerBinding");
    }
}
