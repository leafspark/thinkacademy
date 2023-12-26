package com.igexin.push.core.c;

import com.igexin.push.core.d;
import com.igexin.push.f.b;

class c extends b {
    final /* synthetic */ byte[] a;
    final /* synthetic */ b b;

    c(b bVar, byte[] bArr) {
        this.b = bVar;
        this.a = bArr;
    }

    /* access modifiers changed from: protected */
    public void a() {
        com.igexin.push.util.c.a(this.a, d.g.getFilesDir().getPath() + "/" + "conf_n.pid", false);
    }
}
