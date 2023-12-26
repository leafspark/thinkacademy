package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView;

public final class LiveBusinessFunctionPluginLayoutBinding implements ViewBinding {
    public final ConstraintLayout liveBusinessFunctionRoot;
    public final ImageView liveBusinessFunctionVChatbox;
    public final RoundTextView liveBusinessFunctionVChatboxDot;
    public final ImageView liveBusinessFunctionVEmoji;
    public final CircleProgressView liveBusinessFunctionVHandUp;
    public final ImageView liveBusinessFunctionVMic;
    private final ConstraintLayout rootView;

    private LiveBusinessFunctionPluginLayoutBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, RoundTextView roundTextView, ImageView imageView2, CircleProgressView circleProgressView, ImageView imageView3) {
        this.rootView = constraintLayout;
        this.liveBusinessFunctionRoot = constraintLayout2;
        this.liveBusinessFunctionVChatbox = imageView;
        this.liveBusinessFunctionVChatboxDot = roundTextView;
        this.liveBusinessFunctionVEmoji = imageView2;
        this.liveBusinessFunctionVHandUp = circleProgressView;
        this.liveBusinessFunctionVMic = imageView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessFunctionPluginLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessFunctionPluginLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_function_plugin_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_function_v_chatbox_dot;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_function_v_hand_up;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessFunctionPluginLayoutBinding bind(android.view.View r8) {
        /*
            r2 = r8
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_function_v_chatbox
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r3 = r1
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            if (r3 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_function_v_chatbox_dot
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            com.flyco.roundview.RoundTextView r4 = (com.flyco.roundview.RoundTextView) r4
            if (r4 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_function_v_emoji
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_function_v_hand_up
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView r6 = (com.tal.app.thinkcademy.lib.commui.widget.CircleProgressView) r6
            if (r6 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_function_v_mic
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0042
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessFunctionPluginLayoutBinding r8 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessFunctionPluginLayoutBinding
            r0 = r8
            r1 = r2
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r8
        L_0x0042:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessFunctionPluginLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessFunctionPluginLayoutBinding");
    }
}
