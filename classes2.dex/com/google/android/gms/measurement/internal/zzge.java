package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgh;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzge implements Callable {
    final /* synthetic */ zzau zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgj zzc;

    zzge(zzgj zzgj, zzau zzau, String str) {
        this.zzc = zzgj;
        this.zza = zzau;
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        byte[] bArr;
        zzkp zzkp;
        zzku zzku;
        Bundle bundle;
        zzfv zzfv;
        zzfx zzfx;
        String str;
        Object obj;
        zzg zzg;
        long j;
        zzaq zzaq;
        this.zzc.zza.zzA();
        zzib zzr = this.zzc.zza.zzr();
        zzau zzau = this.zza;
        String str2 = this.zzb;
        zzr.zzg();
        zzfr.zzO();
        Preconditions.checkNotNull(zzau);
        Preconditions.checkNotEmpty(str2);
        if (!zzr.zzs.zzf().zzs(str2, zzdu.zzS)) {
            zzr.zzs.zzay().zzc().zzb("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        } else if ("_iap".equals(zzau.zza) || "_iapx".equals(zzau.zza)) {
            zzfv zza2 = zzfw.zza();
            zzr.zzf.zzi().zzw();
            zzg zzj = zzr.zzf.zzi().zzj(str2);
            if (zzj == null) {
                zzr.zzs.zzay().zzc().zzb("Log and bundle not available. package_name", str2);
                bArr = new byte[0];
                zzkp = zzr.zzf;
            } else if (!zzj.zzah()) {
                zzr.zzs.zzay().zzc().zzb("Log and bundle disabled. package_name", str2);
                bArr = new byte[0];
                zzkp = zzr.zzf;
            } else {
                zzfx zzu = zzfy.zzu();
                zzu.zzZ(1);
                zzu.zzV("android");
                if (!TextUtils.isEmpty(zzj.zzt())) {
                    zzu.zzA(zzj.zzt());
                }
                if (!TextUtils.isEmpty(zzj.zzv())) {
                    zzu.zzC((String) Preconditions.checkNotNull(zzj.zzv()));
                }
                if (!TextUtils.isEmpty(zzj.zzw())) {
                    zzu.zzD((String) Preconditions.checkNotNull(zzj.zzw()));
                }
                if (zzj.zzb() != -2147483648L) {
                    zzu.zzE((int) zzj.zzb());
                }
                zzu.zzR(zzj.zzm());
                zzu.zzM(zzj.zzk());
                String zzy = zzj.zzy();
                String zzr2 = zzj.zzr();
                if (!TextUtils.isEmpty(zzy)) {
                    zzu.zzQ(zzy);
                } else if (!TextUtils.isEmpty(zzr2)) {
                    zzu.zzy(zzr2);
                }
                zzah zzh = zzr.zzf.zzh(str2);
                zzu.zzJ(zzj.zzj());
                if (zzr.zzs.zzJ() && zzr.zzs.zzf().zzt(zzu.zzak()) && zzh.zzi(zzag.AD_STORAGE) && !TextUtils.isEmpty((CharSequence) null)) {
                    zzu.zzL((String) null);
                }
                zzu.zzI(zzh.zzh());
                if (zzh.zzi(zzag.AD_STORAGE)) {
                    Pair zzd = zzr.zzf.zzs().zzd(zzj.zzt(), zzh);
                    if (zzj.zzag() && !TextUtils.isEmpty((CharSequence) zzd.first)) {
                        try {
                            zzu.zzaa(zzib.zza((String) zzd.first, Long.toString(zzau.zzd)));
                            if (zzd.second != null) {
                                zzu.zzT(((Boolean) zzd.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzr.zzs.zzay().zzc().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzkp = zzr.zzf;
                        } catch (Throwable th) {
                            zzr.zzf.zzi().zzx();
                            throw th;
                        }
                    }
                }
                zzr.zzs.zzg().zzu();
                zzu.zzK(Build.MODEL);
                zzr.zzs.zzg().zzu();
                zzu.zzU(Build.VERSION.RELEASE);
                zzu.zzae((int) zzr.zzs.zzg().zzb());
                zzu.zzai(zzr.zzs.zzg().zzc());
                try {
                    if (zzh.zzi(zzag.ANALYTICS_STORAGE) && zzj.zzu() != null) {
                        zzu.zzB(zzib.zza((String) Preconditions.checkNotNull(zzj.zzu()), Long.toString(zzau.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzj.zzx())) {
                        zzu.zzP((String) Preconditions.checkNotNull(zzj.zzx()));
                    }
                    String zzt = zzj.zzt();
                    List zzu2 = zzr.zzf.zzi().zzu(zzt);
                    Iterator it = zzu2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzku = null;
                            break;
                        }
                        zzku = (zzku) it.next();
                        if ("_lte".equals(zzku.zzc)) {
                            break;
                        }
                    }
                    if (zzku == null || zzku.zze == null) {
                        zzku zzku2 = new zzku(zzt, "auto", "_lte", zzr.zzs.zzav().currentTimeMillis(), 0L);
                        zzu2.add(zzku2);
                        zzr.zzf.zzi().zzL(zzku2);
                    }
                    zzkr zzu3 = zzr.zzf.zzu();
                    zzu3.zzs.zzay().zzj().zza("Checking account type status for ad personalization signals");
                    if (zzu3.zzs.zzg().zze()) {
                        String zzt2 = zzj.zzt();
                        Preconditions.checkNotNull(zzt2);
                        if (zzj.zzag() && zzu3.zzf.zzo().zzk(zzt2)) {
                            zzu3.zzs.zzay().zzc().zza("Turning off ad personalization due to account type");
                            Iterator it2 = zzu2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                } else if ("_npa".equals(((zzku) it2.next()).zzc)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            zzu2.add(new zzku(zzt2, "auto", "_npa", zzu3.zzs.zzav().currentTimeMillis(), 1L));
                        }
                    }
                    zzgh[] zzghArr = new zzgh[zzu2.size()];
                    for (int i = 0; i < zzu2.size(); i++) {
                        zzgg zzd2 = zzgh.zzd();
                        zzd2.zzf(((zzku) zzu2.get(i)).zzc);
                        zzd2.zzg(((zzku) zzu2.get(i)).zzd);
                        zzr.zzf.zzu().zzu(zzd2, ((zzku) zzu2.get(i)).zze);
                        zzghArr[i] = (zzgh) zzd2.zzay();
                    }
                    zzu.zzi(Arrays.asList(zzghArr));
                    zzei zzb2 = zzei.zzb(zzau);
                    zzr.zzs.zzv().zzK(zzb2.zzd, zzr.zzf.zzi().zzi(str2));
                    zzr.zzs.zzv().zzL(zzb2, zzr.zzs.zzf().zzd(str2));
                    Bundle bundle2 = zzb2.zzd;
                    bundle2.putLong("_c", 1);
                    zzr.zzs.zzay().zzc().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1);
                    bundle2.putString("_o", zzau.zzc);
                    if (zzr.zzs.zzv().zzad(zzu.zzak())) {
                        zzr.zzs.zzv().zzN(bundle2, "_dbg", 1L);
                        zzr.zzs.zzv().zzN(bundle2, "_r", 1L);
                    }
                    zzaq zzn = zzr.zzf.zzi().zzn(str2, zzau.zza);
                    if (zzn == null) {
                        zzfx = zzu;
                        zzg = zzj;
                        zzfv = zza2;
                        str = str2;
                        bundle = bundle2;
                        obj = null;
                        zzaq = new zzaq(str2, zzau.zza, 0, 0, 0, zzau.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j = 0;
                    } else {
                        zzg = zzj;
                        zzfv = zza2;
                        str = str2;
                        bundle = bundle2;
                        zzfx = zzu;
                        obj = null;
                        long j2 = zzn.zzf;
                        zzaq = zzn.zzc(zzau.zzd);
                        j = j2;
                    }
                    zzr.zzf.zzi().zzE(zzaq);
                    zzap zzap = new zzap(zzr.zzs, zzau.zzc, str, zzau.zza, zzau.zzd, j, bundle);
                    zzfn zze = zzfo.zze();
                    zze.zzm(zzap.zzd);
                    zze.zzi(zzap.zzb);
                    zze.zzl(zzap.zze);
                    zzar zzar = new zzar(zzap.zzf);
                    while (zzar.hasNext()) {
                        String zza3 = zzar.next();
                        zzfr zze2 = zzfs.zze();
                        zze2.zzj(zza3);
                        Object zzf = zzap.zzf.zzf(zza3);
                        if (zzf != null) {
                            zzr.zzf.zzu().zzt(zze2, zzf);
                            zze.zze(zze2);
                        }
                    }
                    zzfx zzfx2 = zzfx;
                    zzfx2.zzj(zze);
                    zzfz zza4 = zzgb.zza();
                    zzfp zza5 = zzfq.zza();
                    zza5.zza(zzaq.zzc);
                    zza5.zzb(zzau.zza);
                    zza4.zza(zza5);
                    zzfx2.zzW(zza4);
                    zzfx2.zzf(zzr.zzf.zzf().zza(zzg.zzt(), Collections.emptyList(), zzfx2.zzan(), Long.valueOf(zze.zzc()), Long.valueOf(zze.zzc())));
                    if (zze.zzq()) {
                        zzfx2.zzad(zze.zzc());
                        zzfx2.zzN(zze.zzc());
                    }
                    long zzn2 = zzg.zzn();
                    int i2 = (zzn2 > 0 ? 1 : (zzn2 == 0 ? 0 : -1));
                    if (i2 != 0) {
                        zzfx2.zzX(zzn2);
                    }
                    long zzp = zzg.zzp();
                    if (zzp != 0) {
                        zzfx2.zzY(zzp);
                    } else if (i2 != 0) {
                        zzfx2.zzY(zzn2);
                    }
                    zzg.zzD();
                    zzfx2.zzF((int) zzg.zzo());
                    zzr.zzs.zzf().zzh();
                    zzfx2.zzag(55005);
                    zzfx2.zzaf(zzr.zzs.zzav().currentTimeMillis());
                    Boolean bool = Boolean.TRUE;
                    zzfx2.zzac(true);
                    zzfv zzfv2 = zzfv;
                    zzfv2.zza(zzfx2);
                    zzg zzg2 = zzg;
                    zzg2.zzab(zzfx2.zzd());
                    zzg2.zzZ(zzfx2.zzc());
                    zzr.zzf.zzi().zzD(zzg2);
                    zzr.zzf.zzi().zzC();
                    zzr.zzf.zzi().zzx();
                    try {
                        return zzr.zzf.zzu().zzy(((zzfw) zzfv2.zzay()).zzbq());
                    } catch (IOException e2) {
                        zzr.zzs.zzay().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzeh.zzn(str), e2);
                        return obj;
                    }
                } catch (SecurityException e3) {
                    zzr.zzs.zzay().zzc().zzb("app instance id encryption failed", e3.getMessage());
                    bArr = new byte[0];
                    zzkp = zzr.zzf;
                }
            }
            zzkp.zzi().zzx();
            return bArr;
        } else {
            zzr.zzs.zzay().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str2, zzau.zza);
            return null;
        }
    }
}
