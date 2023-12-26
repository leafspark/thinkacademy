package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkcademy.lib.commui.widget.StateImageView;

public final class LayoutNetStateProgressBinding implements ViewBinding {
    public final ImageView ivStateError;
    public final StateImageView progress1;
    public final StateImageView progress2;
    public final StateImageView progress3;
    public final StateImageView progress4;
    public final StateImageView progress5;
    public final StateImageView progress6;
    private final LinearLayout rootView;

    private LayoutNetStateProgressBinding(LinearLayout linearLayout, ImageView imageView, StateImageView stateImageView, StateImageView stateImageView2, StateImageView stateImageView3, StateImageView stateImageView4, StateImageView stateImageView5, StateImageView stateImageView6) {
        this.rootView = linearLayout;
        this.ivStateError = imageView;
        this.progress1 = stateImageView;
        this.progress2 = stateImageView2;
        this.progress3 = stateImageView3;
        this.progress4 = stateImageView4;
        this.progress5 = stateImageView5;
        this.progress6 = stateImageView6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutNetStateProgressBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutNetStateProgressBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_net_state_progress;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutNetStateProgressBinding bind(View view) {
        int i = R.id.iv_state_error;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.progress_1;
            StateImageView stateImageView = (StateImageView) ViewBindings.findChildViewById(view, i);
            if (stateImageView != null) {
                i = R.id.progress_2;
                StateImageView stateImageView2 = (StateImageView) ViewBindings.findChildViewById(view, i);
                if (stateImageView2 != null) {
                    i = R.id.progress_3;
                    StateImageView stateImageView3 = (StateImageView) ViewBindings.findChildViewById(view, i);
                    if (stateImageView3 != null) {
                        i = R.id.progress_4;
                        StateImageView stateImageView4 = (StateImageView) ViewBindings.findChildViewById(view, i);
                        if (stateImageView4 != null) {
                            i = R.id.progress_5;
                            StateImageView stateImageView5 = (StateImageView) ViewBindings.findChildViewById(view, i);
                            if (stateImageView5 != null) {
                                i = R.id.progress_6;
                                StateImageView stateImageView6 = (StateImageView) ViewBindings.findChildViewById(view, i);
                                if (stateImageView6 != null) {
                                    return new LayoutNetStateProgressBinding((LinearLayout) view, imageView, stateImageView, stateImageView2, stateImageView3, stateImageView4, stateImageView5, stateImageView6);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
