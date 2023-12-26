package com.bonree.sdk.bc;

import com.bonree.sdk.ac.f;
import com.bonree.sdk.bc.w;
import com.facebook.soloader.MinElf;
import java.io.IOException;

public final class h extends ca {
    private static int a = 1;
    private static int b = 2;
    private static int c = 3;
    private static int d = 253;
    private static int e = 254;
    private static final long j = 4763014646517016835L;
    private int k;
    private int l;
    private int m;
    private byte[] n;

    public static class a {
        private static int a = 1;
        private static int b = 2;
        private static int c = 3;
        private static int d = 4;
        private static int e = 5;
        private static int f = 6;
        private static int g = 7;
        private static int h = 8;
        private static int i = 253;
        private static int j = 254;
        private static bc k;

        private a() {
        }

        static {
            bc bcVar = new bc("Certificate type", 2);
            k = bcVar;
            bcVar.b((int) MinElf.PN_XNUM);
            k.a(true);
            k.a(1, "PKIX");
            k.a(2, "SPKI");
            k.a(3, "PGP");
            k.a(1, "IPKIX");
            k.a(2, "ISPKI");
            k.a(3, "IPGP");
            k.a(3, "ACPKIX");
            k.a(3, "IACPKIX");
            k.a(253, "URI");
            k.a(254, "OID");
        }

        private static String a(int i2) {
            return k.d(i2);
        }

        public static int a(String str) {
            return k.b(str);
        }
    }

    h() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new h();
    }

    private h(bn bnVar, int i, long j2, int i2, int i3, int i4, byte[] bArr) {
        super(bnVar, 37, i, j2);
        this.k = b("certType", i2);
        this.l = b("keyTag", i3);
        this.m = a("alg", i4);
        this.n = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.k = tVar.h();
        this.l = tVar.h();
        this.m = tVar.g();
        this.n = tVar.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        String c2 = ddVar.c();
        int a2 = a.a(c2);
        this.k = a2;
        if (a2 >= 0) {
            this.l = ddVar.g();
            String c3 = ddVar.c();
            int a3 = w.a.a(c3);
            this.m = a3;
            if (a3 >= 0) {
                this.n = ddVar.l();
                return;
            }
            throw ddVar.a("Invalid algorithm: " + c3);
        }
        throw ddVar.a("Invalid certificate type: " + c2);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.k);
        stringBuffer.append(" ");
        stringBuffer.append(this.l);
        stringBuffer.append(" ");
        stringBuffer.append(this.m);
        if (this.n != null) {
            if (br.a("multiline")) {
                stringBuffer.append(" (\n");
                stringBuffer.append(f.a(this.n, 64, "\t", true));
            } else {
                stringBuffer.append(" ");
                stringBuffer.append(f.a(this.n));
            }
        }
        return stringBuffer.toString();
    }

    private int d() {
        return this.k;
    }

    private int e() {
        return this.l;
    }

    private int f() {
        return this.m;
    }

    private byte[] g() {
        return this.n;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.c(this.k);
        vVar.c(this.l);
        vVar.b(this.m);
        vVar.a(this.n);
    }
}
