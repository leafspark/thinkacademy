package com.bonree.sdk.agent.engine.state;

import android.net.ConnectivityManager;
import android.net.Network;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;

final class c extends ConnectivityManager.NetworkCallback {
    private /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void onAvailable(Network network) {
        super.onAvailable(network);
        if (!this.a.f) {
            f a2 = a.a();
            a2.c("StateEngine- onAvailable fastNetInfo:" + this.a.f, new Object[0]);
            this.a.a(network);
        }
        boolean unused = this.a.f = false;
    }

    public final void onLost(Network network) {
        super.onLost(network);
        f a2 = a.a();
        a2.c("StateEngine- onLost fastNetInfo:" + this.a.f, new Object[0]);
        this.a.a(network);
        boolean unused = this.a.f = false;
    }
}
