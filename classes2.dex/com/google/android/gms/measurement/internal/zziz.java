package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zziz implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzau zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzjk zze;

    zziz(zzjk zzjk, boolean z, zzp zzp, boolean z2, zzau zzau, String str) {
        this.zze = zzjk;
        this.zza = zzp;
        this.zzb = z2;
        this.zzc = zzau;
        this.zzd = str;
    }

    public final void run() {
        zzau zzau;
        zzjk zzjk = this.zze;
        zzdx zzh = zzjk.zzb;
        if (zzh == null) {
            zzjk.zzs.zzay().zzd().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzjk zzjk2 = this.zze;
        if (this.zzb) {
            zzau = null;
        } else {
            zzau = this.zzc;
        }
        zzjk2.zzD(zzh, zzau, this.zza);
        this.zze.zzQ();
    }
}
