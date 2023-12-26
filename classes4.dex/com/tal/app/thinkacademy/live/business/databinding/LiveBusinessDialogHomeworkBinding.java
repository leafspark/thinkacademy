package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.google.android.material.imageview.ShapeableImageView;
import com.tal.app.thinkacademy.lib.commui.widget.StrokeTextView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessDialogHomeworkBinding implements ViewBinding {
    public final ImageView correctWrongIV;
    public final StrokeTextView correctWrongTV;
    public final LottieAnimationView homeworkLottie;
    public final ImageView ivLiveBusinessHomeworkClose;
    public final ConstraintLayout ivLiveBusinessHomeworkContent;
    public final ShapeableImageView ivLiveBusinessHomeworkPhoto;
    public final ImageView ivLiveBusinessHomeworkResubmit;
    public final ImageView ivLiveBusinessHomeworkTitle;
    public final LinearLayout layoutLiveBusinessHomeworkFrame;
    public final LottieAnimationView resubmitLottie;
    private final ConstraintLayout rootView;

    private LiveBusinessDialogHomeworkBinding(ConstraintLayout constraintLayout, ImageView imageView, StrokeTextView strokeTextView, LottieAnimationView lottieAnimationView, ImageView imageView2, ConstraintLayout constraintLayout2, ShapeableImageView shapeableImageView, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LottieAnimationView lottieAnimationView2) {
        this.rootView = constraintLayout;
        this.correctWrongIV = imageView;
        this.correctWrongTV = strokeTextView;
        this.homeworkLottie = lottieAnimationView;
        this.ivLiveBusinessHomeworkClose = imageView2;
        this.ivLiveBusinessHomeworkContent = constraintLayout2;
        this.ivLiveBusinessHomeworkPhoto = shapeableImageView;
        this.ivLiveBusinessHomeworkResubmit = imageView3;
        this.ivLiveBusinessHomeworkTitle = imageView4;
        this.layoutLiveBusinessHomeworkFrame = linearLayout;
        this.resubmitLottie = lottieAnimationView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessDialogHomeworkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessDialogHomeworkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_dialog_homework;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.resubmitLottie;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.homeworkLottie;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_content;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogHomeworkBinding bind(android.view.View r14) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.correctWrongIV
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.correctWrongTV
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r5 = r1
            com.tal.app.thinkacademy.lib.commui.widget.StrokeTextView r5 = (com.tal.app.thinkacademy.lib.commui.widget.StrokeTextView) r5
            if (r5 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.homeworkLottie
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r6 = r1
            com.airbnb.lottie.LottieAnimationView r6 = (com.airbnb.lottie.LottieAnimationView) r6
            if (r6 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r8 = r1
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r9 = r1
            com.google.android.material.imageview.ShapeableImageView r9 = (com.google.android.material.imageview.ShapeableImageView) r9
            if (r9 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_resubmit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r10 = r1
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r11 = r1
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_live_business_homework_frame
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r12 = r1
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x0078
            int r0 = com.tal.app.thinkacademy.live.business.R.id.resubmitLottie
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r14, r0)
            r13 = r1
            com.airbnb.lottie.LottieAnimationView r13 = (com.airbnb.lottie.LottieAnimationView) r13
            if (r13 == 0) goto L_0x0078
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogHomeworkBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogHomeworkBinding
            r3 = r14
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r0
        L_0x0078:
            android.content.res.Resources r14 = r14.getResources()
            java.lang.String r14 = r14.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r14 = r1.concat(r14)
            r0.<init>(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogHomeworkBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogHomeworkBinding");
    }
}
