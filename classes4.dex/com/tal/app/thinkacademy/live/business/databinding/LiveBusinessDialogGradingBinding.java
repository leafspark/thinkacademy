package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessDialogGradingBinding implements ViewBinding {
    private final RoundLinearLayout rootView;
    public final RoundTextView tvLiveBusinessGradingClose;
    public final TextView tvLiveBusinessGradingView;

    private LiveBusinessDialogGradingBinding(RoundLinearLayout roundLinearLayout, RoundTextView roundTextView, TextView textView) {
        this.rootView = roundLinearLayout;
        this.tvLiveBusinessGradingClose = roundTextView;
        this.tvLiveBusinessGradingView = textView;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessDialogGradingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessDialogGradingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_dialog_grading;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessDialogGradingBinding bind(View view) {
        int i = R.id.tv_live_business_grading_close;
        RoundTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tv_live_business_grading_view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new LiveBusinessDialogGradingBinding((RoundLinearLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
