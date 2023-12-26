package com.bonree.sdk.agent.engine.crash.anr;

import com.bonree.sdk.ag.a;
import com.bonree.sdk.agent.engine.crash.anr.d;

final class c implements d.b {
    private /* synthetic */ AnrEngine a;

    c(AnrEngine anrEngine) {
        this.a = anrEngine;
    }

    public final void a(a aVar) {
        com.bonree.sdk.be.a.a().c("happen anr type is WatchDog, AnrError is %s", aVar.toString());
        if (aVar != null) {
            com.bonree.sdk.ah.a aVar2 = new com.bonree.sdk.ah.a();
            aVar2.a((byte) 2);
            aVar2.a(aVar);
            this.a.a(aVar2);
            this.a.notifyService(aVar2);
        }
    }
}
