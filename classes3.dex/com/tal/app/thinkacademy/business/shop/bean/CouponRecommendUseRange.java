package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0003J?\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendUseRange;", "", "clazzId", "", "courseId", "courseSpec", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getClazzId", "()Ljava/util/List;", "getCourseId", "getCourseSpec", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopCouponRecommendBean.kt */
public final class CouponRecommendUseRange {
    private final List<Object> clazzId;
    private final List<Object> courseId;
    private final List<Object> courseSpec;

    public CouponRecommendUseRange() {
        this((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CouponRecommendUseRange copy$default(CouponRecommendUseRange couponRecommendUseRange, List<Object> list, List<Object> list2, List<Object> list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = couponRecommendUseRange.clazzId;
        }
        if ((i & 2) != 0) {
            list2 = couponRecommendUseRange.courseId;
        }
        if ((i & 4) != 0) {
            list3 = couponRecommendUseRange.courseSpec;
        }
        return couponRecommendUseRange.copy(list, list2, list3);
    }

    public final List<Object> component1() {
        return this.clazzId;
    }

    public final List<Object> component2() {
        return this.courseId;
    }

    public final List<Object> component3() {
        return this.courseSpec;
    }

    public final CouponRecommendUseRange copy(List<? extends Object> list, List<? extends Object> list2, List<? extends Object> list3) {
        return new CouponRecommendUseRange(list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouponRecommendUseRange)) {
            return false;
        }
        CouponRecommendUseRange couponRecommendUseRange = (CouponRecommendUseRange) obj;
        return Intrinsics.areEqual((Object) this.clazzId, (Object) couponRecommendUseRange.clazzId) && Intrinsics.areEqual((Object) this.courseId, (Object) couponRecommendUseRange.courseId) && Intrinsics.areEqual((Object) this.courseSpec, (Object) couponRecommendUseRange.courseSpec);
    }

    public int hashCode() {
        List<Object> list = this.clazzId;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<Object> list2 = this.courseId;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Object> list3 = this.courseSpec;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CouponRecommendUseRange(clazzId=" + this.clazzId + ", courseId=" + this.courseId + ", courseSpec=" + this.courseSpec + ')';
    }

    public CouponRecommendUseRange(List<? extends Object> list, List<? extends Object> list2, List<? extends Object> list3) {
        this.clazzId = list;
        this.courseId = list2;
        this.courseSpec = list3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CouponRecommendUseRange(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
    }

    public final List<Object> getClazzId() {
        return this.clazzId;
    }

    public final List<Object> getCourseId() {
        return this.courseId;
    }

    public final List<Object> getCourseSpec() {
        return this.courseSpec;
    }
}
