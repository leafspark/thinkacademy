package com.tal.app.thinkacademy.business.home.main.dialog;

import android.view.View;
import com.tal.app.thinkacademy.business.home.main.dialog.PaymentRemindManager;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class PaymentRemindManager$PaymentRemindDialog$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ PaymentRemindManager.PaymentRemindDialog f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ PaymentRemindManager$PaymentRemindDialog$$ExternalSyntheticLambda1(PaymentRemindManager.PaymentRemindDialog paymentRemindDialog, Function1 function1) {
        this.f$0 = paymentRemindDialog;
        this.f$1 = function1;
    }

    public final void onClick(View view) {
        PaymentRemindManager.PaymentRemindDialog.m39setPositiveButton$lambda1(this.f$0, this.f$1, view);
    }
}
