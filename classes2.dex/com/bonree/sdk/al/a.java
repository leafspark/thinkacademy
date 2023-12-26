package com.bonree.sdk.al;

import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.CustomEventInfoBean;
import com.bonree.sdk.agent.business.entity.CustomLog;
import com.bonree.sdk.agent.business.entity.CustomMetricEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.be.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    private static f a = com.bonree.sdk.be.a.a();
    private static final int c = 100;
    private static final int d = 200;
    private static final int e = 256;
    private static final int f = 10000;
    private static final int g = 50;
    private static final int o = 0;
    private static final int p = 1;
    private static final int q = 2;
    private final AtomicBoolean b = new AtomicBoolean(true);
    private final List<EventBean> h = Collections.synchronizedList(new ArrayList());
    private final List<EventBean> i = Collections.synchronizedList(new ArrayList());
    private final List<EventBean> j = Collections.synchronizedList(new ArrayList());
    private final AtomicInteger k = new AtomicInteger(0);
    private final AtomicInteger l = new AtomicInteger(0);
    private final AtomicInteger m = new AtomicInteger(0);
    private final Map<String, CustomEventInfoBean> n = Collections.synchronizedMap(new LinkedHashMap());

    private static CustomEventInfoBean d(String str, String str2, String str3, String str4) {
        CustomEventInfoBean customEventInfoBean = new CustomEventInfoBean();
        customEventInfoBean.mId = str;
        if (!TextUtils.isEmpty(str2)) {
            if (str2.length() > 256) {
                str2 = str2.substring(0, 256);
            }
            customEventInfoBean.mName = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            if (str3.length() > f) {
                str3 = str3.substring(0, f);
            }
            customEventInfoBean.mParam = str3;
        }
        if (!TextUtils.isEmpty(str4)) {
            if (str4.length() > 256) {
                str4 = str4.substring(0, 256);
            }
            customEventInfoBean.mLabel = str4;
        }
        return customEventInfoBean;
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            CustomLog customLog = new CustomLog();
            if (str.length() > f) {
                str = str.substring(0, f);
            }
            customLog.mInfo = str;
            if (!TextUtils.isEmpty(str2)) {
                if (str2.length() > f) {
                    str2 = str2.substring(0, f);
                }
                customLog.mParam = str2;
            }
            EventBean eventBean = new EventBean();
            eventBean.mEventType = BaseEventInfo.EVENT_TYPE_CUSTOMLOG;
            eventBean.mEventTime = com.bonree.sdk.d.a.l();
            if (eventBean.mEventTime < 0) {
                this.l.getAndIncrement();
            } else if (this.l.get() > 0) {
                g();
            }
            eventBean.mStateIndex = eventBean.getStateIndex();
            eventBean.mEventInfo = customLog;
            synchronized (this.i) {
                if (this.i.size() >= 50) {
                    this.i.remove(0);
                }
                f fVar = a;
                fVar.c("eventBean :" + eventBean.toString(), new Object[0]);
                eventBean.uploadStateKey();
                this.i.add(eventBean);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, long j2, String str2) {
        if (!TextUtils.isEmpty(str) && str.length() <= 256) {
            CustomMetricEventInfo customMetricEventInfo = new CustomMetricEventInfo();
            customMetricEventInfo.mName = str;
            customMetricEventInfo.mValue = j2;
            if (!TextUtils.isEmpty(str2)) {
                if (str2.length() > f) {
                    str2 = str2.substring(0, f);
                }
                customMetricEventInfo.param = str2;
            }
            EventBean eventBean = new EventBean();
            eventBean.mEventType = BaseEventInfo.EVENT_TYPE_CUSTOMMETRIC;
            eventBean.mEventTime = com.bonree.sdk.d.a.l();
            if (eventBean.mEventTime < 0) {
                this.m.getAndIncrement();
            } else if (this.m.get() > 0) {
                h();
            }
            eventBean.mStateIndex = eventBean.getStateIndex();
            eventBean.mEventInfo = customMetricEventInfo;
            synchronized (this.j) {
                if (this.j.size() >= 50) {
                    this.j.remove(0);
                }
                f fVar = a;
                fVar.c("eventBean :" + eventBean.toString(), new Object[0]);
                eventBean.uploadStateKey();
                this.j.add(eventBean);
            }
        }
    }

    private void a(BaseEventInfo baseEventInfo, String str, int i2) {
        EventBean eventBean = new EventBean();
        eventBean.mEventType = str;
        eventBean.mEventTime = com.bonree.sdk.d.a.l();
        if (eventBean.mEventTime < 0) {
            this.k.getAndIncrement();
        } else if (this.k.get() > 0) {
            f();
        }
        eventBean.mStateIndex = eventBean.getStateIndex();
        eventBean.mEventInfo = baseEventInfo;
        synchronized (this.h) {
            if (this.h.size() >= d) {
                this.h.remove(0);
            }
            f fVar = a;
            fVar.c("eventBean :" + eventBean.toString(), new Object[0]);
            eventBean.uploadStateKey();
            this.h.add(eventBean);
        }
    }

    private void b(BaseEventInfo baseEventInfo, String str, int i2) {
        EventBean eventBean = new EventBean();
        eventBean.mEventType = str;
        eventBean.mEventTime = com.bonree.sdk.d.a.l();
        if (eventBean.mEventTime < 0) {
            this.l.getAndIncrement();
        } else if (this.l.get() > 0) {
            g();
        }
        eventBean.mStateIndex = eventBean.getStateIndex();
        eventBean.mEventInfo = baseEventInfo;
        synchronized (this.i) {
            if (this.i.size() >= 50) {
                this.i.remove(0);
            }
            f fVar = a;
            fVar.c("eventBean :" + eventBean.toString(), new Object[0]);
            eventBean.uploadStateKey();
            this.i.add(eventBean);
        }
    }

    private void c(BaseEventInfo baseEventInfo, String str, int i2) {
        EventBean eventBean = new EventBean();
        eventBean.mEventType = str;
        eventBean.mEventTime = com.bonree.sdk.d.a.l();
        if (eventBean.mEventTime < 0) {
            this.m.getAndIncrement();
        } else if (this.m.get() > 0) {
            h();
        }
        eventBean.mStateIndex = eventBean.getStateIndex();
        eventBean.mEventInfo = baseEventInfo;
        synchronized (this.j) {
            if (this.j.size() >= 50) {
                this.j.remove(0);
            }
            f fVar = a;
            fVar.c("eventBean :" + eventBean.toString(), new Object[0]);
            eventBean.uploadStateKey();
            this.j.add(eventBean);
        }
    }

    /* access modifiers changed from: package-private */
    public final List<EventBean> a() {
        ArrayList arrayList;
        synchronized (this.h) {
            if (this.k.get() > 0) {
                f();
            }
            arrayList = new ArrayList(this.h);
            this.h.clear();
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<EventBean> b() {
        ArrayList arrayList;
        synchronized (this.i) {
            if (this.l.get() > 0) {
                g();
            }
            arrayList = new ArrayList(this.i);
            this.i.clear();
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<EventBean> c() {
        ArrayList arrayList;
        synchronized (this.j) {
            if (this.m.get() > 0) {
                h();
            }
            arrayList = new ArrayList(this.j);
            this.j.clear();
        }
        return arrayList;
    }

    private static long e() {
        return com.bonree.sdk.d.a.l();
    }

    private static long a(long j2) {
        return com.bonree.sdk.d.a.c(j2);
    }

    private void f() {
        synchronized (this.h) {
            for (EventBean next : this.h) {
                if (next.mEventTime < 0) {
                    next.mEventTime = com.bonree.sdk.d.a.c(next.mEventTime);
                    this.k.getAndDecrement();
                    if (this.k.get() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    private void g() {
        synchronized (this.i) {
            for (EventBean next : this.i) {
                if (next.mEventTime < 0) {
                    next.mEventTime = com.bonree.sdk.d.a.c(next.mEventTime);
                    this.l.getAndDecrement();
                    if (this.l.get() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    private void h() {
        synchronized (this.j) {
            for (EventBean next : this.j) {
                if (next.mEventTime < 0) {
                    next.mEventTime = com.bonree.sdk.d.a.c(next.mEventTime);
                    this.m.getAndDecrement();
                    if (this.m.get() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        List<EventBean> list = this.h;
        if (list != null && list.size() > 0) {
            this.h.clear();
        }
        List<EventBean> list2 = this.i;
        if (list2 != null && list2.size() > 0) {
            this.i.clear();
        }
        List<EventBean> list3 = this.j;
        if (list3 != null && list3.size() > 0) {
            this.j.clear();
        }
        Map<String, CustomEventInfoBean> map = this.n;
        if (map != null && map.size() > 0) {
            this.n.clear();
        }
    }

    private boolean i() {
        return this.b.get();
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z) {
        if (z) {
            com.bonree.sdk.be.a.a().c("UserCustom - CustomEvent is start.", new Object[0]);
        } else {
            com.bonree.sdk.be.a.a().c("UserCustom - CustomEvent is stop.", new Object[0]);
        }
        this.b.getAndSet(z);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2, String str3, String str4) {
        if (this.b.get() && str != null && str.length() > 0 && str.length() <= 256) {
            CustomEventInfoBean customEventInfoBean = new CustomEventInfoBean();
            customEventInfoBean.mId = str;
            if (!TextUtils.isEmpty(str2)) {
                if (str2.length() > 256) {
                    str2 = str2.substring(0, 256);
                }
                customEventInfoBean.mName = str2;
            }
            if (!TextUtils.isEmpty(str3)) {
                if (str3.length() > f) {
                    str3 = str3.substring(0, f);
                }
                customEventInfoBean.mParam = str3;
            }
            if (!TextUtils.isEmpty(str4)) {
                if (str4.length() > 256) {
                    str4 = str4.substring(0, 256);
                }
                customEventInfoBean.mLabel = str4;
            }
            customEventInfoBean.mType = 0;
            a((BaseEventInfo) customEventInfoBean, BaseEventInfo.EVENT_TYPE_CUSTOMEVENT, (int) d);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        r4 = d(r3, r4, r5, r6);
        r4.mType = 1;
        r4.startTime = com.bonree.sdk.d.a.l();
        r4.correlationId = java.util.UUID.randomUUID().toString();
        r5 = r2.n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r2.n.size() < 100) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r2.n.put(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        a((com.bonree.sdk.agent.business.entity.BaseEventInfo) r4, com.bonree.sdk.agent.business.entity.BaseEventInfo.EVENT_TYPE_CUSTOMEVENT, (int) d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r2 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r2.b
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x0062
            if (r3 == 0) goto L_0x0062
            int r0 = r3.length()
            if (r0 <= 0) goto L_0x0062
            int r0 = r3.length()
            r1 = 256(0x100, float:3.59E-43)
            if (r0 > r1) goto L_0x0062
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.CustomEventInfoBean> r0 = r2.n
            monitor-enter(r0)
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.CustomEventInfoBean> r1 = r2.n     // Catch:{ all -> 0x005f }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x005f }
            com.bonree.sdk.agent.business.entity.CustomEventInfoBean r1 = (com.bonree.sdk.agent.business.entity.CustomEventInfoBean) r1     // Catch:{ all -> 0x005f }
            if (r1 == 0) goto L_0x0027
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            return
        L_0x0027:
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            com.bonree.sdk.agent.business.entity.CustomEventInfoBean r4 = d(r3, r4, r5, r6)
            r5 = 1
            r4.mType = r5
            long r5 = com.bonree.sdk.d.a.l()
            r4.startTime = r5
            java.util.UUID r5 = java.util.UUID.randomUUID()
            java.lang.String r5 = r5.toString()
            r4.correlationId = r5
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.CustomEventInfoBean> r5 = r2.n
            monitor-enter(r5)
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.CustomEventInfoBean> r6 = r2.n     // Catch:{ all -> 0x005c }
            int r6 = r6.size()     // Catch:{ all -> 0x005c }
            r0 = 100
            if (r6 < r0) goto L_0x004e
            monitor-exit(r5)     // Catch:{ all -> 0x005c }
            return
        L_0x004e:
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.CustomEventInfoBean> r6 = r2.n     // Catch:{ all -> 0x005c }
            r6.put(r3, r4)     // Catch:{ all -> 0x005c }
            monitor-exit(r5)     // Catch:{ all -> 0x005c }
            java.lang.String r3 = "customevent"
            r5 = 200(0xc8, float:2.8E-43)
            r2.a((com.bonree.sdk.agent.business.entity.BaseEventInfo) r4, (java.lang.String) r3, (int) r5)
            goto L_0x0062
        L_0x005c:
            r3 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x005c }
            throw r3
        L_0x005f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005f }
            throw r3
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.al.a.b(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void c(String str, String str2, String str3, String str4) {
        CustomEventInfoBean customEventInfoBean;
        if (this.b.get() && str != null && str.length() > 0 && str.length() <= 256) {
            synchronized (this.n) {
                customEventInfoBean = this.n.get(str);
            }
            if (customEventInfoBean != null) {
                long j2 = customEventInfoBean.startTime;
                String str5 = customEventInfoBean.correlationId;
                CustomEventInfoBean d2 = d(str, str2, str3, str4);
                long l2 = com.bonree.sdk.d.a.l();
                if (l2 < 0) {
                    if (j2 < 0) {
                        d2.mDuration = Math.abs(l2 - j2);
                    } else {
                        d2.mDuration = com.bonree.sdk.d.a.c(l2) - j2;
                    }
                } else if (j2 < 0) {
                    d2.mDuration = l2 - com.bonree.sdk.d.a.c(j2);
                } else {
                    d2.mDuration = l2 - j2;
                }
                d2.mType = 2;
                d2.correlationId = str5;
                a((BaseEventInfo) d2, BaseEventInfo.EVENT_TYPE_CUSTOMEVENT, (int) d);
                synchronized (this.n) {
                    this.n.remove(str);
                }
            }
        }
    }
}
