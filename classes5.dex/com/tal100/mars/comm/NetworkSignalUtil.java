package com.tal100.mars.comm;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;

public class NetworkSignalUtil {
    public static final String TAG = "MicroMsg.NetworkSignalUtil";
    private static Context context = null;
    private static boolean hasInit = false;
    private static long strength = 10000;

    public static long getNetworkSignalStrength(boolean z) {
        return 0;
    }

    public static void InitNetworkSignalUtil(Context context2) {
        context = context2;
        try {
            if (!hasInit) {
                ((TelephonyManager) context2.getSystemService("phone")).listen(new PhoneStateListener() {
                    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                        super.onSignalStrengthsChanged(signalStrength);
                        NetworkSignalUtil.calSignalStrength(signalStrength);
                    }
                }, 256);
                hasInit = true;
            }
        } catch (Exception e) {
            Log.e(TAG, "", e);
        }
    }

    public static long getGSMSignalStrength() {
        return strength;
    }

    public static long getWifiSignalStrength() {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null || connectionInfo.getBSSID() == null) {
            return 0;
        }
        int calculateSignalLevel = WifiManager.calculateSignalLevel(connectionInfo.getRssi(), 10);
        if (calculateSignalLevel > 10) {
            calculateSignalLevel = 10;
        }
        if (calculateSignalLevel < 0) {
            calculateSignalLevel = 0;
        }
        return (long) (calculateSignalLevel * 10);
    }

    /* access modifiers changed from: private */
    public static void calSignalStrength(SignalStrength signalStrength) {
        int i;
        if (signalStrength.isGsm()) {
            i = signalStrength.getGsmSignalStrength();
        } else {
            i = (signalStrength.getCdmaDbm() + 113) / 2;
        }
        long j = 0;
        if (!signalStrength.isGsm() || i != 99) {
            long j2 = (long) (((float) i) * 3.2258065f);
            strength = j2;
            if (j2 > 100) {
                j2 = 100;
            }
            strength = j2;
            if (j2 >= 0) {
                j = j2;
            }
            strength = j;
            return;
        }
        strength = 0;
    }
}
