package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzjt implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzka zzb;

    zzjt(zzka zzka, long j) {
        this.zzb = zzka;
        this.zza = j;
    }

    public final void run() {
        zzka.zzj(this.zzb, this.zza);
    }
}
