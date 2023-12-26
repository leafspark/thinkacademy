package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
final class zzlg implements zzln {
    private final zzlc zza;
    private final zzmb zzb;
    private final boolean zzc;
    private final zzjk zzd;

    private zzlg(zzmb zzmb, zzjk zzjk, zzlc zzlc) {
        this.zzb = zzmb;
        this.zzc = zzjk.zzc(zzlc);
        this.zzd = zzjk;
        this.zza = zzlc;
    }

    static zzlg zzc(zzmb zzmb, zzjk zzjk, zzlc zzlc) {
        return new zzlg(zzmb, zzjk, zzlc);
    }

    public final int zza(Object obj) {
        zzmb zzmb = this.zzb;
        int zzb2 = zzmb.zzb(zzmb.zzc(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzc(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        return this.zza.zzbA().zzaA();
    }

    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzlp.zzF(this.zzb, obj, obj2);
        if (this.zzc) {
            zzlp.zzE(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzik zzik) throws IOException {
        zzjx zzjx = (zzjx) obj;
        if (zzjx.zzc == zzmc.zzc()) {
            zzjx.zzc = zzmc.zze();
        }
        zzju zzju = (zzju) obj;
        throw null;
    }

    public final boolean zzi(Object obj, Object obj2) {
        if (!this.zzb.zzc(obj).equals(this.zzb.zzc(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzj(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    public final void zzm(Object obj, zzjf zzjf) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}
