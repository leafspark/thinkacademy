package com.kwai.koom.javaoom.monitor;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMMonitor.kt */
final class OOMMonitor$startLoop$2$1 extends Lambda implements Function0<Unit> {
    public static final OOMMonitor$startLoop$2$1 INSTANCE = new OOMMonitor$startLoop$2$1();

    OOMMonitor$startLoop$2$1() {
        super(0);
    }

    public final void invoke() {
        OOMMonitor.INSTANCE.processOldHprofFile();
    }
}
