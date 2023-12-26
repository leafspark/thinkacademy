package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class StudyDialogAssignmentBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RoundTextView tvCancel;
    public final TextView tvGotIt;
    public final TextView tvPhone;

    private StudyDialogAssignmentBinding(RelativeLayout relativeLayout, RoundTextView roundTextView, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.tvCancel = roundTextView;
        this.tvGotIt = textView;
        this.tvPhone = textView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StudyDialogAssignmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StudyDialogAssignmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.study_dialog_assignment;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StudyDialogAssignmentBinding bind(View view) {
        int i = R.id.tvCancel;
        RoundTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tvGotIt;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tvPhone;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new StudyDialogAssignmentBinding((RelativeLayout) view, findChildViewById, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
