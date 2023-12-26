package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final /* synthetic */ class zzgx implements Runnable {
    public final /* synthetic */ zzhw zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzgx(zzhw zzhw, Bundle bundle, long j) {
        this.zza = zzhw;
        this.zzb = bundle;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzB(this.zzb, this.zzc);
    }
}
