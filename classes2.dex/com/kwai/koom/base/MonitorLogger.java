package com.kwai.koom.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/kwai/koom/base/MonitorLogger;", "Lcom/kwai/koom/base/Logger;", "()V", "addCustomStatEvent", "", "key", "", "value", "realtimeReport", "", "addExceptionEvent", "message", "crashType", "", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: MonitorLogger.kt */
public final class MonitorLogger implements Logger {
    public static final MonitorLogger INSTANCE = new MonitorLogger();

    private MonitorLogger() {
    }

    public void addCustomStatEvent(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getLogger$koom_monitor_base_SharedCppRelease().addCustomStatEvent(str, str2, z);
    }

    public void addExceptionEvent(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "message");
        MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getLogger$koom_monitor_base_SharedCppRelease().addExceptionEvent(str, i);
    }
}
