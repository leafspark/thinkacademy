package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzih implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzik zzb;

    zzih(zzik zzik, long j) {
        this.zzb = zzik;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
