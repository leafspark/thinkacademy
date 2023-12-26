package com.bonree.sdk.bc;

import com.bonree.sdk.ac.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class be extends ca {
    private static final long a = -1037209403185658593L;
    private byte[] b;

    be() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new be();
    }

    private static final byte[] b(String str) {
        if (!str.substring(0, 2).equalsIgnoreCase("0x")) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        int i = 0;
        for (int i2 = 2; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != '.') {
                int digit = Character.digit(charAt, 16);
                if (digit == -1) {
                    return null;
                }
                if (z) {
                    i += digit;
                    byteArrayOutputStream.write(i);
                    z = false;
                } else {
                    i = digit << 4;
                    z = true;
                }
            }
        }
        if (z) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private be(bn bnVar, int i, long j, String str) {
        super(bnVar, 22, i, j);
        byte[] b2 = b(str);
        this.b = b2;
        if (b2 == null) {
            throw new IllegalArgumentException("invalid NSAP address " + str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        String c = ddVar.c();
        byte[] b2 = b(c);
        this.b = b2;
        if (b2 == null) {
            throw ddVar.a("invalid NSAP address " + c);
        }
    }

    private String d() {
        return a(this.b, false);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.a(this.b);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return "0x" + e.a(this.b);
    }
}
