package com.bonree.sdk.ba;

import android.os.Message;
import com.bonree.sdk.aa.d;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.engine.state.i;
import com.bonree.sdk.agent.engine.webview.f;
import com.bonree.sdk.agent.engine.webview.g;
import com.bonree.sdk.ba.m;
import com.bonree.sdk.d.e;
import com.bonree.sdk.k.b;
import com.bonree.sdk.k.c;
import java.util.List;

public final class p extends com.bonree.sdk.ad.a implements d, i, f, b, com.bonree.sdk.x.d, com.bonree.sdk.y.d, com.bonree.sdk.z.d {
    private String f = "";
    private int g;
    private o h;

    public p(e eVar) {
        super((e) null);
        this.e = "BR-View-Thread";
        this.h = new o(com.bonree.sdk.ad.d.a().a(this.e));
    }

    public final synchronized boolean b() {
        a("View", a.d.a);
        if (!this.a) {
            this.a = true;
            a(this.e);
            if (com.bonree.sdk.ad.d.a().a(this.e) != this.h.getLooper()) {
                this.h = new o(com.bonree.sdk.ad.d.a().a(this.e));
            }
            if (com.bonree.sdk.d.a.L()) {
                com.bonree.sdk.x.b.a().registerService(this);
                com.bonree.sdk.y.b.a().registerService(this);
            } else {
                com.bonree.sdk.z.b.a().registerService((com.bonree.sdk.z.d) this);
                com.bonree.sdk.aa.b.a().registerService(this);
            }
            com.bonree.sdk.k.d.a().a((b) this);
            g.a().registerService((f) this);
            com.bonree.sdk.agent.engine.state.f.getEngine().registerService((i) this);
            a("View", a.d.c);
            return true;
        }
        a("View", a.d.b);
        return true;
    }

    public final synchronized boolean c() {
        a("View", a.d.d);
        this.a = false;
        if (com.bonree.sdk.d.a.L()) {
            com.bonree.sdk.x.b.a().unRegisterService(this);
            com.bonree.sdk.y.b.a().unRegisterService(this);
        } else {
            com.bonree.sdk.z.b.a().unRegisterService((com.bonree.sdk.z.d) this);
            com.bonree.sdk.aa.b.a().unRegisterService(this);
        }
        Message obtain = Message.obtain();
        obtain.what = 1001;
        a(obtain);
        com.bonree.sdk.k.d.a().unRegisterService(this);
        g.a().unRegisterService((f) this);
        com.bonree.sdk.agent.engine.state.f.getEngine().unRegisterService((i) this);
        f();
        a("View", a.d.e);
        return true;
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        this.h.a(message);
    }

    public final void a(com.bonree.sdk.z.a aVar) {
        if (aVar != null && this.h != null) {
            try {
                if (aVar.e() == 0) {
                    if (!this.f.equals(aVar.c() + aVar.e())) {
                        this.g = 0;
                        a(1, (Object) aVar);
                    } else {
                        this.g++;
                    }
                } else if (aVar.e() == 1) {
                    int i = this.g;
                    if (i == 0) {
                        a(1, (Object) aVar);
                    } else {
                        this.g = i - 1;
                    }
                }
                this.f = aVar.c() + aVar.e();
            } catch (Exception unused) {
            }
        }
    }

    public final void a(com.bonree.sdk.aa.a aVar) {
        if (aVar != null && aVar.a() != null) {
            a(2, (Object) aVar);
        }
    }

    public final void a(c cVar) {
        o oVar;
        if (cVar != null && (oVar = this.h) != null && !oVar.b()) {
            a(3, (Object) cVar);
        }
    }

    public final void a(com.bonree.sdk.ab.d dVar) {
        if (dVar != null && dVar.a() != null) {
            a(4, (Object) dVar.a());
        }
    }

    public final void a(com.bonree.sdk.agent.engine.state.e eVar) {
        if (this.h != null) {
            a(7, (Object) eVar);
        }
    }

    public static void a(String str, String str2) {
        o oVar;
        p o = e.d().o();
        if (o == null || !o.a || (oVar = o.h) == null) {
            com.bonree.sdk.be.f a2 = com.bonree.sdk.be.a.a();
            Object[] objArr = new Object[1];
            objArr[0] = o == null ? null : Boolean.valueOf(o.a);
            a2.a("ViewService setCustomPage is stop! ViewService is %s", objArr);
            return;
        }
        o.a(5, (Object) oVar.a(true, str, str2));
    }

    public static void b(String str, String str2) {
        o oVar;
        p o = e.d().o();
        if (o != null && o.a && (oVar = o.h) != null) {
            o.a(5, (Object) oVar.a(false, str, str2));
        }
    }

    public static void a(long j, String str, int i, int i2, String str2, String str3, int i3) {
        p o = e.d().o();
        if (o == null || str == null || !o.a || o.h == null) {
            com.bonree.sdk.be.f a2 = com.bonree.sdk.be.a.a();
            Object[] objArr = new Object[1];
            objArr[0] = o == null ? null : Boolean.valueOf(o.a);
            a2.a("ViewService reportView is stop! ViewService is %s", objArr);
            return;
        }
        m.a aVar = new m.a(j, str, i, i2, str2, str3, i3);
        com.bonree.sdk.be.a.a().a("ViewService reporView platform %d, Data : %s", Integer.valueOf(aVar.f), aVar.toString());
        o.a(6, (Object) aVar);
    }

    public final void b(int i) {
        o oVar;
        if (i > 0 && (oVar = this.h) != null) {
            oVar.a(i);
        }
    }

    public final List<EventBean> a(boolean z) {
        o oVar;
        if (!this.a || (oVar = this.h) == null) {
            return null;
        }
        return oVar.a(z);
    }

    public final void a(com.bonree.sdk.x.a aVar) {
        if (aVar != null && this.h != null) {
            try {
                if (aVar.e() == 0) {
                    if (!this.f.equals(aVar.c() + aVar.e())) {
                        this.g = 0;
                        a(8, (Object) aVar);
                    } else {
                        this.g++;
                    }
                } else if (aVar.e() == 1) {
                    int i = this.g;
                    if (i == 0) {
                        a(8, (Object) aVar);
                    } else {
                        this.g = i - 1;
                    }
                }
                this.f = aVar.c() + aVar.e();
            } catch (Exception unused) {
            }
        }
    }

    public final void a(com.bonree.sdk.y.a aVar) {
        if (aVar != null && aVar.a() != null) {
            a(9, (Object) aVar);
        }
    }

    static class a {
        /* access modifiers changed from: private */
        public static final p a = new p((e) null);

        private a() {
        }
    }

    public static p a() {
        return a.a;
    }
}
