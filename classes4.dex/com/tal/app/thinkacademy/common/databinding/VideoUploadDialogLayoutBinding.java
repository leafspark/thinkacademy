package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.lib.commui.widget.ArcLoadingView;

public final class VideoUploadDialogLayoutBinding implements ViewBinding {
    public final RoundTextView btnUploadCancel;
    public final TextView imageProgressTextView;
    public final RoundLinearLayout imageRoot;
    public final ArcLoadingView imgLoading;
    public final ImageView ivCircle;
    public final ImageView ivLoading;
    public final TextView progressTextview;
    private final FrameLayout rootView;
    public final ProgressBar uploadProgressView;
    public final ImageView videoIcon;
    public final RelativeLayout videoRoot;
    public final TextView videoUploadTips;

    private VideoUploadDialogLayoutBinding(FrameLayout frameLayout, RoundTextView roundTextView, TextView textView, RoundLinearLayout roundLinearLayout, ArcLoadingView arcLoadingView, ImageView imageView, ImageView imageView2, TextView textView2, ProgressBar progressBar, ImageView imageView3, RelativeLayout relativeLayout, TextView textView3) {
        this.rootView = frameLayout;
        this.btnUploadCancel = roundTextView;
        this.imageProgressTextView = textView;
        this.imageRoot = roundLinearLayout;
        this.imgLoading = arcLoadingView;
        this.ivCircle = imageView;
        this.ivLoading = imageView2;
        this.progressTextview = textView2;
        this.uploadProgressView = progressBar;
        this.videoIcon = imageView3;
        this.videoRoot = relativeLayout;
        this.videoUploadTips = textView3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static VideoUploadDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static VideoUploadDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.video_upload_dialog_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.common.R.id.imageRoot;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.common.databinding.VideoUploadDialogLayoutBinding bind(android.view.View r15) {
        /*
            int r0 = com.tal.app.thinkacademy.common.R.id.btnUploadCancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            com.flyco.roundview.RoundTextView r4 = (com.flyco.roundview.RoundTextView) r4
            if (r4 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.common.R.id.imageProgressTextView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.common.R.id.imageRoot
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            com.flyco.roundview.RoundLinearLayout r6 = (com.flyco.roundview.RoundLinearLayout) r6
            if (r6 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.common.R.id.img_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            com.tal.app.thinkacademy.lib.commui.widget.ArcLoadingView r7 = (com.tal.app.thinkacademy.lib.commui.widget.ArcLoadingView) r7
            if (r7 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.common.R.id.iv_circle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.common.R.id.iv_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.common.R.id.progress_textview
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.common.R.id.upload_progressView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r11 = r1
            android.widget.ProgressBar r11 = (android.widget.ProgressBar) r11
            if (r11 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.common.R.id.videoIcon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.common.R.id.videoRoot
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            if (r13 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.common.R.id.video_upload_tips
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r14 = r1
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0083
            com.tal.app.thinkacademy.common.databinding.VideoUploadDialogLayoutBinding r0 = new com.tal.app.thinkacademy.common.databinding.VideoUploadDialogLayoutBinding
            r3 = r15
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x0083:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.databinding.VideoUploadDialogLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.common.databinding.VideoUploadDialogLayoutBinding");
    }
}
