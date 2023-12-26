package com.bonree.sdk.aq;

import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.aa.d;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.engine.external.AppStateInfo;
import com.bonree.sdk.agent.engine.state.f;
import com.bonree.sdk.agent.engine.state.i;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.q;
import com.bonree.sdk.d.e;
import com.bonree.sdk.k.b;
import com.bonree.sdk.k.c;
import ohos.aafwk.ability.AbilityPackage;

public final class h extends com.bonree.sdk.ad.a implements d, i, b, com.bonree.sdk.x.d, com.bonree.sdk.y.d, com.bonree.sdk.z.d {
    private static final String p = "application-accelerate-Thread";
    private static final String q = "main";
    private String f;
    private String g;
    private int h;
    private int i;
    private volatile boolean j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;
    private final g n;
    private final String o;

    /* synthetic */ h(e eVar, byte b) {
        this((e) null);
    }

    private h(e eVar) {
        super(eVar);
        this.g = "";
        this.j = true;
        this.k = true;
        this.o = "LaunchService";
        this.e = "BR-Launch-Thread";
        this.n = new g(this);
    }

    public final void a(com.bonree.sdk.x.a aVar) {
        if (aVar != null && !this.l) {
            try {
                if (aVar.e() == 0) {
                    if (!this.g.equals(aVar.c() + aVar.e())) {
                        this.h = 0;
                        a(8, (Object) aVar);
                    } else {
                        this.h++;
                    }
                }
                if (aVar.e() == 1) {
                    int i2 = this.h;
                    if (i2 == 0) {
                        a(8, (Object) aVar);
                        if (com.bonree.sdk.x.a.m.equals(aVar.c())) {
                            if (!this.n.a()) {
                                this.l = true;
                            }
                            this.j = false;
                        }
                    } else {
                        this.h = i2 - 1;
                    }
                }
                this.g = aVar.c() + aVar.e();
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(com.bonree.sdk.y.a aVar) {
        if (aVar != null && !j()) {
            a(9, (Object) aVar);
        }
    }

    static class a {
        /* access modifiers changed from: private */
        public static final h a = new h((e) null, (byte) 0);

        private a() {
        }
    }

    public static h a() {
        return a.a;
    }

    public final synchronized void a(Application application, String str, Context context) {
        com.bonree.sdk.d.a.c();
        if (application == null) {
            com.bonree.sdk.d.a.a.e("Application context is NULL !!!  ", new Object[0]);
            return;
        }
        com.bonree.sdk.bs.a.a((Context) application);
        if (com.bonree.sdk.bs.a.b(application) || com.bonree.sdk.bs.a.b(context)) {
            a(application.getClass().getName(), str);
        }
    }

    public final synchronized void a(AbilityPackage abilityPackage, String str, ohos.app.Context context) {
        com.bonree.sdk.d.a.c();
        if (abilityPackage == null) {
            com.bonree.sdk.d.a.a.e("Application context is NULL !!!  ", new Object[0]);
            return;
        }
        q.a(abilityPackage);
        if (q.b(abilityPackage) || q.b(context)) {
            a(abilityPackage.getClass().getName(), str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r14, java.lang.String r15) {
        /*
            r13 = this;
            boolean r0 = r13.j
            if (r0 == 0) goto L_0x007c
            r0 = 0
            r13.j = r0
            r13.f = r14
            long r7 = com.bonree.sdk.d.a.l()
            long r5 = com.bonree.sdk.d.a.b()
            boolean r14 = com.bonree.sdk.d.a.L()
            r0 = 0
            if (r14 == 0) goto L_0x004a
            java.lang.Thread r14 = java.lang.Thread.currentThread()
            java.lang.String r14 = r14.getName()
            java.lang.String r2 = "application-accelerate-Thread"
            boolean r14 = android.text.TextUtils.equals(r14, r2)
            if (r14 == 0) goto L_0x002e
            long r2 = android.os.SystemClock.currentThreadTimeMillis()
            goto L_0x002f
        L_0x002e:
            r2 = r0
        L_0x002f:
            int r14 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r14 != 0) goto L_0x0058
            java.lang.Thread r14 = java.lang.Thread.currentThread()
            java.lang.String r14 = r14.getName()
            java.lang.String r2 = "main"
            boolean r14 = android.text.TextUtils.equals(r14, r2)
            if (r14 == 0) goto L_0x0048
            long r2 = android.os.SystemClock.currentThreadTimeMillis()
            goto L_0x0058
        L_0x0048:
            r2 = r0
            goto L_0x0058
        L_0x004a:
            android.os.Looper r14 = android.os.Looper.getMainLooper()
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r14 != r2) goto L_0x0048
            long r2 = android.os.SystemClock.currentThreadTimeMillis()
        L_0x0058:
            int r14 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            r0 = 1000(0x3e8, double:4.94E-321)
            if (r14 <= 0) goto L_0x0062
            long r0 = r0 * r2
            long r0 = r7 - r0
            goto L_0x0067
        L_0x0062:
            java.lang.Long.signum(r2)
            long r0 = r0 * r2
            long r0 = r0 + r7
        L_0x0067:
            r11 = r0
            long r9 = r5 - r2
            r13.i()
            java.lang.String r2 = r13.f
            r4 = 0
            r1 = r13
            r3 = r15
            r1.a(r2, r3, r4, r5, r7, r9, r11)
            boolean r14 = r13.m
            if (r14 == 0) goto L_0x007c
            r13.l()
        L_0x007c:
            java.lang.String r14 = "attachBaseContext"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x008a
            int r14 = r13.i
            int r14 = r14 + 1
            r13.i = r14
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.aq.h.a(java.lang.String, java.lang.String):void");
    }

    public final void d() {
        int i2 = this.i - 1;
        this.i = i2;
        if (i2 == 0) {
            a(AppStateInfo.ATTACH_BASE_CONTEXT, 1, com.bonree.sdk.d.a.b(), com.bonree.sdk.d.a.l());
        }
    }

    public final void b(String str) {
        if (this.i == 0) {
            this.f = str;
            a(com.bonree.sdk.z.a.l, 0, com.bonree.sdk.d.a.b(), com.bonree.sdk.d.a.l());
        }
        this.i++;
    }

    public final void c(String str) {
        if (this.i == 0) {
            this.f = str;
            a(AppStateInfo.ON_INITIALIZE, 0, com.bonree.sdk.d.a.b(), com.bonree.sdk.d.a.l());
        }
        this.i++;
    }

    public final void e() {
        int i2 = this.i - 1;
        this.i = i2;
        if (i2 == 0) {
            a(com.bonree.sdk.z.a.l, 1, com.bonree.sdk.d.a.b(), com.bonree.sdk.d.a.l());
        }
    }

    public final void g() {
        int i2 = this.i - 1;
        this.i = i2;
        if (i2 == 0) {
            a(AppStateInfo.ON_INITIALIZE, 1, com.bonree.sdk.d.a.b(), com.bonree.sdk.d.a.l());
        }
    }

    private void a(String str, int i2, long j2, long j3) {
        a(this.f, str, i2, j2, j3, 0, 0);
    }

    private void a(String str, String str2, int i2, long j2, long j3, long j4, long j5) {
        b bVar = new b();
        bVar.a(str);
        bVar.c(str2);
        bVar.a(j2);
        bVar.b(j3);
        bVar.b(i2);
        bVar.f(String.valueOf(Thread.currentThread().getId()));
        bVar.d(Thread.currentThread().getName());
        boolean z = false;
        bVar.a(0);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z = true;
        }
        bVar.a(z);
        bVar.c(j4);
        bVar.d(j5);
        a(1, (Object) bVar);
    }

    private synchronized void i() {
        a("LaunchService", a.d.a);
        if (!this.a) {
            this.a = true;
            a(this.e);
            if (com.bonree.sdk.d.a.L()) {
                com.bonree.sdk.x.b.a().registerService(this);
                com.bonree.sdk.y.b.a().registerService(this);
            } else {
                com.bonree.sdk.z.b.a().registerService((com.bonree.sdk.z.d) this);
                com.bonree.sdk.aa.b.a().registerService(this);
            }
            f.getEngine().registerService((i) this);
            com.bonree.sdk.k.d.a().a((b) this);
            a("LaunchService", a.d.c);
        }
        a("LaunchService", a.d.b);
    }

    public final synchronized boolean b() {
        i();
        return false;
    }

    public final synchronized boolean c() {
        a("LaunchService", a.d.d);
        this.a = false;
        if (!com.bonree.sdk.d.a.L()) {
            com.bonree.sdk.z.b.a().unRegisterService((com.bonree.sdk.z.d) this);
            com.bonree.sdk.aa.b.a().unRegisterService(this);
        } else {
            com.bonree.sdk.x.b.a().unRegisterService(this);
            com.bonree.sdk.y.b.a().unRegisterService(this);
        }
        com.bonree.sdk.k.d.a().unRegisterService(this);
        f.getEngine().unRegisterService((i) this);
        this.n.f();
        f();
        a("LaunchService", a.d.e);
        return false;
    }

    public final void a(com.bonree.sdk.z.a aVar) {
        if (aVar != null && !this.l) {
            try {
                if (aVar.e() == 0) {
                    if (!this.g.equals(aVar.c() + aVar.e())) {
                        this.h = 0;
                        a(2, (Object) aVar);
                    } else {
                        this.h++;
                    }
                }
                if (aVar.e() == 1) {
                    int i2 = this.h;
                    if (i2 == 0) {
                        a(2, (Object) aVar);
                        if (com.bonree.sdk.z.a.n.equals(aVar.c())) {
                            if (!this.n.a()) {
                                this.l = true;
                            }
                            this.j = false;
                        }
                    } else {
                        this.h = i2 - 1;
                    }
                }
                this.g = aVar.c() + aVar.e();
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(com.bonree.sdk.aa.a aVar) {
        if (aVar != null && !j()) {
            a(3, (Object) aVar);
        }
    }

    public final void a(c cVar) {
        if (cVar != null && !j()) {
            if (this.n.a(cVar)) {
                this.n.b(cVar.f());
                return;
            }
            if (ad.a(cVar.a())) {
                cVar.a(this.f);
            }
            a(4, (Object) cVar);
        }
    }

    private boolean j() {
        return !this.n.a() && !this.n.b();
    }

    private boolean k() {
        return !this.n.a() && !this.n.b();
    }

    public final EventBean a(boolean z) {
        return this.n.a(z);
    }

    public final void a(com.bonree.sdk.agent.engine.state.e eVar) {
        if (eVar != null) {
            if (eVar == com.bonree.sdk.agent.engine.state.e.BACKGROUND) {
                this.l = false;
            }
            a(7, (Object) eVar);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        this.n.a(message);
    }

    public final void b(int i2) {
        if (i2 > 0) {
            this.n.a(i2);
            if (!this.m) {
                a(5, (Object) null);
            }
        }
    }

    public final void c(int i2) {
        if (i2 > 0) {
            this.n.b(i2);
        }
    }

    public final void b(boolean z) {
        if (z && !this.m) {
            l();
        }
        this.m = z;
    }

    private void l() {
        if (!this.j) {
            this.n.e();
            com.bonree.sdk.be.a.a().a("LaunchService withUseCustomLaunch is success.", new Object[0]);
            return;
        }
        com.bonree.sdk.be.a.a().a("LaunchService withUseCustomLaunch is failed, LaunchService is start %b.", Boolean.valueOf(true ^ this.j));
    }

    public final void h() {
        com.bonree.sdk.be.a.a().a("LaunchService recordCustomLaunchEnd isFirstColdStart %s, isFirstColdEnd %s, isCustomColdEnd %s.", Boolean.valueOf(this.j), Boolean.valueOf(this.k), Boolean.valueOf(this.m));
        if (!this.j && this.k) {
            this.k = false;
            if (this.m) {
                String b = com.bonree.sdk.z.b.a().b();
                if (ad.a(b)) {
                    b = this.f;
                }
                a(b, AppStateInfo.RECORD_CUSTOM_LAUNCH_END, 0, com.bonree.sdk.d.a.b(), com.bonree.sdk.d.a.l(), 0, 0);
                if (!this.n.b()) {
                    this.l = true;
                }
            }
        }
    }
}
