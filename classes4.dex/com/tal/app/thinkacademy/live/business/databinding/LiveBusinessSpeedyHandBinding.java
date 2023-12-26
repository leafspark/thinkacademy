package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessSpeedyHandBinding implements ViewBinding {
    public final ImageView avator;
    public final LottieAnimationView lottie;
    public final LottieAnimationView lottiePreload;
    private final ConstraintLayout rootView;
    public final ConstraintLayout speedyHandBg;
    public final TextView tvName;
    public final TextView tvNoBody;

    private LiveBusinessSpeedyHandBinding(ConstraintLayout constraintLayout, ImageView imageView, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.avator = imageView;
        this.lottie = lottieAnimationView;
        this.lottiePreload = lottieAnimationView2;
        this.speedyHandBg = constraintLayout2;
        this.tvName = textView;
        this.tvNoBody = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessSpeedyHandBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessSpeedyHandBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_speedy_hand;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottie;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottiePreload;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessSpeedyHandBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.avator
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottie
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            com.airbnb.lottie.LottieAnimationView r5 = (com.airbnb.lottie.LottieAnimationView) r5
            if (r5 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottiePreload
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            com.airbnb.lottie.LottieAnimationView r6 = (com.airbnb.lottie.LottieAnimationView) r6
            if (r6 == 0) goto L_0x0042
            r7 = r10
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvNoBody
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0042
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessSpeedyHandBinding r10 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessSpeedyHandBinding
            r2 = r10
            r3 = r7
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r10
        L_0x0042:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessSpeedyHandBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessSpeedyHandBinding");
    }
}
