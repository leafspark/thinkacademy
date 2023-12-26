package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzii implements Runnable {
    final /* synthetic */ zzid zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzik zzc;

    zzii(zzik zzik, zzid zzid, long j) {
        this.zzc = zzik;
        this.zza = zzid;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzC(this.zza, false, this.zzb);
        zzik zzik = this.zzc;
        zzik.zza = null;
        zzik.zzs.zzt().zzG((zzid) null);
    }
}
