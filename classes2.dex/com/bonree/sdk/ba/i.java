package com.bonree.sdk.ba;

import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.ViewEventInfoBean;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.ba.m;
import com.bonree.sdk.be.a;
import com.bonree.sdk.bs.ad;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

final class i extends e {
    private static final String b = "FlutterDefaultView";
    private static final long c = 100;
    private final o d;
    private final ConcurrentHashMap<String, m.a> e = new ConcurrentHashMap<>();

    i(o oVar) {
        super(oVar);
        this.d = oVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.bonree.sdk.ba.m.a r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = r11.i
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = "FlutterDefaultView"
            r11.i = r0
        L_0x000f:
            int r0 = r11.h
            r1 = 1
            if (r0 != r1) goto L_0x0044
            java.lang.String r0 = r11.c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r1 = r10.e
            monitor-enter(r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0041 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0041 }
            if (r2 != 0) goto L_0x003f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0041 }
            int r2 = r2.size()     // Catch:{ all -> 0x0041 }
            long r2 = (long) r2     // Catch:{ all -> 0x0041 }
            r4 = 100
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0030
            monitor-exit(r1)     // Catch:{ all -> 0x0041 }
            goto L_0x0040
        L_0x0030:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0041 }
            r2.put(r0, r11)     // Catch:{ all -> 0x0041 }
            r4 = 1
            r6 = 0
            r8 = 0
            r3 = r10
            r5 = r11
            r3.a(r4, r5, r6, r8)     // Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r1)     // Catch:{ all -> 0x0041 }
        L_0x0040:
            return
        L_0x0041:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0041 }
            throw r11
        L_0x0044:
            java.lang.String r0 = r11.c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r1 = r10.e
            monitor-enter(r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x006a }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0068
            r4 = 2
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x006a }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x006a }
            r5 = r2
            com.bonree.sdk.ba.m$a r5 = (com.bonree.sdk.ba.m.a) r5     // Catch:{ all -> 0x006a }
            long r6 = r11.b     // Catch:{ all -> 0x006a }
            long r8 = r11.a     // Catch:{ all -> 0x006a }
            r3 = r10
            r3.a(r4, r5, r6, r8)     // Catch:{ all -> 0x006a }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r11 = r10.e     // Catch:{ all -> 0x006a }
            r11.remove(r0)     // Catch:{ all -> 0x006a }
        L_0x0068:
            monitor-exit(r1)     // Catch:{ all -> 0x006a }
            return
        L_0x006a:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006a }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.i.b(com.bonree.sdk.ba.m$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.bonree.sdk.ba.m.a r11) {
        /*
            r10 = this;
            java.lang.String r0 = r11.c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r1 = r10.e
            monitor-enter(r1)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x002d }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x002d }
            if (r2 != 0) goto L_0x002b
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x002d }
            int r2 = r2.size()     // Catch:{ all -> 0x002d }
            long r2 = (long) r2     // Catch:{ all -> 0x002d }
            r4 = 100
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x001c
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            return
        L_0x001c:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x002d }
            r2.put(r0, r11)     // Catch:{ all -> 0x002d }
            r4 = 1
            r6 = 0
            r8 = 0
            r3 = r10
            r5 = r11
            r3.a(r4, r5, r6, r8)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            return
        L_0x002d:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.i.c(com.bonree.sdk.ba.m$a):void");
    }

    private void d(m.a aVar) {
        String str = aVar.c;
        synchronized (this.e) {
            if (this.e.containsKey(str)) {
                a(2, this.e.get(str), aVar.b, aVar.a);
                this.e.remove(str);
            }
        }
    }

    private void a(int i, m.a aVar, long j, long j2) {
        if (aVar != null) {
            try {
                if (this.d != null) {
                    EventBean eventBean = new EventBean();
                    eventBean.mEventType = BaseEventInfo.EVENT_TYPE_VIEW;
                    eventBean.mEventTime = this.d.a(0);
                    eventBean.mStateIndex = eventBean.getStateIndex();
                    ViewEventInfoBean viewEventInfoBean = new ViewEventInfoBean();
                    if (aVar.e) {
                        viewEventInfoBean.mCorrelationId = aVar.d;
                    } else {
                        viewEventInfoBean.mCorrelationId = aVar.c;
                    }
                    viewEventInfoBean.mName = aVar.i;
                    viewEventInfoBean.mModel = i;
                    viewEventInfoBean.isCustom = false;
                    viewEventInfoBean.mIsSlow = Boolean.FALSE;
                    viewEventInfoBean.mType = 7;
                    viewEventInfoBean.mLoadTimeUs = 999;
                    eventBean.mEventInfo = viewEventInfoBean;
                    if (i == 1) {
                        eventBean.mEventTime = this.d.a(aVar.a);
                    } else if (!(i != 2 || j2 == 0 || j == 0)) {
                        eventBean.mEventTime = this.d.a(j2);
                        viewEventInfoBean.mStayTimeUs = Long.valueOf(ad.a(j - aVar.b));
                    }
                    a.a().c("ViewService FlutterViewEvent model is %s, EnterView is %s, exitTimeStampUs is %s, exitRealTimeMs is %s", Integer.valueOf(i), aVar, Long.valueOf(j), Long.valueOf(j2));
                    eventBean.uploadStateKey();
                    this.d.b(eventBean);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void a(e eVar) {
        if (eVar == e.BACKGROUND) {
            if (!this.e.isEmpty()) {
                synchronized (this.e) {
                    long b2 = com.bonree.sdk.d.a.b();
                    long l = com.bonree.sdk.d.a.l();
                    Iterator<String> it = this.e.keySet().iterator();
                    while (it.hasNext()) {
                        a(2, this.e.get(it.next()), b2, l);
                        if (this.e.size() > 10) {
                            it.remove();
                        }
                    }
                }
            }
        } else if (eVar == e.FOREGROUND && !this.e.isEmpty()) {
            synchronized (this.e) {
                long b3 = com.bonree.sdk.d.a.b();
                long l2 = com.bonree.sdk.d.a.l();
                for (String str : this.e.keySet()) {
                    m.a aVar = this.e.get(str);
                    if (aVar != null) {
                        aVar.a = l2;
                        aVar.b = b3;
                        aVar.e = true;
                        aVar.d = UUID.randomUUID().toString();
                        a(1, aVar, 0, 0);
                    }
                }
            }
        }
    }

    private void c() {
        if (!this.e.isEmpty()) {
            synchronized (this.e) {
                long b2 = com.bonree.sdk.d.a.b();
                long l = com.bonree.sdk.d.a.l();
                Iterator<String> it = this.e.keySet().iterator();
                while (it.hasNext()) {
                    a(2, this.e.get(it.next()), b2, l);
                    if (this.e.size() > 10) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void d() {
        if (!this.e.isEmpty()) {
            synchronized (this.e) {
                long b2 = com.bonree.sdk.d.a.b();
                long l = com.bonree.sdk.d.a.l();
                for (String str : this.e.keySet()) {
                    m.a aVar = this.e.get(str);
                    if (aVar != null) {
                        aVar.a = l;
                        aVar.b = b2;
                        aVar.e = true;
                        aVar.d = UUID.randomUUID().toString();
                        a(1, aVar, 0, 0);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (!this.e.isEmpty()) {
            synchronized (this.e) {
                this.e.clear();
            }
        }
    }
}
