package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0}, l = {80}, m = "completeWritingFallback", n = {"buffer"}, s = {"L$0"})
/* compiled from: WriterSession.kt */
final class WriterSessionKt$completeWritingFallback$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    WriterSessionKt$completeWritingFallback$1(Continuation<? super WriterSessionKt$completeWritingFallback$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WriterSessionKt.completeWritingFallback((ByteWriteChannel) null, (Buffer) null, (Continuation) this);
    }
}
