package com.bonree.sdk.bn;

import com.bonree.sdk.am.k;
import com.bonree.sdk.bn.a;
import java.nio.charset.StandardCharsets;

public final class e extends c {
    private static e b;

    static {
        new e();
    }

    private e() {
        this(new byte[0]);
    }

    public e(byte[] bArr) {
        super(bArr);
    }

    public final a.b a() {
        return a.b.NSID;
    }

    /* access modifiers changed from: protected */
    public final CharSequence b() {
        return (a.b.NSID + ": ") + new String(this.a, StandardCharsets.US_ASCII);
    }

    /* access modifiers changed from: protected */
    public final CharSequence d() {
        return k.a(this.a);
    }
}
