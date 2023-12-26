package com.tal.app.thinkacademy.business.shop.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.repository.ShopClassListRepository", f = "ShopClassListRepository.kt", i = {}, l = {45, 44}, m = "getTeacherDetailsList", n = {}, s = {})
/* compiled from: ShopClassListRepository.kt */
final class ShopClassListRepository$getTeacherDetailsList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShopClassListRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopClassListRepository$getTeacherDetailsList$1(ShopClassListRepository shopClassListRepository, Continuation<? super ShopClassListRepository$getTeacherDetailsList$1> continuation) {
        super(continuation);
        this.this$0 = shopClassListRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return this.this$0.getTeacherDetailsList(0, this);
    }
}
