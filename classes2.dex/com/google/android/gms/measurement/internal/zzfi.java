package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzez;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzgo;
import com.google.android.gms.internal.measurement.zzkh;
import com.google.android.gms.internal.measurement.zzr;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzfi extends zzkf implements zzae {
    final Map zza = new ArrayMap();
    final Map zzb = new ArrayMap();
    final LruCache zzc = new zzff(this, 20);
    final zzr zzd = new zzfg(this);
    /* access modifiers changed from: private */
    public final Map zze = new ArrayMap();
    private final Map zzg = new ArrayMap();
    private final Map zzh = new ArrayMap();
    private final Map zzi = new ArrayMap();

    zzfi(zzkp zzkp) {
        super(zzkp);
    }

    static /* bridge */ /* synthetic */ zzc zzd(zzfi zzfi, String str) {
        zzfi.zzW();
        Preconditions.checkNotEmpty(str);
        if (!zzfi.zzl(str)) {
            return null;
        }
        if (!zzfi.zzg.containsKey(str) || zzfi.zzg.get(str) == null) {
            zzfi.zzt(str);
        } else {
            zzfi.zzu(str, (zzfc) zzfi.zzg.get(str));
        }
        return (zzc) zzfi.zzc.snapshot().get(str);
    }

    private final zzfc zzr(String str, byte[] bArr) {
        if (bArr == null) {
            return zzfc.zzg();
        }
        try {
            zzfc zzfc = (zzfc) ((zzfb) zzkr.zzl(zzfc.zze(), bArr)).zzay();
            zzef zzj = this.zzs.zzay().zzj();
            String str2 = null;
            Long valueOf = zzfc.zzq() ? Long.valueOf(zzfc.zzc()) : null;
            if (zzfc.zzp()) {
                str2 = zzfc.zzh();
            }
            zzj.zzc("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzfc;
        } catch (zzkh e) {
            this.zzs.zzay().zzk().zzc("Unable to merge remote config. appId", zzeh.zzn(str), e);
            return zzfc.zzg();
        } catch (RuntimeException e2) {
            this.zzs.zzay().zzk().zzc("Unable to merge remote config. appId", zzeh.zzn(str), e2);
            return zzfc.zzg();
        }
    }

    private final void zzs(String str, zzfb zzfb) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzfb != null) {
            for (int i = 0; i < zzfb.zza(); i++) {
                zzez zzez = (zzez) zzfb.zzb(i).zzbt();
                if (TextUtils.isEmpty(zzez.zzc())) {
                    this.zzs.zzay().zzk().zza("EventConfig contained null event name");
                } else {
                    String zzc2 = zzez.zzc();
                    String zzb2 = zzgo.zzb(zzez.zzc());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zzez.zzb(zzb2);
                        zzfb.zzd(i, zzez);
                    }
                    if (zzez.zzf() && zzez.zzd()) {
                        arrayMap.put(zzc2, true);
                    }
                    if (zzez.zzg() && zzez.zze()) {
                        arrayMap2.put(zzez.zzc(), true);
                    }
                    if (zzez.zzh()) {
                        if (zzez.zza() < 2 || zzez.zza() > 65535) {
                            this.zzs.zzay().zzk().zzc("Invalid sampling rate. Event name, sample rate", zzez.zzc(), Integer.valueOf(zzez.zza()));
                        } else {
                            arrayMap3.put(zzez.zzc(), Integer.valueOf(zzez.zza()));
                        }
                    }
                }
            }
        }
        this.zza.put(str, arrayMap);
        this.zzb.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0093, code lost:
        if (r2 != null) goto L_0x0095;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzt(java.lang.String r13) {
        /*
            r12 = this;
            r12.zzW()
            r12.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            java.util.Map r0 = r12.zzg
            java.lang.Object r0 = r0.get(r13)
            if (r0 != 0) goto L_0x0100
            com.google.android.gms.measurement.internal.zzkp r0 = r12.zzf
            com.google.android.gms.measurement.internal.zzak r0 = r0.zzi()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            r0.zzg()
            r0.zzW()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r0.zzh()     // Catch:{ SQLiteException -> 0x007d, all -> 0x007a }
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String[] r4 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x007d, all -> 0x007a }
            r10 = 1
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x007d, all -> 0x007a }
            r11 = 0
            r6[r11] = r13     // Catch:{ SQLiteException -> 0x007d, all -> 0x007a }
            java.lang.String r3 = "apps"
            java.lang.String r5 = "app_id=?"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x007d, all -> 0x007a }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0078 }
            if (r3 != 0) goto L_0x0047
            if (r2 == 0) goto L_0x0098
            goto L_0x0095
        L_0x0047:
            byte[] r3 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r4 = r2.getString(r10)     // Catch:{ SQLiteException -> 0x0078 }
            boolean r5 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0078 }
            if (r5 == 0) goto L_0x0068
            com.google.android.gms.measurement.internal.zzfr r5 = r0.zzs     // Catch:{ SQLiteException -> 0x0078 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ SQLiteException -> 0x0078 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ SQLiteException -> 0x0078 }
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r13)     // Catch:{ SQLiteException -> 0x0078 }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0078 }
        L_0x0068:
            if (r3 != 0) goto L_0x006d
            if (r2 == 0) goto L_0x0098
            goto L_0x0095
        L_0x006d:
            android.util.Pair r5 = new android.util.Pair     // Catch:{ SQLiteException -> 0x0078 }
            r5.<init>(r3, r4)     // Catch:{ SQLiteException -> 0x0078 }
            if (r2 == 0) goto L_0x0099
            r2.close()
            goto L_0x0099
        L_0x0078:
            r3 = move-exception
            goto L_0x0080
        L_0x007a:
            r13 = move-exception
            goto L_0x00fa
        L_0x007d:
            r2 = move-exception
            r3 = r2
            r2 = r1
        L_0x0080:
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzs     // Catch:{ all -> 0x00f8 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x00f8 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x00f8 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r13)     // Catch:{ all -> 0x00f8 }
            r0.zzc(r4, r5, r3)     // Catch:{ all -> 0x00f8 }
            if (r2 == 0) goto L_0x0098
        L_0x0095:
            r2.close()
        L_0x0098:
            r5 = r1
        L_0x0099:
            if (r5 != 0) goto L_0x00ba
            java.util.Map r0 = r12.zze
            r0.put(r13, r1)
            java.util.Map r0 = r12.zza
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzb
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzg
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzi
            r0.put(r13, r1)
            java.util.Map r0 = r12.zzh
            r0.put(r13, r1)
            return
        L_0x00ba:
            java.lang.Object r0 = r5.first
            byte[] r0 = (byte[]) r0
            com.google.android.gms.internal.measurement.zzfc r0 = r12.zzr(r13, r0)
            com.google.android.gms.internal.measurement.zzjt r0 = r0.zzbt()
            com.google.android.gms.internal.measurement.zzfb r0 = (com.google.android.gms.internal.measurement.zzfb) r0
            r12.zzs(r13, r0)
            java.util.Map r1 = r12.zze
            com.google.android.gms.internal.measurement.zzjx r2 = r0.zzay()
            com.google.android.gms.internal.measurement.zzfc r2 = (com.google.android.gms.internal.measurement.zzfc) r2
            java.util.Map r2 = zzv(r2)
            r1.put(r13, r2)
            java.util.Map r1 = r12.zzg
            com.google.android.gms.internal.measurement.zzjx r2 = r0.zzay()
            com.google.android.gms.internal.measurement.zzfc r2 = (com.google.android.gms.internal.measurement.zzfc) r2
            r1.put(r13, r2)
            com.google.android.gms.internal.measurement.zzjx r0 = r0.zzay()
            com.google.android.gms.internal.measurement.zzfc r0 = (com.google.android.gms.internal.measurement.zzfc) r0
            r12.zzu(r13, r0)
            java.util.Map r0 = r12.zzi
            java.lang.Object r1 = r5.second
            java.lang.String r1 = (java.lang.String) r1
            r0.put(r13, r1)
            return
        L_0x00f8:
            r13 = move-exception
            r1 = r2
        L_0x00fa:
            if (r1 == 0) goto L_0x00ff
            r1.close()
        L_0x00ff:
            throw r13
        L_0x0100:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfi.zzt(java.lang.String):void");
    }

    private final void zzu(String str, zzfc zzfc) {
        if (zzfc.zza() != 0) {
            this.zzs.zzay().zzj().zzb("EES programs found", Integer.valueOf(zzfc.zza()));
            zzgo zzgo = (zzgo) zzfc.zzj().get(0);
            try {
                zzc zzc2 = new zzc();
                zzc2.zzd("internal.remoteConfig", new zzfc(this, str));
                zzc2.zzd("internal.appMetadata", new zzfe(this, str));
                zzc2.zzd("internal.logger", new zzfb(this));
                zzc2.zzc(zzgo);
                this.zzc.put(str, zzc2);
                this.zzs.zzay().zzj().zzc("EES program loaded for appId, activities", str, Integer.valueOf(zzgo.zza().zza()));
                for (zzgm zzb2 : zzgo.zza().zzd()) {
                    this.zzs.zzay().zzj().zzb("EES program activity", zzb2.zzb());
                }
            } catch (zzd unused) {
                this.zzs.zzay().zzd().zzb("Failed to load EES program. appId", str);
            }
        } else {
            this.zzc.remove(str);
        }
    }

    private static final Map zzv(zzfc zzfc) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzfc != null) {
            for (zzfe zzfe : zzfc.zzk()) {
                arrayMap.put(zzfe.zzb(), zzfe.zzc());
            }
        }
        return arrayMap;
    }

    public final String zza(String str, String str2) {
        zzg();
        zzt(str);
        Map map = (Map) this.zze.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(String str, String str2) {
        Integer num;
        zzg();
        zzt(str);
        Map map = (Map) this.zzh.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public final zzfc zze(String str) {
        zzW();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzt(str);
        return (zzfc) this.zzg.get(str);
    }

    /* access modifiers changed from: protected */
    public final String zzf(String str) {
        zzg();
        return (String) this.zzi.get(str);
    }

    /* access modifiers changed from: protected */
    public final void zzi(String str) {
        zzg();
        this.zzi.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzj(String str) {
        zzg();
        this.zzg.remove(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzk(String str) {
        zzg();
        zzfc zze2 = zze(str);
        if (zze2 == null) {
            return false;
        }
        return zze2.zzo();
    }

    public final boolean zzl(String str) {
        zzfc zzfc;
        if (TextUtils.isEmpty(str) || (zzfc = (zzfc) this.zzg.get(str)) == null || zzfc.zza() == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzm(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzn(String str, String str2) {
        Boolean bool;
        zzg();
        zzt(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2) || FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map map = (Map) this.zzb.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzo(String str, String str2) {
        Boolean bool;
        zzg();
        zzt(str);
        if (zzm(str) && zzkw.zzag(str2)) {
            return true;
        }
        if (zzp(str) && zzkw.zzah(str2)) {
            return true;
        }
        Map map = (Map) this.zza.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzp(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    /* access modifiers changed from: protected */
    public final boolean zzq(String str, byte[] bArr, String str2) {
        zzW();
        zzg();
        Preconditions.checkNotEmpty(str);
        zzfb zzfb = (zzfb) zzr(str, bArr).zzbt();
        if (zzfb == null) {
            return false;
        }
        zzs(str, zzfb);
        zzu(str, (zzfc) zzfb.zzay());
        this.zzg.put(str, (zzfc) zzfb.zzay());
        this.zzi.put(str, str2);
        this.zze.put(str, zzv((zzfc) zzfb.zzay()));
        this.zzf.zzi().zzB(str, new ArrayList(zzfb.zze()));
        try {
            zzfb.zzc();
            bArr = ((zzfc) zzfb.zzay()).zzbq();
        } catch (RuntimeException e) {
            this.zzs.zzay().zzk().zzc("Unable to serialize reduced-size config. Storing full config instead. appId", zzeh.zzn(str), e);
        }
        zzak zzi2 = this.zzf.zzi();
        Preconditions.checkNotEmpty(str);
        zzi2.zzg();
        zzi2.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        try {
            if (((long) zzi2.zzh().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzi2.zzs.zzay().zzd().zzb("Failed to update remote config (got 0). appId", zzeh.zzn(str));
            }
        } catch (SQLiteException e2) {
            zzi2.zzs.zzay().zzd().zzc("Error storing remote config. appId", zzeh.zzn(str), e2);
        }
        this.zzg.put(str, (zzfc) zzfb.zzay());
        return true;
    }
}
