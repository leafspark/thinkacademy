package com.tal100.mars;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class BaseEvent {
    public static native void onCreate();

    public static native void onDestroy();

    public static native void onExceptionCrash();

    public static native void onForeground(boolean z);

    public static native void onNetworkChange();

    public static native void onSingalCrash(int i);

    public static class ConnectionReceiver extends BroadcastReceiver {
        public static String TAG = "mars.ConnectionReceiver";
        public static NetworkInfo lastActiveNetworkInfo = null;
        public static boolean lastConnected = true;
        public static WifiInfo lastWifiInfo;

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (context != null && intent != null) {
                NetworkInfo networkInfo = null;
                try {
                    networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception unused) {
                    Log.i(TAG, "getActiveNetworkInfo failed.");
                }
                checkConnInfo(context, networkInfo);
            }
        }

        public void checkConnInfo(Context context, NetworkInfo networkInfo) {
            if (networkInfo == null) {
                lastActiveNetworkInfo = null;
                lastWifiInfo = null;
                BaseEvent.onNetworkChange();
            } else if (networkInfo.getDetailedState() != NetworkInfo.DetailedState.CONNECTED) {
                if (lastConnected) {
                    lastActiveNetworkInfo = null;
                    lastWifiInfo = null;
                    BaseEvent.onNetworkChange();
                }
                lastConnected = false;
            } else {
                if (isNetworkChange(context, networkInfo)) {
                    BaseEvent.onNetworkChange();
                }
                lastConnected = true;
            }
        }

        public boolean isNetworkChange(Context context, NetworkInfo networkInfo) {
            WifiInfo wifiInfo;
            if (networkInfo.getType() == 1) {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo == null || (wifiInfo = lastWifiInfo) == null || !wifiInfo.getBSSID().equals(connectionInfo.getBSSID()) || !lastWifiInfo.getSSID().equals(connectionInfo.getSSID()) || lastWifiInfo.getNetworkId() != connectionInfo.getNetworkId()) {
                    lastWifiInfo = connectionInfo;
                } else {
                    Log.w(TAG, "Same Wifi, do not NetworkChanged");
                    return false;
                }
            } else {
                NetworkInfo networkInfo2 = lastActiveNetworkInfo;
                if (networkInfo2 != null && networkInfo2.getExtraInfo() != null && networkInfo.getExtraInfo() != null && lastActiveNetworkInfo.getExtraInfo().equals(networkInfo.getExtraInfo()) && lastActiveNetworkInfo.getSubtype() == networkInfo.getSubtype() && lastActiveNetworkInfo.getType() == networkInfo.getType()) {
                    return false;
                }
                NetworkInfo networkInfo3 = lastActiveNetworkInfo;
                if (networkInfo3 != null && networkInfo3.getExtraInfo() == null && networkInfo.getExtraInfo() == null && lastActiveNetworkInfo.getSubtype() == networkInfo.getSubtype() && lastActiveNetworkInfo.getType() == networkInfo.getType()) {
                    Log.w(TAG, "Same Network, do not NetworkChanged");
                    return false;
                }
            }
            lastActiveNetworkInfo = networkInfo;
            return true;
        }
    }
}
