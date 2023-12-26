package com.bonree.sdk.j;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Printer;
import android.view.Choreographer;
import com.bonree.sdk.ad.d;
import com.bonree.sdk.bs.z;
import com.bonree.sdk.d.e;

public final class b extends com.bonree.sdk.g.a<Long, a> {
    private static String a = "BR-LagEngine-Thread";
    private static final int b = 1000000;
    private static final byte c = 0;
    private Handler d;
    private final Handler e;
    private Choreographer.FrameCallback f;
    private long g;
    private volatile boolean h;
    private a i;
    private Printer j;
    private final Runnable k;
    private final Runnable l;

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
        this.e = new Handler(Looper.getMainLooper());
        this.k = new c(this);
        this.l = new d(this);
    }

    public static b a() {
        return C0022b.a;
    }

    /* access modifiers changed from: protected */
    public final void startEngine() {
        super.startEngine();
        try {
            com.bonree.sdk.be.a.a().c("LagEngine is start.", new Object[0]);
            this.d = new e(this, d.a().a("BR-LagEngine-Thread"));
            this.f = new f(this);
            if (!com.bonree.sdk.d.a.k().J()) {
                b();
            }
            Printer printer = (Printer) z.a((Object) Looper.getMainLooper(), "mLogging", null, true);
            this.j = printer;
            if (!(printer instanceof a)) {
                if (this.i == null) {
                    this.i = new a(this, (byte) 0);
                }
                Looper.getMainLooper().setMessageLogging(this.i);
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("LagEngine startWorker error ", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void stopEngine() {
        super.stopEngine();
        e();
    }

    public final void a(long j2) {
        try {
            if (!isEmptyServices()) {
                e.d();
                if (!e.v()) {
                    notifyService(Long.valueOf(j2));
                    return;
                }
            }
            c();
            e();
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().c("LagEngine handleDoFrame is error: %s", th.toString());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void notifyService(Long l2) {
        if (l2 != null) {
            this.readWriteLock.readLock().lock();
            try {
                for (a aVar : this.services) {
                    if (aVar != null) {
                        aVar.a(l2.longValue());
                    }
                }
            } finally {
                this.readWriteLock.readLock().unlock();
            }
        }
    }

    private void d() {
        try {
            com.bonree.sdk.be.a.a().c("LagEngine is start.", new Object[0]);
            this.d = new e(this, d.a().a("BR-LagEngine-Thread"));
            this.f = new f(this);
            if (!com.bonree.sdk.d.a.k().J()) {
                b();
            }
            Printer printer = (Printer) z.a((Object) Looper.getMainLooper(), "mLogging", null, true);
            this.j = printer;
            if (!(printer instanceof a)) {
                if (this.i == null) {
                    this.i = new a(this, (byte) 0);
                }
                Looper.getMainLooper().setMessageLogging(this.i);
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("LagEngine startWorker error ", th);
        }
    }

    private void e() {
        try {
            com.bonree.sdk.be.a.a().c("LagEngine is stop.", new Object[0]);
            c();
            Handler handler = this.d;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            if (this.i != null) {
                this.i = null;
            }
            Printer printer = this.j;
            if (!(printer instanceof a)) {
                Looper.getMainLooper().setMessageLogging(printer);
            }
        } catch (Throwable th) {
            this.d = null;
            this.f = null;
            throw th;
        }
        this.d = null;
        this.f = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A[Catch:{ Exception -> 0x0071 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(long r9, long r11) {
        /*
            r8 = this;
            boolean r0 = r8.h
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x0015
            r8.g = r2
            com.bonree.sdk.be.f r9 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.String r11 = "LagEngine doFrame is stop."
            r9.c(r11, r10)
            return
        L_0x0015:
            long r4 = r8.g     // Catch:{ Exception -> 0x0071 }
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            r4 = 1000000(0xf4240, double:4.940656E-318)
            if (r0 != 0) goto L_0x002d
            long r6 = r9 / r4
            r8.g = r6     // Catch:{ Exception -> 0x0071 }
            com.bonree.sdk.be.f r0 = com.bonree.sdk.be.a.a()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r6 = "LagEngine doFrame is start."
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0071 }
            r0.c(r6, r7)     // Catch:{ Exception -> 0x0071 }
        L_0x002d:
            int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0049
            long r4 = r9 / r4
            long r6 = r8.g     // Catch:{ Exception -> 0x0071 }
            long r4 = r4 - r6
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x003b
            goto L_0x0049
        L_0x003b:
            com.bonree.sdk.be.f r9 = com.bonree.sdk.be.a.a()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r10 = "LagEngine doFrame is onPause."
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0071 }
            r9.c(r10, r11)     // Catch:{ Exception -> 0x0071 }
            r8.g = r2     // Catch:{ Exception -> 0x0071 }
            goto L_0x0064
        L_0x0049:
            com.bonree.sdk.ad.d r11 = com.bonree.sdk.ad.d.a()     // Catch:{ Exception -> 0x0071 }
            java.lang.String r12 = "BR-LagEngine-Thread"
            android.os.Handler r0 = r8.d     // Catch:{ Exception -> 0x0071 }
            boolean r11 = r11.a(r12, r0)     // Catch:{ Exception -> 0x0071 }
            if (r11 == 0) goto L_0x0064
            android.os.Handler r11 = r8.d     // Catch:{ Exception -> 0x0071 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ Exception -> 0x0071 }
            android.os.Message r9 = r11.obtainMessage(r1, r9)     // Catch:{ Exception -> 0x0071 }
            r9.sendToTarget()     // Catch:{ Exception -> 0x0071 }
        L_0x0064:
            com.bonree.sdk.d.a r9 = com.bonree.sdk.d.a.k()     // Catch:{ Exception -> 0x0071 }
            boolean r9 = r9.J()     // Catch:{ Exception -> 0x0071 }
            if (r9 != 0) goto L_0x0071
            r8.b()     // Catch:{ Exception -> 0x0071 }
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.j.b.a(long, long):void");
    }

    private void f() {
        try {
            if (Looper.myLooper() != null && this.f != null) {
                Choreographer.getInstance().postFrameCallback(this.f);
            }
        } catch (Throwable unused) {
        }
    }

    private void g() {
        try {
            if (Looper.myLooper() != null && this.f != null) {
                Choreographer.getInstance().removeFrameCallback(this.f);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        try {
            if (d.a().a("BR-LagEngine-Thread", this.d)) {
                if (!this.h) {
                    com.bonree.sdk.be.a.a().c("LagEngine startFrameListening", new Object[0]);
                }
                this.e.post(this.k);
            }
            this.h = true;
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("LagEngine startFrameListening error ", th);
        }
    }

    public final void c() {
        try {
            this.h = false;
            if (d.a().a("BR-LagEngine-Thread", this.d)) {
                this.e.post(this.l);
                com.bonree.sdk.be.a.a().c("LagEngine stopFrameListening", new Object[0]);
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("LagEngine stopFrameListening error ", th);
        }
    }

    /* renamed from: com.bonree.sdk.j.b$b  reason: collision with other inner class name */
    static class C0022b {
        /* access modifiers changed from: private */
        public static final b a = new b((byte) 0);

        private C0022b() {
        }
    }

    private static void a(Printer printer) {
        Looper.getMainLooper().setMessageLogging(printer);
    }

    class a implements Printer {
        private static final String a = ">>>>> Dispatching to";
        private static final String b = "<<<<< Finished to";

        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        public final void println(String str) {
            if (str.startsWith(a)) {
                com.bonree.sdk.ap.e.g().b(SystemClock.uptimeMillis());
                b.a(b.this, str);
            } else if (str.startsWith(b)) {
                b.a(b.this, str);
                com.bonree.sdk.ap.e.g().c(SystemClock.uptimeMillis());
            }
        }
    }

    private void a(String str) {
        Printer printer = this.j;
        if (printer != null && !(printer instanceof a)) {
            printer.println(str);
        }
    }

    static /* synthetic */ void a(b bVar) {
        try {
            if (Looper.myLooper() != null && bVar.f != null) {
                Choreographer.getInstance().postFrameCallback(bVar.f);
            }
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void b(b bVar) {
        try {
            if (Looper.myLooper() != null && bVar.f != null) {
                Choreographer.getInstance().removeFrameCallback(bVar.f);
            }
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ void a(b bVar, long j2, long j3) {
        if (!bVar.h) {
            bVar.g = 0;
            com.bonree.sdk.be.a.a().c("LagEngine doFrame is stop.", new Object[0]);
            return;
        }
        try {
            if (bVar.g == 0) {
                bVar.g = j2 / 1000000;
                com.bonree.sdk.be.a.a().c("LagEngine doFrame is start.", new Object[0]);
            }
            if (d.a().a("BR-LagEngine-Thread", bVar.d)) {
                bVar.d.obtainMessage(0, Long.valueOf(j2)).sendToTarget();
            }
            if (!com.bonree.sdk.d.a.k().J()) {
                bVar.b();
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(b bVar, String str) {
        Printer printer = bVar.j;
        if (printer != null && !(printer instanceof a)) {
            printer.println(str);
        }
    }
}
