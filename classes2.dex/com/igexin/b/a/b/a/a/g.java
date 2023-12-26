package com.igexin.b.a.b.a.a;

import android.os.Handler;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.igexin.b.a.b.a.a.a.d;
import com.igexin.b.a.c.b;
import java.net.Socket;

class g implements d {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void a(com.igexin.b.a.b.d dVar) {
        Handler a2 = this.a.m;
        int ordinal = q.INTERRUPT_SUCCESS.ordinal();
        if (!(a2 instanceof Handler)) {
            a2.sendEmptyMessage(ordinal);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(a2, ordinal);
        }
    }

    public void a(Exception exc) {
        b.a("GS-M|c ex = " + exc.toString(), new Object[0]);
        this.a.i();
    }

    public void a(String str) {
        Handler a2 = this.a.m;
        int ordinal = q.TCP_CREATE_SUCCESS.ordinal();
        if (!(a2 instanceof Handler)) {
            a2.sendEmptyMessage(ordinal);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(a2, ordinal);
        }
    }

    public void a(Socket socket) {
        Message obtain = Message.obtain();
        obtain.obj = socket;
        obtain.what = q.TCP_CONNECT_SUCCESS.ordinal();
        Handler a2 = this.a.m;
        if (!(a2 instanceof Handler)) {
            a2.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(a2, obtain);
        }
    }
}
