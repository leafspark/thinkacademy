package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ItemPlanListExamBinding implements ViewBinding {
    public final ConstraintLayout clExam;
    private final LinearLayout rootView;
    public final TextView tvExamName;
    public final TextView tvExamStatus;
    public final TextView tvExamTime;

    private ItemPlanListExamBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.clExam = constraintLayout;
        this.tvExamName = textView;
        this.tvExamStatus = textView2;
        this.tvExamTime = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemPlanListExamBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemPlanListExamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_plan_list_exam;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemPlanListExamBinding bind(View view) {
        int i = R.id.clExam;
        ConstraintLayout findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tvExamName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tvExamStatus;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tvExamTime;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new ItemPlanListExamBinding((LinearLayout) view, findChildViewById, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
