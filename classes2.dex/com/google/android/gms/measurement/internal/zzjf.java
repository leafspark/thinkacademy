package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzjf implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzjj zzb;

    zzjf(zzjj zzjj, ComponentName componentName) {
        this.zzb = zzjj;
        this.zza = componentName;
    }

    public final void run() {
        zzjk.zzo(this.zzb.zza, this.zza);
    }
}
