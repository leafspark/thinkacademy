package com.tal.app.thinkacademy.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tal.app.thinkacademy.common.entity.ScreenInfo;
import com.tal.app.thinkacademy.lib.utils.TableUtils;

public class PadUtils {
    public static void setup(Context context) {
        TableUtils.setupTable(context);
    }

    public static boolean isPad(Context context) {
        return TableUtils.isTable();
    }

    public static ScreenInfo getScreenInch(Context context) {
        float f;
        float f2;
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int i = resources.getConfiguration().orientation;
        if (i == 2) {
            f2 = displayMetrics.ydpi;
            f = displayMetrics.xdpi;
        } else {
            f2 = displayMetrics.xdpi;
            f = displayMetrics.ydpi;
        }
        float f3 = f2;
        float f4 = f;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT < 30) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getRealSize(point);
            return new ScreenInfo(i, point.x, point.y, f3, f4, Math.sqrt(Math.pow((double) (((float) point.x) / f3), 2.0d) + Math.pow((double) (((float) point.y) / f4), 2.0d)));
        }
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        int i2 = bounds.right - bounds.left;
        int i3 = bounds.bottom - bounds.top;
        return new ScreenInfo(i, i2, i3, f3, f4, Math.sqrt(Math.pow((double) (((float) i2) / f3), 2.0d) + Math.pow((double) (((float) i3) / f4), 2.0d)));
    }
}
