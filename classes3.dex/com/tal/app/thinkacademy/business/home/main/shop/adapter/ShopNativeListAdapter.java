package com.tal.app.thinkacademy.business.home.main.shop.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemCtaNode;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemNormalNode;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootFootNode;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootViewMoreNode;
import com.tal.app.thinkacademy.business.home.main.shop.provider.ItemClassCardNodeProvider;
import com.tal.app.thinkacademy.business.home.main.shop.provider.ItemCtaNodeProvider;
import com.tal.app.thinkacademy.business.home.main.shop.provider.ItemNormalNodeProvider;
import com.tal.app.thinkacademy.business.home.main.shop.provider.ItemRecordedCardNodeProvider;
import com.tal.app.thinkacademy.business.home.main.shop.provider.ItemRecordedGoodsCardNodeProvider;
import com.tal.app.thinkacademy.business.home.main.shop.provider.RootFooterNodeProvider;
import com.tal.app.thinkacademy.business.home.main.shop.provider.RootViewMoreNodeProvider;
import com.tal.app.thinkacademy.business.home.main.shop.provider.TitleRootNodeProvider;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.bean.ShopItemClassCardNode;
import com.tal.app.thinkacademy.business.shop.bean.ShopItemRecordedCardNode;
import com.tal.app.thinkacademy.business.shop.bean.ShopItemRecordedGoodsCardNode;
import com.tal.app.thinkacademy.business.shop.trace.ShopTrack;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ShopNativeListAdapter;", "Lcom/chad/library/adapter/base/BaseNodeAdapter;", "shopListener", "Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ShopListener;", "(Lcom/tal/app/thinkacademy/business/home/main/shop/adapter/ShopListener;)V", "mLayoutManger", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mShopListener", "mShopRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemType", "", "data", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "position", "onBindViewHolder", "", "holder", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "reportCourseCard", "node", "reportTrack", "pos", "reportViewMoreShow", "childNode", "setShopRecyclerView", "recyclerView", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopNativeListAdapter.kt */
public final class ShopNativeListAdapter extends BaseNodeAdapter {
    private LinearLayoutManager mLayoutManger;
    private ShopListener mShopListener;
    private RecyclerView mShopRecyclerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopNativeListAdapter(ShopListener shopListener) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(shopListener, "shopListener");
        this.mShopListener = shopListener;
        addFullSpanNodeProvider(new TitleRootNodeProvider());
        addNodeProvider(new RootViewMoreNodeProvider());
        addFooterNodeProvider(new RootFooterNodeProvider(shopListener));
        addNodeProvider(new ItemNormalNodeProvider());
        addNodeProvider(new ItemCtaNodeProvider(shopListener));
        addNodeProvider(new ItemClassCardNodeProvider());
        addNodeProvider(new ItemRecordedCardNodeProvider(0, 0, 3, (DefaultConstructorMarker) null));
        addNodeProvider(new ItemRecordedGoodsCardNodeProvider(0, 0, 3, (DefaultConstructorMarker) null));
    }

    public final void setShopRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.mShopRecyclerView = recyclerView;
        this.mLayoutManger = recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new ShopNativeListAdapter$setShopRecyclerView$1());
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        ShopNativeListAdapter.super.onBindViewHolder(baseViewHolder, i);
        reportTrack(i);
    }

    /* access modifiers changed from: protected */
    public int getItemType(List<? extends BaseNode> list, int i) {
        Intrinsics.checkNotNullParameter(list, DbParams.KEY_DATA);
        BaseNode baseNode = list.get(i);
        if (baseNode instanceof ShopRootTitleNode) {
            return ShopHomeViewType.ROOT_TITLE.getValue();
        }
        if (baseNode instanceof ShopRootViewMoreNode) {
            return ShopHomeViewType.ROOT_VIEW_MORE.getValue();
        }
        if (baseNode instanceof ShopRootFootNode) {
            return ShopHomeViewType.ROOT_VIEW_FOOT.getValue();
        }
        if (baseNode instanceof ShopItemNormalNode) {
            return ShopHomeViewType.ITEM_NORMAL_CARD.getValue();
        }
        if (baseNode instanceof ShopItemCtaNode) {
            return ShopHomeViewType.ITEM_NORMAL_CARD_CTA.getValue();
        }
        if (baseNode instanceof ShopItemClassCardNode) {
            return ShopHomeViewType.ITEM_ClASS_CARD.getValue();
        }
        if (baseNode instanceof ShopItemRecordedCardNode) {
            return ShopHomeViewType.RECORDED_CLASS_CARD.getValue();
        }
        if (baseNode instanceof ShopItemRecordedGoodsCardNode) {
            return ShopHomeViewType.RECORDED_CLASS_GOODS_CARD.getValue();
        }
        return -1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: com.chad.library.adapter.base.entity.node.BaseNode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void reportTrack(int r20) {
        /*
            r19 = this;
            r0 = r19
            boolean r1 = r19.hasHeaderLayout()
            if (r1 == 0) goto L_0x000b
            int r1 = r20 + -1
            goto L_0x000d
        L_0x000b:
            r1 = r20
        L_0x000d:
            if (r1 >= 0) goto L_0x0010
            return
        L_0x0010:
            java.util.List r2 = r19.getData()
            int r2 = r2.size()
            if (r1 >= r2) goto L_0x020d
            java.util.List r2 = r19.getData()
            java.lang.Object r1 = r2.get(r1)
            com.chad.library.adapter.base.entity.node.BaseNode r1 = (com.chad.library.adapter.base.entity.node.BaseNode) r1
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootTitleNode
            if (r2 == 0) goto L_0x002a
            goto L_0x020d
        L_0x002a:
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootViewMoreNode
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x0057
            java.util.List r2 = r1.getChildNode()
            if (r2 == 0) goto L_0x020d
            java.util.List r2 = r1.getChildNode()
            if (r2 != 0) goto L_0x003e
            r2 = r4
            goto L_0x0042
        L_0x003e:
            int r2 = r2.size()
        L_0x0042:
            if (r2 <= 0) goto L_0x020d
            java.util.List r1 = r1.getChildNode()
            if (r1 != 0) goto L_0x004b
            goto L_0x0052
        L_0x004b:
            java.lang.Object r1 = r1.get(r4)
            r3 = r1
            com.chad.library.adapter.base.entity.node.BaseNode r3 = (com.chad.library.adapter.base.entity.node.BaseNode) r3
        L_0x0052:
            r0.reportViewMoreShow(r3)
            goto L_0x020d
        L_0x0057:
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopRootFootNode
            if (r2 == 0) goto L_0x005d
            goto L_0x020d
        L_0x005d:
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemNormalNode
            if (r2 == 0) goto L_0x0066
            r0.reportCourseCard(r1)
            goto L_0x020d
        L_0x0066:
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataCta
            java.lang.String r5 = ""
            if (r2 == 0) goto L_0x008a
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r2 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopListener r3 = r0.mShopListener
            if (r3 != 0) goto L_0x0074
        L_0x0072:
            r3 = r5
            goto L_0x007b
        L_0x0074:
            java.lang.String r3 = r3.getChannelName()
            if (r3 != 0) goto L_0x007b
            goto L_0x0072
        L_0x007b:
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataCta r1 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataCta) r1
            java.lang.String r1 = r1.getTouchLink()
            if (r1 != 0) goto L_0x0084
            goto L_0x0085
        L_0x0084:
            r5 = r1
        L_0x0085:
            r2.hw_shop_cta_card_show(r3, r5)
            goto L_0x020d
        L_0x008a:
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData
            if (r2 == 0) goto L_0x0140
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r6 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData r1 = (com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData) r1
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r2 = r1.getSpec()
            if (r2 != 0) goto L_0x009a
            r7 = r4
            goto L_0x009f
        L_0x009a:
            int r2 = r2.getCourseId()
            r7 = r2
        L_0x009f:
            java.lang.String r2 = r1.getTitle()
            if (r2 != 0) goto L_0x00a7
            r8 = r5
            goto L_0x00a8
        L_0x00a7:
            r8 = r2
        L_0x00a8:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r2 = r1.getSpec()
            if (r2 != 0) goto L_0x00b0
            r9 = r4
            goto L_0x00b5
        L_0x00b0:
            int r2 = r2.getClazzId()
            r9 = r2
        L_0x00b5:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r2 = r1.getSpec()
            if (r2 != 0) goto L_0x00bd
        L_0x00bb:
            r10 = r5
            goto L_0x00c5
        L_0x00bd:
            java.lang.String r2 = r2.getLevelDegreeName()
            if (r2 != 0) goto L_0x00c4
            goto L_0x00bb
        L_0x00c4:
            r10 = r2
        L_0x00c5:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r2 = r1.getSpec()
            if (r2 != 0) goto L_0x00cd
            r11 = r4
            goto L_0x00d2
        L_0x00cd:
            int r2 = r2.getCourseType()
            r11 = r2
        L_0x00d2:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r2 = r1.getSpec()
            if (r2 != 0) goto L_0x00da
        L_0x00d8:
            r12 = r4
            goto L_0x00ed
        L_0x00da:
            java.lang.String r2 = r2.getPlatformType()
            if (r2 != 0) goto L_0x00e1
            goto L_0x00d8
        L_0x00e1:
            java.lang.Integer r2 = kotlin.text.StringsKt.toIntOrNull(r2)
            if (r2 != 0) goto L_0x00e8
            goto L_0x00d8
        L_0x00e8:
            int r2 = r2.intValue()
            r12 = r2
        L_0x00ed:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r2 = r1.getSpec()
            if (r2 != 0) goto L_0x00f5
        L_0x00f3:
            r13 = r5
            goto L_0x00fd
        L_0x00f5:
            java.lang.String r2 = r2.getYear()
            if (r2 != 0) goto L_0x00fc
            goto L_0x00f3
        L_0x00fc:
            r13 = r2
        L_0x00fd:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r2 = r1.getSpec()
            if (r2 != 0) goto L_0x0105
            r14 = r4
            goto L_0x010a
        L_0x0105:
            int r2 = r2.getTerm()
            r14 = r2
        L_0x010a:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r2 = r1.getSpec()
            if (r2 != 0) goto L_0x0112
        L_0x0110:
            r15 = r5
            goto L_0x011a
        L_0x0112:
            java.lang.String r2 = r2.getSubject()
            if (r2 != 0) goto L_0x0119
            goto L_0x0110
        L_0x0119:
            r15 = r2
        L_0x011a:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r2 = r1.getSpec()
            if (r2 != 0) goto L_0x0123
        L_0x0120:
            r16 = r5
            goto L_0x012c
        L_0x0123:
            java.lang.String r2 = r2.getGradeName()
            if (r2 != 0) goto L_0x012a
            goto L_0x0120
        L_0x012a:
            r16 = r2
        L_0x012c:
            com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsSpecData r1 = r1.getSpec()
            if (r1 != 0) goto L_0x0133
            goto L_0x0137
        L_0x0133:
            int r4 = r1.getSubPlatformType()
        L_0x0137:
            r17 = r4
            java.lang.String r18 = "商城"
            r6.hw_shop_class_card_show(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x020d
        L_0x0140:
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData
            if (r2 == 0) goto L_0x01c3
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r6 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData r1 = (com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData) r1
            java.lang.String r2 = r1.getTitle()
            if (r2 != 0) goto L_0x0150
            r7 = r5
            goto L_0x0151
        L_0x0150:
            r7 = r2
        L_0x0151:
            java.lang.Long r2 = r1.getId()
            if (r2 != 0) goto L_0x0159
        L_0x0157:
            r8 = r5
            goto L_0x0161
        L_0x0159:
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L_0x0160
            goto L_0x0157
        L_0x0160:
            r8 = r2
        L_0x0161:
            com.tal.app.thinkacademy.business.shop.bean.RecordedSpec r2 = r1.getSpec()
            if (r2 != 0) goto L_0x0169
        L_0x0167:
            r9 = r5
            goto L_0x0171
        L_0x0169:
            java.lang.String r2 = r2.getSubject()
            if (r2 != 0) goto L_0x0170
            goto L_0x0167
        L_0x0170:
            r9 = r2
        L_0x0171:
            com.tal.app.thinkacademy.business.shop.bean.RecordedSpec r2 = r1.getSpec()
            if (r2 != 0) goto L_0x0178
            goto L_0x017c
        L_0x0178:
            java.util.List r3 = r2.getTeacherList()
        L_0x017c:
            java.util.Collection r3 = (java.util.Collection) r3
            if (r3 == 0) goto L_0x0189
            boolean r2 = r3.isEmpty()
            if (r2 == 0) goto L_0x0187
            goto L_0x0189
        L_0x0187:
            r2 = r4
            goto L_0x018a
        L_0x0189:
            r2 = 1
        L_0x018a:
            if (r2 == 0) goto L_0x018e
        L_0x018c:
            r10 = r5
            goto L_0x01ad
        L_0x018e:
            com.tal.app.thinkacademy.business.shop.bean.RecordedSpec r2 = r1.getSpec()
            if (r2 != 0) goto L_0x0195
            goto L_0x018c
        L_0x0195:
            java.util.List r2 = r2.getTeacherList()
            if (r2 != 0) goto L_0x019c
            goto L_0x018c
        L_0x019c:
            java.lang.Object r2 = r2.get(r4)
            com.tal.app.thinkacademy.business.shop.bean.RecordedTeacherItem r2 = (com.tal.app.thinkacademy.business.shop.bean.RecordedTeacherItem) r2
            if (r2 != 0) goto L_0x01a5
            goto L_0x018c
        L_0x01a5:
            java.lang.String r2 = r2.getSysName()
            if (r2 != 0) goto L_0x01ac
            goto L_0x018c
        L_0x01ac:
            r10 = r2
        L_0x01ad:
            java.lang.Integer r1 = r1.getShowPrice()
            if (r1 != 0) goto L_0x01b5
        L_0x01b3:
            r11 = r5
            goto L_0x01bd
        L_0x01b5:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x01bc
            goto L_0x01b3
        L_0x01bc:
            r11 = r1
        L_0x01bd:
            java.lang.String r12 = "courses页面"
            r6.hw_recorded_class_card_show(r7, r8, r9, r10, r11, r12)
            goto L_0x020d
        L_0x01c3:
            boolean r2 = r1 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemData
            if (r2 == 0) goto L_0x020d
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r6 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemData r1 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemData) r1
            java.lang.Integer r2 = r1.getCategoryType()
            if (r2 != 0) goto L_0x01d3
            r2 = 3
            goto L_0x01d7
        L_0x01d3:
            int r2 = r2.intValue()
        L_0x01d7:
            r7 = r2
            java.lang.String r2 = r1.getCategoryName()
            if (r2 != 0) goto L_0x01e0
            r8 = r5
            goto L_0x01e1
        L_0x01e0:
            r8 = r2
        L_0x01e1:
            java.lang.String r2 = r1.getTitle()
            if (r2 != 0) goto L_0x01e9
            r9 = r5
            goto L_0x01ea
        L_0x01e9:
            r9 = r2
        L_0x01ea:
            java.lang.Long r2 = r1.getId()
            if (r2 != 0) goto L_0x01f2
        L_0x01f0:
            r10 = r5
            goto L_0x01fa
        L_0x01f2:
            java.lang.String r2 = r2.toString()
            if (r2 != 0) goto L_0x01f9
            goto L_0x01f0
        L_0x01f9:
            r10 = r2
        L_0x01fa:
            java.lang.Integer r1 = r1.getShowPrice()
            if (r1 != 0) goto L_0x0202
        L_0x0200:
            r11 = r5
            goto L_0x020a
        L_0x0202:
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L_0x0209
            goto L_0x0200
        L_0x0209:
            r11 = r1
        L_0x020a:
            r6.hw_universal_goods_card_show(r7, r8, r9, r10, r11)
        L_0x020d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopNativeListAdapter.reportTrack(int):void");
    }

    private final void reportViewMoreShow(BaseNode baseNode) {
        int i = 0;
        if (baseNode instanceof ShopHomeDataType1Course) {
            ShopTrack shopTrack = ShopTrack.INSTANCE;
            ShopListener shopListener = this.mShopListener;
            if (shopListener != null) {
                i = shopListener.getChannelId();
            }
            shopTrack.hw_shop_card_more_show(i, ShopTrack.ShopColumnType.COURSE_CARD);
        } else if (baseNode instanceof ShopHomeDataType12CourseConfig) {
            ShopTrack shopTrack2 = ShopTrack.INSTANCE;
            ShopListener shopListener2 = this.mShopListener;
            if (shopListener2 != null) {
                i = shopListener2.getChannelId();
            }
            shopTrack2.hw_shop_card_more_show(i, ShopTrack.ShopColumnType.COURSE_TOGETHER);
        } else if (baseNode instanceof ShopClassGoodsData) {
            ShopTrack shopTrack3 = ShopTrack.INSTANCE;
            ShopListener shopListener3 = this.mShopListener;
            if (shopListener3 != null) {
                i = shopListener3.getChannelId();
            }
            shopTrack3.hw_shop_card_more_show(i, ShopTrack.ShopColumnType.CLASS_CARD);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void reportCourseCard(com.chad.library.adapter.base.entity.node.BaseNode r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course
            r1 = 0
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x003b
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r3 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course r10 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course) r10
            java.lang.Integer r0 = r10.getCourseId()
            if (r0 != 0) goto L_0x0012
            goto L_0x0016
        L_0x0012:
            int r1 = r0.intValue()
        L_0x0016:
            r4 = r1
            java.lang.String r0 = r10.getShowName()
            if (r0 != 0) goto L_0x001f
            r5 = r2
            goto L_0x0020
        L_0x001f:
            r5 = r0
        L_0x0020:
            if (r10 != 0) goto L_0x0024
        L_0x0022:
            r6 = r2
            goto L_0x002c
        L_0x0024:
            java.lang.String r0 = r10.getLevelDegreeName()
            if (r0 != 0) goto L_0x002b
            goto L_0x0022
        L_0x002b:
            r6 = r0
        L_0x002c:
            java.lang.String r10 = r10.getSubjectTag()
            if (r10 != 0) goto L_0x0034
            r7 = r2
            goto L_0x0035
        L_0x0034:
            r7 = r10
        L_0x0035:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack$ShopLinkType r8 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.ShopLinkType.JUMP_CLASS_LIST_PAGE
            r3.hw_shop_course_card_show(r4, r5, r6, r7, r8)
            goto L_0x0087
        L_0x003b:
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig
            if (r0 == 0) goto L_0x0087
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig r10 = (com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig) r10
            java.util.List r0 = r10.getLevelDegreeList()
            if (r0 == 0) goto L_0x0064
            java.util.List r0 = r10.getLevelDegreeList()
            if (r0 != 0) goto L_0x004f
            r0 = r1
            goto L_0x0053
        L_0x004f:
            int r0 = r0.size()
        L_0x0053:
            if (r0 <= 0) goto L_0x0064
            java.util.List r0 = r10.getLevelDegreeList()
            if (r0 != 0) goto L_0x005d
            r0 = 0
            goto L_0x0065
        L_0x005d:
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0065
        L_0x0064:
            r0 = r2
        L_0x0065:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack r3 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.INSTANCE
            int r4 = r10.getPageId()
            java.lang.String r1 = r10.getName()
            if (r1 != 0) goto L_0x0073
            r5 = r2
            goto L_0x0074
        L_0x0073:
            r5 = r1
        L_0x0074:
            if (r0 != 0) goto L_0x0078
            r6 = r2
            goto L_0x0079
        L_0x0078:
            r6 = r0
        L_0x0079:
            java.lang.String r10 = r10.getSubjectTag()
            if (r10 != 0) goto L_0x0081
            r7 = r2
            goto L_0x0082
        L_0x0081:
            r7 = r10
        L_0x0082:
            com.tal.app.thinkacademy.business.shop.trace.ShopTrack$ShopLinkType r8 = com.tal.app.thinkacademy.business.shop.trace.ShopTrack.ShopLinkType.JUMP_CLASS_LIST_PAGE
            r3.hw_shop_course_card_show(r4, r5, r6, r7, r8)
        L_0x0087:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.adapter.ShopNativeListAdapter.reportCourseCard(com.chad.library.adapter.base.entity.node.BaseNode):void");
    }
}
