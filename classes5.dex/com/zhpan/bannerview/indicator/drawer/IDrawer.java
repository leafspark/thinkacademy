package com.zhpan.bannerview.indicator.drawer;

import android.graphics.Canvas;
import com.zhpan.bannerview.indicator.drawer.BaseDrawer;

public interface IDrawer {
    void onDraw(Canvas canvas);

    void onLayout(boolean z, int i, int i2, int i3, int i4);

    BaseDrawer.MeasureResult onMeasure(int i, int i2);
}
