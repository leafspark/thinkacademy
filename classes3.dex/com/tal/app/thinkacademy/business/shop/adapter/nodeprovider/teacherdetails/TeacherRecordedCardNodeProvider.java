package com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.TeacherDeatilsEnum;
import com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/nodeprovider/teacherdetails/TeacherRecordedCardNodeProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "itemViewType", "", "layoutId", "(II)V", "getItemViewType", "()I", "getLayoutId", "mSchoolCode", "", "getMSchoolCode", "()Ljava/lang/String;", "mSchoolCode$delegate", "Lkotlin/Lazy;", "convert", "", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherRecordedCardNodeProvider.kt */
public final class TeacherRecordedCardNodeProvider extends BaseNodeProvider {
    private final int itemViewType;
    private final int layoutId;
    private final Lazy mSchoolCode$delegate;

    public TeacherRecordedCardNodeProvider() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TeacherRecordedCardNodeProvider(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? TeacherDeatilsEnum.RECORDEDLESSON.getValue() : i, (i3 & 2) != 0 ? R.layout.bus_shop_teacher_details_recorded_item_list : i2);
    }

    public int getItemViewType() {
        return this.itemViewType;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public TeacherRecordedCardNodeProvider(int i, int i2) {
        this.itemViewType = i;
        this.layoutId = i2;
        this.mSchoolCode$delegate = LazyKt.lazy(TeacherRecordedCardNodeProvider$mSchoolCode$2.INSTANCE);
    }

    private final String getMSchoolCode() {
        return (String) this.mSchoolCode$delegate.getValue();
    }

    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        if (baseNode instanceof ShopRecordedItemData) {
            TeacherRecordedCardNodeProviderKt.recordedClassItemBind(getContext(), baseViewHolder, (ShopRecordedItemData) baseNode, getMSchoolCode());
        }
    }
}
