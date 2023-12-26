package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {127}, m = "readFullySuspend", n = {"this", "dst", "count"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: ByteChannelSequentialJVM.kt */
final class ByteChannelSequentialJVM$readFullySuspend$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialJVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteChannelSequentialJVM$readFullySuspend$1(ByteChannelSequentialJVM byteChannelSequentialJVM, Continuation<? super ByteChannelSequentialJVM$readFullySuspend$1> continuation) {
        super(continuation);
        this.this$0 = byteChannelSequentialJVM;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readFullySuspend((ByteBuffer) null, 0, (Continuation) this);
    }
}
