package com.eaydu.omni.log;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;

public class NetUtils {
    public static final int NETWORK_2G = 1;
    public static final int NETWORK_3G = 2;
    public static final int NETWORK_4G = 3;
    public static final int NETWORK_MOBILE = 4;
    public static final int NETWORK_NONE = 10;
    public static final int NETWORK_WIFI = 5;

    public static String getOperatorName(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static int getNetworkType(Context context) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        try {
            if (context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return 10;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasCapability(12)) {
                    return 10;
                }
                if (networkCapabilities.hasTransport(1)) {
                    return 5;
                }
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnected()) {
                        if (1 == activeNetworkInfo.getType()) {
                            return 5;
                        }
                    }
                }
                return 10;
            }
            return getMobileNetType(context);
        } catch (Exception unused) {
        }
    }

    private static int getMobileNetType(Context context) {
        int i;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return 10;
        }
        if (Build.VERSION.SDK_INT < 24) {
            i = telephonyManager.getNetworkType();
        } else if (context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) == 0) {
            i = telephonyManager.getDataNetworkType();
        } else if (Build.VERSION.SDK_INT >= 30) {
            return 10;
        } else {
            i = telephonyManager.getNetworkType();
        }
        if (!(i == 19 || i == 20)) {
            switch (i) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 1;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 2;
                case 13:
                    break;
                default:
                    return 10;
            }
        }
        return 3;
    }

    public static int getNetworkState(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
                if (activeNetworkInfo.isAvailable()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                        return 5;
                    }
                    switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 1;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 2;
                        case 13:
                            return 3;
                        default:
                            return 4;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r1.getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isNetConnected(android.content.Context r1) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            if (r1 == 0) goto L_0x0020
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            if (r1 == 0) goto L_0x0020
            boolean r0 = r1.isConnected()
            if (r0 == 0) goto L_0x0020
            android.net.NetworkInfo$State r1 = r1.getState()
            android.net.NetworkInfo$State r0 = android.net.NetworkInfo.State.CONNECTED
            if (r1 != r0) goto L_0x0020
            r1 = 1
            return r1
        L_0x0020:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.log.NetUtils.isNetConnected(android.content.Context):boolean");
    }

    public static synchronized boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        int type;
        synchronized (NetUtils.class) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || ((type = activeNetworkInfo.getType()) != 1 && type != 9)) {
                return false;
            }
            boolean isConnected = activeNetworkInfo.isConnected();
            return isConnected;
        }
    }

    public static String getLocalIpV4Address() {
        try {
            Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator<T> it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it2.next();
                        if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
                            return inetAddress.getHostAddress();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            Log.e("localip", e.toString());
            return null;
        }
    }
}
