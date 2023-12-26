package com.kwai.koom.base;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: MonitorBuildConfig.kt */
final class MonitorBuildConfig$VERSION_NAME$2 extends Lambda implements Function0<String> {
    public static final MonitorBuildConfig$VERSION_NAME$2 INSTANCE = new MonitorBuildConfig$VERSION_NAME$2();

    MonitorBuildConfig$VERSION_NAME$2() {
        super(0);
    }

    public final String invoke() {
        return (String) MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getVersionNameInvoker$koom_monitor_base_SharedCppRelease().invoke();
    }
}
