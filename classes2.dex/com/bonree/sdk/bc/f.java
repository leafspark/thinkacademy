package com.bonree.sdk.bc;

import com.bonree.sdk.ab.i;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class f extends ca {
    private static final long a = -2172609200849142323L;
    private int b;

    private static final byte[] b(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    f() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new f();
    }

    private static final int b(byte[] bArr) {
        return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8);
    }

    private f(bn bnVar, int i, long j, InetAddress inetAddress) {
        super(bnVar, 1, i, j);
        if (i.a(inetAddress) == 1) {
            this.b = b(inetAddress.getAddress());
            return;
        }
        throw new IllegalArgumentException("invalid IPv4 address");
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = b(tVar.d(4));
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = b(ddVar.a(1));
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return i.a(b(this.b));
    }

    public final InetAddress c_() {
        try {
            if (this.f == null) {
                return InetAddress.getByAddress(b(this.b));
            }
            return InetAddress.getByAddress(this.f.toString(), b(this.b));
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.a(((long) this.b) & 4294967295L);
    }
}
