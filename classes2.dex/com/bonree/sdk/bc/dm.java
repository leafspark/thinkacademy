package com.bonree.sdk.bc;

import com.bonree.sdk.bc.w;
import java.io.IOException;
import java.util.Iterator;

public final class dm extends bb {
    private bn d;
    private int e;

    private dm(bn bnVar, int i) {
        if (bnVar.b()) {
            p.a(1);
            a().c(5);
            a(ca.a(bnVar, 6, 1), 0);
            this.d = bnVar;
            this.e = 1;
            return;
        }
        throw new w.d(bnVar);
    }

    public dm(bn bnVar) {
        this(bnVar, 1);
    }

    private void b(ca caVar) {
        a(caVar, 1);
    }

    private void c(ca caVar) {
        a(caVar, 2);
    }

    private void a(bn bnVar) {
        a(ca.a(bnVar, 255, 255, 0), 1);
    }

    private void a(bn bnVar, int i) {
        a(ca.a(bnVar, i, 255, 0), 1);
    }

    private void a(bn bnVar, int i, String str) throws IOException {
        a(ca.a(bnVar, i, this.e, 0, str, this.d), 1);
    }

    private void a(bn bnVar, int i, dd ddVar) throws IOException {
        a(ca.a(bnVar, i, this.e, 0, ddVar, this.d), 1);
    }

    private void b(bn bnVar) {
        a(ca.a(bnVar, 255, 254, 0), 1);
    }

    private void b(bn bnVar, int i) {
        a(ca.a(bnVar, i, 254, 0), 1);
    }

    private void a(bn bnVar, int i, long j, String str) throws IOException {
        a(ca.a(bnVar, i, this.e, j, str, this.d), 2);
    }

    private void a(bn bnVar, int i, long j, dd ddVar) throws IOException {
        a(ca.a(bnVar, i, this.e, j, ddVar, this.d), 2);
    }

    private void a(ca[] caVarArr) {
        for (ca e2 : caVarArr) {
            e(e2);
        }
    }

    private void a(bx bxVar) {
        Iterator c = bxVar.c();
        while (c.hasNext()) {
            e((ca) c.next());
        }
    }

    private void c(bn bnVar) {
        a(ca.a(bnVar, 255, 255, 0), 2);
    }

    private void c(bn bnVar, int i) {
        a(ca.a(bnVar, i, 255, 0), 2);
    }

    private void b(bn bnVar, int i, String str) throws IOException {
        a(ca.a(bnVar, i, 254, 0, str, this.d), 2);
    }

    private void b(bn bnVar, int i, dd ddVar) throws IOException {
        a(ca.a(bnVar, i, 254, 0, ddVar, this.d), 2);
    }

    private void f(ca caVar) {
        a(caVar.a(254, 0), 2);
    }

    private void b(ca[] caVarArr) {
        for (ca f : caVarArr) {
            f(f);
        }
    }

    private void b(bx bxVar) {
        Iterator c = bxVar.c();
        while (c.hasNext()) {
            f((ca) c.next());
        }
    }

    private void b(bn bnVar, int i, long j, String str) throws IOException {
        c(bnVar, i);
        a(ca.a(bnVar, i, this.e, j, str, this.d), 2);
    }

    private void b(bn bnVar, int i, long j, dd ddVar) throws IOException {
        c(bnVar, i);
        a(ca.a(bnVar, i, this.e, j, ddVar, this.d), 2);
    }

    private void g(ca caVar) {
        c(caVar.o(), caVar.p());
        e(caVar);
    }

    private void c(ca[] caVarArr) {
        for (ca caVar : caVarArr) {
            c(caVar.o(), caVar.p());
            e(caVar);
        }
    }

    private void d(ca caVar) {
        a(caVar, 1);
    }

    private void e(ca caVar) {
        a(caVar, 2);
    }

    private void c(bx bxVar) {
        c(bxVar.i().o(), bxVar.i().q());
        Iterator c = bxVar.c();
        while (c.hasNext()) {
            e((ca) c.next());
        }
    }
}
