package com.bonree.sdk.f;

import java.io.Serializable;

public final class c implements Serializable {
    private String a;
    private byte[] b;
    private String c;

    public c(String str, byte[] bArr, String str2) {
        this.a = str;
        this.b = bArr;
        this.c = str2;
    }

    public final String a() {
        return this.c;
    }

    private void a(String str) {
        this.c = str;
    }

    public final String b() {
        String str = this.a;
        return str == null ? "" : str;
    }

    private void b(String str) {
        this.a = str;
    }

    public final byte[] c() {
        return this.b;
    }

    public final void a(byte[] bArr) {
        this.b = bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d() {
        /*
            r2 = this;
            java.lang.String r0 = r2.a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0011
            byte[] r0 = r2.b
            if (r0 == 0) goto L_0x0011
            int r0 = r0.length
            r1 = 1
            if (r0 <= r1) goto L_0x0011
            return r1
        L_0x0011:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.f.c.d():boolean");
    }
}
