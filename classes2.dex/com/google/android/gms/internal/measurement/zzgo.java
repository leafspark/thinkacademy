package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzgo extends zzjx implements zzld {
    /* access modifiers changed from: private */
    public static final zzgo zza;
    private int zze;
    private zzke zzf = zzby();
    private zzgk zzg;

    static {
        zzgo zzgo = new zzgo();
        zza = zzgo;
        zzjx.zzbE(zzgo.class, zzgo);
    }

    private zzgo() {
    }

    public final zzgk zza() {
        zzgk zzgk = this.zzg;
        return zzgk == null ? zzgk.zzc() : zzgk;
    }

    public final List zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbD(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", zzgt.class, "zzg"});
        } else if (i2 == 3) {
            return new zzgo();
        } else {
            if (i2 == 4) {
                return new zzgn((zzgi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
