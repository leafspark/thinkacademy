package com.bonree.sdk.av;

import android.os.Handler;
import android.os.Message;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.LogReturnInfoBean;
import com.bonree.sdk.agent.business.entity.LogReturnUserInfoRequestBean;
import com.bonree.sdk.agent.engine.state.j;
import com.bonree.sdk.agent.engine.state.k;
import com.bonree.sdk.agent.engine.state.m;
import com.bonree.sdk.am.f;
import com.bonree.sdk.av.c;
import com.bonree.sdk.bs.aa;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.d.e;

public final class a extends com.bonree.sdk.ad.a implements j {
    private static final String f = "LogReturnService";
    private static final int h = 0;
    private static final int i = 1;
    private final b g;
    private volatile boolean j;

    /* synthetic */ a(e eVar, byte b) {
        this((e) null);
    }

    private a(e eVar) {
        super(eVar);
        this.g = new b();
    }

    public final void b(String str) {
        if (ad.a(str)) {
            return;
        }
        if (ad.a(this.g.c)) {
            this.g.c = str;
            b(1);
        } else if (!str.equals(this.g.c)) {
            this.g.c = str;
            b(1);
        }
    }

    public final void c(String str) {
        if (ad.a(str)) {
            return;
        }
        if (ad.a(this.g.d)) {
            this.g.d = str;
            b(0);
        } else if (!str.equals(this.g.d)) {
            this.g.d = str;
            b(0);
        }
    }

    private void b(int i2) {
        if (this.a) {
            LogReturnUserInfoRequestBean logReturnUserInfoRequestBean = new LogReturnUserInfoRequestBean();
            logReturnUserInfoRequestBean.appId = this.g.a;
            logReturnUserInfoRequestBean.deviceId = this.g.b;
            if (i2 == 0) {
                logReturnUserInfoRequestBean.userId = this.g.c;
                logReturnUserInfoRequestBean.extraInfo = this.g.d;
            } else if (i2 == 1) {
                logReturnUserInfoRequestBean.userId = this.g.c;
            }
            a(3, (Object) logReturnUserInfoRequestBean);
        }
    }

    public final boolean b() {
        if (!this.a) {
            a(f, a.d.a);
            this.a = true;
            a("BR-LogCycle-Thread");
            c.a.a.a((Handler) this.d);
            String d = aa.d(com.bonree.sdk.bs.a.a(), "logUserInfo", "logAppId");
            String d2 = aa.d(com.bonree.sdk.bs.a.a(), "logUserInfo", "logDeviceId");
            if (!ad.a(d) && !ad.a(d2) && (!d.equals(com.bonree.sdk.d.a.k().v()) || !d2.equals(f.d()))) {
                aa.a(com.bonree.sdk.bs.a.a(), "logUserInfo");
            }
            h();
            this.g.a = com.bonree.sdk.d.a.k().v();
            this.g.b = f.d();
            String d3 = aa.d(com.bonree.sdk.bs.a.a(), "logUserInfo", "logUserId");
            String d4 = aa.d(com.bonree.sdk.bs.a.a(), "logUserInfo", "logExtraInfo");
            if (ad.a(this.g.c) || ad.a(this.g.d)) {
                if (!ad.a(this.g.c)) {
                    if (!this.g.c.equals(d3)) {
                        b(1);
                    }
                } else if (!ad.a(this.g.d) && !this.g.d.equals(d4)) {
                    b(0);
                }
            } else if (!this.g.c.equals(d3) || !this.g.d.equals(d4)) {
                b(0);
            }
            a(f, a.d.c);
        } else {
            a(f, a.d.b);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        super.a(message);
        c.a.a.a(message);
    }

    private static void g() {
        aa.a(com.bonree.sdk.bs.a.a(), "logUserInfo");
    }

    private void h() {
        if (this.j && this.a) {
            c.a.a.a();
        }
    }

    private void i() {
        this.g.a = com.bonree.sdk.d.a.k().v();
        this.g.b = f.d();
        String d = aa.d(com.bonree.sdk.bs.a.a(), "logUserInfo", "logUserId");
        String d2 = aa.d(com.bonree.sdk.bs.a.a(), "logUserInfo", "logExtraInfo");
        if (ad.a(this.g.c) || ad.a(this.g.d)) {
            if (!ad.a(this.g.c)) {
                if (!this.g.c.equals(d)) {
                    b(1);
                }
            } else if (!ad.a(this.g.d) && !this.g.d.equals(d2)) {
                b(0);
            }
        } else if (!this.g.c.equals(d) || !this.g.d.equals(d2)) {
            b(0);
        }
    }

    public final boolean c() {
        if (this.a) {
            a(f, a.d.d);
            this.a = false;
            f();
            this.j = false;
        } else {
            this.c.d("LogReturnService no need stoped!", new Object[0]);
        }
        a(f, a.d.e);
        return true;
    }

    public final void a(LogReturnInfoBean logReturnInfoBean) {
        if (logReturnInfoBean != null && logReturnInfoBean.isLegal()) {
            this.j = true;
            c.a.a.a(logReturnInfoBean);
            h();
        }
    }

    public final void a() {
        m.g().registerService((j) this);
    }

    public final void d() {
        m.g().unRegisterService(this);
    }

    public static a e() {
        return C0008a.a;
    }

    /* renamed from: com.bonree.sdk.av.a$a  reason: collision with other inner class name */
    static class C0008a {
        /* access modifiers changed from: private */
        public static final a a = new a((e) null, (byte) 0);

        private C0008a() {
        }
    }

    public final void a(k kVar) {
        c.a.a.a(kVar);
    }
}
