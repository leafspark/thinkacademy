package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzol implements zzok {
    public static final zzhu zza;
    public static final zzhu zzb;
    public static final zzhu zzc;
    public static final zzhu zzd;

    static {
        zzhr zzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
        zza = zzhr.zzc("measurement.id.lifecycle.app_in_background_parameter", 0);
        zzb = zzhr.zze("measurement.lifecycle.app_backgrounded_tracking", true);
        zzc = zzhr.zze("measurement.lifecycle.app_in_background_parameter", false);
        zzd = zzhr.zzc("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }

    public final boolean zza() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
