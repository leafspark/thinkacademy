package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0}, l = {123}, m = "requestBufferSuspend", n = {"$this$requestBufferSuspend"}, s = {"L$0"})
/* compiled from: ReadSession.kt */
final class ReadSessionKt$requestBufferSuspend$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ReadSessionKt$requestBufferSuspend$1(Continuation<? super ReadSessionKt$requestBufferSuspend$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ReadSessionKt.requestBufferSuspend((SuspendableReadSession) null, 0, (Continuation) this);
    }
}
