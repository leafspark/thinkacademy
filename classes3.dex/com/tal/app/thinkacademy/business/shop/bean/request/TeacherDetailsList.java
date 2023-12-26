package com.tal.app.thinkacademy.business.shop.bean.request;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import com.tal.app.thinkacademy.business.shop.bean.ShopRecordedItemData;
import com.tal.app.thinkacademy.business.shop.bean.TeacherRecordedData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B_\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003Jc\u0010\u001f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/TeacherDetailsList;", "", "shortGoodsList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodsData;", "longGoodsList", "recordGoodsList", "Lcom/tal/app/thinkacademy/business/shop/bean/TeacherRecordedData;", "recordList", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopRecordedItemData;", "nodeList", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getLongGoodsList", "()Ljava/util/List;", "setLongGoodsList", "(Ljava/util/List;)V", "getNodeList", "setNodeList", "getRecordGoodsList", "setRecordGoodsList", "getRecordList", "setRecordList", "getShortGoodsList", "setShortGoodsList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherDetailsList.kt */
public final class TeacherDetailsList {
    private List<ShopClassGoodsData> longGoodsList;
    private List<? extends BaseNode> nodeList;
    private List<TeacherRecordedData> recordGoodsList;
    private List<ShopRecordedItemData> recordList;
    private List<ShopClassGoodsData> shortGoodsList;

    public TeacherDetailsList() {
        this((List) null, (List) null, (List) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TeacherDetailsList copy$default(TeacherDetailsList teacherDetailsList, List<ShopClassGoodsData> list, List<ShopClassGoodsData> list2, List<TeacherRecordedData> list3, List<ShopRecordedItemData> list4, List<? extends BaseNode> list5, int i, Object obj) {
        if ((i & 1) != 0) {
            list = teacherDetailsList.shortGoodsList;
        }
        if ((i & 2) != 0) {
            list2 = teacherDetailsList.longGoodsList;
        }
        List<ShopClassGoodsData> list6 = list2;
        if ((i & 4) != 0) {
            list3 = teacherDetailsList.recordGoodsList;
        }
        List<TeacherRecordedData> list7 = list3;
        if ((i & 8) != 0) {
            list4 = teacherDetailsList.recordList;
        }
        List<ShopRecordedItemData> list8 = list4;
        if ((i & 16) != 0) {
            list5 = teacherDetailsList.nodeList;
        }
        return teacherDetailsList.copy(list, list6, list7, list8, list5);
    }

    public final List<ShopClassGoodsData> component1() {
        return this.shortGoodsList;
    }

    public final List<ShopClassGoodsData> component2() {
        return this.longGoodsList;
    }

    public final List<TeacherRecordedData> component3() {
        return this.recordGoodsList;
    }

    public final List<ShopRecordedItemData> component4() {
        return this.recordList;
    }

    public final List<BaseNode> component5() {
        return this.nodeList;
    }

    public final TeacherDetailsList copy(List<ShopClassGoodsData> list, List<ShopClassGoodsData> list2, List<TeacherRecordedData> list3, List<ShopRecordedItemData> list4, List<? extends BaseNode> list5) {
        return new TeacherDetailsList(list, list2, list3, list4, list5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TeacherDetailsList)) {
            return false;
        }
        TeacherDetailsList teacherDetailsList = (TeacherDetailsList) obj;
        return Intrinsics.areEqual((Object) this.shortGoodsList, (Object) teacherDetailsList.shortGoodsList) && Intrinsics.areEqual((Object) this.longGoodsList, (Object) teacherDetailsList.longGoodsList) && Intrinsics.areEqual((Object) this.recordGoodsList, (Object) teacherDetailsList.recordGoodsList) && Intrinsics.areEqual((Object) this.recordList, (Object) teacherDetailsList.recordList) && Intrinsics.areEqual((Object) this.nodeList, (Object) teacherDetailsList.nodeList);
    }

    public int hashCode() {
        List<ShopClassGoodsData> list = this.shortGoodsList;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<ShopClassGoodsData> list2 = this.longGoodsList;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<TeacherRecordedData> list3 = this.recordGoodsList;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<ShopRecordedItemData> list4 = this.recordList;
        int hashCode4 = (hashCode3 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<? extends BaseNode> list5 = this.nodeList;
        if (list5 != null) {
            i = list5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "TeacherDetailsList(shortGoodsList=" + this.shortGoodsList + ", longGoodsList=" + this.longGoodsList + ", recordGoodsList=" + this.recordGoodsList + ", recordList=" + this.recordList + ", nodeList=" + this.nodeList + ')';
    }

    public TeacherDetailsList(List<ShopClassGoodsData> list, List<ShopClassGoodsData> list2, List<TeacherRecordedData> list3, List<ShopRecordedItemData> list4, List<? extends BaseNode> list5) {
        this.shortGoodsList = list;
        this.longGoodsList = list2;
        this.recordGoodsList = list3;
        this.recordList = list4;
        this.nodeList = list5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TeacherDetailsList(java.util.List r4, java.util.List r5, java.util.List r6, java.util.List r7, java.util.List r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000b
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.List r4 = (java.util.List) r4
        L_0x000b:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0016
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
        L_0x0016:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0023
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = r5
            java.util.List r6 = (java.util.List) r6
        L_0x0023:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0030
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r7 = r5
            java.util.List r7 = (java.util.List) r7
        L_0x0030:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0039
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0039:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.request.TeacherDetailsList.<init>(java.util.List, java.util.List, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<ShopClassGoodsData> getShortGoodsList() {
        return this.shortGoodsList;
    }

    public final void setShortGoodsList(List<ShopClassGoodsData> list) {
        this.shortGoodsList = list;
    }

    public final List<ShopClassGoodsData> getLongGoodsList() {
        return this.longGoodsList;
    }

    public final void setLongGoodsList(List<ShopClassGoodsData> list) {
        this.longGoodsList = list;
    }

    public final List<TeacherRecordedData> getRecordGoodsList() {
        return this.recordGoodsList;
    }

    public final void setRecordGoodsList(List<TeacherRecordedData> list) {
        this.recordGoodsList = list;
    }

    public final List<ShopRecordedItemData> getRecordList() {
        return this.recordList;
    }

    public final void setRecordList(List<ShopRecordedItemData> list) {
        this.recordList = list;
    }

    public final List<BaseNode> getNodeList() {
        return this.nodeList;
    }

    public final void setNodeList(List<? extends BaseNode> list) {
        this.nodeList = list;
    }
}
