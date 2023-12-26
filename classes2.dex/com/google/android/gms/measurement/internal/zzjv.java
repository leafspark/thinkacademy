package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzjv implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzjw zzc;

    zzjv(zzjw zzjw, long j, long j2) {
        this.zzc = zzjw;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzs.zzaz().zzp(new zzju(this));
    }
}
