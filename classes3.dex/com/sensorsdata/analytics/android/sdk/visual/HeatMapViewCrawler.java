package com.sensorsdata.analytics.android.sdk.visual;

import android.app.Activity;

class HeatMapViewCrawler extends AbstractViewCrawler {
    HeatMapViewCrawler(Activity activity, String str, String str2, String str3) {
        super(activity, str, str2, str3, AbstractViewCrawler.TYPE_HEAT_MAP);
    }
}
