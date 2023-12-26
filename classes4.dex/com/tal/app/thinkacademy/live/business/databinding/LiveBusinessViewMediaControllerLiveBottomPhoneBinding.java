package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.view.HandUpPhoneView;

public final class LiveBusinessViewMediaControllerLiveBottomPhoneBinding implements ViewBinding {
    public final ConstraintLayout clMediaControllerRootBottom;
    public final RoundLinearLayout handUpDisable;
    public final ImageView ivLiveBusinessLiveMsgReply;
    public final ImageView ivLiveBusinessLiveMsgTeacherOnly;
    public final LinearLayout llLiveBusinessLiveMsgInput;
    public final RelativeLayout rlLiveBusinessLiveMsgInputGroup;
    public final HandUpPhoneView rlLiveBusinessLiveRaiseYourHand;
    private final ConstraintLayout rootView;
    public final TextView tvClose;
    public final TextView tvIrcConnecting;
    public final TextView tvLiveBusinessLiveMsgInputPrivate;
    public final TextView tvMediaControllerTime;
    public final TextView tvSaySomething;

    private LiveBusinessViewMediaControllerLiveBottomPhoneBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RoundLinearLayout roundLinearLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, RelativeLayout relativeLayout, HandUpPhoneView handUpPhoneView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.clMediaControllerRootBottom = constraintLayout2;
        this.handUpDisable = roundLinearLayout;
        this.ivLiveBusinessLiveMsgReply = imageView;
        this.ivLiveBusinessLiveMsgTeacherOnly = imageView2;
        this.llLiveBusinessLiveMsgInput = linearLayout;
        this.rlLiveBusinessLiveMsgInputGroup = relativeLayout;
        this.rlLiveBusinessLiveRaiseYourHand = handUpPhoneView;
        this.tvClose = textView;
        this.tvIrcConnecting = textView2;
        this.tvLiveBusinessLiveMsgInputPrivate = textView3;
        this.tvMediaControllerTime = textView4;
        this.tvSaySomething = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewMediaControllerLiveBottomPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewMediaControllerLiveBottomPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_media_controller_live_bottom_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_live_raise_your_hand;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerLiveBottomPhoneBinding bind(android.view.View r14) {
        /*
            r2 = r14
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            int r0 = com.tal.app.thinkacademy.live.business.R.id.handUpDisable
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r3 = r1
            com.flyco.roundview.RoundLinearLayout r3 = (com.flyco.roundview.RoundLinearLayout) r3
            if (r3 == 0) goto L_0x0084
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_live_msg_reply
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0084
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_live_msg_teacher_only
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0084
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ll_live_business_live_msg_input
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x0084
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_live_msg_input_group
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            if (r7 == 0) goto L_0x0084
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_live_raise_your_hand
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            com.tal.app.thinkacademy.live.view.HandUpPhoneView r8 = (com.tal.app.thinkacademy.live.view.HandUpPhoneView) r8
            if (r8 == 0) goto L_0x0084
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0084
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_irc_connecting
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0084
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_live_msg_input_private
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0084
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_media_controller_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0084
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_say_something
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0084
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerLiveBottomPhoneBinding r14 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerLiveBottomPhoneBinding
            r0 = r14
            r1 = r2
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r14
        L_0x0084:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerLiveBottomPhoneBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerLiveBottomPhoneBinding");
    }
}
