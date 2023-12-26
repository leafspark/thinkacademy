package com.coloros.ocs.base.common;

import android.os.Parcel;
import android.os.Parcelable;

public class Feature implements Parcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new Parcelable.Creator<Feature>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Feature[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Feature(parcel);
        }
    };
    private String a;
    private long b;

    public int describeContents() {
        return 0;
    }

    public Feature(String str, long j) {
        this.a = str;
        this.b = j;
    }

    protected Feature(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readLong();
    }

    public String getName() {
        return this.a;
    }

    public long getVersion() {
        long j = this.b;
        if (j == -1) {
            return -1;
        }
        return j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeLong(this.b);
    }
}
