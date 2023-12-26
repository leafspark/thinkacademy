package com.kwai.koom.base;

import android.os.Build;
import android.util.Log;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0007\u001a\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0002¢\u0006\u0002\u0010\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"TAG", "", "isSupportArm64", "", "loadSo", "", "soName", "loadSoQuietly", "supportedABIs", "", "()[Ljava/lang/String;", "koom-monitor-base_SharedCppRelease"}, k = 2, mv = {1, 4, 1})
/* compiled from: Monitor_So.kt */
public final class Monitor_SoKt {
    private static final String TAG = "MonitorSo";

    @Deprecated(message = "Deprecated", replaceWith = @ReplaceWith(expression = "loadSoQuietly(soName)", imports = {}))
    public static final void loadSo(String str) {
        Intrinsics.checkNotNullParameter(str, "soName");
        MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getLoadSoInvoker$koom_monitor_base_SharedCppRelease().invoke(str);
    }

    public static final boolean loadSoQuietly(String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "soName");
        try {
            Result.Companion companion = Result.Companion;
            MonitorManager.INSTANCE.getCommonConfig$koom_monitor_base_SharedCppRelease().getLoadSoInvoker$koom_monitor_base_SharedCppRelease().invoke(str);
            z = Result.constructor-impl(true);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            z = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable r0 = Result.exceptionOrNull-impl(z);
        if (r0 != null) {
            r0.printStackTrace();
            MonitorLog.e(TAG, r0.getMessage() + "\n" + Log.getStackTraceString(r0));
        }
        if (Result.exceptionOrNull-impl(z) != null) {
            z = false;
        }
        return ((Boolean) z).booleanValue();
    }

    public static final boolean isSupportArm64() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        return ArraysKt.contains(supportedABIs(), "arm64-v8a");
    }

    private static final String[] supportedABIs() {
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            Intrinsics.checkNotNullExpressionValue(strArr, "Build.SUPPORTED_ABIS");
            if (!(strArr.length == 0)) {
                String[] strArr2 = Build.SUPPORTED_ABIS;
                Intrinsics.checkNotNullExpressionValue(strArr2, "Build.SUPPORTED_ABIS");
                return strArr2;
            }
        }
        CharSequence charSequence = Build.CPU_ABI2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            String str = Build.CPU_ABI;
            Intrinsics.checkNotNullExpressionValue(str, "Build.CPU_ABI");
            String str2 = Build.CPU_ABI2;
            Intrinsics.checkNotNullExpressionValue(str2, "Build.CPU_ABI2");
            return new String[]{str, str2};
        }
        String str3 = Build.CPU_ABI;
        Intrinsics.checkNotNullExpressionValue(str3, "Build.CPU_ABI");
        return new String[]{str3};
    }
}
