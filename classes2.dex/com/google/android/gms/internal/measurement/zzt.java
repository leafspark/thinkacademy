package com.google.android.gms.internal.measurement;

import com.didi.hummer.devtools.bean.WSMsg;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
public final class zzt extends zzai {
    /* access modifiers changed from: private */
    public final zzr zza;

    public zzt(zzr zzr) {
        super("internal.logger");
        this.zza = zzr;
        this.zze.put(WSMsg.TYPE_LOG, new zzs(this, false, true));
        this.zze.put("silent", new zzp(this, "silent"));
        ((zzai) this.zze.get("silent")).zzr(WSMsg.TYPE_LOG, new zzs(this, true, true));
        this.zze.put("unmonitored", new zzq(this, "unmonitored"));
        ((zzai) this.zze.get("unmonitored")).zzr(WSMsg.TYPE_LOG, new zzs(this, false, false));
    }

    public final zzap zza(zzg zzg, List list) {
        return zzap.zzf;
    }
}
