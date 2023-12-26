package com.tal.app.thinkacademy.business.shop.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/ClassListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodsData;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "schoolCode", "", "(Ljava/lang/String;)V", "convert", "", "holder", "item", "convertClassItem", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassListAdapter.kt */
public final class ClassListAdapter extends BaseQuickAdapter<ShopClassGoodsData, BaseViewHolder> implements LoadMoreModule {
    private String schoolCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClassListAdapter(String str) {
        super(R.layout.item_class, (List) null);
        Intrinsics.checkNotNullParameter(str, "schoolCode");
        this.schoolCode = str;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, ShopClassGoodsData shopClassGoodsData) {
        String str;
        String str2;
        String str3;
        String str4;
        String platformType;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(shopClassGoodsData, "item");
        convertClassItem(baseViewHolder, shopClassGoodsData);
        ShopTrack shopTrack = ShopTrack.INSTANCE;
        ShopClassGoodsSpecData spec = shopClassGoodsData.getSpec();
        int courseId = spec == null ? 0 : spec.getCourseId();
        String title = shopClassGoodsData.getTitle();
        if (title == null) {
            title = "";
        }
        ShopClassGoodsSpecData spec2 = shopClassGoodsData.getSpec();
        int clazzId = spec2 == null ? 0 : spec2.getClazzId();
        ShopClassGoodsSpecData spec3 = shopClassGoodsData.getSpec();
        if (spec3 == null || (str = spec3.getLevelDegreeName()) == null) {
            str = "";
        }
        ShopClassGoodsSpecData spec4 = shopClassGoodsData.getSpec();
        int courseType = spec4 == null ? 0 : spec4.getCourseType();
        ShopClassGoodsSpecData spec5 = shopClassGoodsData.getSpec();
        int intValue = (spec5 == null || (platformType = spec5.getPlatformType()) == null || (intOrNull = StringsKt.toIntOrNull(platformType)) == null) ? 0 : intOrNull.intValue();
        ShopClassGoodsSpecData spec6 = shopClassGoodsData.getSpec();
        if (spec6 == null || (str2 = spec6.getYear()) == null) {
            str2 = "";
        }
        ShopClassGoodsSpecData spec7 = shopClassGoodsData.getSpec();
        int term = spec7 == null ? 0 : spec7.getTerm();
        ShopClassGoodsSpecData spec8 = shopClassGoodsData.getSpec();
        if (spec8 == null || (str3 = spec8.getSubject()) == null) {
            str3 = "";
        }
        ShopClassGoodsSpecData spec9 = shopClassGoodsData.getSpec();
        if (spec9 == null || (str4 = spec9.getGradeName()) == null) {
            str4 = "";
        }
        ShopClassGoodsSpecData spec10 = shopClassGoodsData.getSpec();
        shopTrack.hw_shop_class_card_show(courseId, title, clazzId, str, courseType, intValue, str2, term, str3, str4, spec10 == null ? 0 : spec10.getSubPlatformType(), "班级列表页");
    }

    private final void convertClassItem(BaseViewHolder baseViewHolder, ShopClassGoodsData shopClassGoodsData) {
        ClassListAdapterKt.classItemBind(getContext(), baseViewHolder, shopClassGoodsData, this.schoolCode);
    }
}
