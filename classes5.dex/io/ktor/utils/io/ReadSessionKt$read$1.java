package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0, 0, 1, 1, 1, 2}, l = {23, 27, 30}, m = "read", n = {"$this$read", "block", "$this$read", "buffer", "bytesRead", "cause"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0"})
/* compiled from: ReadSession.kt */
final class ReadSessionKt$read$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ReadSessionKt$read$1(Continuation<? super ReadSessionKt$read$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReadSessionKt.read((ByteReadChannel) null, 0, (Function3<? super Memory, ? super Long, ? super Long, Integer>) null, (Continuation) this);
    }
}
