package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessPraiseViewBinding implements ViewBinding {
    public final Group groupLiveBusinessMedal;
    public final ImageView ivLiveBusinessAvatar;
    public final ImageView ivLiveBusinessBg;
    public final LottieAnimationView ivLiveBusinessBox;
    public final ImageView ivLiveBusinessCoins;
    public final ImageView ivLiveBusinessMedal;
    public final ImageView ivLiveBusinessPraiseClose;
    public final ImageView ivLiveBusinessPraiseTiny;
    public final RoundLinearLayout llLiveBusinessName;
    public final ConstraintLayout llLiveBusinessPraise;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessCoins;
    public final TextView tvLiveBusinessContent;
    public final TextView tvLiveBusinessName;
    public final TextView tvLiveBusinessOnlyCoins;
    public final TextView tvLiveBusinessTitle;
    public final View vLiveBusinessBg;

    private LiveBusinessPraiseViewBinding(ConstraintLayout constraintLayout, Group group, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, RoundLinearLayout roundLinearLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view) {
        this.rootView = constraintLayout;
        this.groupLiveBusinessMedal = group;
        this.ivLiveBusinessAvatar = imageView;
        this.ivLiveBusinessBg = imageView2;
        this.ivLiveBusinessBox = lottieAnimationView;
        this.ivLiveBusinessCoins = imageView3;
        this.ivLiveBusinessMedal = imageView4;
        this.ivLiveBusinessPraiseClose = imageView5;
        this.ivLiveBusinessPraiseTiny = imageView6;
        this.llLiveBusinessName = roundLinearLayout;
        this.llLiveBusinessPraise = constraintLayout2;
        this.tvLiveBusinessCoins = textView;
        this.tvLiveBusinessContent = textView2;
        this.tvLiveBusinessName = textView3;
        this.tvLiveBusinessOnlyCoins = textView4;
        this.tvLiveBusinessTitle = textView5;
        this.vLiveBusinessBg = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPraiseViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPraiseViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_praise_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.ll_live_business_name;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.ll_live_business_praise;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_bg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_box;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPraiseViewBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.tal.app.thinkacademy.live.business.R.id.group_live_business_medal
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.Group r5 = (androidx.constraintlayout.widget.Group) r5
            if (r5 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_avatar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_box
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.airbnb.lottie.LottieAnimationView r8 = (com.airbnb.lottie.LottieAnimationView) r8
            if (r8 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_medal
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_praise_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_praise_tiny
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ll_live_business_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.flyco.roundview.RoundLinearLayout r13 = (com.flyco.roundview.RoundLinearLayout) r13
            if (r13 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ll_live_business_praise
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_only_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00bd
            int r1 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_bg
            android.view.View r20 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r20 == 0) goto L_0x00bd
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPraiseViewBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPraiseViewBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPraiseViewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPraiseViewBinding");
    }
}
