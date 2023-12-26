package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzi {
    public static zzap zza(zzgt zzgt) {
        if (zzgt == null) {
            return zzap.zzf;
        }
        int zzj = zzgt.zzj() - 1;
        if (zzj != 1) {
            if (zzj != 2) {
                if (zzj != 3) {
                    if (zzj == 4) {
                        List<zzgt> zze = zzgt.zze();
                        ArrayList arrayList = new ArrayList();
                        for (zzgt zza : zze) {
                            arrayList.add(zza(zza));
                        }
                        return new zzaq(zzgt.zzc(), arrayList);
                    }
                    throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
                } else if (zzgt.zzg()) {
                    return new zzaf(Boolean.valueOf(zzgt.zzf()));
                } else {
                    return new zzaf((Boolean) null);
                }
            } else if (zzgt.zzh()) {
                return new zzah(Double.valueOf(zzgt.zza()));
            } else {
                return new zzah((Double) null);
            }
        } else if (zzgt.zzi()) {
            return new zzat(zzgt.zzd());
        } else {
            return zzap.zzm;
        }
    }

    public static zzap zzb(Object obj) {
        if (obj == null) {
            return zzap.zzg;
        }
        if (obj instanceof String) {
            return new zzat((String) obj);
        }
        if (obj instanceof Double) {
            return new zzah((Double) obj);
        }
        if (obj instanceof Long) {
            return new zzah(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzah(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new zzaf((Boolean) obj);
        }
        if (obj instanceof Map) {
            zzam zzam = new zzam();
            Map map = (Map) obj;
            for (Object next : map.keySet()) {
                zzap zzb = zzb(map.get(next));
                if (next != null) {
                    if (!(next instanceof String)) {
                        next = next.toString();
                    }
                    zzam.zzr((String) next, zzb);
                }
            }
            return zzam;
        } else if (obj instanceof List) {
            zzae zzae = new zzae();
            for (Object zzb2 : (List) obj) {
                zzae.zzq(zzae.zzc(), zzb(zzb2));
            }
            return zzae;
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }
}
