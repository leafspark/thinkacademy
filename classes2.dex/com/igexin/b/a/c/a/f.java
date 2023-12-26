package com.igexin.b.a.c.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.igexin.b.a.c.b;
import com.igexin.push.core.x;
import com.igexin.push.util.a;

public class f extends Handler {
    private final String a;
    private final Messenger b;
    private StringBuffer c;
    private Messenger d;

    private f() {
        super(Looper.getMainLooper());
        this.a = "LOG-" + "f";
        this.b = new Messenger(this);
        this.c = new StringBuffer();
    }

    public static f a() {
        return h.a;
    }

    private void a(Message message) {
        this.d = message.replyTo;
        if (c()) {
            b(this.c.toString());
            this.c.setLength(0);
        }
    }

    private void b(String str) {
        try {
            Message message = new Message();
            message.what = 2;
            Bundle bundle = new Bundle();
            bundle.putString("log_data", str);
            message.setData(bundle);
            this.d.send(message);
        } catch (Exception e) {
            b.a(this.a + "|send message error = " + e, new Object[0]);
        }
    }

    private boolean c() {
        return this.c.length() > 0;
    }

    public void a(String str) {
        if (x.a != null && a.d(x.a)) {
            if (this.d != null) {
                b(str);
            } else if (this.c.length() + str.length() < 5120) {
                StringBuffer stringBuffer = this.c;
                stringBuffer.append(str);
                stringBuffer.append("\n");
            } else if (this.c.length() <= 5120 && this.c.length() + 135 > 5120) {
                StringBuffer stringBuffer2 = this.c;
                stringBuffer2.append("Warning! the log cache is too long to show the full content,we suggest you call initialize and setDebugLogger in a short time interval.");
                stringBuffer2.append("\n");
            }
        }
    }

    public IBinder b() {
        return this.b.getBinder();
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        if (message.what != 1) {
            super.handleMessage(message);
        } else {
            a(message);
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
