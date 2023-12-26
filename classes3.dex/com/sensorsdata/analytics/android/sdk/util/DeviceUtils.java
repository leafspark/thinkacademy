package com.sensorsdata.analytics.android.sdk.util;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.sensorsdata.analytics.android.sdk.SALog;

public class DeviceUtils {
    private static int getNaturalHeight(int i, int i2, int i3) {
        return (i == 0 || i == 2) ? i3 : i2;
    }

    private static int getNaturalWidth(int i, int i2, int i3) {
        return (i == 0 || i == 2) ? i2 : i3;
    }

    public static String getOS() {
        return Build.VERSION.RELEASE == null ? "UNKNOWN" : Build.VERSION.RELEASE;
    }

    public static String getManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            if (str != null) {
                return str.trim().toUpperCase();
            }
            return "UNKNOWN";
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "UNKNOWN";
        }
    }

    public static String getBrand() {
        try {
            String str = Build.BRAND;
            if (str != null) {
                return str.trim().toUpperCase();
            }
            return "UNKNOWN";
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return "UNKNOWN";
        }
    }

    public static String getModel() {
        return TextUtils.isEmpty(Build.MODEL) ? "UNKNOWN" : Build.MODEL.trim();
    }

    public static int[] getDeviceSize(Context context) {
        int i;
        int i2;
        int[] iArr = new int[2];
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            int rotation = defaultDisplay.getRotation();
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
                i2 = point.x;
                i = point.y;
            } else if (Build.VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
                i2 = point.x;
                i = point.y;
            } else {
                int width = defaultDisplay.getWidth();
                i = defaultDisplay.getHeight();
                i2 = width;
            }
            iArr[0] = getNaturalWidth(rotation, i2, i);
            iArr[1] = getNaturalHeight(rotation, i2, i);
        } catch (Exception unused) {
            if (context.getResources() != null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                iArr[0] = displayMetrics.widthPixels;
                iArr[1] = displayMetrics.heightPixels;
            }
        }
        return iArr;
    }

    public static String getHarmonyOSVersion() {
        if (!isHarmonyOs()) {
            return null;
        }
        String prop = getProp("hw_sc.build.platform.version", "");
        return TextUtils.isEmpty(prop) ? exec(SensorsDataUtils.COMMAND_HARMONYOS_VERSION) : prop;
    }

    private static boolean isHarmonyOs() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object invoke = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
            if (invoke == null) {
                return false;
            }
            return "harmony".equalsIgnoreCase(invoke.toString());
        } catch (Throwable th) {
            SALog.i("SA.HasHarmonyOS", th.getMessage());
            return false;
        }
    }

    private static String getProp(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            SALog.i("SA.SystemProperties", th.getMessage());
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0056 A[SYNTHETIC, Splitter:B:28:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0064 A[SYNTHETIC, Splitter:B:33:0x0064] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String exec(java.lang.String r5) {
        /*
            java.lang.String r0 = "SA.Exec"
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x004a }
            java.lang.Process r5 = r2.exec(r5)     // Catch:{ all -> 0x004a }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x004a }
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ all -> 0x004a }
            r2.<init>(r5)     // Catch:{ all -> 0x004a }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x0047 }
            r5.<init>(r2)     // Catch:{ all -> 0x0047 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r3.<init>()     // Catch:{ all -> 0x0045 }
        L_0x001e:
            java.lang.String r4 = r5.readLine()     // Catch:{ all -> 0x0045 }
            if (r4 == 0) goto L_0x0028
            r3.append(r4)     // Catch:{ all -> 0x0045 }
            goto L_0x001e
        L_0x0028:
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0045 }
            r5.close()     // Catch:{ all -> 0x0030 }
            goto L_0x0038
        L_0x0030:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x0038:
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0044
        L_0x003c:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x0044:
            return r1
        L_0x0045:
            r3 = move-exception
            goto L_0x004d
        L_0x0047:
            r3 = move-exception
            r5 = r1
            goto L_0x004d
        L_0x004a:
            r3 = move-exception
            r5 = r1
            r2 = r5
        L_0x004d:
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0071 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ all -> 0x0071 }
            if (r5 == 0) goto L_0x0062
            r5.close()     // Catch:{ all -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x0062:
            if (r2 == 0) goto L_0x0070
            r2.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0070
        L_0x0068:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x0070:
            return r1
        L_0x0071:
            r1 = move-exception
            if (r5 == 0) goto L_0x0080
            r5.close()     // Catch:{ all -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x0080:
            if (r2 == 0) goto L_0x008e
            r2.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008e
        L_0x0086:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x008e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.DeviceUtils.exec(java.lang.String):java.lang.String");
    }
}
