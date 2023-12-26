package com.bonree.sdk.as;

import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.ab.d;
import com.bonree.sdk.ab.j;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.ad.f;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.RouteChangeEventBean;
import com.bonree.sdk.agent.engine.webview.entity.WebViewRouteChangeEvent;
import com.bonree.sdk.agent.engine.webview.g;
import com.bonree.sdk.ax.c;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.d.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a extends f implements com.bonree.sdk.agent.engine.webview.f {
    private static final int j = 200;
    private static final int k = 1000;
    private final String g;
    private final String h;
    private final int i;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this((e) null);
    }

    private a(e eVar) {
        super((e) null);
        this.g = "RouteChange-";
        this.h = "BR-RouteChange-Thread";
        this.i = 1;
        this.f = Collections.synchronizedList(new ArrayList());
    }

    public final synchronized List<EventBean> e() {
        if (!this.a) {
            return null;
        }
        d();
        ArrayList arrayList = new ArrayList(this.f);
        this.f.clear();
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        super.a(message);
        Object obj = message.obj;
        if (obj != null && message.what == 1) {
            j jVar = (j) obj;
            String a = jVar.a();
            boolean b = jVar.b();
            try {
                WebViewRouteChangeEvent webViewRouteChangeEvent = (WebViewRouteChangeEvent) new Gson().fromJson(a, WebViewRouteChangeEvent.class);
                if (!b || webViewRouteChangeEvent.isInvalid()) {
                    RouteChangeEventBean routeChangeEventBean = new RouteChangeEventBean();
                    if (TextUtils.isEmpty(webViewRouteChangeEvent.alias)) {
                        routeChangeEventBean.alias = null;
                    } else {
                        routeChangeEventBean.alias = webViewRouteChangeEvent.alias;
                    }
                    routeChangeEventBean.duration = ad.a(webViewRouteChangeEvent.duration);
                    routeChangeEventBean.duration *= 1000;
                    if (routeChangeEventBean.duration <= 0) {
                        routeChangeEventBean.duration = ad.a(webViewRouteChangeEvent.duration);
                    }
                    if (!TextUtils.isEmpty(webViewRouteChangeEvent.framework)) {
                        routeChangeEventBean.framework = webViewRouteChangeEvent.framework;
                    }
                    if (!TextUtils.isEmpty(webViewRouteChangeEvent.fromUrl)) {
                        routeChangeEventBean.fromUrl = webViewRouteChangeEvent.fromUrl;
                    }
                    if (!TextUtils.isEmpty(webViewRouteChangeEvent.pageUrl)) {
                        routeChangeEventBean.pageUrl = webViewRouteChangeEvent.pageUrl;
                    }
                    if (!TextUtils.isEmpty(webViewRouteChangeEvent.path)) {
                        routeChangeEventBean.path = webViewRouteChangeEvent.path;
                    }
                    if (!TextUtils.isEmpty(webViewRouteChangeEvent.root)) {
                        routeChangeEventBean.root = webViewRouteChangeEvent.root;
                    }
                    routeChangeEventBean.status = ad.b(webViewRouteChangeEvent.status);
                    if (!TextUtils.isEmpty(webViewRouteChangeEvent.toUrl)) {
                        routeChangeEventBean.toUrl = webViewRouteChangeEvent.toUrl;
                    }
                    routeChangeEventBean.isCustom = b;
                    routeChangeEventBean.clientType = 2;
                    EventBean eventBean = new EventBean();
                    eventBean.mEventInfo = routeChangeEventBean;
                    eventBean.mEventType = BaseEventInfo.EVENT_TYPE_ROUTE_CHANGE;
                    eventBean.mStateIndex = eventBean.getStateIndex();
                    if (this.f.size() >= j) {
                        this.f.remove(0);
                    }
                    if (webViewRouteChangeEvent.eventTime <= 0) {
                        eventBean.mEventTime = a();
                        this.f.add(eventBean);
                    } else {
                        eventBean.mEventTime = -(webViewRouteChangeEvent.eventTime * 1000);
                        a(eventBean);
                    }
                    c.h().a(eventBean);
                }
            } catch (Throwable th) {
                this.c.a("RouteChange- format WebViewRouteChangeEvent error: %s", th);
            }
        }
    }

    private void a(WebViewRouteChangeEvent webViewRouteChangeEvent, boolean z) {
        RouteChangeEventBean routeChangeEventBean = new RouteChangeEventBean();
        if (TextUtils.isEmpty(webViewRouteChangeEvent.alias)) {
            routeChangeEventBean.alias = null;
        } else {
            routeChangeEventBean.alias = webViewRouteChangeEvent.alias;
        }
        routeChangeEventBean.duration = ad.a(webViewRouteChangeEvent.duration);
        routeChangeEventBean.duration *= 1000;
        if (routeChangeEventBean.duration <= 0) {
            routeChangeEventBean.duration = ad.a(webViewRouteChangeEvent.duration);
        }
        if (!TextUtils.isEmpty(webViewRouteChangeEvent.framework)) {
            routeChangeEventBean.framework = webViewRouteChangeEvent.framework;
        }
        if (!TextUtils.isEmpty(webViewRouteChangeEvent.fromUrl)) {
            routeChangeEventBean.fromUrl = webViewRouteChangeEvent.fromUrl;
        }
        if (!TextUtils.isEmpty(webViewRouteChangeEvent.pageUrl)) {
            routeChangeEventBean.pageUrl = webViewRouteChangeEvent.pageUrl;
        }
        if (!TextUtils.isEmpty(webViewRouteChangeEvent.path)) {
            routeChangeEventBean.path = webViewRouteChangeEvent.path;
        }
        if (!TextUtils.isEmpty(webViewRouteChangeEvent.root)) {
            routeChangeEventBean.root = webViewRouteChangeEvent.root;
        }
        routeChangeEventBean.status = ad.b(webViewRouteChangeEvent.status);
        if (!TextUtils.isEmpty(webViewRouteChangeEvent.toUrl)) {
            routeChangeEventBean.toUrl = webViewRouteChangeEvent.toUrl;
        }
        routeChangeEventBean.isCustom = z;
        routeChangeEventBean.clientType = 2;
        EventBean eventBean = new EventBean();
        eventBean.mEventInfo = routeChangeEventBean;
        eventBean.mEventType = BaseEventInfo.EVENT_TYPE_ROUTE_CHANGE;
        eventBean.mStateIndex = eventBean.getStateIndex();
        if (this.f.size() >= j) {
            this.f.remove(0);
        }
        if (webViewRouteChangeEvent.eventTime <= 0) {
            eventBean.mEventTime = a();
            this.f.add(eventBean);
        } else {
            eventBean.mEventTime = -(webViewRouteChangeEvent.eventTime * 1000);
            a(eventBean);
        }
        c.h().a(eventBean);
    }

    public final boolean b() {
        if (!this.a) {
            a("RouteChange-", a.d.a);
            this.a = true;
            a("BR-RouteChange-Thread");
            g.a().registerService((com.bonree.sdk.agent.engine.webview.f) this);
            a("RouteChange-", a.d.c);
        } else {
            a("RouteChange-", a.d.b);
        }
        return true;
    }

    public final boolean c() {
        if (this.a) {
            a("RouteChange-", a.d.d);
            this.a = false;
            f();
            this.f.clear();
            g.a().unRegisterService((com.bonree.sdk.agent.engine.webview.f) this);
        } else {
            this.c.d("RouteChangeService no need stoped!", new Object[0]);
        }
        a("RouteChange-", a.d.e);
        return true;
    }

    public static a g() {
        return C0006a.a;
    }

    public final void a(d dVar) {
        if (dVar != null && this.a && dVar.g() != null) {
            a(1, (Object) dVar.g());
        }
    }

    /* renamed from: com.bonree.sdk.as.a$a  reason: collision with other inner class name */
    static class C0006a {
        /* access modifiers changed from: private */
        public static final a a = new a((byte) 0);

        private C0006a() {
        }
    }
}
