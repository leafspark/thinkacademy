package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.view.HandUpPadView;

public final class LiveBusinessViewMediaControllerLiveBottomPadBinding implements ViewBinding {
    public final ConstraintLayout clLiveBusinessLiveRaiseYourHand;
    public final ConstraintLayout clMediaControllerRootBottom;
    public final RoundRelativeLayout handUpDisable;
    public final ImageView ivLiveBusinessLiveScreenshot;
    public final HandUpPadView rlLiveBusinessLiveHanduppadview;
    public final RelativeLayout rlLiveBusinessLiveRaiseYourHand;
    private final ConstraintLayout rootView;
    public final TextView tvMediaControllerTime;

    private LiveBusinessViewMediaControllerLiveBottomPadBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, RoundRelativeLayout roundRelativeLayout, ImageView imageView, HandUpPadView handUpPadView, RelativeLayout relativeLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.clLiveBusinessLiveRaiseYourHand = constraintLayout2;
        this.clMediaControllerRootBottom = constraintLayout3;
        this.handUpDisable = roundRelativeLayout;
        this.ivLiveBusinessLiveScreenshot = imageView;
        this.rlLiveBusinessLiveHanduppadview = handUpPadView;
        this.rlLiveBusinessLiveRaiseYourHand = relativeLayout;
        this.tvMediaControllerTime = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewMediaControllerLiveBottomPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewMediaControllerLiveBottomPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_media_controller_live_bottom_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_live_handuppadview;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerLiveBottomPadBinding bind(android.view.View r11) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_live_raise_your_hand
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x004d
            r5 = r11
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            int r0 = com.tal.app.thinkacademy.live.business.R.id.handUpDisable
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            com.flyco.roundview.RoundRelativeLayout r6 = (com.flyco.roundview.RoundRelativeLayout) r6
            if (r6 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_live_screenshot
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_live_handuppadview
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            com.tal.app.thinkacademy.live.view.HandUpPadView r8 = (com.tal.app.thinkacademy.live.view.HandUpPadView) r8
            if (r8 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_live_raise_your_hand
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            if (r9 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_media_controller_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x004d
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerLiveBottomPadBinding r11 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerLiveBottomPadBinding
            r2 = r11
            r3 = r5
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        L_0x004d:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerLiveBottomPadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerLiveBottomPadBinding");
    }
}
