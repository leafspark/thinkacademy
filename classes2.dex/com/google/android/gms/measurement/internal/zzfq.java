package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzfq implements Runnable {
    final /* synthetic */ zzgu zza;
    final /* synthetic */ zzfr zzb;

    zzfq(zzfr zzfr, zzgu zzgu) {
        this.zzb = zzfr;
        this.zza = zzgu;
    }

    public final void run() {
        zzfr.zzA(this.zzb, this.zza);
        this.zzb.zzH(this.zza.zzg);
    }
}
