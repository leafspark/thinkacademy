package com.tal.app.thinkacademy.business.home.main.shop.provider;

import android.os.Bundle;
import android.view.View;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopHomeViewType;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemData;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/provider/ItemRecordedGoodsCardNodeProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "itemViewType", "", "layoutId", "(II)V", "getItemViewType", "()I", "getLayoutId", "mSchoolCode", "", "getMSchoolCode", "()Ljava/lang/String;", "mSchoolCode$delegate", "Lkotlin/Lazy;", "convert", "", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "onClick", "helper", "view", "Landroid/view/View;", "position", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemRecordedGoodsCardNodeProvider.kt */
public final class ItemRecordedGoodsCardNodeProvider extends BaseNodeProvider {
    private final int itemViewType;
    private final int layoutId;
    private final Lazy mSchoolCode$delegate;

    public ItemRecordedGoodsCardNodeProvider() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemRecordedGoodsCardNodeProvider(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ShopHomeViewType.RECORDED_CLASS_GOODS_CARD.getValue() : i, (i3 & 2) != 0 ? R.layout.bus_shop_item_recorded_goods : i2);
    }

    public int getItemViewType() {
        return this.itemViewType;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public ItemRecordedGoodsCardNodeProvider(int i, int i2) {
        this.itemViewType = i;
        this.layoutId = i2;
        this.mSchoolCode$delegate = LazyKt.lazy(ItemRecordedGoodsCardNodeProvider$mSchoolCode$2.INSTANCE);
    }

    private final String getMSchoolCode() {
        return (String) this.mSchoolCode$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void convert(com.chad.library.adapter.base.viewholder.BaseViewHolder r17, com.chad.library.adapter.base.entity.node.BaseNode r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            java.lang.String r2 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemData
            if (r2 == 0) goto L_0x00c5
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.tvRecordedGoods
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemData r1 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemData) r1
            java.lang.String r3 = r1.getTitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r2, r3)
            java.lang.String[] r2 = r1.getBanners()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0032
            int r2 = r2.length
            if (r2 != 0) goto L_0x002c
            r2 = r3
            goto L_0x002d
        L_0x002c:
            r2 = r4
        L_0x002d:
            if (r2 == 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r2 = r4
            goto L_0x0033
        L_0x0032:
            r2 = r3
        L_0x0033:
            if (r2 == 0) goto L_0x0043
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.ivRecordedGoods
            android.view.View r2 = r0.getView(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            int r5 = com.tal.app.thinkacademy.business.shop.R.drawable.icon_shop_item_placeholder
            r2.setImageResource(r5)
            goto L_0x0068
        L_0x0043:
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader r6 = com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.INSTANCE
            int r2 = com.tal.app.thinkacademy.business.shop.R.id.ivRecordedGoods
            android.view.View r2 = r0.getView(r2)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            android.content.Context r8 = r16.getContext()
            java.lang.String[] r2 = r1.getBanners()
            r9 = r2[r4]
            r2 = 1086324736(0x40c00000, float:6.0)
            int r10 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r2)
            r11 = 0
            int r12 = com.tal.app.thinkacademy.business.shop.R.drawable.icon_shop_item_placeholder
            r13 = 0
            r14 = 32
            r15 = 0
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.loadRoundCornerImage$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
        L_0x0068:
            java.lang.Integer r2 = r1.getShowOrgPrice()
            if (r2 != 0) goto L_0x0070
            r2 = r4
            goto L_0x0074
        L_0x0070:
            int r2 = r2.intValue()
        L_0x0074:
            java.lang.Integer r1 = r1.getShowPrice()
            if (r1 != 0) goto L_0x007c
            r1 = r4
            goto L_0x0080
        L_0x007c:
            int r1 = r1.intValue()
        L_0x0080:
            int r5 = com.tal.app.thinkacademy.business.shop.R.id.tvOrgPrice
            java.lang.String r6 = r16.getMSchoolCode()
            java.lang.String r6 = com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails.TeacherRecordedCardNodeProviderKt.makePrice(r6, r2)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r5, r6)
            int r5 = com.tal.app.thinkacademy.business.shop.R.id.tvOrgPrice
            android.view.View r5 = r0.getView(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.text.TextPaint r5 = r5.getPaint()
            r6 = 16
            r5.setFlags(r6)
            int r5 = com.tal.app.thinkacademy.business.shop.R.id.tvShowPrice
            if (r1 > 0) goto L_0x00af
            android.content.Context r6 = r16.getContext()
            int r7 = com.tal.app.thinkacademy.business.shop.R.string.free
            java.lang.String r6 = r6.getString(r7)
            goto L_0x00b7
        L_0x00af:
            java.lang.String r6 = r16.getMSchoolCode()
            java.lang.String r6 = com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails.TeacherRecordedCardNodeProviderKt.makePrice(r6, r1)
        L_0x00b7:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r5, r6)
            int r5 = com.tal.app.thinkacademy.business.shop.R.id.tvOrgPrice
            if (r2 > r1) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r3 = r4
        L_0x00c2:
            r0.setGone(r5, r3)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.provider.ItemRecordedGoodsCardNodeProvider.convert(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.chad.library.adapter.base.entity.node.BaseNode):void");
    }

    public void onClick(BaseViewHolder baseViewHolder, View view, BaseNode baseNode, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String num;
        String l;
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        ItemRecordedGoodsCardNodeProvider.super.onClick(baseViewHolder, view, baseNode, i);
        if (baseNode instanceof ShopItemData) {
            Bundle bundle = null;
            ShopItemData shopItemData = (ShopItemData) baseNode;
            Integer categoryType = shopItemData.getCategoryType();
            int i2 = 3;
            if (categoryType != null && categoryType.intValue() == 2) {
                bundle = new Bundle();
                bundle.putString("jump_key", UrlUtils.INSTANCE.getTouchAppV2Host() + "/goods/detail/" + shopItemData.getId());
            } else {
                Integer categoryType2 = shopItemData.getCategoryType();
                if (categoryType2 != null && categoryType2.intValue() == 3) {
                    bundle = new Bundle();
                    bundle.putString("jump_key", UrlUtils.INSTANCE.getTouchAppV2Host() + "/courses/recorded-detail/" + shopItemData.getId());
                }
            }
            if (bundle != null) {
                bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setLocalTitle("").setShowTitle(false).build());
                XesRoute.getInstance().navigation("/login/coins_activity", bundle);
            }
            ShopTrack shopTrack = ShopTrack.INSTANCE;
            Integer categoryType3 = shopItemData.getCategoryType();
            if (categoryType3 != null) {
                i2 = categoryType3.intValue();
            }
            int i3 = i2;
            String categoryName = shopItemData.getCategoryName();
            if (categoryName == null) {
                str = "";
            } else {
                str = categoryName;
            }
            String title = shopItemData.getTitle();
            if (title == null) {
                str2 = "";
            } else {
                str2 = title;
            }
            Long id = shopItemData.getId();
            if (id == null || (l = id.toString()) == null) {
                str3 = "";
            } else {
                str3 = l;
            }
            Integer showPrice = shopItemData.getShowPrice();
            if (showPrice == null || (num = showPrice.toString()) == null) {
                str4 = "";
            } else {
                str4 = num;
            }
            shopTrack.hw_universal_goods_card_click(i3, str, str2, str3, str4);
        }
    }
}
