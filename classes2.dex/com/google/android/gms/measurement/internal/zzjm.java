package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.measurement.zzmt;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzjm extends zzkf {
    public final zzes zza;
    public final zzes zzb;
    public final zzes zzc;
    public final zzes zzd;
    public final zzes zze;
    private final Map zzg = new HashMap();
    private String zzh;
    private boolean zzi;
    private long zzj;

    zzjm(zzkp zzkp) {
        super(zzkp);
        zzew zzm = this.zzs.zzm();
        zzm.getClass();
        this.zza = new zzes(zzm, "last_delete_stale", 0);
        zzew zzm2 = this.zzs.zzm();
        zzm2.getClass();
        this.zzb = new zzes(zzm2, "backoff", 0);
        zzew zzm3 = this.zzs.zzm();
        zzm3.getClass();
        this.zzc = new zzes(zzm3, "last_upload", 0);
        zzew zzm4 = this.zzs.zzm();
        zzm4.getClass();
        this.zzd = new zzes(zzm4, "last_upload_attempt", 0);
        zzew zzm5 = this.zzs.zzm();
        zzm5.getClass();
        this.zze = new zzes(zzm5, "midnight_offset", 0);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final Pair zza(String str) {
        zzjl zzjl;
        zzg();
        long elapsedRealtime = this.zzs.zzav().elapsedRealtime();
        zzmt.zzc();
        if (this.zzs.zzf().zzs((String) null, zzdu.zzar)) {
            zzjl zzjl2 = (zzjl) this.zzg.get(str);
            if (zzjl2 != null && elapsedRealtime < zzjl2.zzc) {
                return new Pair(zzjl2.zza, Boolean.valueOf(zzjl2.zzb));
            }
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            long zzi2 = elapsedRealtime + this.zzs.zzf().zzi(str, zzdu.zza);
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zzau());
                if (advertisingIdInfo == null) {
                    return new Pair("", false);
                }
                String id = advertisingIdInfo.getId();
                if (id != null) {
                    zzjl = new zzjl(id, advertisingIdInfo.isLimitAdTrackingEnabled(), zzi2);
                } else {
                    zzjl = new zzjl("", advertisingIdInfo.isLimitAdTrackingEnabled(), zzi2);
                }
                this.zzg.put(str, zzjl);
                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
                return new Pair(zzjl.zza, Boolean.valueOf(zzjl.zzb));
            } catch (Exception e) {
                this.zzs.zzay().zzc().zzb("Unable to get advertising id", e);
                zzjl = new zzjl("", false, zzi2);
            }
        } else {
            String str2 = this.zzh;
            if (str2 != null && elapsedRealtime < this.zzj) {
                return new Pair(str2, Boolean.valueOf(this.zzi));
            }
            this.zzj = elapsedRealtime + this.zzs.zzf().zzi(str, zzdu.zza);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            try {
                AdvertisingIdClient.Info advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zzau());
                if (advertisingIdInfo2 == null) {
                    return new Pair("", false);
                }
                this.zzh = "";
                String id2 = advertisingIdInfo2.getId();
                if (id2 != null) {
                    this.zzh = id2;
                }
                this.zzi = advertisingIdInfo2.isLimitAdTrackingEnabled();
                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
                return new Pair(this.zzh, Boolean.valueOf(this.zzi));
            } catch (Exception e2) {
                this.zzs.zzay().zzc().zzb("Unable to get advertising id", e2);
                this.zzh = "";
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Pair zzd(String str, zzah zzah) {
        if (zzah.zzi(zzag.AD_STORAGE)) {
            return zza(str);
        }
        return new Pair("", false);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final String zzf(String str) {
        zzg();
        String str2 = (String) zza(str).first;
        MessageDigest zzE = zzkw.zzE();
        if (zzE == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzE.digest(str2.getBytes()))});
    }
}
