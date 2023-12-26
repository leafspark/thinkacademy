package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessInteractiveGameBinding implements ViewBinding {
    public final ImageView bgLoading;
    public final ImageView btnGameBack;
    public final ImageView btnGameRefresh;
    public final ConstraintLayout gamePluginView;
    public final FrameLayout layoutWebContainer;
    private final ConstraintLayout rootView;

    private LiveBusinessInteractiveGameBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout2, FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.bgLoading = imageView;
        this.btnGameBack = imageView2;
        this.btnGameRefresh = imageView3;
        this.gamePluginView = constraintLayout2;
        this.layoutWebContainer = frameLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessInteractiveGameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessInteractiveGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_interactive_game;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessInteractiveGameBinding bind(View view) {
        int i = R.id.bg_loading;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btn_game_back;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.btn_game_refresh;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.layout_web_container;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        return new LiveBusinessInteractiveGameBinding(constraintLayout, imageView, imageView2, imageView3, constraintLayout, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
