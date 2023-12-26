package com.bonree.sdk.bc;

import com.bonree.sdk.ab.i;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class l extends y {
    private static final long a = -3868158449890266347L;
    private int b;
    private int c;
    private int d;
    private InetAddress e;

    l() {
        super(8);
    }

    private static int a(String str, int i, int i2) {
        int a2 = i.a(i) << 3;
        if (i2 >= 0 && i2 <= a2) {
            return i2;
        }
        throw new IllegalArgumentException("\"" + str + "\" " + i2 + " must be in the range [0.." + a2 + "]");
    }

    private l(int i, int i2, InetAddress inetAddress) {
        super(8);
        int a2 = i.a(inetAddress);
        this.b = a2;
        this.c = a("source netmask", a2, i);
        this.d = a("scope netmask", this.b, 0);
        InetAddress a3 = i.a(inetAddress, i);
        this.e = a3;
        if (!inetAddress.equals(a3)) {
            throw new IllegalArgumentException("source netmask is not valid for address");
        }
    }

    private l(int i, InetAddress inetAddress) {
        this(i, 0, inetAddress);
    }

    private int c() {
        return this.b;
    }

    private int d() {
        return this.c;
    }

    private int e() {
        return this.d;
    }

    private InetAddress f() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws Cdo {
        int h = tVar.h();
        this.b = h;
        if (h == 1 || h == 2) {
            int g = tVar.g();
            this.c = g;
            if (g <= (i.a(this.b) << 3)) {
                int g2 = tVar.g();
                this.d = g2;
                if (g2 <= (i.a(this.b) << 3)) {
                    byte[] j = tVar.j();
                    if (j.length == (this.c + 7) / 8) {
                        byte[] bArr = new byte[i.a(this.b)];
                        System.arraycopy(j, 0, bArr, 0, j.length);
                        try {
                            InetAddress byAddress = InetAddress.getByAddress(bArr);
                            this.e = byAddress;
                            if (!i.a(byAddress, this.c).equals(this.e)) {
                                throw new Cdo("invalid padding");
                            }
                        } catch (UnknownHostException e2) {
                            throw new Cdo("invalid address", e2);
                        }
                    } else {
                        throw new Cdo("invalid address");
                    }
                } else {
                    throw new Cdo("invalid scope netmask");
                }
            } else {
                throw new Cdo("invalid source netmask");
            }
        } else {
            throw new Cdo("unknown address family");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar) {
        vVar.c(this.b);
        vVar.b(this.c);
        vVar.b(this.d);
        vVar.a(this.e.getAddress(), 0, (this.c + 7) / 8);
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.e.getHostAddress());
        stringBuffer.append("/");
        stringBuffer.append(this.c);
        stringBuffer.append(", scope netmask ");
        stringBuffer.append(this.d);
        return stringBuffer.toString();
    }
}
