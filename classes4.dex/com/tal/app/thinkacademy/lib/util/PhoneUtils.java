package com.tal.app.thinkacademy.lib.util;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import com.tal.app.thinkacademy.lib.language.AppUtil;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public final class PhoneUtils {
    private PhoneUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isPhone() {
        return getTelephonyManager().getPhoneType() != 0;
    }

    public static String getDeviceId() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        TelephonyManager telephonyManager = getTelephonyManager();
        String deviceId = telephonyManager.getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        if (Build.VERSION.SDK_INT < 26) {
            return "";
        }
        String imei = telephonyManager.getImei();
        if (!TextUtils.isEmpty(imei)) {
            return imei;
        }
        String meid = telephonyManager.getMeid();
        if (TextUtils.isEmpty(meid)) {
            return "";
        }
        return meid;
    }

    public static String getSerial() {
        if (Build.VERSION.SDK_INT < 29) {
            return Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
        }
        try {
            return Build.getSerial();
        } catch (SecurityException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getIMEI() {
        return getImeiOrMeid(true);
    }

    public static String getMEID() {
        return getImeiOrMeid(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a9, code lost:
        if (r0.length() < 15) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bb, code lost:
        if (r0.length() == 14) goto L_0x00bf;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ac A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00dc A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getImeiOrMeid(boolean r12) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            r2 = 29
            if (r0 < r2) goto L_0x0009
            return r1
        L_0x0009:
            android.telephony.TelephonyManager r0 = getTelephonyManager()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L_0x0031
            if (r12 == 0) goto L_0x0024
            java.lang.String r12 = r0.getImei(r5)
            java.lang.String r0 = r0.getImei(r4)
            java.lang.String r12 = getMinOne(r12, r0)
            return r12
        L_0x0024:
            java.lang.String r12 = r0.getMeid(r5)
            java.lang.String r0 = r0.getMeid(r4)
            java.lang.String r12 = getMinOne(r12, r0)
            return r12
        L_0x0031:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            r6 = 15
            r7 = 14
            if (r2 < r3) goto L_0x00c4
            if (r12 == 0) goto L_0x0040
            java.lang.String r2 = "ril.gsm.imei"
            goto L_0x0042
        L_0x0040:
            java.lang.String r2 = "ril.cdma.meid"
        L_0x0042:
            java.lang.String r2 = getSystemPropertyByReflect(r2)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r8 = 2
            if (r3 != 0) goto L_0x0062
            java.lang.String r12 = ","
            java.lang.String[] r12 = r2.split(r12)
            int r0 = r12.length
            if (r0 != r8) goto L_0x005f
            r0 = r12[r5]
            r12 = r12[r4]
            java.lang.String r12 = getMinOne(r0, r12)
            return r12
        L_0x005f:
            r12 = r12[r5]
            return r12
        L_0x0062:
            java.lang.String r2 = r0.getDeviceId()
            java.lang.Class r3 = r0.getClass()     // Catch:{ NoSuchMethodException -> 0x0093, IllegalAccessException -> 0x008e, InvocationTargetException -> 0x0089 }
            java.lang.String r9 = "getDeviceId"
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0093, IllegalAccessException -> 0x008e, InvocationTargetException -> 0x0089 }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0093, IllegalAccessException -> 0x008e, InvocationTargetException -> 0x0089 }
            r10[r5] = r11     // Catch:{ NoSuchMethodException -> 0x0093, IllegalAccessException -> 0x008e, InvocationTargetException -> 0x0089 }
            java.lang.reflect.Method r3 = r3.getMethod(r9, r10)     // Catch:{ NoSuchMethodException -> 0x0093, IllegalAccessException -> 0x008e, InvocationTargetException -> 0x0089 }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ NoSuchMethodException -> 0x0093, IllegalAccessException -> 0x008e, InvocationTargetException -> 0x0089 }
            if (r12 == 0) goto L_0x007b
            goto L_0x007c
        L_0x007b:
            r4 = r8
        L_0x007c:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NoSuchMethodException -> 0x0093, IllegalAccessException -> 0x008e, InvocationTargetException -> 0x0089 }
            r9[r5] = r4     // Catch:{ NoSuchMethodException -> 0x0093, IllegalAccessException -> 0x008e, InvocationTargetException -> 0x0089 }
            java.lang.Object r0 = r3.invoke(r0, r9)     // Catch:{ NoSuchMethodException -> 0x0093, IllegalAccessException -> 0x008e, InvocationTargetException -> 0x0089 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NoSuchMethodException -> 0x0093, IllegalAccessException -> 0x008e, InvocationTargetException -> 0x0089 }
            goto L_0x0098
        L_0x0089:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0097
        L_0x008e:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0097
        L_0x0093:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0097:
            r0 = r1
        L_0x0098:
            if (r12 == 0) goto L_0x00ac
            if (r2 == 0) goto L_0x00a3
            int r12 = r2.length()
            if (r12 >= r6) goto L_0x00a3
            r2 = r1
        L_0x00a3:
            if (r0 == 0) goto L_0x00be
            int r12 = r0.length()
            if (r12 >= r6) goto L_0x00be
            goto L_0x00bf
        L_0x00ac:
            if (r2 == 0) goto L_0x00b5
            int r12 = r2.length()
            if (r12 != r7) goto L_0x00b5
            r2 = r1
        L_0x00b5:
            if (r0 == 0) goto L_0x00be
            int r12 = r0.length()
            if (r12 != r7) goto L_0x00be
            goto L_0x00bf
        L_0x00be:
            r1 = r0
        L_0x00bf:
            java.lang.String r12 = getMinOne(r2, r1)
            return r12
        L_0x00c4:
            java.lang.String r0 = r0.getDeviceId()
            if (r12 == 0) goto L_0x00d3
            if (r0 == 0) goto L_0x00dc
            int r12 = r0.length()
            if (r12 < r6) goto L_0x00dc
            return r0
        L_0x00d3:
            if (r0 == 0) goto L_0x00dc
            int r12 = r0.length()
            if (r12 != r7) goto L_0x00dc
            return r0
        L_0x00dc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.util.PhoneUtils.getImeiOrMeid(boolean):java.lang.String");
    }

    private static String getMinOne(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty || !isEmpty2) {
            return (isEmpty || isEmpty2) ? !isEmpty ? str : str2 : str.compareTo(str2) <= 0 ? str : str2;
        }
        return "";
    }

    private static String getSystemPropertyByReflect(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, ""});
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getIMSI() {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                getTelephonyManager().getSubscriberId();
            } catch (SecurityException e) {
                e.printStackTrace();
                return "";
            }
        }
        return getTelephonyManager().getSubscriberId();
    }

    public static int getPhoneType() {
        return getTelephonyManager().getPhoneType();
    }

    public static boolean isSimCardReady() {
        return getTelephonyManager().getSimState() == 5;
    }

    public static String getSimOperatorName() {
        return getTelephonyManager().getSimOperatorName();
    }

    public static String getSimOperatorByMnc() {
        String simOperator = getTelephonyManager().getSimOperator();
        if (simOperator == null) {
            return "";
        }
        simOperator.hashCode();
        char c = 65535;
        switch (simOperator.hashCode()) {
            case 49679470:
                if (simOperator.equals("46000")) {
                    c = 0;
                    break;
                }
                break;
            case 49679471:
                if (simOperator.equals("46001")) {
                    c = 1;
                    break;
                }
                break;
            case 49679472:
                if (simOperator.equals("46002")) {
                    c = 2;
                    break;
                }
                break;
            case 49679473:
                if (simOperator.equals("46003")) {
                    c = 3;
                    break;
                }
                break;
            case 49679475:
                if (simOperator.equals("46005")) {
                    c = 4;
                    break;
                }
                break;
            case 49679476:
                if (simOperator.equals("46006")) {
                    c = 5;
                    break;
                }
                break;
            case 49679477:
                if (simOperator.equals("46007")) {
                    c = 6;
                    break;
                }
                break;
            case 49679479:
                if (simOperator.equals("46009")) {
                    c = 7;
                    break;
                }
                break;
            case 49679502:
                if (simOperator.equals("46011")) {
                    c = 8;
                    break;
                }
                break;
            case 49679532:
                if (simOperator.equals("46020")) {
                    c = 9;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 6:
            case 9:
                return "中国移动";
            case 1:
            case 5:
            case 7:
                return "中国联通";
            case 3:
            case 4:
            case 8:
                return "中国电信";
            default:
                return simOperator;
        }
    }

    public static void dial(String str) {
        Utils.getApp().startActivity(UtilsBridge.getDialIntent(str));
    }

    public static void call(String str) {
        Utils.getApp().startActivity(UtilsBridge.getCallIntent(str));
    }

    public static void sendSms(String str, String str2) {
        Utils.getApp().startActivity(UtilsBridge.getSendSmsIntent(str, str2));
    }

    private static TelephonyManager getTelephonyManager() {
        return (TelephonyManager) Utils.getApp().getSystemService("phone");
    }

    public static String getCurCpuFreq() {
        try {
            String readLine = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq")).readLine();
            return readLine.trim() + "Hz";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "N/A";
        } catch (IOException e2) {
            e2.printStackTrace();
            return "N/A";
        }
    }

    public static String getMaxCpuFreq() {
        String str;
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            str = "";
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            str = "N/A";
        }
        return str.trim() + "Hz";
    }

    public static String getMinCpuFreq() {
        String str;
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            str = "";
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            str = "N/A";
        }
        return str.trim() + "Hz";
    }

    public static double getRamMaxMemoryInt(long j) {
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            str = bufferedReader.readLine().split("\\s+")[1];
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str != null) {
            return Math.ceil(new Float(Float.valueOf(str).floatValue() / ((float) j)).doubleValue());
        }
        return 0.0d;
    }

    public static String getRamMaxMemory() {
        return ((int) getRamMaxMemoryInt(1048576)) + LanguageUtil.COUNTRY_UK;
    }

    public static String getRamRemainingMemory() {
        Application application = AppUtil.getApplication();
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) application.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return Formatter.formatFileSize(application, memoryInfo.availMem);
    }

    public static String getRomMaxMemory() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Formatter.formatFileSize(AppUtil.getApplication(), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()));
    }

    public static String getRomRemainingMemory() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return Formatter.formatFileSize(AppUtil.getApplication(), ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()));
    }
}
