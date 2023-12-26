package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzgd implements Runnable {
    final /* synthetic */ zzau zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgj zzc;

    zzgd(zzgj zzgj, zzau zzau, String str) {
        this.zzc = zzgj;
        this.zza = zzau;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzA();
        this.zzc.zza.zzE(this.zza, this.zzb);
    }
}
