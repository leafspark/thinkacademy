package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzko {
    zzfy zza;
    List zzb;
    List zzc;
    long zzd;
    final /* synthetic */ zzkp zze;

    /* synthetic */ zzko(zzkp zzkp, zzkn zzkn) {
        this.zze = zzkp;
    }

    private static final long zzb(zzfo zzfo) {
        return ((zzfo.zzd() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, zzfo zzfo) {
        Preconditions.checkNotNull(zzfo);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (this.zzc.size() > 0 && zzb((zzfo) this.zzc.get(0)) != zzb(zzfo)) {
            return false;
        }
        long zzbr = this.zzd + ((long) zzfo.zzbr());
        this.zze.zzg();
        if (zzbr >= ((long) Math.max(0, ((Integer) zzdu.zzh.zza((Object) null)).intValue()))) {
            return false;
        }
        this.zzd = zzbr;
        this.zzc.add(zzfo);
        this.zzb.add(Long.valueOf(j));
        int size = this.zzc.size();
        this.zze.zzg();
        if (size >= Math.max(1, ((Integer) zzdu.zzi.zza((Object) null)).intValue())) {
            return false;
        }
        return true;
    }
}
