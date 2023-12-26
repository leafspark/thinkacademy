package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;

public final class ItemEmojiListBinding implements ViewBinding {
    public final RelativeLayout emojiListItemRL;
    public final EmojiView emojiView;
    private final RelativeLayout rootView;

    private ItemEmojiListBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, EmojiView emojiView2) {
        this.rootView = relativeLayout;
        this.emojiListItemRL = relativeLayout2;
        this.emojiView = emojiView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ItemEmojiListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemEmojiListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_emoji_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemEmojiListBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R.id.emojiView;
        EmojiView emojiView2 = (EmojiView) ViewBindings.findChildViewById(view, i);
        if (emojiView2 != null) {
            return new ItemEmojiListBinding(relativeLayout, relativeLayout, emojiView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
