package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzor implements zzoq {
    public static final zzhu zza;
    public static final zzhu zzb;
    public static final zzhu zzc;
    public static final zzhu zzd;
    public static final zzhu zze;

    static {
        zzhr zzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
        zza = zzhr.zze("measurement.test.boolean_flag", false);
        zzb = zzhr.zzb("measurement.test.double_flag", -3.0d);
        zzc = zzhr.zzc("measurement.test.int_flag", -2);
        zzd = zzhr.zzc("measurement.test.long_flag", -1);
        zze = zzhr.zzd("measurement.test.string_flag", "---");
    }

    public final double zza() {
        return ((Double) zzb.zzb()).doubleValue();
    }

    public final long zzb() {
        return ((Long) zzc.zzb()).longValue();
    }

    public final long zzc() {
        return ((Long) zzd.zzb()).longValue();
    }

    public final String zzd() {
        return (String) zze.zzb();
    }

    public final boolean zze() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
