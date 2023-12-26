package com.kwai.koom.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: Monitor_Thread.kt */
final class Monitor_ThreadKt$async$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0 $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Monitor_ThreadKt$async$2(Function0 function0) {
        super(0);
        this.$block = function0;
    }

    public final void invoke() {
        this.$block.invoke();
    }
}
