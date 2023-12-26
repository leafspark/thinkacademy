package com.bonree.sdk.bc;

import com.bonree.sdk.ac.f;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;

public final class aj extends ca {
    private static final long a = 3050449702765909687L;
    private int b;
    private int c;
    private int d;
    private Object e;
    private byte[] j;

    public static class a {
        private static int a = 1;
        private static int b = 2;

        private a() {
        }
    }

    public static class b {
        private static int a = 0;
        private static int b = 1;
        private static int c = 2;
        private static int d = 3;

        private b() {
        }
    }

    aj() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new aj();
    }

    private aj(bn bnVar, int i, long j2, int i2, int i3, int i4, Object obj, byte[] bArr) {
        super(bnVar, 45, i, j2);
        this.b = a("precedence", i2);
        this.c = a("gatewayType", i3);
        this.d = a("algorithmType", i4);
        if (i3 == 0) {
            this.e = null;
        } else if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new IllegalArgumentException("\"gatewayType\" must be between 0 and 3");
                } else if (obj instanceof bn) {
                    this.e = a((bn) obj);
                } else {
                    throw new IllegalArgumentException("\"gateway\" must be a DNS name");
                }
            } else if (obj instanceof Inet6Address) {
                this.e = obj;
            } else {
                throw new IllegalArgumentException("\"gateway\" must be an IPv6 address");
            }
        } else if (obj instanceof InetAddress) {
            this.e = obj;
        } else {
            throw new IllegalArgumentException("\"gateway\" must be an IPv4 address");
        }
        this.j = bArr;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.g();
        this.c = tVar.g();
        this.d = tVar.g();
        int i = this.c;
        if (i == 0) {
            this.e = null;
        } else if (i == 1) {
            this.e = InetAddress.getByAddress(tVar.d(4));
        } else if (i == 2) {
            this.e = InetAddress.getByAddress(tVar.d(16));
        } else if (i == 3) {
            this.e = new bn(tVar);
        } else {
            throw new Cdo("invalid gateway type");
        }
        if (tVar.b() > 0) {
            this.j = tVar.j();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.h();
        this.c = ddVar.h();
        this.d = ddVar.h();
        int i = this.c;
        if (i != 0) {
            if (i == 1) {
                this.e = ddVar.b(1);
            } else if (i == 2) {
                this.e = ddVar.b(2);
            } else if (i == 3) {
                this.e = ddVar.a(bnVar);
            } else {
                throw new Cdo("invalid gateway type");
            }
        } else if (ddVar.c().equals(".")) {
            this.e = null;
        } else {
            throw new dc("invalid gateway format");
        }
        this.j = ddVar.a(false);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.b);
        stringBuffer.append(" ");
        stringBuffer.append(this.c);
        stringBuffer.append(" ");
        stringBuffer.append(this.d);
        stringBuffer.append(" ");
        int i = this.c;
        if (i == 0) {
            stringBuffer.append(".");
        } else if (i == 1 || i == 2) {
            stringBuffer.append(((InetAddress) this.e).getHostAddress());
        } else if (i == 3) {
            stringBuffer.append(this.e);
        }
        if (this.j != null) {
            stringBuffer.append(" ");
            stringBuffer.append(f.a(this.j));
        }
        return stringBuffer.toString();
    }

    private int d() {
        return this.b;
    }

    private int e() {
        return this.c;
    }

    private int f() {
        return this.d;
    }

    private Object g() {
        return this.e;
    }

    private byte[] h() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(this.b);
        vVar.b(this.c);
        vVar.b(this.d);
        int i = this.c;
        if (i == 1 || i == 2) {
            vVar.a(((InetAddress) this.e).getAddress());
        } else if (i == 3) {
            ((bn) this.e).a(vVar, (m) null, z);
        }
        byte[] bArr = this.j;
        if (bArr != null) {
            vVar.a(bArr);
        }
    }
}
