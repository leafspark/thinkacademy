package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzg {
    private long zzA;
    private String zzB;
    private boolean zzC;
    private long zzD;
    private long zzE;
    private final zzfr zza;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private long zzp;
    private boolean zzq;
    private String zzr;
    private Boolean zzs;
    private long zzt;
    private List zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    zzg(zzfr zzfr, String str) {
        Preconditions.checkNotNull(zzfr);
        Preconditions.checkNotEmpty(str);
        this.zza = zzfr;
        this.zzb = str;
        zzfr.zzaz().zzg();
    }

    public final String zzA() {
        this.zza.zzaz().zzg();
        return this.zze;
    }

    public final List zzB() {
        this.zza.zzaz().zzg();
        return this.zzu;
    }

    public final void zzC() {
        this.zza.zzaz().zzg();
        this.zzC = false;
    }

    public final void zzD() {
        this.zza.zzaz().zzg();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            this.zza.zzay().zzk().zzb("Bundle index overflow. appId", zzeh.zzn(this.zzb));
            j = 0;
        }
        this.zzC = true;
        this.zzg = j;
    }

    public final void zzE(String str) {
        this.zza.zzaz().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzC |= true ^ zzkw.zzak(this.zzr, str);
        this.zzr = str;
    }

    public final void zzF(boolean z) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzq != z;
        this.zzq = z;
    }

    public final void zzG(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzp != j;
        this.zzp = j;
    }

    public final void zzH(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzkw.zzak(this.zzc, str);
        this.zzc = str;
    }

    public final void zzI(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzkw.zzak(this.zzl, str);
        this.zzl = str;
    }

    public final void zzJ(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzkw.zzak(this.zzj, str);
        this.zzj = str;
    }

    public final void zzK(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzk != j;
        this.zzk = j;
    }

    public final void zzL(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzD != j;
        this.zzD = j;
    }

    public final void zzM(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzy != j;
        this.zzy = j;
    }

    public final void zzN(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzz != j;
        this.zzz = j;
    }

    public final void zzO(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzx != j;
        this.zzx = j;
    }

    public final void zzP(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzw != j;
        this.zzw = j;
    }

    public final void zzQ(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzA != j;
        this.zzA = j;
    }

    public final void zzR(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzv != j;
        this.zzv = j;
    }

    public final void zzS(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzn != j;
        this.zzn = j;
    }

    public final void zzT(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzt != j;
        this.zzt = j;
    }

    public final void zzU(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzE != j;
        this.zzE = j;
    }

    public final void zzV(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzkw.zzak(this.zzf, str);
        this.zzf = str;
    }

    public final void zzW(String str) {
        this.zza.zzaz().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzC |= true ^ zzkw.zzak(this.zzd, str);
        this.zzd = str;
    }

    public final void zzX(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzm != j;
        this.zzm = j;
    }

    public final void zzY(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzkw.zzak(this.zzB, str);
        this.zzB = str;
    }

    public final void zzZ(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzi != j;
        this.zzi = j;
    }

    public final long zza() {
        this.zza.zzaz().zzg();
        return this.zzp;
    }

    public final void zzaa(long j) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        this.zza.zzaz().zzg();
        boolean z2 = this.zzC;
        if (this.zzg == j) {
            z = false;
        }
        this.zzC = z2 | z;
        this.zzg = j;
    }

    public final void zzab(long j) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzh != j;
        this.zzh = j;
    }

    public final void zzac(boolean z) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzo != z;
        this.zzo = z;
    }

    public final void zzad(Boolean bool) {
        this.zza.zzaz().zzg();
        boolean z = this.zzC;
        Boolean bool2 = this.zzs;
        int i = zzkw.zza;
        this.zzC = z | (!((bool2 == null && bool == null) ? true : bool2 == null ? false : bool2.equals(bool)));
        this.zzs = bool;
    }

    public final void zzae(String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzkw.zzak(this.zze, str);
        this.zze = str;
    }

    public final void zzaf(List list) {
        this.zza.zzaz().zzg();
        List list2 = this.zzu;
        int i = zzkw.zza;
        if (list2 != null || list != null) {
            if (list2 == null || !list2.equals(list)) {
                this.zzC = true;
                this.zzu = list != null ? new ArrayList(list) : null;
            }
        }
    }

    public final boolean zzag() {
        this.zza.zzaz().zzg();
        return this.zzq;
    }

    public final boolean zzah() {
        this.zza.zzaz().zzg();
        return this.zzo;
    }

    public final boolean zzai() {
        this.zza.zzaz().zzg();
        return this.zzC;
    }

    public final long zzb() {
        this.zza.zzaz().zzg();
        return this.zzk;
    }

    public final long zzc() {
        this.zza.zzaz().zzg();
        return this.zzD;
    }

    public final long zzd() {
        this.zza.zzaz().zzg();
        return this.zzy;
    }

    public final long zze() {
        this.zza.zzaz().zzg();
        return this.zzz;
    }

    public final long zzf() {
        this.zza.zzaz().zzg();
        return this.zzx;
    }

    public final long zzg() {
        this.zza.zzaz().zzg();
        return this.zzw;
    }

    public final long zzh() {
        this.zza.zzaz().zzg();
        return this.zzA;
    }

    public final long zzi() {
        this.zza.zzaz().zzg();
        return this.zzv;
    }

    public final long zzj() {
        this.zza.zzaz().zzg();
        return this.zzn;
    }

    public final long zzk() {
        this.zza.zzaz().zzg();
        return this.zzt;
    }

    public final long zzl() {
        this.zza.zzaz().zzg();
        return this.zzE;
    }

    public final long zzm() {
        this.zza.zzaz().zzg();
        return this.zzm;
    }

    public final long zzn() {
        this.zza.zzaz().zzg();
        return this.zzi;
    }

    public final long zzo() {
        this.zza.zzaz().zzg();
        return this.zzg;
    }

    public final long zzp() {
        this.zza.zzaz().zzg();
        return this.zzh;
    }

    public final Boolean zzq() {
        this.zza.zzaz().zzg();
        return this.zzs;
    }

    public final String zzr() {
        this.zza.zzaz().zzg();
        return this.zzr;
    }

    public final String zzs() {
        this.zza.zzaz().zzg();
        String str = this.zzB;
        zzY((String) null);
        return str;
    }

    public final String zzt() {
        this.zza.zzaz().zzg();
        return this.zzb;
    }

    public final String zzu() {
        this.zza.zzaz().zzg();
        return this.zzc;
    }

    public final String zzv() {
        this.zza.zzaz().zzg();
        return this.zzl;
    }

    public final String zzw() {
        this.zza.zzaz().zzg();
        return this.zzj;
    }

    public final String zzx() {
        this.zza.zzaz().zzg();
        return this.zzf;
    }

    public final String zzy() {
        this.zza.zzaz().zzg();
        return this.zzd;
    }

    public final String zzz() {
        this.zza.zzaz().zzg();
        return this.zzB;
    }
}
