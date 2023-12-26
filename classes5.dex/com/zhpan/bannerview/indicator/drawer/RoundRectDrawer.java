package com.zhpan.bannerview.indicator.drawer;

import android.graphics.Canvas;
import com.zhpan.bannerview.manager.IndicatorOptions;

public class RoundRectDrawer extends RectDrawer {
    RoundRectDrawer(IndicatorOptions indicatorOptions) {
        super(indicatorOptions);
    }

    /* access modifiers changed from: protected */
    public void drawRoundRect(Canvas canvas, float f, float f2) {
        canvas.drawRoundRect(this.mRectF, f, f2, this.mPaint);
    }
}
