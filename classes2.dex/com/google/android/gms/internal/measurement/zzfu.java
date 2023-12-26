package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzfu extends zzjx implements zzld {
    /* access modifiers changed from: private */
    public static final zzfu zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzfi zzh;

    static {
        zzfu zzfu = new zzfu();
        zza = zzfu;
        zzjx.zzbE(zzfu.class, zzfu);
    }

    private zzfu() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbD(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzfu();
        } else {
            if (i2 == 4) {
                return new zzft((zzff) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
