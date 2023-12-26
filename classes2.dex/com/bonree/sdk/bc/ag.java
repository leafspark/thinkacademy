package com.bonree.sdk.bc;

import com.bonree.sdk.ac.e;
import com.facebook.soloader.MinElf;
import java.io.IOException;

public class ag extends y {
    private byte[] a;

    ag(int i) {
        super(i);
    }

    public ag(int i, byte[] bArr) {
        super(3);
        this.a = ca.a("option data", bArr, (int) MinElf.PN_XNUM);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.a = tVar.j();
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar) {
        vVar.a(this.a);
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return "<" + e.a(this.a) + ">";
    }
}
