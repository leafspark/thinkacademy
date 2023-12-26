package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzgf implements Runnable {
    final /* synthetic */ zzks zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzgj zzc;

    zzgf(zzgj zzgj, zzks zzks, zzp zzp) {
        this.zzc = zzgj;
        this.zza = zzks;
        this.zzb = zzp;
    }

    public final void run() {
        this.zzc.zza.zzA();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzO(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzV(this.zza, this.zzb);
        }
    }
}
