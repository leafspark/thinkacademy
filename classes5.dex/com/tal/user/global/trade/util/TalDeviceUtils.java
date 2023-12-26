package com.tal.user.global.trade.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tal.user.global.trade.api.TalTradeSdk;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.List;

public class TalDeviceUtils {
    public static final String MOBILE = "mobile";
    public static final String TELECOM = "telecom";
    public static final String UNICOM = "unicom";
    protected static String processName;

    public static synchronized String getAppName(Context context) {
        String str;
        synchronized (TalDeviceUtils.class) {
            try {
                PackageManager packageManager = context.getPackageManager();
                int i = packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes;
                str = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            } catch (Exception e) {
                TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
                logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
                return null;
            }
        }
        return str;
    }

    public static synchronized String getVersionName(Context context) {
        String str;
        synchronized (TalDeviceUtils.class) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
                logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
                return null;
            }
        }
        return str;
    }

    public static synchronized int getVersionCode(Context context) {
        int i;
        synchronized (TalDeviceUtils.class) {
            try {
                i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Exception e) {
                TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
                logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
                return 0;
            }
        }
        return i;
    }

    public static synchronized String getPackageName(Context context) {
        String str;
        synchronized (TalDeviceUtils.class) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Exception e) {
                TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
                logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
                return null;
            }
        }
        return str;
    }

    public static boolean isNetWorkAvailable(Context context) {
        boolean z = true;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (connectivityManager.getActiveNetworkInfo() != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                        z = false;
                    }
                    return z;
                }
            }
            return true;
        } catch (Exception e) {
            TalTradeLoggerFactory.getLogger("").i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            return false;
        }
    }

    public static boolean checkPermissions(Context context, String str) {
        boolean z = true;
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
                z = false;
            }
            return z;
        } catch (Exception e) {
            TalTradeLoggerFactory.getLogger("").i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            return false;
        }
    }

    public static int Dp2Px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static int Px2Dp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int[] measureView(View view) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i2 = layoutParams.height;
        if (i2 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i);
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static String getCurProcessName(Context context) {
        String str = processName;
        if (str != null) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                String processName2 = getProcessName(Process.myPid());
                processName = processName2;
                return processName2;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                String processName3 = getProcessName(Process.myPid());
                processName = processName3;
                return processName3;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid) {
                    processName = next.processName;
                    return next.processName;
                }
            }
            return null;
        } catch (Exception e) {
            TalTradeLogger logger = TalTradeLoggerFactory.getLogger("");
            logger.i(Thread.currentThread().getStackTrace()[1].getMethodName() + "发生的异常是: " + e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041 A[SYNTHETIC, Splitter:B:18:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static java.lang.String getProcessName(int r5) {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x003a }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x003a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x003a }
            r3.<init>()     // Catch:{ all -> 0x003a }
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch:{ all -> 0x003a }
            r3.append(r5)     // Catch:{ all -> 0x003a }
            java.lang.String r5 = "/cmdline"
            r3.append(r5)     // Catch:{ all -> 0x003a }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x003a }
            r2.<init>(r5)     // Catch:{ all -> 0x003a }
            r1.<init>(r2)     // Catch:{ all -> 0x003a }
            java.lang.String r5 = r1.readLine()     // Catch:{ all -> 0x0038 }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0038 }
            if (r2 != 0) goto L_0x002f
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x0038 }
        L_0x002f:
            r1.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0037:
            return r5
        L_0x0038:
            r5 = move-exception
            goto L_0x003c
        L_0x003a:
            r5 = move-exception
            r1 = r0
        L_0x003c:
            r5.printStackTrace()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0049:
            return r0
        L_0x004a:
            r5 = move-exception
            if (r1 == 0) goto L_0x0055
            r1.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0055:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.util.TalDeviceUtils.getProcessName(int):java.lang.String");
    }

    public static String getCarrierTypeAsFarAsPossible(Context context) {
        String simOperator;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (!(telephonyManager == null || (simOperator = telephonyManager.getSimOperator()) == null)) {
                    return parseOperatorCode(simOperator);
                }
            } catch (Exception e) {
                TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG).e(e);
            }
        }
        return "";
    }

    static String parseOperatorCode(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 49679470:
                if (str.equals("46000")) {
                    c = 0;
                    break;
                }
                break;
            case 49679471:
                if (str.equals("46001")) {
                    c = 1;
                    break;
                }
                break;
            case 49679472:
                if (str.equals("46002")) {
                    c = 2;
                    break;
                }
                break;
            case 49679473:
                if (str.equals("46003")) {
                    c = 3;
                    break;
                }
                break;
            case 49679475:
                if (str.equals("46005")) {
                    c = 4;
                    break;
                }
                break;
            case 49679476:
                if (str.equals("46006")) {
                    c = 5;
                    break;
                }
                break;
            case 49679477:
                if (str.equals("46007")) {
                    c = 6;
                    break;
                }
                break;
            case 49679478:
                if (str.equals("46008")) {
                    c = 7;
                    break;
                }
                break;
            case 49679479:
                if (str.equals("46009")) {
                    c = 8;
                    break;
                }
                break;
            case 49679502:
                if (str.equals("46011")) {
                    c = 9;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 6:
            case 7:
                return MOBILE;
            case 1:
            case 5:
            case 8:
                return UNICOM;
            case 3:
            case 4:
            case 9:
                return TELECOM;
            default:
                return "";
        }
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
                return str2.trim();
            }
            return (str + " " + str2).trim();
        } catch (Exception e) {
            TalTradeLoggerFactory.getLogger(TalTradeSdk.TAG).e(e);
            return "";
        }
    }

    public static void setLightStatusBar(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(((!z || Build.VERSION.SDK_INT <= 23) ? 0 : Marshallable.PROTO_PACKET_SIZE) | PlatformPlugin.DEFAULT_SYSTEM_UI);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.addFlags(67108864);
        }
    }
}
