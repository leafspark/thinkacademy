package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzjp implements Runnable {
    final /* synthetic */ zzkp zza;
    final /* synthetic */ Runnable zzb;

    zzjp(zzjr zzjr, zzkp zzkp, Runnable runnable) {
        this.zza = zzkp;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzA();
        this.zza.zzz(this.zzb);
        this.zza.zzW();
    }
}
