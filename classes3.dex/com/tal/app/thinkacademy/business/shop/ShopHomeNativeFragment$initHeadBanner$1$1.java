package com.tal.app.thinkacademy.business.shop;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.home.main.shop.bean.Channel;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerResource;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.lib.imageloader.ImageRequestListener;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.progress.OnProgressListener;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J,\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"com/tal/app/thinkacademy/business/shop/ShopHomeNativeFragment$initHeadBanner$1$1", "Lcom/youth/banner/adapter/BannerImageAdapter;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerResource;", "onBindView", "", "holder", "Lcom/youth/banner/holder/BannerImageHolder;", "data", "position", "", "size", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeNativeFragment.kt */
public final class ShopHomeNativeFragment$initHeadBanner$1$1 extends BannerImageAdapter<ShopBannerResource> {
    final /* synthetic */ ShopHomeNativeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopHomeNativeFragment$initHeadBanner$1$1(ShopHomeNativeFragment shopHomeNativeFragment) {
        super((List) null);
        this.this$0 = shopHomeNativeFragment;
    }

    public void onBindView(BannerImageHolder bannerImageHolder, ShopBannerResource shopBannerResource, int i, int i2) {
        ImageView imageView;
        ImageView imageView2;
        String str;
        if (!(bannerImageHolder == null || (imageView2 = bannerImageHolder.imageView) == null)) {
            XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
            Context context = bannerImageHolder.imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "holder.imageView.context");
            if (shopBannerResource == null) {
                str = null;
            } else {
                str = shopBannerResource.getSrc();
            }
            XesImageLoader.loadImage$default(xesImageLoader, imageView2, context, str, R.drawable.bg_default_image, (OnProgressListener) null, (ImageRequestListener) null, 24, (Object) null);
        }
        if (bannerImageHolder != null && (imageView = bannerImageHolder.imageView) != null) {
            imageView.setOnClickListener(new ShopHomeNativeFragment$initHeadBanner$1$1$$ExternalSyntheticLambda0(shopBannerResource, this.this$0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindView$lambda-0  reason: not valid java name */
    public static final void m204onBindView$lambda0(ShopBannerResource shopBannerResource, ShopHomeNativeFragment shopHomeNativeFragment, View view) {
        Integer resId;
        Integer id;
        Intrinsics.checkNotNullParameter(shopHomeNativeFragment, "this$0");
        String str = null;
        CharSequence url = shopBannerResource == null ? null : shopBannerResource.getUrl();
        int i = 0;
        if (!(url == null || url.length() == 0)) {
            Bundle bundle = new Bundle();
            if (shopBannerResource != null) {
                str = shopBannerResource.getUrl();
            }
            bundle.putString("jump_key", new StringBuffer(str).toString());
            bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setLocalTitle(" ").setShowTitle(false).build());
            XesRoute.getInstance().navigation("/login/coins_activity", bundle);
        }
        ShopTrack shopTrack = ShopTrack.INSTANCE;
        Channel access$getMDefaultChannel$p = shopHomeNativeFragment.mDefaultChannel;
        int intValue = (access$getMDefaultChannel$p == null || (id = access$getMDefaultChannel$p.getId()) == null) ? 0 : id.intValue();
        if (!(shopBannerResource == null || (resId = shopBannerResource.getResId()) == null)) {
            i = resId.intValue();
        }
        shopTrack.ad_click(intValue, i);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
