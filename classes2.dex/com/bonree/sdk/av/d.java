package com.bonree.sdk.av;

final class d implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ String b;
    private /* synthetic */ c c;

    d(c cVar, String str, String str2) {
        this.c = cVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        c cVar = this.c;
        c.a(cVar, this.a, this.b, cVar.j);
    }
}
