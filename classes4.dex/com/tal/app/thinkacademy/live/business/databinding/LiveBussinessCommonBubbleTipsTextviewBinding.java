package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkcademy.lib.commui.widget.BubbleLayout;

public final class LiveBussinessCommonBubbleTipsTextviewBinding implements ViewBinding {
    public final TextView bubbleTipsTextview;
    private final BubbleLayout rootView;

    private LiveBussinessCommonBubbleTipsTextviewBinding(BubbleLayout bubbleLayout, TextView textView) {
        this.rootView = bubbleLayout;
        this.bubbleTipsTextview = textView;
    }

    public BubbleLayout getRoot() {
        return this.rootView;
    }

    public static LiveBussinessCommonBubbleTipsTextviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBussinessCommonBubbleTipsTextviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_bussiness_common_bubble_tips_textview;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBussinessCommonBubbleTipsTextviewBinding bind(View view) {
        int i = R.id.bubble_tips_textview;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new LiveBussinessCommonBubbleTipsTextviewBinding((BubbleLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
