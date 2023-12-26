package com.igexin.b.a.b;

import com.igexin.b.a.d.e;

public abstract class d extends e {
    public String a;
    public b b;
    public Object c;
    private final String d;

    public d(int i, String str, b bVar) {
        super(i);
        this.d = getClass().getName();
        if (str != null) {
            this.a = a(str);
        }
        this.b = bVar;
    }

    public d(String str, b bVar) {
        this(0, str, bVar);
    }

    private String a(String str) {
        return e.a(e.a(str));
    }

    public void f() {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(false);
        }
        this.a = null;
        super.f();
    }
}
