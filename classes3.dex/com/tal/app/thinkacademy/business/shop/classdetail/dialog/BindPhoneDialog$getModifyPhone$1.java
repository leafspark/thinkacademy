package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.bean.request.ModifyPhoneRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindPhoneDialog", f = "BindPhoneDialog.kt", i = {}, l = {223, 221}, m = "getModifyPhone", n = {}, s = {})
/* compiled from: BindPhoneDialog.kt */
final class BindPhoneDialog$getModifyPhone$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BindPhoneDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BindPhoneDialog$getModifyPhone$1(BindPhoneDialog bindPhoneDialog, Continuation<? super BindPhoneDialog$getModifyPhone$1> continuation) {
        super(continuation);
        this.this$0 = bindPhoneDialog;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.getModifyPhone((ShopRequestCommonBody<ModifyPhoneRequest>) null, this);
    }
}
