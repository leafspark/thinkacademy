package com.bonree.sdk.ab;

import android.os.Parcel;
import android.os.Parcelable;
import com.bonree.sdk.d.a;

public final class f implements Parcelable {
    private static Parcelable.Creator<f> m;
    public String a;
    public int b;
    public String c;
    public String d;
    public int e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    private int k;
    private boolean l;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ f(Parcel parcel, byte b2) {
        this(parcel);
    }

    public final String toString() {
        return "MetaWebViewError{mReqUrl='" + this.a + '\'' + ", mErrorId=" + this.b + ", mRequestHeader='" + this.c + '\'' + ", mRequestDataSize=" + this.k + ", mResponseHeader='" + this.d + '\'' + ", mResponseDataSize=" + this.e + ", mMimeType='" + this.f + '\'' + ", mIsBackground=" + this.l + ", message='" + this.g + '\'' + ", mErrorOccurrentprocess=" + this.h + ", mLoadUrl='" + this.i + '\'' + ", mErrorPlatform='" + this.j + '\'' + '}';
    }

    public f(String str, int i2, String str2, int i3, String str3, String str4) {
        this.a = str;
        this.b = i2;
        this.l = a.k().J();
        this.g = str2;
        this.h = i3;
        this.i = str3;
        this.j = str4;
    }

    public f(String str, int i2, String str2, int i3, String str3, int i4, String str4, String str5) {
        this.a = str;
        this.b = i2;
        this.c = str2;
        this.k = i3;
        this.l = a.k().J();
        this.g = str3;
        this.h = i4;
        this.i = str4;
        this.j = str5;
    }

    public f(String str, int i2, String str2, int i3, String str3, int i4, String str4, String str5, int i5, String str6, String str7) {
        this.a = str;
        this.b = i2;
        this.c = str2;
        this.k = i3;
        this.d = str3;
        this.e = i4;
        this.f = str4;
        this.l = a.k().J();
        this.g = str5;
        this.h = i5;
        this.i = str6;
        this.j = str7;
    }

    private f(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readString();
        this.k = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.l = zArr[0];
        this.g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.c);
        parcel.writeInt(this.k);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeBooleanArray(new boolean[]{this.l});
        parcel.writeString(this.g);
    }

    static {
        new g();
    }
}
