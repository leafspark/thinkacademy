package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzel implements Runnable {
    private final zzej zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map zzf;

    /* synthetic */ zzel(String str, zzej zzej, int i, Throwable th, byte[] bArr, Map map, zzek zzek) {
        Preconditions.checkNotNull(zzej);
        this.zza = zzej;
        this.zzb = i;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
