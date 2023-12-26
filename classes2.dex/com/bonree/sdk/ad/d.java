package com.bonree.sdk.ad;

import android.os.HandlerThread;
import android.os.Looper;
import com.bonree.sdk.bs.k;
import java.util.Iterator;
import java.util.Map;

public final class d {
    private final Map<String, HandlerThread> a;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.a = new k();
    }

    static class a {
        /* access modifiers changed from: private */
        public static final d a = new d((byte) 0);

        private a() {
        }
    }

    public static d a() {
        return a.a;
    }

    private HandlerThread c(String str) {
        c();
        HandlerThread handlerThread = this.a.get(str);
        if (handlerThread == null) {
            handlerThread = new HandlerThread(str);
            handlerThread.start();
            synchronized (this.a) {
                this.a.put(str, handlerThread);
            }
        }
        return handlerThread;
    }

    public final synchronized Looper a(String str) {
        HandlerThread handlerThread;
        c();
        handlerThread = this.a.get(str);
        if (handlerThread == null) {
            handlerThread = c(str);
        }
        return handlerThread.getLooper();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0028, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x002d, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean a(java.lang.String r3, android.os.Handler r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            if (r4 != 0) goto L_0x0006
            monitor-exit(r2)
            return r0
        L_0x0006:
            java.util.Map<java.lang.String, android.os.HandlerThread> r1 = r2.a     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            android.os.HandlerThread r3 = (android.os.HandlerThread) r3     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            if (r3 != 0) goto L_0x0012
            monitor-exit(r2)
            return r0
        L_0x0012:
            android.os.Looper r1 = r3.getLooper()     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            if (r1 == 0) goto L_0x0027
            android.os.Looper r4 = r4.getLooper()     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            if (r4 == 0) goto L_0x0027
            boolean r3 = r3.isAlive()     // Catch:{ Exception -> 0x002c, all -> 0x0029 }
            if (r3 == 0) goto L_0x0027
            r3 = 1
            monitor-exit(r2)
            return r3
        L_0x0027:
            monitor-exit(r2)
            return r0
        L_0x0029:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        L_0x002c:
            monitor-exit(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ad.d.a(java.lang.String, android.os.Handler):boolean");
    }

    private void c() {
        Iterator<Map.Entry<String, HandlerThread>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            HandlerThread handlerThread = (HandlerThread) it.next().getValue();
            if (handlerThread != null && !handlerThread.isAlive()) {
                it.remove();
            }
        }
    }

    public final synchronized void b(String str) {
        Iterator<Map.Entry<String, HandlerThread>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            HandlerThread handlerThread = (HandlerThread) it.next().getValue();
            if (handlerThread != null && handlerThread.getName().equals(str) && handlerThread.isAlive()) {
                handlerThread.quit();
                it.remove();
            }
        }
    }

    public final synchronized void b() {
        for (String b : this.a.keySet()) {
            b(b);
        }
    }
}
