package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ActivityBeforeClassErrorBinding implements ViewBinding {
    public final TextView btnRetry;
    public final ImageView ivNoVideo;
    public final LinearLayout layoutError;
    private final LinearLayout rootView;
    public final TextView tvErrorInfo;

    private ActivityBeforeClassErrorBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, LinearLayout linearLayout2, TextView textView2) {
        this.rootView = linearLayout;
        this.btnRetry = textView;
        this.ivNoVideo = imageView;
        this.layoutError = linearLayout2;
        this.tvErrorInfo = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBeforeClassErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityBeforeClassErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_before_class_error;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityBeforeClassErrorBinding bind(View view) {
        int i = R.id.btn_retry;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.iv_no_video;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R.id.tv_error_info;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new ActivityBeforeClassErrorBinding(linearLayout, textView, imageView, linearLayout, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
