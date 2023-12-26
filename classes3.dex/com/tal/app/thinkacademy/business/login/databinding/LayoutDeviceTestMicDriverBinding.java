package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView;
import com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView;
import com.tal.app.thinkcademy.lib.commui.widget.StateImageView;

public final class LayoutDeviceTestMicDriverBinding implements ViewBinding {
    public final View bottomPos;
    public final Group groupMicInput;
    public final Group groupMicState;
    public final StateImageView ivMicState;
    public final TextView layoutMicState;
    public final View lineContent;
    private final ConstraintLayout rootView;
    public final View topPos;
    public final TextView tvErrorNext;
    public final TextView tvErrorRetest;
    public final TextView tvInputHint;
    public final TextView tvMicMsg;
    public final CountdownTextView tvMicPassNext;
    public final CircleProgressView viewInputProgress;

    private LayoutDeviceTestMicDriverBinding(ConstraintLayout constraintLayout, View view, Group group, Group group2, StateImageView stateImageView, TextView textView, View view2, View view3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, CountdownTextView countdownTextView, CircleProgressView circleProgressView) {
        this.rootView = constraintLayout;
        this.bottomPos = view;
        this.groupMicInput = group;
        this.groupMicState = group2;
        this.ivMicState = stateImageView;
        this.layoutMicState = textView;
        this.lineContent = view2;
        this.topPos = view3;
        this.tvErrorNext = textView2;
        this.tvErrorRetest = textView3;
        this.tvInputHint = textView4;
        this.tvMicMsg = textView5;
        this.tvMicPassNext = countdownTextView;
        this.viewInputProgress = circleProgressView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDeviceTestMicDriverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutDeviceTestMicDriverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_device_test_mic_driver;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.line_content;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.top_pos;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_mic_input;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_mic_state;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestMicDriverBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.tal.app.thinkacademy.business.login.R.id.bottom_pos
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r4 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_mic_input
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.Group r5 = (androidx.constraintlayout.widget.Group) r5
            if (r5 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_mic_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.Group r6 = (androidx.constraintlayout.widget.Group) r6
            if (r6 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_mic_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.tal.app.thinkcademy.lib.commui.widget.StateImageView r7 = (com.tal.app.thinkcademy.lib.commui.widget.StateImageView) r7
            if (r7 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_mic_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.line_content
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.top_pos
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_error_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_error_retest
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_input_hint
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_mic_msg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_mic_pass_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView r15 = (com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView) r15
            if (r15 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.view_input_progress
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView r16 = (com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView) r16
            if (r16 == 0) goto L_0x0093
            com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestMicDriverBinding r1 = new com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestMicDriverBinding
            r3 = r0
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x0093:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestMicDriverBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestMicDriverBinding");
    }
}
