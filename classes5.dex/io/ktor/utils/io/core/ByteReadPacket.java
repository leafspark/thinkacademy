package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0004J\u0006\u0010\f\u001a\u00020\u0000J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0004J-\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/core/Input;", "head", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/pool/ObjectPool;)V", "remaining", "", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;JLio/ktor/utils/io/pool/ObjectPool;)V", "closeSource", "", "copy", "fill", "", "destination", "Lio/ktor/utils/io/bits/Memory;", "offset", "length", "fill-62zg_DM", "(Ljava/nio/ByteBuffer;II)I", "toString", "", "Companion", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteReadPacket.kt */
public final class ByteReadPacket extends Input {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ByteReadPacket Empty = new ByteReadPacket(ChunkBuffer.Companion.getEmpty(), 0, ChunkBuffer.Companion.getEmptyPool());

    /* access modifiers changed from: protected */
    public final void closeSource() {
    }

    /* access modifiers changed from: protected */
    public final ChunkBuffer fill() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: fill-62zg_DM  reason: not valid java name */
    public final int m220fill62zg_DM(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "destination");
        return 0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ByteReadPacket(ChunkBuffer chunkBuffer, long j, ObjectPool<ChunkBuffer> objectPool) {
        super(chunkBuffer, j, objectPool);
        Intrinsics.checkNotNullParameter(chunkBuffer, "head");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        markNoMoreChunksAvailable();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ByteReadPacket(ChunkBuffer chunkBuffer, ObjectPool<ChunkBuffer> objectPool) {
        this(chunkBuffer, BuffersKt.remainingAll(chunkBuffer), objectPool);
        Intrinsics.checkNotNullParameter(chunkBuffer, "head");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
    }

    public final ByteReadPacket copy() {
        return new ByteReadPacket(BuffersKt.copyAll(getHead()), getRemaining(), getPool());
    }

    public String toString() {
        return "ByteReadPacket(" + getRemaining() + " bytes remaining)";
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/core/ByteReadPacket$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/core/ByteReadPacket;", "getEmpty", "()Lio/ktor/utils/io/core/ByteReadPacket;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ByteReadPacket.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ByteReadPacket getEmpty() {
            return ByteReadPacket.Empty;
        }
    }
}
