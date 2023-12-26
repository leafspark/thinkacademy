package com.igexin.b.a.c.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.igexin.b.a.c.b;
import com.igexin.push.core.x;
import com.igexin.sdk.IUserLoggerInterface;
import com.igexin.sdk.PushManager;

public class c extends Handler implements ServiceConnection {
    private final String a;
    private Messenger b;
    private Messenger c;
    private b d;

    private c() {
        super(Looper.getMainLooper());
        this.a = "LOG-LogController";
        this.d = new a();
    }

    public static c a() {
        return e.a;
    }

    private void a(Context context) {
        b.a("try to bind log server", new Object[0]);
        try {
            Intent intent = new Intent(context, x.a().b(context));
            intent.setType("SERVER_LOG");
            context.bindService(intent, this, 1);
        } catch (Exception e) {
            Log.e("LOG-LogController", "bind service error = " + e.toString());
        }
    }

    public void a(Context context, IUserLoggerInterface iUserLoggerInterface) {
        if (iUserLoggerInterface == null) {
            Log.i("LOG-LogController", "register parameter can not be null!");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        a(applicationContext);
        this.d.a(iUserLoggerInterface);
        this.d.a();
        a("[LOG-LogController] Sdk version = " + PushManager.getInstance().getVersion(applicationContext));
    }

    public void a(String str) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        if (message.what == 2) {
            String string = message.getData().getString("log_data");
            if (TextUtils.isEmpty(string)) {
                AsynchronousInstrumentation.handlerMessageEnd();
                return;
            } else if (string.contains("\n")) {
                for (String a2 : string.split("\n")) {
                    this.d.a(a2);
                }
            } else {
                this.d.a(string);
            }
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b.a("remote log service connected ", new Object[0]);
        try {
            this.c = new Messenger(iBinder);
            if (this.b == null) {
                this.b = new Messenger(this);
            }
            Message obtain = Message.obtain();
            obtain.replyTo = this.b;
            obtain.what = 1;
            this.c.send(obtain);
        } catch (Exception e) {
            a("Client sent Message to Service error = " + e);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.c = null;
    }
}
