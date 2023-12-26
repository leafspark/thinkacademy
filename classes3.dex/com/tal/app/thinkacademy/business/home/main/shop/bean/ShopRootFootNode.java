package com.tal.app.thinkacademy.business.home.main.shop.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopRootFootNode;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "parentNode", "childNode", "", "isClassCard", "", "(Lcom/chad/library/adapter/base/entity/node/BaseNode;Ljava/util/List;Z)V", "getChildNode", "()Ljava/util/List;", "()Z", "getParentNode", "()Lcom/chad/library/adapter/base/entity/node/BaseNode;", "setParentNode", "(Lcom/chad/library/adapter/base/entity/node/BaseNode;)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopRootFootNode.kt */
public final class ShopRootFootNode extends BaseNode {
    private final List<BaseNode> childNode;
    private final boolean isClassCard;
    private BaseNode parentNode;

    public ShopRootFootNode() {
        this((BaseNode) null, (List) null, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopRootFootNode copy$default(ShopRootFootNode shopRootFootNode, BaseNode baseNode, List<BaseNode> list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            baseNode = shopRootFootNode.parentNode;
        }
        if ((i & 2) != 0) {
            list = shopRootFootNode.getChildNode();
        }
        if ((i & 4) != 0) {
            z = shopRootFootNode.isClassCard;
        }
        return shopRootFootNode.copy(baseNode, list, z);
    }

    public final BaseNode component1() {
        return this.parentNode;
    }

    public final List<BaseNode> component2() {
        return getChildNode();
    }

    public final boolean component3() {
        return this.isClassCard;
    }

    public final ShopRootFootNode copy(BaseNode baseNode, List<BaseNode> list, boolean z) {
        return new ShopRootFootNode(baseNode, list, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopRootFootNode)) {
            return false;
        }
        ShopRootFootNode shopRootFootNode = (ShopRootFootNode) obj;
        return Intrinsics.areEqual((Object) this.parentNode, (Object) shopRootFootNode.parentNode) && Intrinsics.areEqual((Object) getChildNode(), (Object) shopRootFootNode.getChildNode()) && this.isClassCard == shopRootFootNode.isClassCard;
    }

    public int hashCode() {
        BaseNode baseNode = this.parentNode;
        int i = 0;
        int hashCode = (baseNode == null ? 0 : baseNode.hashCode()) * 31;
        if (getChildNode() != null) {
            i = getChildNode().hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.isClassCard;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "ShopRootFootNode(parentNode=" + this.parentNode + ", childNode=" + getChildNode() + ", isClassCard=" + this.isClassCard + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopRootFootNode(BaseNode baseNode, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : baseNode, (i & 2) != 0 ? null : list, (i & 4) != 0 ? false : z);
    }

    public final BaseNode getParentNode() {
        return this.parentNode;
    }

    public final void setParentNode(BaseNode baseNode) {
        this.parentNode = baseNode;
    }

    public List<BaseNode> getChildNode() {
        return this.childNode;
    }

    public final boolean isClassCard() {
        return this.isClassCard;
    }

    public ShopRootFootNode(BaseNode baseNode, List<BaseNode> list, boolean z) {
        this.parentNode = baseNode;
        this.childNode = list;
        this.isClassCard = z;
    }
}
