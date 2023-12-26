package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindPhoneDialog", f = "BindPhoneDialog.kt", i = {}, l = {179, 177}, m = "getSmsCode", n = {}, s = {})
/* compiled from: BindPhoneDialog.kt */
final class BindPhoneDialog$getSmsCode$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BindPhoneDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BindPhoneDialog$getSmsCode$1(BindPhoneDialog bindPhoneDialog, Continuation<? super BindPhoneDialog$getSmsCode$1> continuation) {
        super(continuation);
        this.this$0 = bindPhoneDialog;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.getSmsCode((String) null, (String) null, (Integer) null, (Integer) null, this);
    }
}
