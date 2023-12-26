package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {233}, m = "write", n = {"this", "block", "min"}, s = {"L$0", "L$1", "I$0"})
/* compiled from: ByteChannelSequentialJVM.kt */
final class ByteChannelSequentialJVM$write$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialJVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteChannelSequentialJVM$write$1(ByteChannelSequentialJVM byteChannelSequentialJVM, Continuation<? super ByteChannelSequentialJVM$write$1> continuation) {
        super(continuation);
        this.this$0 = byteChannelSequentialJVM;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.write(0, (Function1<? super ByteBuffer, Unit>) null, (Continuation) this);
    }
}
