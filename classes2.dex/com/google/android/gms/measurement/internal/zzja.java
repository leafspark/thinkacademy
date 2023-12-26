package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzja implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzab zzc;
    final /* synthetic */ zzab zzd;
    final /* synthetic */ zzjk zze;

    zzja(zzjk zzjk, boolean z, zzp zzp, boolean z2, zzab zzab, zzab zzab2) {
        this.zze = zzjk;
        this.zza = zzp;
        this.zzb = z2;
        this.zzc = zzab;
        this.zzd = zzab2;
    }

    public final void run() {
        zzab zzab;
        zzjk zzjk = this.zze;
        zzdx zzh = zzjk.zzb;
        if (zzh == null) {
            zzjk.zzs.zzay().zzd().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjk zzjk2 = this.zze;
        if (this.zzb) {
            zzab = null;
        } else {
            zzab = this.zzc;
        }
        zzjk2.zzD(zzh, zzab, this.zza);
        this.zze.zzQ();
    }
}
