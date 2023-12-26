package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Allocator;
import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.DefaultPool;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u0002H\u0014J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/ktor/utils/io/core/DefaultBufferPool;", "Lio/ktor/utils/io/pool/DefaultPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "bufferSize", "", "capacity", "allocator", "Lio/ktor/utils/io/bits/Allocator;", "(IILio/ktor/utils/io/bits/Allocator;)V", "clearInstance", "instance", "disposeInstance", "", "produceInstance", "validateInstance", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BufferFactory.kt */
public final class DefaultBufferPool extends DefaultPool<ChunkBuffer> {
    private final Allocator allocator;
    private final int bufferSize;

    public DefaultBufferPool() {
        this(0, 0, (Allocator) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultBufferPool(int i, int i2, Allocator allocator2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 4096 : i, (i3 & 2) != 0 ? 1000 : i2, (i3 & 4) != 0 ? DefaultAllocator.INSTANCE : allocator2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultBufferPool(int i, int i2, Allocator allocator2) {
        super(i2);
        Intrinsics.checkNotNullParameter(allocator2, "allocator");
        this.bufferSize = i;
        this.allocator = allocator2;
    }

    /* access modifiers changed from: protected */
    public ChunkBuffer produceInstance() {
        return new ChunkBuffer(this.allocator.m30allocgFvZug(this.bufferSize), (ChunkBuffer) null, this, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: protected */
    public void disposeInstance(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "instance");
        this.allocator.m32free3GNKZMM(chunkBuffer.m184getMemorySK3TCg8());
        super.disposeInstance(chunkBuffer);
        chunkBuffer.unlink$ktor_io();
    }

    /* access modifiers changed from: protected */
    public void validateInstance(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "instance");
        super.validateInstance(chunkBuffer);
        boolean z = true;
        if (((long) chunkBuffer.m184getMemorySK3TCg8().limit()) == ((long) this.bufferSize)) {
            if (chunkBuffer != ChunkBuffer.Companion.getEmpty()) {
                if (chunkBuffer != Buffer.Companion.getEmpty()) {
                    if (chunkBuffer.getReferenceCount() == 0) {
                        if (chunkBuffer.getNext() == null) {
                            if (chunkBuffer.getOrigin() != null) {
                                z = false;
                            }
                            if (!z) {
                                throw new IllegalStateException("Recycled instance shouldn't be a view or another buffer.".toString());
                            }
                            return;
                        }
                        throw new IllegalStateException("Recycled instance shouldn't be a part of a chain.".toString());
                    }
                    throw new IllegalStateException("Unable to clear buffer: it is still in use.".toString());
                }
                throw new IllegalStateException("Empty instance couldn't be recycled".toString());
            }
            throw new IllegalStateException("ChunkBuffer.Empty couldn't be recycled".toString());
        }
        throw new IllegalStateException(("Buffer size mismatch. Expected: " + this.bufferSize + ", actual: " + ((long) chunkBuffer.m184getMemorySK3TCg8().limit())).toString());
    }

    /* access modifiers changed from: protected */
    public ChunkBuffer clearInstance(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "instance");
        ChunkBuffer chunkBuffer2 = (ChunkBuffer) super.clearInstance(chunkBuffer);
        chunkBuffer2.unpark$ktor_io();
        chunkBuffer2.reset();
        return chunkBuffer2;
    }
}
