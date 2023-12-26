package com.didi.hummer.render.utility;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;

public class RTLUtil {
    public static boolean isRTL(Context context) {
        return context != null && context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public static void toRTLRect(Rect rect) {
        int i = rect.left;
        rect.left = rect.right;
        rect.right = i;
    }

    public static void toRTLRect(RectF rectF) {
        float f = rectF.left;
        rectF.left = rectF.right;
        rectF.right = f;
    }
}
