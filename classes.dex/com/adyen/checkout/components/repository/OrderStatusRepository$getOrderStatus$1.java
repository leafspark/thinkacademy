package com.adyen.checkout.components.repository;

import com.adyen.checkout.components.base.Configuration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.adyen.checkout.components.repository.OrderStatusRepository", f = "OrderStatusRepository.kt", i = {}, l = {50}, m = "getOrderStatus", n = {}, s = {})
/* compiled from: OrderStatusRepository.kt */
final class OrderStatusRepository$getOrderStatus$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OrderStatusRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderStatusRepository$getOrderStatus$1(OrderStatusRepository orderStatusRepository, Continuation<? super OrderStatusRepository$getOrderStatus$1> continuation) {
        super(continuation);
        this.this$0 = orderStatusRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getOrderStatus((Configuration) null, (String) null, (Continuation) this);
    }
}
