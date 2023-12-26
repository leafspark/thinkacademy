package io.ktor.utils.io.internal;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.SuspendableReadSession;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lio/ktor/utils/io/internal/ReadSessionImpl;", "Lio/ktor/utils/io/SuspendableReadSession;", "channel", "Lio/ktor/utils/io/ByteBufferChannel;", "(Lio/ktor/utils/io/ByteBufferChannel;)V", "availableForRead", "", "getAvailableForRead", "()I", "lastAvailable", "lastView", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "await", "", "atLeast", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "completed", "", "newView", "discard", "n", "request", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadSessionImpl.kt */
public final class ReadSessionImpl implements SuspendableReadSession {
    private final ByteBufferChannel channel;
    private int lastAvailable;
    private ChunkBuffer lastView = ChunkBuffer.Companion.getEmpty();

    public ReadSessionImpl(ByteBufferChannel byteBufferChannel) {
        Intrinsics.checkNotNullParameter(byteBufferChannel, "channel");
        this.channel = byteBufferChannel;
    }

    public final void completed() {
        completed(ChunkBuffer.Companion.getEmpty());
    }

    private final void completed(ChunkBuffer chunkBuffer) {
        int i = this.lastAvailable;
        Buffer buffer = this.lastView;
        int writePosition = i - (buffer.getWritePosition() - buffer.getReadPosition());
        if (writePosition > 0) {
            this.channel.consumed(writePosition);
        }
        this.lastView = chunkBuffer;
        Buffer buffer2 = chunkBuffer;
        this.lastAvailable = buffer2.getWritePosition() - buffer2.getReadPosition();
    }

    public int getAvailableForRead() {
        return this.channel.getAvailableForRead();
    }

    public int discard(int i) {
        completed();
        int min = Math.min(getAvailableForRead(), i);
        this.channel.consumed(min);
        return min;
    }

    public ChunkBuffer request(int i) {
        ByteBuffer request = this.channel.request(0, i);
        if (request == null) {
            return null;
        }
        ChunkBuffer ChunkBuffer$default = BufferUtilsJvmKt.ChunkBuffer$default(request, (ObjectPool) null, 2, (Object) null);
        ChunkBuffer$default.resetForRead();
        completed(ChunkBuffer$default);
        return ChunkBuffer$default;
    }

    public Object await(int i, Continuation<? super Boolean> continuation) {
        completed();
        return this.channel.awaitAtLeast(i, continuation);
    }
}
