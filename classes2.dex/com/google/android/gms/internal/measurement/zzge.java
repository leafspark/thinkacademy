package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzge extends zzjt implements zzld {
    private zzge() {
        super(zzgf.zza);
    }

    public final zzge zza(Iterable iterable) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzgf.zzh((zzgf) this.zza, iterable);
        return this;
    }

    public final zzge zzb(int i) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzgf.zzg((zzgf) this.zza, i);
        return this;
    }

    /* synthetic */ zzge(zzff zzff) {
        super(zzgf.zza);
    }
}
