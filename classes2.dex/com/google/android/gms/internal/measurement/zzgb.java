package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzgb extends zzjx implements zzld {
    /* access modifiers changed from: private */
    public static final zzgb zza;
    private int zze;
    private int zzf = 1;
    private zzke zzg = zzby();

    static {
        zzgb zzgb = new zzgb();
        zza = zzgb;
        zzjx.zzbE(zzgb.class, zzgb);
    }

    private zzgb() {
    }

    public static zzfz zza() {
        return (zzfz) zza.zzbs();
    }

    static /* synthetic */ void zzc(zzgb zzgb, zzfq zzfq) {
        zzfq.getClass();
        zzke zzke = zzgb.zzg;
        if (!zzke.zzc()) {
            zzgb.zzg = zzjx.zzbz(zzke);
        }
        zzgb.zzg.add(zzfq);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbD(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zze", "zzf", zzga.zza, "zzg", zzfq.class});
        } else if (i2 == 3) {
            return new zzgb();
        } else {
            if (i2 == 4) {
                return new zzfz((zzff) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
