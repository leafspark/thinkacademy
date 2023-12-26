package com.bonree.sdk.bc;

final class cc extends Thread {
    private bb a;
    private Object b;
    private cf c;
    private cd d;

    public cc(cd cdVar, bb bbVar, Object obj, cf cfVar) {
        this.d = cdVar;
        this.a = bbVar;
        this.b = obj;
        this.c = cfVar;
    }

    public final void run() {
        try {
            this.c.a(this.d.a(this.a));
        } catch (Exception e) {
            this.c.a(this.b, e);
        }
    }
}
