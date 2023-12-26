package com.sensorsdata.analytics.android.sdk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {
    private static final int HTTP_307 = 307;
    private static final String TAG = "SA.NetworkUtils";
    private static SABroadcastReceiver mReceiver;
    private static SANetworkCallbackImpl networkCallback;
    private static String networkType;

    public static boolean needRedirects(int i) {
        return i == 301 || i == 302 || i == HTTP_307;
    }

    public static String networkType(Context context) {
        try {
            if (!TextUtils.isEmpty(networkType) && !"NULL".equals(networkType)) {
                return networkType;
            }
            if (!SensorsDataUtils.checkHasPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                networkType = "NULL";
                return "NULL";
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                if (!isNetworkAvailable(connectivityManager)) {
                    networkType = "NULL";
                    return "NULL";
                } else if (isWiFiNetwork(connectivityManager)) {
                    networkType = "WIFI";
                    return "WIFI";
                }
            }
            String mobileNetworkType = mobileNetworkType(context, (TelephonyManager) context.getSystemService("phone"), connectivityManager);
            networkType = mobileNetworkType;
            return mobileNetworkType;
        } catch (Exception e) {
            SALog.printStackTrace(e);
            networkType = "NULL";
            return "NULL";
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        if (!SensorsDataUtils.checkHasPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return false;
        }
        try {
            return isNetworkAvailable((ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e) {
            SALog.printStackTrace(e);
            return false;
        }
    }

    public static boolean isShouldFlush(String str, int i) {
        return (toNetworkType(str) & i) != 0;
    }

    private static int toNetworkType(String str) {
        if ("NULL".equals(str)) {
            return 255;
        }
        if ("WIFI".equals(str)) {
            return 8;
        }
        if ("2G".equals(str)) {
            return 1;
        }
        if ("3G".equals(str)) {
            return 2;
        }
        if ("4G".equals(str)) {
            return 4;
        }
        if ("5G".equals(str)) {
            return 16;
        }
        return 255;
    }

    public static boolean isNetworkValid(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return false;
        }
        if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(7) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16)) {
            return true;
        }
        return false;
    }

    public static String getLocation(HttpURLConnection httpURLConnection, String str) throws MalformedURLException {
        if (httpURLConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            headerField = httpURLConnection.getHeaderField("location");
        }
        if (TextUtils.isEmpty(headerField)) {
            return null;
        }
        if (headerField.startsWith("http://") || headerField.startsWith("https://")) {
            return headerField;
        }
        URL url = new URL(str);
        return url.getProtocol() + "://" + url.getHost() + headerField;
    }

    public static void registerNetworkListener(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                if (mReceiver == null) {
                    mReceiver = new SABroadcastReceiver();
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(mReceiver, intentFilter);
                SALog.i(TAG, "Register BroadcastReceiver");
                return;
            }
            if (networkCallback == null) {
                networkCallback = new SANetworkCallbackImpl();
            }
            NetworkRequest build = new NetworkRequest.Builder().build();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(build, networkCallback);
                SALog.i(TAG, "Register ConnectivityManager");
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public static void unregisterNetworkListener(Context context) {
        ConnectivityManager connectivityManager;
        try {
            if (Build.VERSION.SDK_INT < 21) {
                SABroadcastReceiver sABroadcastReceiver = mReceiver;
                if (sABroadcastReceiver != null) {
                    context.unregisterReceiver(sABroadcastReceiver);
                    SALog.i(TAG, "unregisterReceiver BroadcastReceiver");
                }
            } else if (networkCallback != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                connectivityManager.unregisterNetworkCallback(networkCallback);
                SALog.i(TAG, "unregister ConnectivityManager");
            }
        } catch (Exception e) {
            SALog.printStackTrace(e);
        }
    }

    public static void cleanNetworkTypeCache() {
        networkType = null;
    }

    private static boolean isNetworkAvailable(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        if (connectivityManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return isNetworkValid(networkCapabilities);
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    private static boolean isWiFiNetwork(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        if (Build.VERSION.SDK_INT >= 23) {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasTransport(1);
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0041 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0047 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String mobileNetworkType(android.content.Context r2, android.telephony.TelephonyManager r3, android.net.ConnectivityManager r4) {
        /*
            r0 = 30
            if (r3 == 0) goto L_0x0024
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x001b
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            boolean r2 = com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils.checkHasPermission(r2, r1)
            if (r2 != 0) goto L_0x0016
            boolean r2 = r3.hasCarrierPrivileges()
            if (r2 == 0) goto L_0x001b
        L_0x0016:
            int r2 = r3.getDataNetworkType()
            goto L_0x0025
        L_0x001b:
            int r2 = r3.getNetworkType()     // Catch:{ Exception -> 0x0020 }
            goto L_0x0025
        L_0x0020:
            r2 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r2)
        L_0x0024:
            r2 = 0
        L_0x0025:
            java.lang.String r3 = "NULL"
            if (r2 != 0) goto L_0x003a
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r0) goto L_0x002e
            return r3
        L_0x002e:
            if (r4 == 0) goto L_0x003a
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()
            if (r4 == 0) goto L_0x003a
            int r2 = r4.getSubtype()
        L_0x003a:
            switch(r2) {
                case 1: goto L_0x0047;
                case 2: goto L_0x0047;
                case 3: goto L_0x0044;
                case 4: goto L_0x0047;
                case 5: goto L_0x0044;
                case 6: goto L_0x0044;
                case 7: goto L_0x0047;
                case 8: goto L_0x0044;
                case 9: goto L_0x0044;
                case 10: goto L_0x0044;
                case 11: goto L_0x0047;
                case 12: goto L_0x0044;
                case 13: goto L_0x0041;
                case 14: goto L_0x0044;
                case 15: goto L_0x0044;
                case 16: goto L_0x003d;
                case 17: goto L_0x003d;
                case 18: goto L_0x0041;
                case 19: goto L_0x0041;
                case 20: goto L_0x003e;
                default: goto L_0x003d;
            }
        L_0x003d:
            return r3
        L_0x003e:
            java.lang.String r2 = "5G"
            return r2
        L_0x0041:
            java.lang.String r2 = "4G"
            return r2
        L_0x0044:
            java.lang.String r2 = "3G"
            return r2
        L_0x0047:
            java.lang.String r2 = "2G"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.NetworkUtils.mobileNetworkType(android.content.Context, android.telephony.TelephonyManager, android.net.ConnectivityManager):java.lang.String");
    }

    private static class SABroadcastReceiver extends BroadcastReceiver {
        private SABroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                NetworkUtils.cleanNetworkTypeCache();
                SensorsDataAPI.sharedInstance().flush();
                SALog.i(NetworkUtils.TAG, "SABroadcastReceiver is receiving ConnectivityManager.CONNECTIVITY_ACTION broadcast");
            }
        }
    }

    private static class SANetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
        private SANetworkCallbackImpl() {
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            NetworkUtils.cleanNetworkTypeCache();
            SensorsDataAPI.sharedInstance().flush();
            SALog.i(NetworkUtils.TAG, "onAvailable is calling");
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            NetworkUtils.cleanNetworkTypeCache();
            SALog.i(NetworkUtils.TAG, "onCapabilitiesChanged is calling");
        }

        public void onLost(Network network) {
            super.onLost(network);
            NetworkUtils.cleanNetworkTypeCache();
            SALog.i(NetworkUtils.TAG, "onLost is calling");
        }
    }
}
