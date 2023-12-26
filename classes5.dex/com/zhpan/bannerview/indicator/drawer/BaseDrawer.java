package com.zhpan.bannerview.indicator.drawer;

import android.graphics.Paint;
import android.graphics.RectF;
import com.zhpan.bannerview.manager.IndicatorOptions;

public abstract class BaseDrawer implements IDrawer {
    IndicatorOptions mIndicatorOptions;
    private MeasureResult mMeasureResult = new MeasureResult();
    Paint mPaint;
    RectF mRectF = new RectF();
    float maxWidth;
    float minWidth;

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    BaseDrawer(IndicatorOptions indicatorOptions) {
        this.mIndicatorOptions = indicatorOptions;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }

    public MeasureResult onMeasure(int i, int i2) {
        this.maxWidth = Math.max(this.mIndicatorOptions.getNormalSliderWidth(), this.mIndicatorOptions.getCheckedSliderWidth());
        this.minWidth = Math.min(this.mIndicatorOptions.getNormalSliderWidth(), this.mIndicatorOptions.getCheckedSliderWidth());
        this.mMeasureResult.setMeasureResult(measureWidth(), measureHeight());
        return this.mMeasureResult;
    }

    /* access modifiers changed from: protected */
    public int measureHeight() {
        return (int) this.mIndicatorOptions.getSliderHeight();
    }

    private int measureWidth() {
        float pageSize = (float) (this.mIndicatorOptions.getPageSize() - 1);
        return (int) ((this.mIndicatorOptions.getSliderGap() * pageSize) + this.maxWidth + (pageSize * this.minWidth));
    }

    public class MeasureResult {
        int measureHeight;
        int measureWidth;

        public MeasureResult() {
        }

        /* access modifiers changed from: package-private */
        public void setMeasureResult(int i, int i2) {
            this.measureWidth = i;
            this.measureHeight = i2;
        }

        public int getMeasureWidth() {
            return this.measureWidth;
        }

        public int getMeasureHeight() {
            return this.measureHeight;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isWidthEquals() {
        return this.mIndicatorOptions.getNormalSliderWidth() == this.mIndicatorOptions.getCheckedSliderWidth();
    }
}
