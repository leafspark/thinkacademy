package com.bonree.sdk.agent.engine.state;

import android.os.Parcel;
import android.os.Parcelable;

final class l implements Parcelable.Creator<k> {
    l() {
    }

    private static k a(Parcel parcel) {
        return new k(parcel, (byte) 0);
    }

    private static k[] a(int i) {
        return new k[i];
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new k[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new k(parcel, (byte) 0);
    }
}
