package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.business.study.study.dialog.CheckInSuccessDialog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrepareClassActivity.kt */
final class PrepareClassActivity$startObserve$4$1 implements Runnable {
    final /* synthetic */ PrepareClassActivity this$0;

    PrepareClassActivity$startObserve$4$1(PrepareClassActivity prepareClassActivity) {
        this.this$0 = prepareClassActivity;
    }

    public final void run() {
        CheckInSuccessDialog access$getMCheckInSuccessDialog$p = this.this$0.mCheckInSuccessDialog;
        if (access$getMCheckInSuccessDialog$p != null) {
            access$getMCheckInSuccessDialog$p.dismiss();
        }
    }
}
