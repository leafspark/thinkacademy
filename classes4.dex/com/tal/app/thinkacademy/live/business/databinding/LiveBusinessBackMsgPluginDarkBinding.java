package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView;

public final class LiveBusinessBackMsgPluginDarkBinding implements ViewBinding {
    public final ChatBoxListPluginView chatBoxListView;
    public final ImageView ivPlayBackEmptyMsg;
    private final ConstraintLayout rootView;

    private LiveBusinessBackMsgPluginDarkBinding(ConstraintLayout constraintLayout, ChatBoxListPluginView chatBoxListPluginView, ImageView imageView) {
        this.rootView = constraintLayout;
        this.chatBoxListView = chatBoxListPluginView;
        this.ivPlayBackEmptyMsg = imageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessBackMsgPluginDarkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessBackMsgPluginDarkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_back_msg_plugin_dark;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessBackMsgPluginDarkBinding bind(View view) {
        int i = R.id.chat_box_list_view;
        ChatBoxListPluginView chatBoxListPluginView = (ChatBoxListPluginView) ViewBindings.findChildViewById(view, i);
        if (chatBoxListPluginView != null) {
            i = R.id.iv_play_back_empty_msg;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                return new LiveBusinessBackMsgPluginDarkBinding((ConstraintLayout) view, chatBoxListPluginView, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
