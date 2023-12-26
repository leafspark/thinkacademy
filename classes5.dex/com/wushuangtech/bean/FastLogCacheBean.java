package com.wushuangtech.bean;

public class FastLogCacheBean {
    public int mInterval = 2000;
    public String mKey;
    public int mLevel;
    public String mMessage;
    public String mTag;
    public long mTimestamp;
    public String mWatcher;

    public FastLogCacheBean(String str, String str2, int i) {
        this.mKey = str;
        this.mTag = str2;
        this.mLevel = i;
    }

    public FastLogCacheBean(String str, String str2, String str3, int i) {
        this.mKey = str;
        this.mWatcher = str2;
        this.mTag = str3;
        this.mLevel = i;
    }
}
