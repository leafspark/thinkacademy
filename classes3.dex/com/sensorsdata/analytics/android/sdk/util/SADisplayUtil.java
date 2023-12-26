package com.sensorsdata.analytics.android.sdk.util;

import android.content.Context;

public class SADisplayUtil {
    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
