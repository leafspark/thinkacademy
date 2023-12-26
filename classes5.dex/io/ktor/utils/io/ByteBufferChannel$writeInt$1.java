package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7}, l = {928, 928, 928, 2433, 2488, 928, 928, 2515}, m = "writeInt$suspendImpl", n = {"joined$iv$iv", "this_$iv$iv$iv", "i", "capacity$iv", "this_$iv$iv", "$this$writeSuspendPrimitive$iv$iv", "i", "size$iv", "joined$iv$iv$iv", "this_$iv$iv$iv$iv", "i"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "I$0"})
/* compiled from: ByteBufferChannel.kt */
final class ByteBufferChannel$writeInt$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$writeInt$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$writeInt$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteBufferChannel.writeInt$suspendImpl(this.this$0, 0, (Continuation) this);
    }
}
