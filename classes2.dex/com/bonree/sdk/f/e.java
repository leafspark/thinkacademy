package com.bonree.sdk.f;

final class e implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ c b;
    private /* synthetic */ d c;

    e(d dVar, String str, c cVar) {
        this.c = dVar;
        this.a = str;
        this.b = cVar;
    }

    public final void run() {
        this.c.a(this.a, this.b);
    }
}
