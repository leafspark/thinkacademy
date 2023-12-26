package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u001d\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0010\u001a\u0012\u0010\t\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007\u001a9\u0010\u000b\u001a\u00020\f*\u00020\u00052\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000fH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a9\u0010\u000b\u001a\u00020\f*\u00020\u00102\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000fH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007\u001a9\u0010\u0012\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000fH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a9\u0010\u0014\u001a\u00020\f*\u00020\u00132\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000fH\bø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0015"}, d2 = {"hasArray", "", "Lio/ktor/utils/io/core/Buffer;", "readAsMuchAsPossible", "", "Lio/ktor/utils/io/core/ByteReadPacket;", "bb", "Ljava/nio/ByteBuffer;", "copied", "readAvailable", "dst", "readDirect", "", "size", "block", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/Input;", "readFully", "writeByteBufferDirect", "Lio/ktor/utils/io/core/BytePacketBuilder;", "writeDirect", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteBuffers.kt */
public final class ByteBuffersKt {
    public static final int readAvailable(ByteReadPacket byteReadPacket, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "dst");
        return readAsMuchAsPossible(byteReadPacket, byteBuffer, 0);
    }

    public static final int readFully(ByteReadPacket byteReadPacket, ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(byteBuffer, "dst");
        int readAsMuchAsPossible = readAsMuchAsPossible(byteReadPacket, byteBuffer, 0);
        if (!byteBuffer.hasRemaining()) {
            return readAsMuchAsPossible;
        }
        throw new EOFException("Not enough data in packet to fill buffer: " + byteBuffer.remaining() + " more bytes required");
    }

    private static final int readAsMuchAsPossible(ByteReadPacket byteReadPacket, ByteBuffer byteBuffer, int i) {
        ChunkBuffer prepareRead;
        while (byteBuffer.hasRemaining() && (prepareRead = byteReadPacket.prepareRead(1)) != null) {
            int remaining = byteBuffer.remaining();
            Buffer buffer = prepareRead;
            int writePosition = buffer.getWritePosition() - buffer.getReadPosition();
            if (remaining >= writePosition) {
                BufferUtilsJvmKt.readFully(buffer, byteBuffer, writePosition);
                byteReadPacket.releaseHead$ktor_io(prepareRead);
                i += writePosition;
            } else {
                BufferUtilsJvmKt.readFully(buffer, byteBuffer, remaining);
                byteReadPacket.setHeadPosition(prepareRead.getReadPosition());
                return i + remaining;
            }
        }
        return i;
    }

    public static final int writeByteBufferDirect(BytePacketBuilder bytePacketBuilder, int i, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Output output = bytePacketBuilder;
        try {
            Buffer prepareWriteHead = output.prepareWriteHead(i);
            ByteBuffer r1 = prepareWriteHead.m184getMemorySK3TCg8();
            int writePosition = prepareWriteHead.getWritePosition();
            int limit = prepareWriteHead.getLimit() - writePosition;
            ByteBuffer r12 = Memory.m50slice87lwejk(r1, writePosition, limit);
            function1.invoke(r12);
            boolean z = false;
            if (r12.limit() == limit) {
                int position = r12.position();
                prepareWriteHead.commitWritten(position);
                if (position >= 0) {
                    z = true;
                }
                if (z) {
                    return position;
                }
                throw new IllegalStateException("The returned value shouldn't be negative".toString());
            }
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        } finally {
            InlineMarker.finallyStart(1);
            output.afterHeadWrite();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void readDirect(ByteReadPacket byteReadPacket, int i, Function1<? super ByteBuffer, Unit> function1) {
        int readPosition;
        int writePosition;
        Intrinsics.checkNotNullParameter(byteReadPacket, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Input input = byteReadPacket;
        ChunkBuffer prepareRead = input.prepareRead(i);
        if (prepareRead != null) {
            int readPosition2 = prepareRead.getReadPosition();
            try {
                Buffer buffer = prepareRead;
                ByteBuffer r4 = buffer.m184getMemorySK3TCg8();
                int readPosition3 = buffer.getReadPosition();
                int writePosition2 = buffer.getWritePosition() - readPosition3;
                ByteBuffer r42 = Memory.m50slice87lwejk(r4, readPosition3, writePosition2);
                function1.invoke(r42);
                if (r42.limit() == writePosition2) {
                    buffer.discardExact(r42.position());
                    if (readPosition >= readPosition2) {
                        if (readPosition != writePosition) {
                            input.setHeadPosition(readPosition);
                        }
                        return;
                    }
                    throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                }
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            } finally {
                InlineMarker.finallyStart(1);
                readPosition = prepareRead.getReadPosition();
                if (readPosition >= readPosition2) {
                    if (readPosition == prepareRead.getWritePosition()) {
                        input.ensureNext(prepareRead);
                    } else {
                        input.setHeadPosition(readPosition);
                    }
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
                IllegalStateException illegalStateException = new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
        } else {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
    }

    public static final boolean hasArray(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        return r1.hasArray() && !r1.isReadOnly();
    }

    public static final void writeDirect(BytePacketBuilder bytePacketBuilder, int i, Function1<? super ByteBuffer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bytePacketBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Output output = bytePacketBuilder;
        try {
            Buffer prepareWriteHead = output.prepareWriteHead(i);
            ByteBuffer r1 = prepareWriteHead.m184getMemorySK3TCg8();
            int writePosition = prepareWriteHead.getWritePosition();
            int limit = prepareWriteHead.getLimit() - writePosition;
            ByteBuffer r12 = Memory.m50slice87lwejk(r1, writePosition, limit);
            function1.invoke(r12);
            boolean z = false;
            if (r12.limit() == limit) {
                int position = r12.position();
                prepareWriteHead.commitWritten(position);
                if (position >= 0) {
                    z = true;
                }
                if (!z) {
                    throw new IllegalStateException("The returned value shouldn't be negative".toString());
                }
                return;
            }
            throw new IllegalStateException("Buffer's limit change is not allowed".toString());
        } finally {
            InlineMarker.finallyStart(1);
            output.afterHeadWrite();
            InlineMarker.finallyEnd(1);
        }
    }

    @Deprecated(message = "Use read {} instead.")
    public static final void readDirect(Input input, int i, Function1<? super ByteBuffer, Unit> function1) {
        int readPosition;
        int writePosition;
        Intrinsics.checkNotNullParameter(input, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ChunkBuffer prepareRead = input.prepareRead(i);
        if (prepareRead != null) {
            int readPosition2 = prepareRead.getReadPosition();
            try {
                Buffer buffer = prepareRead;
                ByteBuffer r4 = buffer.m184getMemorySK3TCg8();
                int readPosition3 = buffer.getReadPosition();
                int writePosition2 = buffer.getWritePosition() - readPosition3;
                ByteBuffer r42 = Memory.m50slice87lwejk(r4, readPosition3, writePosition2);
                function1.invoke(r42);
                if (r42.limit() == writePosition2) {
                    buffer.discardExact(r42.position());
                    if (readPosition >= readPosition2) {
                        if (readPosition != writePosition) {
                            input.setHeadPosition(readPosition);
                        }
                        return;
                    }
                    throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                }
                throw new IllegalStateException("Buffer's limit change is not allowed".toString());
            } finally {
                InlineMarker.finallyStart(1);
                readPosition = prepareRead.getReadPosition();
                if (readPosition >= readPosition2) {
                    if (readPosition == prepareRead.getWritePosition()) {
                        input.ensureNext(prepareRead);
                    } else {
                        input.setHeadPosition(readPosition);
                    }
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
                IllegalStateException illegalStateException = new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
        } else {
            StringsKt.prematureEndOfStream(i);
            throw new KotlinNothingValueException();
        }
    }
}
