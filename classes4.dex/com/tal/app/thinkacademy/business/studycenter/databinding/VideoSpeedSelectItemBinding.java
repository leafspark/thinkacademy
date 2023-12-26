package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class VideoSpeedSelectItemBinding implements ViewBinding {
    private final RoundRelativeLayout rootView;
    public final TextView speedNumber;
    public final ProgressBar speedProgressBar;
    public final LinearLayout textlayout;

    private VideoSpeedSelectItemBinding(RoundRelativeLayout roundRelativeLayout, TextView textView, ProgressBar progressBar, LinearLayout linearLayout) {
        this.rootView = roundRelativeLayout;
        this.speedNumber = textView;
        this.speedProgressBar = progressBar;
        this.textlayout = linearLayout;
    }

    public RoundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static VideoSpeedSelectItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static VideoSpeedSelectItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.video_speed_select_item;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static VideoSpeedSelectItemBinding bind(View view) {
        int i = R.id.speed_number;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.speedProgressBar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                i = R.id.textlayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    return new VideoSpeedSelectItemBinding((RoundRelativeLayout) view, textView, progressBar, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
