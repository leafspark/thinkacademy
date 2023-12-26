package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzfc extends zzjx implements zzld {
    /* access modifiers changed from: private */
    public static final zzfc zza;
    private int zze;
    private long zzf;
    private String zzg = "";
    private int zzh;
    private zzke zzi = zzby();
    private zzke zzj = zzby();
    /* access modifiers changed from: private */
    public zzke zzk = zzby();
    private String zzl = "";
    private boolean zzm;
    private zzke zzn = zzby();

    static {
        zzfc zzfc = new zzfc();
        zza = zzfc;
        zzjx.zzbE(zzfc.class, zzfc);
    }

    private zzfc() {
    }

    public static zzfb zze() {
        return (zzfb) zza.zzbs();
    }

    public static zzfc zzg() {
        return zza;
    }

    static /* synthetic */ void zzm(zzfc zzfc, int i, zzfa zzfa) {
        zzfa.getClass();
        zzke zzke = zzfc.zzj;
        if (!zzke.zzc()) {
            zzfc.zzj = zzjx.zzbz(zzke);
        }
        zzfc.zzj.set(i, zzfa);
    }

    public final int zza() {
        return this.zzn.size();
    }

    public final int zzb() {
        return this.zzj.size();
    }

    public final long zzc() {
        return this.zzf;
    }

    public final zzfa zzd(int i) {
        return (zzfa) this.zzj.get(i);
    }

    public final String zzh() {
        return this.zzg;
    }

    public final List zzi() {
        return this.zzk;
    }

    public final List zzj() {
        return this.zzn;
    }

    public final List zzk() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbD(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzfe.class, "zzj", zzfa.class, "zzk", zzeh.class, "zzl", "zzm", "zzn", zzgo.class});
        } else if (i2 == 3) {
            return new zzfc();
        } else {
            if (i2 == 4) {
                return new zzfb((zzey) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzo() {
        return this.zzm;
    }

    public final boolean zzp() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzq() {
        return (this.zze & 1) != 0;
    }
}
