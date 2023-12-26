package com.bonree.sdk.ac;

import android.view.View;
import com.bonree.sdk.ac.c;
import com.bonree.sdk.agent.business.entity.ActionEventInfoBean;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.k;
import com.bonree.sdk.k.c;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class d {
    private static final long e = 4294967295L;
    private final b a;
    private final Map<String, c> b;
    private int c;
    private volatile String d;

    public d(b bVar) {
        this.a = bVar;
        this.b = new k();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0098, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bonree.sdk.k.c r7) {
        /*
            r6 = this;
            int r0 = r7.e()
            r1 = 1
            if (r0 != 0) goto L_0x004d
            java.lang.String r0 = r7.o()
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            java.lang.String r2 = r6.d
            if (r2 != 0) goto L_0x0017
            r6.d = r0
            r6.c = r1
            goto L_0x0038
        L_0x0017:
            java.lang.String r2 = r6.d
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0025
            int r2 = r6.c
            int r2 = r2 + r1
            r6.c = r2
            goto L_0x0038
        L_0x0025:
            com.bonree.sdk.be.f r2 = com.bonree.sdk.be.a.a()
            java.lang.String r3 = "miKey=%s,mCurrentDataKey=%s"
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r0
            java.lang.String r5 = r6.d
            r4[r1] = r5
            r2.a((java.lang.String) r3, (java.lang.Object[]) r4)
        L_0x0038:
            java.util.Map<java.lang.String, com.bonree.sdk.k.c> r2 = r6.b
            monitor-enter(r2)
            java.util.Map<java.lang.String, com.bonree.sdk.k.c> r1 = r6.b     // Catch:{ all -> 0x004a }
            boolean r1 = r1.containsKey(r0)     // Catch:{ all -> 0x004a }
            if (r1 != 0) goto L_0x0048
            java.util.Map<java.lang.String, com.bonree.sdk.k.c> r1 = r6.b     // Catch:{ all -> 0x004a }
            r1.put(r0, r7)     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            goto L_0x009c
        L_0x004a:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            throw r7
        L_0x004d:
            int r0 = r7.e()
            if (r0 != r1) goto L_0x009c
            java.util.Map<java.lang.String, com.bonree.sdk.k.c> r0 = r6.b
            monitor-enter(r0)
            java.lang.String r2 = r7.o()     // Catch:{ all -> 0x0099 }
            if (r2 != 0) goto L_0x005e
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return
        L_0x005e:
            java.util.Map<java.lang.String, com.bonree.sdk.k.c> r3 = r6.b     // Catch:{ all -> 0x0099 }
            java.lang.Object r3 = r3.get(r2)     // Catch:{ all -> 0x0099 }
            com.bonree.sdk.k.c r3 = (com.bonree.sdk.k.c) r3     // Catch:{ all -> 0x0099 }
            if (r3 != 0) goto L_0x006a
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return
        L_0x006a:
            java.lang.String r4 = r6.d     // Catch:{ all -> 0x0099 }
            boolean r4 = r2.equals(r4)     // Catch:{ all -> 0x0099 }
            r5 = 0
            if (r4 == 0) goto L_0x0089
            int r4 = r6.c     // Catch:{ all -> 0x0099 }
            int r4 = r4 - r1
            r6.c = r4     // Catch:{ all -> 0x0099 }
            if (r4 != 0) goto L_0x0097
            r6.d = r5     // Catch:{ all -> 0x0099 }
            java.util.Map<java.lang.String, com.bonree.sdk.k.c> r1 = r6.b     // Catch:{ all -> 0x0099 }
            r1.remove(r2)     // Catch:{ all -> 0x0099 }
            long r1 = r7.f()     // Catch:{ all -> 0x0099 }
            r6.a((com.bonree.sdk.k.c) r3, (long) r1)     // Catch:{ all -> 0x0099 }
            goto L_0x0097
        L_0x0089:
            r6.d = r5     // Catch:{ all -> 0x0099 }
            java.util.Map<java.lang.String, com.bonree.sdk.k.c> r1 = r6.b     // Catch:{ all -> 0x0099 }
            r1.remove(r2)     // Catch:{ all -> 0x0099 }
            long r1 = r7.f()     // Catch:{ all -> 0x0099 }
            r6.a((com.bonree.sdk.k.c) r3, (long) r1)     // Catch:{ all -> 0x0099 }
        L_0x0097:
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            return
        L_0x0099:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0099 }
            throw r7
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ac.d.a(com.bonree.sdk.k.c):void");
    }

    private void a(c cVar, long j) {
        String str;
        if (cVar != null) {
            EventBean eventBean = new EventBean();
            eventBean.mEventType = "action";
            eventBean.mEventTime = this.a.a(cVar.j());
            eventBean.mStateIndex = eventBean.getStateIndex();
            ActionEventInfoBean actionEventInfoBean = new ActionEventInfoBean();
            if (c.a.a.a() && !cVar.c().startsWith("onItemSelected")) {
                if (!ad.b(cVar.r())) {
                    actionEventInfoBean.mActionId = cVar.r();
                } else {
                    cVar.h(UUID.randomUUID().toString());
                    actionEventInfoBean.mActionId = cVar.r();
                }
                actionEventInfoBean.mMode = 1;
                actionEventInfoBean.mIsCustomEnd = Boolean.FALSE;
            }
            if (cVar.p()) {
                actionEventInfoBean.mType = 2;
            } else {
                actionEventInfoBean.mType = 1;
            }
            actionEventInfoBean.mSourceAction = 0;
            if (cVar.u() == null) {
                Class<View> cls = View.class;
                str = "View";
            } else {
                str = cVar.u();
            }
            actionEventInfoBean.mName = str;
            actionEventInfoBean.mViewName = cVar.a();
            actionEventInfoBean.mInfo = cVar.c() + ad.a(cVar.t(), cVar.s());
            actionEventInfoBean.isCustom = false;
            actionEventInfoBean.isSlow = Boolean.FALSE;
            actionEventInfoBean.mLoadTime = ad.a(j - cVar.f());
            eventBean.mEventInfo = actionEventInfoBean;
            eventBean.uploadStateKey();
            this.a.b(eventBean);
        }
    }

    public final void a(long j) {
        synchronized (this.b) {
            if (!this.b.isEmpty()) {
                Iterator<Map.Entry<String, com.bonree.sdk.k.c>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    it.remove();
                    a((com.bonree.sdk.k.c) it.next().getValue(), j);
                }
                this.d = null;
            }
        }
    }

    public final void a() {
        synchronized (this.b) {
            this.b.clear();
        }
    }

    private d() {
    }

    public static int a(long j, long j2) {
        if (j < 0 || j > e) {
            throw new IllegalArgumentException(j + " out of range");
        } else if (j2 < 0 || j2 > e) {
            throw new IllegalArgumentException(j2 + " out of range");
        } else {
            long j3 = j - j2;
            if (j3 >= e) {
                j3 -= 4294967296L;
            } else if (j3 < -4294967295L) {
                j3 += 4294967296L;
            }
            return (int) j3;
        }
    }

    private static long b(long j) {
        int i;
        if (j < 0 || j > e) {
            throw new IllegalArgumentException(j + " out of range");
        } else if (i == 0) {
            return 0;
        } else {
            return j + 1;
        }
    }
}
