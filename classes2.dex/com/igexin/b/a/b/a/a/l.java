package com.igexin.b.a.b.a.a;

import android.text.TextUtils;
import com.igexin.b.a.b.a.a.a.b;
import com.igexin.b.a.b.d;

public final class l extends a {
    private b K;
    private byte[] L;
    o h;
    com.igexin.b.a.b.b i;

    public l(o oVar, com.igexin.b.a.b.b bVar) {
        super(-2035, (String) null, bVar);
        this.i = bVar;
        this.h = oVar;
    }

    public void a(b bVar) {
        this.K = bVar;
    }

    public void b() {
        super.b();
        Thread currentThread = Thread.currentThread();
        com.igexin.b.a.c.b.a("GS-R|" + currentThread + " running", new Object[0]);
        while (this.g && !currentThread.isInterrupted() && !this.d) {
            try {
                this.i.c((d) null, this.h);
                this.e = b.NORMAL;
            } catch (Throwable th) {
                this.g = false;
                if (this.e != b.INTERRUPT) {
                    this.e = b.EXCEPTION;
                    this.f = (th.getMessage() == null || !th.getMessage().equals("read = -1, end of stream !")) ? th.toString() : "end of stream";
                }
            }
        }
        this.d = true;
        com.igexin.b.a.c.b.a("GS-R|finish ~~~~~~", new Object[0]);
    }

    public final int b_() {
        return -2035;
    }

    public void f() {
        super.f();
        com.igexin.b.a.c.b.a("GS-R|rt dispose", new Object[0]);
        if (this.K != null) {
            if (this.e != b.EXCEPTION) {
                this.K.a(this);
            } else if (!TextUtils.isEmpty(this.f)) {
                this.K.a(new Exception(this.f));
            }
        }
        if (this.L != null) {
            this.L = null;
        }
        this.K = null;
    }

    public void j() {
        this.g = false;
        this.e = b.INTERRUPT;
    }
}
