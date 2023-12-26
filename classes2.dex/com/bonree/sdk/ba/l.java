package com.bonree.sdk.ba;

import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.ViewEventInfoBean;
import com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.d.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class l extends e {
    private static final long b = 50;
    private static final long c = 120000;
    private final Map<String, WebviewPageEvent> d = Collections.synchronizedMap(new HashMap());
    private final Map<String, WebviewPageEvent> e = Collections.synchronizedMap(new HashMap());
    private long f;
    private final Gson g = new Gson();

    l(o oVar) {
        super(oVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[Catch:{ all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d6 A[Catch:{ all -> 0x00e4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bonree.sdk.ab.i r13) {
        /*
            r12 = this;
            r0 = 0
            r1 = 1
            com.bonree.sdk.common.gson.Gson r2 = r12.g     // Catch:{ all -> 0x00e4 }
            java.lang.String r13 = r13.a()     // Catch:{ all -> 0x00e4 }
            java.lang.Class<com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent> r3 = com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent.class
            java.lang.Object r13 = r2.fromJson((java.lang.String) r13, r3)     // Catch:{ all -> 0x00e4 }
            com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent r13 = (com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent) r13     // Catch:{ all -> 0x00e4 }
            int r2 = r13.isMainDocument     // Catch:{ all -> 0x00e4 }
            if (r2 != 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.String r2 = r13.mViewName     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = "https:"
            boolean r3 = r2.startsWith(r3)     // Catch:{ all -> 0x00e4 }
            if (r3 != 0) goto L_0x003a
            java.lang.String r3 = "http:"
            boolean r3 = r2.startsWith(r3)     // Catch:{ all -> 0x00e4 }
            if (r3 != 0) goto L_0x003a
            java.lang.String r3 = "file:"
            boolean r3 = r2.startsWith(r3)     // Catch:{ all -> 0x00e4 }
            if (r3 != 0) goto L_0x003a
            java.lang.String r3 = "dataability:"
            boolean r2 = r2.startsWith(r3)     // Catch:{ all -> 0x00e4 }
            if (r2 == 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r2 = r0
            goto L_0x003b
        L_0x003a:
            r2 = r1
        L_0x003b:
            if (r2 == 0) goto L_0x00d6
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00e4 }
            long r4 = com.bonree.sdk.d.a.b()     // Catch:{ all -> 0x00e4 }
            long r6 = r13.mEventTimeMS     // Catch:{ all -> 0x00e4 }
            long r6 = r2 - r6
            long r8 = r4 - r6
            r13.mRealTimeMs = r8     // Catch:{ all -> 0x00e4 }
            long r8 = com.bonree.sdk.d.a.l()     // Catch:{ all -> 0x00e4 }
            r10 = 0
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 <= 0) goto L_0x0068
            long r8 = r13.mEventTimeMS     // Catch:{ all -> 0x00e4 }
            long r8 = -r8
            long r8 = com.bonree.sdk.bs.ad.a((long) r8)     // Catch:{ all -> 0x00e4 }
            long r8 = com.bonree.sdk.d.a.c((long) r8)     // Catch:{ all -> 0x00e4 }
            r10 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 / r10
            r13.mEventTimeMS = r8     // Catch:{ all -> 0x00e4 }
            goto L_0x006d
        L_0x0068:
            long r8 = r13.mEventTimeMS     // Catch:{ all -> 0x00e4 }
            long r8 = -r8
            r13.mEventTimeMS = r8     // Catch:{ all -> 0x00e4 }
        L_0x006d:
            com.bonree.sdk.be.f r8 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00e4 }
            java.lang.String r9 = "ViewService H5Page updatePageRealTime curTime %s, curRealTime %s, update after page.mEventTimeMS %s, page.mRealTimeMs %s, temp %s."
            r10 = 5
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x00e4 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00e4 }
            r10[r0] = r2     // Catch:{ all -> 0x00e4 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00e4 }
            r10[r1] = r2     // Catch:{ all -> 0x00e4 }
            long r2 = r13.mEventTimeMS     // Catch:{ all -> 0x00e4 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00e4 }
            r3 = 2
            r10[r3] = r2     // Catch:{ all -> 0x00e4 }
            long r4 = r13.mRealTimeMs     // Catch:{ all -> 0x00e4 }
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x00e4 }
            r4 = 3
            r10[r4] = r2     // Catch:{ all -> 0x00e4 }
            r2 = 4
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x00e4 }
            r10[r2] = r5     // Catch:{ all -> 0x00e4 }
            r8.c(r9, r10)     // Catch:{ all -> 0x00e4 }
            long r5 = r13.mRealTimeMs     // Catch:{ all -> 0x00e4 }
            long r7 = r12.f     // Catch:{ all -> 0x00e4 }
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c6
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00e4 }
            java.lang.String r5 = "ViewService H5Page is filter, mActivityCreateTimeMs is %s, activity is %s. WebviewPageEvent is %s."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00e4 }
            long r6 = r12.f     // Catch:{ all -> 0x00e4 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x00e4 }
            r4[r0] = r6     // Catch:{ all -> 0x00e4 }
            com.bonree.sdk.z.b r6 = com.bonree.sdk.z.b.a()     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = r6.b()     // Catch:{ all -> 0x00e4 }
            r4[r1] = r6     // Catch:{ all -> 0x00e4 }
            r4[r3] = r13     // Catch:{ all -> 0x00e4 }
            r2.c(r5, r4)     // Catch:{ all -> 0x00e4 }
            return
        L_0x00c6:
            int r2 = r13.mModel     // Catch:{ all -> 0x00e4 }
            if (r2 != r1) goto L_0x00ce
            r12.b(r13)     // Catch:{ all -> 0x00e4 }
            goto L_0x00f6
        L_0x00ce:
            int r2 = r13.mModel     // Catch:{ all -> 0x00e4 }
            if (r2 != r3) goto L_0x00e3
            r12.c(r13)     // Catch:{ all -> 0x00e4 }
            goto L_0x00f6
        L_0x00d6:
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = "ViewService H5Page url is verify false %s"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x00e4 }
            r4[r0] = r13     // Catch:{ all -> 0x00e4 }
            r2.c(r3, r4)     // Catch:{ all -> 0x00e4 }
        L_0x00e3:
            return
        L_0x00e4:
            r13 = move-exception
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r13 = r13.getMessage()
            r1[r0] = r13
            java.lang.String r13 = "ViewService H5Page is error %s"
            r2.e(r13, r1)
        L_0x00f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.l.a(com.bonree.sdk.ab.i):void");
    }

    private static void a(WebviewPageEvent webviewPageEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        long b2 = a.b();
        long j = currentTimeMillis - webviewPageEvent.mEventTimeMS;
        webviewPageEvent.mRealTimeMs = b2 - j;
        if (a.l() > 0) {
            webviewPageEvent.mEventTimeMS = a.c(ad.a(-webviewPageEvent.mEventTimeMS)) / 1000;
        } else {
            webviewPageEvent.mEventTimeMS = -webviewPageEvent.mEventTimeMS;
        }
        com.bonree.sdk.be.a.a().c("ViewService H5Page updatePageRealTime curTime %s, curRealTime %s, update after page.mEventTimeMS %s, page.mRealTimeMs %s, temp %s.", Long.valueOf(currentTimeMillis), Long.valueOf(b2), Long.valueOf(webviewPageEvent.mEventTimeMS), Long.valueOf(webviewPageEvent.mRealTimeMs), Long.valueOf(j));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00df, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r12 == 0) goto L_0x00de
            java.lang.String r1 = r12.mPageId     // Catch:{ all -> 0x00db }
            if (r1 != 0) goto L_0x0009
            goto L_0x00de
        L_0x0009:
            long r1 = com.bonree.sdk.d.a.b()     // Catch:{ all -> 0x00db }
            java.util.Map<java.lang.String, com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent> r3 = r11.e     // Catch:{ all -> 0x00db }
            java.util.Set r3 = r3.entrySet()     // Catch:{ all -> 0x00db }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x00db }
        L_0x0017:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x00db }
            if (r4 == 0) goto L_0x0060
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x00db }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x00db }
            if (r4 == 0) goto L_0x0017
            java.lang.Object r5 = r4.getValue()     // Catch:{ all -> 0x00db }
            if (r5 == 0) goto L_0x0017
            java.lang.Object r5 = r4.getValue()     // Catch:{ all -> 0x00db }
            com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent r5 = (com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent) r5     // Catch:{ all -> 0x00db }
            long r5 = r5.mRealTimeMs     // Catch:{ all -> 0x00db }
            long r5 = r1 - r5
            r8 = 120000(0x1d4c0, double:5.9288E-319)
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x0017
            com.bonree.sdk.be.f r5 = com.bonree.sdk.be.a.a()     // Catch:{ all -> 0x00db }
            java.lang.String r6 = "ViewService H5Event ExitEvent is OverTime %d s, will remove, event is %s."
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x00db }
            r8 = 0
            java.lang.Object r9 = r4.getValue()     // Catch:{ all -> 0x00db }
            com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent r9 = (com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent) r9     // Catch:{ all -> 0x00db }
            long r9 = r9.mRealTimeMs     // Catch:{ all -> 0x00db }
            long r9 = r1 - r9
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x00db }
            r7[r8] = r9     // Catch:{ all -> 0x00db }
            r8 = 1
            r7[r8] = r4     // Catch:{ all -> 0x00db }
            r5.c(r6, r7)     // Catch:{ all -> 0x00db }
            r3.remove()     // Catch:{ all -> 0x00db }
            goto L_0x0017
        L_0x0060:
            java.lang.String r1 = r12.mPageId     // Catch:{ all -> 0x00db }
            java.util.Map<java.lang.String, com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent> r2 = r11.e     // Catch:{ all -> 0x00db }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00db }
            if (r2 != 0) goto L_0x00a8
            java.util.Map<java.lang.String, com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent> r2 = r11.e     // Catch:{ all -> 0x00db }
            boolean r2 = r2.containsKey(r1)     // Catch:{ all -> 0x00db }
            if (r2 == 0) goto L_0x00a8
            java.util.Map<java.lang.String, com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent> r2 = r11.e     // Catch:{ all -> 0x00db }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x00db }
            r8 = r2
            com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent r8 = (com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent) r8     // Catch:{ all -> 0x00db }
            if (r8 != 0) goto L_0x007f
            monitor-exit(r11)
            return
        L_0x007f:
            long r2 = r8.mRealTimeMs     // Catch:{ all -> 0x00db }
            long r4 = r12.mRealTimeMs     // Catch:{ all -> 0x00db }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x00a8
            r2 = 1
            r4 = 0
            r6 = 0
            r1 = r11
            r3 = r12
            r1.a(r2, r3, r4, r6)     // Catch:{ all -> 0x00db }
            r2 = 2
            long r4 = r8.mRealTimeMs     // Catch:{ all -> 0x00db }
            long r6 = r8.mEventTimeMS     // Catch:{ all -> 0x00db }
            long r6 = com.bonree.sdk.bs.ad.a((long) r6)     // Catch:{ all -> 0x00db }
            r1 = r11
            r3 = r12
            r1.a(r2, r3, r4, r6)     // Catch:{ all -> 0x00db }
            java.util.Map<java.lang.String, com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent> r0 = r11.e     // Catch:{ all -> 0x00db }
            java.lang.String r1 = r8.mPageId     // Catch:{ all -> 0x00db }
            r0.remove(r1)     // Catch:{ all -> 0x00db }
            monitor-exit(r11)
            return
        L_0x00a8:
            java.util.Map<java.lang.String, com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent> r2 = r11.d     // Catch:{ all -> 0x00db }
            int r2 = r2.size()     // Catch:{ all -> 0x00db }
            long r2 = (long) r2     // Catch:{ all -> 0x00db }
            r4 = 50
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x00ca
            java.util.Map<java.lang.String, com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent> r2 = r11.d     // Catch:{ all -> 0x00db }
            java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x00db }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00db }
            java.lang.Object r2 = r2.next()     // Catch:{ all -> 0x00db }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00db }
            java.util.Map<java.lang.String, com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent> r3 = r11.d     // Catch:{ all -> 0x00db }
            r3.remove(r2)     // Catch:{ all -> 0x00db }
        L_0x00ca:
            java.util.Map<java.lang.String, com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent> r2 = r11.d     // Catch:{ all -> 0x00db }
            r2.put(r1, r12)     // Catch:{ all -> 0x00db }
            r2 = 1
            r4 = 0
            r6 = 0
            r1 = r11
            r3 = r12
            r1.a(r2, r3, r4, r6)     // Catch:{ all -> 0x00db }
            monitor-exit(r11)
            return
        L_0x00db:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
        L_0x00de:
            monitor-exit(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.l.b(com.bonree.sdk.agent.engine.webview.entity.WebviewPageEvent):void");
    }

    private void c() {
        long b2 = a.b();
        Iterator<Map.Entry<String, WebviewPageEvent>> it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!(next == null || next.getValue() == null || b2 - ((WebviewPageEvent) next.getValue()).mRealTimeMs < c)) {
                com.bonree.sdk.be.a.a().c("ViewService H5Event ExitEvent is OverTime %d s, will remove, event is %s.", Long.valueOf(b2 - ((WebviewPageEvent) next.getValue()).mRealTimeMs), next);
                it.remove();
            }
        }
    }

    private synchronized void c(WebviewPageEvent webviewPageEvent) {
        WebviewPageEvent webviewPageEvent2 = this.d.get(webviewPageEvent.mPageId);
        if (webviewPageEvent2 != null) {
            a(2, webviewPageEvent2, webviewPageEvent.mRealTimeMs, ad.a(webviewPageEvent.mEventTimeMS));
            this.d.remove(webviewPageEvent.mPageId);
            return;
        }
        this.e.put(webviewPageEvent.mPageId, webviewPageEvent);
        com.bonree.sdk.be.a.a().c("ViewService H5Event cache exit event is %s", webviewPageEvent);
    }

    private void a(int i, WebviewPageEvent webviewPageEvent, long j, long j2) {
        int i2 = i;
        WebviewPageEvent webviewPageEvent2 = webviewPageEvent;
        long j3 = j2;
        if (webviewPageEvent2 != null) {
            try {
                if (this.a != null) {
                    EventBean eventBean = new EventBean();
                    eventBean.mEventType = BaseEventInfo.EVENT_TYPE_VIEW;
                    long j4 = 0;
                    eventBean.mEventTime = this.a.a(0);
                    eventBean.mStateIndex = eventBean.getStateIndex();
                    ViewEventInfoBean viewEventInfoBean = new ViewEventInfoBean();
                    viewEventInfoBean.mCorrelationId = webviewPageEvent2.mPageId;
                    viewEventInfoBean.mName = webviewPageEvent2.mViewName;
                    viewEventInfoBean.mModel = i2;
                    viewEventInfoBean.isCustom = false;
                    viewEventInfoBean.mIsSlow = Boolean.FALSE;
                    viewEventInfoBean.mType = 1;
                    if (webviewPageEvent2.mLoadTimeMS > 0) {
                        viewEventInfoBean.mLoadTimeUs = ad.a((long) webviewPageEvent2.mLoadTimeMS);
                    } else {
                        viewEventInfoBean.mLoadTimeUs = 999;
                    }
                    eventBean.mEventInfo = viewEventInfoBean;
                    if (i2 == 1) {
                        eventBean.mEventTime = this.a.a(ad.a(webviewPageEvent2.mEventTimeMS));
                    } else if (!(i2 != 2 || j3 == 0 || j == 0)) {
                        eventBean.mEventTime = this.a.a(j3);
                        long j5 = (j - webviewPageEvent2.mRealTimeMs) - ((long) webviewPageEvent2.mLoadTimeMS);
                        if (j5 > 0) {
                            j4 = ad.a(j5);
                        }
                        viewEventInfoBean.mStayTimeUs = Long.valueOf(j4);
                    }
                    com.bonree.sdk.be.a.a().c("ViewService H5Event model is %s, EnterView is %s, exitTimeStampUs is %s, exitRealTimeMs is %s", Integer.valueOf(i), webviewPageEvent2, Long.valueOf(j2), Long.valueOf(j));
                    eventBean.uploadStateKey();
                    this.a.b(eventBean);
                }
            } catch (Exception unused) {
            }
        }
    }

    private static boolean a(String str) {
        return str.startsWith("https:") || str.startsWith("http:") || str.startsWith("file:") || str.startsWith("dataability:");
    }

    public final void a(com.bonree.sdk.z.a aVar) {
        if (aVar.e() == 0 && (com.bonree.sdk.z.a.l.equals(aVar.c()) || com.bonree.sdk.z.a.o.equals(aVar.c()))) {
            this.f = aVar.f();
        }
        if (com.bonree.sdk.z.a.p.equals(aVar.c()) && 1 == aVar.e()) {
            b(aVar.f(), aVar.j());
        }
    }

    public final void a(com.bonree.sdk.x.a aVar) {
        if (aVar.e() == 0 && (com.bonree.sdk.x.a.l.equals(aVar.c()) || com.bonree.sdk.x.a.n.equals(aVar.c()))) {
            this.f = aVar.f();
        }
        if (com.bonree.sdk.x.a.o.equals(aVar.c()) && 1 == aVar.e()) {
            b(aVar.f(), aVar.j());
        }
    }

    public final void a(long j, long j2) {
        b(j, j2);
    }

    private synchronized void b(long j, long j2) {
        this.e.clear();
        if (!this.d.isEmpty()) {
            Iterator<Map.Entry<String, WebviewPageEvent>> it = this.d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (!(next == null || next.getValue() == null)) {
                    a(2, (WebviewPageEvent) next.getValue(), j, j2);
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a() {
        this.f = 0;
        this.d.clear();
        this.e.clear();
    }
}
