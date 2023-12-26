package com.zhpan.bannerview.indicator;

import androidx.viewpager.widget.ViewPager;
import com.zhpan.bannerview.manager.IndicatorOptions;

public interface IIndicator extends ViewPager.OnPageChangeListener {
    void notifyDataChanged();

    void setIndicatorOptions(IndicatorOptions indicatorOptions);
}
