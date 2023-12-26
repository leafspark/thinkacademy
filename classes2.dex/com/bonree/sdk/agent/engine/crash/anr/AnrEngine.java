package com.bonree.sdk.agent.engine.crash.anr;

import android.app.ActivityManager;
import android.os.Build;
import android.os.FileObserver;
import android.os.SystemClock;
import com.bonree.sdk.agent.engine.crash.anr.d;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.s;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AnrEngine extends com.bonree.sdk.g.a<com.bonree.sdk.ah.a, com.bonree.sdk.agent.engine.crash.a> {
    private static final int a = 10000;
    private static final String b = "/data/anr/";
    private static final String c = "trace";
    private AtomicBoolean d;
    private FileObserver e;
    private d f;

    public static native int anrInit(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, boolean z5);

    public static void onFastAnr() {
    }

    public static native void stopCaughtAnr();

    /* synthetic */ AnrEngine(byte b2) {
        this();
    }

    private AnrEngine() {
        this.d = new AtomicBoolean(false);
    }

    public static AnrEngine getEngine() {
        return a.a;
    }

    /* access modifiers changed from: protected */
    public void startEngine() {
        com.bonree.sdk.be.a.a().c("anr engine is start.", new Object[0]);
        this.d.set(false);
        try {
            if (com.bonree.sdk.d.a.L()) {
                if (this.f == null) {
                    d dVar = new d();
                    this.f = dVar;
                    dVar.a((d.b) new c(this));
                    this.f.start();
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                initNativeAnrObserver();
            } else if (this.e == null) {
                b bVar = new b(this, b, 8);
                this.e = bVar;
                bVar.startWatching();
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("AnrEngine init error : ", th);
            this.e = null;
            if (com.bonree.sdk.d.a.L()) {
                this.f = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void stopEngine() {
        com.bonree.sdk.be.a.a().c("anr engine is stop.", new Object[0]);
        this.d.set(true);
        stopFileObserver();
        if (com.bonree.sdk.d.a.L()) {
            d dVar = this.f;
            if (dVar != null) {
                dVar.a();
                this.f = null;
            }
        } else if (s.a().b()) {
            stopCaughtAnr();
        }
    }

    private void a() {
        try {
            if (com.bonree.sdk.d.a.L()) {
                d();
            } else if (Build.VERSION.SDK_INT < 21) {
                c();
            } else {
                initNativeAnrObserver();
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("AnrEngine init error : ", th);
            this.e = null;
            if (com.bonree.sdk.d.a.L()) {
                this.f = null;
            }
        }
    }

    public static void initNativeAnrObserver() {
        boolean d2 = s.a().d();
        f a2 = com.bonree.sdk.be.a.a();
        a2.c("load lib" + s.a + ".so is %b", Boolean.valueOf(d2));
        if (d2) {
            com.bonree.sdk.bs.a.b().post(new a());
        }
    }

    private static void b() {
        com.bonree.sdk.bs.a.b().post(new a());
    }

    public static void onAnr(String str) {
        com.bonree.sdk.ah.a aVar = new com.bonree.sdk.ah.a();
        aVar.a((byte) 3);
        aVar.b(str);
        getEngine().a(aVar);
        getEngine().notifyService(aVar);
    }

    private void c() {
        if (this.e == null) {
            b bVar = new b(this, b, 8);
            this.e = bVar;
            bVar.startWatching();
        }
    }

    private void d() {
        if (this.f == null) {
            d dVar = new d();
            this.f = dVar;
            dVar.a((d.b) new c(this));
            this.f.start();
        }
    }

    private void e() {
        d dVar = this.f;
        if (dVar != null) {
            dVar.a();
            this.f = null;
        }
    }

    public void stopFileObserver() {
        FileObserver fileObserver = this.e;
        if (fileObserver != null) {
            fileObserver.stopWatching();
            this.e = null;
        }
    }

    public void notifyService(com.bonree.sdk.ah.a aVar) {
        this.readWriteLock.readLock().lock();
        try {
            for (com.bonree.sdk.agent.engine.crash.a a2 : this.services) {
                a2.a(aVar);
            }
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00aa, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.bonree.sdk.ah.a r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.bonree.sdk.d.a r0 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x00b7 }
            boolean r0 = r0.z()     // Catch:{ all -> 0x00b7 }
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L_0x0031
            com.bonree.sdk.be.f r10 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00b7 }
            java.lang.String r0 = "anr engine AndroidBoxMode is %s, android version is %s."
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00b7 }
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x00b7 }
            boolean r3 = r3.z()     // Catch:{ all -> 0x00b7 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00b7 }
            r1[r2] = r3     // Catch:{ all -> 0x00b7 }
            r2 = 1
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00b7 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00b7 }
            r1[r2] = r3     // Catch:{ all -> 0x00b7 }
            r10.c(r0, r1)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r9)
            return
        L_0x0031:
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00ab }
            java.lang.String r3 = "anr engine getErrorStateInfo"
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ab }
            r0.c(r3, r4)     // Catch:{ all -> 0x00ab }
            android.content.Context r0 = com.bonree.sdk.bs.a.a()     // Catch:{ all -> 0x00ab }
            java.lang.String r3 = "activity"
            java.lang.Object r0 = r0.getSystemService(r3)     // Catch:{ all -> 0x00ab }
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch:{ all -> 0x00ab }
            long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00ab }
        L_0x004c:
            java.util.concurrent.atomic.AtomicBoolean r5 = r9.d     // Catch:{ all -> 0x00ab }
            boolean r5 = r5.get()     // Catch:{ all -> 0x00ab }
            if (r5 != 0) goto L_0x0094
            long r5 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00ab }
            long r5 = r5 - r3
            r7 = 10000(0x2710, double:4.9407E-320)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x006b
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00ab }
            java.lang.String r1 = "anr engine getProcessErrorStateInfo is timeout."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ab }
            r0.c(r1, r2)     // Catch:{ all -> 0x00ab }
            goto L_0x0094
        L_0x006b:
            java.util.List r5 = r0.getProcessesInErrorState()     // Catch:{ all -> 0x00ab }
            if (r5 == 0) goto L_0x008e
            int r6 = r5.size()     // Catch:{ all -> 0x00ab }
            if (r6 <= 0) goto L_0x008e
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x00ab }
        L_0x007b:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x00ab }
            if (r6 == 0) goto L_0x008e
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x00ab }
            android.app.ActivityManager$ProcessErrorStateInfo r6 = (android.app.ActivityManager.ProcessErrorStateInfo) r6     // Catch:{ all -> 0x00ab }
            if (r6 == 0) goto L_0x007b
            int r7 = r6.condition     // Catch:{ all -> 0x00ab }
            if (r7 != r1) goto L_0x007b
            goto L_0x0095
        L_0x008e:
            r5 = 50
            com.bonree.sdk.bs.f.a(r5)     // Catch:{ all -> 0x00ab }
            goto L_0x004c
        L_0x0094:
            r6 = 0
        L_0x0095:
            if (r6 == 0) goto L_0x00a9
            int r0 = r6.pid     // Catch:{ all -> 0x00ab }
            int r1 = android.os.Process.myPid()     // Catch:{ all -> 0x00ab }
            if (r0 != r1) goto L_0x00a9
            java.lang.String r0 = r6.longMsg     // Catch:{ all -> 0x00ab }
            r10.c(r0)     // Catch:{ all -> 0x00ab }
            java.lang.String r0 = r6.shortMsg     // Catch:{ all -> 0x00ab }
            r10.a((java.lang.String) r0)     // Catch:{ all -> 0x00ab }
        L_0x00a9:
            monitor-exit(r9)
            return
        L_0x00ab:
            r10 = move-exception
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = "get ANR message from ProcessErrorStateInfo exception: "
            r0.a((java.lang.String) r1, (java.lang.Throwable) r10)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r9)
            return
        L_0x00b7:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.crash.anr.AnrEngine.a(com.bonree.sdk.ah.a):void");
    }

    private ActivityManager.ProcessErrorStateInfo f() {
        com.bonree.sdk.be.a.a().c("anr engine getErrorStateInfo", new Object[0]);
        ActivityManager activityManager = (ActivityManager) com.bonree.sdk.bs.a.a().getSystemService("activity");
        long uptimeMillis = SystemClock.uptimeMillis();
        while (!this.d.get()) {
            if (SystemClock.uptimeMillis() - uptimeMillis > 10000) {
                com.bonree.sdk.be.a.a().c("anr engine getProcessErrorStateInfo is timeout.", new Object[0]);
                return null;
            }
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null && processesInErrorState.size() > 0) {
                for (ActivityManager.ProcessErrorStateInfo next : processesInErrorState) {
                    if (next != null && next.condition == 2) {
                        return next;
                    }
                }
                continue;
            }
            com.bonree.sdk.bs.f.a(50);
        }
        return null;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final AnrEngine a = new AnrEngine((byte) 0);

        private a() {
        }
    }
}
