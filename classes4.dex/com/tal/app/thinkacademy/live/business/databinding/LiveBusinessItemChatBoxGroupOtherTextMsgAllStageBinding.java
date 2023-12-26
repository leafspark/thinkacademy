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

public final class LiveBusinessItemChatBoxGroupOtherTextMsgAllStageBinding implements ViewBinding {
    public final ImageView ivUserAvatar;
    public final RelativeLayout rlUserAvatar;
    private final ConstraintLayout rootView;
    public final TextView tvMsg;
    public final TextView tvUserName;

    private LiveBusinessItemChatBoxGroupOtherTextMsgAllStageBinding(ConstraintLayout constraintLayout, ImageView imageView, RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.ivUserAvatar = imageView;
        this.rlUserAvatar = relativeLayout;
        this.tvMsg = textView;
        this.tvUserName = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessItemChatBoxGroupOtherTextMsgAllStageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessItemChatBoxGroupOtherTextMsgAllStageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_item_chat_box_group_other_text_msg_all_stage;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessItemChatBoxGroupOtherTextMsgAllStageBinding bind(View view) {
        int i = R.id.iv_user_avatar;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.rl_user_avatar;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.tv_msg;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_user_name;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new LiveBusinessItemChatBoxGroupOtherTextMsgAllStageBinding((ConstraintLayout) view, imageView, relativeLayout, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
