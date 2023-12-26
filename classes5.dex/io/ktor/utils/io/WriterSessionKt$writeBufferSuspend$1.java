package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0, 0}, l = {90}, m = "writeBufferSuspend", n = {"session", "desiredSpace"}, s = {"L$0", "I$0"})
/* compiled from: WriterSession.kt */
final class WriterSessionKt$writeBufferSuspend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    WriterSessionKt$writeBufferSuspend$1(Continuation<? super WriterSessionKt$writeBufferSuspend$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WriterSessionKt.writeBufferSuspend((WriterSuspendSession) null, 0, (Continuation) this);
    }
}
