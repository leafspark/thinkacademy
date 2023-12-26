package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzjh implements Runnable {
    final /* synthetic */ zzjj zza;

    zzjh(zzjj zzjj) {
        this.zza = zzjj;
    }

    public final void run() {
        zzjk zzjk = this.zza.zza;
        Context zzau = zzjk.zzs.zzau();
        this.zza.zza.zzs.zzaw();
        zzjk.zzo(zzjk, new ComponentName(zzau, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
