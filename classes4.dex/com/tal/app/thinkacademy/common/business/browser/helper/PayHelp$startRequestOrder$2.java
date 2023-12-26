package com.tal.app.thinkacademy.common.business.browser.helper;

import com.tal.app.thinkacademy.common.entity.OrderPayRequestBean;
import com.tal.app.thinkacademy.common.entity.OrderPlayResponseBean;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.common.business.browser.helper.PayHelp$startRequestOrder$2", f = "PayHelp.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PayHelp.kt */
final class PayHelp$startRequestOrder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OrderPayRequestBean $orderPayRequestBean;
    int label;
    final /* synthetic */ PayHelp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PayHelp$startRequestOrder$2(PayHelp payHelp, OrderPayRequestBean orderPayRequestBean, Continuation<? super PayHelp$startRequestOrder$2> continuation) {
        super(2, continuation);
        this.this$0 = payHelp;
        this.$orderPayRequestBean = orderPayRequestBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new PayHelp$startRequestOrder$2(this.this$0, this.$orderPayRequestBean, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getPayInfo(this.$orderPayRequestBean, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OrderPlayResponseBean orderPlayResponseBean = (OrderPlayResponseBean) obj;
        if (orderPlayResponseBean != null) {
            this.this$0.startSendPay(orderPlayResponseBean);
        } else {
            XesLog.dt(PayHelp.TAG, "startRequestOrder result is null");
            ToastUtils.showLong("result is null", new Object[0]);
        }
        XesLog.dt(PayHelp.TAG, "startRequestOrder success");
        return Unit.INSTANCE;
    }
}
