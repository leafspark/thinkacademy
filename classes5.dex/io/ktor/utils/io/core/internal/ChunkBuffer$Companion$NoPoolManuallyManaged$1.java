package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.pool.NoPoolImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"io/ktor/utils/io/core/internal/ChunkBuffer$Companion$NoPoolManuallyManaged$1", "Lio/ktor/utils/io/pool/NoPoolImpl;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "borrow", "recycle", "", "instance", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChunkBuffer.kt */
public final class ChunkBuffer$Companion$NoPoolManuallyManaged$1 extends NoPoolImpl<ChunkBuffer> {
    public void recycle(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "instance");
    }

    ChunkBuffer$Companion$NoPoolManuallyManaged$1() {
    }

    public ChunkBuffer borrow() {
        throw new UnsupportedOperationException("This pool doesn't support borrow");
    }
}
