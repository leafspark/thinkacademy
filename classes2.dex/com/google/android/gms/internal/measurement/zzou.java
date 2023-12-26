package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzou implements zzot {
    public static final zzhu zza;
    public static final zzhu zzb;

    static {
        zzhr zzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
        zza = zzhr.zze("measurement.module.pixie.ees", true);
        zzb = zzhr.zze("measurement.module.pixie.fix_array", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }
}
