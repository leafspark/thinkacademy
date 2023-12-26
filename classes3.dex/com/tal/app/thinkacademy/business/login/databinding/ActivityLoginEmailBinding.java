package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;

public final class ActivityLoginEmailBinding implements ViewBinding {
    public final ClearEditText etEmailAddress;
    public final ClearEditText etPassword;
    public final ImageView ivAgree;
    public final ImageView ivLoginId;
    public final ImageView ivLoginPhone;
    public final ImageView ivPasswordEye;
    public final ConstraintLayout layoutId;
    public final TextView loginAgreementTips;
    private final LinearLayout rootView;
    public final LinearLayout rootlayout;
    public final TextView tvDecs;
    public final TextView tvForgetPassword;
    public final RoundTextView tvOtpLogin;
    public final TextView tvSignIn;
    public final RoundTextView tvSkip;
    public final TextView tvTitle;

    private ActivityLoginEmailBinding(LinearLayout linearLayout, ClearEditText clearEditText, ClearEditText clearEditText2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, RoundTextView roundTextView, TextView textView4, RoundTextView roundTextView2, TextView textView5) {
        this.rootView = linearLayout;
        this.etEmailAddress = clearEditText;
        this.etPassword = clearEditText2;
        this.ivAgree = imageView;
        this.ivLoginId = imageView2;
        this.ivLoginPhone = imageView3;
        this.ivPasswordEye = imageView4;
        this.layoutId = constraintLayout;
        this.loginAgreementTips = textView;
        this.rootlayout = linearLayout2;
        this.tvDecs = textView2;
        this.tvForgetPassword = textView3;
        this.tvOtpLogin = roundTextView;
        this.tvSignIn = textView4;
        this.tvSkip = roundTextView2;
        this.tvTitle = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLoginEmailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityLoginEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_login_email;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layout_id;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_otp_login;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_skip;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityLoginEmailBinding bind(android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_email_address
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r5 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r5
            if (r5 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_password
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r6 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r6
            if (r6 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_agree
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_login_id
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_login_phone
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_password_eye
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_id
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            if (r11 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.login_agreement_tips
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00ab
            r13 = r0
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_decs
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_forget_password
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_otp_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.flyco.roundview.RoundTextView r16 = (com.flyco.roundview.RoundTextView) r16
            if (r16 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_sign_in
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_skip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.flyco.roundview.RoundTextView r18 = (com.flyco.roundview.RoundTextView) r18
            if (r18 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00ab
            com.tal.app.thinkacademy.business.login.databinding.ActivityLoginEmailBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivityLoginEmailBinding
            r3 = r0
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        L_0x00ab:
            android.content.res.Resources r0 = r20.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityLoginEmailBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityLoginEmailBinding");
    }
}
