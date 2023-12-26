package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzfq extends zzjx implements zzld {
    /* access modifiers changed from: private */
    public static final zzfq zza;
    private int zze;
    private String zzf = "";
    private long zzg;

    static {
        zzfq zzfq = new zzfq();
        zza = zzfq;
        zzjx.zzbE(zzfq.class, zzfq);
    }

    private zzfq() {
    }

    public static zzfp zza() {
        return (zzfp) zza.zzbs();
    }

    static /* synthetic */ void zzc(zzfq zzfq, String str) {
        str.getClass();
        zzfq.zze |= 1;
        zzfq.zzf = str;
    }

    static /* synthetic */ void zzd(zzfq zzfq, long j) {
        zzfq.zze |= 2;
        zzfq.zzg = j;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbD(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfq();
        } else {
            if (i2 == 4) {
                return new zzfp((zzff) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
