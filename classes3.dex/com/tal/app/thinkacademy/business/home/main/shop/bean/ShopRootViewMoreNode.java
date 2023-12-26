package com.tal.app.thinkacademy.business.home.main.shop.bean;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.entity.node.NodeFooterImp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J%\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopRootViewMoreNode;", "Lcom/chad/library/adapter/base/entity/node/BaseExpandNode;", "Lcom/chad/library/adapter/base/entity/node/NodeFooterImp;", "childNode", "", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "isClassViewMore", "", "(Ljava/util/List;Z)V", "getChildNode", "()Ljava/util/List;", "footerNode", "getFooterNode", "()Lcom/chad/library/adapter/base/entity/node/BaseNode;", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopRootViewMoreNode.kt */
public final class ShopRootViewMoreNode extends BaseExpandNode implements NodeFooterImp {
    private final List<BaseNode> childNode;
    private final boolean isClassViewMore;

    public static /* synthetic */ ShopRootViewMoreNode copy$default(ShopRootViewMoreNode shopRootViewMoreNode, List<BaseNode> list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shopRootViewMoreNode.getChildNode();
        }
        if ((i & 2) != 0) {
            z = shopRootViewMoreNode.isClassViewMore;
        }
        return shopRootViewMoreNode.copy(list, z);
    }

    public final List<BaseNode> component1() {
        return getChildNode();
    }

    public final boolean component2() {
        return this.isClassViewMore;
    }

    public final ShopRootViewMoreNode copy(List<BaseNode> list, boolean z) {
        return new ShopRootViewMoreNode(list, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopRootViewMoreNode)) {
            return false;
        }
        ShopRootViewMoreNode shopRootViewMoreNode = (ShopRootViewMoreNode) obj;
        return Intrinsics.areEqual((Object) getChildNode(), (Object) shopRootViewMoreNode.getChildNode()) && this.isClassViewMore == shopRootViewMoreNode.isClassViewMore;
    }

    public int hashCode() {
        int hashCode = (getChildNode() == null ? 0 : getChildNode().hashCode()) * 31;
        boolean z = this.isClassViewMore;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "ShopRootViewMoreNode(childNode=" + getChildNode() + ", isClassViewMore=" + this.isClassViewMore + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopRootViewMoreNode(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? false : z);
    }

    public List<BaseNode> getChildNode() {
        return this.childNode;
    }

    public final boolean isClassViewMore() {
        return this.isClassViewMore;
    }

    public ShopRootViewMoreNode(List<BaseNode> list, boolean z) {
        this.childNode = list;
        this.isClassViewMore = z;
    }

    public BaseNode getFooterNode() {
        return new ShopRootFootNode((BaseNode) this, (List) null, this.isClassViewMore, 2, (DefaultConstructorMarker) null);
    }
}
