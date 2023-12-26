package com.bonree.sdk.ax;

import java.util.Comparator;

final class b implements Comparator<Object> {
    private /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final int compare(Object obj, Object obj2) {
        return -Long.compare(a.a(obj), a.a(obj2));
    }
}
