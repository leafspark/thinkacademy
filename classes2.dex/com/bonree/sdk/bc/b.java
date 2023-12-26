package com.bonree.sdk.bc;

import com.bonree.sdk.ab.i;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class b extends ca {
    private static final long a = -4588601512069748050L;
    private byte[] b;

    b() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new b();
    }

    private b(bn bnVar, int i, long j, InetAddress inetAddress) {
        super(bnVar, 28, i, j);
        if (i.a(inetAddress) == 2) {
            this.b = inetAddress.getAddress();
            return;
        }
        throw new IllegalArgumentException("invalid IPv6 address");
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.d(16);
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = ddVar.a(2);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        try {
            InetAddress byAddress = InetAddress.getByAddress((String) null, this.b);
            if (byAddress.getAddress().length != 4) {
                return byAddress.getHostAddress();
            }
            StringBuffer stringBuffer = new StringBuffer("0:0:0:0:0:ffff:");
            byte[] bArr = this.b;
            int i = ((bArr[12] & 255) << 8) + (bArr[13] & 255);
            int i2 = ((bArr[14] & 255) << 8) + (bArr[15] & 255);
            stringBuffer.append(Integer.toHexString(i));
            stringBuffer.append(':');
            stringBuffer.append(Integer.toHexString(i2));
            return stringBuffer.toString();
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    public final InetAddress b_() {
        try {
            if (this.f == null) {
                return InetAddress.getByAddress(this.b);
            }
            return InetAddress.getByAddress(this.f.toString(), this.b);
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.a(this.b);
    }
}
