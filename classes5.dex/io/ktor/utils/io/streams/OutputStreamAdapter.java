package io.ktor.utils.io.streams;

import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J-\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Lio/ktor/utils/io/streams/OutputStreamAdapter;", "Lio/ktor/utils/io/core/Output;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "stream", "Ljava/io/OutputStream;", "(Lio/ktor/utils/io/pool/ObjectPool;Ljava/io/OutputStream;)V", "closeDestination", "", "flush", "source", "Lio/ktor/utils/io/bits/Memory;", "offset", "", "length", "flush-62zg_DM", "(Ljava/nio/ByteBuffer;II)V", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Output.kt */
final class OutputStreamAdapter extends Output {
    private final OutputStream stream;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OutputStreamAdapter(ObjectPool<ChunkBuffer> objectPool, OutputStream outputStream) {
        super(objectPool);
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        Intrinsics.checkNotNullParameter(outputStream, "stream");
        this.stream = outputStream;
    }

    /* access modifiers changed from: protected */
    /* renamed from: flush-62zg_DM  reason: not valid java name */
    public void m315flush62zg_DM(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly()) {
            byte[] borrow = ByteArraysKt.getByteArrayPool().borrow();
            ByteBuffer sliceSafe = MemoryJvmKt.sliceSafe(byteBuffer, i, i2);
            while (true) {
                try {
                    int min = Math.min(sliceSafe.remaining(), borrow.length);
                    if (min != 0) {
                        sliceSafe.get(borrow, 0, min);
                        this.stream.write(borrow, 0, min);
                    } else {
                        return;
                    }
                } finally {
                    ByteArraysKt.getByteArrayPool().recycle(borrow);
                }
            }
        } else {
            this.stream.write(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void closeDestination() {
        this.stream.close();
    }
}
