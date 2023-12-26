package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzfa;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzfa.zza {
    private zzfa zza;

    public BroadcastReceiver.PendingResult doGoAsync() {
        return goAsync();
    }

    public void doStartService(Context context, Intent intent) {
        startWakefulService(context, intent);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfa(this);
        }
        this.zza.zza(context, intent);
    }
}
