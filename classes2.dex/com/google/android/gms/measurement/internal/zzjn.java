package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final /* synthetic */ class zzjn implements Runnable {
    public final /* synthetic */ zzjr zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzeh zzc;
    public final /* synthetic */ Intent zzd;

    public /* synthetic */ zzjn(zzjr zzjr, int i, zzeh zzeh, Intent intent) {
        this.zza = zzjr;
        this.zzb = i;
        this.zzc = zzeh;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zzc(this.zzb, this.zzc, this.zzd);
    }
}
