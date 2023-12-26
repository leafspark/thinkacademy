package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessGoldCoinToastViewPrimaryBinding implements ViewBinding {
    public final LottieAnimationView lavLiveBusinessToastRewardPrimary;
    private final RelativeLayout rootView;

    private LiveBusinessGoldCoinToastViewPrimaryBinding(RelativeLayout relativeLayout, LottieAnimationView lottieAnimationView) {
        this.rootView = relativeLayout;
        this.lavLiveBusinessToastRewardPrimary = lottieAnimationView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessGoldCoinToastViewPrimaryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessGoldCoinToastViewPrimaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_gold_coin_toast_view_primary;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessGoldCoinToastViewPrimaryBinding bind(View view) {
        int i = R.id.lav_live_business_toast_reward_primary;
        LottieAnimationView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new LiveBusinessGoldCoinToastViewPrimaryBinding((RelativeLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
