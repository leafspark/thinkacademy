package com.kwai.koom.base;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
/* compiled from: Monitor_Thread.kt */
final class Monitor_ThreadKt$sam$java_lang_Runnable$0 implements Runnable {
    private final /* synthetic */ Function0 function;

    Monitor_ThreadKt$sam$java_lang_Runnable$0(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ void run() {
        Intrinsics.checkNotNullExpressionValue(this.function.invoke(), "invoke(...)");
    }
}
