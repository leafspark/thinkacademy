package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;

public final class LayoutDeviceTestResultDriverBinding implements ViewBinding {
    public final View bottomPos;
    public final ImageView ivResultState;
    private final ConstraintLayout rootView;
    public final View topPos;
    public final TextView tvBack;
    public final TextView tvResultHint;
    public final TextView tvResultMsg;

    private LayoutDeviceTestResultDriverBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, View view2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.bottomPos = view;
        this.ivResultState = imageView;
        this.topPos = view2;
        this.tvBack = textView;
        this.tvResultHint = textView2;
        this.tvResultMsg = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDeviceTestResultDriverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutDeviceTestResultDriverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_device_test_result_driver;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.top_pos;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestResultDriverBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.business.login.R.id.bottom_pos
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r3 == 0) goto L_0x0046
            int r0 = com.tal.app.thinkacademy.business.login.R.id.iv_result_state
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0046
            int r0 = com.tal.app.thinkacademy.business.login.R.id.top_pos
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r5 == 0) goto L_0x0046
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_back
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0046
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_result_hint
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0046
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_result_msg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0046
            com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestResultDriverBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestResultDriverBinding
            r2 = r9
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0046:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestResultDriverBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestResultDriverBinding");
    }
}
