package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b6\b\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003Jë\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u0003HÖ\u0001J\t\u0010O\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\"R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001e¨\u0006P"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendEffectCoupon;", "", "activityId", "", "canUse", "", "categoryName", "", "couponId", "description", "effectEnd", "effectStart", "feeName", "goodsCategoryId", "id", "name", "reasons", "", "studentId", "style", "timeStatus", "typeFields", "Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendTypeFields;", "typeId", "typeName", "useRange", "Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendUseRange;", "useStatus", "(IZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/List;IIILcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendTypeFields;ILjava/lang/String;Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendUseRange;I)V", "getActivityId", "()I", "getCanUse", "()Z", "getCategoryName", "()Ljava/lang/String;", "getCouponId", "getDescription", "getEffectEnd", "getEffectStart", "getFeeName", "getGoodsCategoryId", "getId", "getName", "getReasons", "()Ljava/util/List;", "getStudentId", "getStyle", "getTimeStatus", "getTypeFields", "()Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendTypeFields;", "getTypeId", "getTypeName", "getUseRange", "()Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendUseRange;", "getUseStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopCouponRecommendBean.kt */
public final class CouponRecommendEffectCoupon {
    private final int activityId;
    private final boolean canUse;
    private final String categoryName;
    private final int couponId;
    private final String description;
    private final String effectEnd;
    private final String effectStart;
    private final String feeName;
    private final int goodsCategoryId;
    private final int id;
    private final String name;
    private final List<Object> reasons;
    private final int studentId;
    private final int style;
    private final int timeStatus;
    private final CouponRecommendTypeFields typeFields;
    private final int typeId;
    private final String typeName;
    private final CouponRecommendUseRange useRange;
    private final int useStatus;

    public CouponRecommendEffectCoupon() {
        this(0, false, (String) null, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (List) null, 0, 0, 0, (CouponRecommendTypeFields) null, 0, (String) null, (CouponRecommendUseRange) null, 0, 1048575, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CouponRecommendEffectCoupon copy$default(CouponRecommendEffectCoupon couponRecommendEffectCoupon, int i, boolean z, String str, int i2, String str2, String str3, String str4, String str5, int i3, int i4, String str6, List list, int i5, int i6, int i7, CouponRecommendTypeFields couponRecommendTypeFields, int i8, String str7, CouponRecommendUseRange couponRecommendUseRange, int i9, int i10, Object obj) {
        CouponRecommendEffectCoupon couponRecommendEffectCoupon2 = couponRecommendEffectCoupon;
        int i11 = i10;
        return couponRecommendEffectCoupon.copy((i11 & 1) != 0 ? couponRecommendEffectCoupon2.activityId : i, (i11 & 2) != 0 ? couponRecommendEffectCoupon2.canUse : z, (i11 & 4) != 0 ? couponRecommendEffectCoupon2.categoryName : str, (i11 & 8) != 0 ? couponRecommendEffectCoupon2.couponId : i2, (i11 & 16) != 0 ? couponRecommendEffectCoupon2.description : str2, (i11 & 32) != 0 ? couponRecommendEffectCoupon2.effectEnd : str3, (i11 & 64) != 0 ? couponRecommendEffectCoupon2.effectStart : str4, (i11 & 128) != 0 ? couponRecommendEffectCoupon2.feeName : str5, (i11 & 256) != 0 ? couponRecommendEffectCoupon2.goodsCategoryId : i3, (i11 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? couponRecommendEffectCoupon2.id : i4, (i11 & 1024) != 0 ? couponRecommendEffectCoupon2.name : str6, (i11 & 2048) != 0 ? couponRecommendEffectCoupon2.reasons : list, (i11 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? couponRecommendEffectCoupon2.studentId : i5, (i11 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? couponRecommendEffectCoupon2.style : i6, (i11 & 16384) != 0 ? couponRecommendEffectCoupon2.timeStatus : i7, (i11 & 32768) != 0 ? couponRecommendEffectCoupon2.typeFields : couponRecommendTypeFields, (i11 & 65536) != 0 ? couponRecommendEffectCoupon2.typeId : i8, (i11 & 131072) != 0 ? couponRecommendEffectCoupon2.typeName : str7, (i11 & 262144) != 0 ? couponRecommendEffectCoupon2.useRange : couponRecommendUseRange, (i11 & 524288) != 0 ? couponRecommendEffectCoupon2.useStatus : i9);
    }

    public final int component1() {
        return this.activityId;
    }

    public final int component10() {
        return this.id;
    }

    public final String component11() {
        return this.name;
    }

    public final List<Object> component12() {
        return this.reasons;
    }

    public final int component13() {
        return this.studentId;
    }

    public final int component14() {
        return this.style;
    }

    public final int component15() {
        return this.timeStatus;
    }

    public final CouponRecommendTypeFields component16() {
        return this.typeFields;
    }

    public final int component17() {
        return this.typeId;
    }

    public final String component18() {
        return this.typeName;
    }

    public final CouponRecommendUseRange component19() {
        return this.useRange;
    }

    public final boolean component2() {
        return this.canUse;
    }

    public final int component20() {
        return this.useStatus;
    }

    public final String component3() {
        return this.categoryName;
    }

    public final int component4() {
        return this.couponId;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.effectEnd;
    }

    public final String component7() {
        return this.effectStart;
    }

    public final String component8() {
        return this.feeName;
    }

    public final int component9() {
        return this.goodsCategoryId;
    }

    public final CouponRecommendEffectCoupon copy(int i, boolean z, String str, int i2, String str2, String str3, String str4, String str5, int i3, int i4, String str6, List<? extends Object> list, int i5, int i6, int i7, CouponRecommendTypeFields couponRecommendTypeFields, int i8, String str7, CouponRecommendUseRange couponRecommendUseRange, int i9) {
        return new CouponRecommendEffectCoupon(i, z, str, i2, str2, str3, str4, str5, i3, i4, str6, list, i5, i6, i7, couponRecommendTypeFields, i8, str7, couponRecommendUseRange, i9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouponRecommendEffectCoupon)) {
            return false;
        }
        CouponRecommendEffectCoupon couponRecommendEffectCoupon = (CouponRecommendEffectCoupon) obj;
        return this.activityId == couponRecommendEffectCoupon.activityId && this.canUse == couponRecommendEffectCoupon.canUse && Intrinsics.areEqual((Object) this.categoryName, (Object) couponRecommendEffectCoupon.categoryName) && this.couponId == couponRecommendEffectCoupon.couponId && Intrinsics.areEqual((Object) this.description, (Object) couponRecommendEffectCoupon.description) && Intrinsics.areEqual((Object) this.effectEnd, (Object) couponRecommendEffectCoupon.effectEnd) && Intrinsics.areEqual((Object) this.effectStart, (Object) couponRecommendEffectCoupon.effectStart) && Intrinsics.areEqual((Object) this.feeName, (Object) couponRecommendEffectCoupon.feeName) && this.goodsCategoryId == couponRecommendEffectCoupon.goodsCategoryId && this.id == couponRecommendEffectCoupon.id && Intrinsics.areEqual((Object) this.name, (Object) couponRecommendEffectCoupon.name) && Intrinsics.areEqual((Object) this.reasons, (Object) couponRecommendEffectCoupon.reasons) && this.studentId == couponRecommendEffectCoupon.studentId && this.style == couponRecommendEffectCoupon.style && this.timeStatus == couponRecommendEffectCoupon.timeStatus && Intrinsics.areEqual((Object) this.typeFields, (Object) couponRecommendEffectCoupon.typeFields) && this.typeId == couponRecommendEffectCoupon.typeId && Intrinsics.areEqual((Object) this.typeName, (Object) couponRecommendEffectCoupon.typeName) && Intrinsics.areEqual((Object) this.useRange, (Object) couponRecommendEffectCoupon.useRange) && this.useStatus == couponRecommendEffectCoupon.useStatus;
    }

    public int hashCode() {
        int i = this.activityId * 31;
        boolean z = this.canUse;
        if (z) {
            z = true;
        }
        int i2 = (i + (z ? 1 : 0)) * 31;
        String str = this.categoryName;
        int i3 = 0;
        int hashCode = (((i2 + (str == null ? 0 : str.hashCode())) * 31) + this.couponId) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.effectEnd;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.effectStart;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.feeName;
        int hashCode5 = (((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.goodsCategoryId) * 31) + this.id) * 31;
        String str6 = this.name;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<Object> list = this.reasons;
        int hashCode7 = (((((((hashCode6 + (list == null ? 0 : list.hashCode())) * 31) + this.studentId) * 31) + this.style) * 31) + this.timeStatus) * 31;
        CouponRecommendTypeFields couponRecommendTypeFields = this.typeFields;
        int hashCode8 = (((hashCode7 + (couponRecommendTypeFields == null ? 0 : couponRecommendTypeFields.hashCode())) * 31) + this.typeId) * 31;
        String str7 = this.typeName;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        CouponRecommendUseRange couponRecommendUseRange = this.useRange;
        if (couponRecommendUseRange != null) {
            i3 = couponRecommendUseRange.hashCode();
        }
        return ((hashCode9 + i3) * 31) + this.useStatus;
    }

    public String toString() {
        return "CouponRecommendEffectCoupon(activityId=" + this.activityId + ", canUse=" + this.canUse + ", categoryName=" + this.categoryName + ", couponId=" + this.couponId + ", description=" + this.description + ", effectEnd=" + this.effectEnd + ", effectStart=" + this.effectStart + ", feeName=" + this.feeName + ", goodsCategoryId=" + this.goodsCategoryId + ", id=" + this.id + ", name=" + this.name + ", reasons=" + this.reasons + ", studentId=" + this.studentId + ", style=" + this.style + ", timeStatus=" + this.timeStatus + ", typeFields=" + this.typeFields + ", typeId=" + this.typeId + ", typeName=" + this.typeName + ", useRange=" + this.useRange + ", useStatus=" + this.useStatus + ')';
    }

    public CouponRecommendEffectCoupon(int i, boolean z, String str, int i2, String str2, String str3, String str4, String str5, int i3, int i4, String str6, List<? extends Object> list, int i5, int i6, int i7, CouponRecommendTypeFields couponRecommendTypeFields, int i8, String str7, CouponRecommendUseRange couponRecommendUseRange, int i9) {
        this.activityId = i;
        this.canUse = z;
        this.categoryName = str;
        this.couponId = i2;
        this.description = str2;
        this.effectEnd = str3;
        this.effectStart = str4;
        this.feeName = str5;
        this.goodsCategoryId = i3;
        this.id = i4;
        this.name = str6;
        this.reasons = list;
        this.studentId = i5;
        this.style = i6;
        this.timeStatus = i7;
        this.typeFields = couponRecommendTypeFields;
        this.typeId = i8;
        this.typeName = str7;
        this.useRange = couponRecommendUseRange;
        this.useStatus = i9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CouponRecommendEffectCoupon(int r22, boolean r23, java.lang.String r24, int r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, int r31, java.lang.String r32, java.util.List r33, int r34, int r35, int r36, com.tal.app.thinkacademy.business.shop.bean.CouponRecommendTypeFields r37, int r38, java.lang.String r39, com.tal.app.thinkacademy.business.shop.bean.CouponRecommendUseRange r40, int r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r21 = this;
            r0 = r42
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r22
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r23
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r24
        L_0x001a:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0020
            r6 = 0
            goto L_0x0022
        L_0x0020:
            r6 = r25
        L_0x0022:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            r7 = 0
            goto L_0x002a
        L_0x0028:
            r7 = r26
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            r8 = 0
            goto L_0x0032
        L_0x0030:
            r8 = r27
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            r9 = 0
            goto L_0x003a
        L_0x0038:
            r9 = r28
        L_0x003a:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            r10 = 0
            goto L_0x0042
        L_0x0040:
            r10 = r29
        L_0x0042:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0048
            r11 = 0
            goto L_0x004a
        L_0x0048:
            r11 = r30
        L_0x004a:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0050
            r12 = 0
            goto L_0x0052
        L_0x0050:
            r12 = r31
        L_0x0052:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            r13 = 0
            goto L_0x005a
        L_0x0058:
            r13 = r32
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0060
            r14 = 0
            goto L_0x0062
        L_0x0060:
            r14 = r33
        L_0x0062:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0068
            r15 = 0
            goto L_0x006a
        L_0x0068:
            r15 = r34
        L_0x006a:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0072
        L_0x0070:
            r2 = r35
        L_0x0072:
            r5 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x0078
            r5 = 0
            goto L_0x007a
        L_0x0078:
            r5 = r36
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r37
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r38
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r39
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r40
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r20
            if (r0 == 0) goto L_0x00af
            r0 = 0
            goto L_0x00b1
        L_0x00af:
            r0 = r41
        L_0x00b1:
            r22 = r21
            r23 = r1
            r24 = r3
            r25 = r4
            r26 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r32 = r12
            r33 = r13
            r34 = r14
            r35 = r15
            r36 = r2
            r37 = r5
            r38 = r16
            r39 = r17
            r40 = r18
            r41 = r19
            r42 = r0
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.CouponRecommendEffectCoupon.<init>(int, boolean, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.util.List, int, int, int, com.tal.app.thinkacademy.business.shop.bean.CouponRecommendTypeFields, int, java.lang.String, com.tal.app.thinkacademy.business.shop.bean.CouponRecommendUseRange, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getActivityId() {
        return this.activityId;
    }

    public final boolean getCanUse() {
        return this.canUse;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final int getCouponId() {
        return this.couponId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEffectEnd() {
        return this.effectEnd;
    }

    public final String getEffectStart() {
        return this.effectStart;
    }

    public final String getFeeName() {
        return this.feeName;
    }

    public final int getGoodsCategoryId() {
        return this.goodsCategoryId;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Object> getReasons() {
        return this.reasons;
    }

    public final int getStudentId() {
        return this.studentId;
    }

    public final int getStyle() {
        return this.style;
    }

    public final int getTimeStatus() {
        return this.timeStatus;
    }

    public final CouponRecommendTypeFields getTypeFields() {
        return this.typeFields;
    }

    public final int getTypeId() {
        return this.typeId;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final CouponRecommendUseRange getUseRange() {
        return this.useRange;
    }

    public final int getUseStatus() {
        return this.useStatus;
    }
}
