package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.0 */
public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new zzav();
    public final String zza;
    public final zzas zzb;
    public final String zzc;
    public final long zzd;

    zzau(zzau zzau, long j) {
        Preconditions.checkNotNull(zzau);
        this.zza = zzau.zza;
        this.zzb = zzau.zzb;
        this.zzc = zzau.zzc;
        this.zzd = j;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zzav.zza(this, parcel, i);
    }

    public zzau(String str, zzas zzas, String str2, long j) {
        this.zza = str;
        this.zzb = zzas;
        this.zzc = str2;
        this.zzd = j;
    }
}
