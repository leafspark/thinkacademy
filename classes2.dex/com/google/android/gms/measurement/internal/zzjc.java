package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzjc implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzp zzc;
    final /* synthetic */ zzcf zzd;
    final /* synthetic */ zzjk zze;

    zzjc(zzjk zzjk, String str, String str2, zzp zzp, zzcf zzcf) {
        this.zze = zzjk;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzp;
        this.zzd = zzcf;
    }

    public final void run() {
        zzfr zzfr;
        ArrayList arrayList = new ArrayList();
        try {
            zzjk zzjk = this.zze;
            zzdx zzh = zzjk.zzb;
            if (zzh == null) {
                zzjk.zzs.zzay().zzd().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                zzfr = this.zze.zzs;
            } else {
                Preconditions.checkNotNull(this.zzc);
                arrayList = zzkw.zzG(zzh.zzf(this.zza, this.zzb, this.zzc));
                this.zze.zzQ();
                zzfr = this.zze.zzs;
            }
        } catch (RemoteException e) {
            this.zze.zzs.zzay().zzd().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
            zzfr = this.zze.zzs;
        } catch (Throwable th) {
            this.zze.zzs.zzv().zzP(this.zzd, arrayList);
            throw th;
        }
        zzfr.zzv().zzP(this.zzd, arrayList);
    }
}
