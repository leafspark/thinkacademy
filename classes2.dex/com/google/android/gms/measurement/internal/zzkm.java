package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzkm implements zzkv {
    final /* synthetic */ zzkp zza;

    zzkm(zzkp zzkp) {
        this.zza = zzkp;
    }

    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            zzkp zzkp = this.zza;
            if (zzkp.zzn != null) {
                zzkp.zzn.zzay().zzd().zzb("AppId not known when logging event", "_err");
                return;
            }
            return;
        }
        this.zza.zzaz().zzp(new zzkl(this, str, "_err", bundle));
    }
}
