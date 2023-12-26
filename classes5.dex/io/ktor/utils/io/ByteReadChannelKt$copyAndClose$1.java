package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelKt", f = "ByteReadChannel.kt", i = {0}, l = {255}, m = "copyAndClose", n = {"dst"}, s = {"L$0"})
/* compiled from: ByteReadChannel.kt */
final class ByteReadChannelKt$copyAndClose$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ByteReadChannelKt$copyAndClose$1(Continuation<? super ByteReadChannelKt$copyAndClose$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteReadChannelKt.copyAndClose((ByteReadChannel) null, (ByteWriteChannel) null, 0, (Continuation) this);
    }
}
