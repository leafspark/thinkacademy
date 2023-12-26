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

public final class ActivityExamNoteHeaderBinding implements ViewBinding {
    public final ImageView ivDivider;
    public final ImageView ivMiss;
    public final ConstraintLayout layoutExpired;
    public final RoundLinearLayout llTime;
    public final RoundLinearLayout llTitle;
    private final LinearLayout rootView;
    public final TextView tvDeadline;
    public final TextView tvDuration;
    public final TextView tvMiss;
    public final TextView tvTitle;
    public final RoundTextView tvTotalScore;

    private ActivityExamNoteHeaderBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, RoundLinearLayout roundLinearLayout, RoundLinearLayout roundLinearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, RoundTextView roundTextView) {
        this.rootView = linearLayout;
        this.ivDivider = imageView;
        this.ivMiss = imageView2;
        this.layoutExpired = constraintLayout;
        this.llTime = roundLinearLayout;
        this.llTitle = roundLinearLayout2;
        this.tvDeadline = textView;
        this.tvDuration = textView2;
        this.tvMiss = textView3;
        this.tvTitle = textView4;
        this.tvTotalScore = roundTextView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityExamNoteHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityExamNoteHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_exam_note_header;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTotalScore;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.layoutExpired;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.llTime;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.llTitle;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ActivityExamNoteHeaderBinding bind(android.view.View r14) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_divider
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_miss
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.layoutExpired
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.llTime
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            com.flyco.roundview.RoundLinearLayout r7 = (com.flyco.roundview.RoundLinearLayout) r7
            if (r7 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.llTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            com.flyco.roundview.RoundLinearLayout r8 = (com.flyco.roundview.RoundLinearLayout) r8
            if (r8 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDeadline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDuration
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_miss
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTotalScore
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r13 = r1
            com.flyco.roundview.RoundTextView r13 = (com.flyco.roundview.RoundTextView) r13
            if (r13 == 0) goto L_0x0078
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityExamNoteHeaderBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.ActivityExamNoteHeaderBinding
            r3 = r14
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x0078:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ActivityExamNoteHeaderBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ActivityExamNoteHeaderBinding");
    }
}
