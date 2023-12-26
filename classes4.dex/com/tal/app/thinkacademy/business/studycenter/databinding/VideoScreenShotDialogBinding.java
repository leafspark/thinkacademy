package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class VideoScreenShotDialogBinding implements ViewBinding {
    public final CardView imageCardLayout;
    private final ConstraintLayout rootView;
    public final ImageView screenShotImage;
    public final TextView shotBg;

    private VideoScreenShotDialogBinding(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.imageCardLayout = cardView;
        this.screenShotImage = imageView;
        this.shotBg = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static VideoScreenShotDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static VideoScreenShotDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.video_screen_shot_dialog;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static VideoScreenShotDialogBinding bind(View view) {
        int i = R.id.imageCardLayout;
        CardView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.screenShotImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.shotBg;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new VideoScreenShotDialogBinding((ConstraintLayout) view, findChildViewById, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
