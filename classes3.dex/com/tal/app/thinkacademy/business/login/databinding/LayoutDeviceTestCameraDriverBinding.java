package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView;

public final class LayoutDeviceTestCameraDriverBinding implements ViewBinding {
    public final View bottomPos;
    public final Group groupCameraPreview;
    public final Group groupCameraState;
    public final ImageView ivCameraState;
    public final FrameLayout layoutCameraContainer;
    public final TextView layoutCameraState;
    public final View lineContent;
    private final ConstraintLayout rootView;
    public final View topPos;
    public final TextView tvCameraMsg;
    public final CountdownTextView tvCameraPassNext;
    public final TextView tvCameraPreviewTitle;
    public final TextView tvCameraResultNo;
    public final TextView tvCameraResultYes;
    public final TextView tvErrorNext;
    public final TextView tvErrorRetest;

    private LayoutDeviceTestCameraDriverBinding(ConstraintLayout constraintLayout, View view, Group group, Group group2, ImageView imageView, FrameLayout frameLayout, TextView textView, View view2, View view3, TextView textView2, CountdownTextView countdownTextView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.bottomPos = view;
        this.groupCameraPreview = group;
        this.groupCameraState = group2;
        this.ivCameraState = imageView;
        this.layoutCameraContainer = frameLayout;
        this.layoutCameraState = textView;
        this.lineContent = view2;
        this.topPos = view3;
        this.tvCameraMsg = textView2;
        this.tvCameraPassNext = countdownTextView;
        this.tvCameraPreviewTitle = textView3;
        this.tvCameraResultNo = textView4;
        this.tvCameraResultYes = textView5;
        this.tvErrorNext = textView6;
        this.tvErrorRetest = textView7;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDeviceTestCameraDriverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutDeviceTestCameraDriverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_device_test_camera_driver;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.line_content;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.top_pos;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_camera_preview;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_camera_state;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestCameraDriverBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.tal.app.thinkacademy.business.login.R.id.bottom_pos
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r4 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_camera_preview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.Group r5 = (androidx.constraintlayout.widget.Group) r5
            if (r5 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_camera_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.Group r6 = (androidx.constraintlayout.widget.Group) r6
            if (r6 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_camera_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_camera_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            if (r8 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_camera_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.line_content
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.top_pos
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r11 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_camera_msg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_camera_pass_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView r13 = (com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView) r13
            if (r13 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_camera_preview_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_camera_result_no
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_camera_result_yes
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_error_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_error_retest
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00ab
            com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestCameraDriverBinding r1 = new com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestCameraDriverBinding
            r2 = r1
            r3 = r0
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        L_0x00ab:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestCameraDriverBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestCameraDriverBinding");
    }
}
