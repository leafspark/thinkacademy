package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPortrait;", "", "describes", "", "", "illustrations", "placement", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPlacement;", "(Ljava/util/List;Ljava/util/List;Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPlacement;)V", "getDescribes", "()Ljava/util/List;", "getIllustrations", "getPlacement", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPlacement;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailPortrait {
    private final List<String> describes;
    private final List<String> illustrations;
    private final ShopClassDetailPlacement placement;

    public ShopClassDetailPortrait() {
        this((List) null, (List) null, (ShopClassDetailPlacement) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailPortrait copy$default(ShopClassDetailPortrait shopClassDetailPortrait, List<String> list, List<String> list2, ShopClassDetailPlacement shopClassDetailPlacement, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shopClassDetailPortrait.describes;
        }
        if ((i & 2) != 0) {
            list2 = shopClassDetailPortrait.illustrations;
        }
        if ((i & 4) != 0) {
            shopClassDetailPlacement = shopClassDetailPortrait.placement;
        }
        return shopClassDetailPortrait.copy(list, list2, shopClassDetailPlacement);
    }

    public final List<String> component1() {
        return this.describes;
    }

    public final List<String> component2() {
        return this.illustrations;
    }

    public final ShopClassDetailPlacement component3() {
        return this.placement;
    }

    public final ShopClassDetailPortrait copy(List<String> list, List<String> list2, ShopClassDetailPlacement shopClassDetailPlacement) {
        return new ShopClassDetailPortrait(list, list2, shopClassDetailPlacement);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailPortrait)) {
            return false;
        }
        ShopClassDetailPortrait shopClassDetailPortrait = (ShopClassDetailPortrait) obj;
        return Intrinsics.areEqual((Object) this.describes, (Object) shopClassDetailPortrait.describes) && Intrinsics.areEqual((Object) this.illustrations, (Object) shopClassDetailPortrait.illustrations) && Intrinsics.areEqual((Object) this.placement, (Object) shopClassDetailPortrait.placement);
    }

    public int hashCode() {
        List<String> list = this.describes;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.illustrations;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        ShopClassDetailPlacement shopClassDetailPlacement = this.placement;
        if (shopClassDetailPlacement != null) {
            i = shopClassDetailPlacement.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ShopClassDetailPortrait(describes=" + this.describes + ", illustrations=" + this.illustrations + ", placement=" + this.placement + ')';
    }

    public ShopClassDetailPortrait(List<String> list, List<String> list2, ShopClassDetailPlacement shopClassDetailPlacement) {
        this.describes = list;
        this.illustrations = list2;
        this.placement = shopClassDetailPlacement;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailPortrait(List list, List list2, ShopClassDetailPlacement shopClassDetailPlacement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : shopClassDetailPlacement);
    }

    public final List<String> getDescribes() {
        return this.describes;
    }

    public final List<String> getIllustrations() {
        return this.illustrations;
    }

    public final ShopClassDetailPlacement getPlacement() {
        return this.placement;
    }
}
