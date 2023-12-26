package com.luck.picture.lib.tools;

import android.content.Context;
import android.widget.Toast;

public final class ToastUtils {
    private static final long TIME = 1500;
    private static long lastToastTime;

    public static void s(Context context, String str) {
        if (!isShowToast()) {
            Toast.makeText(context.getApplicationContext(), str, 0).show();
        }
    }

    public static boolean isShowToast() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastToastTime < TIME) {
            return true;
        }
        lastToastTime = currentTimeMillis;
        return false;
    }
}
