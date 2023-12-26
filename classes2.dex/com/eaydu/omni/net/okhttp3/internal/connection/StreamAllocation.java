package com.eaydu.omni.net.okhttp3.internal.connection;

import com.eaydu.omni.net.okhttp3.Address;
import com.eaydu.omni.net.okhttp3.Call;
import com.eaydu.omni.net.okhttp3.ConnectionPool;
import com.eaydu.omni.net.okhttp3.EventListener;
import com.eaydu.omni.net.okhttp3.Interceptor;
import com.eaydu.omni.net.okhttp3.OkHttpClient;
import com.eaydu.omni.net.okhttp3.Route;
import com.eaydu.omni.net.okhttp3.internal.Internal;
import com.eaydu.omni.net.okhttp3.internal.Util;
import com.eaydu.omni.net.okhttp3.internal.connection.RouteSelector;
import com.eaydu.omni.net.okhttp3.internal.http.HttpCodec;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;

    public StreamAllocation(ConnectionPool connectionPool2, Address address2, Call call2, EventListener eventListener2, Object obj) {
        this.connectionPool = connectionPool2;
        this.address = address2;
        this.call = call2;
        this.eventListener = eventListener2;
        this.routeSelector = new RouteSelector(address2, routeDatabase(), call2, eventListener2);
        this.callStackTrace = obj;
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        try {
            HttpCodec newCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = newCodec;
            }
            return newCodec;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0.isHealthy(r9) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.eaydu.omni.net.okhttp3.internal.connection.RealConnection findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            com.eaydu.omni.net.okhttp3.internal.connection.RealConnection r0 = r3.findConnection(r4, r5, r6, r7, r8)
            com.eaydu.omni.net.okhttp3.ConnectionPool r1 = r3.connectionPool
            monitor-enter(r1)
            int r2 = r0.successCount     // Catch:{ all -> 0x0019 }
            if (r2 != 0) goto L_0x000d
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            return r0
        L_0x000d:
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            boolean r1 = r0.isHealthy(r9)
            if (r1 != 0) goto L_0x0018
            r3.noNewStreams()
            goto L_0x0000
        L_0x0018:
            return r0
        L_0x0019:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0019 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.net.okhttp3.internal.connection.StreamAllocation.findHealthyConnection(int, int, int, int, boolean, boolean):com.eaydu.omni.net.okhttp3.internal.connection.RealConnection");
    }

    private RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws IOException {
        RealConnection realConnection;
        Socket releaseIfNoNewStreams;
        RealConnection realConnection2;
        Socket socket;
        boolean z2;
        Route route2;
        boolean z3;
        RouteSelector.Selection selection;
        synchronized (this.connectionPool) {
            if (this.released) {
                throw new IllegalStateException("released");
            } else if (this.codec != null) {
                throw new IllegalStateException("codec != null");
            } else if (!this.canceled) {
                realConnection = this.connection;
                releaseIfNoNewStreams = releaseIfNoNewStreams();
                realConnection2 = this.connection;
                socket = null;
                if (realConnection2 != null) {
                    realConnection = null;
                } else {
                    realConnection2 = null;
                }
                if (!this.reportedAcquired) {
                    realConnection = null;
                }
                if (realConnection2 == null) {
                    Internal.instance.get(this.connectionPool, this.address, this, (Route) null);
                    RealConnection realConnection3 = this.connection;
                    if (realConnection3 != null) {
                        z2 = true;
                        realConnection2 = realConnection3;
                        route2 = null;
                    } else {
                        route2 = this.route;
                    }
                } else {
                    route2 = null;
                }
                z2 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        Util.closeQuietly(releaseIfNoNewStreams);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
        }
        if (realConnection2 != null) {
            return realConnection2;
        }
        if (route2 != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
            z3 = false;
        } else {
            this.routeSelection = this.routeSelector.next();
            z3 = true;
        }
        synchronized (this.connectionPool) {
            if (!this.canceled) {
                if (z3) {
                    List<Route> all = this.routeSelection.getAll();
                    int size = all.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        Route route3 = all.get(i5);
                        Internal.instance.get(this.connectionPool, this.address, this, route3);
                        RealConnection realConnection4 = this.connection;
                        if (realConnection4 != null) {
                            this.route = route3;
                            z2 = true;
                            realConnection2 = realConnection4;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (route2 == null) {
                        route2 = this.routeSelection.next();
                    }
                    this.route = route2;
                    this.refusedStreamCount = 0;
                    realConnection2 = new RealConnection(this.connectionPool, route2);
                    acquire(realConnection2, false);
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection2);
            return realConnection2;
        }
        realConnection2.connect(i, i2, i3, i4, z, this.call, this.eventListener);
        routeDatabase().connected(realConnection2.route());
        synchronized (this.connectionPool) {
            this.reportedAcquired = true;
            Internal.instance.put(this.connectionPool, realConnection2);
            if (realConnection2.isMultiplexed()) {
                socket = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                realConnection2 = this.connection;
            }
        }
        Util.closeQuietly(socket);
        this.eventListener.connectionAcquired(this.call, realConnection2);
        return realConnection2;
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection realConnection = this.connection;
        if (realConnection == null || !realConnection.noNewStreams) {
            return null;
        }
        return deallocate(false, false, true);
    }

    public void streamFinished(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket deallocate;
        boolean z2;
        this.eventListener.responseBodyEnd(this.call, j);
        synchronized (this.connectionPool) {
            if (httpCodec != null) {
                if (httpCodec == this.codec) {
                    if (!z) {
                        this.connection.successCount++;
                    }
                    realConnection = this.connection;
                    deallocate = deallocate(z, false, true);
                    if (this.connection != null) {
                        realConnection = null;
                    }
                    z2 = this.released;
                }
            }
            throw new IllegalStateException("expected " + this.codec + " but was " + httpCodec);
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (iOException != null) {
            this.eventListener.callFailed(this.call, iOException);
        } else if (z2) {
            this.eventListener.callEnd(this.call);
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public Route route() {
        return this.route;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public void release() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(false, true, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket deallocate;
        synchronized (this.connectionPool) {
            realConnection = this.connection;
            deallocate = deallocate(true, false, false);
            if (this.connection != null) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    private Socket deallocate(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.codec = null;
        }
        if (z2) {
            this.released = true;
        }
        RealConnection realConnection = this.connection;
        if (realConnection == null) {
            return null;
        }
        if (z) {
            realConnection.noNewStreams = true;
        }
        if (this.codec != null) {
            return null;
        }
        if (!this.released && !this.connection.noNewStreams) {
            return null;
        }
        release(this.connection);
        if (this.connection.allocations.isEmpty()) {
            this.connection.idleAtNanos = System.nanoTime();
            if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                socket = this.connection.socket();
                this.connection = null;
                return socket;
            }
        }
        socket = null;
        this.connection = null;
        return socket;
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            httpCodec = this.codec;
            realConnection = this.connection;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void streamFailed(java.io.IOException r7) {
        /*
            r6 = this;
            com.eaydu.omni.net.okhttp3.ConnectionPool r0 = r6.connectionPool
            monitor-enter(r0)
            boolean r1 = r7 instanceof com.eaydu.omni.net.okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x0065 }
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0023
            com.eaydu.omni.net.okhttp3.internal.http2.StreamResetException r7 = (com.eaydu.omni.net.okhttp3.internal.http2.StreamResetException) r7     // Catch:{ all -> 0x0065 }
            com.eaydu.omni.net.okhttp3.internal.http2.ErrorCode r7 = r7.errorCode     // Catch:{ all -> 0x0065 }
            com.eaydu.omni.net.okhttp3.internal.http2.ErrorCode r1 = com.eaydu.omni.net.okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0065 }
            if (r7 != r1) goto L_0x001c
            int r7 = r6.refusedStreamCount     // Catch:{ all -> 0x0065 }
            int r7 = r7 + r4
            r6.refusedStreamCount = r7     // Catch:{ all -> 0x0065 }
            if (r7 <= r4) goto L_0x0046
            r6.route = r3     // Catch:{ all -> 0x0065 }
            goto L_0x0044
        L_0x001c:
            com.eaydu.omni.net.okhttp3.internal.http2.ErrorCode r1 = com.eaydu.omni.net.okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ all -> 0x0065 }
            if (r7 == r1) goto L_0x0046
            r6.route = r3     // Catch:{ all -> 0x0065 }
            goto L_0x0044
        L_0x0023:
            com.eaydu.omni.net.okhttp3.internal.connection.RealConnection r1 = r6.connection     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0046
            boolean r1 = r1.isMultiplexed()     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0031
            boolean r1 = r7 instanceof com.eaydu.omni.net.okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0046
        L_0x0031:
            com.eaydu.omni.net.okhttp3.internal.connection.RealConnection r1 = r6.connection     // Catch:{ all -> 0x0065 }
            int r1 = r1.successCount     // Catch:{ all -> 0x0065 }
            if (r1 != 0) goto L_0x0044
            com.eaydu.omni.net.okhttp3.Route r1 = r6.route     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x0042
            if (r7 == 0) goto L_0x0042
            com.eaydu.omni.net.okhttp3.internal.connection.RouteSelector r5 = r6.routeSelector     // Catch:{ all -> 0x0065 }
            r5.connectFailed(r1, r7)     // Catch:{ all -> 0x0065 }
        L_0x0042:
            r6.route = r3     // Catch:{ all -> 0x0065 }
        L_0x0044:
            r7 = r4
            goto L_0x0047
        L_0x0046:
            r7 = r2
        L_0x0047:
            com.eaydu.omni.net.okhttp3.internal.connection.RealConnection r1 = r6.connection     // Catch:{ all -> 0x0065 }
            java.net.Socket r7 = r6.deallocate(r7, r2, r4)     // Catch:{ all -> 0x0065 }
            com.eaydu.omni.net.okhttp3.internal.connection.RealConnection r2 = r6.connection     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0057
            boolean r2 = r6.reportedAcquired     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r3 = r1
        L_0x0057:
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            com.eaydu.omni.net.okhttp3.internal.Util.closeQuietly((java.net.Socket) r7)
            if (r3 == 0) goto L_0x0064
            com.eaydu.omni.net.okhttp3.EventListener r7 = r6.eventListener
            com.eaydu.omni.net.okhttp3.Call r0 = r6.call
            r7.connectionReleased(r0, r3)
        L_0x0064:
            return
        L_0x0065:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0065 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.net.okhttp3.internal.connection.StreamAllocation.streamFailed(java.io.IOException):void");
    }

    public void acquire(RealConnection realConnection, boolean z) {
        if (this.connection == null) {
            this.connection = realConnection;
            this.reportedAcquired = z;
            realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.allocations.get(i).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if (this.codec == null && this.connection.allocations.size() == 1) {
            Socket deallocate = deallocate(true, false, false);
            this.connection = realConnection;
            realConnection.allocations.add(this.connection.allocations.get(0));
            return deallocate;
        }
        throw new IllegalStateException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.routeSelection;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasMoreRoutes() {
        /*
            r1 = this;
            com.eaydu.omni.net.okhttp3.Route r0 = r1.route
            if (r0 != 0) goto L_0x0019
            com.eaydu.omni.net.okhttp3.internal.connection.RouteSelector$Selection r0 = r1.routeSelection
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x0019
        L_0x000e:
            com.eaydu.omni.net.okhttp3.internal.connection.RouteSelector r0 = r1.routeSelector
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.net.okhttp3.internal.connection.StreamAllocation.hasMoreRoutes():boolean");
    }

    public String toString() {
        RealConnection connection2 = connection();
        return connection2 != null ? connection2.toString() : this.address.toString();
    }

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }
}
