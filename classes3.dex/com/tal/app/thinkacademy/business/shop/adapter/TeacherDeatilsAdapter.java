package com.tal.app.thinkacademy.business.shop.adapter;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails.TeacherClasslistItemProvider;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails.TeacherClasslistTitleProvider;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails.TeacherIngachievemProvider;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails.TeacherIntroduceProvider;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails.TeacherRecordedCardNodeProvider;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails.TeacherVideoProvider;
import com.tal.app.thinkacademy.business.shop.bean.RecordedSpec;
import com.tal.app.thinkacademy.business.shop.bean.RecordedTeacherItem;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.bean.ShopItemRecordedCardNode;
import com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData;
import com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherClasslistTitleNode;
import com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherIngachievemNode;
import com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherIntroduceNode;
import com.tal.app.thinkacademy.business.shop.bean.teachernode.TeacherVideoNode;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0014J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0004H\u0016¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/adapter/TeacherDeatilsAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "()V", "getItemType", "", "data", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "position", "onBindViewHolder", "", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDeatilsAdapter.kt */
public final class TeacherDeatilsAdapter extends BaseNodeAdapter {
    public TeacherDeatilsAdapter() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        addFullSpanNodeProvider(new TeacherVideoProvider(0, 0, 3, (DefaultConstructorMarker) null));
        addFullSpanNodeProvider(new TeacherIngachievemProvider(0, 0, 3, (DefaultConstructorMarker) null));
        addFullSpanNodeProvider(new TeacherIntroduceProvider(0, 0, 3, (DefaultConstructorMarker) null));
        addFullSpanNodeProvider(new TeacherClasslistTitleProvider(0, 0, 3, (DefaultConstructorMarker) null));
        addNodeProvider(new TeacherClasslistItemProvider(0, 0, 3, (DefaultConstructorMarker) null));
        addNodeProvider(new TeacherRecordedCardNodeProvider(0, 0, 3, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: protected */
    public int getItemType(List<? extends BaseNode> list, int i) {
        Intrinsics.checkNotNullParameter(list, DbParams.KEY_DATA);
        BaseNode baseNode = list.get(i);
        if (baseNode instanceof TeacherVideoNode) {
            return TeacherDeatilsEnum.VIDEO.getValue();
        }
        if (baseNode instanceof TeacherIngachievemNode) {
            return TeacherDeatilsEnum.TEACHINGACHIEVEMENTS.getValue();
        }
        if (baseNode instanceof TeacherIntroduceNode) {
            return TeacherDeatilsEnum.TEACHERINTRODUCE.getValue();
        }
        if (baseNode instanceof TeacherClasslistTitleNode) {
            return TeacherDeatilsEnum.CLASSLISTTITLE.getValue();
        }
        if (baseNode instanceof ShopClassGoodsData) {
            return TeacherDeatilsEnum.CLASSLISTITEM.getValue();
        }
        if (baseNode instanceof ShopItemRecordedCardNode) {
            return TeacherDeatilsEnum.RECORDEDLESSON.getValue();
        }
        return -1;
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String num;
        RecordedSpec spec;
        List<RecordedTeacherItem> teacherList;
        RecordedTeacherItem recordedTeacherItem;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        TeacherDeatilsAdapter.super.onBindViewHolder(baseViewHolder, i);
        if (hasHeaderLayout()) {
            i--;
        }
        if (i >= 0 && i < getData().size()) {
            ShopRecordedItemData shopRecordedItemData = (BaseNode) getData().get(i);
            if (shopRecordedItemData instanceof ShopRecordedItemData) {
                ShopTrack shopTrack = ShopTrack.INSTANCE;
                ShopRecordedItemData shopRecordedItemData2 = shopRecordedItemData;
                String title = shopRecordedItemData2.getTitle();
                if (title == null) {
                    title = "";
                }
                Long id = shopRecordedItemData2.getId();
                if (id == null || (str = id.toString()) == null) {
                    str = "";
                }
                RecordedSpec spec2 = shopRecordedItemData2.getSpec();
                if (spec2 == null || (str2 = spec2.getSubject()) == null) {
                    str2 = "";
                }
                RecordedSpec spec3 = shopRecordedItemData2.getSpec();
                Collection teacherList2 = spec3 == null ? null : spec3.getTeacherList();
                if ((teacherList2 == null || teacherList2.isEmpty()) || (spec = shopRecordedItemData2.getSpec()) == null || (teacherList = spec.getTeacherList()) == null || (recordedTeacherItem = teacherList.get(0)) == null || (str3 = recordedTeacherItem.getSysName()) == null) {
                    str3 = "";
                }
                Integer showPrice = shopRecordedItemData2.getShowPrice();
                if (showPrice == null || (num = showPrice.toString()) == null) {
                    str4 = "";
                } else {
                    str4 = num;
                }
                shopTrack.hw_recorded_class_card_show(title, str, str2, str3, str4, "teacher detail页面");
            }
        }
    }
}
