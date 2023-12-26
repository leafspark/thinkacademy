package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzgj extends zzdw {
    /* access modifiers changed from: private */
    public final zzkp zza;
    private Boolean zzb;
    private String zzc = null;

    public zzgj(zzkp zzkp, String str) {
        Preconditions.checkNotNull(zzkp);
        this.zza = zzkp;
    }

    private final void zzA(zzau zzau, zzp zzp) {
        this.zza.zzA();
        this.zza.zzD(zzau, zzp);
    }

    private final void zzy(zzp zzp, boolean z) {
        Preconditions.checkNotNull(zzp);
        Preconditions.checkNotEmpty(zzp.zza);
        zzz(zzp.zza, false);
        this.zza.zzv().zzW(zzp.zzb, zzp.zzq);
    }

    private final void zzz(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzau(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzau()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzay().zzd().zzb("Measurement Service called with invalid calling package. appId", zzeh.zzn(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzau(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzay().zzd().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    /* access modifiers changed from: package-private */
    public final zzau zzb(zzau zzau, zzp zzp) {
        zzas zzas;
        if (!(!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzau.zza) || (zzas = zzau.zzb) == null || zzas.zza() == 0)) {
            String zzg = zzau.zzb.zzg("_cis");
            if ("referrer broadcast".equals(zzg) || "referrer API".equals(zzg)) {
                this.zza.zzay().zzi().zzb("Event has been filtered ", zzau.toString());
                return new zzau("_cmpx", zzau.zzb, zzau.zzc, zzau.zzd);
            }
        }
        return zzau;
    }

    public final String zzd(zzp zzp) {
        zzy(zzp, false);
        return this.zza.zzx(zzp);
    }

    public final List zze(zzp zzp, boolean z) {
        zzy(zzp, false);
        String str = zzp.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzku> list = (List) this.zza.zzaz().zzh(new zzgg(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzku zzku : list) {
                if (z || !zzkw.zzag(zzku.zzc)) {
                    arrayList.add(new zzks(zzku));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzc("Failed to get user properties. appId", zzeh.zzn(zzp.zza), e);
            return null;
        }
    }

    public final List zzf(String str, String str2, zzp zzp) {
        zzy(zzp, false);
        String str3 = zzp.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzaz().zzh(new zzfx(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzb("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    public final List zzg(String str, String str2, String str3) {
        zzz(str, true);
        try {
            return (List) this.zza.zzaz().zzh(new zzfy(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzb("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    public final List zzh(String str, String str2, boolean z, zzp zzp) {
        zzy(zzp, false);
        String str3 = zzp.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzku> list = (List) this.zza.zzaz().zzh(new zzfv(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzku zzku : list) {
                if (z || !zzkw.zzag(zzku.zzc)) {
                    arrayList.add(new zzks(zzku));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzc("Failed to query user properties. appId", zzeh.zzn(zzp.zza), e);
            return Collections.emptyList();
        }
    }

    public final List zzi(String str, String str2, String str3, boolean z) {
        zzz(str, true);
        try {
            List<zzku> list = (List) this.zza.zzaz().zzh(new zzfw(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzku zzku : list) {
                if (z || !zzkw.zzag(zzku.zzc)) {
                    arrayList.add(new zzks(zzku));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzc("Failed to get user properties as. appId", zzeh.zzn(str), e);
            return Collections.emptyList();
        }
    }

    public final void zzj(zzp zzp) {
        zzy(zzp, false);
        zzx(new zzgh(this, zzp));
    }

    public final void zzk(zzau zzau, zzp zzp) {
        Preconditions.checkNotNull(zzau);
        zzy(zzp, false);
        zzx(new zzgc(this, zzau, zzp));
    }

    public final void zzl(zzau zzau, String str, String str2) {
        Preconditions.checkNotNull(zzau);
        Preconditions.checkNotEmpty(str);
        zzz(str, true);
        zzx(new zzgd(this, zzau, str));
    }

    public final void zzm(zzp zzp) {
        Preconditions.checkNotEmpty(zzp.zza);
        zzz(zzp.zza, false);
        zzx(new zzfz(this, zzp));
    }

    public final void zzn(zzab zzab, zzp zzp) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotNull(zzab.zzc);
        zzy(zzp, false);
        zzab zzab2 = new zzab(zzab);
        zzab2.zza = zzp.zza;
        zzx(new zzft(this, zzab2, zzp));
    }

    public final void zzo(zzab zzab) {
        Preconditions.checkNotNull(zzab);
        Preconditions.checkNotNull(zzab.zzc);
        Preconditions.checkNotEmpty(zzab.zza);
        zzz(zzab.zza, true);
        zzx(new zzfu(this, new zzab(zzab)));
    }

    public final void zzp(zzp zzp) {
        Preconditions.checkNotEmpty(zzp.zza);
        Preconditions.checkNotNull(zzp.zzv);
        zzgb zzgb = new zzgb(this, zzp);
        Preconditions.checkNotNull(zzgb);
        if (this.zza.zzaz().zzs()) {
            zzgb.run();
        } else {
            this.zza.zzaz().zzq(zzgb);
        }
    }

    public final void zzq(long j, String str, String str2, String str3) {
        zzx(new zzgi(this, str2, str3, str, j));
    }

    public final void zzr(Bundle bundle, zzp zzp) {
        zzy(zzp, false);
        String str = zzp.zza;
        Preconditions.checkNotNull(str);
        zzx(new zzfs(this, str, bundle));
    }

    public final void zzs(zzp zzp) {
        zzy(zzp, false);
        zzx(new zzga(this, zzp));
    }

    public final void zzt(zzks zzks, zzp zzp) {
        Preconditions.checkNotNull(zzks);
        zzy(zzp, false);
        zzx(new zzgf(this, zzks, zzp));
    }

    public final byte[] zzu(zzau zzau, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzau);
        zzz(str, true);
        this.zza.zzay().zzc().zzb("Log and bundle. event", this.zza.zzj().zzd(zzau.zza));
        long nanoTime = this.zza.zzav().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzaz().zzi(new zzge(this, zzau, str)).get();
            if (bArr == null) {
                this.zza.zzay().zzd().zzb("Log and bundle returned null. appId", zzeh.zzn(str));
                bArr = new byte[0];
            }
            this.zza.zzay().zzc().zzd("Log and bundle processed. event, size, time_ms", this.zza.zzj().zzd(zzau.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzav().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzay().zzd().zzd("Failed to log and bundle. appId, event, error", zzeh.zzn(str), this.zza.zzj().zzd(zzau.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv(zzau zzau, zzp zzp) {
        zzc zzc2;
        if (!this.zza.zzo().zzl(zzp.zza)) {
            zzA(zzau, zzp);
            return;
        }
        this.zza.zzay().zzj().zzb("EES config found for", zzp.zza);
        zzfi zzo = this.zza.zzo();
        String str = zzp.zza;
        if (TextUtils.isEmpty(str)) {
            zzc2 = null;
        } else {
            zzc2 = (zzc) zzo.zzc.get(str);
        }
        if (zzc2 != null) {
            try {
                Map zzs = this.zza.zzu().zzs(zzau.zzb.zzc(), true);
                String zza2 = zzgo.zza(zzau.zza);
                if (zza2 == null) {
                    zza2 = zzau.zza;
                }
                if (zzc2.zze(new zzaa(zza2, zzau.zzd, zzs))) {
                    if (zzc2.zzg()) {
                        this.zza.zzay().zzj().zzb("EES edited event", zzau.zza);
                        zzA(this.zza.zzu().zzi(zzc2.zza().zzb()), zzp);
                    } else {
                        zzA(zzau, zzp);
                    }
                    if (zzc2.zzf()) {
                        for (zzaa zzaa : zzc2.zza().zzc()) {
                            this.zza.zzay().zzj().zzb("EES logging created event", zzaa.zzd());
                            zzA(this.zza.zzu().zzi(zzaa), zzp);
                        }
                        return;
                    }
                    return;
                }
            } catch (zzd unused) {
                this.zza.zzay().zzd().zzc("EES error. appId, eventName", zzp.zzb, zzau.zza);
            }
            this.zza.zzay().zzj().zzb("EES was not applied to event", zzau.zza);
            zzA(zzau, zzp);
            return;
        }
        this.zza.zzay().zzj().zzb("EES not loaded for", zzp.zza);
        zzA(zzau, zzp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(String str, Bundle bundle) {
        zzak zzi = this.zza.zzi();
        zzi.zzg();
        zzi.zzW();
        byte[] zzbq = zzi.zzf.zzu().zzj(new zzap(zzi.zzs, "", str, "dep", 0, 0, bundle)).zzbq();
        zzi.zzs.zzay().zzj().zzc("Saving default event parameters, appId, data size", zzi.zzs.zzj().zzd(str), Integer.valueOf(zzbq.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbq);
        try {
            if (zzi.zzh().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                zzi.zzs.zzay().zzd().zzb("Failed to insert default event parameters (got -1). appId", zzeh.zzn(str));
            }
        } catch (SQLiteException e) {
            zzi.zzs.zzay().zzd().zzc("Error storing default event parameters. appId", zzeh.zzn(str), e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzx(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzaz().zzs()) {
            runnable.run();
        } else {
            this.zza.zzaz().zzp(runnable);
        }
    }
}
