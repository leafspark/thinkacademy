package io.ktor.utils.io.nio;

import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Lio/ktor/utils/io/nio/ChannelAsOutput;", "Lio/ktor/utils/io/core/Output;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "channel", "Ljava/nio/channels/WritableByteChannel;", "(Lio/ktor/utils/io/pool/ObjectPool;Ljava/nio/channels/WritableByteChannel;)V", "getChannel", "()Ljava/nio/channels/WritableByteChannel;", "closeDestination", "", "flush", "source", "Lio/ktor/utils/io/bits/Memory;", "offset", "", "length", "flush-62zg_DM", "(Ljava/nio/ByteBuffer;II)V", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Output.kt */
final class ChannelAsOutput extends Output {
    private final WritableByteChannel channel;

    public final WritableByteChannel getChannel() {
        return this.channel;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelAsOutput(ObjectPool<ChunkBuffer> objectPool, WritableByteChannel writableByteChannel) {
        super(objectPool);
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        Intrinsics.checkNotNullParameter(writableByteChannel, "channel");
        this.channel = writableByteChannel;
    }

    /* access modifiers changed from: protected */
    /* renamed from: flush-62zg_DM  reason: not valid java name */
    public void m309flush62zg_DM(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        ByteBuffer sliceSafe = MemoryJvmKt.sliceSafe(byteBuffer, i, i2);
        while (sliceSafe.hasRemaining()) {
            this.channel.write(sliceSafe);
        }
    }

    /* access modifiers changed from: protected */
    public void closeDestination() {
        this.channel.close();
    }
}
