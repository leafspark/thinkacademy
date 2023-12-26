package com.kwai.koom.base;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0006\u0010\u0004\u001a\u00020\u0001\u001a\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u001a\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0006\u0010\b\u001a\u00020\t\u001a\u0006\u0010\n\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"mCurrentAbi", "Lcom/kwai/koom/base/Abi;", "mProcessName", "", "getCurrentAbi", "getProcessName", "getProcessNameByAms", "getProcessNameByProc", "isArm64", "", "isMainProcess", "koom-monitor-base_SharedCppRelease"}, k = 2, mv = {1, 4, 1})
/* compiled from: Monitor_Process.kt */
public final class Monitor_ProcessKt {
    private static volatile Abi mCurrentAbi = Abi.UNKNOWN;
    private static String mProcessName;

    public static final boolean isMainProcess() {
        return Intrinsics.areEqual(MonitorManager.getApplication().getPackageName(), getProcessName());
    }

    public static final String getProcessName() {
        String str = mProcessName;
        if (str == null) {
            str = getProcessNameByAms();
            if (str != null) {
                mProcessName = str;
            } else {
                str = null;
            }
        }
        if (str == null) {
            str = getProcessNameByProc();
            if (str == null) {
                return null;
            }
            mProcessName = str;
        }
        return str;
    }

    public static final boolean isArm64() {
        return getCurrentAbi() == Abi.ARM64_V8A;
    }

    public static final Abi getCurrentAbi() {
        Object callStaticMethod$default;
        Integer num;
        Object callStaticMethod$default2;
        Boolean bool;
        if (Build.VERSION.SDK_INT < 21) {
            return Abi.ARMEABI_V7A;
        }
        if (mCurrentAbi != Abi.UNKNOWN) {
            return mCurrentAbi;
        }
        Class<?> cls = Monitor_ReflectKt.toClass("dalvik.system.VMRuntime");
        if (cls == null || (callStaticMethod$default2 = Monitor_ReflectKt.callStaticMethod$default(cls, "getRuntime", (Class[]) null, (Object[]) null, 6, (Object) null)) == null || (bool = (Boolean) Monitor_ReflectKt.callMethod$default(callStaticMethod$default2, "is64Bit", (Class[]) null, (Object[]) null, 6, (Object) null)) == null) {
            Class<?> cls2 = Monitor_ReflectKt.toClass("sun.misc.Unsafe");
            if (cls2 == null || (callStaticMethod$default = Monitor_ReflectKt.callStaticMethod$default(cls2, "getUnsafe", (Class[]) null, (Object[]) null, 6, (Object) null)) == null || (num = (Integer) Monitor_ReflectKt.callMethod$default(callStaticMethod$default, "addressSize", (Class[]) null, (Object[]) null, 6, (Object) null)) == null) {
                try {
                    String str = MonitorManager.getApplication().getApplicationInfo().nativeLibraryDir;
                    Intrinsics.checkNotNullExpressionValue(str, "getApplication().applica…o\n      .nativeLibraryDir");
                    mCurrentAbi = StringsKt.contains$default(str, "arm64", false, 2, (Object) null) ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                return mCurrentAbi;
            }
            mCurrentAbi = num.intValue() == 8 ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
            return mCurrentAbi;
        }
        mCurrentAbi = bool.booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
        return mCurrentAbi;
    }

    private static final String getProcessNameByProc() {
        try {
            return StringsKt.trim(FilesKt.readText$default(new File("/proc/" + Process.myPid() + "/" + "cmdline"), (Charset) null, 1, (Object) null), new char[]{' ', 0});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final String getProcessNameByAms() {
        try {
            Object systemService = MonitorManager.getApplication().getSystemService("activity");
            if (systemService != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    runningAppProcesses = CollectionsKt.emptyList();
                }
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (next.pid == Process.myPid()) {
                        return next.processName;
                    }
                }
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
