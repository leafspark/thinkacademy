package com.bonree.sdk.bc;

import com.bonree.sdk.bd.e;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.channels.SelectionKey;

class k {
    private static bu c;
    private long a;
    private SelectionKey b;

    static void a(bu buVar) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected k(java.nio.channels.SelectableChannel r1, long r2) throws java.io.IOException {
        /*
            r0 = this;
            r0.<init>()
            r0.a = r2
            java.nio.channels.Selector r2 = java.nio.channels.Selector.open()     // Catch:{ all -> 0x0017 }
            r3 = 0
            r1.configureBlocking(r3)     // Catch:{ all -> 0x0015 }
            r3 = 1
            java.nio.channels.SelectionKey r3 = r1.register(r2, r3)     // Catch:{ all -> 0x0015 }
            r0.b = r3     // Catch:{ all -> 0x0015 }
            return
        L_0x0015:
            r3 = move-exception
            goto L_0x0019
        L_0x0017:
            r3 = move-exception
            r2 = 0
        L_0x0019:
            if (r2 == 0) goto L_0x001e
            r2.close()
        L_0x001e:
            r1.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bc.k.<init>(java.nio.channels.SelectableChannel, long):void");
    }

    protected static void a(SelectionKey selectionKey, long j) throws IOException {
        int i;
        long currentTimeMillis = j - System.currentTimeMillis();
        int i2 = (currentTimeMillis > 0 ? 1 : (currentTimeMillis == 0 ? 0 : -1));
        if (i2 > 0) {
            i = selectionKey.selector().select(currentTimeMillis);
        } else {
            i = i2 == 0 ? selectionKey.selector().selectNow() : 0;
        }
        if (i == 0) {
            throw new SocketTimeoutException();
        }
    }

    protected static void a(String str, SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr) {
        if (br.a("verbosemsg")) {
            System.err.println(e.a(str, bArr));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() throws IOException {
        this.b.selector().close();
        this.b.channel().close();
    }
}
