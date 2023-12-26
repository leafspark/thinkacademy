package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzn extends zzai {
    private final zzo zza;

    public zzn(String str, zzo zzo) {
        super("internal.remoteConfig");
        this.zza = zzo;
        this.zze.put("getValue", new zzm(this, "getValue", zzo));
    }

    public final zzap zza(zzg zzg, List list) {
        return zzf;
    }
}
