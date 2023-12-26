package com.zhpan.bannerview.transform;

import androidx.viewpager.widget.ViewPager;

public class PageTransformerFactory {
    public ViewPager.PageTransformer createPageTransformer(int i) {
        if (i == 2) {
            return new DepthPageTransformer();
        }
        if (i == 4) {
            return new StackTransformer();
        }
        if (i == 8) {
            return new AccordionTransformer();
        }
        if (i == 16) {
            return new RotateUpTransformer();
        }
        if (i != 32) {
            return null;
        }
        return new ScaleInTransformer(0.85f);
    }
}
