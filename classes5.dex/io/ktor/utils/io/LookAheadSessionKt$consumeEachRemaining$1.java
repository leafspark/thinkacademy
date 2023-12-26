package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.LookAheadSessionKt", f = "LookAheadSession.kt", i = {0, 0, 1, 1, 1}, l = {54, 59}, m = "consumeEachRemaining", n = {"$this$consumeEachRemaining", "visitor", "$this$consumeEachRemaining", "visitor", "s"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
/* compiled from: LookAheadSession.kt */
final class LookAheadSessionKt$consumeEachRemaining$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    LookAheadSessionKt$consumeEachRemaining$1(Continuation<? super LookAheadSessionKt$consumeEachRemaining$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return LookAheadSessionKt.consumeEachRemaining((LookAheadSuspendSession) null, (Function2<? super ByteBuffer, ? super Continuation<? super Boolean>, ? extends Object>) null, (Continuation) this);
    }
}
