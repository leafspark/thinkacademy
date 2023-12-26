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
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;

public final class LiveLoginActivityAccountVerificationBinding implements ViewBinding {
    public final TextView accountVerificationDecs;
    public final TextView emailNumberLogin;
    public final ClearEditText etEmailNumber;
    public final ClearEditText etPhoneNumber;
    public final ClearEditText etVerificationCode;
    public final ImageView icBack;
    public final LinearLayout layoutCode;
    public final ConstraintLayout layoutEmailLogin;
    public final ConstraintLayout layoutEmailNotLogin;
    public final ConstraintLayout layoutPhoneLogin;
    public final ConstraintLayout layoutPhoneNotLogin;
    public final TextView phoneNumberLogin;
    private final ConstraintLayout rootView;
    public final ConstraintLayout rootlayout;
    public final TextView tvCountryCode;
    public final TextView tvCountryCodeLogin;
    public final TextView tvNextStep;
    public final TextView tvSecond;
    public final TextView tvSend;
    public final TextView tvTitle;

    private LiveLoginActivityAccountVerificationBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ClearEditText clearEditText, ClearEditText clearEditText2, ClearEditText clearEditText3, ImageView imageView, LinearLayout linearLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, TextView textView3, ConstraintLayout constraintLayout6, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.accountVerificationDecs = textView;
        this.emailNumberLogin = textView2;
        this.etEmailNumber = clearEditText;
        this.etPhoneNumber = clearEditText2;
        this.etVerificationCode = clearEditText3;
        this.icBack = imageView;
        this.layoutCode = linearLayout;
        this.layoutEmailLogin = constraintLayout2;
        this.layoutEmailNotLogin = constraintLayout3;
        this.layoutPhoneLogin = constraintLayout4;
        this.layoutPhoneNotLogin = constraintLayout5;
        this.phoneNumberLogin = textView3;
        this.rootlayout = constraintLayout6;
        this.tvCountryCode = textView4;
        this.tvCountryCodeLogin = textView5;
        this.tvNextStep = textView6;
        this.tvSecond = textView7;
        this.tvSend = textView8;
        this.tvTitle = textView9;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveLoginActivityAccountVerificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveLoginActivityAccountVerificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_login_activity_account_verification;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layout_email_login;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layout_email_not_login;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layout_phone_login;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layout_phone_not_login;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding bind(android.view.View r24) {
        /*
            r0 = r24
            int r1 = com.tal.app.thinkacademy.business.login.R.id.account_verification_decs
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.email_number_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_email_number
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r7 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r7
            if (r7 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_phone_number
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r8 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r8
            if (r8 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_verification_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r9 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r9
            if (r9 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.icBack
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_email_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            if (r12 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_email_not_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            if (r13 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_phone_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_phone_not_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.phone_number_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00dc
            r17 = r0
            androidx.constraintlayout.widget.ConstraintLayout r17 = (androidx.constraintlayout.widget.ConstraintLayout) r17
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_country_code
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_country_code_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvNextStep
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_second
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_send
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00dc
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding
            r3 = r0
            r4 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r0
        L_0x00dc:
            android.content.res.Resources r0 = r24.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding");
    }
}
