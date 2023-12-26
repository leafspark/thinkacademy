package com.bonree.sdk.r;

import java.util.ArrayList;
import java.util.List;

public final class c {
    private boolean a = false;
    private ArrayList<b> b = new ArrayList<>();

    public final boolean a() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public final void a(b bVar) {
        synchronized (this.b) {
            this.b.add(bVar);
        }
    }

    public final void b(b bVar) {
        synchronized (this.b) {
            this.b.remove(bVar);
        }
    }

    public final void a(a aVar) {
        if (!b()) {
            for (b a2 : c()) {
                a2.a(aVar);
            }
        }
    }

    public final void b(a aVar) {
        if (!b()) {
            for (b b2 : c()) {
                b2.b(aVar);
            }
        }
    }

    private boolean b() {
        boolean a2;
        synchronized (this) {
            a2 = a();
            if (!a2) {
                this.a = true;
            }
        }
        return a2;
    }

    private List<b> c() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.b);
            this.b.clear();
        }
        return arrayList;
    }
}
