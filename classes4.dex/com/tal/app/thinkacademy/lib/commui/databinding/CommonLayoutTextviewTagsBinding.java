package com.tal.app.thinkacademy.lib.commui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;

public final class CommonLayoutTextviewTagsBinding implements ViewBinding {
    public final TextView ctCtcommonTvTag;
    private final FrameLayout rootView;

    private CommonLayoutTextviewTagsBinding(FrameLayout frameLayout, TextView textView) {
        this.rootView = frameLayout;
        this.ctCtcommonTvTag = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static CommonLayoutTextviewTagsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CommonLayoutTextviewTagsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.common_layout_textview_tags;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static CommonLayoutTextviewTagsBinding bind(View view) {
        int i = R.id.ct_ctcommon_tv_tag;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            return new CommonLayoutTextviewTagsBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
