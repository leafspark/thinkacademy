package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessLiveTopicViewBinding implements ViewBinding {
    public final ConstraintLayout clLiveBusinessTopicRoot;
    public final FrameLayout flResultRoot;
    public final View guideLine;
    public final ImageView ivLiveBusinessTopicAnswerClose;
    public final ImageView ivLiveBusinessTopicBg;
    public final ImageView ivLiveBusinessTopicController;
    public final ConstraintLayout layoutBottom;
    public final RelativeLayout rlLiveBusinessTopicParent;
    public final RelativeLayout rlLiveBusinessTopicRightAnswer;
    public final RelativeLayout rlLiveBusinessTopicYourAnswer;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessTopicCountdown;
    public final TextView tvLiveBusinessTopicSubmit;
    public final View viesResultBackground;
    public final View view;
    public final View viewLiveBusinessClickMask;

    private LiveBusinessLiveTopicViewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, View view2, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2, View view3, View view4, View view5) {
        this.rootView = constraintLayout;
        this.clLiveBusinessTopicRoot = constraintLayout2;
        this.flResultRoot = frameLayout;
        this.guideLine = view2;
        this.ivLiveBusinessTopicAnswerClose = imageView;
        this.ivLiveBusinessTopicBg = imageView2;
        this.ivLiveBusinessTopicController = imageView3;
        this.layoutBottom = constraintLayout3;
        this.rlLiveBusinessTopicParent = relativeLayout;
        this.rlLiveBusinessTopicRightAnswer = relativeLayout2;
        this.rlLiveBusinessTopicYourAnswer = relativeLayout3;
        this.tvLiveBusinessTopicCountdown = textView;
        this.tvLiveBusinessTopicSubmit = textView2;
        this.viesResultBackground = view3;
        this.view = view4;
        this.viewLiveBusinessClickMask = view5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLiveTopicViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLiveTopicViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_live_topic_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.layout_bottom;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.vies_result_background;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0081, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.view_live_business_click_mask;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.guide_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveTopicViewBinding bind(android.view.View r18) {
        /*
            r0 = r18
            r2 = r0
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            int r1 = com.tal.app.thinkacademy.live.business.R.id.fl_result_root
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            if (r3 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.guide_line
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r4 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_topic_answer_close
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_topic_bg
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_topic_controller
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layout_bottom
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_topic_parent
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            if (r9 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_topic_right_answer
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            if (r10 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_topic_your_answer
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            if (r11 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_topic_countdown
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_topic_submit
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.vies_result_background
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r14 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.view
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r15 == 0) goto L_0x0092
            int r1 = com.tal.app.thinkacademy.live.business.R.id.view_live_business_click_mask
            android.view.View r16 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r16 == 0) goto L_0x0092
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveTopicViewBinding r17 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveTopicViewBinding
            r0 = r17
            r1 = r2
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r17
        L_0x0092:
            android.content.res.Resources r0 = r18.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveTopicViewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveTopicViewBinding");
    }
}
