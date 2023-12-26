package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzar implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzas zzb;

    zzar(zzas zzas) {
        this.zzb = zzas;
        this.zza = zzas.zza.keySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    /* renamed from: zza */
    public final String next() {
        return (String) this.zza.next();
    }
}
