package com.zhpan.bannerview.indicator.drawer;

import android.graphics.Canvas;
import com.zhpan.bannerview.indicator.drawer.BaseDrawer;
import com.zhpan.bannerview.manager.IndicatorOptions;

public class DrawerProxy implements IDrawer {
    private IDrawer mIDrawer;

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public DrawerProxy(IndicatorOptions indicatorOptions) {
        init(indicatorOptions);
    }

    private void init(IndicatorOptions indicatorOptions) {
        this.mIDrawer = DrawerFactory.createDrawer(indicatorOptions);
    }

    public BaseDrawer.MeasureResult onMeasure(int i, int i2) {
        return this.mIDrawer.onMeasure(i, i2);
    }

    public void onDraw(Canvas canvas) {
        this.mIDrawer.onDraw(canvas);
    }

    public void setIndicatorOptions(IndicatorOptions indicatorOptions) {
        init(indicatorOptions);
    }
}
