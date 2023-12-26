package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzgg implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ zzgj zzb;

    zzgg(zzgj zzgj, String str) {
        this.zzb = zzgj;
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzA();
        return this.zzb.zza.zzi().zzu(this.zza);
    }
}
