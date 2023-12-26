package com.tal.app.thinkacademy.business.login.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountVerificationActivity.kt */
final class AccountVerificationActivity$setListener$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AccountVerificationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountVerificationActivity$setListener$4(AccountVerificationActivity accountVerificationActivity) {
        super(0);
        this.this$0 = accountVerificationActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x019f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r11 = this;
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r11.this$0
            r0.showLoading()
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r11.this$0
            boolean r1 = r0.mIsLogin
            r2 = 0
            if (r1 == 0) goto L_0x006f
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r11.this$0
            int r1 = r1.KTypeSms
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r3 = r11.this$0
            java.lang.Integer r3 = r3.mType
            if (r3 != 0) goto L_0x001d
            goto L_0x004b
        L_0x001d:
            int r3 = r3.intValue()
            if (r1 != r3) goto L_0x004b
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r11.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            android.widget.TextView r1 = r1.phoneNumberLogin
            if (r1 != 0) goto L_0x002f
            goto L_0x00b2
        L_0x002f:
            java.lang.CharSequence r1 = r1.getText()
            if (r1 != 0) goto L_0x0037
            goto L_0x00b2
        L_0x0037:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x003f
            goto L_0x00b2
        L_0x003f:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            goto L_0x00cc
        L_0x004b:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r11.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            android.widget.TextView r1 = r1.emailNumberLogin
            if (r1 != 0) goto L_0x0056
            goto L_0x00b2
        L_0x0056:
            java.lang.CharSequence r1 = r1.getText()
            if (r1 != 0) goto L_0x005d
            goto L_0x00b2
        L_0x005d:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x0064
            goto L_0x00b2
        L_0x0064:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            goto L_0x00cc
        L_0x006f:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r11.this$0
            int r1 = r1.KTypeSms
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r3 = r11.this$0
            java.lang.Integer r3 = r3.mType
            if (r3 != 0) goto L_0x007e
            goto L_0x00a8
        L_0x007e:
            int r3 = r3.intValue()
            if (r1 != r3) goto L_0x00a8
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r11.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r1 = r1.etPhoneNumber
            if (r1 != 0) goto L_0x008f
            goto L_0x00b2
        L_0x008f:
            android.text.Editable r1 = r1.getText()
            if (r1 != 0) goto L_0x0096
            goto L_0x00b2
        L_0x0096:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x009d
            goto L_0x00b2
        L_0x009d:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            goto L_0x00cc
        L_0x00a8:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r11.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r1 = r1.etEmailNumber
            if (r1 != 0) goto L_0x00b4
        L_0x00b2:
            r1 = r2
            goto L_0x00cc
        L_0x00b4:
            android.text.Editable r1 = r1.getText()
            if (r1 != 0) goto L_0x00bb
            goto L_0x00b2
        L_0x00bb:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x00c2
            goto L_0x00b2
        L_0x00c2:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
        L_0x00cc:
            r0.mContactInfo = r1
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r11.this$0
            java.lang.Integer r1 = r0.mType
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r3 = r11.this$0
            int r3 = r3.KTypeSms
            java.lang.String r4 = ""
            if (r1 != 0) goto L_0x00e1
            goto L_0x0149
        L_0x00e1:
            int r1 = r1.intValue()
            if (r1 != r3) goto L_0x0149
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r11.this$0
            boolean r1 = r1.mIsLogin
            r3 = 1
            if (r1 == 0) goto L_0x011c
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r11.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            android.widget.TextView r1 = r1.tvCountryCodeLogin
            if (r1 != 0) goto L_0x00fb
            goto L_0x0126
        L_0x00fb:
            java.lang.CharSequence r1 = r1.getText()
            if (r1 != 0) goto L_0x0102
            goto L_0x0126
        L_0x0102:
            int r5 = r1.length()
            java.lang.CharSequence r1 = r1.subSequence(r3, r5)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x0111
            goto L_0x0126
        L_0x0111:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            goto L_0x014a
        L_0x011c:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r11.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            android.widget.TextView r1 = r1.tvCountryCode
            if (r1 != 0) goto L_0x0128
        L_0x0126:
            r1 = r2
            goto L_0x014a
        L_0x0128:
            java.lang.CharSequence r1 = r1.getText()
            if (r1 != 0) goto L_0x012f
            goto L_0x0126
        L_0x012f:
            int r5 = r1.length()
            java.lang.CharSequence r1 = r1.subSequence(r3, r5)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x013e
            goto L_0x0126
        L_0x013e:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            goto L_0x014a
        L_0x0149:
            r1 = r4
        L_0x014a:
            r0.mCountryCallingCode = r1
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r11.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r0.getBinding()
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r1 = r1.etVerificationCode
            if (r1 != 0) goto L_0x0158
            goto L_0x0170
        L_0x0158:
            android.text.Editable r1 = r1.getText()
            if (r1 != 0) goto L_0x015f
            goto L_0x0170
        L_0x015f:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x0166
            goto L_0x0170
        L_0x0166:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r2 = r1.toString()
        L_0x0170:
            r0.mVerificationCode = r2
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r11.this$0
            com.tal.app.thinkacademy.business.login.presenter.LoginViewModel r5 = r0.getMViewModel()
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r11.this$0
            java.lang.String r0 = r0.mContactInfo
            if (r0 != 0) goto L_0x0183
            r6 = r4
            goto L_0x0184
        L_0x0183:
            r6 = r0
        L_0x0184:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r11.this$0
            java.lang.String r0 = r0.mCountryCallingCode
            if (r0 != 0) goto L_0x018e
            r7 = r4
            goto L_0x018f
        L_0x018e:
            r7 = r0
        L_0x018f:
            r0 = 14
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r11.this$0
            java.lang.String r0 = r0.mVerificationCode
            if (r0 != 0) goto L_0x019f
            r9 = r4
            goto L_0x01a0
        L_0x019f:
            r9 = r0
        L_0x01a0:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r11.this$0
            java.lang.Integer r10 = r0.mType
            r5.securityCheck(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity$setListener$4.invoke():void");
    }
}
