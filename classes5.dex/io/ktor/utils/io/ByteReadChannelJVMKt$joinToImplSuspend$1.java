package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", i = {0, 0}, l = {261}, m = "joinToImplSuspend", n = {"dst", "close"}, s = {"L$0", "Z$0"})
/* compiled from: ByteReadChannelJVM.kt */
final class ByteReadChannelJVMKt$joinToImplSuspend$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    ByteReadChannelJVMKt$joinToImplSuspend$1(Continuation<? super ByteReadChannelJVMKt$joinToImplSuspend$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteReadChannelJVMKt.joinToImplSuspend((ByteReadChannel) null, (ByteWriteChannel) null, false, (Continuation) this);
    }
}
