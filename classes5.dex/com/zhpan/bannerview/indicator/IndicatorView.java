package com.zhpan.bannerview.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.zhpan.bannerview.indicator.drawer.BaseDrawer;
import com.zhpan.bannerview.indicator.drawer.DrawerProxy;
import com.zhpan.bannerview.manager.IndicatorOptions;

public class IndicatorView extends BaseIndicatorView implements IIndicator {
    private DrawerProxy mDrawerProxy;

    public IndicatorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawerProxy = new DrawerProxy(getIndicatorOptions());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mDrawerProxy.onLayout(z, i, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        BaseDrawer.MeasureResult onMeasure = this.mDrawerProxy.onMeasure(i, i2);
        setMeasuredDimension(onMeasure.getMeasureWidth(), onMeasure.getMeasureHeight());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mDrawerProxy.onDraw(canvas);
    }

    public void setIndicatorOptions(IndicatorOptions indicatorOptions) {
        super.setIndicatorOptions(indicatorOptions);
        this.mDrawerProxy.setIndicatorOptions(indicatorOptions);
    }
}
