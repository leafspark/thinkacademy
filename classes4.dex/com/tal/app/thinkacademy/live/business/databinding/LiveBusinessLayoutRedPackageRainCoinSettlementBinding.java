package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessLayoutRedPackageRainCoinSettlementBinding implements ViewBinding {
    public final ConstraintLayout clCoinSettlement;
    public final LottieAnimationView coinSettlementLottieView;
    public final ImageView ivCoin;
    public final ImageView ivCoinSettlementBg;
    public final RelativeLayout rlCoin;
    private final ConstraintLayout rootView;
    public final TextView tvCoin;
    public final TextView tvCollectCoin;

    private LiveBusinessLayoutRedPackageRainCoinSettlementBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LottieAnimationView lottieAnimationView, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clCoinSettlement = constraintLayout2;
        this.coinSettlementLottieView = lottieAnimationView;
        this.ivCoin = imageView;
        this.ivCoinSettlementBg = imageView2;
        this.rlCoin = relativeLayout;
        this.tvCoin = textView;
        this.tvCollectCoin = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLayoutRedPackageRainCoinSettlementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLayoutRedPackageRainCoinSettlementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_layout_red_package_rain_coin_settlement;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.coin_settlement_lottie_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainCoinSettlementBinding bind(android.view.View r11) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.cl_coin_settlement
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.coin_settlement_lottie_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            com.airbnb.lottie.LottieAnimationView r5 = (com.airbnb.lottie.LottieAnimationView) r5
            if (r5 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_coin
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_coin_settlement_bg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_coin
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            if (r8 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_coin
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_collect_coin
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0057
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainCoinSettlementBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainCoinSettlementBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0057:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainCoinSettlementBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRedPackageRainCoinSettlementBinding");
    }
}
