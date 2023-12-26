package com.tal.app.thinkacademy.business.shop.classdetail;

import com.google.android.material.tabs.TabLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailActivity$initScrollListen$1", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailActivity.kt */
public final class ShopClassDetailActivity$initScrollListen$1 implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ ShopClassDetailActivity this$0;

    public void onTabUnselected(TabLayout.Tab tab) {
    }

    ShopClassDetailActivity$initScrollListen$1(ShopClassDetailActivity shopClassDetailActivity) {
        this.this$0 = shopClassDetailActivity;
    }

    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            this.this$0.listScrollByTabIndex(tab.getPosition());
        }
        SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
    }

    public void onTabReselected(TabLayout.Tab tab) {
        if (tab != null) {
            this.this$0.listScrollByTabIndex(tab.getPosition());
        }
    }
}
