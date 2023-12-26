package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.google.android.flexbox.FlexboxLayout;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessPopupwindowFeedbackBinding implements ViewBinding {
    public final EditText etFeedbackContent;
    public final ImageView ivFeedbackAllow;
    public final FlexboxLayout llFeedbackOptions;
    private final ConstraintLayout rootView;
    public final RoundTextView tvFeedbackCancel;
    public final TextView tvFeedbackOptionsAppProblem;
    public final TextView tvFeedbackOptionsInappropriateBehavior;
    public final TextView tvFeedbackOptionsInappropriateOthers;
    public final TextView tvFeedbackOptionsStudyQuestion;
    public final RoundTextView tvFeedbackSend;
    public final TextView tvFeedbackTip;
    public final TextView tvFeedbackTitle;

    private LiveBusinessPopupwindowFeedbackBinding(ConstraintLayout constraintLayout, EditText editText, ImageView imageView, FlexboxLayout flexboxLayout, RoundTextView roundTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4, RoundTextView roundTextView2, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.etFeedbackContent = editText;
        this.ivFeedbackAllow = imageView;
        this.llFeedbackOptions = flexboxLayout;
        this.tvFeedbackCancel = roundTextView;
        this.tvFeedbackOptionsAppProblem = textView;
        this.tvFeedbackOptionsInappropriateBehavior = textView2;
        this.tvFeedbackOptionsInappropriateOthers = textView3;
        this.tvFeedbackOptionsStudyQuestion = textView4;
        this.tvFeedbackSend = roundTextView2;
        this.tvFeedbackTip = textView5;
        this.tvFeedbackTitle = textView6;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPopupwindowFeedbackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPopupwindowFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_popupwindow_feedback;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.tv_feedback_send;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.ll_feedback_options;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.tv_feedback_cancel;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowFeedbackBinding bind(android.view.View r15) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.et_feedback_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            android.widget.EditText r4 = (android.widget.EditText) r4
            if (r4 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_feedback_allow
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ll_feedback_options
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            com.google.android.flexbox.FlexboxLayout r6 = (com.google.android.flexbox.FlexboxLayout) r6
            if (r6 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_feedback_cancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            com.flyco.roundview.RoundTextView r7 = (com.flyco.roundview.RoundTextView) r7
            if (r7 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_feedback_options_app_problem
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_feedback_options_inappropriate_behavior
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_feedback_options_inappropriate_others
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_feedback_options_study_question
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_feedback_send
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            com.flyco.roundview.RoundTextView r12 = (com.flyco.roundview.RoundTextView) r12
            if (r12 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_feedback_tip
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_feedback_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r14 = r1
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0083
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowFeedbackBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowFeedbackBinding
            r3 = r15
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x0083:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowFeedbackBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPopupwindowFeedbackBinding");
    }
}
