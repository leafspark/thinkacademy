package com.bonree.sdk.bc;

import java.io.IOException;

public final class ae extends ca {
    private static final long a = -6349714958085750705L;
    private byte[] b;
    private byte[] c;
    private byte[] d;

    ae() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new ae();
    }

    private static void a(double d2, double d3) throws IllegalArgumentException {
        if (d2 < -90.0d || d2 > 90.0d) {
            throw new IllegalArgumentException("illegal longitude " + d2);
        } else if (d3 < -180.0d || d3 > 180.0d) {
            throw new IllegalArgumentException("illegal latitude " + d3);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ae(bn bnVar, int i, long j, double d2, double d3, double d4) {
        super(bnVar, 27, i, j);
        a(d2, d3);
        this.c = Double.toString(d2).getBytes();
        this.b = Double.toString(d3).getBytes();
        this.d = Double.toString(d4).getBytes();
    }

    private ae(bn bnVar, int i, long j, String str, String str2, String str3) {
        super(bnVar, 27, i, j);
        try {
            this.c = a(str);
            this.b = a(str2);
            a(Double.parseDouble(d()), Double.parseDouble(f()));
            this.d = a(str3);
        } catch (dc e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.c = tVar.k();
        this.b = tVar.k();
        this.d = tVar.k();
        try {
            a(Double.parseDouble(d()), Double.parseDouble(f()));
        } catch (IllegalArgumentException e) {
            throw new Cdo(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        try {
            this.c = a(ddVar.c());
            this.b = a(ddVar.c());
            this.d = a(ddVar.c());
            try {
                a(Double.parseDouble(d()), Double.parseDouble(f()));
            } catch (IllegalArgumentException e) {
                throw new Cdo(e.getMessage());
            }
        } catch (dc e2) {
            throw ddVar.a(e2.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(this.c, true));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.b, true));
        stringBuffer.append(" ");
        stringBuffer.append(a(this.d, true));
        return stringBuffer.toString();
    }

    private String d() {
        return a(this.c, false);
    }

    private double e() {
        return Double.parseDouble(d());
    }

    private String f() {
        return a(this.b, false);
    }

    private double g() {
        return Double.parseDouble(f());
    }

    private String h() {
        return a(this.d, false);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(this.c);
        vVar.b(this.b);
        vVar.b(this.d);
    }

    private double i() {
        return Double.parseDouble(a(this.d, false));
    }
}
