package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0, 0, 0, 0, 0}, l = {2110}, m = "readRemainingSuspend", n = {"this", "builder$iv", "remaining", "$this$writeWhile$iv", "tail$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: ByteBufferChannel.kt */
final class ByteBufferChannel$readRemainingSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$readRemainingSuspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readRemainingSuspend$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readRemainingSuspend(0, (Continuation) this);
    }
}
