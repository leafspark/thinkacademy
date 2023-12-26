package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final /* synthetic */ class zzju implements Runnable {
    public final /* synthetic */ zzjv zza;

    public /* synthetic */ zzju(zzjv zzjv) {
        this.zza = zzjv;
    }

    public final void run() {
        zzjv zzjv = this.zza;
        zzjw zzjw = zzjv.zzc;
        long j = zzjv.zza;
        long j2 = zzjv.zzb;
        zzjw.zza.zzg();
        zzjw.zza.zzs.zzay().zzc().zza("Application going to the background");
        zzjw.zza.zzs.zzm().zzl.zza(true);
        Bundle bundle = new Bundle();
        if (!zzjw.zza.zzs.zzf().zzu()) {
            zzjw.zza.zzb.zzb(j2);
            zzjw.zza.zzb.zzd(false, false, j2);
        }
        zzjw.zza.zzs.zzq().zzH("auto", "_ab", j, bundle);
    }
}
