package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessDialogNetworkBinding implements ViewBinding {
    public final FrameLayout flNetwork;
    public final ImageView ivNetwork;
    private final FrameLayout rootView;
    public final TextView tvContent;
    public final TextView tvExit;
    public final TextView tvTitle;

    private LiveBusinessDialogNetworkBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.flNetwork = frameLayout2;
        this.ivNetwork = imageView;
        this.tvContent = textView;
        this.tvExit = textView2;
        this.tvTitle = textView3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessDialogNetworkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessDialogNetworkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_dialog_network;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessDialogNetworkBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.ivNetwork;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.tvContent;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tvExit;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new LiveBusinessDialogNetworkBinding(frameLayout, frameLayout, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
