package com.kwai.koom.base;

import com.kwai.koom.base.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\u000e"}, d2 = {"Lcom/kwai/koom/base/MonitorLog;", "", "()V", "d", "", "tag", "", "msg", "syncToLogger", "", "e", "i", "v", "w", "koom-monitor-base_SharedCppRelease"}, k = 1, mv = {1, 4, 1})
/* compiled from: MonitorLog.kt */
public final class MonitorLog {
    public static final MonitorLog INSTANCE = new MonitorLog();

    private MonitorLog() {
    }

    @JvmStatic
    public static final int v(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        return MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getLog$koom_monitor_base_SharedCppRelease().v(str, str2);
    }

    @JvmStatic
    public static final int i(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        return MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getLog$koom_monitor_base_SharedCppRelease().i(str, str2);
    }

    @JvmStatic
    public static final int d(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        return MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getLog$koom_monitor_base_SharedCppRelease().d(str, str2);
    }

    @JvmStatic
    public static final int w(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        return MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getLog$koom_monitor_base_SharedCppRelease().w(str, str2);
    }

    @JvmStatic
    public static final int e(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        return MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getLog$koom_monitor_base_SharedCppRelease().e(str, str2);
    }

    @JvmStatic
    public static final int v(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        if (z) {
            Logger.DefaultImpls.addCustomStatEvent$default(MonitorLogger.INSTANCE, str, str2, false, 4, (Object) null);
        }
        return v(str, str2);
    }

    @JvmStatic
    public static final int i(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        if (z) {
            Logger.DefaultImpls.addCustomStatEvent$default(MonitorLogger.INSTANCE, str, str2, false, 4, (Object) null);
        }
        return i(str, str2);
    }

    @JvmStatic
    public static final int d(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        if (z) {
            Logger.DefaultImpls.addCustomStatEvent$default(MonitorLogger.INSTANCE, str, str2, false, 4, (Object) null);
        }
        return d(str, str2);
    }

    @JvmStatic
    public static final int w(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        if (z) {
            Logger.DefaultImpls.addCustomStatEvent$default(MonitorLogger.INSTANCE, str, str2, false, 4, (Object) null);
        }
        return w(str, str2);
    }

    @JvmStatic
    public static final int e(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        if (z) {
            Logger.DefaultImpls.addCustomStatEvent$default(MonitorLogger.INSTANCE, str, str2, false, 4, (Object) null);
        }
        return e(str, str2);
    }
}
