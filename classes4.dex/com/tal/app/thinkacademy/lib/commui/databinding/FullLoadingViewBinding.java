package com.tal.app.thinkacademy.lib.commui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.widget.ArcLoadingView;

public final class FullLoadingViewBinding implements ViewBinding {
    public final ArcLoadingView imgLoading;
    public final ImageView ivCircle;
    public final ImageView ivLoading;
    public final ImageView ivLoadingBg;
    private final ConstraintLayout rootView;

    private FullLoadingViewBinding(ConstraintLayout constraintLayout, ArcLoadingView arcLoadingView, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.rootView = constraintLayout;
        this.imgLoading = arcLoadingView;
        this.ivCircle = imageView;
        this.ivLoading = imageView2;
        this.ivLoadingBg = imageView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FullLoadingViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FullLoadingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.full_loading_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FullLoadingViewBinding bind(View view) {
        int i = R.id.img_loading;
        ArcLoadingView arcLoadingView = (ArcLoadingView) ViewBindings.findChildViewById(view, i);
        if (arcLoadingView != null) {
            i = R.id.iv_circle;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_loading;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.iv_loading_bg;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        return new FullLoadingViewBinding((ConstraintLayout) view, arcLoadingView, imageView, imageView2, imageView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
