package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import org.libpag.PAGView;

public final class LayoutCoinCenterNotifyBinding implements ViewBinding {
    public final PAGView coinCenterNotifyLottie;
    public final LinearLayout llCoinCenterNotifyRoot;
    private final LinearLayout rootView;

    private LayoutCoinCenterNotifyBinding(LinearLayout linearLayout, PAGView pAGView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.coinCenterNotifyLottie = pAGView;
        this.llCoinCenterNotifyRoot = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutCoinCenterNotifyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutCoinCenterNotifyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_coin_center_notify;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutCoinCenterNotifyBinding bind(View view) {
        int i = R.id.coin_center_notify_lottie;
        PAGView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new LayoutCoinCenterNotifyBinding(linearLayout, findChildViewById, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
