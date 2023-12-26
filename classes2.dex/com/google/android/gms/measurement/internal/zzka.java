package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.measurement.zzby;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzka extends zzf {
    protected final zzjz zza = new zzjz(this);
    protected final zzjy zzb = new zzjy(this);
    protected final zzjw zzc = new zzjw(this);
    /* access modifiers changed from: private */
    public Handler zzd;

    zzka(zzfr zzfr) {
        super(zzfr);
    }

    static /* bridge */ /* synthetic */ void zzj(zzka zzka, long j) {
        zzka.zzg();
        zzka.zzm();
        zzka.zzs.zzay().zzj().zzb("Activity paused, time", Long.valueOf(j));
        zzka.zzc.zza(j);
        if (zzka.zzs.zzf().zzu()) {
            zzka.zzb.zzb(j);
        }
    }

    static /* bridge */ /* synthetic */ void zzl(zzka zzka, long j) {
        zzka.zzg();
        zzka.zzm();
        zzka.zzs.zzay().zzj().zzb("Activity resumed, time", Long.valueOf(j));
        if (zzka.zzs.zzf().zzu() || zzka.zzs.zzm().zzl.zzb()) {
            zzka.zzb.zzc(j);
        }
        zzka.zzc.zzb();
        zzjz zzjz = zzka.zza;
        zzjz.zza.zzg();
        if (zzjz.zza.zzs.zzJ()) {
            zzjz.zzb(zzjz.zza.zzs.zzav().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    public final void zzm() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new zzby(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }
}
