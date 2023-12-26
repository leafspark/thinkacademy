package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzt;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final /* synthetic */ class zzfb implements Callable {
    public final /* synthetic */ zzfi zza;

    public /* synthetic */ zzfb(zzfi zzfi) {
        this.zza = zzfi;
    }

    public final Object call() {
        return new zzt(this.zza.zzd);
    }
}
