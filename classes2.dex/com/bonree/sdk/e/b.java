package com.bonree.sdk.e;

import com.bonree.sdk.ad.d;
import com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.be.f;

public final class b {
    private volatile OnlineTrackingInfo a;
    private a b;
    private final String c = "BR-HeartbeatHandlerThread";
    private final f d = com.bonree.sdk.be.a.a();

    public final OnlineTrackingInfo a() {
        return this.a;
    }

    public final void a(e eVar, boolean z) {
        if (this.a != null) {
            if (z) {
                if (d.a().a("BR-HeartbeatHandlerThread", this.b)) {
                    a aVar = this.b;
                    aVar.getClass();
                    aVar.sendEmptyMessage(2);
                }
            } else if (eVar == e.BACKGROUND) {
                if (d.a().a("BR-HeartbeatHandlerThread", this.b)) {
                    this.b.removeCallbacksAndMessages((Object) null);
                }
            } else if (eVar == e.FOREGROUND && d.a().a("BR-HeartbeatHandlerThread", this.b)) {
                this.b.removeCallbacksAndMessages((Object) null);
                a aVar2 = this.b;
                aVar2.getClass();
                aVar2.sendEmptyMessage(1);
            }
        }
    }

    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0092, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bonree.sdk.be.f r0 = r8.d     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = "online start... "
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0093 }
            r0.c(r1, r3)     // Catch:{ all -> 0x0093 }
            if (r9 == 0) goto L_0x0091
            boolean r0 = r9.isInvalid()     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x0015
            goto L_0x0091
        L_0x0015:
            com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo r0 = r8.a     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x002b
            com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo r0 = r8.a     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r0.getTrackID()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = r9.getTrackID()     // Catch:{ all -> 0x0093 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x002b
            monitor-exit(r8)
            return
        L_0x002b:
            r8.a = r9     // Catch:{ all -> 0x0093 }
            com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo r9 = r8.a     // Catch:{ all -> 0x0093 }
            com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo r0 = r8.a     // Catch:{ all -> 0x0093 }
            long r0 = r0.getInstantCycleTimeUpload()     // Catch:{ all -> 0x0093 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0093 }
            r4 = 1
            long r6 = r3.toMillis(r4)     // Catch:{ all -> 0x0093 }
            long r0 = java.lang.Math.max(r0, r6)     // Catch:{ all -> 0x0093 }
            r9.setInstantCycleTimeUpload(r0)     // Catch:{ all -> 0x0093 }
            com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo r9 = r8.a     // Catch:{ all -> 0x0093 }
            com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo r0 = r8.a     // Catch:{ all -> 0x0093 }
            long r0 = r0.getHeartbeatTime()     // Catch:{ all -> 0x0093 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x0093 }
            long r3 = r3.toMillis(r4)     // Catch:{ all -> 0x0093 }
            long r0 = java.lang.Math.max(r0, r3)     // Catch:{ all -> 0x0093 }
            r9.setHeartbeatTime(r0)     // Catch:{ all -> 0x0093 }
            com.bonree.sdk.e.a r9 = new com.bonree.sdk.e.a     // Catch:{ all -> 0x0093 }
            com.bonree.sdk.ad.d r0 = com.bonree.sdk.ad.d.a()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = "BR-HeartbeatHandlerThread"
            android.os.Looper r0 = r0.a(r1)     // Catch:{ all -> 0x0093 }
            com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo r1 = r8.a     // Catch:{ all -> 0x0093 }
            r9.<init>((android.os.Looper) r0, (com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo) r1)     // Catch:{ all -> 0x0093 }
            r8.b = r9     // Catch:{ all -> 0x0093 }
            com.bonree.sdk.d.a r9 = com.bonree.sdk.d.a.k()     // Catch:{ all -> 0x0093 }
            boolean r9 = r9.J()     // Catch:{ all -> 0x0093 }
            if (r9 != 0) goto L_0x007f
            com.bonree.sdk.e.a r9 = r8.b     // Catch:{ all -> 0x0093 }
            r9.getClass()     // Catch:{ all -> 0x0093 }
            r0 = 1
            r9.sendEmptyMessage(r0)     // Catch:{ all -> 0x0093 }
        L_0x007f:
            com.bonree.sdk.ao.d r9 = com.bonree.sdk.ao.d.g()     // Catch:{ all -> 0x0093 }
            r9.b()     // Catch:{ all -> 0x0093 }
            com.bonree.sdk.be.f r9 = r8.d     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = "Online start successful... "
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x0093 }
            r9.c(r0, r1)     // Catch:{ all -> 0x0093 }
            monitor-exit(r8)
            return
        L_0x0091:
            monitor-exit(r8)
            return
        L_0x0093:
            r9 = move-exception
            com.bonree.sdk.be.f r0 = r8.d     // Catch:{ all -> 0x00a0 }
            java.lang.String r1 = "online start error... "
            r0.a((java.lang.String) r1, (java.lang.Throwable) r9)     // Catch:{ all -> 0x00a0 }
            r8.c()     // Catch:{ all -> 0x00a0 }
            monitor-exit(r8)
            return
        L_0x00a0:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.e.b.a(com.bonree.sdk.agent.business.entity.transfer.OnlineTrackingInfo):void");
    }

    public final synchronized void c() {
        this.d.c("online stop... ", new Object[0]);
        this.a = null;
        a aVar = this.b;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages((Object) null);
        }
        com.bonree.sdk.ao.d.g().c();
        d.a().b("BR-HeartbeatHandlerThread");
        this.d.c("online stop successful... ", new Object[0]);
    }
}
