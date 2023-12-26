package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopCouponRecommendInfoBean;", "", "canUseCount", "", "effectCoupons", "", "Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendEffectCoupon;", "useCouponInfo", "Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendUseCouponInfo;", "(ILjava/util/List;Ljava/util/List;)V", "getCanUseCount", "()I", "getEffectCoupons", "()Ljava/util/List;", "getUseCouponInfo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopCouponRecommendBean.kt */
public final class ShopCouponRecommendInfoBean {
    private final int canUseCount;
    private final List<CouponRecommendEffectCoupon> effectCoupons;
    private final List<CouponRecommendUseCouponInfo> useCouponInfo;

    public ShopCouponRecommendInfoBean() {
        this(0, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopCouponRecommendInfoBean copy$default(ShopCouponRecommendInfoBean shopCouponRecommendInfoBean, int i, List<CouponRecommendEffectCoupon> list, List<CouponRecommendUseCouponInfo> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = shopCouponRecommendInfoBean.canUseCount;
        }
        if ((i2 & 2) != 0) {
            list = shopCouponRecommendInfoBean.effectCoupons;
        }
        if ((i2 & 4) != 0) {
            list2 = shopCouponRecommendInfoBean.useCouponInfo;
        }
        return shopCouponRecommendInfoBean.copy(i, list, list2);
    }

    public final int component1() {
        return this.canUseCount;
    }

    public final List<CouponRecommendEffectCoupon> component2() {
        return this.effectCoupons;
    }

    public final List<CouponRecommendUseCouponInfo> component3() {
        return this.useCouponInfo;
    }

    public final ShopCouponRecommendInfoBean copy(int i, List<CouponRecommendEffectCoupon> list, List<CouponRecommendUseCouponInfo> list2) {
        return new ShopCouponRecommendInfoBean(i, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponRecommendInfoBean)) {
            return false;
        }
        ShopCouponRecommendInfoBean shopCouponRecommendInfoBean = (ShopCouponRecommendInfoBean) obj;
        return this.canUseCount == shopCouponRecommendInfoBean.canUseCount && Intrinsics.areEqual((Object) this.effectCoupons, (Object) shopCouponRecommendInfoBean.effectCoupons) && Intrinsics.areEqual((Object) this.useCouponInfo, (Object) shopCouponRecommendInfoBean.useCouponInfo);
    }

    public int hashCode() {
        int i = this.canUseCount * 31;
        List<CouponRecommendEffectCoupon> list = this.effectCoupons;
        int i2 = 0;
        int hashCode = (i + (list == null ? 0 : list.hashCode())) * 31;
        List<CouponRecommendUseCouponInfo> list2 = this.useCouponInfo;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ShopCouponRecommendInfoBean(canUseCount=" + this.canUseCount + ", effectCoupons=" + this.effectCoupons + ", useCouponInfo=" + this.useCouponInfo + ')';
    }

    public ShopCouponRecommendInfoBean(int i, List<CouponRecommendEffectCoupon> list, List<CouponRecommendUseCouponInfo> list2) {
        this.canUseCount = i;
        this.effectCoupons = list;
        this.useCouponInfo = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopCouponRecommendInfoBean(int i, List list, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? null : list2);
    }

    public final int getCanUseCount() {
        return this.canUseCount;
    }

    public final List<CouponRecommendEffectCoupon> getEffectCoupons() {
        return this.effectCoupons;
    }

    public final List<CouponRecommendUseCouponInfo> getUseCouponInfo() {
        return this.useCouponInfo;
    }
}
