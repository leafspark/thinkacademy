package com.bonree.sdk.agent.engine.crash;

import android.os.Looper;
import com.bonree.sdk.ah.b;
import com.bonree.sdk.be.f;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class d extends com.bonree.sdk.g.a<b, b> implements Thread.UncaughtExceptionHandler {
    private static final String g = "com.facebook.react.common.JavascriptException";
    private Thread.UncaughtExceptionHandler a;
    private Thread.UncaughtExceptionHandler b;
    private final f c;
    private final AtomicBoolean d;
    private final Lock e;
    private b f;

    /* synthetic */ d(byte b2) {
        this();
    }

    private d() {
        this.c = com.bonree.sdk.be.a.a();
        this.d = new AtomicBoolean(false);
        this.e = new ReentrantLock();
    }

    public static d a() {
        return a.a;
    }

    /* access modifiers changed from: protected */
    public final void startEngine() {
        this.c.c("java crash engine start...", new Object[0]);
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == null) {
            this.c.d("default crash handler is NULL!!!", new Object[0]);
        } else if (defaultUncaughtExceptionHandler instanceof d) {
            this.c.d("Bonree crash handler already installed", new Object[0]);
        } else {
            this.a = defaultUncaughtExceptionHandler;
            this.f = new b();
            this.c.c("Installing Bonree crash handler and chaining %s", this.a.getClass().getName());
            Thread.setDefaultUncaughtExceptionHandler(this);
            try {
                Thread thread = Looper.getMainLooper().getThread();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
                if (uncaughtExceptionHandler == null) {
                    return;
                }
                if (!(uncaughtExceptionHandler instanceof d)) {
                    thread.setUncaughtExceptionHandler(this);
                    this.b = uncaughtExceptionHandler;
                    this.c.c("Installing Bonree crash handler and chaining on the main thread %s", uncaughtExceptionHandler.getClass().getName());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void stopEngine() {
        this.c.d("java crash engine stop!", new Object[0]);
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
            if (uncaughtExceptionHandler != null) {
                this.c.d("uninstalling Bonree crash handler and chaining %s", uncaughtExceptionHandler.getClass().getName());
                Thread.setDefaultUncaughtExceptionHandler(this.a);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.b;
            if (uncaughtExceptionHandler2 != null) {
                this.c.d("uninstalling Bonree crash handler and chaining main %s", uncaughtExceptionHandler2.getClass().getName());
                Looper.getMainLooper().getThread().setUncaughtExceptionHandler(this.b);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void notifyService(b bVar) {
        if (bVar == null) {
            this.c.d("no java crash data when notify services", new Object[0]);
            return;
        }
        this.readWriteLock.readLock().lock();
        try {
            for (b bVar2 : this.services) {
                if (bVar2 instanceof com.bonree.sdk.af.a) {
                    bVar2.a(bVar);
                }
            }
            for (b bVar3 : this.services) {
                if (!(bVar3 instanceof com.bonree.sdk.af.a)) {
                    bVar3.a(bVar);
                }
            }
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(13:7|8|(1:12)|13|14|(1:19)|20|21|(1:23)|24|25|26|35) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0089 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008d A[Catch:{ all -> 0x00ba, all -> 0x00c0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void uncaughtException(java.lang.Thread r5, java.lang.Throwable r6) {
        /*
            r4 = this;
            java.util.concurrent.locks.Lock r0 = r4.e
            r0.lock()
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.d     // Catch:{ all -> 0x00ba }
            boolean r0 = r0.get()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0013
            java.util.concurrent.locks.Lock r5 = r4.e     // Catch:{ all -> 0x0012 }
            r5.unlock()     // Catch:{ all -> 0x0012 }
        L_0x0012:
            return
        L_0x0013:
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.d     // Catch:{ all -> 0x00ba }
            r1 = 1
            r2 = 0
            r0.compareAndSet(r2, r1)     // Catch:{ all -> 0x00ba }
            com.bonree.sdk.ah.b r0 = r4.f     // Catch:{ all -> 0x00ba }
            r0.a = r5     // Catch:{ all -> 0x00ba }
            com.bonree.sdk.ah.b r0 = r4.f     // Catch:{ all -> 0x00ba }
            r0.b = r6     // Catch:{ all -> 0x00ba }
            com.bonree.sdk.be.f r0 = r4.c     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = "CrashEngine:mCrashThread:"
            r1.<init>(r3)     // Catch:{ all -> 0x00ba }
            r1.append(r5)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ba }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ba }
            r0.e(r1, r3)     // Catch:{ all -> 0x00ba }
            com.bonree.sdk.be.f r0 = r4.c     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = "CrashEngine:mThrowable:"
            r0.a((java.lang.String) r1, (java.lang.Throwable) r6)     // Catch:{ all -> 0x00ba }
            if (r6 == 0) goto L_0x0055
            java.lang.Class r0 = r6.getClass()     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = "com.facebook.react.common.JavascriptException"
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x00ba }
            if (r0 != 0) goto L_0x0055
            com.bonree.sdk.ah.b r0 = r4.f     // Catch:{ all -> 0x00ba }
            r4.notifyService(r0)     // Catch:{ all -> 0x00ba }
        L_0x0055:
            java.lang.Thread$UncaughtExceptionHandler r0 = r4.b     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x0089
            if (r5 == 0) goto L_0x0089
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x0089 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0089 }
            if (r5 != r0) goto L_0x0089
            com.bonree.sdk.be.f r0 = r4.c     // Catch:{ all -> 0x0089 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = "Callback previous main handler: "
            r1.<init>(r3)     // Catch:{ all -> 0x0089 }
            java.lang.Thread$UncaughtExceptionHandler r3 = r4.b     // Catch:{ all -> 0x0089 }
            java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0089 }
            r1.append(r3)     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0089 }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0089 }
            r0.b(r1, r3)     // Catch:{ all -> 0x0089 }
            java.lang.Thread$UncaughtExceptionHandler r0 = r4.b     // Catch:{ all -> 0x0089 }
            r0.uncaughtException(r5, r6)     // Catch:{ all -> 0x0089 }
        L_0x0089:
            java.lang.Thread$UncaughtExceptionHandler r0 = r4.a     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x00b1
            com.bonree.sdk.be.f r0 = r4.c     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = "Callback previous handler: "
            r1.<init>(r3)     // Catch:{ all -> 0x00ba }
            java.lang.Thread$UncaughtExceptionHandler r3 = r4.a     // Catch:{ all -> 0x00ba }
            java.lang.Class r3 = r3.getClass()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x00ba }
            r1.append(r3)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ba }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ba }
            r0.b(r1, r2)     // Catch:{ all -> 0x00ba }
            java.lang.Thread$UncaughtExceptionHandler r0 = r4.a     // Catch:{ all -> 0x00ba }
            r0.uncaughtException(r5, r6)     // Catch:{ all -> 0x00ba }
        L_0x00b1:
            r4.stopEngine()     // Catch:{ all -> 0x00ba }
            java.util.concurrent.locks.Lock r5 = r4.e     // Catch:{ all -> 0x00b9 }
            r5.unlock()     // Catch:{ all -> 0x00b9 }
        L_0x00b9:
            return
        L_0x00ba:
            r5 = move-exception
            java.util.concurrent.locks.Lock r6 = r4.e     // Catch:{ all -> 0x00c0 }
            r6.unlock()     // Catch:{ all -> 0x00c0 }
        L_0x00c0:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.crash.d.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }

    private void a(Thread thread, Throwable th) {
        try {
            if (!(this.b == null || thread == null || thread != Looper.getMainLooper().getThread())) {
                f fVar = this.c;
                fVar.b("Callback previous main handler: " + this.b.getClass().getName(), new Object[0]);
                this.b.uncaughtException(thread, th);
            }
        } catch (Throwable unused) {
        }
        if (this.a != null) {
            f fVar2 = this.c;
            fVar2.b("Callback previous handler: " + this.a.getClass().getName(), new Object[0]);
            this.a.uncaughtException(thread, th);
        }
    }

    static class a {
        /* access modifiers changed from: private */
        public static final d a = new d((byte) 0);

        private a() {
        }
    }
}
