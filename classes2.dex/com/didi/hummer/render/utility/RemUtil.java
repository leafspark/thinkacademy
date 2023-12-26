package com.didi.hummer.render.utility;

import android.content.res.Resources;

public class RemUtil {
    public static float BASE_WIDTH = 750.0f;
    private static final int SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;

    public static float rem2px(float f) {
        return f * (((float) SCREEN_WIDTH) / BASE_WIDTH);
    }

    public static float px2rem(float f) {
        return f / (((float) SCREEN_WIDTH) / BASE_WIDTH);
    }
}
