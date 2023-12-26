package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView;

public final class LiveBusinessViewLiveMsgAuditorPhoneBinding implements ViewBinding {
    public final ChatBoxListPluginView chatBoxListView;
    public final ConstraintLayout clLiveBusinessMessageRoot;
    private final ConstraintLayout rootView;
    public final View vLiveBusinessMessageMiddleLine;

    private LiveBusinessViewLiveMsgAuditorPhoneBinding(ConstraintLayout constraintLayout, ChatBoxListPluginView chatBoxListPluginView, ConstraintLayout constraintLayout2, View view) {
        this.rootView = constraintLayout;
        this.chatBoxListView = chatBoxListPluginView;
        this.clLiveBusinessMessageRoot = constraintLayout2;
        this.vLiveBusinessMessageMiddleLine = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewLiveMsgAuditorPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewLiveMsgAuditorPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_live_msg_auditor_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessViewLiveMsgAuditorPhoneBinding bind(View view) {
        int i = R.id.chat_box_list_view;
        ChatBoxListPluginView chatBoxListPluginView = (ChatBoxListPluginView) ViewBindings.findChildViewById(view, i);
        if (chatBoxListPluginView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i2 = R.id.v_live_business_message_middle_line;
            View findChildViewById = ViewBindings.findChildViewById(view, i2);
            if (findChildViewById != null) {
                return new LiveBusinessViewLiveMsgAuditorPhoneBinding(constraintLayout, chatBoxListPluginView, constraintLayout, findChildViewById);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
