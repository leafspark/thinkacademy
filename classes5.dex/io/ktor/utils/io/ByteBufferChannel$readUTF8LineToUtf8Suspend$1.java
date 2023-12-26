package io.ktor.utils.io;

import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0}, l = {2031}, m = "readUTF8LineToUtf8Suspend", n = {"result"}, s = {"L$0"})
/* compiled from: ByteBufferChannel.kt */
final class ByteBufferChannel$readUTF8LineToUtf8Suspend$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$readUTF8LineToUtf8Suspend$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$readUTF8LineToUtf8Suspend$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readUTF8LineToUtf8Suspend((Appendable) null, 0, (char[]) null, (CharBuffer) null, 0, (Continuation) this);
    }
}
