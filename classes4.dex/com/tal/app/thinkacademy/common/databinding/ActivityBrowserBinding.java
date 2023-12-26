package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;

public final class ActivityBrowserBinding implements ViewBinding {
    public final FrameLayout flActivityBrowserMain;
    private final LinearLayout rootView;
    public final TitleBar webTitleBar;
    public final WebView wvBrowser;

    private ActivityBrowserBinding(LinearLayout linearLayout, FrameLayout frameLayout, TitleBar titleBar, WebView webView) {
        this.rootView = linearLayout;
        this.flActivityBrowserMain = frameLayout;
        this.webTitleBar = titleBar;
        this.wvBrowser = webView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBrowserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityBrowserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_browser;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityBrowserBinding bind(View view) {
        int i = R.id.fl_activity_browser_main;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = R.id.web_titleBar;
            TitleBar titleBar = (TitleBar) ViewBindings.findChildViewById(view, i);
            if (titleBar != null) {
                i = R.id.wv_browser;
                WebView webView = (WebView) ViewBindings.findChildViewById(view, i);
                if (webView != null) {
                    return new ActivityBrowserBinding((LinearLayout) view, frameLayout, titleBar, webView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
