package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessPreviewSubmitGuideBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RoundTextView tvBack;
    public final TextView tvSubmit;

    private LiveBusinessPreviewSubmitGuideBinding(RelativeLayout relativeLayout, RoundTextView roundTextView, TextView textView) {
        this.rootView = relativeLayout;
        this.tvBack = roundTextView;
        this.tvSubmit = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPreviewSubmitGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPreviewSubmitGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_preview_submit_guide;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessPreviewSubmitGuideBinding bind(View view) {
        int i = R.id.tvBack;
        RoundTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tvSubmit;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new LiveBusinessPreviewSubmitGuideBinding((RelativeLayout) view, findChildViewById, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
