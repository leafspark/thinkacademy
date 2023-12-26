package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzfh implements zzo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzfi zzb;

    zzfh(zzfi zzfi, String str) {
        this.zzb = zzfi;
        this.zza = str;
    }

    public final String zza(String str) {
        Map map = (Map) this.zzb.zze.get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
