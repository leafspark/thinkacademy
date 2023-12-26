package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class StudyDialogClassinBinding implements ViewBinding {
    public final RoundLinearLayout llCopyClassinLink;
    private final RelativeLayout rootView;
    public final TextView tvClassinLink;
    public final TextView tvDownload;
    public final TextView tvGotIt;

    private StudyDialogClassinBinding(RelativeLayout relativeLayout, RoundLinearLayout roundLinearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.llCopyClassinLink = roundLinearLayout;
        this.tvClassinLink = textView;
        this.tvDownload = textView2;
        this.tvGotIt = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StudyDialogClassinBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StudyDialogClassinBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.study_dialog_classin;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StudyDialogClassinBinding bind(View view) {
        int i = R.id.llCopyClassinLink;
        RoundLinearLayout findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tvClassinLink;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tvDownload;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tvGotIt;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new StudyDialogClassinBinding((RelativeLayout) view, findChildViewById, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
