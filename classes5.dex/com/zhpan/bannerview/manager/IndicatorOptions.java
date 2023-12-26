package com.zhpan.bannerview.manager;

import android.graphics.Color;
import com.yalantis.ucrop.view.CropImageView;
import com.zhpan.bannerview.utils.BannerUtils;

public class IndicatorOptions {
    private int checkedColor = Color.parseColor("#8C6C6D72");
    private float checkedSliderWidth;
    private int currentPosition;
    private int mIndicatorStyle;
    private int normalColor = Color.parseColor("#8C18171C");
    private float normalSliderWidth;
    private int pageSize;
    private int slideMode = 0;
    private float slideProgress;
    private float sliderGap;
    private float sliderHeight;

    public IndicatorOptions() {
        float dp2px = (float) BannerUtils.dp2px(8.0f);
        this.normalSliderWidth = dp2px;
        this.checkedSliderWidth = dp2px;
        this.sliderGap = dp2px;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getNormalSliderColor() {
        return this.normalColor;
    }

    public int getCheckedSliderColor() {
        return this.checkedColor;
    }

    public void setCheckedColor(int i) {
        this.checkedColor = i;
    }

    public float getSliderGap() {
        return this.sliderGap;
    }

    public void setSliderGap(float f) {
        this.sliderGap = f;
    }

    public float getSlideProgress() {
        return this.slideProgress;
    }

    public void setSlideProgress(float f) {
        this.slideProgress = f;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public void setCurrentPosition(int i) {
        this.currentPosition = i;
    }

    public int getSlideMode() {
        return this.slideMode;
    }

    public void setSlideMode(int i) {
        this.slideMode = i;
    }

    public float getNormalSliderWidth() {
        return this.normalSliderWidth;
    }

    public float getCheckedSliderWidth() {
        return this.checkedSliderWidth;
    }

    public float getSliderHeight() {
        float f = this.sliderHeight;
        return f > CropImageView.DEFAULT_ASPECT_RATIO ? f : this.normalSliderWidth / 2.0f;
    }

    public void setSliderHeight(float f) {
        this.sliderHeight = f;
    }

    public int getIndicatorStyle() {
        return this.mIndicatorStyle;
    }

    public void setPageSize(int i) {
        this.pageSize = i;
    }

    public void setIndicatorStyle(int i) {
        this.mIndicatorStyle = i;
    }

    public void setSliderWidth(float f, float f2) {
        this.normalSliderWidth = f;
        this.checkedSliderWidth = f2;
    }

    public void setSliderWidth(float f) {
        setSliderWidth(f, f);
    }

    public void setSliderColor(int i, int i2) {
        this.normalColor = i;
        this.checkedColor = i2;
    }
}
