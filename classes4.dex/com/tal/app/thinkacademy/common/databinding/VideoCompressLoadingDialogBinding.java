package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.lib.commui.widget.ArcLoadingView;

public final class VideoCompressLoadingDialogBinding implements ViewBinding {
    public final ArcLoadingView imgLoading;
    public final ImageView ivCircle;
    public final ImageView ivLoading;
    public final TextView loadingTips;
    public final TextView progressTextView;
    private final ConstraintLayout rootView;

    private VideoCompressLoadingDialogBinding(ConstraintLayout constraintLayout, ArcLoadingView arcLoadingView, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.imgLoading = arcLoadingView;
        this.ivCircle = imageView;
        this.ivLoading = imageView2;
        this.loadingTips = textView;
        this.progressTextView = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static VideoCompressLoadingDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static VideoCompressLoadingDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.video_compress_loading_dialog;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static VideoCompressLoadingDialogBinding bind(View view) {
        int i = R.id.img_loading;
        ArcLoadingView arcLoadingView = (ArcLoadingView) ViewBindings.findChildViewById(view, i);
        if (arcLoadingView != null) {
            i = R.id.iv_circle;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.iv_loading;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.loadingTips;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.progressTextView;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new VideoCompressLoadingDialogBinding((ConstraintLayout) view, arcLoadingView, imageView, imageView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
