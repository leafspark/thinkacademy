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

public final class LiveBusinessDirectionGoldNewViewBinding implements ViewBinding {
    public final LottieAnimationView directionGoldLottie;
    public final ConstraintLayout directionOtherGoldCL;
    public final ImageView directionOtherGoldIV;
    public final TextView directionOtherGoldTV;
    public final TextView directionOtherNameTV;
    private final ConstraintLayout rootView;

    private LiveBusinessDirectionGoldNewViewBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.directionGoldLottie = lottieAnimationView;
        this.directionOtherGoldCL = constraintLayout2;
        this.directionOtherGoldIV = imageView;
        this.directionOtherGoldTV = textView;
        this.directionOtherNameTV = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessDirectionGoldNewViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessDirectionGoldNewViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_direction_gold_new_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.directionOtherGoldCL;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.directionGoldLottie
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            com.airbnb.lottie.LottieAnimationView r4 = (com.airbnb.lottie.LottieAnimationView) r4
            if (r4 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.directionOtherGoldCL
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.directionOtherGoldIV
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.directionOtherGoldTV
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.directionOtherNameTV
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0041
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0041:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDirectionGoldNewViewBinding");
    }
}
