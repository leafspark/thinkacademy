package com.tal.app.thinkacademy.common.business.browser.helper;

import com.tal.app.thinkacademy.common.entity.OrderPayRequestBean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.common.business.browser.helper.PayHelp", f = "PayHelp.kt", i = {}, l = {188, 186}, m = "getPayInfo", n = {}, s = {})
/* compiled from: PayHelp.kt */
final class PayHelp$getPayInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PayHelp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PayHelp$getPayInfo$1(PayHelp payHelp, Continuation<? super PayHelp$getPayInfo$1> continuation) {
        super(continuation);
        this.this$0 = payHelp;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPayInfo((OrderPayRequestBean) null, (Continuation) this);
    }
}
