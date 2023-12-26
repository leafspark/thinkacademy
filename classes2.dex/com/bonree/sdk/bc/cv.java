package com.bonree.sdk.bc;

import com.bonree.sdk.ac.f;
import com.didi.hummer.adapter.http.IHttpAdapter;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.Date;

public final class cv extends ca {
    private static final long a = 8828458121926391756L;
    private static int m = 1;
    private static int n = 2;
    private static int o = 3;
    private static int p = 4;
    private static int q = 5;
    private bn b;
    private Date c;
    private Date d;
    private int e;
    private int j;
    private byte[] k;
    private byte[] l;

    cv() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new cv();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private cv(bn bnVar, int i, long j2, bn bnVar2, Date date, Date date2, int i2, int i3, byte[] bArr, byte[] bArr2) {
        super(bnVar, 249, i, j2);
        this.b = a(bnVar2);
        this.c = date;
        this.d = date2;
        int i4 = i2;
        this.e = b(HummerStyleUtils.Hummer.MODE, i2);
        this.j = b(Constants.IPC_BUNDLE_KEY_SEND_ERROR, i3);
        this.k = bArr;
        this.l = bArr2;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = new bn(tVar);
        this.c = new Date(tVar.i() * 1000);
        this.d = new Date(tVar.i() * 1000);
        this.e = tVar.h();
        this.j = tVar.h();
        int h = tVar.h();
        if (h > 0) {
            this.k = tVar.d(h);
        } else {
            this.k = null;
        }
        int h2 = tVar.h();
        if (h2 > 0) {
            this.l = tVar.d(h2);
        } else {
            this.l = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        throw ddVar.a("no text format defined for TKEY");
    }

    private String d() {
        int i = this.e;
        if (i == 1) {
            return "SERVERASSIGNED";
        }
        if (i == 2) {
            return "DIFFIEHELLMAN";
        }
        if (i == 3) {
            return "GSSAPI";
        }
        if (i != 4) {
            return i != 5 ? Integer.toString(i) : IHttpAdapter.METHOD_DELETE;
        }
        return "RESOLVERASSIGNED";
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        if (br.a("multiline")) {
            stringBuffer.append("(\n\t");
        }
        stringBuffer.append(ad.a(this.c));
        stringBuffer.append(" ");
        stringBuffer.append(ad.a(this.d));
        stringBuffer.append(" ");
        int i = this.e;
        if (i != 1) {
            str = i != 2 ? i != 3 ? i != 4 ? i != 5 ? Integer.toString(i) : IHttpAdapter.METHOD_DELETE : "RESOLVERASSIGNED" : "GSSAPI" : "DIFFIEHELLMAN";
        } else {
            str = "SERVERASSIGNED";
        }
        stringBuffer.append(str);
        stringBuffer.append(" ");
        stringBuffer.append(bz.b(this.j));
        if (br.a("multiline")) {
            stringBuffer.append("\n");
            byte[] bArr = this.k;
            if (bArr != null) {
                stringBuffer.append(f.a(bArr, 64, "\t", false));
                stringBuffer.append("\n");
            }
            byte[] bArr2 = this.l;
            if (bArr2 != null) {
                stringBuffer.append(f.a(bArr2, 64, "\t", false));
            }
            stringBuffer.append(" )");
        } else {
            stringBuffer.append(" ");
            byte[] bArr3 = this.k;
            if (bArr3 != null) {
                stringBuffer.append(f.a(bArr3));
                stringBuffer.append(" ");
            }
            byte[] bArr4 = this.l;
            if (bArr4 != null) {
                stringBuffer.append(f.a(bArr4));
            }
        }
        return stringBuffer.toString();
    }

    private bn e() {
        return this.b;
    }

    private Date f() {
        return this.c;
    }

    private Date g() {
        return this.d;
    }

    private int h() {
        return this.e;
    }

    private int i() {
        return this.j;
    }

    private byte[] j() {
        return this.k;
    }

    private byte[] k() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        this.b.a(vVar, (m) null, z);
        vVar.a(this.c.getTime() / 1000);
        vVar.a(this.d.getTime() / 1000);
        vVar.c(this.e);
        vVar.c(this.j);
        byte[] bArr = this.k;
        if (bArr != null) {
            vVar.c(bArr.length);
            vVar.a(this.k);
        } else {
            vVar.c(0);
        }
        byte[] bArr2 = this.l;
        if (bArr2 != null) {
            vVar.c(bArr2.length);
            vVar.a(this.l);
            return;
        }
        vVar.c(0);
    }
}
