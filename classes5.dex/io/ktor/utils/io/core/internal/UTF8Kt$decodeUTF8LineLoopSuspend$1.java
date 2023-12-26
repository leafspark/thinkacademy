package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.core.Input;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.core.internal.UTF8Kt", f = "UTF8.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {36}, m = "decodeUTF8LineLoopSuspend", n = {"out", "nextChunk", "afterRead", "decoded", "size", "cr", "end", "limit"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
/* compiled from: UTF8.kt */
final class UTF8Kt$decodeUTF8LineLoopSuspend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;

    UTF8Kt$decodeUTF8LineLoopSuspend$1(Continuation<? super UTF8Kt$decodeUTF8LineLoopSuspend$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UTF8Kt.decodeUTF8LineLoopSuspend((Appendable) null, 0, (Function2<? super Integer, ? super Continuation<? super Input>, ? extends Object>) null, (Function1<? super Integer, Unit>) null, (Continuation) this);
    }
}
