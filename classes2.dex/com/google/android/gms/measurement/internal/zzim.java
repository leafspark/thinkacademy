package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzim implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzks zzc;
    final /* synthetic */ zzjk zzd;

    zzim(zzjk zzjk, zzp zzp, boolean z, zzks zzks) {
        this.zzd = zzjk;
        this.zza = zzp;
        this.zzb = z;
        this.zzc = zzks;
    }

    public final void run() {
        zzks zzks;
        zzjk zzjk = this.zzd;
        zzdx zzh = zzjk.zzb;
        if (zzh == null) {
            zzjk.zzs.zzay().zzd().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjk zzjk2 = this.zzd;
        if (this.zzb) {
            zzks = null;
        } else {
            zzks = this.zzc;
        }
        zzjk2.zzD(zzh, zzks, this.zza);
        this.zzd.zzQ();
    }
}
