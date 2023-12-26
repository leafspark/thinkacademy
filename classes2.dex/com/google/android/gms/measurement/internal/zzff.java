package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.0 */
final class zzff extends LruCache {
    final /* synthetic */ zzfi zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzff(zzfi zzfi, int i) {
        super(20);
        this.zza = zzfi;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfi.zzd(this.zza, str);
    }
}
