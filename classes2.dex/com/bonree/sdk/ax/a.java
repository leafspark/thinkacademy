package com.bonree.sdk.ax;

import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.ActionEventInfoBean;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.LaunchEventInfoBean;
import com.bonree.sdk.agent.business.entity.RouteChangeEventBean;
import com.bonree.sdk.agent.business.entity.TraceInfo;
import com.bonree.sdk.agent.business.entity.ViewEventInfoBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    private static final String c = ":";
    private static final String d = "activity";
    private static final String e = "fragment";
    private static final String f = "h5";
    private static final String g = "rn";
    private static final String h = "flutter";
    private static final String i = "ability";
    private static final String j = "abilitySlice";
    private static final String k = "unDefine";
    private static final String l = "enter";
    private static String o = "firstlaunch";
    private final List<Object> a = Collections.synchronizedList(new ArrayList());
    private final List<WeakReference<TraceInfo>> b = new ArrayList();
    private boolean m = false;
    private final AtomicInteger n = new AtomicInteger(0);
    private Comparator<Object> p = new b(this);

    public final void a(int i2) {
        this.m = true;
        this.n.set(i2);
    }

    public final int a() {
        return this.n.get();
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) {
        if (message.obj != null) {
            int i2 = message.what;
            if (i2 == 10) {
                a((EventBean) message.obj);
            } else if (i2 == 11) {
                d();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.bonree.sdk.agent.business.entity.EventBean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List<java.lang.Object> r0 = r4.a     // Catch:{ all -> 0x0080 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0080 }
            if (r0 != 0) goto L_0x0035
            java.util.List<java.lang.Object> r0 = r4.a     // Catch:{ all -> 0x0080 }
            int r0 = r0.size()     // Catch:{ all -> 0x0080 }
            java.util.concurrent.atomic.AtomicInteger r1 = r4.n     // Catch:{ all -> 0x0080 }
            int r1 = r1.get()     // Catch:{ all -> 0x0080 }
            if (r0 != r1) goto L_0x0035
            long r0 = r5.mEventTime     // Catch:{ all -> 0x0080 }
            long r0 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x0080 }
            java.util.List<java.lang.Object> r2 = r4.a     // Catch:{ all -> 0x0080 }
            java.util.concurrent.atomic.AtomicInteger r3 = r4.n     // Catch:{ all -> 0x0080 }
            int r3 = r3.get()     // Catch:{ all -> 0x0080 }
            int r3 = r3 + -1
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0080 }
            long r2 = a((java.lang.Object) r2)     // Catch:{ all -> 0x0080 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0035
            monitor-exit(r4)
            return
        L_0x0035:
            java.util.List<java.lang.Object> r0 = r4.a     // Catch:{ all -> 0x0080 }
            r0.add(r5)     // Catch:{ all -> 0x0080 }
            java.util.List<java.lang.Object> r5 = r4.a     // Catch:{ all -> 0x0080 }
            int r5 = r5.size()     // Catch:{ all -> 0x0080 }
            java.util.concurrent.atomic.AtomicInteger r0 = r4.n     // Catch:{ all -> 0x0080 }
            int r0 = r0.get()     // Catch:{ all -> 0x0080 }
            if (r5 >= r0) goto L_0x004a
            monitor-exit(r4)
            return
        L_0x004a:
            java.util.List<java.lang.Object> r5 = r4.a     // Catch:{ all -> 0x0080 }
            boolean r0 = r5.isEmpty()     // Catch:{ all -> 0x0080 }
            if (r0 != 0) goto L_0x0057
            java.util.Comparator<java.lang.Object> r0 = r4.p     // Catch:{ all -> 0x0080 }
            java.util.Collections.sort(r5, r0)     // Catch:{ all -> 0x0080 }
        L_0x0057:
            boolean r5 = r4.m     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x007e
            java.util.List<java.lang.Object> r5 = r4.a     // Catch:{ all -> 0x0080 }
            int r5 = r5.size()     // Catch:{ all -> 0x0080 }
            java.util.concurrent.atomic.AtomicInteger r0 = r4.n     // Catch:{ all -> 0x0080 }
            int r0 = r0.get()     // Catch:{ all -> 0x0080 }
            if (r5 <= r0) goto L_0x007e
            java.util.List<java.lang.Object> r5 = r4.a     // Catch:{ all -> 0x0080 }
            java.util.concurrent.atomic.AtomicInteger r0 = r4.n     // Catch:{ all -> 0x0080 }
            int r0 = r0.get()     // Catch:{ all -> 0x0080 }
            java.util.List<java.lang.Object> r1 = r4.a     // Catch:{ all -> 0x0080 }
            int r1 = r1.size()     // Catch:{ all -> 0x0080 }
            java.util.List r5 = r5.subList(r0, r1)     // Catch:{ all -> 0x0080 }
            r5.clear()     // Catch:{ all -> 0x0080 }
        L_0x007e:
            monitor-exit(r4)
            return
        L_0x0080:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ax.a.a(com.bonree.sdk.agent.business.entity.EventBean):void");
    }

    public final synchronized List<TraceInfo> b() {
        String str;
        if (!this.a.isEmpty()) {
            if (this.n.get() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.a.size(); i2++) {
                    if (i2 == this.n.get()) {
                        return arrayList;
                    }
                    Object obj = this.a.get(i2);
                    if (obj != null) {
                        if (obj instanceof TraceInfo) {
                            arrayList.add((TraceInfo) obj);
                        } else {
                            EventBean eventBean = (EventBean) obj;
                            if (!TextUtils.isEmpty(eventBean.mEventType) && eventBean.mEventInfo != null) {
                                TraceInfo traceInfo = new TraceInfo();
                                traceInfo.setTime(eventBean.mEventTime);
                                traceInfo.setType(eventBean.mEventType);
                                String str2 = eventBean.mEventType;
                                char c2 = 65535;
                                switch (str2.hashCode()) {
                                    case -1666503879:
                                        if (str2.equals(BaseEventInfo.EVENT_TYPE_ROUTE_CHANGE)) {
                                            c2 = 3;
                                            break;
                                        }
                                        break;
                                    case -1422950858:
                                        if (str2.equals("action")) {
                                            c2 = 0;
                                            break;
                                        }
                                        break;
                                    case -1109843021:
                                        if (str2.equals(BaseEventInfo.EVENT_TYPE_LAUNCH)) {
                                            c2 = 2;
                                            break;
                                        }
                                        break;
                                    case 3619493:
                                        if (str2.equals(BaseEventInfo.EVENT_TYPE_VIEW)) {
                                            c2 = 1;
                                            break;
                                        }
                                        break;
                                }
                                if (c2 == 0) {
                                    ActionEventInfoBean actionEventInfoBean = (ActionEventInfoBean) eventBean.mEventInfo;
                                    if (!TextUtils.isEmpty(actionEventInfoBean.mName) && !TextUtils.isEmpty(actionEventInfoBean.mInfo)) {
                                        traceInfo.setInfo(actionEventInfoBean.mName + c + actionEventInfoBean.mInfo);
                                    }
                                } else if (c2 == 1) {
                                    ViewEventInfoBean viewEventInfoBean = (ViewEventInfoBean) eventBean.mEventInfo;
                                    if (viewEventInfoBean.mModel != 2 && !TextUtils.isEmpty(viewEventInfoBean.mName)) {
                                        switch (viewEventInfoBean.mType) {
                                            case 1:
                                                str = "h5";
                                                break;
                                            case 2:
                                                str = d;
                                                break;
                                            case 3:
                                                str = e;
                                                break;
                                            case 6:
                                                str = g;
                                                break;
                                            case 7:
                                                str = h;
                                                break;
                                            case 8:
                                                str = i;
                                                break;
                                            case 9:
                                                str = j;
                                                break;
                                            default:
                                                str = k;
                                                break;
                                        }
                                        traceInfo.setInfo(str + ":enter" + c + viewEventInfoBean.mName);
                                    }
                                } else if (c2 == 2) {
                                    LaunchEventInfoBean launchEventInfoBean = (LaunchEventInfoBean) eventBean.mEventInfo;
                                    if (launchEventInfoBean.mType != null) {
                                        if (launchEventInfoBean.mType.equals(LaunchEventInfoBean.LAUNCH_TYPE_COLD)) {
                                            traceInfo.setInfo("coollaunch");
                                        } else if (launchEventInfoBean.mType.equals(LaunchEventInfoBean.LAUNCH_TYPE_HOT)) {
                                            traceInfo.setInfo("hotlaunch");
                                        } else if (launchEventInfoBean.mType.equals(LaunchEventInfoBean.LAUNCH_TYPE_FIRST)) {
                                            traceInfo.setInfo("firstlaunch");
                                        }
                                    }
                                } else if (c2 == 3) {
                                    RouteChangeEventBean routeChangeEventBean = (RouteChangeEventBean) eventBean.mEventInfo;
                                    if (!TextUtils.isEmpty(routeChangeEventBean.toUrl)) {
                                        traceInfo.setInfo(routeChangeEventBean.toUrl);
                                    }
                                }
                                arrayList.add(traceInfo);
                                this.a.set(i2, traceInfo);
                                if (traceInfo.getTime() < 0) {
                                    this.b.add(new WeakReference(traceInfo));
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    private void a(List<Object> list) {
        if (!list.isEmpty()) {
            Collections.sort(list, this.p);
        }
    }

    /* access modifiers changed from: private */
    public static long a(Object obj) {
        long j2;
        if (obj instanceof EventBean) {
            j2 = ((EventBean) obj).mEventTime;
        } else {
            j2 = ((TraceInfo) obj).getTime();
        }
        if (j2 > 0) {
            return j2;
        }
        return com.bonree.sdk.d.a.c(j2);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void c() {
        if (!this.b.isEmpty()) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                WeakReference weakReference = this.b.get(i2);
                if (!(weakReference == null || weakReference.get() == null)) {
                    TraceInfo traceInfo = (TraceInfo) weakReference.get();
                    if (traceInfo.getTime() < 0) {
                        traceInfo.setTime(com.bonree.sdk.d.a.c(traceInfo.getTime()));
                    }
                }
            }
            this.b.clear();
        }
    }

    public final synchronized void d() {
        if (!this.a.isEmpty()) {
            this.a.clear();
        }
        this.b.clear();
    }
}
