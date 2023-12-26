package com.igexin.b.a.b.a.a;

import android.text.TextUtils;
import com.igexin.b.a.b.a.a.a.c;
import com.igexin.b.a.b.b;
import com.igexin.b.a.b.d;

public final class n extends a {
    private c K;
    public b h;
    p i;

    public n(p pVar, b bVar) {
        super(-2036, (String) null, bVar);
        this.h = bVar;
        this.i = pVar;
    }

    public void a(c cVar) {
        this.K = cVar;
    }

    public void b() {
        super.b();
        Thread currentThread = Thread.currentThread();
        com.igexin.b.a.c.b.a("GS-W|" + currentThread + " running", new Object[0]);
        f a = f.a();
        while (this.g && !currentThread.isInterrupted() && !this.d) {
            try {
                a.a.lock();
                if (a.c.isEmpty() && this.g) {
                    a.b.await();
                }
                m poll = a.c.poll();
                if (poll != null && this.g && this.i != null && this.g) {
                    this.e = b.NORMAL;
                    if (this.K != null && this.g) {
                        this.K.a(poll);
                    }
                    this.i.a((byte[]) this.h.d((d) null, poll.c));
                    if (poll.c != null) {
                        com.igexin.b.a.c.b.a("GS-W|" + poll.toString() + " --> " + poll.c.getClass().getName() + "-- send success", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                try {
                    a.a.unlock();
                } catch (Exception unused) {
                }
                throw th;
            }
            try {
                a.a.unlock();
            } catch (Exception unused2) {
            }
        }
        this.d = true;
        com.igexin.b.a.c.b.a("GS-W|finish ~~~~~~", new Object[0]);
    }

    public final int b_() {
        return -2036;
    }

    public void f() {
        super.f();
        com.igexin.b.a.c.b.a("GS-W|wt dispose", new Object[0]);
        if (this.K != null) {
            if (this.e != b.EXCEPTION) {
                this.K.a(this);
            } else if (!TextUtils.isEmpty(this.f)) {
                this.K.a(new Exception(this.f));
            }
        }
        this.K = null;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r2 = this;
            r0 = 0
            r2.g = r0
            com.igexin.b.a.b.a.a.b r0 = com.igexin.b.a.b.a.a.b.INTERRUPT
            r2.e = r0
            com.igexin.b.a.b.a.a.f r0 = com.igexin.b.a.b.a.a.f.a()
            boolean r1 = r2.d     // Catch:{ Exception -> 0x0019, all -> 0x001f }
            if (r1 != 0) goto L_0x0019
            java.util.concurrent.locks.Lock r1 = r0.a     // Catch:{ Exception -> 0x0019, all -> 0x001f }
            r1.lock()     // Catch:{ Exception -> 0x0019, all -> 0x001f }
            java.util.concurrent.locks.Condition r1 = r0.b     // Catch:{ Exception -> 0x0019, all -> 0x001f }
            r1.signalAll()     // Catch:{ Exception -> 0x0019, all -> 0x001f }
        L_0x0019:
            java.util.concurrent.locks.Lock r0 = r0.a     // Catch:{ Exception -> 0x0026 }
            r0.unlock()     // Catch:{ Exception -> 0x0026 }
            goto L_0x0026
        L_0x001f:
            r1 = move-exception
            java.util.concurrent.locks.Lock r0 = r0.a     // Catch:{ Exception -> 0x0025 }
            r0.unlock()     // Catch:{ Exception -> 0x0025 }
        L_0x0025:
            throw r1
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.n.j():void");
    }
}
