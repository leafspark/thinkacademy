package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.view.customview.DeviceTestStepTitle;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityDeviceTestBinding implements ViewBinding {
    public final LinearLayout adaptContent;
    public final FrameLayout containerTest;
    public final DeviceTestStepTitle layoutDeviceStep;
    public final LoadStatusView loadStatusView;
    private final LinearLayout rootView;
    public final TitleBar titleBar;

    private ActivityDeviceTestBinding(LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, DeviceTestStepTitle deviceTestStepTitle, LoadStatusView loadStatusView2, TitleBar titleBar2) {
        this.rootView = linearLayout;
        this.adaptContent = linearLayout2;
        this.containerTest = frameLayout;
        this.layoutDeviceStep = deviceTestStepTitle;
        this.loadStatusView = loadStatusView2;
        this.titleBar = titleBar2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDeviceTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityDeviceTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_device_test;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.titleBar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityDeviceTestBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.business.login.R.id.adapt_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.container_test
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.layout_device_step
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            com.tal.app.thinkacademy.business.login.view.customview.DeviceTestStepTitle r6 = (com.tal.app.thinkacademy.business.login.view.customview.DeviceTestStepTitle) r6
            if (r6 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.loadStatusView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r7 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r7
            if (r7 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.titleBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r8 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r8
            if (r8 == 0) goto L_0x0041
            com.tal.app.thinkacademy.business.login.databinding.ActivityDeviceTestBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivityDeviceTestBinding
            r3 = r9
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0041:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityDeviceTestBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityDeviceTestBinding");
    }
}
