package com.tal.app.thinkacademy.business.shop.bean.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/CouponRecommendRequest;", "", "products", "", "Lcom/tal/app/thinkacademy/business/shop/bean/request/CouponRecommendRequestProduct;", "(Ljava/util/List;)V", "getProducts", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CouponRecommendRequest.kt */
public final class CouponRecommendRequest {
    private final List<CouponRecommendRequestProduct> products;

    public CouponRecommendRequest() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CouponRecommendRequest copy$default(CouponRecommendRequest couponRecommendRequest, List<CouponRecommendRequestProduct> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = couponRecommendRequest.products;
        }
        return couponRecommendRequest.copy(list);
    }

    public final List<CouponRecommendRequestProduct> component1() {
        return this.products;
    }

    public final CouponRecommendRequest copy(List<CouponRecommendRequestProduct> list) {
        return new CouponRecommendRequest(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CouponRecommendRequest) && Intrinsics.areEqual((Object) this.products, (Object) ((CouponRecommendRequest) obj).products);
    }

    public int hashCode() {
        List<CouponRecommendRequestProduct> list = this.products;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "CouponRecommendRequest(products=" + this.products + ')';
    }

    public CouponRecommendRequest(List<CouponRecommendRequestProduct> list) {
        this.products = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CouponRecommendRequest(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<CouponRecommendRequestProduct> getProducts() {
        return this.products;
    }
}
