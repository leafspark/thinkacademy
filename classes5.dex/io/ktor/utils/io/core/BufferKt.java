package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\r\u0010\t\u001a\u00020\n*\u00020\u000bH\b\u001a\r\u0010\f\u001a\u00020\n*\u00020\u000bH\b\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0011\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001am\u0010\u0012\u001a\u00020\u0003*\u00020\u000b2K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00030\u0014H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0014\u0010\u001b\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u001d\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u001f\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0003H\u0000\u001am\u0010 \u001a\u00020\u0003*\u00020\u000b2K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00030\u0014H\bø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006!"}, d2 = {"commitWrittenFailed", "", "count", "", "writeRemaining", "discardFailed", "readRemaining", "rewindFailed", "rewindRemaining", "canRead", "", "Lio/ktor/utils/io/core/Buffer;", "canWrite", "endGapReservationFailedDueToCapacity", "", "endGap", "endGapReservationFailedDueToContent", "endGapReservationFailedDueToStartGap", "read", "block", "Lkotlin/Function3;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "name", "memory", "start", "endExclusive", "restoreStartGap", "size", "startGapReservationFailed", "startGap", "startGapReservationFailedDueToLimit", "write", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Buffer.kt */
public final class BufferKt {
    public static final boolean canRead(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.getWritePosition() > buffer.getReadPosition();
    }

    public static final boolean canWrite(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return buffer.getLimit() > buffer.getWritePosition();
    }

    public static final int read(Buffer buffer, Function3<? super Memory, ? super Integer, ? super Integer, Integer> function3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function3, "block");
        int intValue = ((Number) function3.invoke(Memory.m39boximpl(buffer.m184getMemorySK3TCg8()), Integer.valueOf(buffer.getReadPosition()), Integer.valueOf(buffer.getWritePosition()))).intValue();
        buffer.discardExact(intValue);
        return intValue;
    }

    public static final int write(Buffer buffer, Function3<? super Memory, ? super Integer, ? super Integer, Integer> function3) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function3, "block");
        int intValue = ((Number) function3.invoke(Memory.m39boximpl(buffer.m184getMemorySK3TCg8()), Integer.valueOf(buffer.getWritePosition()), Integer.valueOf(buffer.getLimit()))).intValue();
        buffer.commitWritten(intValue);
        return intValue;
    }

    public static final Void discardFailed(int i, int i2) {
        throw new EOFException("Unable to discard " + i + " bytes: only " + i2 + " available for reading");
    }

    public static final Void commitWrittenFailed(int i, int i2) {
        throw new EOFException("Unable to discard " + i + " bytes: only " + i2 + " available for writing");
    }

    public static final Void rewindFailed(int i, int i2) {
        throw new IllegalArgumentException("Unable to rewind " + i + " bytes: only " + i2 + " could be rewinded");
    }

    public static final Void startGapReservationFailedDueToLimit(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (i > buffer.getCapacity()) {
            throw new IllegalArgumentException("Start gap " + i + " is bigger than the capacity " + buffer.getCapacity());
        }
        throw new IllegalStateException("Unable to reserve " + i + " start gap: there are already " + (buffer.getCapacity() - buffer.getLimit()) + " bytes reserved in the end");
    }

    public static final Void startGapReservationFailed(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        throw new IllegalStateException("Unable to reserve " + i + " start gap: there are already " + (buffer.getWritePosition() - buffer.getReadPosition()) + " content bytes starting at offset " + buffer.getReadPosition());
    }

    public static final void endGapReservationFailedDueToCapacity(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        throw new IllegalArgumentException("End gap " + i + " is too big: capacity is " + buffer.getCapacity());
    }

    public static final void endGapReservationFailedDueToStartGap(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        throw new IllegalArgumentException("End gap " + i + " is too big: there are already " + buffer.getStartGap() + " bytes reserved in the beginning");
    }

    public static final void endGapReservationFailedDueToContent(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        throw new IllegalArgumentException("Unable to reserve end gap " + i + ": there are already " + (buffer.getWritePosition() - buffer.getReadPosition()) + " content bytes at offset " + buffer.getReadPosition());
    }

    public static final void restoreStartGap(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        buffer.releaseStartGap$ktor_io(buffer.getReadPosition() - i);
    }
}
