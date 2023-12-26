package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzhq implements Runnable {
    final /* synthetic */ zzah zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzhw zzf;

    zzhq(zzhw zzhw, zzah zzah, long j, int i, long j2, boolean z) {
        this.zzf = zzhw;
        this.zza = zzah;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
    }

    public final void run() {
        this.zzf.zzW(this.zza);
        this.zzf.zzL(this.zzb, false);
        zzhw.zzv(this.zzf, this.zza, this.zzc, this.zzd, true, this.zze);
    }
}
