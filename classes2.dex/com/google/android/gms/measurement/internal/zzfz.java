package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzfz implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgj zzb;

    zzfz(zzgj zzgj, zzp zzp) {
        this.zzb = zzgj;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzP(this.zza);
    }
}
