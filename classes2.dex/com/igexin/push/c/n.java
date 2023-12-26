package com.igexin.push.c;

import android.text.TextUtils;
import com.igexin.push.core.d;

public class n extends o implements r {
    private static n e;

    private n() {
        super(d.am, d.ao);
        this.d.a(false);
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            if (e == null) {
                e = new n();
            }
            nVar = e;
        }
        return nVar;
    }

    public void a(g gVar, j jVar) {
        k a;
        if (jVar != null && !TextUtils.isEmpty(jVar.a()) && (a = a(jVar.a())) != null) {
            b(jVar);
            a.d();
            l();
            if (gVar == g.SUCCESS) {
                k();
            }
        }
    }

    public void a(j jVar) {
    }

    public h b() {
        return h.MOBILE;
    }

    public r c() {
        return this;
    }
}
