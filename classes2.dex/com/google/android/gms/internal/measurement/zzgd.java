package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzgd extends zzjx implements zzld {
    /* access modifiers changed from: private */
    public static final zzgd zza;
    /* access modifiers changed from: private */
    public zzkd zze = zzbw();
    /* access modifiers changed from: private */
    public zzkd zzf = zzbw();
    private zzke zzg = zzby();
    private zzke zzh = zzby();

    static {
        zzgd zzgd = new zzgd();
        zza = zzgd;
        zzjx.zzbE(zzgd.class, zzgd);
    }

    private zzgd() {
    }

    public static zzgc zzf() {
        return (zzgc) zza.zzbs();
    }

    public static zzgd zzh() {
        return zza;
    }

    static /* synthetic */ void zzo(zzgd zzgd, Iterable iterable) {
        zzkd zzkd = zzgd.zze;
        if (!zzkd.zzc()) {
            zzgd.zze = zzjx.zzbx(zzkd);
        }
        zzih.zzbo(iterable, zzgd.zze);
    }

    static /* synthetic */ void zzq(zzgd zzgd, Iterable iterable) {
        zzkd zzkd = zzgd.zzf;
        if (!zzkd.zzc()) {
            zzgd.zzf = zzjx.zzbx(zzkd);
        }
        zzih.zzbo(iterable, zzgd.zzf);
    }

    static /* synthetic */ void zzs(zzgd zzgd, Iterable iterable) {
        zzgd.zzw();
        zzih.zzbo(iterable, zzgd.zzg);
    }

    static /* synthetic */ void zzt(zzgd zzgd, int i) {
        zzgd.zzw();
        zzgd.zzg.remove(i);
    }

    static /* synthetic */ void zzu(zzgd zzgd, Iterable iterable) {
        zzgd.zzx();
        zzih.zzbo(iterable, zzgd.zzh);
    }

    static /* synthetic */ void zzv(zzgd zzgd, int i) {
        zzgd.zzx();
        zzgd.zzh.remove(i);
    }

    private final void zzw() {
        zzke zzke = this.zzg;
        if (!zzke.zzc()) {
            this.zzg = zzjx.zzbz(zzke);
        }
    }

    private final void zzx() {
        zzke zzke = this.zzh;
        if (!zzke.zzc()) {
            this.zzh = zzjx.zzbz(zzke);
        }
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zzf.size();
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final zzfm zze(int i) {
        return (zzfm) this.zzg.get(i);
    }

    public final zzgf zzi(int i) {
        return (zzgf) this.zzh.get(i);
    }

    public final List zzj() {
        return this.zzg;
    }

    public final List zzk() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbD(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", zzfm.class, "zzh", zzgf.class});
        } else if (i2 == 3) {
            return new zzgd();
        } else {
            if (i2 == 4) {
                return new zzgc((zzff) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final List zzm() {
        return this.zzh;
    }

    public final List zzn() {
        return this.zze;
    }
}
