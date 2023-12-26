package net.lucode.hackware.magicindicator;

import androidx.viewpager.widget.ViewPager;

public class ViewPagerHelper {
    public static void bind(final MagicIndicator magicIndicator, ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int i, float f, int i2) {
                magicIndicator.onPageScrolled(i, f, i2);
            }

            public void onPageSelected(int i) {
                magicIndicator.onPageSelected(i);
            }

            public void onPageScrollStateChanged(int i) {
                magicIndicator.onPageScrollStateChanged(i);
            }
        });
    }
}
