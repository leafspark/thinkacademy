package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;

public final class LayoutShopClassLoadmoreBinding implements ViewBinding {
    public final LinearLayout llLoadMmoreFail;
    public final LinearLayout llLoadMoreEnd;
    public final LinearLayout llLoadMoreLoading;
    private final FrameLayout rootView;
    public final Space spaceComplete;

    private LayoutShopClassLoadmoreBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, Space space) {
        this.rootView = frameLayout;
        this.llLoadMmoreFail = linearLayout;
        this.llLoadMoreEnd = linearLayout2;
        this.llLoadMoreLoading = linearLayout3;
        this.spaceComplete = space;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutShopClassLoadmoreBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutShopClassLoadmoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_shop_class_loadmore;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutShopClassLoadmoreBinding bind(View view) {
        int i = R.id.llLoadMmoreFail;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.llLoadMoreEnd;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.llLoadMoreLoading;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = R.id.spaceComplete;
                    Space space = (Space) ViewBindings.findChildViewById(view, i);
                    if (space != null) {
                        return new LayoutShopClassLoadmoreBinding((FrameLayout) view, linearLayout, linearLayout2, linearLayout3, space);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
