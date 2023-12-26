package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzkc extends zzan {
    final /* synthetic */ zzkd zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzkc(zzkd zzkd, zzgm zzgm) {
        super(zzgm);
        this.zza = zzkd;
    }

    public final void zzc() {
        this.zza.zza();
        this.zza.zzs.zzay().zzj().zza("Starting upload from DelayedRunnable");
        this.zza.zzf.zzW();
    }
}
