package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzgr;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@20.1.0 */
final class zzdu extends zzch {
    private final zzgr zza;

    zzdu(zzgr zzgr) {
        this.zza = zzgr;
    }

    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    public final void zze(String str, String str2, Bundle bundle, long j) {
        this.zza.interceptEvent(str, str2, bundle, j);
    }
}
