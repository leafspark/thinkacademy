package com.google.android.gms.internal.measurement;

import com.facebook.soloader.MinElf;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.0 */
final class zzji {
    private final Object zza;
    private final int zzb;

    zzji(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzji)) {
            return false;
        }
        zzji zzji = (zzji) obj;
        if (this.zza == zzji.zza && this.zzb == zzji.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * MinElf.PN_XNUM) + this.zzb;
    }
}
