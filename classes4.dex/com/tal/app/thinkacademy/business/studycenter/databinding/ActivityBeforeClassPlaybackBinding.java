package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ActivityBeforeClassPlaybackBinding implements ViewBinding {
    public final ImageView btnBack;
    public final TextView btnOperation;
    public final ImageView ivNoVideo;
    public final ActivityBeforeClassErrorBinding layoutError;
    public final LinearLayout linearLayout;
    public final LottieAnimationView lottieLoading;
    public final SeekBar progressDownload;
    private final FrameLayout rootView;
    public final TextView tvDownloadInfo;
    public final TextView tvNoVideo;

    private ActivityBeforeClassPlaybackBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, ImageView imageView2, ActivityBeforeClassErrorBinding activityBeforeClassErrorBinding, LinearLayout linearLayout2, LottieAnimationView lottieAnimationView, SeekBar seekBar, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.btnBack = imageView;
        this.btnOperation = textView;
        this.ivNoVideo = imageView2;
        this.layoutError = activityBeforeClassErrorBinding;
        this.linearLayout = linearLayout2;
        this.lottieLoading = lottieAnimationView;
        this.progressDownload = seekBar;
        this.tvDownloadInfo = textView2;
        this.tvNoVideo = textView3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBeforeClassPlaybackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityBeforeClassPlaybackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_before_class_playback;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.lottie_loading;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_error;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassPlaybackBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.btn_back
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x006e
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.btn_operation
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x006e
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_no_video
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x006e
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_error
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r1 == 0) goto L_0x006e
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassErrorBinding r7 = com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassErrorBinding.bind(r1)
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.linear_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x006e
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.lottie_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            com.airbnb.lottie.LottieAnimationView r9 = (com.airbnb.lottie.LottieAnimationView) r9
            if (r9 == 0) goto L_0x006e
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.progress_download
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.SeekBar r10 = (android.widget.SeekBar) r10
            if (r10 == 0) goto L_0x006e
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_download_info
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x006e
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_no_video
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x006e
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassPlaybackBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassPlaybackBinding
            r3 = r13
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006e:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassPlaybackBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassPlaybackBinding");
    }
}
