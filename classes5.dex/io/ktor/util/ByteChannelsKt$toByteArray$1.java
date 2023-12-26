package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt", f = "ByteChannels.kt", i = {}, l = {90}, m = "toByteArray", n = {}, s = {})
/* compiled from: ByteChannels.kt */
final class ByteChannelsKt$toByteArray$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    ByteChannelsKt$toByteArray$1(Continuation<? super ByteChannelsKt$toByteArray$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteChannelsKt.toByteArray((ByteReadChannel) null, (Continuation) this);
    }
}
