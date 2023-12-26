package com.igexin.push.c;

import com.igexin.b.a.c.b;
import com.igexin.push.core.d;
import com.igexin.push.f.b.g;
import com.igexin.push.util.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class m extends g {
    public static final AtomicBoolean a = new AtomicBoolean(false);
    private static final String b = ("DT_" + m.class.getName());
    private static m c;
    private boolean e;

    private m() {
        super(10);
        this.n = true;
    }

    public static synchronized m c_() {
        m mVar;
        synchronized (m.class) {
            if (c == null) {
                c = new m();
            }
            mVar = c;
        }
        return mVar;
    }

    public void a(long j) {
        a(j, TimeUnit.MILLISECONDS);
    }

    public int b_() {
        return 20150607;
    }

    /* access modifiers changed from: protected */
    public void d_() {
        a(f.a, TimeUnit.MILLISECONDS);
        if (this.e) {
            b.a(b + "|detect task already stop", new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        String str = b;
        sb.append(str);
        sb.append("|");
        sb.append(f.a / 1000);
        sb.append("s passed, do task method, start redect ~~~~");
        b.a(sb.toString(), new Object[0]);
        d.i = a.h();
        if (d.i) {
            i.a().c();
            return;
        }
        b.a(str + "|" + (f.a / 1000) + "s passed, network is unavailable, stop ###", new Object[0]);
    }

    public void h() {
        this.n = false;
        this.e = true;
        p();
    }
}
