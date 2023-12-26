package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;

public final class LiveBusinessItemChatBoxGroupTeacherEmojiMsgBinding implements ViewBinding {
    public final EmojiView ivEmojiMsg;
    public final ImageView ivUserAvatar;
    public final RelativeLayout rlUserAvatar;
    private final ConstraintLayout rootView;
    public final TextView tvUserName;

    private LiveBusinessItemChatBoxGroupTeacherEmojiMsgBinding(ConstraintLayout constraintLayout, EmojiView emojiView, ImageView imageView, RelativeLayout relativeLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.ivEmojiMsg = emojiView;
        this.ivUserAvatar = imageView;
        this.rlUserAvatar = relativeLayout;
        this.tvUserName = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessItemChatBoxGroupTeacherEmojiMsgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessItemChatBoxGroupTeacherEmojiMsgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_item_chat_box_group_teacher_emoji_msg;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessItemChatBoxGroupTeacherEmojiMsgBinding bind(View view) {
        int i = R.id.iv_emoji_msg;
        EmojiView emojiView = (EmojiView) ViewBindings.findChildViewById(view, i);
        if (emojiView != null) {
            i = R.id.iv_user_avatar;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.rl_user_avatar;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.tv_user_name;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new LiveBusinessItemChatBoxGroupTeacherEmojiMsgBinding((ConstraintLayout) view, emojiView, imageView, relativeLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
