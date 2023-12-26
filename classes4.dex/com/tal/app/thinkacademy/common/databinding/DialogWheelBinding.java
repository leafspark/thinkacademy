package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.lib.commui.wheel.view.WheelView;

public final class DialogWheelBinding implements ViewBinding {
    public final ImageView ivCancel;
    public final ImageView ivConfirm;
    private final LinearLayout rootView;
    public final WheelView wheelView;

    private DialogWheelBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, WheelView wheelView2) {
        this.rootView = linearLayout;
        this.ivCancel = imageView;
        this.ivConfirm = imageView2;
        this.wheelView = wheelView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogWheelBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogWheelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.dialog_wheel;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogWheelBinding bind(View view) {
        int i = R.id.iv_cancel;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_confirm;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.wheelView;
                WheelView wheelView2 = (WheelView) ViewBindings.findChildViewById(view, i);
                if (wheelView2 != null) {
                    return new DialogWheelBinding((LinearLayout) view, imageView, imageView2, wheelView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
