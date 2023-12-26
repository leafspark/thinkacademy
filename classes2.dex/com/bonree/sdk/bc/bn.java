package com.bonree.sdk.bc;

import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;

public final class bn implements Serializable, Comparable {
    public static final bn a;
    private static final long b = -7257019940971525644L;
    private static final int c = 0;
    private static final int d = 192;
    private static final int e = 192;
    private static final byte[] i = {0};
    private static final byte[] j = {1, 42};
    private static bn k = null;
    private static final int l = 255;
    private static final int m = 63;
    private static final int n = 128;
    private static final int o = 7;
    private static final DecimalFormat p;
    private static final byte[] q = new byte[WebViewRouteChangeEvent.ROUTE_CHANGE_String_LIMIT];
    private static final bn r;
    private byte[] f;
    private long g;
    private int h;

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        p = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 65 || i2 > 90) {
                q[i2] = (byte) i2;
            } else {
                q[i2] = (byte) ((i2 - 65) + 97);
            }
        }
        bn bnVar = new bn();
        a = bnVar;
        bnVar.b(i, 0, 1);
        bn bnVar2 = new bn();
        k = bnVar2;
        bnVar2.f = new byte[0];
        bn bnVar3 = new bn();
        r = bnVar3;
        bnVar3.b(j, 0, 1);
    }

    private bn() {
    }

    private final void a(int i2, int i3) {
        if (i2 < 7) {
            int i4 = (7 - i2) * 8;
            long j2 = this.g & (~(255 << i4));
            this.g = j2;
            this.g = (((long) i3) << i4) | j2;
        }
    }

    private final int b(int i2) {
        if (i2 == 0 && f() == 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= f()) {
            throw new IllegalArgumentException("label out of range");
        } else if (i2 < 7) {
            return ((int) (this.g >>> ((7 - i2) * 8))) & l;
        } else {
            int b2 = b(6);
            for (int i3 = 6; i3 < i2; i3++) {
                b2 += this.f[b2] + 1;
            }
            return b2;
        }
    }

    private final void c(int i2) {
        long j2 = this.g & -256;
        this.g = j2;
        this.g = j2 | ((long) i2);
    }

    private final int f() {
        return (int) (this.g & 255);
    }

    private static final void b(bn bnVar, bn bnVar2) {
        int i2 = 0;
        if (bnVar.b(0) == 0) {
            bnVar2.f = bnVar.f;
            bnVar2.g = bnVar.g;
            return;
        }
        int b2 = bnVar.b(0);
        int length = bnVar.f.length - b2;
        int f2 = bnVar.f();
        byte[] bArr = new byte[length];
        bnVar2.f = bArr;
        System.arraycopy(bnVar.f, b2, bArr, 0, length);
        while (i2 < f2 && i2 < 7) {
            bnVar2.a(i2, bnVar.b(i2) - b2);
            i2++;
        }
        bnVar2.c(f2);
    }

    private final void a(byte[] bArr, int i2, int i3) throws bo {
        byte[] bArr2 = this.f;
        int length = bArr2 == null ? 0 : bArr2.length - b(0);
        int i4 = i2;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            byte b2 = bArr[i4];
            if (b2 <= 63) {
                int i7 = b2 + 1;
                i4 += i7;
                i6 += i7;
                i5++;
            } else {
                throw new IllegalStateException("invalid label");
            }
        }
        int i8 = length + i6;
        if (i8 <= l) {
            int f2 = f();
            int i9 = f2 + i3;
            if (i9 <= n) {
                byte[] bArr3 = new byte[i8];
                if (length != 0) {
                    System.arraycopy(this.f, b(0), bArr3, 0, length);
                }
                System.arraycopy(bArr, i2, bArr3, length, i6);
                this.f = bArr3;
                for (int i10 = 0; i10 < i3; i10++) {
                    a(f2 + i10, length);
                    length += bArr3[length] + 1;
                }
                c(i9);
                return;
            }
            throw new IllegalStateException("too many labels");
        }
        throw new bo();
    }

    private static dc a(String str, String str2) {
        return new dc("'" + str + "': " + str2);
    }

    private final void a(String str, byte[] bArr, int i2, int i3) throws dc {
        try {
            a(bArr, i2, i3);
        } catch (bo unused) {
            throw a(str, "Name too long");
        }
    }

    private final void b(byte[] bArr, int i2, int i3) {
        try {
            a(bArr, i2, i3);
        } catch (bo unused) {
        }
    }

    private bn(String str, bn bnVar) throws dc {
        int i2;
        boolean z;
        int i3;
        String str2 = str;
        bn bnVar2 = bnVar;
        if (str2.equals("")) {
            throw a(str2, "empty name");
        } else if (str2.equals("@")) {
            if (bnVar2 == null) {
                b(k, this);
            } else {
                b(bnVar2, this);
            }
        } else if (str2.equals(".")) {
            b(a, this);
        } else {
            byte[] bArr = new byte[64];
            int i4 = 0;
            boolean z2 = false;
            int i5 = -1;
            int i6 = 1;
            int i7 = 0;
            for (int i8 = 0; i8 < str.length(); i8++) {
                byte charAt = (byte) str2.charAt(i8);
                if (z2) {
                    if (charAt >= 48 && charAt <= 57 && i4 < 3) {
                        i4++;
                        i7 = (i7 * 10) + (charAt - 48);
                        if (i7 > l) {
                            throw a(str2, "bad escape");
                        } else if (i4 >= 3) {
                            charAt = (byte) i7;
                        } else {
                            continue;
                        }
                    } else if (i4 > 0 && i4 < 3) {
                        throw a(str2, "bad escape");
                    }
                    if (i6 <= 63) {
                        i3 = i6 + 1;
                        bArr[i6] = charAt;
                        i5 = i6;
                        z2 = false;
                    } else {
                        throw a(str2, "label too long");
                    }
                } else {
                    if (charAt == 92) {
                        i4 = 0;
                        z2 = true;
                        i7 = 0;
                    } else if (charAt != 46) {
                        i5 = i5 == -1 ? i8 : i5;
                        if (i6 <= 63) {
                            i3 = i6 + 1;
                            bArr[i6] = charAt;
                        } else {
                            throw a(str2, "label too long");
                        }
                    } else if (i5 != -1) {
                        bArr[0] = (byte) (i6 - 1);
                        a(str2, bArr, 0, 1);
                        i5 = -1;
                        i6 = 1;
                    } else {
                        throw a(str2, "invalid empty label");
                    }
                }
                i6 = i3;
            }
            if (i4 > 0 && i4 < 3) {
                throw a(str2, "bad escape");
            } else if (!z2) {
                if (i5 == -1) {
                    z = true;
                    i2 = 0;
                    a(str2, i, 0, 1);
                } else {
                    i2 = 0;
                    bArr[0] = (byte) (i6 - 1);
                    a(str2, bArr, 0, 1);
                    z = false;
                }
                if (bnVar2 != null && !z) {
                    a(str2, bnVar2.f, bnVar2.b(i2), bnVar.f());
                }
            } else {
                throw a(str2, "bad escape");
            }
        }
    }

    private bn(String str) throws dc {
        this(str, (bn) null);
    }

    public static bn a(String str, bn bnVar) throws dc {
        if (str.equals("@") && bnVar != null) {
            return bnVar;
        }
        if (str.equals(".")) {
            return a;
        }
        return new bn(str, bnVar);
    }

    public static bn a(String str) throws dc {
        return a(str, (bn) null);
    }

    public static bn b(String str) {
        try {
            return a(str, (bn) null);
        } catch (dc unused) {
            throw new IllegalArgumentException("Invalid name '" + str + "'");
        }
    }

    public bn(t tVar) throws Cdo {
        byte[] bArr = new byte[64];
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            int g2 = tVar.g();
            int i2 = g2 & 192;
            if (i2 != 0) {
                if (i2 == 192) {
                    int g3 = tVar.g() + ((g2 & -193) << 8);
                    if (br.a("verbosecompression")) {
                        System.err.println("currently " + tVar.a() + ", pointer to " + g3);
                    }
                    if (g3 < tVar.a() - 2) {
                        if (!z2) {
                            tVar.e();
                            z2 = true;
                        }
                        tVar.c(g3);
                        if (br.a("verbosecompression")) {
                            System.err.println("current name '" + this + "', seeking to " + g3);
                        }
                    } else {
                        throw new Cdo("bad compression");
                    }
                } else {
                    throw new Cdo("bad label type");
                }
            } else if (f() >= n) {
                throw new Cdo("too many labels");
            } else if (g2 == 0) {
                a(i, 0, 1);
                z = true;
            } else {
                bArr[0] = (byte) g2;
                tVar.a(bArr, 1, g2);
                a(bArr, 0, 1);
            }
        }
        if (z2) {
            tVar.f();
        }
    }

    private bn(byte[] bArr) throws IOException {
        this(new t(bArr));
    }

    public bn(bn bnVar, int i2) {
        int f2 = bnVar.f();
        if (i2 <= f2) {
            this.f = bnVar.f;
            int i3 = f2 - i2;
            c(i3);
            int i4 = 0;
            while (i4 < 7 && i4 < i3) {
                a(i4, bnVar.b(i4 + i2));
                i4++;
            }
            return;
        }
        throw new IllegalArgumentException("attempted to remove too many labels");
    }

    public static bn a(bn bnVar, bn bnVar2) throws bo {
        if (bnVar.b()) {
            return bnVar;
        }
        bn bnVar3 = new bn();
        b(bnVar, bnVar3);
        bnVar3.a(bnVar2.f, bnVar2.b(0), bnVar2.f());
        return bnVar3;
    }

    private bn b(bn bnVar) {
        if (bnVar == null || !a(bnVar)) {
            return this;
        }
        bn bnVar2 = new bn();
        b(this, bnVar2);
        int c2 = c() - bnVar.c();
        bnVar2.c(bnVar2.f() - bnVar.f());
        bnVar2.f = new byte[c2];
        System.arraycopy(this.f, b(0), bnVar2.f, 0, c2);
        return bnVar2;
    }

    public final bn a(int i2) {
        if (i2 > 0) {
            try {
                bn bnVar = new bn();
                b(r, bnVar);
                bnVar.a(this.f, b(i2), f() - i2);
                return bnVar;
            } catch (bo unused) {
                throw new IllegalStateException("Name.wild: concatenate failed");
            }
        } else {
            throw new IllegalArgumentException("must replace 1 or more labels");
        }
    }

    private bn g() {
        boolean z;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f;
            if (i3 >= bArr.length) {
                z = true;
                break;
            } else if (q[bArr[i3] & 255] != bArr[i3]) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        if (z) {
            return this;
        }
        bn bnVar = new bn();
        bnVar.b(this.f, b(0), f());
        while (true) {
            byte[] bArr2 = bnVar.f;
            if (i2 >= bArr2.length) {
                return bnVar;
            }
            bArr2[i2] = q[bArr2[i2] & 255];
            i2++;
        }
    }

    public final bn a(s sVar) throws bo {
        bn o2 = sVar.o();
        bn e_ = sVar.e_();
        if (!a(o2)) {
            return null;
        }
        int f2 = f() - o2.f();
        int c2 = c() - o2.c();
        int i2 = 0;
        int b2 = b(0);
        int f3 = e_.f();
        short c3 = e_.c();
        int i3 = c2 + c3;
        if (i3 <= l) {
            bn bnVar = new bn();
            int i4 = f2 + f3;
            bnVar.c(i4);
            byte[] bArr = new byte[i3];
            bnVar.f = bArr;
            System.arraycopy(this.f, b2, bArr, 0, c2);
            System.arraycopy(e_.f, 0, bnVar.f, c2, c3);
            int i5 = 0;
            while (i2 < 7 && i2 < i4) {
                bnVar.a(i2, i5);
                i5 += bnVar.f[i5] + 1;
                i2++;
            }
            return bnVar;
        }
        throw new bo();
    }

    public final short c() {
        if (f() == 0) {
            return 0;
        }
        return (short) (this.f.length - b(0));
    }

    public final int d() {
        return f();
    }

    private static String a(byte[] bArr, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        for (int i4 = i3; i4 < i3 + b2; i4++) {
            byte b3 = bArr[i4] & 255;
            if (b3 <= 32 || b3 >= Byte.MAX_VALUE) {
                stringBuffer.append('\\');
                stringBuffer.append(p.format((long) b3));
            } else if (b3 == 34 || b3 == 40 || b3 == 41 || b3 == 46 || b3 == 59 || b3 == 92 || b3 == 64 || b3 == 36) {
                stringBuffer.append('\\');
                stringBuffer.append((char) b3);
            } else {
                stringBuffer.append((char) b3);
            }
        }
        return stringBuffer.toString();
    }

    private byte[] d(int i2) {
        int b2 = b(i2);
        byte[] bArr = this.f;
        int i3 = (byte) (bArr[b2] + 1);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, b2, bArr2, 0, i3);
        return bArr2;
    }

    private String e(int i2) {
        return a(this.f, b(i2));
    }

    public final void a(v vVar, m mVar) {
        if (b()) {
            int f2 = f();
            int i2 = 0;
            while (i2 < f2 - 1) {
                bn bnVar = i2 == 0 ? this : new bn(this, i2);
                int i3 = -1;
                if (mVar != null) {
                    i3 = mVar.a(bnVar);
                }
                if (i3 >= 0) {
                    vVar.c(49152 | i3);
                    return;
                }
                if (mVar != null) {
                    mVar.a(vVar.a(), bnVar);
                }
                int b2 = b(i2);
                byte[] bArr = this.f;
                vVar.a(bArr, b2, bArr[b2] + 1);
                i2++;
            }
            vVar.b(0);
            return;
        }
        throw new IllegalArgumentException("toWire() called on non-absolute name");
    }

    private byte[] h() {
        v vVar = new v();
        a(vVar, (m) null);
        return vVar.d();
    }

    public final void a(v vVar) {
        vVar.a(e());
    }

    public final void a(v vVar, m mVar, boolean z) {
        if (z) {
            a(vVar);
        } else {
            a(vVar, mVar);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof bn)) {
            return false;
        }
        bn bnVar = (bn) obj;
        if (bnVar.h == 0) {
            bnVar.hashCode();
        }
        if (this.h == 0) {
            hashCode();
        }
        if (bnVar.h == this.h && bnVar.f() == f()) {
            return b(bnVar.f, bnVar.b(0));
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.h;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 0;
        int b2 = b(0);
        while (true) {
            byte[] bArr = this.f;
            if (b2 < bArr.length) {
                i3 += (i3 << 3) + q[bArr[b2] & 255];
                b2++;
            } else {
                this.h = i3;
                return i3;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int compareTo(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            com.bonree.sdk.bc.bn r1 = (com.bonree.sdk.bc.bn) r1
            r2 = 0
            if (r0 != r1) goto L_0x000a
            return r2
        L_0x000a:
            int r3 = r17.f()
            int r4 = r1.f()
            if (r3 <= r4) goto L_0x0016
            r5 = r4
            goto L_0x0017
        L_0x0016:
            r5 = r3
        L_0x0017:
            r6 = 1
            r7 = r6
        L_0x0019:
            if (r7 > r5) goto L_0x005b
            int r8 = r3 - r7
            int r8 = r0.b((int) r8)
            int r9 = r4 - r7
            int r9 = r1.b((int) r9)
            byte[] r10 = r0.f
            byte r10 = r10[r8]
            byte[] r11 = r1.f
            byte r11 = r11[r9]
            r12 = r2
        L_0x0030:
            if (r12 >= r10) goto L_0x0054
            if (r12 >= r11) goto L_0x0054
            byte[] r13 = q
            byte[] r14 = r0.f
            int r15 = r12 + r8
            int r15 = r15 + r6
            byte r14 = r14[r15]
            r14 = r14 & 255(0xff, float:3.57E-43)
            byte r14 = r13[r14]
            byte[] r15 = r1.f
            int r16 = r12 + r9
            int r16 = r16 + 1
            byte r15 = r15[r16]
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte r13 = r13[r15]
            int r14 = r14 - r13
            if (r14 == 0) goto L_0x0051
            return r14
        L_0x0051:
            int r12 = r12 + 1
            goto L_0x0030
        L_0x0054:
            if (r10 == r11) goto L_0x0058
            int r10 = r10 - r11
            return r10
        L_0x0058:
            int r7 = r7 + 1
            goto L_0x0019
        L_0x005b:
            int r3 = r3 - r4
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.bn.compareTo(java.lang.Object):int");
    }

    public final boolean a() {
        if (f() == 0) {
            return false;
        }
        byte[] bArr = this.f;
        return bArr[0] == 1 && bArr[1] == 42;
    }

    public final boolean b() {
        int f2 = f();
        return f2 != 0 && this.f[b(f2 - 1)] == 0;
    }

    public final boolean a(bn bnVar) {
        int f2 = f();
        int f3 = bnVar.f();
        if (f3 > f2) {
            return false;
        }
        if (f3 == f2) {
            return equals(bnVar);
        }
        return bnVar.b(this.f, b(f2 - f3));
    }

    private String a(boolean z) {
        int f2 = f();
        if (f2 == 0) {
            return "@";
        }
        int i2 = 0;
        if (f2 == 1 && this.f[b(0)] == 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int b2 = b(0);
        while (true) {
            if (i2 >= f2) {
                break;
            }
            byte b3 = this.f[b2];
            if (b3 > 63) {
                throw new IllegalStateException("invalid label");
            } else if (b3 == 0) {
                stringBuffer.append('.');
                break;
            } else {
                if (i2 > 0) {
                    stringBuffer.append('.');
                }
                stringBuffer.append(a(this.f, b2));
                b2 += b3 + 1;
                i2++;
            }
        }
        return stringBuffer.toString();
    }

    public final String toString() {
        int f2 = f();
        if (f2 == 0) {
            return "@";
        }
        int i2 = 0;
        if (f2 == 1 && this.f[b(0)] == 0) {
            return ".";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int b2 = b(0);
        while (true) {
            if (i2 >= f2) {
                break;
            }
            byte b3 = this.f[b2];
            if (b3 > 63) {
                throw new IllegalStateException("invalid label");
            } else if (b3 == 0) {
                stringBuffer.append('.');
                break;
            } else {
                if (i2 > 0) {
                    stringBuffer.append('.');
                }
                stringBuffer.append(a(this.f, b2));
                b2 += b3 + 1;
                i2++;
            }
        }
        return stringBuffer.toString();
    }

    public final byte[] e() {
        int f2 = f();
        if (f2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(this.f.length - b(0))];
        int b2 = b(0);
        int i2 = 0;
        int i3 = 0;
        while (i2 < f2) {
            byte[] bArr2 = this.f;
            byte b3 = bArr2[b2];
            if (b3 <= 63) {
                bArr[i3] = bArr2[b2];
                int i4 = 0;
                i3++;
                b2++;
                while (i4 < b3) {
                    bArr[i3] = q[this.f[b2] & 255];
                    i4++;
                    i3++;
                    b2++;
                }
                i2++;
            } else {
                throw new IllegalStateException("invalid label");
            }
        }
        return bArr;
    }

    private final boolean b(byte[] bArr, int i2) {
        int f2 = f();
        int b2 = b(0);
        int i3 = 0;
        while (i3 < f2) {
            byte[] bArr2 = this.f;
            if (bArr2[b2] != bArr[i2]) {
                return false;
            }
            int i4 = b2 + 1;
            byte b3 = bArr2[b2];
            i2++;
            if (b3 <= 63) {
                int i5 = 0;
                while (i5 < b3) {
                    byte[] bArr3 = q;
                    int i6 = i4 + 1;
                    int i7 = i2 + 1;
                    if (bArr3[this.f[i4] & 255] != bArr3[bArr[i2] & 255]) {
                        return false;
                    }
                    i5++;
                    i2 = i7;
                    i4 = i6;
                }
                i3++;
                b2 = i4;
            } else {
                throw new IllegalStateException("invalid label");
            }
        }
        return true;
    }
}
