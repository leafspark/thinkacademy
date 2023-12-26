package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.common.widget.HwPlayerView;

public final class BusShopAggregateDetailHeadVideoBinding implements ViewBinding {
    public final HwPlayerView playerView;
    private final ConstraintLayout rootView;

    private BusShopAggregateDetailHeadVideoBinding(ConstraintLayout constraintLayout, HwPlayerView hwPlayerView) {
        this.rootView = constraintLayout;
        this.playerView = hwPlayerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BusShopAggregateDetailHeadVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopAggregateDetailHeadVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_aggregate_detail_head_video;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BusShopAggregateDetailHeadVideoBinding bind(View view) {
        int i = R.id.player_view;
        HwPlayerView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new BusShopAggregateDetailHeadVideoBinding((ConstraintLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
