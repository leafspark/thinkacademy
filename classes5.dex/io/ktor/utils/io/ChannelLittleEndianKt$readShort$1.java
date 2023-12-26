package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteOrder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {7}, m = "readShort", n = {"byteOrder"}, s = {"L$0"})
/* compiled from: ChannelLittleEndian.kt */
final class ChannelLittleEndianKt$readShort$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ChannelLittleEndianKt$readShort$1(Continuation<? super ChannelLittleEndianKt$readShort$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelLittleEndianKt.readShort((ByteReadChannel) null, (ByteOrder) null, (Continuation) this);
    }
}
