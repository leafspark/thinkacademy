package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
final class zzhg implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzhw zzb;

    zzhg(zzhw zzhw, Bundle bundle) {
        this.zzb = zzhw;
        this.zza = bundle;
    }

    public final void run() {
        zzhw zzhw = this.zzb;
        Bundle bundle = this.zza;
        zzhw.zzg();
        zzhw.zza();
        Preconditions.checkNotNull(bundle);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!zzhw.zzs.zzJ()) {
            zzhw.zzs.zzay().zzj().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzks zzks = new zzks(checkNotEmpty, 0, (Object) null, "");
        try {
            zzab zzab = r4;
            zzab zzab2 = new zzab(bundle.getString("app_id"), "", zzks, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzau) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzau) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzhw.zzs.zzv().zzz(bundle.getString("app_id"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true));
            zzhw.zzs.zzt().zzE(zzab);
        } catch (IllegalArgumentException unused) {
        }
    }
}
