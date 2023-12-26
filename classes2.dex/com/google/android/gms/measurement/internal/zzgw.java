package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final /* synthetic */ class zzgw implements Runnable {
    public final /* synthetic */ zzhw zza;
    public final /* synthetic */ Bundle zzb;

    public /* synthetic */ zzgw(zzhw zzhw, Bundle bundle) {
        this.zza = zzhw;
        this.zzb = bundle;
    }

    public final void run() {
        this.zza.zzC(this.zzb);
    }
}
