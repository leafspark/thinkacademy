package com.tal.app.thinkacademy.live.business.function.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository", f = "FunctionRepository.kt", i = {}, l = {27, 27}, m = "getPhotoBoxMessage", n = {}, s = {})
/* compiled from: FunctionRepository.kt */
final class FunctionRepository$getPhotoBoxMessage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FunctionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FunctionRepository$getPhotoBoxMessage$1(FunctionRepository functionRepository, Continuation<? super FunctionRepository$getPhotoBoxMessage$1> continuation) {
        super(continuation);
        this.this$0 = functionRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPhotoBoxMessage(0, (Continuation) this);
    }
}
