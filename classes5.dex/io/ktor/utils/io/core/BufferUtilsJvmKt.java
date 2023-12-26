package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.internal.jvm.ErrorsKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0007\u001a1\u0010\u000b\u001a\u00020\u0007*\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a$\u0010\u000b\u001a\u00020\u0007*\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rH\bø\u0001\u0000\u001a\u001a\u0010\u000f\u001a\u00020\u000e*\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007\u001a\u0014\u0010\u0010\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0003H\u0000\u001a;\u0010\u0012\u001a\u00020\u0007*\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a,\u0010\u0012\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0014"}, d2 = {"ChunkBuffer", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "buffer", "Ljava/nio/ByteBuffer;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "readAvailable", "", "Lio/ktor/utils/io/core/Buffer;", "dst", "length", "readDirect", "block", "Lkotlin/Function1;", "", "readFully", "resetFromContentToWrite", "child", "writeDirect", "size", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BufferUtilsJvm.kt */
public final class BufferUtilsJvmKt {
    public static /* synthetic */ ChunkBuffer ChunkBuffer$default(ByteBuffer byteBuffer, ObjectPool objectPool, int i, Object obj) {
        if ((i & 2) != 0) {
            objectPool = null;
        }
        return ChunkBuffer(byteBuffer, objectPool);
    }

    public static final ChunkBuffer ChunkBuffer(ByteBuffer byteBuffer, ObjectPool<ChunkBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        Memory.Companion companion = Memory.Companion;
        ByteBuffer order = byteBuffer.slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "buffer.slice().order(ByteOrder.BIG_ENDIAN)");
        return new ChunkBuffer(Memory.m40constructorimpl(order), (ChunkBuffer) null, objectPool, (DefaultConstructorMarker) null);
    }

    public static final int readDirect(ChunkBuffer chunkBuffer, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        int readPosition = chunkBuffer.getReadPosition();
        int writePosition = chunkBuffer.getWritePosition();
        ByteBuffer duplicate = chunkBuffer.m184getMemorySK3TCg8().duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.limit(writePosition);
        duplicate.position(readPosition);
        function1.invoke(duplicate);
        int position = duplicate.position() - readPosition;
        if (position < 0) {
            ErrorsKt.negativeShiftError(position);
            throw new KotlinNothingValueException();
        } else if (duplicate.limit() == writePosition) {
            chunkBuffer.discardExact(position);
            return position;
        } else {
            ErrorsKt.limitChangeError();
            throw new KotlinNothingValueException();
        }
    }

    public static final int writeDirect(ChunkBuffer chunkBuffer, int i, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Buffer buffer = chunkBuffer;
        int limit = buffer.getLimit() - buffer.getWritePosition();
        if (i <= limit) {
            ByteBuffer duplicate = chunkBuffer.m184getMemorySK3TCg8().duplicate();
            Intrinsics.checkNotNull(duplicate);
            int writePosition = chunkBuffer.getWritePosition();
            duplicate.limit(chunkBuffer.getLimit());
            duplicate.position(writePosition);
            function1.invoke(duplicate);
            int position = duplicate.position() - writePosition;
            if (position < 0 || position > limit) {
                ErrorsKt.wrongBufferPositionChangeError(position, i);
                throw new KotlinNothingValueException();
            }
            chunkBuffer.commitWritten(position);
            return position;
        }
        throw new IllegalArgumentException(("size " + i + " is greater than buffer's remaining capacity " + limit).toString());
    }

    public static final void resetFromContentToWrite(ChunkBuffer chunkBuffer, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "child");
        chunkBuffer.resetForWrite(byteBuffer.limit());
        chunkBuffer.commitWrittenUntilIndex(byteBuffer.position());
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, ByteBuffer byteBuffer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = byteBuffer.remaining();
        }
        return readAvailable(buffer, byteBuffer, i);
    }

    public static /* synthetic */ int writeDirect$default(Buffer buffer, int i, Function1 function1, int i2, Object obj) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        ByteBuffer r12 = Memory.m50slice87lwejk(r1, writePosition, limit);
        function1.invoke(r12);
        if (r12.limit() == limit) {
            int position = r12.position();
            buffer.commitWritten(position);
            return position;
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    /* JADX INFO: finally extract failed */
    public static final void readFully(Buffer buffer, ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "dst");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i) {
            int limit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i);
                MemoryJvmKt.m57copyTo62zg_DM(r0, byteBuffer, readPosition);
                byteBuffer.limit(limit);
                Unit unit = Unit.INSTANCE;
                buffer.discardExact(i);
            } catch (Throwable th) {
                byteBuffer.limit(limit);
                throw th;
            }
        } else {
            throw new EOFException("Not enough bytes to read a " + "buffer content" + " of size " + i + '.');
        }
    }

    public static final int readAvailable(Buffer buffer, ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "dst");
        if (!(buffer.getWritePosition() > buffer.getReadPosition())) {
            return -1;
        }
        int min = Math.min(buffer.getWritePosition() - buffer.getReadPosition(), i);
        readFully(buffer, byteBuffer, min);
        return min;
    }

    public static final int readDirect(Buffer buffer, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition() - readPosition;
        ByteBuffer r02 = Memory.m50slice87lwejk(r0, readPosition, writePosition);
        function1.invoke(r02);
        if (r02.limit() == writePosition) {
            int position = r02.position();
            buffer.discardExact(position);
            return position;
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }

    public static final int writeDirect(Buffer buffer, int i, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ByteBuffer r3 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        ByteBuffer r32 = Memory.m50slice87lwejk(r3, writePosition, limit);
        function1.invoke(r32);
        if (r32.limit() == limit) {
            int position = r32.position();
            buffer.commitWritten(position);
            return position;
        }
        throw new IllegalStateException("Buffer's limit change is not allowed".toString());
    }
}
