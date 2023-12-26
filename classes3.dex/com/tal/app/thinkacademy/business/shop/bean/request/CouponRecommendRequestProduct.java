package com.tal.app.thinkacademy.business.shop.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/CouponRecommendRequestProduct;", "", "amount", "", "price", "sellPrice", "skuInfo", "Lcom/tal/app/thinkacademy/business/shop/bean/request/CouponRecommendRequestSkuInfo;", "(IIILcom/tal/app/thinkacademy/business/shop/bean/request/CouponRecommendRequestSkuInfo;)V", "getAmount", "()I", "getPrice", "getSellPrice", "getSkuInfo", "()Lcom/tal/app/thinkacademy/business/shop/bean/request/CouponRecommendRequestSkuInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CouponRecommendRequest.kt */
public final class CouponRecommendRequestProduct {
    private final int amount;
    private final int price;
    private final int sellPrice;
    private final CouponRecommendRequestSkuInfo skuInfo;

    public CouponRecommendRequestProduct() {
        this(0, 0, 0, (CouponRecommendRequestSkuInfo) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CouponRecommendRequestProduct copy$default(CouponRecommendRequestProduct couponRecommendRequestProduct, int i, int i2, int i3, CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = couponRecommendRequestProduct.amount;
        }
        if ((i4 & 2) != 0) {
            i2 = couponRecommendRequestProduct.price;
        }
        if ((i4 & 4) != 0) {
            i3 = couponRecommendRequestProduct.sellPrice;
        }
        if ((i4 & 8) != 0) {
            couponRecommendRequestSkuInfo = couponRecommendRequestProduct.skuInfo;
        }
        return couponRecommendRequestProduct.copy(i, i2, i3, couponRecommendRequestSkuInfo);
    }

    public final int component1() {
        return this.amount;
    }

    public final int component2() {
        return this.price;
    }

    public final int component3() {
        return this.sellPrice;
    }

    public final CouponRecommendRequestSkuInfo component4() {
        return this.skuInfo;
    }

    public final CouponRecommendRequestProduct copy(int i, int i2, int i3, CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo) {
        return new CouponRecommendRequestProduct(i, i2, i3, couponRecommendRequestSkuInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouponRecommendRequestProduct)) {
            return false;
        }
        CouponRecommendRequestProduct couponRecommendRequestProduct = (CouponRecommendRequestProduct) obj;
        return this.amount == couponRecommendRequestProduct.amount && this.price == couponRecommendRequestProduct.price && this.sellPrice == couponRecommendRequestProduct.sellPrice && Intrinsics.areEqual((Object) this.skuInfo, (Object) couponRecommendRequestProduct.skuInfo);
    }

    public int hashCode() {
        int i = ((((this.amount * 31) + this.price) * 31) + this.sellPrice) * 31;
        CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo = this.skuInfo;
        return i + (couponRecommendRequestSkuInfo == null ? 0 : couponRecommendRequestSkuInfo.hashCode());
    }

    public String toString() {
        return "CouponRecommendRequestProduct(amount=" + this.amount + ", price=" + this.price + ", sellPrice=" + this.sellPrice + ", skuInfo=" + this.skuInfo + ')';
    }

    public CouponRecommendRequestProduct(int i, int i2, int i3, CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo) {
        this.amount = i;
        this.price = i2;
        this.sellPrice = i3;
        this.skuInfo = couponRecommendRequestSkuInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CouponRecommendRequestProduct(int i, int i2, int i3, CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? null : couponRecommendRequestSkuInfo);
    }

    public final int getAmount() {
        return this.amount;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getSellPrice() {
        return this.sellPrice;
    }

    public final CouponRecommendRequestSkuInfo getSkuInfo() {
        return this.skuInfo;
    }
}
