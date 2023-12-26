package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzmt;
import com.google.android.gms.internal.measurement.zzno;
import com.google.android.gms.internal.measurement.zzpb;
import com.google.firebase.messaging.Constants;
import com.igexin.assist.control.fcm.GTJobService;
import com.igexin.assist.sdk.AssistPushConsts;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzkp implements zzgm {
    private static volatile zzkp zzb;
    private long zzA;
    private final Map zzB;
    private zzid zzC;
    private String zzD;
    private final zzkv zzE = new zzkm(this);
    long zza;
    private final zzfi zzc;
    private final zzen zzd;
    private zzak zze;
    private zzep zzf;
    private zzkd zzg;
    private zzz zzh;
    private final zzkr zzi;
    private zzib zzj;
    private zzjm zzk;
    private final zzkg zzl;
    private zzez zzm;
    /* access modifiers changed from: private */
    public final zzfr zzn;
    private boolean zzo = false;
    private boolean zzp;
    private List zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List zzy;
    private List zzz;

    zzkp(zzkq zzkq, zzfr zzfr) {
        Preconditions.checkNotNull(zzkq);
        this.zzn = zzfr.zzp(zzkq.zza, (zzcl) null, (Long) null);
        this.zzA = -1;
        this.zzl = new zzkg(this);
        zzkr zzkr = new zzkr(this);
        zzkr.zzX();
        this.zzi = zzkr;
        zzen zzen = new zzen(this);
        zzen.zzX();
        this.zzd = zzen;
        zzfi zzfi = new zzfi(this);
        zzfi.zzX();
        this.zzc = zzfi;
        this.zzB = new HashMap();
        zzaz().zzp(new zzkh(this, zzkq));
    }

    static final void zzZ(zzfn zzfn, int i, String str) {
        List zzp2 = zzfn.zzp();
        int i2 = 0;
        while (i2 < zzp2.size()) {
            if (!"_err".equals(((zzfs) zzp2.get(i2)).zzg())) {
                i2++;
            } else {
                return;
            }
        }
        zzfr zze2 = zzfs.zze();
        zze2.zzj("_err");
        zze2.zzi(Long.valueOf((long) i).longValue());
        zzfr zze3 = zzfs.zze();
        zze3.zzj("_ev");
        zze3.zzk(str);
        zzfn.zzf((zzfs) zze2.zzay());
        zzfn.zzf((zzfs) zze3.zzay());
    }

    static final void zzaa(zzfn zzfn, String str) {
        List zzp2 = zzfn.zzp();
        for (int i = 0; i < zzp2.size(); i++) {
            if (str.equals(((zzfs) zzp2.get(i)).zzg())) {
                zzfn.zzh(i);
                return;
            }
        }
    }

    private final zzp zzab(String str) {
        String str2 = str;
        zzak zzak = this.zze;
        zzak(zzak);
        zzg zzj2 = zzak.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzay().zzc().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzac = zzac(zzj2);
        if (zzac == null || zzac.booleanValue()) {
            zzg zzg2 = zzj2;
            return new zzp(str, zzj2.zzy(), zzj2.zzw(), zzj2.zzb(), zzj2.zzv(), zzj2.zzm(), zzj2.zzj(), (String) null, zzj2.zzah(), false, zzj2.zzx(), zzg2.zza(), 0, 0, zzg2.zzag(), false, zzg2.zzr(), zzg2.zzq(), zzg2.zzk(), zzg2.zzB(), (String) null, zzh(str).zzh());
        }
        zzay().zzd().zzb("App version does not match; dropping. appId", zzeh.zzn(str));
        return null;
    }

    private final Boolean zzac(zzg zzg2) {
        try {
            if (zzg2.zzb() != -2147483648L) {
                if (zzg2.zzb() == ((long) Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzg2.zzt(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzg2.zzt(), 0).versionName;
                String zzw2 = zzg2.zzw();
                if (zzw2 != null && zzw2.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzad() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzay().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzj().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    private final void zzae(zzfx zzfx, long j, boolean z) {
        zzku zzku;
        String str = true != z ? "_lte" : "_se";
        zzak zzak = this.zze;
        zzak(zzak);
        zzku zzp2 = zzak.zzp(zzfx.zzak(), str);
        if (zzp2 == null || zzp2.zze == null) {
            zzku = new zzku(zzfx.zzak(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzku = new zzku(zzfx.zzak(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(((Long) zzp2.zze).longValue() + j));
        }
        zzgg zzd2 = zzgh.zzd();
        zzd2.zzf(str);
        zzd2.zzg(zzav().currentTimeMillis());
        zzd2.zze(((Long) zzku.zze).longValue());
        zzgh zzgh = (zzgh) zzd2.zzay();
        int zza2 = zzkr.zza(zzfx, str);
        if (zza2 >= 0) {
            zzfx.zzah(zza2, zzgh);
        } else {
            zzfx.zzl(zzgh);
        }
        if (j > 0) {
            zzak zzak2 = this.zze;
            zzak(zzak2);
            zzak2.zzL(zzku);
            zzay().zzj().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", zzku.zze);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0237  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzaf() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzfo r1 = r20.zzaz()
            r1.zzg()
            r20.zzB()
            long r1 = r0.zza
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004e
            r1 = 3600000(0x36ee80, double:1.7786363E-317)
            com.google.android.gms.common.util.Clock r5 = r20.zzav()
            long r5 = r5.elapsedRealtime()
            long r7 = r0.zza
            long r5 = r5 - r7
            long r5 = java.lang.Math.abs(r5)
            long r1 = r1 - r5
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzeh r3 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzj()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            java.lang.String r2 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r3.zzb(r2, r1)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkd r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        L_0x004c:
            r0.zza = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.zzfr r1 = r0.zzn
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x0254
            boolean r1 = r20.zzah()
            if (r1 != 0) goto L_0x005e
            goto L_0x0254
        L_0x005e:
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzak r5 = r0.zze
            zzak(r5)
            boolean r5 = r5.zzH()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.zzak r5 = r0.zze
            zzak(r5)
            boolean r5 = r5.zzG()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.zzaf r5 = r20.zzg()
            java.lang.String r5 = r5.zzl()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bf
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzu
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00bf:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzt
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00d3:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzs
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzjm r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzc
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zzjm r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzd
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.zzak r5 = r0.zze
            zzak(r5)
            r17 = r10
            long r9 = r5.zzd()
            com.google.android.gms.measurement.internal.zzak r5 = r0.zze
            zzak(r5)
            r18 = r7
            long r6 = r5.zze()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0117
        L_0x0114:
            r7 = r3
            goto L_0x018e
        L_0x0117:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r9 = r1 - r9
            long r1 = r1 - r7
            long r1 = java.lang.Math.max(r1, r9)
            long r7 = r5 + r18
            if (r17 == 0) goto L_0x013c
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x013c
            long r7 = java.lang.Math.min(r5, r1)
            long r7 = r7 + r11
        L_0x013c:
            com.google.android.gms.measurement.internal.zzkr r13 = r0.zzi
            zzak(r13)
            boolean r13 = r13.zzw(r1, r11)
            if (r13 != 0) goto L_0x0149
            long r7 = r1 + r11
        L_0x0149:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x018e
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x018e
            r1 = 0
        L_0x0152:
            r20.zzg()
            r2 = 20
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzB
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            r11 = 0
            int r5 = java.lang.Math.max(r11, r5)
            int r2 = java.lang.Math.min(r2, r5)
            if (r1 >= r2) goto L_0x0114
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r2 = com.google.android.gms.measurement.internal.zzdu.zzA
            java.lang.Object r2 = r2.zza(r6)
            java.lang.Long r2 = (java.lang.Long) r2
            long r5 = r2.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            r12 = 1
            long r12 = r12 << r1
            long r5 = r5 * r12
            long r7 = r7 + r5
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x018e
            int r1 = r1 + 1
            goto L_0x0152
        L_0x018e:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0237
            com.google.android.gms.measurement.internal.zzen r1 = r0.zzd
            zzak(r1)
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x021a
            com.google.android.gms.measurement.internal.zzjm r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzb
            long r1 = r1.zza()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzkr r9 = r0.zzi
            zzak(r9)
            boolean r9 = r9.zzw(r1, r5)
            if (r9 != 0) goto L_0x01c9
            long r1 = r1 + r5
            long r7 = java.lang.Math.max(r7, r1)
        L_0x01c9:
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            long r7 = r7 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0200
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r1 = com.google.android.gms.measurement.internal.zzdu.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzjm r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r20.zzav()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0200:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzkd r1 = r0.zzg
            zzak(r1)
            r1.zzd(r7)
            return
        L_0x021a:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzkd r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        L_0x0237:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkd r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        L_0x0254:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzep r1 = r20.zzm()
            r1.zzc()
            com.google.android.gms.measurement.internal.zzkd r1 = r0.zzg
            zzak(r1)
            r1.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzaf():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0b81, code lost:
        if (r10 > (com.google.android.gms.measurement.internal.zzaf.zzA() + r8)) goto L_0x0b83;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x03a7 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x046b A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x04c5 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x081f A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0868 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x088b A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0902 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0904 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x090c A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x0938 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0b71 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x0bf8 A[Catch:{ NumberFormatException -> 0x07e4, all -> 0x0d1a }] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0c14 A[Catch:{ SQLiteException -> 0x0c2c }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:69:0x01e4=Splitter:B:69:0x01e4, B:420:0x0d08=Splitter:B:420:0x0d08} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzag(java.lang.String r42, long r43) {
        /*
            r41 = this;
            r1 = r41
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            com.google.android.gms.measurement.internal.zzak r4 = r1.zze
            zzak(r4)
            r4.zzw()
            com.google.android.gms.measurement.internal.zzko r4 = new com.google.android.gms.measurement.internal.zzko     // Catch:{ all -> 0x0d1a }
            r12 = 0
            r4.<init>(r1, r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzak r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r5)     // Catch:{ all -> 0x0d1a }
            r6 = 0
            long r9 = r1.zzA     // Catch:{ all -> 0x0d1a }
            r7 = r43
            r11 = r4
            r5.zzU(r6, r7, r9, r11)     // Catch:{ all -> 0x0d1a }
            java.util.List r5 = r4.zzc     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0d08
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x002e
            goto L_0x0d08
        L_0x002e:
            com.google.android.gms.internal.measurement.zzfy r5 = r4.zza     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjt r5 = r5.zzbt()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x0d1a }
            r5.zzp()     // Catch:{ all -> 0x0d1a }
            r10 = r12
            r13 = r10
            r8 = 0
            r9 = 0
            r11 = -1
            r14 = -1
            r15 = 0
        L_0x0040:
            java.util.List r12 = r4.zzc     // Catch:{ all -> 0x0d1a }
            int r12 = r12.size()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "_fr"
            java.lang.String r7 = "_et"
            r16 = r15
            java.lang.String r15 = "_e"
            r17 = r2
            r18 = r3
            if (r8 >= r12) goto L_0x0543
            java.util.List r3 = r4.zzc     // Catch:{ all -> 0x0d1a }
            java.lang.Object r3 = r3.get(r8)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r3 = (com.google.android.gms.internal.measurement.zzfo) r3     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjt r3 = r3.zzbt()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfn r3 = (com.google.android.gms.internal.measurement.zzfn) r3     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfi r12 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzak(r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r2 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r2.zzy()     // Catch:{ all -> 0x0d1a }
            r20 = r9
            java.lang.String r9 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r12.zzo(r2, r9)     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = "_err"
            if (r2 == 0) goto L_0x00f3
            com.google.android.gms.measurement.internal.zzeh r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzfy r7 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r15 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzd(r15)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r6, r7, r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.zzm(r6)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.zzp(r6)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00e8
        L_0x00c3:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r9.equals(r2)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x00e8
            com.google.android.gms.measurement.internal.zzkw r21 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzE     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r23 = r6.zzy()     // Catch:{ all -> 0x0d1a }
            r24 = 11
            java.lang.String r25 = "_ev"
            java.lang.String r26 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            r27 = 0
            r22 = r2
            r21.zzM(r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x0d1a }
        L_0x00e8:
            r7 = r8
            r23 = r10
            r15 = r16
            r9 = r20
            r10 = r5
            r5 = -1
            goto L_0x0538
        L_0x00f3:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = com.google.android.gms.measurement.internal.zzgo.zza(r18)     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x016d
            r2 = r18
            r3.zzi(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r12 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzj()     // Catch:{ all -> 0x0d1a }
            r18 = r2
            java.lang.String r2 = "Renaming ad_impression to _ai"
            r12.zza(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r2.zzq()     // Catch:{ all -> 0x0d1a }
            r12 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r12)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x016d
            r2 = 0
        L_0x0125:
            int r12 = r3.zza()     // Catch:{ all -> 0x0d1a }
            if (r2 >= r12) goto L_0x016d
            java.lang.String r12 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfs r21 = r3.zzn(r2)     // Catch:{ all -> 0x0d1a }
            r22 = r8
            java.lang.String r8 = r21.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r12.equals(r8)     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x0168
            com.google.android.gms.internal.measurement.zzfs r8 = r3.zzn(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r8.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0d1a }
            if (r8 != 0) goto L_0x0168
            java.lang.String r8 = "admob"
            com.google.android.gms.internal.measurement.zzfs r12 = r3.zzn(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r8.equalsIgnoreCase(r12)     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x0168
            com.google.android.gms.measurement.internal.zzeh r8 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzl()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "AdMob ad impression logged from app. Potentially duplicative."
            r8.zza(r12)     // Catch:{ all -> 0x0d1a }
        L_0x0168:
            int r2 = r2 + 1
            r8 = r22
            goto L_0x0125
        L_0x016d:
            r22 = r8
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r8 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r8.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.zzn(r8, r12)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = "_c"
            if (r2 != 0) goto L_0x01db
            com.google.android.gms.measurement.internal.zzkr r12 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r12)     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)     // Catch:{ all -> 0x0d1a }
            r21 = r11
            int r11 = r12.hashCode()     // Catch:{ all -> 0x0d1a }
            r23 = r10
            r10 = 94660(0x171c4, float:1.32647E-40)
            if (r11 == r10) goto L_0x01be
            r10 = 95025(0x17331, float:1.33158E-40)
            if (r11 == r10) goto L_0x01b4
            r10 = 95027(0x17333, float:1.33161E-40)
            if (r11 == r10) goto L_0x01aa
            goto L_0x01c8
        L_0x01aa:
            java.lang.String r10 = "_ui"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 1
            goto L_0x01c9
        L_0x01b4:
            java.lang.String r10 = "_ug"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 2
            goto L_0x01c9
        L_0x01be:
            java.lang.String r10 = "_in"
            boolean r10 = r12.equals(r10)
            if (r10 == 0) goto L_0x01c8
            r10 = 0
            goto L_0x01c9
        L_0x01c8:
            r10 = -1
        L_0x01c9:
            if (r10 == 0) goto L_0x01df
            r11 = 1
            if (r10 == r11) goto L_0x01df
            r11 = 2
            if (r10 == r11) goto L_0x01df
            r25 = r5
            r24 = r7
            r7 = r13
            r19 = r14
            r2 = 0
            goto L_0x03a5
        L_0x01db:
            r23 = r10
            r21 = r11
        L_0x01df:
            r24 = r7
            r10 = 0
            r11 = 0
            r12 = 0
        L_0x01e4:
            int r7 = r3.zza()     // Catch:{ all -> 0x0d1a }
            r25 = r5
            java.lang.String r5 = "_r"
            if (r10 >= r7) goto L_0x024b
            com.google.android.gms.internal.measurement.zzfs r7 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x0219
            com.google.android.gms.internal.measurement.zzfs r5 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjt r5 = r5.zzbt()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfr r5 = (com.google.android.gms.internal.measurement.zzfr) r5     // Catch:{ all -> 0x0d1a }
            r7 = r13
            r19 = r14
            r13 = 1
            r5.zzi(r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r5 = r5.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r5 = (com.google.android.gms.internal.measurement.zzfs) r5     // Catch:{ all -> 0x0d1a }
            r3.zzk(r10, r5)     // Catch:{ all -> 0x0d1a }
            r11 = 1
            goto L_0x0243
        L_0x0219:
            r7 = r13
            r19 = r14
            com.google.android.gms.internal.measurement.zzfs r13 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r13.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.equals(r13)     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0243
            com.google.android.gms.internal.measurement.zzfs r5 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjt r5 = r5.zzbt()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfr r5 = (com.google.android.gms.internal.measurement.zzfr) r5     // Catch:{ all -> 0x0d1a }
            r12 = 1
            r5.zzi(r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r5 = r5.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r5 = (com.google.android.gms.internal.measurement.zzfs) r5     // Catch:{ all -> 0x0d1a }
            r3.zzk(r10, r5)     // Catch:{ all -> 0x0d1a }
            r12 = 1
        L_0x0243:
            int r10 = r10 + 1
            r13 = r7
            r14 = r19
            r5 = r25
            goto L_0x01e4
        L_0x024b:
            r7 = r13
            r19 = r14
            if (r11 != 0) goto L_0x027c
            if (r2 == 0) goto L_0x027c
            com.google.android.gms.measurement.internal.zzeh r10 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzn     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzec r13 = r13.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r13.zzd(r14)     // Catch:{ all -> 0x0d1a }
            r10.zzb(r11, r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfr r10 = com.google.android.gms.internal.measurement.zzfs.zze()     // Catch:{ all -> 0x0d1a }
            r10.zzj(r8)     // Catch:{ all -> 0x0d1a }
            r13 = 1
            r10.zzi(r13)     // Catch:{ all -> 0x0d1a }
            r3.zze(r10)     // Catch:{ all -> 0x0d1a }
        L_0x027c:
            if (r12 != 0) goto L_0x02a8
            com.google.android.gms.measurement.internal.zzeh r10 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzd(r13)     // Catch:{ all -> 0x0d1a }
            r10.zzb(r11, r12)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfr r10 = com.google.android.gms.internal.measurement.zzfs.zze()     // Catch:{ all -> 0x0d1a }
            r10.zzj(r5)     // Catch:{ all -> 0x0d1a }
            r11 = 1
            r10.zzi(r11)     // Catch:{ all -> 0x0d1a }
            r3.zze(r10)     // Catch:{ all -> 0x0d1a }
        L_0x02a8:
            com.google.android.gms.measurement.internal.zzak r10 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r10)     // Catch:{ all -> 0x0d1a }
            long r27 = r41.zza()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r29 = r11.zzy()     // Catch:{ all -> 0x0d1a }
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 1
            r26 = r10
            com.google.android.gms.measurement.internal.zzai r10 = r26.zzl(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0d1a }
            long r10 = r10.zze     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaf r12 = r41.zzg()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r13 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r13.zzy()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzn     // Catch:{ all -> 0x0d1a }
            int r12 = r12.zze(r13, r14)     // Catch:{ all -> 0x0d1a }
            long r12 = (long) r12     // Catch:{ all -> 0x0d1a }
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x02e2
            zzaa(r3, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x02e4
        L_0x02e2:
            r16 = 1
        L_0x02e4:
            java.lang.String r5 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r5 = com.google.android.gms.measurement.internal.zzkw.zzah(r5)     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x03a5
            if (r2 == 0) goto L_0x03a5
            com.google.android.gms.measurement.internal.zzak r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r5)     // Catch:{ all -> 0x0d1a }
            long r27 = r41.zza()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r10 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r29 = r10.zzy()     // Catch:{ all -> 0x0d1a }
            r30 = 0
            r31 = 0
            r32 = 1
            r33 = 0
            r34 = 0
            r26 = r5
            com.google.android.gms.measurement.internal.zzai r5 = r26.zzl(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0d1a }
            long r10 = r5.zzc     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaf r5 = r41.zzg()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r12 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzy()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzdt r13 = com.google.android.gms.measurement.internal.zzdu.zzm     // Catch:{ all -> 0x0d1a }
            int r5 = r5.zze(r12, r13)     // Catch:{ all -> 0x0d1a }
            long r12 = (long) r5     // Catch:{ all -> 0x0d1a }
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 <= 0) goto L_0x03a5
            com.google.android.gms.measurement.internal.zzeh r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzfy r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r11)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r10, r11)     // Catch:{ all -> 0x0d1a }
            r5 = 0
            r10 = 0
            r11 = 0
            r12 = -1
        L_0x0341:
            int r13 = r3.zza()     // Catch:{ all -> 0x0d1a }
            if (r10 >= r13) goto L_0x036b
            com.google.android.gms.internal.measurement.zzfs r13 = r3.zzn(r10)     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = r13.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r14 = r8.equals(r14)     // Catch:{ all -> 0x0d1a }
            if (r14 == 0) goto L_0x035d
            com.google.android.gms.internal.measurement.zzjt r5 = r13.zzbt()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfr r5 = (com.google.android.gms.internal.measurement.zzfr) r5     // Catch:{ all -> 0x0d1a }
            r12 = r10
            goto L_0x0368
        L_0x035d:
            java.lang.String r13 = r13.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r13 = r9.equals(r13)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x0368
            r11 = 1
        L_0x0368:
            int r10 = r10 + 1
            goto L_0x0341
        L_0x036b:
            if (r11 == 0) goto L_0x0374
            if (r5 == 0) goto L_0x0373
            r3.zzh(r12)     // Catch:{ all -> 0x0d1a }
            goto L_0x03a5
        L_0x0373:
            r5 = 0
        L_0x0374:
            if (r5 == 0) goto L_0x038e
            com.google.android.gms.internal.measurement.zzjt r5 = r5.zzao()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfr r5 = (com.google.android.gms.internal.measurement.zzfr) r5     // Catch:{ all -> 0x0d1a }
            r5.zzj(r9)     // Catch:{ all -> 0x0d1a }
            r9 = 10
            r5.zzi(r9)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r5 = r5.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r5 = (com.google.android.gms.internal.measurement.zzfs) r5     // Catch:{ all -> 0x0d1a }
            r3.zzk(r12, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x03a5
        L_0x038e:
            com.google.android.gms.measurement.internal.zzeh r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzfy r10 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = r10.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r9, r10)     // Catch:{ all -> 0x0d1a }
        L_0x03a5:
            if (r2 == 0) goto L_0x045e
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0d1a }
            java.util.List r5 = r3.zzp()     // Catch:{ all -> 0x0d1a }
            r2.<init>(r5)     // Catch:{ all -> 0x0d1a }
            r5 = 0
            r9 = -1
            r10 = -1
        L_0x03b3:
            int r11 = r2.size()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "currency"
            java.lang.String r13 = "value"
            if (r5 >= r11) goto L_0x03e3
            java.lang.Object r11 = r2.get(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r11 = r13.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x03cf
            r9 = r5
            goto L_0x03e0
        L_0x03cf:
            java.lang.Object r11 = r2.get(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x03e0
            r10 = r5
        L_0x03e0:
            int r5 = r5 + 1
            goto L_0x03b3
        L_0x03e3:
            r5 = -1
            if (r9 != r5) goto L_0x03e8
            goto L_0x045f
        L_0x03e8:
            java.lang.Object r5 = r2.get(r9)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r5 = (com.google.android.gms.internal.measurement.zzfs) r5     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.zzw()     // Catch:{ all -> 0x0d1a }
            if (r5 != 0) goto L_0x0419
            java.lang.Object r5 = r2.get(r9)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r5 = (com.google.android.gms.internal.measurement.zzfs) r5     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.zzu()     // Catch:{ all -> 0x0d1a }
            if (r5 != 0) goto L_0x0419
            com.google.android.gms.measurement.internal.zzeh r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzl()     // Catch:{ all -> 0x0d1a }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.zza(r5)     // Catch:{ all -> 0x0d1a }
            r3.zzh(r9)     // Catch:{ all -> 0x0d1a }
            zzaa(r3, r8)     // Catch:{ all -> 0x0d1a }
            r2 = 18
            zzZ(r3, r2, r13)     // Catch:{ all -> 0x0d1a }
            goto L_0x045e
        L_0x0419:
            r5 = -1
            if (r10 != r5) goto L_0x041d
            goto L_0x0445
        L_0x041d:
            java.lang.Object r2 = r2.get(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x0d1a }
            int r10 = r2.length()     // Catch:{ all -> 0x0d1a }
            r11 = 3
            if (r10 != r11) goto L_0x0445
            r10 = 0
        L_0x042f:
            int r11 = r2.length()     // Catch:{ all -> 0x0d1a }
            if (r10 >= r11) goto L_0x045f
            int r11 = r2.codePointAt(r10)     // Catch:{ all -> 0x0d1a }
            boolean r13 = java.lang.Character.isLetter(r11)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x0445
            int r11 = java.lang.Character.charCount(r11)     // Catch:{ all -> 0x0d1a }
            int r10 = r10 + r11
            goto L_0x042f
        L_0x0445:
            com.google.android.gms.measurement.internal.zzeh r2 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzl()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r10)     // Catch:{ all -> 0x0d1a }
            r3.zzh(r9)     // Catch:{ all -> 0x0d1a }
            zzaa(r3, r8)     // Catch:{ all -> 0x0d1a }
            r2 = 19
            zzZ(r3, r2, r12)     // Catch:{ all -> 0x0d1a }
            goto L_0x045f
        L_0x045e:
            r5 = -1
        L_0x045f:
            java.lang.String r2 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r15.equals(r2)     // Catch:{ all -> 0x0d1a }
            r8 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04c5
            com.google.android.gms.measurement.internal.zzkr r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r2 = r3.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r2 = com.google.android.gms.measurement.internal.zzkr.zzB(r2, r6)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x04c0
            if (r7 == 0) goto L_0x04b4
            long r10 = r7.zzc()     // Catch:{ all -> 0x0d1a }
            long r12 = r3.zzc()     // Catch:{ all -> 0x0d1a }
            long r10 = r10 - r12
            long r10 = java.lang.Math.abs(r10)     // Catch:{ all -> 0x0d1a }
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x04b4
            com.google.android.gms.internal.measurement.zzjt r2 = r7.zzao()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfn r2 = (com.google.android.gms.internal.measurement.zzfn) r2     // Catch:{ all -> 0x0d1a }
            boolean r6 = r1.zzai(r3, r2)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x04a7
            r6 = r19
            r10 = r25
            r10.zzO(r6, r2)     // Catch:{ all -> 0x0d1a }
            r11 = r21
            r2 = 0
            r13 = 0
            goto L_0x04af
        L_0x04a7:
            r6 = r19
            r10 = r25
            r2 = r3
            r13 = r7
            r11 = r20
        L_0x04af:
            r23 = r2
            r14 = r6
            goto L_0x0524
        L_0x04b4:
            r6 = r19
            r10 = r25
            r23 = r3
            r14 = r6
            r13 = r7
            r11 = r20
            goto L_0x0524
        L_0x04c0:
            r6 = r19
            r10 = r25
            goto L_0x051f
        L_0x04c5:
            r6 = r19
            r10 = r25
            java.lang.String r2 = "_vs"
            java.lang.String r11 = r3.zzo()     // Catch:{ all -> 0x0d1a }
            boolean r2 = r2.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x051f
            com.google.android.gms.measurement.internal.zzkr r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r2 = r3.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ all -> 0x0d1a }
            r11 = r24
            com.google.android.gms.internal.measurement.zzfs r2 = com.google.android.gms.measurement.internal.zzkr.zzB(r2, r11)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x051f
            if (r23 == 0) goto L_0x0518
            long r11 = r23.zzc()     // Catch:{ all -> 0x0d1a }
            long r13 = r3.zzc()     // Catch:{ all -> 0x0d1a }
            long r11 = r11 - r13
            long r11 = java.lang.Math.abs(r11)     // Catch:{ all -> 0x0d1a }
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x0518
            com.google.android.gms.internal.measurement.zzjt r2 = r23.zzao()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfn r2 = (com.google.android.gms.internal.measurement.zzfn) r2     // Catch:{ all -> 0x0d1a }
            boolean r7 = r1.zzai(r2, r3)     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x0511
            r8 = r21
            r10.zzO(r8, r2)     // Catch:{ all -> 0x0d1a }
            r14 = r6
            r2 = 0
            r23 = 0
            goto L_0x0516
        L_0x0511:
            r8 = r21
            r2 = r3
            r14 = r20
        L_0x0516:
            r13 = r2
            goto L_0x0523
        L_0x0518:
            r8 = r21
            r13 = r3
            r11 = r8
            r14 = r20
            goto L_0x0524
        L_0x051f:
            r8 = r21
            r14 = r6
            r13 = r7
        L_0x0523:
            r11 = r8
        L_0x0524:
            java.util.List r2 = r4.zzc     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r6 = r3.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r6 = (com.google.android.gms.internal.measurement.zzfo) r6     // Catch:{ all -> 0x0d1a }
            r7 = r22
            r2.set(r7, r6)     // Catch:{ all -> 0x0d1a }
            int r9 = r20 + 1
            r10.zzj(r3)     // Catch:{ all -> 0x0d1a }
            r15 = r16
        L_0x0538:
            int r8 = r7 + 1
            r5 = r10
            r2 = r17
            r3 = r18
            r10 = r23
            goto L_0x0040
        L_0x0543:
            r10 = r5
            r11 = r7
            r20 = r9
            r2 = 0
            r7 = r2
            r5 = 0
        L_0x054b:
            if (r5 >= r9) goto L_0x059b
            com.google.android.gms.internal.measurement.zzfo r12 = r10.zze(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.String r13 = r12.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r13 = r15.equals(r13)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x056e
            com.google.android.gms.measurement.internal.zzkr r13 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r13 = com.google.android.gms.measurement.internal.zzkr.zzB(r12, r6)     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x056e
            r10.zzw(r5)     // Catch:{ all -> 0x0d1a }
            int r9 = r9 + -1
            int r5 = r5 + -1
            goto L_0x0598
        L_0x056e:
            com.google.android.gms.measurement.internal.zzkr r13 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r13)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r12 = com.google.android.gms.measurement.internal.zzkr.zzB(r12, r11)     // Catch:{ all -> 0x0d1a }
            if (r12 == 0) goto L_0x0598
            boolean r13 = r12.zzw()     // Catch:{ all -> 0x0d1a }
            if (r13 == 0) goto L_0x0588
            long r12 = r12.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x0d1a }
            goto L_0x0589
        L_0x0588:
            r12 = 0
        L_0x0589:
            if (r12 == 0) goto L_0x0598
            long r13 = r12.longValue()     // Catch:{ all -> 0x0d1a }
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 <= 0) goto L_0x0598
            long r12 = r12.longValue()     // Catch:{ all -> 0x0d1a }
            long r7 = r7 + r12
        L_0x0598:
            r12 = 1
            int r5 = r5 + r12
            goto L_0x054b
        L_0x059b:
            r5 = 0
            r1.zzae(r10, r7, r5)     // Catch:{ all -> 0x0d1a }
            java.util.List r5 = r10.zzam()     // Catch:{ all -> 0x0d1a }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0d1a }
        L_0x05a7:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = "_se"
            if (r6 == 0) goto L_0x05cd
            java.lang.String r6 = "_s"
            java.lang.Object r11 = r5.next()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r11 = (com.google.android.gms.internal.measurement.zzfo) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzh()     // Catch:{ all -> 0x0d1a }
            boolean r6 = r6.equals(r11)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x05a7
            com.google.android.gms.measurement.internal.zzak r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r10.zzak()     // Catch:{ all -> 0x0d1a }
            r5.zzA(r6, r9)     // Catch:{ all -> 0x0d1a }
        L_0x05cd:
            java.lang.String r5 = "_sid"
            int r5 = com.google.android.gms.measurement.internal.zzkr.zza(r10, r5)     // Catch:{ all -> 0x0d1a }
            if (r5 < 0) goto L_0x05da
            r5 = 1
            r1.zzae(r10, r7, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x05fa
        L_0x05da:
            int r5 = com.google.android.gms.measurement.internal.zzkr.zza(r10, r9)     // Catch:{ all -> 0x0d1a }
            if (r5 < 0) goto L_0x05fa
            r10.zzx(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzfy r7 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0d1a }
        L_0x05fa:
            com.google.android.gms.measurement.internal.zzkr r5 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r6 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Checking account type status for ad personalization signals"
            r6.zza(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkp r6 = r5.zzf     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfi r6 = r6.zzc     // Catch:{ all -> 0x0d1a }
            zzak(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r10.zzak()     // Catch:{ all -> 0x0d1a }
            boolean r6 = r6.zzk(r7)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.zzkp r6 = r5.zzf     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzak r6 = r6.zze     // Catch:{ all -> 0x0d1a }
            zzak(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r10.zzak()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzg r6 = r6.zzj(r7)     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            boolean r6 = r6.zzag()     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.zzfr r6 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzao r6 = r6.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r6 = r6.zze()     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0691
            com.google.android.gms.measurement.internal.zzfr r6 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzc()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Turning off ad personalization due to account type"
            r6.zza(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgg r6 = com.google.android.gms.internal.measurement.zzgh.zzd()     // Catch:{ all -> 0x0d1a }
            r7 = r17
            r6.zzf(r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzao r5 = r5.zzg()     // Catch:{ all -> 0x0d1a }
            long r8 = r5.zza()     // Catch:{ all -> 0x0d1a }
            r6.zzg(r8)     // Catch:{ all -> 0x0d1a }
            r8 = 1
            r6.zze(r8)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r5 = r6.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzgh r5 = (com.google.android.gms.internal.measurement.zzgh) r5     // Catch:{ all -> 0x0d1a }
            r6 = 0
        L_0x0673:
            int r8 = r10.zzb()     // Catch:{ all -> 0x0d1a }
            if (r6 >= r8) goto L_0x068e
            com.google.android.gms.internal.measurement.zzgh r8 = r10.zzaj(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r8.zzf()     // Catch:{ all -> 0x0d1a }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x068b
            r10.zzah(r6, r5)     // Catch:{ all -> 0x0d1a }
            goto L_0x0691
        L_0x068b:
            int r6 = r6 + 1
            goto L_0x0673
        L_0x068e:
            r10.zzl(r5)     // Catch:{ all -> 0x0d1a }
        L_0x0691:
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r10.zzad(r5)     // Catch:{ all -> 0x0d1a }
            r5 = -9223372036854775808
            r10.zzN(r5)     // Catch:{ all -> 0x0d1a }
            r5 = 0
        L_0x069f:
            int r6 = r10.zza()     // Catch:{ all -> 0x0d1a }
            if (r5 >= r6) goto L_0x06d2
            com.google.android.gms.internal.measurement.zzfo r6 = r10.zze(r5)     // Catch:{ all -> 0x0d1a }
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            long r11 = r10.zzd()     // Catch:{ all -> 0x0d1a }
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 >= 0) goto L_0x06bc
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            r10.zzad(r7)     // Catch:{ all -> 0x0d1a }
        L_0x06bc:
            long r7 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            long r11 = r10.zzc()     // Catch:{ all -> 0x0d1a }
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x06cf
            long r6 = r6.zzd()     // Catch:{ all -> 0x0d1a }
            r10.zzN(r6)     // Catch:{ all -> 0x0d1a }
        L_0x06cf:
            int r5 = r5 + 1
            goto L_0x069f
        L_0x06d2:
            r10.zzv()     // Catch:{ all -> 0x0d1a }
            r10.zzn()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzz r5 = r1.zzh     // Catch:{ all -> 0x0d1a }
            zzak(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.String r21 = r10.zzak()     // Catch:{ all -> 0x0d1a }
            java.util.List r22 = r10.zzam()     // Catch:{ all -> 0x0d1a }
            java.util.List r23 = r10.zzan()     // Catch:{ all -> 0x0d1a }
            long r6 = r10.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r24 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0d1a }
            long r6 = r10.zzc()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r25 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0d1a }
            r20 = r5
            java.util.List r5 = r20.zza(r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0d1a }
            r10.zzf(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaf r5 = r41.zzg()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r6 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0d1a }
            boolean r5 = r5.zzw(r6)     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0a54
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0d1a }
            r5.<init>()     // Catch:{ all -> 0x0d1a }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0d1a }
            r6.<init>()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkw r7 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            java.security.SecureRandom r7 = r7.zzF()     // Catch:{ all -> 0x0d1a }
            r8 = 0
        L_0x0725:
            int r9 = r10.zza()     // Catch:{ all -> 0x0d1a }
            if (r8 >= r9) goto L_0x0a1a
            com.google.android.gms.internal.measurement.zzfo r9 = r10.zze(r8)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjt r9 = r9.zzbt()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfn r9 = (com.google.android.gms.internal.measurement.zzfn) r9     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "_ep"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "_efs"
            java.lang.String r13 = "_sr"
            if (r11 == 0) goto L_0x07c8
            com.google.android.gms.measurement.internal.zzkr r11 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r11)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r11 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r11 = (com.google.android.gms.internal.measurement.zzfo) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = "_en"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzkr.zzC(r11, r14)     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0d1a }
            java.lang.Object r14 = r5.get(r11)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r14 = (com.google.android.gms.measurement.internal.zzaq) r14     // Catch:{ all -> 0x0d1a }
            if (r14 != 0) goto L_0x077c
            com.google.android.gms.measurement.internal.zzak r14 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r14)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r15 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r15 = r15.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r17 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x0d1a }
            r2 = r17
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r14 = r14.zzn(r15, r2)     // Catch:{ all -> 0x0d1a }
            if (r14 == 0) goto L_0x077c
            r5.put(r11, r14)     // Catch:{ all -> 0x0d1a }
        L_0x077c:
            if (r14 == 0) goto L_0x07bb
            java.lang.Long r2 = r14.zzi     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x07bb
            java.lang.Long r2 = r14.zzj     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x079a
            long r2 = r2.longValue()     // Catch:{ all -> 0x0d1a }
            r17 = 1
            int r2 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r2 <= 0) goto L_0x079a
            com.google.android.gms.measurement.internal.zzkr r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = r14.zzj     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkr.zzz(r9, r13, r2)     // Catch:{ all -> 0x0d1a }
        L_0x079a:
            java.lang.Boolean r2 = r14.zzk     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x07b2
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x07b2
            com.google.android.gms.measurement.internal.zzkr r2 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            r2 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkr.zzz(r9, r12, r11)     // Catch:{ all -> 0x0d1a }
        L_0x07b2:
            com.google.android.gms.internal.measurement.zzjx r2 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ all -> 0x0d1a }
            r6.add(r2)     // Catch:{ all -> 0x0d1a }
        L_0x07bb:
            r10.zzO(r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x07be:
            r24 = r4
            r22 = r7
            r2 = r10
            r7 = r5
            r4 = 1
            goto L_0x0a0e
        L_0x07c8:
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r3 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r11 = r2.zza(r3, r11)     // Catch:{ all -> 0x0d1a }
            boolean r14 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0d1a }
            if (r14 != 0) goto L_0x07f9
            long r2 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x07e4 }
            goto L_0x07fb
        L_0x07e4:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r14 = "Unable to parse timezone offset. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r14, r3, r11)     // Catch:{ all -> 0x0d1a }
        L_0x07f9:
            r2 = 0
        L_0x07fb:
            com.google.android.gms.measurement.internal.zzkw r11 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            long r14 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            long r14 = r11.zzr(r14, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r11 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r11 = (com.google.android.gms.internal.measurement.zzfo) r11     // Catch:{ all -> 0x0d1a }
            r44 = r12
            r17 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0d1a }
            r17 = r2
            java.lang.String r2 = "_dbg"
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0d1a }
            if (r3 != 0) goto L_0x0853
            java.util.List r3 = r11.zzi()     // Catch:{ all -> 0x0d1a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0d1a }
        L_0x0827:
            boolean r11 = r3.hasNext()     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x0853
            java.lang.Object r11 = r3.next()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfs r11 = (com.google.android.gms.internal.measurement.zzfs) r11     // Catch:{ all -> 0x0d1a }
            r22 = r3
            java.lang.String r3 = r11.zzg()     // Catch:{ all -> 0x0d1a }
            boolean r3 = r2.equals(r3)     // Catch:{ all -> 0x0d1a }
            if (r3 == 0) goto L_0x0850
            long r2 = r11.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0d1a }
            boolean r2 = r12.equals(r2)     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x084e
            goto L_0x0853
        L_0x084e:
            r2 = 1
            goto L_0x0866
        L_0x0850:
            r3 = r22
            goto L_0x0827
        L_0x0853:
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r3 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r3 = r3.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            int r2 = r2.zzc(r3, r11)     // Catch:{ all -> 0x0d1a }
        L_0x0866:
            if (r2 > 0) goto L_0x088b
            com.google.android.gms.measurement.internal.zzeh r3 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0d1a }
            r3.zzc(r11, r12, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r2 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ all -> 0x0d1a }
            r6.add(r2)     // Catch:{ all -> 0x0d1a }
            r10.zzO(r8, r9)     // Catch:{ all -> 0x0d1a }
            goto L_0x07be
        L_0x088b:
            java.lang.String r3 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r3 = r5.get(r3)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r3 = (com.google.android.gms.measurement.internal.zzaq) r3     // Catch:{ all -> 0x0d1a }
            if (r3 != 0) goto L_0x08eb
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r3)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = r11.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r3 = r3.zzn(r11, r12)     // Catch:{ all -> 0x0d1a }
            if (r3 != 0) goto L_0x08eb
            com.google.android.gms.measurement.internal.zzeh r3 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzfy r12 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = r12.zzy()     // Catch:{ all -> 0x0d1a }
            r22 = r14
            java.lang.String r14 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r3.zzc(r11, r12, r14)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r3 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r11 = r4.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r25 = r11.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.String r26 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r27 = 1
            r29 = 1
            r31 = 1
            long r33 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            r35 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r24 = r3
            r24.<init>(r25, r26, r27, r29, r31, r33, r35, r37, r38, r39, r40)     // Catch:{ all -> 0x0d1a }
            goto L_0x08ed
        L_0x08eb:
            r22 = r14
        L_0x08ed:
            com.google.android.gms.measurement.internal.zzkr r11 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r11)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r11 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r11 = (com.google.android.gms.internal.measurement.zzfo) r11     // Catch:{ all -> 0x0d1a }
            java.lang.String r12 = "_eid"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzkr.zzC(r11, r12)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x0904
            r12 = 1
            goto L_0x0905
        L_0x0904:
            r12 = 0
        L_0x0905:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0d1a }
            r14 = 1
            if (r2 != r14) goto L_0x0938
            com.google.android.gms.internal.measurement.zzjx r2 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch:{ all -> 0x0d1a }
            r6.add(r2)     // Catch:{ all -> 0x0d1a }
            boolean r2 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x0933
            java.lang.Long r2 = r3.zzi     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x0927
            java.lang.Long r2 = r3.zzj     // Catch:{ all -> 0x0d1a }
            if (r2 != 0) goto L_0x0927
            java.lang.Boolean r2 = r3.zzk     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x0933
        L_0x0927:
            r2 = 0
            com.google.android.gms.measurement.internal.zzaq r3 = r3.zza(r2, r2, r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r5.put(r2, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0933:
            r10.zzO(r8, r9)     // Catch:{ all -> 0x0d1a }
            goto L_0x07be
        L_0x0938:
            int r14 = r7.nextInt(r2)     // Catch:{ all -> 0x0d1a }
            if (r14 != 0) goto L_0x097a
            com.google.android.gms.measurement.internal.zzkr r11 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r11)     // Catch:{ all -> 0x0d1a }
            long r14 = (long) r2     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkr.zzz(r9, r13, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r11 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r11 = (com.google.android.gms.internal.measurement.zzfo) r11     // Catch:{ all -> 0x0d1a }
            r6.add(r11)     // Catch:{ all -> 0x0d1a }
            boolean r11 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r11 == 0) goto L_0x095f
            r11 = 0
            com.google.android.gms.measurement.internal.zzaq r3 = r3.zza(r11, r2, r11)     // Catch:{ all -> 0x0d1a }
        L_0x095f:
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            long r11 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            r14 = r22
            com.google.android.gms.measurement.internal.zzaq r3 = r3.zzb(r11, r14)     // Catch:{ all -> 0x0d1a }
            r5.put(r2, r3)     // Catch:{ all -> 0x0d1a }
            r24 = r4
            r22 = r7
            r2 = r10
            r7 = r5
            r4 = 1
            goto L_0x0a0b
        L_0x097a:
            r14 = r22
            r22 = r7
            java.lang.Long r7 = r3.zzh     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x098f
            long r17 = r7.longValue()     // Catch:{ all -> 0x0d1a }
            r24 = r4
            r26 = r5
            r25 = r10
            r23 = r11
            goto L_0x09a5
        L_0x098f:
            com.google.android.gms.measurement.internal.zzkw r7 = r41.zzv()     // Catch:{ all -> 0x0d1a }
            r25 = r10
            r23 = r11
            long r10 = r9.zzb()     // Catch:{ all -> 0x0d1a }
            r24 = r4
            r26 = r5
            r4 = r17
            long r17 = r7.zzr(r10, r4)     // Catch:{ all -> 0x0d1a }
        L_0x09a5:
            int r4 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x09f1
            com.google.android.gms.measurement.internal.zzkr r4 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r4)     // Catch:{ all -> 0x0d1a }
            r4 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0d1a }
            r10 = r44
            com.google.android.gms.measurement.internal.zzkr.zzz(r9, r10, r7)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkr r7 = r1.zzi     // Catch:{ all -> 0x0d1a }
            zzak(r7)     // Catch:{ all -> 0x0d1a }
            long r10 = (long) r2     // Catch:{ all -> 0x0d1a }
            java.lang.Long r2 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkr.zzz(r9, r13, r2)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r7 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfo r7 = (com.google.android.gms.internal.measurement.zzfo) r7     // Catch:{ all -> 0x0d1a }
            r6.add(r7)     // Catch:{ all -> 0x0d1a }
            boolean r7 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r7 == 0) goto L_0x09df
            r7 = 1
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0d1a }
            r7 = 0
            com.google.android.gms.measurement.internal.zzaq r3 = r3.zza(r7, r2, r10)     // Catch:{ all -> 0x0d1a }
        L_0x09df:
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            long r10 = r9.zzc()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r3 = r3.zzb(r10, r14)     // Catch:{ all -> 0x0d1a }
            r7 = r26
            r7.put(r2, r3)     // Catch:{ all -> 0x0d1a }
            goto L_0x0a09
        L_0x09f1:
            r7 = r26
            r4 = 1
            boolean r2 = r12.booleanValue()     // Catch:{ all -> 0x0d1a }
            if (r2 == 0) goto L_0x0a09
            java.lang.String r2 = r9.zzo()     // Catch:{ all -> 0x0d1a }
            r11 = r23
            r10 = 0
            com.google.android.gms.measurement.internal.zzaq r3 = r3.zza(r11, r10, r10)     // Catch:{ all -> 0x0d1a }
            r7.put(r2, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0a09:
            r2 = r25
        L_0x0a0b:
            r2.zzO(r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x0a0e:
            int r8 = r8 + 1
            r10 = r2
            r5 = r7
            r7 = r22
            r4 = r24
            r2 = 0
            goto L_0x0725
        L_0x0a1a:
            r24 = r4
            r7 = r5
            r2 = r10
            int r3 = r6.size()     // Catch:{ all -> 0x0d1a }
            int r4 = r2.zza()     // Catch:{ all -> 0x0d1a }
            if (r3 >= r4) goto L_0x0a2e
            r2.zzp()     // Catch:{ all -> 0x0d1a }
            r2.zzg(r6)     // Catch:{ all -> 0x0d1a }
        L_0x0a2e:
            java.util.Set r3 = r7.entrySet()     // Catch:{ all -> 0x0d1a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0d1a }
        L_0x0a36:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0d1a }
            if (r4 == 0) goto L_0x0a51
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0d1a }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzak r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r5)     // Catch:{ all -> 0x0d1a }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzaq r4 = (com.google.android.gms.measurement.internal.zzaq) r4     // Catch:{ all -> 0x0d1a }
            r5.zzE(r4)     // Catch:{ all -> 0x0d1a }
            goto L_0x0a36
        L_0x0a51:
            r3 = r24
            goto L_0x0a56
        L_0x0a54:
            r2 = r10
            r3 = r4
        L_0x0a56:
            com.google.android.gms.internal.measurement.zzfy r4 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r4 = r4.zzy()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzak r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzg r5 = r5.zzj(r4)     // Catch:{ all -> 0x0d1a }
            if (r5 != 0) goto L_0x0a7f
            com.google.android.gms.measurement.internal.zzeh r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzfy r7 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = r7.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r6, r7)     // Catch:{ all -> 0x0d1a }
            goto L_0x0adb
        L_0x0a7f:
            int r6 = r2.zza()     // Catch:{ all -> 0x0d1a }
            if (r6 <= 0) goto L_0x0adb
            long r6 = r5.zzn()     // Catch:{ all -> 0x0d1a }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0a93
            r2.zzX(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0a96
        L_0x0a93:
            r2.zzs()     // Catch:{ all -> 0x0d1a }
        L_0x0a96:
            long r8 = r5.zzp()     // Catch:{ all -> 0x0d1a }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0aa1
            goto L_0x0aa2
        L_0x0aa1:
            r6 = r8
        L_0x0aa2:
            int r8 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0aaa
            r2.zzY(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0aad
        L_0x0aaa:
            r2.zzt()     // Catch:{ all -> 0x0d1a }
        L_0x0aad:
            r5.zzD()     // Catch:{ all -> 0x0d1a }
            long r6 = r5.zzo()     // Catch:{ all -> 0x0d1a }
            int r6 = (int) r6     // Catch:{ all -> 0x0d1a }
            r2.zzF(r6)     // Catch:{ all -> 0x0d1a }
            long r6 = r2.zzd()     // Catch:{ all -> 0x0d1a }
            r5.zzab(r6)     // Catch:{ all -> 0x0d1a }
            long r6 = r2.zzc()     // Catch:{ all -> 0x0d1a }
            r5.zzZ(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r5.zzs()     // Catch:{ all -> 0x0d1a }
            if (r6 == 0) goto L_0x0ad0
            r2.zzS(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0ad3
        L_0x0ad0:
            r2.zzq()     // Catch:{ all -> 0x0d1a }
        L_0x0ad3:
            com.google.android.gms.measurement.internal.zzak r6 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r6)     // Catch:{ all -> 0x0d1a }
            r6.zzD(r5)     // Catch:{ all -> 0x0d1a }
        L_0x0adb:
            int r5 = r2.zza()     // Catch:{ all -> 0x0d1a }
            if (r5 <= 0) goto L_0x0c5f
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzn     // Catch:{ all -> 0x0d1a }
            r5.zzaw()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfi r5 = r1.zzc     // Catch:{ all -> 0x0d1a }
            zzak(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r6 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = r6.zzy()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfc r5 = r5.zze(r6)     // Catch:{ all -> 0x0d1a }
            r6 = -1
            if (r5 == 0) goto L_0x0b08
            boolean r8 = r5.zzq()     // Catch:{ all -> 0x0d1a }
            if (r8 != 0) goto L_0x0b00
            goto L_0x0b08
        L_0x0b00:
            long r8 = r5.zzc()     // Catch:{ all -> 0x0d1a }
            r2.zzH(r8)     // Catch:{ all -> 0x0d1a }
            goto L_0x0b2f
        L_0x0b08:
            com.google.android.gms.internal.measurement.zzfy r5 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r5 = r5.zzG()     // Catch:{ all -> 0x0d1a }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0d1a }
            if (r5 == 0) goto L_0x0b18
            r2.zzH(r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0b2f
        L_0x0b18:
            com.google.android.gms.measurement.internal.zzeh r5 = r41.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzfy r9 = r3.zza     // Catch:{ all -> 0x0d1a }
            java.lang.String r9 = r9.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x0d1a }
            r5.zzb(r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x0b2f:
            com.google.android.gms.measurement.internal.zzak r5 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r5)     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzjx r2 = r2.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.internal.measurement.zzfy r2 = (com.google.android.gms.internal.measurement.zzfy) r2     // Catch:{ all -> 0x0d1a }
            r5.zzg()     // Catch:{ all -> 0x0d1a }
            r5.zzW()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = r2.zzy()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x0d1a }
            boolean r8 = r2.zzba()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkState(r8)     // Catch:{ all -> 0x0d1a }
            r5.zzz()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r8 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.util.Clock r8 = r8.zzav()     // Catch:{ all -> 0x0d1a }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0d1a }
            long r10 = r2.zzm()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r12 = r5.zzs     // Catch:{ all -> 0x0d1a }
            r12.zzf()     // Catch:{ all -> 0x0d1a }
            long r12 = com.google.android.gms.measurement.internal.zzaf.zzA()     // Catch:{ all -> 0x0d1a }
            long r12 = r8 - r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 < 0) goto L_0x0b83
            long r10 = r2.zzm()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzfr r12 = r5.zzs     // Catch:{ all -> 0x0d1a }
            r12.zzf()     // Catch:{ all -> 0x0d1a }
            long r12 = com.google.android.gms.measurement.internal.zzaf.zzA()     // Catch:{ all -> 0x0d1a }
            long r12 = r12 + r8
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x0ba6
        L_0x0b83:
            com.google.android.gms.measurement.internal.zzfr r10 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzk()     // Catch:{ all -> 0x0d1a }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r2.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeh.zzn(r12)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0d1a }
            long r13 = r2.zzm()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0d1a }
            r10.zzd(r11, r12, r8, r9)     // Catch:{ all -> 0x0d1a }
        L_0x0ba6:
            byte[] r8 = r2.zzbq()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzkp r9 = r5.zzf     // Catch:{ IOException -> 0x0c46 }
            com.google.android.gms.measurement.internal.zzkr r9 = r9.zzi     // Catch:{ IOException -> 0x0c46 }
            zzak(r9)     // Catch:{ IOException -> 0x0c46 }
            byte[] r8 = r9.zzy(r8)     // Catch:{ IOException -> 0x0c46 }
            com.google.android.gms.measurement.internal.zzfr r9 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r8.length     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0d1a }
            r9.zzb(r10, r11)     // Catch:{ all -> 0x0d1a }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0d1a }
            r9.<init>()     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r2.zzy()     // Catch:{ all -> 0x0d1a }
            r9.put(r10, r11)     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r2.zzm()     // Catch:{ all -> 0x0d1a }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0d1a }
            r9.put(r10, r11)     // Catch:{ all -> 0x0d1a }
            java.lang.String r10 = "data"
            r9.put(r10, r8)     // Catch:{ all -> 0x0d1a }
            java.lang.String r8 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x0d1a }
            r9.put(r8, r10)     // Catch:{ all -> 0x0d1a }
            boolean r8 = r2.zzbg()     // Catch:{ all -> 0x0d1a }
            if (r8 == 0) goto L_0x0c05
            java.lang.String r8 = "retry_count"
            int r10 = r2.zze()     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0d1a }
            r9.put(r8, r10)     // Catch:{ all -> 0x0d1a }
        L_0x0c05:
            android.database.sqlite.SQLiteDatabase r8 = r5.zzh()     // Catch:{ SQLiteException -> 0x0c2c }
            java.lang.String r10 = "queue"
            r11 = 0
            long r8 = r8.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0c2c }
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0c5f
            com.google.android.gms.measurement.internal.zzfr r6 = r5.zzs     // Catch:{ SQLiteException -> 0x0c2c }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ SQLiteException -> 0x0c2c }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ SQLiteException -> 0x0c2c }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r2.zzy()     // Catch:{ SQLiteException -> 0x0c2c }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)     // Catch:{ SQLiteException -> 0x0c2c }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0c2c }
            goto L_0x0c5f
        L_0x0c2c:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r2 = r2.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r2)     // Catch:{ all -> 0x0d1a }
            r5.zzc(r7, r2, r6)     // Catch:{ all -> 0x0d1a }
            goto L_0x0c5f
        L_0x0c46:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r2 = r2.zzy()     // Catch:{ all -> 0x0d1a }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r2)     // Catch:{ all -> 0x0d1a }
            r5.zzc(r7, r2, r6)     // Catch:{ all -> 0x0d1a }
        L_0x0c5f:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            java.util.List r3 = r3.zzb     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0d1a }
            r2.zzg()     // Catch:{ all -> 0x0d1a }
            r2.zzW()     // Catch:{ all -> 0x0d1a }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0d1a }
            r6 = 0
        L_0x0c77:
            int r7 = r3.size()     // Catch:{ all -> 0x0d1a }
            if (r6 >= r7) goto L_0x0c94
            if (r6 == 0) goto L_0x0c84
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0d1a }
        L_0x0c84:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0d1a }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0d1a }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0d1a }
            r5.append(r7)     // Catch:{ all -> 0x0d1a }
            int r6 = r6 + 1
            goto L_0x0c77
        L_0x0c94:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0d1a }
            android.database.sqlite.SQLiteDatabase r6 = r2.zzh()     // Catch:{ all -> 0x0d1a }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0d1a }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0d1a }
            int r6 = r3.size()     // Catch:{ all -> 0x0d1a }
            if (r5 == r6) goto L_0x0cc9
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0d1a }
            int r3 = r3.size()     // Catch:{ all -> 0x0d1a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r6, r5, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0cc9:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ all -> 0x0d1a }
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0ce1 }
            r6 = 0
            r5[r6] = r4     // Catch:{ SQLiteException -> 0x0ce1 }
            r6 = 1
            r5[r6] = r4     // Catch:{ SQLiteException -> 0x0ce1 }
            java.lang.String r6 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r3.execSQL(r6, r5)     // Catch:{ SQLiteException -> 0x0ce1 }
            goto L_0x0cf6
        L_0x0ce1:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0d1a }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x0d1a }
            r2.zzc(r5, r4, r3)     // Catch:{ all -> 0x0d1a }
        L_0x0cf6:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            r2.zzC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzak(r2)
            r2.zzx()
            r2 = 1
            return r2
        L_0x0d08:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0d1a }
            zzak(r2)     // Catch:{ all -> 0x0d1a }
            r2.zzC()     // Catch:{ all -> 0x0d1a }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzak(r2)
            r2.zzx()
            r2 = 0
            return r2
        L_0x0d1a:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze
            zzak(r3)
            r3.zzx()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzag(java.lang.String, long):boolean");
    }

    private final boolean zzah() {
        zzaz().zzg();
        zzB();
        zzak zzak = this.zze;
        zzak(zzak);
        if (zzak.zzF()) {
            return true;
        }
        zzak zzak2 = this.zze;
        zzak(zzak2);
        return !TextUtils.isEmpty(zzak2.zzr());
    }

    private final boolean zzai(zzfn zzfn, zzfn zzfn2) {
        Preconditions.checkArgument("_e".equals(zzfn.zzo()));
        zzak(this.zzi);
        zzfs zzB2 = zzkr.zzB((zzfo) zzfn.zzay(), "_sc");
        String str = null;
        String zzh2 = zzB2 == null ? null : zzB2.zzh();
        zzak(this.zzi);
        zzfs zzB3 = zzkr.zzB((zzfo) zzfn2.zzay(), "_pc");
        if (zzB3 != null) {
            str = zzB3.zzh();
        }
        if (str == null || !str.equals(zzh2)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfn.zzo()));
        zzak(this.zzi);
        zzfs zzB4 = zzkr.zzB((zzfo) zzfn.zzay(), "_et");
        if (zzB4 == null || !zzB4.zzw() || zzB4.zzd() <= 0) {
            return true;
        }
        long zzd2 = zzB4.zzd();
        zzak(this.zzi);
        zzfs zzB5 = zzkr.zzB((zzfo) zzfn2.zzay(), "_et");
        if (zzB5 != null && zzB5.zzd() > 0) {
            zzd2 += zzB5.zzd();
        }
        zzak(this.zzi);
        zzkr.zzz(zzfn2, "_et", Long.valueOf(zzd2));
        zzak(this.zzi);
        zzkr.zzz(zzfn, "_fr", 1L);
        return true;
    }

    private static final boolean zzaj(zzp zzp2) {
        return !TextUtils.isEmpty(zzp2.zzb) || !TextUtils.isEmpty(zzp2.zzq);
    }

    private static final zzkf zzak(zzkf zzkf) {
        if (zzkf == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzkf.zzY()) {
            return zzkf;
        } else {
            String valueOf = String.valueOf(zzkf.getClass());
            String.valueOf(valueOf).length();
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(valueOf)));
        }
    }

    public static zzkp zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzkp.class) {
                if (zzb == null) {
                    zzb = new zzkp((zzkq) Preconditions.checkNotNull(new zzkq(context)), (zzfr) null);
                }
            }
        }
        return zzb;
    }

    static /* bridge */ /* synthetic */ void zzy(zzkp zzkp, zzkq zzkq) {
        zzkp.zzaz().zzg();
        zzkp.zzm = new zzez(zzkp);
        zzak zzak = new zzak(zzkp);
        zzak.zzX();
        zzkp.zze = zzak;
        zzkp.zzg().zzq((zzae) Preconditions.checkNotNull(zzkp.zzc));
        zzjm zzjm = new zzjm(zzkp);
        zzjm.zzX();
        zzkp.zzk = zzjm;
        zzz zzz2 = new zzz(zzkp);
        zzz2.zzX();
        zzkp.zzh = zzz2;
        zzib zzib = new zzib(zzkp);
        zzib.zzX();
        zzkp.zzj = zzib;
        zzkd zzkd = new zzkd(zzkp);
        zzkd.zzX();
        zzkp.zzg = zzkd;
        zzkp.zzf = new zzep(zzkp);
        if (zzkp.zzr != zzkp.zzs) {
            zzkp.zzay().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzkp.zzr), Integer.valueOf(zzkp.zzs));
        }
        zzkp.zzo = true;
    }

    /* access modifiers changed from: package-private */
    public final void zzA() {
        zzaz().zzg();
        zzB();
        if (!this.zzp) {
            this.zzp = true;
            if (zzY()) {
                FileChannel fileChannel = this.zzx;
                zzaz().zzg();
                int i = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    zzay().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i = allocate.getInt();
                        } else if (read != -1) {
                            zzay().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e) {
                        zzay().zzd().zzb("Failed to read from channel", e);
                    }
                }
                int zzi2 = this.zzn.zzh().zzi();
                zzaz().zzg();
                if (i > zzi2) {
                    zzay().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                } else if (i < zzi2) {
                    FileChannel fileChannel2 = this.zzx;
                    zzaz().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        zzay().zzd().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzi2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            if (zzg().zzs((String) null, zzdu.zzaf) && Build.VERSION.SDK_INT <= 19) {
                                fileChannel2.position(0);
                            }
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzay().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzay().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                            return;
                        } catch (IOException e2) {
                            zzay().zzd().zzb("Failed to write to channel", e2);
                        }
                    }
                    zzay().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzi2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzC(zzg zzg2) {
        String str;
        zzaz().zzg();
        if (!TextUtils.isEmpty(zzg2.zzy()) || !TextUtils.isEmpty(zzg2.zzr())) {
            zzkg zzkg = this.zzl;
            Uri.Builder builder = new Uri.Builder();
            String zzy2 = zzg2.zzy();
            if (TextUtils.isEmpty(zzy2)) {
                zzy2 = zzg2.zzr();
            }
            ArrayMap arrayMap = null;
            Uri.Builder encodedAuthority = builder.scheme((String) zzdu.zzd.zza((Object) null)).encodedAuthority((String) zzdu.zze.zza((Object) null));
            String valueOf = String.valueOf(zzy2);
            if (valueOf.length() != 0) {
                str = "config/app/".concat(valueOf);
            } else {
                str = new String("config/app/");
            }
            Uri.Builder appendQueryParameter = encodedAuthority.path(str).appendQueryParameter("app_instance_id", zzg2.zzu()).appendQueryParameter("platform", "android");
            zzkg.zzs.zzf().zzh();
            appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(55005)).appendQueryParameter("runtime_version", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE);
            String uri = builder.build().toString();
            try {
                String str2 = (String) Preconditions.checkNotNull(zzg2.zzt());
                URL url = new URL(uri);
                zzay().zzj().zzb("Fetching remote configuration", str2);
                zzfi zzfi = this.zzc;
                zzak(zzfi);
                zzfc zze2 = zzfi.zze(str2);
                zzfi zzfi2 = this.zzc;
                zzak(zzfi2);
                String zzf2 = zzfi2.zzf(str2);
                if (zze2 != null && !TextUtils.isEmpty(zzf2)) {
                    arrayMap = new ArrayMap();
                    arrayMap.put("If-Modified-Since", zzf2);
                }
                this.zzt = true;
                zzen zzen = this.zzd;
                zzak(zzen);
                zzkj zzkj = new zzkj(this);
                zzen.zzg();
                zzen.zzW();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzkj);
                zzen.zzs.zzaz().zzo(new zzem(zzen, str2, url, (byte[]) null, arrayMap, zzkj));
            } catch (MalformedURLException unused) {
                zzay().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzeh.zzn(zzg2.zzt()), uri);
            }
        } else {
            zzH((String) Preconditions.checkNotNull(zzg2.zzt()), 204, (Throwable) null, (byte[]) null, (Map) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzD(zzau zzau, zzp zzp2) {
        zzau zzau2;
        List<zzab> list;
        List<zzab> list2;
        List<zzab> list3;
        String str;
        zzp zzp3 = zzp2;
        Preconditions.checkNotNull(zzp2);
        Preconditions.checkNotEmpty(zzp3.zza);
        zzaz().zzg();
        zzB();
        String str2 = zzp3.zza;
        zzau zzau3 = zzau;
        long j = zzau3.zzd;
        zzpb.zzc();
        zzid zzid = null;
        if (zzg().zzs((String) null, zzdu.zzat)) {
            zzei zzb2 = zzei.zzb(zzau);
            zzaz().zzg();
            if (!(this.zzC == null || (str = this.zzD) == null || !str.equals(str2))) {
                zzid = this.zzC;
            }
            zzkw.zzJ(zzid, zzb2.zzd, false);
            zzau3 = zzb2.zza();
        }
        zzak(this.zzi);
        if (zzkr.zzA(zzau3, zzp3)) {
            if (!zzp3.zzh) {
                zzd(zzp3);
                return;
            }
            List list4 = zzp3.zzt;
            if (list4 == null) {
                zzau2 = zzau3;
            } else if (list4.contains(zzau3.zza)) {
                Bundle zzc2 = zzau3.zzb.zzc();
                zzc2.putLong("ga_safelisted", 1);
                zzau2 = new zzau(zzau3.zza, new zzas(zzc2), zzau3.zzc, zzau3.zzd);
            } else {
                zzay().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zzau3.zza, zzau3.zzc);
                return;
            }
            zzak zzak = this.zze;
            zzak(zzak);
            zzak.zzw();
            try {
                zzak zzak2 = this.zze;
                zzak(zzak2);
                Preconditions.checkNotEmpty(str2);
                zzak2.zzg();
                zzak2.zzW();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zzak2.zzs.zzay().zzk().zzc("Invalid time querying timed out conditional properties", zzeh.zzn(str2), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzak2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzab zzab : list) {
                    if (zzab != null) {
                        zzay().zzj().zzd("User property timed out", zzab.zza, this.zzn.zzj().zzf(zzab.zzc.zzb), zzab.zzc.zza());
                        zzau zzau4 = zzab.zzg;
                        if (zzau4 != null) {
                            zzX(new zzau(zzau4, j), zzp3);
                        }
                        zzak zzak3 = this.zze;
                        zzak(zzak3);
                        zzak3.zza(str2, zzab.zzc.zzb);
                    }
                }
                zzak zzak4 = this.zze;
                zzak(zzak4);
                Preconditions.checkNotEmpty(str2);
                zzak4.zzg();
                zzak4.zzW();
                if (i < 0) {
                    zzak4.zzs.zzay().zzk().zzc("Invalid time querying expired conditional properties", zzeh.zzn(str2), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzak4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList<zzau> arrayList = new ArrayList<>(list2.size());
                for (zzab zzab2 : list2) {
                    if (zzab2 != null) {
                        zzay().zzj().zzd("User property expired", zzab2.zza, this.zzn.zzj().zzf(zzab2.zzc.zzb), zzab2.zzc.zza());
                        zzak zzak5 = this.zze;
                        zzak(zzak5);
                        zzak5.zzA(str2, zzab2.zzc.zzb);
                        zzau zzau5 = zzab2.zzk;
                        if (zzau5 != null) {
                            arrayList.add(zzau5);
                        }
                        zzak zzak6 = this.zze;
                        zzak(zzak6);
                        zzak6.zza(str2, zzab2.zzc.zzb);
                    }
                }
                for (zzau zzau6 : arrayList) {
                    zzX(new zzau(zzau6, j), zzp3);
                }
                zzak zzak7 = this.zze;
                zzak(zzak7);
                String str3 = zzau2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzak7.zzg();
                zzak7.zzW();
                if (i < 0) {
                    zzak7.zzs.zzay().zzk().zzd("Invalid time querying triggered conditional properties", zzeh.zzn(str2), zzak7.zzs.zzj().zzd(str3), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzak7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j)});
                }
                ArrayList<zzau> arrayList2 = new ArrayList<>(list3.size());
                for (zzab zzab3 : list3) {
                    if (zzab3 != null) {
                        zzks zzks = zzab3.zzc;
                        zzku zzku = new zzku((String) Preconditions.checkNotNull(zzab3.zza), zzab3.zzb, zzks.zzb, j, Preconditions.checkNotNull(zzks.zza()));
                        zzak zzak8 = this.zze;
                        zzak(zzak8);
                        if (zzak8.zzL(zzku)) {
                            zzay().zzj().zzd("User property triggered", zzab3.zza, this.zzn.zzj().zzf(zzku.zzc), zzku.zze);
                        } else {
                            zzay().zzd().zzd("Too many active user properties, ignoring", zzeh.zzn(zzab3.zza), this.zzn.zzj().zzf(zzku.zzc), zzku.zze);
                        }
                        zzau zzau7 = zzab3.zzi;
                        if (zzau7 != null) {
                            arrayList2.add(zzau7);
                        }
                        zzab3.zzc = new zzks(zzku);
                        zzab3.zze = true;
                        zzak zzak9 = this.zze;
                        zzak(zzak9);
                        zzak9.zzK(zzab3);
                    }
                }
                zzX(zzau2, zzp3);
                for (zzau zzau8 : arrayList2) {
                    zzX(new zzau(zzau8, j), zzp3);
                }
                zzak zzak10 = this.zze;
                zzak(zzak10);
                zzak10.zzC();
            } finally {
                zzak zzak11 = this.zze;
                zzak(zzak11);
                zzak11.zzx();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzE(zzau zzau, String str) {
        zzau zzau2 = zzau;
        String str2 = str;
        zzak zzak = this.zze;
        zzak(zzak);
        zzg zzj2 = zzak.zzj(str2);
        if (zzj2 == null || TextUtils.isEmpty(zzj2.zzw())) {
            zzay().zzc().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzac = zzac(zzj2);
        if (zzac == null) {
            if (!"_ui".equals(zzau2.zza)) {
                zzay().zzk().zzb("Could not find package. appId", zzeh.zzn(str));
            }
        } else if (!zzac.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping event. appId", zzeh.zzn(str));
            return;
        }
        zzp zzp2 = r2;
        zzg zzg2 = zzj2;
        zzp zzp3 = new zzp(str, zzj2.zzy(), zzj2.zzw(), zzj2.zzb(), zzj2.zzv(), zzj2.zzm(), zzj2.zzj(), (String) null, zzj2.zzah(), false, zzg2.zzx(), zzg2.zza(), 0, 0, zzg2.zzag(), false, zzg2.zzr(), zzg2.zzq(), zzg2.zzk(), zzg2.zzB(), (String) null, zzh(str2).zzh());
        zzF(zzau2, zzp2);
    }

    /* access modifiers changed from: package-private */
    public final void zzF(zzau zzau, zzp zzp2) {
        Preconditions.checkNotEmpty(zzp2.zza);
        zzei zzb2 = zzei.zzb(zzau);
        zzkw zzv2 = zzv();
        Bundle bundle = zzb2.zzd;
        zzak zzak = this.zze;
        zzak(zzak);
        zzv2.zzK(bundle, zzak.zzi(zzp2.zza));
        zzv().zzL(zzb2, zzg().zzd(zzp2.zza));
        zzau zza2 = zzb2.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zza2.zza) && "referrer API v2".equals(zza2.zzb.zzg("_cis"))) {
            String zzg2 = zza2.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(zzg2)) {
                zzV(new zzks("_lgclid", zza2.zzd, zzg2, "auto"), zzp2);
            }
        }
        zzD(zza2, zzp2);
    }

    /* access modifiers changed from: package-private */
    public final void zzG() {
        this.zzs++;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0126 A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0134 A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0156 A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015a A[Catch:{ all -> 0x016b, all -> 0x0175 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzH(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.zzfo r0 = r6.zzaz()
            r0.zzg()
            r6.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x0012
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0175 }
        L_0x0012:
            com.google.android.gms.measurement.internal.zzeh r1 = r6.zzay()     // Catch:{ all -> 0x0175 }
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()     // Catch:{ all -> 0x0175 }
            int r2 = r10.length     // Catch:{ all -> 0x0175 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = "onConfigFetched. Response size"
            r1.zzb(r3, r2)     // Catch:{ all -> 0x0175 }
            com.google.android.gms.measurement.internal.zzak r1 = r6.zze     // Catch:{ all -> 0x0175 }
            zzak(r1)     // Catch:{ all -> 0x0175 }
            r1.zzw()     // Catch:{ all -> 0x0175 }
            com.google.android.gms.measurement.internal.zzak r1 = r6.zze     // Catch:{ all -> 0x016b }
            zzak(r1)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzj(r7)     // Catch:{ all -> 0x016b }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r8 == r3) goto L_0x0042
            r3 = 204(0xcc, float:2.86E-43)
            if (r8 == r3) goto L_0x0042
            if (r8 != r4) goto L_0x0046
            r8 = r4
        L_0x0042:
            if (r9 != 0) goto L_0x0046
            r3 = 1
            goto L_0x0047
        L_0x0046:
            r3 = r0
        L_0x0047:
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzeh r8 = r6.zzay()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzk()     // Catch:{ all -> 0x016b }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x016b }
            r8.zzb(r9, r7)     // Catch:{ all -> 0x016b }
            goto L_0x015d
        L_0x005c:
            r5 = 404(0x194, float:5.66E-43)
            if (r3 != 0) goto L_0x00ba
            if (r8 != r5) goto L_0x0063
            goto L_0x00ba
        L_0x0063:
            com.google.android.gms.common.util.Clock r10 = r6.zzav()     // Catch:{ all -> 0x016b }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x016b }
            r1.zzU(r10)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzak r10 = r6.zze     // Catch:{ all -> 0x016b }
            zzak(r10)     // Catch:{ all -> 0x016b }
            r10.zzD(r1)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzeh r10 = r6.zzay()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzj()     // Catch:{ all -> 0x016b }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x016b }
            r10.zzc(r11, r1, r9)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzfi r9 = r6.zzc     // Catch:{ all -> 0x016b }
            zzak(r9)     // Catch:{ all -> 0x016b }
            r9.zzi(r7)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzjm r7 = r6.zzk     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzd     // Catch:{ all -> 0x016b }
            com.google.android.gms.common.util.Clock r9 = r6.zzav()     // Catch:{ all -> 0x016b }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x016b }
            r7.zzb(r9)     // Catch:{ all -> 0x016b }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00a6
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00b5
        L_0x00a6:
            com.google.android.gms.measurement.internal.zzjm r7 = r6.zzk     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzb     // Catch:{ all -> 0x016b }
            com.google.android.gms.common.util.Clock r8 = r6.zzav()     // Catch:{ all -> 0x016b }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x016b }
            r7.zzb(r8)     // Catch:{ all -> 0x016b }
        L_0x00b5:
            r6.zzaf()     // Catch:{ all -> 0x016b }
            goto L_0x015d
        L_0x00ba:
            r9 = 0
            if (r11 == 0) goto L_0x00c6
            java.lang.String r3 = "Last-Modified"
            java.lang.Object r11 = r11.get(r3)     // Catch:{ all -> 0x016b }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x016b }
            goto L_0x00c7
        L_0x00c6:
            r11 = r9
        L_0x00c7:
            if (r11 == 0) goto L_0x00d6
            int r3 = r11.size()     // Catch:{ all -> 0x016b }
            if (r3 <= 0) goto L_0x00d6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x016b }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x016b }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r8 == r5) goto L_0x00f5
            if (r8 != r4) goto L_0x00dc
            goto L_0x00f5
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzfi r9 = r6.zzc     // Catch:{ all -> 0x016b }
            zzak(r9)     // Catch:{ all -> 0x016b }
            boolean r9 = r9.zzq(r7, r10, r11)     // Catch:{ all -> 0x016b }
            if (r9 != 0) goto L_0x0111
            com.google.android.gms.measurement.internal.zzak r7 = r6.zze     // Catch:{ all -> 0x0175 }
            zzak(r7)     // Catch:{ all -> 0x0175 }
        L_0x00ec:
            r7.zzx()     // Catch:{ all -> 0x0175 }
            r6.zzt = r0
            r6.zzad()
            return
        L_0x00f5:
            com.google.android.gms.measurement.internal.zzfi r10 = r6.zzc     // Catch:{ all -> 0x016b }
            zzak(r10)     // Catch:{ all -> 0x016b }
            com.google.android.gms.internal.measurement.zzfc r10 = r10.zze(r7)     // Catch:{ all -> 0x016b }
            if (r10 != 0) goto L_0x0111
            com.google.android.gms.measurement.internal.zzfi r10 = r6.zzc     // Catch:{ all -> 0x016b }
            zzak(r10)     // Catch:{ all -> 0x016b }
            boolean r9 = r10.zzq(r7, r9, r9)     // Catch:{ all -> 0x016b }
            if (r9 != 0) goto L_0x0111
            com.google.android.gms.measurement.internal.zzak r7 = r6.zze     // Catch:{ all -> 0x0175 }
            zzak(r7)     // Catch:{ all -> 0x0175 }
            goto L_0x00ec
        L_0x0111:
            com.google.android.gms.common.util.Clock r9 = r6.zzav()     // Catch:{ all -> 0x016b }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x016b }
            r1.zzL(r9)     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzak r9 = r6.zze     // Catch:{ all -> 0x016b }
            zzak(r9)     // Catch:{ all -> 0x016b }
            r9.zzD(r1)     // Catch:{ all -> 0x016b }
            if (r8 != r5) goto L_0x0134
            com.google.android.gms.measurement.internal.zzeh r8 = r6.zzay()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzl()     // Catch:{ all -> 0x016b }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zzb(r9, r7)     // Catch:{ all -> 0x016b }
            goto L_0x0145
        L_0x0134:
            com.google.android.gms.measurement.internal.zzeh r7 = r6.zzay()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzj()     // Catch:{ all -> 0x016b }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x016b }
            r7.zzc(r9, r8, r2)     // Catch:{ all -> 0x016b }
        L_0x0145:
            com.google.android.gms.measurement.internal.zzen r7 = r6.zzd     // Catch:{ all -> 0x016b }
            zzak(r7)     // Catch:{ all -> 0x016b }
            boolean r7 = r7.zza()     // Catch:{ all -> 0x016b }
            if (r7 == 0) goto L_0x015a
            boolean r7 = r6.zzah()     // Catch:{ all -> 0x016b }
            if (r7 == 0) goto L_0x015a
            r6.zzW()     // Catch:{ all -> 0x016b }
            goto L_0x015d
        L_0x015a:
            r6.zzaf()     // Catch:{ all -> 0x016b }
        L_0x015d:
            com.google.android.gms.measurement.internal.zzak r7 = r6.zze     // Catch:{ all -> 0x016b }
            zzak(r7)     // Catch:{ all -> 0x016b }
            r7.zzC()     // Catch:{ all -> 0x016b }
            com.google.android.gms.measurement.internal.zzak r7 = r6.zze     // Catch:{ all -> 0x0175 }
            zzak(r7)     // Catch:{ all -> 0x0175 }
            goto L_0x00ec
        L_0x016b:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzak r8 = r6.zze     // Catch:{ all -> 0x0175 }
            zzak(r8)     // Catch:{ all -> 0x0175 }
            r8.zzx()     // Catch:{ all -> 0x0175 }
            throw r7     // Catch:{ all -> 0x0175 }
        L_0x0175:
            r7 = move-exception
            r6.zzt = r0
            r6.zzad()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzH(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzI(boolean z) {
        zzaf();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zzJ(int i, Throwable th, byte[] bArr, String str) {
        zzak zzak;
        zzaz().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzad();
                throw th2;
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i != 200) {
            if (i == 204) {
                i = 204;
            }
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i == 503 || i == 429) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            }
            zzak zzak2 = this.zze;
            zzak(zzak2);
            zzak2.zzy(list);
            zzaf();
            this.zzu = false;
            zzad();
        }
        if (th == null) {
            try {
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
                this.zzk.zzd.zzb(0);
                zzaf();
                zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzak zzak3 = this.zze;
                zzak(zzak3);
                zzak3.zzw();
                try {
                    for (Long l : list) {
                        try {
                            zzak = this.zze;
                            zzak(zzak);
                            long longValue = l.longValue();
                            zzak.zzg();
                            zzak.zzW();
                            if (zzak.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzak.zzs.zzay().zzd().zzb("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            List list2 = this.zzz;
                            if (list2 == null || !list2.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzak zzak4 = this.zze;
                    zzak(zzak4);
                    zzak4.zzC();
                    zzak zzak5 = this.zze;
                    zzak(zzak5);
                    zzak5.zzx();
                    this.zzz = null;
                    zzen zzen = this.zzd;
                    zzak(zzen);
                    if (!zzen.zza() || !zzah()) {
                        this.zzA = -1;
                        zzaf();
                    } else {
                        zzW();
                    }
                    this.zza = 0;
                } catch (Throwable th3) {
                    zzak zzak6 = this.zze;
                    zzak(zzak6);
                    zzak6.zzx();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                zzay().zzd().zzb("Database error while trying to delete uploaded bundles", e3);
                this.zza = zzav().elapsedRealtime();
                zzay().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            }
            this.zzu = false;
            zzad();
        }
        zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
        this.zzk.zzd.zzb(zzav().currentTimeMillis());
        this.zzk.zzb.zzb(zzav().currentTimeMillis());
        zzak zzak22 = this.zze;
        zzak(zzak22);
        zzak22.zzy(list);
        zzaf();
        this.zzu = false;
        zzad();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03ce A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x03fa A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0411 A[SYNTHETIC, Splitter:B:128:0x0411] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x04d9 A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x053d A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01b9 A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01e4 A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x021a A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0239 A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x023f A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x024e A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x025e A[Catch:{ SQLiteException -> 0x01cd, all -> 0x056b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzK(com.google.android.gms.measurement.internal.zzp r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "com.android.vending"
            java.lang.String r6 = "_pfo"
            java.lang.String r7 = "_uwa"
            java.lang.String r0 = "app_id=?"
            com.google.android.gms.measurement.internal.zzfo r8 = r23.zzaz()
            r8.zzg()
            r23.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r24)
            java.lang.String r8 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            boolean r8 = zzaj(r24)
            if (r8 == 0) goto L_0x0575
            com.google.android.gms.measurement.internal.zzak r8 = r1.zze
            zzak(r8)
            java.lang.String r9 = r2.zza
            com.google.android.gms.measurement.internal.zzg r8 = r8.zzj(r9)
            r9 = 0
            if (r8 == 0) goto L_0x005e
            java.lang.String r11 = r8.zzy()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x005e
            java.lang.String r11 = r2.zzb
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x005e
            r8.zzL(r9)
            com.google.android.gms.measurement.internal.zzak r11 = r1.zze
            zzak(r11)
            r11.zzD(r8)
            com.google.android.gms.measurement.internal.zzfi r8 = r1.zzc
            zzak(r8)
            java.lang.String r11 = r2.zza
            r8.zzj(r11)
        L_0x005e:
            boolean r8 = r2.zzh
            if (r8 != 0) goto L_0x0066
            r23.zzd(r24)
            return
        L_0x0066:
            long r11 = r2.zzm
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0074
            com.google.android.gms.common.util.Clock r8 = r23.zzav()
            long r11 = r8.currentTimeMillis()
        L_0x0074:
            com.google.android.gms.measurement.internal.zzfr r8 = r1.zzn
            com.google.android.gms.measurement.internal.zzao r8 = r8.zzg()
            r8.zzd()
            int r8 = r2.zzn
            r15 = 1
            if (r8 == 0) goto L_0x009c
            if (r8 == r15) goto L_0x009c
            com.google.android.gms.measurement.internal.zzeh r13 = r23.zzay()
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzk()
            java.lang.String r14 = r2.zza
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeh.zzn(r14)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Incorrect app type, assuming installed app. appId, appType"
            r13.zzc(r9, r14, r8)
            r8 = 0
        L_0x009c:
            com.google.android.gms.measurement.internal.zzak r9 = r1.zze
            zzak(r9)
            r9.zzw()
            com.google.android.gms.measurement.internal.zzak r9 = r1.zze     // Catch:{ all -> 0x056b }
            zzak(r9)     // Catch:{ all -> 0x056b }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x056b }
            java.lang.String r13 = "_npa"
            com.google.android.gms.measurement.internal.zzku r9 = r9.zzp(r10, r13)     // Catch:{ all -> 0x056b }
            if (r9 == 0) goto L_0x00c5
            java.lang.String r10 = "auto"
            java.lang.String r13 = r9.zzb     // Catch:{ all -> 0x056b }
            boolean r10 = r10.equals(r13)     // Catch:{ all -> 0x056b }
            if (r10 == 0) goto L_0x00be
            goto L_0x00c5
        L_0x00be:
            r21 = r3
            r22 = r4
            r4 = r15
            r3 = 0
            goto L_0x0119
        L_0x00c5:
            java.lang.Boolean r10 = r2.zzr     // Catch:{ all -> 0x056b }
            if (r10 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzks r10 = new com.google.android.gms.measurement.internal.zzks     // Catch:{ all -> 0x056b }
            java.lang.String r14 = "_npa"
            java.lang.Boolean r13 = r2.zzr     // Catch:{ all -> 0x056b }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x056b }
            if (r15 == r13) goto L_0x00d8
            r19 = 0
            goto L_0x00da
        L_0x00d8:
            r19 = 1
        L_0x00da:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x056b }
            java.lang.String r20 = "auto"
            r21 = r3
            r22 = r4
            r3 = 1
            r13 = r10
            r3 = 0
            r4 = r15
            r15 = r11
            r17 = r19
            r18 = r20
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x056b }
            if (r9 == 0) goto L_0x00fd
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x056b }
            java.lang.Long r13 = r10.zzd     // Catch:{ all -> 0x056b }
            boolean r9 = r9.equals(r13)     // Catch:{ all -> 0x056b }
            if (r9 != 0) goto L_0x0119
        L_0x00fd:
            r1.zzV(r10, r2)     // Catch:{ all -> 0x056b }
            goto L_0x0119
        L_0x0101:
            r21 = r3
            r22 = r4
            r4 = r15
            r3 = 0
            if (r9 == 0) goto L_0x0119
            com.google.android.gms.measurement.internal.zzks r9 = new com.google.android.gms.measurement.internal.zzks     // Catch:{ all -> 0x056b }
            java.lang.String r14 = "_npa"
            r17 = 0
            java.lang.String r18 = "auto"
            r13 = r9
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x056b }
            r1.zzO(r9, r2)     // Catch:{ all -> 0x056b }
        L_0x0119:
            com.google.android.gms.measurement.internal.zzak r9 = r1.zze     // Catch:{ all -> 0x056b }
            zzak(r9)     // Catch:{ all -> 0x056b }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x056b }
            java.lang.Object r10 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x056b }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzg r9 = r9.zzj(r10)     // Catch:{ all -> 0x056b }
            if (r9 == 0) goto L_0x01e2
            com.google.android.gms.measurement.internal.zzkw r13 = r23.zzv()     // Catch:{ all -> 0x056b }
            java.lang.String r14 = r2.zzb     // Catch:{ all -> 0x056b }
            java.lang.String r15 = r9.zzy()     // Catch:{ all -> 0x056b }
            java.lang.String r10 = r2.zzq     // Catch:{ all -> 0x056b }
            java.lang.String r3 = r9.zzr()     // Catch:{ all -> 0x056b }
            boolean r3 = r13.zzam(r14, r15, r10, r3)     // Catch:{ all -> 0x056b }
            if (r3 == 0) goto L_0x01e2
            com.google.android.gms.measurement.internal.zzeh r3 = r23.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()     // Catch:{ all -> 0x056b }
            java.lang.String r10 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r9.zzt()     // Catch:{ all -> 0x056b }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r13)     // Catch:{ all -> 0x056b }
            r3.zzb(r10, r13)     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ all -> 0x056b }
            zzak(r3)     // Catch:{ all -> 0x056b }
            java.lang.String r9 = r9.zzt()     // Catch:{ all -> 0x056b }
            r3.zzW()     // Catch:{ all -> 0x056b }
            r3.zzg()     // Catch:{ all -> 0x056b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ all -> 0x056b }
            android.database.sqlite.SQLiteDatabase r10 = r3.zzh()     // Catch:{ SQLiteException -> 0x01cd }
            java.lang.String[] r13 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x01cd }
            r14 = 0
            r13[r14] = r9     // Catch:{ SQLiteException -> 0x01cd }
            java.lang.String r14 = "events"
            int r14 = r10.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01cd }
            java.lang.String r15 = "user_attributes"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cd }
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cd }
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cd }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cd }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cd }
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cd }
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cd }
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cd }
            int r14 = r14 + r15
            java.lang.String r15 = "consent_settings"
            int r0 = r10.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01cd }
            int r14 = r14 + r0
            if (r14 <= 0) goto L_0x01e1
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzs     // Catch:{ SQLiteException -> 0x01cd }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x01cd }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x01cd }
            java.lang.String r10 = "Deleted application data. app, records"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01cd }
            r0.zzc(r10, r9, r13)     // Catch:{ SQLiteException -> 0x01cd }
            goto L_0x01e1
        L_0x01cd:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzs     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x056b }
            java.lang.String r10 = "Error deleting application data. appId, error"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x056b }
            r3.zzc(r10, r9, r0)     // Catch:{ all -> 0x056b }
        L_0x01e1:
            r9 = 0
        L_0x01e2:
            if (r9 == 0) goto L_0x0239
            long r13 = r9.zzb()     // Catch:{ all -> 0x056b }
            r15 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r0 == 0) goto L_0x01fc
            long r13 = r9.zzb()     // Catch:{ all -> 0x056b }
            r3 = r5
            long r4 = r2.zzj     // Catch:{ all -> 0x056b }
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01fd
            r0 = 1
            goto L_0x01fe
        L_0x01fc:
            r3 = r5
        L_0x01fd:
            r0 = 0
        L_0x01fe:
            java.lang.String r4 = r9.zzw()     // Catch:{ all -> 0x056b }
            long r13 = r9.zzb()     // Catch:{ all -> 0x056b }
            int r5 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r5 != 0) goto L_0x0216
            if (r4 == 0) goto L_0x0216
            java.lang.String r5 = r2.zzc     // Catch:{ all -> 0x056b }
            boolean r5 = r4.equals(r5)     // Catch:{ all -> 0x056b }
            if (r5 != 0) goto L_0x0216
            r15 = 1
            goto L_0x0217
        L_0x0216:
            r15 = 0
        L_0x0217:
            r0 = r0 | r15
            if (r0 == 0) goto L_0x023a
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x056b }
            r0.<init>()     // Catch:{ all -> 0x056b }
            java.lang.String r5 = "_pv"
            r0.putString(r5, r4)     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzau r4 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzas r15 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x056b }
            r15.<init>(r0)     // Catch:{ all -> 0x056b }
            java.lang.String r14 = "_au"
            java.lang.String r16 = "auto"
            r13 = r4
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x056b }
            r1.zzD(r4, r2)     // Catch:{ all -> 0x056b }
            goto L_0x023a
        L_0x0239:
            r3 = r5
        L_0x023a:
            r23.zzd(r24)     // Catch:{ all -> 0x056b }
            if (r8 != 0) goto L_0x024e
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x056b }
            zzak(r0)     // Catch:{ all -> 0x056b }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x056b }
            java.lang.String r5 = "_f"
            com.google.android.gms.measurement.internal.zzaq r0 = r0.zzn(r4, r5)     // Catch:{ all -> 0x056b }
            r15 = 0
            goto L_0x025c
        L_0x024e:
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x056b }
            zzak(r0)     // Catch:{ all -> 0x056b }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x056b }
            java.lang.String r5 = "_v"
            com.google.android.gms.measurement.internal.zzaq r0 = r0.zzn(r4, r5)     // Catch:{ all -> 0x056b }
            r15 = 1
        L_0x025c:
            if (r0 != 0) goto L_0x053d
            r4 = 3600000(0x36ee80, double:1.7786363E-317)
            long r8 = r11 / r4
            r13 = 1
            long r8 = r8 + r13
            long r8 = r8 * r4
            java.lang.String r4 = "_dac"
            java.lang.String r5 = "_et"
            java.lang.String r14 = "_r"
            java.lang.String r13 = "_c"
            if (r15 != 0) goto L_0x04f3
            com.google.android.gms.measurement.internal.zzks r0 = new com.google.android.gms.measurement.internal.zzks     // Catch:{ all -> 0x056b }
            java.lang.String r15 = "_fot"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x056b }
            java.lang.String r18 = "auto"
            r8 = r13
            r13 = r0
            r9 = r14
            r14 = r15
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x056b }
            r1.zzV(r0, r2)     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzfo r0 = r23.zzaz()     // Catch:{ all -> 0x056b }
            r0.zzg()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzez r0 = r1.zzm     // Catch:{ all -> 0x056b }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x056b }
            r13 = r0
            com.google.android.gms.measurement.internal.zzez r13 = (com.google.android.gms.measurement.internal.zzez) r13     // Catch:{ all -> 0x056b }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x056b }
            if (r0 == 0) goto L_0x038d
            boolean r14 = r0.isEmpty()     // Catch:{ all -> 0x056b }
            if (r14 == 0) goto L_0x02a2
            goto L_0x038d
        L_0x02a2:
            com.google.android.gms.measurement.internal.zzfr r14 = r13.zza     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzfo r14 = r14.zzaz()     // Catch:{ all -> 0x056b }
            r14.zzg()     // Catch:{ all -> 0x056b }
            boolean r14 = r13.zza()     // Catch:{ all -> 0x056b }
            if (r14 != 0) goto L_0x02c2
            com.google.android.gms.measurement.internal.zzfr r0 = r13.zza     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzi()     // Catch:{ all -> 0x056b }
            java.lang.String r3 = "Install Referrer Reporter is not available"
            r0.zza(r3)     // Catch:{ all -> 0x056b }
            goto L_0x039c
        L_0x02c2:
            com.google.android.gms.measurement.internal.zzey r14 = new com.google.android.gms.measurement.internal.zzey     // Catch:{ all -> 0x056b }
            r14.<init>(r13, r0)     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzfr r0 = r13.zza     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzaz()     // Catch:{ all -> 0x056b }
            r0.zzg()     // Catch:{ all -> 0x056b }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x056b }
            java.lang.String r15 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r15)     // Catch:{ all -> 0x056b }
            android.content.ComponentName r15 = new android.content.ComponentName     // Catch:{ all -> 0x056b }
            java.lang.String r10 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r15.<init>(r3, r10)     // Catch:{ all -> 0x056b }
            r0.setComponent(r15)     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzfr r10 = r13.zza     // Catch:{ all -> 0x056b }
            android.content.Context r10 = r10.zzau()     // Catch:{ all -> 0x056b }
            android.content.pm.PackageManager r10 = r10.getPackageManager()     // Catch:{ all -> 0x056b }
            if (r10 != 0) goto L_0x02fe
            com.google.android.gms.measurement.internal.zzfr r0 = r13.zza     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzm()     // Catch:{ all -> 0x056b }
            java.lang.String r3 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r3)     // Catch:{ all -> 0x056b }
            goto L_0x039c
        L_0x02fe:
            r15 = 0
            java.util.List r10 = r10.queryIntentServices(r0, r15)     // Catch:{ all -> 0x056b }
            if (r10 == 0) goto L_0x037d
            boolean r17 = r10.isEmpty()     // Catch:{ all -> 0x056b }
            if (r17 != 0) goto L_0x037d
            java.lang.Object r10 = r10.get(r15)     // Catch:{ all -> 0x056b }
            android.content.pm.ResolveInfo r10 = (android.content.pm.ResolveInfo) r10     // Catch:{ all -> 0x056b }
            android.content.pm.ServiceInfo r15 = r10.serviceInfo     // Catch:{ all -> 0x056b }
            if (r15 == 0) goto L_0x039c
            android.content.pm.ServiceInfo r15 = r10.serviceInfo     // Catch:{ all -> 0x056b }
            java.lang.String r15 = r15.packageName     // Catch:{ all -> 0x056b }
            android.content.pm.ServiceInfo r10 = r10.serviceInfo     // Catch:{ all -> 0x056b }
            java.lang.String r10 = r10.name     // Catch:{ all -> 0x056b }
            if (r10 == 0) goto L_0x036d
            boolean r3 = r3.equals(r15)     // Catch:{ all -> 0x056b }
            if (r3 == 0) goto L_0x036d
            boolean r3 = r13.zza()     // Catch:{ all -> 0x056b }
            if (r3 == 0) goto L_0x036d
            android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x056b }
            r3.<init>(r0)     // Catch:{ all -> 0x056b }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x0358 }
            com.google.android.gms.measurement.internal.zzfr r10 = r13.zza     // Catch:{ RuntimeException -> 0x0358 }
            android.content.Context r10 = r10.zzau()     // Catch:{ RuntimeException -> 0x0358 }
            r15 = 1
            boolean r0 = r0.bindService(r10, r3, r14, r15)     // Catch:{ RuntimeException -> 0x0358 }
            com.google.android.gms.measurement.internal.zzfr r3 = r13.zza     // Catch:{ RuntimeException -> 0x0358 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ RuntimeException -> 0x0358 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzj()     // Catch:{ RuntimeException -> 0x0358 }
            java.lang.String r14 = "Install Referrer Service is"
            java.lang.String r15 = "available"
            java.lang.String r16 = "not available"
            r10 = 1
            if (r10 == r0) goto L_0x0354
            r15 = r16
        L_0x0354:
            r3.zzb(r14, r15)     // Catch:{ RuntimeException -> 0x0358 }
            goto L_0x039c
        L_0x0358:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r13.zza     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x056b }
            java.lang.String r13 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x056b }
            r3.zzb(r13, r0)     // Catch:{ all -> 0x056b }
            goto L_0x039c
        L_0x036d:
            com.google.android.gms.measurement.internal.zzfr r0 = r13.zza     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x056b }
            java.lang.String r3 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r3)     // Catch:{ all -> 0x056b }
            goto L_0x039c
        L_0x037d:
            com.google.android.gms.measurement.internal.zzfr r0 = r13.zza     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzi()     // Catch:{ all -> 0x056b }
            java.lang.String r3 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r3)     // Catch:{ all -> 0x056b }
            goto L_0x039c
        L_0x038d:
            com.google.android.gms.measurement.internal.zzfr r0 = r13.zza     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzm()     // Catch:{ all -> 0x056b }
            java.lang.String r3 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r3)     // Catch:{ all -> 0x056b }
        L_0x039c:
            com.google.android.gms.measurement.internal.zzfo r0 = r23.zzaz()     // Catch:{ all -> 0x056b }
            r0.zzg()     // Catch:{ all -> 0x056b }
            r23.zzB()     // Catch:{ all -> 0x056b }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x056b }
            r3.<init>()     // Catch:{ all -> 0x056b }
            r13 = 1
            r3.putLong(r8, r13)     // Catch:{ all -> 0x056b }
            r3.putLong(r9, r13)     // Catch:{ all -> 0x056b }
            r8 = 0
            r3.putLong(r7, r8)     // Catch:{ all -> 0x056b }
            r3.putLong(r6, r8)     // Catch:{ all -> 0x056b }
            r15 = r22
            r3.putLong(r15, r8)     // Catch:{ all -> 0x056b }
            r14 = r21
            r3.putLong(r14, r8)     // Catch:{ all -> 0x056b }
            r8 = 1
            r3.putLong(r5, r8)     // Catch:{ all -> 0x056b }
            boolean r0 = r2.zzp     // Catch:{ all -> 0x056b }
            if (r0 == 0) goto L_0x03d1
            r3.putLong(r4, r8)     // Catch:{ all -> 0x056b }
        L_0x03d1:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x056b }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x056b }
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x056b }
            zzak(r0)     // Catch:{ all -> 0x056b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x056b }
            r0.zzg()     // Catch:{ all -> 0x056b }
            r0.zzW()     // Catch:{ all -> 0x056b }
            java.lang.String r5 = "first_open_count"
            long r8 = r0.zzc(r4, r5)     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x056b }
            android.content.Context r0 = r0.zzau()     // Catch:{ all -> 0x056b }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x056b }
            if (r0 != 0) goto L_0x0411
            com.google.android.gms.measurement.internal.zzeh r0 = r23.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x056b }
            java.lang.String r5 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x056b }
            r0.zzb(r5, r4)     // Catch:{ all -> 0x056b }
            r22 = r6
        L_0x040d:
            r4 = 0
            goto L_0x04d5
        L_0x0411:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x0421 }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x0421 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0421 }
            r5 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x0421 }
            goto L_0x0434
        L_0x0421:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeh r5 = r23.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x056b }
            java.lang.String r13 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x056b }
            r5.zzc(r13, r10, r0)     // Catch:{ all -> 0x056b }
            r0 = 0
        L_0x0434:
            if (r0 == 0) goto L_0x0494
            r21 = r14
            long r13 = r0.firstInstallTime     // Catch:{ all -> 0x056b }
            r17 = 0
            int r5 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r5 == 0) goto L_0x048e
            long r13 = r0.firstInstallTime     // Catch:{ all -> 0x056b }
            r22 = r6
            long r5 = r0.lastUpdateTime     // Catch:{ all -> 0x056b }
            int r0 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x046e
            com.google.android.gms.measurement.internal.zzaf r0 = r23.zzg()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzab     // Catch:{ all -> 0x056b }
            r6 = 0
            boolean r0 = r0.zzs(r6, r5)     // Catch:{ all -> 0x056b }
            if (r0 == 0) goto L_0x0468
            r13 = 0
            int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x0466
            r13 = 1
            r3.putLong(r7, r13)     // Catch:{ all -> 0x056b }
            r0 = 0
            r8 = 0
            goto L_0x0470
        L_0x0466:
            r0 = 0
            goto L_0x0470
        L_0x0468:
            r13 = 1
            r3.putLong(r7, r13)     // Catch:{ all -> 0x056b }
            goto L_0x0466
        L_0x046e:
            r6 = 0
            r0 = 1
        L_0x0470:
            com.google.android.gms.measurement.internal.zzks r5 = new com.google.android.gms.measurement.internal.zzks     // Catch:{ all -> 0x056b }
            java.lang.String r14 = "_fi"
            r7 = 1
            if (r7 == r0) goto L_0x047a
            r16 = 0
            goto L_0x047c
        L_0x047a:
            r16 = 1
        L_0x047c:
            java.lang.Long r17 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x056b }
            java.lang.String r18 = "auto"
            r13 = r5
            r7 = r21
            r6 = r15
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x056b }
            r1.zzV(r5, r2)     // Catch:{ all -> 0x056b }
            goto L_0x0498
        L_0x048e:
            r22 = r6
            r6 = r15
            r7 = r21
            goto L_0x0498
        L_0x0494:
            r22 = r6
            r7 = r14
            r6 = r15
        L_0x0498:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x04a8 }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x04a8 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x04a8 }
            r5 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r4, r5)     // Catch:{ NameNotFoundException -> 0x04a8 }
            goto L_0x04bb
        L_0x04a8:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeh r5 = r23.zzay()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x056b }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x056b }
            r5.zzc(r13, r4, r0)     // Catch:{ all -> 0x056b }
            r0 = 0
        L_0x04bb:
            if (r0 == 0) goto L_0x040d
            int r4 = r0.flags     // Catch:{ all -> 0x056b }
            r5 = 1
            r4 = r4 & r5
            if (r4 == 0) goto L_0x04c8
            r4 = 1
            r3.putLong(r6, r4)     // Catch:{ all -> 0x056b }
        L_0x04c8:
            int r0 = r0.flags     // Catch:{ all -> 0x056b }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x040d
            r4 = 1
            r3.putLong(r7, r4)     // Catch:{ all -> 0x056b }
            goto L_0x040d
        L_0x04d5:
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x04de
            r4 = r22
            r3.putLong(r4, r8)     // Catch:{ all -> 0x056b }
        L_0x04de:
            com.google.android.gms.measurement.internal.zzau r0 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzas r15 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x056b }
            r15.<init>(r3)     // Catch:{ all -> 0x056b }
            java.lang.String r14 = "_f"
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x056b }
            r1.zzF(r0, r2)     // Catch:{ all -> 0x056b }
            goto L_0x055a
        L_0x04f3:
            r6 = r13
            r3 = r14
            com.google.android.gms.measurement.internal.zzks r0 = new com.google.android.gms.measurement.internal.zzks     // Catch:{ all -> 0x056b }
            java.lang.String r14 = "_fvt"
            java.lang.Long r17 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x056b }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x056b }
            r1.zzV(r0, r2)     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzfo r0 = r23.zzaz()     // Catch:{ all -> 0x056b }
            r0.zzg()     // Catch:{ all -> 0x056b }
            r23.zzB()     // Catch:{ all -> 0x056b }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x056b }
            r0.<init>()     // Catch:{ all -> 0x056b }
            r7 = 1
            r0.putLong(r6, r7)     // Catch:{ all -> 0x056b }
            r0.putLong(r3, r7)     // Catch:{ all -> 0x056b }
            r0.putLong(r5, r7)     // Catch:{ all -> 0x056b }
            boolean r3 = r2.zzp     // Catch:{ all -> 0x056b }
            if (r3 == 0) goto L_0x0528
            r0.putLong(r4, r7)     // Catch:{ all -> 0x056b }
        L_0x0528:
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzas r15 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x056b }
            r15.<init>(r0)     // Catch:{ all -> 0x056b }
            java.lang.String r14 = "_v"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x056b }
            r1.zzF(r3, r2)     // Catch:{ all -> 0x056b }
            goto L_0x055a
        L_0x053d:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x056b }
            if (r0 == 0) goto L_0x055a
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x056b }
            r0.<init>()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzau r3 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzas r15 = new com.google.android.gms.measurement.internal.zzas     // Catch:{ all -> 0x056b }
            r15.<init>(r0)     // Catch:{ all -> 0x056b }
            java.lang.String r14 = "_cd"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r11
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x056b }
            r1.zzF(r3, r2)     // Catch:{ all -> 0x056b }
        L_0x055a:
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x056b }
            zzak(r0)     // Catch:{ all -> 0x056b }
            r0.zzC()     // Catch:{ all -> 0x056b }
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze
            zzak(r0)
            r0.zzx()
            return
        L_0x056b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzak(r2)
            r2.zzx()
            throw r0
        L_0x0575:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzK(com.google.android.gms.measurement.internal.zzp):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzL() {
        this.zzr++;
    }

    /* access modifiers changed from: package-private */
    public final void zzM(zzab zzab) {
        zzp zzab2 = zzab((String) Preconditions.checkNotNull(zzab.zza));
        if (zzab2 != null) {
            zzN(zzab, zzab2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzN(zzab zzab, zzp zzp2) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotEmpty(zzab.zza);
        Preconditions.checkNotNull(zzab.zzc);
        Preconditions.checkNotEmpty(zzab.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzaj(zzp2)) {
            if (zzp2.zzh) {
                zzak zzak = this.zze;
                zzak(zzak);
                zzak.zzw();
                try {
                    zzd(zzp2);
                    String str = (String) Preconditions.checkNotNull(zzab.zza);
                    zzak zzak2 = this.zze;
                    zzak(zzak2);
                    zzab zzk2 = zzak2.zzk(str, zzab.zzc.zzb);
                    if (zzk2 != null) {
                        zzay().zzc().zzc("Removing conditional user property", zzab.zza, this.zzn.zzj().zzf(zzab.zzc.zzb));
                        zzak zzak3 = this.zze;
                        zzak(zzak3);
                        zzak3.zza(str, zzab.zzc.zzb);
                        if (zzk2.zze) {
                            zzak zzak4 = this.zze;
                            zzak(zzak4);
                            zzak4.zzA(str, zzab.zzc.zzb);
                        }
                        zzau zzau = zzab.zzk;
                        if (zzau != null) {
                            zzas zzas = zzau.zzb;
                            zzX((zzau) Preconditions.checkNotNull(zzv().zzz(str, ((zzau) Preconditions.checkNotNull(zzab.zzk)).zza, zzas != null ? zzas.zzc() : null, zzk2.zzb, zzab.zzk.zzd, true, true)), zzp2);
                        }
                    } else {
                        zzay().zzk().zzc("Conditional user property doesn't exist", zzeh.zzn(zzab.zza), this.zzn.zzj().zzf(zzab.zzc.zzb));
                    }
                    zzak zzak5 = this.zze;
                    zzak(zzak5);
                    zzak5.zzC();
                } finally {
                    zzak zzak6 = this.zze;
                    zzak(zzak6);
                    zzak6.zzx();
                }
            } else {
                zzd(zzp2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzO(zzks zzks, zzp zzp2) {
        zzaz().zzg();
        zzB();
        if (zzaj(zzp2)) {
            if (!zzp2.zzh) {
                zzd(zzp2);
            } else if (!"_npa".equals(zzks.zzb) || zzp2.zzr == null) {
                zzay().zzc().zzb("Removing user property", this.zzn.zzj().zzf(zzks.zzb));
                zzak zzak = this.zze;
                zzak(zzak);
                zzak.zzw();
                try {
                    zzd(zzp2);
                    zzmt.zzc();
                    if (this.zzn.zzf().zzs((String) null, zzdu.zzan) && this.zzn.zzf().zzs((String) null, zzdu.zzap) && "_id".equals(zzks.zzb)) {
                        zzak zzak2 = this.zze;
                        zzak(zzak2);
                        zzak2.zzA((String) Preconditions.checkNotNull(zzp2.zza), "_lair");
                    }
                    zzak zzak3 = this.zze;
                    zzak(zzak3);
                    zzak3.zzA((String) Preconditions.checkNotNull(zzp2.zza), zzks.zzb);
                    zzak zzak4 = this.zze;
                    zzak(zzak4);
                    zzak4.zzC();
                    zzay().zzc().zzb("User property removed", this.zzn.zzj().zzf(zzks.zzb));
                } finally {
                    zzak zzak5 = this.zze;
                    zzak(zzak5);
                    zzak5.zzx();
                }
            } else {
                zzay().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zzV(new zzks("_npa", zzav().currentTimeMillis(), Long.valueOf(true != zzp2.zzr.booleanValue() ? 0 : 1), "auto"), zzp2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzP(zzp zzp2) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzak zzak = this.zze;
        zzak(zzak);
        String str = (String) Preconditions.checkNotNull(zzp2.zza);
        Preconditions.checkNotEmpty(str);
        zzak.zzg();
        zzak.zzW();
        try {
            SQLiteDatabase zzh2 = zzak.zzh();
            String[] strArr = {str};
            int delete = zzh2.delete("apps", "app_id=?", strArr) + zzh2.delete("events", "app_id=?", strArr) + zzh2.delete("user_attributes", "app_id=?", strArr) + zzh2.delete("conditional_properties", "app_id=?", strArr) + zzh2.delete("raw_events", "app_id=?", strArr) + zzh2.delete("raw_events_metadata", "app_id=?", strArr) + zzh2.delete("queue", "app_id=?", strArr) + zzh2.delete("audience_filter_values", "app_id=?", strArr) + zzh2.delete("main_event_params", "app_id=?", strArr) + zzh2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzak.zzs.zzay().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzak.zzs.zzay().zzd().zzc("Error resetting analytics data. appId, error", zzeh.zzn(str), e);
        }
        if (zzp2.zzh) {
            zzK(zzp2);
        }
    }

    public final void zzQ(String str, zzid zzid) {
        zzaz().zzg();
        String str2 = this.zzD;
        if (str2 == null || str2.equals(str) || zzid != null) {
            this.zzD = str;
            this.zzC = zzid;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzR() {
        zzaz().zzg();
        zzak zzak = this.zze;
        zzak(zzak);
        zzak.zzz();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzaf();
    }

    /* access modifiers changed from: package-private */
    public final void zzS(zzab zzab) {
        zzp zzab2 = zzab((String) Preconditions.checkNotNull(zzab.zza));
        if (zzab2 != null) {
            zzT(zzab, zzab2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzT(zzab zzab, zzp zzp2) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotEmpty(zzab.zza);
        Preconditions.checkNotNull(zzab.zzb);
        Preconditions.checkNotNull(zzab.zzc);
        Preconditions.checkNotEmpty(zzab.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzaj(zzp2)) {
            if (!zzp2.zzh) {
                zzd(zzp2);
                return;
            }
            zzab zzab2 = new zzab(zzab);
            boolean z = false;
            zzab2.zze = false;
            zzak zzak = this.zze;
            zzak(zzak);
            zzak.zzw();
            try {
                zzak zzak2 = this.zze;
                zzak(zzak2);
                zzab zzk2 = zzak2.zzk((String) Preconditions.checkNotNull(zzab2.zza), zzab2.zzc.zzb);
                if (zzk2 != null && !zzk2.zzb.equals(zzab2.zzb)) {
                    zzay().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzab2.zzc.zzb), zzab2.zzb, zzk2.zzb);
                }
                if (zzk2 != null && zzk2.zze) {
                    zzab2.zzb = zzk2.zzb;
                    zzab2.zzd = zzk2.zzd;
                    zzab2.zzh = zzk2.zzh;
                    zzab2.zzf = zzk2.zzf;
                    zzab2.zzi = zzk2.zzi;
                    zzab2.zze = true;
                    zzks zzks = zzab2.zzc;
                    zzab2.zzc = new zzks(zzks.zzb, zzk2.zzc.zzc, zzks.zza(), zzk2.zzc.zzf);
                } else if (TextUtils.isEmpty(zzab2.zzf)) {
                    zzks zzks2 = zzab2.zzc;
                    zzab2.zzc = new zzks(zzks2.zzb, zzab2.zzd, zzks2.zza(), zzab2.zzc.zzf);
                    zzab2.zze = true;
                    z = true;
                }
                if (zzab2.zze) {
                    zzks zzks3 = zzab2.zzc;
                    zzku zzku = new zzku((String) Preconditions.checkNotNull(zzab2.zza), zzab2.zzb, zzks3.zzb, zzks3.zzc, Preconditions.checkNotNull(zzks3.zza()));
                    zzak zzak3 = this.zze;
                    zzak(zzak3);
                    if (zzak3.zzL(zzku)) {
                        zzay().zzc().zzd("User property updated immediately", zzab2.zza, this.zzn.zzj().zzf(zzku.zzc), zzku.zze);
                    } else {
                        zzay().zzd().zzd("(2)Too many active user properties, ignoring", zzeh.zzn(zzab2.zza), this.zzn.zzj().zzf(zzku.zzc), zzku.zze);
                    }
                    if (z && zzab2.zzi != null) {
                        zzX(new zzau(zzab2.zzi, zzab2.zzd), zzp2);
                    }
                }
                zzak zzak4 = this.zze;
                zzak(zzak4);
                if (zzak4.zzK(zzab2)) {
                    zzay().zzc().zzd("Conditional property added", zzab2.zza, this.zzn.zzj().zzf(zzab2.zzc.zzb), zzab2.zzc.zza());
                } else {
                    zzay().zzd().zzd("Too many conditional properties, ignoring", zzeh.zzn(zzab2.zza), this.zzn.zzj().zzf(zzab2.zzc.zzb), zzab2.zzc.zza());
                }
                zzak zzak5 = this.zze;
                zzak(zzak5);
                zzak5.zzC();
            } finally {
                zzak zzak6 = this.zze;
                zzak(zzak6);
                zzak6.zzx();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzU(String str, zzah zzah) {
        zzaz().zzg();
        zzB();
        this.zzB.put(str, zzah);
        zzak zzak = this.zze;
        zzak(zzak);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzah);
        zzak.zzg();
        zzak.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzah.zzh());
        try {
            if (zzak.zzh().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                zzak.zzs.zzay().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzeh.zzn(str));
            }
        } catch (SQLiteException e) {
            zzak.zzs.zzay().zzd().zzc("Error storing consent setting. appId, error", zzeh.zzn(str), e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzV(zzks zzks, zzp zzp2) {
        long j;
        zzks zzks2 = zzks;
        zzp zzp3 = zzp2;
        zzaz().zzg();
        zzB();
        if (zzaj(zzp2)) {
            if (!zzp3.zzh) {
                zzd(zzp3);
                return;
            }
            int zzl2 = zzv().zzl(zzks2.zzb);
            int i = 0;
            if (zzl2 != 0) {
                zzkw zzv2 = zzv();
                String str = zzks2.zzb;
                zzg();
                String zzC2 = zzv2.zzC(str, 24, true);
                String str2 = zzks2.zzb;
                zzv().zzM(this.zzE, zzp3.zza, zzl2, "_ev", zzC2, str2 != null ? str2.length() : 0);
                return;
            }
            int zzd2 = zzv().zzd(zzks2.zzb, zzks.zza());
            if (zzd2 != 0) {
                zzkw zzv3 = zzv();
                String str3 = zzks2.zzb;
                zzg();
                String zzC3 = zzv3.zzC(str3, 24, true);
                Object zza2 = zzks.zza();
                if (zza2 != null && ((zza2 instanceof String) || (zza2 instanceof CharSequence))) {
                    i = zza2.toString().length();
                }
                zzv().zzM(this.zzE, zzp3.zza, zzd2, "_ev", zzC3, i);
                return;
            }
            Object zzB2 = zzv().zzB(zzks2.zzb, zzks.zza());
            if (zzB2 != null) {
                if ("_sid".equals(zzks2.zzb)) {
                    long j2 = zzks2.zzc;
                    String str4 = zzks2.zzf;
                    String str5 = (String) Preconditions.checkNotNull(zzp3.zza);
                    zzak zzak = this.zze;
                    zzak(zzak);
                    zzku zzp4 = zzak.zzp(str5, "_sno");
                    if (zzp4 != null) {
                        Object obj = zzp4.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            zzV(new zzks("_sno", j2, Long.valueOf(j + 1), str4), zzp3);
                        }
                    }
                    if (zzp4 != null) {
                        zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzp4.zze);
                    }
                    zzak zzak2 = this.zze;
                    zzak(zzak2);
                    zzaq zzn2 = zzak2.zzn(str5, "_s");
                    if (zzn2 != null) {
                        j = zzn2.zzc;
                        zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(j));
                    } else {
                        j = 0;
                    }
                    zzV(new zzks("_sno", j2, Long.valueOf(j + 1), str4), zzp3);
                }
                zzku zzku = new zzku((String) Preconditions.checkNotNull(zzp3.zza), (String) Preconditions.checkNotNull(zzks2.zzf), zzks2.zzb, zzks2.zzc, zzB2);
                zzay().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzku.zzc), zzB2);
                zzak zzak3 = this.zze;
                zzak(zzak3);
                zzak3.zzw();
                try {
                    zzmt.zzc();
                    if (this.zzn.zzf().zzs((String) null, zzdu.zzan) && "_id".equals(zzku.zzc)) {
                        if (this.zzn.zzf().zzs((String) null, zzdu.zzaq)) {
                            zzak zzak4 = this.zze;
                            zzak(zzak4);
                            zzku zzp5 = zzak4.zzp(zzp3.zza, "_id");
                            if (zzp5 != null && !zzku.zze.equals(zzp5.zze)) {
                                zzak zzak5 = this.zze;
                                zzak(zzak5);
                                zzak5.zzA(zzp3.zza, "_lair");
                            }
                        } else {
                            zzak zzak6 = this.zze;
                            zzak(zzak6);
                            zzak6.zzA(zzp3.zza, "_lair");
                        }
                    }
                    zzd(zzp3);
                    zzak zzak7 = this.zze;
                    zzak(zzak7);
                    boolean zzL = zzak7.zzL(zzku);
                    zzak zzak8 = this.zze;
                    zzak(zzak8);
                    zzak8.zzC();
                    if (!zzL) {
                        zzay().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzku.zzc), zzku.zze);
                        zzv().zzM(this.zzE, zzp3.zza, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzak zzak9 = this.zze;
                    zzak(zzak9);
                    zzak9.zzx();
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v4 */
    /* JADX WARNING: type inference failed for: r9v16, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r9v18 */
    /* JADX WARNING: type inference failed for: r9v19 */
    /* JADX WARNING: type inference failed for: r9v20 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:218|219) */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0217, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0218, code lost:
        r8.zzs.zzay().zzd().zzc("Failed to merge queued bundle. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        r0 = r0.subList(0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0303, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0304, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:?, code lost:
        zzay().zzd().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r6), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x04d9, code lost:
        if (r3 != null) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:?, code lost:
        r3.close();
        r9 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x04e4, code lost:
        if (r3 != null) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x04fc, code lost:
        if (r3 != null) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0503, code lost:
        if (android.text.TextUtils.isEmpty(r9) != false) goto L_0x0513;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0505, code lost:
        r0 = r1.zze;
        zzak(r0);
        r0 = r0.zzj(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x050e, code lost:
        if (r0 == null) goto L_0x0513;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0510, code lost:
        zzC(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0525, code lost:
        r1.zzv = r2;
        zzad();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x052a, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0108, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0112, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012a, code lost:
        if (r11 != null) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r1.zzA = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:218:0x047e */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x029c A[SYNTHETIC, Splitter:B:146:0x029c] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02a5 A[Catch:{ all -> 0x03bf, all -> 0x0520 }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0495 A[Catch:{ all -> 0x03bf, all -> 0x0520 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x051c A[SYNTHETIC, Splitter:B:256:0x051c] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0134 A[Catch:{ all -> 0x0130, all -> 0x0523 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:143:0x0283=Splitter:B:143:0x0283, B:174:0x030a=Splitter:B:174:0x030a, B:233:0x04db=Splitter:B:233:0x04db, B:218:0x047e=Splitter:B:218:0x047e, B:246:0x04ff=Splitter:B:246:0x04ff} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzW() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.zzfo r0 = r22.zzaz()
            r0.zzg()
            r22.zzB()
            r2 = 1
            r1.zzv = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x0523 }
            r0.zzaw()     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzjk r0 = r0.zzt()     // Catch:{ all -> 0x0523 }
            java.lang.Boolean r0 = r0.zzj()     // Catch:{ all -> 0x0523 }
            if (r0 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0523 }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x0523 }
            r1.zzv = r3
        L_0x0030:
            r22.zzad()
            return
        L_0x0034:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0523 }
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x0523 }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x0523 }
            r1.zzv = r3
            goto L_0x0030
        L_0x004a:
            long r4 = r1.zza     // Catch:{ all -> 0x0523 }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0058
            r22.zzaf()     // Catch:{ all -> 0x0523 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0058:
            com.google.android.gms.measurement.internal.zzfo r0 = r22.zzaz()     // Catch:{ all -> 0x0523 }
            r0.zzg()     // Catch:{ all -> 0x0523 }
            java.util.List r0 = r1.zzy     // Catch:{ all -> 0x0523 }
            if (r0 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ all -> 0x0523 }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x0523 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0073:
            com.google.android.gms.measurement.internal.zzen r0 = r1.zzd     // Catch:{ all -> 0x0523 }
            zzak(r0)     // Catch:{ all -> 0x0523 }
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0523 }
            if (r0 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ all -> 0x0523 }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x0523 }
            r22.zzaf()     // Catch:{ all -> 0x0523 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0091:
            com.google.android.gms.common.util.Clock r0 = r22.zzav()     // Catch:{ all -> 0x0523 }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzaf r0 = r22.zzg()     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzP     // Catch:{ all -> 0x0523 }
            r9 = 0
            int r0 = r0.zze(r9, r8)     // Catch:{ all -> 0x0523 }
            r22.zzg()     // Catch:{ all -> 0x0523 }
            long r10 = com.google.android.gms.measurement.internal.zzaf.zzz()     // Catch:{ all -> 0x0523 }
            long r10 = r4 - r10
            r8 = r3
        L_0x00ae:
            if (r8 >= r0) goto L_0x00b9
            boolean r12 = r1.zzag(r9, r10)     // Catch:{ all -> 0x0523 }
            if (r12 == 0) goto L_0x00b9
            int r8 = r8 + 1
            goto L_0x00ae
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzjm r0 = r1.zzk     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc     // Catch:{ all -> 0x0523 }
            long r10 = r0.zza()     // Catch:{ all -> 0x0523 }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ all -> 0x0523 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0523 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0523 }
            r0.zzb(r6, r7)     // Catch:{ all -> 0x0523 }
        L_0x00dc:
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x0523 }
            zzak(r0)     // Catch:{ all -> 0x0523 }
            java.lang.String r6 = r0.zzr()     // Catch:{ all -> 0x0523 }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0523 }
            r7 = -1
            if (r0 != 0) goto L_0x0499
            long r10 = r1.zzA     // Catch:{ all -> 0x0523 }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0138
            com.google.android.gms.measurement.internal.zzak r10 = r1.zze     // Catch:{ all -> 0x0523 }
            zzak(r10)     // Catch:{ all -> 0x0523 }
            android.database.sqlite.SQLiteDatabase r0 = r10.zzh()     // Catch:{ SQLiteException -> 0x0119, all -> 0x0117 }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x0119, all -> 0x0117 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0115 }
            if (r0 != 0) goto L_0x010e
            if (r11 == 0) goto L_0x012d
        L_0x010a:
            r11.close()     // Catch:{ all -> 0x0523 }
            goto L_0x012d
        L_0x010e:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0115 }
            if (r11 == 0) goto L_0x012d
            goto L_0x010a
        L_0x0115:
            r0 = move-exception
            goto L_0x011b
        L_0x0117:
            r0 = move-exception
            goto L_0x0132
        L_0x0119:
            r0 = move-exception
            r11 = r9
        L_0x011b:
            com.google.android.gms.measurement.internal.zzfr r10 = r10.zzs     // Catch:{ all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()     // Catch:{ all -> 0x0130 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzd()     // Catch:{ all -> 0x0130 }
            java.lang.String r12 = "Error querying raw events"
            r10.zzb(r12, r0)     // Catch:{ all -> 0x0130 }
            if (r11 == 0) goto L_0x012d
            goto L_0x010a
        L_0x012d:
            r1.zzA = r7     // Catch:{ all -> 0x0523 }
            goto L_0x0138
        L_0x0130:
            r0 = move-exception
            r9 = r11
        L_0x0132:
            if (r9 == 0) goto L_0x0137
            r9.close()     // Catch:{ all -> 0x0523 }
        L_0x0137:
            throw r0     // Catch:{ all -> 0x0523 }
        L_0x0138:
            com.google.android.gms.measurement.internal.zzaf r0 = r22.zzg()     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzdt r7 = com.google.android.gms.measurement.internal.zzdu.zzf     // Catch:{ all -> 0x0523 }
            int r0 = r0.zze(r6, r7)     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzaf r7 = r22.zzg()     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzg     // Catch:{ all -> 0x0523 }
            int r7 = r7.zze(r6, r8)     // Catch:{ all -> 0x0523 }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x0523 }
            com.google.android.gms.measurement.internal.zzak r8 = r1.zze     // Catch:{ all -> 0x0523 }
            zzak(r8)     // Catch:{ all -> 0x0523 }
            r8.zzg()     // Catch:{ all -> 0x0523 }
            r8.zzW()     // Catch:{ all -> 0x0523 }
            if (r0 <= 0) goto L_0x015f
            r10 = r2
            goto L_0x0160
        L_0x015f:
            r10 = r3
        L_0x0160:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0523 }
            if (r7 <= 0) goto L_0x0167
            r10 = r2
            goto L_0x0168
        L_0x0167:
            r10 = r3
        L_0x0168:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x0523 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x0523 }
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String r12 = "rowid"
            java.lang.String r13 = "data"
            java.lang.String r14 = "retry_count"
            java.lang.String[] r13 = new java.lang.String[]{r12, r13, r14}     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String[] r15 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            r15[r3] = r6     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            java.lang.String r12 = "queue"
            java.lang.String r14 = "app_id=?"
            r16 = 0
            r17 = 0
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x027f, all -> 0x027b }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0277 }
            if (r0 != 0) goto L_0x01a5
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0277 }
            if (r11 == 0) goto L_0x01a1
            r11.close()     // Catch:{ all -> 0x0523 }
        L_0x01a1:
            r20 = r4
            goto L_0x029f
        L_0x01a5:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0277 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0277 }
            r13 = r3
        L_0x01ab:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0277 }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0248 }
            com.google.android.gms.measurement.internal.zzkp r2 = r8.zzf     // Catch:{ IOException -> 0x0248 }
            com.google.android.gms.measurement.internal.zzkr r2 = r2.zzi     // Catch:{ IOException -> 0x0248 }
            zzak(r2)     // Catch:{ IOException -> 0x0248 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0233 }
            r9.<init>(r0)     // Catch:{ IOException -> 0x0233 }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0233 }
            r0.<init>(r9)     // Catch:{ IOException -> 0x0233 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0233 }
            r3.<init>()     // Catch:{ IOException -> 0x0233 }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x0233 }
            r20 = r4
        L_0x01cf:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x0231 }
            if (r4 > 0) goto L_0x022c
            r0.close()     // Catch:{ IOException -> 0x0231 }
            r9.close()     // Catch:{ IOException -> 0x0231 }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x0231 }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x0275 }
            if (r2 != 0) goto L_0x01eb
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x0275 }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01eb
            goto L_0x026e
        L_0x01eb:
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.internal.measurement.zzfy.zzu()     // Catch:{ IOException -> 0x0217 }
            com.google.android.gms.internal.measurement.zzlb r2 = com.google.android.gms.measurement.internal.zzkr.zzl(r2, r0)     // Catch:{ IOException -> 0x0217 }
            com.google.android.gms.internal.measurement.zzfx r2 = (com.google.android.gms.internal.measurement.zzfx) r2     // Catch:{ IOException -> 0x0217 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x0275 }
            if (r4 != 0) goto L_0x0203
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzab(r4)     // Catch:{ SQLiteException -> 0x0275 }
        L_0x0203:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0275 }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzjx r0 = r2.zzay()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.internal.measurement.zzfy r0 = (com.google.android.gms.internal.measurement.zzfy) r0     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x0275 }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x0275 }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0275 }
            goto L_0x025e
        L_0x0217:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzs     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0275 }
            goto L_0x025e
        L_0x022c:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x0231 }
            goto L_0x01cf
        L_0x0231:
            r0 = move-exception
            goto L_0x0236
        L_0x0233:
            r0 = move-exception
            r20 = r4
        L_0x0236:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs     // Catch:{ IOException -> 0x0246 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ IOException -> 0x0246 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ IOException -> 0x0246 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.zzb(r3, r0)     // Catch:{ IOException -> 0x0246 }
            throw r0     // Catch:{ IOException -> 0x0246 }
        L_0x0246:
            r0 = move-exception
            goto L_0x024b
        L_0x0248:
            r0 = move-exception
            r20 = r4
        L_0x024b:
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzs     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x0275 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x0275 }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x0275 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x0275 }
        L_0x025e:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0275 }
            if (r0 == 0) goto L_0x026e
            if (r13 <= r7) goto L_0x0267
            goto L_0x026e
        L_0x0267:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            goto L_0x01ab
        L_0x026e:
            if (r11 == 0) goto L_0x0273
            r11.close()     // Catch:{ all -> 0x0520 }
        L_0x0273:
            r0 = r12
            goto L_0x029f
        L_0x0275:
            r0 = move-exception
            goto L_0x0283
        L_0x0277:
            r0 = move-exception
            r20 = r4
            goto L_0x0283
        L_0x027b:
            r0 = move-exception
            r9 = 0
            goto L_0x0493
        L_0x027f:
            r0 = move-exception
            r20 = r4
            r11 = 0
        L_0x0283:
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzs     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0491 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0491 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ all -> 0x0491 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x0491 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0491 }
            if (r11 == 0) goto L_0x029f
            r11.close()     // Catch:{ all -> 0x0520 }
        L_0x029f:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x0520 }
            if (r2 != 0) goto L_0x0513
            com.google.android.gms.measurement.internal.zzah r2 = r1.zzh(r6)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzag r3 = com.google.android.gms.measurement.internal.zzag.AD_STORAGE     // Catch:{ all -> 0x0520 }
            boolean r2 = r2.zzi(r3)     // Catch:{ all -> 0x0520 }
            if (r2 == 0) goto L_0x030a
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0520 }
        L_0x02b5:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0520 }
            if (r3 == 0) goto L_0x02d4
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0520 }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x0520 }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x0520 }
            com.google.android.gms.internal.measurement.zzfy r3 = (com.google.android.gms.internal.measurement.zzfy) r3     // Catch:{ all -> 0x0520 }
            java.lang.String r4 = r3.zzK()     // Catch:{ all -> 0x0520 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0520 }
            if (r4 != 0) goto L_0x02b5
            java.lang.String r2 = r3.zzK()     // Catch:{ all -> 0x0520 }
            goto L_0x02d5
        L_0x02d4:
            r2 = 0
        L_0x02d5:
            if (r2 == 0) goto L_0x030a
            r3 = 0
        L_0x02d8:
            int r4 = r0.size()     // Catch:{ all -> 0x0520 }
            if (r3 >= r4) goto L_0x030a
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x0520 }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x0520 }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x0520 }
            com.google.android.gms.internal.measurement.zzfy r4 = (com.google.android.gms.internal.measurement.zzfy) r4     // Catch:{ all -> 0x0520 }
            java.lang.String r5 = r4.zzK()     // Catch:{ all -> 0x0520 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0520 }
            if (r5 == 0) goto L_0x02f3
            goto L_0x0307
        L_0x02f3:
            java.lang.String r4 = r4.zzK()     // Catch:{ all -> 0x0520 }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0520 }
            if (r4 != 0) goto L_0x0307
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x0303 }
            goto L_0x030a
        L_0x0303:
            r0 = move-exception
            r2 = r4
            goto L_0x0525
        L_0x0307:
            int r3 = r3 + 1
            goto L_0x02d8
        L_0x030a:
            com.google.android.gms.internal.measurement.zzfv r2 = com.google.android.gms.internal.measurement.zzfw.zza()     // Catch:{ all -> 0x0520 }
            int r3 = r0.size()     // Catch:{ all -> 0x0520 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0520 }
            int r5 = r0.size()     // Catch:{ all -> 0x0520 }
            r4.<init>(r5)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzaf r5 = r22.zzg()     // Catch:{ all -> 0x0520 }
            boolean r5 = r5.zzt(r6)     // Catch:{ all -> 0x0520 }
            if (r5 == 0) goto L_0x0333
            com.google.android.gms.measurement.internal.zzah r5 = r1.zzh(r6)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzag r7 = com.google.android.gms.measurement.internal.zzag.AD_STORAGE     // Catch:{ all -> 0x0520 }
            boolean r5 = r5.zzi(r7)     // Catch:{ all -> 0x0520 }
            if (r5 == 0) goto L_0x0333
            r5 = 1
            goto L_0x0334
        L_0x0333:
            r5 = 0
        L_0x0334:
            com.google.android.gms.measurement.internal.zzah r7 = r1.zzh(r6)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzag r8 = com.google.android.gms.measurement.internal.zzag.AD_STORAGE     // Catch:{ all -> 0x0520 }
            boolean r7 = r7.zzi(r8)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzah r8 = r1.zzh(r6)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzag r9 = com.google.android.gms.measurement.internal.zzag.ANALYTICS_STORAGE     // Catch:{ all -> 0x0520 }
            boolean r8 = r8.zzi(r9)     // Catch:{ all -> 0x0520 }
            r9 = 0
        L_0x0349:
            if (r9 >= r3) goto L_0x03c3
            java.lang.Object r10 = r0.get(r9)     // Catch:{ all -> 0x0520 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x0520 }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x0520 }
            com.google.android.gms.internal.measurement.zzfy r10 = (com.google.android.gms.internal.measurement.zzfy) r10     // Catch:{ all -> 0x0520 }
            com.google.android.gms.internal.measurement.zzjt r10 = r10.zzbt()     // Catch:{ all -> 0x0520 }
            com.google.android.gms.internal.measurement.zzfx r10 = (com.google.android.gms.internal.measurement.zzfx) r10     // Catch:{ all -> 0x0520 }
            java.lang.Object r11 = r0.get(r9)     // Catch:{ all -> 0x0520 }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x0520 }
            java.lang.Object r11 = r11.second     // Catch:{ all -> 0x0520 }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0520 }
            r4.add(r11)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzaf r11 = r22.zzg()     // Catch:{ all -> 0x0520 }
            r11.zzh()     // Catch:{ all -> 0x0520 }
            r11 = 55005(0xd6dd, double:2.7176E-319)
            r10.zzag(r11)     // Catch:{ all -> 0x0520 }
            r11 = r20
            r10.zzaf(r11)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzn     // Catch:{ all -> 0x0520 }
            r13.zzaw()     // Catch:{ all -> 0x0520 }
            r13 = 0
            r10.zzac(r13)     // Catch:{ all -> 0x03bf }
            if (r5 != 0) goto L_0x0388
            r10.zzo()     // Catch:{ all -> 0x0520 }
        L_0x0388:
            if (r7 != 0) goto L_0x0390
            r10.zzu()     // Catch:{ all -> 0x0520 }
            r10.zzr()     // Catch:{ all -> 0x0520 }
        L_0x0390:
            if (r8 != 0) goto L_0x0395
            r10.zzm()     // Catch:{ all -> 0x0520 }
        L_0x0395:
            com.google.android.gms.measurement.internal.zzaf r13 = r22.zzg()     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzT     // Catch:{ all -> 0x0520 }
            boolean r13 = r13.zzs(r6, r14)     // Catch:{ all -> 0x0520 }
            if (r13 == 0) goto L_0x03b7
            com.google.android.gms.internal.measurement.zzjx r13 = r10.zzay()     // Catch:{ all -> 0x0520 }
            com.google.android.gms.internal.measurement.zzfy r13 = (com.google.android.gms.internal.measurement.zzfy) r13     // Catch:{ all -> 0x0520 }
            byte[] r13 = r13.zzbq()     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzkr r14 = r1.zzi     // Catch:{ all -> 0x0520 }
            zzak(r14)     // Catch:{ all -> 0x0520 }
            long r13 = r14.zzd(r13)     // Catch:{ all -> 0x0520 }
            r10.zzG(r13)     // Catch:{ all -> 0x0520 }
        L_0x03b7:
            r2.zza(r10)     // Catch:{ all -> 0x0520 }
            int r9 = r9 + 1
            r20 = r11
            goto L_0x0349
        L_0x03bf:
            r0 = move-exception
            r2 = r13
            goto L_0x0525
        L_0x03c3:
            r11 = r20
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0520 }
            java.lang.String r0 = r0.zzq()     // Catch:{ all -> 0x0520 }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x0520 }
            if (r0 == 0) goto L_0x03e4
            com.google.android.gms.measurement.internal.zzkr r0 = r1.zzi     // Catch:{ all -> 0x0520 }
            zzak(r0)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.internal.measurement.zzjx r5 = r2.zzay()     // Catch:{ all -> 0x0520 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0520 }
            java.lang.String r0 = r0.zzm(r5)     // Catch:{ all -> 0x0520 }
            goto L_0x03e5
        L_0x03e4:
            r0 = 0
        L_0x03e5:
            com.google.android.gms.measurement.internal.zzkr r5 = r1.zzi     // Catch:{ all -> 0x0520 }
            zzak(r5)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.internal.measurement.zzjx r5 = r2.zzay()     // Catch:{ all -> 0x0520 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x0520 }
            byte[] r14 = r5.zzbq()     // Catch:{ all -> 0x0520 }
            r22.zzg()     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzp     // Catch:{ all -> 0x0520 }
            r9 = 0
            java.lang.Object r5 = r5.zza(r9)     // Catch:{ all -> 0x0520 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0520 }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x047e }
            r13.<init>(r5)     // Catch:{ MalformedURLException -> 0x047e }
            boolean r7 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x047e }
            r8 = 1
            r7 = r7 ^ r8
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ MalformedURLException -> 0x047e }
            java.util.List r7 = r1.zzy     // Catch:{ MalformedURLException -> 0x047e }
            if (r7 == 0) goto L_0x0420
            com.google.android.gms.measurement.internal.zzeh r4 = r22.zzay()     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ MalformedURLException -> 0x047e }
            java.lang.String r7 = "Set uploading progress before finishing the previous upload"
            r4.zza(r7)     // Catch:{ MalformedURLException -> 0x047e }
            goto L_0x0427
        L_0x0420:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x047e }
            r7.<init>(r4)     // Catch:{ MalformedURLException -> 0x047e }
            r1.zzy = r7     // Catch:{ MalformedURLException -> 0x047e }
        L_0x0427:
            com.google.android.gms.measurement.internal.zzjm r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x047e }
            r4.zzb(r11)     // Catch:{ MalformedURLException -> 0x047e }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x043b
            r3 = 0
            com.google.android.gms.internal.measurement.zzfy r2 = r2.zzb(r3)     // Catch:{  }
            java.lang.String r4 = r2.zzy()     // Catch:{ MalformedURLException -> 0x047e }
        L_0x043b:
            com.google.android.gms.measurement.internal.zzeh r2 = r22.zzay()     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()     // Catch:{ MalformedURLException -> 0x047e }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r7 = r14.length     // Catch:{ MalformedURLException -> 0x047e }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x047e }
            r2.zzd(r3, r4, r7, r0)     // Catch:{ MalformedURLException -> 0x047e }
            r2 = 1
            r1.zzu = r2     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.measurement.internal.zzen r11 = r1.zzd     // Catch:{ MalformedURLException -> 0x047e }
            zzak(r11)     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.measurement.internal.zzki r0 = new com.google.android.gms.measurement.internal.zzki     // Catch:{ MalformedURLException -> 0x047e }
            r0.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x047e }
            r11.zzg()     // Catch:{ MalformedURLException -> 0x047e }
            r11.zzW()     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzs     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.measurement.internal.zzfo r2 = r2.zzaz()     // Catch:{ MalformedURLException -> 0x047e }
            com.google.android.gms.measurement.internal.zzem r3 = new com.google.android.gms.measurement.internal.zzem     // Catch:{ MalformedURLException -> 0x047e }
            r15 = 0
            r10 = r3
            r12 = r6
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x047e }
            r2.zzo(r3)     // Catch:{ MalformedURLException -> 0x047e }
            goto L_0x0513
        L_0x047e:
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x0520 }
            java.lang.String r2 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ all -> 0x0520 }
            r0.zzc(r2, r3, r5)     // Catch:{ all -> 0x0520 }
            goto L_0x0513
        L_0x0491:
            r0 = move-exception
            r9 = r11
        L_0x0493:
            if (r9 == 0) goto L_0x0498
            r9.close()     // Catch:{ all -> 0x0520 }
        L_0x0498:
            throw r0     // Catch:{ all -> 0x0520 }
        L_0x0499:
            r11 = r4
            r1.zzA = r7     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0520 }
            zzak(r2)     // Catch:{ all -> 0x0520 }
            r22.zzg()     // Catch:{ all -> 0x0520 }
            long r3 = com.google.android.gms.measurement.internal.zzaf.zzz()     // Catch:{ all -> 0x0520 }
            long r4 = r11 - r3
            r2.zzg()     // Catch:{ all -> 0x0520 }
            r2.zzW()     // Catch:{ all -> 0x0520 }
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()     // Catch:{ SQLiteException -> 0x04eb, all -> 0x04e9 }
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x04eb, all -> 0x04e9 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ SQLiteException -> 0x04eb, all -> 0x04e9 }
            r5 = 0
            r3[r5] = r4     // Catch:{ SQLiteException -> 0x04eb, all -> 0x04e9 }
            java.lang.String r4 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            android.database.Cursor r3 = r0.rawQuery(r4, r3)     // Catch:{ SQLiteException -> 0x04eb, all -> 0x04e9 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x04e7 }
            if (r0 != 0) goto L_0x04df
            com.google.android.gms.measurement.internal.zzfr r0 = r2.zzs     // Catch:{ SQLiteException -> 0x04e7 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x04e7 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x04e7 }
            java.lang.String r4 = "No expired configs for apps with pending events"
            r0.zza(r4)     // Catch:{ SQLiteException -> 0x04e7 }
            if (r3 == 0) goto L_0x04ff
        L_0x04db:
            r3.close()     // Catch:{ all -> 0x0520 }
            goto L_0x04ff
        L_0x04df:
            r4 = 0
            java.lang.String r9 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x04e7 }
            if (r3 == 0) goto L_0x04ff
            goto L_0x04db
        L_0x04e7:
            r0 = move-exception
            goto L_0x04ed
        L_0x04e9:
            r0 = move-exception
            goto L_0x051a
        L_0x04eb:
            r0 = move-exception
            r3 = r9
        L_0x04ed:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0518 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0518 }
            java.lang.String r4 = "Error selecting expired configs"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x0518 }
            if (r3 == 0) goto L_0x04ff
            goto L_0x04db
        L_0x04ff:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0520 }
            if (r0 != 0) goto L_0x0513
            com.google.android.gms.measurement.internal.zzak r0 = r1.zze     // Catch:{ all -> 0x0520 }
            zzak(r0)     // Catch:{ all -> 0x0520 }
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzj(r9)     // Catch:{ all -> 0x0520 }
            if (r0 == 0) goto L_0x0513
            r1.zzC(r0)     // Catch:{ all -> 0x0520 }
        L_0x0513:
            r2 = 0
            r1.zzv = r2
            goto L_0x0030
        L_0x0518:
            r0 = move-exception
            r9 = r3
        L_0x051a:
            if (r9 == 0) goto L_0x051f
            r9.close()     // Catch:{ all -> 0x0520 }
        L_0x051f:
            throw r0     // Catch:{ all -> 0x0520 }
        L_0x0520:
            r0 = move-exception
            r2 = 0
            goto L_0x0525
        L_0x0523:
            r0 = move-exception
            r2 = r3
        L_0x0525:
            r1.zzv = r2
            r22.zzad()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzW():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0752, code lost:
        if (r14.size() == 0) goto L_0x0754;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0966, code lost:
        r13 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02f5 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x033f A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0342 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03a2 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03d0  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0536 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0575 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x05ee A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x063b A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0648 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0655 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0663 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0674 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x06b5 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x06d0 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0757 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0778 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x07e7 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x07f4 A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x080d A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x08aa A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x08ca A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x095c A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0a08 A[Catch:{ SQLiteException -> 0x0a23 }] */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0a1e  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0968 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x017c A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0192 A[SYNTHETIC, Splitter:B:51:0x0192] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x020d A[Catch:{ NumberFormatException -> 0x073c, all -> 0x0a9f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzX(com.google.android.gms.measurement.internal.zzau r35, com.google.android.gms.measurement.internal.zzp r36) {
        /*
            r34 = this;
            r1 = r34
            r2 = r35
            r3 = r36
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzfo r10 = r34.zzaz()
            r10.zzg()
            r34.zzB()
            java.lang.String r10 = r3.zza
            com.google.android.gms.measurement.internal.zzkr r11 = r1.zzi
            zzak(r11)
            boolean r11 = com.google.android.gms.measurement.internal.zzkr.zzA(r35, r36)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 == 0) goto L_0x0aaa
            com.google.android.gms.measurement.internal.zzfi r11 = r1.zzc
            zzak(r11)
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzo(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzeh r3 = r34.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzn
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzd(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc
            zzak(r3)
            boolean r3 = r3.zzm(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc
            zzak(r3)
            boolean r3 = r3.zzp(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzkw r11 = r34.zzv()
            com.google.android.gms.measurement.internal.zzkv r12 = r1.zzE
            r14 = 11
            java.lang.String r2 = r2.zza
            r17 = 0
            java.lang.String r15 = "_ev"
            r13 = r10
            r16 = r2
            r11.zzM(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzak(r2)
            com.google.android.gms.measurement.internal.zzg r2 = r2.zzj(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.zzl()
            long r5 = r2.zzc()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r34.zzav()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r34.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzy
            java.lang.Object r5 = r5.zza(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzeh r3 = r34.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzc()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzC(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzei r2 = com.google.android.gms.measurement.internal.zzei.zzb(r35)
            com.google.android.gms.measurement.internal.zzkw r11 = r34.zzv()
            com.google.android.gms.measurement.internal.zzaf r12 = r34.zzg()
            int r12 = r12.zzd(r10)
            r11.zzL(r2, r12)
            com.google.android.gms.measurement.internal.zzau r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzeh r11 = r34.zzay()
            java.lang.String r11 = r11.zzq()
            r13 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r13)
            if (r11 == 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzeh r11 = r34.zzay()
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzj()
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()
            java.lang.String r12 = r12.zzc(r2)
            java.lang.String r13 = "Logging event"
            r11.zzb(r13, r12)
        L_0x011c:
            com.google.android.gms.measurement.internal.zzak r11 = r1.zze
            zzak(r11)
            r11.zzw()
            r1.zzd(r3)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.internal.measurement.zzmt.zzc()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzaf r11 = r34.zzg()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzdt r12 = com.google.android.gms.measurement.internal.zzdu.zzan     // Catch:{ all -> 0x0a9f }
            boolean r11 = r11.zzs(r14, r12)     // Catch:{ all -> 0x0a9f }
            if (r11 != 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzaf r11 = r34.zzg()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzdt r12 = com.google.android.gms.measurement.internal.zzdu.zzao     // Catch:{ all -> 0x0a9f }
            boolean r11 = r11.zzs(r14, r12)     // Catch:{ all -> 0x0a9f }
            if (r11 == 0) goto L_0x014e
            com.google.android.gms.measurement.internal.zzak r11 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r11)     // Catch:{ all -> 0x0a9f }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x0a9f }
            java.lang.String r13 = "_lair"
            r11.zzA(r12, r13)     // Catch:{ all -> 0x0a9f }
        L_0x014e:
            java.lang.String r11 = "ecommerce_purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0a9f }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0a9f }
            java.lang.String r12 = "refund"
            r28 = r8
            if (r11 != 0) goto L_0x0171
            java.lang.String r9 = "purchase"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a9f }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0a9f }
            if (r9 != 0) goto L_0x0171
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a9f }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0a9f }
            if (r9 == 0) goto L_0x016f
            goto L_0x0171
        L_0x016f:
            r9 = 0
            goto L_0x0172
        L_0x0171:
            r9 = 1
        L_0x0172:
            java.lang.String r11 = "_iap"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0a9f }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x0a9f }
            if (r11 != 0) goto L_0x0186
            if (r9 == 0) goto L_0x0180
            r9 = 1
            goto L_0x0186
        L_0x0180:
            r33 = r4
            r8 = r15
        L_0x0183:
            r4 = 2
            goto L_0x032c
        L_0x0186:
            com.google.android.gms.measurement.internal.zzas r11 = r2.zzb     // Catch:{ all -> 0x0a9f }
            java.lang.String r13 = "currency"
            java.lang.String r11 = r11.zzg(r13)     // Catch:{ all -> 0x0a9f }
            java.lang.String r13 = "value"
            if (r9 == 0) goto L_0x01fb
            com.google.android.gms.measurement.internal.zzas r9 = r2.zzb     // Catch:{ all -> 0x0a9f }
            java.lang.Double r9 = r9.zzd(r13)     // Catch:{ all -> 0x0a9f }
            double r17 = r9.doubleValue()     // Catch:{ all -> 0x0a9f }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r9 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r9 != 0) goto L_0x01b9
            com.google.android.gms.measurement.internal.zzas r9 = r2.zzb     // Catch:{ all -> 0x0a9f }
            java.lang.Long r9 = r9.zze(r13)     // Catch:{ all -> 0x0a9f }
            r21 = r15
            long r14 = r9.longValue()     // Catch:{ all -> 0x0a9f }
            double r13 = (double) r14     // Catch:{ all -> 0x0a9f }
            double r17 = r13 * r19
            goto L_0x01bb
        L_0x01b9:
            r21 = r15
        L_0x01bb:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x01d5
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r9 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r9 < 0) goto L_0x01d5
            long r13 = java.lang.Math.round(r17)     // Catch:{ all -> 0x0a9f }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a9f }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0a9f }
            if (r9 == 0) goto L_0x0207
            long r13 = -r13
            goto L_0x0207
        L_0x01d5:
            com.google.android.gms.measurement.internal.zzeh r2 = r34.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x0a9f }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a9f }
            java.lang.Double r5 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0a9f }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r2)     // Catch:{ all -> 0x0a9f }
            r2.zzC()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzak(r2)
            r2.zzx()
            return
        L_0x01fb:
            r21 = r15
            com.google.android.gms.measurement.internal.zzas r9 = r2.zzb     // Catch:{ all -> 0x0a9f }
            java.lang.Long r9 = r9.zze(r13)     // Catch:{ all -> 0x0a9f }
            long r13 = r9.longValue()     // Catch:{ all -> 0x0a9f }
        L_0x0207:
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0a9f }
            if (r9 != 0) goto L_0x0326
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x0a9f }
            java.lang.String r9 = r11.toUpperCase(r9)     // Catch:{ all -> 0x0a9f }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r9.matches(r11)     // Catch:{ all -> 0x0a9f }
            if (r11 == 0) goto L_0x0326
            java.lang.String r11 = "_ltv_"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0a9f }
            int r12 = r9.length()     // Catch:{ all -> 0x0a9f }
            if (r12 == 0) goto L_0x022c
            java.lang.String r9 = r11.concat(r9)     // Catch:{ all -> 0x0a9f }
            goto L_0x0231
        L_0x022c:
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x0a9f }
            r9.<init>(r11)     // Catch:{ all -> 0x0a9f }
        L_0x0231:
            com.google.android.gms.measurement.internal.zzak r11 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r11)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzku r11 = r11.zzp(r10, r9)     // Catch:{ all -> 0x0a9f }
            if (r11 == 0) goto L_0x0271
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x0a9f }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a9f }
            if (r12 != 0) goto L_0x0243
            goto L_0x0271
        L_0x0243:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0a9f }
            long r11 = r11.longValue()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzku r18 = new com.google.android.gms.measurement.internal.zzku     // Catch:{ all -> 0x0a9f }
            java.lang.String r15 = r2.zzc     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.common.util.Clock r17 = r34.zzav()     // Catch:{ all -> 0x0a9f }
            long r19 = r17.currentTimeMillis()     // Catch:{ all -> 0x0a9f }
            long r11 = r11 + r13
            java.lang.Long r17 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0a9f }
            r11 = r18
            r12 = r10
            r14 = 0
            r13 = r15
            r8 = r14
            r15 = 0
            r14 = r9
            r9 = r21
            r15 = r19
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a9f }
            r33 = r4
            r8 = r9
            r9 = r18
            r4 = 2
            goto L_0x02ea
        L_0x0271:
            r15 = r21
            r8 = 0
            com.google.android.gms.measurement.internal.zzak r11 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r11)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzaf r12 = r34.zzg()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzD     // Catch:{ all -> 0x0a9f }
            int r8 = r12.zze(r10, r8)     // Catch:{ all -> 0x0a9f }
            int r8 = r8 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0a9f }
            r11.zzg()     // Catch:{ all -> 0x0a9f }
            r11.zzW()     // Catch:{ all -> 0x0a9f }
            android.database.sqlite.SQLiteDatabase r12 = r11.zzh()     // Catch:{ SQLiteException -> 0x02b4 }
            r21 = r15
            r15 = 3
            java.lang.String[] r15 = new java.lang.String[r15]     // Catch:{ SQLiteException -> 0x02b0 }
            r16 = 0
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x02b0 }
            r16 = 1
            r15[r16] = r10     // Catch:{ SQLiteException -> 0x02b0 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x02b0 }
            r33 = r4
            r4 = 2
            r15[r4] = r8     // Catch:{ SQLiteException -> 0x02ae }
            java.lang.String r8 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r12.execSQL(r8, r15)     // Catch:{ SQLiteException -> 0x02ae }
            goto L_0x02ce
        L_0x02ae:
            r0 = move-exception
            goto L_0x02ba
        L_0x02b0:
            r0 = move-exception
            r33 = r4
            goto L_0x02b9
        L_0x02b4:
            r0 = move-exception
            r33 = r4
            r21 = r15
        L_0x02b9:
            r4 = 2
        L_0x02ba:
            r8 = r0
            com.google.android.gms.measurement.internal.zzfr r11 = r11.zzs     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzd()     // Catch:{ all -> 0x0a9f }
            java.lang.String r12 = "Error pruning currencies. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a9f }
            r11.zzc(r12, r15, r8)     // Catch:{ all -> 0x0a9f }
        L_0x02ce:
            com.google.android.gms.measurement.internal.zzku r18 = new com.google.android.gms.measurement.internal.zzku     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.common.util.Clock r11 = r34.zzav()     // Catch:{ all -> 0x0a9f }
            long r15 = r11.currentTimeMillis()     // Catch:{ all -> 0x0a9f }
            java.lang.Long r17 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0a9f }
            r11 = r18
            r12 = r10
            r13 = r8
            r14 = r9
            r8 = r21
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x0a9f }
            r9 = r18
        L_0x02ea:
            com.google.android.gms.measurement.internal.zzak r11 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r11)     // Catch:{ all -> 0x0a9f }
            boolean r11 = r11.zzL(r9)     // Catch:{ all -> 0x0a9f }
            if (r11 != 0) goto L_0x032c
            com.google.android.gms.measurement.internal.zzeh r11 = r34.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzd()     // Catch:{ all -> 0x0a9f }
            java.lang.String r12 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzfr r14 = r1.zzn     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzec r14 = r14.zzj()     // Catch:{ all -> 0x0a9f }
            java.lang.String r15 = r9.zzc     // Catch:{ all -> 0x0a9f }
            java.lang.String r14 = r14.zzf(r15)     // Catch:{ all -> 0x0a9f }
            java.lang.Object r9 = r9.zze     // Catch:{ all -> 0x0a9f }
            r11.zzd(r12, r13, r14, r9)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkw r11 = r34.zzv()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkv r12 = r1.zzE     // Catch:{ all -> 0x0a9f }
            r14 = 9
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzM(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a9f }
            goto L_0x032c
        L_0x0326:
            r33 = r4
            r8 = r21
            goto L_0x0183
        L_0x032c:
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x0a9f }
            boolean r9 = com.google.android.gms.measurement.internal.zzkw.zzah(r9)     // Catch:{ all -> 0x0a9f }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a9f }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0a9f }
            r34.zzv()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzas r11 = r2.zzb     // Catch:{ all -> 0x0a9f }
            if (r11 != 0) goto L_0x0342
            r16 = 0
            goto L_0x0362
        L_0x0342:
            com.google.android.gms.measurement.internal.zzar r12 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x0a9f }
            r12.<init>(r11)     // Catch:{ all -> 0x0a9f }
            r16 = 0
        L_0x0349:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x0a9f }
            if (r13 == 0) goto L_0x0362
            java.lang.String r13 = r12.next()     // Catch:{ all -> 0x0a9f }
            java.lang.Object r13 = r11.zzf(r13)     // Catch:{ all -> 0x0a9f }
            boolean r14 = r13 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0a9f }
            if (r14 == 0) goto L_0x0349
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13     // Catch:{ all -> 0x0a9f }
            int r13 = r13.length     // Catch:{ all -> 0x0a9f }
            long r13 = (long) r13     // Catch:{ all -> 0x0a9f }
            long r16 = r16 + r13
            goto L_0x0349
        L_0x0362:
            r22 = 1
            long r15 = r16 + r22
            com.google.android.gms.measurement.internal.zzak r11 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r11)     // Catch:{ all -> 0x0a9f }
            long r12 = r34.zza()     // Catch:{ all -> 0x0a9f }
            r17 = 1
            r20 = 0
            r21 = 0
            r30 = r5
            r4 = 0
            r14 = r10
            r18 = r9
            r19 = r20
            r20 = r8
            com.google.android.gms.measurement.internal.zzai r11 = r11.zzm(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x0a9f }
            long r12 = r11.zzb     // Catch:{ all -> 0x0a9f }
            r34.zzg()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzj     // Catch:{ all -> 0x0a9f }
            r15 = 0
            java.lang.Object r14 = r14.zza(r15)     // Catch:{ all -> 0x0a9f }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0a9f }
            int r14 = r14.intValue()     // Catch:{ all -> 0x0a9f }
            r31 = r6
            r16 = r7
            long r6 = (long) r14     // Catch:{ all -> 0x0a9f }
            long r12 = r12 - r6
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            r17 = 1000(0x3e8, double:4.94E-321)
            if (r6 <= 0) goto L_0x03d0
            long r12 = r12 % r17
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x03bf
            com.google.android.gms.measurement.internal.zzeh r2 = r34.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a9f }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a9f }
            long r5 = r11.zzb     // Catch:{ all -> 0x0a9f }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a9f }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a9f }
        L_0x03bf:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r2)     // Catch:{ all -> 0x0a9f }
            r2.zzC()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzak(r2)
            r2.zzx()
            return
        L_0x03d0:
            if (r9 == 0) goto L_0x042b
            long r6 = r11.zza     // Catch:{ all -> 0x0a9f }
            r34.zzg()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzdt r12 = com.google.android.gms.measurement.internal.zzdu.zzl     // Catch:{ all -> 0x0a9f }
            java.lang.Object r12 = r12.zza(r15)     // Catch:{ all -> 0x0a9f }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x0a9f }
            int r12 = r12.intValue()     // Catch:{ all -> 0x0a9f }
            long r12 = (long) r12     // Catch:{ all -> 0x0a9f }
            long r6 = r6 - r12
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x042b
            long r6 = r6 % r17
            int r3 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x0406
            com.google.android.gms.measurement.internal.zzeh r3 = r34.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x0a9f }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a9f }
            long r6 = r11.zza     // Catch:{ all -> 0x0a9f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0a9f }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x0a9f }
        L_0x0406:
            com.google.android.gms.measurement.internal.zzkw r11 = r34.zzv()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkv r12 = r1.zzE     // Catch:{ all -> 0x0a9f }
            r14 = 16
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x0a9f }
            r17 = 0
            r13 = r10
            r16 = r2
            r11.zzM(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r2)     // Catch:{ all -> 0x0a9f }
            r2.zzC()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzak(r2)
            r2.zzx()
            return
        L_0x042b:
            r6 = 1000000(0xf4240, float:1.401298E-39)
            if (r8 == 0) goto L_0x0479
            long r7 = r11.zzd     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzaf r12 = r34.zzg()     // Catch:{ all -> 0x0a9f }
            java.lang.String r13 = r3.zza     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzk     // Catch:{ all -> 0x0a9f }
            int r12 = r12.zze(r13, r14)     // Catch:{ all -> 0x0a9f }
            int r12 = java.lang.Math.min(r6, r12)     // Catch:{ all -> 0x0a9f }
            r13 = 0
            int r12 = java.lang.Math.max(r13, r12)     // Catch:{ all -> 0x0a9f }
            long r12 = (long) r12     // Catch:{ all -> 0x0a9f }
            long r7 = r7 - r12
            int r12 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x0479
            int r2 = (r7 > r22 ? 1 : (r7 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x0468
            com.google.android.gms.measurement.internal.zzeh r2 = r34.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a9f }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a9f }
            long r5 = r11.zzd     // Catch:{ all -> 0x0a9f }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a9f }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0a9f }
        L_0x0468:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r2)     // Catch:{ all -> 0x0a9f }
            r2.zzC()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzak(r2)
            r2.zzx()
            return
        L_0x0479:
            com.google.android.gms.measurement.internal.zzas r7 = r2.zzb     // Catch:{ all -> 0x0a9f }
            android.os.Bundle r7 = r7.zzc()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkw r8 = r34.zzv()     // Catch:{ all -> 0x0a9f }
            java.lang.String r11 = "_o"
            java.lang.String r12 = r2.zzc     // Catch:{ all -> 0x0a9f }
            r8.zzN(r7, r11, r12)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkw r8 = r34.zzv()     // Catch:{ all -> 0x0a9f }
            boolean r8 = r8.zzad(r10)     // Catch:{ all -> 0x0a9f }
            java.lang.String r14 = "_r"
            if (r8 == 0) goto L_0x04aa
            com.google.android.gms.measurement.internal.zzkw r8 = r34.zzv()     // Catch:{ all -> 0x0a9f }
            java.lang.Long r11 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0a9f }
            java.lang.String r12 = "_dbg"
            r8.zzN(r7, r12, r11)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkw r8 = r34.zzv()     // Catch:{ all -> 0x0a9f }
            r8.zzN(r7, r14, r11)     // Catch:{ all -> 0x0a9f }
        L_0x04aa:
            java.lang.String r8 = "_s"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0a9f }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0a9f }
            if (r8 == 0) goto L_0x04d2
            com.google.android.gms.measurement.internal.zzak r8 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a9f }
            r12 = r16
            com.google.android.gms.measurement.internal.zzku r8 = r8.zzp(r11, r12)     // Catch:{ all -> 0x0a9f }
            if (r8 == 0) goto L_0x04d2
            java.lang.Object r11 = r8.zze     // Catch:{ all -> 0x0a9f }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0a9f }
            if (r11 == 0) goto L_0x04d2
            com.google.android.gms.measurement.internal.zzkw r11 = r34.zzv()     // Catch:{ all -> 0x0a9f }
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0a9f }
            r11.zzN(r7, r12, r8)     // Catch:{ all -> 0x0a9f }
        L_0x04d2:
            com.google.android.gms.measurement.internal.zzak r8 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r8)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x0a9f }
            r8.zzg()     // Catch:{ all -> 0x0a9f }
            r8.zzW()     // Catch:{ all -> 0x0a9f }
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x0516 }
            com.google.android.gms.measurement.internal.zzfr r12 = r8.zzs     // Catch:{ SQLiteException -> 0x0516 }
            com.google.android.gms.measurement.internal.zzaf r12 = r12.zzf()     // Catch:{ SQLiteException -> 0x0516 }
            com.google.android.gms.measurement.internal.zzdt r13 = com.google.android.gms.measurement.internal.zzdu.zzo     // Catch:{ SQLiteException -> 0x0516 }
            int r12 = r12.zze(r10, r13)     // Catch:{ SQLiteException -> 0x0516 }
            int r6 = java.lang.Math.min(r6, r12)     // Catch:{ SQLiteException -> 0x0516 }
            r13 = 0
            int r6 = java.lang.Math.max(r13, r6)     // Catch:{ SQLiteException -> 0x0512 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0512 }
            r12 = 2
            java.lang.String[] r12 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0512 }
            r12[r13] = r10     // Catch:{ SQLiteException -> 0x0512 }
            r16 = 1
            r12[r16] = r6     // Catch:{ SQLiteException -> 0x0512 }
            java.lang.String r6 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            r4 = r31
            int r5 = r11.delete(r4, r6, r12)     // Catch:{ SQLiteException -> 0x0510 }
            long r5 = (long) r5
            goto L_0x0530
        L_0x0510:
            r0 = move-exception
            goto L_0x051a
        L_0x0512:
            r0 = move-exception
            r4 = r31
            goto L_0x051a
        L_0x0516:
            r0 = move-exception
            r4 = r31
            r13 = 0
        L_0x051a:
            r5 = r0
            com.google.android.gms.measurement.internal.zzfr r6 = r8.zzs     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = "Error deleting over the limit events. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a9f }
            r6.zzc(r8, r11, r5)     // Catch:{ all -> 0x0a9f }
            r5 = 0
        L_0x0530:
            r11 = 0
            int r8 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r8 <= 0) goto L_0x054b
            com.google.android.gms.measurement.internal.zzeh r8 = r34.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzk()     // Catch:{ all -> 0x0a9f }
            java.lang.String r11 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a9f }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0a9f }
            r8.zzc(r11, r12, r5)     // Catch:{ all -> 0x0a9f }
        L_0x054b:
            com.google.android.gms.measurement.internal.zzap r5 = new com.google.android.gms.measurement.internal.zzap     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x0a9f }
            java.lang.String r6 = r2.zzc     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x0a9f }
            long r2 = r2.zzd     // Catch:{ all -> 0x0a9f }
            r18 = 0
            r11 = r5
            r31 = r13
            r13 = r6
            r6 = r14
            r14 = r10
            r32 = r4
            r4 = r15
            r15 = r8
            r16 = r2
            r20 = r7
            r11.<init>((com.google.android.gms.measurement.internal.zzfr) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r2)     // Catch:{ all -> 0x0a9f }
            java.lang.String r3 = r5.zzb     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzaq r2 = r2.zzn(r10, r3)     // Catch:{ all -> 0x0a9f }
            if (r2 != 0) goto L_0x05ee
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r2)     // Catch:{ all -> 0x0a9f }
            long r2 = r2.zzf(r10)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzaf r7 = r34.zzg()     // Catch:{ all -> 0x0a9f }
            int r7 = r7.zzb(r10)     // Catch:{ all -> 0x0a9f }
            long r7 = (long) r7     // Catch:{ all -> 0x0a9f }
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x05d0
            if (r9 == 0) goto L_0x05d0
            com.google.android.gms.measurement.internal.zzeh r2 = r34.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a9f }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzfr r6 = r1.zzn     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzec r6 = r6.zzj()     // Catch:{ all -> 0x0a9f }
            java.lang.String r5 = r5.zzb     // Catch:{ all -> 0x0a9f }
            java.lang.String r5 = r6.zzd(r5)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzaf r6 = r34.zzg()     // Catch:{ all -> 0x0a9f }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x0a9f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0a9f }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkw r11 = r34.zzv()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkv r12 = r1.zzE     // Catch:{ all -> 0x0a9f }
            r14 = 8
            r15 = 0
            r16 = 0
            r17 = 0
            r13 = r10
            r11.zzM(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzak(r2)
            r2.zzx()
            return
        L_0x05d0:
            com.google.android.gms.measurement.internal.zzaq r2 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ all -> 0x0a9f }
            java.lang.String r13 = r5.zzb     // Catch:{ all -> 0x0a9f }
            long r7 = r5.zzd     // Catch:{ all -> 0x0a9f }
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r11 = r2
            r12 = r10
            r20 = r7
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x0a9f }
            goto L_0x05fc
        L_0x05ee:
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzn     // Catch:{ all -> 0x0a9f }
            long r7 = r2.zzf     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzap r5 = r5.zza(r3, r7)     // Catch:{ all -> 0x0a9f }
            long r7 = r5.zzd     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzaq r2 = r2.zzc(r7)     // Catch:{ all -> 0x0a9f }
        L_0x05fc:
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r3)     // Catch:{ all -> 0x0a9f }
            r3.zzE(r2)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzfo r2 = r34.zzaz()     // Catch:{ all -> 0x0a9f }
            r2.zzg()     // Catch:{ all -> 0x0a9f }
            r34.zzB()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r36)     // Catch:{ all -> 0x0a9f }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x0a9f }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x0a9f }
            r3 = r36
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x0a9f }
            boolean r2 = r2.equals(r7)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.internal.measurement.zzfy.zzu()     // Catch:{ all -> 0x0a9f }
            r7 = 1
            r2.zzZ(r7)     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = "android"
            r2.zzV(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a9f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9f }
            if (r8 != 0) goto L_0x0640
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a9f }
            r2.zzA(r8)     // Catch:{ all -> 0x0a9f }
        L_0x0640:
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0a9f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9f }
            if (r8 != 0) goto L_0x064d
            java.lang.String r8 = r3.zzd     // Catch:{ all -> 0x0a9f }
            r2.zzC(r8)     // Catch:{ all -> 0x0a9f }
        L_0x064d:
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0a9f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9f }
            if (r8 != 0) goto L_0x065a
            java.lang.String r8 = r3.zzc     // Catch:{ all -> 0x0a9f }
            r2.zzD(r8)     // Catch:{ all -> 0x0a9f }
        L_0x065a:
            long r8 = r3.zzj     // Catch:{ all -> 0x0a9f }
            r10 = -2147483648(0xffffffff80000000, double:NaN)
            int r10 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r10 == 0) goto L_0x0667
            int r8 = (int) r8     // Catch:{ all -> 0x0a9f }
            r2.zzE(r8)     // Catch:{ all -> 0x0a9f }
        L_0x0667:
            long r8 = r3.zze     // Catch:{ all -> 0x0a9f }
            r2.zzR(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0a9f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9f }
            if (r8 != 0) goto L_0x0679
            java.lang.String r8 = r3.zzb     // Catch:{ all -> 0x0a9f }
            r2.zzQ(r8)     // Catch:{ all -> 0x0a9f }
        L_0x0679:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a9f }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzah r8 = r1.zzh(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.zzb(r9)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzah r8 = r8.zzc(r9)     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = r8.zzh()     // Catch:{ all -> 0x0a9f }
            r2.zzI(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = r2.zzal()     // Catch:{ all -> 0x0a9f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9f }
            if (r8 == 0) goto L_0x06ad
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0a9f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9f }
            if (r8 != 0) goto L_0x06ad
            java.lang.String r8 = r3.zzq     // Catch:{ all -> 0x0a9f }
            r2.zzy(r8)     // Catch:{ all -> 0x0a9f }
        L_0x06ad:
            long r8 = r3.zzf     // Catch:{ all -> 0x0a9f }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x06b8
            r2.zzJ(r8)     // Catch:{ all -> 0x0a9f }
        L_0x06b8:
            long r8 = r3.zzs     // Catch:{ all -> 0x0a9f }
            r2.zzM(r8)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkr r8 = r1.zzi     // Catch:{ all -> 0x0a9f }
            zzak(r8)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkp r9 = r8.zzf     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzfr r9 = r9.zzn     // Catch:{ all -> 0x0a9f }
            android.content.Context r9 = r9.zzau()     // Catch:{ all -> 0x0a9f }
            java.util.Map r9 = com.google.android.gms.measurement.internal.zzdu.zzc(r9)     // Catch:{ all -> 0x0a9f }
            if (r9 == 0) goto L_0x0754
            int r10 = r9.size()     // Catch:{ all -> 0x0a9f }
            if (r10 != 0) goto L_0x06d8
            goto L_0x0754
        L_0x06d8:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x0a9f }
            r14.<init>()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzO     // Catch:{ all -> 0x0a9f }
            java.lang.Object r10 = r10.zza(r4)     // Catch:{ all -> 0x0a9f }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0a9f }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0a9f }
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x0a9f }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0a9f }
        L_0x06f1:
            boolean r11 = r9.hasNext()     // Catch:{ all -> 0x0a9f }
            if (r11 == 0) goto L_0x074e
            java.lang.Object r11 = r9.next()     // Catch:{ all -> 0x0a9f }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0a9f }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0a9f }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0a9f }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x0a9f }
            if (r12 == 0) goto L_0x06f1
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x073c }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x073c }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x073c }
            if (r11 == 0) goto L_0x06f1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x073c }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x073c }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x073c }
            if (r11 < r10) goto L_0x06f1
            com.google.android.gms.measurement.internal.zzfr r11 = r8.zzs     // Catch:{ NumberFormatException -> 0x073c }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzay()     // Catch:{ NumberFormatException -> 0x073c }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzk()     // Catch:{ NumberFormatException -> 0x073c }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x073c }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x073c }
            r11.zzb(r12, r13)     // Catch:{ NumberFormatException -> 0x073c }
            goto L_0x074e
        L_0x073c:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfr r12 = r8.zzs     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzk()     // Catch:{ all -> 0x0a9f }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.zzb(r13, r11)     // Catch:{ all -> 0x0a9f }
            goto L_0x06f1
        L_0x074e:
            int r8 = r14.size()     // Catch:{ all -> 0x0a9f }
            if (r8 != 0) goto L_0x0755
        L_0x0754:
            r14 = r4
        L_0x0755:
            if (r14 == 0) goto L_0x075a
            r2.zzh(r14)     // Catch:{ all -> 0x0a9f }
        L_0x075a:
            java.lang.String r8 = r3.zza     // Catch:{ all -> 0x0a9f }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzah r8 = r1.zzh(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.zzb(r9)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzah r8 = r8.zzc(r9)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzag r9 = com.google.android.gms.measurement.internal.zzag.AD_STORAGE     // Catch:{ all -> 0x0a9f }
            boolean r9 = r8.zzi(r9)     // Catch:{ all -> 0x0a9f }
            if (r9 == 0) goto L_0x07a4
            com.google.android.gms.measurement.internal.zzjm r9 = r1.zzk     // Catch:{ all -> 0x0a9f }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a9f }
            android.util.Pair r9 = r9.zzd(r10, r8)     // Catch:{ all -> 0x0a9f }
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0a9f }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x0a9f }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0a9f }
            if (r10 != 0) goto L_0x07a4
            boolean r10 = r3.zzo     // Catch:{ all -> 0x0a9f }
            if (r10 == 0) goto L_0x07a4
            java.lang.Object r10 = r9.first     // Catch:{ all -> 0x0a9f }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0a9f }
            r2.zzaa(r10)     // Catch:{ all -> 0x0a9f }
            java.lang.Object r10 = r9.second     // Catch:{ all -> 0x0a9f }
            if (r10 == 0) goto L_0x07a4
            java.lang.Object r9 = r9.second     // Catch:{ all -> 0x0a9f }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0a9f }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0a9f }
            r2.zzT(r9)     // Catch:{ all -> 0x0a9f }
        L_0x07a4:
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzao r9 = r9.zzg()     // Catch:{ all -> 0x0a9f }
            r9.zzu()     // Catch:{ all -> 0x0a9f }
            java.lang.String r9 = android.os.Build.MODEL     // Catch:{ all -> 0x0a9f }
            r2.zzK(r9)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzao r9 = r9.zzg()     // Catch:{ all -> 0x0a9f }
            r9.zzu()     // Catch:{ all -> 0x0a9f }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0a9f }
            r2.zzU(r9)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzao r9 = r9.zzg()     // Catch:{ all -> 0x0a9f }
            long r9 = r9.zzb()     // Catch:{ all -> 0x0a9f }
            int r9 = (int) r9     // Catch:{ all -> 0x0a9f }
            r2.zzae(r9)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzao r9 = r9.zzg()     // Catch:{ all -> 0x0a9f }
            java.lang.String r9 = r9.zzc()     // Catch:{ all -> 0x0a9f }
            r2.zzai(r9)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzaf r9 = r34.zzg()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzah     // Catch:{ all -> 0x0a9f }
            boolean r9 = r9.zzs(r4, r10)     // Catch:{ all -> 0x0a9f }
            if (r9 != 0) goto L_0x07ec
            long r9 = r3.zzl     // Catch:{ all -> 0x0a9f }
            r2.zzz(r9)     // Catch:{ all -> 0x0a9f }
        L_0x07ec:
            com.google.android.gms.measurement.internal.zzfr r9 = r1.zzn     // Catch:{ all -> 0x0a9f }
            boolean r9 = r9.zzJ()     // Catch:{ all -> 0x0a9f }
            if (r9 == 0) goto L_0x0800
            r2.zzak()     // Catch:{ all -> 0x0a9f }
            boolean r9 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0a9f }
            if (r9 != 0) goto L_0x0800
            r2.zzL(r4)     // Catch:{ all -> 0x0a9f }
        L_0x0800:
            com.google.android.gms.measurement.internal.zzak r9 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r9)     // Catch:{ all -> 0x0a9f }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzg r9 = r9.zzj(r10)     // Catch:{ all -> 0x0a9f }
            if (r9 != 0) goto L_0x0881
            com.google.android.gms.measurement.internal.zzg r9 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzn     // Catch:{ all -> 0x0a9f }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a9f }
            r9.<init>(r10, r11)     // Catch:{ all -> 0x0a9f }
            java.lang.String r10 = r1.zzw(r8)     // Catch:{ all -> 0x0a9f }
            r9.zzH(r10)     // Catch:{ all -> 0x0a9f }
            java.lang.String r10 = r3.zzk     // Catch:{ all -> 0x0a9f }
            r9.zzV(r10)     // Catch:{ all -> 0x0a9f }
            java.lang.String r10 = r3.zzb     // Catch:{ all -> 0x0a9f }
            r9.zzW(r10)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzag r10 = com.google.android.gms.measurement.internal.zzag.AD_STORAGE     // Catch:{ all -> 0x0a9f }
            boolean r10 = r8.zzi(r10)     // Catch:{ all -> 0x0a9f }
            if (r10 == 0) goto L_0x083a
            com.google.android.gms.measurement.internal.zzjm r10 = r1.zzk     // Catch:{ all -> 0x0a9f }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x0a9f }
            java.lang.String r10 = r10.zzf(r11)     // Catch:{ all -> 0x0a9f }
            r9.zzae(r10)     // Catch:{ all -> 0x0a9f }
        L_0x083a:
            r10 = 0
            r9.zzaa(r10)     // Catch:{ all -> 0x0a9f }
            r9.zzab(r10)     // Catch:{ all -> 0x0a9f }
            r9.zzZ(r10)     // Catch:{ all -> 0x0a9f }
            java.lang.String r10 = r3.zzc     // Catch:{ all -> 0x0a9f }
            r9.zzJ(r10)     // Catch:{ all -> 0x0a9f }
            long r10 = r3.zzj     // Catch:{ all -> 0x0a9f }
            r9.zzK(r10)     // Catch:{ all -> 0x0a9f }
            java.lang.String r10 = r3.zzd     // Catch:{ all -> 0x0a9f }
            r9.zzI(r10)     // Catch:{ all -> 0x0a9f }
            long r10 = r3.zze     // Catch:{ all -> 0x0a9f }
            r9.zzX(r10)     // Catch:{ all -> 0x0a9f }
            long r10 = r3.zzf     // Catch:{ all -> 0x0a9f }
            r9.zzS(r10)     // Catch:{ all -> 0x0a9f }
            boolean r10 = r3.zzh     // Catch:{ all -> 0x0a9f }
            r9.zzac(r10)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzaf r10 = r34.zzg()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzdt r11 = com.google.android.gms.measurement.internal.zzdu.zzah     // Catch:{ all -> 0x0a9f }
            boolean r10 = r10.zzs(r4, r11)     // Catch:{ all -> 0x0a9f }
            if (r10 != 0) goto L_0x0874
            long r10 = r3.zzl     // Catch:{ all -> 0x0a9f }
            r9.zzG(r10)     // Catch:{ all -> 0x0a9f }
        L_0x0874:
            long r10 = r3.zzs     // Catch:{ all -> 0x0a9f }
            r9.zzT(r10)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r10 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r10)     // Catch:{ all -> 0x0a9f }
            r10.zzD(r9)     // Catch:{ all -> 0x0a9f }
        L_0x0881:
            com.google.android.gms.measurement.internal.zzag r10 = com.google.android.gms.measurement.internal.zzag.ANALYTICS_STORAGE     // Catch:{ all -> 0x0a9f }
            boolean r8 = r8.zzi(r10)     // Catch:{ all -> 0x0a9f }
            if (r8 == 0) goto L_0x08a0
            java.lang.String r8 = r9.zzu()     // Catch:{ all -> 0x0a9f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9f }
            if (r8 != 0) goto L_0x08a0
            java.lang.String r8 = r9.zzu()     // Catch:{ all -> 0x0a9f }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a9f }
            r2.zzB(r8)     // Catch:{ all -> 0x0a9f }
        L_0x08a0:
            java.lang.String r8 = r9.zzx()     // Catch:{ all -> 0x0a9f }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0a9f }
            if (r8 != 0) goto L_0x08b7
            java.lang.String r8 = r9.zzx()     // Catch:{ all -> 0x0a9f }
            java.lang.Object r8 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0a9f }
            r2.zzP(r8)     // Catch:{ all -> 0x0a9f }
        L_0x08b7:
            com.google.android.gms.measurement.internal.zzak r8 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x0a9f }
            java.util.List r3 = r8.zzu(r3)     // Catch:{ all -> 0x0a9f }
            r13 = r31
        L_0x08c4:
            int r8 = r3.size()     // Catch:{ all -> 0x0a9f }
            if (r13 >= r8) goto L_0x08fa
            com.google.android.gms.internal.measurement.zzgg r8 = com.google.android.gms.internal.measurement.zzgh.zzd()     // Catch:{ all -> 0x0a9f }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzku r9 = (com.google.android.gms.measurement.internal.zzku) r9     // Catch:{ all -> 0x0a9f }
            java.lang.String r9 = r9.zzc     // Catch:{ all -> 0x0a9f }
            r8.zzf(r9)     // Catch:{ all -> 0x0a9f }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzku r9 = (com.google.android.gms.measurement.internal.zzku) r9     // Catch:{ all -> 0x0a9f }
            long r9 = r9.zzd     // Catch:{ all -> 0x0a9f }
            r8.zzg(r9)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkr r9 = r1.zzi     // Catch:{ all -> 0x0a9f }
            zzak(r9)     // Catch:{ all -> 0x0a9f }
            java.lang.Object r10 = r3.get(r13)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzku r10 = (com.google.android.gms.measurement.internal.zzku) r10     // Catch:{ all -> 0x0a9f }
            java.lang.Object r10 = r10.zze     // Catch:{ all -> 0x0a9f }
            r9.zzu(r8, r10)     // Catch:{ all -> 0x0a9f }
            r2.zzk(r8)     // Catch:{ all -> 0x0a9f }
            int r13 = r13 + 1
            goto L_0x08c4
        L_0x08fa:
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze     // Catch:{ IOException -> 0x0a55 }
            zzak(r3)     // Catch:{ IOException -> 0x0a55 }
            com.google.android.gms.internal.measurement.zzjx r8 = r2.zzay()     // Catch:{ IOException -> 0x0a55 }
            com.google.android.gms.internal.measurement.zzfy r8 = (com.google.android.gms.internal.measurement.zzfy) r8     // Catch:{ IOException -> 0x0a55 }
            r3.zzg()     // Catch:{ IOException -> 0x0a55 }
            r3.zzW()     // Catch:{ IOException -> 0x0a55 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ IOException -> 0x0a55 }
            java.lang.String r9 = r8.zzy()     // Catch:{ IOException -> 0x0a55 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ IOException -> 0x0a55 }
            byte[] r9 = r8.zzbq()     // Catch:{ IOException -> 0x0a55 }
            com.google.android.gms.measurement.internal.zzkp r10 = r3.zzf     // Catch:{ IOException -> 0x0a55 }
            com.google.android.gms.measurement.internal.zzkr r10 = r10.zzi     // Catch:{ IOException -> 0x0a55 }
            zzak(r10)     // Catch:{ IOException -> 0x0a55 }
            long r10 = r10.zzd(r9)     // Catch:{ IOException -> 0x0a55 }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ IOException -> 0x0a55 }
            r12.<init>()     // Catch:{ IOException -> 0x0a55 }
            java.lang.String r13 = r8.zzy()     // Catch:{ IOException -> 0x0a55 }
            r14 = r30
            r12.put(r14, r13)     // Catch:{ IOException -> 0x0a55 }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0a55 }
            r15 = r33
            r12.put(r15, r13)     // Catch:{ IOException -> 0x0a55 }
            java.lang.String r13 = "metadata"
            r12.put(r13, r9)     // Catch:{ IOException -> 0x0a55 }
            android.database.sqlite.SQLiteDatabase r9 = r3.zzh()     // Catch:{ SQLiteException -> 0x0a3b }
            java.lang.String r13 = "raw_events_metadata"
            r7 = 4
            r9.insertWithOnConflict(r13, r4, r12, r7)     // Catch:{ SQLiteException -> 0x0a3b }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r2)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzas r3 = r5.zzf     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzar r7 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x0a9f }
            r7.<init>(r3)     // Catch:{ all -> 0x0a9f }
        L_0x0956:
            boolean r3 = r7.hasNext()     // Catch:{ all -> 0x0a9f }
            if (r3 == 0) goto L_0x0968
            java.lang.String r3 = r7.next()     // Catch:{ all -> 0x0a9f }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0a9f }
            if (r3 == 0) goto L_0x0956
        L_0x0966:
            r13 = 1
            goto L_0x09aa
        L_0x0968:
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc     // Catch:{ all -> 0x0a9f }
            zzak(r3)     // Catch:{ all -> 0x0a9f }
            java.lang.String r6 = r5.zza     // Catch:{ all -> 0x0a9f }
            java.lang.String r7 = r5.zzb     // Catch:{ all -> 0x0a9f }
            boolean r3 = r3.zzn(r6, r7)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r6 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r6)     // Catch:{ all -> 0x0a9f }
            long r17 = r34.zza()     // Catch:{ all -> 0x0a9f }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0a9f }
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r16 = r6
            r19 = r7
            com.google.android.gms.measurement.internal.zzai r6 = r16.zzl(r17, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x0a9f }
            if (r3 == 0) goto L_0x09a8
            long r6 = r6.zze     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzaf r3 = r34.zzg()     // Catch:{ all -> 0x0a9f }
            java.lang.String r8 = r5.zza     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzdt r9 = com.google.android.gms.measurement.internal.zzdu.zzn     // Catch:{ all -> 0x0a9f }
            int r3 = r3.zze(r8, r9)     // Catch:{ all -> 0x0a9f }
            long r8 = (long) r3     // Catch:{ all -> 0x0a9f }
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x09a8
            goto L_0x0966
        L_0x09a8:
            r13 = r31
        L_0x09aa:
            r2.zzg()     // Catch:{ all -> 0x0a9f }
            r2.zzW()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0a9f }
            java.lang.String r3 = r5.zza     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkp r3 = r2.zzf     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzkr r3 = r3.zzi     // Catch:{ all -> 0x0a9f }
            zzak(r3)     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.internal.measurement.zzfo r3 = r3.zzj(r5)     // Catch:{ all -> 0x0a9f }
            byte[] r3 = r3.zzbq()     // Catch:{ all -> 0x0a9f }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ all -> 0x0a9f }
            r6.<init>()     // Catch:{ all -> 0x0a9f }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x0a9f }
            r6.put(r14, r7)     // Catch:{ all -> 0x0a9f }
            java.lang.String r7 = "name"
            java.lang.String r8 = r5.zzb     // Catch:{ all -> 0x0a9f }
            r6.put(r7, r8)     // Catch:{ all -> 0x0a9f }
            java.lang.String r7 = "timestamp"
            long r8 = r5.zzd     // Catch:{ all -> 0x0a9f }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0a9f }
            r6.put(r7, r8)     // Catch:{ all -> 0x0a9f }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0a9f }
            r6.put(r15, r7)     // Catch:{ all -> 0x0a9f }
            java.lang.String r7 = "data"
            r6.put(r7, r3)     // Catch:{ all -> 0x0a9f }
            java.lang.String r3 = "realtime"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x0a9f }
            r6.put(r3, r7)     // Catch:{ all -> 0x0a9f }
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ SQLiteException -> 0x0a23 }
            r7 = r32
            long r3 = r3.insert(r7, r4, r6)     // Catch:{ SQLiteException -> 0x0a23 }
            r6 = -1
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0a1e
            com.google.android.gms.measurement.internal.zzfr r3 = r2.zzs     // Catch:{ SQLiteException -> 0x0a23 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x0a23 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x0a23 }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r6 = r5.zza     // Catch:{ SQLiteException -> 0x0a23 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x0a23 }
            r3.zzb(r4, r6)     // Catch:{ SQLiteException -> 0x0a23 }
            goto L_0x0a6c
        L_0x0a1e:
            r3 = 0
            r1.zza = r3     // Catch:{ all -> 0x0a9f }
            goto L_0x0a6c
        L_0x0a23:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzs     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0a9f }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x0a9f }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ all -> 0x0a9f }
            r2.zzc(r4, r5, r3)     // Catch:{ all -> 0x0a9f }
            goto L_0x0a6c
        L_0x0a3b:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzs     // Catch:{ IOException -> 0x0a55 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ IOException -> 0x0a55 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ IOException -> 0x0a55 }
            java.lang.String r5 = "Error storing raw event metadata. appId"
            java.lang.String r6 = r8.zzy()     // Catch:{ IOException -> 0x0a55 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ IOException -> 0x0a55 }
            r3.zzc(r5, r6, r4)     // Catch:{ IOException -> 0x0a55 }
            throw r4     // Catch:{ IOException -> 0x0a55 }
        L_0x0a55:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzeh r4 = r34.zzay()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x0a9f }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzak()     // Catch:{ all -> 0x0a9f }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r2)     // Catch:{ all -> 0x0a9f }
            r4.zzc(r5, r2, r3)     // Catch:{ all -> 0x0a9f }
        L_0x0a6c:
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze     // Catch:{ all -> 0x0a9f }
            zzak(r2)     // Catch:{ all -> 0x0a9f }
            r2.zzC()     // Catch:{ all -> 0x0a9f }
            com.google.android.gms.measurement.internal.zzak r2 = r1.zze
            zzak(r2)
            r2.zzx()
            r34.zzaf()
            com.google.android.gms.measurement.internal.zzeh r2 = r34.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0a9f:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzak r3 = r1.zze
            zzak(r3)
            r3.zzx()
            throw r2
        L_0x0aaa:
            r1.zzd(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzX(com.google.android.gms.measurement.internal.zzau, com.google.android.gms.measurement.internal.zzp):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzY() {
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzs.zzf();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzn.zzau().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzx = channel;
                FileLock tryLock = channel.tryLock();
                this.zzw = tryLock;
                if (tryLock != null) {
                    zzay().zzj().zza("Storage concurrent access okay");
                    return true;
                }
                zzay().zzd().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzay().zzd().zzb("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzay().zzd().zzb("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzay().zzk().zzb("Storage lock already acquired", e3);
                return false;
            }
        } else {
            zzay().zzj().zza("Storage concurrent access okay");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        long currentTimeMillis = zzav().currentTimeMillis();
        zzjm zzjm = this.zzk;
        zzjm.zzW();
        zzjm.zzg();
        long zza2 = zzjm.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzjm.zzs.zzv().zzF().nextInt(86400000)) + 1;
            zzjm.zze.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    public final Context zzau() {
        return this.zzn.zzau();
    }

    public final Clock zzav() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzav();
    }

    public final zzaa zzaw() {
        throw null;
    }

    public final zzeh zzay() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzay();
    }

    public final zzfo zzaz() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzaz();
    }

    /* access modifiers changed from: package-private */
    public final zzg zzd(zzp zzp2) {
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzp2);
        Preconditions.checkNotEmpty(zzp2.zza);
        zzak zzak = this.zze;
        zzak(zzak);
        zzg zzj2 = zzak.zzj(zzp2.zza);
        zzah zzc2 = zzh(zzp2.zza).zzc(zzah.zzb(zzp2.zzv));
        String zzf2 = zzc2.zzi(zzag.AD_STORAGE) ? this.zzk.zzf(zzp2.zza) : "";
        if (zzj2 == null) {
            zzj2 = new zzg(this.zzn, zzp2.zza);
            if (zzc2.zzi(zzag.ANALYTICS_STORAGE)) {
                zzj2.zzH(zzw(zzc2));
            }
            if (zzc2.zzi(zzag.AD_STORAGE)) {
                zzj2.zzae(zzf2);
            }
        } else if (zzc2.zzi(zzag.AD_STORAGE) && zzf2 != null && !zzf2.equals(zzj2.zzA())) {
            zzj2.zzae(zzf2);
            zzmt.zzc();
            if (!zzg().zzs((String) null, zzdu.zzan) || !zzg().zzs((String) null, zzdu.zzas)) {
                zzj2.zzH(zzw(zzc2));
            } else if (!"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzp2.zza, zzc2).first)) {
                zzj2.zzH(zzw(zzc2));
            }
            zzmt.zzc();
            if (zzg().zzs((String) null, zzdu.zzan) && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzp2.zza, zzc2).first)) {
                zzak zzak2 = this.zze;
                zzak(zzak2);
                if (zzak2.zzp(zzp2.zza, "_id") != null) {
                    zzak zzak3 = this.zze;
                    zzak(zzak3);
                    if (zzak3.zzp(zzp2.zza, "_lair") == null) {
                        zzku zzku = new zzku(zzp2.zza, "auto", "_lair", zzav().currentTimeMillis(), 1L);
                        zzak zzak4 = this.zze;
                        zzak(zzak4);
                        zzak4.zzL(zzku);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzj2.zzu()) && zzc2.zzi(zzag.ANALYTICS_STORAGE)) {
            zzj2.zzH(zzw(zzc2));
        }
        zzj2.zzW(zzp2.zzb);
        zzj2.zzE(zzp2.zzq);
        if (!TextUtils.isEmpty(zzp2.zzk)) {
            zzj2.zzV(zzp2.zzk);
        }
        long j = zzp2.zze;
        if (j != 0) {
            zzj2.zzX(j);
        }
        if (!TextUtils.isEmpty(zzp2.zzc)) {
            zzj2.zzJ(zzp2.zzc);
        }
        zzj2.zzK(zzp2.zzj);
        String str = zzp2.zzd;
        if (str != null) {
            zzj2.zzI(str);
        }
        zzj2.zzS(zzp2.zzf);
        zzj2.zzac(zzp2.zzh);
        if (!TextUtils.isEmpty(zzp2.zzg)) {
            zzj2.zzY(zzp2.zzg);
        }
        if (!zzg().zzs((String) null, zzdu.zzah)) {
            zzj2.zzG(zzp2.zzl);
        }
        zzj2.zzF(zzp2.zzo);
        zzj2.zzad(zzp2.zzr);
        zzj2.zzT(zzp2.zzs);
        zzno.zzc();
        if (zzg().zzs((String) null, zzdu.zzax)) {
            zzj2.zzaf(zzp2.zzt);
        } else {
            zzno.zzc();
            if (zzg().zzs((String) null, zzdu.zzaw)) {
                zzj2.zzaf((List) null);
            }
        }
        if (zzj2.zzai()) {
            zzak zzak5 = this.zze;
            zzak(zzak5);
            zzak5.zzD(zzj2);
        }
        return zzj2;
    }

    public final zzz zzf() {
        zzz zzz2 = this.zzh;
        zzak(zzz2);
        return zzz2;
    }

    public final zzaf zzg() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    /* access modifiers changed from: package-private */
    public final zzah zzh(String str) {
        String str2;
        zzah zzah = zzah.zza;
        zzaz().zzg();
        zzB();
        zzah zzah2 = (zzah) this.zzB.get(str);
        if (zzah2 != null) {
            return zzah2;
        }
        zzak zzak = this.zze;
        zzak(zzak);
        Preconditions.checkNotNull(str);
        zzak.zzg();
        zzak.zzW();
        Cursor cursor = null;
        try {
            Cursor rawQuery = zzak.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                str2 = "G1";
            }
            zzah zzb2 = zzah.zzb(str2);
            zzU(str, zzb2);
            return zzb2;
        } catch (SQLiteException e) {
            zzak.zzs.zzay().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzak zzi() {
        zzak zzak = this.zze;
        zzak(zzak);
        return zzak;
    }

    public final zzec zzj() {
        return this.zzn.zzj();
    }

    public final zzen zzl() {
        zzen zzen = this.zzd;
        zzak(zzen);
        return zzen;
    }

    public final zzep zzm() {
        zzep zzep = this.zzf;
        if (zzep != null) {
            return zzep;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfi zzo() {
        zzfi zzfi = this.zzc;
        zzak(zzfi);
        return zzfi;
    }

    /* access modifiers changed from: package-private */
    public final zzfr zzq() {
        return this.zzn;
    }

    public final zzib zzr() {
        zzib zzib = this.zzj;
        zzak(zzib);
        return zzib;
    }

    public final zzjm zzs() {
        return this.zzk;
    }

    public final zzkr zzu() {
        zzkr zzkr = this.zzi;
        zzak(zzkr);
        return zzkr;
    }

    public final zzkw zzv() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    /* access modifiers changed from: package-private */
    public final String zzw(zzah zzah) {
        if (!zzah.zzi(zzag.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzF().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final String zzx(zzp zzp2) {
        try {
            return (String) zzaz().zzh(new zzkk(this, zzp2)).get(GTJobService.WAIT_TIME, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzay().zzd().zzc("Failed to get app instance id. appId", zzeh.zzn(zzp2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzz(Runnable runnable) {
        zzaz().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
