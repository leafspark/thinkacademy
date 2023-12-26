package com.tal.app.thinkacademy.business.login.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountVerificationActivity.kt */
final class AccountVerificationActivity$setListener$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AccountVerificationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountVerificationActivity$setListener$3(AccountVerificationActivity accountVerificationActivity) {
        super(0);
        this.this$0 = accountVerificationActivity;
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r8 = this;
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            int r1 = r0.mPhoneLengthMax
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r2 = r8.this$0
            int r2 = r2.mPhoneLengthMin
            r0.changeStatus(r1, r2)
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r0 = r0.getBinding()
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r0 = r0.etPhoneNumber
            if (r0 != 0) goto L_0x001a
            goto L_0x001d
        L_0x001a:
            r0.clearFocus()
        L_0x001d:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r0 = r0.getBinding()
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r0 = r0.etEmailNumber
            if (r0 != 0) goto L_0x0028
            goto L_0x002b
        L_0x0028:
            r0.clearFocus()
        L_0x002b:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            boolean r0 = r0.isRightNumber
            if (r0 == 0) goto L_0x01de
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer r0 = r0.mTimer
            if (r0 != 0) goto L_0x0068
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer r7 = new com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer
            r2 = 60000(0xea60, double:2.9644E-319)
            r4 = 1000(0x3e8, double:4.94E-321)
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r8.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            android.widget.TextView r6 = r1.tvSecond
            java.lang.String r1 = "binding.tvSecond"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            r1 = r7
            r1.<init>(r2, r4, r6)
            r0.mTimer = r7
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer r0 = r0.mTimer
            if (r0 != 0) goto L_0x0061
            goto L_0x0068
        L_0x0061:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r8.this$0
            com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer$ITimerListener r1 = (com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer.ITimerListener) r1
            r0.setTimerListener(r1)
        L_0x0068:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            com.tal.app.thinkacademy.business.login.widget.LoginCountDownTimer r0 = r0.mTimer
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0074
        L_0x0072:
            r0 = r1
            goto L_0x007b
        L_0x0074:
            boolean r0 = r0.isTick()
            if (r0 != r2) goto L_0x0072
            r0 = r2
        L_0x007b:
            if (r0 == 0) goto L_0x007e
            return
        L_0x007e:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            r0.showLoading()
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r0 = r0.getBinding()
            android.widget.TextView r0 = r0.tvSend
            r0.setEnabled(r1)
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r0 = r8.this$0
            com.tal.app.thinkacademy.business.login.presenter.LoginViewModel r0 = r0.getMViewModel()
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r8.this$0
            boolean r1 = r1.mIsLogin
            r3 = 0
            if (r1 == 0) goto L_0x00fe
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r8.this$0
            int r1 = r1.KTypeSms
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r4 = r8.this$0
            java.lang.Integer r4 = r4.mType
            if (r4 != 0) goto L_0x00ac
            goto L_0x00da
        L_0x00ac:
            int r4 = r4.intValue()
            if (r1 != r4) goto L_0x00da
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r8.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            android.widget.TextView r1 = r1.phoneNumberLogin
            if (r1 != 0) goto L_0x00be
            goto L_0x0141
        L_0x00be:
            java.lang.CharSequence r1 = r1.getText()
            if (r1 != 0) goto L_0x00c6
            goto L_0x0141
        L_0x00c6:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x00ce
            goto L_0x0141
        L_0x00ce:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            goto L_0x015b
        L_0x00da:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r8.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            android.widget.TextView r1 = r1.emailNumberLogin
            if (r1 != 0) goto L_0x00e5
            goto L_0x0141
        L_0x00e5:
            java.lang.CharSequence r1 = r1.getText()
            if (r1 != 0) goto L_0x00ec
            goto L_0x0141
        L_0x00ec:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x00f3
            goto L_0x0141
        L_0x00f3:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            goto L_0x015b
        L_0x00fe:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r8.this$0
            int r1 = r1.KTypeSms
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r4 = r8.this$0
            java.lang.Integer r4 = r4.mType
            if (r4 != 0) goto L_0x010d
            goto L_0x0137
        L_0x010d:
            int r4 = r4.intValue()
            if (r1 != r4) goto L_0x0137
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r8.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r1 = r1.etPhoneNumber
            if (r1 != 0) goto L_0x011e
            goto L_0x0141
        L_0x011e:
            android.text.Editable r1 = r1.getText()
            if (r1 != 0) goto L_0x0125
            goto L_0x0141
        L_0x0125:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x012c
            goto L_0x0141
        L_0x012c:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            goto L_0x015b
        L_0x0137:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r1 = r8.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r1 = r1.getBinding()
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r1 = r1.etEmailNumber
            if (r1 != 0) goto L_0x0143
        L_0x0141:
            r1 = r3
            goto L_0x015b
        L_0x0143:
            android.text.Editable r1 = r1.getText()
            if (r1 != 0) goto L_0x014a
            goto L_0x0141
        L_0x014a:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x0151
            goto L_0x0141
        L_0x0151:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
        L_0x015b:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r4 = r8.this$0
            java.lang.Integer r4 = r4.mType
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r5 = r8.this$0
            int r5 = r5.KTypeSms
            if (r4 != 0) goto L_0x016a
            goto L_0x01cd
        L_0x016a:
            int r4 = r4.intValue()
            if (r4 != r5) goto L_0x01cd
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r4 = r8.this$0
            boolean r4 = r4.mIsLogin
            if (r4 == 0) goto L_0x01a4
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r4 = r8.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r4 = r4.getBinding()
            android.widget.TextView r4 = r4.tvCountryCodeLogin
            if (r4 != 0) goto L_0x0183
            goto L_0x01cf
        L_0x0183:
            java.lang.CharSequence r4 = r4.getText()
            if (r4 != 0) goto L_0x018a
            goto L_0x01cf
        L_0x018a:
            int r5 = r4.length()
            java.lang.CharSequence r2 = r4.subSequence(r2, r5)
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L_0x0199
            goto L_0x01cf
        L_0x0199:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r2 = kotlin.text.StringsKt.trim(r2)
            java.lang.String r3 = r2.toString()
            goto L_0x01cf
        L_0x01a4:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r4 = r8.this$0
            com.tal.app.thinkacademy.business.login.databinding.LiveLoginActivityAccountVerificationBinding r4 = r4.getBinding()
            android.widget.TextView r4 = r4.tvCountryCode
            java.lang.CharSequence r4 = r4.getText()
            if (r4 != 0) goto L_0x01b3
            goto L_0x01cf
        L_0x01b3:
            int r5 = r4.length()
            java.lang.CharSequence r2 = r4.subSequence(r2, r5)
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L_0x01c2
            goto L_0x01cf
        L_0x01c2:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r2 = kotlin.text.StringsKt.trim(r2)
            java.lang.String r3 = r2.toString()
            goto L_0x01cf
        L_0x01cd:
            java.lang.String r3 = ""
        L_0x01cf:
            com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity r2 = r8.this$0
            java.lang.Integer r2 = r2.mType
            r4 = 14
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r0.getSmsCode(r1, r3, r2, r4)
        L_0x01de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.view.AccountVerificationActivity$setListener$3.invoke():void");
    }
}
