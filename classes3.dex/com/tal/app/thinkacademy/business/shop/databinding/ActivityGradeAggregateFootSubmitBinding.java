package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.shop.R;

public final class ActivityGradeAggregateFootSubmitBinding implements ViewBinding {
    public final TextView dayPrompt;
    public final EditText editEmail;
    public final EditText editName;
    public final TextView emailPrompt;
    public final TextView groupPrompt;
    public final ImageView ivSeleted;
    public final RoundLinearLayout llEdit;
    public final LinearLayout llSeleted;
    public final TextView namePrompt;
    public final RoundRelativeLayout rlDay;
    public final RoundRelativeLayout rlEmail;
    public final RoundRelativeLayout rlGroup;
    public final RoundRelativeLayout rlName;
    public final RoundRelativeLayout rlTime;
    private final ConstraintLayout rootView;
    public final TextView timePrompt;
    public final TextView tvDay;
    public final TextView tvGroup;
    public final RoundTextView tvSubmit;
    public final TextView tvTime;
    public final TextView tvTitle;

    private ActivityGradeAggregateFootSubmitBinding(ConstraintLayout constraintLayout, TextView textView, EditText editText, EditText editText2, TextView textView2, TextView textView3, ImageView imageView, RoundLinearLayout roundLinearLayout, LinearLayout linearLayout, TextView textView4, RoundRelativeLayout roundRelativeLayout, RoundRelativeLayout roundRelativeLayout2, RoundRelativeLayout roundRelativeLayout3, RoundRelativeLayout roundRelativeLayout4, RoundRelativeLayout roundRelativeLayout5, TextView textView5, TextView textView6, TextView textView7, RoundTextView roundTextView, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.dayPrompt = textView;
        this.editEmail = editText;
        this.editName = editText2;
        this.emailPrompt = textView2;
        this.groupPrompt = textView3;
        this.ivSeleted = imageView;
        this.llEdit = roundLinearLayout;
        this.llSeleted = linearLayout;
        this.namePrompt = textView4;
        this.rlDay = roundRelativeLayout;
        this.rlEmail = roundRelativeLayout2;
        this.rlGroup = roundRelativeLayout3;
        this.rlName = roundRelativeLayout4;
        this.rlTime = roundRelativeLayout5;
        this.timePrompt = textView5;
        this.tvDay = textView6;
        this.tvGroup = textView7;
        this.tvSubmit = roundTextView;
        this.tvTime = textView8;
        this.tvTitle = textView9;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityGradeAggregateFootSubmitBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityGradeAggregateFootSubmitBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_grade_aggregate_foot_submit;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.llEdit;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.rlDay;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.rlEmail;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.rlGroup;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.rlName;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.rlTime;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.tvSubmit;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateFootSubmitBinding bind(android.view.View r25) {
        /*
            r0 = r25
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.dayPrompt
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.editEmail
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.EditText r6 = (android.widget.EditText) r6
            if (r6 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.editName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.EditText r7 = (android.widget.EditText) r7
            if (r7 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.emailPrompt
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.groupPrompt
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.ivSeleted
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.llEdit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.flyco.roundview.RoundLinearLayout r11 = (com.flyco.roundview.RoundLinearLayout) r11
            if (r11 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.llSeleted
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.namePrompt
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.rlDay
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            com.flyco.roundview.RoundRelativeLayout r14 = (com.flyco.roundview.RoundRelativeLayout) r14
            if (r14 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.rlEmail
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.flyco.roundview.RoundRelativeLayout r15 = (com.flyco.roundview.RoundRelativeLayout) r15
            if (r15 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.rlGroup
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.flyco.roundview.RoundRelativeLayout r16 = (com.flyco.roundview.RoundRelativeLayout) r16
            if (r16 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.rlName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.flyco.roundview.RoundRelativeLayout r17 = (com.flyco.roundview.RoundRelativeLayout) r17
            if (r17 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.rlTime
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.flyco.roundview.RoundRelativeLayout r18 = (com.flyco.roundview.RoundRelativeLayout) r18
            if (r18 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.timePrompt
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvDay
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvGroup
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvSubmit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            com.flyco.roundview.RoundTextView r22 = (com.flyco.roundview.RoundTextView) r22
            if (r22 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvTime
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x00f1
            com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateFootSubmitBinding r1 = new com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateFootSubmitBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r1
        L_0x00f1:
            android.content.res.Resources r0 = r25.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateFootSubmitBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ActivityGradeAggregateFootSubmitBinding");
    }
}
