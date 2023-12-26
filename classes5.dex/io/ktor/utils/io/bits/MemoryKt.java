package io.ktor.utils.io.bits;

import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u000b\u001a\"\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a\"\u0010\f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0011\u001a*\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\rH\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a*\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\rH\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0018H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0015\u001a*\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0018H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"copyTo", "", "Lio/ktor/utils/io/bits/Memory;", "destination", "", "offset", "", "length", "copyTo-JT6ljtQ", "(Ljava/nio/ByteBuffer;[BII)V", "", "(Ljava/nio/ByteBuffer;[BJI)V", "get", "", "index", "get-eY85DW0", "(Ljava/nio/ByteBuffer;I)B", "(Ljava/nio/ByteBuffer;J)B", "set", "value", "set-62zg_DM", "(Ljava/nio/ByteBuffer;IB)V", "(Ljava/nio/ByteBuffer;JB)V", "storeAt", "Lkotlin/UByte;", "storeAt-OEmREl0", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Memory.kt */
public final class MemoryKt {
    /* renamed from: copyTo-JT6ljtQ  reason: not valid java name */
    public static final void m64copyToJT6ljtQ(ByteBuffer byteBuffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$copyTo");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        MemoryJvmKt.m59copyTo9zorpBc(byteBuffer, bArr, i, i2, 0);
    }

    /* renamed from: copyTo-JT6ljtQ  reason: not valid java name */
    public static final void m65copyToJT6ljtQ(ByteBuffer byteBuffer, byte[] bArr, long j, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$copyTo");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        MemoryJvmKt.m60copyTo9zorpBc(byteBuffer, bArr, j, i, 0);
    }

    /* renamed from: get-eY85DW0  reason: not valid java name */
    public static final byte m66geteY85DW0(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$get");
        return byteBuffer.get(i);
    }

    /* renamed from: get-eY85DW0  reason: not valid java name */
    public static final byte m67geteY85DW0(ByteBuffer byteBuffer, long j) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$get");
        if (j < 2147483647L) {
            return byteBuffer.get((int) j);
        }
        NumbersKt.failLongToIntConversion(j, "index");
        throw new KotlinNothingValueException();
    }

    /* renamed from: set-62zg_DM  reason: not valid java name */
    public static final void m69set62zg_DM(ByteBuffer byteBuffer, long j, byte b) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$set");
        if (j < 2147483647L) {
            byteBuffer.put((int) j, b);
        } else {
            NumbersKt.failLongToIntConversion(j, "index");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: set-62zg_DM  reason: not valid java name */
    public static final void m68set62zg_DM(ByteBuffer byteBuffer, int i, byte b) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$set");
        byteBuffer.put(i, b);
    }

    /* renamed from: storeAt-OEmREl0  reason: not valid java name */
    public static final void m71storeAtOEmREl0(ByteBuffer byteBuffer, long j, byte b) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeAt");
        if (j < 2147483647L) {
            byteBuffer.put((int) j, b);
        } else {
            NumbersKt.failLongToIntConversion(j, "index");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: storeAt-OEmREl0  reason: not valid java name */
    public static final void m70storeAtOEmREl0(ByteBuffer byteBuffer, int i, byte b) {
        Intrinsics.checkNotNullParameter(byteBuffer, "$this$storeAt");
        byteBuffer.put(i, b);
    }
}
