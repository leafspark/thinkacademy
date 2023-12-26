package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessItemEmojiPackageListBinding implements ViewBinding {
    public final ImageView ivEmojiView;
    public final FrameLayout llItemView;
    private final FrameLayout rootView;

    private LiveBusinessItemEmojiPackageListBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.ivEmojiView = imageView;
        this.llItemView = frameLayout2;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessItemEmojiPackageListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessItemEmojiPackageListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_item_emoji_package_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessItemEmojiPackageListBinding bind(View view) {
        int i = R.id.ivEmojiView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new LiveBusinessItemEmojiPackageListBinding(frameLayout, imageView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
