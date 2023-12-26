package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzit implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzjk zzc;

    zzit(zzjk zzjk, zzp zzp, Bundle bundle) {
        this.zzc = zzjk;
        this.zza = zzp;
        this.zzb = bundle;
    }

    public final void run() {
        zzjk zzjk = this.zzc;
        zzdx zzh = zzjk.zzb;
        if (zzh == null) {
            zzjk.zzs.zzay().zzd().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzh.zzr(this.zzb, this.zza);
        } catch (RemoteException e) {
            this.zzc.zzs.zzay().zzd().zzb("Failed to send default event parameters to service", e);
        }
    }
}
