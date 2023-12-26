package com.zhpan.bannerview.indicator.drawer;

import android.graphics.Canvas;
import com.yalantis.ucrop.view.CropImageView;
import com.zhpan.bannerview.manager.IndicatorOptions;
import com.zhpan.bannerview.utils.BannerUtils;

public class RectDrawer extends BaseDrawer {
    /* access modifiers changed from: protected */
    public void drawDash(Canvas canvas) {
    }

    RectDrawer(IndicatorOptions indicatorOptions) {
        super(indicatorOptions);
    }

    public void onDraw(Canvas canvas) {
        int pageSize = this.mIndicatorOptions.getPageSize();
        if (pageSize <= 1) {
            return;
        }
        if (!isWidthEquals() || this.mIndicatorOptions.getSlideMode() == 0) {
            for (int i = 0; i < pageSize; i++) {
                drawInequalitySlider(canvas, i);
            }
            return;
        }
        drawUncheckedSlider(canvas, pageSize);
        drawCheckedSlider(canvas);
    }

    private void drawUncheckedSlider(Canvas canvas, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.mPaint.setColor(this.mIndicatorOptions.getNormalSliderColor());
            float sliderHeight = this.mIndicatorOptions.getSliderHeight();
            float f = (float) i2;
            float sliderGap = (this.maxWidth * f) + (f * this.mIndicatorOptions.getSliderGap()) + (this.maxWidth - this.minWidth);
            this.mRectF.set(sliderGap, CropImageView.DEFAULT_ASPECT_RATIO, this.minWidth + sliderGap, sliderHeight);
            drawRoundRect(canvas, sliderHeight, sliderHeight);
        }
    }

    private void drawInequalitySlider(Canvas canvas, int i) {
        int normalSliderColor = this.mIndicatorOptions.getNormalSliderColor();
        float sliderGap = this.mIndicatorOptions.getSliderGap();
        float sliderHeight = this.mIndicatorOptions.getSliderHeight();
        int currentPosition = this.mIndicatorOptions.getCurrentPosition();
        if (i < currentPosition) {
            this.mPaint.setColor(normalSliderColor);
            float f = (float) i;
            float f2 = (this.minWidth * f) + (f * sliderGap);
            this.mRectF.set(f2, CropImageView.DEFAULT_ASPECT_RATIO, this.minWidth + f2, sliderHeight);
            drawRoundRect(canvas, sliderHeight, sliderHeight);
        } else if (i == currentPosition) {
            this.mPaint.setColor(this.mIndicatorOptions.getCheckedSliderColor());
            float f3 = (float) i;
            float f4 = (this.minWidth * f3) + (f3 * sliderGap);
            this.mRectF.set(f4, CropImageView.DEFAULT_ASPECT_RATIO, this.minWidth + f4 + (this.maxWidth - this.minWidth), sliderHeight);
            drawRoundRect(canvas, sliderHeight, sliderHeight);
        } else {
            this.mPaint.setColor(normalSliderColor);
            float f5 = (float) i;
            float f6 = (this.minWidth * f5) + (f5 * sliderGap) + (this.maxWidth - this.minWidth);
            this.mRectF.set(f6, CropImageView.DEFAULT_ASPECT_RATIO, this.minWidth + f6, sliderHeight);
            drawRoundRect(canvas, sliderHeight, sliderHeight);
        }
    }

    private void drawCheckedSlider(Canvas canvas) {
        this.mPaint.setColor(this.mIndicatorOptions.getCheckedSliderColor());
        int slideMode = this.mIndicatorOptions.getSlideMode();
        if (slideMode == 2) {
            drawSmoothSlider(canvas);
        } else if (slideMode == 3) {
            drawWormSlider(canvas);
        }
    }

    private void drawWormSlider(Canvas canvas) {
        float sliderHeight = this.mIndicatorOptions.getSliderHeight();
        float slideProgress = this.mIndicatorOptions.getSlideProgress();
        int currentPosition = this.mIndicatorOptions.getCurrentPosition();
        float sliderGap = this.mIndicatorOptions.getSliderGap() + this.mIndicatorOptions.getNormalSliderWidth();
        float coordinateX = BannerUtils.getCoordinateX(this.mIndicatorOptions, this.maxWidth, currentPosition);
        float min = coordinateX + Math.min(slideProgress * sliderGap * 2.0f, sliderGap) + (this.mIndicatorOptions.getNormalSliderWidth() / 2.0f);
        this.mRectF.set((Math.max(((slideProgress - 0.5f) * sliderGap) * 2.0f, CropImageView.DEFAULT_ASPECT_RATIO) + coordinateX) - (this.mIndicatorOptions.getNormalSliderWidth() / 2.0f), CropImageView.DEFAULT_ASPECT_RATIO, min, sliderHeight);
        drawRoundRect(canvas, sliderHeight, sliderHeight);
    }

    private void drawSmoothSlider(Canvas canvas) {
        int currentPosition = this.mIndicatorOptions.getCurrentPosition();
        float sliderGap = this.mIndicatorOptions.getSliderGap();
        float sliderHeight = this.mIndicatorOptions.getSliderHeight();
        float f = (float) currentPosition;
        float slideProgress = (this.maxWidth * f) + (f * sliderGap) + ((this.maxWidth + sliderGap) * this.mIndicatorOptions.getSlideProgress());
        this.mRectF.set(slideProgress, CropImageView.DEFAULT_ASPECT_RATIO, this.maxWidth + slideProgress, sliderHeight);
        drawRoundRect(canvas, sliderHeight, sliderHeight);
    }

    /* access modifiers changed from: protected */
    public void drawRoundRect(Canvas canvas, float f, float f2) {
        drawDash(canvas);
    }
}
