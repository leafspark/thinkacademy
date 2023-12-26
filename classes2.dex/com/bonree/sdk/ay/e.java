package com.bonree.sdk.ay;

import android.os.Message;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.TrafficUsageBean;
import com.bonree.sdk.at.c;
import com.bonree.sdk.ay.a;
import com.bonree.sdk.ay.b;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class e extends com.bonree.sdk.ad.a implements c.a {
    private static String k = "Traffic-";
    private static int l = 1;
    public volatile String f = "";
    public volatile String g = "";
    public List<TrafficUsageBean> h = Collections.synchronizedList(new ArrayList());
    public TrafficUsageBean i;
    public TrafficUsageBean j;
    private String m = "BR-Traffic-Thread";

    public static long a(long j2) {
        if (j2 < 0) {
            return 0;
        }
        return j2;
    }

    public abstract List<TrafficUsageBean> a();

    /* access modifiers changed from: protected */
    public abstract void a(String str, boolean z, e eVar);

    public abstract void c(String str);

    public e(com.bonree.sdk.d.e eVar) {
        super(eVar);
    }

    public final boolean b() {
        if (this.a) {
            a("Traffic-", a.d.b);
            return true;
        }
        a("Traffic-", a.d.a);
        this.a = true;
        int i2 = c.m().i();
        if (i2 > 0) {
            this.g = c.m().e();
            i2 = 1;
        } else if (i2 == 0) {
            this.f = c.m().e();
        }
        b(i2);
        a("Traffic-", a.d.c);
        return true;
    }

    public void b(int i2) {
        c.m().a((c.a) this);
        a("BR-Traffic-Thread");
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        super.a(message);
        try {
            String str = (String) message.obj;
            if (message.what == 1 && !ad.a(str)) {
                a(str, true, a.a);
            }
        } catch (Exception e) {
            f fVar = this.c;
            fVar.e("Traffic-handleMessage Exception:" + Arrays.toString(e.getStackTrace()), new Object[0]);
        }
    }

    public final boolean c() {
        if (this.a) {
            a("Traffic-", a.d.d);
            c.m().b((c.a) this);
            f();
        }
        this.a = false;
        a("Traffic-", a.d.e);
        return true;
    }

    public static e e() {
        return a.a;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final e a;

        private a() {
        }

        static {
            e eVar;
            if (com.bonree.sdk.d.a.L()) {
                eVar = b.a.a;
            } else {
                eVar = a.C0010a.a;
            }
            a = eVar;
        }
    }

    public final TrafficUsageBean g() {
        return this.i;
    }

    public final TrafficUsageBean h() {
        return this.j;
    }

    public final void a(TrafficUsageBean trafficUsageBean) {
        this.i = trafficUsageBean;
    }

    public final void b(TrafficUsageBean trafficUsageBean) {
        this.j = trafficUsageBean;
    }
}
