package com.igexin.b.a.b.a.a;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.igexin.b.a.b.a.a.a.b;
import com.igexin.b.a.b.d;

class h implements b {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
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
        com.igexin.b.a.c.b.a("GS-M|r ex = " + exc.toString(), new Object[0]);
        if (exc.getMessage() != null && exc.getMessage().equals("end of stream")) {
            com.igexin.push.d.b.a().d();
        }
        this.a.i();
    }
}
