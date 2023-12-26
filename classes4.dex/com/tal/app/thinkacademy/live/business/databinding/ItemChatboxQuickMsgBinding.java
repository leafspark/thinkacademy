package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class ItemChatboxQuickMsgBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView tvMsg;

    private ItemChatboxQuickMsgBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.tvMsg = textView2;
    }

    public TextView getRoot() {
        return this.rootView;
    }

    public static ItemChatboxQuickMsgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemChatboxQuickMsgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_chatbox_quick_msg;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemChatboxQuickMsgBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new ItemChatboxQuickMsgBinding(textView, textView);
    }
}
