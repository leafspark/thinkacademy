package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zznz implements zzny {
    public static final zzhu zza;
    public static final zzhu zzb;

    static {
        zzhr zzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
        zza = zzhr.zze("measurement.client.consent.suppress_1p_in_ga4f_install", true);
        zzb = zzhr.zze("measurement.client.consent.gmpappid_worker_thread_fix", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }
}
