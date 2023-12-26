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

public final class ItemShopClassFilterDayBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final StateTextView tvItemDay;

    private ItemShopClassFilterDayBinding(ConstraintLayout constraintLayout, StateTextView stateTextView) {
        this.rootView = constraintLayout;
        this.tvItemDay = stateTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemShopClassFilterDayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemShopClassFilterDayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_shop_class_filter_day;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemShopClassFilterDayBinding bind(View view) {
        int i = R.id.tv_item_day;
        StateTextView stateTextView = (StateTextView) ViewBindings.findChildViewById(view, i);
        if (stateTextView != null) {
            return new ItemShopClassFilterDayBinding((ConstraintLayout) view, stateTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
