package com.bonree.sdk.bf;

import com.bonree.sdk.bf.i;
import com.bonree.sdk.br.e;
import java.util.Collection;
import java.util.List;

final class p implements e<EI> {
    private /* synthetic */ List a;
    private /* synthetic */ Collection b;
    private /* synthetic */ i.a c;
    private /* synthetic */ i.b d;

    p(List list, Collection collection, i.a aVar, i.b bVar) {
        this.a = list;
        this.b = collection;
        this.c = aVar;
        this.d = bVar;
    }

    public final /* synthetic */ void a(Object obj) {
        this.a.add((Exception) obj);
        if (this.a.size() == this.b.size()) {
            this.d.a(this.c.a(this.a));
        }
    }

    private void a(EI ei) {
        this.a.add(ei);
        if (this.a.size() == this.b.size()) {
            this.d.a(this.c.a(this.a));
        }
    }
}
