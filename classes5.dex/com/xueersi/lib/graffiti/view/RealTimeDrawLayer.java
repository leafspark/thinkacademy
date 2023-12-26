package com.xueersi.lib.graffiti.view;

import android.graphics.Canvas;
import android.os.SystemClock;
import com.xueersi.lib.graffiti.utils.XesLog;

public class RealTimeDrawLayer extends BaseDrawLayer {
    private int count;

    public void onDraw(Canvas canvas) {
        long uptimeMillis = SystemClock.uptimeMillis();
        drawAllObjects(canvas);
        this.count++;
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (XesLog.isEnabled()) {
            XesLog.d("RealTimeDrawLayer绘制一帧所需时间:" + uptimeMillis2);
            XesLog.d("RealTimeDrawLayer绘制次数" + this.count);
        }
    }
}
