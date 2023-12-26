package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzgc implements Runnable {
    final /* synthetic */ zzau zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgj zzc;

    zzgc(zzgj zzgj, zzau zzau, zzp zzp) {
        this.zzc = zzgj;
        this.zza = zzau;
        this.zzb = zzp;
    }

    public final void run() {
        this.zzc.zzv(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
