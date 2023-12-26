package com.igexin.b.a.d;

import com.igexin.b.a.c.b;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

final class h implements Runnable {
    final BlockingQueue<e> a = new LinkedBlockingQueue();
    e b;
    e c;
    volatile int d;
    final /* synthetic */ g e;

    public h(g gVar, e eVar) {
        this.e = gVar;
        this.b = eVar;
    }

    public final void a() {
        this.a.clear();
        this.c = null;
    }

    public final void a(e eVar) {
        if (this.d == 0) {
            this.d = eVar.y;
        }
        boolean z = true;
        while (z) {
            try {
                eVar.b();
                eVar.g();
                eVar.e_();
                if (!eVar.s) {
                    eVar.c();
                }
                if (!eVar.j && eVar.n && eVar.t != 0) {
                }
            } catch (Exception e2) {
                b.a("TaskService" + e2.toString(), new Object[0]);
                eVar.s = true;
                eVar.A = e2;
                eVar.t();
                eVar.p();
                this.e.i.a((Object) eVar);
                this.e.i.f();
                if (!eVar.s) {
                    eVar.c();
                }
                if (!eVar.j && eVar.n && eVar.t != 0) {
                }
            } catch (Throwable th) {
                if (!eVar.s) {
                    eVar.c();
                }
                if (eVar.j || !eVar.n || eVar.t == 0) {
                    throw th;
                }
            }
            eVar = null;
            z = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final e b() {
        ReentrantLock reentrantLock;
        while (this.d != 0) {
            try {
                e poll = this.a.poll(this.e.e, TimeUnit.NANOSECONDS);
                if (poll != null) {
                    return poll;
                }
                if (this.a.isEmpty()) {
                    reentrantLock = this.e.c;
                    reentrantLock.lock();
                    if (!this.a.isEmpty()) {
                        reentrantLock.unlock();
                    } else {
                        this.e.b.remove(Integer.valueOf(this.d));
                        this.c.e();
                        this.d = 0;
                        reentrantLock.unlock();
                        return null;
                    }
                } else {
                    continue;
                }
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        return null;
    }

    public final void run() {
        boolean z = true;
        while (z) {
            try {
                e eVar = this.b;
                this.b = null;
                while (true) {
                    if (eVar == null) {
                        eVar = b();
                        if (eVar == null && (eVar = this.e.a()) == null) {
                            break;
                        }
                    }
                    this.c = null;
                    a(eVar);
                    this.c = eVar;
                    eVar = null;
                }
                z = this.e.a(this);
                if (z) {
                }
            } catch (Exception e2) {
                b.a("TaskService|Worker|run()|error" + e2.toString(), new Object[0]);
                z = this.e.a(this);
                if (z) {
                }
            } catch (Throwable th) {
                if (!this.e.a(this)) {
                    a();
                }
                throw th;
            }
            a();
        }
    }
}
