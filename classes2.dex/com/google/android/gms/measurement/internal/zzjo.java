package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final /* synthetic */ class zzjo implements Runnable {
    public final /* synthetic */ zzjr zza;
    public final /* synthetic */ zzeh zzb;
    public final /* synthetic */ JobParameters zzc;

    public /* synthetic */ zzjo(zzjr zzjr, zzeh zzeh, JobParameters jobParameters) {
        this.zza = zzjr;
        this.zzb = zzeh;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
