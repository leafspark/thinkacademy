package com.tal.app.thinkacademy.live.business.function.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.function.repository.FunctionRepository", f = "FunctionRepository.kt", i = {}, l = {37, 37}, m = "getPhotoBox", n = {}, s = {})
/* compiled from: FunctionRepository.kt */
final class FunctionRepository$getPhotoBox$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FunctionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FunctionRepository$getPhotoBox$1(FunctionRepository functionRepository, Continuation<? super FunctionRepository$getPhotoBox$1> continuation) {
        super(continuation);
        this.this$0 = functionRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPhotoBox(0, (Continuation) this);
    }
}