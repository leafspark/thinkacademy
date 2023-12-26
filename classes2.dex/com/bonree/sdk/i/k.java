package com.bonree.sdk.i;

import com.bonree.sdk.be.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class k {
    private static final String c = "BRSDK.ServiceHooker";
    protected List<a> a = new ArrayList();
    protected l b;
    private boolean d;
    private f e = com.bonree.sdk.be.a.a();

    public interface a {
    }

    /* access modifiers changed from: protected */
    public abstract void a(Method method, Object[] objArr);

    public final void a(l lVar) {
        this.b = lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.bonree.sdk.i.k.a r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            java.util.List<com.bonree.sdk.i.k$a> r0 = r3.a     // Catch:{ all -> 0x0041 }
            boolean r0 = r0.contains(r4)     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r3)
            return
        L_0x000f:
            java.util.List<com.bonree.sdk.i.k$a> r0 = r3.a     // Catch:{ all -> 0x0041 }
            r0.add(r4)     // Catch:{ all -> 0x0041 }
            boolean r4 = r3.d     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.util.List<com.bonree.sdk.i.k$a> r4 = r3.a     // Catch:{ all -> 0x0041 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            com.bonree.sdk.i.l r4 = r3.b     // Catch:{ all -> 0x0041 }
            boolean r4 = r4.a()     // Catch:{ all -> 0x0041 }
            com.bonree.sdk.be.f r0 = r3.e     // Catch:{ all -> 0x0041 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = "BRSDK.ServiceHooker checkHook hookRet:"
            r1.<init>(r2)     // Catch:{ all -> 0x0041 }
            r1.append(r4)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0041 }
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0041 }
            r0.c(r4, r1)     // Catch:{ all -> 0x0041 }
            r4 = 1
            r3.d = r4     // Catch:{ all -> 0x0041 }
        L_0x003f:
            monitor-exit(r3)
            return
        L_0x0041:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.i.k.a(com.bonree.sdk.i.k$a):void");
    }

    public final synchronized void b(a aVar) {
        if (aVar != null) {
            this.a.remove(aVar);
            c();
        }
    }

    private synchronized void a() {
        this.a.clear();
        c();
    }

    private void b() {
        if (!this.d && !this.a.isEmpty()) {
            boolean a2 = this.b.a();
            f fVar = this.e;
            fVar.c("BRSDK.ServiceHooker checkHook hookRet:" + a2, new Object[0]);
            this.d = true;
        }
    }

    private void c() {
        if (this.d && this.a.isEmpty()) {
            boolean b2 = this.b.b();
            f fVar = this.e;
            fVar.c("BRSDK.ServiceHooker checkUnHook unHookRet:" + b2, new Object[0]);
            this.d = false;
        }
    }
}
