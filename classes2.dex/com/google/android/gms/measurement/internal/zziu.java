package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zziu extends zzan {
    final /* synthetic */ zzjk zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zziu(zzjk zzjk, zzgm zzgm) {
        super(zzgm);
        this.zza = zzjk;
    }

    public final void zzc() {
        zzjk zzjk = this.zza;
        zzjk.zzg();
        if (zzjk.zzL()) {
            zzjk.zzs.zzay().zzj().zza("Inactivity, disconnecting from the service");
            zzjk.zzs();
        }
    }
}
