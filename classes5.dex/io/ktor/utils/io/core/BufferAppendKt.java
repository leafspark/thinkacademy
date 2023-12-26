package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¨\u0006\t"}, d2 = {"writeBufferAppend", "", "Lio/ktor/utils/io/core/Buffer;", "other", "maxSize", "writeBufferAppendUnreserve", "", "writeSize", "writeBufferPrepend", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BufferAppend.kt */
public final class BufferAppendKt {
    public static final int writeBufferAppend(Buffer buffer, Buffer buffer2, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "other");
        int min = Math.min(buffer2.getWritePosition() - buffer2.getReadPosition(), i);
        if (buffer.getLimit() - buffer.getWritePosition() <= min) {
            writeBufferAppendUnreserve(buffer, min);
        }
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        buffer.getLimit();
        ByteBuffer r2 = buffer2.m184getMemorySK3TCg8();
        int readPosition = buffer2.getReadPosition();
        buffer2.getWritePosition();
        Memory.m41copyToJT6ljtQ(r2, r0, readPosition, min, writePosition);
        buffer2.discardExact(min);
        buffer.commitWritten(min);
        return min;
    }

    public static final int writeBufferPrepend(Buffer buffer, Buffer buffer2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "other");
        int writePosition = buffer2.getWritePosition() - buffer2.getReadPosition();
        int readPosition = buffer.getReadPosition();
        if (readPosition >= writePosition) {
            int i = readPosition - writePosition;
            Memory.m41copyToJT6ljtQ(buffer2.m184getMemorySK3TCg8(), buffer.m184getMemorySK3TCg8(), buffer2.getReadPosition(), writePosition, i);
            buffer2.discardExact(writePosition);
            buffer.releaseStartGap$ktor_io(i);
            return writePosition;
        }
        throw new IllegalArgumentException("Not enough space in the beginning to prepend bytes");
    }

    private static final void writeBufferAppendUnreserve(Buffer buffer, int i) {
        if ((buffer.getLimit() - buffer.getWritePosition()) + (buffer.getCapacity() - buffer.getLimit()) < i) {
            throw new IllegalArgumentException("Can't append buffer: not enough free space at the end");
        } else if ((buffer.getWritePosition() + i) - buffer.getLimit() > 0) {
            buffer.releaseEndGap$ktor_io();
        }
    }
}
