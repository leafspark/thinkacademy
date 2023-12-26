package com.bonree.sdk.m;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.ad.d;
import com.bonree.sdk.m.g;
import com.bonree.sdk.n.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a {
    private static final int a = 0;
    private static final String d = "BR-CacheData-Thread";
    private final ConcurrentLinkedQueue<Object> b;
    private Handler c;

    /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
        this.b = new ConcurrentLinkedQueue<>();
    }

    /* renamed from: com.bonree.sdk.m.a$a  reason: collision with other inner class name */
    static class C0023a {
        /* access modifiers changed from: private */
        public static final a a = new a((byte) 0);

        private C0023a() {
        }
    }

    public static a a() {
        return C0023a.a;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        try {
            if (this.c == null) {
                b bVar = new b(this, d.a().a(d), (byte) 0);
                this.c = bVar;
                bVar.sendEmptyMessageDelayed(0, 10000);
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("cacheData-handler startWorker error ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        try {
            d.a().b(d);
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("cacheData-handler stopWorker error ", th);
        } finally {
            this.c = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.Object r4) {
        /*
            r3 = this;
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Object> r0 = r3.b
            monitor-enter(r0)
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Object> r1 = r3.b     // Catch:{ all -> 0x0043 }
            int r1 = r1.size()     // Catch:{ all -> 0x0043 }
            r2 = 50
            if (r1 < r2) goto L_0x003c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = "cachedata length:"
            r1.<init>(r2)     // Catch:{ all -> 0x0043 }
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Object> r2 = r3.b     // Catch:{ all -> 0x0043 }
            int r2 = r2.size()     // Catch:{ all -> 0x0043 }
            r1.append(r2)     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0043 }
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0043 }
            com.bonree.sdk.be.g.a((java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0043 }
            com.bonree.sdk.n.b r4 = (com.bonree.sdk.n.b) r4     // Catch:{ all -> 0x0043 }
            boolean r1 = r4.p()     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x0031
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            return
        L_0x0031:
            r4.q()     // Catch:{ all -> 0x0043 }
            com.bonree.sdk.m.g r1 = com.bonree.sdk.m.g.a.a     // Catch:{ all -> 0x0043 }
            r1.notifyService((com.bonree.sdk.n.c) r4)     // Catch:{ all -> 0x0043 }
            goto L_0x0041
        L_0x003c:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Object> r1 = r3.b     // Catch:{ all -> 0x0043 }
            r1.add(r4)     // Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            return
        L_0x0043:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.m.a.a(java.lang.Object):void");
    }

    private void e() {
        synchronized (this.b) {
            if (!this.b.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<Object> it = this.b.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.bonree.sdk.n.b) {
                        com.bonree.sdk.n.b bVar = (com.bonree.sdk.n.b) next;
                        if (com.bonree.sdk.d.a.b() - bVar.c() >= 10000) {
                            arrayList.add(next);
                            if (!bVar.p()) {
                                bVar.q();
                                com.bonree.sdk.be.a.a().c("cachedata:%s", bVar);
                                g.a.a.notifyService((c) bVar);
                            }
                        }
                    }
                }
                this.b.removeAll(arrayList);
            }
        }
    }

    class b extends Handler {
        /* synthetic */ b(a aVar, Looper looper, byte b) {
            this(looper);
        }

        private b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            removeMessages(0);
            a.a(a.this);
            sendEmptyMessageDelayed(0, 10000);
        }
    }

    public final void d() {
        synchronized (this.b) {
            if (!this.b.isEmpty()) {
                this.b.clear();
            }
        }
    }

    static /* synthetic */ void a(a aVar) {
        synchronized (aVar.b) {
            if (!aVar.b.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<Object> it = aVar.b.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.bonree.sdk.n.b) {
                        com.bonree.sdk.n.b bVar = (com.bonree.sdk.n.b) next;
                        if (com.bonree.sdk.d.a.b() - bVar.c() >= 10000) {
                            arrayList.add(next);
                            if (!bVar.p()) {
                                bVar.q();
                                com.bonree.sdk.be.a.a().c("cachedata:%s", bVar);
                                g.a.a.notifyService((c) bVar);
                            }
                        }
                    }
                }
                aVar.b.removeAll(arrayList);
            }
        }
    }
}
