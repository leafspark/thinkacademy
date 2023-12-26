package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzfe extends zzjx implements zzld {
    /* access modifiers changed from: private */
    public static final zzfe zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzfe zzfe = new zzfe();
        zza = zzfe;
        zzjx.zzbE(zzfe.class, zzfe);
    }

    private zzfe() {
    }

    public final String zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbD(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfe();
        } else {
            if (i2 == 4) {
                return new zzfd((zzey) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
