package io.ktor.utils.io;

import io.ktor.utils.io.bits.Memory;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0, 0}, l = {21, 28, 28}, m = "write", n = {"$this$write", "block"}, s = {"L$0", "L$1"})
/* compiled from: WriterSession.kt */
final class WriterSessionKt$write$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    WriterSessionKt$write$1(Continuation<? super WriterSessionKt$write$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WriterSessionKt.write((ByteWriteChannel) null, 0, (Function3<? super Memory, ? super Long, ? super Long, Integer>) null, (Continuation) this);
    }
}
