package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendTypeFields;", "", "cut", "", "full", "(II)V", "getCut", "()I", "getFull", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopCouponRecommendBean.kt */
public final class CouponRecommendTypeFields {
    private final int cut;
    private final int full;

    public CouponRecommendTypeFields() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CouponRecommendTypeFields copy$default(CouponRecommendTypeFields couponRecommendTypeFields, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = couponRecommendTypeFields.cut;
        }
        if ((i3 & 2) != 0) {
            i2 = couponRecommendTypeFields.full;
        }
        return couponRecommendTypeFields.copy(i, i2);
    }

    public final int component1() {
        return this.cut;
    }

    public final int component2() {
        return this.full;
    }

    public final CouponRecommendTypeFields copy(int i, int i2) {
        return new CouponRecommendTypeFields(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouponRecommendTypeFields)) {
            return false;
        }
        CouponRecommendTypeFields couponRecommendTypeFields = (CouponRecommendTypeFields) obj;
        return this.cut == couponRecommendTypeFields.cut && this.full == couponRecommendTypeFields.full;
    }

    public int hashCode() {
        return (this.cut * 31) + this.full;
    }

    public String toString() {
        return "CouponRecommendTypeFields(cut=" + this.cut + ", full=" + this.full + ')';
    }

    public CouponRecommendTypeFields(int i, int i2) {
        this.cut = i;
        this.full = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CouponRecommendTypeFields(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getCut() {
        return this.cut;
    }

    public final int getFull() {
        return this.full;
    }
}
