package org.apache.httpcore.impl.pool;

import org.apache.httpcore.HttpClientConnection;
import org.apache.httpcore.HttpHost;
import org.apache.httpcore.pool.PoolEntry;

public class BasicPoolEntry extends PoolEntry<HttpHost, HttpClientConnection> {
    public BasicPoolEntry(String str, HttpHost httpHost, HttpClientConnection httpClientConnection) {
        super(str, httpHost, httpClientConnection);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0.shutdown();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.getConnection()     // Catch:{ IOException -> 0x001a }
            org.apache.httpcore.HttpClientConnection r0 = (org.apache.httpcore.HttpClientConnection) r0     // Catch:{ IOException -> 0x001a }
            int r1 = r0.getSocketTimeout()     // Catch:{ IOException -> 0x0017 }
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r1 <= 0) goto L_0x0010
            if (r1 <= r2) goto L_0x0013
        L_0x0010:
            r0.setSocketTimeout(r2)     // Catch:{ IOException -> 0x0017 }
        L_0x0013:
            r0.close()     // Catch:{ IOException -> 0x0017 }
            goto L_0x001a
        L_0x0017:
            r0.shutdown()     // Catch:{ IOException -> 0x001a }
        L_0x001a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.httpcore.impl.pool.BasicPoolEntry.close():void");
    }

    public boolean isClosed() {
        return !((HttpClientConnection) getConnection()).isOpen();
    }
}
