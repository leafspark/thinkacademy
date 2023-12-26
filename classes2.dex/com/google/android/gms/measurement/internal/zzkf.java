package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
abstract class zzkf extends zzke {
    private boolean zza;

    zzkf(zzkp zzkp) {
        super(zzkp);
        this.zzf.zzL();
    }

    /* access modifiers changed from: protected */
    public final void zzW() {
        if (!zzY()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzX() {
        if (!this.zza) {
            zzb();
            this.zzf.zzG();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzY() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzb();
}
