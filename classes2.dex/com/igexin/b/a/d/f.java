package com.igexin.b.a.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import com.igexin.b.a.b.d;
import com.igexin.b.a.d.a.b;
import com.igexin.b.a.d.a.e;
import com.igexin.push.d.b.a;
import com.igexin.push.d.c.n;
import com.igexin.push.util.m;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class f extends BroadcastReceiver implements Comparator<e> {
    public static final String g = "com.igexin.b.a.d.f";
    public static final long u = TimeUnit.SECONDS.toMillis(2);
    private boolean a = false;
    final j h = new j(this);
    final HashMap<Long, b> i = new HashMap<>(7);
    final c j = new c();
    final d<e> k = new d<>(this, this);
    final ReentrantLock l = new ReentrantLock();
    PowerManager m;
    AlarmManager n;
    Intent o;
    PendingIntent p;
    Intent q;
    PendingIntent r;
    String s;
    volatile boolean t;

    protected f() {
        e.D = this;
    }

    /* renamed from: a */
    public final int compare(e eVar, e eVar2) {
        if (eVar.t < eVar2.t) {
            return -1;
        }
        if (eVar.t > eVar2.t) {
            return 1;
        }
        if (eVar.z > eVar2.z) {
            return -1;
        }
        if (eVar.z < eVar2.z) {
            return 1;
        }
        if (eVar.u < eVar2.u) {
            return -1;
        }
        if (eVar.u > eVar2.u) {
            return 1;
        }
        return eVar.hashCode() - eVar2.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(long r5) {
        /*
            r4 = this;
            boolean r0 = r4.t
            if (r0 == 0) goto L_0x0076
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setalarm|"
            r0.append(r1)
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
            r1.<init>(r3, r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>(r5)
            java.lang.String r1 = r1.format(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r2)
            r2 = 0
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x003c
            long r5 = java.lang.System.currentTimeMillis()
            long r2 = u
            long r5 = r5 + r2
        L_0x003c:
            android.app.PendingIntent r0 = r4.p     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0076
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x005b }
            r2 = 19
            if (r0 >= r2) goto L_0x004e
            android.app.AlarmManager r0 = r4.n     // Catch:{ all -> 0x005b }
            android.app.PendingIntent r2 = r4.p     // Catch:{ all -> 0x005b }
        L_0x004a:
            r0.set(r1, r5, r2)     // Catch:{ all -> 0x005b }
            goto L_0x0076
        L_0x004e:
            android.app.AlarmManager r0 = r4.n     // Catch:{ all -> 0x0056 }
            android.app.PendingIntent r2 = r4.p     // Catch:{ all -> 0x0056 }
            r0.setExact(r1, r5, r2)     // Catch:{ all -> 0x0056 }
            goto L_0x0076
        L_0x0056:
            android.app.AlarmManager r0 = r4.n     // Catch:{ all -> 0x005b }
            android.app.PendingIntent r2 = r4.p     // Catch:{ all -> 0x005b }
            goto L_0x004a
        L_0x005b:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "TaskService"
            r6.append(r0)
            java.lang.String r5 = r5.toString()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.Object[] r6 = new java.lang.Object[r1]
            com.igexin.b.a.c.b.a((java.lang.String) r5, (java.lang.Object[]) r6)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.a(long):void");
    }

    public final void a(Context context) {
        if (!this.a) {
            if (!m.b()) {
                this.m = (PowerManager) context.getSystemService("power");
                this.t = true;
                this.n = (AlarmManager) context.getSystemService("alarm");
                context.registerReceiver(this, new IntentFilter("AlarmTaskSchedule." + context.getPackageName()));
                context.registerReceiver(this, new IntentFilter("AlarmTaskScheduleBak." + context.getPackageName()));
                context.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_OFF"));
                context.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_ON"));
                this.s = "AlarmNioTaskSchedule." + context.getPackageName();
                context.registerReceiver(this, new IntentFilter(this.s));
                int i2 = 134217728;
                if (m.a(context) >= 31 && Build.VERSION.SDK_INT >= 30) {
                    i2 = 201326592;
                }
                this.o = new Intent("AlarmTaskSchedule." + context.getPackageName());
                this.p = PendingIntent.getBroadcast(context, hashCode(), this.o, i2);
                this.q = new Intent(this.s);
                this.r = PendingIntent.getBroadcast(context, hashCode() + 2, this.q, i2);
            }
            this.h.start();
            try {
                Thread.yield();
            } catch (Throwable unused) {
            }
            this.a = true;
        }
    }

    public final boolean a(b bVar) {
        Objects.requireNonNull(bVar);
        ReentrantLock reentrantLock = this.l;
        if (reentrantLock.tryLock()) {
            try {
                if (this.i.keySet().contains(Long.valueOf(bVar.m()))) {
                    return false;
                }
                this.i.put(Long.valueOf(bVar.m()), bVar);
                reentrantLock.unlock();
                return true;
            } catch (Throwable th) {
                com.igexin.b.a.c.b.a("TaskService|" + th.toString(), new Object[0]);
            } finally {
                reentrantLock.unlock();
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(e eVar, b bVar) {
        int b_ = eVar.b_();
        if (b_ > Integer.MIN_VALUE && b_ < 0) {
            e eVar2 = (e) eVar;
            boolean a2 = eVar2.s ? bVar.a(eVar2, this) : bVar.a(eVar, this);
            if (a2) {
                eVar2.c();
            }
            return a2;
        } else if (b_ < 0 || b_ >= Integer.MAX_VALUE) {
            return false;
        } else {
            return bVar.a(eVar, this);
        }
    }

    public final boolean a(e eVar, boolean z) {
        Objects.requireNonNull(eVar);
        int i2 = 0;
        if (eVar.o || eVar.j) {
            return false;
        }
        d<e> dVar = this.k;
        if ((eVar instanceof d) && (((d) eVar).c instanceof n)) {
            if (z) {
                i2 = Integer.MAX_VALUE;
            }
        } else if (z) {
            i2 = dVar.e.incrementAndGet();
        }
        eVar.z = i2;
        return dVar.a(eVar);
    }

    public final boolean a(e eVar, boolean z, boolean z2) {
        Objects.requireNonNull(eVar);
        boolean z3 = false;
        if (eVar.k) {
            return false;
        }
        if (!z || z2) {
            if (z2 && z) {
                z3 = true;
            }
            return a(eVar, z3);
        }
        eVar.d();
        try {
            eVar.b();
            eVar.g();
            eVar.e_();
            if (!eVar.s) {
                eVar.c();
            }
            return true;
        } catch (Exception e) {
            eVar.s = true;
            eVar.A = e;
            eVar.p();
            eVar.t();
            a((Object) eVar);
            f();
            if (!eVar.s) {
                eVar.c();
            }
            return false;
        } catch (Throwable th) {
            if (!eVar.s) {
                eVar.c();
            }
            throw th;
        }
    }

    public final boolean a(Class cls) {
        d<e> dVar = this.k;
        return dVar != null && dVar.a(cls);
    }

    public final boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (obj instanceof com.igexin.push.d.c.m) {
                com.igexin.push.d.c.m mVar = (com.igexin.push.d.c.m) obj;
            }
        } catch (Exception unused) {
        }
        com.igexin.b.a.c.b.a("TaskService|responseQueue ++ task = " + obj.getClass().getName() + "@" + obj.hashCode(), new Object[0]);
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.l()) {
                return false;
            }
            eVar.a(false);
            if ((obj instanceof a) || (obj instanceof com.igexin.push.d.b.b)) {
                this.j.a();
                com.igexin.b.a.c.b.a("TaskService|change to primaryQueue", new Object[0]);
            }
            this.j.a(eVar);
            return true;
        }
        throw new ClassCastException("response Obj is not a TaskResult ");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(long r5) {
        /*
            r4 = this;
            boolean r0 = com.igexin.push.util.m.b()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "setnioalarm|"
            r0.append(r1)
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
            r1.<init>(r3, r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>(r5)
            java.lang.String r1 = r1.format(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.igexin.b.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r2)
            r2 = 0
            int r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x003f
            long r5 = java.lang.System.currentTimeMillis()
            long r2 = u
            long r5 = r5 + r2
        L_0x003f:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0058 }
            r2 = 19
            if (r0 >= r2) goto L_0x004d
            android.app.AlarmManager r0 = r4.n     // Catch:{ all -> 0x0058 }
        L_0x0047:
            android.app.PendingIntent r2 = r4.r     // Catch:{ all -> 0x0058 }
            r0.set(r1, r5, r2)     // Catch:{ all -> 0x0058 }
            goto L_0x0058
        L_0x004d:
            android.app.AlarmManager r0 = r4.n     // Catch:{ Exception -> 0x0055 }
            android.app.PendingIntent r2 = r4.r     // Catch:{ Exception -> 0x0055 }
            r0.setExact(r1, r5, r2)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0058
        L_0x0055:
            android.app.AlarmManager r0 = r4.n     // Catch:{ all -> 0x0058 }
            goto L_0x0047
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.b(long):void");
    }

    public final void e() {
        try {
            PendingIntent pendingIntent = this.r;
            if (pendingIntent != null) {
                this.n.cancel(pendingIntent);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void f() {
        j jVar = this.h;
        if (jVar != null && !jVar.isInterrupted()) {
            this.h.interrupt();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
        if (r4 < 0) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0091, code lost:
        ((com.igexin.b.a.d.e) r0).c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bf, code lost:
        if (r4 < 0) goto L_0x0091;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0000 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r8 = this;
        L_0x0000:
            com.igexin.b.a.d.c r0 = r8.j
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x00e8
            com.igexin.b.a.d.c r0 = r8.j
            com.igexin.b.a.d.a.e r0 = r0.d()
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "TaskService|notifyObserver responseQueue -- task = "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.igexin.b.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r3)
            r1 = 1
            r0.a(r1)
            java.util.concurrent.locks.ReentrantLock r1 = r8.l
            r1.lock()
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            java.util.HashMap<java.lang.Long, com.igexin.b.a.d.a.b> r4 = r8.i     // Catch:{ all -> 0x009b }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x009b }
            if (r4 != 0) goto L_0x0086
            long r4 = r0.m()     // Catch:{ all -> 0x009b }
            r6 = 0
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x005e
            java.util.HashMap<java.lang.Long, com.igexin.b.a.d.a.b> r6 = r8.i     // Catch:{ all -> 0x009b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x009b }
            java.lang.Object r4 = r6.get(r4)     // Catch:{ all -> 0x009b }
            com.igexin.b.a.d.a.b r4 = (com.igexin.b.a.d.a.b) r4     // Catch:{ all -> 0x009b }
            if (r4 == 0) goto L_0x0086
            boolean r5 = r4.l()     // Catch:{ all -> 0x009b }
            if (r5 == 0) goto L_0x0086
            boolean r4 = r8.a((com.igexin.b.a.d.a.e) r0, (com.igexin.b.a.d.a.b) r4)     // Catch:{ all -> 0x009b }
            goto L_0x0087
        L_0x005e:
            java.util.HashMap<java.lang.Long, com.igexin.b.a.d.a.b> r4 = r8.i     // Catch:{ all -> 0x009b }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x009b }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x009b }
            r5 = r2
        L_0x0069:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0084 }
            if (r6 == 0) goto L_0x0082
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0084 }
            com.igexin.b.a.d.a.b r6 = (com.igexin.b.a.d.a.b) r6     // Catch:{ all -> 0x0084 }
            boolean r7 = r6.l()     // Catch:{ all -> 0x0084 }
            if (r7 != 0) goto L_0x007c
            goto L_0x0069
        L_0x007c:
            boolean r5 = r8.a((com.igexin.b.a.d.a.e) r0, (com.igexin.b.a.d.a.b) r6)     // Catch:{ all -> 0x0084 }
            if (r5 == 0) goto L_0x0069
        L_0x0082:
            r4 = r5
            goto L_0x0087
        L_0x0084:
            r4 = move-exception
            goto L_0x009d
        L_0x0086:
            r4 = r2
        L_0x0087:
            if (r4 != 0) goto L_0x0097
            int r4 = r0.b_()
            if (r4 <= r3) goto L_0x0097
            if (r4 >= 0) goto L_0x0097
        L_0x0091:
            r3 = r0
            com.igexin.b.a.d.e r3 = (com.igexin.b.a.d.e) r3
            r3.c()
        L_0x0097:
            r1.unlock()
            goto L_0x00c2
        L_0x009b:
            r4 = move-exception
            r5 = r2
        L_0x009d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
            r6.<init>()     // Catch:{ all -> 0x00d4 }
            java.lang.String r7 = "TaskService|"
            r6.append(r7)     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00d4 }
            r6.append(r4)     // Catch:{ all -> 0x00d4 }
            java.lang.String r4 = r6.toString()     // Catch:{ all -> 0x00d4 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x00d4 }
            com.igexin.b.a.c.b.a((java.lang.String) r4, (java.lang.Object[]) r6)     // Catch:{ all -> 0x00d4 }
            if (r5 != 0) goto L_0x0097
            int r4 = r0.b_()
            if (r4 <= r3) goto L_0x0097
            if (r4 >= 0) goto L_0x0097
            goto L_0x0091
        L_0x00c2:
            boolean r0 = r0 instanceof com.igexin.push.d.c.k
            if (r0 == 0) goto L_0x0000
            com.igexin.b.a.d.c r0 = r8.j
            r0.b()
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "TaskService|queue -> secondRespQueue"
            com.igexin.b.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r0)
            goto L_0x0000
        L_0x00d4:
            r2 = move-exception
            if (r5 != 0) goto L_0x00e4
            int r4 = r0.b_()
            if (r4 <= r3) goto L_0x00e4
            if (r4 >= 0) goto L_0x00e4
            com.igexin.b.a.d.e r0 = (com.igexin.b.a.d.e) r0
            r0.c()
        L_0x00e4:
            r1.unlock()
            throw r2
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.g():void");
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.t = true;
            com.igexin.b.a.c.b.a("screenoff", new Object[0]);
            if (this.k.h.get() > 0) {
                a(this.k.h.get());
            }
        } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            this.t = false;
            com.igexin.b.a.c.b.a("screenon", new Object[0]);
        } else if (intent.getAction().startsWith("AlarmTaskSchedule.") || intent.getAction().startsWith("AlarmTaskScheduleBak.")) {
            com.igexin.b.a.c.b.a("receivealarm|" + this.t, new Object[0]);
            f();
        } else if (this.s.equals(intent.getAction())) {
            com.igexin.b.a.c.b.a("receive nioalarm", new Object[0]);
            try {
                com.igexin.b.a.c.b.a("TaskService|alarm time out #######", new Object[0]);
                com.igexin.b.a.b.a.a.f.a().e();
            } catch (Exception unused) {
            }
        }
    }
}
