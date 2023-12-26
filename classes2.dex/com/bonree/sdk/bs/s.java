package com.bonree.sdk.bs;

import com.bonree.sdk.agent.engine.crash.NativeCrashEngine;
import com.bonree.sdk.be.f;
import java.util.concurrent.atomic.AtomicBoolean;

public final class s {
    public static String a = "brcrash";
    private static String d = "bronlinetracking";
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicBoolean c = new AtomicBoolean(false);
    private f e = com.bonree.sdk.be.a.a();

    static class a {
        /* access modifiers changed from: private */
        public static final s a = new s();

        private a() {
        }
    }

    public static s a() {
        return a.a;
    }

    s() {
    }

    public final boolean b() {
        return this.b.get();
    }

    public final boolean c() {
        return this.c.get();
    }

    public final synchronized boolean d() {
        boolean a2;
        a2 = a(a, this.b);
        f fVar = com.bonree.sdk.d.a.a;
        fVar.c("BRAgent Native v" + NativeCrashEngine.getInstance().getBrCrashVersion(), new Object[0]);
        return a2;
    }

    public final synchronized boolean e() {
        return a(d, this.c);
    }

    private synchronized boolean a(String str, AtomicBoolean atomicBoolean) {
        if (!atomicBoolean.get()) {
            atomicBoolean.compareAndSet(false, a(str));
        }
        return atomicBoolean.get();
    }

    private boolean a(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            f fVar = this.e;
            fVar.a("load lib" + str + ".so error", th);
            com.bonree.sdk.d.a.a.e("Load lib error: %s", th.toString());
            return false;
        }
    }
}
