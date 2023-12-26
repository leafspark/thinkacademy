package com.bonree.sdk.bc;

import android.text.TextUtils;
import com.bonree.sdk.ac.f;
import com.bonree.sdk.bc.u;
import java.io.Serializable;
import java.util.Date;

public final class cx {
    private static final String a = "HMAC-MD5.SIG-ALG.REG.INT.";
    private static final String b = "hmac-sha1.";
    private static final String c = "hmac-sha224.";
    private static final String d = "hmac-sha256.";
    private static final String e = "hmac-sha384.";
    private static final String f = "hmac-sha512.";
    private static bn g = bn.b(a);
    private static bn h = null;
    private static bn i = bn.b(b);
    private static bn j = bn.b(c);
    private static bn k = bn.b(d);
    private static bn l = bn.b(e);
    private static bn m = bn.b(f);
    private static short n = 300;
    /* access modifiers changed from: private */
    public bn o;
    /* access modifiers changed from: private */
    public bn p;
    /* access modifiers changed from: private */
    public String q;
    /* access modifiers changed from: private */
    public int r;
    /* access modifiers changed from: private */
    public byte[] s;

    private void b() {
        if (this.p.equals(g)) {
            this.q = "md5";
            this.r = 64;
        } else if (this.p.equals(i)) {
            this.q = "sha-1";
            this.r = 64;
        } else if (this.p.equals(j)) {
            this.q = "sha-224";
            this.r = 64;
        } else if (this.p.equals(k)) {
            this.q = "sha-256";
            this.r = 64;
        } else if (this.p.equals(m)) {
            this.q = "sha-512";
            this.r = 128;
        } else if (this.p.equals(l)) {
            this.q = "sha-384";
            this.r = 128;
        } else {
            throw new IllegalArgumentException("Invalid algorithm");
        }
    }

    private cx(bn bnVar, bn bnVar2, byte[] bArr) {
        this.o = bnVar2;
        this.p = bnVar;
        this.s = bArr;
        b();
    }

    private cx(bn bnVar, byte[] bArr) {
        this(g, bnVar, bArr);
    }

    private cx(bn bnVar, String str, String str2) {
        byte[] a2 = f.a(str2);
        this.s = a2;
        if (a2 != null) {
            try {
                this.o = bn.a(str, bn.a);
                this.p = bnVar;
                b();
            } catch (dc unused) {
                throw new IllegalArgumentException("Invalid TSIG key name");
            }
        } else {
            throw new IllegalArgumentException("Invalid TSIG key string");
        }
    }

    private cx(String str, String str2, String str3) {
        this(g, str2, str3);
        if (str.equalsIgnoreCase("hmac-md5")) {
            this.p = g;
        } else if (str.equalsIgnoreCase("hmac-sha1")) {
            this.p = i;
        } else if (str.equalsIgnoreCase("hmac-sha224")) {
            this.p = j;
        } else if (str.equalsIgnoreCase("hmac-sha256")) {
            this.p = k;
        } else if (str.equalsIgnoreCase("hmac-sha384")) {
            this.p = l;
        } else if (str.equalsIgnoreCase("hmac-sha512")) {
            this.p = m;
        } else {
            throw new IllegalArgumentException("Invalid TSIG algorithm");
        }
        b();
    }

    private cx(String str, String str2) {
        this(g, str, str2);
    }

    private static cx a(String str) {
        String[] split = str.split("[:/]", 3);
        if (split.length >= 2) {
            if (split.length == 3) {
                try {
                    return new cx(split[0], split[1], split[2]);
                } catch (IllegalArgumentException unused) {
                    split = str.split("[:/]", 2);
                }
            }
            return new cx(g, split[0], split[1]);
        }
        throw new IllegalArgumentException("Invalid TSIG key specification");
    }

    public final cy a(bb bbVar, byte[] bArr, int i2, cy cyVar) {
        Date date;
        u.b bVar;
        byte[] bArr2;
        int i3 = i2;
        if (i3 != 18) {
            date = new Date();
        } else {
            date = cyVar.e();
        }
        Date date2 = date;
        if (i3 == 0 || i3 == 18) {
            bVar = new u.b(this.q, this.r, this.s);
        } else {
            bVar = null;
        }
        int b2 = br.b("tsigfudge");
        if (b2 < 0 || b2 > 32767) {
            b2 = 300;
        }
        int i4 = b2;
        if (cyVar != null) {
            v vVar = new v();
            vVar.c(cyVar.g().length);
            if (bVar != null) {
                bVar.a(vVar.d());
                bVar.a(cyVar.g());
            }
        }
        if (bVar != null) {
            bVar.a(bArr);
        }
        v vVar2 = new v();
        this.o.a(vVar2);
        vVar2.c(255);
        vVar2.a(0);
        this.p.a(vVar2);
        long time = date2.getTime() / 1000;
        vVar2.c((int) (time >> 32));
        vVar2.a(time & 4294967295L);
        vVar2.c(i4);
        vVar2.c(i3);
        vVar2.c(0);
        if (bVar != null) {
            bVar.a(vVar2.d());
        }
        byte[] a2 = bVar != null ? bVar.a() : new byte[0];
        if (i3 == 18) {
            v vVar3 = new v();
            long time2 = new Date().getTime() / 1000;
            vVar3.c((int) (time2 >> 32));
            vVar3.a(time2 & 4294967295L);
            bArr2 = vVar3.d();
        } else {
            bArr2 = null;
        }
        return new cy(this.o, 255, 0, this.p, date2, i4, a2, bbVar.a().b(), i2, bArr2);
    }

    private void a(bb bbVar, int i2, cy cyVar) {
        bbVar.a((ca) a(bbVar, bbVar.g(), 0, cyVar), 3);
        bbVar.b = 3;
    }

    public final void a(bb bbVar, cy cyVar) {
        a(bbVar, 0, cyVar);
    }

    private byte b(bb bbVar, byte[] bArr, cy cyVar) {
        bbVar.b = 4;
        cy c2 = bbVar.c();
        u.b bVar = new u.b(this.q, this.r, this.s);
        if (c2 == null) {
            return 1;
        }
        if (!c2.o().equals(this.o) || !c2.d().equals(this.p)) {
            if (br.a("verbose")) {
                System.err.println("BADKEY failure");
            }
            return 17;
        }
        if (Math.abs(System.currentTimeMillis() - c2.e().getTime()) <= ((long) c2.f()) * 1000) {
            if (!(cyVar == null || c2.h() == 17 || c2.h() == 16)) {
                v vVar = new v();
                vVar.c(cyVar.g().length);
                bVar.a(vVar.d());
                bVar.a(cyVar.g());
            }
            bbVar.a().e(3);
            byte[] a2 = bbVar.a().a();
            bbVar.a().d(3);
            bVar.a(a2);
            bVar.a(bArr, a2.length, bbVar.a - a2.length);
            v vVar2 = new v();
            c2.o().a(vVar2);
            vVar2.c(c2.h);
            vVar2.a(c2.i);
            c2.d().a(vVar2);
            long time = c2.e().getTime() / 1000;
            vVar2.c((int) (time >> 32));
            vVar2.a(time & 4294967295L);
            vVar2.c(c2.f());
            vVar2.c(c2.h());
            if (c2.i() != null) {
                vVar2.c(c2.i().length);
                vVar2.a(c2.i());
            } else {
                vVar2.c(0);
            }
            bVar.a(vVar2.d());
            byte[] g2 = c2.g();
            int c3 = bVar.c();
            int i2 = this.q.equals("md5") ? 10 : c3 / 2;
            if (g2.length > c3) {
                if (br.a("verbose")) {
                    System.err.println("BADSIG: signature too long");
                }
                return 16;
            } else if (g2.length < i2) {
                if (br.a("verbose")) {
                    System.err.println("BADSIG: signature too short");
                }
                return 16;
            } else if (!bVar.a(g2, true)) {
                if (br.a("verbose")) {
                    System.err.println("BADSIG: signature verification");
                }
                return 16;
            } else {
                bbVar.b = 1;
                return 0;
            }
        } else if (!br.a("verbose")) {
            return 18;
        } else {
            System.err.println("BADTIME failure");
            return 18;
        }
    }

    public final int a(bb bbVar, byte[] bArr, cy cyVar) {
        return b(bbVar, bArr, cyVar);
    }

    public final int a() {
        return this.o.c() + 10 + this.p.c() + 8 + 18 + 4 + 8;
    }

    public static class a {
        private cx a;
        private u.b b;
        private int c;
        private int d;
        private cy e;

        public a(cx cxVar, cy cyVar) {
            this.a = cxVar;
            this.b = new u.b(cxVar.q, this.a.r, this.a.s);
            this.c = 0;
            this.e = cyVar;
        }

        public final int a(bb bbVar, byte[] bArr) {
            int i;
            int i2;
            cy c2 = bbVar.c();
            int i3 = this.c + 1;
            this.c = i3;
            if (i3 == 1) {
                int a2 = this.a.a(bbVar, bArr, this.e);
                if (a2 == 0) {
                    byte[] g = c2.g();
                    v vVar = new v();
                    vVar.c(g.length);
                    this.b.a(vVar.d());
                    this.b.a(g);
                }
                this.e = c2;
                return a2;
            }
            if (c2 != null) {
                bbVar.a().e(3);
            }
            byte[] a3 = bbVar.a().a();
            if (c2 != null) {
                bbVar.a().d(3);
            }
            this.b.a(a3);
            if (c2 == null) {
                i2 = bArr.length;
                i = a3.length;
            } else {
                i2 = bbVar.a;
                i = a3.length;
            }
            this.b.a(bArr, a3.length, i2 - i);
            if (c2 != null) {
                this.d = this.c;
                this.e = c2;
                if (!c2.o().equals(this.a.o) || !c2.d().equals(this.a.p)) {
                    if (br.a("verbose")) {
                        System.err.println("BADKEY failure");
                    }
                    bbVar.b = 4;
                    return 17;
                }
                v vVar2 = new v();
                long time = c2.e().getTime() / 1000;
                vVar2.c((int) (time >> 32));
                vVar2.a(time & 4294967295L);
                vVar2.c(c2.f());
                this.b.a(vVar2.d());
                if (!this.b.b(c2.g())) {
                    if (br.a("verbose")) {
                        System.err.println("BADSIG failure");
                    }
                    bbVar.b = 4;
                    return 16;
                }
                this.b.b();
                v vVar3 = new v();
                vVar3.c(c2.g().length);
                this.b.a(vVar3.d());
                this.b.a(c2.g());
                bbVar.b = 1;
                return 0;
            }
            if (this.c - this.d >= 100) {
                bbVar.b = 4;
                return 1;
            }
            bbVar.b = 2;
            return 0;
        }

        public a() {
        }

        public static String a(Serializable serializable) {
            String substring;
            if (serializable == null) {
                return "";
            }
            try {
                String[] split = serializable.toString().split("/");
                if (split != null && split.length == 2) {
                    if (!TextUtils.isEmpty(split[0])) {
                        return split[0];
                    }
                    if (split[1] != null) {
                        String str = split[1];
                        String str2 = ":" + b(serializable);
                        if (str.endsWith(str2) && (substring = str.substring(0, str.lastIndexOf(str2))) != null) {
                            return substring.contains("]") ? substring.split("]")[0].replace("[", "") : substring;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return "";
        }

        public static String a(Serializable serializable, int i) {
            if (serializable == null) {
                return "";
            }
            try {
                String obj = serializable.toString();
                String str = ":" + i;
                if (obj.endsWith(str)) {
                    obj = obj.substring(0, obj.lastIndexOf(str));
                }
                String[] split = obj.split("/");
                if (!(split == null || split.length != 2 || split[1] == null)) {
                    if (split[1].contains("]")) {
                        return split[1].split("]")[0].replace("[", "");
                    }
                    return split[1];
                }
            } catch (Throwable unused) {
            }
            return "";
        }

        private static int a(String str, String str2) {
            if (str.length() <= 0) {
                return 0;
            }
            String upperCase = str.toUpperCase();
            char charAt = str2.toUpperCase().charAt(0);
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (charAt == upperCase.charAt(i2)) {
                    i++;
                }
            }
            return i;
        }

        public static int b(Serializable serializable) {
            if (serializable == null) {
                return 80;
            }
            try {
                String[] split = serializable.toString().split(":");
                if (split != null && split.length > 1 && !TextUtils.isEmpty(split[split.length - 1])) {
                    return Integer.parseInt(split[split.length - 1]);
                }
            } catch (Throwable unused) {
            }
            return 80;
        }
    }

    private void a(bb bbVar, cy cyVar, boolean z) {
        if (z) {
            a(bbVar, 0, cyVar);
            return;
        }
        Date date = new Date();
        u.b bVar = new u.b(this.q, this.r, this.s);
        int b2 = br.b("tsigfudge");
        if (b2 < 0 || b2 > 32767) {
            b2 = 300;
        }
        int i2 = b2;
        v vVar = new v();
        vVar.c(cyVar.g().length);
        bVar.a(vVar.d());
        bVar.a(cyVar.g());
        bVar.a(bbVar.g());
        v vVar2 = new v();
        long time = date.getTime() / 1000;
        vVar2.c((int) (time >> 32));
        vVar2.a(time & 4294967295L);
        vVar2.c(i2);
        bVar.a(vVar2.d());
        bbVar.a((ca) new cy(this.o, 255, 0, this.p, date, i2, bVar.a(), bbVar.a().b(), 0, (byte[]) null), 3);
        bbVar.b = 3;
    }
}
