package com.igexin.push.c;

import java.util.Comparator;
import java.util.Map;

class p implements Comparator<Map.Entry<String, j>> {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    /* renamed from: a */
    public int compare(Map.Entry<String, j> entry, Map.Entry<String, j> entry2) {
        return (int) (entry.getValue().e() - entry2.getValue().e());
    }
}
