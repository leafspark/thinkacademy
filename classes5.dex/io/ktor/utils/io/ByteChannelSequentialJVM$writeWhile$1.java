package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {245}, m = "writeWhile", n = {"this", "block", "shouldContinue"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: ByteChannelSequentialJVM.kt */
final class ByteChannelSequentialJVM$writeWhile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelSequentialJVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteChannelSequentialJVM$writeWhile$1(ByteChannelSequentialJVM byteChannelSequentialJVM, Continuation<? super ByteChannelSequentialJVM$writeWhile$1> continuation) {
        super(continuation);
        this.this$0 = byteChannelSequentialJVM;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeWhile((Function1<? super ByteBuffer, Boolean>) null, (Continuation) this);
    }
}
