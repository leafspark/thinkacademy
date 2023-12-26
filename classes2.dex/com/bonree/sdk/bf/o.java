package com.bonree.sdk.bf;

import com.bonree.sdk.bf.i;
import com.bonree.sdk.br.l;
import java.util.Collection;

final class o implements l<V> {
    private /* synthetic */ Collection a;
    private /* synthetic */ i.b b;

    o(Collection collection, i.b bVar) {
        this.a = collection;
        this.b = bVar;
    }

    public final void a(V v) {
        for (i cancel : this.a) {
            cancel.cancel(true);
        }
        this.b.b(v);
    }
}
