package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzby;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
abstract class zzan {
    private static volatile Handler zza;
    private final zzgm zzb;
    private final Runnable zzc;
    /* access modifiers changed from: private */
    public volatile long zzd;

    zzan(zzgm zzgm) {
        Preconditions.checkNotNull(zzgm);
        this.zzb = zzgm;
        this.zzc = new zzam(this, zzgm);
    }

    private final Handler zzf() {
        Handler handler;
        if (zza != null) {
            return zza;
        }
        synchronized (zzan.class) {
            if (zza == null) {
                zza = new zzby(this.zzb.zzau().getMainLooper());
            }
            handler = zza;
        }
        return handler;
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        this.zzd = 0;
        zzf().removeCallbacks(this.zzc);
    }

    public abstract void zzc();

    public final void zzd(long j) {
        zzb();
        if (j >= 0) {
            this.zzd = this.zzb.zzav().currentTimeMillis();
            if (!zzf().postDelayed(this.zzc, j)) {
                this.zzb.zzay().zzd().zzb("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public final boolean zze() {
        return this.zzd != 0;
    }
}
