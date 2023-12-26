package com.tal.app.thinkacademy.business.shop;

import com.tal.app.thinkacademy.business.home.main.shop.bean.Channel;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Channel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeNativeFragment.kt */
final class ShopHomeNativeFragment$getChannelDialog$1$1 extends Lambda implements Function1<Channel, Unit> {
    final /* synthetic */ ShopHomeNativeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShopHomeNativeFragment$getChannelDialog$1$1(ShopHomeNativeFragment shopHomeNativeFragment) {
        super(1);
        this.this$0 = shopHomeNativeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Channel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Channel channel) {
        Integer id;
        String name;
        Intrinsics.checkNotNullParameter(channel, "it");
        this.this$0.mDefaultChannel = channel;
        ShopHomeNativeFragment shopHomeNativeFragment = this.this$0;
        Channel access$getMDefaultChannel$p = shopHomeNativeFragment.mDefaultChannel;
        shopHomeNativeFragment.setTitleChannelName(access$getMDefaultChannel$p == null ? null : access$getMDefaultChannel$p.getName());
        Channel access$getMDefaultChannel$p2 = this.this$0.mDefaultChannel;
        if (access$getMDefaultChannel$p2 != null && (id = access$getMDefaultChannel$p2.getId()) != null) {
            ShopHomeNativeFragment shopHomeNativeFragment2 = this.this$0;
            id.intValue();
            ShopTrack shopTrack = ShopTrack.INSTANCE;
            Channel access$getMDefaultChannel$p3 = shopHomeNativeFragment2.mDefaultChannel;
            String str = "";
            if (!(access$getMDefaultChannel$p3 == null || (name = access$getMDefaultChannel$p3.getName()) == null)) {
                str = name;
            }
            shopTrack.hw_shop_channel_click(str);
            shopHomeNativeFragment2.showFullLoading();
            shopHomeNativeFragment2.removeHeadView();
            shopHomeNativeFragment2.removeFootView();
            shopHomeNativeFragment2.mShopNativeListAdapter.setList((Collection) null);
            shopHomeNativeFragment2.requestHome();
            Unit unit = Unit.INSTANCE;
            XesLog.dt(this.this$0.TAG, new Object[]{"id is null"});
        }
    }
}
