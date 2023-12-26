package io.ktor.utils.io.bits;

import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\n\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u0010\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\b\u001a/\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a/\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u0004*\u00020\u0004H\b\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0004H\b\u001a\u001c\u0010\u001b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0000\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0004H\b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"copyTo", "", "Lio/ktor/utils/io/bits/Memory;", "destination", "Ljava/nio/ByteBuffer;", "offset", "", "copyTo-62zg_DM", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;I)V", "", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;J)V", "", "length", "destinationOffset", "copyTo-9zorpBc", "(Ljava/nio/ByteBuffer;[BIII)V", "(Ljava/nio/ByteBuffer;[BJII)V", "copyTo-SG11BkQ", "fill", "count", "value", "", "fill-JT6ljtQ", "(Ljava/nio/ByteBuffer;IIB)V", "(Ljava/nio/ByteBuffer;JJB)V", "myDuplicate", "mySlice", "sliceSafe", "suppressNullCheck", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MemoryJvm.kt */
public final class MemoryJvmKt {
    private static final ByteBuffer suppressNullCheck(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    /* renamed from: copyTo-9zorpBc  reason: not valid java name */
    public static final void m59copyTo9zorpBc(ByteBuffer byteBuffer, byte[] bArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$copyTo");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly()) {
            byteBuffer.duplicate().get(bArr, i3, i2);
        } else {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i, bArr, i3, i2);
        }
    }

    /* renamed from: copyTo-9zorpBc  reason: not valid java name */
    public static final void m60copyTo9zorpBc(ByteBuffer byteBuffer, byte[] bArr, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$copyTo");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        if (j < 2147483647L) {
            m59copyTo9zorpBc(byteBuffer, bArr, (int) j, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: copyTo-62zg_DM  reason: not valid java name */
    public static final void m57copyTo62zg_DM(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$copyTo");
        Intrinsics.checkNotNullParameter(byteBuffer2, "destination");
        int remaining = byteBuffer2.remaining();
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly() || !byteBuffer2.hasArray() || byteBuffer2.isReadOnly()) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.limit(remaining + i);
            duplicate.position(i);
            byteBuffer2.put(duplicate);
            return;
        }
        int position = byteBuffer2.position();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i, byteBuffer2.array(), byteBuffer2.arrayOffset() + position, remaining);
        byteBuffer2.position(position + remaining);
    }

    /* renamed from: copyTo-62zg_DM  reason: not valid java name */
    public static final void m58copyTo62zg_DM(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, long j) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$copyTo");
        Intrinsics.checkNotNullParameter(byteBuffer2, "destination");
        if (j < 2147483647L) {
            m57copyTo62zg_DM(byteBuffer, byteBuffer2, (int) j);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: copyTo-SG11BkQ  reason: not valid java name */
    public static final void m61copyToSG11BkQ(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$copyTo");
        Intrinsics.checkNotNullParameter(byteBuffer2, "destination");
        if (!byteBuffer.hasArray() || byteBuffer.isReadOnly()) {
            sliceSafe(byteBuffer2, i, byteBuffer.remaining()).put(byteBuffer);
            return;
        }
        byte[] array = byteBuffer.array();
        Intrinsics.checkNotNullExpressionValue(array, "array()");
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int remaining = byteBuffer.remaining();
        ByteBuffer order = ByteBuffer.wrap(array, arrayOffset, remaining).slice().order(ByteOrder.BIG_ENDIAN);
        Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
        Memory.m41copyToJT6ljtQ(Memory.m40constructorimpl(order), byteBuffer2, 0, remaining, i);
        byteBuffer.position(byteBuffer.limit());
    }

    private static final ByteBuffer myDuplicate(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNullExpressionValue(duplicate, "");
        return duplicate;
    }

    private static final ByteBuffer mySlice(ByteBuffer byteBuffer) {
        ByteBuffer slice = byteBuffer.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "");
        return slice;
    }

    /* renamed from: fill-JT6ljtQ  reason: not valid java name */
    public static final void m63fillJT6ljtQ(ByteBuffer byteBuffer, long j, long j2, byte b) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$fill");
        if (j < 2147483647L) {
            int i = (int) j;
            if (j2 < 2147483647L) {
                m62fillJT6ljtQ(byteBuffer, i, (int) j2, b);
            } else {
                NumbersKt.failLongToIntConversion(j2, "count");
                throw new KotlinNothingValueException();
            }
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: fill-JT6ljtQ  reason: not valid java name */
    public static final void m62fillJT6ljtQ(ByteBuffer byteBuffer, int i, int i2, byte b) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$fill");
        int i3 = i2 + i;
        while (i < i3) {
            byteBuffer.put(i, b);
            i++;
        }
    }

    public static final ByteBuffer sliceSafe(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        ByteBuffer duplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNullExpressionValue(duplicate, "");
        duplicate.position(i);
        duplicate.limit(i + i2);
        ByteBuffer slice = duplicate.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "");
        return slice;
    }
}
