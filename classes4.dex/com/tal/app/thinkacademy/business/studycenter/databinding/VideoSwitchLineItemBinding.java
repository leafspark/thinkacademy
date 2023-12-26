package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class VideoSwitchLineItemBinding implements ViewBinding {
    public final TextView lineNumber;
    public final ProgressBar lineProgressBar;
    private final RoundRelativeLayout rootView;

    private VideoSwitchLineItemBinding(RoundRelativeLayout roundRelativeLayout, TextView textView, ProgressBar progressBar) {
        this.rootView = roundRelativeLayout;
        this.lineNumber = textView;
        this.lineProgressBar = progressBar;
    }

    public RoundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static VideoSwitchLineItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static VideoSwitchLineItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.video_switch_line_item;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static VideoSwitchLineItemBinding bind(View view) {
        int i = R.id.lineNumber;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.lineProgressBar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                return new VideoSwitchLineItemBinding((RoundRelativeLayout) view, textView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
