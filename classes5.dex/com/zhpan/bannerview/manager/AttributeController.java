package com.zhpan.bannerview.manager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import com.yalantis.ucrop.view.CropImageView;
import com.zhpan.bannerview.R;
import com.zhpan.bannerview.utils.BannerUtils;

public class AttributeController {
    private BannerOptions mBannerOptions;

    public AttributeController(BannerOptions bannerOptions) {
        this.mBannerOptions = bannerOptions;
    }

    public void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BannerViewPager);
            initBannerAttrs(obtainStyledAttributes);
            initIndicatorAttrs(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
    }

    private void initIndicatorAttrs(TypedArray typedArray) {
        int color = typedArray.getColor(R.styleable.BannerViewPager_bvp_indicator_checked_color, Color.parseColor("#8C18171C"));
        int color2 = typedArray.getColor(R.styleable.BannerViewPager_bvp_indicator_normal_color, Color.parseColor("#8C6C6D72"));
        int dimension = (int) typedArray.getDimension(R.styleable.BannerViewPager_bvp_indicator_radius, (float) BannerUtils.dp2px(8.0f));
        int i = typedArray.getInt(R.styleable.BannerViewPager_bvp_indicator_gravity, 0);
        int i2 = typedArray.getInt(R.styleable.BannerViewPager_bvp_indicator_style, 0);
        int i3 = typedArray.getInt(R.styleable.BannerViewPager_bvp_indicator_slide_mode, 0);
        int i4 = typedArray.getInt(R.styleable.BannerViewPager_bvp_indicator_visibility, 0);
        this.mBannerOptions.setIndicatorSliderColor(color2, color);
        this.mBannerOptions.setIndicatorSliderWidth(dimension, dimension);
        this.mBannerOptions.setIndicatorGravity(i);
        this.mBannerOptions.setIndicatorStyle(i2);
        this.mBannerOptions.setIndicatorSlideMode(i3);
        this.mBannerOptions.setIndicatorVisibility(i4);
        this.mBannerOptions.setIndicatorGap((float) dimension);
        this.mBannerOptions.setIndicatorHeight(dimension / 2);
    }

    private void initBannerAttrs(TypedArray typedArray) {
        int integer = typedArray.getInteger(R.styleable.BannerViewPager_bvp_interval, 3000);
        boolean z = typedArray.getBoolean(R.styleable.BannerViewPager_bvp_auto_play, true);
        boolean z2 = typedArray.getBoolean(R.styleable.BannerViewPager_bvp_can_loop, true);
        int i = typedArray.getInt(R.styleable.BannerViewPager_bvp_page_style, 0);
        int i2 = typedArray.getInt(R.styleable.BannerViewPager_bvp_scroll_duration, 500);
        this.mBannerOptions.setInterval(integer);
        this.mBannerOptions.setAutoPlay(z);
        this.mBannerOptions.setCanLoop(z2);
        this.mBannerOptions.setPageMargin((int) typedArray.getDimension(R.styleable.BannerViewPager_bvp_page_margin, CropImageView.DEFAULT_ASPECT_RATIO));
        this.mBannerOptions.setRoundRectRadius((int) typedArray.getDimension(R.styleable.BannerViewPager_bvp_round_corner, CropImageView.DEFAULT_ASPECT_RATIO));
        this.mBannerOptions.setRevealWidth((int) typedArray.getDimension(R.styleable.BannerViewPager_bvp_reveal_width, CropImageView.DEFAULT_ASPECT_RATIO));
        this.mBannerOptions.setPageStyle(i);
        this.mBannerOptions.setScrollDuration(i2);
    }
}
