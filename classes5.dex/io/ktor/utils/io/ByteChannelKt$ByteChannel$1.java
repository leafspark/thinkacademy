package io.ktor.utils.io;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"io/ktor/utils/io/ByteChannelKt$ByteChannel$1", "Lio/ktor/utils/io/ByteBufferChannel;", "close", "", "cause", "", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteChannel.kt */
public final class ByteChannelKt$ByteChannel$1 extends ByteBufferChannel {
    final /* synthetic */ Function1<Throwable, Throwable> $exceptionMapper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteChannelKt$ByteChannel$1(boolean z, Function1<? super Throwable, ? extends Throwable> function1) {
        super(z, (ObjectPool) null, 0, 6, (DefaultConstructorMarker) null);
        this.$exceptionMapper = function1;
    }

    public boolean close(Throwable th) {
        return super.close((Throwable) this.$exceptionMapper.invoke(th));
    }
}
