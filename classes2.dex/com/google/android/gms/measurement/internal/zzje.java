package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzje implements Runnable {
    final /* synthetic */ zzdx zza;
    final /* synthetic */ zzjj zzb;

    zzje(zzjj zzjj, zzdx zzdx) {
        this.zzb = zzjj;
        this.zza = zzdx;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzL()) {
                this.zzb.zza.zzs.zzay().zzj().zza("Connected to service");
                this.zzb.zza.zzJ(this.zza);
            }
        }
    }
}
