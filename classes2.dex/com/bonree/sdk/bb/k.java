package com.bonree.sdk.bb;

import android.os.Message;
import com.bonree.sdk.ab.d;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.engine.webview.f;
import com.bonree.sdk.agent.engine.webview.g;
import com.bonree.sdk.d.e;
import com.igexin.assist.control.fcm.GTJobService;
import java.util.List;

public final class k extends com.bonree.sdk.ad.a implements f {
    private static final int f = 10000;

    /* synthetic */ k(byte b) {
        this();
    }

    private k() {
        super((e) null);
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        super.a(message);
        i.a().a(message);
    }

    public static void a(String[] strArr) {
        i.a().a(strArr);
    }

    public static void b(String[] strArr) {
        i.a().b(strArr);
    }

    public static void c(String[] strArr) {
        i.a().c(strArr);
    }

    private static boolean g() {
        return i.a().b();
    }

    public final synchronized boolean c() {
        if (this.a) {
            a("WebView", a.d.d);
            this.a = false;
            f();
            i.a().c();
            g.a().unRegisterService((f) this);
            a("WebView", a.d.e);
        } else {
            this.c.d("WebViewService no need stoped!", new Object[0]);
        }
        return true;
    }

    private void b(d dVar) {
        if (dVar.e() != null) {
            a(dVar.e());
        } else if (dVar.c() != null) {
            a(dVar.c());
        } else if (dVar.d() != null) {
            a(2, (Object) dVar.d());
        }
    }

    private void a(com.bonree.sdk.w.a aVar) {
        if (aVar.f()) {
            a(0, (Object) aVar);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = aVar;
        a(obtain, 10000);
    }

    private void a(com.bonree.sdk.agent.engine.network.websocket.a aVar) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = aVar;
        a(obtain, 10000);
    }

    private void a(com.bonree.sdk.ab.f fVar) {
        a(2, (Object) fVar);
    }

    public static List<EventBean> a() {
        return i.a().d();
    }

    public static List<EventBean> d() {
        return i.a().e();
    }

    public static k e() {
        return a.a;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final k a = new k((byte) 0);

        private a() {
        }
    }

    public final synchronized boolean b() {
        boolean b = i.a().b();
        if (b) {
            g.a().a(b);
        }
        if (!this.a) {
            a("WebView", a.d.a);
            this.a = true;
            a("BR-Webview-Thread");
            a(3, (long) GTJobService.WAIT_TIME);
            g.a().registerService((f) this);
            a("WebView", a.d.c);
            return true;
        }
        a("WebView", a.d.b);
        return false;
    }

    public final void a(d dVar) {
        if (dVar == null) {
            return;
        }
        if (dVar.e() != null) {
            com.bonree.sdk.w.a e = dVar.e();
            if (e.f()) {
                a(0, (Object) e);
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = e;
            a(obtain, 10000);
        } else if (dVar.c() != null) {
            com.bonree.sdk.agent.engine.network.websocket.a c = dVar.c();
            Message obtain2 = Message.obtain();
            obtain2.what = 1;
            obtain2.obj = c;
            a(obtain2, 10000);
        } else if (dVar.d() != null) {
            a(2, (Object) dVar.d());
        }
    }
}
