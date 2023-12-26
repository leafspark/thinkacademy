package io.ktor.utils.io.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", i = {0}, l = {24}, m = "sleep", n = {"this"}, s = {"L$0"})
/* compiled from: AwaitingSlot.kt */
final class AwaitingSlot$sleep$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwaitingSlot this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AwaitingSlot$sleep$1(AwaitingSlot awaitingSlot, Continuation<? super AwaitingSlot$sleep$1> continuation) {
        super(continuation);
        this.this$0 = awaitingSlot;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sleep((Function0<Boolean>) null, (Continuation) this);
    }
}
