package com.bonree.sdk.ae;

import android.os.Message;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.ad.d;
import com.bonree.sdk.ad.f;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean;
import com.bonree.sdk.agent.engine.state.i;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.d.e;
import com.bonree.sdk.h.b;
import com.bonree.sdk.h.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a extends f implements i, com.bonree.sdk.h.f {
    private static final int i = 200;
    private final String g;
    private final String h;
    private final int j;
    private final int k;
    private final Map<Integer, BatteryEventInfoBean> l;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this((e) null);
    }

    private a(e eVar) {
        super((e) null);
        this.g = "Battery-";
        this.h = "BR-Battery-Thread";
        this.j = 1;
        this.k = 2;
        this.f = Collections.synchronizedList(new ArrayList());
        this.l = Collections.synchronizedMap(new HashMap());
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        super.a(message);
        try {
            int i2 = message.what;
            if (i2 == 1) {
                b((c) message.obj);
            } else if (i2 == 2) {
                a((com.bonree.sdk.agent.engine.state.e) message.obj, false);
            }
        } catch (Throwable th) {
            this.c.a("Battery-", th);
        }
    }

    public final List<EventBean> b(com.bonree.sdk.agent.engine.state.e eVar) {
        if (eVar == null) {
            return null;
        }
        a(eVar, true);
        d();
        ArrayList arrayList = new ArrayList(this.f);
        this.f.clear();
        return arrayList;
    }

    private void a(com.bonree.sdk.agent.engine.state.e eVar, boolean z) {
        if (eVar != null) {
            boolean z2 = false;
            if (!(e.d().y() == null || e.d().y().g() == null)) {
                z2 = e.d().y().g().e();
            }
            if (z || eVar != com.bonree.sdk.agent.engine.state.e.BACKGROUND || !z2) {
                long b = com.bonree.sdk.d.a.b();
                long l2 = com.bonree.sdk.d.a.l();
                synchronized (this.l) {
                    for (Map.Entry<Integer, BatteryEventInfoBean> value : this.l.entrySet()) {
                        BatteryEventInfoBean batteryEventInfoBean = (BatteryEventInfoBean) value.getValue();
                        BatteryEventInfoBean batteryEventInfoBean2 = new BatteryEventInfoBean();
                        batteryEventInfoBean2.identifier = batteryEventInfoBean.identifier;
                        batteryEventInfoBean2.activityType = batteryEventInfoBean.activityType;
                        batteryEventInfoBean2.triggerType = 3;
                        batteryEventInfoBean2.periodLoadTimeUS = ad.a(b - batteryEventInfoBean.batteryTimeMS);
                        batteryEventInfoBean.batteryTimeMS = b;
                        int i2 = 1;
                        if (!z && eVar == com.bonree.sdk.agent.engine.state.e.BACKGROUND) {
                            batteryEventInfoBean2.appState = 1;
                        } else if ((z || eVar != com.bonree.sdk.agent.engine.state.e.FOREGROUND) && z) {
                            if (eVar != com.bonree.sdk.agent.engine.state.e.FOREGROUND) {
                                i2 = 2;
                            }
                            batteryEventInfoBean2.appState = i2;
                        } else {
                            batteryEventInfoBean2.appState = 2;
                        }
                        a(batteryEventInfoBean2, l2, BaseEventInfo.EVENT_TYPE_BATTERY, i);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        r1.periodLoadTimeUS = 0;
        r1.identifier = java.util.UUID.randomUUID().toString();
        r1.batteryTimeMS = r8.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.bonree.sdk.h.c r8) {
        /*
            r7 = this;
            com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean r1 = new com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean
            r1.<init>()
            com.bonree.sdk.h.d r0 = r8.c()
            int r0 = r0.a()
            r1.activityType = r0
            int r0 = r8.d()
            r1.triggerType = r0
            com.bonree.sdk.d.a r0 = com.bonree.sdk.d.a.k()
            boolean r0 = r0.J()
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L_0x0023
            r0 = r2
            goto L_0x0024
        L_0x0023:
            r0 = r3
        L_0x0024:
            r1.appState = r0
            int r0 = r8.d()
            r4 = 4
            r5 = 0
            if (r0 != r4) goto L_0x0033
            r1.periodLoadTimeUS = r5
            goto L_0x00b7
        L_0x0033:
            int r0 = r8.d()
            if (r0 != r3) goto L_0x0089
            java.util.Map<java.lang.Integer, com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean> r0 = r7.l
            monitor-enter(r0)
            java.util.Map<java.lang.Integer, com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean> r2 = r7.l     // Catch:{ all -> 0x0086 }
            int r3 = r8.b()     // Catch:{ all -> 0x0086 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0086 }
            boolean r2 = r2.containsKey(r3)     // Catch:{ all -> 0x0086 }
            if (r2 == 0) goto L_0x004e
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            return
        L_0x004e:
            java.util.Map<java.lang.Integer, com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean> r2 = r7.l     // Catch:{ all -> 0x0086 }
            int r2 = r2.size()     // Catch:{ all -> 0x0086 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 < r3) goto L_0x0065
            java.util.Map<java.lang.Integer, com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean> r2 = r7.l     // Catch:{ all -> 0x0086 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0086 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0086 }
            r2.remove()     // Catch:{ all -> 0x0086 }
        L_0x0065:
            java.util.Map<java.lang.Integer, com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean> r2 = r7.l     // Catch:{ all -> 0x0086 }
            int r3 = r8.b()     // Catch:{ all -> 0x0086 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0086 }
            r2.put(r3, r1)     // Catch:{ all -> 0x0086 }
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            r1.periodLoadTimeUS = r5
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            r1.identifier = r0
            long r2 = r8.a()
            r1.batteryTimeMS = r2
            goto L_0x00b7
        L_0x0086:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0086 }
            throw r8
        L_0x0089:
            int r0 = r8.d()
            if (r0 != r2) goto L_0x00c7
            java.util.Map<java.lang.Integer, com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean> r0 = r7.l
            monitor-enter(r0)
            java.util.Map<java.lang.Integer, com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean> r2 = r7.l     // Catch:{ all -> 0x00c4 }
            int r3 = r8.b()     // Catch:{ all -> 0x00c4 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00c4 }
            java.lang.Object r2 = r2.remove(r3)     // Catch:{ all -> 0x00c4 }
            com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean r2 = (com.bonree.sdk.agent.business.entity.battery.BatteryEventInfoBean) r2     // Catch:{ all -> 0x00c4 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c4 }
            if (r2 != 0) goto L_0x00a6
            return
        L_0x00a6:
            java.lang.String r0 = r2.identifier
            r1.identifier = r0
            long r3 = r8.a()
            long r5 = r2.batteryTimeMS
            long r3 = r3 - r5
            long r2 = com.bonree.sdk.bs.ad.a((long) r3)
            r1.periodLoadTimeUS = r2
        L_0x00b7:
            long r2 = r8.e()
            java.lang.String r4 = "battery"
            r5 = 200(0xc8, float:2.8E-43)
            r0 = r7
            r0.a(r1, r2, r4, r5)
            return
        L_0x00c4:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c4 }
            throw r8
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.ae.a.b(com.bonree.sdk.h.c):void");
    }

    private void a(BaseEventInfo baseEventInfo, long j2, String str, int i2) {
        EventBean eventBean = new EventBean();
        eventBean.mEventType = str;
        eventBean.mEventTime = j2;
        eventBean.mStateIndex = eventBean.getStateIndex();
        eventBean.mEventInfo = baseEventInfo;
        synchronized (this.f) {
            if (this.f.size() >= i) {
                this.f.remove(0);
            }
            com.bonree.sdk.be.f fVar = this.c;
            fVar.c("eventBean :" + eventBean.toString(), new Object[0]);
            eventBean.uploadStateKey();
            if (j2 < 0) {
                a(eventBean);
            } else {
                this.f.add(eventBean);
            }
        }
    }

    public final void a(c cVar) {
        if (cVar != null) {
            a(1, (Object) cVar);
        }
    }

    public final void a(com.bonree.sdk.agent.engine.state.e eVar) {
        if (eVar != null) {
            a(2, (Object) eVar);
        }
    }

    public final boolean b() {
        if (!this.a) {
            a("Battery-", a.d.a);
            this.a = true;
            a("BR-Battery-Thread");
            b.a().registerService((com.bonree.sdk.h.f) this);
            com.bonree.sdk.agent.engine.state.f.getEngine().registerService((i) this);
            a("Battery-", a.d.c);
        } else {
            a("Battery-", a.d.b);
        }
        return true;
    }

    public final boolean c() {
        if (this.a) {
            a("Battery-", a.d.d);
            this.a = false;
            d.a().b("BR-Battery-Thread");
            b.a().unRegisterService(this);
            com.bonree.sdk.agent.engine.state.f.getEngine().unRegisterService((i) this);
            f();
            this.f.clear();
            this.l.clear();
        } else {
            this.c.d("BatteryService no need stoped!", new Object[0]);
        }
        a("Battery-", a.d.e);
        return true;
    }

    public static a e() {
        return C0003a.a;
    }

    /* renamed from: com.bonree.sdk.ae.a$a  reason: collision with other inner class name */
    static class C0003a {
        /* access modifiers changed from: private */
        public static final a a = new a((byte) 0);

        private C0003a() {
        }
    }
}
