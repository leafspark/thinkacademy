package org.apache.httpcore.pool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.httpcore.concurrent.FutureCallback;
import org.apache.httpcore.pool.PoolEntry;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.Asserts;

public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    private final LinkedList<E> available = new LinkedList<>();
    /* access modifiers changed from: private */
    public final Condition condition;
    private final ConnFactory<T, C> connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set<E> leased = new HashSet();
    /* access modifiers changed from: private */
    public final Lock lock;
    private final Map<T, Integer> maxPerRoute = new HashMap();
    private volatile int maxTotal;
    private final LinkedList<Future<E>> pending = new LinkedList<>();
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool = new HashMap();
    /* access modifiers changed from: private */
    public volatile int validateAfterInactivity;

    /* access modifiers changed from: protected */
    public abstract E createEntry(T t, C c);

    /* access modifiers changed from: protected */
    public void onLease(E e) {
    }

    /* access modifiers changed from: protected */
    public void onRelease(E e) {
    }

    /* access modifiers changed from: protected */
    public void onReuse(E e) {
    }

    /* access modifiers changed from: protected */
    public boolean validate(E e) {
        return true;
    }

    public AbstractConnPool(ConnFactory<T, C> connFactory2, int i, int i2) {
        this.connFactory = (ConnFactory) Args.notNull(connFactory2, "Connection factory");
        this.defaultMaxPerRoute = Args.positive(i, "Max per route value");
        this.maxTotal = Args.positive(i2, "Max total value");
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    public void shutdown() throws IOException {
        if (!this.isShutDown) {
            this.isShutDown = true;
            this.lock.lock();
            try {
                Iterator it = this.available.iterator();
                while (it.hasNext()) {
                    ((PoolEntry) it.next()).close();
                }
                for (E close : this.leased) {
                    close.close();
                }
                for (RouteSpecificPool<T, C, E> shutdown : this.routeToPool.values()) {
                    shutdown.shutdown();
                }
                this.routeToPool.clear();
                this.leased.clear();
                this.available.clear();
            } finally {
                this.lock.unlock();
            }
        }
    }

    private RouteSpecificPool<T, C, E> getPool(final T t) {
        RouteSpecificPool<T, C, E> routeSpecificPool = this.routeToPool.get(t);
        if (routeSpecificPool != null) {
            return routeSpecificPool;
        }
        AnonymousClass1 r0 = new RouteSpecificPool<T, C, E>(t) {
            /* access modifiers changed from: protected */
            public E createEntry(C c) {
                return AbstractConnPool.this.createEntry(t, c);
            }
        };
        this.routeToPool.put(t, r0);
        return r0;
    }

    /* access modifiers changed from: private */
    public static Exception operationAborted() {
        return new CancellationException("Operation aborted");
    }

    public Future<E> lease(final T t, final Object obj, final FutureCallback<E> futureCallback) {
        Args.notNull(t, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return new Future<E>() {
            private final AtomicBoolean cancelled = new AtomicBoolean(false);
            private final AtomicBoolean done = new AtomicBoolean(false);
            private final AtomicReference<E> entryRef = new AtomicReference<>((Object) null);

            /* JADX INFO: finally extract failed */
            public boolean cancel(boolean z) {
                if (!this.done.compareAndSet(false, true)) {
                    return false;
                }
                this.cancelled.set(true);
                AbstractConnPool.this.lock.lock();
                try {
                    AbstractConnPool.this.condition.signalAll();
                    AbstractConnPool.this.lock.unlock();
                    FutureCallback futureCallback = futureCallback;
                    if (futureCallback != null) {
                        futureCallback.cancelled();
                    }
                    return true;
                } catch (Throwable th) {
                    AbstractConnPool.this.lock.unlock();
                    throw th;
                }
            }

            public boolean isCancelled() {
                return this.cancelled.get();
            }

            public boolean isDone() {
                return this.done.get();
            }

            public E get() throws InterruptedException, ExecutionException {
                try {
                    return get(0, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e) {
                    throw new ExecutionException(e);
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
                if (r10.done.compareAndSet(false, true) == false) goto L_0x0072;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
                r10.entryRef.set(r2);
                r10.done.set(true);
                r10.this$0.onLease(r2);
                r11 = r5;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x006b, code lost:
                if (r11 == null) goto L_0x0070;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x006d, code lost:
                r11.completed(r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x0071, code lost:
                return r2;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
                r10.this$0.release(r2, true);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:31:0x0080, code lost:
                throw new java.util.concurrent.ExecutionException(org.apache.httpcore.pool.AbstractConnPool.access$200());
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public E get(long r11, java.util.concurrent.TimeUnit r13) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
                /*
                    r10 = this;
                L_0x0000:
                    monitor-enter(r10)
                    r0 = 0
                    r1 = 1
                    java.util.concurrent.atomic.AtomicReference<E> r2 = r10.entryRef     // Catch:{ IOException -> 0x008d }
                    java.lang.Object r2 = r2.get()     // Catch:{ IOException -> 0x008d }
                    org.apache.httpcore.pool.PoolEntry r2 = (org.apache.httpcore.pool.PoolEntry) r2     // Catch:{ IOException -> 0x008d }
                    if (r2 == 0) goto L_0x000f
                    monitor-exit(r10)     // Catch:{ all -> 0x008b }
                    return r2
                L_0x000f:
                    java.util.concurrent.atomic.AtomicBoolean r2 = r10.done     // Catch:{ IOException -> 0x008d }
                    boolean r2 = r2.get()     // Catch:{ IOException -> 0x008d }
                    if (r2 != 0) goto L_0x0081
                    org.apache.httpcore.pool.AbstractConnPool r3 = org.apache.httpcore.pool.AbstractConnPool.this     // Catch:{ IOException -> 0x008d }
                    java.lang.Object r4 = r3     // Catch:{ IOException -> 0x008d }
                    java.lang.Object r5 = r4     // Catch:{ IOException -> 0x008d }
                    r6 = r11
                    r8 = r13
                    r9 = r10
                    org.apache.httpcore.pool.PoolEntry r2 = r3.getPoolEntryBlocking(r4, r5, r6, r8, r9)     // Catch:{ IOException -> 0x008d }
                    org.apache.httpcore.pool.AbstractConnPool r3 = org.apache.httpcore.pool.AbstractConnPool.this     // Catch:{ IOException -> 0x008d }
                    int r3 = r3.validateAfterInactivity     // Catch:{ IOException -> 0x008d }
                    if (r3 <= 0) goto L_0x0052
                    long r3 = r2.getUpdated()     // Catch:{ IOException -> 0x008d }
                    org.apache.httpcore.pool.AbstractConnPool r5 = org.apache.httpcore.pool.AbstractConnPool.this     // Catch:{ IOException -> 0x008d }
                    int r5 = r5.validateAfterInactivity     // Catch:{ IOException -> 0x008d }
                    long r5 = (long) r5     // Catch:{ IOException -> 0x008d }
                    long r3 = r3 + r5
                    long r5 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x008d }
                    int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r3 > 0) goto L_0x0052
                    org.apache.httpcore.pool.AbstractConnPool r3 = org.apache.httpcore.pool.AbstractConnPool.this     // Catch:{ IOException -> 0x008d }
                    boolean r3 = r3.validate(r2)     // Catch:{ IOException -> 0x008d }
                    if (r3 != 0) goto L_0x0052
                    r2.close()     // Catch:{ IOException -> 0x008d }
                    org.apache.httpcore.pool.AbstractConnPool r3 = org.apache.httpcore.pool.AbstractConnPool.this     // Catch:{ IOException -> 0x008d }
                    r3.release(r2, (boolean) r0)     // Catch:{ IOException -> 0x008d }
                    monitor-exit(r10)     // Catch:{ all -> 0x008b }
                    goto L_0x0000
                L_0x0052:
                    java.util.concurrent.atomic.AtomicBoolean r11 = r10.done     // Catch:{ IOException -> 0x008d }
                    boolean r11 = r11.compareAndSet(r0, r1)     // Catch:{ IOException -> 0x008d }
                    if (r11 == 0) goto L_0x0072
                    java.util.concurrent.atomic.AtomicReference<E> r11 = r10.entryRef     // Catch:{ IOException -> 0x008d }
                    r11.set(r2)     // Catch:{ IOException -> 0x008d }
                    java.util.concurrent.atomic.AtomicBoolean r11 = r10.done     // Catch:{ IOException -> 0x008d }
                    r11.set(r1)     // Catch:{ IOException -> 0x008d }
                    org.apache.httpcore.pool.AbstractConnPool r11 = org.apache.httpcore.pool.AbstractConnPool.this     // Catch:{ IOException -> 0x008d }
                    r11.onLease(r2)     // Catch:{ IOException -> 0x008d }
                    org.apache.httpcore.concurrent.FutureCallback r11 = r5     // Catch:{ IOException -> 0x008d }
                    if (r11 == 0) goto L_0x0070
                    r11.completed(r2)     // Catch:{ IOException -> 0x008d }
                L_0x0070:
                    monitor-exit(r10)     // Catch:{ all -> 0x008b }
                    return r2
                L_0x0072:
                    org.apache.httpcore.pool.AbstractConnPool r11 = org.apache.httpcore.pool.AbstractConnPool.this     // Catch:{ IOException -> 0x008d }
                    r11.release(r2, (boolean) r1)     // Catch:{ IOException -> 0x008d }
                    java.util.concurrent.ExecutionException r11 = new java.util.concurrent.ExecutionException     // Catch:{ IOException -> 0x008d }
                    java.lang.Exception r12 = org.apache.httpcore.pool.AbstractConnPool.operationAborted()     // Catch:{ IOException -> 0x008d }
                    r11.<init>(r12)     // Catch:{ IOException -> 0x008d }
                    throw r11     // Catch:{ IOException -> 0x008d }
                L_0x0081:
                    java.util.concurrent.ExecutionException r11 = new java.util.concurrent.ExecutionException     // Catch:{ IOException -> 0x008d }
                    java.lang.Exception r12 = org.apache.httpcore.pool.AbstractConnPool.operationAborted()     // Catch:{ IOException -> 0x008d }
                    r11.<init>(r12)     // Catch:{ IOException -> 0x008d }
                    throw r11     // Catch:{ IOException -> 0x008d }
                L_0x008b:
                    r11 = move-exception
                    goto L_0x00a3
                L_0x008d:
                    r11 = move-exception
                    java.util.concurrent.atomic.AtomicBoolean r12 = r10.done     // Catch:{ all -> 0x008b }
                    boolean r12 = r12.compareAndSet(r0, r1)     // Catch:{ all -> 0x008b }
                    if (r12 == 0) goto L_0x009d
                    org.apache.httpcore.concurrent.FutureCallback r12 = r5     // Catch:{ all -> 0x008b }
                    if (r12 == 0) goto L_0x009d
                    r12.failed(r11)     // Catch:{ all -> 0x008b }
                L_0x009d:
                    java.util.concurrent.ExecutionException r12 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x008b }
                    r12.<init>(r11)     // Catch:{ all -> 0x008b }
                    throw r12     // Catch:{ all -> 0x008b }
                L_0x00a3:
                    monitor-exit(r10)     // Catch:{ all -> 0x008b }
                    throw r11
                */
                throw new UnsupportedOperationException("Method not decompiled: org.apache.httpcore.pool.AbstractConnPool.AnonymousClass2.get(long, java.util.concurrent.TimeUnit):org.apache.httpcore.pool.PoolEntry");
            }
        };
    }

    public Future<E> lease(T t, Object obj) {
        return lease(t, obj, (FutureCallback) null);
    }

    /* access modifiers changed from: private */
    public E getPoolEntryBlocking(T t, Object obj, long j, TimeUnit timeUnit, Future<E> future) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        RouteSpecificPool pool;
        E free;
        Date date = j > 0 ? new Date(System.currentTimeMillis() + timeUnit.toMillis(j)) : null;
        this.lock.lock();
        try {
            pool = getPool(t);
            while (true) {
                boolean z = true;
                Asserts.check(!this.isShutDown, "Connection pool shut down");
                if (!future.isCancelled()) {
                    while (true) {
                        free = pool.getFree(obj);
                        if (free != null) {
                            if (free.isExpired(System.currentTimeMillis())) {
                                free.close();
                            }
                            if (!free.isClosed()) {
                                break;
                            }
                            this.available.remove(free);
                            pool.free(free, false);
                        } else {
                            break;
                        }
                    }
                    if (free != null) {
                        this.available.remove(free);
                        this.leased.add(free);
                        onReuse(free);
                        this.lock.unlock();
                        return free;
                    }
                    int max = getMax(t);
                    int max2 = Math.max(0, (pool.getAllocatedCount() + 1) - max);
                    if (max2 > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= max2) {
                                break;
                            }
                            PoolEntry lastUsed = pool.getLastUsed();
                            if (lastUsed == null) {
                                break;
                            }
                            lastUsed.close();
                            this.available.remove(lastUsed);
                            pool.remove(lastUsed);
                            i++;
                        }
                    }
                    if (pool.getAllocatedCount() < max) {
                        int max3 = Math.max(this.maxTotal - this.leased.size(), 0);
                        if (max3 > 0) {
                            if (this.available.size() > max3 - 1 && !this.available.isEmpty()) {
                                PoolEntry poolEntry = (PoolEntry) this.available.removeLast();
                                poolEntry.close();
                                getPool(poolEntry.getRoute()).remove(poolEntry);
                            }
                            E add = pool.add(this.connFactory.create(t));
                            this.leased.add(add);
                            this.lock.unlock();
                            return add;
                        }
                    }
                    pool.queue(future);
                    this.pending.add(future);
                    if (date != null) {
                        z = this.condition.awaitUntil(date);
                    } else {
                        this.condition.await();
                    }
                    if (!future.isCancelled()) {
                        pool.unqueue(future);
                        this.pending.remove(future);
                        if (!z && date != null) {
                            if (date.getTime() <= System.currentTimeMillis()) {
                                throw new TimeoutException("Timeout waiting for connection");
                            }
                        }
                    } else {
                        throw new ExecutionException(operationAborted());
                    }
                } else {
                    throw new ExecutionException(operationAborted());
                }
            }
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public void release(E e, boolean z) {
        this.lock.lock();
        try {
            if (this.leased.remove(e)) {
                RouteSpecificPool pool = getPool(e.getRoute());
                pool.free(e, z);
                if (!z || this.isShutDown) {
                    e.close();
                } else {
                    this.available.addFirst(e);
                }
                onRelease(e);
                Future nextPending = pool.nextPending();
                if (nextPending != null) {
                    this.pending.remove(nextPending);
                } else {
                    nextPending = this.pending.poll();
                }
                if (nextPending != null) {
                    this.condition.signalAll();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    private int getMax(T t) {
        Integer num = this.maxPerRoute.get(t);
        return num != null ? num.intValue() : this.defaultMaxPerRoute;
    }

    public void setMaxTotal(int i) {
        Args.positive(i, "Max value");
        this.lock.lock();
        try {
            this.maxTotal = i;
        } finally {
            this.lock.unlock();
        }
    }

    public int getMaxTotal() {
        this.lock.lock();
        try {
            return this.maxTotal;
        } finally {
            this.lock.unlock();
        }
    }

    public void setDefaultMaxPerRoute(int i) {
        Args.positive(i, "Max per route value");
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = i;
        } finally {
            this.lock.unlock();
        }
    }

    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            return this.defaultMaxPerRoute;
        } finally {
            this.lock.unlock();
        }
    }

    public void setMaxPerRoute(T t, int i) {
        Args.notNull(t, "Route");
        this.lock.lock();
        if (i > -1) {
            try {
                this.maxPerRoute.put(t, Integer.valueOf(i));
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        } else {
            this.maxPerRoute.remove(t);
        }
        this.lock.unlock();
    }

    public int getMaxPerRoute(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            return getMax(t);
        } finally {
            this.lock.unlock();
        }
    }

    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
        } finally {
            this.lock.unlock();
        }
    }

    public PoolStats getStats(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            RouteSpecificPool pool = getPool(t);
            return new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), getMax(t));
        } finally {
            this.lock.unlock();
        }
    }

    public Set<T> getRoutes() {
        this.lock.lock();
        try {
            return new HashSet(this.routeToPool.keySet());
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void enumAvailable(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator it = this.available.iterator();
            while (it.hasNext()) {
                PoolEntry poolEntry = (PoolEntry) it.next();
                poolEntryCallback.process(poolEntry);
                if (poolEntry.isClosed()) {
                    getPool(poolEntry.getRoute()).remove(poolEntry);
                    it.remove();
                }
            }
            purgePoolMap();
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void enumLeased(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            for (E process : this.leased) {
                poolEntryCallback.process(process);
            }
        } finally {
            this.lock.unlock();
        }
    }

    private void purgePoolMap() {
        Iterator<Map.Entry<T, RouteSpecificPool<T, C, E>>> it = this.routeToPool.entrySet().iterator();
        while (it.hasNext()) {
            RouteSpecificPool routeSpecificPool = (RouteSpecificPool) it.next().getValue();
            if (routeSpecificPool.getPendingCount() + routeSpecificPool.getAllocatedCount() == 0) {
                it.remove();
            }
        }
    }

    public void closeIdle(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j);
        if (millis < 0) {
            millis = 0;
        }
        final long currentTimeMillis = System.currentTimeMillis() - millis;
        enumAvailable(new PoolEntryCallback<T, C>() {
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.getUpdated() <= currentTimeMillis) {
                    poolEntry.close();
                }
            }
        });
    }

    public void closeExpired() {
        final long currentTimeMillis = System.currentTimeMillis();
        enumAvailable(new PoolEntryCallback<T, C>() {
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.isExpired(currentTimeMillis)) {
                    poolEntry.close();
                }
            }
        });
    }

    public int getValidateAfterInactivity() {
        return this.validateAfterInactivity;
    }

    public void setValidateAfterInactivity(int i) {
        this.validateAfterInactivity = i;
    }

    public String toString() {
        this.lock.lock();
        try {
            return "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + "]";
        } finally {
            this.lock.unlock();
        }
    }
}
