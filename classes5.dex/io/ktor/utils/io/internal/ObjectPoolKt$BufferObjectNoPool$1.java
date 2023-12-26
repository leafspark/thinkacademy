package io.ktor.utils.io.internal;

import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.pool.NoPoolImpl;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"io/ktor/utils/io/internal/ObjectPoolKt$BufferObjectNoPool$1", "Lio/ktor/utils/io/pool/NoPoolImpl;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "borrow", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ObjectPool.kt */
public final class ObjectPoolKt$BufferObjectNoPool$1 extends NoPoolImpl<ReadWriteBufferState.Initial> {
    ObjectPoolKt$BufferObjectNoPool$1() {
    }

    public ReadWriteBufferState.Initial borrow() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(ObjectPoolKt.getBUFFER_SIZE());
        Intrinsics.checkNotNullExpressionValue(allocateDirect, "allocateDirect(BUFFER_SIZE)");
        return new ReadWriteBufferState.Initial(allocateDirect, 0, 2, (DefaultConstructorMarker) null);
    }
}
