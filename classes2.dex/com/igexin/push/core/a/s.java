package com.igexin.push.core.a;

import com.igexin.b.a.c.a.f;
import com.igexin.b.a.c.b;
import com.igexin.b.a.d.e;
import com.igexin.push.config.k;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import com.igexin.push.d.c.p;

public class s extends a {
    private static final String a = (k.a + "_RegisterFailResultAction");

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if ((obj instanceof p) && ((p) obj).a == 1) {
            b.a(a + "|Register failed because of the wrong appid", new Object[0]);
            f a2 = f.a();
            a2.a("Register failed because of the wrong appid = " + d.a);
            d.j = true;
            c.a().i().c();
        }
        return true;
    }
}
