package com.eaydu.omni.log;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.eaydu.omni.fullLog.CommonUtil_rtc;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

public class DeviceInfo {
    private static final String TAG = "DeviceInfo";
    private static Context mContext;
    private static TelephonyManager telephonyManager;

    public static void init(Context context) {
        mContext = context;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceID() {
        return Build.SERIAL;
    }

    public static String getOsVersion() {
        String str = Build.VERSION.RELEASE;
        return str == null ? "" : str;
    }

    public static String getDeviceName() {
        try {
            String str = Build.MANUFACTURER;
            if (str == null) {
                str = "";
            }
            String str2 = Build.MODEL;
            if (str2 == null) {
                str2 = "";
            }
            if (str2.startsWith(str)) {
                return capitalize(str2).trim();
            }
            return (capitalize(str) + " " + str2).trim();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getOSver() {
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                str = "" + Build.VERSION.BASE_OS + "_";
            } else {
                str = "" + Build.VERSION.SDK + "_";
            }
            return str + Build.VERSION.RELEASE;
        } catch (Throwable th) {
            th.printStackTrace();
            return "" + "_" + th.getMessage();
        }
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getSn() {
        if (mContext != null && Build.VERSION.SDK_INT >= 23 && mContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            return ((TelephonyManager) mContext.getSystemService("phone")).getDeviceId();
        }
        return "";
    }

    public static int getMemTotal() {
        Context context = mContext;
        if (context != null) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                return (int) (memoryInfo.totalMem / 1024);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static double getMemRatio() {
        Context context = mContext;
        if (context != null) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                if (memoryInfo.totalMem != 0) {
                    return ((double) memoryInfo.availMem) / ((double) memoryInfo.totalMem);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0.0d;
    }

    public static double getCpuRatio() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            String[] split = randomAccessFile.readLine().split(" ");
            long parseLong = Long.parseLong(split[5]);
            long parseLong2 = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            randomAccessFile.seek(0);
            String readLine = randomAccessFile.readLine();
            randomAccessFile.close();
            String[] split2 = readLine.split(" ");
            long parseLong3 = Long.parseLong(split2[5]);
            long parseLong4 = Long.parseLong(split2[2]) + Long.parseLong(split2[3]) + Long.parseLong(split2[4]) + Long.parseLong(split2[6]) + Long.parseLong(split2[7]) + Long.parseLong(split2[8]);
            return (double) (((float) (parseLong4 - parseLong2)) / ((float) ((parseLong4 + parseLong3) - (parseLong2 + parseLong))));
        } catch (IOException unused) {
            Log.e(TAG, "get cpu usage failed!!!");
            return 0.0d;
        }
    }

    public static String getCpuArch() {
        return System.getProperty("os.arch");
    }

    private static String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static String getDeviceId() {
        try {
            String deviceIMEI = getDeviceIMEI();
            String imsi = getIMSI();
            String salt = CommonUtil_rtc.getSALT(mContext);
            return CommonUtil_rtc.md5Appkey(deviceIMEI + imsi + salt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getIMSI() {
        String subscriberId;
        try {
            if (CommonUtil_rtc.checkPermissions(mContext, "android.permission.READ_PHONE_STATE") && mContext != null && Build.VERSION.SDK_INT >= 23 && mContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0 && (subscriberId = telephonyManager.getSubscriberId()) != null) {
                return subscriberId;
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDeviceIMEI() {
        String deviceId;
        try {
            if (CommonUtil_rtc.checkPermissions(mContext, "android.permission.READ_PHONE_STATE") && mContext != null && Build.VERSION.SDK_INT >= 23 && mContext.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0 && (deviceId = telephonyManager.getDeviceId()) != null) {
                return deviceId;
            }
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getSystemModel() {
        return Build.MODEL;
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }
}
