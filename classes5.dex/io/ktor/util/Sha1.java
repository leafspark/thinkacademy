package io.ktor.util;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.ArraysKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lio/ktor/util/Sha1;", "Lio/ktor/util/HashFunction;", "()V", "h0", "", "h1", "h2", "h3", "h4", "messageLength", "", "unprocessed", "", "unprocessedLimit", "words", "", "digest", "processChunk", "", "input", "pos", "reset", "update", "offset", "length", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HashFunction.kt */
public final class Sha1 implements HashFunction {
    private int h0 = 1732584193;
    private int h1 = -271733879;
    private int h2 = -1732584194;
    private int h3 = 271733878;
    private int h4 = -1009589776;
    private long messageLength;
    private final byte[] unprocessed = new byte[64];
    private int unprocessedLimit;
    private final int[] words = new int[80];

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(byte[] r6, int r7, int r8) {
        /*
            r5 = this;
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            long r0 = r5.messageLength
            long r2 = (long) r8
            long r0 = r0 + r2
            r5.messageLength = r0
            int r0 = r7 + r8
            byte[] r1 = r5.unprocessed
            int r2 = r5.unprocessedLimit
            r3 = 0
            if (r2 <= 0) goto L_0x002b
            int r8 = r8 + r2
            r4 = 64
            if (r8 >= r4) goto L_0x001f
            kotlin.collections.ArraysKt.copyInto(r6, r1, r2, r7, r0)
            r5.unprocessedLimit = r8
            return
        L_0x001f:
            int r8 = 64 - r2
            int r8 = r8 + r7
            kotlin.collections.ArraysKt.copyInto(r6, r1, r2, r7, r8)
            r5.processChunk(r1, r3)
            r5.unprocessedLimit = r3
        L_0x002a:
            r7 = r8
        L_0x002b:
            if (r7 >= r0) goto L_0x003c
            int r8 = r7 + 64
            if (r8 <= r0) goto L_0x0038
            kotlin.collections.ArraysKt.copyInto(r6, r1, r3, r7, r0)
            int r0 = r0 - r7
            r5.unprocessedLimit = r0
            return
        L_0x0038:
            r5.processChunk(r6, r7)
            goto L_0x002a
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.Sha1.update(byte[], int, int):void");
    }

    private final void processChunk(byte[] bArr, int i) {
        int i2;
        int access$leftRotate;
        int i3;
        int[] iArr = this.words;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= 16) {
                break;
            }
            int i6 = i + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            iArr[i5] = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i6] & UByte.MAX_VALUE) << 16) | ((bArr[i7] & UByte.MAX_VALUE) << 8) | (bArr[i8] & UByte.MAX_VALUE);
            i5++;
            i = i8 + 1;
        }
        for (i2 = 16; i2 < 80; i2++) {
            iArr[i2] = HashFunctionKt.leftRotate(((iArr[i2 - 3] ^ iArr[i2 - 8]) ^ iArr[i2 - 14]) ^ iArr[i2 - 16], 1);
        }
        int i9 = this.h0;
        int i10 = this.h1;
        int i11 = this.h2;
        int i12 = this.h3;
        int i13 = this.h4;
        while (i4 < 80) {
            if (i4 < 20) {
                access$leftRotate = HashFunctionKt.leftRotate(i9, 5) + (((i11 ^ i12) & i10) ^ i12) + i13 + 1518500249;
                i3 = iArr[i4];
            } else if (i4 < 40) {
                access$leftRotate = HashFunctionKt.leftRotate(i9, 5) + ((i10 ^ i11) ^ i12) + i13 + 1859775393;
                i3 = iArr[i4];
            } else if (i4 < 60) {
                access$leftRotate = ((HashFunctionKt.leftRotate(i9, 5) + (((i10 & i11) | (i10 & i12)) | (i11 & i12))) + i13) - 1894007588;
                i3 = iArr[i4];
            } else {
                access$leftRotate = ((HashFunctionKt.leftRotate(i9, 5) + ((i10 ^ i11) ^ i12)) + i13) - 899497514;
                i3 = iArr[i4];
            }
            int i14 = access$leftRotate + i3;
            i4++;
            i13 = i12;
            i12 = i11;
            i11 = HashFunctionKt.leftRotate(i10, 30);
            i10 = i9;
            i9 = i14;
        }
        this.h0 += i9;
        this.h1 += i10;
        this.h2 += i11;
        this.h3 += i12;
        this.h4 += i13;
    }

    public byte[] digest() {
        byte[] bArr = this.unprocessed;
        int i = this.unprocessedLimit;
        long j = this.messageLength * ((long) 8);
        int i2 = i + 1;
        bArr[i] = Byte.MIN_VALUE;
        if (i2 > 56) {
            ArraysKt.fill(bArr, (byte) 0, i2, 64);
            processChunk(bArr, 0);
            ArraysKt.fill(bArr, (byte) 0, 0, i2);
        } else {
            ArraysKt.fill(bArr, (byte) 0, i2, 56);
        }
        bArr[56] = (byte) ((int) (j >>> 56));
        bArr[57] = (byte) ((int) (j >>> 48));
        bArr[58] = (byte) ((int) (j >>> 40));
        bArr[59] = (byte) ((int) (j >>> 32));
        bArr[60] = (byte) ((int) (j >>> 24));
        bArr[61] = (byte) ((int) (j >>> 16));
        bArr[62] = (byte) ((int) (j >>> 8));
        bArr[63] = (byte) ((int) j);
        processChunk(bArr, 0);
        int i3 = this.h0;
        int i4 = this.h1;
        int i5 = this.h2;
        int i6 = this.h3;
        int i7 = this.h4;
        reset();
        return new byte[]{(byte) (i3 >> 24), (byte) (i3 >> 16), (byte) (i3 >> 8), (byte) i3, (byte) (i4 >> 24), (byte) (i4 >> 16), (byte) (i4 >> 8), (byte) i4, (byte) (i5 >> 24), (byte) (i5 >> 16), (byte) (i5 >> 8), (byte) i5, (byte) (i6 >> 24), (byte) (i6 >> 16), (byte) (i6 >> 8), (byte) i6, (byte) (i7 >> 24), (byte) (i7 >> 16), (byte) (i7 >> 8), (byte) i7};
    }

    private final void reset() {
        this.messageLength = 0;
        ArraysKt.fill$default(this.unprocessed, (byte) 0, 0, 0, 6, (Object) null);
        this.unprocessedLimit = 0;
        ArraysKt.fill$default(this.words, 0, 0, 0, 6, (Object) null);
        this.h0 = 1732584193;
        this.h1 = -271733879;
        this.h2 = -1732584194;
        this.h3 = 271733878;
        this.h4 = -1009589776;
    }
}
