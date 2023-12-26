package com.tal.app.thinkacademy.live.business.videocall.util;

import android.graphics.Outline;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tal.app.thinkacademy.lib.util.SizeUtils;

public class ViewCornerUtil {
    public static void clipViewCornerByDp(View view, final int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setClipToOutline(true);
            view.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    Outline outline2 = outline;
                    outline2.setRoundRect(0, 0, view.getWidth(), view.getHeight(), (float) SizeUtils.dp2px((float) i));
                }
            });
        }
    }

    public static void clipViewCircle(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setClipToOutline(true);
            view.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
        }
    }
}
