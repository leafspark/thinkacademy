package com.bonree.sdk.ag;

import com.bonree.sdk.agent.engine.crash.anr.AnrEngine;
import com.bonree.sdk.ah.a;
import com.bonree.sdk.bs.c;

final class d implements c.a {
    private /* synthetic */ a a;
    private /* synthetic */ c b;

    d(c cVar, a aVar) {
        this.b = cVar;
        this.a = aVar;
    }

    public final Object a() {
        c.a(this.b, this.a.b());
        this.b.a("fileobserver", this.a.b());
        AnrEngine.getEngine().stopFileObserver();
        return null;
    }
}
