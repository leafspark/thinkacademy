package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkcademy.lib.commui.widget.LoadingView;

public final class LiveBusinessLiveplayLoadingViewBinding implements ViewBinding {
    public final FrameLayout flLiveBusinessLiveplayCoursewareArea;
    public final ImageView ivLivebusinessLiveplayNoTeacher;
    public final View liveBusinessSimpleGuide;
    public final LinearLayout llLiveBusinessLiveplayState;
    public final LoadingView lvLiveBusinessLiveplayBufferLoad;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessLiveplayState;
    public final View vLiveBusinessLiveplayCoursewareAreaGuide;

    private LiveBusinessLiveplayLoadingViewBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, View view, LinearLayout linearLayout, LoadingView loadingView, TextView textView, View view2) {
        this.rootView = constraintLayout;
        this.flLiveBusinessLiveplayCoursewareArea = frameLayout;
        this.ivLivebusinessLiveplayNoTeacher = imageView;
        this.liveBusinessSimpleGuide = view;
        this.llLiveBusinessLiveplayState = linearLayout;
        this.lvLiveBusinessLiveplayBufferLoad = loadingView;
        this.tvLiveBusinessLiveplayState = textView;
        this.vLiveBusinessLiveplayCoursewareAreaGuide = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLiveplayLoadingViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLiveplayLoadingViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_liveplay_loading_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_liveplay_courseware_area_guide;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_simple_guide;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lv_live_business_liveplay_buffer_load;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayLoadingViewBinding bind(android.view.View r11) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.fl_live_business_liveplay_courseware_area
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            if (r4 == 0) goto L_0x0051
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_livebusiness_liveplay_no_teacher
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0051
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_simple_guide
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r6 == 0) goto L_0x0051
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ll_live_business_liveplay_state
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0051
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lv_live_business_liveplay_buffer_load
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadingView r8 = (com.tal.app.thinkcademy.lib.commui.widget.LoadingView) r8
            if (r8 == 0) goto L_0x0051
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_liveplay_state
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0051
            int r0 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_liveplay_courseware_area_guide
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r10 == 0) goto L_0x0051
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayLoadingViewBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayLoadingViewBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0051:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayLoadingViewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayLoadingViewBinding");
    }
}
