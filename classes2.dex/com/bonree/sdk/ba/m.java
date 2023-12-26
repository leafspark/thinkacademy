package com.bonree.sdk.ba;

import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.ViewEventInfoBean;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.bs.ad;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

final class m extends e {
    private static final long b = 100;
    private static final long c = 10;
    private final o d;
    private final Map<String, a> e = Collections.synchronizedMap(new LinkedHashMap());

    m(o oVar) {
        super(oVar);
        this.d = oVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bonree.sdk.ba.m.a r11) {
        /*
            r10 = this;
            int r0 = r11.h
            r1 = 1
            if (r0 != r1) goto L_0x003d
            if (r11 == 0) goto L_0x003c
            java.lang.String r0 = r11.c
            if (r0 != 0) goto L_0x000c
            goto L_0x003c
        L_0x000c:
            java.lang.String r0 = r11.c
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r1 = r10.e
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0039 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0039 }
            if (r2 != 0) goto L_0x0037
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0039 }
            int r2 = r2.size()     // Catch:{ all -> 0x0039 }
            long r2 = (long) r2     // Catch:{ all -> 0x0039 }
            r4 = 100
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0028
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            goto L_0x003c
        L_0x0028:
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0039 }
            r2.put(r0, r11)     // Catch:{ all -> 0x0039 }
            r4 = 1
            r6 = 0
            r8 = 0
            r3 = r10
            r5 = r11
            r3.a(r4, r5, r6, r8)     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            goto L_0x003c
        L_0x0039:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            throw r11
        L_0x003c:
            return
        L_0x003d:
            if (r11 == 0) goto L_0x008c
            java.lang.String r0 = r11.c
            if (r0 != 0) goto L_0x0044
            goto L_0x008c
        L_0x0044:
            java.lang.String r0 = r11.c
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r1 = r10.e
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0089 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x0087
            r4 = 2
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0089 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0089 }
            r5 = r2
            com.bonree.sdk.ba.m$a r5 = (com.bonree.sdk.ba.m.a) r5     // Catch:{ all -> 0x0089 }
            long r6 = r11.b     // Catch:{ all -> 0x0089 }
            long r8 = r11.a     // Catch:{ all -> 0x0089 }
            r3 = r10
            r3.a(r4, r5, r6, r8)     // Catch:{ all -> 0x0089 }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0089 }
            r2.remove(r0)     // Catch:{ all -> 0x0089 }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0089 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x0087
            r4 = 2
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0089 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0089 }
            r5 = r2
            com.bonree.sdk.ba.m$a r5 = (com.bonree.sdk.ba.m.a) r5     // Catch:{ all -> 0x0089 }
            long r6 = r11.b     // Catch:{ all -> 0x0089 }
            long r8 = r11.a     // Catch:{ all -> 0x0089 }
            r3 = r10
            r3.a(r4, r5, r6, r8)     // Catch:{ all -> 0x0089 }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r11 = r10.e     // Catch:{ all -> 0x0089 }
            r11.remove(r0)     // Catch:{ all -> 0x0089 }
        L_0x0087:
            monitor-exit(r1)     // Catch:{ all -> 0x0089 }
            return
        L_0x0089:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0089 }
            throw r11
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.m.a(com.bonree.sdk.ba.m$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.bonree.sdk.ba.m.a r11) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0037
            java.lang.String r0 = r11.c
            if (r0 != 0) goto L_0x0007
            goto L_0x0037
        L_0x0007:
            java.lang.String r0 = r11.c
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r1 = r10.e
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0034 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x0032
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0034 }
            int r2 = r2.size()     // Catch:{ all -> 0x0034 }
            long r2 = (long) r2     // Catch:{ all -> 0x0034 }
            r4 = 100
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0023
            monitor-exit(r1)     // Catch:{ all -> 0x0034 }
            return
        L_0x0023:
            java.util.Map<java.lang.String, com.bonree.sdk.ba.m$a> r2 = r10.e     // Catch:{ all -> 0x0034 }
            r2.put(r0, r11)     // Catch:{ all -> 0x0034 }
            r4 = 1
            r6 = 0
            r8 = 0
            r3 = r10
            r5 = r11
            r3.a(r4, r5, r6, r8)     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r1)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0034 }
            throw r11
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.m.c(com.bonree.sdk.ba.m$a):void");
    }

    private void d(a aVar) {
        if (aVar != null && aVar.c != null) {
            String str = aVar.c;
            synchronized (this.e) {
                if (this.e.containsKey(str)) {
                    a(2, this.e.get(str), aVar.b, aVar.a);
                    this.e.remove(str);
                    if (this.e.containsKey(str)) {
                        a(2, this.e.get(str), aVar.b, aVar.a);
                        this.e.remove(str);
                    }
                }
            }
        }
    }

    private void a(int i, a aVar, long j, long j2) {
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
                    viewEventInfoBean.mType = 6;
                    if (aVar.g > 0) {
                        viewEventInfoBean.mLoadTimeUs = ad.a((long) aVar.g);
                    } else {
                        viewEventInfoBean.mLoadTimeUs = 999;
                    }
                    eventBean.mEventInfo = viewEventInfoBean;
                    if (i == 1) {
                        eventBean.mEventTime = this.d.a(aVar.a);
                    } else if (!(i != 2 || j2 == 0 || j == 0)) {
                        eventBean.mEventTime = this.d.a(j2);
                        viewEventInfoBean.mStayTimeUs = Long.valueOf(ad.a(j - aVar.b));
                    }
                    com.bonree.sdk.be.a.a().c("ViewService RNViewEvent model is %s, EnterView is %s, exitTimeStampUs is %s, exitRealTimeMs is %s", Integer.valueOf(i), aVar, Long.valueOf(j), Long.valueOf(j2));
                    eventBean.uploadStateKey();
                    this.d.b(eventBean);
                }
            } catch (Exception unused) {
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

    public final void a(e eVar) {
        if (eVar == e.BACKGROUND) {
            if (!this.e.isEmpty()) {
                synchronized (this.e) {
                    long b2 = com.bonree.sdk.d.a.b();
                    long l = com.bonree.sdk.d.a.l();
                    Iterator<String> it = this.e.keySet().iterator();
                    while (it.hasNext()) {
                        a(2, this.e.get(it.next()), b2, l);
                        if (((long) this.e.size()) > c) {
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
                    a aVar = this.e.get(str);
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
                    if (((long) this.e.size()) > c) {
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
                    a aVar = this.e.get(str);
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

    static class a {
        long a;
        long b;
        String c;
        String d;
        boolean e;
        int f;
        int g;
        int h;
        String i;
        private String j;

        public a(long j2, String str, int i2, int i3, String str2, String str3, int i4) {
            this.f = i4;
            if (com.bonree.sdk.d.a.l() > 0) {
                this.a = com.bonree.sdk.d.a.c(ad.a(j2));
            } else {
                this.a = -ad.a(j2);
            }
            this.b = com.bonree.sdk.d.a.b() - (System.currentTimeMillis() - j2);
            this.c = str;
            this.g = i2;
            this.h = i3;
            this.i = str2;
            this.j = str3;
        }

        public final String toString() {
            return "RNViewEventData{timeStampUs=" + this.a + ", realTimeMs=" + this.b + ", platform=" + this.f + ", viewId='" + this.c + '\'' + ", reOpenId='" + this.d + '\'' + ", isReOpen='" + this.e + '\'' + ", loadTimeMs=" + this.g + ", model=" + this.h + ", viewName='" + this.i + '\'' + ", methodName='" + this.j + '\'' + '}';
        }
    }
}
