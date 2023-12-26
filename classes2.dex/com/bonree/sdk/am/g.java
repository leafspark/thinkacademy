package com.bonree.sdk.am;

import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.AppInfoBean;
import com.bonree.sdk.agent.business.entity.DeviceInfoBean;
import com.bonree.sdk.agent.business.entity.DeviceStateInfoBean;
import com.bonree.sdk.at.c;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.k;
import com.bonree.sdk.d.e;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public final class g extends com.bonree.sdk.ad.a implements c.a {
    private static final String r = "android.permission.INTERNET";
    private static final String s = "android.permission.ACCESS_NETWORK_STATE";
    private final String f;
    private AppInfoBean g;
    private volatile f h;
    /* access modifiers changed from: private */
    public i i;
    private k j;
    private final int k;
    private final int l;
    private final Map<String, k> m;
    private final Map<String, DeviceStateInfoBean> n;
    private Timer o;
    private volatile String p;
    private final CopyOnWriteArraySet<String> q;

    /* synthetic */ g(byte b) {
        this();
    }

    private void l() {
        DeviceStateInfoBean deviceStateInfoBean = new DeviceStateInfoBean();
        deviceStateInfoBean.mOrientation = Byte.valueOf(this.i.h);
        deviceStateInfoBean.mGpsIsOpen = Boolean.valueOf(this.i.f);
        deviceStateInfoBean.mBluetoothOpen = Boolean.valueOf(this.i.e);
        deviceStateInfoBean.mOrientationLockOpen = Boolean.valueOf(this.i.g);
        deviceStateInfoBean.mUsableStorage = this.i.c;
        deviceStateInfoBean.mSystemUsableMemory = this.i.d;
        deviceStateInfoBean.mBattery = this.i.g();
        deviceStateInfoBean.mAppUsedMemory = this.i.a;
        deviceStateInfoBean.mAppUsedCpu = this.i.l();
        deviceStateInfoBean.mSystemUsedCpu = this.i.n();
        deviceStateInfoBean.mSignal = this.i.i;
        k kVar = this.j;
        if (kVar == null || kVar.a() != null) {
            this.j = new k(deviceStateInfoBean);
            this.p = UUID.randomUUID().toString();
            return;
        }
        this.j.a(deviceStateInfoBean);
    }

    public final synchronized String a() {
        if (this.j == null) {
            this.j = new k((DeviceStateInfoBean) null);
        }
        this.j.b();
        this.m.put(this.p, this.j);
        f fVar = this.c;
        fVar.c("Device" + Thread.currentThread().getName() + " getDeviceStateInfoKey=" + this.p, new Object[0]);
        return this.p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r4, boolean r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.bonree.sdk.be.f r0 = r3.c     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "Device"
            r1.<init>(r2)     // Catch:{ all -> 0x0051 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0051 }
            r1.append(r2)     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = " DeviceService uploadKey="
            r1.append(r2)     // Catch:{ all -> 0x0051 }
            r1.append(r4)     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0051 }
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0051 }
            r0.c(r1, r2)     // Catch:{ all -> 0x0051 }
            if (r4 != 0) goto L_0x002b
            monitor-exit(r3)
            return
        L_0x002b:
            java.util.Map<java.lang.String, com.bonree.sdk.am.k> r0 = r3.m     // Catch:{ all -> 0x0051 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0051 }
            com.bonree.sdk.am.k r0 = (com.bonree.sdk.am.k) r0     // Catch:{ all -> 0x0051 }
            if (r0 != 0) goto L_0x0037
            monitor-exit(r3)
            return
        L_0x0037:
            int r1 = r0.c()     // Catch:{ all -> 0x0051 }
            if (r5 == 0) goto L_0x0048
            com.bonree.sdk.agent.business.entity.DeviceStateInfoBean r5 = r0.a()     // Catch:{ all -> 0x0051 }
            if (r5 == 0) goto L_0x0048
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.DeviceStateInfoBean> r0 = r3.n     // Catch:{ all -> 0x0051 }
            r0.put(r4, r5)     // Catch:{ all -> 0x0051 }
        L_0x0048:
            if (r1 != 0) goto L_0x004f
            java.util.Map<java.lang.String, com.bonree.sdk.am.k> r5 = r3.m     // Catch:{ all -> 0x0051 }
            r5.remove(r4)     // Catch:{ all -> 0x0051 }
        L_0x004f:
            monitor-exit(r3)
            return
        L_0x0051:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.am.g.a(java.lang.String, boolean):void");
    }

    public final synchronized Map<String, DeviceStateInfoBean> d() {
        k kVar;
        kVar = new k(this.n);
        this.n.clear();
        return kVar;
    }

    public final AppInfoBean e() {
        if (this.g == null) {
            AppInfoBean appInfoBean = new AppInfoBean();
            this.g = appInfoBean;
            try {
                appInfoBean.appId = com.bonree.sdk.d.a.k().v();
                String b = e.d().b();
                if (b != null) {
                    this.g.appVersion = b;
                } else {
                    this.g.appVersion = "";
                }
                this.g.appName = e.d().c().getPackageName();
                this.g.channelId = com.bonree.sdk.d.a.k().G();
                if (com.bonree.sdk.d.a.L()) {
                    this.g.mAppType = 3;
                } else {
                    this.g.mAppType = 1;
                }
            } catch (Exception e) {
                this.c.e("Device getAppInfoBean appInfoBean:%s", this.g);
                f fVar = this.c;
                fVar.e("Device getAppInfoBean error:" + e, new Object[0]);
            }
        }
        return this.g;
    }

    public final DeviceInfoBean g() {
        DeviceInfoBean deviceInfoBean = new DeviceInfoBean();
        if (this.h == null) {
            if (com.bonree.sdk.d.a.L()) {
                this.h = new l();
            } else {
                this.h = new a();
            }
        }
        deviceInfoBean.osMajorVersion = this.h.g();
        deviceInfoBean.osCustomVersion = this.h.p();
        deviceInfoBean.osType = this.h.e();
        deviceInfoBean.mBrandName = this.h.h();
        deviceInfoBean.deviceId = f.d();
        deviceInfoBean.mModel = this.h.i();
        deviceInfoBean.mCpuModel = this.h.j();
        deviceInfoBean.mCpuInstructionSet = this.h.k();
        deviceInfoBean.mCpuHardware = this.h.l();
        deviceInfoBean.authority = this.h.m();
        deviceInfoBean.mDisplaySize = this.h.n();
        deviceInfoBean.mLanguage = this.h.b();
        deviceInfoBean.mTotalRAM = this.h.q();
        deviceInfoBean.mTotalROM = this.h.r();
        return deviceInfoBean;
    }

    public static String h() {
        return f.d();
    }

    public static void b(String str) {
        if (!ad.b(str)) {
            f.a(str);
        }
    }

    private g(e eVar) {
        super((e) null);
        this.f = "Device";
        this.k = 1;
        this.l = 3;
        this.m = new k();
        this.n = new k();
        this.p = UUID.randomUUID().toString();
        this.q = new CopyOnWriteArraySet<>();
    }

    public final Set<String> i() {
        f fVar = this.c;
        fVar.c("DevicegetmLocalDns:" + this.q, new Object[0]);
        return this.q;
    }

    public final String j() {
        return this.q.size() > 0 ? this.q.iterator().next() : "";
    }

    private void m() {
        this.q.addAll(ad.a(ad.m(r) && ad.m(s)));
    }

    private g() {
        this((e) null);
    }

    public final synchronized boolean b() {
        if (!this.a) {
            a("Device", a.d.a);
            this.a = true;
            Timer timer = new Timer();
            this.o = timer;
            timer.schedule(new h(this), 0, com.bonree.sdk.d.a.k().h());
            c.m().a((c.a) this);
            a("Device", a.d.c);
        } else {
            a("Device", a.d.b);
        }
        return true;
    }

    public final synchronized boolean c() {
        if (this.a) {
            a("Device", a.d.d);
            this.a = false;
            i iVar = this.i;
            if (iVar != null) {
                iVar.f();
            }
            this.o.cancel();
            this.o = null;
        } else {
            this.c.d("DeviceService no need stoped!", new Object[0]);
        }
        c.m().b((c.a) this);
        a("Device", a.d.e);
        return true;
    }

    public static g k() {
        return a.a;
    }

    public final void c(String str) {
        f fVar = this.c;
        boolean z = false;
        fVar.c("Network state change: " + str, new Object[0]);
        this.q.clear();
        if (!"NaN".equals(str)) {
            CopyOnWriteArraySet<String> copyOnWriteArraySet = this.q;
            if (ad.m(r) && ad.m(s)) {
                z = true;
            }
            copyOnWriteArraySet.addAll(ad.a(z));
        }
    }

    static class a {
        /* access modifiers changed from: private */
        public static final g a = new g((byte) 0);

        private a() {
        }
    }

    static /* synthetic */ void b(g gVar) {
        DeviceStateInfoBean deviceStateInfoBean = new DeviceStateInfoBean();
        deviceStateInfoBean.mOrientation = Byte.valueOf(gVar.i.h);
        deviceStateInfoBean.mGpsIsOpen = Boolean.valueOf(gVar.i.f);
        deviceStateInfoBean.mBluetoothOpen = Boolean.valueOf(gVar.i.e);
        deviceStateInfoBean.mOrientationLockOpen = Boolean.valueOf(gVar.i.g);
        deviceStateInfoBean.mUsableStorage = gVar.i.c;
        deviceStateInfoBean.mSystemUsableMemory = gVar.i.d;
        deviceStateInfoBean.mBattery = gVar.i.g();
        deviceStateInfoBean.mAppUsedMemory = gVar.i.a;
        deviceStateInfoBean.mAppUsedCpu = gVar.i.l();
        deviceStateInfoBean.mSystemUsedCpu = gVar.i.n();
        deviceStateInfoBean.mSignal = gVar.i.i;
        k kVar = gVar.j;
        if (kVar == null || kVar.a() != null) {
            gVar.j = new k(deviceStateInfoBean);
            gVar.p = UUID.randomUUID().toString();
            return;
        }
        gVar.j.a(deviceStateInfoBean);
    }
}
