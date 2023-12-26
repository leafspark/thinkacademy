package io.ktor.utils.io.bits;

import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\b\u001a\"\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\r\u001a\"\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a\"\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0001H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a*\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0001H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018\u001a*\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\nH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a*\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\nH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001c\u001a*\u0010\u001d\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a*\u0010\u001d\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u000fH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010 \u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"loadUIntAt", "Lkotlin/UInt;", "Lio/ktor/utils/io/bits/Memory;", "offset", "", "loadUIntAt-eY85DW0", "(Ljava/nio/ByteBuffer;I)I", "", "(Ljava/nio/ByteBuffer;J)I", "loadULongAt", "Lkotlin/ULong;", "loadULongAt-eY85DW0", "(Ljava/nio/ByteBuffer;I)J", "(Ljava/nio/ByteBuffer;J)J", "loadUShortAt", "Lkotlin/UShort;", "loadUShortAt-eY85DW0", "(Ljava/nio/ByteBuffer;I)S", "(Ljava/nio/ByteBuffer;J)S", "storeUIntAt", "", "value", "storeUIntAt-c9EmHqw", "(Ljava/nio/ByteBuffer;II)V", "(Ljava/nio/ByteBuffer;JI)V", "storeULongAt", "storeULongAt-zwzI6Wg", "(Ljava/nio/ByteBuffer;IJ)V", "(Ljava/nio/ByteBuffer;JJ)V", "storeUShortAt", "storeUShortAt-4ET0KQI", "(Ljava/nio/ByteBuffer;IS)V", "(Ljava/nio/ByteBuffer;JS)V", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MemoryPrimitives.kt */
public final class MemoryPrimitivesKt {
    /* renamed from: loadUShortAt-eY85DW0  reason: not valid java name */
    public static final short m96loadUShortAteY85DW0(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUShortAt");
        return UShort.m598constructorimpl(byteBuffer.getShort(i));
    }

    /* renamed from: loadUShortAt-eY85DW0  reason: not valid java name */
    public static final short m97loadUShortAteY85DW0(ByteBuffer byteBuffer, long j) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUShortAt");
        if (j < 2147483647L) {
            return UShort.m598constructorimpl(byteBuffer.getShort((int) j));
        }
        NumbersKt.failLongToIntConversion(j, "offset");
        throw new KotlinNothingValueException();
    }

    /* renamed from: storeUShortAt-4ET0KQI  reason: not valid java name */
    public static final void m102storeUShortAt4ET0KQI(ByteBuffer byteBuffer, int i, short s) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUShortAt");
        byteBuffer.putShort(i, s);
    }

    /* renamed from: storeUShortAt-4ET0KQI  reason: not valid java name */
    public static final void m103storeUShortAt4ET0KQI(ByteBuffer byteBuffer, long j, short s) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUShortAt");
        if (j < 2147483647L) {
            byteBuffer.putShort((int) j, s);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadUIntAt-eY85DW0  reason: not valid java name */
    public static final int m92loadUIntAteY85DW0(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUIntAt");
        return UInt.m414constructorimpl(byteBuffer.getInt(i));
    }

    /* renamed from: loadUIntAt-eY85DW0  reason: not valid java name */
    public static final int m93loadUIntAteY85DW0(ByteBuffer byteBuffer, long j) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadUIntAt");
        if (j < 2147483647L) {
            return UInt.m414constructorimpl(byteBuffer.getInt((int) j));
        }
        NumbersKt.failLongToIntConversion(j, "offset");
        throw new KotlinNothingValueException();
    }

    /* renamed from: storeUIntAt-c9EmHqw  reason: not valid java name */
    public static final void m98storeUIntAtc9EmHqw(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUIntAt");
        byteBuffer.putInt(i, i2);
    }

    /* renamed from: storeUIntAt-c9EmHqw  reason: not valid java name */
    public static final void m99storeUIntAtc9EmHqw(ByteBuffer byteBuffer, long j, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeUIntAt");
        if (j < 2147483647L) {
            byteBuffer.putInt((int) j, i);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadULongAt-eY85DW0  reason: not valid java name */
    public static final long m94loadULongAteY85DW0(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadULongAt");
        return ULong.m492constructorimpl(byteBuffer.getLong(i));
    }

    /* renamed from: loadULongAt-eY85DW0  reason: not valid java name */
    public static final long m95loadULongAteY85DW0(ByteBuffer byteBuffer, long j) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$loadULongAt");
        if (j < 2147483647L) {
            return ULong.m492constructorimpl(byteBuffer.getLong((int) j));
        }
        NumbersKt.failLongToIntConversion(j, "offset");
        throw new KotlinNothingValueException();
    }

    /* renamed from: storeULongAt-zwzI6Wg  reason: not valid java name */
    public static final void m100storeULongAtzwzI6Wg(ByteBuffer byteBuffer, int i, long j) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeULongAt");
        byteBuffer.putLong(i, j);
    }

    /* renamed from: storeULongAt-zwzI6Wg  reason: not valid java name */
    public static final void m101storeULongAtzwzI6Wg(ByteBuffer byteBuffer, long j, long j2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeULongAt");
        if (j < 2147483647L) {
            byteBuffer.putLong((int) j, j2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }
}
