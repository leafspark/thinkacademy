package com.tal.app.thinkacademy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityDemoBinding implements ViewBinding {
    public final LoadStatusView lsView;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;

    private ActivityDemoBinding(ConstraintLayout constraintLayout, LoadStatusView loadStatusView, TextView textView) {
        this.rootView = constraintLayout;
        this.lsView = loadStatusView;
        this.tvTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDemoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityDemoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(2131492918, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, 2131492918, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityDemoBinding bind(View view) {
        int i = 2131297597;
        LoadStatusView findChildViewById = ViewBindings.findChildViewById(view, 2131297597);
        if (findChildViewById != null) {
            i = 2131298838;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131298838);
            if (textView != null) {
                return new ActivityDemoBinding((ConstraintLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
