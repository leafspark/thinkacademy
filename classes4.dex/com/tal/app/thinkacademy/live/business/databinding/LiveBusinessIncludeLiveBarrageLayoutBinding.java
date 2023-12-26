package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessIncludeLiveBarrageLayoutBinding implements ViewBinding {
    public final ImageView ivLiveBusinessGiftSendToast;
    public final RelativeLayout rlLiveBusinessGiftToast;
    private final RelativeLayout rootView;
    public final TextView tvLiveBusinessGiftSendToast;

    private LiveBusinessIncludeLiveBarrageLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView) {
        this.rootView = relativeLayout;
        this.ivLiveBusinessGiftSendToast = imageView;
        this.rlLiveBusinessGiftToast = relativeLayout2;
        this.tvLiveBusinessGiftSendToast = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessIncludeLiveBarrageLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessIncludeLiveBarrageLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_include_live_barrage_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessIncludeLiveBarrageLayoutBinding bind(View view) {
        int i = R.id.iv_live_business_gift_send_toast;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i2 = R.id.tv_live_business_gift_send_toast;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView != null) {
                return new LiveBusinessIncludeLiveBarrageLayoutBinding(relativeLayout, imageView, relativeLayout, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
