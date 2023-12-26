package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzfj extends zzjt implements zzld {
    private zzfj() {
        super(zzfk.zza);
    }

    public final zzfj zza(int i) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfk.zzf((zzfk) this.zza, i);
        return this;
    }

    public final zzfj zzb(zzgc zzgc) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfk.zzg((zzfk) this.zza, (zzgd) zzgc.zzay());
        return this;
    }

    public final zzfj zzc(boolean z) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfk.zzi((zzfk) this.zza, z);
        return this;
    }

    public final zzfj zzd(zzgd zzgd) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfk.zzh((zzfk) this.zza, zzgd);
        return this;
    }

    /* synthetic */ zzfj(zzff zzff) {
        super(zzfk.zza);
    }
}
