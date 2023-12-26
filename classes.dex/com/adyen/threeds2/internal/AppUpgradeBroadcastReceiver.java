package com.adyen.threeds2.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import atd.k0.b;
import atd.s0.a;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class AppUpgradeBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if (a.a(-105156643187264L).equals(intent.getAction()) && context.getPackageName().equals(intent.getPackage())) {
            e.a(context, b.a()).c(context);
        }
    }
}
