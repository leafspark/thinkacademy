package com.bonree.sdk.ax;

import android.os.Message;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.ad.f;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.TraceInfo;
import com.bonree.sdk.d.e;
import java.util.List;

public final class c extends f {
    private static int g = 10;
    private static int h = 11;
    private a i;
    private volatile boolean j = false;
    private final String k = "Trace";

    public c(e eVar) {
        super((e) null);
        this.e = "BR_Trace_Thread";
        a(this.e);
        this.i = new a();
    }

    public final void a(EventBean eventBean) {
        if (eventBean != null) {
            if (this.j || eventBean.mEventType.equals(BaseEventInfo.EVENT_TYPE_LAUNCH)) {
                a(10, (Object) eventBean);
            }
        }
    }

    public final List<TraceInfo> e() {
        if (this.j) {
            return this.i.b();
        }
        a(11, 0);
        return null;
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        a aVar = this.i;
        if (message.obj != null) {
            int i2 = message.what;
            if (i2 == 10) {
                aVar.a((EventBean) message.obj);
            } else if (i2 == 11) {
                aVar.d();
            }
        }
    }

    public final void g() {
        this.i.c();
    }

    public final void b(int i2) {
        this.i.a(i2);
    }

    public static c h() {
        return a.a;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final c a = new c((e) null);

        private a() {
        }
    }

    public final boolean b() {
        a("Trace", a.d.a);
        if (this.i.a() <= 0) {
            return true;
        }
        this.j = true;
        a("Trace", a.d.b);
        return true;
    }

    public final boolean c() {
        a("Trace", a.d.d);
        this.j = false;
        a(11, 0);
        a("Trace", a.d.e);
        return true;
    }
}
