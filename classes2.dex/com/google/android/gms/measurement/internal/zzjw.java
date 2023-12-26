package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzjw {
    final /* synthetic */ zzka zza;
    private zzjv zzb;

    zzjw(zzka zzka) {
        this.zza = zzka;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzb = new zzjv(this, this.zza.zzs.zzav().currentTimeMillis(), j);
        this.zza.zzd.postDelayed(this.zzb, 2000);
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zza.zzg();
        zzjv zzjv = this.zzb;
        if (zzjv != null) {
            this.zza.zzd.removeCallbacks(zzjv);
        }
        this.zza.zzs.zzm().zzl.zza(false);
    }
}
