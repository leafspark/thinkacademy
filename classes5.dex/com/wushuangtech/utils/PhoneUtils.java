package com.wushuangtech.utils;

import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.library.GlobalHolder;

public class PhoneUtils {
    private static final String TAG = "PhoneUtils";

    public static int getInternalServiceCompany(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return LocalSDKConstants.PHONE_SERVER_NULL;
            }
            String simOperator = telephonyManager.getSimOperator();
            if (simOperator != null) {
                if (!simOperator.startsWith("46000") && !simOperator.startsWith("46002")) {
                    if (!simOperator.startsWith("46007")) {
                        if (!simOperator.startsWith("46001")) {
                            if (!simOperator.startsWith("46006")) {
                                if (simOperator.startsWith("46003")) {
                                    return LocalSDKConstants.PHONE_SERVER_DX;
                                }
                            }
                        }
                        return LocalSDKConstants.PHONE_SERVER_LT;
                    }
                }
                return LocalSDKConstants.PHONE_SERVER_YD;
            }
            return LocalSDKConstants.PHONE_SERVER_NULL;
        } catch (Exception e) {
            String str = TAG;
            OmniLog.e(str, "Get internal service company failed... Exception: " + e.getLocalizedMessage());
            return LocalSDKConstants.PHONE_SERVER_NULL;
        }
    }

    public static int getNetworkType() {
        return getNetworkType(GlobalHolder.getInstance().getContext());
    }

    public static int getNetworkType(Context context) {
        try {
            if (!AppUtils.hasPermission("android.permission.ACCESS_NETWORK_STATE")) {
                String str = TAG;
                OmniLog.e(str, "Get network type failed... " + "Not READ_PHONE_STATE or ACCESS_NETWORK_STATE permission!");
                return LocalSDKConstants.PHONE_NETWORK_NULL;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                String str2 = TAG;
                OmniLog.e(str2, "Get network type failed... " + "ConnectivityManager is null!");
                return LocalSDKConstants.PHONE_NETWORK_NULL;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork == null) {
                    return LocalSDKConstants.PHONE_NETWORK_NO_CONNECT;
                }
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities == null) {
                    return LocalSDKConstants.PHONE_NETWORK_NO_CONNECT;
                }
                if (!networkCapabilities.hasCapability(12)) {
                    return LocalSDKConstants.PHONE_NETWORK_NO_CONNECT;
                }
                if (networkCapabilities.hasTransport(1)) {
                    return LocalSDKConstants.PHONE_NETWORK_WIFI;
                }
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnected()) {
                        if (1 == activeNetworkInfo.getType()) {
                            return LocalSDKConstants.PHONE_NETWORK_WIFI;
                        }
                    }
                }
                return LocalSDKConstants.PHONE_NETWORK_NO_CONNECT;
            }
            return getMobileNetType(context);
        } catch (Exception e) {
            String str3 = TAG;
            OmniLog.e(str3, "Get network type failed... " + "Excetpion: " + e.getLocalizedMessage());
            return LocalSDKConstants.PHONE_NETWORK_NULL;
        }
    }

    public static boolean isEmu() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object newInstance = cls.newInstance();
            return cls.getMethod("get", new Class[]{String.class, String.class}).invoke(newInstance, new Object[]{"gsm.version.baseband", "no message"}).equals("no message");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        r1 = (android.os.PowerManager) r6.getSystemService("power");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int isPowerSaveMode(android.content.Context r6) {
        /*
            r0 = -1
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0048 }
            r3 = 21
            r4 = 0
            if (r2 < r3) goto L_0x001b
            java.lang.String r1 = "power"
            java.lang.Object r1 = r6.getSystemService(r1)     // Catch:{ Exception -> 0x0048 }
            android.os.PowerManager r1 = (android.os.PowerManager) r1     // Catch:{ Exception -> 0x0048 }
            if (r1 == 0) goto L_0x001b
            boolean r2 = r1.isPowerSaveMode()     // Catch:{ Exception -> 0x0048 }
            goto L_0x001c
        L_0x001b:
            r2 = r4
        L_0x001c:
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r3 = "low_power"
            java.lang.String r6 = android.provider.Settings.Global.getString(r6, r3)     // Catch:{ Exception -> 0x0048 }
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0048 }
            r5 = 1
            if (r3 != 0) goto L_0x0037
            java.lang.String r3 = "1"
            boolean r3 = r6.equals(r3)     // Catch:{ Exception -> 0x0048 }
            if (r3 == 0) goto L_0x0037
            r3 = r5
            goto L_0x0038
        L_0x0037:
            r3 = r4
        L_0x0038:
            if (r1 != 0) goto L_0x0041
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0048 }
            if (r6 == 0) goto L_0x0041
            return r0
        L_0x0041:
            if (r2 != 0) goto L_0x0047
            if (r3 == 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            return r4
        L_0x0047:
            return r5
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.utils.PhoneUtils.isPowerSaveMode(android.content.Context):int");
    }

    public static int getScreenOrientation(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            if (point.x >= point.y) {
                return 2;
            }
            return 1;
        } catch (Exception unused) {
            return 1;
        }
    }

    private static int getMobileNetType(Context context) {
        int i;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            String str = TAG;
            OmniLog.e(str, "Get network type failed... " + "TelephonyManager is null");
            return LocalSDKConstants.PHONE_NETWORK_NULL;
        }
        if (Build.VERSION.SDK_INT < 24) {
            i = telephonyManager.getNetworkType();
        } else if (AppUtils.hasPermission("android.permission.READ_PHONE_STATE")) {
            i = telephonyManager.getDataNetworkType();
        } else if (Build.VERSION.SDK_INT >= 30) {
            return LocalSDKConstants.PHONE_NETWORK_NULL;
        } else {
            i = telephonyManager.getNetworkType();
        }
        if (i != 19) {
            if (i == 20) {
                return LocalSDKConstants.PHONE_NETWORK_5G;
            }
            switch (i) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return LocalSDKConstants.PHONE_NETWORK_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return LocalSDKConstants.PHONE_NETWORK_3G;
                case 13:
                    break;
                default:
                    String str2 = TAG;
                    OmniLog.e(str2, "Get network type failed... " + i);
                    return LocalSDKConstants.PHONE_NETWORK_NULL;
            }
        }
        return LocalSDKConstants.PHONE_NETWORK_4G;
    }
}
