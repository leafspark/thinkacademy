package com.igexin.push.core.a;

import android.text.TextUtils;
import com.igexin.b.a.c.b;
import com.igexin.b.a.d.e;
import com.igexin.push.config.k;
import com.igexin.push.core.b.i;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import com.igexin.push.core.m;
import com.igexin.push.d.c.o;
import com.igexin.push.e.a;

public class t extends a {
    private static final String a = (k.a + "_RegisterResultAction");

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            d.F = 0;
            b.a("register resp |" + oVar.a + "|" + d.t, new Object[0]);
            b.a("register resp cid = " + oVar.c + " device id = " + oVar.d, new Object[0]);
            if (oVar.a != d.t) {
                d.o = false;
                StringBuilder sb = new StringBuilder();
                String str = a;
                sb.append(str);
                sb.append(" change session : from [");
                sb.append(d.t);
                sb.append("] to [");
                sb.append(oVar.a);
                sb.append("]");
                b.a(sb.toString(), new Object[0]);
                b.a(str + " change cid : from [" + d.u + "] to [" + oVar.c + "]", new Object[0]);
                if (TextUtils.isEmpty(oVar.c) || TextUtils.isEmpty(oVar.d)) {
                    i.a().a(oVar.a);
                } else {
                    i.a().a(oVar.c, oVar.d, oVar.a);
                }
                d.I = 0;
            }
            b.a("loginReqAfterRegister|new session:" + d.t + ", cid :" + d.u + ", devId :" + d.A, new Object[0]);
            com.igexin.push.d.c.i d = m.a().d();
            a i = c.a().i();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("S-");
            sb2.append(d.a);
            i.a(sb2.toString(), d, true);
        }
        return true;
    }
}
