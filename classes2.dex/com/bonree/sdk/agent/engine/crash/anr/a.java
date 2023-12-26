package com.bonree.sdk.agent.engine.crash.anr;

import android.os.Build;
import com.bonree.sdk.agent.Agent;
import com.bonree.sdk.bs.ad;

final class a implements Runnable {
    a() {
    }

    public final void run() {
        try {
            int i = Build.VERSION.SDK_INT;
            String str = Build.VERSION.RELEASE;
            String i2 = ad.i();
            String str2 = Build.MANUFACTURER;
            String str3 = Build.BRAND;
            String j = ad.j();
            String str4 = Build.FINGERPRINT;
            String v = com.bonree.sdk.d.a.k().v();
            String agentVersion = Agent.getAgentVersion();
            String str5 = com.bonree.sdk.bs.a.a().getApplicationInfo().nativeLibraryDir;
            AnrEngine.anrInit(i, str, i2, str2, str3, j, str4, v, agentVersion, str5, com.bonree.sdk.bs.a.a().getFilesDir().getAbsolutePath() + "/brcrash/nativecrashs", true, true, 100, 100, 100, false, false, false);
        } catch (Exception e) {
            com.bonree.sdk.be.a.a().a("AnrEngine initNativeAnrObserver error : ", (Throwable) e);
        }
    }
}
