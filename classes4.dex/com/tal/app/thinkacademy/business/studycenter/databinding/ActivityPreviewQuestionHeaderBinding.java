package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.widget.TagTextView;

public final class ActivityPreviewQuestionHeaderBinding implements ViewBinding {
    public final ImageView ivMiss;
    public final ConstraintLayout layoutExpired;
    public final RoundLinearLayout llTitle;
    private final LinearLayout rootView;
    public final TextView tvDeadline;
    public final TextView tvDuration;
    public final TextView tvMiss;
    public final TagTextView tvTitle;
    public final RoundTextView tvTotalScore;

    private ActivityPreviewQuestionHeaderBinding(LinearLayout linearLayout, ImageView imageView, ConstraintLayout constraintLayout, RoundLinearLayout roundLinearLayout, TextView textView, TextView textView2, TextView textView3, TagTextView tagTextView, RoundTextView roundTextView) {
        this.rootView = linearLayout;
        this.ivMiss = imageView;
        this.layoutExpired = constraintLayout;
        this.llTitle = roundLinearLayout;
        this.tvDeadline = textView;
        this.tvDuration = textView2;
        this.tvMiss = textView3;
        this.tvTitle = tagTextView;
        this.tvTotalScore = roundTextView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPreviewQuestionHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPreviewQuestionHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_preview_question_header;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTotalScore;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.layoutExpired;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.llTitle;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionHeaderBinding bind(android.view.View r12) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_miss
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.layoutExpired
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.llTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            com.flyco.roundview.RoundLinearLayout r6 = (com.flyco.roundview.RoundLinearLayout) r6
            if (r6 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDeadline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDuration
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_miss
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            com.tal.app.thinkacademy.lib.commui.widget.TagTextView r10 = (com.tal.app.thinkacademy.lib.commui.widget.TagTextView) r10
            if (r10 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTotalScore
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            com.flyco.roundview.RoundTextView r11 = (com.flyco.roundview.RoundTextView) r11
            if (r11 == 0) goto L_0x0062
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionHeaderBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionHeaderBinding
            r3 = r12
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0062:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionHeaderBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionHeaderBinding");
    }
}
