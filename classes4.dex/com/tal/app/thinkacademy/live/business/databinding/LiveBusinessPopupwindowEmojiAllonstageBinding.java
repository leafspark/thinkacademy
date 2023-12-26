package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessPopupwindowEmojiAllonstageBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RecyclerView rvEmoji;

    private LiveBusinessPopupwindowEmojiAllonstageBinding(RelativeLayout relativeLayout, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.rvEmoji = recyclerView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPopupwindowEmojiAllonstageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPopupwindowEmojiAllonstageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_popupwindow_emoji_allonstage;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessPopupwindowEmojiAllonstageBinding bind(View view) {
        int i = R.id.rv_emoji;
        RecyclerView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new LiveBusinessPopupwindowEmojiAllonstageBinding((RelativeLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
