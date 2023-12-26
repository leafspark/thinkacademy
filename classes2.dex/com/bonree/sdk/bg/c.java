package com.bonree.sdk.bg;

import com.bonree.sdk.bf.d;
import com.bonree.sdk.bj.a;
import com.bonree.sdk.bl.b;
import java.util.LinkedHashMap;

public class c extends d {
    protected LinkedHashMap<a, com.bonree.sdk.bl.a> a;
    private long b;
    private long c;
    private long d;
    private int e;
    private long f;

    public void a(a aVar, com.bonree.sdk.bl.c cVar, com.bonree.sdk.bk.a aVar2) {
    }

    public c(int i, long j) {
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = i;
        this.f = j;
        this.a = new d(this, Math.min(((i + 3) / 4) + i + 2, 11), 0.75f, true, i);
    }

    public c(int i) {
        this(i, Long.MAX_VALUE);
    }

    public c() {
        this(512);
    }

    /* access modifiers changed from: protected */
    public synchronized void b(a aVar, com.bonree.sdk.bl.c cVar) {
        if (cVar.a.o > 0) {
            this.a.put(aVar, new b(aVar, cVar));
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized com.bonree.sdk.bl.a b(a aVar) {
        com.bonree.sdk.bl.a aVar2 = this.a.get(aVar);
        if (aVar2 == null) {
            this.b++;
            return null;
        }
        a aVar3 = aVar2.a;
        if (aVar3.o + (Math.min(aVar3.c(), this.f) * 1000) < System.currentTimeMillis()) {
            this.b++;
            this.c++;
            this.a.remove(aVar);
            return null;
        }
        this.d++;
        return aVar2;
    }

    private synchronized void a() {
        this.a.clear();
        this.b = 0;
        this.d = 0;
        this.c = 0;
    }

    private long b() {
        return this.b;
    }

    private long c() {
        return this.c;
    }

    private long d() {
        return this.d;
    }

    public String toString() {
        return "LRUCache{usage=" + this.a.size() + "/" + this.e + ", hits=" + this.d + ", misses=" + this.b + ", expires=" + this.c + "}";
    }
}
