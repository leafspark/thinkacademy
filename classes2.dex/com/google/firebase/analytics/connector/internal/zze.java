package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@20.1.0 */
public final class zze implements zza {
    final Set zza = new HashSet();
    /* access modifiers changed from: private */
    public final AnalyticsConnector.AnalyticsConnectorListener zzb;
    private final AppMeasurementSdk zzc;
    private final zzd zzd;

    public zze(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = appMeasurementSdk;
        zzd zzd2 = new zzd(this);
        this.zzd = zzd2;
        appMeasurementSdk.registerOnMeasurementEventListener(zzd2);
    }

    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    public final void zzb(Set set) {
        this.zza.clear();
        Set set2 = this.zza;
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (hashSet.size() >= 50) {
                break;
            } else if (zzc.zzf(str) && zzc.zzg(str)) {
                String zzd2 = zzc.zzd(str);
                Preconditions.checkNotNull(zzd2);
                hashSet.add(zzd2);
            }
        }
        set2.addAll(hashSet);
    }

    public final void zzc() {
        this.zza.clear();
    }
}
