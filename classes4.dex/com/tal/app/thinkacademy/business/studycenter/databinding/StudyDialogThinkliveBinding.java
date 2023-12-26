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

public final class StudyDialogThinkliveBinding implements ViewBinding {
    public final RoundLinearLayout llCopyThinkLive;
    private final RelativeLayout rootView;
    public final TextView tvGotIt;
    public final TextView tvThinkLive;

    private StudyDialogThinkliveBinding(RelativeLayout relativeLayout, RoundLinearLayout roundLinearLayout, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.llCopyThinkLive = roundLinearLayout;
        this.tvGotIt = textView;
        this.tvThinkLive = textView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StudyDialogThinkliveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StudyDialogThinkliveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.study_dialog_thinklive;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StudyDialogThinkliveBinding bind(View view) {
        int i = R.id.llCopyThinkLive;
        RoundLinearLayout findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tvGotIt;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tvThinkLive;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new StudyDialogThinkliveBinding((RelativeLayout) view, findChildViewById, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
