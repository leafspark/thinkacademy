package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class LiveBusinessLayoutGestureBinding implements ViewBinding {
    private final FrameLayout rootView;

    private LiveBusinessLayoutGestureBinding(FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLayoutGestureBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLayoutGestureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_layout_gesture;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessLayoutGestureBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new LiveBusinessLayoutGestureBinding((FrameLayout) view);
    }
}