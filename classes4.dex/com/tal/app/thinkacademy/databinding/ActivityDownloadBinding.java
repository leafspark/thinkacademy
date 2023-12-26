package com.tal.app.thinkacademy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ActivityDownloadBinding implements ViewBinding {
    public final Button btnDownloadPause;
    public final Button btnDownloadResume;
    public final Button btnDownloadStart;
    public final ProgressBar pbDownloadProgress;
    private final ConstraintLayout rootView;
    public final ScrollView svDownloadInfo;
    public final TextView tvDownloadInfo;

    private ActivityDownloadBinding(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, ProgressBar progressBar, ScrollView scrollView, TextView textView) {
        this.rootView = constraintLayout;
        this.btnDownloadPause = button;
        this.btnDownloadResume = button2;
        this.btnDownloadStart = button3;
        this.pbDownloadProgress = progressBar;
        this.svDownloadInfo = scrollView;
        this.tvDownloadInfo = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDownloadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityDownloadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(2131492921, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, 2131492921, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityDownloadBinding bind(View view) {
        int i = 2131296448;
        Button button = (Button) ViewBindings.findChildViewById(view, 2131296448);
        if (button != null) {
            i = 2131296449;
            Button button2 = (Button) ViewBindings.findChildViewById(view, 2131296449);
            if (button2 != null) {
                i = 2131296450;
                Button button3 = (Button) ViewBindings.findChildViewById(view, 2131296450);
                if (button3 != null) {
                    i = 2131297745;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, 2131297745);
                    if (progressBar != null) {
                        i = 2131298206;
                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, 2131298206);
                        if (scrollView != null) {
                            i = R.id.tv_download_info;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_download_info);
                            if (textView != null) {
                                return new ActivityDownloadBinding((ConstraintLayout) view, button, button2, button3, progressBar, scrollView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
