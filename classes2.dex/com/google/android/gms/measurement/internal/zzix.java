package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzix implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzjk zzb;

    zzix(zzjk zzjk, zzp zzp) {
        this.zzb = zzjk;
        this.zza = zzp;
    }

    public final void run() {
        zzjk zzjk = this.zzb;
        zzdx zzh = zzjk.zzb;
        if (zzh == null) {
            zzjk.zzs.zzay().zzd().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzs(this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e) {
            this.zzb.zzs.zzay().zzd().zzb("Failed to send measurementEnabled to the service", e);
        }
    }
}
