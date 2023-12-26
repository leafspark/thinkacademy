package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zziq implements Runnable {
    final /* synthetic */ zzp zza;
    final /* synthetic */ zzcf zzb;
    final /* synthetic */ zzjk zzc;

    zziq(zzjk zzjk, zzp zzp, zzcf zzcf) {
        this.zzc = zzjk;
        this.zza = zzp;
        this.zzb = zzcf;
    }

    public final void run() {
        zzfr zzfr;
        String str = null;
        try {
            if (!this.zzc.zzs.zzm().zzc().zzi(zzag.ANALYTICS_STORAGE)) {
                this.zzc.zzs.zzay().zzl().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzs.zzq().zzO((String) null);
                this.zzc.zzs.zzm().zze.zzb((String) null);
                zzfr = this.zzc.zzs;
            } else {
                zzjk zzjk = this.zzc;
                zzdx zzh = zzjk.zzb;
                if (zzh == null) {
                    zzjk.zzs.zzay().zzd().zza("Failed to get app instance id");
                    zzfr = this.zzc.zzs;
                } else {
                    Preconditions.checkNotNull(this.zza);
                    str = zzh.zzd(this.zza);
                    if (str != null) {
                        this.zzc.zzs.zzq().zzO(str);
                        this.zzc.zzs.zzm().zze.zzb(str);
                    }
                    this.zzc.zzQ();
                    zzfr = this.zzc.zzs;
                }
            }
        } catch (RemoteException e) {
            this.zzc.zzs.zzay().zzd().zzb("Failed to get app instance id", e);
            zzfr = this.zzc.zzs;
        } catch (Throwable th) {
            this.zzc.zzs.zzv().zzU(this.zzb, (String) null);
            throw th;
        }
        zzfr.zzv().zzU(this.zzb, str);
    }
}
