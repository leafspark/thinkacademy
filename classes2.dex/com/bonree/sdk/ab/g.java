package com.bonree.sdk.ab;

import android.os.Parcel;
import android.os.Parcelable;

final class g implements Parcelable.Creator<f> {
    g() {
    }

    private static f a(Parcel parcel) {
        return new f(parcel, (byte) 0);
    }

    private static f[] a(int i) {
        return new f[i];
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new f[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new f(parcel, (byte) 0);
    }
}
