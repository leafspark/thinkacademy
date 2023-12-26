package com.sensorsdata.analytics.android.sdk.util;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.ThreadNameConstants;
import java.lang.reflect.Method;

public class AppInfoUtils {
    private static String mAppVersionName;
    private static Bundle mConfigBundle;

    public static CharSequence getAppName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager);
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }

    public static String getProcessName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getApplicationInfo().processName;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }

    public static String getAppVersionName(Context context) {
        if (context == null) {
            return "";
        }
        if (!TextUtils.isEmpty(mAppVersionName)) {
            return mAppVersionName;
        }
        try {
            mAppVersionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
        return mAppVersionName;
    }

    public static String getMainProcessName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getApplicationContext().getApplicationInfo().processName;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "";
        }
    }

    public static boolean isMainProcess(Context context, Bundle bundle) {
        if (context == null) {
            return false;
        }
        String mainProcessName = getMainProcessName(context);
        if (TextUtils.isEmpty(mainProcessName) && bundle != null) {
            mainProcessName = bundle.getString("com.sensorsdata.analytics.android.MainProcessName");
        }
        if (TextUtils.isEmpty(mainProcessName)) {
            return true;
        }
        String currentProcessName = getCurrentProcessName();
        if (TextUtils.isEmpty(currentProcessName) || mainProcessName.equals(currentProcessName)) {
            return true;
        }
        return false;
    }

    public static boolean isTaskExecuteThread() {
        return TextUtils.equals(ThreadNameConstants.THREAD_TASK_EXECUTE, Thread.currentThread().getName());
    }

    public static Bundle getAppInfoBundle(Context context) {
        if (mConfigBundle == null) {
            try {
                mConfigBundle = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e) {
                SALog.printStackTrace(e);
            }
        }
        Bundle bundle = mConfigBundle;
        return bundle == null ? new Bundle() : bundle;
    }

    private static String getCurrentProcessName() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            String currentProcessNameByCmd = getCurrentProcessNameByCmd();
            return TextUtils.isEmpty(currentProcessNameByCmd) ? getCurrentProcessNameByAT() : currentProcessNameByCmd;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return null;
        }
    }

    private static String getCurrentProcessNameByAT() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f A[Catch:{ all -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f A[SYNTHETIC, Splitter:B:17:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0036 A[Catch:{ IOException -> 0x003a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getCurrentProcessNameByCmd() {
        /*
            r0 = 0
            java.lang.String r1 = "/proc/self/cmdline"
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0033 }
            r2.<init>(r1)     // Catch:{ all -> 0x0033 }
            r1 = 256(0x100, float:3.59E-43)
            byte[] r3 = new byte[r1]     // Catch:{ all -> 0x0034 }
            r4 = 0
            r5 = r4
        L_0x000e:
            int r6 = r2.read()     // Catch:{ all -> 0x0034 }
            if (r6 <= 0) goto L_0x001d
            if (r5 >= r1) goto L_0x001d
            int r7 = r5 + 1
            byte r6 = (byte) r6     // Catch:{ all -> 0x0034 }
            r3[r5] = r6     // Catch:{ all -> 0x0034 }
            r5 = r7
            goto L_0x000e
        L_0x001d:
            if (r5 <= 0) goto L_0x002f
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0034 }
            java.lang.String r6 = "UTF-8"
            r1.<init>(r3, r4, r5, r6)     // Catch:{ all -> 0x0034 }
            r2.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
        L_0x002e:
            return r1
        L_0x002f:
            r2.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x0033:
            r2 = r0
        L_0x0034:
            if (r2 == 0) goto L_0x003e
            r2.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r1 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.AppInfoUtils.getCurrentProcessNameByCmd():java.lang.String");
    }
}
