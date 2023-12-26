package com.wushuangtech.expansion.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.wushuangtech.expansion.inter.OnScreenStartListener;

public class ScreenRecordConfig implements Parcelable {
    public static final Parcelable.Creator<ScreenRecordConfig> CREATOR = new Parcelable.Creator<ScreenRecordConfig>() {
        public ScreenRecordConfig createFromParcel(Parcel parcel) {
            return new ScreenRecordConfig(parcel);
        }

        public ScreenRecordConfig[] newArray(int i) {
            return new ScreenRecordConfig[i];
        }
    };
    public int mBitrateMode;
    public OnScreenStartListener mOnScreenStartListener;
    public int mRecordBitRate;
    public int mRecordFrameRate;
    public int mRecordHeight;
    public int mRecordIFrameInterval;
    public int mRecordWidth;

    public int describeContents() {
        return 0;
    }

    public ScreenRecordConfig(int i, int i2, int i3, int i4, int i5) {
        this.mRecordWidth = i;
        this.mRecordHeight = i2;
        this.mRecordBitRate = i3;
        this.mRecordFrameRate = i4;
        this.mRecordIFrameInterval = i5;
    }

    public String toString() {
        return "ScreenRecordConfig{mRecordWidth=" + this.mRecordWidth + ", mRecordHeight=" + this.mRecordHeight + ", mRecordBitRate=" + this.mRecordBitRate + ", mRecordFrameRate=" + this.mRecordFrameRate + ", mRecordIFrameInterval=" + this.mRecordIFrameInterval + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRecordWidth);
        parcel.writeInt(this.mRecordHeight);
        parcel.writeInt(this.mRecordBitRate);
        parcel.writeInt(this.mRecordFrameRate);
        parcel.writeInt(this.mRecordIFrameInterval);
    }

    private ScreenRecordConfig(Parcel parcel) {
        this.mRecordWidth = parcel.readInt();
        this.mRecordHeight = parcel.readInt();
        this.mRecordBitRate = parcel.readInt();
        this.mRecordFrameRate = parcel.readInt();
        this.mRecordIFrameInterval = parcel.readInt();
    }
}
