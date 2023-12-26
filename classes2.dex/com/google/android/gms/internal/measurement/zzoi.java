package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzoi implements zzoh {
    public static final zzhu zza;
    public static final zzhu zzb;
    public static final zzhu zzc;
    public static final zzhu zzd;

    static {
        zzhr zzhr = new zzhr(zzhk.zza("com.google.android.gms.measurement"));
        zza = zzhr.zze("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zzhr.zze("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzhr.zze("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zzhr.zzc("measurement.id.sdk.collection.last_deep_link_referrer2", 0);
    }

    public final boolean zza() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
