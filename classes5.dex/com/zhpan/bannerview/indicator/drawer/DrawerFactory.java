package com.zhpan.bannerview.indicator.drawer;

import com.zhpan.bannerview.manager.IndicatorOptions;

class DrawerFactory {
    DrawerFactory() {
    }

    static IDrawer createDrawer(IndicatorOptions indicatorOptions) {
        int indicatorStyle = indicatorOptions.getIndicatorStyle();
        if (indicatorStyle == 2) {
            return new DashDrawer(indicatorOptions);
        }
        if (indicatorStyle == 4) {
            return new RoundRectDrawer(indicatorOptions);
        }
        return new CircleDrawer(indicatorOptions);
    }
}
