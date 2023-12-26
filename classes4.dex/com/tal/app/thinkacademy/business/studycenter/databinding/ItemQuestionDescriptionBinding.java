package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ItemQuestionDescriptionBinding implements ViewBinding {
    public final RoundLinearLayout llContent;
    private final ConstraintLayout rootView;
    public final TextView tvItemQuestionCount;
    public final TextView tvItemQuestionType;

    private ItemQuestionDescriptionBinding(ConstraintLayout constraintLayout, RoundLinearLayout roundLinearLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.llContent = roundLinearLayout;
        this.tvItemQuestionCount = textView;
        this.tvItemQuestionType = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemQuestionDescriptionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemQuestionDescriptionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_question_description;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemQuestionDescriptionBinding bind(View view) {
        int i = R.id.llContent;
        RoundLinearLayout findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.tv_item_question_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_item_question_type;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new ItemQuestionDescriptionBinding((ConstraintLayout) view, findChildViewById, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
