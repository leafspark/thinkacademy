package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;

public final class ActivityLoginOtpBinding implements ViewBinding {
    public final ClearEditText etEmailAddress;
    public final ClearEditText etEmailCode;
    public final ClearEditText etPhoneNumber;
    public final ClearEditText etSmsCode;
    public final Group groupEmail;
    public final Group groupSms;
    public final Group groupTitle;
    public final ImageView ivAgree;
    public final LinearLayout layoutEmailCode;
    public final ConstraintLayout layoutPhone;
    public final LinearLayout layoutSmsCode;
    public final TextView loginAgreementTips;
    public final RadioButton rbEmail;
    public final RadioButton rbPhone;
    public final RadioGroup rgSwitch;
    private final ConstraintLayout rootView;
    public final ConstraintLayout rootlayout;
    public final TextView tvCountryCode;
    public final TextView tvDecs;
    public final TextView tvEmailSecond;
    public final TextView tvEmailSend;
    public final RoundTextView tvPasswordLogin;
    public final TextView tvSignIn;
    public final RoundTextView tvSkip;
    public final TextView tvSmsSecond;
    public final TextView tvSmsSend;
    public final TextView tvTitle;

    private ActivityLoginOtpBinding(ConstraintLayout constraintLayout, ClearEditText clearEditText, ClearEditText clearEditText2, ClearEditText clearEditText3, ClearEditText clearEditText4, Group group, Group group2, Group group3, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, TextView textView, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, ConstraintLayout constraintLayout3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RoundTextView roundTextView, TextView textView6, RoundTextView roundTextView2, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.etEmailAddress = clearEditText;
        this.etEmailCode = clearEditText2;
        this.etPhoneNumber = clearEditText3;
        this.etSmsCode = clearEditText4;
        this.groupEmail = group;
        this.groupSms = group2;
        this.groupTitle = group3;
        this.ivAgree = imageView;
        this.layoutEmailCode = linearLayout;
        this.layoutPhone = constraintLayout2;
        this.layoutSmsCode = linearLayout2;
        this.loginAgreementTips = textView;
        this.rbEmail = radioButton;
        this.rbPhone = radioButton2;
        this.rgSwitch = radioGroup;
        this.rootlayout = constraintLayout3;
        this.tvCountryCode = textView2;
        this.tvDecs = textView3;
        this.tvEmailSecond = textView4;
        this.tvEmailSend = textView5;
        this.tvPasswordLogin = roundTextView;
        this.tvSignIn = textView6;
        this.tvSkip = roundTextView2;
        this.tvSmsSecond = textView7;
        this.tvSmsSend = textView8;
        this.tvTitle = textView9;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityLoginOtpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityLoginOtpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_login_otp;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_sms;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_title;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layout_phone;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00df, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_password_login;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f7, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_skip;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_email;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding bind(android.view.View r31) {
        /*
            r0 = r31
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_email_address
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r5 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r5
            if (r5 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_email_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r6 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r6
            if (r6 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_phone_number
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r7 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r7
            if (r7 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_sms_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r8 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r8
            if (r8 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_email
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.Group r9 = (androidx.constraintlayout.widget.Group) r9
            if (r9 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_sms
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.Group r10 = (androidx.constraintlayout.widget.Group) r10
            if (r10 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.Group r11 = (androidx.constraintlayout.widget.Group) r11
            if (r11 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_agree
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_email_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_phone
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_sms_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            if (r15 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.login_agreement_tips
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.rb_email
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.RadioButton r17 = (android.widget.RadioButton) r17
            if (r17 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.rb_phone
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.RadioButton r18 = (android.widget.RadioButton) r18
            if (r18 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.rg_switch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.RadioGroup r19 = (android.widget.RadioGroup) r19
            if (r19 == 0) goto L_0x0130
            r20 = r0
            androidx.constraintlayout.widget.ConstraintLayout r20 = (androidx.constraintlayout.widget.ConstraintLayout) r20
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_country_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_decs
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_email_second
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_email_send
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_password_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            com.flyco.roundview.RoundTextView r25 = (com.flyco.roundview.RoundTextView) r25
            if (r25 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_sign_in
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_skip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            com.flyco.roundview.RoundTextView r27 = (com.flyco.roundview.RoundTextView) r27
            if (r27 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_sms_second
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_sms_send
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            android.widget.TextView r29 = (android.widget.TextView) r29
            if (r29 == 0) goto L_0x0130
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.TextView r30 = (android.widget.TextView) r30
            if (r30 == 0) goto L_0x0130
            com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding
            r3 = r0
            r4 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return r0
        L_0x0130:
            android.content.res.Resources r0 = r31.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityLoginOtpBinding");
    }
}
