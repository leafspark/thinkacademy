package com.tal.app.thinkacademy.business.home.main.shop.vm;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm", f = "ShopHomeNativeVm.kt", i = {}, l = {127, 125}, m = "getHomeDataListReal", n = {}, s = {})
/* compiled from: ShopHomeNativeVm.kt */
final class ShopHomeNativeVm$getHomeDataListReal$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShopHomeNativeVm this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopHomeNativeVm$getHomeDataListReal$1(ShopHomeNativeVm shopHomeNativeVm, Continuation<? super ShopHomeNativeVm$getHomeDataListReal$1> continuation) {
        super(continuation);
        this.this$0 = shopHomeNativeVm;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.getHomeDataListReal(0, this);
    }
}
