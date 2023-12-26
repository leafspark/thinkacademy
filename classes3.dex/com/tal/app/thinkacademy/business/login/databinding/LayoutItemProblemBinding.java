package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.login.R;

public final class LayoutItemProblemBinding implements ViewBinding {
    public final RoundTextView itemTvDescriptor;
    public final LinearLayout rlItem;
    private final LinearLayout rootView;

    private LayoutItemProblemBinding(LinearLayout linearLayout, RoundTextView roundTextView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.itemTvDescriptor = roundTextView;
        this.rlItem = linearLayout2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutItemProblemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutItemProblemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_item_problem;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutItemProblemBinding bind(View view) {
        int i = R.id.item_tv_descriptor;
        RoundTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new LayoutItemProblemBinding(linearLayout, findChildViewById, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
