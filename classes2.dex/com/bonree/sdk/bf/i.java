package com.bonree.sdk.bf;

import com.bonree.sdk.br.c;
import com.bonree.sdk.br.e;
import com.bonree.sdk.br.l;
import java.io.IOException;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class i<V, E extends Exception> implements c<V, E>, Future<V> {
    private static final ExecutorService f;
    private static /* synthetic */ boolean g = true;
    protected V a;
    protected E b;
    private boolean c;
    /* access modifiers changed from: private */
    public l<V> d;
    /* access modifiers changed from: private */
    public e<E> e;

    public interface a<EI extends Exception, EO extends Exception> {
        EO a(List<EI> list);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0013, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean cancel(boolean r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDone()     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x000a
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000a:
            r0 = 1
            r1.c = r0     // Catch:{ all -> 0x0014 }
            if (r2 == 0) goto L_0x0012
            r1.notifyAll()     // Catch:{ all -> 0x0014 }
        L_0x0012:
            monitor-exit(r1)
            return r0
        L_0x0014:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bf.i.cancel(boolean):boolean");
    }

    public final synchronized boolean isCancelled() {
        return this.c;
    }

    public final synchronized boolean isDone() {
        return b() || c();
    }

    private synchronized boolean b() {
        return this.a != null;
    }

    private synchronized boolean c() {
        return this.b != null;
    }

    public final c<V, E> a(l<V> lVar) {
        this.d = lVar;
        a();
        return this;
    }

    public final c<V, E> a(e<E> eVar) {
        this.e = eVar;
        a();
        return this;
    }

    private V d() throws ExecutionException {
        boolean z = g;
        if (z || this.a != null || this.b != null || this.c) {
            V v = this.a;
            if (v != null) {
                return v;
            }
            if (this.b != null) {
                throw new ExecutionException(this.b);
            } else if (z || this.c) {
                throw new CancellationException();
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    public final synchronized V get() throws InterruptedException, ExecutionException {
        while (this.a == null && this.b == null && !this.c) {
            wait();
        }
        return d();
    }

    private synchronized V e() throws Exception {
        V v;
        while (true) {
            v = this.a;
            if (v == null && this.b == null && !this.c) {
                try {
                    wait();
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                E e3 = this.b;
            }
        }
        E e32 = this.b;
        if (e32 != null) {
            throw e32;
        } else if (this.c) {
            throw new CancellationException();
        } else if (!g) {
            if (v == null) {
                throw new AssertionError();
            }
        }
        return v;
    }

    public final synchronized V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        V v;
        long currentTimeMillis = System.currentTimeMillis() + timeUnit.toMillis(j);
        while (true) {
            v = this.a;
            if (v != null && this.b != null && !this.c) {
                long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
                if (currentTimeMillis2 > 0) {
                    wait(currentTimeMillis2);
                }
            }
        }
        if (this.c) {
            throw new CancellationException();
        } else if (v == null || this.b == null) {
            throw new TimeoutException();
        }
        return d();
    }

    static {
        j jVar = new j();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(128);
        k kVar = new k();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors <= 4) {
            availableProcessors = 2;
        }
        f = new ThreadPoolExecutor(0, availableProcessors, 60, TimeUnit.SECONDS, arrayBlockingQueue, jVar, kVar);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.c     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            V r0 = r2.a     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x001b
            com.bonree.sdk.br.l<V> r0 = r2.d     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x001b
            java.util.concurrent.ExecutorService r0 = f     // Catch:{ all -> 0x002f }
            com.bonree.sdk.bf.l r1 = new com.bonree.sdk.bf.l     // Catch:{ all -> 0x002f }
            r1.<init>(r2)     // Catch:{ all -> 0x002f }
            r0.submit(r1)     // Catch:{ all -> 0x002f }
            monitor-exit(r2)
            return
        L_0x001b:
            E r0 = r2.b     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            com.bonree.sdk.br.e<E> r0 = r2.e     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            java.util.concurrent.ExecutorService r0 = f     // Catch:{ all -> 0x002f }
            com.bonree.sdk.bf.m r1 = new com.bonree.sdk.bf.m     // Catch:{ all -> 0x002f }
            r1.<init>(r2)     // Catch:{ all -> 0x002f }
            r0.submit(r1)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r2)
            return
        L_0x002f:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bf.i.a():void");
    }

    public static class b<V, E extends Exception> extends i<V, E> {
        public final synchronized void b(V v) {
            if (!isDone()) {
                this.a = v;
                notifyAll();
                a();
            }
        }

        public final synchronized void a(E e) {
            if (!isDone()) {
                this.b = e;
                notifyAll();
                a();
            }
        }
    }

    public static <V, E extends Exception> i<V, E> a(V v) {
        b bVar = new b();
        bVar.b(v);
        return bVar;
    }

    public static <V> i<V, IOException> a(Collection<i<V, IOException>> collection) {
        n nVar = new n();
        b bVar = new b();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(new ArrayList(collection.size()));
        for (i next : collection) {
            next.d = new o(collection, bVar);
            next.a();
            next.e = new p(copyOnWriteArrayList, collection, nVar, bVar);
            next.a();
        }
        return bVar;
    }

    private static <V, EI extends Exception, EO extends Exception> i<V, EO> a(Collection<i<V, EI>> collection, a<EI, EO> aVar) {
        b bVar = new b();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(new ArrayList(collection.size()));
        for (i next : collection) {
            next.a(new o(collection, bVar));
            next.a(new p(copyOnWriteArrayList, collection, aVar, bVar));
        }
        return bVar;
    }
}
