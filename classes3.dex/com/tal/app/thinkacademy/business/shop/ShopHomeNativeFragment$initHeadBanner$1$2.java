package com.tal.app.thinkacademy.business.shop;

import com.tal.app.thinkacademy.business.home.main.shop.bean.Channel;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerResource;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.listener.OnPageChangeListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/tal/app/thinkacademy/business/shop/ShopHomeNativeFragment$initHeadBanner$1$2", "Lcom/youth/banner/listener/OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeNativeFragment.kt */
public final class ShopHomeNativeFragment$initHeadBanner$1$2 implements OnPageChangeListener {
    final /* synthetic */ ShopHomeNativeFragment this$0;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    ShopHomeNativeFragment$initHeadBanner$1$2(ShopHomeNativeFragment shopHomeNativeFragment) {
        this.this$0 = shopHomeNativeFragment;
    }

    public void onPageSelected(int i) {
        Integer id;
        BannerImageAdapter access$getMBannerAdapter$p = this.this$0.mBannerAdapter;
        ShopBannerResource shopBannerResource = access$getMBannerAdapter$p == null ? null : (ShopBannerResource) access$getMBannerAdapter$p.getData(i);
        if (shopBannerResource != null) {
            ShopHomeNativeFragment shopHomeNativeFragment = this.this$0;
            HashMap access$getMBannerHashMap$p = shopHomeNativeFragment.mBannerHashMap;
            Integer resId = shopBannerResource.getResId();
            if (!Intrinsics.areEqual(access$getMBannerHashMap$p.get(Integer.valueOf(resId == null ? 0 : resId.intValue())), (Object) true)) {
                ShopTrack shopTrack = ShopTrack.INSTANCE;
                Channel access$getMDefaultChannel$p = shopHomeNativeFragment.mDefaultChannel;
                int intValue = (access$getMDefaultChannel$p == null || (id = access$getMDefaultChannel$p.getId()) == null) ? 0 : id.intValue();
                Integer resId2 = shopBannerResource.getResId();
                shopTrack.ad_show(intValue, resId2 == null ? 0 : resId2.intValue());
                Map access$getMBannerHashMap$p2 = shopHomeNativeFragment.mBannerHashMap;
                Integer resId3 = shopBannerResource.getResId();
                access$getMBannerHashMap$p2.put(Integer.valueOf(resId3 == null ? 0 : resId3.intValue()), true);
            }
        }
        XesLog.dt(this.this$0.TAG, new Object[]{Intrinsics.stringPlus("banner onPageSelected position = ", Integer.valueOf(i))});
    }
}
