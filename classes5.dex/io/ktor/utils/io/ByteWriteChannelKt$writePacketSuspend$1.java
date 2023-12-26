package io.ktor.utils.io;

import io.ktor.utils.io.core.BytePacketBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelKt", f = "ByteWriteChannel.kt", i = {0}, l = {199, 199}, m = "writePacketSuspend", n = {"builder$iv"}, s = {"L$0"})
/* compiled from: ByteWriteChannel.kt */
final class ByteWriteChannelKt$writePacketSuspend$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ByteWriteChannelKt$writePacketSuspend$1(Continuation<? super ByteWriteChannelKt$writePacketSuspend$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteWriteChannelKt.writePacketSuspend((ByteWriteChannel) null, (Function2<? super BytePacketBuilder, ? super Continuation<? super Unit>, ? extends Object>) null, (Continuation) this);
    }
}
