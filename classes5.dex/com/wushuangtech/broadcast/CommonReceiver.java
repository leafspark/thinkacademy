package com.wushuangtech.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;

public class CommonReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        String action = intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            if ("android.intent.action.CONFIGURATION_CHANGED".equals(action)) {
                recvBroadcastToHandingConfigChanged();
            } else if ("android.net.wifi.RSSI_CHANGED".equals(action)) {
                GlobalConfig.mWifiRSSI = intent.getIntExtra("newRssi", -10000);
            }
        }
    }

    private void recvBroadcastToHandingConfigChanged() {
        GlobalHolder.getInstance().sendSyncGlobalMessage(4, new Object[0]);
    }
}
