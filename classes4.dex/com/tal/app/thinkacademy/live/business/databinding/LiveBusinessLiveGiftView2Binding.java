package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessLiveGiftView2Binding implements ViewBinding {
    public final ConstraintLayout clLiveBusinessGiftWidow;
    public final FrameLayout flGiftIndicator;
    public final ImageView ivLiveBusinessGiftSendToast;
    public final ImageView ivLiveBusinessGiftUserCoins;
    public final ImageView ivLiveBusinessGiftWindowClose;
    public final ImageView lavLiveBusinessGiftWindowShow;
    public final RelativeLayout rlLiveBusinessGiftToast;
    private final ConstraintLayout rootView;
    public final RecyclerView rvLiveBusinessGift;
    public final TextView tvLiveBusinessGiftCoins;
    public final TextView tvLiveBusinessGiftHint;
    public final TextView tvLiveBusinessGiftSend;
    public final TextView tvLiveBusinessGiftSendToast;
    public final View tvLiveBusinessGiftUnsend;
    public final TextView tvLiveBusinessGiftUserCoins;

    private LiveBusinessLiveGiftView2Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view, TextView textView5) {
        this.rootView = constraintLayout;
        this.clLiveBusinessGiftWidow = constraintLayout2;
        this.flGiftIndicator = frameLayout;
        this.ivLiveBusinessGiftSendToast = imageView;
        this.ivLiveBusinessGiftUserCoins = imageView2;
        this.ivLiveBusinessGiftWindowClose = imageView3;
        this.lavLiveBusinessGiftWindowShow = imageView4;
        this.rlLiveBusinessGiftToast = relativeLayout;
        this.rvLiveBusinessGift = recyclerView;
        this.tvLiveBusinessGiftCoins = textView;
        this.tvLiveBusinessGiftHint = textView2;
        this.tvLiveBusinessGiftSend = textView3;
        this.tvLiveBusinessGiftSendToast = textView4;
        this.tvLiveBusinessGiftUnsend = view;
        this.tvLiveBusinessGiftUserCoins = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLiveGiftView2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLiveGiftView2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_live_gift_view2;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.rv_live_business_gift;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_gift_unsend;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveGiftView2Binding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_gift_widow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.fl_gift_indicator
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            if (r6 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_gift_send_toast
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_gift_user_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_gift_window_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.lav_live_business_gift_window_show
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_gift_toast
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            if (r11 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rv_live_business_gift
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            if (r12 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_gift_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_gift_hint
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_gift_send
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_gift_send_toast
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_gift_unsend
            android.view.View r17 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r17 == 0) goto L_0x00a5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_gift_user_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00a5
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveGiftView2Binding r1 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveGiftView2Binding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        L_0x00a5:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveGiftView2Binding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveGiftView2Binding");
    }
}
