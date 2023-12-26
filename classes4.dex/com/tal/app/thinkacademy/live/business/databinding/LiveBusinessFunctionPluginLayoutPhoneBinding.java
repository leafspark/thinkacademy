package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView;

public final class LiveBusinessFunctionPluginLayoutPhoneBinding implements ViewBinding {
    public final CircleProgressView liveBusinessFunctionCpbHand;
    public final ImageView liveBusinessFunctionIvHand;
    public final ImageView liveBusinessFunctionIvHandDis;
    public final ImageView liveBusinessFunctionIvMute;
    public final TextView liveBusinessFunctionTvHandProgress;
    private final ConstraintLayout rootView;

    private LiveBusinessFunctionPluginLayoutPhoneBinding(ConstraintLayout constraintLayout, CircleProgressView circleProgressView, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        this.rootView = constraintLayout;
        this.liveBusinessFunctionCpbHand = circleProgressView;
        this.liveBusinessFunctionIvHand = imageView;
        this.liveBusinessFunctionIvHandDis = imageView2;
        this.liveBusinessFunctionIvMute = imageView3;
        this.liveBusinessFunctionTvHandProgress = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessFunctionPluginLayoutPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessFunctionPluginLayoutPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_function_plugin_layout_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessFunctionPluginLayoutPhoneBinding bind(View view) {
        int i = R.id.live_business_function_cpb_hand;
        CircleProgressView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.live_business_function_iv_hand;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.live_business_function_iv_hand_dis;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.live_business_function_iv_mute;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.live_business_function_tv_hand_progress;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new LiveBusinessFunctionPluginLayoutPhoneBinding((ConstraintLayout) view, findChildViewById, imageView, imageView2, imageView3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
