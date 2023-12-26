package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LayoutGraffitiPluginViewToolBinding implements ViewBinding {
    public final LinearLayout graffitiViewFrame;
    public final ImageView liveBusinessIvEraser;
    public final ImageView liveBusinessIvRedPaint;
    public final ImageView liveBusinessIvYellowPaint;
    private final LinearLayout rootView;

    private LayoutGraffitiPluginViewToolBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3) {
        this.rootView = linearLayout;
        this.graffitiViewFrame = linearLayout2;
        this.liveBusinessIvEraser = imageView;
        this.liveBusinessIvRedPaint = imageView2;
        this.liveBusinessIvYellowPaint = imageView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutGraffitiPluginViewToolBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutGraffitiPluginViewToolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_graffiti_plugin_view_tool;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutGraffitiPluginViewToolBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = R.id.live_business_iv_eraser;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.live_business_iv_red_paint;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.live_business_iv_yellow_paint;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    return new LayoutGraffitiPluginViewToolBinding(linearLayout, linearLayout, imageView, imageView2, imageView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
