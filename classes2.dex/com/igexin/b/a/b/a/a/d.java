package com.igexin.b.a.b.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.net.Socket;

public class d extends Handler {
    public d(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        try {
            int i = e.a[q.a()[message.what].ordinal()];
            if (i == 1) {
                f.a().g();
            } else if (i == 3) {
                f.a().a((Socket) message.obj);
            } else if (i == 4) {
                f.a().h();
            } else if (i == 5) {
                f.a().f();
            } else if (i == 6) {
                f.a().b();
            }
        } catch (Throwable unused) {
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
