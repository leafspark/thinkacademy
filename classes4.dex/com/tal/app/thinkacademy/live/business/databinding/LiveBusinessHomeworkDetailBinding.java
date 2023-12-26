package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tal.app.thinkacademy.lib.commui.widget.RoundConstraintLayout;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;

public final class LiveBusinessHomeworkDetailBinding implements ViewBinding {
    public final View bgLiveBusinessHomeworkDetail;
    public final ImageView ivLiveBusinessHomeworkClose;
    public final RoundConstraintLayout ivLiveBusinessHomeworkContent;
    public final ShapeableImageView ivLiveBusinessHomeworkPhoto;
    public final ImageView ivLiveBusinessHomeworkPhotoBg;
    public final RoundTextView ivLiveBusinessHomeworkResubmit;
    public final ImageView ivLiveBusinessHomeworkTitle;
    public final SubmitResultView layoutAwardView;
    public final FrameLayout layoutLiveBusinessHomeworkDetail;
    public final RoundLinearLayout layoutLiveBusinessHomeworkTitle;
    private final ConstraintLayout rootView;

    private LiveBusinessHomeworkDetailBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, RoundConstraintLayout roundConstraintLayout, ShapeableImageView shapeableImageView, ImageView imageView2, RoundTextView roundTextView, ImageView imageView3, SubmitResultView submitResultView, FrameLayout frameLayout, RoundLinearLayout roundLinearLayout) {
        this.rootView = constraintLayout;
        this.bgLiveBusinessHomeworkDetail = view;
        this.ivLiveBusinessHomeworkClose = imageView;
        this.ivLiveBusinessHomeworkContent = roundConstraintLayout;
        this.ivLiveBusinessHomeworkPhoto = shapeableImageView;
        this.ivLiveBusinessHomeworkPhotoBg = imageView2;
        this.ivLiveBusinessHomeworkResubmit = roundTextView;
        this.ivLiveBusinessHomeworkTitle = imageView3;
        this.layoutAwardView = submitResultView;
        this.layoutLiveBusinessHomeworkDetail = frameLayout;
        this.layoutLiveBusinessHomeworkTitle = roundLinearLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessHomeworkDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessHomeworkDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_homework_detail;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_resubmit;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.layout_live_business_homework_title;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkDetailBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.bg_live_business_homework_detail
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r3 == 0) goto L_0x0075
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0075
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            com.tal.app.thinkacademy.lib.commui.widget.RoundConstraintLayout r5 = (com.tal.app.thinkacademy.lib.commui.widget.RoundConstraintLayout) r5
            if (r5 == 0) goto L_0x0075
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            com.google.android.material.imageview.ShapeableImageView r6 = (com.google.android.material.imageview.ShapeableImageView) r6
            if (r6 == 0) goto L_0x0075
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo_bg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0075
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_resubmit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            com.flyco.roundview.RoundTextView r8 = (com.flyco.roundview.RoundTextView) r8
            if (r8 == 0) goto L_0x0075
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0075
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layoutAwardView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView r10 = (com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView) r10
            if (r10 == 0) goto L_0x0075
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_live_business_homework_detail
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.FrameLayout r11 = (android.widget.FrameLayout) r11
            if (r11 == 0) goto L_0x0075
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_live_business_homework_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            com.flyco.roundview.RoundLinearLayout r12 = (com.flyco.roundview.RoundLinearLayout) r12
            if (r12 == 0) goto L_0x0075
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkDetailBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkDetailBinding
            r2 = r13
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x0075:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkDetailBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkDetailBinding");
    }
}
