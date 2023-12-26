package com.kwai.koom.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "C", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: Monitor.kt */
public final class Monitor$throwIfNotInitialized$1 extends Lambda implements Function0<Unit> {
    public static final Monitor$throwIfNotInitialized$1 INSTANCE = new Monitor$throwIfNotInitialized$1();

    public Monitor$throwIfNotInitialized$1() {
        super(0);
    }

    public final void invoke() {
        throw new RuntimeException("Monitor is not initialized");
    }
}
