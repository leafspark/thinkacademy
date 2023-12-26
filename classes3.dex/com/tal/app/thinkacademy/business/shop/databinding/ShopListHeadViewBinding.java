package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.youth.banner.Banner;

public final class ShopListHeadViewBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final Banner shopBanner;

    private ShopListHeadViewBinding(ConstraintLayout constraintLayout, Banner banner) {
        this.rootView = constraintLayout;
        this.shopBanner = banner;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopListHeadViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopListHeadViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_list_head_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShopListHeadViewBinding bind(View view) {
        int i = R.id.shop_banner;
        Banner findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new ShopListHeadViewBinding((ConstraintLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
