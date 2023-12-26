package com.zhpan.bannerview.manager;

import com.yalantis.ucrop.view.CropImageView;
import com.zhpan.bannerview.utils.BannerUtils;

public class BannerOptions {
    public static final int DEFAULT_SCROLL_DURATION = 500;
    private int currentPosition;
    private boolean disableTouchScroll;
    private int indicatorGravity;
    private int interval;
    private boolean isAutoPlay = false;
    private boolean isCanLoop;
    private boolean isLooping;
    private IndicatorMargin mIndicatorMargin;
    private IndicatorOptions mIndicatorOptions = new IndicatorOptions();
    private int mIndicatorVisibility;
    private int mPageMargin = BannerUtils.dp2px(20.0f);
    private int mPageStyle = 0;
    private int mRevealWidth = BannerUtils.dp2px(20.0f);
    private int mRoundRadius;
    private int mScrollDuration;
    private int offScreenPageLimit;

    public int getInterval() {
        return this.interval;
    }

    public void setInterval(int i) {
        this.interval = i;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public void setCurrentPosition(int i) {
        this.currentPosition = i;
    }

    public boolean isLooping() {
        return this.isLooping;
    }

    public void setLooping(boolean z) {
        this.isLooping = z;
    }

    public boolean isCanLoop() {
        return this.isCanLoop;
    }

    public void setCanLoop(boolean z) {
        this.isCanLoop = z;
    }

    public boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public void setAutoPlay(boolean z) {
        this.isAutoPlay = z;
    }

    public int getIndicatorGravity() {
        return this.indicatorGravity;
    }

    public void setIndicatorGravity(int i) {
        this.indicatorGravity = i;
    }

    public int getIndicatorNormalColor() {
        return this.mIndicatorOptions.getNormalSliderColor();
    }

    public int getIndicatorCheckedColor() {
        return this.mIndicatorOptions.getCheckedSliderColor();
    }

    public int getNormalIndicatorWidth() {
        return (int) this.mIndicatorOptions.getNormalSliderWidth();
    }

    public void setIndicatorSliderColor(int i, int i2) {
        this.mIndicatorOptions.setSliderColor(i, i2);
    }

    public void setIndicatorSliderWidth(int i, int i2) {
        this.mIndicatorOptions.setSliderWidth((float) i, (float) i2);
    }

    public int getCheckedIndicatorWidth() {
        return (int) this.mIndicatorOptions.getCheckedSliderWidth();
    }

    public IndicatorOptions getIndicatorOptions() {
        return this.mIndicatorOptions;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMargin(int i) {
        this.mPageMargin = i;
    }

    public int getRevealWidth() {
        return this.mRevealWidth;
    }

    public void setRevealWidth(int i) {
        this.mRevealWidth = i;
    }

    public int getIndicatorStyle() {
        return this.mIndicatorOptions.getIndicatorStyle();
    }

    public void setIndicatorStyle(int i) {
        this.mIndicatorOptions.setIndicatorStyle(i);
    }

    public int getIndicatorSlideMode() {
        return this.mIndicatorOptions.getSlideMode();
    }

    public void setIndicatorSlideMode(int i) {
        this.mIndicatorOptions.setSlideMode(i);
    }

    public float getIndicatorGap() {
        return this.mIndicatorOptions.getSliderGap();
    }

    public void setIndicatorGap(float f) {
        this.mIndicatorOptions.setSliderGap(f);
    }

    public float getIndicatorHeight() {
        return this.mIndicatorOptions.getSliderHeight();
    }

    public void setIndicatorHeight(int i) {
        this.mIndicatorOptions.setSliderHeight((float) i);
    }

    public int getPageStyle() {
        return this.mPageStyle;
    }

    public void setPageStyle(int i) {
        this.mPageStyle = i;
    }

    public IndicatorMargin getIndicatorMargin() {
        return this.mIndicatorMargin;
    }

    public void setIndicatorMargin(int i, int i2, int i3, int i4) {
        this.mIndicatorMargin = new IndicatorMargin(i, i2, i3, i4);
    }

    public int getRoundRectRadius() {
        return this.mRoundRadius;
    }

    public void setRoundRectRadius(int i) {
        this.mRoundRadius = i;
    }

    public int getScrollDuration() {
        return this.mScrollDuration;
    }

    public void setScrollDuration(int i) {
        this.mScrollDuration = i;
    }

    public int getIndicatorVisibility() {
        return this.mIndicatorVisibility;
    }

    public void setIndicatorVisibility(int i) {
        this.mIndicatorVisibility = i;
    }

    public boolean isDisableTouchScroll() {
        return this.disableTouchScroll;
    }

    public void setDisableTouchScroll(boolean z) {
        this.disableTouchScroll = z;
    }

    public void resetIndicatorOptions() {
        this.mIndicatorOptions.setCurrentPosition(0);
        this.mIndicatorOptions.setSlideProgress(CropImageView.DEFAULT_ASPECT_RATIO);
    }

    public int getOffScreenPageLimit() {
        return this.offScreenPageLimit;
    }

    public void setOffScreenPageLimit(int i) {
        this.offScreenPageLimit = i;
    }

    public static class IndicatorMargin {
        private int bottom;
        private int left;
        private int right;
        private int top;

        public IndicatorMargin(int i, int i2, int i3, int i4) {
            this.left = i;
            this.right = i3;
            this.top = i2;
            this.bottom = i4;
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        public int getTop() {
            return this.top;
        }

        public int getBottom() {
            return this.bottom;
        }
    }
}
