package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpb;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzgi implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzgj zze;

    zzgi(zzgj zzgj, String str, String str2, String str3, long j) {
        this.zze = zzgj;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        zzpb.zzc();
        if (this.zze.zza.zzg().zzs((String) null, zzdu.zzat)) {
            String str = this.zza;
            if (str == null) {
                this.zze.zza.zzQ(this.zzb, (zzid) null);
                return;
            }
            this.zze.zza.zzQ(this.zzb, new zzid(this.zzc, str, this.zzd));
            return;
        }
        String str2 = this.zza;
        if (str2 == null) {
            this.zze.zza.zzq().zzs().zzy(this.zzb, (zzid) null);
            return;
        }
        this.zze.zza.zzq().zzs().zzy(this.zzb, new zzid(this.zzc, str2, this.zzd));
    }
}
