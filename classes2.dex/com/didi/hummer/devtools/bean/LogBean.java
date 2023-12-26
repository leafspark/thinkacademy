package com.didi.hummer.devtools.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class LogBean implements Serializable {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss.SSS");
    public static final int LEVEL_DEBUG = 2;
    public static final int LEVEL_ERROR = 5;
    public static final int LEVEL_INFO = 3;
    public static final int LEVEL_LOG = 1;
    public static final int LEVEL_WARN = 4;
    @SerializedName("level")
    private int level;
    @SerializedName("message")
    private String msg;
    private transient String rawMsg;
    private transient long timestamp;

    public LogBean(int i, String str) {
        this.level = i;
        this.rawMsg = str;
        long currentTimeMillis = System.currentTimeMillis();
        this.timestamp = currentTimeMillis;
        this.msg = String.format("[%s] %s", new Object[]{DATE_FORMAT.format(Long.valueOf(currentTimeMillis)), str});
    }

    public int getLevel() {
        return this.level;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRawMsg() {
        return this.rawMsg;
    }
}
