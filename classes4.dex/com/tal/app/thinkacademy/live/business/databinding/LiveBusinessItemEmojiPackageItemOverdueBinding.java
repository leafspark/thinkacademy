package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessItemEmojiPackageItemOverdueBinding implements ViewBinding {
    public final RelativeLayout emojiItemOverdue;
    public final ImageView ivHeadPortrait;
    private final RelativeLayout rootView;

    private LiveBusinessItemEmojiPackageItemOverdueBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView) {
        this.rootView = relativeLayout;
        this.emojiItemOverdue = relativeLayout2;
        this.ivHeadPortrait = imageView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessItemEmojiPackageItemOverdueBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessItemEmojiPackageItemOverdueBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_item_emoji_package_item_overdue;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessItemEmojiPackageItemOverdueBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R.id.ivHeadPortrait;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new LiveBusinessItemEmojiPackageItemOverdueBinding(relativeLayout, relativeLayout, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
