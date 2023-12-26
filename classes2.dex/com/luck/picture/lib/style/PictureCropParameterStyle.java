package com.luck.picture.lib.style;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

public class PictureCropParameterStyle implements Parcelable {
    public static final Parcelable.Creator<PictureCropParameterStyle> CREATOR = new Parcelable.Creator<PictureCropParameterStyle>() {
        public PictureCropParameterStyle createFromParcel(Parcel parcel) {
            return new PictureCropParameterStyle(parcel);
        }

        public PictureCropParameterStyle[] newArray(int i) {
            return new PictureCropParameterStyle[i];
        }
    };
    public int cropNavBarColor;
    public int cropStatusBarColorPrimaryDark;
    public int cropTitleBarBackgroundColor;
    public int cropTitleColor;
    public boolean isChangeStatusBarFontColor;

    public int describeContents() {
        return 0;
    }

    public PictureCropParameterStyle() {
    }

    public PictureCropParameterStyle(int i, int i2, int i3, boolean z) {
        this.cropTitleBarBackgroundColor = i;
        this.cropStatusBarColorPrimaryDark = i2;
        this.cropTitleColor = i3;
        this.isChangeStatusBarFontColor = z;
    }

    public PictureCropParameterStyle(int i, int i2, int i3, int i4, boolean z) {
        this.cropTitleBarBackgroundColor = i;
        this.cropNavBarColor = i3;
        this.cropStatusBarColorPrimaryDark = i2;
        this.cropTitleColor = i4;
        this.isChangeStatusBarFontColor = z;
    }

    public static PictureCropParameterStyle ofDefaultCropStyle() {
        return new PictureCropParameterStyle(Color.parseColor("#393a3e"), Color.parseColor("#393a3e"), Color.parseColor("#393a3e"), Color.parseColor("#FFFFFF"), false);
    }

    public static PictureCropParameterStyle ofSelectTotalStyle() {
        return new PictureCropParameterStyle(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"), Color.parseColor("#000000"), true);
    }

    public static PictureCropParameterStyle ofSelectNumberStyle() {
        return new PictureCropParameterStyle(Color.parseColor("#7D7DFF"), Color.parseColor("#7D7DFF"), Color.parseColor("#FFFFFF"), false);
    }

    public static PictureCropParameterStyle ofNewStyle() {
        return new PictureCropParameterStyle(Color.parseColor("#393a3e"), Color.parseColor("#393a3e"), Color.parseColor("#393a3e"), Color.parseColor("#FFFFFF"), false);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.isChangeStatusBarFontColor ? (byte) 1 : 0);
        parcel.writeInt(this.cropTitleBarBackgroundColor);
        parcel.writeInt(this.cropStatusBarColorPrimaryDark);
        parcel.writeInt(this.cropTitleColor);
        parcel.writeInt(this.cropNavBarColor);
    }

    protected PictureCropParameterStyle(Parcel parcel) {
        this.isChangeStatusBarFontColor = parcel.readByte() != 0;
        this.cropTitleBarBackgroundColor = parcel.readInt();
        this.cropStatusBarColorPrimaryDark = parcel.readInt();
        this.cropTitleColor = parcel.readInt();
        this.cropNavBarColor = parcel.readInt();
    }
}
