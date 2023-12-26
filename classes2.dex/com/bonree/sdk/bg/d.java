package com.bonree.sdk.bg;

import com.bonree.sdk.bj.a;
import java.util.LinkedHashMap;
import java.util.Map;

final class d extends LinkedHashMap<a, com.bonree.sdk.bl.a> {
    private /* synthetic */ int a;
    private /* synthetic */ c b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    d(c cVar, int i, float f, boolean z, int i2) {
        super(i, 0.75f, true);
        this.b = cVar;
        this.a = i2;
    }

    /* access modifiers changed from: protected */
    public final boolean removeEldestEntry(Map.Entry<a, com.bonree.sdk.bl.a> entry) {
        return size() > this.a;
    }
}
