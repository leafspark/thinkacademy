package com.igexin.b.a.d;

import com.igexin.b.a.c.b;
import com.igexin.b.a.d.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class d<E extends e> {
    static final /* synthetic */ boolean i = true;
    public String a = getClass().getName();
    final transient ReentrantLock b;
    final transient Condition c;
    final TreeSet<E> d;
    final AtomicInteger e;
    int f;
    f g;
    public final AtomicLong h;

    public d(Comparator<? super E> comparator, f fVar) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.b = reentrantLock;
        this.c = reentrantLock.newCondition();
        this.e = new AtomicInteger(0);
        this.h = new AtomicLong(-1);
        this.d = new TreeSet<>(comparator);
        this.g = fVar;
    }

    private E e() {
        E a2 = a();
        if (a2 != null && this.d.remove(a2)) {
            return a2;
        }
        return null;
    }

    public final int a(E e2, long j, TimeUnit timeUnit) {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            if (!this.d.contains(e2)) {
                return -1;
            }
            this.d.remove(e2);
            e2.t = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
            int i2 = a(e2) ? 1 : -2;
            reentrantLock.unlock();
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public E a() {
        try {
            return (e) this.d.first();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    public final boolean a(E e2) {
        if (e2 == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            e a2 = a();
            int i2 = this.f + 1;
            this.f = i2;
            e2.u = i2;
            if (!this.d.add(e2)) {
                e2.u--;
                return false;
            }
            e2.n();
            if (a2 == null || this.d.comparator().compare(e2, a2) < 0) {
                this.c.signalAll();
            }
            reentrantLock.unlock();
            return true;
        } catch (Exception unused) {
            b.a("ScheduleQueue|offer|error", new Object[0]);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean a(Class cls) {
        if (cls == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<E> it = this.d.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (eVar.getClass() == cls) {
                    arrayList.add(eVar);
                }
            }
            this.d.removeAll(arrayList);
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            return this.d.isEmpty();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final E c() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                e a2 = a();
                boolean z = true;
                if (a2 == null) {
                    this.e.set(1);
                    this.f = 0;
                    this.c.await();
                } else {
                    long a3 = a2.a(TimeUnit.NANOSECONDS);
                    if (!a2.j) {
                        if (!a2.k) {
                            z = false;
                        }
                    }
                    if (a3 <= 0) {
                        break;
                    } else if (z) {
                        break;
                    } else {
                        this.h.set(a2.t);
                        b.a("schedule take|needAlarm = " + this.g.t + "|" + a2.getClass().getName() + "@" + a2.hashCode(), new Object[0]);
                        if (this.g.t) {
                            this.g.a(a2.t);
                        }
                        this.c.awaitNanos(a3);
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        E e2 = e();
        if (!i) {
            if (e2 == null) {
                throw new AssertionError();
            }
        }
        if (!b()) {
            this.c.signalAll();
        }
        this.h.set(-1);
        return e2;
    }

    public final void d() {
        this.d.clear();
    }
}
