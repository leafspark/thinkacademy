package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzgm extends zzjx implements zzld {
    /* access modifiers changed from: private */
    public static final zzgm zza;
    private int zze;
    private String zzf = "";
    private zzke zzg = zzby();

    static {
        zzgm zzgm = new zzgm();
        zza = zzgm;
        zzjx.zzbE(zzgm.class, zzgm);
    }

    private zzgm() {
    }

    public final String zzb() {
        return this.zzf;
    }

    public final List zzc() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbD(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", zzgt.class});
        } else if (i2 == 3) {
            return new zzgm();
        } else {
            if (i2 == 4) {
                return new zzgl((zzgi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
