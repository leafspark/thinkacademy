package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzw extends zzai {
    final Map zza = new HashMap();
    private final zzj zzb;

    public zzw(zzj zzj) {
        super("require");
        this.zzb = zzj;
    }

    public final zzap zza(zzg zzg, List list) {
        zzap zzap;
        zzh.zzh("require", 1, list);
        String zzi = zzg.zzb((zzap) list.get(0)).zzi();
        if (this.zza.containsKey(zzi)) {
            return (zzap) this.zza.get(zzi);
        }
        zzj zzj = this.zzb;
        if (zzj.zza.containsKey(zzi)) {
            try {
                zzap = (zzap) ((Callable) zzj.zza.get(zzi)).call();
            } catch (Exception unused) {
                String valueOf = String.valueOf(zzi);
                throw new IllegalStateException(valueOf.length() != 0 ? "Failed to create API implementation: ".concat(valueOf) : new String("Failed to create API implementation: "));
            }
        } else {
            zzap = zzap.zzf;
        }
        if (zzap instanceof zzai) {
            this.zza.put(zzi, (zzai) zzap);
        }
        return zzap;
    }
}
