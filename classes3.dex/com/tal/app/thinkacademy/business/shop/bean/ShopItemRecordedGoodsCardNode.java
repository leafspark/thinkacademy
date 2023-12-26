package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopItemRecordedGoodsCardNode;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "childNode", "", "(Ljava/util/List;)V", "getChildNode", "()Ljava/util/List;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopItemRecordedGoodsCardNode.kt */
public class ShopItemRecordedGoodsCardNode extends BaseNode {
    private final List<BaseNode> childNode;

    public ShopItemRecordedGoodsCardNode() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopItemRecordedGoodsCardNode(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public List<BaseNode> getChildNode() {
        return this.childNode;
    }

    public ShopItemRecordedGoodsCardNode(List<BaseNode> list) {
        this.childNode = list;
    }
}
