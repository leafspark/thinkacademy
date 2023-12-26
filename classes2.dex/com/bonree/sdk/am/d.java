package com.bonree.sdk.am;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

final class d extends BroadcastReceiver {
    private /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        try {
            int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
            this.a.b = (intExtra * 100) / intent.getIntExtra("scale", 100);
        } catch (Throwable unused) {
        }
    }
}
