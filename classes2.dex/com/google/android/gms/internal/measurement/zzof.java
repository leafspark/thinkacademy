package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzof implements zzoe {
    public static final zzhu zza;
    public static final zzhu zzb;
    public static final zzhu zzc;

    static {
        zzhr zzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
        zza = zzhr.zze("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zzhr.zze("measurement.client.sessions.check_on_startup", true);
        zzc = zzhr.zze("measurement.client.sessions.start_session_before_view_screen", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
