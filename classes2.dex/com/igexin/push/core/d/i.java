package com.igexin.push.core.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class i implements ServiceConnection {
    private h a;
    private String b;
    private CountDownLatch c;
    private IBinder d;

    i(String str, CountDownLatch countDownLatch) {
        this.b = str;
        this.c = countDownLatch;
    }

    /* access modifiers changed from: package-private */
    public h a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public boolean a(Context context, Intent intent) {
        if (context == null) {
            return false;
        }
        if (this.a != null) {
            return true;
        }
        try {
            boolean bindService = context.bindService(intent, this, 1);
            this.c.await(2000, TimeUnit.MILLISECONDS);
            this.a = h.a(this.d, this.b);
            return bindService;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.d = iBinder;
            this.c.countDown();
        } catch (Throwable unused) {
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a = null;
        this.d = null;
    }
}
