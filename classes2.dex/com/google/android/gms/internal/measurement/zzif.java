package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzif {
    public static zzib zza(zzib zzib) {
        if ((zzib instanceof zzid) || (zzib instanceof zzic)) {
            return zzib;
        }
        if (zzib instanceof Serializable) {
            return new zzic(zzib);
        }
        return new zzid(zzib);
    }

    public static zzib zzb(Object obj) {
        return new zzie(obj);
    }
}
