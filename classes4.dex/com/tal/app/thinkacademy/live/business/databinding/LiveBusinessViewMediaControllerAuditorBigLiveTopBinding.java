package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessViewMediaControllerAuditorBigLiveTopBinding implements ViewBinding {
    public final ImageView ivLiveBusinessScreenshot;
    public final ImageView ivMediaControllerBack;
    public final ImageView ivMediaControllerNetwork;
    public final ImageView ivMediaControllerRefresh;
    public final LinearLayout rlMediaControllerRootTop;
    private final LinearLayout rootView;
    public final TextView tvMediaControllerTitle;

    private LiveBusinessViewMediaControllerAuditorBigLiveTopBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.ivLiveBusinessScreenshot = imageView;
        this.ivMediaControllerBack = imageView2;
        this.ivMediaControllerNetwork = imageView3;
        this.ivMediaControllerRefresh = imageView4;
        this.rlMediaControllerRootTop = linearLayout2;
        this.tvMediaControllerTitle = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewMediaControllerAuditorBigLiveTopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewMediaControllerAuditorBigLiveTopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_media_controller_auditor_big_live_top;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessViewMediaControllerAuditorBigLiveTopBinding bind(View view) {
        int i = R.id.iv_live_business_screenshot;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_media_controller_back;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_media_controller_network;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_media_controller_refresh;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        LinearLayout linearLayout = (LinearLayout) view;
                        i = R.id.tv_media_controller_title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new LiveBusinessViewMediaControllerAuditorBigLiveTopBinding(linearLayout, imageView, imageView2, imageView3, imageView4, linearLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
