package com.bonree.sdk.ab;

import com.bonree.sdk.agent.business.entity.NetworkEventInfoBean;
import com.bonree.sdk.d.a;

public final class b {
    private NetworkEventInfoBean a;
    private long b = a.b();
    private int c;

    public b(NetworkEventInfoBean networkEventInfoBean, int i) {
        this.a = networkEventInfoBean;
        this.c = i;
    }

    public final NetworkEventInfoBean a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }
}
