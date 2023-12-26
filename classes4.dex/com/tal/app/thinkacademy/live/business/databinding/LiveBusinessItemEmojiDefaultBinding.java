package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class LiveBusinessItemEmojiDefaultBinding implements ViewBinding {
    public final ImageView ivEmoji;
    private final ImageView rootView;

    private LiveBusinessItemEmojiDefaultBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.ivEmoji = imageView2;
    }

    public ImageView getRoot() {
        return this.rootView;
    }

    public static LiveBusinessItemEmojiDefaultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessItemEmojiDefaultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_item_emoji_default;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessItemEmojiDefaultBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        ImageView imageView = (ImageView) view;
        return new LiveBusinessItemEmojiDefaultBinding(imageView, imageView);
    }
}
