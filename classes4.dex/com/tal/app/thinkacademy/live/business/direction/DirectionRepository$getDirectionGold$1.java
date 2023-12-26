package com.tal.app.thinkacademy.live.business.direction;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.direction.DirectionRepository", f = "DirectionRepository.kt", i = {}, l = {28, 28}, m = "getDirectionGold", n = {}, s = {})
/* compiled from: DirectionRepository.kt */
final class DirectionRepository$getDirectionGold$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DirectionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DirectionRepository$getDirectionGold$1(DirectionRepository directionRepository, Continuation<? super DirectionRepository$getDirectionGold$1> continuation) {
        super(continuation);
        this.this$0 = directionRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDirectionGold((Integer) null, (String) null, (String) null, (Continuation) this);
    }
}
