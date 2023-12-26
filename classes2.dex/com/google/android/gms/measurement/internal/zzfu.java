package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzfu implements Runnable {
    final /* synthetic */ zzab zza;
    final /* synthetic */ zzgj zzb;

    zzfu(zzgj zzgj, zzab zzab) {
        this.zzb = zzgj;
        this.zza = zzab;
    }

    public final void run() {
        this.zzb.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzM(this.zza);
        } else {
            this.zzb.zza.zzS(this.zza);
        }
    }
}
