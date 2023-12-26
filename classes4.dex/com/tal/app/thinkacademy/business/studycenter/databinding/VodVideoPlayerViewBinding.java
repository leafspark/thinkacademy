package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class VodVideoPlayerViewBinding implements ViewBinding {
    public final ImageView backSeekBtn;
    public final TextView backSeekTargetTextview;
    public final TextView backSeekTextView;
    public final ConstraintLayout centerControlBtnLayout;
    public final View displayInfoBg;
    public final TextView errDesc;
    public final LinearLayout errorLayout;
    public final ImageView frontSeekBtn;
    public final TextView frontSeekTargetTextview;
    public final TextView frontSeekTextView;
    public final LottieAnimationView loadingLottieView;
    public final TextureView payerSurfaceView;
    public final RoundTextView playNextVideoBtn;
    public final ImageView playerBackBtn;
    public final RelativeLayout playerBottomLayout;
    public final ImageView playerFunctionMore;
    public final FrameLayout playerLoading;
    public final ImageView playerPlayBtn;
    public final SeekBar playerProgress;
    public final ConstraintLayout playerRoot;
    public final TextView playerTimeCurrent;
    public final TextView playerTimeTotal;
    public final RelativeLayout playerTopLayout;
    public final TextView playerVideoName;
    public final RoundTextView reloadButton;
    private final ConstraintLayout rootView;
    public final TextView switchSpeedBtn;
    public final ImageView takePhoto;
    public final TextView tcpSpeedTextview;

    private VodVideoPlayerViewBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, View view, TextView textView3, LinearLayout linearLayout, ImageView imageView2, TextView textView4, TextView textView5, LottieAnimationView lottieAnimationView, TextureView textureView, RoundTextView roundTextView, ImageView imageView3, RelativeLayout relativeLayout, ImageView imageView4, FrameLayout frameLayout, ImageView imageView5, SeekBar seekBar, ConstraintLayout constraintLayout3, TextView textView6, TextView textView7, RelativeLayout relativeLayout2, TextView textView8, RoundTextView roundTextView2, TextView textView9, ImageView imageView6, TextView textView10) {
        this.rootView = constraintLayout;
        this.backSeekBtn = imageView;
        this.backSeekTargetTextview = textView;
        this.backSeekTextView = textView2;
        this.centerControlBtnLayout = constraintLayout2;
        this.displayInfoBg = view;
        this.errDesc = textView3;
        this.errorLayout = linearLayout;
        this.frontSeekBtn = imageView2;
        this.frontSeekTargetTextview = textView4;
        this.frontSeekTextView = textView5;
        this.loadingLottieView = lottieAnimationView;
        this.payerSurfaceView = textureView;
        this.playNextVideoBtn = roundTextView;
        this.playerBackBtn = imageView3;
        this.playerBottomLayout = relativeLayout;
        this.playerFunctionMore = imageView4;
        this.playerLoading = frameLayout;
        this.playerPlayBtn = imageView5;
        this.playerProgress = seekBar;
        this.playerRoot = constraintLayout3;
        this.playerTimeCurrent = textView6;
        this.playerTimeTotal = textView7;
        this.playerTopLayout = relativeLayout2;
        this.playerVideoName = textView8;
        this.reloadButton = roundTextView2;
        this.switchSpeedBtn = textView9;
        this.takePhoto = imageView6;
        this.tcpSpeedTextview = textView10;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static VodVideoPlayerViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static VodVideoPlayerViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.vod_video_player_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.loadingLottieView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0084, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.playNextVideoBtn;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010c, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.reloadButton;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.centerControlBtnLayout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.displayInfoBg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding bind(android.view.View r33) {
        /*
            r0 = r33
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.backSeekBtn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.backSeekTargetTextview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.backSeekTextView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.centerControlBtnLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.displayInfoBg
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.errDesc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.errorLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.frontSeekBtn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.frontSeekTargetTextview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.frontSeekTextView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.loadingLottieView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.airbnb.lottie.LottieAnimationView r15 = (com.airbnb.lottie.LottieAnimationView) r15
            if (r15 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.payer_surface_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.view.TextureView r16 = (android.view.TextureView) r16
            if (r16 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.playNextVideoBtn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.flyco.roundview.RoundTextView r17 = (com.flyco.roundview.RoundTextView) r17
            if (r17 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.player_back_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.ImageView r18 = (android.widget.ImageView) r18
            if (r18 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.player_bottom_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.RelativeLayout r19 = (android.widget.RelativeLayout) r19
            if (r19 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.player_function_more
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.ImageView r20 = (android.widget.ImageView) r20
            if (r20 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.player_loading
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.FrameLayout r21 = (android.widget.FrameLayout) r21
            if (r21 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.playerPlayBtn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.ImageView r22 = (android.widget.ImageView) r22
            if (r22 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.player_progress
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.SeekBar r23 = (android.widget.SeekBar) r23
            if (r23 == 0) goto L_0x0145
            r24 = r0
            androidx.constraintlayout.widget.ConstraintLayout r24 = (androidx.constraintlayout.widget.ConstraintLayout) r24
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.player_time_current
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.player_time_total
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.player_top_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.RelativeLayout r27 = (android.widget.RelativeLayout) r27
            if (r27 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.player_video_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.reloadButton
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            com.flyco.roundview.RoundTextView r29 = (com.flyco.roundview.RoundTextView) r29
            if (r29 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.switchSpeedBtn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.TextView r30 = (android.widget.TextView) r30
            if (r30 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.takePhoto
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            android.widget.ImageView r31 = (android.widget.ImageView) r31
            if (r31 == 0) goto L_0x0145
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tcpSpeedTextview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            android.widget.TextView r32 = (android.widget.TextView) r32
            if (r32 == 0) goto L_0x0145
            com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding
            r3 = r0
            r4 = r24
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return r0
        L_0x0145:
            android.content.res.Resources r0 = r33.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.VodVideoPlayerViewBinding");
    }
}
