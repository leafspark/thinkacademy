package com.luck.picture.lib.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class LocalMediaFolder implements Parcelable {
    public static final Parcelable.Creator<LocalMediaFolder> CREATOR = new Parcelable.Creator<LocalMediaFolder>() {
        public LocalMediaFolder createFromParcel(Parcel parcel) {
            return new LocalMediaFolder(parcel);
        }

        public LocalMediaFolder[] newArray(int i) {
            return new LocalMediaFolder[i];
        }
    };
    private long bucketId = -1;
    private int checkedNum;
    private int currentDataPage;
    private List<LocalMedia> data = new ArrayList();
    private String firstImagePath;
    private String firstMimeType;
    private int imageNum;
    private boolean isCameraFolder;
    private boolean isChecked;
    private boolean isHasMore;
    private String name;
    private int ofAllType = -1;

    public int describeContents() {
        return 0;
    }

    public LocalMediaFolder() {
    }

    protected LocalMediaFolder(Parcel parcel) {
        this.bucketId = parcel.readLong();
        this.name = parcel.readString();
        this.firstImagePath = parcel.readString();
        this.firstMimeType = parcel.readString();
        this.imageNum = parcel.readInt();
        this.checkedNum = parcel.readInt();
        boolean z = true;
        this.isChecked = parcel.readByte() != 0;
        this.ofAllType = parcel.readInt();
        this.isCameraFolder = parcel.readByte() != 0;
        this.data = parcel.createTypedArrayList(LocalMedia.CREATOR);
        this.currentDataPage = parcel.readInt();
        this.isHasMore = parcel.readByte() == 0 ? false : z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.bucketId);
        parcel.writeString(this.name);
        parcel.writeString(this.firstImagePath);
        parcel.writeString(this.firstMimeType);
        parcel.writeInt(this.imageNum);
        parcel.writeInt(this.checkedNum);
        parcel.writeByte(this.isChecked ? (byte) 1 : 0);
        parcel.writeInt(this.ofAllType);
        parcel.writeByte(this.isCameraFolder ? (byte) 1 : 0);
        parcel.writeTypedList(this.data);
        parcel.writeInt(this.currentDataPage);
        parcel.writeByte(this.isHasMore ? (byte) 1 : 0);
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public void setBucketId(long j) {
        this.bucketId = j;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? "unknown" : this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getFirstImagePath() {
        return this.firstImagePath;
    }

    public void setFirstImagePath(String str) {
        this.firstImagePath = str;
    }

    public int getImageNum() {
        return this.imageNum;
    }

    public void setImageNum(int i) {
        this.imageNum = i;
    }

    public int getCheckedNum() {
        return this.checkedNum;
    }

    public void setCheckedNum(int i) {
        this.checkedNum = i;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }

    public int getOfAllType() {
        return this.ofAllType;
    }

    public void setOfAllType(int i) {
        this.ofAllType = i;
    }

    public boolean isCameraFolder() {
        return this.isCameraFolder;
    }

    public void setCameraFolder(boolean z) {
        this.isCameraFolder = z;
    }

    public List<LocalMedia> getData() {
        return this.data;
    }

    public void setData(List<LocalMedia> list) {
        this.data = list;
    }

    public int getCurrentDataPage() {
        return this.currentDataPage;
    }

    public void setCurrentDataPage(int i) {
        this.currentDataPage = i;
    }

    public boolean isHasMore() {
        return this.isHasMore;
    }

    public void setHasMore(boolean z) {
        this.isHasMore = z;
    }

    public String getFirstMimeType() {
        return this.firstMimeType;
    }

    public void setFirstMimeType(String str) {
        this.firstMimeType = str;
    }
}
