package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessActivityTakePhotoBinding implements ViewBinding {
    public final SurfaceView cameraPreview;
    public final ConstraintLayout clPreview;
    public final ConstraintLayout clRootView;
    public final ImageView ivBack;
    public final ImageView ivSwitch;
    public final ImageView ivTakePhoto;
    public final RoundLinearLayout llCountdown;
    public final LinearLayout llTitleBar;
    private final ConstraintLayout rootView;
    public final TextView tvCountdown;

    private LiveBusinessActivityTakePhotoBinding(ConstraintLayout constraintLayout, SurfaceView surfaceView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, RoundLinearLayout roundLinearLayout, LinearLayout linearLayout, TextView textView) {
        this.rootView = constraintLayout;
        this.cameraPreview = surfaceView;
        this.clPreview = constraintLayout2;
        this.clRootView = constraintLayout3;
        this.ivBack = imageView;
        this.ivSwitch = imageView2;
        this.ivTakePhoto = imageView3;
        this.llCountdown = roundLinearLayout;
        this.llTitleBar = linearLayout;
        this.tvCountdown = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessActivityTakePhotoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessActivityTakePhotoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_activity_take_photo;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.llCountdown;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.clPreview;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityTakePhotoBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.cameraPreview
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.view.SurfaceView r4 = (android.view.SurfaceView) r4
            if (r4 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.clPreview
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0063
            r6 = r13
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivBack
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivSwitch
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivTakePhoto
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.llCountdown
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            com.flyco.roundview.RoundLinearLayout r10 = (com.flyco.roundview.RoundLinearLayout) r10
            if (r10 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.llTitleBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvCountdown
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0063
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityTakePhotoBinding r13 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityTakePhotoBinding
            r2 = r13
            r3 = r6
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        L_0x0063:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityTakePhotoBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityTakePhotoBinding");
    }
}
