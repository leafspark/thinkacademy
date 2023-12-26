package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.view.StateTextView;

public final class LayoutShopClassFilterTabBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final StateTextView tvFilterTab;

    private LayoutShopClassFilterTabBinding(ConstraintLayout constraintLayout, StateTextView stateTextView) {
        this.rootView = constraintLayout;
        this.tvFilterTab = stateTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutShopClassFilterTabBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutShopClassFilterTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_shop_class_filter_tab;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutShopClassFilterTabBinding bind(View view) {
        int i = R.id.tv_filter_tab;
        StateTextView stateTextView = (StateTextView) ViewBindings.findChildViewById(view, i);
        if (stateTextView != null) {
            return new LayoutShopClassFilterTabBinding((ConstraintLayout) view, stateTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
