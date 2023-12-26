package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzr;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzfg implements zzr {
    final /* synthetic */ zzfi zza;

    zzfg(zzfi zzfi) {
        this.zza = zzfi;
    }

    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzef zzef;
        int i2 = i - 1;
        if (i2 == 0) {
            zzef = this.zza.zzs.zzay().zzc();
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzef = this.zza.zzs.zzay().zzj();
            } else if (i2 != 4) {
                zzef = this.zza.zzs.zzay().zzi();
            } else if (z) {
                zzef = this.zza.zzs.zzay().zzm();
            } else if (!z2) {
                zzef = this.zza.zzs.zzay().zzl();
            } else {
                zzef = this.zza.zzs.zzay().zzk();
            }
        } else if (z) {
            zzef = this.zza.zzs.zzay().zzh();
        } else if (!z2) {
            zzef = this.zza.zzs.zzay().zze();
        } else {
            zzef = this.zza.zzs.zzay().zzd();
        }
        int size = list.size();
        if (size == 1) {
            zzef.zzb(str, list.get(0));
        } else if (size == 2) {
            zzef.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzef.zza(str);
        } else {
            zzef.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
