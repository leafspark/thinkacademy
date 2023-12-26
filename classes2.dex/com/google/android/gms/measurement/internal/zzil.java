package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzil implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzp zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzcf zze;
    final /* synthetic */ zzjk zzf;

    zzil(zzjk zzjk, String str, String str2, zzp zzp, boolean z, zzcf zzcf) {
        this.zzf = zzjk;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzp;
        this.zzd = z;
        this.zze = zzcf;
    }

    public final void run() {
        Throwable th;
        Bundle bundle;
        RemoteException e;
        Bundle bundle2 = new Bundle();
        try {
            zzjk zzjk = this.zzf;
            zzdx zzh = zzjk.zzb;
            if (zzh == null) {
                zzjk.zzs.zzay().zzd().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                this.zzf.zzs.zzv().zzQ(this.zze, bundle2);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            List<zzks> zzh2 = zzh.zzh(this.zza, this.zzb, this.zzd, this.zzc);
            bundle = new Bundle();
            if (zzh2 != null) {
                for (zzks zzks : zzh2) {
                    String str = zzks.zze;
                    if (str != null) {
                        bundle.putString(zzks.zzb, str);
                    } else {
                        Long l = zzks.zzd;
                        if (l != null) {
                            bundle.putLong(zzks.zzb, l.longValue());
                        } else {
                            Double d = zzks.zzg;
                            if (d != null) {
                                bundle.putDouble(zzks.zzb, d.doubleValue());
                            }
                        }
                    }
                }
            }
            try {
                this.zzf.zzQ();
                this.zzf.zzs.zzv().zzQ(this.zze, bundle);
            } catch (RemoteException e2) {
                e = e2;
                try {
                    this.zzf.zzs.zzay().zzd().zzc("Failed to get user properties; remote exception", this.zza, e);
                    this.zzf.zzs.zzv().zzQ(this.zze, bundle);
                } catch (Throwable th2) {
                    th = th2;
                    bundle2 = bundle;
                    this.zzf.zzs.zzv().zzQ(this.zze, bundle2);
                    throw th;
                }
            }
        } catch (RemoteException e3) {
            bundle = bundle2;
            e = e3;
            this.zzf.zzs.zzay().zzd().zzc("Failed to get user properties; remote exception", this.zza, e);
            this.zzf.zzs.zzv().zzQ(this.zze, bundle);
        } catch (Throwable th3) {
            th = th3;
            this.zzf.zzs.zzv().zzQ(this.zze, bundle2);
            throw th;
        }
    }
}
