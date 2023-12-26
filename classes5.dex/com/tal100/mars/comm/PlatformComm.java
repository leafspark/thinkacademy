package com.tal100.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.File;

public class PlatformComm {
    static final int EMobile = 2;
    static final int ENoNet = -1;
    static final int EOtherNet = 3;
    static final int EWifi = 1;
    private static final boolean IS_PROXY_ON = false;
    static final int NETTYPE_2G = 3;
    static final int NETTYPE_3G = 4;
    static final int NETTYPE_4G = 5;
    static final int NETTYPE_NON = -1;
    static final int NETTYPE_NOT_WIFI = 0;
    static final int NETTYPE_UNKNOWN = 6;
    static final int NETTYPE_WAP = 2;
    static final int NETTYPE_WIFI = 1;
    private static final String TAG = "PlatformComm";
    public static Context context;
    public static Handler handler;

    public static String getAppFilePath() {
        Context context2 = context;
        if (context2 == null) {
            return null;
        }
        try {
            File filesDir = context2.getFilesDir();
            if (!filesDir.exists()) {
                filesDir.createNewFile();
            }
            return filesDir.toString();
        } catch (Exception e) {
            Log.e(TAG, "DeviceInfo cannot find the App Path", e);
            return null;
        }
    }

    static class WifiInfo {
        public String bssid;
        public String ssid;

        WifiInfo() {
        }
    }

    static class SIMInfo {
        public String ispCode;
        public String ispName;

        SIMInfo() {
        }
    }

    static class APNInfo {
        public String extraInfo;
        public int netType;
        public int subNetType;

        APNInfo() {
        }
    }

    public static void init(Context context2, Handler handler2) {
        context = context2;
        handler = handler2;
        NetworkSignalUtil.InitNetworkSignalUtil(context2);
    }

    public static class C2Java {
        public static int getProxyInfo(StringBuffer stringBuffer) {
            return -1;
        }

        public static int getNetInfo() {
            NetworkInfo activeNetworkInfo;
            if (PlatformComm.context == null) {
                return 1;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            try {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 1;
                    }
                    if (type == 2 || type == 3 || type == 4 || type == 5) {
                        return 2;
                    }
                    return 3;
                }
                return 2;
            } catch (Exception e) {
                e.printStackTrace();
                return 3;
            }
        }

        public static int getStatisticsNetType() {
            if (PlatformComm.context == null) {
                return 0;
            }
            try {
                int netType = NetStatusUtil.getNetType(PlatformComm.context);
                if (netType == -1) {
                    return -1;
                }
                if (NetStatusUtil.is2G(PlatformComm.context)) {
                    return 3;
                }
                if (NetStatusUtil.is3G(PlatformComm.context)) {
                    return 4;
                }
                if (NetStatusUtil.is4G(PlatformComm.context)) {
                    return 5;
                }
                if (NetStatusUtil.isWifi(netType)) {
                    return 1;
                }
                return NetStatusUtil.isWap(netType) ? 2 : 6;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        public static boolean startAlarm(int i, int i2) {
            if (PlatformComm.context == null) {
                return false;
            }
            try {
                return Alarm.start((long) i, i2, PlatformComm.context);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public static boolean stopAlarm(int i) {
            if (PlatformComm.context == null) {
                return false;
            }
            try {
                return Alarm.stop((long) i, PlatformComm.context);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public static WifiInfo getCurWifiInfo() {
            ConnectivityManager connectivityManager;
            NetworkInfo activeNetworkInfo;
            android.net.wifi.WifiInfo connectionInfo;
            try {
                if (!(PlatformComm.context == null || (connectivityManager = (ConnectivityManager) PlatformComm.context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                    if (1 == activeNetworkInfo.getType()) {
                        WifiManager wifiManager = (WifiManager) PlatformComm.context.getSystemService("wifi");
                        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                            return null;
                        }
                        WifiInfo wifiInfo = new WifiInfo();
                        wifiInfo.ssid = connectionInfo.getSSID();
                        wifiInfo.bssid = connectionInfo.getBSSID();
                        return wifiInfo;
                    }
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static SIMInfo getCurSIMInfo() {
            int iSPCode;
            try {
                if (PlatformComm.context == null || (iSPCode = NetStatusUtil.getISPCode(PlatformComm.context)) == 0) {
                    return null;
                }
                SIMInfo sIMInfo = new SIMInfo();
                sIMInfo.ispCode = "" + iSPCode;
                sIMInfo.ispName = NetStatusUtil.getISPName(PlatformComm.context);
                return sIMInfo;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static APNInfo getAPNInfo() {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) PlatformComm.context.getSystemService("connectivity")).getActiveNetworkInfo();
                APNInfo aPNInfo = new APNInfo();
                if (activeNetworkInfo == null) {
                    return null;
                }
                aPNInfo.netType = activeNetworkInfo.getType();
                aPNInfo.subNetType = activeNetworkInfo.getSubtype();
                if (1 != activeNetworkInfo.getType()) {
                    aPNInfo.extraInfo = activeNetworkInfo.getExtraInfo() == null ? "" : activeNetworkInfo.getExtraInfo();
                } else {
                    aPNInfo.extraInfo = getCurWifiInfo().ssid;
                }
                return aPNInfo;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static int getCurRadioAccessNetworkInfo() {
            if (PlatformComm.context == null) {
                return 0;
            }
            try {
                return ((TelephonyManager) PlatformComm.context.getSystemService("phone")).getNetworkType();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        public static long getSignal(boolean z) {
            try {
                if (PlatformComm.context == null) {
                    return 0;
                }
                if (z) {
                    return NetworkSignalUtil.getWifiSignalStrength();
                }
                return NetworkSignalUtil.getGSMSignalStrength();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }

        public static boolean isNetworkConnected() {
            if (PlatformComm.context == null) {
                return false;
            }
            try {
                return NetStatusUtil.isNetworkConnected(PlatformComm.context);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        public static WakerLock wakeupLock_new() {
            if (PlatformComm.context == null) {
                return null;
            }
            try {
                return new WakerLock(PlatformComm.context);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
