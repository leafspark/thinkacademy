package com.tal.app.thinkacademy.lib.logger;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class XesLogMo {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss", Locale.CHINA);
    public String appVersion;
    public String deviceName;
    public boolean isDebug = false;
    public int level;
    public String log;
    public String schoolCode;
    public String tag;
    public long timeMillis;
    public String token;
    public String uid;

    public XesLogMo(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.timeMillis = j;
        this.level = i;
        this.tag = str;
        this.log = str7;
        this.deviceName = str2;
        this.appVersion = str3;
        this.uid = str4;
        this.schoolCode = str5;
        this.token = str6;
    }

    public String flattenedLog() {
        return getFlattened() + this.log;
    }

    public String getFlattened() {
        return format(this.timeMillis) + '|' + this.level + '|' + this.tag + '|' + this.deviceName + '|' + this.appVersion + '|' + this.uid + '|' + this.schoolCode + '|' + this.isDebug + '|' + this.token + "|:";
    }

    private String format(long j) {
        return sdf.format(Long.valueOf(j));
    }

    public String toString() {
        return "XesLogMo{timeMillis=" + this.timeMillis + ", level=" + this.level + ", tag='" + this.tag + '\'' + ", log='" + this.log + '\'' + ", deviceName='" + this.deviceName + '\'' + ", appVersion='" + this.appVersion + '\'' + ", uid='" + this.uid + '\'' + ", schoolCode='" + this.schoolCode + '\'' + ", isDebug='" + this.isDebug + '\'' + ", token='" + this.token + '\'' + '}';
    }
}
