package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;

public final class LiveBusinessPhotosOnTheWallBinding implements ViewBinding {
    public final ImageView ivCamera;
    public final ImageView ivPromptClose;
    public final SubmitResultView layoutAwardView;
    public final RelativeLayout layoutTakePhoto;
    public final RoundLinearLayout llCameraSettings;
    public final RoundLinearLayout llCountdown;
    public final RelativeLayout llPrompt;
    public final RelativeLayout llResultFaild;
    private final FrameLayout rootView;
    public final TextView tvCountdown;

    private LiveBusinessPhotosOnTheWallBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, SubmitResultView submitResultView, RelativeLayout relativeLayout, RoundLinearLayout roundLinearLayout, RoundLinearLayout roundLinearLayout2, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView) {
        this.rootView = frameLayout;
        this.ivCamera = imageView;
        this.ivPromptClose = imageView2;
        this.layoutAwardView = submitResultView;
        this.layoutTakePhoto = relativeLayout;
        this.llCameraSettings = roundLinearLayout;
        this.llCountdown = roundLinearLayout2;
        this.llPrompt = relativeLayout2;
        this.llResultFaild = relativeLayout3;
        this.tvCountdown = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPhotosOnTheWallBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPhotosOnTheWallBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_photos_on_the_wall;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.llCountdown;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.llCameraSettings;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivCamera
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivPromptClose
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layoutAwardView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView r6 = (com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView) r6
            if (r6 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layoutTakePhoto
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            if (r7 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.llCameraSettings
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            com.flyco.roundview.RoundLinearLayout r8 = (com.flyco.roundview.RoundLinearLayout) r8
            if (r8 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.llCountdown
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            com.flyco.roundview.RoundLinearLayout r9 = (com.flyco.roundview.RoundLinearLayout) r9
            if (r9 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.llPrompt
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            if (r10 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.llResultFaild
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            if (r11 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvCountdown
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x006d
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallBinding
            r3 = r13
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006d:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallBinding");
    }
}
