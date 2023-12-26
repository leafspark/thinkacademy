package com.yy.mobile.rollingtextview.strategy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: NonZeroFirstStrategy.kt */
final class NonZeroFirstStrategy$findCharOrder$replaceList$3 extends Lambda implements Function0<Integer> {
    final /* synthetic */ int $firstIdx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NonZeroFirstStrategy$findCharOrder$replaceList$3(int i) {
        super(0);
        this.$firstIdx = i;
    }

    public final Integer invoke() {
        return Integer.valueOf(this.$firstIdx);
    }
}
