package com.tal100.mars.comm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tal100.mars.xlog.Log;
import java.util.List;

public class NetStatusUtil {
    public static final int CMNET = 6;
    public static final int CMWAP = 5;
    public static final int CTNET = 8;
    public static final int CTWAP = 7;
    public static final int LTE = 10;
    public static final int MOBILE = 9;
    public static final int NETTYPE_NOT_WIFI = 0;
    public static final int NETTYPE_WIFI = 1;
    public static final int NET_3G = 4;
    public static final int NON_NETWORK = -1;
    public static final int NO_SIM_OPERATOR = 0;
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
    private static final String TAG = "MicroMsg.NetStatusUtil";
    public static final int TBACKGROUND_DATA_LIMITED = 2;
    public static final int TBACKGROUND_NOT_LIMITED = 0;
    public static final int TBACKGROUND_PROCESS_LIMITED = 1;
    public static final int TBACKGROUND_WIFI_LIMITED = 3;
    public static final int UNINET = 1;
    public static final int UNIWAP = 2;
    public static final int UNKNOW_TYPE = 999;
    public static final int WAP_3G = 3;
    public static final int WIFI = 0;
    /* access modifiers changed from: private */
    public static int nowStrength;

    public static boolean isLimited(int i) {
        return i == 2 || i == 1 || i == 3;
    }

    public static boolean isWap(int i) {
        return i == 2 || i == 5 || i == 7 || i == 3;
    }

    public static boolean isWifi(int i) {
        return i == 0;
    }

    public static void dumpNetStatus(Context context) {
        try {
            Log.i(TAG, ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().toString());
        } catch (Exception e) {
            Log.e(TAG, "", e);
        }
    }

    public static boolean isConnected(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getNetTypeString(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "NON_NETWORK";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        return activeNetworkInfo.getExtraInfo() != null ? activeNetworkInfo.getExtraInfo() : "MOBILE";
    }

    public static int getNetWorkType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.getType();
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getNetType(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 0;
        }
        if (activeNetworkInfo.getExtraInfo() == null) {
            return 9;
        }
        if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uninet")) {
            return 1;
        }
        if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uniwap")) {
            return 2;
        }
        if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gwap")) {
            return 3;
        }
        if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gnet")) {
            return 4;
        }
        if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmwap")) {
            return 5;
        }
        if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmnet")) {
            return 6;
        }
        if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctwap")) {
            return 7;
        }
        if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctnet")) {
            return 8;
        }
        return activeNetworkInfo.getExtraInfo().equalsIgnoreCase("LTE") ? 10 : 9;
    }

    public static int getISPCode(Context context) {
        String simOperator;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (!(telephonyManager == null || (simOperator = telephonyManager.getSimOperator()) == null || simOperator.length() < 5)) {
            StringBuilder sb = new StringBuilder();
            try {
                int length = simOperator.length();
                if (length > 6) {
                    length = 6;
                }
                for (int i = 0; i < length; i++) {
                    if (!Character.isDigit(simOperator.charAt(i))) {
                        if (sb.length() > 0) {
                            break;
                        }
                    } else {
                        sb.append(simOperator.charAt(i));
                    }
                }
                return Integer.valueOf(sb.toString()).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static String getISPName(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        if (telephonyManager.getSimOperatorName().length() <= 100) {
            return telephonyManager.getSimOperatorName();
        }
        return telephonyManager.getSimOperatorName().substring(0, 100);
    }

    public static int guessNetSpeed(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return 102400;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype == 1) {
                return 4096;
            }
            if (subtype != 2) {
                return 102400;
            }
            return Marshallable.PROTO_PACKET_SIZE;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isMobile(Context context) {
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() != 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean is2G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return false;
            }
            if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean is4G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() != 1 && activeNetworkInfo.getSubtype() >= 13) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isWap(Context context) {
        return isWap(getNetType(context));
    }

    public static boolean is3G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() != 1 && activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isWifi(Context context) {
        return isWifi(getNetType(context));
    }

    public static WifiInfo getWifiInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                if (1 == activeNetworkInfo.getType()) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return null;
                    }
                    return wifiManager.getConnectionInfo();
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages == null || installedPackages.size() <= 0) {
                return null;
            }
            for (int i = 0; i < installedPackages.size(); i++) {
                try {
                    Intent intent = new Intent();
                    intent.setPackage(installedPackages.get(i).packageName);
                    List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                    int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                    if (size > 0) {
                        int i2 = 0;
                        while (i2 < size) {
                            try {
                                ActivityInfo activityInfo = queryIntentActivities.get(i2).activityInfo;
                                if (activityInfo.name.contains(str)) {
                                    Intent intent2 = new Intent("/");
                                    intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                    intent2.setAction("android.intent.action.VIEW");
                                    context.startActivity(intent2);
                                    return intent2;
                                }
                                i2++;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:10|11|12|13|26) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
        searchIntentByClass(r5, "ManageAccountsSettings");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void startSettingItent(android.content.Context r5, int r6) {
        /*
            r0 = 1
            java.lang.String r1 = "android.intent.action.VIEW"
            java.lang.String r2 = "/"
            if (r6 == r0) goto L_0x0058
            r0 = 2
            if (r6 == r0) goto L_0x0022
            r0 = 3
            if (r6 == r0) goto L_0x000e
            goto L_0x0075
        L_0x000e:
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x001c }
            r6.<init>()     // Catch:{ Exception -> 0x001c }
            java.lang.String r0 = "android.settings.WIFI_IP_SETTINGS"
            r6.setAction(r0)     // Catch:{ Exception -> 0x001c }
            r5.startActivity(r6)     // Catch:{ Exception -> 0x001c }
            goto L_0x0075
        L_0x001c:
            java.lang.String r6 = "AdvancedSettings"
            searchIntentByClass(r5, r6)
            goto L_0x0075
        L_0x0022:
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x003a }
            r6.<init>(r2)     // Catch:{ Exception -> 0x003a }
            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x003a }
            java.lang.String r3 = "com.android.providers.subscribedfeeds"
            java.lang.String r4 = "com.android.settings.ManageAccountsSettings"
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x003a }
            r6.setComponent(r0)     // Catch:{ Exception -> 0x003a }
            r6.setAction(r1)     // Catch:{ Exception -> 0x003a }
            r5.startActivity(r6)     // Catch:{ Exception -> 0x003a }
            goto L_0x0075
        L_0x003a:
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x0052 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x0052 }
            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x0052 }
            java.lang.String r2 = "com.htc.settings.accountsync"
            java.lang.String r3 = "com.htc.settings.accountsync.ManageAccountsSettings"
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x0052 }
            r6.setComponent(r0)     // Catch:{ Exception -> 0x0052 }
            r6.setAction(r1)     // Catch:{ Exception -> 0x0052 }
            r5.startActivity(r6)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0075
        L_0x0052:
            java.lang.String r6 = "ManageAccountsSettings"
            searchIntentByClass(r5, r6)
            goto L_0x0075
        L_0x0058:
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x0070 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x0070 }
            android.content.ComponentName r0 = new android.content.ComponentName     // Catch:{ Exception -> 0x0070 }
            java.lang.String r2 = "com.android.settings"
            java.lang.String r3 = "com.android.settings.DevelopmentSettings"
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x0070 }
            r6.setComponent(r0)     // Catch:{ Exception -> 0x0070 }
            r6.setAction(r1)     // Catch:{ Exception -> 0x0070 }
            r5.startActivity(r6)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0075
        L_0x0070:
            java.lang.String r6 = "DevelopmentSettings"
            searchIntentByClass(r5, r6)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal100.mars.comm.NetStatusUtil.startSettingItent(android.content.Context, int):void");
    }

    public static int getWifiSleeepPolicy(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
    }

    public static int getBackgroundLimitType(Context context) {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                    return 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            int wifiSleeepPolicy = getWifiSleeepPolicy(context);
            if (wifiSleeepPolicy == 2 || getNetType(context) != 0) {
                return 0;
            }
            if (wifiSleeepPolicy == 1 || wifiSleeepPolicy == 0) {
                return 3;
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean isImmediatelyDestroyActivities(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0;
    }

    public static int getProxyInfo(Context context, StringBuffer stringBuffer) {
        try {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost == null || defaultHost.length() <= 0 || defaultPort <= 0) {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                int i = 80;
                if (property2 != null && property2.length() > 0) {
                    i = Integer.parseInt(property2);
                }
                if (property == null || property.length() <= 0) {
                    return 0;
                }
                stringBuffer.append(property);
                return i;
            }
            stringBuffer.append(defaultHost);
            return defaultPort;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean isKnownDirectNet(Context context) {
        int netType = getNetType(context);
        return 6 == netType || 1 == netType || 4 == netType || 8 == netType || 10 == netType || netType == 0;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
            return false;
        }
        return true;
    }

    public static class StrengthListener extends PhoneStateListener {
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if (!signalStrength.isGsm()) {
                int unused = NetStatusUtil.nowStrength = signalStrength.getCdmaDbm();
            } else {
                int unused2 = NetStatusUtil.nowStrength = signalStrength.getGsmSignalStrength();
            }
        }
    }

    public static int getNetTypeForStat(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return UNKNOW_TYPE;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return UNKNOW_TYPE;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 1;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype == 0) {
                return UNKNOW_TYPE;
            }
            return subtype * 1000;
        } catch (Exception e) {
            e.printStackTrace();
            return UNKNOW_TYPE;
        }
    }

    public static int getStrength(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            if (getNetTypeForStat(context) == 1) {
                return Math.abs(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi());
            }
            ((TelephonyManager) context.getSystemService("phone")).listen(new StrengthListener(), 256);
            return Math.abs(nowStrength);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
