package com.wushuangtech.wstechapi.bean;

public enum VideoRotate {
    ROTATE_0,
    ROTATE_90,
    ROTATE_180,
    ROTATE_270;

    public static VideoRotate fromInt(int i) {
        if (i == 0) {
            return ROTATE_0;
        }
        if (i == 90) {
            return ROTATE_90;
        }
        if (i == 180) {
            return ROTATE_180;
        }
        if (i != 270) {
            return null;
        }
        return ROTATE_270;
    }
}
