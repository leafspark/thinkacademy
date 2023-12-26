package io.ktor.utils.io.bits;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0000\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0003H\b\u001a\r\u0010\u0000\u001a\u00020\u0004*\u00020\u0004H\b\u001a\r\u0010\u0000\u001a\u00020\u0005*\u00020\u0005H\b¨\u0006\u0006"}, d2 = {"reverseByteOrder", "", "", "", "", "", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteOrderJvm.kt */
public final class ByteOrderJVMKt {
    public static final short reverseByteOrder(short s) {
        return Short.reverseBytes(s);
    }

    public static final int reverseByteOrder(int i) {
        return Integer.reverseBytes(i);
    }

    public static final long reverseByteOrder(long j) {
        return Long.reverseBytes(j);
    }

    public static final float reverseByteOrder(float f) {
        return Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f)));
    }

    public static final double reverseByteOrder(double d) {
        return Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d)));
    }
}
