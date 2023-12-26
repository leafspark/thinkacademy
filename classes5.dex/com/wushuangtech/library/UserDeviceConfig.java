package com.wushuangtech.library;

import android.text.TextUtils;

public class UserDeviceConfig implements Cloneable {
    private final String mDeviceId;
    private long mDeviceOpenTimestamp;
    private String mDualDeviceId;
    private int mHeight;
    private boolean mIsDef;
    private boolean mIsDualUse;
    private boolean mIsOpenBigVideo;
    private boolean mIsOpenSmallVideo;
    private boolean mIsUse;
    private final long mUid;
    private int mVideoSteamType = 0;
    private int mVideoType;
    private int mWidth;

    public UserDeviceConfig(long j, String str, boolean z, boolean z2) {
        this.mUid = j;
        this.mDeviceId = str;
        this.mIsUse = z;
        this.mIsDef = z2;
    }

    public int hashCode() {
        String str = this.mDeviceId;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.mUid;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserDeviceConfig userDeviceConfig = (UserDeviceConfig) obj;
        String str = this.mDeviceId;
        if (str == null) {
            if (userDeviceConfig.mDeviceId != null) {
                return false;
            }
        } else if (!str.equals(userDeviceConfig.mDeviceId)) {
            return false;
        }
        return this.mUid == userDeviceConfig.mUid;
    }

    public UserDeviceConfig clone() {
        try {
            return (UserDeviceConfig) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public long getUid() {
        return this.mUid;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public boolean isDefaultDevice() {
        return this.mIsDef;
    }

    public boolean isUse() {
        return this.mIsUse;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public String getDualDeviceId() {
        return this.mDualDeviceId;
    }

    public boolean isDualUse() {
        return this.mIsDualUse;
    }

    public int getVideoSteamType() {
        return this.mVideoSteamType;
    }

    public boolean isOpenBigVideo() {
        return this.mIsOpenBigVideo;
    }

    public boolean isOpenSmallVideo() {
        return this.mIsOpenSmallVideo;
    }

    public int getVideoType() {
        return this.mVideoType;
    }

    public long getDeviceOpenTimestamp() {
        return this.mDeviceOpenTimestamp;
    }

    public void setDefaultDevice(boolean z) {
        this.mIsDef = z;
    }

    public void setIsUse(boolean z) {
        this.mIsUse = z;
    }

    public void setDualDeviceId(String str) {
        this.mDualDeviceId = str;
    }

    public void setDualUse(boolean z) {
        this.mIsDualUse = z;
    }

    public void setVideoType(int i) {
        this.mVideoType = i;
    }

    public void setIsOpenBigVideo(boolean z) {
        this.mIsOpenBigVideo = z;
    }

    public void setIsOpenSmallVideo(boolean z) {
        this.mIsOpenSmallVideo = z;
    }

    public void setVideoSteamType(int i) {
        this.mVideoSteamType = i;
    }

    public void setDeviceOpenTimestamp(long j) {
        this.mDeviceOpenTimestamp = j;
    }

    public void updateDeviceOpenStatus(boolean z, boolean z2, long j) {
        if (this.mIsOpenBigVideo != z) {
            this.mIsOpenBigVideo = z;
        }
        if (this.mIsOpenSmallVideo != z2) {
            this.mIsOpenSmallVideo = z2;
        }
        if (this.mDeviceOpenTimestamp != j) {
            this.mDeviceOpenTimestamp = j;
        }
    }

    public boolean updateDevice(UserDeviceConfig userDeviceConfig) {
        boolean z = false;
        if (userDeviceConfig == null) {
            return false;
        }
        if (this.mIsUse != userDeviceConfig.isUse()) {
            this.mIsUse = userDeviceConfig.isUse();
            z = true;
        }
        if (this.mIsDef != userDeviceConfig.isDefaultDevice()) {
            this.mIsDef = userDeviceConfig.isDefaultDevice();
            z = true;
        }
        if (this.mWidth != userDeviceConfig.getWidth()) {
            this.mWidth = userDeviceConfig.getWidth();
            z = true;
        }
        if (this.mHeight != userDeviceConfig.getHeight()) {
            this.mHeight = userDeviceConfig.getHeight();
            z = true;
        }
        if (this.mVideoType != userDeviceConfig.getVideoType()) {
            this.mVideoType = userDeviceConfig.getVideoType();
            z = true;
        }
        String dualDeviceId = userDeviceConfig.getDualDeviceId();
        if (!TextUtils.isEmpty(dualDeviceId) && !dualDeviceId.equals(this.mDualDeviceId)) {
            this.mDualDeviceId = dualDeviceId;
            z = true;
        }
        if (this.mIsDualUse != userDeviceConfig.isDualUse()) {
            this.mIsDualUse = userDeviceConfig.isDualUse();
            z = true;
        }
        if (this.mDeviceOpenTimestamp == userDeviceConfig.getDeviceOpenTimestamp()) {
            return z;
        }
        this.mDeviceOpenTimestamp = userDeviceConfig.getDeviceOpenTimestamp();
        return true;
    }

    public String toString() {
        return "UserDeviceConfig{mUerID=" + this.mUid + ", mDeviceID='" + this.mDeviceId + '\'' + ", mIsUse=" + this.mIsUse + ", mIsDef=" + this.mIsDef + ", mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDualDeviceID='" + this.mDualDeviceId + '\'' + ", mIsDualUse=" + this.mIsDualUse + ", mVideoSteamType=" + this.mVideoSteamType + ", mIsOpenBigVideo=" + this.mIsOpenBigVideo + ", mIsOpenSmallVideo=" + this.mIsOpenSmallVideo + '}';
    }
}
