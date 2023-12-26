package com.bonree.sdk.bf;

import com.bonree.sdk.bj.a;
import com.bonree.sdk.bl.c;

public abstract class d {
    private static int a = 512;

    public abstract void a(a aVar, c cVar, com.bonree.sdk.bk.a aVar2);

    /* access modifiers changed from: protected */
    public abstract com.bonree.sdk.bl.a b(a aVar);

    /* access modifiers changed from: protected */
    public abstract void b(a aVar, c cVar);

    public final void a(a aVar, c cVar) {
        b(aVar.e(), cVar);
    }

    public final com.bonree.sdk.bl.a a(a aVar) {
        return b(aVar.e());
    }
}
