package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzhr implements Runnable {
    final /* synthetic */ zzah zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzhw zze;

    zzhr(zzhw zzhw, zzah zzah, int i, long j, boolean z) {
        this.zze = zzhw;
        this.zza = zzah;
        this.zzb = i;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zzW(this.zza);
        zzhw.zzv(this.zze, this.zza, this.zzb, this.zzc, false, this.zzd);
    }
}
