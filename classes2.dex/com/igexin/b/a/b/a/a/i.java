package com.igexin.b.a.b.a.a;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.igexin.b.a.b.a.a.a.c;
import com.igexin.b.a.b.d;
import com.igexin.b.a.c.b;
import com.igexin.push.util.m;

class i implements c {
    final /* synthetic */ f a;

    i(f fVar) {
        this.a = fVar;
    }

    public void a(m mVar) {
        if (!m.b()) {
            this.a.b(mVar);
        }
    }

    public void a(d dVar) {
        Handler a2 = this.a.m;
        int ordinal = q.INTERRUPT_SUCCESS.ordinal();
        if (!(a2 instanceof Handler)) {
            a2.sendEmptyMessage(ordinal);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(a2, ordinal);
        }
    }

    public void a(Exception exc) {
        b.a("GS-M|w ex = " + exc.toString(), new Object[0]);
        this.a.i();
    }
}
