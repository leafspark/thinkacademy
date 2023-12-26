package com.bonree.sdk.al;

import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.d.e;
import java.util.List;

public final class b extends com.bonree.sdk.ad.a {
    private static final a g = new a();
    private final String f;
    private boolean h;
    private boolean i;
    private boolean j;

    /* synthetic */ b(e eVar, byte b) {
        this((e) null);
    }

    private b(e eVar) {
        super(eVar);
        this.f = "Custom";
    }

    public final synchronized boolean b() {
        a("Custom", a.d.a);
        this.c.c("customEventOpen:%b ,customLogOpen:%b ,customMetricOpen:%b ", Boolean.valueOf(this.h), Boolean.valueOf(this.i), Boolean.valueOf(this.j));
        if (!this.a) {
            this.a = true;
            a("Custom", a.d.c);
            return true;
        }
        a("Custom", a.d.b);
        return false;
    }

    public final synchronized boolean c() {
        a("Custom", a.d.d);
        this.a = false;
        this.j = false;
        this.i = false;
        this.h = false;
        g.d();
        a("Custom", a.d.e);
        return true;
    }

    private void b(String str, String str2) {
        a(str, str2, (String) null, (String) null);
    }

    public final void a(String str, String str2) {
        if (this.a && this.i) {
            g.a(str, str2);
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (this.a && this.h) {
            g.a(str, str2, str3, str4);
        }
    }

    public final void b(String str, String str2, String str3, String str4) {
        if (this.a && this.h) {
            g.b(str, str2, str3, str4);
        }
    }

    public final void c(String str, String str2, String str3, String str4) {
        if (this.a && this.h) {
            g.c(str, str2, str3, str4);
        }
    }

    public final void a(String str, long j2, String str2) {
        if (this.a && this.j) {
            g.a(str, j2, str2);
        }
    }

    public static List<EventBean> a() {
        return g.a();
    }

    public static List<EventBean> d() {
        return g.b();
    }

    public static List<EventBean> e() {
        return g.c();
    }

    private static void d(boolean z) {
        g.a(z);
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final void b(boolean z) {
        this.i = z;
    }

    public final void c(boolean z) {
        this.j = z;
    }

    private static void h() {
        g.d();
    }

    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b((e) null, (byte) 0);

        private a() {
        }
    }

    public static b g() {
        return a.a;
    }
}
