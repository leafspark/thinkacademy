package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {35}, m = "readLongLittleEndian", n = {}, s = {})
/* compiled from: ChannelLittleEndian.kt */
final class ChannelLittleEndianKt$readLongLittleEndian$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    ChannelLittleEndianKt$readLongLittleEndian$1(Continuation<? super ChannelLittleEndianKt$readLongLittleEndian$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelLittleEndianKt.readLongLittleEndian((ByteReadChannel) null, (Continuation) this);
    }
}
