package com.bonree.sdk.bp;

import com.bonree.sdk.bk.a;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public abstract class u extends h {
    public final a a;
    @Deprecated
    private a b;

    public final void a(DataOutputStream dataOutputStream) throws IOException {
        this.a.a((OutputStream) dataOutputStream);
    }

    protected u(a aVar) {
        this.a = aVar;
        this.b = aVar;
    }

    public String toString() {
        return this.a + ".";
    }

    private a d() {
        return this.a;
    }
}
