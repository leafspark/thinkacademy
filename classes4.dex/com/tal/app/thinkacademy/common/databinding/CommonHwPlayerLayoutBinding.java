package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;

public final class CommonHwPlayerLayoutBinding implements ViewBinding {
    public final ProgressBar bottomProgressbar;
    public final ImageView imageCover;
    public final TextureView payerSurfaceView;
    public final ImageView playBtn;
    public final LinearLayout playerLoading;
    public final ConstraintLayout playerRoot;
    private final ConstraintLayout rootView;

    private CommonHwPlayerLayoutBinding(ConstraintLayout constraintLayout, ProgressBar progressBar, ImageView imageView, TextureView textureView, ImageView imageView2, LinearLayout linearLayout, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.bottomProgressbar = progressBar;
        this.imageCover = imageView;
        this.payerSurfaceView = textureView;
        this.playBtn = imageView2;
        this.playerLoading = linearLayout;
        this.playerRoot = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CommonHwPlayerLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CommonHwPlayerLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.common_hw_player_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CommonHwPlayerLayoutBinding bind(View view) {
        int i = R.id.bottom_progressbar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
        if (progressBar != null) {
            i = R.id.image_cover;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.payer_surface_view;
                TextureView textureView = (TextureView) ViewBindings.findChildViewById(view, i);
                if (textureView != null) {
                    i = R.id.play_btn;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.player_loading;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            return new CommonHwPlayerLayoutBinding(constraintLayout, progressBar, imageView, textureView, imageView2, linearLayout, constraintLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
