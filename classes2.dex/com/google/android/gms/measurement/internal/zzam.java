package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzam implements Runnable {
    final /* synthetic */ zzgm zza;
    final /* synthetic */ zzan zzb;

    zzam(zzan zzan, zzgm zzgm) {
        this.zzb = zzan;
        this.zza = zzgm;
    }

    public final void run() {
        this.zza.zzaw();
        if (zzaa.zza()) {
            this.zza.zzaz().zzp(this);
            return;
        }
        boolean zze = this.zzb.zze();
        this.zzb.zzd = 0;
        if (zze) {
            this.zzb.zzc();
        }
    }
}
