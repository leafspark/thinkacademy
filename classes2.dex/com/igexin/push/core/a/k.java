package com.igexin.push.core.a;

import com.igexin.b.a.d.e;
import com.igexin.push.core.h;
import com.igexin.push.core.j;
import com.igexin.push.d.b;
import com.igexin.push.d.c.f;

public class k extends a {
    private static final String a = com.igexin.push.config.k.a;

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if (!(obj instanceof f)) {
            return true;
        }
        b.a().e();
        com.igexin.b.a.c.b.a("heartbeatRsp", new Object[0]);
        h.a().a(j.HEARTBEAT_OK);
        return true;
    }
}
