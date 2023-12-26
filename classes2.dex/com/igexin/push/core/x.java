package com.igexin.push.core;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.igexin.b.a.c.a.f;
import com.igexin.b.a.c.b;
import com.igexin.push.config.l;
import com.igexin.push.config.m;
import com.igexin.push.core.a.e;
import com.igexin.push.util.EncryptUtils;
import com.igexin.push.util.c;
import com.igexin.push.util.n;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.IPushCore;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushService;
import com.igexin.sdk.a.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class x {
    public static Context a;
    public Pair<Integer, String> b;
    private IPushCore c;
    private final AtomicBoolean d;
    private final ExecutorService e;
    /* access modifiers changed from: private */
    public String f;
    /* access modifiers changed from: private */
    public final ServiceConnection g;

    private x() {
        this.d = new AtomicBoolean(false);
        this.g = new z(this);
        this.e = Executors.newSingleThreadExecutor();
    }

    /* synthetic */ x(y yVar) {
        this();
    }

    private int a(Service service) {
        b.a("ServiceManager|start by system ####", new Object[0]);
        if (a((Context) service, false)) {
            b.a("ServiceManager|intent = null", new Object[0]);
            if (!this.d.getAndSet(true)) {
                a(service, (Intent) null);
            }
            return 2;
        }
        service.stopSelf();
        return 2;
    }

    private int a(Intent intent, int i, int i2) {
        if (this.c == null) {
            return 2;
        }
        b.a("ServiceManager|inInit = true, call onServiceStartCommand...", new Object[0]);
        return this.c.onServiceStartCommand(intent, i, i2);
    }

    public static x a() {
        return aa.a;
    }

    private void a(Service service, Intent intent) {
        b.a("ServiceManager|startPushCore ++++", new Object[0]);
        if (EncryptUtils.isLoadSuccess()) {
            a.a().b();
            IPushCore c2 = a.a().c();
            this.c = c2;
            if (c2 != null) {
                c2.start(service);
                return;
            }
            return;
        }
        Log.e("ServiceManager", "load so error ####");
        service.stopSelf();
    }

    private boolean a(Context context, boolean z) {
        if (c.a(context)) {
            return false;
        }
        if (!z) {
            return true;
        }
        m.a(context);
        return l.k;
    }

    private int b(Service service, Intent intent, int i, int i2) {
        b.a("ServiceManager|start from initialize...", new Object[0]);
        f.a().a("ServiceManager start from initialize...");
        a(service, intent);
        IPushCore iPushCore = this.c;
        if (iPushCore != null) {
            return iPushCore.onServiceStartCommand(intent, i, i2);
        }
        return 2;
    }

    private boolean b(Context context, Intent intent) {
        this.e.execute(new y(this, context, intent));
        return true;
    }

    private int c(Service service, Intent intent, int i, int i2) {
        if (a((Context) service, true)) {
            a(service, intent);
            IPushCore iPushCore = this.c;
            if (iPushCore != null) {
                return iPushCore.onServiceStartCommand(intent, i, i2);
            }
            return 2;
        }
        this.d.set(false);
        service.stopSelf();
        return 2;
    }

    public int a(Service service, Intent intent, int i, int i2) {
        if (intent == null) {
            try {
                this.b = Pair.create(1, (Object) null);
                return a(service);
            } catch (Throwable th) {
                b.a("ServiceManager|" + th.toString(), new Object[0]);
                return 2;
            }
        } else {
            n.a(service, intent);
            String stringExtra = intent.getStringExtra("action");
            if (PushConsts.ACTION_SERVICE_INITIALIZE.equals(stringExtra)) {
                c.b((Context) service);
            }
            if (this.d.getAndSet(true)) {
                return a(intent, i, i2);
            }
            if (PushConsts.ACTION_SERVICE_INITIALIZE.equals(stringExtra)) {
                this.b = Pair.create(0, (Object) null);
                return b(service, intent, i, i2);
            }
            this.b = Pair.create(1, intent.getStringExtra("pkg"));
            return c(service, intent, i, i2);
        }
    }

    public IBinder a(Intent intent) {
        b.a("ServiceManager|onBind...", new Object[0]);
        IPushCore iPushCore = this.c;
        if (iPushCore != null) {
            return iPushCore.onServiceBind(intent);
        }
        return null;
    }

    public void a(Activity activity) {
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                intent = new Intent(activity, e.a().a((Context) activity));
            } else {
                intent.setComponent(new ComponentName(activity, e.a().a((Context) activity)));
            }
            a((Context) activity, intent);
            b.a("ServiceManager|start PushService from da", new Object[0]);
        } catch (Throwable th) {
            activity.finish();
            throw th;
        }
        activity.finish();
    }

    public void a(Context context) {
        a = context.getApplicationContext();
    }

    public boolean a(Context context, Intent intent) {
        return b(context, intent);
    }

    public Class b(Context context) {
        try {
            String str = (String) n.c(context, "us", "", new String[0]);
            if (!TextUtils.isEmpty(str)) {
                return Class.forName(str);
            }
            Class cls = (Class) com.igexin.push.util.b.a(context, PushService.class).second;
            return cls != null ? cls : PushService.class;
        } catch (Throwable th) {
            b.a("ServiceManager|" + th.toString(), new Object[0]);
            return PushService.class;
        }
    }

    public void b() {
        b.a("ServiceManager|onLowMemory...", new Object[0]);
    }

    public Class c(Context context) {
        try {
            String str = (String) n.c(context, "uis", "", new String[0]);
            return !TextUtils.isEmpty(str) ? Class.forName(str) : (Class) com.igexin.push.util.b.a(context, GTIntentService.class).second;
        } catch (Throwable th) {
            b.a("ServiceManager|" + th.toString(), new Object[0]);
            return null;
        }
    }

    public void c() {
        b.a("ServiceManager|onDestroy...", new Object[0]);
        IPushCore iPushCore = this.c;
        if (iPushCore != null) {
            iPushCore.onServiceDestroy();
        }
    }

    public String d(Context context) {
        return (String) n.c(context, "ua", "", new String[0]);
    }
}
