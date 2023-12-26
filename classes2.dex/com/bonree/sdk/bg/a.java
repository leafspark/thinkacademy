package com.bonree.sdk.bg;

import com.bonree.sdk.bj.a;
import com.bonree.sdk.bl.b;
import com.bonree.sdk.bl.c;
import com.bonree.sdk.bp.h;
import com.bonree.sdk.bp.v;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a extends c {
    private static /* synthetic */ boolean b = true;

    public a() {
        this(512);
    }

    public a(int i) {
        super(i);
    }

    public a(int i, long j) {
        super(i, j);
    }

    /* access modifiers changed from: protected */
    public final void b(com.bonree.sdk.bj.a aVar, c cVar) {
        super.b(aVar, cVar);
        com.bonree.sdk.bj.a aVar2 = cVar.a;
        HashMap hashMap = new HashMap(aVar2.n.size());
        a(hashMap, aVar, aVar2.l, (com.bonree.sdk.bk.a) null);
        a(hashMap, aVar, aVar2.m, (com.bonree.sdk.bk.a) null);
        a(hashMap, aVar, aVar2.n, (com.bonree.sdk.bk.a) null);
        a(cVar, hashMap);
    }

    public final void a(com.bonree.sdk.bj.a aVar, c cVar, com.bonree.sdk.bk.a aVar2) {
        com.bonree.sdk.bj.a aVar3 = cVar.a;
        if (b || !aVar3.e) {
            HashMap hashMap = new HashMap(aVar3.n.size());
            a(hashMap, aVar, aVar3.m, aVar2);
            a(hashMap, aVar, aVar3.n, aVar2);
            a(cVar, hashMap);
            return;
        }
        throw new AssertionError();
    }

    private void a(Map<com.bonree.sdk.bj.a, List<v<? extends h>>> map, com.bonree.sdk.bj.a aVar, List<v<? extends h>> list, com.bonree.sdk.bk.a aVar2) {
        a.C0014a aVar3;
        for (v next : list) {
            if (a((v<? extends h>) next, aVar.b(), aVar2)) {
                com.bonree.sdk.bj.c c = next.c();
                if (c == null) {
                    aVar3 = null;
                } else {
                    aVar3 = c.b();
                }
                if (aVar3 != null) {
                    aVar3.a(aVar);
                    aVar3.b((Collection<v<? extends h>>) aVar.n);
                    com.bonree.sdk.bj.a b2 = aVar3.b();
                    if (!b2.equals(aVar)) {
                        List list2 = map.get(b2);
                        if (list2 == null) {
                            list2 = new LinkedList();
                            map.put(b2, list2);
                        }
                        list2.add(next);
                    }
                }
            }
        }
    }

    private void a(c cVar, Map<com.bonree.sdk.bj.a, List<v<? extends h>>> map) {
        com.bonree.sdk.bj.a aVar = cVar.a;
        for (Map.Entry next : map.entrySet()) {
            com.bonree.sdk.bj.a aVar2 = (com.bonree.sdk.bj.a) next.getKey();
            b bVar = new b(aVar2, aVar.d().b(aVar2.b()).b(true).a((Collection<v<? extends h>>) (Collection) next.getValue()).b(), cVar);
            synchronized (this) {
                this.a.put(aVar2, bVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(v<? extends h> vVar, com.bonree.sdk.bj.c cVar, com.bonree.sdk.bk.a aVar) {
        boolean b2 = vVar.a.b(cVar.a);
        boolean b3 = aVar != null ? vVar.a.b(aVar) : false;
        if (b2 || b3) {
            return true;
        }
        return false;
    }
}
