package com.bonree.sdk.bc;

import com.bonree.sdk.ab.i;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class a extends ca {
    private static final long a = -8815026887337346789L;
    private int b;
    private InetAddress c;
    private bn d;

    a() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new a();
    }

    private a(bn bnVar, int i, long j, int i2, InetAddress inetAddress, bn bnVar2) {
        super(bnVar, 38, i, j);
        this.b = a("prefixBits", i2);
        if (inetAddress == null || i.a(inetAddress) == 2) {
            this.c = inetAddress;
            if (bnVar2 != null) {
                this.d = a(bnVar2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid IPv6 address");
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        int g = tVar.g();
        this.b = g;
        int i = ((128 - g) + 7) / 8;
        if (g < 128) {
            byte[] bArr = new byte[16];
            tVar.a(bArr, 16 - i, i);
            this.c = InetAddress.getByAddress(bArr);
        }
        if (this.b > 0) {
            this.d = new bn(tVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        int h = ddVar.h();
        this.b = h;
        if (h <= 128) {
            if (h < 128) {
                String c2 = ddVar.c();
                try {
                    this.c = i.b(c2, 2);
                } catch (UnknownHostException unused) {
                    throw ddVar.a("invalid IPv6 address: " + c2);
                }
            }
            if (this.b > 0) {
                this.d = ddVar.a(bnVar);
                return;
            }
            return;
        }
        throw ddVar.a("prefix bits must be [0..128]");
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        if (this.c != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.c.getHostAddress());
        }
        if (this.d != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.d);
        }
        return stringBuffer.toString();
    }

    private int d() {
        return this.b;
    }

    private InetAddress e() {
        return this.c;
    }

    private bn f() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(this.b);
        InetAddress inetAddress = this.c;
        if (inetAddress != null) {
            int i = ((128 - this.b) + 7) / 8;
            vVar.a(inetAddress.getAddress(), 16 - i, i);
        }
        bn bnVar = this.d;
        if (bnVar != null) {
            bnVar.a(vVar, (m) null, z);
        }
    }
}
