package com.didi.hummer.render.utility;

import android.content.Context;

public class DPUtil {
    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float dp2pxF(Context context, float f) {
        return f * context.getResources().getDisplayMetrics().density;
    }

    public static int px2dp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float px2dpF(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }
}
