package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzgb implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzgj zzb;

    zzgb(zzgj zzgj, zzp zzp) {
        this.zzb = zzgj;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzA();
        zzkp zzc = this.zzb.zza;
        zzp zzp = this.zza;
        zzc.zzaz().zzg();
        zzc.zzB();
        Preconditions.checkNotEmpty(zzp.zza);
        zzah zzb2 = zzah.zzb(zzp.zzv);
        zzah zzh = zzc.zzh(zzp.zza);
        zzc.zzay().zzj().zzc("Setting consent, package, consent", zzp.zza, zzb2);
        zzc.zzU(zzp.zza, zzb2);
        if (zzb2.zzk(zzh)) {
            zzc.zzP(zzp);
        }
    }
}
