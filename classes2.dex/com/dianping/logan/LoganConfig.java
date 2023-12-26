package com.dianping.logan;

import android.text.TextUtils;

public class LoganConfig {
    private static final long DAYS = 86400000;
    private static final long DEFAULT_DAY = 604800000;
    private static final long DEFAULT_FILE_SIZE = 10485760;
    private static final long DEFAULT_MIN_SDCARD_SIZE = 52428800;
    private static final int DEFAULT_QUEUE = 500;
    private static final long M = 1048576;
    String mCachePath;
    long mDay;
    byte[] mEncryptIv16;
    byte[] mEncryptKey16;
    long mMaxFile;
    long mMaxQueue;
    long mMinSDCard;
    String mPathPath;

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        return !TextUtils.isEmpty(this.mCachePath) && !TextUtils.isEmpty(this.mPathPath) && this.mEncryptKey16 != null && this.mEncryptIv16 != null;
    }

    private LoganConfig() {
        this.mMaxFile = DEFAULT_FILE_SIZE;
        this.mDay = DEFAULT_DAY;
        this.mMaxQueue = 500;
        this.mMinSDCard = DEFAULT_MIN_SDCARD_SIZE;
    }

    /* access modifiers changed from: private */
    public void setCachePath(String str) {
        this.mCachePath = str;
    }

    /* access modifiers changed from: private */
    public void setPathPath(String str) {
        this.mPathPath = str;
    }

    /* access modifiers changed from: private */
    public void setMaxFile(long j) {
        this.mMaxFile = j;
    }

    /* access modifiers changed from: private */
    public void setDay(long j) {
        this.mDay = j;
    }

    /* access modifiers changed from: private */
    public void setMinSDCard(long j) {
        this.mMinSDCard = j;
    }

    /* access modifiers changed from: private */
    public void setEncryptKey16(byte[] bArr) {
        this.mEncryptKey16 = bArr;
    }

    /* access modifiers changed from: private */
    public void setEncryptIV16(byte[] bArr) {
        this.mEncryptIv16 = bArr;
    }

    public static final class Builder {
        String mCachePath;
        long mDay = LoganConfig.DEFAULT_DAY;
        byte[] mEncryptIv16;
        byte[] mEncryptKey16;
        long mMaxFile = LoganConfig.DEFAULT_FILE_SIZE;
        long mMinSDCard = LoganConfig.DEFAULT_MIN_SDCARD_SIZE;
        String mPath;

        public Builder setCachePath(String str) {
            this.mCachePath = str;
            return this;
        }

        public Builder setPath(String str) {
            this.mPath = str;
            return this;
        }

        public Builder setMaxFile(long j) {
            this.mMaxFile = j * 1048576;
            return this;
        }

        public Builder setDay(long j) {
            this.mDay = j * LoganConfig.DAYS;
            return this;
        }

        public Builder setEncryptKey16(byte[] bArr) {
            this.mEncryptKey16 = bArr;
            return this;
        }

        public Builder setEncryptIV16(byte[] bArr) {
            this.mEncryptIv16 = bArr;
            return this;
        }

        public Builder setMinSDCard(long j) {
            this.mMinSDCard = j;
            return this;
        }

        public LoganConfig build() {
            LoganConfig loganConfig = new LoganConfig();
            loganConfig.setCachePath(this.mCachePath);
            loganConfig.setPathPath(this.mPath);
            loganConfig.setMaxFile(this.mMaxFile);
            loganConfig.setMinSDCard(this.mMinSDCard);
            loganConfig.setDay(this.mDay);
            loganConfig.setEncryptKey16(this.mEncryptKey16);
            loganConfig.setEncryptIV16(this.mEncryptIv16);
            return loganConfig;
        }
    }
}
