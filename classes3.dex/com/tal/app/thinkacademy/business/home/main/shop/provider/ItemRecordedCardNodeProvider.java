package com.tal.app.thinkacademy.business.home.main.shop.provider;

import android.os.Bundle;
import android.view.View;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopHomeViewType;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.adapter.nodeprovider.teacherdetails.TeacherRecordedCardNodeProviderKt;
import com.tal.app.thinkacademy.business.shop.bean.RecordedSpec;
import com.tal.app.thinkacademy.business.shop.bean.RecordedTeacherItem;
import com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.constants.UrlUtils;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/provider/ItemRecordedCardNodeProvider;", "Lcom/chad/library/adapter/base/provider/BaseNodeProvider;", "itemViewType", "", "layoutId", "(II)V", "getItemViewType", "()I", "getLayoutId", "mSchoolCode", "", "getMSchoolCode", "()Ljava/lang/String;", "mSchoolCode$delegate", "Lkotlin/Lazy;", "convert", "", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "item", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "onClick", "helper", "view", "Landroid/view/View;", "position", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ItemRecordedCardNodeProvider.kt */
public final class ItemRecordedCardNodeProvider extends BaseNodeProvider {
    private final int itemViewType;
    private final int layoutId;
    private final Lazy mSchoolCode$delegate;

    public ItemRecordedCardNodeProvider() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ItemRecordedCardNodeProvider(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ShopHomeViewType.RECORDED_CLASS_CARD.getValue() : i, (i3 & 2) != 0 ? R.layout.bus_shop_item_recorded : i2);
    }

    public int getItemViewType() {
        return this.itemViewType;
    }

    public int getLayoutId() {
        return this.layoutId;
    }

    public ItemRecordedCardNodeProvider(int i, int i2) {
        this.itemViewType = i;
        this.layoutId = i2;
        this.mSchoolCode$delegate = LazyKt.lazy(ItemRecordedCardNodeProvider$mSchoolCode$2.INSTANCE);
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

    public void onClick(BaseViewHolder baseViewHolder, View view, BaseNode baseNode, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String num;
        RecordedSpec spec;
        List<RecordedTeacherItem> teacherList;
        RecordedTeacherItem recordedTeacherItem;
        String sysName;
        String subject;
        String l;
        Intrinsics.checkNotNullParameter(baseViewHolder, "helper");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(baseNode, "item");
        ItemRecordedCardNodeProvider.super.onClick(baseViewHolder, view, baseNode, i);
        if (baseNode instanceof ShopRecordedItemData) {
            Bundle bundle = new Bundle();
            StringBuilder sb = new StringBuilder();
            sb.append(UrlUtils.INSTANCE.getTouchAppV2Host());
            sb.append("/courses/recorded-detail/");
            ShopRecordedItemData shopRecordedItemData = (ShopRecordedItemData) baseNode;
            sb.append(shopRecordedItemData.getId());
            bundle.putString("jump_key", sb.toString());
            boolean z = true;
            bundle.putSerializable(ClassParamsKt.AGENT_CONFIG, new AgentConfig.Builder().setShowProgressBar(true).setLocalTitle("").setShowTitle(false).build());
            XesRoute.getInstance().navigation("/login/coins_activity", bundle);
            ShopTrack shopTrack = ShopTrack.INSTANCE;
            String title = shopRecordedItemData.getTitle();
            if (title == null) {
                str = "";
            } else {
                str = title;
            }
            Long id = shopRecordedItemData.getId();
            if (id == null || (l = id.toString()) == null) {
                str2 = "";
            } else {
                str2 = l;
            }
            RecordedSpec spec2 = shopRecordedItemData.getSpec();
            if (spec2 == null || (subject = spec2.getSubject()) == null) {
                str3 = "";
            } else {
                str3 = subject;
            }
            RecordedSpec spec3 = shopRecordedItemData.getSpec();
            Collection teacherList2 = spec3 == null ? null : spec3.getTeacherList();
            if (teacherList2 != null && !teacherList2.isEmpty()) {
                z = false;
            }
            if (z || (spec = shopRecordedItemData.getSpec()) == null || (teacherList = spec.getTeacherList()) == null || (recordedTeacherItem = teacherList.get(0)) == null || (sysName = recordedTeacherItem.getSysName()) == null) {
                str4 = "";
            } else {
                str4 = sysName;
            }
            Integer showPrice = shopRecordedItemData.getShowPrice();
            if (showPrice == null || (num = showPrice.toString()) == null) {
                str5 = "";
            } else {
                str5 = num;
            }
            shopTrack.hw_recorded_class_card_click(str, str2, str3, str4, str5, "courses页面");
        }
    }
}
