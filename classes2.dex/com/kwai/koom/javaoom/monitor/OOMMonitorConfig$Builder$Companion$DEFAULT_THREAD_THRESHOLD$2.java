package com.kwai.koom.javaoom.monitor;

import android.os.Build;
import com.kwai.koom.base.MonitorBuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OOMMonitorConfig.kt */
final class OOMMonitorConfig$Builder$Companion$DEFAULT_THREAD_THRESHOLD$2 extends Lambda implements Function0<Integer> {
    public static final OOMMonitorConfig$Builder$Companion$DEFAULT_THREAD_THRESHOLD$2 INSTANCE = new OOMMonitorConfig$Builder$Companion$DEFAULT_THREAD_THRESHOLD$2();

    OOMMonitorConfig$Builder$Companion$DEFAULT_THREAD_THRESHOLD$2() {
        super(0);
    }

    public final Integer invoke() {
        return Integer.valueOf((!Intrinsics.areEqual(MonitorBuildConfig.getROM(), "EMUI") || Build.VERSION.SDK_INT > 26) ? 750 : 450);
    }
}
