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
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;

public final class ItemAllstagePhoneBinding implements ViewBinding {
    public final ImageView bgLiveBusinessEmoji;
    public final ImageView boxLiveBusinessAvatar;
    public final ImageView ivAudioMute;
    public final ImageView ivLiveBusinessAvatar;
    public final EmojiView ivLiveBusinessEmoji;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessName;

    private ItemAllstagePhoneBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, EmojiView emojiView, TextView textView) {
        this.rootView = constraintLayout;
        this.bgLiveBusinessEmoji = imageView;
        this.boxLiveBusinessAvatar = imageView2;
        this.ivAudioMute = imageView3;
        this.ivLiveBusinessAvatar = imageView4;
        this.ivLiveBusinessEmoji = emojiView;
        this.tvLiveBusinessName = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemAllstagePhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemAllstagePhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_allstage_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemAllstagePhoneBinding bind(View view) {
        int i = R.id.bg_live_business_emoji;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.box_live_business_avatar;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.iv_audio_mute;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.iv_live_business_avatar;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.iv_live_business_emoji;
                        EmojiView emojiView = (EmojiView) ViewBindings.findChildViewById(view, i);
                        if (emojiView != null) {
                            i = R.id.tv_live_business_name;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new ItemAllstagePhoneBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, emojiView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
