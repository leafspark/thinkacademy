package com.bonree.sdk.am;

import com.bonree.sdk.d.a;
import java.util.TimerTask;

final class h extends TimerTask {
    private /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        if (!a.k().J()) {
            if (this.a.i != null) {
                this.a.i.h();
            } else if (a.L()) {
                i unused = this.a.i = new m();
            } else {
                i unused2 = this.a.i = new b();
            }
            g.b(this.a);
        }
    }
}
