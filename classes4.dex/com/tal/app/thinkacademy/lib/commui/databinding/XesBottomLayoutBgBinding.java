package com.tal.app.thinkacademy.lib.commui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;
import java.util.Objects;

public final class XesBottomLayoutBgBinding implements ViewBinding {
    private final View rootView;

    private XesBottomLayoutBgBinding(View view) {
        this.rootView = view;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static XesBottomLayoutBgBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static XesBottomLayoutBgBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.xes_bottom_layout_bg;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static XesBottomLayoutBgBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new XesBottomLayoutBgBinding(view);
    }
}
