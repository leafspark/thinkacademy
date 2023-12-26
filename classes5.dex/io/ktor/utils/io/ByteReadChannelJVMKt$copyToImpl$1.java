package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelJVMKt", f = "ByteReadChannelJVM.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {302, 305}, m = "copyToImpl", n = {"$this$copyToImpl", "dst", "buffer", "limit", "dstNeedsFlush", "copied", "$this$copyToImpl", "dst", "buffer", "limit", "dstNeedsFlush", "copied", "size"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "J$1", "L$0", "L$1", "L$2", "J$0", "I$0", "J$1", "I$1"})
/* compiled from: ByteReadChannelJVM.kt */
final class ByteReadChannelJVMKt$copyToImpl$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ByteReadChannelJVMKt$copyToImpl$1(Continuation<? super ByteReadChannelJVMKt$copyToImpl$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteReadChannelJVMKt.copyToImpl((ByteReadChannel) null, (ByteWriteChannel) null, 0, (Continuation) this);
    }
}
