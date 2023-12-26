package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteChannelSequentialBase;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", i = {0, 0}, l = {8}, m = "joinToImpl", n = {"dst", "closeOnEnd"}, s = {"L$0", "Z$0"})
/* compiled from: SequentialCopyTo.kt */
final class SequentialCopyToKt$joinToImpl$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    SequentialCopyToKt$joinToImpl$1(Continuation<? super SequentialCopyToKt$joinToImpl$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SequentialCopyToKt.joinToImpl((ByteChannelSequentialBase) null, (ByteChannelSequentialBase) null, false, (Continuation) this);
    }
}
