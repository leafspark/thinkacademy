package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzmv implements zzmu {
    public static final zzhu zza;
    public static final zzhu zzb;
    public static final zzhu zzc;
    public static final zzhu zzd;
    public static final zzhu zze;
    public static final zzhu zzf;
    public static final zzhu zzg;

    static {
        zzhr zza2 = new zzhr(zzhk.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zze("measurement.adid_zero.app_instance_id_fix", true);
        zzb = zza2.zze("measurement.adid_zero.service", true);
        zzc = zza2.zze("measurement.adid_zero.adid_uid", false);
        zzd = zza2.zzc("measurement.id.adid_zero.service", 0);
        zze = zza2.zze("measurement.adid_zero.remove_lair_if_adidzero_false", true);
        zzf = zza2.zze("measurement.adid_zero.remove_lair_if_userid_cleared", true);
        zzg = zza2.zze("measurement.adid_zero.remove_lair_on_id_value_change_only", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    public final boolean zzc() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    public final boolean zzd() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    public final boolean zze() {
        return ((Boolean) zze.zzb()).booleanValue();
    }

    public final boolean zzf() {
        return ((Boolean) zzf.zzb()).booleanValue();
    }

    public final boolean zzg() {
        return ((Boolean) zzg.zzb()).booleanValue();
    }
}
