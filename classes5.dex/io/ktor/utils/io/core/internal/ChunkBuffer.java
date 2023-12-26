package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\b\u0016\u0018\u0000 +2\u00020-:\u0001+B,\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0004ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0017J\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u001a\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001c\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001b\u0010\nR(\u0010 \u001a\u0004\u0018\u00010\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u00008F@FX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u000eR(\u0010\u0003\u001a\u0004\u0018\u00010\u00002\b\u0010!\u001a\u0004\u0018\u00010\u00008\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0010R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&R\u0011\u0010*\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lio/ktor/utils/io/core/internal/ChunkBuffer;", "Lio/ktor/utils/io/bits/Memory;", "memory", "origin", "Lio/ktor/utils/io/pool/ObjectPool;", "parentPool", "<init>", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/core/internal/ChunkBuffer;Lio/ktor/utils/io/pool/ObjectPool;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "acquire$ktor_io", "()V", "acquire", "chunk", "appendNext", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)V", "cleanNext", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "duplicate", "", "release$ktor_io", "()Z", "release", "pool", "(Lio/ktor/utils/io/pool/ObjectPool;)V", "reset", "unlink$ktor_io", "unlink", "unpark$ktor_io", "unpark", "newValue", "getNext", "setNext", "next", "<set-?>", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "getOrigin", "Lio/ktor/utils/io/pool/ObjectPool;", "getParentPool$ktor_io", "()Lio/ktor/utils/io/pool/ObjectPool;", "", "getReferenceCount", "()I", "referenceCount", "Companion", "ktor-io", "Lio/ktor/utils/io/core/Buffer;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChunkBuffer.kt */
public class ChunkBuffer extends Buffer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ChunkBuffer Empty;
    /* access modifiers changed from: private */
    public static final ObjectPool<ChunkBuffer> EmptyPool;
    /* access modifiers changed from: private */
    public static final ObjectPool<ChunkBuffer> NoPool = new ChunkBuffer$Companion$NoPool$1();
    /* access modifiers changed from: private */
    public static final ObjectPool<ChunkBuffer> NoPoolManuallyManaged = new ChunkBuffer$Companion$NoPoolManuallyManaged$1();
    /* access modifiers changed from: private */
    public static final ObjectPool<ChunkBuffer> Pool = new ChunkBuffer$Companion$Pool$1();
    private static final /* synthetic */ AtomicReferenceFieldUpdater nextRef$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater refCount$FU;
    private volatile /* synthetic */ Object nextRef;
    private ChunkBuffer origin;
    private final ObjectPool<ChunkBuffer> parentPool;
    private volatile /* synthetic */ int refCount;

    public /* synthetic */ ChunkBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool objectPool, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer, chunkBuffer, objectPool);
    }

    public final ObjectPool<ChunkBuffer> getParentPool$ktor_io() {
        return this.parentPool;
    }

    private ChunkBuffer(ByteBuffer byteBuffer, ChunkBuffer chunkBuffer, ObjectPool<ChunkBuffer> objectPool) {
        super(byteBuffer, (DefaultConstructorMarker) null);
        this.parentPool = objectPool;
        if (chunkBuffer != this) {
            this.nextRef = null;
            this.refCount = 1;
            this.origin = chunkBuffer;
            return;
        }
        throw new IllegalArgumentException("A chunk couldn't be a view of itself.".toString());
    }

    public final ChunkBuffer getOrigin() {
        return this.origin;
    }

    public final ChunkBuffer getNext() {
        return (ChunkBuffer) this.nextRef;
    }

    public final void setNext(ChunkBuffer chunkBuffer) {
        if (chunkBuffer == null) {
            cleanNext();
        } else {
            appendNext(chunkBuffer);
        }
    }

    public final int getReferenceCount() {
        return this.refCount;
    }

    private final void appendNext(ChunkBuffer chunkBuffer) {
        if (!nextRef$FU.compareAndSet(this, (Object) null, chunkBuffer)) {
            throw new IllegalStateException("This chunk has already a next chunk.");
        }
    }

    public final ChunkBuffer cleanNext() {
        return (ChunkBuffer) nextRef$FU.getAndSet(this, (Object) null);
    }

    public ChunkBuffer duplicate() {
        ChunkBuffer chunkBuffer = this.origin;
        if (chunkBuffer == null) {
            chunkBuffer = this;
        }
        ChunkBuffer chunkBuffer2 = chunkBuffer;
        chunkBuffer2.acquire$ktor_io();
        ChunkBuffer chunkBuffer3 = new ChunkBuffer(m184getMemorySK3TCg8(), chunkBuffer2, this.parentPool, (DefaultConstructorMarker) null);
        duplicateTo(chunkBuffer3);
        return chunkBuffer3;
    }

    public void release(ObjectPool<ChunkBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        if (release$ktor_io()) {
            ChunkBuffer chunkBuffer = this.origin;
            if (chunkBuffer != null) {
                unlink$ktor_io();
                chunkBuffer.release(objectPool);
                return;
            }
            ObjectPool<ChunkBuffer> objectPool2 = this.parentPool;
            if (objectPool2 != null) {
                objectPool = objectPool2;
            }
            objectPool.recycle(this);
        }
    }

    public final void unlink$ktor_io() {
        if (refCount$FU.compareAndSet(this, 0, -1)) {
            cleanNext();
            this.origin = null;
            return;
        }
        throw new IllegalStateException("Unable to unlink: buffer is in use.");
    }

    public final void reset() {
        if (this.origin == null) {
            super.reset();
            this.nextRef = null;
            return;
        }
        throw new IllegalArgumentException("Unable to reset buffer with origin".toString());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/core/internal/ChunkBuffer$Companion;", "", "()V", "Empty", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "getEmpty", "()Lio/ktor/utils/io/core/internal/ChunkBuffer;", "EmptyPool", "Lio/ktor/utils/io/pool/ObjectPool;", "getEmptyPool", "()Lio/ktor/utils/io/pool/ObjectPool;", "NoPool", "getNoPool$ktor_io", "NoPoolManuallyManaged", "getNoPoolManuallyManaged$ktor_io", "Pool", "getPool", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChunkBuffer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ObjectPool<ChunkBuffer> getPool() {
            return ChunkBuffer.Pool;
        }

        public final ObjectPool<ChunkBuffer> getEmptyPool() {
            return ChunkBuffer.EmptyPool;
        }

        public final ChunkBuffer getEmpty() {
            return ChunkBuffer.Empty;
        }

        public final ObjectPool<ChunkBuffer> getNoPool$ktor_io() {
            return ChunkBuffer.NoPool;
        }

        public final ObjectPool<ChunkBuffer> getNoPoolManuallyManaged$ktor_io() {
            return ChunkBuffer.NoPoolManuallyManaged;
        }
    }

    static {
        Class<ChunkBuffer> cls = ChunkBuffer.class;
        ObjectPool<ChunkBuffer> chunkBuffer$Companion$EmptyPool$1 = new ChunkBuffer$Companion$EmptyPool$1();
        EmptyPool = chunkBuffer$Companion$EmptyPool$1;
        Empty = new ChunkBuffer(Memory.Companion.m56getEmptySK3TCg8(), (ChunkBuffer) null, chunkBuffer$Companion$EmptyPool$1, (DefaultConstructorMarker) null);
        nextRef$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "nextRef");
        refCount$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "refCount");
    }

    public final void acquire$ktor_io() {
        int i;
        do {
            i = this.refCount;
            if (i > 0) {
            } else {
                throw new IllegalStateException("Unable to acquire chunk: it is already released.");
            }
        } while (!refCount$FU.compareAndSet(this, i, i + 1));
    }

    public final void unpark$ktor_io() {
        int i;
        do {
            i = this.refCount;
            if (i < 0) {
                throw new IllegalStateException("This instance is already disposed and couldn't be borrowed.");
            } else if (i > 0) {
                throw new IllegalStateException("This instance is already in use but somehow appeared in the pool.");
            }
        } while (!refCount$FU.compareAndSet(this, i, 1));
    }

    public final boolean release$ktor_io() {
        int i;
        int i2;
        do {
            i = this.refCount;
            if (i > 0) {
                i2 = i - 1;
            } else {
                throw new IllegalStateException("Unable to release: it is already released.");
            }
        } while (!refCount$FU.compareAndSet(this, i, i2));
        return i2 == 0;
    }
}
