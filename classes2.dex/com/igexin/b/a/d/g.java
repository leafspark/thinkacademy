package com.igexin.b.a.d;

import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

final class g {
    final BlockingQueue<e> a = new SynchronousQueue();
    final HashMap<Integer, h> b = new HashMap<>();
    final ReentrantLock c = new ReentrantLock();
    ThreadFactory d = new i(this);
    volatile long e = TimeUnit.SECONDS.toNanos(60);
    volatile int f = 0;
    volatile int g;
    volatile int h = Integer.MAX_VALUE;
    final /* synthetic */ f i;

    public g(f fVar) {
        this.i = fVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|(1:3)(1:5)|4|(2:12|7)(1:8)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:9:0x0023, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.igexin.b.a.d.e a() {
        /*
            r4 = this;
        L_0x0000:
            int r0 = r4.g     // Catch:{ InterruptedException -> 0x0000 }
            int r1 = r4.f     // Catch:{ InterruptedException -> 0x0000 }
            if (r0 <= r1) goto L_0x0013
            java.util.concurrent.BlockingQueue<com.igexin.b.a.d.e> r0 = r4.a     // Catch:{ InterruptedException -> 0x0000 }
            long r1 = r4.e     // Catch:{ InterruptedException -> 0x0000 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ InterruptedException -> 0x0000 }
            java.lang.Object r0 = r0.poll(r1, r3)     // Catch:{ InterruptedException -> 0x0000 }
        L_0x0010:
            com.igexin.b.a.d.e r0 = (com.igexin.b.a.d.e) r0     // Catch:{ InterruptedException -> 0x0000 }
            goto L_0x001a
        L_0x0013:
            java.util.concurrent.BlockingQueue<com.igexin.b.a.d.e> r0 = r4.a     // Catch:{ InterruptedException -> 0x0000 }
            java.lang.Object r0 = r0.take()     // Catch:{ InterruptedException -> 0x0000 }
            goto L_0x0010
        L_0x001a:
            if (r0 == 0) goto L_0x001d
            return r0
        L_0x001d:
            java.util.concurrent.BlockingQueue<com.igexin.b.a.d.e> r0 = r4.a     // Catch:{ InterruptedException -> 0x0000 }
            boolean r0 = r0.isEmpty()     // Catch:{ InterruptedException -> 0x0000 }
            if (r0 == 0) goto L_0x0000
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.g.a():com.igexin.b.a.d.e");
    }

    /* access modifiers changed from: package-private */
    public final void a(e eVar) {
        Objects.requireNonNull(eVar);
        if (eVar.y != 0) {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                h hVar = this.b.get(Integer.valueOf(eVar.y));
                if (hVar != null) {
                    hVar.a.offer(eVar);
                    return;
                }
                reentrantLock.unlock();
            } finally {
                reentrantLock.unlock();
            }
        }
        b(eVar);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(h hVar) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            int i2 = this.g - 1;
            this.g = i2;
            if (i2 == 0 && !this.a.isEmpty()) {
                Thread f2 = f((e) null);
                if (f2 != null) {
                    if (!(f2 instanceof Thread)) {
                        f2.start();
                    } else {
                        AsynchronousInstrumentation.threadStart(f2);
                    }
                }
            } else if (!hVar.a.isEmpty()) {
                reentrantLock.unlock();
                return true;
            }
            this.b.remove(Integer.valueOf(hVar.d));
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(e eVar) {
        if (this.g < this.f && c(eVar)) {
            return;
        }
        if (!this.a.offer(eVar)) {
            d(eVar);
        } else if (this.g == 0) {
            e(eVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean c(e eVar) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Thread f2 = this.g < this.f ? f(eVar) : null;
            if (f2 == null) {
                return false;
            }
            if (!(f2 instanceof Thread)) {
                f2.start();
                return true;
            }
            AsynchronousInstrumentation.threadStart(f2);
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean d(e eVar) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Thread f2 = this.g < this.h ? f(eVar) : null;
            if (f2 == null) {
                return false;
            }
            if (!(f2 instanceof Thread)) {
                f2.start();
                return true;
            }
            AsynchronousInstrumentation.threadStart(f2);
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void e(e eVar) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Thread thread = null;
            if (this.g < Math.max(this.f, 1) && !this.a.isEmpty()) {
                thread = f((e) null);
            }
            if (thread == null) {
                return;
            }
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final Thread f(e eVar) {
        h hVar = new h(this, eVar);
        if (!(eVar == null || eVar.y == 0)) {
            this.b.put(Integer.valueOf(eVar.y), hVar);
        }
        Thread newThread = this.d.newThread(hVar);
        if (newThread != null) {
            this.g++;
        }
        return newThread;
    }
}
