package com.tal.app.thinkacademy.business.home.main.shop.provider;

import android.os.Bundle;
import android.view.View;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopHomeViewType;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.ClassListAdapterKt;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/provider/ItemClassCardNodeProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "()V", "itemViewType", "", "getItemViewType", "()I", "layoutId", "getLayoutId", "mClickCount", "getMClickCount", "setMClickCount", "(I)V", "mSchoolCode", "", "getMSchoolCode", "()Ljava/lang/String;", "mSchoolCode$delegate", "Lkotlin/Lazy;", "convert", "", "helper", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "onClick", "view", "Landroid/view/View;", "data", "position", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemClassCardNodeProvider.kt */
public final class ItemClassCardNodeProvider extends BaseNodeProvider {
    private int mClickCount;
    private final Lazy mSchoolCode$delegate = LazyKt.lazy(ItemClassCardNodeProvider$mSchoolCode$2.INSTANCE);

    public int getItemViewType() {
        return ShopHomeViewType.ITEM_ClASS_CARD.getValue();
    }

    public int getLayoutId() {
        return R.layout.item_class;
    }

    private final String getMSchoolCode() {
        return (String) this.mSchoolCode$delegate.getValue();
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        if (baseNode instanceof ShopClassGoodsData) {
            ClassListAdapterKt.classItemBind(getContext(), baseViewHolder, (ShopClassGoodsData) baseNode, getMSchoolCode());
        }
    }

    public final int getMClickCount() {
        return this.mClickCount;
    }

    public final void setMClickCount(int i) {
        this.mClickCount = i;
    }

    public void onClick(BaseViewHolder baseViewHolder, View view, BaseNode baseNode, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String gradeName;
        String subject;
        String year;
        String platformType;
        Integer intOrNull;
        String levelDegreeName;
        BaseNode baseNode2 = baseNode;
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(baseNode2, DbParams.KEY_DATA);
        if (baseNode2 instanceof ShopClassGoodsData) {
            Bundle bundle = new Bundle();
            ShopClassGoodsData shopClassGoodsData = (ShopClassGoodsData) baseNode2;
            bundle.putString("skuId", String.valueOf(shopClassGoodsData.getId()));
            ShopClassGoodsSpecData spec = shopClassGoodsData.getSpec();
            bundle.putString(LearnMaterialsListActivityKt.CLASSID, String.valueOf(spec == null ? null : Integer.valueOf(spec.getClazzId())));
            XesRoute.getInstance().navigation("/shop/class_detail_activity", bundle);
            ShopTrack shopTrack = ShopTrack.INSTANCE;
            ShopClassGoodsSpecData spec2 = shopClassGoodsData.getSpec();
            int courseId = spec2 == null ? 0 : spec2.getCourseId();
            String title = shopClassGoodsData.getTitle();
            String str5 = title == null ? "" : title;
            ShopClassGoodsSpecData spec3 = shopClassGoodsData.getSpec();
            int clazzId = spec3 == null ? 0 : spec3.getClazzId();
            ShopClassGoodsSpecData spec4 = shopClassGoodsData.getSpec();
            if (spec4 == null || (levelDegreeName = spec4.getLevelDegreeName()) == null) {
                str = "";
            } else {
                str = levelDegreeName;
            }
            ShopClassGoodsSpecData spec5 = shopClassGoodsData.getSpec();
            int courseType = spec5 == null ? 0 : spec5.getCourseType();
            ShopClassGoodsSpecData spec6 = shopClassGoodsData.getSpec();
            int intValue = (spec6 == null || (platformType = spec6.getPlatformType()) == null || (intOrNull = StringsKt.toIntOrNull(platformType)) == null) ? 0 : intOrNull.intValue();
            ShopClassGoodsSpecData spec7 = shopClassGoodsData.getSpec();
            if (spec7 == null || (year = spec7.getYear()) == null) {
                str2 = "";
            } else {
                str2 = year;
            }
            ShopClassGoodsSpecData spec8 = shopClassGoodsData.getSpec();
            int term = spec8 == null ? 0 : spec8.getTerm();
            ShopClassGoodsSpecData spec9 = shopClassGoodsData.getSpec();
            if (spec9 == null || (subject = spec9.getSubject()) == null) {
                str3 = "";
            } else {
                str3 = subject;
            }
            ShopClassGoodsSpecData spec10 = shopClassGoodsData.getSpec();
            if (spec10 == null || (gradeName = spec10.getGradeName()) == null) {
                str4 = "";
            } else {
                str4 = gradeName;
            }
            ShopClassGoodsSpecData spec11 = shopClassGoodsData.getSpec();
            shopTrack.hw_shop_class_card_click(courseId, str5, clazzId, str, courseType, intValue, str2, term, str3, str4, spec11 == null ? 0 : spec11.getSubPlatformType(), "商城");
        }
    }
}
