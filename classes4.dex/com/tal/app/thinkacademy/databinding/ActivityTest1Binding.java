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

public final class ActivityTest1Binding implements ViewBinding {
    public final ConstraintLayout clContent;
    public final LoadStatusView lsView;
    private final ConstraintLayout rootView;
    public final TextView tvContent;

    private ActivityTest1Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LoadStatusView loadStatusView, TextView textView) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.lsView = loadStatusView;
        this.tvContent = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTest1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTest1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(2131492962, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, 2131492962, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityTest1Binding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = 2131297597;
        LoadStatusView findChildViewById = ViewBindings.findChildViewById(view, 2131297597);
        if (findChildViewById != null) {
            i = 2131298574;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131298574);
            if (textView != null) {
                return new ActivityTest1Binding(constraintLayout, constraintLayout, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
