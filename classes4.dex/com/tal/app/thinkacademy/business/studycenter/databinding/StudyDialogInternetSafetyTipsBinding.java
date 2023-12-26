package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.business.browser.view.XesWebView;

public final class StudyDialogInternetSafetyTipsBinding implements ViewBinding {
    public final RoundTextView iGotIt;
    private final RelativeLayout rootView;
    public final XesWebView wvBrowser;

    private StudyDialogInternetSafetyTipsBinding(RelativeLayout relativeLayout, RoundTextView roundTextView, XesWebView xesWebView) {
        this.rootView = relativeLayout;
        this.iGotIt = roundTextView;
        this.wvBrowser = xesWebView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StudyDialogInternetSafetyTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StudyDialogInternetSafetyTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.study_dialog_internet_safety_tips;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StudyDialogInternetSafetyTipsBinding bind(View view) {
        int i = R.id.iGotIt;
        RoundTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.wvBrowser;
            XesWebView xesWebView = (XesWebView) ViewBindings.findChildViewById(view, i);
            if (xesWebView != null) {
                return new StudyDialogInternetSafetyTipsBinding((RelativeLayout) view, findChildViewById, xesWebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
