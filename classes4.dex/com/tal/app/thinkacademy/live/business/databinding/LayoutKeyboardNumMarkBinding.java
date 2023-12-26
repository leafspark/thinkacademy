package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText;

public final class LayoutKeyboardNumMarkBinding implements ViewBinding {
    public final ImageView bgAnswer;
    public final TextView btnSubmit;
    public final ImageView btnToggleShow;
    public final FillInEditText etInputDenominator;
    public final FillInEditText etInputNumerator;
    public final FillInEditText etInputText;
    public final Group groupAnswer;
    public final ImageView imScoreLine;
    public final ImageView ivAnswer;
    public final ImageView ivTopBgBook;
    public final LinearLayout layoutAnswer;
    public final ConstraintLayout layoutInput;
    public final LinearLayout llInputFraction;
    public final RecyclerView recyclerKeyboard;
    private final ConstraintLayout rootView;
    public final TextView tvInputHint;
    public final View viewTop;

    private LayoutKeyboardNumMarkBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ImageView imageView2, FillInEditText fillInEditText, FillInEditText fillInEditText2, FillInEditText fillInEditText3, Group group, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView2, View view) {
        this.rootView = constraintLayout;
        this.bgAnswer = imageView;
        this.btnSubmit = textView;
        this.btnToggleShow = imageView2;
        this.etInputDenominator = fillInEditText;
        this.etInputNumerator = fillInEditText2;
        this.etInputText = fillInEditText3;
        this.groupAnswer = group;
        this.imScoreLine = imageView3;
        this.ivAnswer = imageView4;
        this.ivTopBgBook = imageView5;
        this.layoutAnswer = linearLayout;
        this.layoutInput = constraintLayout2;
        this.llInputFraction = linearLayout2;
        this.recyclerKeyboard = recyclerView;
        this.tvInputHint = textView2;
        this.viewTop = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutKeyboardNumMarkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutKeyboardNumMarkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_keyboard_num_mark;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.group_answer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.layout_input;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.recycler_keyboard;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.view_top;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutKeyboardNumMarkBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bg_answer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.btn_submit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.btn_toggle_show
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.et_input_denominator
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r8 = (com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText) r8
            if (r8 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.et_input_numerator
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r9 = (com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText) r9
            if (r9 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.et_input_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText r10 = (com.tal.app.thinkacademy.live.business.keyboardfill.keyboard.FillInEditText) r10
            if (r10 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.group_answer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.Group r11 = (androidx.constraintlayout.widget.Group) r11
            if (r11 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.im_score_line
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_answer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_top_bg_book
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layout_answer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            if (r15 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layout_input
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.ConstraintLayout r16 = (androidx.constraintlayout.widget.ConstraintLayout) r16
            if (r16 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ll_input_fraction
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.LinearLayout r17 = (android.widget.LinearLayout) r17
            if (r17 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.recycler_keyboard
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            androidx.recyclerview.widget.RecyclerView r18 = (androidx.recyclerview.widget.RecyclerView) r18
            if (r18 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_input_hint
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.view_top
            android.view.View r20 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r20 == 0) goto L_0x00bd
            com.tal.app.thinkacademy.live.business.databinding.LayoutKeyboardNumMarkBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LayoutKeyboardNumMarkBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x00bd:
            android.content.res.Resources r0 = r21.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutKeyboardNumMarkBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutKeyboardNumMarkBinding");
    }
}
