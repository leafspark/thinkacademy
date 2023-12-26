package io.ktor.utils.io.nio;

import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SelectableChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J-\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Lio/ktor/utils/io/nio/ChannelAsInput;", "Lio/ktor/utils/io/core/Input;", "channel", "Ljava/nio/channels/ReadableByteChannel;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Ljava/nio/channels/ReadableByteChannel;Lio/ktor/utils/io/pool/ObjectPool;)V", "closeSource", "", "fill", "", "destination", "Lio/ktor/utils/io/bits/Memory;", "offset", "length", "fill-62zg_DM", "(Ljava/nio/ByteBuffer;II)I", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Input.kt */
final class ChannelAsInput extends Input {
    private final ReadableByteChannel channel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelAsInput(ReadableByteChannel readableByteChannel, ObjectPool<ChunkBuffer> objectPool) {
        super((ChunkBuffer) null, 0, objectPool, 3, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(readableByteChannel, "channel");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.channel = readableByteChannel;
        if (!(!(readableByteChannel instanceof SelectableChannel) || !((SelectableChannel) readableByteChannel).isBlocking())) {
            throw new IllegalArgumentException("Non-blocking channels are not supported".toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: fill-62zg_DM  reason: not valid java name */
    public int m308fill62zg_DM(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "destination");
        return RangesKt.coerceAtLeast(this.channel.read(MemoryJvmKt.sliceSafe(byteBuffer, i, i2)), 0);
    }

    /* access modifiers changed from: protected */
    public void closeSource() {
        this.channel.close();
    }
}
