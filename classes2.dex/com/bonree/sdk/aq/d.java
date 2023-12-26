package com.bonree.sdk.aq;

import com.bonree.sdk.d.a;

final class d implements Runnable {
    private /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        boolean unused = this.a.p = false;
        this.a.d(a.b());
    }
}
