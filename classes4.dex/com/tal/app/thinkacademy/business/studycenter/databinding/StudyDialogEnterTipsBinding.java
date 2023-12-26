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

public final class StudyDialogEnterTipsBinding implements ViewBinding {
    public final RoundTextView btnLeft;
    public final TextView btnRight;
    private final RelativeLayout rootView;
    public final TextView tipsMsg;
    public final TextView tipsTitle;

    private StudyDialogEnterTipsBinding(RelativeLayout relativeLayout, RoundTextView roundTextView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.btnLeft = roundTextView;
        this.btnRight = textView;
        this.tipsMsg = textView2;
        this.tipsTitle = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StudyDialogEnterTipsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StudyDialogEnterTipsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.study_dialog_enter_tips;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static StudyDialogEnterTipsBinding bind(View view) {
        int i = R.id.btn_left;
        RoundTextView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            i = R.id.btn_right;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.tips_msg;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tips_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new StudyDialogEnterTipsBinding((RelativeLayout) view, findChildViewById, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
