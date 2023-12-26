package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class LayoutProgressWebviewBinding implements ViewBinding {
    public final ImageView btnBrowerRightIcon;
    public final FrameLayout flWebviewContainer;
    public final ImageView icBrowserTitleBack;
    public final RelativeLayout llRootBrowser;
    public final LoadStatusView loadStatusView;
    public final ProgressBar probarBrowserLoading;
    public final RelativeLayout rlTitleBrowswer;
    private final RelativeLayout rootView;
    public final TextView tvBrowserTitle;

    private LayoutProgressWebviewBinding(RelativeLayout relativeLayout, ImageView imageView, FrameLayout frameLayout, ImageView imageView2, RelativeLayout relativeLayout2, LoadStatusView loadStatusView2, ProgressBar progressBar, RelativeLayout relativeLayout3, TextView textView) {
        this.rootView = relativeLayout;
        this.btnBrowerRightIcon = imageView;
        this.flWebviewContainer = frameLayout;
        this.icBrowserTitleBack = imageView2;
        this.llRootBrowser = relativeLayout2;
        this.loadStatusView = loadStatusView2;
        this.probarBrowserLoading = progressBar;
        this.rlTitleBrowswer = relativeLayout3;
        this.tvBrowserTitle = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutProgressWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutProgressWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_progress_webview;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutProgressWebviewBinding bind(View view) {
        int i = R.id.btn_brower_right_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.fl_webview_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.ic_browser_title_back;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i = R.id.load_status_view;
                    LoadStatusView findChildViewById = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById != null) {
                        i = R.id.probar_browser_loading;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            i = R.id.rl_title_browswer;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                            if (relativeLayout2 != null) {
                                i = R.id.tv_browser_title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new LayoutProgressWebviewBinding(relativeLayout, imageView, frameLayout, imageView2, relativeLayout, findChildViewById, progressBar, relativeLayout2, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
