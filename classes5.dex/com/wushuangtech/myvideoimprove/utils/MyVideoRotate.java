package com.wushuangtech.myvideoimprove.utils;

import com.wushuangtech.constants.LocalSDKConstants;

public class MyVideoRotate {
    public static int transSurfaceRotate(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 3) {
            return LocalSDKConstants.SCREEN_ROTATE_180;
        }
        return 90;
    }
}
