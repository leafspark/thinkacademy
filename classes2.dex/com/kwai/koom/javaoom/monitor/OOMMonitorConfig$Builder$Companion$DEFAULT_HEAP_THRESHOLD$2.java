package com.kwai.koom.javaoom.monitor;

import com.kwai.koom.javaoom.monitor.utils.SizeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMMonitorConfig.kt */
final class OOMMonitorConfig$Builder$Companion$DEFAULT_HEAP_THRESHOLD$2 extends Lambda implements Function0<Float> {
    public static final OOMMonitorConfig$Builder$Companion$DEFAULT_HEAP_THRESHOLD$2 INSTANCE = new OOMMonitorConfig$Builder$Companion$DEFAULT_HEAP_THRESHOLD$2();

    OOMMonitorConfig$Builder$Companion$DEFAULT_HEAP_THRESHOLD$2() {
        super(0);
    }

    public final Float invoke() {
        float mb = SizeUnit.BYTE.INSTANCE.toMB(Runtime.getRuntime().maxMemory());
        return Float.valueOf(mb >= 502.0f ? 0.8f : mb >= 246.0f ? 0.85f : 0.9f);
    }
}
