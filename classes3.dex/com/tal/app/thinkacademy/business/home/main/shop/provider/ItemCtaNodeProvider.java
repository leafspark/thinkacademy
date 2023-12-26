package com.tal.app.thinkacademy.business.home.main.shop.provider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopHomeViewType;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopListener;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataCta;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/provider/ItemCtaNodeProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "shopListener", "Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ShopListener;", "(Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ShopListener;)V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "mShopListener", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "onClick", "view", "Landroid/view/View;", "data", "position", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemCtaNodeProvider.kt */
public final class ItemCtaNodeProvider extends BaseNodeProvider {
    private ShopListener mShopListener;

    public ItemCtaNodeProvider(ShopListener shopListener) {
        Intrinsics.checkNotNullParameter(shopListener, "shopListener");
        this.mShopListener = shopListener;
    }

    public int getItemViewType() {
        return ShopHomeViewType.ITEM_NORMAL_CARD_CTA.getValue();
    }

    public int getLayoutId() {
        return R.layout.shop_item_cta_layout;
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        if (baseNode instanceof ShopHomeDataCta) {
            XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, (ImageView) baseViewHolder.getView(R.id.cta_image), getContext(), ((ShopHomeDataCta) baseNode).getTouchSidePicture(), SizeUtils.dp2px(10.0f), 0, R.drawable.bg_default_image, (RoundedCornersTransformation.CornerType) null, 32, (Object) null);
        }
    }

    public void onClick(BaseViewHolder baseViewHolder, View view, BaseNode baseNode, int i) {
        String str;
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(baseNode, DbParams.KEY_DATA);
        if (baseNode instanceof ShopHomeDataCta) {
            ShopHomeDataCta shopHomeDataCta = (ShopHomeDataCta) baseNode;
            CharSequence touchLink = shopHomeDataCta.getTouchLink();
            if (!(touchLink == null || touchLink.length() == 0)) {
                Bundle bundle = new Bundle();
                bundle.putString("jump_key", new StringBuffer(shopHomeDataCta.getTouchLink()).toString());
                bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setLocalTitle(" ").setShowTitle(false).build());
                XesRoute.getInstance().navigation("/login/coins_activity", bundle);
            }
            ShopTrack shopTrack = ShopTrack.INSTANCE;
            ShopListener shopListener = this.mShopListener;
            String str2 = "";
            if (shopListener == null || (str = shopListener.getChannelName()) == null) {
                str = str2;
            }
            String touchLink2 = shopHomeDataCta.getTouchLink();
            if (touchLink2 != null) {
                str2 = touchLink2;
            }
            shopTrack.hw_shop_cta_card_click(str, str2);
        }
    }
}
