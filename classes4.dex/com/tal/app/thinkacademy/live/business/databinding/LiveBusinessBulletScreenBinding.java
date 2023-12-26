package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.widget.HwPagView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessBulletScreenBinding implements ViewBinding {
    public final HwPagView pagBullet;
    private final FrameLayout rootView;

    private LiveBusinessBulletScreenBinding(FrameLayout frameLayout, HwPagView hwPagView) {
        this.rootView = frameLayout;
        this.pagBullet = hwPagView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessBulletScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessBulletScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_bullet_screen;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessBulletScreenBinding bind(View view) {
        int i = R.id.pagBullet;
        HwPagView hwPagView = (HwPagView) ViewBindings.findChildViewById(view, i);
        if (hwPagView != null) {
            return new LiveBusinessBulletScreenBinding((FrameLayout) view, hwPagView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
