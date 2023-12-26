package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zziv implements Runnable {
    final /* synthetic */ zzau zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcf zzc;
    final /* synthetic */ zzjk zzd;

    zziv(zzjk zzjk, zzau zzau, String str, zzcf zzcf) {
        this.zzd = zzjk;
        this.zza = zzau;
        this.zzb = str;
        this.zzc = zzcf;
    }

    public final void run() {
        zzfr zzfr;
        byte[] bArr = null;
        try {
            zzjk zzjk = this.zzd;
            zzdx zzh = zzjk.zzb;
            if (zzh == null) {
                zzjk.zzs.zzay().zzd().zza("Discarding data. Failed to send event to service to bundle");
                zzfr = this.zzd.zzs;
            } else {
                bArr = zzh.zzu(this.zza, this.zzb);
                this.zzd.zzQ();
                zzfr = this.zzd.zzs;
            }
        } catch (RemoteException e) {
            this.zzd.zzs.zzay().zzd().zzb("Failed to send event to the service to bundle", e);
            zzfr = this.zzd.zzs;
        } catch (Throwable th) {
            this.zzd.zzs.zzv().zzR(this.zzc, bArr);
            throw th;
        }
        zzfr.zzv().zzR(this.zzc, bArr);
    }
}
