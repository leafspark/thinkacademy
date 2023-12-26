package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/ChannelScope;", "Lio/ktor/utils/io/ReaderScope;", "Lio/ktor/utils/io/WriterScope;", "Lkotlinx/coroutines/CoroutineScope;", "delegate", "channel", "Lio/ktor/utils/io/ByteChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteChannel;)V", "getChannel", "()Lio/ktor/utils/io/ByteChannel;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Coroutines.kt */
final class ChannelScope implements ReaderScope, WriterScope, CoroutineScope {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final ByteChannel channel;

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public ChannelScope(CoroutineScope coroutineScope, ByteChannel byteChannel) {
        Intrinsics.checkNotNullParameter(coroutineScope, "delegate");
        Intrinsics.checkNotNullParameter(byteChannel, "channel");
        this.channel = byteChannel;
        this.$$delegate_0 = coroutineScope;
    }

    public ByteChannel getChannel() {
        return this.channel;
    }
}
