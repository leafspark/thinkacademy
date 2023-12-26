package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveMsgHotwordLayoutBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvHotword;

    private LiveMsgHotwordLayoutBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.rvHotword = recyclerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveMsgHotwordLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveMsgHotwordLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_msg_hotword_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveMsgHotwordLayoutBinding bind(View view) {
        int i = R.id.rv_hotword;
        RecyclerView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new LiveMsgHotwordLayoutBinding((ConstraintLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
