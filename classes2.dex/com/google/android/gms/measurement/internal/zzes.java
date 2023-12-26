package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzes {
    final /* synthetic */ zzew zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzes(zzew zzew, String str, long j) {
        this.zza = zzew;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j;
    }

    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(long j) {
        SharedPreferences.Editor edit = this.zza.zza().edit();
        edit.putLong(this.zzb, j);
        edit.apply();
        this.zze = j;
    }
}
