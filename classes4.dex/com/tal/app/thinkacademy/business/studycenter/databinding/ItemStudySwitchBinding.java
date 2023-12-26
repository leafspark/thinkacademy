package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ItemStudySwitchBinding implements ViewBinding {
    private final RoundLinearLayout rootView;
    public final TextView tvSwitchBtn;
    public final TextView tvSwitchTip;

    private ItemStudySwitchBinding(RoundLinearLayout roundLinearLayout, TextView textView, TextView textView2) {
        this.rootView = roundLinearLayout;
        this.tvSwitchBtn = textView;
        this.tvSwitchTip = textView2;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemStudySwitchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemStudySwitchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_study_switch;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemStudySwitchBinding bind(View view) {
        int i = R.id.tvSwitchBtn;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.tvSwitchTip;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                return new ItemStudySwitchBinding((RoundLinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
