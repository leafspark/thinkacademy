package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzgh implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgj zzb;

    zzgh(zzgj zzgj, zzp zzp) {
        this.zzb = zzgj;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzK(this.zza);
    }
}
