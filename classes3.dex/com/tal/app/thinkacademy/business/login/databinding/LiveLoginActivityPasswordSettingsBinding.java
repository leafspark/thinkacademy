package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;

public final class LiveLoginActivityPasswordSettingsBinding implements ViewBinding {
    public final ClearEditText etConfirmPassword;
    public final ClearEditText etPassword;
    public final ImageView icBack;
    public final ImageView ivConfirmPasswordShow;
    public final ImageView ivPasswordShow;
    public final ConstraintLayout layoutConfirmPassword;
    public final ConstraintLayout layoutPassword;
    private final ConstraintLayout rootView;
    public final ConstraintLayout rootlayout;
    public final RoundTextView tvConfirm;
    public final TextView tvConfirmPasswordDesc;
    public final TextView tvNewPasswordDesc;
    public final RoundTextView tvSkip;
    public final TextView tvTitle;

    private LiveLoginActivityPasswordSettingsBinding(ConstraintLayout constraintLayout, ClearEditText clearEditText, ClearEditText clearEditText2, ImageView imageView, ImageView imageView2, ImageView imageView3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, RoundTextView roundTextView, TextView textView, TextView textView2, RoundTextView roundTextView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.etConfirmPassword = clearEditText;
        this.etPassword = clearEditText2;
        this.icBack = imageView;
        this.ivConfirmPasswordShow = imageView2;
        this.ivPasswordShow = imageView3;
        this.layoutConfirmPassword = constraintLayout2;
        this.layoutPassword = constraintLayout3;
        this.rootlayout = constraintLayout4;
        this.tvConfirm = roundTextView;
        this.tvConfirmPasswordDesc = textView;
        this.tvNewPasswordDesc = textView2;
        this.tvSkip = roundTextView2;
        this.tvTitle = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveLoginActivityPasswordSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveLoginActivityPasswordSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_login_activity_password_settings;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layoutConfirmPassword;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layoutPassword;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tvSkip;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityPasswordSettingsBinding bind(android.view.View r18) {
        /*
            r0 = r18
            int r1 = com.tal.app.thinkacademy.business.login.R.id.etConfirmPassword
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r5 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r5
            if (r5 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.etPassword
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r6 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r6
            if (r6 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.icBack
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.ivConfirmPasswordShow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.ivPasswordShow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layoutConfirmPassword
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            if (r10 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layoutPassword
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            if (r11 == 0) goto L_0x0093
            r12 = r0
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvConfirm
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.flyco.roundview.RoundTextView r13 = (com.flyco.roundview.RoundTextView) r13
            if (r13 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvConfirmPasswordDesc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvNewPasswordDesc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvSkip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.flyco.roundview.RoundTextView r16 = (com.flyco.roundview.RoundTextView) r16
            if (r16 == 0) goto L_0x0093
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x0093
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityPasswordSettingsBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityPasswordSettingsBinding
            r3 = r0
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r0
        L_0x0093:
            android.content.res.Resources r0 = r18.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityPasswordSettingsBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityPasswordSettingsBinding");
    }
}
