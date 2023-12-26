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
import com.tal.app.thinkacademy.lib.commui.widget.IOSLoadingView;

public final class LayoutDefaultRefreshFooterBinding implements ViewBinding {
    public final IOSLoadingView loadingRefreshFooter;
    private final FrameLayout rootView;
    public final TextView tvRefreshFooter;

    private LayoutDefaultRefreshFooterBinding(FrameLayout frameLayout, IOSLoadingView iOSLoadingView, TextView textView) {
        this.rootView = frameLayout;
        this.loadingRefreshFooter = iOSLoadingView;
        this.tvRefreshFooter = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDefaultRefreshFooterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutDefaultRefreshFooterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_default_refresh_footer;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutDefaultRefreshFooterBinding bind(View view) {
        int i = R.id.loading_refresh_footer;
        IOSLoadingView iOSLoadingView = (IOSLoadingView) ViewBindings.findChildViewById(view, i);
        if (iOSLoadingView != null) {
            i = R.id.tv_refresh_footer;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                return new LayoutDefaultRefreshFooterBinding((FrameLayout) view, iOSLoadingView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
