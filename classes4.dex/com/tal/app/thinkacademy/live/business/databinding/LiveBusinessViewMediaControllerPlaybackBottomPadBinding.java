package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkcademy.lib.commui.widget.StateImageView;

public final class LiveBusinessViewMediaControllerPlaybackBottomPadBinding implements ViewBinding {
    public final ImageView imgLiveBusinessPlaybackScreenshot;
    public final StateImageView ivLiveBusinessMediaControllerControlsOption;
    public final ImageView ivLiveBusinessMediaControllerControlsPlaypause;
    public final ImageView ivLiveBusinessMediaControllerControlsSpeed;
    public final ImageView ivLiveBusinessMediaControllerForwardSign;
    public final ImageView ivLiveBusinessMediaControllerNextSign;
    public final RelativeLayout rlLiveBusinessMediaControllerControls;
    public final FrameLayout rlLiveBusinessMediaControllerKeypoints;
    public final RelativeLayout rlLiveBusinessMediaControllerKeytip;
    public final RelativeLayout rlPlaybackMediaControllerRootBottom;
    private final RelativeLayout rootView;
    public final SeekBar sbarLiveBusinessMediaControllerControls;
    public final TextView tvLiveBusinessMediaControllerControlsSeparator;
    public final TextView tvLiveBusinessMediaControllerControlsTimecurrent;
    public final TextView tvLiveBusinessMediaControllerControlsTimetotal;

    private LiveBusinessViewMediaControllerPlaybackBottomPadBinding(RelativeLayout relativeLayout, ImageView imageView, StateImageView stateImageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, RelativeLayout relativeLayout2, FrameLayout frameLayout, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, SeekBar seekBar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.imgLiveBusinessPlaybackScreenshot = imageView;
        this.ivLiveBusinessMediaControllerControlsOption = stateImageView;
        this.ivLiveBusinessMediaControllerControlsPlaypause = imageView2;
        this.ivLiveBusinessMediaControllerControlsSpeed = imageView3;
        this.ivLiveBusinessMediaControllerForwardSign = imageView4;
        this.ivLiveBusinessMediaControllerNextSign = imageView5;
        this.rlLiveBusinessMediaControllerControls = relativeLayout2;
        this.rlLiveBusinessMediaControllerKeypoints = frameLayout;
        this.rlLiveBusinessMediaControllerKeytip = relativeLayout3;
        this.rlPlaybackMediaControllerRootBottom = relativeLayout4;
        this.sbarLiveBusinessMediaControllerControls = seekBar;
        this.tvLiveBusinessMediaControllerControlsSeparator = textView;
        this.tvLiveBusinessMediaControllerControlsTimecurrent = textView2;
        this.tvLiveBusinessMediaControllerControlsTimetotal = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewMediaControllerPlaybackBottomPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewMediaControllerPlaybackBottomPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_media_controller_playback_bottom_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_media_controller_controls_option;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerPlaybackBottomPadBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.tal.app.thinkacademy.live.business.R.id.img_live_business_playback_screenshot
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_media_controller_controls_option
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkcademy.lib.commui.widget.StateImageView r6 = (com.tal.app.thinkcademy.lib.commui.widget.StateImageView) r6
            if (r6 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_media_controller_controls_playpause
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_media_controller_controls_speed
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_media_controller_forward_sign
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_media_controller_next_sign
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_media_controller_controls
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            if (r11 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_media_controller_keypoints
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.FrameLayout r12 = (android.widget.FrameLayout) r12
            if (r12 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_media_controller_keytip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            if (r13 == 0) goto L_0x009f
            r14 = r0
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            int r1 = com.tal.app.thinkacademy.live.business.R.id.sbar_live_business_media_controller_controls
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.SeekBar r15 = (android.widget.SeekBar) r15
            if (r15 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_media_controller_controls_separator
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_media_controller_controls_timecurrent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_media_controller_controls_timetotal
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x009f
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerPlaybackBottomPadBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerPlaybackBottomPadBinding
            r3 = r0
            r4 = r14
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerPlaybackBottomPadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerPlaybackBottomPadBinding");
    }
}
