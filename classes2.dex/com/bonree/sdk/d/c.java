package com.bonree.sdk.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.e;
import com.bonree.sdk.d.a;
import com.igexin.assist.control.fcm.GTJobService;

public final class c {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 5;
    private static int e = 3;
    private static int f = 4;
    private static int g = 6;
    private static int h = 7;
    private static int i = 10;
    private static int j = 11;
    private static int k = 30000;
    /* access modifiers changed from: private */
    public long l;
    /* access modifiers changed from: private */
    public final f m;
    /* access modifiers changed from: private */
    public e n;
    private Handler o;
    private final HandlerThread p;
    private String q;

    /* synthetic */ c(byte b2) {
        this();
    }

    private c() {
        this.l = 0;
        this.m = com.bonree.sdk.be.a.a();
        this.q = "AgentImplHandler";
        this.p = new e(this.q);
    }

    static c a() {
        return b.a;
    }

    /* access modifiers changed from: package-private */
    public final void a(e eVar) {
        this.n = eVar;
        if (this.o == null) {
            this.p.start();
            this.o = new a(this.p.getLooper());
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.p.quit();
    }

    /* access modifiers changed from: package-private */
    public final HandlerThread c() {
        return this.p;
    }

    private boolean e() {
        return (this.o == null || !this.p.isAlive() || this.o.getLooper() == null || this.p.getLooper() == null) ? false : true;
    }

    static class b {
        /* access modifiers changed from: private */
        public static final c a = new c((byte) 0);

        private b() {
        }
    }

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message != null) {
                try {
                    int i = message.what;
                    if (i != 0) {
                        if (i == 1) {
                            boolean a2 = a();
                            if (!a2) {
                                a.a.a("NE");
                                c.this.m.e("sdk is about to stop... cause: netWork -> false", new Object[0]);
                                sendEmptyMessage(10);
                            }
                            if (!e.v() && a2) {
                                b();
                            }
                        } else if (i == 2) {
                            long unused = c.this.l = SystemClock.uptimeMillis();
                            if (c.this.n.y().e()) {
                                a(2);
                            }
                            com.bonree.sdk.e.b.b().a(com.bonree.sdk.agent.engine.state.e.BACKGROUND, false);
                        } else if (i != 3) {
                            if (i == 4) {
                                if (c.this.n.y().e()) {
                                    if (c.this.l > 0) {
                                        long uptimeMillis = SystemClock.uptimeMillis() - c.this.l;
                                        if (uptimeMillis > GTJobService.WAIT_TIME) {
                                            f b = c.this.m;
                                            b.c("CONFIG: BACKGROUND INTERVAL " + uptimeMillis, new Object[0]);
                                            f fVar = a.a;
                                            fVar.a("CONFIG: BACKGROUND INTERVAL " + uptimeMillis);
                                            b();
                                        } else {
                                            c.this.m.c("Less than 30000ms, recover response state", new Object[0]);
                                            a.a.a("Less than 30000ms, recover response state");
                                            removeMessages(4);
                                            removeMessages(3);
                                            sendEmptyMessageDelayed(3, c.this.n.y().f());
                                        }
                                    } else if (!hasMessages(3)) {
                                        long f = c.this.n.y().f();
                                        f b2 = c.this.m;
                                        b2.c("app Foregrounded : Raise the timer-- start timer cycle: " + f, new Object[0]);
                                        f fVar2 = a.a;
                                        fVar2.a("START TIMER :" + f);
                                        sendEmptyMessageDelayed(3, f);
                                    }
                                }
                                com.bonree.sdk.e.b.b().a(com.bonree.sdk.agent.engine.state.e.FOREGROUND, false);
                            } else if (i == 5) {
                                a(5);
                            } else if (i == 10) {
                                c.this.n.u();
                            } else if (i == 11) {
                                c.this.n.s();
                            }
                        } else if (!a.k().J()) {
                            a(3);
                        }
                    } else if (c.this.n.e()) {
                        a.f = a.c.c;
                    }
                } catch (Throwable th) {
                    c.this.m.e("init error %s", th.toString());
                }
            }
        }

        private boolean a() {
            while (!e.v() && !com.bonree.sdk.at.c.m().k()) {
                try {
                    SystemClock.sleep(5000);
                } catch (Throwable th) {
                    c.this.m.a("ConfigThread", th);
                    return false;
                }
            }
            return true;
        }

        private void b() {
            a.a.a("CF");
            com.bonree.sdk.b.a y = c.this.n.y();
            long unused = c.this.l = 0;
            com.bonree.sdk.e.b.b().a((com.bonree.sdk.agent.engine.state.e) null, true);
            int a2 = y.a();
            removeCallbacksAndMessages((Object) null);
            if (y.e()) {
                y.b().a(false);
                boolean z = !a.k().J();
                c.this.m.c("need upload ,current is background ?: %b", Boolean.valueOf(z));
                if (z) {
                    sendEmptyMessageDelayed(3, y.f());
                    return;
                }
                return;
            }
            a.a.a(" ConfigCode " + a2 + " ConfigNeedTrace:" + y.e());
            c.this.m.e("sdk is about to stop... cause: configCode " + a2 + " ConfigNeedTrace:" + y.e(), new Object[0]);
            sendEmptyMessage(10);
        }

        private void c() {
            if (c.this.l > 0) {
                long uptimeMillis = SystemClock.uptimeMillis() - c.this.l;
                if (uptimeMillis > GTJobService.WAIT_TIME) {
                    f b = c.this.m;
                    b.c("CONFIG: BACKGROUND INTERVAL " + uptimeMillis, new Object[0]);
                    f fVar = a.a;
                    fVar.a("CONFIG: BACKGROUND INTERVAL " + uptimeMillis);
                    b();
                    return;
                }
                c.this.m.c("Less than 30000ms, recover response state", new Object[0]);
                a.a.a("Less than 30000ms, recover response state");
                removeMessages(4);
                removeMessages(3);
                sendEmptyMessageDelayed(3, c.this.n.y().f());
            } else if (!hasMessages(3)) {
                long f = c.this.n.y().f();
                f b2 = c.this.m;
                b2.c("app Foregrounded : Raise the timer-- start timer cycle: " + f, new Object[0]);
                f fVar2 = a.a;
                fVar2.a("START TIMER :" + f);
                sendEmptyMessageDelayed(3, f);
            }
        }

        private void a(int i) {
            removeMessages(i);
            com.bonree.sdk.b.a y = c.this.n.y();
            f b = c.this.m;
            b.c("handle upload msg: " + i, new Object[0]);
            if (i == 5 || i == 7 || y.e()) {
                y.a(i);
                if (i == 3) {
                    sendEmptyMessageDelayed(3, y.f());
                    return;
                }
                return;
            }
            c.this.m.c("don't need upload~ ", new Object[0]);
        }
    }

    /* access modifiers changed from: package-private */
    public final Handler d() {
        if (!((this.o == null || !this.p.isAlive() || this.o.getLooper() == null || this.p.getLooper() == null) ? false : true)) {
            return null;
        }
        return this.o;
    }
}
