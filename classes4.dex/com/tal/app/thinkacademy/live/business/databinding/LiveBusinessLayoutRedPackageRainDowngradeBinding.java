package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessLayoutRedPackageRainDowngradeBinding implements ViewBinding {
    public final ConstraintLayout clLoading;
    public final ConstraintLayout clTip;
    public final ImageView ivRainPackageRainBg;
    public final ImageView ivTip;
    public final LottieAnimationView lottieLoading;
    private final ConstraintLayout rootView;
    public final TextView tvDeviceLowAlert;
    public final TextView tvGetCoin;
    public final TextView tvLoading;

    private LiveBusinessLayoutRedPackageRainDowngradeBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clLoading = constraintLayout2;
        this.clTip = constraintLayout3;
        this.ivRainPackageRainBg = imageView;
        this.ivTip = imageView2;
        this.lottieLoading = lottieAnimationView;
        this.tvDeviceLowAlert = textView;
        this.tvGetCoin = textView2;
        this.tvLoading = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLayoutRedPackageRainDowngradeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLayoutRedPackageRainDowngradeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_layout_red_package_rain_downgrade;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.cl_tip;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_loading;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainDowngradeBinding bind(android.view.View r12) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.cl_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.cl_tip
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_rain_package_rain_bg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_tip
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            com.airbnb.lottie.LottieAnimationView r8 = (com.airbnb.lottie.LottieAnimationView) r8
            if (r8 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_device_low_alert
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_get_coin
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0062
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainDowngradeBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainDowngradeBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0062:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainDowngradeBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainDowngradeBinding");
    }
}
