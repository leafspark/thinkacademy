package com.bonree.sdk.bc;

import java.io.IOException;

public final class dp extends ca {
    private static final long a = 4267576252335579764L;
    private byte[] b;

    dp() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new dp();
    }

    private static final byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (!Character.isDigit(charAt)) {
                return null;
            }
            bArr[i] = (byte) charAt;
        }
        return bArr;
    }

    private dp(bn bnVar, int i, long j, String str) {
        super(bnVar, 19, i, j);
        byte[] b2 = b(str);
        this.b = b2;
        if (b2 == null) {
            throw new IllegalArgumentException("invalid PSDN address " + str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = tVar.k();
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        String c = ddVar.c();
        byte[] b2 = b(c);
        this.b = b2;
        if (b2 == null) {
            throw ddVar.a("invalid PSDN address " + c);
        }
    }

    private String d() {
        return a(this.b, false);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        vVar.b(this.b);
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return a(this.b, true);
    }
}
