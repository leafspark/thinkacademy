package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final /* synthetic */ class zzfe implements Callable {
    public final /* synthetic */ zzfi zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfe(zzfi zzfi, String str) {
        this.zza = zzfi;
        this.zzb = str;
    }

    public final Object call() {
        return new zzu("internal.appMetadata", new zzfd(this.zza, this.zzb));
    }
}
