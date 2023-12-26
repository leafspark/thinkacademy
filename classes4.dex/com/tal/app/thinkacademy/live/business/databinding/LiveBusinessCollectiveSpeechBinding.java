package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessCollectiveSpeechBinding implements ViewBinding {
    public final LottieAnimationView ivLottieSpeechMic;
    public final ImageView ivSpeechMic;
    public final ImageView ivSpeechPrompt;
    public final ImageView ivSpeechSettings;
    public final RoundLinearLayout llSpeechSettings;
    public final RelativeLayout rlSpeechMic;
    private final RelativeLayout rootView;
    public final RoundTextView tvSpeechShutDown;

    private LiveBusinessCollectiveSpeechBinding(RelativeLayout relativeLayout, LottieAnimationView lottieAnimationView, ImageView imageView, ImageView imageView2, ImageView imageView3, RoundLinearLayout roundLinearLayout, RelativeLayout relativeLayout2, RoundTextView roundTextView) {
        this.rootView = relativeLayout;
        this.ivLottieSpeechMic = lottieAnimationView;
        this.ivSpeechMic = imageView;
        this.ivSpeechPrompt = imageView2;
        this.ivSpeechSettings = imageView3;
        this.llSpeechSettings = roundLinearLayout;
        this.rlSpeechMic = relativeLayout2;
        this.tvSpeechShutDown = roundTextView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessCollectiveSpeechBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessCollectiveSpeechBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_collective_speech;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.tvSpeechShutDown;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.llSpeechSettings;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessCollectiveSpeechBinding bind(android.view.View r11) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivLottieSpeechMic
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            com.airbnb.lottie.LottieAnimationView r4 = (com.airbnb.lottie.LottieAnimationView) r4
            if (r4 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivSpeechMic
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivSpeechPrompt
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivSpeechSettings
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.llSpeechSettings
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            com.flyco.roundview.RoundLinearLayout r8 = (com.flyco.roundview.RoundLinearLayout) r8
            if (r8 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rlSpeechMic
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            if (r9 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvSpeechShutDown
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            com.flyco.roundview.RoundTextView r10 = (com.flyco.roundview.RoundTextView) r10
            if (r10 == 0) goto L_0x0057
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessCollectiveSpeechBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessCollectiveSpeechBinding
            r3 = r11
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0057:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessCollectiveSpeechBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessCollectiveSpeechBinding");
    }
}
