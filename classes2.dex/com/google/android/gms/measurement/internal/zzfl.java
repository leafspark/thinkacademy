package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzfl implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzfo zza;
    private final String zzb;

    public zzfl(zzfo zzfo, String str) {
        this.zza = zzfo;
        Preconditions.checkNotNull(str);
        this.zzb = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zza.zzs.zzay().zzd().zzb(this.zzb, th);
    }
}
