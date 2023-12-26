package com.bonree.sdk.bc;

import com.bonree.sdk.ac.e;
import com.bonree.sdk.bc.dd;
import com.bonree.sdk.bc.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class ca implements Serializable, Cloneable, Comparable {
    private static final long a = 2694906050116005466L;
    private static final DecimalFormat b;
    protected bn f;
    protected int g;
    protected int h;
    protected long i;

    /* access modifiers changed from: package-private */
    public abstract ca a();

    /* access modifiers changed from: package-private */
    public abstract void a(dd ddVar, bn bnVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(t tVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(v vVar, m mVar, boolean z);

    /* access modifiers changed from: package-private */
    public abstract String b();

    public bn c() {
        return null;
    }

    static {
        DecimalFormat decimalFormat = new DecimalFormat();
        b = decimalFormat;
        decimalFormat.setMinimumIntegerDigits(3);
    }

    protected ca() {
    }

    ca(bn bnVar, int i2, int i3, long j) {
        if (bnVar.b()) {
            df.a(i2);
            p.a(i3);
            e.a(j);
            this.f = bnVar;
            this.g = i2;
            this.h = i3;
            this.i = j;
            return;
        }
        throw new w.d(bnVar);
    }

    private static final ca a(bn bnVar, int i2, int i3, long j, boolean z) {
        ca caVar;
        if (z) {
            ca c = df.c(i2);
            if (c != null) {
                caVar = c.a();
            } else {
                caVar = new dk();
            }
        } else {
            caVar = new z();
        }
        caVar.f = bnVar;
        caVar.g = i2;
        caVar.h = i3;
        caVar.i = j;
        return caVar;
    }

    private static ca a(bn bnVar, int i2, int i3, long j, int i4, t tVar) throws IOException {
        ca a2 = a(bnVar, i2, i3, j, tVar != null);
        if (tVar != null) {
            if (tVar.b() >= i4) {
                tVar.a(i4);
                a2.a(tVar);
                if (tVar.b() <= 0) {
                    tVar.c();
                } else {
                    throw new Cdo("invalid record length");
                }
            } else {
                throw new Cdo("truncated record");
            }
        }
        return a2;
    }

    private static ca a(bn bnVar, int i2, int i3, long j, int i4, byte[] bArr) {
        if (bnVar.b()) {
            df.a(i2);
            p.a(i3);
            e.a(j);
            try {
                return a(bnVar, i2, i3, j, i4, bArr != null ? new t(bArr) : null);
            } catch (IOException unused) {
                return null;
            }
        } else {
            throw new w.d(bnVar);
        }
    }

    private static ca a(bn bnVar, int i2, int i3, long j, byte[] bArr) {
        return a(bnVar, i2, i3, j, bArr.length, bArr);
    }

    public static ca a(bn bnVar, int i2, int i3, long j) {
        if (bnVar.b()) {
            df.a(i2);
            p.a(i3);
            e.a(j);
            return a(bnVar, i2, i3, j, false);
        }
        throw new w.d(bnVar);
    }

    public static ca a(bn bnVar, int i2, int i3) {
        return a(bnVar, i2, i3, 0);
    }

    static ca a(t tVar, int i2, boolean z) throws IOException {
        bn bnVar = new bn(tVar);
        int h2 = tVar.h();
        int h3 = tVar.h();
        if (i2 == 0) {
            return a(bnVar, h2, h3, 0);
        }
        long i3 = tVar.i();
        int h4 = tVar.h();
        if (h4 == 0 && z && (i2 == 1 || i2 == 2)) {
            return a(bnVar, h2, h3, i3);
        }
        return a(bnVar, h2, h3, i3, h4, tVar);
    }

    private static ca a(t tVar, int i2) throws IOException {
        return a(tVar, i2, false);
    }

    private static ca a(byte[] bArr, int i2) throws IOException {
        return a(new t(bArr), i2, false);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, int i2, m mVar) {
        this.f.a(vVar, mVar);
        vVar.c(this.g);
        vVar.c(this.h);
        if (i2 != 0) {
            vVar.a(this.i);
            int a2 = vVar.a();
            vVar.c(0);
            a(vVar, mVar, false);
            vVar.a((vVar.a() - a2) - 2, a2);
        }
    }

    public final byte[] a(int i2) {
        v vVar = new v();
        a(vVar, 3, (m) null);
        return vVar.d();
    }

    private void a(v vVar, boolean z) {
        this.f.a(vVar);
        vVar.c(this.g);
        vVar.c(this.h);
        if (z) {
            vVar.a(0);
        } else {
            vVar.a(this.i);
        }
        int a2 = vVar.a();
        vVar.c(0);
        a(vVar, (m) null, true);
        vVar.a((vVar.a() - a2) - 2, a2);
    }

    private byte[] a(boolean z) {
        v vVar = new v();
        this.f.a(vVar);
        vVar.c(this.g);
        vVar.c(this.h);
        if (z) {
            vVar.a(0);
        } else {
            vVar.a(this.i);
        }
        int a2 = vVar.a();
        vVar.c(0);
        a(vVar, (m) null, true);
        vVar.a((vVar.a() - a2) - 2, a2);
        return vVar.d();
    }

    private byte[] d() {
        return a(false);
    }

    public final byte[] m() {
        v vVar = new v();
        a(vVar, (m) null, true);
        return vVar.d();
    }

    public final String n() {
        return b();
    }

    public String toString() {
        long j;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f);
        if (stringBuffer.length() < 8) {
            stringBuffer.append("\t");
        }
        if (stringBuffer.length() < 16) {
            stringBuffer.append("\t");
        }
        stringBuffer.append("\t");
        if (br.a("BINDTTL")) {
            long j2 = this.i;
            e.a(j2);
            StringBuffer stringBuffer2 = new StringBuffer();
            long j3 = j2 % 60;
            long j4 = j2 / 60;
            long j5 = j4 % 60;
            long j6 = j4 / 60;
            long j7 = j6 % 24;
            long j8 = j6 / 24;
            long j9 = j8 % 7;
            long j10 = j8 / 7;
            int i2 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
            if (i2 > 0) {
                stringBuffer2.append(j10 + "W");
                j = 0;
            } else {
                j = 0;
            }
            int i3 = (j9 > j ? 1 : (j9 == j ? 0 : -1));
            if (i3 > 0) {
                stringBuffer2.append(j9 + "D");
            }
            int i4 = (j7 > j ? 1 : (j7 == j ? 0 : -1));
            if (i4 > 0) {
                stringBuffer2.append(j7 + "H");
            }
            int i5 = (j5 > j ? 1 : (j5 == j ? 0 : -1));
            if (i5 > 0) {
                stringBuffer2.append(j5 + "M");
            }
            if (j3 > j || (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0)) {
                stringBuffer2.append(j3 + "S");
            }
            stringBuffer.append(stringBuffer2.toString());
        } else {
            stringBuffer.append(this.i);
        }
        stringBuffer.append("\t");
        if (this.h != 1 || !br.a("noPrintIN")) {
            stringBuffer.append(p.b(this.h));
            stringBuffer.append("\t");
        }
        stringBuffer.append(df.b(this.g));
        String b2 = b();
        if (!b2.equals("")) {
            stringBuffer.append("\t");
            stringBuffer.append(b2);
        }
        return stringBuffer.toString();
    }

    protected static byte[] a(String str) throws dc {
        boolean z;
        byte[] bytes = str.getBytes();
        int i2 = 0;
        while (true) {
            if (i2 >= bytes.length) {
                z = false;
                break;
            } else if (bytes[i2] == 92) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            boolean z2 = false;
            int i4 = 0;
            for (int i5 = 0; i5 < bytes.length; i5++) {
                byte b2 = bytes[i5];
                if (z2) {
                    if (b2 >= 48 && b2 <= 57 && i3 < 3) {
                        i3++;
                        i4 = (i4 * 10) + (b2 - 48);
                        if (i4 > 255) {
                            throw new dc("bad escape");
                        } else if (i3 >= 3) {
                            b2 = (byte) i4;
                        }
                    } else if (i3 > 0 && i3 < 3) {
                        throw new dc("bad escape");
                    }
                    byteArrayOutputStream.write(b2);
                    z2 = false;
                } else if (bytes[i5] == 92) {
                    i3 = 0;
                    i4 = 0;
                    z2 = true;
                } else {
                    byteArrayOutputStream.write(bytes[i5]);
                }
            }
            if (i3 > 0 && i3 < 3) {
                throw new dc("bad escape");
            } else if (byteArrayOutputStream.toByteArray().length <= 255) {
                return byteArrayOutputStream.toByteArray();
            } else {
                throw new dc("text string too long");
            }
        } else if (bytes.length <= 255) {
            return bytes;
        } else {
            throw new dc("text string too long");
        }
    }

    protected static String a(byte[] bArr, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        if (z) {
            stringBuffer.append('\"');
        }
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            if (b3 < 32 || b3 >= Byte.MAX_VALUE) {
                stringBuffer.append('\\');
                stringBuffer.append(b.format((long) b3));
            } else if (b3 == 34 || b3 == 92) {
                stringBuffer.append('\\');
                stringBuffer.append((char) b3);
            } else {
                stringBuffer.append((char) b3);
            }
        }
        if (z) {
            stringBuffer.append('\"');
        }
        return stringBuffer.toString();
    }

    protected static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\\# ");
        stringBuffer.append(bArr.length);
        stringBuffer.append(" ");
        stringBuffer.append(e.a(bArr));
        return stringBuffer.toString();
    }

    public static ca a(bn bnVar, int i2, int i3, long j, dd ddVar, bn bnVar2) throws IOException {
        if (bnVar.b()) {
            df.a(i2);
            p.a(i3);
            e.a(j);
            dd.a a2 = ddVar.a();
            if (a2.a != 3 || !a2.b.equals("\\#")) {
                ddVar.b();
                ca a3 = a(bnVar, i2, i3, j, true);
                a3.a(ddVar, bnVar2);
                dd.a a4 = ddVar.a();
                if (a4.a == 1 || a4.a == 0) {
                    return a3;
                }
                throw ddVar.a("unexpected tokens at end of record");
            }
            int g2 = ddVar.g();
            byte[] m = ddVar.m();
            if (m == null) {
                m = new byte[0];
            }
            if (g2 == m.length) {
                return a(bnVar, i2, i3, j, g2, new t(m));
            }
            throw ddVar.a("invalid unknown RR encoding: length mismatch");
        }
        throw new w.d(bnVar);
    }

    public static ca a(bn bnVar, int i2, int i3, long j, String str, bn bnVar2) throws IOException {
        return a(bnVar, i2, i3, j, new dd(str), bnVar2);
    }

    public final bn o() {
        return this.f;
    }

    public final int p() {
        return this.g;
    }

    public final int q() {
        int i2 = this.g;
        return i2 == 46 ? ((bw) this).l() : i2;
    }

    public final int r() {
        return this.h;
    }

    public final long s() {
        return this.i;
    }

    public final boolean a(ca caVar) {
        return q() == caVar.q() && this.h == caVar.h && this.f.equals(caVar.f);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ca)) {
            ca caVar = (ca) obj;
            if (this.g == caVar.g && this.h == caVar.h && this.f.equals(caVar.f)) {
                return Arrays.equals(m(), caVar.m());
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = 0;
        for (byte b2 : a(true)) {
            i2 += (i2 << 3) + (b2 & 255);
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final ca t() {
        try {
            return (ca) clone();
        } catch (CloneNotSupportedException unused) {
            throw new IllegalStateException();
        }
    }

    private ca b(bn bnVar) {
        if (bnVar.b()) {
            ca t = t();
            t.f = bnVar;
            return t;
        }
        throw new w.d(bnVar);
    }

    /* access modifiers changed from: package-private */
    public final ca a(int i2, long j) {
        ca t = t();
        t.h = 254;
        t.i = 0;
        return t;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j) {
        this.i = j;
    }

    public int compareTo(Object obj) {
        ca caVar = (ca) obj;
        int i2 = 0;
        if (this == caVar) {
            return 0;
        }
        int compareTo = this.f.compareTo(caVar.f);
        if (compareTo != 0) {
            return compareTo;
        }
        int i3 = this.h - caVar.h;
        if (i3 != 0) {
            return i3;
        }
        int i4 = this.g - caVar.g;
        if (i4 != 0) {
            return i4;
        }
        byte[] m = m();
        byte[] m2 = caVar.m();
        while (i2 < m.length && i2 < m2.length) {
            int i5 = (m[i2] & 255) - (m2[i2] & 255);
            if (i5 != 0) {
                return i5;
            }
            i2++;
        }
        return m.length - m2.length;
    }

    static int a(String str, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return i2;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i2 + " must be an unsigned 8 bit value");
    }

    static int b(String str, int i2) {
        if (i2 >= 0 && i2 <= 65535) {
            return i2;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i2 + " must be an unsigned 16 bit value");
    }

    static long a(String str, long j) {
        if (j >= 0 && j <= 4294967295L) {
            return j;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + j + " must be an unsigned 32 bit value");
    }

    static bn a(bn bnVar) {
        if (bnVar.b()) {
            return bnVar;
        }
        throw new w.d(bnVar);
    }

    static byte[] a(String str, byte[] bArr, int i2) {
        if (bArr.length <= 65535) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        throw new IllegalArgumentException("\"" + str + "\" array must have no more than 65535" + " elements");
    }
}
