package io.ktor.utils.io.internal;

import io.ktor.utils.io.charsets.UTFKt;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000\u001a$\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a9\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\b\u001a$\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a9\u0010\r\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\b\u001a(\u0010\u000e\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000\u001a$\u0010\u000f\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a$\u0010\u0010\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¨\u0006\u0011"}, d2 = {"decodeASCII", "", "Ljava/nio/ByteBuffer;", "out", "", "offset", "length", "decodeASCII3_array", "", "predicate", "Lkotlin/Function1;", "", "", "decodeASCII3_buffer", "decodeASCIILine", "decodeASCIILine_array", "decodeASCIILine_buffer", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Strings.kt */
public final class StringsKt {
    public static /* synthetic */ int decodeASCII$default(ByteBuffer byteBuffer, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return decodeASCII(byteBuffer, cArr, i, i2);
    }

    public static final int decodeASCII(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "out");
        if (byteBuffer.hasArray()) {
            return decodeASCII3_array(byteBuffer, cArr, i, i2);
        }
        return decodeASCII3_buffer(byteBuffer, cArr, i, i2);
    }

    public static /* synthetic */ long decodeASCIILine$default(ByteBuffer byteBuffer, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return decodeASCIILine(byteBuffer, cArr, i, i2);
    }

    public static final long decodeASCIILine(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "out");
        if (byteBuffer.hasArray()) {
            return decodeASCIILine_array(byteBuffer, cArr, i, i2);
        }
        return decodeASCIILine_buffer(byteBuffer, cArr, i, i2);
    }

    private static final int decodeASCII3_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        int i3;
        int i4 = i2 + i;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int remaining = byteBuffer.remaining() + arrayOffset;
        if (i4 > cArr.length || remaining > array.length) {
            i3 = i;
        } else {
            i3 = i;
            while (arrayOffset < remaining && i3 < i4) {
                byte b = array[arrayOffset];
                if (b < 0) {
                    break;
                }
                cArr[i3] = (char) b;
                i3++;
                arrayOffset++;
            }
            byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
        }
        return i3 - i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r2 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int decodeASCII3_buffer(java.nio.ByteBuffer r4, char[] r5, int r6, int r7) {
        /*
            int r7 = r7 + r6
            int r0 = r5.length
            r1 = 1
            r2 = 0
            if (r7 > r0) goto L_0x001e
            r0 = r6
        L_0x0007:
            boolean r3 = r4.hasRemaining()
            if (r3 == 0) goto L_0x001f
            byte r3 = r4.get()
            if (r3 >= 0) goto L_0x0015
        L_0x0013:
            r2 = r1
            goto L_0x001f
        L_0x0015:
            if (r0 < r7) goto L_0x0018
            goto L_0x0013
        L_0x0018:
            char r3 = (char) r3
            r5[r0] = r3
            int r0 = r0 + 1
            goto L_0x0007
        L_0x001e:
            r0 = r6
        L_0x001f:
            if (r2 == 0) goto L_0x0029
            int r5 = r4.position()
            int r5 = r5 - r1
            r4.position(r5)
        L_0x0029:
            int r0 = r0 - r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.StringsKt.decodeASCII3_buffer(java.nio.ByteBuffer, char[], int, int):int");
    }

    private static final long decodeASCII3_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        int i4 = i2 + i;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int remaining = byteBuffer.remaining() + arrayOffset;
        if (i4 > cArr.length || remaining > array.length) {
            i3 = i;
        } else {
            i3 = i;
            while (arrayOffset < remaining) {
                byte b = array[arrayOffset];
                if (b < 0) {
                    break;
                }
                char c = (char) b;
                if (!((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    return UTFKt.decodeUtf8Result(i3 - i, -1);
                } else if (i3 >= i4) {
                    break;
                } else {
                    cArr[i3] = c;
                    i3++;
                    arrayOffset++;
                }
            }
            byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
        }
        return UTFKt.decodeUtf8Result(i3 - i, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r8 = false;
        r6 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final long decodeASCII3_buffer(java.nio.ByteBuffer r5, char[] r6, int r7, int r8, kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> r9) {
        /*
            int r8 = r8 + r7
            int r0 = r6.length
            r1 = 0
            r2 = 1
            if (r8 > r0) goto L_0x0031
            r0 = r7
        L_0x0007:
            boolean r3 = r5.hasRemaining()
            if (r3 == 0) goto L_0x0032
            byte r3 = r5.get()
            if (r3 >= 0) goto L_0x0016
        L_0x0013:
            r8 = r1
            r6 = r2
            goto L_0x0034
        L_0x0016:
            char r3 = (char) r3
            java.lang.Character r4 = java.lang.Character.valueOf(r3)
            java.lang.Object r4 = r9.invoke(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x0029
            r6 = r2
            goto L_0x0033
        L_0x0029:
            if (r0 < r8) goto L_0x002c
            goto L_0x0013
        L_0x002c:
            r6[r0] = r3
            int r0 = r0 + 1
            goto L_0x0007
        L_0x0031:
            r0 = r7
        L_0x0032:
            r6 = r1
        L_0x0033:
            r8 = r6
        L_0x0034:
            if (r6 == 0) goto L_0x003e
            int r6 = r5.position()
            int r6 = r6 - r2
            r5.position(r6)
        L_0x003e:
            int r0 = r0 - r7
            if (r8 == 0) goto L_0x0042
            r1 = -1
        L_0x0042:
            long r5 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r0, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.StringsKt.decodeASCII3_buffer(java.nio.ByteBuffer, char[], int, int, kotlin.jvm.functions.Function1):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0039 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final long decodeASCIILine_array(java.nio.ByteBuffer r11, char[] r12, int r13, int r14) {
        /*
            int r14 = r14 + r13
            byte[] r0 = r11.array()
            int r1 = r11.arrayOffset()
            int r2 = r11.position()
            int r1 = r1 + r2
            int r2 = r11.remaining()
            int r2 = r2 + r1
            int r3 = r12.length
            r4 = 13
            r5 = -1
            r6 = 0
            r7 = 1
            if (r14 > r3) goto L_0x005a
            int r3 = r0.length
            if (r2 > r3) goto L_0x005a
            r8 = r13
            r3 = r6
        L_0x0020:
            if (r1 >= r2) goto L_0x0051
            byte r9 = r0[r1]
            if (r9 < 0) goto L_0x0051
            char r9 = (char) r9
            if (r9 != r4) goto L_0x002c
            r3 = r7
        L_0x002a:
            r10 = r3
            goto L_0x0037
        L_0x002c:
            r10 = 10
            if (r9 != r10) goto L_0x0032
            r3 = r6
            goto L_0x002a
        L_0x0032:
            if (r3 == 0) goto L_0x0036
            r10 = r6
            goto L_0x0037
        L_0x0036:
            r10 = r7
        L_0x0037:
            if (r10 != 0) goto L_0x0047
            int r14 = r11.arrayOffset()
            int r1 = r1 - r14
            r11.position(r1)
            int r8 = r8 - r13
            long r13 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r8, r5)
            goto L_0x0061
        L_0x0047:
            if (r8 < r14) goto L_0x004a
            goto L_0x0051
        L_0x004a:
            r12[r8] = r9
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L_0x0020
        L_0x0051:
            int r14 = r11.arrayOffset()
            int r1 = r1 - r14
            r11.position(r1)
            goto L_0x005c
        L_0x005a:
            r8 = r13
            r3 = r6
        L_0x005c:
            int r8 = r8 - r13
            long r13 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r8, r6)
        L_0x0061:
            r0 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r0 = r0 & r13
            int r0 = (int) r0
            r1 = 32
            if (r0 != r5) goto L_0x008b
            long r0 = r13 >> r1
            int r0 = (int) r0
            if (r3 == 0) goto L_0x0077
            int r0 = r0 - r7
            long r11 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r0, r5)
            return r11
        L_0x0077:
            int r1 = r11.position()
            int r1 = r1 + r7
            r11.position(r1)
            if (r0 <= 0) goto L_0x009f
            int r0 = r0 - r7
            char r11 = r12[r0]
            if (r11 != r4) goto L_0x009f
            long r11 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r0, r5)
            return r11
        L_0x008b:
            if (r3 == 0) goto L_0x009f
            long r12 = r13 >> r1
            int r12 = (int) r12
            int r13 = r11.position()
            int r13 = r13 - r7
            r11.position(r13)
            int r12 = r12 - r7
            r11 = 2
            long r11 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r12, r11)
            return r11
        L_0x009f:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.StringsKt.decodeASCIILine_array(java.nio.ByteBuffer, char[], int, int):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0037, code lost:
        r5 = r11;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x002c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final long decodeASCIILine_buffer(java.nio.ByteBuffer r8, char[] r9, int r10, int r11) {
        /*
            int r11 = r11 + r10
            int r0 = r9.length
            r1 = 13
            r2 = 0
            r3 = 1
            r4 = r10
            if (r11 > r0) goto L_0x0039
            r0 = r2
        L_0x000a:
            boolean r5 = r8.hasRemaining()
            if (r5 == 0) goto L_0x0036
            byte r5 = r8.get()
            if (r5 >= 0) goto L_0x0019
        L_0x0016:
            r5 = r2
            r11 = r3
            goto L_0x003c
        L_0x0019:
            char r5 = (char) r5
            if (r5 != r1) goto L_0x001f
            r0 = r3
        L_0x001d:
            r6 = r0
            goto L_0x002a
        L_0x001f:
            r6 = 10
            if (r5 != r6) goto L_0x0025
            r0 = r2
            goto L_0x001d
        L_0x0025:
            if (r0 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002a
        L_0x0029:
            r6 = r3
        L_0x002a:
            if (r6 != 0) goto L_0x002e
            r11 = r3
            goto L_0x0037
        L_0x002e:
            if (r4 < r11) goto L_0x0031
            goto L_0x0016
        L_0x0031:
            r9[r4] = r5
            int r4 = r4 + 1
            goto L_0x000a
        L_0x0036:
            r11 = r2
        L_0x0037:
            r5 = r11
            goto L_0x003c
        L_0x0039:
            r11 = r2
            r0 = r11
            r5 = r0
        L_0x003c:
            if (r11 == 0) goto L_0x0046
            int r11 = r8.position()
            int r11 = r11 - r3
            r8.position(r11)
        L_0x0046:
            int r4 = r4 - r10
            r10 = -1
            if (r5 == 0) goto L_0x004b
            r2 = r10
        L_0x004b:
            long r4 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r4, r2)
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r6 = r6 & r4
            int r11 = (int) r6
            r2 = 32
            if (r11 != r10) goto L_0x0079
            long r6 = r4 >> r2
            int r11 = (int) r6
            if (r0 == 0) goto L_0x0065
            int r11 = r11 - r3
            long r8 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r11, r10)
            return r8
        L_0x0065:
            int r0 = r8.position()
            int r0 = r0 + r3
            r8.position(r0)
            if (r11 <= 0) goto L_0x008d
            int r11 = r11 - r3
            char r8 = r9[r11]
            if (r8 != r1) goto L_0x008d
            long r8 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r11, r10)
            return r8
        L_0x0079:
            if (r0 == 0) goto L_0x008d
            long r9 = r4 >> r2
            int r9 = (int) r9
            int r10 = r8.position()
            int r10 = r10 - r3
            r8.position(r10)
            int r9 = r9 - r3
            r8 = 2
            long r8 = io.ktor.utils.io.charsets.UTFKt.decodeUtf8Result(r9, r8)
            return r8
        L_0x008d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.StringsKt.decodeASCIILine_buffer(java.nio.ByteBuffer, char[], int, int):long");
    }
}
