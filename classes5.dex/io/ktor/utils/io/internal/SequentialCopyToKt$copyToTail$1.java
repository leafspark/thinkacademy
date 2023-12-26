package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteChannelSequentialBase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0, 1, 1}, l = {60, 66}, m = "copyToTail", n = {"dst", "lastPiece", "lastPiece", "rc"}, s = {"L$0", "L$1", "L$0", "I$0"})
/* compiled from: SequentialCopyTo.kt */
final class SequentialCopyToKt$copyToTail$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    SequentialCopyToKt$copyToTail$1(Continuation<? super SequentialCopyToKt$copyToTail$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SequentialCopyToKt.copyToTail((ByteChannelSequentialBase) null, (ByteChannelSequentialBase) null, 0, (Continuation) this);
    }
}
