package com.igexin.push.core;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.b.a.b.d;
import com.igexin.b.a.d.a.b;
import com.igexin.b.a.d.f;
import com.igexin.push.config.j;
import com.igexin.push.core.a.e;
import com.igexin.push.core.b.i;
import com.igexin.push.e.a;
import com.igexin.push.f.b.g;
import com.igexin.sdk.PushConsts;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class c implements b {
    private static c l;
    private Context a;
    private f b = new f();
    private Handler c;
    private Handler d;
    private ConcurrentLinkedQueue<Message> e = new ConcurrentLinkedQueue<>();
    private e f;
    private com.igexin.b.a.b.c g = com.igexin.b.a.b.c.b();
    private com.igexin.b.a.b.b h;
    private volatile a i;
    private final AtomicBoolean j = new AtomicBoolean(false);
    private com.igexin.push.b.b k;

    private c() {
        this.g.a((com.igexin.b.a.d.a.a<String, Integer, com.igexin.b.a.b.b, d>) new com.igexin.push.d.a(this.a));
        this.g.a((b) this);
        this.i = new a();
    }

    public static c a() {
        if (l == null) {
            l = new c();
        }
        return l;
    }

    private void n() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction(CoreConsts.b);
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.a.registerReceiver(l.a(), intentFilter);
    }

    public boolean a(Context context) {
        this.a = context.getApplicationContext();
        f fVar = this.b;
        if (fVar == null || !fVar.isAlive()) {
            if (!this.j.getAndSet(true)) {
                com.igexin.b.a.c.b.a("CoreLogic|start coreThread +++++", new Object[0]);
                this.b.start();
                this.c = new b(this.b.getLooper());
                this.d = new com.igexin.b.a.b.a.a.d(this.b.getLooper());
            }
            return true;
        }
        com.igexin.b.a.c.b.a("CoreLogic|coreThread is alive +++++", new Object[0]);
        return true;
    }

    public boolean a(Message message) {
        if (d.h.get()) {
            Handler handler = this.c;
            if (!(handler instanceof Handler)) {
                handler.sendMessage(message);
                return true;
            }
            AsynchronousInstrumentation.sendMessage(handler, message);
            return true;
        }
        this.e.add(message);
        return true;
    }

    public boolean a(com.igexin.b.a.d.a.e eVar, f fVar) {
        e eVar2 = this.f;
        return eVar2 != null && eVar2.a((Object) eVar);
    }

    public boolean a(com.igexin.b.a.d.e eVar, f fVar) {
        e eVar2 = this.f;
        return eVar2 != null && eVar2.a(eVar);
    }

    public boolean a(g gVar) {
        return gVar != null && com.igexin.b.a.b.c.b().a(gVar, false, true);
    }

    public boolean a(boolean z) {
        com.igexin.b.a.c.b.a("CoreLogic|start sdkSwitch isSlave = " + z, new Object[0]);
        if (d.g == null) {
            return false;
        }
        if (!new com.igexin.sdk.a.c(d.g).b()) {
            new com.igexin.sdk.a.d(d.g).a();
            d.k = true;
            new com.igexin.sdk.a.c(d.g).a();
        }
        if (z) {
            new com.igexin.sdk.a.d(d.g).a();
            d.k = true;
        }
        a().i().b();
        return true;
    }

    public Handler b() {
        return this.d;
    }

    public void c() {
        Handler handler;
        try {
            this.k = new com.igexin.push.b.b(this.a);
            d.a(this.a);
            j.a().b();
            n();
            com.igexin.push.b.a aVar = new com.igexin.push.b.a();
            aVar.a(i.a());
            aVar.a(com.igexin.push.core.b.e.a());
            aVar.a(com.igexin.push.core.b.c.a());
            aVar.a(com.igexin.push.config.a.a());
            this.g.a(aVar, true, false);
            this.g.a(this.a);
            com.igexin.b.a.b.c.b().a(com.igexin.b.b.a.a(d.D.getBytes()));
            d.ab = this.g.a(com.igexin.push.f.b.b.i(), false, true);
            d.ac = this.g.a(com.igexin.push.f.b.f.i(), true, true);
            com.igexin.push.c.i.a().b();
            d();
            this.f = e.a();
            this.i.b();
            com.igexin.push.a.a.c.c().d();
            d.h.set(true);
            r.a().a(Process.myPid());
            com.igexin.push.extension.a.a().a(this.a);
            while (!this.e.isEmpty()) {
                Message poll = this.e.poll();
                if (!(poll == null || (handler = this.c) == null)) {
                    if (!(handler instanceof Handler)) {
                        handler.sendMessage(poll);
                    } else {
                        AsynchronousInstrumentation.sendMessage(handler, poll);
                    }
                }
            }
            w.a().f();
            try {
                AssistPushManager.getInstance().initialize(d.g);
                AssistPushManager.getInstance().register(d.g);
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            com.igexin.b.a.c.b.a("CoreLogic|init|failed|" + th.toString(), new Object[0]);
            com.igexin.b.a.c.a.f a2 = com.igexin.b.a.c.a.f.a();
            a2.a("CoreLogic init failed = " + th.toString());
        }
    }

    public void d() {
        com.igexin.push.f.b.a i2 = com.igexin.push.f.b.a.i();
        com.igexin.push.a.a.b bVar = new com.igexin.push.a.a.b();
        i2.a(bVar);
        i2.a(new com.igexin.push.a.a.a());
        i2.a(com.igexin.push.a.a.c.c());
        try {
            bVar.a();
            bVar.a(System.currentTimeMillis());
        } catch (Throwable unused) {
        }
        d.ad = this.g.a(i2, false, true);
    }

    public long e() {
        Handler handler = this.c;
        if (handler == null) {
            return -2;
        }
        return handler.getLooper().getThread().getId();
    }

    public String f() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) d.g.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() == 0) {
                return "mobile";
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (d.g != null) {
            new com.igexin.sdk.a.d(d.g).b();
            d.k = false;
            d.o = false;
            this.i.c();
        }
    }

    public com.igexin.b.a.b.b h() {
        if (this.h == null) {
            this.h = com.igexin.push.d.a.b.a();
        }
        return this.h;
    }

    public a i() {
        return this.i;
    }

    public e j() {
        return this.f;
    }

    public com.igexin.push.b.b k() {
        return this.k;
    }

    public boolean l() {
        return true;
    }

    public long m() {
        return 94808;
    }
}
