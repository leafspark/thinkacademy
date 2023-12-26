package io.ktor.utils.io.core;

import com.tekartik.sqflite.Constant;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\u0015\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\b\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0007H\u0000\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0010\u001a\r\u0010\n\u001a\u00020\u0007*\u00020\u0007H\u0010\u001a1\u0010\u000b\u001a\u00020\f*\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000eH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0002\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0007H\u0010\u001a9\u0010\u0011\u001a\u00020\u0002*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u0001\u001a\u001c\u0010\u001d\u001a\u00020\f*\u0004\u0018\u00010\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001fH\u0000\u001a\f\u0010 \u001a\u00020\u0002*\u00020\u0007H\u0000\u001a\u0015\u0010 \u001a\u00020\u0002*\u00020\u00072\u0006\u0010!\u001a\u00020\u0002H\u0010\u0002\u0012\n\u0005\b20\u0001\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"coerceAtMostMaxInt", "", "", "coerceAtMostMaxIntOrFail", "message", "", "copyAll", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "head", "prev", "findTail", "forEachChunk", "", "block", "Lkotlin/Function1;", "isEmpty", "", "peekTo", "Lio/ktor/utils/io/core/Buffer;", "destination", "Lio/ktor/utils/io/bits/Memory;", "destinationOffset", "offset", "max", "peekTo-yRinSxo", "(Lio/ktor/utils/io/core/Buffer;Ljava/nio/ByteBuffer;JJJ)J", "readBytes", "", "count", "releaseAll", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "remainingAll", "n", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Buffers.kt */
public final class BuffersKt {
    public static final byte[] readBytes(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i == 0) {
            return UnsafeKt.EmptyByteArray;
        }
        byte[] bArr = new byte[i];
        BufferPrimitivesKt.readFully$default(buffer, bArr, 0, 0, 6, (Object) null);
        return bArr;
    }

    public static final void releaseAll(ChunkBuffer chunkBuffer, ObjectPool<ChunkBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        while (chunkBuffer != null) {
            ChunkBuffer cleanNext = chunkBuffer.cleanNext();
            chunkBuffer.release(objectPool);
            chunkBuffer = cleanNext;
        }
    }

    public static final void forEachChunk(ChunkBuffer chunkBuffer, Function1<? super ChunkBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        do {
            function1.invoke(chunkBuffer);
            chunkBuffer = chunkBuffer.getNext();
        } while (chunkBuffer != null);
    }

    public static final ChunkBuffer copyAll(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        ChunkBuffer duplicate = chunkBuffer.duplicate();
        ChunkBuffer next = chunkBuffer.getNext();
        if (next == null) {
            return duplicate;
        }
        return copyAll(next, duplicate, duplicate);
    }

    private static final ChunkBuffer copyAll(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, ChunkBuffer chunkBuffer3) {
        while (true) {
            ChunkBuffer duplicate = chunkBuffer.duplicate();
            chunkBuffer3.setNext(duplicate);
            chunkBuffer = chunkBuffer.getNext();
            if (chunkBuffer == null) {
                return chunkBuffer2;
            }
            chunkBuffer3 = duplicate;
        }
    }

    public static final ChunkBuffer findTail(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        while (true) {
            ChunkBuffer next = chunkBuffer.getNext();
            if (next == null) {
                return chunkBuffer;
            }
            chunkBuffer = next;
        }
    }

    public static final long remainingAll(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return remainingAll(chunkBuffer, 0);
    }

    private static final long remainingAll(ChunkBuffer chunkBuffer, long j) {
        do {
            Buffer buffer = chunkBuffer;
            j += (long) (buffer.getWritePosition() - buffer.getReadPosition());
            chunkBuffer = chunkBuffer.getNext();
        } while (chunkBuffer != null);
        return j;
    }

    public static final boolean isEmpty(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        do {
            Buffer buffer = chunkBuffer;
            if (buffer.getWritePosition() - buffer.getReadPosition() > 0) {
                return false;
            }
            chunkBuffer = chunkBuffer.getNext();
        } while (chunkBuffer != null);
        return true;
    }

    public static final int coerceAtMostMaxInt(long j) {
        return (int) Math.min(j, 2147483647L);
    }

    public static final int coerceAtMostMaxIntOrFail(long j, String str) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_MESSAGE);
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new IllegalArgumentException(str);
    }

    public static /* synthetic */ byte[] readBytes$default(Buffer buffer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = buffer.getWritePosition() - buffer.getReadPosition();
        }
        return readBytes(buffer, i);
    }

    /* renamed from: peekTo-yRinSxo  reason: not valid java name */
    public static final long m218peekToyRinSxo(Buffer buffer, ByteBuffer byteBuffer, long j, long j2, long j3) {
        Buffer buffer2 = buffer;
        Intrinsics.checkNotNullParameter(buffer, "$this$peekTo");
        Intrinsics.checkNotNullParameter(byteBuffer, "destination");
        long min = Math.min(((long) byteBuffer.limit()) - j, Math.min(j3, (long) (buffer.getWritePosition() - buffer.getReadPosition())));
        Memory.m42copyToJT6ljtQ(buffer.m184getMemorySK3TCg8(), byteBuffer, ((long) buffer.getReadPosition()) + j2, min, j);
        return min;
    }
}
