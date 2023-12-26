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

public final class ActivityLoginPhoneBinding implements ViewBinding {
    public final ClearEditText etPassword;
    public final ClearEditText etPhoneNumber;
    public final ImageView ivAgree;
    public final ImageView ivLoginEmail;
    public final ImageView ivLoginId;
    public final ImageView ivPasswordEye;
    public final ConstraintLayout layoutPhone;
    public final TextView loginAgreementTips;
    private final LinearLayout rootView;
    public final LinearLayout rootlayout;
    public final TextView tvCountryCode;
    public final TextView tvDecs;
    public final TextView tvForgetPassword;
    public final RoundTextView tvOtpLogin;
    public final TextView tvSignIn;
    public final RoundTextView tvSkip;
    public final TextView tvTitle;

    private ActivityLoginPhoneBinding(LinearLayout linearLayout, ClearEditText clearEditText, ClearEditText clearEditText2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, RoundTextView roundTextView, TextView textView5, RoundTextView roundTextView2, TextView textView6) {
        this.rootView = linearLayout;
        this.etPassword = clearEditText;
        this.etPhoneNumber = clearEditText2;
        this.ivAgree = imageView;
        this.ivLoginEmail = imageView2;
        this.ivLoginId = imageView3;
        this.ivPasswordEye = imageView4;
        this.layoutPhone = constraintLayout;
        this.loginAgreementTips = textView;
        this.rootlayout = linearLayout2;
        this.tvCountryCode = textView2;
        this.tvDecs = textView3;
        this.tvForgetPassword = textView4;
        this.tvOtpLogin = roundTextView;
        this.tvSignIn = textView5;
        this.tvSkip = roundTextView2;
        this.tvTitle = textView6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLoginPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityLoginPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_login_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layout_phone;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_otp_login;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0097, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_skip;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityLoginPhoneBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_password
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r5 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r5
            if (r5 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_phone_number
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r6 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r6
            if (r6 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_agree
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_login_email
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_login_id
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_password_eye
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_phone
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            if (r11 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.login_agreement_tips
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00b7
            r13 = r0
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_country_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_decs
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_forget_password
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_otp_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.flyco.roundview.RoundTextView r17 = (com.flyco.roundview.RoundTextView) r17
            if (r17 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_sign_in
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_skip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            com.flyco.roundview.RoundTextView r19 = (com.flyco.roundview.RoundTextView) r19
            if (r19 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00b7
            com.tal.app.thinkacademy.business.login.databinding.ActivityLoginPhoneBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivityLoginPhoneBinding
            r3 = r0
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x00b7:
            android.content.res.Resources r0 = r21.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityLoginPhoneBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityLoginPhoneBinding");
    }
}
