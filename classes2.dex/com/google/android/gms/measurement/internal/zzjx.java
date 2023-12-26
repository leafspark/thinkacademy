package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzjx extends zzan {
    final /* synthetic */ zzjy zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjx(zzjy zzjy, zzgm zzgm) {
        super(zzgm);
        this.zza = zzjy;
    }

    public final void zzc() {
        zzjy zzjy = this.zza;
        zzjy.zzc.zzg();
        zzjy.zzd(false, false, zzjy.zzc.zzs.zzav().elapsedRealtime());
        zzjy.zzc.zzs.zzd().zzf(zzjy.zzc.zzs.zzav().elapsedRealtime());
    }
}
