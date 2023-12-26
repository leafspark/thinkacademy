package com.igexin.b.a.d;

import com.igexin.b.a.d.a.f;
import java.util.concurrent.TimeUnit;

public abstract class b implements f {
    protected boolean a = true;

    public void a() {
        this.a = false;
    }

    public boolean a(long j, e eVar) {
        return TimeUnit.SECONDS.toMillis((long) eVar.x) < j - eVar.v;
    }

    public long b(long j, e eVar) {
        return (TimeUnit.SECONDS.toMillis((long) eVar.x) + eVar.v) - j;
    }
}
