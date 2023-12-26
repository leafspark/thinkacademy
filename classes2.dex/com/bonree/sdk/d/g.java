package com.bonree.sdk.d;

import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.c;
import com.bonree.sdk.d.e;

final class g implements c.a {
    private /* synthetic */ e.a a;

    g(e.a aVar) {
        this.a = aVar;
    }

    public final Object a() {
        if (e.this.a != null) {
            e.this.a.c("JVM exit upload start:", new Object[0]);
        }
        int a2 = e.this.f.a(6);
        if (e.this.a == null) {
            return null;
        }
        f a3 = e.this.a;
        a3.c("JVM exit upload result: " + a2, new Object[0]);
        return null;
    }
}
