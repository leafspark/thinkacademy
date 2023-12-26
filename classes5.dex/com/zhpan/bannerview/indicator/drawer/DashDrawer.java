package com.zhpan.bannerview.indicator.drawer;

import android.graphics.Canvas;
import com.zhpan.bannerview.manager.IndicatorOptions;

public class DashDrawer extends RectDrawer {
    DashDrawer(IndicatorOptions indicatorOptions) {
        super(indicatorOptions);
    }

    /* access modifiers changed from: protected */
    public void drawDash(Canvas canvas) {
        canvas.drawRect(this.mRectF, this.mPaint);
    }
}
