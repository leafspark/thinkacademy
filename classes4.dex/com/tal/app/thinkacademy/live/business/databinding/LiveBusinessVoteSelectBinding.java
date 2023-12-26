package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;

public final class LiveBusinessVoteSelectBinding implements ViewBinding {
    public final ImageView ivLiveBusinessTopicBg;
    public final ImageView ivPageLivevideoVoteOpen;
    public final ConstraintLayout layoutBottom;
    public final ImageView liveBusinessVoteAnswerClose;
    public final FrameLayout liveBusinessVoteAnswerCloseLayout;
    public final ConstraintLayout mRelativeLayout;
    public final RadioButton rb1PageLivevideoVoteSelect;
    public final RadioButton rb2PageLivevideoVoteSelect;
    public final RadioButton rb3PageLivevideoVoteSelect;
    public final RadioButton rb4PageLivevideoVoteSelect;
    public final RadioButton rb5PageLivevideoVoteSelect;
    public final RadioButton rb6PageLivevideoVoteSelect;
    public final RadioGroup rgPageLivevideoVoteSelect;
    public final LinearLayout rlLiveBusinessVoteAnswer;
    public final RelativeLayout rlPageLivevideoVoteSelect;
    public final TextView rlPageLivevideoVoteTitle;
    private final ConstraintLayout rootView;
    public final SubmitResultView submitResultView;
    public final TextView tvLiveBusinessVoteSubmit;
    public final View view;

    private LiveBusinessVoteSelectBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ImageView imageView3, FrameLayout frameLayout, ConstraintLayout constraintLayout3, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, RadioGroup radioGroup, LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, SubmitResultView submitResultView2, TextView textView2, View view2) {
        this.rootView = constraintLayout;
        this.ivLiveBusinessTopicBg = imageView;
        this.ivPageLivevideoVoteOpen = imageView2;
        this.layoutBottom = constraintLayout2;
        this.liveBusinessVoteAnswerClose = imageView3;
        this.liveBusinessVoteAnswerCloseLayout = frameLayout;
        this.mRelativeLayout = constraintLayout3;
        this.rb1PageLivevideoVoteSelect = radioButton;
        this.rb2PageLivevideoVoteSelect = radioButton2;
        this.rb3PageLivevideoVoteSelect = radioButton3;
        this.rb4PageLivevideoVoteSelect = radioButton4;
        this.rb5PageLivevideoVoteSelect = radioButton5;
        this.rb6PageLivevideoVoteSelect = radioButton6;
        this.rgPageLivevideoVoteSelect = radioGroup;
        this.rlLiveBusinessVoteAnswer = linearLayout;
        this.rlPageLivevideoVoteSelect = relativeLayout;
        this.rlPageLivevideoVoteTitle = textView;
        this.submitResultView = submitResultView2;
        this.tvLiveBusinessVoteSubmit = textView2;
        this.view = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessVoteSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessVoteSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_vote_select;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c7, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.layout_bottom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSelectBinding bind(android.view.View r24) {
        /*
            r0 = r24
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_topic_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_page_livevideo_vote_open
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layout_bottom
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.live_business_vote_answer_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.live_business_vote_answer_close_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.FrameLayout r9 = (android.widget.FrameLayout) r9
            if (r9 == 0) goto L_0x00d7
            r10 = r0
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rb_1_page_livevideo_vote_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.RadioButton r11 = (android.widget.RadioButton) r11
            if (r11 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rb_2_page_livevideo_vote_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.RadioButton r12 = (android.widget.RadioButton) r12
            if (r12 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rb_3_page_livevideo_vote_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.RadioButton r13 = (android.widget.RadioButton) r13
            if (r13 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rb_4_page_livevideo_vote_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.RadioButton r14 = (android.widget.RadioButton) r14
            if (r14 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rb_5_page_livevideo_vote_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.RadioButton r15 = (android.widget.RadioButton) r15
            if (r15 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rb_6_page_livevideo_vote_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.RadioButton r16 = (android.widget.RadioButton) r16
            if (r16 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rg_page_livevideo_vote_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.RadioGroup r17 = (android.widget.RadioGroup) r17
            if (r17 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_vote_answer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.LinearLayout r18 = (android.widget.LinearLayout) r18
            if (r18 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_page_livevideo_vote_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.RelativeLayout r19 = (android.widget.RelativeLayout) r19
            if (r19 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_page_livevideo_vote_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.submit_result_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView r21 = (com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView) r21
            if (r21 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_vote_submit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00d7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.view
            android.view.View r23 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r23 == 0) goto L_0x00d7
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSelectBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSelectBinding
            r3 = r0
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r0
        L_0x00d7:
            android.content.res.Resources r0 = r24.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSelectBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSelectBinding");
    }
}
