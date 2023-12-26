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

public final class LiveBusinessActivityPreviewBinding implements ViewBinding {
    public final ImageView cameraPreview;
    public final ConstraintLayout clRootView;
    public final ImageView ivBack;
    public final ImageView ivRetake;
    public final ImageView ivSubmit;
    public final RoundLinearLayout llCountdown;
    public final LinearLayout llRetake;
    public final RoundLinearLayout llSubmissionFailed;
    public final LinearLayout llSubmit;
    public final LinearLayout llTitleBar;
    public final RelativeLayout rlCameraPreview;
    private final ConstraintLayout rootView;
    public final TextView tvCountdown;
    public final TextView tvRetake;
    public final TextView tvSubmit;

    private LiveBusinessActivityPreviewBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, RoundLinearLayout roundLinearLayout, LinearLayout linearLayout, RoundLinearLayout roundLinearLayout2, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.cameraPreview = imageView;
        this.clRootView = constraintLayout2;
        this.ivBack = imageView2;
        this.ivRetake = imageView3;
        this.ivSubmit = imageView4;
        this.llCountdown = roundLinearLayout;
        this.llRetake = linearLayout;
        this.llSubmissionFailed = roundLinearLayout2;
        this.llSubmit = linearLayout2;
        this.llTitleBar = linearLayout3;
        this.rlCameraPreview = relativeLayout;
        this.tvCountdown = textView;
        this.tvRetake = textView2;
        this.tvSubmit = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessActivityPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessActivityPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_activity_preview;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.llSubmissionFailed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.llCountdown;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityPreviewBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cameraPreview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x009f
            r6 = r0
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivBack
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivRetake
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivSubmit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.llCountdown
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.flyco.roundview.RoundLinearLayout r10 = (com.flyco.roundview.RoundLinearLayout) r10
            if (r10 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.llRetake
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.llSubmissionFailed
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.flyco.roundview.RoundLinearLayout r12 = (com.flyco.roundview.RoundLinearLayout) r12
            if (r12 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.llSubmit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.llTitleBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rlCameraPreview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            if (r15 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvCountdown
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvRetake
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvSubmit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x009f
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityPreviewBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityPreviewBinding
            r3 = r0
            r4 = r6
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x009f:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityPreviewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessActivityPreviewBinding");
    }
}
