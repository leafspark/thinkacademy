package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessCountdownLayoutBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final TextView tvLiveBusinessRestCountdownMin;
    public final TextView tvLiveBusinessRestCountdownSec;

    private LiveBusinessCountdownLayoutBinding(FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.rootView = frameLayout;
        this.tvLiveBusinessRestCountdownMin = textView;
        this.tvLiveBusinessRestCountdownSec = textView2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessCountdownLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessCountdownLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_countdown_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessCountdownLayoutBinding bind(View view) {
        int i = R.id.tv_live_business_rest_countdown_min;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.tv_live_business_rest_countdown_sec;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                return new LiveBusinessCountdownLayoutBinding((FrameLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
