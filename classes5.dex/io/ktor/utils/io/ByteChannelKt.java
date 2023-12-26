package io.ktor.utils.io;

import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u000f"}, d2 = {"ByteChannel", "Lio/ktor/utils/io/ByteChannel;", "autoFlush", "", "exceptionMapper", "Lkotlin/Function1;", "", "ByteReadChannel", "Lio/ktor/utils/io/ByteReadChannel;", "content", "Ljava/nio/ByteBuffer;", "", "offset", "", "length", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteChannel.kt */
public final class ByteChannelKt {
    public static final ByteReadChannel ByteReadChannel(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "content");
        return new ByteBufferChannel(byteBuffer);
    }

    public static final ByteChannel ByteChannel(boolean z) {
        return new ByteBufferChannel(z, (ObjectPool) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ByteChannel ByteChannel$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return ByteChannel(z);
    }

    public static final ByteReadChannel ByteReadChannel(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "content");
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, i2);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(content, offset, length)");
        return new ByteBufferChannel(wrap);
    }

    public static /* synthetic */ ByteChannel ByteChannel$default(boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return ByteChannel(z, function1);
    }

    public static final ByteChannel ByteChannel(boolean z, Function1<? super Throwable, ? extends Throwable> function1) {
        Intrinsics.checkNotNullParameter(function1, "exceptionMapper");
        return new ByteChannelKt$ByteChannel$1(z, function1);
    }
}
