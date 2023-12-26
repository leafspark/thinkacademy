package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzip implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzp zzb;
    final /* synthetic */ zzjk zzc;

    zzip(zzjk zzjk, AtomicReference atomicReference, zzp zzp) {
        this.zzc = zzjk;
        this.zza = atomicReference;
        this.zzb = zzp;
    }

    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                if (!this.zzc.zzs.zzm().zzc().zzi(zzag.ANALYTICS_STORAGE)) {
                    this.zzc.zzs.zzay().zzl().zza("Analytics storage consent denied; will not get app instance id");
                    this.zzc.zzs.zzq().zzO((String) null);
                    this.zzc.zzs.zzm().zze.zzb((String) null);
                    this.zza.set((Object) null);
                    this.zza.notify();
                    return;
                }
                zzjk zzjk = this.zzc;
                zzdx zzh = zzjk.zzb;
                if (zzh == null) {
                    zzjk.zzs.zzay().zzd().zza("Failed to get app instance id");
                    this.zza.notify();
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzh.zzd(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    this.zzc.zzs.zzq().zzO(str);
                    this.zzc.zzs.zzm().zze.zzb(str);
                }
                this.zzc.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzc.zzs.zzay().zzd().zzb("Failed to get app instance id", e);
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
