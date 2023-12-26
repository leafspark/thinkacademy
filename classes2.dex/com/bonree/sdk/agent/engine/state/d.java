package com.bonree.sdk.agent.engine.state;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

final class d extends BroadcastReceiver {
    private /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        this.a.a(true);
        boolean unused = this.a.f = false;
    }
}
