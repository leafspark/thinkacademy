package com.tal.app.thinkacademy.live.core.live.constant;

public class LiveConstants {
    public static final int CLASS_STATUS_ATTEND = 2;
    public static final int CLASS_STATUS_IDLE = 1;
    public static final int CLASS_STATUS_OVER = 3;
    public static final int CLASS_STATUS_UNKNOWN = 0;
    public static final int LIVE_PATTERN_COMMON = 1;
    public static final int LIVE_TYPE_LECTURE = 2;
    public static final int LIVE_TYPE_LIVE = 3;
    public static final int LIVE_TYPE_TUTORIAL = 1;
    public static final String MODE_CLASS = "in-class";
    public static final String MODE_TRAINING = "in-training";
    public static final int STREAM_MODE_CLASS_AFTER = 2;
    public static final int STREAM_MODE_CLASS_BEFORE = 0;
    public static final int STREAM_MODE_MAIN = 1;

    public static int getBizIdFromLiveType(int i) {
        return 1;
    }
}
