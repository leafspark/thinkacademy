package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zznk implements zznj {
    public static final zzhu zza;
    public static final zzhu zzb;
    public static final zzhu zzc;
    public static final zzhu zzd;

    static {
        zzhr zzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
        zza = zzhr.zze("measurement.client.consent_state_v1", true);
        zzb = zzhr.zze("measurement.client.3p_consent_state_v1", true);
        zzc = zzhr.zze("measurement.service.consent_state_v1_W36", true);
        zzd = zzhr.zzc("measurement.service.storage_consent_support_version", 203600);
    }

    public final long zza() {
        return ((Long) zzd.zzb()).longValue();
    }
}
