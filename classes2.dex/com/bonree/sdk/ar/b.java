package com.bonree.sdk.ar;

import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.NetworkEventInfoBean;
import com.bonree.sdk.agent.business.util.g;
import com.bonree.sdk.agent.engine.webview.entity.AjaxPerformanceTimingEvent;
import com.bonree.sdk.agent.engine.webview.entity.PagePerformanceTiming;
import com.bonree.sdk.agent.engine.webview.entity.ResourcePerformanceTiming;
import com.bonree.sdk.agent.engine.webview.entity.WebviewPerformanceTimingEvent;
import com.bonree.sdk.ar.e;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.h;
import com.bonree.sdk.bs.k;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.d.a;
import com.bonree.sdk.m.n;
import com.bonree.sdk.m.o;
import com.bonree.sdk.n.e;
import com.igexin.assist.control.fcm.GTJobService;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private static int e = 4;
    private static int f = 6;
    private static int g = 7;
    private static int h = 8;
    private static int i = 9;
    private static int j = 10;
    private static final int k = 200;
    private static final int l = 1000;
    private static int m = 30000;
    private static final int n = 3600000;
    private static final int o = 1500;
    private static f p = com.bonree.sdk.be.a.a();
    private final List<String> A;
    private final h B;
    private final List<com.bonree.sdk.agent.engine.network.cronet.b> C;
    private String[] D;
    private boolean E;
    private boolean F;
    private int G;
    private final AtomicInteger H;
    private final List<EventBean> q;
    private final Map<String, n> r;
    private final Map<String, g> s;
    private final Map<String, Object> t;
    private final Map<String, NetworkEventInfoBean> u;
    private final Map<String, List> v;
    private final List<String> w;
    private final List<String> x;
    private final List<String> y;
    private final List<String> z;

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
        this.G = 1;
        this.H = new AtomicInteger(0);
        this.q = Collections.synchronizedList(new ArrayList());
        this.r = new k();
        this.s = new k();
        this.t = new k();
        this.u = new k();
        this.v = new k();
        this.w = Collections.synchronizedList(new ArrayList());
        this.x = Collections.synchronizedList(new ArrayList());
        this.y = Collections.synchronizedList(new ArrayList());
        this.z = Collections.synchronizedList(new ArrayList());
        this.A = Collections.synchronizedList(new ArrayList());
        this.B = new h();
        this.C = Collections.synchronizedList(new ArrayList());
        this.E = false;
        this.F = false;
    }

    public static b a() {
        return a.a;
    }

    private void f() {
        a((List) this.q);
    }

    private static void a(List list) {
        synchronized (list) {
            if (list.size() > 0) {
                list.clear();
            }
        }
    }

    private void g() {
        a((Map) this.r);
        a((Map) this.s);
        a((Map) this.t);
        a((Map) this.u);
        a((Map) this.v);
        a((List) this.C);
        this.B.d();
    }

    private static void a(Map map) {
        synchronized (map) {
            if (!map.isEmpty()) {
                map.clear();
            }
        }
    }

    private void i() {
        long b2 = com.bonree.sdk.d.a.b();
        a(b2);
        b(b2);
        e(b2);
        d(b2);
        c(b2);
    }

    private void a(long j2) {
        synchronized (this.s) {
            Iterator<Map.Entry<String, g>> it = this.s.entrySet().iterator();
            f fVar = p;
            fVar.a("mSocketSdMap size():  " + this.s.size(), new Object[0]);
            while (it.hasNext()) {
                Map.Entry next = it.next();
                g gVar = (g) next.getValue();
                Map<Long, n> c2 = gVar.c();
                if (c2 != null) {
                    Iterator<Map.Entry<Long, n>> it2 = c2.entrySet().iterator();
                    f fVar2 = p;
                    fVar2.a(((String) next.getKey()) + "   serializeDataMap size() :  " + c2.size(), new Object[0]);
                    while (it2.hasNext()) {
                        n nVar = (n) it2.next().getValue();
                        if (nVar != null && j2 - nVar.g() > 90000) {
                            if (gVar.b()) {
                                a(nVar);
                            } else if (b(nVar)) {
                                it2.remove();
                            }
                        }
                    }
                    if (c2.isEmpty()) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void b(long j2) {
        synchronized (this.r) {
            if (this.r.size() >= 30) {
                Iterator<Map.Entry<String, n>> it = this.r.entrySet().iterator();
                while (it.hasNext()) {
                    if (j2 - (((n) it.next().getValue()).g() / 1000) > 3600000) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void c(long j2) {
        if (this.F) {
            synchronized (this.C) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.C.size(); i2++) {
                    com.bonree.sdk.agent.engine.network.cronet.b bVar = this.C.get(i2);
                    if (j2 - bVar.b() > 10000) {
                        a(bVar.a(), true);
                    } else {
                        arrayList.add(bVar);
                    }
                }
                this.C.clear();
                this.C.addAll(arrayList);
            }
        }
    }

    private void d(long j2) {
        synchronized (this.t) {
            Iterator<Map.Entry<String, Object>> it = this.t.entrySet().iterator();
            while (it.hasNext()) {
                Object value = it.next().getValue();
                if (value instanceof e) {
                    if (j2 - ((e) value).h() > 180000) {
                        p.a("eventlistener cache timeout  %s", value);
                        it.remove();
                    }
                } else if (value instanceof HashMap) {
                    for (Map.Entry value2 : ((HashMap) value).entrySet()) {
                        value2.getValue();
                        if (j2 - ((e) value).h() > 180000) {
                            p.a("eventlistener cache timeout  %s", value);
                            it.remove();
                        }
                    }
                    if (((HashMap) value).size() == 0) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void e(long j2) {
        synchronized (this.u) {
            Iterator<Map.Entry<String, NetworkEventInfoBean>> it = this.u.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (j2 - Long.parseLong(((String) next.getKey()).substring(((String) next.getKey()).indexOf("_") + 1)) <= 600000) {
                    if (this.u.size() <= 50) {
                        if (a((String) next.getKey(), ((NetworkEventInfoBean) next.getValue()).mRequestUrl)) {
                            it.remove();
                        }
                    }
                }
                a((NetworkEventInfoBean) next.getValue(), true);
                it.remove();
            }
        }
    }

    private static void a(n nVar) {
        List<com.bonree.sdk.l.b> a2 = nVar.a();
        if (a2 != null) {
            Iterator<com.bonree.sdk.l.b> it = a2.iterator();
            while (it.hasNext()) {
                if (com.bonree.sdk.d.a.b() - it.next().c() > 90000) {
                    it.remove();
                }
            }
        }
        List<a.b> b2 = nVar.b();
        if (b2 != null) {
            Iterator<a.b> it2 = b2.iterator();
            while (it2.hasNext()) {
                if (com.bonree.sdk.d.a.b() - it2.next().b() > 90000) {
                    it2.remove();
                }
            }
        }
    }

    private boolean b(n nVar) {
        if (nVar.p() > 0) {
            a(nVar, (com.bonree.sdk.l.b) null);
            return true;
        }
        List<com.bonree.sdk.l.b> a2 = nVar.a();
        if (a2 == null) {
            return true;
        }
        Iterator<com.bonree.sdk.l.b> it = a2.iterator();
        while (it.hasNext()) {
            com.bonree.sdk.l.b next = it.next();
            if (com.bonree.sdk.d.a.b() - next.c() > 60000) {
                a(nVar, next);
                it.remove();
            }
        }
        return a2.isEmpty();
    }

    private void a(n nVar, com.bonree.sdk.l.b bVar) {
        NetworkEventInfoBean a2;
        try {
            synchronized (this.r) {
                a2 = g.a(nVar, bVar, this.r);
            }
            if (a2 != null) {
                p.a("原生socket :%s", a2);
                a(a2);
            }
        } catch (Throwable th) {
            p.a("socket error:", th);
        }
    }

    private void a(e eVar) {
        if (eVar != null) {
            try {
                if (!TextUtils.isEmpty(eVar.c())) {
                    if (!TextUtils.isEmpty(eVar.x())) {
                        p.c("okhttp3Event:%s", eVar);
                        this.E = true;
                        synchronized (this.t) {
                            String x2 = eVar.x();
                            if (!this.t.containsKey(x2)) {
                                this.t.put(x2, eVar);
                            } else {
                                Object obj = this.t.get(x2);
                                if (obj instanceof e) {
                                    if (eVar.c() != null) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(((e) obj).c(), obj);
                                        if (TextUtils.equals(eVar.c(), ((e) obj).c())) {
                                            hashMap.put(eVar.v(), eVar);
                                        } else {
                                            hashMap.put(eVar.c(), eVar);
                                        }
                                        this.t.put(x2, hashMap);
                                    }
                                } else if (obj instanceof HashMap) {
                                    if (((e) ((HashMap) obj).get(eVar.c())) == null) {
                                        ((HashMap) obj).put(eVar.c(), eVar);
                                    } else {
                                        ((HashMap) obj).put(eVar.v(), eVar);
                                    }
                                }
                            }
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                p.a("okhttp3Event error:", th);
                return;
            }
        }
        p.e("okhttp3Event is invalid :%s", eVar);
    }

    private boolean a(String str, String str2) {
        f fVar = p;
        fVar.c("okhttp3Event mathch start:" + str, new Object[0]);
        e b2 = b(str, str2);
        if (b2 == null) {
            return false;
        }
        f fVar2 = p;
        fVar2.c("okhttp3Event mathch end: " + str, new Object[0]);
        a(g.a(b2, this.G, this.w, this.A, this.z), true);
        synchronized (this.t) {
            this.t.remove(b2.x());
        }
        return true;
    }

    private void a(com.bonree.sdk.n.b bVar) {
        if (bVar != null) {
            try {
                if (bVar.f() != null) {
                    NetworkEventInfoBean a2 = g.a(bVar, this.v, this.G);
                    a2.mCustomBusinessHeader = g.a(bVar.w(), this.w);
                    a2.mCustomBusinessQuery = g.a(a2.mRequestUrl, this.y);
                    a2.mResponseTraceInfo = g.b(bVar.N(), this.z);
                    a2.mRequestTraceInfo = g.c(bVar.w(), this.A);
                    String d2 = u.d(bVar.d());
                    if (!TextUtils.isEmpty(d2)) {
                        a2.mTraceId = d2;
                    }
                    String e2 = u.e(bVar.d());
                    if (!TextUtils.isEmpty(e2)) {
                        a2.xBrResponse = e2;
                    }
                    String f2 = u.f(bVar.d());
                    if (!TextUtils.isEmpty(f2)) {
                        a2.traceResponse = f2;
                    }
                    EventBean eventBean = new EventBean();
                    eventBean.mEventType = BaseEventInfo.EVENT_TYPE_NETWORK;
                    eventBean.mEventTime = bVar.R() * 1000;
                    if (eventBean.mEventTime < 0) {
                        this.H.getAndIncrement();
                    } else if (this.H.get() > 0) {
                        j();
                    }
                    eventBean.mStateIndex = eventBean.getStateIndex();
                    eventBean.mEventInfo = a2;
                    g.a(eventBean, a2);
                    synchronized (this.q) {
                        if (this.q.size() >= 1500) {
                            this.q.remove(0);
                        }
                        eventBean.uploadStateKey();
                        this.q.add(eventBean);
                    }
                    p.c("network flutter eventBean :%s", eventBean);
                }
            } catch (Exception e3) {
                f fVar = p;
                fVar.e("constructFlutterNetworkData error:" + e3.toString(), new Object[0]);
            }
        }
    }

    private void b(com.bonree.sdk.n.b bVar) {
        if (bVar != null) {
            try {
                if (bVar.f() != null) {
                    f fVar = p;
                    fVar.c("FrameData = " + bVar, new Object[0]);
                    f fVar2 = p;
                    fVar2.c("FrameData requestId = " + bVar.s(), new Object[0]);
                    e b2 = b(bVar.s(), bVar.f());
                    f fVar3 = p;
                    fVar3.c("ok3EventData = " + b2, new Object[0]);
                    if (b2 != null && (TextUtils.isEmpty(bVar.j()) || !TextUtils.isEmpty(b2.a()))) {
                        if (!b2.b()) {
                            if (!bVar.P()) {
                                NetworkEventInfoBean a2 = g.a(b2, this.G, this.w, this.A, this.z);
                                if (a2 != null) {
                                    if (!TextUtils.isEmpty(bVar.j()) && !TextUtils.isEmpty(b2.a())) {
                                        if (!TextUtils.isEmpty(bVar.f()) && !TextUtils.equals(bVar.f(), b2.c())) {
                                            a2.mRequestUrl = bVar.f();
                                        }
                                        if (a2.mRequestDataSize == 0 && bVar.T() != 0) {
                                            a2.mRequestDataSize = bVar.T();
                                        }
                                    }
                                    a2.mIdentifier = bVar.X();
                                    a2.mCustomBusinessBody = g.a((Object) bVar.S(), this.x);
                                    g.a(a2, b2.s(), this.B);
                                    g.a(bVar, a2);
                                    a(a2);
                                    synchronized (this.t) {
                                        Object obj = this.t.get(b2.x());
                                        if (obj != null && (obj instanceof e)) {
                                            this.t.remove(b2.x());
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                        }
                        bVar.a(true);
                        synchronized (this.t) {
                            Object obj2 = this.t.get(b2.x());
                            if (obj2 != null && (obj2 instanceof e)) {
                                this.t.remove(b2.x());
                            }
                        }
                    }
                    NetworkEventInfoBean a3 = g.a(bVar, this.G);
                    g.a(a3, bVar, this.F, this.D);
                    if (bVar.w() == null || bVar.w().size() <= 0) {
                        g.a(a3, bVar.v(), this.w);
                        a3.mResponseTraceInfo = g.b(bVar.N(), this.z);
                        g.a(a3, bVar.v(), this.B);
                    } else {
                        a3.mCustomBusinessHeader = g.a(bVar.w(), this.w);
                        a3.mResponseTraceInfo = g.b(bVar.N(), this.z);
                        a3.mRequestTraceInfo = g.c(bVar.O(), this.A);
                        g.a(a3, bVar.w(), this.B);
                    }
                    a3.mCustomBusinessBody = g.a((Object) bVar.S(), this.x);
                    if (g.a(bVar, a3, d.a(bVar, this.s), this.E && !TextUtils.isEmpty(bVar.s()))) {
                        d.a(a3, u.c(bVar.f()), bVar, this.s);
                        if (!this.E || TextUtils.isEmpty(bVar.s()) || a3.mErrorCode.intValue() != 0) {
                            g.a(bVar, a3);
                            if (!bVar.V()) {
                                p.a("frame data:%s", a3);
                                a(a3);
                                return;
                            }
                            return;
                        }
                        p.c("可能是okhttp3Event 缓存在发送", new Object[0]);
                        synchronized (this.u) {
                            this.u.put(bVar.s(), a3);
                        }
                    }
                }
            } catch (Throwable th) {
                p.a("frame error:", th);
            }
        }
    }

    private void a(com.bonree.sdk.n.a aVar) {
        if (aVar != null) {
            NetworkEventInfoBean a2 = g.a(aVar, this.G);
            a2.mCustomBusinessHeader = g.a(aVar.n(), this.w);
            a2.mResponseTraceInfo = g.b(aVar.o(), this.z);
            a2.mRequestTraceInfo = g.c(aVar.n(), this.A);
            g.a(a2, aVar.n(), this.B);
            if (aVar.o() != null && aVar.o().size() > 0) {
                String a3 = u.a(aVar.o());
                if (!TextUtils.isEmpty(a3)) {
                    a2.mTraceId = a3;
                }
                String b2 = u.b(aVar.o());
                if (!TextUtils.isEmpty(b2)) {
                    a2.xBrResponse = b2;
                }
                String c2 = u.c(aVar.o());
                if (!TextUtils.isEmpty(c2)) {
                    a2.traceResponse = c2;
                }
            }
            g.a(aVar, a2);
            a(a2, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bonree.sdk.n.e b(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r3.t
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Object> r2 = r3.t     // Catch:{ all -> 0x003c }
            java.lang.Object r4 = r2.get(r4)     // Catch:{ all -> 0x003c }
            if (r4 == 0) goto L_0x003a
            boolean r2 = r4 instanceof com.bonree.sdk.n.e     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x001b
            com.bonree.sdk.n.e r4 = (com.bonree.sdk.n.e) r4     // Catch:{ all -> 0x003c }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return r4
        L_0x001b:
            boolean r2 = r4 instanceof java.util.Map     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x003a
            r1 = r4
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ all -> 0x003c }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x002c
            com.bonree.sdk.n.e r1 = (com.bonree.sdk.n.e) r1     // Catch:{ all -> 0x003c }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return r1
        L_0x002c:
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ all -> 0x003c }
            java.lang.String r5 = com.bonree.sdk.bs.u.c((java.lang.String) r5)     // Catch:{ all -> 0x003c }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ all -> 0x003c }
            com.bonree.sdk.n.e r4 = (com.bonree.sdk.n.e) r4     // Catch:{ all -> 0x003c }
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return r4
        L_0x003a:
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            return r1
        L_0x003c:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.b.b(java.lang.String, java.lang.String):com.bonree.sdk.n.e");
    }

    private void a(com.bonree.sdk.n.f fVar) {
        if (fVar != null) {
            try {
                if (fVar.b() != null) {
                    synchronized (this.s) {
                        String b2 = fVar.b();
                        Long valueOf = Long.valueOf(fVar.c() + fVar.l());
                        if (b2 != null && this.s.containsKey(b2)) {
                            if (this.s.get(b2) != null) {
                                g gVar = this.s.get(b2);
                                if (gVar != null) {
                                    Map<Long, n> c2 = gVar.c();
                                    if (c2 == null) {
                                        a((Map<Long, n>) null, gVar, (n) null, fVar, valueOf, b2);
                                        return;
                                    }
                                    a(c2, gVar, c2.get(valueOf), fVar, valueOf, b2);
                                    return;
                                }
                                return;
                            }
                        }
                        a((Map<Long, n>) null, (g) null, (n) null, fVar, valueOf, b2);
                    }
                }
            } catch (Throwable th) {
                p.a("socket save error:", th);
            }
        }
    }

    private void a(Map<Long, n> map, g gVar, n nVar, com.bonree.sdk.n.f fVar, Long l2, String str) {
        if (nVar == null) {
            nVar = new n(fVar);
        }
        nVar.a(fVar);
        if (map == null) {
            map = new k<>();
        }
        map.put(l2, nVar);
        if (gVar == null) {
            gVar = new g(map);
        } else {
            gVar.a(map);
        }
        this.s.put(str, gVar);
    }

    private void a(com.bonree.sdk.w.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.c() != null) {
                    WebviewPerformanceTimingEvent webviewPerformanceTimingEvent = (WebviewPerformanceTimingEvent) new Gson().fromJson(aVar.c(), WebviewPerformanceTimingEvent.class);
                    List<ResourcePerformanceTiming> rt = webviewPerformanceTimingEvent.getRt();
                    PagePerformanceTiming pt = webviewPerformanceTimingEvent.getPt();
                    NetworkEventInfoBean a2 = g.a(pt, aVar.d());
                    if (a2 == null) {
                        p.e("exception networkEventBean is null\":\r\n%s", aVar.c());
                        return;
                    }
                    if (pt.getImd() == 1) {
                        a2.mCustomBusinessHeader = g.a(aVar.h(), this.w);
                        a2.mCustomBusinessBody = g.a((Object) aVar.i(), this.x);
                        a2.mCustomBusinessQuery = g.a(a2.mRequestUrl, this.y);
                    }
                    if (this.F) {
                        a(a2, 0);
                    } else {
                        a(a2, false);
                    }
                    long d2 = aVar.d();
                    long j2 = a2.startTime;
                    String pvid = pt.getPvid();
                    if (rt != null && !rt.isEmpty()) {
                        for (ResourcePerformanceTiming a3 : rt) {
                            a(g.a(a3, d2, j2, pvid), false);
                        }
                    }
                }
            } catch (Throwable th) {
                p.e("exception pageData:\r\n%s", aVar.c());
                p.a("parse ReceivedData exception:", th);
            }
        }
    }

    private static long f(long j2) {
        return com.bonree.sdk.d.a.c(j2);
    }

    private void j() {
        synchronized (this.q) {
            for (EventBean next : this.q) {
                if (next.mEventTime < 0) {
                    next.correctEventTime(com.bonree.sdk.d.a.c(next.mEventTime));
                    this.H.getAndDecrement();
                    if (this.H.get() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    private void a(NetworkEventInfoBean networkEventInfoBean) {
        a(networkEventInfoBean, true);
    }

    private void a(NetworkEventInfoBean networkEventInfoBean, boolean z2) {
        if (networkEventInfoBean != null) {
            if (z2) {
                networkEventInfoBean.mCustomBusinessQuery = g.a(networkEventInfoBean.mRequestUrl, this.y);
            }
            g.a(networkEventInfoBean, this.v);
            if (networkEventInfoBean.mRequestTimeUs <= 0 && networkEventInfoBean.mResponseTimeUs <= 0 && networkEventInfoBean.mDownloadTimeUs <= 0 && networkEventInfoBean.mErrorCode.intValue() == 0 && networkEventInfoBean.mAppRequestType == 10 && ad.a(networkEventInfoBean.mErrorMsg)) {
                p.c("network data is exception", new Object[0]);
            } else if (networkEventInfoBean.mAppRequestType != 10 || ((!TextUtils.isEmpty(networkEventInfoBean.mTargetIp) && !networkEventInfoBean.mTargetIp.equals(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE)) || h.a(networkEventInfoBean.mErrorCode.intValue()))) {
                EventBean eventBean = new EventBean();
                eventBean.mEventType = BaseEventInfo.EVENT_TYPE_NETWORK;
                eventBean.mEventTime = networkEventInfoBean.startTime;
                if (eventBean.mEventTime < 0) {
                    this.H.getAndIncrement();
                } else if (this.H.get() > 0) {
                    j();
                }
                eventBean.mStateIndex = eventBean.getStateIndex();
                eventBean.mEventInfo = networkEventInfoBean;
                g.a(eventBean, networkEventInfoBean);
                synchronized (this.q) {
                    if (this.q.size() >= 1500) {
                        this.q.remove(0);
                    }
                    eventBean.uploadStateKey();
                    e unused = e.a.a;
                    e.b(a.b.NETWORK, eventBean);
                    this.q.add(eventBean);
                }
                p.c("eventBean :%s", eventBean);
            } else {
                p.c("network address ip is null", new Object[0]);
            }
        }
    }

    private void a(List<ResourcePerformanceTiming> list, long j2, long j3, String str) {
        if (list != null && !list.isEmpty()) {
            try {
                for (ResourcePerformanceTiming a2 : list) {
                    a(g.a(a2, j2, j3, str), false);
                }
            } catch (Throwable th) {
                p.a("add webview resource exception:", th);
            }
        }
    }

    private void a(o oVar) {
        if (oVar != null) {
            try {
                if (!ad.a(oVar.c())) {
                    NetworkEventInfoBean a2 = g.a((AjaxPerformanceTimingEvent) new Gson().fromJson(oVar.c(), AjaxPerformanceTimingEvent.class), oVar.d(), this.w, this.x, this.A, this.z, this.G);
                    p.a("xhrDataBean:%s", a2);
                    if (this.F) {
                        a(a2, 0);
                    } else {
                        a(a2);
                    }
                }
            } catch (Throwable th) {
                p.a("parse xhr bean exception:", th);
            }
        }
    }

    private void a(com.bonree.sdk.ab.f fVar) {
        try {
            if (!this.F) {
                synchronized (this.q) {
                    if (g.a(fVar, this.q, this.G)) {
                        NetworkEventInfoBean a2 = g.a(fVar, this.w, this.A, this.z, this.G);
                        p.a("WebviewError:%s", a2);
                        a(a2);
                        return;
                    }
                    return;
                }
            }
            NetworkEventInfoBean a3 = g.a(fVar, this.w, this.A, this.z, this.G);
            p.a("WebviewError:%s", a3);
            a(a3, 1);
        } catch (Throwable th) {
            p.e("WebviewError throwable:%s", th.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final List<EventBean> c() {
        ArrayList arrayList;
        synchronized (this.q) {
            if (this.H.get() > 0) {
                j();
            }
            arrayList = new ArrayList(this.q);
            a((List) this.q);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String[] r3) {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.w
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = r2.w     // Catch:{ all -> 0x0017 }
            r1.clear()     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            int r1 = r3.length     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.util.List<java.lang.String> r1 = r2.w     // Catch:{ all -> 0x0017 }
            java.util.Collections.addAll(r1, r3)     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0017:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.b.a(java.lang.String[]):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String[] r3) {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.x
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = r2.x     // Catch:{ all -> 0x0017 }
            r1.clear()     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            int r1 = r3.length     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.util.List<java.lang.String> r1 = r2.x     // Catch:{ all -> 0x0017 }
            java.util.Collections.addAll(r1, r3)     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0017:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.b.b(java.lang.String[]):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String[] r3) {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.y
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = r2.y     // Catch:{ all -> 0x0017 }
            r1.clear()     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            int r1 = r3.length     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.util.List<java.lang.String> r1 = r2.y     // Catch:{ all -> 0x0017 }
            java.util.Collections.addAll(r1, r3)     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0017:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.b.c(java.lang.String[]):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.lang.String[] r3) {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.z
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = r2.z     // Catch:{ all -> 0x0017 }
            r1.clear()     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            int r1 = r3.length     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.util.List<java.lang.String> r1 = r2.z     // Catch:{ all -> 0x0017 }
            java.util.Collections.addAll(r1, r3)     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0017:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.b.d(java.lang.String[]):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(java.lang.String[] r3) {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.A
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = r2.A     // Catch:{ all -> 0x0017 }
            r1.clear()     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            int r1 = r3.length     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.util.List<java.lang.String> r1 = r2.A     // Catch:{ all -> 0x0017 }
            java.util.Collections.addAll(r1, r3)     // Catch:{ all -> 0x0017 }
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0015:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return
        L_0x0017:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ar.b.e(java.lang.String[]):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3)) {
            if (this.B.c() >= k) {
                this.B.b();
            }
            this.B.a(str, str2, str3);
            return;
        }
        this.B.b(str, str2);
    }

    /* access modifiers changed from: package-private */
    public final boolean d() {
        List<String> list = this.x;
        return list != null && list.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        if (z2) {
            this.F = true;
            if (this.D == null) {
                this.D = new String[]{"Result-Status", "Tips", "x-mgw-http-code", "Result-tips"};
            }
        }
    }

    public final void a(int i2) {
        if (i2 >= 0 && i2 <= 2) {
            this.G = i2;
        }
    }

    private void a(NetworkEventInfoBean networkEventInfoBean, int i2) {
        if (networkEventInfoBean != null) {
            try {
                synchronized (this.C) {
                    NetworkEventInfoBean networkEventInfoBean2 = null;
                    com.bonree.sdk.agent.engine.network.cronet.b bVar = null;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.C.size()) {
                            break;
                        }
                        bVar = this.C.get(i3);
                        if (bVar == null || bVar.c() == i2 || !h.c(networkEventInfoBean.mRequestUrl, bVar.a().mRequestUrl)) {
                            i3++;
                        } else {
                            p.c("type %d ,WebviewError:%s", Integer.valueOf(i2), networkEventInfoBean.mRequestUrl);
                            if (i2 == 0) {
                                networkEventInfoBean2 = g.a(networkEventInfoBean, bVar.a());
                            } else {
                                networkEventInfoBean2 = g.a(bVar.a(), networkEventInfoBean);
                            }
                        }
                    }
                    if (networkEventInfoBean2 != null) {
                        a(networkEventInfoBean2, true);
                        this.C.remove(bVar);
                    } else {
                        if (this.C.size() > k) {
                            a(this.C.get(0).a(), true);
                            this.C.remove(0);
                        }
                        this.C.add(new com.bonree.sdk.agent.engine.network.cronet.b(networkEventInfoBean, i2));
                    }
                }
            } catch (Throwable th) {
                p.a("cacheWebviewList error:", th);
            }
        }
    }

    private void b(NetworkEventInfoBean networkEventInfoBean) {
        networkEventInfoBean.isCustom = true;
        networkEventInfoBean.mAppRequestType = 10;
        EventBean eventBean = new EventBean();
        eventBean.mEventType = BaseEventInfo.EVENT_TYPE_NETWORK;
        eventBean.mEventTime = com.bonree.sdk.d.a.l();
        if (eventBean.mEventTime < 0) {
            this.H.getAndIncrement();
        } else if (this.H.get() > 0) {
            j();
        }
        eventBean.mStateIndex = eventBean.getStateIndex();
        eventBean.mEventInfo = networkEventInfoBean;
        g.a(eventBean, networkEventInfoBean);
        synchronized (this.q) {
            if (this.q.size() >= 1500) {
                this.q.remove(0);
            }
            eventBean.uploadStateKey();
            this.q.add(eventBean);
        }
        p.c("eventBean :%s", eventBean);
    }

    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b((byte) 0);

        private a() {
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) {
        Object obj = message.obj;
        if (obj != null || message.what == 8) {
            switch (message.what) {
                case 0:
                    com.bonree.sdk.w.a aVar = (com.bonree.sdk.w.a) obj;
                    if (aVar != null) {
                        try {
                            if (aVar.c() != null) {
                                WebviewPerformanceTimingEvent webviewPerformanceTimingEvent = (WebviewPerformanceTimingEvent) new Gson().fromJson(aVar.c(), WebviewPerformanceTimingEvent.class);
                                List<ResourcePerformanceTiming> rt = webviewPerformanceTimingEvent.getRt();
                                PagePerformanceTiming pt = webviewPerformanceTimingEvent.getPt();
                                NetworkEventInfoBean a2 = g.a(pt, aVar.d());
                                if (a2 == null) {
                                    p.e("exception networkEventBean is null\":\r\n%s", aVar.c());
                                    return;
                                }
                                if (pt.getImd() == 1) {
                                    a2.mCustomBusinessHeader = g.a(aVar.h(), this.w);
                                    a2.mCustomBusinessBody = g.a((Object) aVar.i(), this.x);
                                    a2.mCustomBusinessQuery = g.a(a2.mRequestUrl, this.y);
                                }
                                if (this.F) {
                                    a(a2, 0);
                                } else {
                                    a(a2, false);
                                }
                                long d2 = aVar.d();
                                long j2 = a2.startTime;
                                String pvid = pt.getPvid();
                                if (rt != null && !rt.isEmpty()) {
                                    for (ResourcePerformanceTiming a3 : rt) {
                                        a(g.a(a3, d2, j2, pvid), false);
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            p.e("exception pageData:\r\n%s", aVar.c());
                            p.a("parse ReceivedData exception:", th);
                            return;
                        }
                    } else {
                        return;
                    }
                case 1:
                    o oVar = (o) obj;
                    if (oVar != null) {
                        try {
                            if (!ad.a(oVar.c())) {
                                NetworkEventInfoBean a4 = g.a((AjaxPerformanceTimingEvent) new Gson().fromJson(oVar.c(), AjaxPerformanceTimingEvent.class), oVar.d(), this.w, this.x, this.A, this.z, this.G);
                                p.a("xhrDataBean:%s", a4);
                                if (this.F) {
                                    a(a4, 0);
                                    return;
                                } else {
                                    a(a4);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            p.a("parse xhr bean exception:", th2);
                            return;
                        }
                    } else {
                        return;
                    }
                case 2:
                    com.bonree.sdk.ab.f fVar = (com.bonree.sdk.ab.f) obj;
                    try {
                        if (!this.F) {
                            synchronized (this.q) {
                                if (g.a(fVar, this.q, this.G)) {
                                    NetworkEventInfoBean a5 = g.a(fVar, this.w, this.A, this.z, this.G);
                                    p.a("WebviewError:%s", a5);
                                    a(a5);
                                    return;
                                }
                                return;
                            }
                        }
                        NetworkEventInfoBean a6 = g.a(fVar, this.w, this.A, this.z, this.G);
                        p.a("WebviewError:%s", a6);
                        a(a6, 1);
                        return;
                    } catch (Throwable th3) {
                        p.e("WebviewError throwable:%s", th3.toString());
                        return;
                    }
                case 3:
                    com.bonree.sdk.n.b bVar = (com.bonree.sdk.n.b) obj;
                    if (bVar != null) {
                        try {
                            if (bVar.f() != null) {
                                f fVar2 = p;
                                fVar2.c("FrameData = " + bVar, new Object[0]);
                                f fVar3 = p;
                                fVar3.c("FrameData requestId = " + bVar.s(), new Object[0]);
                                com.bonree.sdk.n.e b2 = b(bVar.s(), bVar.f());
                                f fVar4 = p;
                                fVar4.c("ok3EventData = " + b2, new Object[0]);
                                if (b2 != null && (TextUtils.isEmpty(bVar.j()) || !TextUtils.isEmpty(b2.a()))) {
                                    if (!b2.b()) {
                                        if (!bVar.P()) {
                                            NetworkEventInfoBean a7 = g.a(b2, this.G, this.w, this.A, this.z);
                                            if (a7 != null) {
                                                if (!TextUtils.isEmpty(bVar.j()) && !TextUtils.isEmpty(b2.a())) {
                                                    if (!TextUtils.isEmpty(bVar.f()) && !TextUtils.equals(bVar.f(), b2.c())) {
                                                        a7.mRequestUrl = bVar.f();
                                                    }
                                                    if (a7.mRequestDataSize == 0 && bVar.T() != 0) {
                                                        a7.mRequestDataSize = bVar.T();
                                                    }
                                                }
                                                a7.mIdentifier = bVar.X();
                                                a7.mCustomBusinessBody = g.a((Object) bVar.S(), this.x);
                                                g.a(a7, b2.s(), this.B);
                                                g.a(bVar, a7);
                                                a(a7);
                                                synchronized (this.t) {
                                                    Object obj2 = this.t.get(b2.x());
                                                    if (obj2 != null && (obj2 instanceof com.bonree.sdk.n.e)) {
                                                        this.t.remove(b2.x());
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                    }
                                    bVar.a(true);
                                    synchronized (this.t) {
                                        Object obj3 = this.t.get(b2.x());
                                        if (obj3 != null && (obj3 instanceof com.bonree.sdk.n.e)) {
                                            this.t.remove(b2.x());
                                        }
                                    }
                                }
                                NetworkEventInfoBean a8 = g.a(bVar, this.G);
                                g.a(a8, bVar, this.F, this.D);
                                if (bVar.w() == null || bVar.w().size() <= 0) {
                                    g.a(a8, bVar.v(), this.w);
                                    a8.mResponseTraceInfo = g.b(bVar.N(), this.z);
                                    g.a(a8, bVar.v(), this.B);
                                } else {
                                    a8.mCustomBusinessHeader = g.a(bVar.w(), this.w);
                                    a8.mResponseTraceInfo = g.b(bVar.N(), this.z);
                                    a8.mRequestTraceInfo = g.c(bVar.O(), this.A);
                                    g.a(a8, bVar.w(), this.B);
                                }
                                a8.mCustomBusinessBody = g.a((Object) bVar.S(), this.x);
                                if (g.a(bVar, a8, d.a(bVar, this.s), this.E && !TextUtils.isEmpty(bVar.s()))) {
                                    d.a(a8, u.c(bVar.f()), bVar, this.s);
                                    if (!this.E || TextUtils.isEmpty(bVar.s()) || a8.mErrorCode.intValue() != 0) {
                                        g.a(bVar, a8);
                                        if (!bVar.V()) {
                                            p.a("frame data:%s", a8);
                                            a(a8);
                                            return;
                                        }
                                        return;
                                    }
                                    p.c("可能是okhttp3Event 缓存在发送", new Object[0]);
                                    synchronized (this.u) {
                                        this.u.put(bVar.s(), a8);
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable th4) {
                            p.a("frame error:", th4);
                            return;
                        }
                    } else {
                        return;
                    }
                case 4:
                    com.bonree.sdk.n.f fVar5 = (com.bonree.sdk.n.f) obj;
                    if (fVar5 != null) {
                        try {
                            if (fVar5.b() != null) {
                                synchronized (this.s) {
                                    String b3 = fVar5.b();
                                    Long valueOf = Long.valueOf(fVar5.c() + fVar5.l());
                                    if (b3 != null && this.s.containsKey(b3)) {
                                        if (this.s.get(b3) != null) {
                                            g gVar = this.s.get(b3);
                                            if (gVar != null) {
                                                Map<Long, n> c2 = gVar.c();
                                                if (c2 == null) {
                                                    a((Map<Long, n>) null, gVar, (n) null, fVar5, valueOf, b3);
                                                    return;
                                                } else {
                                                    a(c2, gVar, c2.get(valueOf), fVar5, valueOf, b3);
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    a((Map<Long, n>) null, (g) null, (n) null, fVar5, valueOf, b3);
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th5) {
                            p.a("socket save error:", th5);
                            return;
                        }
                    } else {
                        return;
                    }
                case 6:
                    com.bonree.sdk.n.e eVar = (com.bonree.sdk.n.e) obj;
                    if (eVar != null) {
                        try {
                            if (!TextUtils.isEmpty(eVar.c())) {
                                if (!TextUtils.isEmpty(eVar.x())) {
                                    p.c("okhttp3Event:%s", eVar);
                                    this.E = true;
                                    synchronized (this.t) {
                                        String x2 = eVar.x();
                                        if (!this.t.containsKey(x2)) {
                                            this.t.put(x2, eVar);
                                        } else {
                                            Object obj4 = this.t.get(x2);
                                            if (obj4 instanceof com.bonree.sdk.n.e) {
                                                if (eVar.c() != null) {
                                                    HashMap hashMap = new HashMap();
                                                    hashMap.put(((com.bonree.sdk.n.e) obj4).c(), obj4);
                                                    if (TextUtils.equals(eVar.c(), ((com.bonree.sdk.n.e) obj4).c())) {
                                                        hashMap.put(eVar.v(), eVar);
                                                    } else {
                                                        hashMap.put(eVar.c(), eVar);
                                                    }
                                                    this.t.put(x2, hashMap);
                                                }
                                            } else if (obj4 instanceof HashMap) {
                                                if (((com.bonree.sdk.n.e) ((HashMap) obj4).get(eVar.c())) == null) {
                                                    ((HashMap) obj4).put(eVar.c(), eVar);
                                                } else {
                                                    ((HashMap) obj4).put(eVar.v(), eVar);
                                                }
                                            }
                                        }
                                    }
                                    return;
                                }
                            }
                        } catch (Throwable th6) {
                            p.a("okhttp3Event error:", th6);
                            return;
                        }
                    }
                    p.e("okhttp3Event is invalid :%s", eVar);
                    return;
                case 7:
                    com.bonree.sdk.n.a aVar2 = (com.bonree.sdk.n.a) obj;
                    if (aVar2 != null) {
                        NetworkEventInfoBean a9 = g.a(aVar2, this.G);
                        a9.mCustomBusinessHeader = g.a(aVar2.n(), this.w);
                        a9.mResponseTraceInfo = g.b(aVar2.o(), this.z);
                        a9.mRequestTraceInfo = g.c(aVar2.n(), this.A);
                        g.a(a9, aVar2.n(), this.B);
                        if (aVar2.o() != null && aVar2.o().size() > 0) {
                            String a10 = u.a(aVar2.o());
                            if (!TextUtils.isEmpty(a10)) {
                                a9.mTraceId = a10;
                            }
                            String b4 = u.b(aVar2.o());
                            if (!TextUtils.isEmpty(b4)) {
                                a9.xBrResponse = b4;
                            }
                            String c3 = u.c(aVar2.o());
                            if (!TextUtils.isEmpty(c3)) {
                                a9.traceResponse = c3;
                            }
                        }
                        g.a(aVar2, a9);
                        a(a9);
                        return;
                    }
                    return;
                case 8:
                    try {
                        e.a.a.a(8);
                        long b5 = com.bonree.sdk.d.a.b();
                        a(b5);
                        b(b5);
                        e(b5);
                        d(b5);
                        c(b5);
                        e.a.a.a(8, (long) GTJobService.WAIT_TIME);
                        return;
                    } catch (Throwable th7) {
                        p.c("timer exception:", th7);
                        return;
                    }
                case 9:
                    b((NetworkEventInfoBean) obj);
                    return;
                case 10:
                    com.bonree.sdk.n.b bVar2 = (com.bonree.sdk.n.b) obj;
                    if (bVar2 != null) {
                        try {
                            if (bVar2.f() != null) {
                                NetworkEventInfoBean a11 = g.a(bVar2, this.v, this.G);
                                a11.mCustomBusinessHeader = g.a(bVar2.w(), this.w);
                                a11.mCustomBusinessQuery = g.a(a11.mRequestUrl, this.y);
                                a11.mResponseTraceInfo = g.b(bVar2.N(), this.z);
                                a11.mRequestTraceInfo = g.c(bVar2.w(), this.A);
                                String d3 = u.d(bVar2.d());
                                if (!TextUtils.isEmpty(d3)) {
                                    a11.mTraceId = d3;
                                }
                                String e2 = u.e(bVar2.d());
                                if (!TextUtils.isEmpty(e2)) {
                                    a11.xBrResponse = e2;
                                }
                                String f2 = u.f(bVar2.d());
                                if (!TextUtils.isEmpty(f2)) {
                                    a11.traceResponse = f2;
                                }
                                EventBean eventBean = new EventBean();
                                eventBean.mEventType = BaseEventInfo.EVENT_TYPE_NETWORK;
                                eventBean.mEventTime = bVar2.R() * 1000;
                                if (eventBean.mEventTime < 0) {
                                    this.H.getAndIncrement();
                                } else if (this.H.get() > 0) {
                                    j();
                                }
                                eventBean.mStateIndex = eventBean.getStateIndex();
                                eventBean.mEventInfo = a11;
                                g.a(eventBean, a11);
                                synchronized (this.q) {
                                    if (this.q.size() >= 1500) {
                                        this.q.remove(0);
                                    }
                                    eventBean.uploadStateKey();
                                    this.q.add(eventBean);
                                }
                                p.c("network flutter eventBean :%s", eventBean);
                                return;
                            }
                            return;
                        } catch (Exception e3) {
                            f fVar6 = p;
                            fVar6.e("constructFlutterNetworkData error:" + e3.toString(), new Object[0]);
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        a((List) this.q);
        a((Map) this.r);
        a((Map) this.s);
        a((Map) this.t);
        a((Map) this.u);
        a((Map) this.v);
        a((List) this.C);
        this.B.d();
    }

    private void e() {
        a((List) this.q);
        g();
    }

    private void h() {
        try {
            e.a.a.a(8);
            long b2 = com.bonree.sdk.d.a.b();
            a(b2);
            b(b2);
            e(b2);
            d(b2);
            c(b2);
            e.a.a.a(8, (long) GTJobService.WAIT_TIME);
        } catch (Throwable th) {
            p.c("timer exception:", th);
        }
    }
}
