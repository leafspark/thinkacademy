package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzkh implements Runnable {
    final /* synthetic */ zzkq zza;
    final /* synthetic */ zzkp zzb;

    zzkh(zzkp zzkp, zzkq zzkq) {
        this.zzb = zzkp;
        this.zza = zzkq;
    }

    public final void run() {
        zzkp.zzy(this.zzb, this.zza);
        this.zzb.zzR();
    }
}
