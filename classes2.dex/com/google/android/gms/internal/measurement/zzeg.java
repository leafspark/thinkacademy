package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzeg extends zzjt implements zzld {
    private zzeg() {
        super(zzeh.zza);
    }

    public final int zza() {
        return ((zzeh) this.zza).zzb();
    }

    public final int zzb() {
        return ((zzeh) this.zza).zzc();
    }

    public final zzeg zzc(int i, zzei zzei) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzeh.zzj((zzeh) this.zza, i, (zzej) zzei.zzay());
        return this;
    }

    public final zzeg zzd(int i, zzer zzer) {
        if (this.zzb) {
            zzaC();
            this.zzb = false;
        }
        zzeh.zzi((zzeh) this.zza, i, (zzes) zzer.zzay());
        return this;
    }

    public final zzej zze(int i) {
        return ((zzeh) this.zza).zze(i);
    }

    public final zzes zzf(int i) {
        return ((zzeh) this.zza).zzf(i);
    }

    /* synthetic */ zzeg(zzef zzef) {
        super(zzeh.zza);
    }
}
