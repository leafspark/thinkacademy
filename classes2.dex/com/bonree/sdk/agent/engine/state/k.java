package com.bonree.sdk.agent.engine.state;

import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;

public final class k implements Parcelable {
    private static Parcelable.Creator<k> d;
    private int a;
    private String b;
    private NetworkInfo c;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ k(Parcel parcel, byte b2) {
        this(parcel);
    }

    k() {
        this.a = -1;
    }

    public final int a() {
        return this.a;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        this.a = i;
    }

    public final String b() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    private NetworkInfo c() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public final void a(NetworkInfo networkInfo) {
        this.c = networkInfo;
    }

    static {
        new l();
    }

    private k(Parcel parcel) {
        this.a = -1;
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = (NetworkInfo) parcel.readParcelable(NetworkInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("NetState{");
        stringBuffer.append("netType=");
        stringBuffer.append(this.a);
        stringBuffer.append(", standard=");
        stringBuffer.append(this.b);
        stringBuffer.append(", networkInfo=");
        stringBuffer.append(this.c);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
