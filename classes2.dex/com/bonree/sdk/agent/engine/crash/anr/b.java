package com.bonree.sdk.agent.engine.crash.anr;

import android.os.FileObserver;
import com.bonree.sdk.be.a;

final class b extends FileObserver {
    private /* synthetic */ AnrEngine a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    b(AnrEngine anrEngine, String str, int i) {
        super(str, 8);
        this.a = anrEngine;
    }

    public final void onEvent(int i, String str) {
        a.a().c("happen anr type is FileObserver path is %s ", str);
        if (str != null) {
            String str2 = "/data/anr/" + str;
            if (str2.contains("trace")) {
                com.bonree.sdk.ah.a aVar = new com.bonree.sdk.ah.a();
                aVar.a((byte) 1);
                aVar.b(str2);
                this.a.a(aVar);
                this.a.notifyService(aVar);
            }
        }
    }
}
