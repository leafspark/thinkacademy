package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0}, l = {130}, m = "requestBufferFallback", n = {"chunk"}, s = {"L$0"})
/* compiled from: ReadSession.kt */
final class ReadSessionKt$requestBufferFallback$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ReadSessionKt$requestBufferFallback$1(Continuation<? super ReadSessionKt$requestBufferFallback$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReadSessionKt.requestBufferFallback((ByteReadChannel) null, 0, (Continuation) this);
    }
}
