package com.tal.app.thinkacademy.lib.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/ProcessUtils;", "", "()V", "TAG", "", "currentProcessNameByFile", "getCurrentProcessNameByFile", "()Ljava/lang/String;", "currentProcessNameByReflect", "getCurrentProcessNameByReflect", "getCurrentProcessName", "context", "Landroid/content/Context;", "getCurrentProcessNameByAms", "isMainProcess", "", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProcessUtils.kt */
public final class ProcessUtils {
    public static final ProcessUtils INSTANCE = new ProcessUtils();
    private static final String TAG = "ProcessUtils";

    private ProcessUtils() {
    }

    @JvmStatic
    public static final boolean isMainProcess(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = false;
        try {
            String currentProcessName = INSTANCE.getCurrentProcessName(context);
            z = StringsKt.equals(context.getPackageName(), currentProcessName, true);
            Log.i(TAG, "----nowProcess:" + currentProcessName + ",----mainProcess:" + context.getPackageName() + ",----isMainProcess:" + z);
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return z;
        }
    }

    private final String getCurrentProcessName(Context context) {
        String currentProcessNameByFile = getCurrentProcessNameByFile();
        if (!TextUtils.isEmpty(currentProcessNameByFile)) {
            return currentProcessNameByFile;
        }
        String currentProcessNameByAms = getCurrentProcessNameByAms(context);
        if (!TextUtils.isEmpty(currentProcessNameByAms)) {
            return currentProcessNameByAms;
        }
        return getCurrentProcessNameByReflect();
    }

    private final String getCurrentProcessNameByFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String readLine = bufferedReader.readLine();
            Intrinsics.checkNotNullExpressionValue(readLine, "mBufferedReader.readLine()");
            CharSequence charSequence = readLine;
            int length = charSequence.length() - 1;
            int i = 0;
            boolean z = false;
            while (true) {
                if (i > length) {
                    break;
                }
                boolean z2 = Intrinsics.compare(charSequence.charAt(!z ? i : length), 32) <= 0;
                if (!z) {
                    if (!z2) {
                        z = true;
                    } else {
                        i++;
                    }
                } else if (!z2) {
                    break;
                } else {
                    length--;
                }
            }
            String obj = charSequence.subSequence(i, length + 1).toString();
            bufferedReader.close();
            return obj;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private final String getCurrentProcessNameByAms(Context context) {
        try {
            Object systemService = context.getSystemService("activity");
            if (systemService != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    return "";
                }
                if (runningAppProcesses.size() == 0) {
                    return "";
                }
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (next.pid == myPid) {
                        if (TextUtils.isEmpty(next.processName)) {
                            return "";
                        }
                        String str = next.processName;
                        Intrinsics.checkNotNullExpressionValue(str, "{\n                      …ame\n                    }");
                        return str;
                    }
                }
                return "";
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private final String getCurrentProcessNameByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            Method declaredMethod2 = cls.getDeclaredMethod("getProcessName", new Class[0]);
            declaredMethod2.setAccessible(true);
            Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
            if (invoke2 != null) {
                return (String) invoke2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
