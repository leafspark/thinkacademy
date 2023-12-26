package com.bonree.sdk.bc;

import com.facebook.soloader.MinElf;
import java.io.IOException;
import java.util.Arrays;

public abstract class y {
    private final int a;

    /* access modifiers changed from: package-private */
    public abstract String a();

    /* access modifiers changed from: package-private */
    public abstract void a(t tVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void a(v vVar);

    public static class a {
        private static int a = 3;
        private static int b = 8;
        private static bc c;

        private a() {
        }

        static {
            bc bcVar = new bc("EDNS Option Codes", 2);
            c = bcVar;
            bcVar.b((int) MinElf.PN_XNUM);
            c.a("CODE");
            c.a(true);
            c.a(3, "NSID");
            c.a(8, "CLIENT_SUBNET");
        }

        public static String a(int i) {
            return c.d(i);
        }

        private static int a(String str) {
            return c.b(str);
        }
    }

    public y(int i) {
        this.a = ca.b("code", i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append(a.a(this.a));
        stringBuffer.append(": ");
        stringBuffer.append(a());
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public final int b() {
        return this.a;
    }

    private byte[] c() {
        v vVar = new v();
        a(vVar);
        return vVar.d();
    }

    static y b(t tVar) throws IOException {
        y yVar;
        int h = tVar.h();
        int h2 = tVar.h();
        if (tVar.b() >= h2) {
            int d = tVar.d();
            tVar.a(h2);
            if (h == 3) {
                yVar = new bj();
            } else if (h != 8) {
                yVar = new ag(h);
            } else {
                yVar = new l();
            }
            yVar.a(tVar);
            tVar.b(d);
            return yVar;
        }
        throw new Cdo("truncated option");
    }

    private static y a(byte[] bArr) throws IOException {
        return b(new t(bArr));
    }

    /* access modifiers changed from: package-private */
    public final void b(v vVar) {
        vVar.c(this.a);
        int a2 = vVar.a();
        vVar.c(0);
        a(vVar);
        vVar.a((vVar.a() - a2) - 2, a2);
    }

    private byte[] d() throws IOException {
        v vVar = new v();
        b(vVar);
        return vVar.d();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (this.a != yVar.a) {
            return false;
        }
        return Arrays.equals(c(), yVar.c());
    }

    public int hashCode() {
        int i = 0;
        for (byte b : c()) {
            i += (i << 3) + (b & 255);
        }
        return i;
    }
}
