package org.apache.httpcore.impl.pool;

import java.util.concurrent.atomic.AtomicLong;
import org.apache.httpcore.HttpClientConnection;
import org.apache.httpcore.HttpHost;
import org.apache.httpcore.config.ConnectionConfig;
import org.apache.httpcore.config.SocketConfig;
import org.apache.httpcore.params.HttpParams;
import org.apache.httpcore.pool.AbstractConnPool;
import org.apache.httpcore.pool.ConnFactory;

public class BasicConnPool extends AbstractConnPool<HttpHost, HttpClientConnection, BasicPoolEntry> {
    private static final AtomicLong COUNTER = new AtomicLong();

    public BasicConnPool(ConnFactory<HttpHost, HttpClientConnection> connFactory) {
        super(connFactory, 2, 20);
    }

    @Deprecated
    public BasicConnPool(HttpParams httpParams) {
        super(new BasicConnFactory(httpParams), 2, 20);
    }

    public BasicConnPool(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        super(new BasicConnFactory(socketConfig, connectionConfig), 2, 20);
    }

    public BasicConnPool() {
        super(new BasicConnFactory(SocketConfig.DEFAULT, ConnectionConfig.DEFAULT), 2, 20);
    }

    /* access modifiers changed from: protected */
    public BasicPoolEntry createEntry(HttpHost httpHost, HttpClientConnection httpClientConnection) {
        return new BasicPoolEntry(Long.toString(COUNTER.getAndIncrement()), httpHost, httpClientConnection);
    }

    /* access modifiers changed from: protected */
    public boolean validate(BasicPoolEntry basicPoolEntry) {
        return !((HttpClientConnection) basicPoolEntry.getConnection()).isStale();
    }
}
