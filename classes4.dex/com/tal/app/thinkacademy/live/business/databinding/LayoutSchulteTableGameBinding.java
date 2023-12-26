package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.google.android.flexbox.FlexboxLayout;
import com.tal.app.thinkacademy.live.business.R;

public final class LayoutSchulteTableGameBinding implements ViewBinding {
    public final RoundTextView bgTable;
    public final FlexboxLayout flexBox;
    public final FrameLayout layoutClickAnimation;
    public final LinearLayout layoutGameRightBoard;
    public final FrameLayout layoutGuide;
    public final LottieAnimationView lottieAnswer;
    private final ConstraintLayout rootView;
    public final TextView tvChronometer;
    public final TextView tvGameProgress;
    public final RoundTextView tvGameTitle;
    public final TextView tvSchulteMode;

    private LayoutSchulteTableGameBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, FlexboxLayout flexboxLayout, FrameLayout frameLayout, LinearLayout linearLayout, FrameLayout frameLayout2, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2, RoundTextView roundTextView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.bgTable = roundTextView;
        this.flexBox = flexboxLayout;
        this.layoutClickAnimation = frameLayout;
        this.layoutGameRightBoard = linearLayout;
        this.layoutGuide = frameLayout2;
        this.lottieAnswer = lottieAnimationView;
        this.tvChronometer = textView;
        this.tvGameProgress = textView2;
        this.tvGameTitle = roundTextView2;
        this.tvSchulteMode = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSchulteTableGameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutSchulteTableGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_schulte_table_game;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_answer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.tv_game_title;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.flex_box;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableGameBinding bind(android.view.View r14) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.bg_table
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            com.flyco.roundview.RoundTextView r4 = (com.flyco.roundview.RoundTextView) r4
            if (r4 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.flex_box
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r5 = r1
            com.google.android.flexbox.FlexboxLayout r5 = (com.google.android.flexbox.FlexboxLayout) r5
            if (r5 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_click_animation
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            if (r6 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_game_right_board
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_guide
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            if (r8 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_answer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            com.airbnb.lottie.LottieAnimationView r9 = (com.airbnb.lottie.LottieAnimationView) r9
            if (r9 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_chronometer
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_game_progress
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_game_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            com.flyco.roundview.RoundTextView r12 = (com.flyco.roundview.RoundTextView) r12
            if (r12 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_schulte_mode
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0078
            com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableGameBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableGameBinding
            r3 = r14
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableGameBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableGameBinding");
    }
}
