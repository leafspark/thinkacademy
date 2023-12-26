package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
public final class zzjj {
    static final zzjj zza = new zzjj(true);
    private static volatile boolean zzb = false;
    private static volatile zzjj zzc;
    private static volatile zzjj zzd;
    private final Map zze;

    zzjj() {
        this.zze = new HashMap();
    }

    public static zzjj zza() {
        zzjj zzjj = zzc;
        if (zzjj == null) {
            synchronized (zzjj.class) {
                zzjj = zzc;
                if (zzjj == null) {
                    zzjj = zza;
                    zzc = zzjj;
                }
            }
        }
        return zzjj;
    }

    public final zzjv zzc(zzlc zzlc, int i) {
        return (zzjv) this.zze.get(new zzji(zzlc, i));
    }

    zzjj(boolean z) {
        this.zze = Collections.emptyMap();
    }

    public static zzjj zzb() {
        Class<zzjj> cls = zzjj.class;
        zzjj zzjj = zzd;
        if (zzjj != null) {
            return zzjj;
        }
        synchronized (cls) {
            zzjj zzjj2 = zzd;
            if (zzjj2 != null) {
                return zzjj2;
            }
            zzjj zzb2 = zzjr.zzb(cls);
            zzd = zzb2;
            return zzb2;
        }
    }
}
