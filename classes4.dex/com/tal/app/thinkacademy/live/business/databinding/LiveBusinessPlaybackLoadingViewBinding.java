package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkcademy.lib.commui.widget.LoadingView;

public final class LiveBusinessPlaybackLoadingViewBinding implements ViewBinding {
    public final Button btnLiveBusinessErrorRetry;
    public final Button btnLiveBusinessSwitchLine;
    public final ConstraintLayout clLiveBusinessLoadingRoot;
    public final FrameLayout flLiveBusinessVideoReplay;
    public final ImageView ivLiveBusinessVideoReplay;
    public final LinearLayout llLiveBusinessError;
    public final LinearLayout llLiveBusinessLoading;
    public final LoadingView lvLiveBusinessBufferLoad;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessErrorTip;

    private LiveBusinessPlaybackLoadingViewBinding(ConstraintLayout constraintLayout, Button button, Button button2, ConstraintLayout constraintLayout2, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LoadingView loadingView, TextView textView) {
        this.rootView = constraintLayout;
        this.btnLiveBusinessErrorRetry = button;
        this.btnLiveBusinessSwitchLine = button2;
        this.clLiveBusinessLoadingRoot = constraintLayout2;
        this.flLiveBusinessVideoReplay = frameLayout;
        this.ivLiveBusinessVideoReplay = imageView;
        this.llLiveBusinessError = linearLayout;
        this.llLiveBusinessLoading = linearLayout2;
        this.lvLiveBusinessBufferLoad = loadingView;
        this.tvLiveBusinessErrorTip = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPlaybackLoadingViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPlaybackLoadingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_playback_loading_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lv_live_business_buffer_load;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPlaybackLoadingViewBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.btn_live_business_error_retry
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.Button r4 = (android.widget.Button) r4
            if (r4 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.btn_live_business_switchLine
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.Button r5 = (android.widget.Button) r5
            if (r5 == 0) goto L_0x0063
            r6 = r13
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            int r0 = com.tal.app.thinkacademy.live.business.R.id.fl_live_business_video_replay
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            if (r7 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_video_replay
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ll_live_business_error
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ll_live_business_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lv_live_business_buffer_load
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadingView r11 = (com.tal.app.thinkcademy.lib.commui.widget.LoadingView) r11
            if (r11 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_error_tip
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0063
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPlaybackLoadingViewBinding r13 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPlaybackLoadingViewBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPlaybackLoadingViewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPlaybackLoadingViewBinding");
    }
}
