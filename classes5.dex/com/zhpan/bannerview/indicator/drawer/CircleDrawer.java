package com.zhpan.bannerview.indicator.drawer;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.yalantis.ucrop.view.CropImageView;
import com.zhpan.bannerview.manager.IndicatorOptions;
import com.zhpan.bannerview.utils.BannerUtils;

public class CircleDrawer extends BaseDrawer {
    private RectF rectF = new RectF();

    CircleDrawer(IndicatorOptions indicatorOptions) {
        super(indicatorOptions);
    }

    /* access modifiers changed from: protected */
    public int measureHeight() {
        return (int) this.maxWidth;
    }

    public void onDraw(Canvas canvas) {
        if (this.mIndicatorOptions.getPageSize() > 1) {
            drawNormal(canvas);
            drawSlider(canvas);
        }
    }

    private void drawNormal(Canvas canvas) {
        float normalSliderWidth = this.mIndicatorOptions.getNormalSliderWidth();
        this.mPaint.setColor(this.mIndicatorOptions.getNormalSliderColor());
        for (int i = 0; i < this.mIndicatorOptions.getPageSize(); i++) {
            drawCircle(canvas, BannerUtils.getCoordinateX(this.mIndicatorOptions, this.maxWidth, i), BannerUtils.getCoordinateY(this.maxWidth), normalSliderWidth / 2.0f);
        }
    }

    private void drawSlider(Canvas canvas) {
        this.mPaint.setColor(this.mIndicatorOptions.getCheckedSliderColor());
        int slideMode = this.mIndicatorOptions.getSlideMode();
        if (slideMode == 0 || slideMode == 2) {
            drawCircleSlider(canvas);
        } else if (slideMode == 3) {
            drawWormSlider(canvas, this.mIndicatorOptions.getNormalSliderWidth());
        }
    }

    private void drawCircleSlider(Canvas canvas) {
        int currentPosition = this.mIndicatorOptions.getCurrentPosition();
        float coordinateX = BannerUtils.getCoordinateX(this.mIndicatorOptions, this.maxWidth, currentPosition);
        drawCircle(canvas, coordinateX + ((BannerUtils.getCoordinateX(this.mIndicatorOptions, this.maxWidth, (currentPosition + 1) % this.mIndicatorOptions.getPageSize()) - coordinateX) * this.mIndicatorOptions.getSlideProgress()), BannerUtils.getCoordinateY(this.maxWidth), this.mIndicatorOptions.getCheckedSliderWidth() / 2.0f);
    }

    private void drawWormSlider(Canvas canvas, float f) {
        float slideProgress = this.mIndicatorOptions.getSlideProgress();
        int currentPosition = this.mIndicatorOptions.getCurrentPosition();
        float sliderGap = this.mIndicatorOptions.getSliderGap() + this.mIndicatorOptions.getNormalSliderWidth();
        float coordinateX = BannerUtils.getCoordinateX(this.mIndicatorOptions, this.maxWidth, currentPosition);
        float min = coordinateX + Math.min(slideProgress * sliderGap * 2.0f, sliderGap) + (this.mIndicatorOptions.getNormalSliderWidth() / 2.0f);
        this.rectF.set((Math.max(((slideProgress - 0.5f) * sliderGap) * 2.0f, CropImageView.DEFAULT_ASPECT_RATIO) + coordinateX) - (this.mIndicatorOptions.getNormalSliderWidth() / 2.0f), CropImageView.DEFAULT_ASPECT_RATIO, min, f);
        canvas.drawRoundRect(this.rectF, f, f, this.mPaint);
    }

    private void drawCircle(Canvas canvas, float f, float f2, float f3) {
        canvas.drawCircle(f, f2, f3, this.mPaint);
    }
}
