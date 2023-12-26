package com.tal.app.thinkacademy.business.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.home.R;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityLaunchBinding implements ViewBinding {
    public final ImageView launchLogo;
    public final LoadStatusView launchStatusView;
    private final ConstraintLayout rootView;
    public final TextView tvStart;

    private ActivityLaunchBinding(ConstraintLayout constraintLayout, ImageView imageView, LoadStatusView loadStatusView, TextView textView) {
        this.rootView = constraintLayout;
        this.launchLogo = imageView;
        this.launchStatusView = loadStatusView;
        this.tvStart = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLaunchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityLaunchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_launch;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityLaunchBinding bind(View view) {
        int i = R.id.launchLogo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.launchStatusView;
            LoadStatusView loadStatusView = (LoadStatusView) ViewBindings.findChildViewById(view, i);
            if (loadStatusView != null) {
                i = R.id.tv_start;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new ActivityLaunchBinding((ConstraintLayout) view, imageView, loadStatusView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
