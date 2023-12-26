package com.bonree.sdk.bc;

import com.facebook.soloader.MinElf;
import java.io.IOException;
import java.util.Random;

public final class ai implements Cloneable {
    private static Random d = new Random();
    private static int e = 12;
    private int a;
    private int b;
    private int[] c;

    private void f() {
        this.c = new int[4];
        this.b = 0;
        this.a = -1;
    }

    public ai(int i) {
        f();
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("DNS message ID " + i + " is out of range");
        }
        this.a = i;
    }

    public ai() {
        f();
    }

    ai(t tVar) throws IOException {
        this(tVar.h());
        this.b = tVar.h();
        int i = 0;
        while (true) {
            int[] iArr = this.c;
            if (i < iArr.length) {
                iArr[i] = tVar.h();
                i++;
            } else {
                return;
            }
        }
    }

    private ai(byte[] bArr) throws IOException {
        this(new t(bArr));
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar) {
        vVar.c(b());
        vVar.c(this.b);
        int i = 0;
        while (true) {
            int[] iArr = this.c;
            if (i < iArr.length) {
                vVar.c(iArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final byte[] a() {
        v vVar = new v();
        a(vVar);
        return vVar.d();
    }

    private static boolean h(int i) {
        return i >= 0 && i <= 15 && ac.b(i);
    }

    private static void i(int i) {
        if (!h(i)) {
            throw new IllegalArgumentException("invalid flag bit " + i);
        }
    }

    static int a(int i, int i2, boolean z) {
        i(i2);
        return z ? i | (1 << (15 - i2)) : i & (~(1 << (15 - i2)));
    }

    public final void a(int i) {
        i(i);
        this.b = a(this.b, i, true);
    }

    private void j(int i) {
        i(i);
        this.b = a(this.b, i, false);
    }

    public final boolean b(int i) {
        i(i);
        return ((1 << (15 - i)) & this.b) != 0;
    }

    private boolean[] g() {
        boolean[] zArr = new boolean[16];
        for (int i = 0; i < 16; i++) {
            if (h(i)) {
                zArr[i] = b(i);
            }
        }
        return zArr;
    }

    public final int b() {
        int i;
        int i2 = this.a;
        if (i2 >= 0) {
            return i2;
        }
        synchronized (this) {
            if (this.a < 0) {
                this.a = d.nextInt(MinElf.PN_XNUM);
            }
            i = this.a;
        }
        return i;
    }

    private void k(int i) {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("DNS message ID " + i + " is out of range");
        }
        this.a = i;
    }

    private void l(int i) {
        if (i < 0 || i > 15) {
            throw new IllegalArgumentException("DNS Rcode " + i + " is out of range");
        }
        int i2 = this.b & -16;
        this.b = i2;
        this.b = i | i2;
    }

    public final int c() {
        return this.b & 15;
    }

    public final void c(int i) {
        if (i < 0 || i > 15) {
            throw new IllegalArgumentException("DNS Opcode " + i + "is out of range");
        }
        int i2 = this.b & 34815;
        this.b = i2;
        this.b = (i << 11) | i2;
    }

    public final int d() {
        return (this.b >> 11) & 15;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i, int i2) {
        this.c[i] = 0;
    }

    /* access modifiers changed from: package-private */
    public final void d(int i) {
        int[] iArr = this.c;
        if (iArr[i] != 65535) {
            iArr[i] = iArr[i] + 1;
            return;
        }
        throw new IllegalStateException("DNS section count cannot be incremented");
    }

    /* access modifiers changed from: package-private */
    public final void e(int i) {
        int[] iArr = this.c;
        if (iArr[i] != 0) {
            iArr[i] = iArr[i] - 1;
            return;
        }
        throw new IllegalStateException("DNS section count cannot be decremented");
    }

    public final int f(int i) {
        return this.c[i];
    }

    /* access modifiers changed from: package-private */
    public final int e() {
        return this.b;
    }

    private String h() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            if (h(i) && b(i)) {
                stringBuffer.append(ac.a(i));
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public final String g(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(";; ->>HEADER<<- ");
        stringBuffer.append("opcode: " + bq.a(d()));
        stringBuffer.append(", status: " + bz.a(i));
        stringBuffer.append(", id: " + b());
        stringBuffer.append("\n");
        stringBuffer.append(";; flags: " + h());
        stringBuffer.append("; ");
        for (int i2 = 0; i2 < 4; i2++) {
            stringBuffer.append(co.a(i2) + ": " + this.c[i2] + " ");
        }
        return stringBuffer.toString();
    }

    public final Object clone() {
        ai aiVar = new ai();
        aiVar.a = this.a;
        aiVar.b = this.b;
        int[] iArr = this.c;
        System.arraycopy(iArr, 0, aiVar.c, 0, iArr.length);
        return aiVar;
    }

    public final String toString() {
        return g(this.b & 15);
    }
}
