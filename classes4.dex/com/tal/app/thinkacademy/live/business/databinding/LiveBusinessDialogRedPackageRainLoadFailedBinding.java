package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessDialogRedPackageRainLoadFailedBinding implements ViewBinding {
    public final TextView btnLiveBusinessRedPackageRain;
    public final ConstraintLayout clRedPackageRainLoadError;
    public final ImageView ivRedPackageRainLoadError;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessRedPackageRainTip;

    private LiveBusinessDialogRedPackageRainLoadFailedBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnLiveBusinessRedPackageRain = textView;
        this.clRedPackageRainLoadError = constraintLayout2;
        this.ivRedPackageRainLoadError = imageView;
        this.tvLiveBusinessRedPackageRainTip = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessDialogRedPackageRainLoadFailedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessDialogRedPackageRainLoadFailedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_dialog_red_package_rain_load_failed;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.cl_red_package_rain_load_error;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogRedPackageRainLoadFailedBinding bind(android.view.View r8) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.btn_live_business_red_package_rain
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.live.business.R.id.cl_red_package_rain_load_error
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_red_package_rain_load_error
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_red_package_rain_tip
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0036
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogRedPackageRainLoadFailedBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogRedPackageRainLoadFailedBinding
            r3 = r8
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0036:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogRedPackageRainLoadFailedBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogRedPackageRainLoadFailedBinding");
    }
}
