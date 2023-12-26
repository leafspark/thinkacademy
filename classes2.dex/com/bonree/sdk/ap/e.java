package com.bonree.sdk.ap;

import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.ad.f;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.engine.state.i;
import com.bonree.sdk.x.b;
import com.bonree.sdk.x.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e extends f implements i, com.bonree.sdk.j.a, d, com.bonree.sdk.z.d {
    private final String g;
    private final a h;
    private volatile boolean i;

    /* synthetic */ e(com.bonree.sdk.d.e eVar, byte b) {
        this((com.bonree.sdk.d.e) null);
    }

    private e(com.bonree.sdk.d.e eVar) {
        super(eVar);
        this.g = "Lag";
        this.i = false;
        this.e = "BR-Lag-Thread";
        this.f = Collections.synchronizedList(new ArrayList());
        this.h = new a(this, this.f);
    }

    public final synchronized boolean b() {
        a("Lag", a.d.a);
        if (com.bonree.sdk.d.a.L()) {
            b.a().registerService(this);
        } else {
            com.bonree.sdk.z.b.a().registerService((com.bonree.sdk.z.d) this);
        }
        com.bonree.sdk.agent.engine.state.f.getEngine().registerService((i) this);
        h();
        a("Lag", a.d.b);
        return false;
    }

    private synchronized void h() {
        if (!this.a) {
            this.a = true;
            a(this.e);
            this.h.a(com.bonree.sdk.agent.engine.state.f.getEngine().getViewName());
            com.bonree.sdk.j.b.a().registerService(this);
            a("Lag", a.d.c);
            this.h.a();
        }
    }

    public final synchronized boolean c() {
        a("Lag", a.d.d);
        this.a = false;
        com.bonree.sdk.j.b.a().unRegisterService(this);
        if (com.bonree.sdk.d.a.L()) {
            b.a().unRegisterService(this);
        } else {
            com.bonree.sdk.z.b.a().unRegisterService((com.bonree.sdk.z.d) this);
        }
        com.bonree.sdk.agent.engine.state.f.getEngine().unRegisterService((i) this);
        this.f.clear();
        f();
        this.h.c();
        a("Lag", a.d.e);
        return true;
    }

    public final void a(com.bonree.sdk.z.a aVar) {
        if (aVar != null) {
            this.h.a(aVar.a());
            if (aVar.e() == 1 && com.bonree.sdk.z.a.p.equals(aVar.c())) {
                try {
                    a(1, (Object) aVar);
                } catch (Exception unused) {
                }
            }
            if (TextUtils.equals(com.bonree.sdk.z.a.o, aVar.c()) && !this.i) {
                com.bonree.sdk.j.b.a().b();
                this.h.b();
                this.i = true;
            }
        }
    }

    public final void a(long j) {
        this.h.a(j);
    }

    public final void b(long j) {
        if (this.a) {
            this.h.b(j);
        }
    }

    public final boolean e() {
        return this.a;
    }

    public final void c(long j) {
        if (this.a) {
            this.h.c(j);
        }
    }

    public final void a(com.bonree.sdk.agent.engine.state.e eVar) {
        if (eVar == com.bonree.sdk.agent.engine.state.e.FOREGROUND) {
            if (!this.i) {
                com.bonree.sdk.j.b.a().b();
                this.h.b();
                this.i = true;
            }
        } else if (eVar == com.bonree.sdk.agent.engine.state.e.BACKGROUND) {
            com.bonree.sdk.j.b.a().c();
            if (this.i) {
                this.i = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        this.h.a(message);
    }

    public final List<EventBean> a(boolean z) {
        if (this.a) {
            return this.h.a(z);
        }
        return null;
    }

    public final void b(int i2) {
        if (i2 != 0) {
            this.h.a(i2);
        }
    }

    public final void c(int i2) {
        this.h.b(i2);
    }

    public final void d(int i2) {
        this.h.c(i2);
    }

    /* access modifiers changed from: protected */
    public final long a() {
        return super.a();
    }

    /* access modifiers changed from: protected */
    public final void d() {
        super.d();
    }

    public final void a(com.bonree.sdk.x.a aVar) {
        if (aVar != null) {
            this.h.b(aVar.a());
            if (aVar.e() == 1 && com.bonree.sdk.x.a.o.equals(aVar.c())) {
                try {
                    a(2, (Object) aVar);
                } catch (Exception unused) {
                }
            }
            if (TextUtils.equals(com.bonree.sdk.x.a.n, aVar.c()) && !this.i) {
                com.bonree.sdk.j.b.a().b();
                this.h.b();
                this.i = true;
            }
        }
    }

    public static e g() {
        return a.a;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final e a = new e((com.bonree.sdk.d.e) null, (byte) 0);

        private a() {
        }
    }
}
