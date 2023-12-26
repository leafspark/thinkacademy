package com.igexin.b.a.b.a.a;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.igexin.b.a.b.b;
import com.igexin.b.a.d.e;
import com.igexin.push.core.c;
import com.igexin.push.util.m;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class f {
    private static final Object l = new Object();
    public Lock a;
    public Condition b;
    ConcurrentLinkedQueue<m> c;
    private b d;
    private Socket e;
    private l f;
    private n g;
    private c h;
    private final AtomicBoolean i;
    private boolean j;
    private final List<m> k;
    /* access modifiers changed from: private */
    public final Handler m;
    private long n;
    private final Comparator<m> o;

    private f() {
        this.i = new AtomicBoolean(false);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.a = reentrantLock;
        this.b = reentrantLock.newCondition();
        this.k = new ArrayList();
        this.c = new ConcurrentLinkedQueue<>();
        this.o = new j(this);
        this.m = c.a().b();
    }

    /* synthetic */ f(g gVar) {
        this();
    }

    public static f a() {
        return k.a;
    }

    /* access modifiers changed from: private */
    public void b(m mVar) {
        if (mVar.x <= 0 || mVar.C == null) {
            mVar.p();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        mVar.c(currentTimeMillis);
        synchronized (l) {
            this.k.add(mVar);
            Collections.sort(this.k, this.o);
            long millis = TimeUnit.SECONDS.toMillis((long) this.k.get(0).x);
            this.n = millis;
            if (millis > 0 && this.k.size() == 1) {
                com.igexin.b.a.c.b.a("GS-M|add : " + mVar.toString() + " --- " + mVar.c.getClass().getName() + " set alarm " + "delay = " + (this.n + com.igexin.b.a.d.f.u), new Object[0]);
                com.igexin.b.a.b.c.b().b(currentTimeMillis + this.n + com.igexin.b.a.d.f.u);
            }
        }
    }

    private void b(Socket socket) {
        l lVar = new l(new o(socket.getInputStream()), this.d);
        this.f = lVar;
        lVar.a(new h(this));
        com.igexin.b.a.b.c.b().a((e) this.f, true);
    }

    private void c(Socket socket) {
        n nVar = new n(new p(socket.getOutputStream()), this.d);
        this.g = nVar;
        nVar.a(new i(this));
        com.igexin.b.a.b.c.b().a((e) this.g, true);
    }

    /* access modifiers changed from: private */
    public void i() {
        if (!this.i.getAndSet(true)) {
            Handler handler = this.m;
            int ordinal = q.TCP_IO_EXCEPTION.ordinal();
            if (!(handler instanceof Handler)) {
                handler.sendEmptyMessage(ordinal);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler, ordinal);
            }
        }
    }

    private void j() {
        this.i.set(false);
        c.a().i().a(q.TCP_DISCONNECT_SUCCESS);
    }

    private void k() {
        com.igexin.b.a.c.b.a("GS-M|disconnect", new Object[0]);
        c cVar = this.h;
        if (cVar != null) {
            cVar.j();
        }
        n nVar = this.g;
        if (nVar != null) {
            nVar.j();
        }
        l lVar = this.f;
        if (lVar != null) {
            lVar.j();
        }
        Socket socket = this.e;
        if (socket != null) {
            try {
                if (!socket.isClosed()) {
                    this.e.close();
                }
            } catch (Exception unused) {
            }
        }
    }

    private void l() {
        n nVar = this.g;
        if (nVar != null) {
            nVar.i = null;
            this.g = null;
        }
        l lVar = this.f;
        if (lVar != null) {
            lVar.h = null;
            this.f = null;
        }
        this.h = null;
        this.e = null;
    }

    private boolean m() {
        c cVar = this.h;
        if (cVar != null && !cVar.d) {
            return false;
        }
        l lVar = this.f;
        if (lVar != null && !lVar.d) {
            return false;
        }
        n nVar = this.g;
        if (nVar != null && !nVar.d) {
            return false;
        }
        l();
        return true;
    }

    private boolean n() {
        Socket socket = this.e;
        return socket != null && !socket.isClosed();
    }

    private void o() {
        if (!m.b()) {
            com.igexin.b.a.b.c.b().e();
            com.igexin.b.a.c.b.a("GS-M|cancel alrm", new Object[0]);
            synchronized (l) {
                if (!this.k.isEmpty()) {
                    for (m p : this.k) {
                        p.p();
                    }
                    this.k.clear();
                }
            }
        }
        if (!this.c.isEmpty()) {
            Iterator<m> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().p();
            }
            this.c.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.igexin.b.a.b.a.a.m r2) {
        /*
            r1 = this;
            java.util.concurrent.locks.Lock r0 = r1.a     // Catch:{ Exception -> 0x000f, all -> 0x0015 }
            r0.lock()     // Catch:{ Exception -> 0x000f, all -> 0x0015 }
            java.util.concurrent.ConcurrentLinkedQueue<com.igexin.b.a.b.a.a.m> r0 = r1.c     // Catch:{ Exception -> 0x000f, all -> 0x0015 }
            r0.offer(r2)     // Catch:{ Exception -> 0x000f, all -> 0x0015 }
            java.util.concurrent.locks.Condition r2 = r1.b     // Catch:{ Exception -> 0x000f, all -> 0x0015 }
            r2.signalAll()     // Catch:{ Exception -> 0x000f, all -> 0x0015 }
        L_0x000f:
            java.util.concurrent.locks.Lock r2 = r1.a     // Catch:{ Exception -> 0x001c }
            r2.unlock()     // Catch:{ Exception -> 0x001c }
            goto L_0x001c
        L_0x0015:
            r2 = move-exception
            java.util.concurrent.locks.Lock r0 = r1.a     // Catch:{ Exception -> 0x001b }
            r0.unlock()     // Catch:{ Exception -> 0x001b }
        L_0x001b:
            throw r2
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.f.a(com.igexin.b.a.b.a.a.m):void");
    }

    public void a(b bVar) {
        this.d = bVar;
        l lVar = this.f;
        if (lVar != null) {
            lVar.i = bVar;
        }
        n nVar = this.g;
        if (nVar != null) {
            nVar.h = bVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cf, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r12) {
        /*
            r11 = this;
            boolean r0 = com.igexin.push.util.m.b()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Object r2 = l
            monitor-enter(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r3.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r4 = "GS-M|receive: "
            r3.append(r4)     // Catch:{ all -> 0x00d0 }
            r3.append(r12)     // Catch:{ all -> 0x00d0 }
            java.lang.String r12 = " -- resp -----"
            r3.append(r12)     // Catch:{ all -> 0x00d0 }
            java.lang.String r12 = r3.toString()     // Catch:{ all -> 0x00d0 }
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x00d0 }
            com.igexin.b.a.c.b.a((java.lang.String) r12, (java.lang.Object[]) r4)     // Catch:{ all -> 0x00d0 }
            java.util.List<com.igexin.b.a.b.a.a.m> r12 = r11.k     // Catch:{ all -> 0x00d0 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x00d0 }
        L_0x0030:
            boolean r4 = r12.hasNext()     // Catch:{ all -> 0x00d0 }
            r5 = 0
            if (r4 == 0) goto L_0x0066
            java.lang.Object r4 = r12.next()     // Catch:{ all -> 0x00d0 }
            com.igexin.b.a.b.a.a.m r4 = (com.igexin.b.a.b.a.a.m) r4     // Catch:{ all -> 0x00d0 }
            com.igexin.b.a.d.a.f r7 = r4.C     // Catch:{ all -> 0x00d0 }
            boolean r7 = r7.a(r0, r4)     // Catch:{ all -> 0x00d0 }
            if (r7 == 0) goto L_0x0053
            r4.p()     // Catch:{ all -> 0x00d0 }
            com.igexin.b.a.d.a.f r7 = r4.C     // Catch:{ all -> 0x00d0 }
            r7.a(r4)     // Catch:{ all -> 0x00d0 }
            r4 = 1
            r12.remove()     // Catch:{ all -> 0x00d0 }
            goto L_0x0067
        L_0x0053:
            com.igexin.b.a.d.a.f r7 = r4.C     // Catch:{ all -> 0x00d0 }
            long r7 = r7.b(r0, r4)     // Catch:{ all -> 0x00d0 }
            long r9 = r11.n     // Catch:{ all -> 0x00d0 }
            int r4 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0063
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x0030
        L_0x0063:
            r11.n = r7     // Catch:{ all -> 0x00d0 }
            goto L_0x0030
        L_0x0066:
            r4 = r3
        L_0x0067:
            com.igexin.b.a.b.c r12 = com.igexin.b.a.b.c.b()     // Catch:{ all -> 0x00d0 }
            r12.e()     // Catch:{ all -> 0x00d0 }
            if (r4 == 0) goto L_0x007c
            java.lang.String r12 = "GS-M|time out"
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x00d0 }
            com.igexin.b.a.c.b.a((java.lang.String) r12, (java.lang.Object[]) r0)     // Catch:{ all -> 0x00d0 }
            r11.e()     // Catch:{ all -> 0x00d0 }
            monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
            return
        L_0x007c:
            java.util.List<com.igexin.b.a.b.a.a.m> r12 = r11.k     // Catch:{ all -> 0x00d0 }
            int r12 = r12.size()     // Catch:{ all -> 0x00d0 }
            if (r12 <= 0) goto L_0x009b
            java.util.List<com.igexin.b.a.b.a.a.m> r12 = r11.k     // Catch:{ all -> 0x00d0 }
            java.lang.Object r12 = r12.get(r3)     // Catch:{ all -> 0x00d0 }
            com.igexin.b.a.b.a.a.m r12 = (com.igexin.b.a.b.a.a.m) r12     // Catch:{ all -> 0x00d0 }
            r12.p()     // Catch:{ all -> 0x00d0 }
            com.igexin.b.a.b.c r4 = com.igexin.b.a.b.c.b()     // Catch:{ all -> 0x00d0 }
            r4.a((java.lang.Object) r12)     // Catch:{ all -> 0x00d0 }
            java.util.List<com.igexin.b.a.b.a.a.m> r4 = r11.k     // Catch:{ all -> 0x00d0 }
            r4.remove(r12)     // Catch:{ all -> 0x00d0 }
        L_0x009b:
            java.util.List<com.igexin.b.a.b.a.a.m> r12 = r11.k     // Catch:{ all -> 0x00d0 }
            int r12 = r12.size()     // Catch:{ all -> 0x00d0 }
            if (r12 <= 0) goto L_0x00ce
            long r7 = r11.n     // Catch:{ all -> 0x00d0 }
            int r12 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r12 <= 0) goto L_0x00ce
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d0 }
            r12.<init>()     // Catch:{ all -> 0x00d0 }
            java.lang.String r4 = "GS-M|set alarm = "
            r12.append(r4)     // Catch:{ all -> 0x00d0 }
            long r4 = r11.n     // Catch:{ all -> 0x00d0 }
            r12.append(r4)     // Catch:{ all -> 0x00d0 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00d0 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00d0 }
            com.igexin.b.a.c.b.a((java.lang.String) r12, (java.lang.Object[]) r3)     // Catch:{ all -> 0x00d0 }
            com.igexin.b.a.b.c r12 = com.igexin.b.a.b.c.b()     // Catch:{ all -> 0x00d0 }
            long r3 = r11.n     // Catch:{ all -> 0x00d0 }
            long r0 = r0 + r3
            long r3 = com.igexin.b.a.d.f.u     // Catch:{ all -> 0x00d0 }
            long r0 = r0 + r3
            r12.b(r0)     // Catch:{ all -> 0x00d0 }
        L_0x00ce:
            monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
            return
        L_0x00d0:
            r12 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.f.a(java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public void a(Socket socket) {
        try {
            c cVar = this.h;
            if (cVar == null || !cVar.i()) {
                this.e = socket;
                b(socket);
                c(socket);
            }
        } catch (Exception e2) {
            com.igexin.b.a.c.b.a("GS-M|" + e2.toString(), new Object[0]);
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        c.a().i().a(q.TCP_IO_EXCEPTION);
    }

    public synchronized void c() {
        Handler handler = this.m;
        int ordinal = q.TCP_DISCONNECT.ordinal();
        if (!(handler instanceof Handler)) {
            handler.sendEmptyMessage(ordinal);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler, ordinal);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Handler handler = this.m;
        int ordinal = q.TCP_START_CONNECT.ordinal();
        if (!(handler instanceof Handler)) {
            handler.sendEmptyMessage(ordinal);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler, ordinal);
        }
        this.j = false;
    }

    public void e() {
        com.igexin.b.a.c.b.a("GS-M|alarm timeout~~", new Object[0]);
        i();
    }

    public void f() {
        o();
        if (!(this.h == null && this.g == null && this.f == null) && !m()) {
            k();
        } else {
            j();
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        boolean n2 = n();
        if (n2 || this.h != null) {
            com.igexin.b.a.c.b.a("GS-Mstart connect, isConnected = " + n2 + ", ctask = " + this.h, new Object[0]);
            return;
        }
        com.igexin.b.a.c.b.a("GS-M|disconnect = true, reconnect", new Object[0]);
        this.h = new c(new g(this));
        com.igexin.b.a.b.c.b().a((e) this.h, true);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (m() && !this.j) {
            j();
            this.j = true;
        }
    }
}
