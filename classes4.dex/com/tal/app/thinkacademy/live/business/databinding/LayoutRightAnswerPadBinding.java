package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LayoutRightAnswerPadBinding implements ViewBinding {
    public final ImageView ivLevel1;
    public final ImageView ivLevel2;
    public final ImageView ivLevel3;
    public final ImageView ivLevel4;
    public final ImageView ivLevel5;
    public final ImageView ivLevel6;
    public final ImageView ivNextLevel;
    public final ImageView ivNextPointer;
    public final ImageView ivResultClose;
    public final ImageView ivResultCurrLevel;
    public final ImageView ivResultRightCoins;
    private final ConstraintLayout rootView;
    public final TextView tvResultRightCoins;
    public final TextView tvResultText;
    public final View viewResultRight;
    public final View viewResultRightCoins;
    public final View viewResultRightCoinsPoint;
    public final View viewResultRightInner;

    private LayoutRightAnswerPadBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, TextView textView, TextView textView2, View view, View view2, View view3, View view4) {
        this.rootView = constraintLayout;
        this.ivLevel1 = imageView;
        this.ivLevel2 = imageView2;
        this.ivLevel3 = imageView3;
        this.ivLevel4 = imageView4;
        this.ivLevel5 = imageView5;
        this.ivLevel6 = imageView6;
        this.ivNextLevel = imageView7;
        this.ivNextPointer = imageView8;
        this.ivResultClose = imageView9;
        this.ivResultCurrLevel = imageView10;
        this.ivResultRightCoins = imageView11;
        this.tvResultRightCoins = textView;
        this.tvResultText = textView2;
        this.viewResultRight = view;
        this.viewResultRightCoins = view2;
        this.viewResultRightCoinsPoint = view3;
        this.viewResultRightInner = view4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutRightAnswerPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutRightAnswerPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_right_answer_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.view_result_right;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.view_result_right_coins;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a3, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.view_result_right_coins_point;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ab, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.view_result_right_inner;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutRightAnswerPadBinding bind(android.view.View r22) {
        /*
            r0 = r22
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_level_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_level_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_level_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_level_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_level_5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_level_6
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_next_level
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_next_pointer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_result_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_result_curr_level
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_result_right_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_result_right_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_result_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.view_result_right
            android.view.View r18 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r18 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.view_result_right_coins
            android.view.View r19 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r19 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.view_result_right_coins_point
            android.view.View r20 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r20 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.view_result_right_inner
            android.view.View r21 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r21 == 0) goto L_0x00bd
            com.tal.app.thinkacademy.live.business.databinding.LayoutRightAnswerPadBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LayoutRightAnswerPadBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r1
        L_0x00bd:
            android.content.res.Resources r0 = r22.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutRightAnswerPadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutRightAnswerPadBinding");
    }
}
