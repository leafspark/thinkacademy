package com.coloros.ocs.base.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.coloros.ocs.base.a.b;

public class AuthResult implements Parcelable {
    public static final Parcelable.Creator<AuthResult> CREATOR = new Parcelable.Creator<AuthResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AuthResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AuthResult(parcel);
        }
    };
    private String a;
    private int b;
    private int c;
    private int d;
    private byte[] e;

    public int describeContents() {
        return 0;
    }

    public AuthResult(String str, int i, int i2, int i3, byte[] bArr) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = bArr;
        b.b("AuthResult", "AuthResult errorCode is " + this.d);
    }

    protected AuthResult(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.createByteArray();
    }

    public int getUid() {
        return this.b;
    }

    public void setUid(int i) {
        this.b = i;
    }

    public int getPid() {
        return this.c;
    }

    public void setPid(int i) {
        this.c = i;
    }

    public byte[] getPermitBits() {
        return this.e;
    }

    public void setPermitBits(byte[] bArr) {
        this.e = bArr;
    }

    public String getPackageName() {
        return this.a;
    }

    public void setPackageName(String str) {
        this.a = str;
    }

    public int getErrrorCode() {
        return this.d;
    }

    public void setErrrorCode(int i) {
        this.d = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeByteArray(this.e);
    }
}
