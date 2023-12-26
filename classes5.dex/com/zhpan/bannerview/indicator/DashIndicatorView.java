package com.zhpan.bannerview.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.yalantis.ucrop.view.CropImageView;

@Deprecated
public class DashIndicatorView extends BaseIndicatorView {
    private float maxWidth;
    private float minWidth;
    private float sliderHeight;

    public DashIndicatorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DashIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DashIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint.setColor(getNormalColor());
        this.sliderHeight = getNormalSliderWidth() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.maxWidth = Math.max(getNormalSliderWidth(), getCheckedSliderWidth());
        this.minWidth = Math.min(getNormalSliderWidth(), getCheckedSliderWidth());
        setMeasuredDimension((int) ((((float) (getPageSize() - 1)) * getIndicatorGap()) + this.maxWidth + (((float) (getPageSize() - 1)) * this.minWidth)), (int) getSliderHeight());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getPageSize() > 1) {
            for (int i = 0; i < getPageSize(); i++) {
                if (getSlideMode() == 2) {
                    smoothSlide(canvas, i);
                } else {
                    normalSlide(canvas, i);
                }
            }
        }
    }

    private void normalSlide(Canvas canvas, int i) {
        if (getNormalSliderWidth() == getCheckedSliderWidth()) {
            this.mPaint.setColor(getNormalColor());
            float f = (float) i;
            float normalSliderWidth = (getNormalSliderWidth() * f) + (f * getIndicatorGap());
            canvas.drawRect(normalSliderWidth, CropImageView.DEFAULT_ASPECT_RATIO, normalSliderWidth + getNormalSliderWidth(), getSliderHeight(), this.mPaint);
            drawSliderStyle(canvas);
        } else if (i < getCurrentPosition()) {
            this.mPaint.setColor(getNormalColor());
            float f2 = (float) i;
            float indicatorGap = (this.minWidth * f2) + (f2 * getIndicatorGap());
            canvas.drawRect(indicatorGap, CropImageView.DEFAULT_ASPECT_RATIO, indicatorGap + this.minWidth, getSliderHeight(), this.mPaint);
        } else if (i == getCurrentPosition()) {
            this.mPaint.setColor(getCheckedColor());
            float f3 = (float) i;
            float indicatorGap2 = (this.minWidth * f3) + (f3 * getIndicatorGap());
            float f4 = this.minWidth;
            canvas.drawRect(indicatorGap2, CropImageView.DEFAULT_ASPECT_RATIO, indicatorGap2 + f4 + (this.maxWidth - f4), getSliderHeight(), this.mPaint);
        } else {
            this.mPaint.setColor(getNormalColor());
            float f5 = (float) i;
            float indicatorGap3 = (this.minWidth * f5) + (f5 * getIndicatorGap());
            float f6 = this.maxWidth;
            float f7 = this.minWidth;
            float f8 = indicatorGap3 + (f6 - f7);
            canvas.drawRect(f8, CropImageView.DEFAULT_ASPECT_RATIO, f8 + f7, getSliderHeight(), this.mPaint);
        }
    }

    private void smoothSlide(Canvas canvas, int i) {
        this.mPaint.setColor(getNormalColor());
        float f = (float) i;
        float indicatorGap = (this.maxWidth * f) + (f * getIndicatorGap());
        float f2 = this.maxWidth;
        float f3 = this.minWidth;
        float f4 = indicatorGap + (f2 - f3);
        canvas.drawRect(f4, CropImageView.DEFAULT_ASPECT_RATIO, f4 + f3, getSliderHeight(), this.mPaint);
        drawSliderStyle(canvas);
    }

    private void drawSliderStyle(Canvas canvas) {
        this.mPaint.setColor(getCheckedColor());
        float currentPosition = (((float) getCurrentPosition()) * this.maxWidth) + (((float) getCurrentPosition()) * getIndicatorGap()) + ((this.maxWidth + getIndicatorGap()) * getSlideProgress());
        canvas.drawRect(currentPosition, CropImageView.DEFAULT_ASPECT_RATIO, currentPosition + this.maxWidth, getSliderHeight(), this.mPaint);
    }

    public float getSliderHeight() {
        if (getIndicatorOptions().getSliderHeight() > CropImageView.DEFAULT_ASPECT_RATIO) {
            return getIndicatorOptions().getSliderHeight();
        }
        return this.sliderHeight;
    }
}
