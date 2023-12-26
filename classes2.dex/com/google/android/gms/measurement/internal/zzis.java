package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzis implements Runnable {
    final /* synthetic */ zzid zza;
    final /* synthetic */ zzjk zzb;

    zzis(zzjk zzjk, zzid zzid) {
        this.zzb = zzjk;
        this.zza = zzid;
    }

    public final void run() {
        zzjk zzjk = this.zzb;
        zzdx zzh = zzjk.zzb;
        if (zzh == null) {
            zzjk.zzs.zzay().zzd().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzid zzid = this.zza;
            if (zzid == null) {
                zzh.zzq(0, (String) null, (String) null, zzjk.zzs.zzau().getPackageName());
            } else {
                zzh.zzq(zzid.zzc, zzid.zza, zzid.zzb, zzjk.zzs.zzau().getPackageName());
            }
            this.zzb.zzQ();
        } catch (RemoteException e) {
            this.zzb.zzs.zzay().zzd().zzb("Failed to send current screen to the service", e);
        }
    }
}
