package com.tal.app.thinkacademy.business.shop.bean;

import com.tal.app.thinkacademy.business.shop.bean.gradeaggregatenode.GradeAggregateTitleNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J%\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/GradeAggregateClassListData;", "", "goodsList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodsData;", "node", "Lcom/tal/app/thinkacademy/business/shop/bean/gradeaggregatenode/GradeAggregateTitleNode;", "(Ljava/util/List;Lcom/tal/app/thinkacademy/business/shop/bean/gradeaggregatenode/GradeAggregateTitleNode;)V", "getGoodsList", "()Ljava/util/List;", "setGoodsList", "(Ljava/util/List;)V", "getNode", "()Lcom/tal/app/thinkacademy/business/shop/bean/gradeaggregatenode/GradeAggregateTitleNode;", "setNode", "(Lcom/tal/app/thinkacademy/business/shop/bean/gradeaggregatenode/GradeAggregateTitleNode;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GradeAggregateDetailInfo.kt */
public final class GradeAggregateClassListData {
    private List<ShopClassGoodsData> goodsList;
    private GradeAggregateTitleNode node;

    public static /* synthetic */ GradeAggregateClassListData copy$default(GradeAggregateClassListData gradeAggregateClassListData, List<ShopClassGoodsData> list, GradeAggregateTitleNode gradeAggregateTitleNode, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gradeAggregateClassListData.goodsList;
        }
        if ((i & 2) != 0) {
            gradeAggregateTitleNode = gradeAggregateClassListData.node;
        }
        return gradeAggregateClassListData.copy(list, gradeAggregateTitleNode);
    }

    public final List<ShopClassGoodsData> component1() {
        return this.goodsList;
    }

    public final GradeAggregateTitleNode component2() {
        return this.node;
    }

    public final GradeAggregateClassListData copy(List<ShopClassGoodsData> list, GradeAggregateTitleNode gradeAggregateTitleNode) {
        Intrinsics.checkNotNullParameter(gradeAggregateTitleNode, "node");
        return new GradeAggregateClassListData(list, gradeAggregateTitleNode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GradeAggregateClassListData)) {
            return false;
        }
        GradeAggregateClassListData gradeAggregateClassListData = (GradeAggregateClassListData) obj;
        return Intrinsics.areEqual((Object) this.goodsList, (Object) gradeAggregateClassListData.goodsList) && Intrinsics.areEqual((Object) this.node, (Object) gradeAggregateClassListData.node);
    }

    public int hashCode() {
        List<ShopClassGoodsData> list = this.goodsList;
        return ((list == null ? 0 : list.hashCode()) * 31) + this.node.hashCode();
    }

    public String toString() {
        return "GradeAggregateClassListData(goodsList=" + this.goodsList + ", node=" + this.node + ')';
    }

    public GradeAggregateClassListData(List<ShopClassGoodsData> list, GradeAggregateTitleNode gradeAggregateTitleNode) {
        Intrinsics.checkNotNullParameter(gradeAggregateTitleNode, "node");
        this.goodsList = list;
        this.node = gradeAggregateTitleNode;
    }

    public final List<ShopClassGoodsData> getGoodsList() {
        return this.goodsList;
    }

    public final void setGoodsList(List<ShopClassGoodsData> list) {
        this.goodsList = list;
    }

    public final GradeAggregateTitleNode getNode() {
        return this.node;
    }

    public final void setNode(GradeAggregateTitleNode gradeAggregateTitleNode) {
        Intrinsics.checkNotNullParameter(gradeAggregateTitleNode, "<set-?>");
        this.node = gradeAggregateTitleNode;
    }
}
