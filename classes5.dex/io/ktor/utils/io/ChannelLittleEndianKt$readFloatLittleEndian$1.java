package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {39}, m = "readFloatLittleEndian", n = {}, s = {})
/* compiled from: ChannelLittleEndian.kt */
final class ChannelLittleEndianKt$readFloatLittleEndian$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    ChannelLittleEndianKt$readFloatLittleEndian$1(Continuation<? super ChannelLittleEndianKt$readFloatLittleEndian$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelLittleEndianKt.readFloatLittleEndian((ByteReadChannel) null, (Continuation) this);
    }
}
