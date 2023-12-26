package com.didi.hummer.render.event.base;

import java.io.Serializable;

public abstract class Event implements Serializable {
    public static final String HM_EVENT_TYPE_LONG_PRESS = "longPress";
    public static final String HM_EVENT_TYPE_PAN = "pan";
    public static final String HM_EVENT_TYPE_PINCH = "pinch";
    public static final String HM_EVENT_TYPE_SWIPE = "swipe";
    public static final String HM_EVENT_TYPE_TAP = "tap";
    public static final String HM_EVENT_TYPE_TOUCH = "touch";
    public static final int HM_GESTURE_STATE_BEGAN = 1;
    public static final int HM_GESTURE_STATE_CANCELLED = 4;
    public static final int HM_GESTURE_STATE_CHANGED = 2;
    public static final int HM_GESTURE_STATE_ENDED = 3;
    public static final int HM_GESTURE_STATE_NORMAL = 0;
    private int state;
    private long timestamp;
    private String type;

    public void setType(String str) {
        this.type = str;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
