package io.ktor.util;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.internal.jvm.ErrorsKt;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"read", "", "Ljava/nio/channels/ReadableByteChannel;", "buffer", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "write", "Ljava/nio/channels/WritableByteChannel;", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BufferViewJvm.kt */
public final class BufferViewJvmKt {
    public static final int read(ReadableByteChannel readableByteChannel, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(readableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(chunkBuffer, "buffer");
        Buffer buffer = chunkBuffer;
        boolean z = false;
        if (buffer.getLimit() - buffer.getWritePosition() == 0) {
            return 0;
        }
        int limit = buffer.getLimit() - buffer.getWritePosition();
        if (1 <= limit) {
            z = true;
        }
        if (z) {
            ByteBuffer duplicate = chunkBuffer.m184getMemorySK3TCg8().duplicate();
            Intrinsics.checkNotNull(duplicate);
            int writePosition = chunkBuffer.getWritePosition();
            duplicate.limit(chunkBuffer.getLimit());
            duplicate.position(writePosition);
            int read = readableByteChannel.read(duplicate);
            int position = duplicate.position() - writePosition;
            if (position < 0 || position > limit) {
                ErrorsKt.wrongBufferPositionChangeError(position, 1);
                throw new KotlinNothingValueException();
            }
            chunkBuffer.commitWritten(position);
            return read;
        }
        throw new IllegalArgumentException(("size " + 1 + " is greater than buffer's remaining capacity " + limit).toString());
    }

    @InternalAPI
    public static final int write(WritableByteChannel writableByteChannel, ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(writableByteChannel, "<this>");
        Intrinsics.checkNotNullParameter(chunkBuffer, "buffer");
        int readPosition = chunkBuffer.getReadPosition();
        int writePosition = chunkBuffer.getWritePosition();
        ByteBuffer duplicate = chunkBuffer.m184getMemorySK3TCg8().duplicate();
        Intrinsics.checkNotNull(duplicate);
        duplicate.limit(writePosition);
        duplicate.position(readPosition);
        int write = writableByteChannel.write(duplicate);
        int position = duplicate.position() - readPosition;
        if (position < 0) {
            ErrorsKt.negativeShiftError(position);
            throw new KotlinNothingValueException();
        } else if (duplicate.limit() == writePosition) {
            chunkBuffer.discardExact(position);
            return write;
        } else {
            ErrorsKt.limitChangeError();
            throw new KotlinNothingValueException();
        }
    }
}
