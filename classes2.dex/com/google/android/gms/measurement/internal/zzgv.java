package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final /* synthetic */ class zzgv implements Runnable {
    public final /* synthetic */ zzhw zza;

    public /* synthetic */ zzgv(zzhw zzhw) {
        this.zza = zzhw;
    }

    public final void run() {
        zzhw zzhw = this.zza;
        zzhw.zzg();
        if (!zzhw.zzs.zzm().zzm.zzb()) {
            long zza2 = zzhw.zzs.zzm().zzn.zza();
            zzhw.zzs.zzm().zzn.zzb(1 + zza2);
            zzhw.zzs.zzf();
            if (zza2 >= 5) {
                zzhw.zzs.zzay().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzhw.zzs.zzm().zzm.zza(true);
                return;
            }
            zzhw.zzs.zzE();
            return;
        }
        zzhw.zzs.zzay().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
