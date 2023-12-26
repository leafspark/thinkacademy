package com.bonree.sdk.ac;

import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.ac.a;
import com.bonree.sdk.ac.f;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.CrashEventInfoBean;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.engine.state.i;
import com.bonree.sdk.agent.engine.webview.f;
import com.bonree.sdk.agent.engine.webview.g;
import com.bonree.sdk.d.e;
import com.bonree.sdk.k.b;
import com.bonree.sdk.z.d;
import java.util.List;
import java.util.UUID;

public final class c extends com.bonree.sdk.ad.a implements a.c, i, f, b, d {
    private final String f = "action";
    private b g;
    private volatile boolean h = false;
    private int i;
    private int j;
    private int k;
    private String l = "";
    private int m;
    private boolean n = false;

    public c(e eVar) {
        super((e) null);
        this.e = "BR-Action-Thread";
        this.g = new b(com.bonree.sdk.ad.d.a().a(this.e));
    }

    public final void a(boolean z, int i2, int i3, int i4) {
        this.h = z;
        if (i2 > 0) {
            this.j = i2;
        }
        if (i3 > 0) {
            this.i = i3;
        } else if (i3 == 0) {
            this.h = false;
        }
        if (i4 > 0) {
            this.k = i4;
        }
    }

    public final boolean a() {
        return this.h;
    }

    public final boolean b() {
        a("action", a.d.a);
        if (!this.a) {
            this.a = true;
            a(this.e);
            if (com.bonree.sdk.ad.d.a().a(this.e) != this.g.getLooper()) {
                this.g = new b(com.bonree.sdk.ad.d.a().a(this.e));
            }
            com.bonree.sdk.k.d.a().a((b) this);
            if (this.h) {
                g();
            }
            g.a().registerService((f) this);
            a("action", a.d.c);
            return true;
        }
        if (this.h) {
            g();
        } else {
            h();
        }
        a("action", a.d.b);
        return false;
    }

    private void g() {
        com.bonree.sdk.z.b.a().registerService((d) this);
        a(a.b.NETWORK, (a.c) this);
        a(a.b.CRASH, (a.c) this);
        com.bonree.sdk.agent.engine.state.f.getEngine().registerService((i) this);
        b.a(this.j, this.i, this.k);
    }

    public final void a(com.bonree.sdk.agent.engine.state.e eVar) {
        if (this.h) {
            a(8, (Object) eVar);
        }
    }

    public final boolean c() {
        a("action", a.d.d);
        this.a = false;
        this.g.a();
        com.bonree.sdk.k.d.a().unRegisterService(this);
        h();
        g.a().unRegisterService((f) this);
        f();
        a("action", a.d.e);
        return true;
    }

    private void h() {
        com.bonree.sdk.z.b.a().unRegisterService((d) this);
        b(a.b.NETWORK, (a.c) this);
        b(a.b.CRASH, (a.c) this);
        com.bonree.sdk.agent.engine.state.f.getEngine().unRegisterService((i) this);
        a.b.a.a(this.g);
    }

    public final void a(a.b bVar, EventBean eventBean) {
        if (bVar != null && eventBean != null) {
            if (bVar == a.b.NETWORK) {
                a(5, (Object) eventBean);
            } else if (bVar == a.b.CRASH && eventBean.mEventInfo != null && (eventBean.mEventInfo instanceof CrashEventInfoBean)) {
                if (((CrashEventInfoBean) eventBean.mEventInfo).iscustom) {
                    a(6, (Object) eventBean);
                } else {
                    b.a(eventBean);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        this.g.a(message);
    }

    public final List<EventBean> a(boolean z) {
        if (!this.a || this.g == null) {
            return null;
        }
        if (!this.h) {
            return this.g.a(z);
        }
        List<EventBean> a2 = this.g.a(z);
        a2.addAll(a.b.a.a());
        return a2;
    }

    public final void a(com.bonree.sdk.k.c cVar) {
        if (cVar != null) {
            if (cVar.d() == 5) {
                if (this.h) {
                    cVar.h(UUID.randomUUID().toString());
                }
                if (!TextUtils.equals("onPageSelected", cVar.c()) || cVar.p()) {
                    a(1, (Object) cVar);
                }
            }
            if (this.h) {
                a(4, (Object) cVar);
            }
        }
    }

    public final void a(com.bonree.sdk.z.a aVar) {
        if (this.h) {
            try {
                if (!TextUtils.equals(aVar.c(), com.bonree.sdk.z.a.q)) {
                    this.n = false;
                } else if (!this.n) {
                    this.n = true;
                } else {
                    return;
                }
                if (aVar.e() == 0) {
                    if (!this.l.equals(aVar.c() + aVar.e())) {
                        this.m = 0;
                        a(4, (Object) aVar);
                    } else {
                        this.m++;
                    }
                } else if (aVar.e() == 1) {
                    int i2 = this.m;
                    if (i2 == 0) {
                        a(4, (Object) aVar);
                    } else {
                        this.m = i2 - 1;
                    }
                }
                if (!this.n) {
                    this.l = aVar.c() + aVar.e();
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(com.bonree.sdk.ab.d dVar) {
        if (dVar != null && dVar.b() != null) {
            a(2, (Object) dVar.b());
        }
    }

    public final void d() {
        if (this.a && this.h) {
            com.bonree.sdk.k.c cVar = new com.bonree.sdk.k.c();
            cVar.a(15);
            cVar.a(com.bonree.sdk.d.a.b());
            cVar.b(com.bonree.sdk.d.a.l());
            cVar.f(String.valueOf(Thread.currentThread().getId()));
            a(4, (Object) cVar);
        }
    }

    public static void a(long j2, int i2, String str, String str2, String str3, int i3) {
        c i4 = e.d().i();
        if (i4 != null && i4.a) {
            f.a aVar = new f.a(j2, i2, str, str2, str3, i3);
            com.bonree.sdk.be.a.a().a("ActionService reporAction RnData : %s", aVar.toString());
            i4.a(3, (Object) aVar);
        }
    }

    static class a {
        /* access modifiers changed from: private */
        public static final c a = new c((e) null);

        private a() {
        }
    }

    public static c e() {
        return a.a;
    }
}
