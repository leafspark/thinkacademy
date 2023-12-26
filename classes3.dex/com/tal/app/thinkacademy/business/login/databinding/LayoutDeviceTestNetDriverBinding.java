package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView;
import com.tal.app.thinkacademy.business.login.view.customview.DeviceNetStateProgress;

public final class LayoutDeviceTestNetDriverBinding implements ViewBinding {
    public final View bottomPos;
    public final Group groupNetError;
    public final Group groupNetPass;
    public final ImageView ivNetStateDownload;
    public final ImageView ivNetStateIrc;
    public final ImageView ivNetStateRtc;
    public final ImageView ivNetStateServer;
    public final TextView layoutNetLoading;
    public final TextView layoutNetSuccess;
    public final View lineContent;
    public final DeviceNetStateProgress progressNetState;
    private final ConstraintLayout rootView;
    public final ConstraintLayout topCenter;
    public final View topPos;
    public final TextView tvErrorNext;
    public final TextView tvErrorRetest;
    public final TextView tvNetDownload;
    public final TextView tvNetFail;
    public final TextView tvNetIrc;
    public final TextView tvNetRtc;
    public final TextView tvNetServer;
    public final CountdownTextView tvPassNext;

    private LayoutDeviceTestNetDriverBinding(ConstraintLayout constraintLayout, View view, Group group, Group group2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, View view2, DeviceNetStateProgress deviceNetStateProgress, ConstraintLayout constraintLayout2, View view3, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, CountdownTextView countdownTextView) {
        this.rootView = constraintLayout;
        this.bottomPos = view;
        this.groupNetError = group;
        this.groupNetPass = group2;
        this.ivNetStateDownload = imageView;
        this.ivNetStateIrc = imageView2;
        this.ivNetStateRtc = imageView3;
        this.ivNetStateServer = imageView4;
        this.layoutNetLoading = textView;
        this.layoutNetSuccess = textView2;
        this.lineContent = view2;
        this.progressNetState = deviceNetStateProgress;
        this.topCenter = constraintLayout2;
        this.topPos = view3;
        this.tvErrorNext = textView3;
        this.tvErrorRetest = textView4;
        this.tvNetDownload = textView5;
        this.tvNetFail = textView6;
        this.tvNetIrc = textView7;
        this.tvNetRtc = textView8;
        this.tvNetServer = textView9;
        this.tvPassNext = countdownTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDeviceTestNetDriverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutDeviceTestNetDriverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_device_test_net_driver;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.line_content;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.top_center;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.top_pos;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_net_error;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_net_pass;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestNetDriverBinding bind(android.view.View r25) {
        /*
            r0 = r25
            int r1 = com.tal.app.thinkacademy.business.login.R.id.bottom_pos
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r4 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_net_error
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.Group r5 = (androidx.constraintlayout.widget.Group) r5
            if (r5 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_net_pass
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.Group r6 = (androidx.constraintlayout.widget.Group) r6
            if (r6 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_net_state_download
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_net_state_irc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_net_state_rtc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_net_state_server
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_net_loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_net_success
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.line_content
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r13 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.progress_net_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            com.tal.app.thinkacademy.business.login.view.customview.DeviceNetStateProgress r14 = (com.tal.app.thinkacademy.business.login.view.customview.DeviceNetStateProgress) r14
            if (r14 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.top_center
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.top_pos
            android.view.View r16 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r16 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_error_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_error_retest
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_net_download
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_net_fail
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_net_irc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_net_rtc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_net_server
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00f2
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_pass_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView r24 = (com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView) r24
            if (r24 == 0) goto L_0x00f2
            com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestNetDriverBinding r1 = new com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestNetDriverBinding
            r2 = r1
            r3 = r0
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r1
        L_0x00f2:
            android.content.res.Resources r0 = r25.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestNetDriverBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestNetDriverBinding");
    }
}
