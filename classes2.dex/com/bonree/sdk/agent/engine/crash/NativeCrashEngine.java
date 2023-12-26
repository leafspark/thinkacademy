package com.bonree.sdk.agent.engine.crash;

import android.os.Build;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.ah.c;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.s;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeCrashEngine extends com.bonree.sdk.g.a<c, c> {
    private final AtomicBoolean a;
    private final f b;

    private static native String getVersion();

    public static native int nativeCrashInit(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, String[] strArr, boolean z8);

    public static native void stopCaughtCrash();

    /* synthetic */ NativeCrashEngine(byte b2) {
        this();
    }

    static class a {
        /* access modifiers changed from: private */
        public static final NativeCrashEngine a = new NativeCrashEngine((byte) 0);

        private a() {
        }
    }

    public static NativeCrashEngine getInstance() {
        return a.a;
    }

    private NativeCrashEngine() {
        this.a = new AtomicBoolean(false);
        this.b = com.bonree.sdk.be.a.a();
    }

    public void initEngine(boolean z, String str) {
        if (ad.a(str)) {
            this.b.d("dumpBasePath is null!", new Object[0]);
        } else if (!com.bonree.sdk.d.a.L()) {
            boolean d = s.a().d();
            f fVar = this.b;
            fVar.c("load lib" + s.a + ".so is %b", Boolean.valueOf(d));
            if (d) {
                init(z, str);
            }
        }
    }

    public void registerService(c cVar) {
        super.registerService(cVar);
        this.a.compareAndSet(true, false);
    }

    /* access modifiers changed from: protected */
    public void stopEngine() {
        if (!this.a.get()) {
            if (s.a().b()) {
                stopCaughtCrash();
            }
            this.a.getAndSet(true);
            this.b.d("native crash engine stop!", new Object[0]);
        }
    }

    private static void init(boolean z, String str) {
        int i = Build.VERSION.SDK_INT;
        String str2 = Build.VERSION.RELEASE;
        String i2 = ad.i();
        String str3 = Build.MANUFACTURER;
        String str4 = Build.BRAND;
        String j = ad.j();
        String str5 = Build.FINGERPRINT;
        String v = com.bonree.sdk.d.a.k().v();
        String agentVersion = Agent.getAgentVersion();
        String str6 = com.bonree.sdk.bs.a.a().getApplicationInfo().nativeLibraryDir;
        nativeCrashInit(i, str2, i2, str3, str4, j, str5, v, agentVersion, str6, str, true, true, 100, 100, 100, true, true, false, false, true, 0, (String[]) null, z);
    }

    public String getBrCrashVersion() {
        if (!s.a().b()) {
            return "";
        }
        return getVersion();
    }

    private static void onNativeCrash(String str, int i, int i2, String str2) {
        if (!ad.a(str2)) {
            str2 = str2.trim();
            if (str2.endsWith("\n")) {
                str2 = str2.substring(0, str2.length() - 2);
            }
        }
        getInstance().notifyService(new c(str, i, i2, str2));
    }

    public void notifyService(c cVar) {
        if (cVar != null) {
            this.readWriteLock.readLock().lock();
            try {
                for (c cVar2 : this.services) {
                    if (cVar2 instanceof com.bonree.sdk.af.a) {
                        cVar2.a(cVar);
                    }
                }
                for (c cVar3 : this.services) {
                    if (!(cVar3 instanceof com.bonree.sdk.af.a)) {
                        cVar3.a(cVar);
                    }
                }
            } finally {
                this.readWriteLock.readLock().unlock();
            }
        }
    }
}
