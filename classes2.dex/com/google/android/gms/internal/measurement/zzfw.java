package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzfw extends zzjx implements zzld {
    /* access modifiers changed from: private */
    public static final zzfw zza;
    private zzke zze = zzby();

    static {
        zzfw zzfw = new zzfw();
        zza = zzfw;
        zzjx.zzbE(zzfw.class, zzfw);
    }

    private zzfw() {
    }

    public static zzfv zza() {
        return (zzfv) zza.zzbs();
    }

    static /* synthetic */ void zze(zzfw zzfw, zzfy zzfy) {
        zzfy.getClass();
        zzke zzke = zzfw.zze;
        if (!zzke.zzc()) {
            zzfw.zze = zzjx.zzbz(zzke);
        }
        zzfw.zze.add(zzfy);
    }

    public final zzfy zzc(int i) {
        return (zzfy) this.zze.get(0);
    }

    public final List zzd() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzbD(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzfy.class});
        } else if (i2 == 3) {
            return new zzfw();
        } else {
            if (i2 == 4) {
                return new zzfv((zzff) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
