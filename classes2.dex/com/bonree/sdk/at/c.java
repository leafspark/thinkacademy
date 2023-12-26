package com.bonree.sdk.at;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.ad.d;
import com.bonree.sdk.ad.f;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.agent.Bonree;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean;
import com.bonree.sdk.agent.business.entity.StateChangeEventInfoBean;
import com.bonree.sdk.agent.business.util.k;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.agent.engine.state.i;
import com.bonree.sdk.agent.engine.state.j;
import com.bonree.sdk.agent.engine.state.k;
import com.bonree.sdk.agent.engine.state.m;
import com.bonree.sdk.am.g;
import com.bonree.sdk.bs.aa;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.common.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c extends f implements i, j {
    private static final String k = UUID.randomUUID().toString();
    private final String g;
    private a h;
    private final Map<String, a> i;
    private final Map<String, NetWorkStateInfoBean> j;
    private volatile String l;
    private final AtomicBoolean m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final int r;
    private final String s;
    private EventBean t;
    private String u;
    private volatile String v;
    private final List<a> w;
    private k x;

    public interface a {
        void c(String str);
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    public final synchronized String e() {
        if (this.h == null) {
            this.v = aa.d(com.bonree.sdk.bs.a.a(), "netInfo", "ip");
            String d = aa.d(com.bonree.sdk.bs.a.a(), "netInfo", "standard");
            String d2 = aa.d(com.bonree.sdk.bs.a.a(), "netInfo", "dns");
            String str = TextUtils.isEmpty(this.v) ? null : this.v;
            if (TextUtils.isEmpty(d)) {
                d = "NaN";
            }
            if (TextUtils.isEmpty(d2)) {
                d2 = null;
            }
            a(str, d, d2);
        }
        this.h.b();
        this.i.put(this.l, this.h);
        this.c.c("StateChange-" + Thread.currentThread().getName() + " getNetStateInfoKey=" + this.l, new Object[0]);
        return this.l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bonree.sdk.be.f r0 = r4.c     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "StateChange-"
            r1.<init>(r2)     // Catch:{ all -> 0x0076 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0076 }
            r1.append(r2)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = " StateChangeService uploadKey="
            r1.append(r2)     // Catch:{ all -> 0x0076 }
            r1.append(r5)     // Catch:{ all -> 0x0076 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0076 }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0076 }
            r0.c(r1, r3)     // Catch:{ all -> 0x0076 }
            if (r5 != 0) goto L_0x002b
            monitor-exit(r4)
            return
        L_0x002b:
            java.util.Map<java.lang.String, com.bonree.sdk.at.a> r0 = r4.i     // Catch:{ all -> 0x0076 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0076 }
            com.bonree.sdk.at.a r0 = (com.bonree.sdk.at.a) r0     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0037
            monitor-exit(r4)
            return
        L_0x0037:
            int r1 = r0.c()     // Catch:{ all -> 0x0076 }
            if (r6 == 0) goto L_0x0048
            com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean r6 = r0.a()     // Catch:{ all -> 0x0076 }
            if (r6 == 0) goto L_0x0048
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean> r0 = r4.j     // Catch:{ all -> 0x0076 }
            r0.put(r5, r6)     // Catch:{ all -> 0x0076 }
        L_0x0048:
            if (r1 != 0) goto L_0x0074
            com.bonree.sdk.be.f r6 = r4.c     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            java.lang.String r1 = "StateChange-uploadKey remove key="
            r0.<init>(r1)     // Catch:{ all -> 0x0076 }
            java.util.Map<java.lang.String, com.bonree.sdk.at.a> r1 = r4.i     // Catch:{ all -> 0x0076 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0076 }
            com.bonree.sdk.at.a r1 = (com.bonree.sdk.at.a) r1     // Catch:{ all -> 0x0076 }
            com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean r1 = r1.a()     // Catch:{ all -> 0x0076 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0076 }
            r0.append(r1)     // Catch:{ all -> 0x0076 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0076 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0076 }
            r6.c(r0, r1)     // Catch:{ all -> 0x0076 }
            java.util.Map<java.lang.String, com.bonree.sdk.at.a> r6 = r4.i     // Catch:{ all -> 0x0076 }
            r6.remove(r5)     // Catch:{ all -> 0x0076 }
        L_0x0074:
            monitor-exit(r4)
            return
        L_0x0076:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.at.c.a(java.lang.String, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.String, com.bonree.sdk.at.a> r0 = r2.i     // Catch:{ all -> 0x001a }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x001a }
            com.bonree.sdk.at.a r0 = (com.bonree.sdk.at.a) r0     // Catch:{ all -> 0x001a }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r2)
            return
        L_0x000d:
            com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean r0 = r0.a()     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0018
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.NetWorkStateInfoBean> r1 = r2.j     // Catch:{ all -> 0x001a }
            r1.put(r3, r0)     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r2)
            return
        L_0x001a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.at.c.b(java.lang.String):void");
    }

    public final synchronized void c(String str) {
        if (!ad.a(str)) {
            com.bonree.sdk.be.f fVar = this.c;
            fVar.c("StateChange-setConfigIp=" + str, new Object[0]);
            this.v = str;
            String Z = com.bonree.sdk.d.a.Z();
            if (k.equals(this.l)) {
                a aVar = this.h;
                if (aVar == null) {
                    this.h = new a(b(str, Z));
                } else {
                    aVar.a().ip = str;
                    this.h.a().networkStandard = Z;
                    this.h.a().dnsServerIp = g.k().j();
                }
            } else {
                for (String next : this.i.keySet()) {
                    a aVar2 = this.i.get(next);
                    if (aVar2 != null && aVar2 == this.h) {
                        NetWorkStateInfoBean b2 = b(str, Z);
                        this.h.a(b2);
                        this.j.put(next, b2);
                    }
                }
            }
            b(this.v, Z, this.h.a().dnsServerIp);
        }
    }

    public final Map<String, NetWorkStateInfoBean> g() {
        com.bonree.sdk.bs.k kVar;
        synchronized (this.j) {
            kVar = new com.bonree.sdk.bs.k(this.j);
            this.j.clear();
        }
        this.c.c("StateChange-getNetStateInfoBea: %s", kVar);
        return kVar;
    }

    public final synchronized List<EventBean> h() {
        ArrayList arrayList;
        d();
        arrayList = new ArrayList(this.f);
        this.f.clear();
        return arrayList;
    }

    public final synchronized int i() {
        if (this.h == null) {
            return -1;
        }
        NetworkInfo networkInfo = null;
        ConnectivityManager connectivityManager = (ConnectivityManager) com.bonree.sdk.bs.a.a().getSystemService("connectivity");
        if (ad.a(com.bonree.sdk.bs.a.a(), "android.permission.ACCESS_NETWORK_STATE")) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo == null) {
            return -1;
        }
        if (networkInfo.getType() == 1) {
            return 0;
        }
        return networkInfo.getSubtype();
    }

    public final synchronized String j() {
        a aVar;
        if (!this.a || (aVar = this.h) == null) {
            return null;
        }
        return aVar.a().networkStandard;
    }

    /* access modifiers changed from: protected */
    public final void a(Message message) {
        boolean z;
        super.a(message);
        Object obj = message.obj;
        if (obj != null) {
            if (message.what == 1) {
                k kVar = (k) obj;
                com.bonree.sdk.be.f fVar = this.c;
                fVar.c("StateChange-isFirstNetState=" + this.m, new Object[0]);
                if (!this.m.get()) {
                    StateChangeEventInfoBean stateChangeEventInfoBean = new StateChangeEventInfoBean();
                    stateChangeEventInfoBean.type = 1;
                    EventBean eventBean = new EventBean();
                    eventBean.mEventTime = a();
                    eventBean.mEventInfo = stateChangeEventInfoBean;
                    eventBean.mEventType = BaseEventInfo.EVENT_TYPE_STATECHANGE;
                    eventBean.mStateIndex = eventBean.getStateIndex();
                    if (kVar.a() == -1) {
                        a((String) null, kVar.b());
                    } else {
                        this.v = null;
                        try {
                            if (!a(false, kVar)) {
                                eventBean.decrementStateKey();
                                return;
                            }
                            com.bonree.sdk.be.f fVar2 = this.c;
                            fVar2.a("StateChange-netState ip=" + this.v, new Object[0]);
                            a(this.v, kVar.b());
                        } catch (Exception e) {
                            this.c.a("StateChange-getIp failed e:%s", (Throwable) e);
                            eventBean.decrementStateKey();
                            return;
                        }
                    }
                    this.t = eventBean;
                    n();
                    p();
                    b(kVar);
                    this.x = kVar;
                } else if (kVar.a() != -1) {
                    try {
                        z = a(true, (k) null);
                    } catch (Exception e2) {
                        com.bonree.sdk.be.f fVar3 = this.c;
                        fVar3.e("StateChange-first getIp Exception e=" + e2, new Object[0]);
                        z = false;
                    }
                    if (z) {
                        a aVar = this.h;
                        if (aVar == null) {
                            a(this.v, kVar.b());
                        } else {
                            aVar.a(b(this.v, kVar.b()));
                        }
                        s();
                        b(kVar);
                        this.m.set(false);
                    }
                }
            } else if (message.what == 2) {
                e eVar = (e) obj;
                StateChangeEventInfoBean stateChangeEventInfoBean2 = new StateChangeEventInfoBean();
                if (e.FOREGROUND == eVar) {
                    stateChangeEventInfoBean2.type = 2;
                } else if (e.BACKGROUND == eVar) {
                    stateChangeEventInfoBean2.type = 3;
                }
                EventBean eventBean2 = new EventBean();
                eventBean2.mEventType = BaseEventInfo.EVENT_TYPE_STATECHANGE;
                eventBean2.mEventTime = a();
                eventBean2.mEventInfo = stateChangeEventInfoBean2;
                eventBean2.mStateIndex = eventBean2.getStateIndex();
                eventBean2.uploadStateKey();
                this.f.add(eventBean2);
            }
        }
    }

    private void b(k kVar) {
        if (!this.w.isEmpty()) {
            synchronized (this.w) {
                for (a c : this.w) {
                    c.c(kVar.b());
                }
            }
        }
    }

    public final void a(k kVar) {
        if (kVar != null) {
            this.c.c("StateChange- netState:%s, time:%s", kVar, Long.valueOf(System.currentTimeMillis()));
            a(1, (Object) kVar);
        }
    }

    private synchronized void a(String str, String str2) {
        a(str, str2, g.k().j());
    }

    private synchronized void a(String str, String str2, String str3) {
        com.bonree.sdk.be.f fVar = this.c;
        fVar.c("StateChange-updateNetStateInfo,ip=" + str + ",standard=" + str2 + ",dns:" + str3, new Object[0]);
        NetWorkStateInfoBean netWorkStateInfoBean = new NetWorkStateInfoBean();
        netWorkStateInfoBean.ip = str;
        netWorkStateInfoBean.dnsServerIp = str3;
        netWorkStateInfoBean.networkStandard = str2;
        this.h = new a(netWorkStateInfoBean);
    }

    private synchronized void n() {
        String str = null;
        Iterator<String> it = this.i.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                String next = it.next();
                a aVar = this.i.get(next);
                if (aVar != null && aVar.a() != null && aVar.a().equals(this.h.a())) {
                    str = next;
                    break;
                }
            } else {
                break;
            }
        }
        if (!ad.a(str)) {
            this.l = str;
        } else {
            this.l = UUID.randomUUID().toString();
        }
    }

    private synchronized NetWorkStateInfoBean b(String str, String str2) {
        NetWorkStateInfoBean netWorkStateInfoBean;
        com.bonree.sdk.be.f fVar = this.c;
        fVar.c("StateChange-productNetStateInfoBean,ip=" + str + ",standard=" + str2, new Object[0]);
        netWorkStateInfoBean = new NetWorkStateInfoBean();
        netWorkStateInfoBean.ip = str;
        netWorkStateInfoBean.dnsServerIp = g.k().j();
        netWorkStateInfoBean.networkStandard = str2;
        return netWorkStateInfoBean;
    }

    private EventBean o() {
        StateChangeEventInfoBean stateChangeEventInfoBean = new StateChangeEventInfoBean();
        stateChangeEventInfoBean.type = 1;
        EventBean eventBean = new EventBean();
        eventBean.mEventTime = a();
        eventBean.mEventInfo = stateChangeEventInfoBean;
        eventBean.mEventType = BaseEventInfo.EVENT_TYPE_STATECHANGE;
        eventBean.mStateIndex = eventBean.getStateIndex();
        return eventBean;
    }

    private synchronized void p() {
        NetWorkStateInfoBean netWorkStateInfoBean = new NetWorkStateInfoBean();
        netWorkStateInfoBean.ip = this.h.a().ip;
        netWorkStateInfoBean.dnsServerIp = this.h.a().dnsServerIp;
        netWorkStateInfoBean.networkStandard = this.h.a().networkStandard;
        if (this.t.mEventInfo instanceof StateChangeEventInfoBean) {
            ((StateChangeEventInfoBean) this.t.mEventInfo).targetNetStateInfo = netWorkStateInfoBean;
        }
        this.t.uploadStateKey();
        this.f.add(this.t);
    }

    public final void d(String str) {
        if (!ad.a(str)) {
            this.u = str;
            aa.a(com.bonree.sdk.bs.a.a(), "netInfo", "getIpAddress", this.u);
        }
    }

    private boolean a(boolean z, k kVar) {
        com.bonree.sdk.be.f fVar = this.c;
        fVar.c("StateChange-is first getBrIp:" + z, new Object[0]);
        if (ad.a(this.u)) {
            com.bonree.sdk.be.f fVar2 = this.c;
            fVar2.c("StateChange-getIpAddress is:" + this.u, new Object[0]);
            return false;
        }
        String e = e(this.u);
        com.bonree.sdk.be.f fVar3 = this.c;
        fVar3.c("StateChange- getIp response =" + e, new Object[0]);
        if (e == null) {
            return false;
        }
        String string = new JSONObject(e).getString("di");
        if (a(string, kVar)) {
            this.c.c("StateChange- isRepeatNetInfo", new Object[0]);
            return false;
        }
        this.v = string;
        com.bonree.sdk.be.f fVar4 = this.c;
        fVar4.c("StateChange-first getIpAddress=" + this.u + "  localIp=" + this.v, new Object[0]);
        return true;
    }

    private boolean a(String str, k kVar) {
        if (this.x == null || kVar == null || ((!TextUtils.isEmpty(this.v) && !this.v.equals(str)) || !this.x.toString().equals(kVar.toString()))) {
            return false;
        }
        return true;
    }

    private static String e(String str) {
        k.a b2 = com.bonree.sdk.agent.business.util.k.b().b("".getBytes(), str + "?v=" + Agent.PROTOCOL_VERSION + "&a=" + com.bonree.sdk.d.a.k().v() + "&d=" + Bonree.getDeviceID(), (String) null, 5000);
        if (b2 != null) {
            return new String(b2.a);
        }
        return null;
    }

    public final void a(e eVar) {
        com.bonree.sdk.be.f fVar = this.c;
        fVar.c("StateChange-appState=" + eVar + " time=" + System.currentTimeMillis(), new Object[0]);
        a(2, (Object) eVar);
    }

    private void b(e eVar) {
        StateChangeEventInfoBean stateChangeEventInfoBean = new StateChangeEventInfoBean();
        if (e.FOREGROUND == eVar) {
            stateChangeEventInfoBean.type = 2;
        } else if (e.BACKGROUND == eVar) {
            stateChangeEventInfoBean.type = 3;
        }
        EventBean eventBean = new EventBean();
        eventBean.mEventType = BaseEventInfo.EVENT_TYPE_STATECHANGE;
        eventBean.mEventTime = a();
        eventBean.mEventInfo = stateChangeEventInfoBean;
        eventBean.mStateIndex = eventBean.getStateIndex();
        eventBean.uploadStateKey();
        this.f.add(eventBean);
    }

    /* access modifiers changed from: protected */
    public final synchronized void d() {
        super.d();
        EventBean eventBean = this.t;
        if (eventBean != null && eventBean.mEventTime < 0) {
            EventBean eventBean2 = this.t;
            eventBean2.mEventTime = d(eventBean2.mEventTime);
        }
    }

    private boolean q() {
        ConnectivityManager connectivityManager = (ConnectivityManager) com.bonree.sdk.bs.a.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = null;
        if (ad.a(com.bonree.sdk.bs.a.a(), "android.permission.ACCESS_NETWORK_STATE")) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo != null && networkInfo.isAvailable()) {
            return true;
        }
        this.c.e("NetworkInfo null or not available", new Object[0]);
        return false;
    }

    public final boolean l() {
        ConnectivityManager connectivityManager = (ConnectivityManager) com.bonree.sdk.bs.a.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = null;
        if (ad.a(com.bonree.sdk.bs.a.a(), "android.permission.ACCESS_NETWORK_STATE")) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo == null || !networkInfo.isAvailable()) {
            this.c.e("NetworkInfo null or not available", new Object[0]);
            return false;
        } else if (networkInfo.getType() == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static int r() {
        NetworkInfo activeNetworkInfo = ad.a(com.bonree.sdk.bs.a.a(), "android.permission.ACCESS_NETWORK_STATE") ? ((ConnectivityManager) com.bonree.sdk.bs.a.a().getSystemService("connectivity")).getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null) {
            return -1;
        }
        if (activeNetworkInfo.getType() != 1) {
            return activeNetworkInfo.getSubtype();
        }
        return 0;
    }

    public final void a(a aVar) {
        this.w.add(aVar);
    }

    public final void b(a aVar) {
        this.w.remove(aVar);
    }

    public final synchronized boolean b() {
        if (!this.a) {
            a("StateChange-", a.d.a);
            this.a = true;
            a("BR-StateChange-Thread");
            m.g().registerService((j) this);
            com.bonree.sdk.agent.engine.state.f.getEngine().registerService((i) this);
            this.u = aa.d(com.bonree.sdk.bs.a.a(), "netInfo", "getIpAddress");
            if (ad.a(this.v)) {
                this.v = null;
            }
            a("StateChange-", a.d.c);
        } else {
            a("StateChange-", a.d.b);
        }
        return true;
    }

    private synchronized void b(String str, String str2, String str3) {
        aa.a(com.bonree.sdk.bs.a.a(), "netInfo", "ip", str);
        aa.a(com.bonree.sdk.bs.a.a(), "netInfo", "standard", str2);
        aa.a(com.bonree.sdk.bs.a.a(), "netInfo", "dns", str3);
    }

    private synchronized void s() {
        a aVar = this.h;
        if (!(aVar == null || aVar.a() == null)) {
            NetWorkStateInfoBean a2 = this.h.a();
            b(a2.ip, a2.networkStandard, a2.dnsServerIp);
        }
    }

    public final synchronized boolean c() {
        if (this.a) {
            a("StateChange-", a.d.d);
            this.a = false;
            d.a().b("BR-StateChange-Thread");
            m.g().unRegisterService(this);
            com.bonree.sdk.agent.engine.state.f.getEngine().unRegisterService((i) this);
            f();
            this.f.clear();
            this.m.set(true);
        } else {
            this.c.d("StateChangeService no need stoped!", new Object[0]);
        }
        a("StateChange-", a.d.e);
        return true;
    }

    private c() {
        this((com.bonree.sdk.d.e) null);
    }

    private c(com.bonree.sdk.d.e eVar) {
        super((com.bonree.sdk.d.e) null);
        this.g = "StateChange-";
        this.i = new com.bonree.sdk.bs.k();
        this.j = new com.bonree.sdk.bs.k();
        this.l = k;
        this.m = new AtomicBoolean(true);
        this.n = 1;
        this.o = 2;
        this.p = 3;
        this.q = 1;
        this.r = 2;
        this.s = "BR-StateChange-Thread";
        this.w = Collections.synchronizedList(new ArrayList());
        this.f = Collections.synchronizedList(new ArrayList());
    }

    public static c m() {
        return b.a;
    }

    static class b {
        /* access modifiers changed from: private */
        public static final c a = new c((byte) 0);

        private b() {
        }
    }

    public final boolean k() {
        ConnectivityManager connectivityManager = (ConnectivityManager) com.bonree.sdk.bs.a.a().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo networkInfo = null;
            if (ad.a(com.bonree.sdk.bs.a.a(), "android.permission.ACCESS_NETWORK_STATE")) {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            }
            if (networkInfo != null && networkInfo.isAvailable()) {
                return true;
            }
            this.c.e("NetworkInfo null or not available", new Object[0]);
        }
        return false;
    }
}
