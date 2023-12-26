package com.bonree.sdk.d;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.bonree.sdk.ag.c;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.agent.Bonree;
import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.engine.crash.NativeCrashEngine;
import com.bonree.sdk.agent.engine.crash.d;
import com.bonree.sdk.agent.engine.state.i;
import com.bonree.sdk.am.g;
import com.bonree.sdk.aq.h;
import com.bonree.sdk.at.c;
import com.bonree.sdk.ba.p;
import com.bonree.sdk.bb.k;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.d.a;
import com.bonree.sdk.d.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class e implements b {
    /* access modifiers changed from: private */
    public final f a;
    private Context b;
    private com.bonree.sdk.a.a c;
    private a d;
    private final c e;
    /* access modifiers changed from: private */
    public final com.bonree.sdk.b.a f;
    private final com.bonree.sdk.ar.e g;
    private final com.bonree.sdk.af.a h;
    /* access modifiers changed from: private */
    public final p i;
    private final com.bonree.sdk.ap.e j;
    private final com.bonree.sdk.ay.e k;
    private final k l;
    private final c m;
    private final com.bonree.sdk.az.b n;
    private final com.bonree.sdk.ag.c o;
    private final com.bonree.sdk.au.a p;
    private final h q;
    private final com.bonree.sdk.ac.c r;
    private final com.bonree.sdk.av.a s;
    private final com.bonree.sdk.aw.a t;
    private final com.bonree.sdk.al.b u;
    private final com.bonree.sdk.as.a v;
    private final com.bonree.sdk.ae.a w;

    /* synthetic */ e(byte b2) {
        this();
    }

    private e() {
        this.a = com.bonree.sdk.be.a.a();
        this.e = c.b.a;
        this.f = new com.bonree.sdk.b.a(this);
        this.p = com.bonree.sdk.au.a.d();
        this.k = com.bonree.sdk.ay.e.e();
        this.g = com.bonree.sdk.ar.e.d();
        this.o = new com.bonree.sdk.ag.c(this);
        this.h = new com.bonree.sdk.af.a(this);
        this.j = com.bonree.sdk.ap.e.g();
        this.i = p.a();
        this.l = k.e();
        this.m = com.bonree.sdk.at.c.m();
        this.n = com.bonree.sdk.az.b.h();
        this.q = h.a();
        this.r = com.bonree.sdk.ac.c.e();
        this.u = com.bonree.sdk.al.b.g();
        this.s = com.bonree.sdk.av.a.e();
        this.t = com.bonree.sdk.aw.a.g();
        this.v = com.bonree.sdk.as.a.g();
        this.w = com.bonree.sdk.ae.a.e();
    }

    public static e d() {
        return b.a;
    }

    public static synchronized boolean a(Context context, a aVar) {
        synchronized (e.class) {
            if (!(context == null || aVar == null)) {
                if (!a.s()) {
                    Agent.setImpl(b.a);
                    boolean b2 = b.a.b(context, aVar);
                    return b2;
                }
            }
            return false;
        }
    }

    private synchronized boolean b(Context context, a aVar) {
        if (context == null) {
            context = com.bonree.sdk.bs.a.a();
        }
        this.b = context;
        if (aVar == null) {
            aVar = a.k();
        }
        this.c = new com.bonree.sdk.a.a(context, aVar);
        this.d = aVar;
        aVar.n();
        String aVar2 = this.d.toString();
        a.a.c(aVar2, new Object[0]);
        this.a.c(aVar2, new Object[0]);
        c cVar = this.e;
        if (cVar != null) {
            cVar.a(this);
            Handler d2 = this.e.d();
            if (d2 == null) {
                this.a.e("AgentHandler is Null, SDK Start Error!!!", new Object[0]);
                a.a.a("AgentHandler is Null, SDK Start Error!!!");
            }
            if (!aVar.P()) {
                if (d2 == null) {
                    d2 = this.e.d();
                }
                if (d2 == null) {
                    return false;
                }
                d2.obtainMessage(0, Boolean.TRUE).sendToTarget();
            } else if (e()) {
                return false;
            } else {
                if (d2 != null) {
                    d2.sendEmptyMessage(11);
                }
            }
        }
        return true;
    }

    private boolean A() {
        com.bonree.sdk.aj.a i2 = this.h.i();
        if (i2.a) {
            if (ad.a(i2.c) || !i2.c.equals(this.c.b()) || ad.a(i2.b) || !i2.b.equals(Agent.getAgentVersion())) {
                this.h.j();
            } else {
                if (!ad.a(i2.e)) {
                    this.a.c("crashSafeGuard  self crash time: %s crash causeby: %s", Long.valueOf(i2.d), i2.e);
                }
                return true;
            }
        }
        return false;
    }

    public final com.bonree.sdk.af.a f() {
        return this.h;
    }

    private boolean B() {
        this.a.c("Bonree Agent startServices: %s", ad.a());
        if (!a(a.k().m(), true)) {
            Bonree.stopSDK();
            return false;
        }
        this.a.c("All services start successful!", new Object[0]);
        return this.f.c();
    }

    private com.bonree.sdk.az.b C() {
        return this.n;
    }

    public final com.bonree.sdk.at.c g() {
        return this.m;
    }

    private com.bonree.sdk.av.a D() {
        return this.s;
    }

    public final com.bonree.sdk.aw.a h() {
        return this.t;
    }

    private com.bonree.sdk.as.a E() {
        return this.v;
    }

    private com.bonree.sdk.ae.a F() {
        return this.w;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: com.bonree.sdk.agent.business.entity.CustomerParamBean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean r32, boolean r33) {
        /*
            r31 = this;
            r1 = r31
            r0 = r32
            java.lang.String r2 = "battery"
            java.lang.String r3 = "routechange"
            java.lang.String r4 = "lag"
            java.lang.String r5 = "anr"
            java.lang.String r6 = "statechange"
            java.lang.String r7 = "action"
            java.lang.String r8 = "coollaunch"
            java.lang.String r9 = "view"
            java.lang.String r10 = "h5"
            java.lang.String r11 = "crash"
            java.lang.String r12 = "network"
            java.lang.String r13 = "lagfps"
            if (r0 == 0) goto L_0x04e8
            java.util.List<com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$ModuleConfiguration> r14 = r0.mModuleConfiguration     // Catch:{ all -> 0x04e5 }
            if (r14 == 0) goto L_0x04e8
            java.util.List<com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$ModuleConfiguration> r14 = r0.mModuleConfiguration     // Catch:{ all -> 0x04e5 }
            int r14 = r14.size()     // Catch:{ all -> 0x04e5 }
            if (r14 > 0) goto L_0x002c
            goto L_0x04e8
        L_0x002c:
            java.lang.String r14 = r0.mCustomerParam     // Catch:{ all -> 0x04e5 }
            boolean r14 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x04e5 }
            if (r14 != 0) goto L_0x0047
            com.bonree.sdk.common.gson.Gson r14 = new com.bonree.sdk.common.gson.Gson     // Catch:{ all -> 0x04e5 }
            r14.<init>()     // Catch:{ all -> 0x04e5 }
            java.lang.String r15 = r0.mCustomerParam     // Catch:{ all -> 0x04e5 }
            r18 = r2
            java.lang.Class<com.bonree.sdk.agent.business.entity.CustomerParamBean> r2 = com.bonree.sdk.agent.business.entity.CustomerParamBean.class
            java.lang.Object r2 = r14.fromJson((java.lang.String) r15, r2)     // Catch:{ all -> 0x04e5 }
            r14 = r2
            com.bonree.sdk.agent.business.entity.CustomerParamBean r14 = (com.bonree.sdk.agent.business.entity.CustomerParamBean) r14     // Catch:{ all -> 0x04e5 }
            goto L_0x004a
        L_0x0047:
            r18 = r2
            r14 = 0
        L_0x004a:
            if (r33 != 0) goto L_0x0071
            com.bonree.sdk.at.c r2 = r1.m     // Catch:{ all -> 0x04e5 }
            java.lang.String r15 = r0.mDeviceIP     // Catch:{ all -> 0x04e5 }
            r2.c(r15)     // Catch:{ all -> 0x04e5 }
            if (r14 == 0) goto L_0x006c
            com.bonree.sdk.agent.business.entity.LogReturnInfoBean r2 = r14.getUploadLogBean()     // Catch:{ all -> 0x04e5 }
            if (r2 == 0) goto L_0x006c
            boolean r15 = r2.isLegal()     // Catch:{ all -> 0x04e5 }
            if (r15 == 0) goto L_0x006c
            com.bonree.sdk.av.a r15 = r1.s     // Catch:{ all -> 0x04e5 }
            r15.a((com.bonree.sdk.agent.business.entity.LogReturnInfoBean) r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.av.a r2 = r1.s     // Catch:{ all -> 0x04e5 }
            r2.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x0071
        L_0x006c:
            com.bonree.sdk.av.a r2 = r1.s     // Catch:{ all -> 0x04e5 }
            r2.c()     // Catch:{ all -> 0x04e5 }
        L_0x0071:
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x04e5 }
            r2.<init>()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e r15 = r1.g     // Catch:{ all -> 0x04e5 }
            r2.put(r12, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.af.a r15 = r1.h     // Catch:{ all -> 0x04e5 }
            r2.put(r11, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.bb.k r15 = r1.l     // Catch:{ all -> 0x04e5 }
            r2.put(r10, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ba.p r15 = r1.i     // Catch:{ all -> 0x04e5 }
            r2.put(r9, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.aq.h r15 = r1.q     // Catch:{ all -> 0x04e5 }
            r2.put(r8, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ac.c r15 = r1.r     // Catch:{ all -> 0x04e5 }
            r2.put(r7, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.at.c r15 = r1.m     // Catch:{ all -> 0x04e5 }
            r2.put(r6, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ag.c r15 = r1.o     // Catch:{ all -> 0x04e5 }
            r2.put(r5, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ap.e r15 = r1.j     // Catch:{ all -> 0x04e5 }
            r2.put(r13, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ap.e r15 = r1.j     // Catch:{ all -> 0x04e5 }
            r2.put(r4, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.as.a r15 = r1.v     // Catch:{ all -> 0x04e5 }
            r2.put(r3, r15)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ae.a r15 = r1.w     // Catch:{ all -> 0x04e5 }
            r17 = r14
            r14 = r18
            r2.put(r14, r15)     // Catch:{ all -> 0x04e5 }
            java.util.List<com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$ModuleConfiguration> r15 = r0.mModuleConfiguration     // Catch:{ all -> 0x04e5 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x04e5 }
            r18 = 1
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x00c4:
            boolean r22 = r15.hasNext()     // Catch:{ all -> 0x04e5 }
            if (r22 == 0) goto L_0x042b
            java.lang.Object r22 = r15.next()     // Catch:{ all -> 0x04e5 }
            r23 = r15
            r15 = r22
            com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$ModuleConfiguration r15 = (com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean.ModuleConfiguration) r15     // Catch:{ all -> 0x04e5 }
            r22 = r14
            java.lang.String r14 = r15.mModuleName     // Catch:{ all -> 0x04e5 }
            r24 = r3
            int r3 = r15.mConfiguration     // Catch:{ all -> 0x04e5 }
            if (r3 > 0) goto L_0x00fb
            r25 = r5
            com.bonree.sdk.be.f r5 = r1.a     // Catch:{ all -> 0x04e5 }
            r26 = r6
            java.lang.String r6 = "rate is %d, out of range 0-100, result false;"
            r27 = r4
            r28 = r13
            r4 = 1
            java.lang.Object[] r13 = new java.lang.Object[r4]     // Catch:{ all -> 0x04e5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x04e5 }
            r4 = 0
            r13[r4] = r3     // Catch:{ all -> 0x04e5 }
            r5.d(r6, r13)     // Catch:{ all -> 0x04e5 }
            r29 = r7
            r5 = 0
            goto L_0x013d
        L_0x00fb:
            r27 = r4
            r25 = r5
            r26 = r6
            r28 = r13
            if (r33 == 0) goto L_0x0109
            r29 = r7
            r5 = 1
            goto L_0x013d
        L_0x0109:
            java.util.Random r4 = new java.util.Random     // Catch:{ all -> 0x04e5 }
            r4.<init>()     // Catch:{ all -> 0x04e5 }
            r5 = 100
            int r4 = r4.nextInt(r5)     // Catch:{ all -> 0x04e5 }
            r5 = 1
            int r4 = r4 + r5
            if (r4 > r3) goto L_0x011a
            r5 = 1
            goto L_0x011b
        L_0x011a:
            r5 = 0
        L_0x011b:
            com.bonree.sdk.be.f r6 = r1.a     // Catch:{ all -> 0x04e5 }
            java.lang.String r13 = "rate is %d , random number is %d , result %b."
            r29 = r7
            r7 = 3
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x04e5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x04e5 }
            r16 = 0
            r7[r16] = r3     // Catch:{ all -> 0x04e5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x04e5 }
            r4 = 1
            r7[r4] = r3     // Catch:{ all -> 0x04e5 }
            r3 = 2
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x04e5 }
            r7[r3] = r4     // Catch:{ all -> 0x04e5 }
            r6.c(r13, r7)     // Catch:{ all -> 0x04e5 }
        L_0x013d:
            if (r5 == 0) goto L_0x0143
            if (r18 == 0) goto L_0x0143
            r18 = 0
        L_0x0143:
            boolean r3 = r12.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x01c8
            r2.remove(r12)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x01b3
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            java.lang.String[] r3 = r3.S()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e.a((java.lang.String[]) r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            java.lang.String[] r3 = r3.T()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e.b((java.lang.String[]) r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            java.lang.String[] r3 = r3.U()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e.c(r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            java.lang.String[] r3 = r3.V()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e.d(r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            java.lang.String[] r3 = r3.W()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e.e(r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            boolean r3 = r3.H()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e.a((boolean) r3)     // Catch:{ all -> 0x04e5 }
            boolean r3 = r0.mOpenDataMerge     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x019a
            com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$NetworkTraceConfig r3 = r0.mNetworkTraceConfig     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x019a
            r3 = 1
            goto L_0x019b
        L_0x019a:
            r3 = 0
        L_0x019b:
            com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$NetworkTraceConfig r4 = r0.mNetworkTraceConfig     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.m.k r5 = com.bonree.sdk.m.k.b()     // Catch:{ all -> 0x04e5 }
            r5.a((boolean) r3, (com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean.NetworkTraceConfig) r4)     // Catch:{ all -> 0x04e5 }
            int r3 = r0.mHeaderCollectionStrategy     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.b r4 = com.bonree.sdk.ar.b.a()     // Catch:{ all -> 0x04e5 }
            r4.a((int) r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e r3 = r1.g     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x01b8
        L_0x01b3:
            com.bonree.sdk.ar.e r3 = r1.g     // Catch:{ all -> 0x04e5 }
            r3.c()     // Catch:{ all -> 0x04e5 }
        L_0x01b8:
            r13 = r25
            r7 = r26
            r6 = r27
            r4 = r28
        L_0x01c0:
            r30 = r24
            r24 = r22
            r22 = r30
            goto L_0x041d
        L_0x01c8:
            boolean r3 = r11.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x01e6
            r2.remove(r11)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x01e0
            com.bonree.sdk.af.a r3 = r1.h     // Catch:{ all -> 0x04e5 }
            int r4 = r0.mSaveTime     // Catch:{ all -> 0x04e5 }
            r3.b((int) r4)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.af.a r3 = r1.h     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x01b8
        L_0x01e0:
            com.bonree.sdk.af.a r3 = r1.h     // Catch:{ all -> 0x04e5 }
            r3.c()     // Catch:{ all -> 0x04e5 }
            goto L_0x01b8
        L_0x01e6:
            boolean r3 = r10.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x021e
            r2.remove(r10)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x0218
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            java.lang.String[] r3 = r3.S()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.bb.k.a((java.lang.String[]) r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            java.lang.String[] r3 = r3.T()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.bb.k.b((java.lang.String[]) r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            java.lang.String[] r3 = r3.U()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.bb.k.c(r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.bb.k r3 = r1.l     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x01b8
        L_0x0218:
            com.bonree.sdk.bb.k r3 = r1.l     // Catch:{ all -> 0x04e5 }
            r3.c()     // Catch:{ all -> 0x04e5 }
            goto L_0x01b8
        L_0x021e:
            boolean r3 = r9.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x023d
            r2.remove(r9)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x0236
            com.bonree.sdk.ba.p r3 = r1.i     // Catch:{ all -> 0x04e5 }
            int r4 = r15.mThresholdValue     // Catch:{ all -> 0x04e5 }
            r3.b(r4)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ba.p r3 = r1.i     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x01b8
        L_0x0236:
            com.bonree.sdk.ba.p r3 = r1.i     // Catch:{ all -> 0x04e5 }
            r3.c()     // Catch:{ all -> 0x04e5 }
            goto L_0x01b8
        L_0x023d:
            boolean r3 = r8.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x026a
            r2.remove(r8)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x0263
            com.bonree.sdk.aq.h r3 = r1.q     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r4 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            boolean r4 = r4.I()     // Catch:{ all -> 0x04e5 }
            r3.b((boolean) r4)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.aq.h r3 = r1.q     // Catch:{ all -> 0x04e5 }
            int r4 = r15.mThresholdValue     // Catch:{ all -> 0x04e5 }
            r3.b((int) r4)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.aq.h r3 = r1.q     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x01b8
        L_0x0263:
            com.bonree.sdk.aq.h r3 = r1.q     // Catch:{ all -> 0x04e5 }
            r3.c()     // Catch:{ all -> 0x04e5 }
            goto L_0x01b8
        L_0x026a:
            java.lang.String r3 = "hotlaunch"
            boolean r3 = r3.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x028b
            if (r5 == 0) goto L_0x027d
            com.bonree.sdk.aq.h r3 = r1.q     // Catch:{ all -> 0x04e5 }
            int r4 = r15.mThresholdValue     // Catch:{ all -> 0x04e5 }
            r3.c((int) r4)     // Catch:{ all -> 0x04e5 }
            goto L_0x01b8
        L_0x027d:
            r3 = r22
            r15 = r24
            r13 = r25
            r7 = r26
            r6 = r27
            r4 = r28
            goto L_0x03bf
        L_0x028b:
            r3 = r29
            boolean r4 = r3.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r4 == 0) goto L_0x02c7
            r2.remove(r3)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x02be
            com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$ModuleConfiguration$ActionAnalyseConfiguration r4 = r15.mActionAnalyseConfiguration     // Catch:{ all -> 0x04e5 }
            if (r4 == 0) goto L_0x02b2
            com.bonree.sdk.ac.c r4 = r1.r     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$ModuleConfiguration$ActionAnalyseConfiguration r5 = r15.mActionAnalyseConfiguration     // Catch:{ all -> 0x04e5 }
            boolean r5 = r5.mActionAnalyse     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$ModuleConfiguration$ActionAnalyseConfiguration r6 = r15.mActionAnalyseConfiguration     // Catch:{ all -> 0x04e5 }
            int r6 = r6.mMethodMaxDepth     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$ModuleConfiguration$ActionAnalyseConfiguration r7 = r15.mActionAnalyseConfiguration     // Catch:{ all -> 0x04e5 }
            int r7 = r7.mCollectionProbability     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean$ModuleConfiguration$ActionAnalyseConfiguration r13 = r15.mActionAnalyseConfiguration     // Catch:{ all -> 0x04e5 }
            int r13 = r13.mAsynchronousOperationTimeout     // Catch:{ all -> 0x04e5 }
            r4.a(r5, r6, r7, r13)     // Catch:{ all -> 0x04e5 }
            goto L_0x02b8
        L_0x02b2:
            com.bonree.sdk.ac.c r4 = r1.r     // Catch:{ all -> 0x04e5 }
            r5 = 0
            r4.a(r5, r5, r5, r5)     // Catch:{ all -> 0x04e5 }
        L_0x02b8:
            com.bonree.sdk.ac.c r4 = r1.r     // Catch:{ all -> 0x04e5 }
            r4.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x02c3
        L_0x02be:
            com.bonree.sdk.ac.c r4 = r1.r     // Catch:{ all -> 0x04e5 }
            r4.c()     // Catch:{ all -> 0x04e5 }
        L_0x02c3:
            r29 = r3
            goto L_0x01b8
        L_0x02c7:
            r4 = r28
            boolean r6 = r4.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r6 != 0) goto L_0x03c4
            r6 = r27
            boolean r7 = r6.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r7 == 0) goto L_0x02e3
            r29 = r3
            r3 = r22
            r22 = r24
            r13 = r25
            r7 = r26
            goto L_0x03d0
        L_0x02e3:
            java.lang.String r7 = "lagstuck"
            boolean r7 = r7.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r7 == 0) goto L_0x0307
            com.bonree.sdk.ap.e r5 = r1.j     // Catch:{ all -> 0x04e5 }
            int r7 = r15.mThresholdValue     // Catch:{ all -> 0x04e5 }
            if (r7 > 0) goto L_0x02fa
            com.bonree.sdk.d.a r7 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            r7.getClass()     // Catch:{ all -> 0x04e5 }
            r7 = 5
            goto L_0x02fc
        L_0x02fa:
            int r7 = r15.mThresholdValue     // Catch:{ all -> 0x04e5 }
        L_0x02fc:
            r5.d(r7)     // Catch:{ all -> 0x04e5 }
            r29 = r3
            r13 = r25
            r7 = r26
            goto L_0x01c0
        L_0x0307:
            r7 = r26
            boolean r13 = r7.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r13 == 0) goto L_0x032c
            r2.remove(r7)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.at.c r13 = r1.m     // Catch:{ all -> 0x04e5 }
            java.lang.String r14 = r0.mGetDeviceIPAddress     // Catch:{ all -> 0x04e5 }
            r13.d(r14)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x0321
            com.bonree.sdk.at.c r5 = r1.m     // Catch:{ all -> 0x04e5 }
            r5.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x0326
        L_0x0321:
            com.bonree.sdk.at.c r5 = r1.m     // Catch:{ all -> 0x04e5 }
            r5.c()     // Catch:{ all -> 0x04e5 }
        L_0x0326:
            r29 = r3
            r13 = r25
            goto L_0x01c0
        L_0x032c:
            r13 = r25
            boolean r15 = r13.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r15 == 0) goto L_0x0348
            r2.remove(r13)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x033f
            com.bonree.sdk.ag.c r5 = r1.o     // Catch:{ all -> 0x04e5 }
            r5.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x0344
        L_0x033f:
            com.bonree.sdk.ag.c r5 = r1.o     // Catch:{ all -> 0x04e5 }
            r5.c()     // Catch:{ all -> 0x04e5 }
        L_0x0344:
            r29 = r3
            goto L_0x01c0
        L_0x0348:
            r15 = r24
            boolean r24 = r15.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r24 == 0) goto L_0x0366
            r2.remove(r15)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x035b
            com.bonree.sdk.as.a r5 = r1.v     // Catch:{ all -> 0x04e5 }
            r5.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x0360
        L_0x035b:
            com.bonree.sdk.as.a r5 = r1.v     // Catch:{ all -> 0x04e5 }
            r5.c()     // Catch:{ all -> 0x04e5 }
        L_0x0360:
            r29 = r3
            r24 = r22
            goto L_0x03c1
        L_0x0366:
            r29 = r3
            java.lang.String r3 = "custommetric"
            boolean r3 = r3.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x037f
            if (r5 == 0) goto L_0x037c
            r5 = r13
            r3 = r15
            r14 = r22
            r15 = r23
            r21 = 1
            goto L_0x0424
        L_0x037c:
            r3 = r22
            goto L_0x03bf
        L_0x037f:
            java.lang.String r3 = "customlog"
            boolean r3 = r3.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x0393
            if (r5 == 0) goto L_0x037c
            r5 = r13
            r3 = r15
            r14 = r22
            r15 = r23
            r20 = 1
            goto L_0x0424
        L_0x0393:
            java.lang.String r3 = "customevent"
            boolean r3 = r3.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x03a7
            if (r5 == 0) goto L_0x037c
            r5 = r13
            r3 = r15
            r14 = r22
            r15 = r23
            r19 = 1
            goto L_0x0424
        L_0x03a7:
            r3 = r22
            boolean r14 = r3.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r14 == 0) goto L_0x03bf
            r2.remove(r3)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x03ba
            com.bonree.sdk.ae.a r5 = r1.w     // Catch:{ all -> 0x04e5 }
            r5.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x03bf
        L_0x03ba:
            com.bonree.sdk.ae.a r5 = r1.w     // Catch:{ all -> 0x04e5 }
            r5.c()     // Catch:{ all -> 0x04e5 }
        L_0x03bf:
            r24 = r3
        L_0x03c1:
            r22 = r15
            goto L_0x041d
        L_0x03c4:
            r29 = r3
            r3 = r22
            r22 = r24
            r13 = r25
            r7 = r26
            r6 = r27
        L_0x03d0:
            r2.remove(r4)     // Catch:{ all -> 0x04e5 }
            r2.remove(r6)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x0416
            com.bonree.sdk.ap.e r5 = r1.j     // Catch:{ all -> 0x04e5 }
            r24 = r3
            int r3 = r15.mThresholdValue     // Catch:{ all -> 0x04e5 }
            r5.b((int) r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ap.e r3 = r1.j     // Catch:{ all -> 0x04e5 }
            boolean r5 = r4.equals(r14)     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x0405
            java.lang.Integer r5 = r15.mDropFrameTime     // Catch:{ all -> 0x04e5 }
            if (r5 == 0) goto L_0x03fc
            java.lang.Integer r5 = r15.mDropFrameTime     // Catch:{ all -> 0x04e5 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x04e5 }
            if (r5 <= 0) goto L_0x03fc
            java.lang.Integer r5 = r15.mDropFrameTime     // Catch:{ all -> 0x04e5 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x04e5 }
            goto L_0x040d
        L_0x03fc:
            com.bonree.sdk.d.a r5 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            int r5 = r5.aa()     // Catch:{ all -> 0x04e5 }
            goto L_0x040d
        L_0x0405:
            com.bonree.sdk.d.a r5 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            int r5 = r5.aa()     // Catch:{ all -> 0x04e5 }
        L_0x040d:
            r3.c((int) r5)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ap.e r3 = r1.j     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x041d
        L_0x0416:
            r24 = r3
            com.bonree.sdk.ap.e r3 = r1.j     // Catch:{ all -> 0x04e5 }
            r3.c()     // Catch:{ all -> 0x04e5 }
        L_0x041d:
            r5 = r13
            r3 = r22
            r15 = r23
            r14 = r24
        L_0x0424:
            r13 = r4
            r4 = r6
            r6 = r7
            r7 = r29
            goto L_0x00c4
        L_0x042b:
            if (r17 == 0) goto L_0x0439
            java.lang.String r3 = r17.getSpeedInfo()     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x0439
            com.bonree.sdk.aw.a r3 = r1.t     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            goto L_0x043e
        L_0x0439:
            com.bonree.sdk.aw.a r3 = r1.t     // Catch:{ all -> 0x04e5 }
            r3.c()     // Catch:{ all -> 0x04e5 }
        L_0x043e:
            r3 = r19
            r4 = r20
            r5 = r21
            if (r3 != 0) goto L_0x0450
            if (r4 != 0) goto L_0x0450
            if (r5 != 0) goto L_0x0450
            com.bonree.sdk.al.b r3 = r1.u     // Catch:{ all -> 0x04e5 }
            r3.c()     // Catch:{ all -> 0x04e5 }
            goto L_0x0466
        L_0x0450:
            com.bonree.sdk.al.b r6 = r1.u     // Catch:{ all -> 0x04e5 }
            r6.c(r5)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.al.b r5 = r1.u     // Catch:{ all -> 0x04e5 }
            r5.b(r4)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.al.b r4 = r1.u     // Catch:{ all -> 0x04e5 }
            r4.a(r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.al.b r3 = r1.u     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            r18 = 0
        L_0x0466:
            if (r18 != 0) goto L_0x04c3
            com.bonree.sdk.am.g.k()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r3 = r1.d     // Catch:{ all -> 0x04e5 }
            java.lang.String r3 = r3.E()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.am.g.b((java.lang.String) r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.am.g r3 = com.bonree.sdk.am.g.k()     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ay.e r3 = r1.k     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.au.a r3 = r1.p     // Catch:{ all -> 0x04e5 }
            java.lang.String r4 = r0.mGetPingAddress     // Catch:{ all -> 0x04e5 }
            r3.b((java.lang.String) r4)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.au.a r3 = r1.p     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.az.b r3 = r1.n     // Catch:{ all -> 0x04e5 }
            r3.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ax.c r3 = com.bonree.sdk.ax.c.h()     // Catch:{ all -> 0x04e5 }
            int r0 = r0.mTraceThreshold     // Catch:{ all -> 0x04e5 }
            r3.b(r0)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ax.c r0 = com.bonree.sdk.ax.c.h()     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            java.util.Set r0 = r2.keySet()     // Catch:{ all -> 0x04e5 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x04e5 }
        L_0x04a9:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x04c1
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x04e5 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x04e5 }
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ad.a r3 = (com.bonree.sdk.ad.a) r3     // Catch:{ all -> 0x04e5 }
            if (r3 == 0) goto L_0x04a9
            r3.c()     // Catch:{ all -> 0x04e5 }
            goto L_0x04a9
        L_0x04c1:
            r0 = 1
            return r0
        L_0x04c3:
            com.bonree.sdk.am.g r0 = com.bonree.sdk.am.g.k()     // Catch:{ all -> 0x04e5 }
            r0.c()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ay.e r0 = r1.k     // Catch:{ all -> 0x04e5 }
            r0.c()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.au.a r0 = r1.p     // Catch:{ all -> 0x04e5 }
            r0.c()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.az.b r0 = r1.n     // Catch:{ all -> 0x04e5 }
            r0.c()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ax.c r0 = com.bonree.sdk.ax.c.h()     // Catch:{ all -> 0x04e5 }
            r0.c()     // Catch:{ all -> 0x04e5 }
            r2.clear()     // Catch:{ all -> 0x04e5 }
            r2 = 0
            return r2
        L_0x04e5:
            r0 = move-exception
            goto L_0x05eb
        L_0x04e8:
            if (r33 == 0) goto L_0x05f9
            com.bonree.sdk.d.a r0 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            java.lang.String[] r0 = r0.S()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e.a((java.lang.String[]) r0)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r0 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            boolean r0 = r0.H()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e.a((boolean) r0)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ar.e r0 = r1.g     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.af.a r0 = r1.h     // Catch:{ all -> 0x04e5 }
            int r2 = com.bonree.sdk.d.a.e     // Catch:{ all -> 0x04e5 }
            r0.b((int) r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.af.a r0 = r1.h     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ag.c r0 = r1.o     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r0 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            java.lang.String[] r0 = r0.S()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.bb.k.a((java.lang.String[]) r0)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.bb.k r0 = r1.l     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ba.p r0 = r1.i     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            r2 = 2000(0x7d0, float:2.803E-42)
            r0.b(r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ba.p r0 = r1.i     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.aq.h r0 = r1.q     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r3 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            boolean r3 = r3.I()     // Catch:{ all -> 0x04e5 }
            r0.b((boolean) r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.aq.h r0 = r1.q     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            r3 = 5000(0x1388, float:7.006E-42)
            r0.b((int) r3)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.aq.h r0 = r1.q     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            r0.c((int) r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.aq.h r0 = r1.q     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ap.e r0 = r1.j     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r2 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            r2.getClass()     // Catch:{ all -> 0x04e5 }
            r2 = 40
            r0.b((int) r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ap.e r0 = r1.j     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r2 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            int r2 = r2.aa()     // Catch:{ all -> 0x04e5 }
            r0.c((int) r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ap.e r0 = r1.j     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r2 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            r2.getClass()     // Catch:{ all -> 0x04e5 }
            r2 = 5
            r0.d(r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ap.e r0 = r1.j     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.at.c r0 = r1.m     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.as.a r0 = r1.v     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.am.g.k()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a r0 = r1.d     // Catch:{ all -> 0x04e5 }
            java.lang.String r0 = r0.E()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.am.g.b((java.lang.String) r0)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.am.g r0 = com.bonree.sdk.am.g.k()     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ay.e r0 = r1.k     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.au.a r0 = r1.p     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ac.c r0 = r1.r     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.az.b r0 = r1.n     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.aw.a r0 = r1.t     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.al.b r0 = r1.u     // Catch:{ all -> 0x04e5 }
            r2 = 1
            r0.a(r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.al.b r0 = r1.u     // Catch:{ all -> 0x04e5 }
            r0.b(r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.al.b r0 = r1.u     // Catch:{ all -> 0x04e5 }
            r0.c(r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.al.b r0 = r1.u     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ax.c r0 = com.bonree.sdk.ax.c.h()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x04e5 }
            r2 = 20
            r0.b(r2)     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ax.c r0 = com.bonree.sdk.ax.c.h()     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            com.bonree.sdk.ae.a r0 = r1.w     // Catch:{ all -> 0x04e5 }
            r0.b()     // Catch:{ all -> 0x04e5 }
            r0 = 1
            return r0
        L_0x05eb:
            com.bonree.sdk.be.f r2 = r1.a
            java.lang.String r3 = "service start error: "
            r2.a((java.lang.String) r3, (java.lang.Throwable) r0)
            com.bonree.sdk.be.f r2 = com.bonree.sdk.d.a.a
            r2.a((java.lang.String) r3, (java.lang.Throwable) r0)
            r2 = 0
            return r2
        L_0x05f9:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.d.e.a(com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean, boolean):boolean");
    }

    private Map<String, com.bonree.sdk.ad.a> G() {
        HashMap hashMap = new HashMap();
        hashMap.put(BaseEventInfo.EVENT_TYPE_NETWORK, this.g);
        hashMap.put("crash", this.h);
        hashMap.put(BaseEventInfo.EVENT_TYPE_H5, this.l);
        hashMap.put(BaseEventInfo.EVENT_TYPE_VIEW, this.i);
        hashMap.put("coollaunch", this.q);
        hashMap.put("action", this.r);
        hashMap.put(BaseEventInfo.EVENT_TYPE_STATECHANGE, this.m);
        hashMap.put(BaseEventInfo.EVENT_TYPE_ANR, this.o);
        hashMap.put("lagfps", this.j);
        hashMap.put(BaseEventInfo.EVENT_TYPE_LAG, this.j);
        hashMap.put(BaseEventInfo.EVENT_TYPE_ROUTE_CHANGE, this.v);
        hashMap.put(BaseEventInfo.EVENT_TYPE_BATTERY, this.w);
        return hashMap;
    }

    private void H() {
        com.bonree.sdk.ar.e.a(a.k().S());
        com.bonree.sdk.ar.e.a(a.k().H());
        this.g.b();
        this.h.b(a.e);
        this.h.b();
        this.o.b();
        k.a(a.k().S());
        this.l.b();
        p pVar = this.i;
        a.k();
        pVar.b(2000);
        this.i.b();
        this.q.b(a.k().I());
        h hVar = this.q;
        a.k();
        hVar.b(5000);
        h hVar2 = this.q;
        a.k();
        hVar2.c(2000);
        this.q.b();
        com.bonree.sdk.ap.e eVar = this.j;
        a.k().getClass();
        eVar.b(40);
        this.j.c(a.k().aa());
        com.bonree.sdk.ap.e eVar2 = this.j;
        a.k().getClass();
        eVar2.d(5);
        this.j.b();
        this.m.b();
        this.v.b();
        g.k();
        g.b(this.d.E());
        g.k().b();
        this.k.b();
        this.p.b();
        this.r.b();
        this.n.b();
        this.t.b();
        this.u.a(true);
        this.u.b(true);
        this.u.c(true);
        this.u.b();
        com.bonree.sdk.ax.c h2 = com.bonree.sdk.ax.c.h();
        a.k();
        h2.b(20);
        com.bonree.sdk.ax.c.h().b();
        this.w.b();
    }

    private boolean a(boolean z, int i2) {
        if (i2 <= 0) {
            this.a.d("rate is %d, out of range 0-100, result false;", Integer.valueOf(i2));
            return false;
        } else if (z) {
            return true;
        } else {
            int nextInt = new Random().nextInt(100) + 1;
            boolean z2 = nextInt <= i2;
            this.a.c("rate is %d , random number is %d , result %b.", Integer.valueOf(i2), Integer.valueOf(nextInt), Boolean.valueOf(z2));
            return z2;
        }
    }

    public final com.bonree.sdk.ac.c i() {
        return this.r;
    }

    public final com.bonree.sdk.ar.e j() {
        return this.g;
    }

    public final com.bonree.sdk.ag.c k() {
        return this.o;
    }

    public final k l() {
        return this.l;
    }

    public final com.bonree.sdk.au.a m() {
        return this.p;
    }

    public final com.bonree.sdk.ap.e n() {
        return this.j;
    }

    public final p o() {
        return this.i;
    }

    public final com.bonree.sdk.al.b p() {
        return this.u;
    }

    public final com.bonree.sdk.ay.e q() {
        return this.k;
    }

    public final h r() {
        return this.q;
    }

    private static List<String> I() {
        if (b.a.c != null) {
            return b.a.c.f();
        }
        return null;
    }

    private static boolean a(String str) {
        try {
            if (b.a.c != null) {
                return b.a.c.a(str);
            }
            return false;
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().a("valid actvitity exception : ", th);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void s() {
        this.f.c();
    }

    public final HandlerThread t() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    public final synchronized void u() {
        a.d.lock();
        try {
            a.a.a("ST SDK");
            if (this.d == null) {
                a.d.unlock();
                return;
            }
            this.a.c("Exit Bonree agent, release resource ...", new Object[0]);
            a.f = a.c.c;
            this.u.c();
            this.o.c();
            this.l.c();
            this.m.c();
            this.n.c();
            g.k().c();
            this.k.c();
            this.h.c();
            this.i.c();
            this.j.c();
            this.q.c();
            this.p.c();
            this.g.c();
            this.r.c();
            this.t.c();
            this.s.c();
            this.v.c();
            this.w.c();
            com.bonree.sdk.ax.c.h().c();
            com.bonree.sdk.b.a aVar = this.f;
            com.bonree.sdk.agent.engine.state.f.getEngine().unRegisterService((i) aVar);
            if (!(aVar.a == null || aVar.a.w() == null)) {
                aVar.a.w().removeCallbacksAndMessages((Object) null);
            }
            d.a().unRegisterService(aVar);
            NativeCrashEngine.getInstance().unRegisterService(aVar);
            if (aVar.a.o != null) {
                aVar.a.o.b((c.a) aVar);
            }
            aVar.b.c("SDKComm stopped...", new Object[0]);
            this.e.b();
            com.bonree.sdk.ad.d.a().b();
            a.d.unlock();
        } catch (Throwable th) {
            a.d.unlock();
            throw th;
        }
    }

    public static boolean v() {
        return a.f == a.c.c;
    }

    public final void a() {
        if (w() != null) {
            w().sendEmptyMessage(10);
        }
    }

    public final Handler w() {
        c cVar = this.e;
        if (cVar != null) {
            return cVar.d();
        }
        return null;
    }

    public final boolean x() {
        com.bonree.sdk.a.a aVar = this.c;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    public final String b() {
        com.bonree.sdk.a.a aVar = this.c;
        if (aVar == null) {
            return null;
        }
        String b2 = aVar.b();
        if (!TextUtils.isEmpty(b2)) {
            return b2;
        }
        return null;
    }

    public final Context c() {
        try {
            Context context = this.b;
            if (context == null) {
                return com.bonree.sdk.bs.a.a();
            }
            if (!(context instanceof Application)) {
                this.b = context.getApplicationContext();
            }
            return this.b;
        } catch (Throwable unused) {
        }
    }

    public final com.bonree.sdk.b.a y() {
        return this.f;
    }

    public final a z() {
        return this.d;
    }

    private static int J() {
        return a.f;
    }

    static class b {
        /* access modifiers changed from: private */
        public static final e a = new e((byte) 0);

        private b() {
        }
    }

    class a extends com.bonree.sdk.bs.f {
        a(String str) {
            super(str);
        }

        public final void run() {
            e.this.a.d("Bye...", new Object[0]);
            if (!e.v()) {
                if (e.this.i != null) {
                    new com.bonree.sdk.bs.c(3000, new g(this)).a();
                }
                e.this.u();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A[SYNTHETIC, Splitter:B:17:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean e() {
        /*
            r9 = this;
            java.lang.String r0 = "crash safe guard! Bonree agent exit!"
            com.bonree.sdk.af.a r1 = r9.h
            com.bonree.sdk.aj.a r1 = r1.i()
            boolean r2 = r1.a
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x005d
            java.lang.String r2 = r1.c
            boolean r2 = com.bonree.sdk.bs.ad.a((java.lang.String) r2)
            if (r2 != 0) goto L_0x0058
            java.lang.String r2 = r1.c
            com.bonree.sdk.a.a r6 = r9.c
            java.lang.String r6 = r6.b()
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0058
            java.lang.String r2 = r1.b
            boolean r2 = com.bonree.sdk.bs.ad.a((java.lang.String) r2)
            if (r2 != 0) goto L_0x0058
            java.lang.String r2 = r1.b
            java.lang.String r6 = com.bonree.sdk.agent.Agent.getAgentVersion()
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0058
            java.lang.String r2 = r1.e
            boolean r2 = com.bonree.sdk.bs.ad.a((java.lang.String) r2)
            if (r2 != 0) goto L_0x0056
            com.bonree.sdk.be.f r2 = r9.a
            java.lang.Object[] r6 = new java.lang.Object[r3]
            long r7 = r1.d
            java.lang.Long r7 = java.lang.Long.valueOf(r7)
            r6[r5] = r7
            java.lang.String r1 = r1.e
            r6[r4] = r1
            java.lang.String r1 = "crashSafeGuard  self crash time: %s crash causeby: %s"
            r2.c(r1, r6)
        L_0x0056:
            r1 = r4
            goto L_0x005e
        L_0x0058:
            com.bonree.sdk.af.a r1 = r9.h
            r1.j()
        L_0x005d:
            r1 = r5
        L_0x005e:
            if (r1 == 0) goto L_0x007b
            com.bonree.sdk.be.f r1 = com.bonree.sdk.d.a.a     // Catch:{ all -> 0x0077 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x0077 }
            r1.e(r0, r2)     // Catch:{ all -> 0x0077 }
            com.bonree.sdk.be.f r1 = r9.a     // Catch:{ all -> 0x0077 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x0077 }
            r1.d(r0, r2)     // Catch:{ all -> 0x0077 }
            com.bonree.sdk.b.a r0 = r9.f     // Catch:{ all -> 0x0077 }
            com.bonree.sdk.f.d r0 = r0.b()     // Catch:{ all -> 0x0077 }
            r0.a((boolean) r4)     // Catch:{ all -> 0x0077 }
        L_0x0077:
            com.bonree.sdk.agent.Bonree.stopSDK()
            return r4
        L_0x007b:
            com.bonree.sdk.be.f r0 = r9.a
            java.lang.Object[] r1 = new java.lang.Object[r4]
            java.lang.String r2 = com.bonree.sdk.bs.ad.a()
            r1[r5] = r2
            java.lang.String r2 = "Bonree Agent startServices: %s"
            r0.c(r2, r1)
            com.bonree.sdk.d.a r0 = com.bonree.sdk.d.a.k()
            com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean r0 = r0.m()
            boolean r0 = r9.a((com.bonree.sdk.agent.business.entity.transfer.ConfigResponseBean) r0, (boolean) r4)
            if (r0 != 0) goto L_0x009d
            com.bonree.sdk.agent.Bonree.stopSDK()
            r0 = r5
            goto L_0x00ac
        L_0x009d:
            com.bonree.sdk.be.f r0 = r9.a
            java.lang.Object[] r1 = new java.lang.Object[r5]
            java.lang.String r2 = "All services start successful!"
            r0.c(r2, r1)
            com.bonree.sdk.b.a r0 = r9.f
            boolean r0 = r0.c()
        L_0x00ac:
            if (r0 == 0) goto L_0x00b2
            int r1 = com.bonree.sdk.d.a.c.b
            com.bonree.sdk.d.a.f = r1
        L_0x00b2:
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()
            com.bonree.sdk.d.e$a r2 = new com.bonree.sdk.d.e$a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "JVMShutDown_"
            r6.<init>(r7)
            int r7 = android.os.Process.myPid()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r2.<init>(r6)
            r1.addShutdownHook(r2)
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = com.bonree.sdk.agent.Agent.getAgentVersion()
            r1[r5] = r2
            java.lang.String r2 = com.bonree.sdk.agent.Agent.getClassRewriterVersion()
            r1[r4] = r2
            java.lang.String r2 = com.bonree.sdk.agent.Agent.RELEASE_DATE
            r1[r3] = r2
            java.lang.String r2 = "BRAgent v{0}, BRCRewriter v{1}, ReleaseDate {2}"
            java.lang.String r1 = java.text.MessageFormat.format(r2, r1)
            com.bonree.sdk.be.f r2 = com.bonree.sdk.d.a.a
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r2.c(r1, r3)
            com.bonree.sdk.be.f r2 = r9.a
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r2.c(r1, r3)
            com.bonree.sdk.be.f r1 = r9.a
            java.lang.Object[] r2 = new java.lang.Object[r4]
            com.bonree.sdk.d.a r3 = r9.d
            java.lang.String r3 = r3.v()
            r2[r5] = r3
            java.lang.String r3 = "Application AppID: {0}"
            java.lang.String r2 = java.text.MessageFormat.format(r3, r2)
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r1.c(r2, r3)
            if (r0 != 0) goto L_0x0111
            return r4
        L_0x0111:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.d.e.e():boolean");
    }
}
