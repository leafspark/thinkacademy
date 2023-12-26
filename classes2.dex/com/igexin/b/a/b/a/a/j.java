package com.igexin.b.a.b.a.a;

import java.util.Comparator;

class j implements Comparator<m> {
    final /* synthetic */ f a;

    j(f fVar) {
        this.a = fVar;
    }

    /* renamed from: a */
    public int compare(m mVar, m mVar2) {
        if (mVar == null) {
            return 1;
        }
        if (mVar2 == null) {
            return -1;
        }
        if (((long) mVar.x) + mVar.v > ((long) mVar2.x) + mVar2.v) {
            return 1;
        }
        return ((long) mVar.x) + mVar.v < ((long) mVar2.x) + mVar2.v ? -1 : 0;
    }
}
