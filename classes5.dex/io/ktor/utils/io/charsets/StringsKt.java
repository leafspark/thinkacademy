package io.ktor.utils.io.charsets;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0001H\u0000\u001a@\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\bø\u0001\u0000\u001a$\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a9\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\b\u001a$\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a9\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\r"}, d2 = {"decodeASCII", "", "Ljava/nio/ByteBuffer;", "out", "", "offset", "length", "predicate", "Lkotlin/Function1;", "", "", "decodeASCII3_array", "decodeASCII3_buffer", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Strings.kt */
public final class StringsKt {
    public static /* synthetic */ int decodeASCII$default(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1 function1, int i3, Object obj) {
        int i4;
        int i5;
        boolean z = false;
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "out");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (byteBuffer.hasArray()) {
            int i6 = i2 + i;
            byte[] array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int remaining = byteBuffer.remaining() + arrayOffset;
            if (i6 > cArr.length || remaining > array.length) {
                i5 = i;
            } else {
                i5 = i;
                while (true) {
                    if (arrayOffset >= remaining || i5 >= i6) {
                        break;
                    }
                    byte b = array[arrayOffset];
                    if (b < 0) {
                        break;
                    }
                    char c = (char) b;
                    if (!((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                        arrayOffset--;
                        break;
                    }
                    cArr[i5] = c;
                    i5++;
                    arrayOffset++;
                }
                byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
            }
            return i5 - i;
        }
        int i7 = i2 + i;
        if (i7 <= cArr.length) {
            i4 = i;
            while (true) {
                if (byteBuffer.hasRemaining()) {
                    byte b2 = byteBuffer.get();
                    if (b2 < 0 || i4 >= i7) {
                        break;
                    }
                    char c2 = (char) b2;
                    if (!((Boolean) function1.invoke(Character.valueOf(c2))).booleanValue()) {
                        break;
                    }
                    cArr[i4] = c2;
                    i4++;
                } else {
                    break;
                }
            }
            z = true;
        } else {
            i4 = i;
        }
        if (z) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return i4 - i;
    }

    public static final int decodeASCII(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "out");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (byteBuffer.hasArray()) {
            int i5 = i2 + i;
            byte[] array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int remaining = byteBuffer.remaining() + arrayOffset;
            if (i5 > cArr.length || remaining > array.length) {
                i4 = i;
            } else {
                i4 = i;
                while (true) {
                    if (arrayOffset >= remaining || i4 >= i5) {
                        break;
                    }
                    byte b = array[arrayOffset];
                    if (b < 0) {
                        break;
                    }
                    char c = (char) b;
                    if (!((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                        arrayOffset--;
                        break;
                    }
                    cArr[i4] = c;
                    i4++;
                    arrayOffset++;
                }
                byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
            }
            return i4 - i;
        }
        int i6 = i2 + i;
        boolean z = false;
        if (i6 <= cArr.length) {
            i3 = i;
            while (true) {
                if (byteBuffer.hasRemaining()) {
                    byte b2 = byteBuffer.get();
                    if (b2 < 0 || i3 >= i6) {
                        break;
                    }
                    char c2 = (char) b2;
                    if (!((Boolean) function1.invoke(Character.valueOf(c2))).booleanValue()) {
                        break;
                    }
                    cArr[i3] = c2;
                    i3++;
                } else {
                    break;
                }
            }
            z = true;
        } else {
            i3 = i;
        }
        if (z) {
            byteBuffer.position(byteBuffer.position() - 1);
        }
        return i3 - i;
    }

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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.StringsKt.decodeASCII3_buffer(java.nio.ByteBuffer, char[], int, int):int");
    }

    private static final int decodeASCII3_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        int i4 = i2 + i;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int remaining = byteBuffer.remaining() + arrayOffset;
        if (i4 > cArr.length || remaining > array.length) {
            i3 = i;
        } else {
            i3 = i;
            while (true) {
                if (arrayOffset >= remaining || i3 >= i4) {
                    break;
                }
                byte b = array[arrayOffset];
                if (b < 0) {
                    break;
                }
                char c = (char) b;
                if (!((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                    arrayOffset--;
                    break;
                }
                cArr[i3] = c;
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
    private static final int decodeASCII3_buffer(java.nio.ByteBuffer r5, char[] r6, int r7, int r8, kotlin.jvm.functions.Function1<? super java.lang.Character, java.lang.Boolean> r9) {
        /*
            int r8 = r8 + r7
            int r0 = r6.length
            r1 = 1
            r2 = 0
            if (r8 > r0) goto L_0x002f
            r0 = r7
        L_0x0007:
            boolean r3 = r5.hasRemaining()
            if (r3 == 0) goto L_0x0030
            byte r3 = r5.get()
            if (r3 >= 0) goto L_0x0015
        L_0x0013:
            r2 = r1
            goto L_0x0030
        L_0x0015:
            if (r0 < r8) goto L_0x0018
            goto L_0x0013
        L_0x0018:
            char r3 = (char) r3
            java.lang.Character r4 = java.lang.Character.valueOf(r3)
            java.lang.Object r4 = r9.invoke(r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x002a
            goto L_0x0013
        L_0x002a:
            r6[r0] = r3
            int r0 = r0 + 1
            goto L_0x0007
        L_0x002f:
            r0 = r7
        L_0x0030:
            if (r2 == 0) goto L_0x003a
            int r6 = r5.position()
            int r6 = r6 - r1
            r5.position(r6)
        L_0x003a:
            int r0 = r0 - r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.StringsKt.decodeASCII3_buffer(java.nio.ByteBuffer, char[], int, int, kotlin.jvm.functions.Function1):int");
    }
}
