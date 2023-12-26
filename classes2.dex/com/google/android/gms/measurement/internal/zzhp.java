package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzhp implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzhw zzb;

    zzhp(zzhw zzhw, Boolean bool) {
        this.zzb = zzhw;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zzac(this.zza, true);
    }
}
