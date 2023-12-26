package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.widget.AutohListview;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessModeChangePopwindowLayoutBinding implements ViewBinding {
    public final AutohListview lvLiveBusinessPlaybackModechange;
    private final FrameLayout rootView;

    private LiveBusinessModeChangePopwindowLayoutBinding(FrameLayout frameLayout, AutohListview autohListview) {
        this.rootView = frameLayout;
        this.lvLiveBusinessPlaybackModechange = autohListview;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessModeChangePopwindowLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessModeChangePopwindowLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_mode_change_popwindow_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessModeChangePopwindowLayoutBinding bind(View view) {
        int i = R.id.lv_live_business_playback_modechange;
        AutohListview autohListview = (AutohListview) ViewBindings.findChildViewById(view, i);
        if (autohListview != null) {
            return new LiveBusinessModeChangePopwindowLayoutBinding((FrameLayout) view, autohListview);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
