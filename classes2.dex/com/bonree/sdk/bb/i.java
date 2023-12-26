package com.bonree.sdk.bb;

import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.H5EventInfoBean;
import com.bonree.sdk.agent.business.entity.JSErrorEventInfoBean;
import com.bonree.sdk.agent.business.entity.WebviewResourceBean;
import com.bonree.sdk.agent.engine.webview.entity.PagePerformanceTiming;
import com.bonree.sdk.agent.engine.webview.entity.ResourcePerformanceTiming;
import com.bonree.sdk.agent.engine.webview.entity.WebviewJSErrorEvent;
import com.bonree.sdk.agent.engine.webview.entity.WebviewPerformanceTimingEvent;
import com.bonree.sdk.ar.g;
import com.bonree.sdk.bb.k;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.k;
import com.bonree.sdk.common.gson.Gson;
import com.igexin.assist.control.fcm.GTJobService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class i {
    private static int a = 0;
    private static int b = 1;
    private static int c = 2;
    private static int d = 3;
    private static final int e = 1000;
    private static int f = 30000;
    private static String g = "BR-Webview-Thread";
    private static f h = com.bonree.sdk.be.a.a();
    private final List<EventBean> i;
    private final List<EventBean> j;
    private final Map<String, Long> k;
    private final Map<String, Long> l;
    private final Map<String, List<JSErrorEventInfoBean>> m;
    private final AtomicInteger n;
    private final AtomicInteger o;
    private final f p;
    private final List<String> q;
    private final List<String> r;
    private final List<String> s;
    private Gson t;

    /* synthetic */ i(byte b2) {
        this();
    }

    private i() {
        this.n = new AtomicInteger(0);
        this.o = new AtomicInteger(0);
        this.t = new Gson();
        this.i = Collections.synchronizedList(new ArrayList());
        this.j = Collections.synchronizedList(new ArrayList());
        this.l = new k();
        this.k = new k();
        this.m = new k();
        this.p = new f(this);
        this.q = Collections.synchronizedList(new ArrayList());
        this.r = Collections.synchronizedList(new ArrayList());
        this.s = Collections.synchronizedList(new ArrayList());
    }

    static class a {
        /* access modifiers changed from: private */
        public static final i a = new i((byte) 0);

        private a() {
        }
    }

    public static i a() {
        return a.a;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String[] r3) {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.q
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = r2.q     // Catch:{ all -> 0x0017 }
            r1.clear()     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            int r1 = r3.length     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.util.List<java.lang.String> r1 = r2.q     // Catch:{ all -> 0x0017 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bb.i.a(java.lang.String[]):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String[] r3) {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.r
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = r2.r     // Catch:{ all -> 0x0017 }
            r1.clear()     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            int r1 = r3.length     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.util.List<java.lang.String> r1 = r2.r     // Catch:{ all -> 0x0017 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bb.i.b(java.lang.String[]):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        List<String> list = this.r;
        return list != null && list.size() > 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String[] r3) {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = r2.s
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = r2.s     // Catch:{ all -> 0x0017 }
            r1.clear()     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            int r1 = r3.length     // Catch:{ all -> 0x0017 }
            if (r1 != 0) goto L_0x000e
            goto L_0x0015
        L_0x000e:
            java.util.List<java.lang.String> r1 = r2.s     // Catch:{ all -> 0x0017 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bb.i.c(java.lang.String[]):void");
    }

    public final void a(Message message) {
        Object obj = message.obj;
        if (obj != null) {
            int i2 = message.what;
            if (i2 == 0) {
                com.bonree.sdk.w.a aVar = (com.bonree.sdk.w.a) obj;
                if (aVar != null && aVar.c() != null) {
                    try {
                        if (aVar.f()) {
                            this.p.a(aVar);
                            return;
                        }
                        WebviewPerformanceTimingEvent webviewPerformanceTimingEvent = (WebviewPerformanceTimingEvent) this.t.fromJson(aVar.c(), WebviewPerformanceTimingEvent.class);
                        List<ResourcePerformanceTiming> rt = webviewPerformanceTimingEvent.getRt();
                        PagePerformanceTiming pt = webviewPerformanceTimingEvent.getPt();
                        if (pt != null) {
                            pt.getNs();
                        }
                        a(pt, a(rt), aVar);
                    } catch (Throwable th) {
                        h.e("WebviewService exception pageData:\r\n%s", aVar.c());
                        h.a("WebviewService parse ReceivedData exception: %s", th);
                    }
                }
            } else if (i2 == 1) {
                com.bonree.sdk.agent.engine.network.websocket.a aVar2 = (com.bonree.sdk.agent.engine.network.websocket.a) obj;
                if (aVar2 != null) {
                    try {
                        WebviewJSErrorEvent webviewJSErrorEvent = (WebviewJSErrorEvent) new Gson().fromJson(aVar2.b(), WebviewJSErrorEvent.class);
                        JSErrorEventInfoBean jSErrorEventInfoBean = new JSErrorEventInfoBean();
                        jSErrorEventInfoBean.startTime = aVar2.a();
                        jSErrorEventInfoBean.pvid = webviewJSErrorEvent.pvid;
                        jSErrorEventInfoBean.url = webviewJSErrorEvent.url;
                        jSErrorEventInfoBean.col = webviewJSErrorEvent.col;
                        jSErrorEventInfoBean.line = webviewJSErrorEvent.line;
                        if (!TextUtils.isEmpty(webviewJSErrorEvent.msg)) {
                            jSErrorEventInfoBean.msg = webviewJSErrorEvent.msg;
                        }
                        if (!TextUtils.isEmpty(webviewJSErrorEvent.name)) {
                            jSErrorEventInfoBean.name = webviewJSErrorEvent.name;
                        }
                        if (!TextUtils.isEmpty(webviewJSErrorEvent.errorName)) {
                            jSErrorEventInfoBean.type = webviewJSErrorEvent.errorName;
                        }
                        if (!TextUtils.isEmpty(webviewJSErrorEvent.stack)) {
                            jSErrorEventInfoBean.stack = webviewJSErrorEvent.stack;
                        }
                        if (!TextUtils.isEmpty(webviewJSErrorEvent.title)) {
                            jSErrorEventInfoBean.title = webviewJSErrorEvent.title;
                        }
                        if (webviewJSErrorEvent.pvid != null) {
                            if (TextUtils.isEmpty(webviewJSErrorEvent.type) || !"1".equals(webviewJSErrorEvent.type.trim())) {
                                jSErrorEventInfoBean.mCustomBusinessHeader = g.a(aVar2.d(), this.q);
                                jSErrorEventInfoBean.mCustomBusinessQuery = g.a(aVar2.f(), this.s);
                                jSErrorEventInfoBean.mCustomBusinessBody = g.a((Object) aVar2.e(), this.r);
                                if (this.k.containsKey(webviewJSErrorEvent.pvid)) {
                                    long longValue = this.k.get(webviewJSErrorEvent.pvid).longValue();
                                    if (longValue != 0) {
                                        jSErrorEventInfoBean.pageCreateTime = longValue;
                                        a(jSErrorEventInfoBean, BaseEventInfo.EVENT_TYPE_JSERROR);
                                        return;
                                    }
                                    h.a("pvidTimeMap.key=%s,pvidTimeMap.value=%d", webviewJSErrorEvent.pvid, Long.valueOf(longValue));
                                } else if (this.m.containsKey(webviewJSErrorEvent.pvid)) {
                                    synchronized (this.m) {
                                        this.m.get(webviewJSErrorEvent.pvid).add(jSErrorEventInfoBean);
                                    }
                                } else {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(jSErrorEventInfoBean);
                                    if (!TextUtils.isEmpty(webviewJSErrorEvent.pvid)) {
                                        this.m.put(webviewJSErrorEvent.pvid, arrayList);
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        h.a("parse createWebviewError exception", th2);
                    }
                }
            } else if (i2 == 2) {
                com.bonree.sdk.ab.f fVar = (com.bonree.sdk.ab.f) obj;
                synchronized (this.l) {
                    if (!TextUtils.isEmpty(fVar.a)) {
                        this.l.put(fVar.a, Long.valueOf(com.bonree.sdk.d.a.b()));
                    }
                }
            } else if (i2 == 3) {
                f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final List<EventBean> d() {
        ArrayList arrayList;
        synchronized (this.i) {
            if (this.n.get() > 0) {
                h();
            }
            if (this.l.size() > 0) {
                synchronized (this.i) {
                    ArrayList arrayList2 = new ArrayList();
                    for (EventBean next : this.i) {
                        H5EventInfoBean h5EventInfoBean = (H5EventInfoBean) next.mEventInfo;
                        if (!(h5EventInfoBean == null || h5EventInfoBean.mRequestUrl == null || !this.l.containsKey(h5EventInfoBean.mRequestUrl))) {
                            f fVar = h;
                            fVar.a("validityH5EventUrl :" + h5EventInfoBean.mRequestUrl, new Object[0]);
                            arrayList2.add(next);
                        }
                    }
                    this.i.removeAll(arrayList2);
                }
            }
            arrayList = new ArrayList(this.i);
            List<EventBean> list = this.i;
            if (list != null && list.size() > 0) {
                this.i.clear();
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<EventBean> e() {
        ArrayList arrayList;
        synchronized (this.j) {
            if (this.o.get() > 0) {
                i();
            }
            arrayList = new ArrayList(this.j);
            List<EventBean> list = this.j;
            if (list != null && list.size() > 0) {
                this.j.clear();
            }
        }
        return arrayList;
    }

    private void f() {
        try {
            long b2 = com.bonree.sdk.d.a.b();
            k.a.a.a(3);
            synchronized (this.m) {
                Iterator<Map.Entry<String, List<JSErrorEventInfoBean>>> it = this.m.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    if (!TextUtils.isEmpty((CharSequence) next.getKey()) && this.k.containsKey(next.getKey())) {
                        List<JSErrorEventInfoBean> list = (List) next.getValue();
                        long longValue = this.k.get(next.getKey()).longValue();
                        if (longValue != 0) {
                            for (JSErrorEventInfoBean jSErrorEventInfoBean : list) {
                                jSErrorEventInfoBean.pageCreateTime = longValue;
                                a(jSErrorEventInfoBean, BaseEventInfo.EVENT_TYPE_JSERROR);
                            }
                        } else {
                            h.a("pvidTimeMap.key=%s,pvidTimeMap.value=%d, jsErrorEventBeans.size=%d", next.getKey(), Long.valueOf(longValue), Integer.valueOf(list.size()));
                        }
                        it.remove();
                    }
                }
            }
            synchronized (this.l) {
                Iterator<Map.Entry<String, Long>> it2 = this.l.entrySet().iterator();
                while (it2.hasNext()) {
                    if (b2 - ((Long) it2.next().getValue()).longValue() > 60000) {
                        it2.remove();
                    }
                }
            }
            k.a.a.a(3, (long) GTJobService.WAIT_TIME);
        } catch (Throwable th) {
            h.c("timer exception:", th);
        }
    }

    private void a(com.bonree.sdk.w.a aVar) {
        if (aVar != null && aVar.c() != null) {
            try {
                if (aVar.f()) {
                    this.p.a(aVar);
                    return;
                }
                WebviewPerformanceTimingEvent webviewPerformanceTimingEvent = (WebviewPerformanceTimingEvent) this.t.fromJson(aVar.c(), WebviewPerformanceTimingEvent.class);
                List<ResourcePerformanceTiming> rt = webviewPerformanceTimingEvent.getRt();
                PagePerformanceTiming pt = webviewPerformanceTimingEvent.getPt();
                if (pt != null) {
                    pt.getNs();
                }
                a(pt, a(rt), aVar);
            } catch (Throwable th) {
                h.e("WebviewService exception pageData:\r\n%s", aVar.c());
                h.a("WebviewService parse ReceivedData exception: %s", th);
            }
        }
    }

    private static List<WebviewResourceBean> a(List<ResourcePerformanceTiming> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (ResourcePerformanceTiming next : list) {
                WebviewResourceBean webviewResourceBean = new WebviewResourceBean();
                webviewResourceBean.startTime = next.getSt();
                webviewResourceBean.resourceType = next.getRt();
                webviewResourceBean.name = next.getName();
                webviewResourceBean.duration = next.getDura();
                webviewResourceBean.fetchStart = next.getFs();
                webviewResourceBean.domainLookupStart = next.getDls();
                webviewResourceBean.domainLookupEnd = next.getDle();
                webviewResourceBean.connectStart = next.getCs();
                webviewResourceBean.connectEnd = next.getCe();
                webviewResourceBean.secureConnectionStart = next.getScs();
                webviewResourceBean.requestStart = next.getReqs();
                webviewResourceBean.responseStart = next.getRsps();
                webviewResourceBean.responseEnd = next.getRspe();
                webviewResourceBean.transferSize = next.getTs();
                webviewResourceBean.encodedBodySize = next.getEbs();
                webviewResourceBean.decodedBodySize = next.getDbs();
                webviewResourceBean.nextHopProtocol = next.getPr();
                arrayList.add(webviewResourceBean);
            }
        } catch (Throwable th) {
            h.a("add webview resource exception:", th);
        }
        return arrayList;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private void a(com.bonree.sdk.agent.engine.webview.entity.PagePerformanceTiming r9, java.util.List<com.bonree.sdk.agent.business.entity.WebviewResourceBean> r10, com.bonree.sdk.w.a r11) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x0147
            if (r11 != 0) goto L_0x0006
            goto L_0x0147
        L_0x0006:
            long r0 = r11.d()
            com.bonree.sdk.agent.business.entity.WebviewPerformanceTiming r2 = new com.bonree.sdk.agent.business.entity.WebviewPerformanceTiming
            r2.<init>()
            long r3 = r9.getNs()
            r2.ns = r3
            int r3 = r9.getFs()
            r2.fs = r3
            int r3 = r9.getReqs()
            r2.reqs = r3
            int r3 = r9.getRsps()
            r2.rsps = r3
            int r3 = r9.getRspe()
            r2.rspe = r3
            int r3 = r9.getDcles()
            r2.dcles = r3
            int r3 = r9.getDclee()
            r2.dclee = r3
            int r3 = r9.getDi()
            r2.di = r3
            int r3 = r9.getDc()
            r2.dc = r3
            int r3 = r9.getDl()
            r2.dl = r3
            int r3 = r9.getLes()
            r2.les = r3
            int r3 = r9.getLee()
            r2.lee = r3
            int r3 = r9.getUes()
            r2.ues = r3
            int r3 = r9.getUee()
            r2.uee = r3
            int r3 = r9.getCs()
            r2.cs = r3
            int r3 = r9.getCe()
            r2.ce = r3
            int r3 = r9.getDls()
            r2.dls = r3
            int r3 = r9.getDle()
            r2.dle = r3
            int r3 = r9.getRds()
            r2.rds = r3
            int r3 = r9.getRde()
            r2.rde = r3
            int r3 = r9.getScs()
            r2.scs = r3
            int r3 = r9.getFp()
            r2.fp = r3
            int r3 = r9.getFcp()
            r2.fcp = r3
            int r3 = r9.getLcp()
            r2.lcp = r3
            com.bonree.sdk.agent.business.entity.H5EventInfoBean r3 = new com.bonree.sdk.agent.business.entity.H5EventInfoBean
            r3.<init>()
            int r4 = r2.lee
            if (r4 <= 0) goto L_0x00af
            int r4 = r2.lee
        L_0x00aa:
            int r4 = r4 * 1000
            long r4 = (long) r4
            long r0 = r0 - r4
            goto L_0x00b6
        L_0x00af:
            int r4 = r2.les
            if (r4 <= 0) goto L_0x00b6
            int r4 = r2.les
            goto L_0x00aa
        L_0x00b6:
            r3.startTime = r0
            java.lang.String r0 = r9.getPvid()
            r3.mPvid = r0
            r0 = 0
            r3.isCustom = r0
            java.util.Map<java.lang.String, java.lang.Long> r1 = r8.k
            monitor-enter(r1)
            java.lang.String r4 = r3.mPvid     // Catch:{ all -> 0x0144 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0144 }
            if (r4 != 0) goto L_0x00d9
            java.util.Map<java.lang.String, java.lang.Long> r4 = r8.k     // Catch:{ all -> 0x0144 }
            java.lang.String r5 = r3.mPvid     // Catch:{ all -> 0x0144 }
            long r6 = r3.startTime     // Catch:{ all -> 0x0144 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0144 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0144 }
        L_0x00d9:
            monitor-exit(r1)     // Catch:{ all -> 0x0144 }
            java.lang.String r9 = r9.getUrl()
            r3.mRequestUrl = r9
            r3.mWebviewPerformanceTiming = r2
            if (r10 == 0) goto L_0x00ec
            int r9 = r10.size()
            if (r9 <= 0) goto L_0x00ec
            r3.mWebviewResources = r10
        L_0x00ec:
            java.util.Map r9 = r11.h()
            java.util.List<java.lang.String> r10 = r8.q
            java.lang.String r9 = com.bonree.sdk.ar.g.a((java.util.Map<java.lang.String, java.lang.String>) r9, (java.util.List<java.lang.String>) r10)
            r3.mCustomBusinessHeader = r9
            java.lang.String r9 = r11.j()
            java.util.List<java.lang.String> r10 = r8.s
            java.lang.String r9 = com.bonree.sdk.ar.g.a((java.lang.String) r9, (java.util.List<java.lang.String>) r10)
            r3.mCustomBusinessQuery = r9
            java.lang.String r9 = r11.i()
            java.util.List<java.lang.String> r10 = r8.r
            java.lang.String r9 = com.bonree.sdk.ar.g.a((java.lang.Object) r9, (java.util.List<java.lang.String>) r10)
            r3.mCustomBusinessBody = r9
            java.util.Map<java.lang.String, java.lang.Long> r9 = r8.l
            int r9 = r9.size()
            if (r9 <= 0) goto L_0x013e
            java.lang.String r9 = r3.mRequestUrl
            if (r9 == 0) goto L_0x013e
            java.util.Map<java.lang.String, java.lang.Long> r9 = r8.l
            java.lang.String r10 = r3.mRequestUrl
            boolean r9 = r9.containsKey(r10)
            if (r9 == 0) goto L_0x013e
            com.bonree.sdk.be.f r9 = h
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "webViewHandler url is error ："
            r10.<init>(r11)
            java.lang.String r11 = r3.mRequestUrl
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.Object[] r11 = new java.lang.Object[r0]
            r9.a((java.lang.String) r10, (java.lang.Object[]) r11)
            return
        L_0x013e:
            java.lang.String r9 = "h5"
            r8.a((com.bonree.sdk.agent.business.entity.H5EventInfoBean) r3, (java.lang.String) r9)
            return
        L_0x0144:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0144 }
            throw r9
        L_0x0147:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bb.i.a(com.bonree.sdk.agent.engine.webview.entity.PagePerformanceTiming, java.util.List, com.bonree.sdk.w.a):void");
    }

    private void a(com.bonree.sdk.agent.engine.network.websocket.a aVar) {
        if (aVar != null) {
            try {
                WebviewJSErrorEvent webviewJSErrorEvent = (WebviewJSErrorEvent) new Gson().fromJson(aVar.b(), WebviewJSErrorEvent.class);
                JSErrorEventInfoBean jSErrorEventInfoBean = new JSErrorEventInfoBean();
                jSErrorEventInfoBean.startTime = aVar.a();
                jSErrorEventInfoBean.pvid = webviewJSErrorEvent.pvid;
                jSErrorEventInfoBean.url = webviewJSErrorEvent.url;
                jSErrorEventInfoBean.col = webviewJSErrorEvent.col;
                jSErrorEventInfoBean.line = webviewJSErrorEvent.line;
                if (!TextUtils.isEmpty(webviewJSErrorEvent.msg)) {
                    jSErrorEventInfoBean.msg = webviewJSErrorEvent.msg;
                }
                if (!TextUtils.isEmpty(webviewJSErrorEvent.name)) {
                    jSErrorEventInfoBean.name = webviewJSErrorEvent.name;
                }
                if (!TextUtils.isEmpty(webviewJSErrorEvent.errorName)) {
                    jSErrorEventInfoBean.type = webviewJSErrorEvent.errorName;
                }
                if (!TextUtils.isEmpty(webviewJSErrorEvent.stack)) {
                    jSErrorEventInfoBean.stack = webviewJSErrorEvent.stack;
                }
                if (!TextUtils.isEmpty(webviewJSErrorEvent.title)) {
                    jSErrorEventInfoBean.title = webviewJSErrorEvent.title;
                }
                if (webviewJSErrorEvent.pvid != null) {
                    if (TextUtils.isEmpty(webviewJSErrorEvent.type) || !"1".equals(webviewJSErrorEvent.type.trim())) {
                        jSErrorEventInfoBean.mCustomBusinessHeader = g.a(aVar.d(), this.q);
                        jSErrorEventInfoBean.mCustomBusinessQuery = g.a(aVar.f(), this.s);
                        jSErrorEventInfoBean.mCustomBusinessBody = g.a((Object) aVar.e(), this.r);
                        if (this.k.containsKey(webviewJSErrorEvent.pvid)) {
                            long longValue = this.k.get(webviewJSErrorEvent.pvid).longValue();
                            if (longValue != 0) {
                                jSErrorEventInfoBean.pageCreateTime = longValue;
                                a(jSErrorEventInfoBean, BaseEventInfo.EVENT_TYPE_JSERROR);
                                return;
                            }
                            h.a("pvidTimeMap.key=%s,pvidTimeMap.value=%d", webviewJSErrorEvent.pvid, Long.valueOf(longValue));
                        } else if (this.m.containsKey(webviewJSErrorEvent.pvid)) {
                            synchronized (this.m) {
                                this.m.get(webviewJSErrorEvent.pvid).add(jSErrorEventInfoBean);
                            }
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(jSErrorEventInfoBean);
                            if (!TextUtils.isEmpty(webviewJSErrorEvent.pvid)) {
                                this.m.put(webviewJSErrorEvent.pvid, arrayList);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                h.a("parse createWebviewError exception", th);
            }
        }
    }

    private void a(com.bonree.sdk.ab.f fVar) {
        synchronized (this.l) {
            if (!TextUtils.isEmpty(fVar.a)) {
                this.l.put(fVar.a, Long.valueOf(com.bonree.sdk.d.a.b()));
            }
        }
    }

    private static long a(long j2) {
        return com.bonree.sdk.d.a.c(j2);
    }

    private void g() {
        synchronized (this.i) {
            ArrayList arrayList = new ArrayList();
            for (EventBean next : this.i) {
                H5EventInfoBean h5EventInfoBean = (H5EventInfoBean) next.mEventInfo;
                if (!(h5EventInfoBean == null || h5EventInfoBean.mRequestUrl == null || !this.l.containsKey(h5EventInfoBean.mRequestUrl))) {
                    f fVar = h;
                    fVar.a("validityH5EventUrl :" + h5EventInfoBean.mRequestUrl, new Object[0]);
                    arrayList.add(next);
                }
            }
            this.i.removeAll(arrayList);
        }
    }

    private void h() {
        synchronized (this.i) {
            for (EventBean next : this.i) {
                if (next.mEventTime < 0) {
                    next.correctEventTime(com.bonree.sdk.d.a.c(next.mEventTime));
                    this.n.getAndDecrement();
                    if (this.n.get() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    private void i() {
        synchronized (this.j) {
            for (EventBean next : this.j) {
                if (next.mEventTime < 0) {
                    next.correctEventTime(com.bonree.sdk.d.a.c(next.mEventTime));
                    if (next.mEventInfo instanceof JSErrorEventInfoBean) {
                        JSErrorEventInfoBean jSErrorEventInfoBean = (JSErrorEventInfoBean) next.mEventInfo;
                        if (jSErrorEventInfoBean.pageCreateTime < 0) {
                            jSErrorEventInfoBean.pageCreateTime = com.bonree.sdk.d.a.c(jSErrorEventInfoBean.pageCreateTime);
                            next.mEventInfo = jSErrorEventInfoBean;
                        }
                    }
                    this.o.getAndDecrement();
                    if (this.o.get() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(H5EventInfoBean h5EventInfoBean, String str) {
        EventBean eventBean = new EventBean();
        eventBean.mEventType = str;
        eventBean.mEventTime = h5EventInfoBean.startTime;
        if (eventBean.mEventTime < 0) {
            this.n.getAndIncrement();
        } else if (this.n.get() > 0) {
            h();
        }
        eventBean.mStateIndex = eventBean.getStateIndex();
        eventBean.mEventInfo = h5EventInfoBean;
        eventBean.uploadStateKey();
        a(eventBean);
    }

    private void a(EventBean eventBean) {
        synchronized (this.i) {
            if (this.i.size() >= 200) {
                this.i.remove(0);
            }
            this.i.add(eventBean);
        }
    }

    private void a(JSErrorEventInfoBean jSErrorEventInfoBean, String str) {
        EventBean eventBean = new EventBean();
        eventBean.mEventType = str;
        eventBean.mEventTime = jSErrorEventInfoBean.startTime;
        if (eventBean.mEventTime < 0) {
            this.o.getAndIncrement();
        } else if (this.o.get() > 0) {
            i();
        }
        eventBean.mStateIndex = eventBean.getStateIndex();
        eventBean.mEventInfo = jSErrorEventInfoBean;
        synchronized (this.j) {
            if (this.j.size() >= 200) {
                this.j.remove(0);
            }
            eventBean.uploadStateKey();
            this.j.add(eventBean);
        }
    }

    private void j() {
        List<EventBean> list = this.i;
        if (list != null && list.size() > 0) {
            this.i.clear();
        }
        List<EventBean> list2 = this.j;
        if (list2 != null && list2.size() > 0) {
            this.j.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        List<EventBean> list = this.i;
        if (list != null && list.size() > 0) {
            this.i.clear();
        }
        List<EventBean> list2 = this.j;
        if (list2 != null && list2.size() > 0) {
            this.j.clear();
        }
    }
}
