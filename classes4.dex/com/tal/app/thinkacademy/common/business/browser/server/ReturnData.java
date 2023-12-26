package com.tal.app.thinkacademy.common.business.browser.server;

import android.os.Parcel;
import android.os.Parcelable;

public class ReturnData implements Parcelable {
    public static final Parcelable.Creator<ReturnData> CREATOR = new Parcelable.Creator<ReturnData>() {
        public ReturnData createFromParcel(Parcel parcel) {
            return new ReturnData(parcel);
        }

        public ReturnData[] newArray(int i) {
            return new ReturnData[i];
        }
    };
    private Object data;
    private int errorCode;
    private String errorMsg;
    private boolean isSuccess;

    public int describeContents() {
        return 0;
    }

    public ReturnData() {
    }

    protected ReturnData(Parcel parcel) {
        this.isSuccess = parcel.readByte() != 0;
        this.errorCode = parcel.readInt();
        this.errorMsg = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isSuccess ? (byte) 1 : 0);
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.errorMsg);
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }
}
