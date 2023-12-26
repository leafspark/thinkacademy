package com.bonree.sdk.ba;

import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.ViewEventInfoBean;
import com.bonree.sdk.bp.y;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class h {
    private static final long a = 100;
    private final o b;
    private final Map<String, a> c;

    h(o oVar) {
        this.b = oVar;
        this.c = new k();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bonree.sdk.ba.h.a r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x0059
            java.lang.String r0 = r7.e
            if (r0 != 0) goto L_0x0007
            goto L_0x0059
        L_0x0007:
            boolean r0 = r7.a
            if (r0 == 0) goto L_0x0036
            java.lang.String r0 = r7.e
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r1 = r6.c
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r2 = r6.c     // Catch:{ all -> 0x0033 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0033 }
            if (r2 != 0) goto L_0x0031
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r2 = r6.c     // Catch:{ all -> 0x0033 }
            int r2 = r2.size()     // Catch:{ all -> 0x0033 }
            long r2 = (long) r2     // Catch:{ all -> 0x0033 }
            r4 = 100
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0027
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0032
        L_0x0027:
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r2 = r6.c     // Catch:{ all -> 0x0033 }
            r2.put(r0, r7)     // Catch:{ all -> 0x0033 }
            r0 = 1
            r2 = 0
            r6.a(r0, r7, r2)     // Catch:{ all -> 0x0033 }
        L_0x0031:
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
        L_0x0032:
            return
        L_0x0033:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            throw r7
        L_0x0036:
            java.lang.String r0 = r7.e
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r1 = r6.c
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r2 = r6.c     // Catch:{ all -> 0x0056 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0054
            r2 = 2
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r3 = r6.c     // Catch:{ all -> 0x0056 }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x0056 }
            com.bonree.sdk.ba.h$a r3 = (com.bonree.sdk.ba.h.a) r3     // Catch:{ all -> 0x0056 }
            r6.a(r2, r3, r7)     // Catch:{ all -> 0x0056 }
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r7 = r6.c     // Catch:{ all -> 0x0056 }
            r7.remove(r0)     // Catch:{ all -> 0x0056 }
        L_0x0054:
            monitor-exit(r1)     // Catch:{ all -> 0x0056 }
            return
        L_0x0056:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0056 }
            throw r7
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.h.a(com.bonree.sdk.ba.h$a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.bonree.sdk.ba.h.a r7) {
        /*
            r6 = this;
            java.lang.String r0 = r7.e
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r1 = r6.c
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r2 = r6.c     // Catch:{ all -> 0x0028 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0028 }
            if (r2 != 0) goto L_0x0026
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r2 = r6.c     // Catch:{ all -> 0x0028 }
            int r2 = r2.size()     // Catch:{ all -> 0x0028 }
            long r2 = (long) r2     // Catch:{ all -> 0x0028 }
            r4 = 100
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x001c
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            return
        L_0x001c:
            java.util.Map<java.lang.String, com.bonree.sdk.ba.h$a> r2 = r6.c     // Catch:{ all -> 0x0028 }
            r2.put(r0, r7)     // Catch:{ all -> 0x0028 }
            r0 = 1
            r2 = 0
            r6.a(r0, r7, r2)     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            return
        L_0x0028:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ba.h.b(com.bonree.sdk.ba.h$a):void");
    }

    private void c(a aVar) {
        String str = aVar.e;
        synchronized (this.c) {
            if (this.c.containsKey(str)) {
                a(2, this.c.get(str), aVar);
                this.c.remove(str);
            }
        }
    }

    private void a(int i, a aVar, a aVar2) {
        if (aVar != null && this.b != null) {
            EventBean eventBean = new EventBean();
            eventBean.mEventType = BaseEventInfo.EVENT_TYPE_VIEW;
            eventBean.mStateIndex = eventBean.getStateIndex();
            ViewEventInfoBean viewEventInfoBean = new ViewEventInfoBean();
            viewEventInfoBean.mCorrelationId = aVar.b;
            viewEventInfoBean.mName = aVar.e;
            viewEventInfoBean.mModel = i;
            viewEventInfoBean.isCustom = true;
            viewEventInfoBean.mType = com.bonree.sdk.d.a.L() ? 8 : 2;
            eventBean.mEventInfo = viewEventInfoBean;
            if (i == 1 && aVar != null) {
                eventBean.mEventTime = aVar.d;
                viewEventInfoBean.mParam = aVar.f;
            } else if (i == 2 && aVar2 != null) {
                viewEventInfoBean.mParam = aVar2.f;
                eventBean.mEventTime = aVar2.d;
                viewEventInfoBean.mStayTimeUs = Long.valueOf(ad.a(aVar2.c - aVar.c));
            }
            com.bonree.sdk.be.a.a().c("ViewService CustomEvent enter is %s, exit is %s", aVar, aVar2);
            eventBean.uploadStateKey();
            this.b.b(eventBean);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (!this.c.isEmpty()) {
            synchronized (this.c) {
                this.c.clear();
            }
        }
    }

    static class a {
        boolean a;
        String b;
        long c;
        long d;
        String e;
        String f;

        a() {
        }

        public final String toString() {
            return "CustomViewEventData{isPageStart=" + this.a + ", mCorrelationId='" + this.b + '\'' + ", mRealTimeMs=" + this.c + ", mTimeStampUs=" + this.d + ", mPageName='" + this.e + '\'' + ", mParam='" + this.f + '\'' + '}';
        }
    }

    public h() {
    }

    private static List<y> a(Collection<y> collection) {
        int i;
        int i2;
        int i3;
        if (collection.size() == 1 && collection.iterator().next().c.equals(com.bonree.sdk.bk.a.a)) {
            return Collections.emptyList();
        }
        TreeMap treeMap = new TreeMap();
        for (y next : collection) {
            Integer valueOf = Integer.valueOf(next.a);
            List list = (List) treeMap.get(valueOf);
            if (list == null) {
                list = new LinkedList();
                treeMap.put(valueOf, list);
            }
            list.add(next);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<y> list2 : treeMap.values()) {
            while (true) {
                int size = list2.size();
                if (size > 0) {
                    int[] iArr = new int[size];
                    Iterator it = list2.iterator();
                    while (true) {
                        i = 0;
                        if (it.hasNext()) {
                            if (((y) it.next()).b > 0) {
                                i2 = 0;
                                break;
                            }
                        } else {
                            i2 = 1;
                            break;
                        }
                    }
                    int i4 = 0;
                    for (y yVar : list2) {
                        i += yVar.b + i2;
                        iArr[i4] = i;
                        i4++;
                    }
                    if (i == 0) {
                        i3 = (int) (Math.random() * ((double) size));
                    } else {
                        i3 = a(iArr, Math.random() * ((double) i));
                    }
                    arrayList.add((y) list2.remove(i3));
                }
            }
        }
        return arrayList;
    }

    private static int a(int[] iArr, double d) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length && d >= ((double) iArr[i])) {
            i2++;
            i++;
        }
        return i2;
    }
}
