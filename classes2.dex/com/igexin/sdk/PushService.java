package com.igexin.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.igexin.b.a.c.a.f;
import com.igexin.push.core.x;

public class PushService extends Service {
    private final String a = getClass().getName();

    public IBinder onBind(Intent intent) {
        String type = (intent == null || intent.getType() == null) ? "" : intent.getType();
        if (!type.startsWith("GB-") && !type.startsWith("PB-")) {
            return type.equals("SERVER_LOG") ? f.a().b() : x.a().a(intent);
        }
        onStartCommand(intent, 0, 0);
        return null;
    }

    public void onCreate() {
        super.onCreate();
        x.a().a((Context) this);
    }

    public void onDestroy() {
        super.onDestroy();
        x.a().c();
    }

    public void onLowMemory() {
        super.onLowMemory();
        x.a().b();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return x.a().a(this, intent, i, i2);
    }
}
