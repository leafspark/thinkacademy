package com.luck.picture.lib.immersive;

import android.os.Build;
import android.text.TextUtils;
import com.luck.picture.lib.tools.StringUtils;
import com.luck.picture.lib.tools.ValueOf;

public class RomUtils {
    private static Integer romType;

    public static class AvailableRomType {
        public static final int ANDROID_NATIVE = 3;
        public static final int FLYME = 2;
        public static final int MIUI = 1;
        public static final int NA = 4;
    }

    public static int getLightStatausBarAvailableRomType() {
        Integer num = romType;
        if (num != null) {
            return num.intValue();
        }
        if (isMIUIV6OrAbove()) {
            Integer num2 = 1;
            romType = num2;
            return num2.intValue();
        } else if (isFlymeV4OrAbove()) {
            Integer num3 = 2;
            romType = num3;
            return num3.intValue();
        } else if (isAndroid5OrAbove()) {
            Integer num4 = 3;
            romType = num4;
            return num4.intValue();
        } else {
            Integer num5 = 4;
            romType = num5;
            return num5.intValue();
        }
    }

    private static boolean isFlymeV4OrAbove() {
        return getFlymeVersion() >= 4;
    }

    public static int getFlymeVersion() {
        String str = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || !str.contains("Flyme")) {
            return 0;
        }
        return StringUtils.stringToInt(str.replaceAll("Flyme", "").replaceAll("OS", "").replaceAll(" ", "").substring(0, 1));
    }

    private static boolean isMIUIV6OrAbove() {
        String systemProperty = getSystemProperty("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(systemProperty)) {
            return false;
        }
        try {
            if (ValueOf.toInt(systemProperty) >= 4) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getMIUIVersionCode() {
        String systemProperty = getSystemProperty("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(systemProperty)) {
            return 0;
        }
        try {
            return ValueOf.toInt(systemProperty);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static boolean isAndroid5OrAbove() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040 A[SYNTHETIC, Splitter:B:14:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c A[SYNTHETIC, Splitter:B:23:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSystemProperty(java.lang.String r4) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            r2.<init>()     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            r2.append(r4)     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            java.lang.String r4 = r2.toString()     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            java.lang.Process r4 = r1.exec(r4)     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r4)     // Catch:{ IOException -> 0x0049, all -> 0x003d }
            java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            r1.close()     // Catch:{ IOException -> 0x004a, all -> 0x003a }
            r1.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0039:
            return r4
        L_0x003a:
            r4 = move-exception
            r0 = r1
            goto L_0x003e
        L_0x003d:
            r4 = move-exception
        L_0x003e:
            if (r0 == 0) goto L_0x0048
            r0.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0048:
            throw r4
        L_0x0049:
            r1 = r0
        L_0x004a:
            if (r1 == 0) goto L_0x0054
            r1.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.immersive.RomUtils.getSystemProperty(java.lang.String):java.lang.String");
    }
}
