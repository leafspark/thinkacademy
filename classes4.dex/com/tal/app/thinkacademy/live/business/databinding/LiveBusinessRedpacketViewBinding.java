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

public final class LiveBusinessRedpacketViewBinding implements ViewBinding {
    public final ConstraintLayout clLiveBusinessRedpacketOops;
    public final ImageView ivLiveBusinessRedpacketSmall;
    public final ImageView ivLiveBusinessRedpacketWindowClose;
    public final LottieAnimationView lavLiveBusinessRedpacket;
    public final LottieAnimationView lottieRedpacketOops;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessRedpacketOopsCoins;
    public final TextView tvLiveBusinessRedpacketOopsDesc;
    public final TextView tvLiveBusinessRedpacketOopsTitle;
    public final View vLiveBusinessRedpacketBg;

    private LiveBusinessRedpacketViewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = constraintLayout;
        this.clLiveBusinessRedpacketOops = constraintLayout2;
        this.ivLiveBusinessRedpacketSmall = imageView;
        this.ivLiveBusinessRedpacketWindowClose = imageView2;
        this.lavLiveBusinessRedpacket = lottieAnimationView;
        this.lottieRedpacketOops = lottieAnimationView2;
        this.tvLiveBusinessRedpacketOopsCoins = textView;
        this.tvLiveBusinessRedpacketOopsDesc = textView2;
        this.tvLiveBusinessRedpacketOopsTitle = textView3;
        this.vLiveBusinessRedpacketBg = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessRedpacketViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessRedpacketViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_redpacket_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_redpacket_bg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lav_live_business_redpacket;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_redpacket_oops;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessRedpacketViewBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_redpacket_oops
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x006a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_redpacket_small
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x006a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_redpacket_window_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x006a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lav_live_business_redpacket
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            com.airbnb.lottie.LottieAnimationView r7 = (com.airbnb.lottie.LottieAnimationView) r7
            if (r7 == 0) goto L_0x006a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_redpacket_oops
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            com.airbnb.lottie.LottieAnimationView r8 = (com.airbnb.lottie.LottieAnimationView) r8
            if (r8 == 0) goto L_0x006a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_redpacket_oops_coins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x006a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_redpacket_oops_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x006a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_redpacket_oops_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x006a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_redpacket_bg
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r12 == 0) goto L_0x006a
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessRedpacketViewBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessRedpacketViewBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006a:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessRedpacketViewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessRedpacketViewBinding");
    }
}
