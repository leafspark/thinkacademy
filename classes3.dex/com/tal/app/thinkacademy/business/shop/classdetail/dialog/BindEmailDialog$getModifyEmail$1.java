package com.tal.app.thinkacademy.business.shop.classdetail.dialog;

import com.tal.app.thinkacademy.business.shop.bean.ShopRequestCommonBody;
import com.tal.app.thinkacademy.business.shop.bean.request.ModifyEmailRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.classdetail.dialog.BindEmailDialog", f = "BindEmailDialog.kt", i = {}, l = {232, 230}, m = "getModifyEmail", n = {}, s = {})
/* compiled from: BindEmailDialog.kt */
final class BindEmailDialog$getModifyEmail$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BindEmailDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BindEmailDialog$getModifyEmail$1(BindEmailDialog bindEmailDialog, Continuation<? super BindEmailDialog$getModifyEmail$1> continuation) {
        super(continuation);
        this.this$0 = bindEmailDialog;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.getModifyEmail((ShopRequestCommonBody<ModifyEmailRequest>) null, this);
    }
}
