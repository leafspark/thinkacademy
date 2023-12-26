package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LayoutSchulteTablePluginBinding implements ViewBinding {
    public final ImageView ivSchulteTableBg;
    public final ImageView ivSchulteTitle;
    public final FrameLayout layoutBaseView;
    public final FrameLayout layoutSceneContainer;
    public final LottieAnimationView lottieLoading;
    public final LottieAnimationView lottieResultRibbon;
    private final FrameLayout rootView;
    public final TextView tvShculteDesc;
    public final TextView tvShculteLevel;
    public final TextView tvShculteTitle;

    private LayoutSchulteTablePluginBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, FrameLayout frameLayout2, FrameLayout frameLayout3, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = frameLayout;
        this.ivSchulteTableBg = imageView;
        this.ivSchulteTitle = imageView2;
        this.layoutBaseView = frameLayout2;
        this.layoutSceneContainer = frameLayout3;
        this.lottieLoading = lottieAnimationView;
        this.lottieResultRibbon = lottieAnimationView2;
        this.tvShculteDesc = textView;
        this.tvShculteLevel = textView2;
        this.tvShculteTitle = textView3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutSchulteTablePluginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutSchulteTablePluginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_schulte_table_plugin;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_result_ribbon;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_loading;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTablePluginBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_schulte_table_bg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_schulte_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_base_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            if (r6 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_scene_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            if (r7 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_loading
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            com.airbnb.lottie.LottieAnimationView r8 = (com.airbnb.lottie.LottieAnimationView) r8
            if (r8 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_result_ribbon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            com.airbnb.lottie.LottieAnimationView r9 = (com.airbnb.lottie.LottieAnimationView) r9
            if (r9 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_shculte_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_shculte_level
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_shculte_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x006d
            com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTablePluginBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTablePluginBinding
            r3 = r13
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006d:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTablePluginBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTablePluginBinding");
    }
}
