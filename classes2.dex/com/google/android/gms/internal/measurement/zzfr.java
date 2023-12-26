package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzfr extends zzjt implements zzld {
    private zzfr() {
        super(zzfs.zza);
    }

    public final int zza() {
        return ((zzfs) this.zza).zzc();
    }

    public final zzfr zzb(Iterable iterable) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfs.zzs((zzfs) this.zza, iterable);
        return this;
    }

    public final zzfr zzc(zzfr zzfr) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfs.zzr((zzfs) this.zza, (zzfs) zzfr.zzay());
        return this;
    }

    public final zzfr zzd() {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfs.zzq((zzfs) this.zza);
        return this;
    }

    public final zzfr zze() {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfs.zzo((zzfs) this.zza);
        return this;
    }

    public final zzfr zzf() {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        ((zzfs) this.zza).zzk = zzfs.zzby();
        return this;
    }

    public final zzfr zzg() {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfs.zzm((zzfs) this.zza);
        return this;
    }

    public final zzfr zzh(double d) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfs.zzp((zzfs) this.zza, d);
        return this;
    }

    public final zzfr zzi(long j) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfs.zzn((zzfs) this.zza, j);
        return this;
    }

    public final zzfr zzj(String str) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfs.zzj((zzfs) this.zza, str);
        return this;
    }

    public final zzfr zzk(String str) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzfs.zzk((zzfs) this.zza, str);
        return this;
    }

    /* synthetic */ zzfr(zzff zzff) {
        super(zzfs.zza);
    }
}
