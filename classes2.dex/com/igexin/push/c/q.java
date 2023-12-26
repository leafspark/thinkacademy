package com.igexin.push.c;

class q implements Runnable {
    final /* synthetic */ o a;

    q(o oVar) {
        this.a = oVar;
    }

    public void run() {
        try {
            this.a.p();
        } catch (Exception unused) {
        }
    }
}
