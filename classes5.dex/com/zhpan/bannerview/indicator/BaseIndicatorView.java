package com.zhpan.bannerview.indicator;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.yalantis.ucrop.view.CropImageView;
import com.zhpan.bannerview.manager.IndicatorOptions;

public class BaseIndicatorView extends View implements IIndicator {
    private IndicatorOptions mIndicatorOptions;
    protected Paint mPaint;
    private ViewPager mViewPager;

    public void onPageScrollStateChanged(int i) {
    }

    public BaseIndicatorView(Context context) {
        super(context);
    }

    public BaseIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIndicatorOptions = new IndicatorOptions();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }

    public void onPageSelected(int i) {
        if (getSlideMode() == 0) {
            setCurrentPosition(i);
            setSlideProgress(CropImageView.DEFAULT_ASPECT_RATIO);
            invalidate();
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (getSlideMode() != 0 && getPageSize() > 1) {
            scrollSlider(i, f);
            invalidate();
        }
    }

    private void scrollSlider(int i, float f) {
        if (i % getPageSize() != getPageSize() - 1) {
            setCurrentPosition(i);
            setSlideProgress(f);
        } else if (((double) f) < 0.5d) {
            setCurrentPosition(i);
            setSlideProgress(CropImageView.DEFAULT_ASPECT_RATIO);
        } else {
            setCurrentPosition(0);
            setSlideProgress(CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }

    public void notifyDataChanged() {
        setupViewPager();
        requestLayout();
        invalidate();
    }

    private void setupViewPager() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            viewPager.removeOnPageChangeListener(this);
            this.mViewPager.addOnPageChangeListener(this);
            if (this.mViewPager.getAdapter() != null) {
                setPageSize(this.mViewPager.getAdapter().getCount());
            }
        }
    }

    private void setPageSize(int i) {
        this.mIndicatorOptions.setPageSize(i);
    }

    public BaseIndicatorView setSliderColor(int i, int i2) {
        this.mIndicatorOptions.setSliderColor(i, i2);
        return this;
    }

    public BaseIndicatorView setSliderWidth(float f) {
        this.mIndicatorOptions.setSliderWidth(f);
        return this;
    }

    public BaseIndicatorView setSliderWidth(float f, float f2) {
        this.mIndicatorOptions.setSliderWidth(f, f2);
        return this;
    }

    public BaseIndicatorView setSliderGap(float f) {
        this.mIndicatorOptions.setSliderGap(f);
        return this;
    }

    public BaseIndicatorView setSlideMode(int i) {
        this.mIndicatorOptions.setSlideMode(i);
        return this;
    }

    public BaseIndicatorView setIndicatorStyle(int i) {
        this.mIndicatorOptions.setIndicatorStyle(i);
        return this;
    }

    public BaseIndicatorView setSliderHeight(float f) {
        this.mIndicatorOptions.setSliderHeight(f);
        return this;
    }

    public int getPageSize() {
        return this.mIndicatorOptions.getPageSize();
    }

    public int getNormalColor() {
        return this.mIndicatorOptions.getNormalSliderColor();
    }

    public int getCheckedColor() {
        return this.mIndicatorOptions.getCheckedSliderColor();
    }

    public float getIndicatorGap() {
        return this.mIndicatorOptions.getSliderGap();
    }

    public float getSlideProgress() {
        return this.mIndicatorOptions.getSlideProgress();
    }

    public int getCurrentPosition() {
        return this.mIndicatorOptions.getCurrentPosition();
    }

    public int getSlideMode() {
        return this.mIndicatorOptions.getSlideMode();
    }

    public float getNormalSliderWidth() {
        return this.mIndicatorOptions.getNormalSliderWidth();
    }

    public float getCheckedSliderWidth() {
        return this.mIndicatorOptions.getCheckedSliderWidth();
    }

    private void setSlideProgress(float f) {
        this.mIndicatorOptions.setSlideProgress(f);
    }

    private void setCurrentPosition(int i) {
        this.mIndicatorOptions.setCurrentPosition(i);
    }

    public void setupWithViewPager(ViewPager viewPager) {
        this.mViewPager = viewPager;
        notifyDataChanged();
    }

    public IndicatorOptions getIndicatorOptions() {
        return this.mIndicatorOptions;
    }

    public void setIndicatorOptions(IndicatorOptions indicatorOptions) {
        this.mIndicatorOptions = indicatorOptions;
    }
}
