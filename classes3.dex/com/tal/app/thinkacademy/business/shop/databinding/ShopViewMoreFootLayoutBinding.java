package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.shop.R;

public final class ShopViewMoreFootLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RoundTextView viewMoreBtn;

    private ShopViewMoreFootLayoutBinding(LinearLayout linearLayout, RoundTextView roundTextView) {
        this.rootView = linearLayout;
        this.viewMoreBtn = roundTextView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ShopViewMoreFootLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopViewMoreFootLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_view_more_foot_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ShopViewMoreFootLayoutBinding bind(View view) {
        int i = R.id.view_more_btn;
        RoundTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new ShopViewMoreFootLayoutBinding((LinearLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
