package com.kwai.koom.base;

import android.content.SharedPreferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"allKeys", "", "", "Landroid/content/SharedPreferences;", "getAllKeys", "(Landroid/content/SharedPreferences;)Ljava/util/Set;", "koom-monitor-base_SharedCppRelease"}, k = 2, mv = {1, 4, 1})
/* compiled from: Monitor_SharedPreferences.kt */
public final class Monitor_SharedPreferencesKt {
    public static final Set<String> getAllKeys(SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "$this$allKeys");
        return (Set) MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getSharedPreferencesKeysInvoker().invoke(sharedPreferences);
    }
}
