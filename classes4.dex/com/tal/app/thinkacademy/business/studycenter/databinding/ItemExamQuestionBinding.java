package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ItemExamQuestionBinding implements ViewBinding {
    public final RoundLinearLayout llContent;
    private final RoundLinearLayout rootView;
    public final Space spaceItemBottom;
    public final TextView tvItemQuestionCount;
    public final TextView tvItemQuestionType;

    private ItemExamQuestionBinding(RoundLinearLayout roundLinearLayout, RoundLinearLayout roundLinearLayout2, Space space, TextView textView, TextView textView2) {
        this.rootView = roundLinearLayout;
        this.llContent = roundLinearLayout2;
        this.spaceItemBottom = space;
        this.tvItemQuestionCount = textView;
        this.tvItemQuestionType = textView2;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemExamQuestionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemExamQuestionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_exam_question;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemExamQuestionBinding bind(View view) {
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) view;
        int i = R.id.space_item_bottom;
        Space space = (Space) ViewBindings.findChildViewById(view, i);
        if (space != null) {
            i = R.id.tv_item_question_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tv_item_question_type;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    return new ItemExamQuestionBinding(roundLinearLayout, roundLinearLayout, space, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
